package main.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fatura {

    private String nome;
    private LocalDate data;
    private Float valorTotal;
    private String status;
    private List<Pagamento> pagamentos;

    public Fatura(String nome, LocalDate data, Float valorTotal) {
        this.nome = nome;
        this.data = data;
        this.valorTotal = valorTotal;
        this.pagamentos = new ArrayList<Pagamento>();
    }

    public Fatura() {
    }

    public boolean isPaga() {
        int somatorio = 0;
        for (Pagamento pagamento : pagamentos) {
            somatorio += pagamento.getValorPago();
        }

        return somatorio >= valorTotal;
    }

    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getData() {
        return data;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }
}
