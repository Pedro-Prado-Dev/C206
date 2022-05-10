public abstract class Mãe implements Comparable<Mãe> {
    String nome;
    double id;

    public Mãe (String nome, double id){
        this.nome = nome;
        this.id = id;

    }
    @Override
    public int compareTo(Mãe o) {
        return Double.compare(o.id , this.id);
    }

    public void mostraInfo (){
        System.out.println("Nome : " + this.nome);
        System.out.println("ID : " + this.id);
    }
}
