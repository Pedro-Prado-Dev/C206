package Classes;
public class Medico extends Pessoa {

    private String nome ;
    private int idade;
    private String especializacao;
    private String cpf;
    private String crm;

    public void mostraInfo(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Cpf: " + cpf);
        System.out.println("Especialização: " + especializacao);
        System.out.println("CRM : " + crm + "\n");
    }



    //getter e setter
    public String getNome() {
        return nome;
    }

    public double getIdade() {
        return idade;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}