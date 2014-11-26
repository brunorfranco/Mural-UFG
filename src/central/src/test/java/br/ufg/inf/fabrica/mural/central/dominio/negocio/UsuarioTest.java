/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.fabrica.mural.central.dominio.negocio;

import br.ufg.inf.fabrica.mural.central.dominio.entidade.Usuario;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Bruno
 */
public class UsuarioTest {
    
    private static Usuario usuario;
    
    @BeforeClass
    public static void instanciaUsuario(){
        usuario = new Usuario();
        usuario.setId(1);
        usuario.setLogin("testeLogin");
        usuario.setSenha("testeSenha");
        usuario.setAdministrador(true);
        usuario.setApenasProdutor(true);
    }
    
    @Test
    public void getIdTeste(){
        Assert.assertEquals(1, usuario.getId());
    }
    
    @Test
    public void setIdTeste(){
        usuario.setId(2);
        Assert.assertEquals(2, usuario.getId());
        usuario.setId(1);
    }
    
    @Test
    public void getLoginTeste(){
        Assert.assertEquals("testeLogin", usuario.getLogin());
    }
    
    @Test
    public void setLoginTeste(){
        usuario.setLogin("testeLogin2");
        Assert.assertEquals("testeLogin2", usuario.getLogin());
        usuario.setLogin("testeLogin");
    }
    
    @Test
    public void getSenhaTeste(){
        Assert.assertEquals("testeSenha", usuario.getSenha());
    }
    
    @Test
    public void setSenhaTeste(){
        usuario.setSenha("testeSenha2");
        Assert.assertEquals("testeSenha2", usuario.getSenha());
        usuario.setSenha("testeSenha");
    }
    
    @Test
    public void isApenasProdutorTeste(){
        Assert.assertEquals(true, usuario.isApenasProdutor());
    }
    
    @Test
    public void setApenasProdutorTeste(){
        usuario.setApenasProdutor(false);
        Assert.assertEquals(false, usuario.isApenasProdutor());
        usuario.setApenasProdutor(true);
    }
    
    @Test
    public void isAdministradorTeste(){
        Assert.assertEquals(true, usuario.isAdministrador());
    }
    
    @Test
    public void setAdministradorTeste(){
        usuario.setAdministrador(false);
        Assert.assertEquals(false, usuario.isAdministrador());
        usuario.setAdministrador(true);
    }
    
}
