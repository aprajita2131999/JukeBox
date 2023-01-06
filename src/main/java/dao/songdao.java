package dao;
import connection.connectionestablishment;
import entity.song;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class songdao {

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

    public static List<song> songslist() throws SQLException {
        Statement st = conn.createStatement();
        st.executeQuery("select * from song order by song_name asc");
        ResultSet rs = st.getResultSet();
        List<song> listsongs = new ArrayList<>();

        while (rs.next()) {
            listsongs.add(new song(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7) ));
        }
        return listsongs;
    }

}

