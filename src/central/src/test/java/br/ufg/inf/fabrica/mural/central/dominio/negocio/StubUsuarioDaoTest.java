/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.fabrica.mural.central.dominio.negocio;

import br.ufg.inf.fabrica.mural.central.dominio.entidade.Usuario;
import br.ufg.inf.fabrica.mural.central.dominio.exception.VerificaUsuarioNotificacaoDirigidaException;
import br.ufg.inf.fabrica.mural.central.persistencia.StubUsuarioDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.Assert;
/**
 *
 * @author Bruno
 */
public class StubUsuarioDaoTest {
    
    @Test
    public void verificarUsuarioNotificacaoDirigidaTeste(){
        Usuario usuario = new Usuario();
        boolean verificador = false;
        try {
            verificador = new StubUsuarioDao().verificarUsuarioNotificacaoDirigida(usuario);
        } catch (VerificaUsuarioNotificacaoDirigidaException ex) {
            Logger.getLogger(StubUsuarioDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assert.assertEquals(verificador, true);
        
    }
    
    @Test
    public void buscaUsuarioByLoginSenhaTeste(){
        Usuario usuarioTeste = new Usuario();
        usuarioTeste.setLogin("testeLogin");
        usuarioTeste.setSenha("testeSenha");
        Usuario usuario = new StubUsuarioDao().buscaUsuarioByLoginSenha("testeLogin", "testeSenha");
        Assert.assertEquals(usuario.toString(), usuarioTeste.toString());
        
    }
    
}
