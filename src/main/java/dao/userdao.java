package dao;
import com.mysql.cj.protocol.Resultset;
import entity.user;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userdao {
    Connection conn;

    public List<user> getUserList() throws ClassNotFoundException, SQLException {
        conn=connection.connectionestablishment.connectionEstablishment();
        List<user> userList=new ArrayList<>();
        String str="select * from user";
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(str);
        while (rs.next()){
            user user=new user(rs.getInt(1),rs.getString(2),rs.getString(3));
            userList.add(user);
        }
         return userList;
    }

    public void addUser(String userName,String password) throws SQLException, ClassNotFoundException {
        conn=connection.connectionestablishment.connectionEstablishment();
        PreparedStatement ps=conn.prepareStatement("insert into user(userName,password) values(?,?)");
        ps.setString(1,userName);
        ps.setString(2,password);
        int rowsAffected=ps.executeUpdate();
        System.out.println(rowsAffected+" row successfully inserted");

    }
}
