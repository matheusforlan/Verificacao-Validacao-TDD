package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.ProcessadorBoletos;
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

    @Test
    public void testeProcessaBoletosFaturaPaga() {
        LocalDate data = LocalDate.of(2023, 4, 12);

        Fatura fatura = new Fatura("Mister Vitor Pereira", data, 1500.0f);

        Boleto boleto1= new Boleto("0002", data, 500.0f);
        Boleto boleto2 = new Boleto("0002", data, 600.0f);
        Boleto boleto3 = new Boleto("0003", data, 500.0f);

        List<Boleto> boletos = new ArrayList<Boleto>();
        boletos.add(boleto1);
        boletos.add(boleto2);
        boletos.add(boleto3);

       ProcessadorBoletos processadorBoletos = new ProcessadorBoletos();
       processadorBoletos.processar(fatura, boletos);
       assertEquals("PAGA", fatura.getStatus());
    }

    @Test
    public void testeProcessaBoletosFaturaPendente() {
        LocalDate data = LocalDate.of(2023, 4, 12);

        Fatura fatura = new Fatura("Mister Vitor Pereira", data, 1500.0f);

        Boleto boleto1= new Boleto("0002", data, 500.0f);
        Boleto boleto2 = new Boleto("0002", data, 600.0f);
        Boleto boleto3 = new Boleto("0003", data, 300.0f);

        List<Boleto> boletos = new ArrayList<Boleto>();
        boletos.add(boleto1);
        boletos.add(boleto2);
        boletos.add(boleto3);

       ProcessadorBoletos processadorBoletos = new ProcessadorBoletos();
       assertEquals("PENDENTE", fatura.getStatus());
       processadorBoletos.processar(fatura, boletos);
       assertEquals("PENDENTE", fatura.getStatus());
    }

    @Test
    public void testeFaturaZeradaMarcadaComoPaga() {
        LocalDate data = LocalDate.of(2023, 4, 12);

        Fatura fatura = new Fatura("Mister Vitor Pereira", data, 0f);

        Boleto boleto1= new Boleto("0002", data, 500.0f);

        List<Boleto> boletos = new ArrayList<Boleto>();
        boletos.add(boleto1);

       assertEquals("PAGA", fatura.getStatus());
    }
}
