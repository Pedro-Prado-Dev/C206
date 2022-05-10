public class Filha2 extends Mãe{

    public Filha2(String nome, double id) {
        super(nome, id);
    }

    @Override
    public int compareTo(Mãe o) {
        return Double.compare(o.id , this.id);
    }
}
