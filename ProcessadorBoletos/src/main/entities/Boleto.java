package main.entities;

import java.time.LocalDate;

public class Boleto {

    private String codigo;
    private LocalDate data;
    private Float valorPago;

    public Boleto() {
    }

    public Boleto(String codigo, LocalDate data, Float valorPago) throws IllegalArgumentException {
        this.codigo = codigo;
        this.data = data;
        if (valorPago < 0) {
            throw new IllegalArgumentException("Valor do boleto não pode ser negativo.");
        } else {
            this.valorPago = valorPago;
        }

    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public Float getValorPago() {
        return valorPago;
    }

}
