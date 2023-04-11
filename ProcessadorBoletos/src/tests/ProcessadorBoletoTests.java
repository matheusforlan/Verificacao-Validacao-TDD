package tests;

import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import main.ProcessadorBoletos;
import main.entities.Boleto;
import main.entities.Fatura;

/*
 * Roteiro de testes
 * 
 * Teste de criação de faturas
 * 1. Dado um nome de cliente, uma data e um valor total, deve criar uma fatura com esses dados.
 * 2. Verificar se os dados da fatura estão corretos.
 * 3. Verificar se a fatura está com status "PENDENTE".
 * 
 * Teste de criação de boleto
 * 1. Dado um código de boleto, uma data e um valor pago, deve criar um boleto com esses dados.
 * 2. Verificar se os dados do boleto estão corretos.
 * 
 * Teste de processamento de boletos
 * 1. Dado uma lista de boletos e uma fatura, deve processar os boletos e associá-los à fatura.
 * 2. Verificar se os pagamentos foram criados corretamente para cada boleto.
 * 3. Verificar se a fatura foi marcada como "PAGA" quando o valor total dos boletos ultrapassar o valor da fatura.
 * 4. Verificar se a fatura está com status "PENDENTE" quando o valor total dos boletos for menor que o valor da fatura.
 */

public class ProcessadorBoletoTests {

    private ProcessadorBoletos processador;
    private Fatura fatura;
    private List<Boleto> boletos;

    @Before
    public void setUp() {
        processador = new ProcessadorBoletos();
        fatura = new Fatura();
        boletos = new ArrayList<>();
    }
}
