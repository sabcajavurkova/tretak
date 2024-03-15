import java.sql.*;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        String[] slova = {"nula", "jedna", "dva", "tri", "ctyri", "pet"};

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db3963", "db3963", "123")) {
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS slova(" +
                        "n INT NOT NULL," +
                        "popis VARCHAR NOT NULL" +
                        ")");
            }
            try (Statement stmt = conn.createStatement()){

                String delete = "DELETE FROM slova";
                String sql = "INSERT INTO slova VALUES (1, 'jedna')";
                String sql2 = "INSERT INTO slova VALUES (2, 'dva')";
                String sql3 = "INSERT INTO slova VALUES (3, 'tri')";
                String sql4 = "INSERT INTO slova VALUES (4, 'ctyri')";
                String sql5 = "INSERT INTO slova VALUES (5, 'pet')";
                stmt.executeUpdate(delete);
                stmt.executeUpdate(sql);
                stmt.executeUpdate(sql2);
                stmt.executeUpdate(sql3);
                stmt.executeUpdate(sql4);
                stmt.executeUpdate(sql5);
            }

            Scanner sc = new Scanner(System.in);
            for (; ; ) {
                int cislo = sc.nextInt();
                try (Statement stmt = conn.createStatement()) {
                    ResultSet rs = stmt.executeQuery("SELECT popis FROM slova WHERE n=" + cislo);
                    while (rs.next()) {
                        String p = rs.getString(1);
                        System.out.println("radek: " + p);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
