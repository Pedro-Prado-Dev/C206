package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.*;
import DAO.CirurgiaDAO;
import DAO.ConsultaDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import Exceptions.*;


public class Main {
    public static void main(String[] args) throws PacienteNaoEncontrado, ConsultaIndisponivel {
        Scanner sc = new Scanner(System.in);
        Hospital hospital = new Hospital("Samuel Libaneo");
        boolean flag = true;

        while (flag) {
            System.out.println("*** Menu do Hospital ***");
            System.out.println(" Opçoes :");
            System.out.println("1 -> Cadastro de Medico");
            System.out.println("2 -> Cadastro de Paciente");
            System.out.println("3 -> Marcar uma consulta");
            System.out.println("4 -> Medicos cadastrados");
            System.out.println("5 -> Pacientes cadastrados");
            System.out.println("6 -> Consultas marcadas");
            System.out.println("7 -> Cirurgias marcadas");
            System.out.println("8 -> Sair");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    sc.nextLine();
                    MedicoDAO iDAO = new MedicoDAO();
                    Medico m = new Medico();
                    System.out.println("Digite o nome do médico: ");
                    m.setNome(sc.nextLine());
                    System.out.println("Digite a idade do doutor " + m.getNome() + " :");
                    m.setIdade(sc.nextInt());
                    if (m.getIdade() < 22 || m.getIdade() > 75) {
                        System.out.println("Idade Invalida");
                        break;
                    }
                    sc.nextLine();
                    System.out.println("Digite o cpf do doutor " + m.getNome() + " :");
                    m.setCpf(sc.nextLine());
                    System.out.println("Digite a especializacao do doutor " + m.getNome() + " :");
                    m.setEspecializacao(sc.nextLine());
                    System.out.println("Digite o CRM do doutor " + m.getNome() + " :");
                    m.setCrm(sc.nextLine());
                    hospital.addMedicos(m);
                    iDAO.inserirMedico(m);
                    System.out.println("Cadastro realizado" + "\n");
                    break;

                case 2:
                    sc.nextLine();
                    PacienteDAO eDAO = new PacienteDAO();
                    Paciente p = new Paciente();
                    System.out.println("Digite o nome do paciente: ");
                    p.setNome(sc.nextLine());
                    System.out.println("Digite a idade do paciente " + p.getNome() + " :");
                    p.setIdade(sc.nextInt());
                    sc.nextLine();
                    if (p.getIdade() < 0 || p.getIdade() > 110) {
                        System.out.println("Idade Invalida");
                        break;
                    } else {
                        System.out.println("Digite o cpf do paciente " + p.getNome() + " :");
                        p.setCpf(sc.nextLine());
                        hospital.addPacientes(p);
                        eDAO.inserirPaciente(p);
                        System.out.println("Cadastro realizado" + "\n");
                    }
                    break;

                case 3:
                    String aux1;
                    sc.nextLine();
                    Medico medico = new Medico();
                    Paciente paciente = new Paciente();
                    ConsultaDAO aDAO = new ConsultaDAO();
                    Consulta consulta = new Consulta();

                    System.out.println("Digite o cpf do Paciente para Marcar uma consulta");
                    aux1 = sc.nextLine();
                    try {
                        paciente = hospital.procuraPorCpf(aux1);
                    } catch (PacienteNaoEncontrado e) {
                        System.out.println(e);
                        break;
                    }
                    consulta.setPaciente(paciente);
                    System.out.println("Digite o CRM do Medico que ira realizar a consulta");
                    aux1 = sc.nextLine();
                    try {
                        medico = hospital.procuraPorCRM(aux1);
                    } catch (MedicoNaoEncontrado e) {
                        System.out.println(e);
                        break;
                    }
                    consulta.setMedico(medico);
                    System.out.println("Digite uma data para Consulta");
                    aux1 = sc.nextLine();
                    try {
                        hospital.procuraPorConsulta(aux1, medico);
                    } catch (ConsultaIndisponivel e) {
                        System.out.println(e);
                        break;
                    }
                    consulta.setDatad(aux1);
                    hospital.marcaConsulta(consulta);
                    aDAO.inserirConsulta(consulta);
                    if(consulta.isFazerCirurgia() == true){
                        Cirurgia cirurgia = new Cirurgia();
                        CirurgiaDAO uDAO = new CirurgiaDAO();
                        cirurgia.setMedico(medico);
                        cirurgia.setPaciente(paciente);
                        sc.nextLine();
                        System.out.println("Digite uma data para Cirurgia");
                        aux1 = sc.nextLine();
                        try {
                            hospital.procuraPorCirurgia(aux1, medico);
                        } catch (ConsultaIndisponivel e) {
                            System.out.println(e);
                            break;
                        }
                        cirurgia.setDatad(aux1);
                        hospital.marcaCirurgia(cirurgia);
                        uDAO.inserirCirurgia(cirurgia);
                    }
                    break;

                case 4:
                    hospital.mostraInfoMedicos();
                    break;
                case 5:
                    hospital.mostraInfoPacientes();
                    break;
                case 6:
                    hospital.mostraInfoConsultas();
                    break;
                case 7:
                    hospital.mostraInfoCirurgias();
                    break;
                case 8:
                    System.out.println("Você saiu ");
                    flag = false;
                    break;
                default:
                    System.out.println("Entrada invalida");
                    System.out.println("");
                    break;
            }
        }
    }

}