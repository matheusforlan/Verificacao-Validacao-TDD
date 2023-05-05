package tests.funtionalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import main.DBA;
import main.Desenvolvedor;
import main.Gerente;
import main.Testador;

public class ParticaoEquivalenciaTest {

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
        double salarioLiquido = desenvolvedor.calcularSalarioLiquido(3400.0);
        assertEquals(2720.0, salarioLiquido, 0.001);
    }

    @Test
    public void casoTeste3() {
        Desenvolvedor desenvolvedor = new Desenvolvedor();
        double salarioLiquido = desenvolvedor.calcularSalarioLiquido(2750.0);
        assertEquals(2475.0, salarioLiquido, 0.001);
    }

    @Test
    public void casoTeste4() {
        Testador testador = new Testador();
        try {
            testador.calcularSalarioLiquido(-1.0);
            fail("Uma exceção era esperada.");
        } catch (IllegalArgumentException e) {
            assertEquals("Salário base não pode ser negativo.", e.getMessage());
        }
    }

    @Test
    public void casoTeste5() {
        DBA dba = new DBA();
        try {
            dba.calcularSalarioLiquido(-1.0);
            fail("Uma exceção era esperada.");
        } catch (IllegalArgumentException e) {
            assertEquals("Salário base não pode ser negativo.", e.getMessage());
        }
    }

    @Test
    public void casoTeste6() {
        Testador testador = new Testador();
        DBA dba = new DBA();

        double salarioLiquidoTestador = testador.calcularSalarioLiquido(2500.0);
        double salarioLiquidoDBA = dba.calcularSalarioLiquido(2500.0);

        assertEquals(1875.0, salarioLiquidoDBA, 0.001);
        assertEquals(1875.0, salarioLiquidoTestador, 0.001);
    }

    @Test
    public void casoTeste7() {
        Testador testador = new Testador();
        DBA dba = new DBA();

        double salarioLiquidoTestador = testador.calcularSalarioLiquido(1460.0);
        double salarioLiquidoDBA = dba.calcularSalarioLiquido(1460.0);

        assertEquals(1241.0, salarioLiquidoDBA, 0.001);
        assertEquals(1241.0, salarioLiquidoTestador, 0.001);
    }

    @Test
    public void casoTeste8() {
        Gerente gerente = new Gerente();
        try {
            gerente.calcularSalarioLiquido(-1.0);
            fail("Uma exceção era esperada.");
        } catch (IllegalArgumentException e) {
            assertEquals("Salário base não pode ser negativo.", e.getMessage());
        }
    }

    @Test
    public void casoTeste9() {
        Gerente gerente = new Gerente();
        double salarioLiquido = gerente.calcularSalarioLiquido(6000.0);
        assertEquals(4200.0, salarioLiquido, 0.001);
    }

    @Test
    public void casoTeste10() {
        Gerente gerente = new Gerente();
        double salarioLiquido = gerente.calcularSalarioLiquido(3700.0);
        assertEquals(2960.0, salarioLiquido, 0.001);
    }
}
