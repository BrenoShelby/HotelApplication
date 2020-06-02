package tad;

import pessoa.Hospede;
import quarto.Quarto;
import quarto.ReservaQuarto;
import quarto.Servico;

/**
 *
 * @author Siabreu
 */
public class No {

    //atributos
    Hospede dado;
    ReservaQuarto dado2;
    Servico dado3;
    No prox; //auto referencia

    public No(Hospede dado) {
        this.dado = dado;
        prox = null; //referencia nula
    }

    public No(ReservaQuarto dado2) {
        this.dado2 = dado2;
        prox = null; //referencia nula
    }

    public No(Servico dado3) {
        this.dado3 = dado3;
        prox = null; //referencia nula
    }

    @Override
    public String toString() {
        return String.valueOf(dado);
    }
}
