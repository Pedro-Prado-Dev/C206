import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Mãe>lista = new ArrayList<>();
        ArrayList<String>nome = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Informe o nome da pessoa " + (i+1));
            nome.add(sc.nextLine());
        }
        System.out.println("\n");
        Filha1 a = new Filha1(nome.get(0), new Random().nextDouble()*100);
        Filha1 b = new Filha1(nome.get(1), new Random().nextDouble()*100 );
        Filha2 c = new Filha2(nome.get(2),new Random().nextDouble()*100);
        Filha2 d = new Filha2(nome.get(3),new Random().nextDouble()*100);
        Filha3 e = new Filha3(nome.get(4),new Random().nextDouble()*100);
        Filha3 f = new Filha3(nome.get(5),new Random().nextDouble()*100);

        lista.add(a);
        lista.add(b);
        lista.add(c);
        lista.add(d);
        lista.add(e);
        lista.add(f);
        System.out.println("**  Antes de ordenar  **" +"\n");
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).mostraInfo();
        }
        System.out.println("\n");
        System.out.println("**  Depois de ordenar  ** " +"\n");

        Collections.sort(lista);
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).mostraInfo();
        }

    }
}
