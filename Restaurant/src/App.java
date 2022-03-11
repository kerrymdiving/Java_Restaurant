import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
       new DB("jdbc:sqlite:./database.sqlite"); // can have relative or absolute address
       PreparedStatement insertCafe = DB.conn.prepareStatement("INSERT INTO cafes (name) VALUES (?);");
 //       PreparedStatement insertCafe = DB.conn.prepareStatement("INSERT INTO cafes (name, imageURL) VALUES (?, ?);");

        String[] cafes = {
            "Simons",
            "Jazz cafe",
            "Minnies"
        };
        for(String cafe : cafes) {
            insertCafe.setString(1, cafe);
            insertCafe.executeUpdate(); // this will update table and insert row
        }
        Statement getAllCafes = DB.conn.createStatement();
        PreparedStatement getOneCafe = DB.conn.prepareStatement("SELECT * FROM cafes WHERE id = ?;");
        try {
            ResultSet results = getAllCafes.executeQuery("SELECT * FROM cafes;");
            while(results.next()) {
                System.out.printf("  id: %d\n", results.getInt(1));
                System.out.printf("name: %s\n", results.getString(2));
            }
            getOneCafe.setInt(1, 4);
            ResultSet minnies = getOneCafe.executeQuery();
            System.out.printf("Winner is %s\n", minnies.getString(2));
        } catch(SQLException errr) {

        }
        DB.close();
    }
}
