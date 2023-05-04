package funcionalTests;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.ProcessadorBoletos;
import main.entities.Boleto;
import main.entities.Fatura;
import main.entities.Pagamento;

public class ParticaoDeEquivalenciaTests {

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

    @Test
    public void casoDeTeste6() {
        LocalDate data = LocalDate.of(2023, 5, 5);
        Fatura fatura = new Fatura("Burguiff", data, 100.0f);

        assertNotNull(fatura);
        assertEquals("Burguiff", fatura.getNome());
        assertEquals(100.f, fatura.getValorTotal(), 0.01);

        try {
            Boleto boleto1= new Boleto("0002", data, 70.0f);
            Boleto boleto2= new Boleto("0002", data, -40.0f);

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

    @Test
    public void casoDeTeste7() {
        LocalDate data = LocalDate.of(2023, 5, 5);
        Fatura fatura = new Fatura("Burguiff", data, 100.0f);

        assertNotNull(fatura);
        assertEquals("Burguiff", fatura.getNome());
        assertEquals(100.f, fatura.getValorTotal(), 0.01);

        try {
            Boleto boleto1= new Boleto("0002", data, -5.0f);
            Boleto boleto2= new Boleto("0002", data, 120.0f);

            List<Boleto> boletos = new ArrayList<Boleto>();
            boletos.add(boleto1);
            boletos.add(boleto2);

            ProcessadorBoletos processadorBoletos = new ProcessadorBoletos();
            processadorBoletos.processar(fatura, boletos);
            assertEquals("PAGA", fatura.getStatus());

            fail("Uma exceção era esperada, o valor do boleto não pode ser negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("Valor do boleto não pode ser negativo.", e.getMessage());
        }
    }

    @Test
    public void casoDeTeste8() {

        try {

            LocalDate data = LocalDate.of(2023, 5, 5);
            Fatura fatura = new Fatura("Burguiff", data, -100.0f);

            assertNotNull(fatura);
            assertEquals("Burguiff", fatura.getNome());
            assertEquals(-100.f, fatura.getValorTotal(), 0.01);
            Boleto boleto1= new Boleto("0002", data, 50.0f);

            List<Boleto> boletos = new ArrayList<Boleto>();
            boletos.add(boleto1);

            ProcessadorBoletos processadorBoletos = new ProcessadorBoletos();
            processadorBoletos.processar(fatura, boletos);
            assertEquals("PAGA", fatura.getStatus());

            fail("Uma exceção era esperada, o valor da fatura não pode ser negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("Valor da fatura não pode ser negativo.", e.getMessage());
        }
    }

    @Test
    public void casoDeTeste9() {
        LocalDate data = LocalDate.of(2023, 5, 5);
        Fatura fatura = new Fatura("Burguiff", data, 100.0f);

        assertNotNull(fatura);
        assertEquals("Burguiff", fatura.getNome());
        assertEquals(100.f, fatura.getValorTotal(), 0.01);

        try {
            Boleto boleto1= new Boleto("0002", data, 0.0f);


            List<Boleto> boletos = new ArrayList<Boleto>();
            boletos.add(boleto1);


            ProcessadorBoletos processadorBoletos = new ProcessadorBoletos();
            processadorBoletos.processar(fatura, boletos);
            assertEquals("PENDENTE", fatura.getStatus());

            fail("Uma exceção era esperada, o valor do boleto não pode ser zero.");
        } catch (IllegalArgumentException e) {
            assertEquals("Valor do boleto não pode ser zero.", e.getMessage());
        }
    }

    @Test
    public void casoDeTeste10() {
        LocalDate data = LocalDate.of(2023, 5, 5);
        Fatura fatura = new Fatura("Burguiff", data, 100.0f);

        assertNotNull(fatura);
        assertEquals("Burguiff", fatura.getNome());
        assertEquals(100.f, fatura.getValorTotal(), 0.01);



        assertEquals("PENDENTE", fatura.getStatus());
    }

}
