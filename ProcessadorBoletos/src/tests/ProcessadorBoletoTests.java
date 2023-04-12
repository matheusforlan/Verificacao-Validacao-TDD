package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import main.entities.Fatura;

public class ProcessadorBoletoTests {

    @Test
    public void testeCriaFaturaCorretamente() {
        LocalDate data = LocalDate.of(2023, 4, 12);
        Fatura fatura = new Fatura("Fulano de tal", data, 3000.0f);

        assertNotNull(fatura);
        assertEquals("Fulano de tal", fatura.getNome());
        assertEquals(0, (fatura.getData()).compareTo(LocalDate.of(2023, 4, 12)));
        assertEquals(3000.f, fatura.getValorTotal(), 0.01);
    }
}
