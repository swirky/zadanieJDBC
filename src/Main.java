import java.sql.*;
public class Main {
    public static void main( String args[] ) {

        StworzTabele nowaTabela = new StworzTabele();

       /* nowaTabela.stworz(); */       //tworzy nowa tabele jako liste obecnosci
nowaTabela.dodajStudenta("Marek","Nowakowski","12:22:00","13:33:00");  
        nowaTabela.wyswietl(); //wyswietla wszystkich studentów z listy obecnosci






    }

}
