package tad;

import quarto.ReservaQuarto;

public class ListReservaQuarto {

    //atributos
    private No inicio;
    private No fim;
    private int total;

    //construtor
    public ListReservaQuarto() {
        inicio = fim = null;
        total = 0;
    }

    //insere o dado no fim da lista
    public void insert(ReservaQuarto dado) {
        insert(dado, size()); //chama o inserir com a posicao igual ao total       
    }

    //insere o dado na posicao especifica
    public void insert(ReservaQuarto dado, int posicao) {
        No novoNo = new No(dado);

        //é uma posição inválida?
        if (posicao < 0 || posicao > total) {
            throw new RuntimeException("==>Posicao Invalida!!");
        }

        if (posicao == 0) {
            if (isEmpty()) //a posicão é zero a lista está vazia?
            {
                inicio = fim = novoNo;
            } else {  //a posicao é zero e tem nos na lista?
                novoNo.prox = inicio;
                inicio = novoNo;
            }
        } else { //a posição não é zero
            if (posicao == size()) { //é igual ao total, então insere no fim
                fim.prox = novoNo;
                fim = novoNo;
            } else { //é uma posição intermediária?
                No aux = inicio; //cria nó auxiliar 
                int cont = 0; //cria um contador de posicao
                //então caminha na lista enquanto não for null e 
                //até que atinga a posição anterior de inserção
                while (aux != null && !(cont == posicao - 1)) {
                    aux = aux.prox;
                    cont++;
                }
                novoNo.prox = aux.prox; // o prox do novo nó passa a apontar para o prox do aux
                aux.prox = novoNo; //o prox do aux passa a ser o novo nó
            }
        }
        total++;
    }

    public void remove(int posicao) {
        No temp;
        //é uma posição inválida?
        if (posicao < 0 || posicao >= total || isEmpty()) {
            throw new RuntimeException("==>Posicao Invalida ou Lista Vazia");
        }

        //é posição zero?
        if (posicao == 0) {
            if (size() == 1) {
                inicio = fim = null;
            } else {
                inicio = inicio.prox;
            }
        } else { //para as demais posições
            No aux = inicio; //cria nó auxiliar que aponta para o inicio
            int cont = 0; //cria um contador de posicao
            //então caminha na lista enquanto não for null e 
            //até que atinga a posição anterior de remoção
            while (aux != null && !(cont == posicao - 1)) {
                aux = aux.prox;
                cont++;
            }
            temp = aux.prox; //temp aponta para o proximo do auxiliar
            aux.prox = temp.prox; //o prox do auxiliar aponta para o prox do temp 
        }
        total--;
    }

    //modifica o dado na posição espeficada
    public void set(ReservaQuarto dado, int posicao) {
        if (posicao < 0 || posicao >= total || isEmpty()) {
            throw new RuntimeException("==>Posicao Invalida ou Lista Vazia");
        }

        No aux = inicio;
        int cont = 0;
        //caminha na lista enquanto aux não for null e a posicao for diferente do cont
        while (aux != null && posicao != cont) {
            aux = aux.prox;
            cont++;
        }
        //altera o valor do dado
        aux.dado2 = dado;
    }

    //retorna o dado da posição especificada
    public ReservaQuarto get(int posicao) {
        if (posicao < 0 || posicao >= total || isEmpty()) {
            throw new RuntimeException("==>Posicao Invalida ou Lista Vazia");
        }

        No aux = inicio;
        int cont = 0;
        //caminha na lista enquanto aux não for null e a posicao for diferente do cont
        while (aux != null && posicao != cont) {
            aux = aux.prox;
            cont++;
        }
        return aux.dado2;
    }

    //verifica se um dado existe na lista
    public boolean exist(String dado) {
        if (isEmpty()) {
            return false;
        }

        No aux = inicio;
        while (aux != null) {
            //percorre a lista do inicio e compara o dado do aux com o dado parametro
            if (aux.dado2.getCpf().equalsIgnoreCase(dado)) {
                return true;
            }
            aux = aux.prox;
        }
        //não encontrou nada
        return false;
    }

    public int existReserva(String cpf) {
        if (isEmpty()) {
            throw new RuntimeException();
        }

        int cont = 0;

        No aux = inicio;
        while (aux != null) {
            //percorre a lista do inicio e compara o dado do aux com o dado parametro
            if (aux.dado2.getCpf().equalsIgnoreCase(cpf)) {
                return cont;
            }
            aux = aux.prox;
            //Toda vez que passar por esse laço é incrementado
            cont++;
        }
        //não encontrou nada
        return cont;
    }

    //retorna o total de nos da lista
    public int size() {
        return total;
    }

    //verifica se a lista está vazia
    public boolean isEmpty() {
        return total == 0;
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();

        No atual = inicio; //atual aponta para o início da lista
        //enquanto não encontrar null
        while (atual != null) {
            saida.append(atual.dado2).append(" ");
            //avança para a próxima referência
            atual = atual.prox;
        }
        return saida.toString();
    }
}
