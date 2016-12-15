package br.usp.exoma.dao;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marcelo
 */
//@RunWith(WeldJUnit4Runner.class)
public class UsuarioDaoTest {
    
    private UsuarioDao instance;
    
    public UsuarioDaoTest() {
    }
    
    @Test
    public void testInjections() {
        assertNotNull(true);
    }

    /**
     * Test of adiciona method, of class UsuarioDao.
     
    @Test
    public void testAdiciona() {
        System.out.println("adiciona");
        Usuario user = new Usuario();
        user.setNome("Usuario Teste");
        Usuario expResult = new Usuario();
        expResult.setNome("Usuario Teste");
        Usuario result = instance.adiciona(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    */
}
