package Studentsystem.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author shkstart
 * @create 2022-12-10 18:46
 */
class Altername {
    public static final String url="jdbc:mysql://127.0.0.1/studentdb";
    private  String news ;
    private String ID;
    public Altername(String news,String ID){
        this.news=news;
        this.ID=ID;
    }
    public void update() {
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = DriverManager.getConnection(url, "root", "");
            System.out.println(2);
            stmt = connect.prepareStatement("update students set name=? where ID=?");
            System.out.println(1);
            stmt.setString(1,news);
            stmt.setString(2,ID);
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
class AlterID {
    public static final String url="jdbc:mysql://127.0.0.1/studentdb";
    private  String news ;
    private String ID;
    public AlterID(String news,String ID){
        this.news=news;
        this.ID=ID;
    }
    public void update() {
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = DriverManager.getConnection(url, "root", "");
            stmt = connect.prepareStatement("update students set ID=? where ID=?");
            stmt.setString(1,news);
            stmt.setString(2,ID);
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
class Altergender {
    public static final String url="jdbc:mysql://127.0.0.1/studentdb";
    private  String news ;
    private String ID;
    public Altergender(String news,String ID){
        this.news=news;
        this.ID=ID;
    }
    public void update() {
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = DriverManager.getConnection(url, "root", "");
            stmt = connect.prepareStatement("update students set gender=? where ID=?");
            stmt.setString(1,news);
            stmt.setString(2,ID);
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
class Alterscore {
    public static final String url="jdbc:mysql://127.0.0.1/studentdb";
    private  String news ;
    private String ID;
    public Alterscore(String news,String ID){
        this.news=news;
        this.ID=ID;
    }
    public void update() {
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = DriverManager.getConnection(url, "root", "");
            stmt = connect.prepareStatement("update students set grade=? where ID=?");
            stmt.setString(1,news);
            stmt.setString(2,ID);
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
class Alterclass {
    public static final String url="jdbc:mysql://127.0.0.1/studentdb";
    private  String news ;
    private String ID;
    public Alterclass(String news,String ID){
        this.news=news;
        this.ID=ID;
    }
    public void update() {
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = DriverManager.getConnection(url, "root", "");
            stmt = connect.prepareStatement("update students set class=? where ID=?");
            stmt.setString(1,news);
            stmt.setString(2,ID);
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
class Alterorigin {
    public static final String url="jdbc:mysql://127.0.0.1/studentdb";
    private  String news ;
    private String ID;
    public Alterorigin(String news,String ID){
        this.news=news;
        this.ID=ID;
    }
    public void update() {
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = DriverManager.getConnection(url, "root", "");
            stmt = connect.prepareStatement("update students set origin=? where ID=?");
            stmt.setString(1,news);
            stmt.setString(2,ID);
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
class Alterbirth {
    public static final String url="jdbc:mysql://127.0.0.1/studentdb";
    private  String news ;
    private String ID;
    public Alterbirth(String news,String ID){
        this.news=news;
        this.ID=ID;
    }
    public void update() {
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = DriverManager.getConnection(url, "root", "");
            stmt = connect.prepareStatement("update students set birth=? where ID=?");
            stmt.setString(1,news);
            stmt.setString(2,ID);
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