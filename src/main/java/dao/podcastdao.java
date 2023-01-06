package dao;


import connection.connectionestablishment;
import entity.audio;
import entity.podcast;
import entity.song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class podcastdao {
    static Connection conn;

    static {
        try {
            conn = connectionestablishment.connectionEstablishment();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<podcast> podcastlist() throws SQLException,ClassNotFoundException {
        Statement st = conn.createStatement();
        st.executeQuery("select * from podcast order by podcast_name  asc");
        ResultSet rs = st.getResultSet();
        List<podcast> listpodcast = new ArrayList<>();

        while (rs.next()) {
            listpodcast.add(new podcast(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)));
        }
        return listpodcast;
    }

    //Query to retrieve the podcast by Celebrity Name

    public List<podcast> podcastslistByCelebrity(String celebrity_name) throws SQLException,ClassNotFoundException {
        //Query to retrieve the podcast by celebrity_name
        String query = "SELECT * FROM podcast WHERE celebrity_name = ? ";
        //Creating the PreparedStatement object
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, celebrity_name);
        ResultSet rs = pstmt.executeQuery();
        System.out.println("Podcast of "+celebrity_name);
        List<podcast> listpodast = new ArrayList<>();
        while (rs.next()) {
            listpodast.add(new podcast(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4), rs.getString(5)));
        }
        return listpodast;
    }

    public Date podcastPublishDate(String podcast_name) throws SQLException,ClassNotFoundException {
        //Query to retrieve the publish date of podcast
        String query = "SELECT * FROM podcast WHERE podcast_name = ? ";
        //Creating the PreparedStatement object
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, podcast_name);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        Date pulish_date=rs.getDate(4);
        return pulish_date;
    }


}

