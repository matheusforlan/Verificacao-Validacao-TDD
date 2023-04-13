package main;

public class Funcionario {
    private String nome;
    private String email;
    private double salarioBase;
    public Funcionario(String nome, String email, double salarioBase) {
        this.nome = nome;
        this.email = email;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
}
