import java.sql.*;
public class StworzTabele {

    public void stworz() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "CREATE TABLE listaObecnosci2" +
                    " (id INTEGER primary key,"+
                   " prowadzacy int(1)," +
                   " nazwa_przedmiotu VARCHAR(255) NOT NULL," +
                   " imie_student VARCHAR(255) NOT NULL," +
                   " nazwisko_student VARCHAR(255) NOT NULL," +
                   " numer_albumu INT NOT NULL," +
                   " data_zajec DATE," +
                   " czas_zalogowania TIME," +
                   " czas_wylogowania TIME," +
                   " dlugosc_czasu_sesji TIME )";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

        public void dodajStudenta(String imie, String nazwisko, String czasZalogowania, String czasWylogowania){
            Connection c = null;
            Statement stmt = null;

            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:test.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                String sql = "INSERT INTO listaObecnosci2 (prowadzacy,nazwa_przedmiotu,imie_student,nazwisko_student,numer_albumu,data_zajec,czas_zalogowania,czas_wylogowania) " +
                        "VALUES (0,'Programowanie','"+imie+"','"+nazwisko+"',66020,2023-10-10,'12:20:00','12:45:00');";
                stmt.executeUpdate(sql);
                stmt.close();
                c.commit();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Records created successfully");
        }


public void wyswietl(){
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:test.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM listaObecnosci2;" );

        while ( rs.next() ) {
            int id = rs.getInt("id");
            int prowadzacy = rs.getInt("prowadzacy");
            String nazwa_przemdiotu = rs.getString("nazwa_przedmiotu");
            String imie_student = rs.getString("imie_student");
            String nazwisko_student = rs.getString("nazwisko_student");
            int numer_alb = rs.getInt("numer_albumu");
            String data_zajec = rs.getString("data_zajec");
            String czas_zalogow = rs.getString("czas_zalogowania");
            String czas_wyloggow = rs.getString("czas_wylogowania");
            String dlug_sesji = rs.getString("dlugosc_czasu_sesji");


            System.out.println( "id = " + id );
            System.out.println( "prowadzacy = " + prowadzacy);
            System.out.println( "nazwa_przedmiotu = " + nazwa_przemdiotu );
            System.out.println( "imie_student = " + imie_student );
            System.out.println( "nazwisko_student = " + nazwisko_student );
            System.out.println( "numer_albumu = "+ numer_alb);
            System.out.println( "data_zajec = "+ data_zajec);
            System.out.println( "czas_zalogowania = "+ czas_zalogow);
            System.out.println( "czas_wylogowania = "+ czas_wyloggow);
            System.out.println( "dlugosc_czasu_sesji = " + dlug_sesji);
            System.out.println(" ");
        }
        rs.close();
        stmt.close();
        c.close();
    } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
    }
    System.out.println("Operation done successfully");


            }

}
