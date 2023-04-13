package tests;

import org.junit.Test;
import static org.junit.Assert.*;

public class DesenvolvedorTest {

    @Test
    public void testCalcularSalarioLiquidoSalarioMaiorQue3000() {
        Desenvolvedor desenvolvedor = new Desenvolvedor();
        double salarioLiquido = desenvolvedor.calcularSalarioLiquido(4000.0);
        assertEquals(3200.0, salarioLiquido, 0.001);
    }

    @Test
    public void testCalcularSalarioLiquidoSalarioMenorQue3000() {
        Desenvolvedor desenvolvedor = new Desenvolvedor();
        double salarioLiquido = desenvolvedor.calcularSalarioLiquido(2500.0);
        assertEquals(2250.0, salarioLiquido, 0.001);
    }
}
