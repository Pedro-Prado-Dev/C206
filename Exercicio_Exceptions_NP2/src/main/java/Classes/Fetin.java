package Classes;

import Exceptons.NomeIgualException;
import Exceptons.NotaInvalida;

import java.util.HashMap;
import java.util.Map;

public class Fetin {

    private Map<String, Double> projetos = new HashMap<>();


    public void criaProjeto(String nome, double nota) throws NotaInvalida, NomeIgualException {
        if (nota < 0 || nota > 100) {
            throw new NotaInvalida("Nota invalida");
        } else if (projetos.keySet().contains(nome)){
                throw new NomeIgualException("Nome em uso");

        } else{
            projetos.put(nome,nota);
            System.out.println("Projeto cadastrado");
        }
    }

    public void mostrainfo() {
        System.out.println(projetos);
    }

}
