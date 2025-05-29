package MetrolSys;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author shkstart
 * @create 2023-06-07 10:49
 */
public class SitesTable extends JFrame {
    Object[][] data = new Object[200][3];
    Object[][] data1 = new Object[200][3];
    Object[] column = {"站点名称", "行经线路", "进站时间"};
    JTable info;
    JTable infoSorted;

    public JTable getInfo() {
        return info;
    }

    public JTable getInfoSorted() {
        return infoSorted;
    }

    JScrollPane jScrollPane;
    static MetrolMap metrolMap;

    public SitesTable() {
        metrolMap = new MetrolMap(41);
    }

    void setInfoUnsorted() {
        for (int i = 0; i < metrolMap.max; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Calendar nowTime = Calendar.getInstance();
            nowTime.add(Calendar.MINUTE, (int) (10 * (Math.random()) + 5));
            data[i][0] = metrolMap.sites[i].sitename;
            if (metrolMap.sites[i].line.length() > 1) {
                Calendar nowTime2 = Calendar.getInstance();
                nowTime2.add(Calendar.MINUTE, (int) (10 * (Math.random()) + 5));
                data[i][1] = metrolMap.sites[i].line.charAt(0) + "," + metrolMap.sites[i].line.charAt(1);
                data[i][2] = sdf.format(nowTime.getTime()) + "," + sdf.format(nowTime2.getTime());
            } else {
                data[i][1] = metrolMap.sites[i].line;
                data[i][2] = sdf.format(nowTime.getTime());
            }
        }
        info = new JTable(data, column);
        jScrollPane = new JScrollPane(info);
        info.setRowHeight(30);
    }

    void setInfoSorted() {
        RoutePlan routePlan = new RoutePlan(metrolMap);
        routePlan.Dijistra("工研院", "济南西", 2);
        sites[] sites = metrolMap.sites;
        metrolMap.fresh();
        quickSort(sites, 0, sites.length - 1);
        for (int i = 0; i < sites.length; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Calendar nowTime = Calendar.getInstance();
            nowTime.add(Calendar.MINUTE, (int) (10 * (Math.random()) + 5));
            data1[i][0] = sites[i].sitename;
            if (sites[i].line.length() > 1) {
                Calendar nowTime2 = Calendar.getInstance();
                nowTime2.add(Calendar.MINUTE, (int) (10 * (Math.random()) + 5));
                data1[i][1] = sites[i].line.charAt(0) + "," + sites[i].line.charAt(1);
                data1[i][2] = sdf.format(nowTime.getTime()) + "," + sdf.format(nowTime2.getTime());
            } else {
                data1[i][1] = sites[i].line;
                data1[i][2] = sdf.format(nowTime.getTime());
            }
        }
        infoSorted = new JTable(data1, column);
        jScrollPane = new JScrollPane(infoSorted);
        infoSorted.setRowHeight(30);
    }

    static int getPivot(sites[] arr, int left, int right) {
        int center = (right + left) / 2;
        if (arr[left].cost > arr[center].cost) {
            swap(arr, left, center);
        }
        if (arr[left].cost > arr[right].cost) {
            swap(arr, left, right);
        }
        if (arr[center].cost > arr[right].cost) {
            swap(arr, center, right);
        }
        swap(arr, center, right - 1);
        return arr[right - 1].cost;
    }

    static void quickSort(sites[] sites, int i, int j) {
        if (i >= j) return;
        int l = i - 1;
        int r = j + 1;
        int x = sites[l + r >> 1].cost;
        while (l < r) {
            while (sites[++l].cost < x) ;
            while (sites[--r].cost > x) ;
            if (l < r) {
                sites tmp = sites[l];
                sites[l] = sites[r];
                sites[r] = tmp;
            }
        }
        quickSort(sites, i, r);
        quickSort(sites, r + 1, j);
    }

    static void insertsort(sites[] sites) {
        for (int i = 0; i < sites.length; i++) {
            MetrolSys.sites tempt = sites[i];
            int j = i;
            while (tempt.cost < getPrior(j, sites).cost) {
                sites[j] = sites[j - 1];
                j--;
            }
            sites[j] = tempt;
        }
    }

    static void swap(sites[] sites, int i, int j) {
        MetrolSys.sites tempt = new sites();
        tempt = sites[i];
        sites[i] = sites[j];
        sites[j] = tempt;
    }

    static sites getPrior(int i, sites[] sites) {
        if (i == 1) {
            return sites[i - 1];
        } else {
            MetrolSys.sites tempt = new sites();
            tempt.setCost(-1000);
            return tempt;
        }
    }
}
