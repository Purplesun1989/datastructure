package MetrolSys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

 class MyFrame extends JFrame {
	public final static String LOCAL_FILE_PATH_STATIONS = "src/MetrolSys/Station.txt";
	Station[] stations;
	JPanel panelCenter = new JPanel();
	JPanel panelsouth = new JPanel();
	JTextField resultSet=new JTextField();
	JLabel result=new JLabel("你所查询的结果");
	int actionCounter=0;
	Container contentPane;

	String[] site=new String[2];
	int flag;
	public MyFrame(int flag) {
		super("智慧泉城，畅达幸福");
		setIconImage(new ImageIcon("src/MetrolSys/tag.png").getImage());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets screenInsets=Toolkit.getDefaultToolkit().getScreenInsets(new JFrame().getGraphicsConfiguration());
		contentPane=getContentPane();
		stations=initStations();
		layoutCenter(contentPane,stations);
		layoutSouth(contentPane,screenSize.width-screenInsets.left-screenInsets.right);
		setBounds(new Rectangle(screenInsets.left,screenInsets.top,screenSize.width-screenInsets.left-screenInsets.right,screenSize.height-screenInsets.top-screenInsets.bottom));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		initStations();
		this.flag=flag;
	}
	private void layoutSouth(Container contentPane,int width) {
		resultSet.setPreferredSize(new Dimension(1000,100));
		resultSet.setText("请按照“起点——终点”的顺序，依次点击顶部站名。（顶部站点为节省空间已隐藏，鼠标滑动后显示！）");
		result.setFont(new Font( "宋体",Font.BOLD, 35));
		panelsouth.add(resultSet);
		panelsouth.add(result);
		contentPane.add(panelsouth,BorderLayout.SOUTH);
	}
	private void layoutCenter(Container contentPane,Station[] stations) {
		for (Station station : stations) {
			panelCenter.add(station);
			station.setText(station.getName());
			station.setBounds(station.getX(), station.getY(), 90, 30);
			station.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					resultSet.setText(null);
					if(actionCounter<=1){
						site[actionCounter++]=station.getName();
						MetrolMap map=new MetrolMap(41);
						RoutePlan routePlan=new RoutePlan(map);
						routePlan.Dijistra(site[0],site[1],flag);
						resultSet.setText(routePlan.getDirect());
						map.fresh();
					}
					else{
						dispose();
						new Menu();
					}
				}
			});
		}
		contentPane.add(panelCenter,BorderLayout.CENTER);
	}
	public Station[] initStations(){
		try{
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(MyFrame.LOCAL_FILE_PATH_STATIONS)));
			String amountString = bufferedReader.readLine();
			amountString = amountString.substring(1);
			int amount = Integer.valueOf(amountString);
			stations = new Station[amount];
			String lineTxt = null;
			int i = 0;
			String[] info;
			while((lineTxt = bufferedReader.readLine()) != null){
				info = lineTxt.split(",");
				int x = Integer.valueOf(info[1]);
				int y = Integer.valueOf(info[2]);
				String stationName = info[3];
				stations[i] = new Station(x, y, stationName);
				i++;
			}
			bufferedReader.close();
		}
		catch(Exception e){
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return stations;
	}
}
class Station extends JButton {
	int x;int y;String stationName;

	public Station() {
	}

	public Station(int x, int y, String stationName) {
		this.x = x;
		this.y = y;
		this.stationName = stationName;
		this.setBounds(x,y,50,50);
		this.setText(stationName);
	}

	@Override
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	@Override
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String getName() {
		return stationName;
	}

	@Override
	public void setName(String stationName) {
		this.stationName = stationName;
	}
}