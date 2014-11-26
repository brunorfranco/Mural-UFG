/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.fabrica.mural.central.dominio.negocio;

import br.ufg.inf.fabrica.mural.central.dominio.entidade.Usuario;
import br.ufg.inf.fabrica.mural.central.dominio.exception.ValidaCredencialException;
import br.ufg.inf.fabrica.mural.central.dominio.exception.ValidaDispositivoException;
import br.ufg.inf.fabrica.mural.central.dominio.exception.VerificaUsuarioNotificacaoDirigidaException;
import br.ufg.inf.fabrica.mural.central.dominio.stub.StubAutenticadorCAS;
import br.ufg.inf.fabrica.mural.central.persistencia.StubDispositivoDao;
import br.ufg.inf.fabrica.mural.central.persistencia.StubUsuarioDao;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Bruno
 */
public class DispositivoTeste {
    
    private static String identificadorGCM;
    private static Usuario usuario;
    
    @BeforeClass
    public static void carregaIdentificadoEUsuario(){
        identificadorGCM = "testeIdentificador";
        usuario = new Usuario();
        usuario.setLogin("LoginBruno");
        usuario.setSenha("SenhaBruno");
    }
    
    @Test
    public void validaDispositivoTeste() throws ValidaDispositivoException{
        Boolean valida = new StubDispositivoDao().validarDispositivo(identificadorGCM);
        Assert.assertEquals(valida, true);
    }
    
    @Test
    public void verificarUsuarioNotificacaoDirigidaTeste() throws VerificaUsuarioNotificacaoDirigidaException{
        Boolean valida = new StubUsuarioDao().verificarUsuarioNotificacaoDirigida(usuario);
        Assert.assertEquals(valida, true);
    }
    
    @Test
    public void validarCredencialTeste() throws ValidaCredencialException{
        Boolean valida = new StubAutenticadorCAS().validarCredencial(usuario);
        Assert.assertEquals(valida, true);
    }
    
}
