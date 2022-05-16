import java.util.HashSet;
import java.util.Set;

public class Main
{
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Pedro",123456789);
        Cliente c2 = new Cliente("Chris",12345698);
        Cliente c3 = null;

        Conta conta = new Conta(1000,10000);

        conta.addCliente(c1);
        conta.addCliente(c2);
        conta.addCliente(c3);


        conta.mostraInfo();


    }
}
