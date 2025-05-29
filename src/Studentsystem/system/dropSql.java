package Studentsystem.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author shkstart
 * @create 2022-12-10 16:44
 */
public class dropSql {
    public static final String url="jdbc:mysql://127.0.0.1/studentdb";
    private String ID;
    public dropSql(String ID){
        this.ID=ID;
    }
    public void drop() {
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = DriverManager.getConnection(url, "root", "");
            stmt = connect.prepareStatement("delete from students where ID=?");
            stmt.setString(1,ID);
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
