package Studentsystem.system;

import java.sql.*;

/**
 * @author shkstart
 * @create 2022-12-10 16:44
 */
public class usersql {
    public static final String url="jdbc:mysql://127.0.0.1/studentdb";
    private  String username ;
    private String password ;
    public usersql(String umn,String pwd){
        username=umn;
        password=pwd;
    }
    public boolean judge() {
        Connection connect = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            connect = DriverManager.getConnection(url, "root", "");
            stmt = connect.prepareStatement("select password from users where username=?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String s1 = rs.getString("password");
                if (s1.equals(password)) {
                    return true;
                }
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
