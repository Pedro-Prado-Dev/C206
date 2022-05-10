public class Filha3 extends Mãe{

    public Filha3(String nome, double id) {
        super(nome, id);
    }

    @Override
    public int compareTo(Mãe o) {
        return Double.compare(o.id , this.id);
    }
}
