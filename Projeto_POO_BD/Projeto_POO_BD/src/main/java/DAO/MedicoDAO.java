package DAO;

import Classes.Medico;

import java.sql.SQLException;

public class MedicoDAO extends ConnectionDAO {

    //DAO - Data Access Object

    boolean sucesso = false; //Para saber se funcionou

    public boolean inserirMedico(Medico medico) {
        connectToDB();
        String sql = "INSERT INTO Medico (nome,idade,cpf,especializacao,crm) values(?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, medico.getNome());
            pst.setInt(2, medico.getIdade());
            pst.setString(3, medico.getCpf());
            pst.setString(4, medico.getEspecializacao());
            pst.setString(5, medico.getCrm());
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


    public boolean atualizarMedico(int id, Medico medico) {
        connectToDB();
        String sql = "UPDATE Medico SET nome=?, idade=?, cpf=?, especializacao=?, crm=? where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, medico.getNome());
            pst.setInt(2, medico.getIdade());
            pst.setString(3, medico.getCpf());
            pst.setString(4, medico.getEspecializacao());
            pst.setString(5, medico.getCrm());
            pst.setInt(6, id);
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

    public boolean deletarMedico(int id) {
        connectToDB();
        String sql = "DELETE FROM medico where id=?";

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
