package Studentsystem.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author shkstart
 * @create 2022-12-10 17:41
 */
public class registSql {
    public static final String url="jdbc:mysql://127.0.0.1/studentdb";
    private  String username ;
    private String password ;
    public registSql(String umn,String pwd){
        username=umn;
        password=pwd;
    }
    public void insert() {
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = DriverManager.getConnection(url, "root", "");
            stmt = connect.prepareStatement("insert into users values(?,?)");
            stmt.setString(1, username);
            stmt.setString(2,password);
            stmt.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            new Close().closecon(connect);
            new Close().closesps(stmt);
        }
    }
}
