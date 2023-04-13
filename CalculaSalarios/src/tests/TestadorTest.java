package tests;

import main.Testador;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestadorTest {

    @Test
    public void testCalcularSalarioLiquidoSalarioMaiorQue2000() {
        Testador testador = new Testador();
        double salarioLiquido = testador.calcularSalarioLiquido(3000.0);
        assertEquals(2250.0, salarioLiquido, 0.001);
    }

    @Test
    public void testCalcularSalarioLiquidoSalarioMenorQue2000() {
        Testador testador = new Testador();
        double salarioLiquido = testador.calcularSalarioLiquido(1500.0);
        assertEquals(1275.0, salarioLiquido, 0.001);
    }
}