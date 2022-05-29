package Classes;
import Exceptons.NomeIgualException;
import Exceptons.NotaInvalida;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NomeIgualException, NotaInvalida {
        Scanner sc = new Scanner(System.in);
        Fetin fetin = new Fetin();
        boolean flag = true;
        while(flag){
            System.out.println(" *** Fetin ***");
            System.out.println("1-> Cadastrar Projeto");
            System.out.println("2-> Mostrar Projetos Cadastrados");
            System.out.println("3-> Sair");
            int op;
            op=sc.nextInt();
            switch (op){
                case 1:
                    String aux1;
                    double aux2;
                    sc.nextLine();
                    System.out.println("Nome do projeto");
                    aux1 = sc.nextLine();
                    System.out.println("Nota do projeto");
                    aux2 = sc.nextDouble();
                    try {
                        fetin.criaProjeto(aux1,aux2);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    fetin.mostrainfo();
                    break;
                case 3:
                    System.out.println("Saiu");
                    flag = false;
                    break;
                default:
                    System.out.println("Entrada Invalida");
            }
        }
    }

}
