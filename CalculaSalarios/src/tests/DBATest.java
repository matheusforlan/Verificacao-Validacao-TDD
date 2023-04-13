package tests;

import main.DBA;
import org.junit.Test;
import static org.junit.Assert.*;

public class DBATest {

    @Test
    public void testCalcularSalarioLiquidoSalarioMaiorQue2000() {
        DBA dba = new DBA();
        double salarioLiquido = dba.calcularSalarioLiquido(3000.0);
        assertEquals(2250.0, salarioLiquido, 0.001);
    }

    @Test
    public void testCalcularSalarioLiquidoSalarioMenorQue2000() {
        DBA dba = new DBA();
        double salarioLiquido = dba.calcularSalarioLiquido(1500.0);
        assertEquals(1275.0, salarioLiquido, 0.001);
    }
}

