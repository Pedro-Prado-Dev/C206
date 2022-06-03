package Classes;

public class Cirurgia {
    private Medico medico;
    private String datad;
    private Paciente paciente;

    //mostra info

    public void mostraInfo(){
        System.out.println("Cirurgia do paciente "+ paciente.getNome() +" dia " + datad + " pelo doutor " + medico.getNome());
    }

    //getter e setter
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getDatad() {
        return datad;
    }

    public void setDatad(String datad) {
        this.datad = datad;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
