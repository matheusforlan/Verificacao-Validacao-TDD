package funcionalTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.ProcessadorBoletos;
import main.entities.Boleto;
import main.entities.Fatura;

// Falta terminar a tabela de decisão
public class TabelaDeDecisaoTests {

    @Test
    public void casoDeTeste1() {
        LocalDate data = LocalDate.of(2023, 5, 5);
        Fatura fatura = new Fatura("Burguiff", data, 100.0f);

        assertNotNull(fatura);
        assertEquals("Burguiff", fatura.getNome());
        assertEquals(100.f, fatura.getValorTotal(), 0.01);

        Boleto boleto1= new Boleto("0002", data, 95.0f);

        List<Boleto> boletos = new ArrayList<Boleto>();
        boletos.add(boleto1);

        ProcessadorBoletos processadorBoletos = new ProcessadorBoletos();
        processadorBoletos.processar(fatura, boletos);
        assertEquals("PENDENTE", fatura.getStatus());
    }

    @Test
    public void casoDeTeste2() {
        LocalDate data = LocalDate.of(2023, 5, 5);
        Fatura fatura = new Fatura("Burguiff", data, 100.0f);

        assertNotNull(fatura);
        assertEquals("Burguiff", fatura.getNome());
        assertEquals(100.f, fatura.getValorTotal(), 0.01);

        Boleto boleto1= new Boleto("0002", data, 100.0f);

        List<Boleto> boletos = new ArrayList<Boleto>();
        boletos.add(boleto1);

        ProcessadorBoletos processadorBoletos = new ProcessadorBoletos();
        processadorBoletos.processar(fatura, boletos);
        assertEquals("PAGA", fatura.getStatus());
    }

    @Test
    public void casoDeTeste3() {
        LocalDate data = LocalDate.of(2023, 5, 5);
        Fatura fatura = new Fatura("Burguiff", data, 100.0f);

        assertNotNull(fatura);
        assertEquals("Burguiff", fatura.getNome());
        assertEquals(100.f, fatura.getValorTotal(), 0.01);

        Boleto boleto1= new Boleto("0002", data, 50.0f);
        Boleto boleto2= new Boleto("0002", data, 70.0f);

        List<Boleto> boletos = new ArrayList<Boleto>();
        boletos.add(boleto1);
        boletos.add(boleto2);

        ProcessadorBoletos processadorBoletos = new ProcessadorBoletos();
        processadorBoletos.processar(fatura, boletos);
        assertEquals("PAGA", fatura.getStatus());
    }

    @Test
    public void casoDeTeste4() {
        LocalDate data = LocalDate.of(2023, 5, 5);
        Fatura fatura = new Fatura("Burguiff", data, 100.0f);

        assertNotNull(fatura);
        assertEquals("Burguiff", fatura.getNome());
        assertEquals(100.f, fatura.getValorTotal(), 0.01);

        Boleto boleto1= new Boleto("0002", data, 50.0f);
        Boleto boleto2= new Boleto("0002", data, 10.0f);

        List<Boleto> boletos = new ArrayList<Boleto>();
        boletos.add(boleto1);
        boletos.add(boleto2);

        ProcessadorBoletos processadorBoletos = new ProcessadorBoletos();
        processadorBoletos.processar(fatura, boletos);
        assertEquals("PENDENTE", fatura.getStatus());
    }

    @Test
    public void casoDeTeste5() {
        LocalDate data = LocalDate.of(2023, 5, 5);
        Fatura fatura = new Fatura("Burguiff", data, 100.0f);

        assertNotNull(fatura);
        assertEquals("Burguiff", fatura.getNome());
        assertEquals(100.f, fatura.getValorTotal(), 0.01);

        try {
            Boleto boleto1= new Boleto("0002", data, -1.0f);
            Boleto boleto2= new Boleto("0002", data, 50.0f);

            List<Boleto> boletos = new ArrayList<Boleto>();
            boletos.add(boleto1);
            boletos.add(boleto2);

            ProcessadorBoletos processadorBoletos = new ProcessadorBoletos();
            processadorBoletos.processar(fatura, boletos);
            assertEquals("PENDENTE", fatura.getStatus());

            fail("Uma exceção era esperada, o valor do boleto não pode ser negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("Valor do boleto não pode ser negativo.", e.getMessage());
        }
    }

}
