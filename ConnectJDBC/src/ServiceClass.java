import javax.naming.BinaryRefAddr;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ServiceClass extends MyDBClass {
    public boolean InsertDB(String birthDate, String name) {
        this.getConnection();  // Assuming this sets up `con`
        String sql = "INSERT INTO STUDENT(birthDate, NAME) VALUES(?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, birthDate);
            ps.setString(2, name);
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<FriendBirthday> ReadFromDB(){
        List<FriendBirthday> li = new ArrayList<FriendBirthday>();
        FriendBirthday std = null;
        this.getConnection();
        String sql = "select birthDate, name from student";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                std = new FriendBirthday();
                std.setBirthDate(rs.getString("birthDate"));
                std.setName(rs.getString("name"));
                li.add(std);
            }
            ps.close();
            rs.close();
            con.close();
            return li;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public void updateStudent(String date, String newName){
        this.getConnection();
        String sql = "update student set name=? where birthDate=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, date);
            ps.setString(2, newName);
            ps.executeUpdate();
            ps.close();
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteStudent(String date){
        this.getConnection();
        String sql = "delete from student where birthDate=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, date);
            ps.executeUpdate();
            ps.close();
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}

