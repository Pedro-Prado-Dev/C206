package DAO;

import Classes.Paciente;

import java.sql.SQLException;

public class PacienteDAO extends ConnectionDAO {

    //DAO - Data Access Object

    boolean sucesso = false; //Para saber se funcionou

    public boolean inserirPaciente(Paciente paciente) {
        connectToDB();
        String sql = "INSERT INTO Paciente (nome,idade,cpf) values(?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, paciente.getNome());
            pst.setInt(2, paciente.getIdade());
            pst.setString(3, paciente.getCpf());
            pst.execute();
            sucesso = true;
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return sucesso;
    }


    public boolean atualizarMedico(int id, Paciente paciente) {
        connectToDB();
        String sql = "UPDATE Paciente SET nome=?, idade=?, cpf=? where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, paciente.getNome());
            pst.setInt(2, paciente.getIdade());
            pst.setString(3, paciente.getCpf());
            pst.setInt(4, id);
            pst.execute();
            sucesso = true;

        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean deletarPaciente(int id) {
        connectToDB();
        String sql = "DELETE FROM Paciente where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;

        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

}
