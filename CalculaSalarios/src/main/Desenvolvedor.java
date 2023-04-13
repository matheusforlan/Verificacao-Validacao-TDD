package main;

public class Desenvolvedor implements Cargo {
    public double calcularSalarioLiquido(double salarioBase) {
        if (salarioBase >= 3000) {
            return salarioBase * 0.8;
        } else {
            return salarioBase * 0.9;
        }
    }
}