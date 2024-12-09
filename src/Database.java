
import javax.swing.*;
import java.sql.*;


public class Database
{
    Connection con;
    Statement statement;
    PreparedStatement pstmt;
    ResultSet result;
    String driver_sqlite = "org.sqlite.JDBC";
    String url_sqlite = "jdbc:sqlite:demo.db";

    public Database()
    {
        try
        {
            con = DriverManager.getConnection(url_sqlite);
            statement = con.createStatement();

        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "could not connect to the database  " + ex.getMessage(), "CBT", 0);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "could not connect to the database  " + ex.getMessage(), "CBT", 0);
        }
    }

    public void insert(int id, byte[] img) throws SQLException
    {

        String sql = "insert into info values(?,?)";
       pstmt = con.prepareStatement(sql);
       pstmt.setInt(1,id);
       pstmt.setBytes(2,img);
       pstmt.executeUpdate();
        //statement.executeUpdate(sql);


    }

    public void update(int id, byte[] img) throws SQLException {
        String sql = "update info set image = ? where id = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(2,id);
        pstmt.setBytes(1,img);
        pstmt.executeUpdate();
    }

    public ResultSet select(int id) throws SQLException
    {
        String sql = "SELECT * FROM info where id = '" + id + "'";
        result = statement.executeQuery(sql);
        return result;
    }



    public void close()
    {
        try {
            con.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
    }
}
