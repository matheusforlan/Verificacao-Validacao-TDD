package main.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fatura {
    
    private String nome;
    private LocalDate data;
    private Float valorTotal;
    private List<Pagamento> pagamentos;

    public Fatura(String nome, LocalDate data, Float valorTotal) {
        this.nome = nome;
        this.data = data;
        this.valorTotal = valorTotal;
        this.pagamentos = new ArrayList<Pagamento>();
    }

    public Fatura() {
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData() {
        return data;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    
}
