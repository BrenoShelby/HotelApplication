package tad;

import conexaoBD.QuartoDAO;
import java.util.ArrayList;

/*Classe com métodos estáticos para não precisar ter que criar uma objeto sempre
que quiser usar*/
public class GerenciarContas {
    /*Atributo*/
    public static ArrayList<Conta> filaDeContas = new ArrayList<>();
    
    /*Adiciona a conta na fila de contas*/
    public static void adicionar(Conta q) {
        filaDeContas.add(q);
    }
    
    /*Imprime a conta baseado no CPF*/
    public static String imprimirConta(String cpf) {
        StringBuilder out = new StringBuilder();
        
        /*Percorre o arraylist*/
        for (Conta f : filaDeContas) {
            /*Se o CPF inserido for igual ao CPF da conta*/
            if (f.getCpf().equals(cpf)) {
                /*Adiciona na String*/
                out.append(f.toString());
            }
        }
        
        return out.toString();
    }
    
    /*Retorna o valor total da conta baseado no CPF*/
    public static double getValorTotal(String cpf) {
        double valorTotal = 0;
        
        /*Percorre o arraylist*/
        for (Conta f : filaDeContas) {
            /*Se o CPF inserido for igual ao CPF da conta*/
            if (f.getCpf().equals(cpf)) {
                /*Enquanto a fila não estiver vazia o valorTotal será incrementado
                com o preço do serviço*/
                while (!f.isEmpty()) {
                    valorTotal += f.dequeue().getPreco();
                }
            }
        }

        return valorTotal;
    }
}
