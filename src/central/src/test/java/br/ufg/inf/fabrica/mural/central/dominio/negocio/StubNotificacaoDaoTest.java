/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.fabrica.mural.central.dominio.negocio;

import br.ufg.inf.fabrica.mural.central.dominio.entidade.Usuario;
import br.ufg.inf.fabrica.mural.central.persistencia.StubNotificacaoDao;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author Bruno
 */
public class StubNotificacaoDaoTest {
    
    @Test
    public void verificaSeUsuarioRecebeNotifDirigidaTeste(){
        Usuario usuario = new Usuario();
        StubNotificacaoDao stubNotificacaoDao = new StubNotificacaoDao();
        boolean verificador = stubNotificacaoDao.verificaSeUsuarioRecebeNotifDirigida(usuario);
        Assert.assertEquals(verificador, true);
    }
    
}
