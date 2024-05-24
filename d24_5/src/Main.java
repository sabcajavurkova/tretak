import pl.allegro.finance.tradukisto.ValueConverters;
import java.sql.*;

// kdyz databzi posleme prikaz a pred nej napiseme 'explain', vypise to proces jak nas pozadavek zpracuje, odhadne 'cenu'
// po vytvoreni indexu ("katalogu") je proces mnohem jednodussi
public class Main {
    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db3125", "db3125", "tief1Aich9aeteeshoo1")) {
            PreparedStatement vlozCislo = conn.prepareStatement("insert into cislo(i, czech) values (?,?);");
            // ve p[roject strukture se  a maven libraries se prida tato knihovna, to same s postgresql
            ValueConverters intConverter = ValueConverters.CZECH_INTEGER;

            for (int i = 0; i <= 100; i++) {
                vlozCislo.setInt(1, i);
                vlozCislo.setString(2, intConverter.asWords(i));
                // executeQuery = ocekava odpoved (u select..)
                // executeUpdate je na DELETE, INSERT..
                vlozCislo.executeUpdate();
            }

        }catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Nastala chyba.");
        }
    }
}