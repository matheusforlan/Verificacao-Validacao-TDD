package main.entities;

import java.time.LocalDate;

public class Pagamento {

    private String tipo;
    private Float valorPago;
    private LocalDate data;

    public Pagamento() {
    }

    public Pagamento(String tipo, Float valorPago, LocalDate data) {
        this.tipo = tipo;
        this.valorPago = valorPago;
        this.data = data;
    }

    public Pagamento(Float valorPago, LocalDate data) {
        this.tipo = "BOLETO";
        this.valorPago = valorPago;
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public Float getValorPago() {
        return valorPago;
    }

    public LocalDate getData() {
        return data;
    }
}
