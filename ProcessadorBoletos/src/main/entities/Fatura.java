package main.entities;

import java.time.LocalDate;

public class Fatura {
    
    private String nome;
    private LocalDate data;
    private Float valorTotal;

    public Fatura(String nome, LocalDate data, Float valorTotal) {
        this.nome = nome;
        this.data = data;
        this.valorTotal = valorTotal;
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
}
