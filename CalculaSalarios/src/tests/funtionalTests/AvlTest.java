package tests.funtionalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import main.DBA;
import main.Desenvolvedor;
import main.Gerente;
import main.Testador;

public class AvlTest {

    @Test
    public void casoTeste1() {
        Desenvolvedor desenvolvedor = new Desenvolvedor();
        try {
            desenvolvedor.calcularSalarioLiquido(-1.0);
            fail("Uma exceção era esperada.");
        } catch (IllegalArgumentException e) {
            assertEquals("Salário base não pode ser negativo.", e.getMessage());
        }
    }

    @Test
    public void casoTeste2() {
        Desenvolvedor desenvolvedor = new Desenvolvedor();
        double salarioLiquido = desenvolvedor.calcularSalarioLiquido(0.0);
        assertEquals(0, salarioLiquido, 0.001);
    }

    @Test
    public void casoTeste3() {
        Desenvolvedor desenvolvedor = new Desenvolvedor();
        double salarioLiquido = desenvolvedor.calcularSalarioLiquido(999999.0);
        assertEquals(799999.2, salarioLiquido, 0.001);
    }

    @Test
    public void casoTeste4() {
        Desenvolvedor desenvolvedor = new Desenvolvedor();
        double salarioLiquido = desenvolvedor.calcularSalarioLiquido(3000.0);
        assertEquals(2400.0, salarioLiquido, 0.001);
    }

    @Test
    public void casoTeste5() {
        Desenvolvedor desenvolvedor = new Desenvolvedor();
        double salarioLiquido = desenvolvedor.calcularSalarioLiquido(2999.0);
        assertEquals(2699.1, salarioLiquido, 0.001);
    }

    @Test
    public void casoTeste6() {
        DBA dba = new DBA();
        try {
            dba.calcularSalarioLiquido(-1.0);
            fail("Uma exceção era esperada.");
        } catch (IllegalArgumentException e) {
            assertEquals("Salário base não pode ser negativo.", e.getMessage());
        }
    }

    @Test
    public void casoTeste7() {
        Testador testador = new Testador();
        try {
            testador.calcularSalarioLiquido(-1.0);
            fail("Uma exceção era esperada.");
        } catch (IllegalArgumentException e) {
            assertEquals("Salário base não pode ser negativo.", e.getMessage());
        }
    }

    @Test
    public void casoTeste8() {
        DBA dba = new DBA();
        Testador testador = new Testador();

        double salarioLiquidoDBA = dba.calcularSalarioLiquido(0.0);
        double salarioLiquidoTestador = testador.calcularSalarioLiquido(0.0);

        assertEquals(0.0, salarioLiquidoDBA, 0.001);
        assertEquals(0.0, salarioLiquidoTestador, 0.001);
    }

    @Test
    public void casoTeste9() {
        DBA dba = new DBA();
        Testador testador = new Testador();

        double salarioLiquidoDBA = dba.calcularSalarioLiquido(999999.0);
        double salarioLiquidoTestador = testador.calcularSalarioLiquido(999999.0);

        assertEquals(749999.25, salarioLiquidoDBA, 0.001);
        assertEquals(749999.25, salarioLiquidoTestador, 0.001);
    }

    @Test
    public void casoTeste10() {
        DBA dba = new DBA();
        Testador testador = new Testador();

        double salarioLiquidoDBA = dba.calcularSalarioLiquido(2000.0);
        double salarioLiquidoTestador = testador.calcularSalarioLiquido(2000.0);

        assertEquals(1500, salarioLiquidoDBA, 0.001);
        assertEquals(1500, salarioLiquidoTestador, 0.001);
    }

    @Test
    public void casoTeste11() {
        DBA dba = new DBA();
        Testador testador = new Testador();

        double salarioLiquidoDBA = dba.calcularSalarioLiquido(1999.0);
        double salarioLiquidoTestador = testador.calcularSalarioLiquido(1999.0);

        assertEquals(1699.15, salarioLiquidoDBA, 0.001);
        assertEquals(1699.15, salarioLiquidoTestador, 0.001);
    }

    @Test
    public void casoTeste12() {
        Gerente gerente = new Gerente();
        try {
            gerente.calcularSalarioLiquido(-1.0);
            fail("Uma exceção era esperada.");
        } catch (IllegalArgumentException e) {
            assertEquals("Salário base não pode ser negativo.", e.getMessage());
        }
    }

    @Test
    public void casoTeste13() {
        Gerente gerente = new Gerente();
        double salarioLiquido = gerente.calcularSalarioLiquido(0.0);
        assertEquals(0.0, salarioLiquido, 0.001);
    }

    @Test
    public void casoTeste14() {
        Gerente gerente = new Gerente();
        double salarioLiquido = gerente.calcularSalarioLiquido(999999.0);
        assertEquals(699999.3, salarioLiquido, 0.001);
    }

    @Test
    public void casoTeste15() {
        Gerente gerente = new Gerente();
        double salarioLiquido = gerente.calcularSalarioLiquido(5000.0);
        assertEquals(3500.0, salarioLiquido, 0.001);
    }

    @Test
    public void casoTeste16() {
        Gerente gerente = new Gerente();
        double salarioLiquido = gerente.calcularSalarioLiquido(4999.0);
        assertEquals(3999.2, salarioLiquido, 0.001);
    }
}
