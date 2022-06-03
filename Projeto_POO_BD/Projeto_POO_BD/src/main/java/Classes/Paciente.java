package Classes;
public class Paciente extends Pessoa implements Comparable<Paciente> {

    private int idade;
    private String nome;
    private String cpf;

    public Paciente() {
        super();
    }


    void mostraInfo(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Cpf: "+ cpf+ "\n");
    }

    @Override
    public int compareTo(Paciente o) {
        return cpf.compareTo(o.cpf);
    }

    //getter e setter
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}