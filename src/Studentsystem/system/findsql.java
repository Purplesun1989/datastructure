package Studentsystem.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author shkstart
 * @create 2022-12-10 18:28
 */
public class findsql {
    public static final String url="jdbc:mysql://127.0.0.1/studentdb";
    private  String ID ;
    public findsql(String ID){
        this.ID=ID;
    }
    public boolean judge() {
        Connection connect = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            connect = DriverManager.getConnection(url, "root", "");
            stmt = connect.prepareStatement("select name from students where ID=?");
            stmt.setString(1, ID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                return true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            new Close().closecon(connect);
            new Close().closeres(rs);
            new Close().closesps(stmt);
        }
        return false;
    }
}
