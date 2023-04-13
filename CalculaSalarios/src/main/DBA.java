package main;

public class DBA implements Cargo {
    public double calcularSalarioLiquido(double salarioBase) {
        if (salarioBase >= 2000) {
            return salarioBase * 0.75;
        } else {
            return salarioBase * 0.85;
        }
    }
}