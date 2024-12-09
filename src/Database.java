
import javax.swing.*;
import java.sql.*;


public class Database
{
    Connection con;
    Statement statement;
    ResultSet result;
    String driver_sqlite = "org.sqlite.JDBC";
    String url_sqlite = "jdbc:sqlite:cbt.db";

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

    public void insert(String n, String sub1, String sub2, String sub3, String sub4,int s1,
                       int s2, int s3, int s4, int sub1l, int sub2l, int sub3l, int sub4l) throws SQLException
    {

        String sql = "insert into details values('" + n + "','" + sub1 + "','" + sub2 + "','" + sub3 + "','" + sub4 + "','" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + sub1l + "','" + sub2l + "','" + sub3l + "','" + sub4l + "')";

        statement.executeUpdate(sql);


    }

    public ResultSet selectSingle(String str) throws SQLException
    {
        String sql = "SELECT * FROM details where name = '" + str + "'";
        result = statement.executeQuery(sql);
        return result;
    }

    void update(String name, int s1, int s2, int s3, int s4, int sub1l, int sub2l, int sub3l, int sub4l) throws SQLException
    {

        String sql = " update details set sub1level = '" + sub1l + "',sub2level = '" + sub2l + "',sub3level = '" + sub3l + "',sub4level = '" + sub4l + "',s1 = '" + s1 + "',s2 = '" + s2 + "',s3 = '" + s3 + "',s4 = '" + s4 + "' where name = '" + name + "'";

        statement.execute(sql);

    }

    public void delete(String theName)
    {
        try {
            String sql = "delete from details where Name = '" + theName + "'";
            statement.executeUpdate(sql);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Delete Page", 0);
        }
    }

    public ResultSet fetch() throws SQLException {
        String sql = "select * from details ORDER BY NAME";
        result = statement.executeQuery(sql);
        return result;
    }

    public ResultSet fetchQuestion(String subject)
    {
        try {
            String sql = "select * from " + subject + " order by random()";

            result = statement.executeQuery(sql);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Fetch Page", 0);
        }
        return result;
    }

    public ResultSet getHiScore(String str) throws SQLException
    {
        result = statement.executeQuery(str);
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
