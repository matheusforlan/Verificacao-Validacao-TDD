package tests;
import main.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class FuncionarioTest {

    @Test
    public void testCriarFuncionario() {
        Funcionario funcionario = new Funcionario("Forlán", "4lan@gmail.com", 3000, new Desenvolvedor());
        Funcionario funcionario2 = new Funcionario("Forlán", "4lan@gmail.com", 3000, new Gerente());
        Funcionario funcionario3 = new Funcionario("Forlán", "4lan@gmail.com", 3000, new DBA());
        Funcionario funcionario4 = new Funcionario("Forlán", "4lan@gmail.com", 3000, new Testador());


        assertEquals("Forlán", funcionario.getNome());
        assertEquals("4lan@gmail.com", funcionario.getEmail());
        assertEquals(3000, funcionario.getSalarioBase(), 0.001);
        assertEquals("Desenvolvedor", funcionario.getCargo());
        assertEquals("Gerente", funcionario2.getCargo());
        assertEquals("DBA", funcionario3.getCargo());
        assertEquals("Testador", funcionario4.getCargo());

    }


}
