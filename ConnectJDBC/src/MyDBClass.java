import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MyDBClass {
    protected Connection con;
    protected PreparedStatement ps;
    protected ResultSet rs;
    public MyDBClass(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/ConnectJDBC";
        try{
            con = DriverManager.getConnection(url,"root","sahriar#");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
    public void closeAll(){
        try{
            if(this.rs != null){
                this.rs.close();
            }
            if(this.ps != null){
                this.ps.close();
            }
            if(this.con != null){
                this.con.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
