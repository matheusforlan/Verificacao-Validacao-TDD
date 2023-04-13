package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import main.entities.Boleto;
import main.entities.Fatura;
import main.entities.Pagamento;

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

    @Test
    public void testeCriaBoletoCorretamente() {

        LocalDate data = LocalDate.of(2023, 4, 12);
        Boleto boleto = new Boleto("0001", data, 220.50f);

        assertNotNull(boleto);
        assertEquals("0001", boleto.getCodigo());
        assertEquals(0, (boleto.getData()).compareTo(LocalDate.of(2023, 4, 12)));
        assertEquals(220.50f, boleto.getValorPago(), 0.01);
    }

    @Test
    public void criaPagamentoCorretamente() {
        LocalDate data = LocalDate.of(2023, 4, 12);

        Pagamento pagamento = new Pagamento("BOLETO", 200.0f, data);
        Fatura fatura = new Fatura("Fulano de tal", data, 3000.f);
        
        fatura.getPagamentos().add(pagamento);

        assertNotNull(pagamento);
        assertEquals("BOLETO", pagamento.getTipo());
        assertEquals(0, (pagamento.getData()).compareTo(LocalDate.of(2023, 4, 12)));
        assertEquals( 200.0f, pagamento.getValorPago(), 0.01);

        assertEquals(1, fatura.getPagamentos().size());
    }

}
