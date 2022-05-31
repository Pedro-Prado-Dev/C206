package Classes;

public class Cirurgia {
    private Medico medico;
    private String data;
    private Paciente paciente;

    //mostra info

    public void mostraInfo(){
        System.out.println("Cirurgia do paciente "+ paciente.getNome() +" dia " + data + " pelo doutor " + medico.getNome());
    }

    //getter e setter
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
