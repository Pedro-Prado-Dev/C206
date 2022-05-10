public class Filha1 extends Mãe{

    public Filha1(String nome, double id) {
        super(nome, id);
    }

    @Override
    public int compareTo(Mãe o) {
        return Double.compare(o.id , this.id);
    }
}
