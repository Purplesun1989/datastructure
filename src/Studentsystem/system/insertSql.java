package Studentsystem.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author shkstart
 * @create 2022-12-10 16:44
 */
public class insertSql {
    String name;
    String gender;
    String birthday;
    String scores;
    String origin;
    String classname;
    String studentID;
    public insertSql(String name,String gender,String ID, String birth,String origin,String grade,String classn){
        this.birthday=birth;
        this.name=name;
        this.classname=classn;
        this.scores=grade;
        this.gender=gender;
        this.origin=origin;
        this.studentID=ID;
    }
    public void insert() throws SQLException {
        Connection connect= DriverManager.getConnection("jdbc:mysql://127.0.0.1/studentdb","root","");
        PreparedStatement stmt=connect.prepareStatement("insert into students values(?,?,?,?,?,?,?)");
        stmt.setString(1,name);
        stmt.setString(2,gender);
        stmt.setString(3,studentID);
        stmt.setString(4,birthday);
        stmt.setString(5,origin);
        stmt.setString(6,scores);
        stmt.setString(7,classname);
        stmt.execute();
    }
}
