import java.sql.*;
import java.util.Scanner;

// prihlaseni:  ssh -L 5432:localhost:5432 sabina.javurkova@svs.gyarab.cz
// localhost: 5432
// db a user: nase databaze
// password: posledni cast stringu co vyskoci po prikazu "cat .pgpass"
// 22.3. 2024

// assert lala = podminka; -> kdzy false program skonci, kdyz true program pokracuje


public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        int idZakaznika = sc.nextInt();
        String zbozi = sc.next();
        System.out.println("ID zakznika: " + idZakaznika + ", zbozi: " + zbozi + ".");


        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db3125", "db3125", "tief1Aich9aeteeshoo1")) {

            PreparedStatement jeNaSklade = conn.prepareStatement("select count(1) from sklad where id_zbozi=?;");
            PreparedStatement kolikKusu = conn.prepareStatement("select kusu from sklad where id_zbozi=?;");

            PreparedStatement snizitKusy = conn.prepareStatement("update sklad set kusu = kusu-1 where id_zbozi = ?;");
            PreparedStatement pridatDoKosiku = conn.prepareStatement("insert into kosik(zakaznik, id_zbozi) values (?,?);");

            PreparedStatement vypisObsahKosiku = conn.prepareStatement("select kosik.zakaznik, zbozi.popis, zbozi.cena from kosik, zbozi where kosik.zakaznik=? and zbozi.id_zbozi=kosik.id_zbozi");

            PreparedStatement smazatZeSkladu = conn.prepareStatement("delete from sklad where id_zbozi = ?");





            String sql = "select id_zbozi from zbozi where popis='" + zbozi + "';";
            try(ResultSet rs = conn.createStatement().executeQuery(sql)){
                while(rs.next()){


                    System.out.println("ID zbozi je " + rs.getInt(1) + ".");
                }
            }


        }catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Nastala chyba.");
        }


    }
}