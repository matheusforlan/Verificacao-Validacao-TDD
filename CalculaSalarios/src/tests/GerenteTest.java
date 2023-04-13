package tests;

import org.junit.Test;
import static org.junit.Assert.*;

public class GerenteTest {

    @Test
    public void testCalcularSalarioLiquidoSalarioMaiorQue5000() {
        Gerente gerente = new Gerente();
        double salarioLiquido = gerente.calcularSalarioLiquido(7000.0);
        assertEquals(4900.0, salarioLiquido, 0.001);
    }

    @Test
    public void testCalcularSalarioLiquidoSalarioMenorQue5000() {
        Gerente gerente = new Gerente();
        double salarioLiquido = gerente.calcularSalarioLiquido(4000.0);
        assertEquals(3200.0, salarioLiquido, 0.001);
    }
}






