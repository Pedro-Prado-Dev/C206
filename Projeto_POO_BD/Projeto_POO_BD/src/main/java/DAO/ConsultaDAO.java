package DAO;

import Classes.Consulta;

import java.sql.SQLException;

public class ConsultaDAO extends ConnectionDAO {

    //DAO - Data Access Object

    boolean sucesso = false; //Para saber se funcionou

    public boolean inserirConsulta(Consulta consulta) {
        connectToDB();
        String sql = "INSERT INTO Consulta (datad) values(?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, consulta.getDatad());
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


    public boolean atualizarMedico(int id, Consulta consulta) {
        connectToDB();
        String sql = "UPDATE Consulta SET nome=?, idade=?, cpf=? where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, consulta.getDatad());
            pst.setInt(2, id);
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

    public boolean deletarConsulta(int id) {
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

