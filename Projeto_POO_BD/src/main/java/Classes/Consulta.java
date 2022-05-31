package Classes;

public class Consulta {
    private String data;
    private Paciente paciente;
    private Medico medico;

    public void mostraInfo(){
        System.out.println("Consulta do paciente "+ paciente.getNome() +" dia " + data + " pelo doutor " + medico.getNome());
    }

    //getter e setter

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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
