package main;

import java.util.List;

import main.entities.Boleto;
import main.entities.Fatura;
import main.entities.Pagamento;

public class ProcessadorBoletos {

    public ProcessadorBoletos() {
    }

    public void processar(Fatura fatura, List<Boleto> boletos) {
        List<Pagamento> listaPagamentos = fatura.getPagamentos();
        for (Boleto boleto : boletos) {
            Pagamento pagamento = new Pagamento("Boleto", boleto.getValorPago(), boleto.getData());
            listaPagamentos.add(pagamento);
            fatura.setPagamentos(listaPagamentos);
        }

        if (fatura.isPaga()) {
            fatura.setStatus("PAGA");
        }
    }

}
