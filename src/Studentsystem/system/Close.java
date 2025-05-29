package Studentsystem.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author shkstart
 * @create 2022-12-10 17:20
 */
public class Close {
    void closecon(Connection connection){
        if(connection!=null){
            try{
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void closesps(PreparedStatement preparedStatement){
        if(preparedStatement!=null){
            try{
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void closeres(ResultSet resultSet){
        if(resultSet!=null){
            try{
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
