public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Pedro",12456789);
        Cliente c2 = new Cliente("Chris", 1478523);

        Conta conta = new Conta(1000,10000);
        conta.addCliente(c1);
        conta.addCliente(c2);

        conta.mostraInfo();
        try {
            conta.sacar(10000);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
}
