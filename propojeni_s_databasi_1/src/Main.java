import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

        try(Connection conn = DriverManager.getConnection("jdbc:sqLite: sample.db")) {
            try(Statement stat = conn.createStatement()){
                stat.executeUpdate("CREATE TABLE cisla (n INT NOT NULL)");
//                stat.executeUpdate("DROP TABLE cisla");
            }
            for (int i = 0; i <= 10; i++) {
                try(Statement stat = conn.createStatement()){
                    stat.executeUpdate("INSERT INTO cisla VALUES (" + i + ")");
                }
            }
        }catch(SQLException sqle){
            System.out.println("Neco se pokazilo: " + sqle);
        }
    }
}

//pres settiongs stahonut tmodul simplesqlbrowser