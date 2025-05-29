package Studentsystem.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author shkstart
 * @create 2022-12-10 20:17
 */
public class Selectsql {
    public static final String url="jdbc:mysql://127.0.0.1/studentdb";
    private String ID;
    public Selectsql(String ID){
       this.ID=ID;
    }
    public void select() {
        String name = null;
        String gender = null;
        String birth = null;
        String origin = null;
        String grade = null;
        String classn = null;
        try{
            Connection connect= DriverManager.getConnection(url,"root","");
            PreparedStatement stmt=connect.prepareStatement("select * from students where ID=?");
            stmt.setString(1,ID);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                if(rs.getString("ID").equals(ID)){
                    name=rs.getString("name");
                    gender=rs.getString("gender");
                    birth=rs.getString("birth");
                    origin=rs.getString("origin");
                    grade=rs.getString("grade");
                    classn=rs.getString("class");
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        new sf2(name,gender,ID,birth,origin,grade,classn);
    }
}
