package DAO;

import Classes.Cirurgia;

import java.sql.SQLException;

public class CirurgiaDAO extends ConnectionDAO {

    //DAO - Data Access Object

    boolean sucesso = false; //Para saber se funcionou

    public boolean inserirCirurgia(Cirurgia cirurgia) {
        connectToDB();
        String sql = "INSERT INTO Cirurgia (datad) values(?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cirurgia.getDatad());
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


    public boolean atualizarCirurgia(int id, Cirurgia cirurgia) {
        connectToDB();
        String sql = "UPDATE Cirurgia SET nome=?, idade=?, cpf=? where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cirurgia.getDatad());
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

    public boolean deletarCirurgia(int id) {
        connectToDB();
        String sql = "DELETE FROM Cirurgia where id=?";

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


