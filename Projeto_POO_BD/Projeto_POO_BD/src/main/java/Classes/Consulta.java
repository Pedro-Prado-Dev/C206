package Classes;

public class Consulta {
    private String datad;
    private Paciente paciente;
    private Medico medico;

    public void mostraInfo(){
        System.out.println("Consulta do paciente "+ paciente.getNome() +" dia " + datad + " pelo doutor " + medico.getNome());
    }

    //getter e setter

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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
