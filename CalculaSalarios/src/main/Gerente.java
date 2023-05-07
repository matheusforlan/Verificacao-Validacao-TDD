package main;

public class Gerente implements Cargo {
    public double calcularSalarioLiquido(double salarioBase) {
        if (salarioBase >= 5000) {
            return salarioBase * 0.7;
        } else {
            return salarioBase * 0.8;
        }
    }

    @Override
    public String getCargo() {
        return "Gerente";
    }
}
