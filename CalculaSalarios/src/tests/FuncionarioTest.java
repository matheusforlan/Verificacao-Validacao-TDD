package tests;
import org.junit.Test;
import static org.junit.Assert.*;
public class FuncionarioTest {

    @Test
    public void testCriarFuncionario() {
        Funcionario funcionario = new Funcionario("Forlán", "4lan@gmail.com", 3000);

        assertEquals("Forlán", funcionario.getNome());
        assertEquals("4lan@gmail.com", funcionario.getEmail());
        assertEquals(3000, funcionario.getSalarioBase());

    }


}
