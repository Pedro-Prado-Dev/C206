package Classes;

import Exceptions.ConsultaIndisponivel;
import Exceptions.MedicoNaoEncontrado;
import Exceptions.PacienteNaoEncontrado;

import java.util.*;

public class Hospital {
    String nome;
    private ArrayList<Medico> medicos = new ArrayList<>();
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Consulta> consultas = new ArrayList<>();
    private ArrayList<Cirurgia> cirurgias = new ArrayList<>();

    public Hospital(String nome) {
        this.nome = nome;
    }


    //Funções para adicionar
    public void addMedicos(Medico medico) {
        medicos.add(medico);
    }
    public void addPacientes(Paciente paciente) {
        pacientes.add(paciente);
    }
    public void marcaConsulta(Consulta consulta){
        consultas.add(consulta);
    }
    public void marcaCirurgia(Cirurgia cirurgia){
        cirurgias.add(cirurgia);
    }

    //Mostra Informaçoes

    public void mostraInfoMedicos() {
        System.out.println(" ** Medicos do Hospital " + nome + " **");
        for (Medico medi : medicos) {
            medi.mostraInfo();
        }
    }

    public void mostraInfoPacientes() {
        System.out.println(" ** Pacientes do Hospital " + nome + " **");
        for (Paciente paci : pacientes) {
            paci.mostraInfo();
        }
    }
    public void mostraInfoConsultas(){
        System.out.println(" ** Consultas Marcadas no Hospital " + nome + " **");
        for (Consulta c: consultas) {
            c.mostraInfo();
        }
    }


    //Funções de procura

    public Paciente procuraPorCpf(String cpf) throws PacienteNaoEncontrado {
        Paciente p1 = null;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getCpf().equals(cpf)){
                p1 = pacientes.get(i);
                System.out.println("ACHOU");
            }

        }
        if(p1 == null){
            throw new PacienteNaoEncontrado("Paciente não cadastrado"+ "+\n");
        }
        return p1;
    }

    public Medico procuraPorCRM(String crm) throws MedicoNaoEncontrado {
        Medico m1 = null;
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getCpf().equals(crm)) {
                m1 = medicos.get(i);
                System.out.println("ACHOU");
            }
        }
        if (m1 == null) {
            throw new MedicoNaoEncontrado("Medico não cadastrado"+ "+\n");
        }
        return m1;
    }

    public void procuraPorConsulta(String data, Medico medico) throws ConsultaIndisponivel {
        if(consultas == null){
            System.out.println("Nenhuma consulta Marcada");
        }else {
            for (int i = 0; i < consultas.size(); i++) {
                if (consultas.get(i).getMedico().getCrm().equals(medico.getCrm()) && consultas.get(i).getData().equals(data)){
                    throw new ConsultaIndisponivel("O doutor "+ medico.getNome() +" já possui uma consulta nesse dia"  + "+\n");
                }
            }
        }
    }

    public void procuraPorCirurgia(String data, Medico medico) throws ConsultaIndisponivel{
        if(cirurgias == null){
            System.out.println("Nenhuma consulta Marcada");
        }else {
            for (int i = 0; i < cirurgias.size(); i++) {
                if (cirurgias.get(i).getMedico().getCrm().equals(medico.getCrm()) && cirurgias.get(i).getData().equals(data)){
                    throw new ConsultaIndisponivel("O doutor "+ medico.getNome() +" já possui uma cirurgia nesse dia"  + "+\n");
                }
            }
        }

    }

    //getter e setter

    public String getNome() {
        return nome;
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }


}

