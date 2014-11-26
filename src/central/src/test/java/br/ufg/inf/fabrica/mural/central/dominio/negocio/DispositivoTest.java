/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.fabrica.mural.central.dominio.negocio;

import br.ufg.inf.fabrica.mural.central.dominio.entidade.Usuario;
import br.ufg.inf.fabrica.mural.central.dominio.enumerado.CodigoResposta;
import br.ufg.inf.fabrica.mural.central.dominio.exception.ValidaCredencialException;
import br.ufg.inf.fabrica.mural.central.dominio.exception.ValidaDispositivoException;
import br.ufg.inf.fabrica.mural.central.dominio.exception.VerificaUsuarioNotificacaoDirigidaException;
import br.ufg.inf.fabrica.mural.central.dominio.stub.StubAutenticadorCAS;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Bruno
 */
public class DispositivoTest {
    
    private static String identificadorGCM;
    private static Usuario usuario;
    private static Dispositivo dispositivo;
    
    @BeforeClass
    public static void carregaIdentificadoEUsuario(){
        identificadorGCM = "testeIdentificador";
        usuario = new Usuario();
        usuario.setLogin("LoginBruno");
        usuario.setSenha("SenhaBruno");
        
        dispositivo = new Dispositivo(identificadorGCM, usuario);
    }
    
    @Test
    public void validaDispositivoTeste() throws ValidaDispositivoException{
        boolean validarDispositivo = new Dispositivo(identificadorGCM, usuario).validarDispositivo(identificadorGCM);
        Assert.assertEquals(validarDispositivo, true);
    }
    
    @Test
    public void verificarUsuarioNotificacaoDirigidaTeste() throws VerificaUsuarioNotificacaoDirigidaException{
        Boolean valida = new Dispositivo(identificadorGCM, usuario).verificarUsuarioNotificacaoDirigida();
        Assert.assertEquals(valida, true);
    }
    
    @Test
    public void validarCredencialTeste() throws ValidaCredencialException{
        Boolean valida = new StubAutenticadorCAS().validarCredencial(usuario);
        Assert.assertEquals(valida, true);
    }
    
    @Test
    public void getIdentificadorGCMTeste(){
        Assert.assertEquals(dispositivo.getIdentificadorGCM(), identificadorGCM);
    }
    
    @Test
    public void getUsuarioTeste(){
        Assert.assertEquals(dispositivo.getUsuario(), usuario);
    }
    
    @Test
    public void getListaNotificacaoTeste(){
        Assert.assertEquals(dispositivo.getListaNotificacao(), null);
    }
    
    @Test
    public void dessassociarDispositivoAoUsuarioTeste(){
        CodigoResposta dessassociarDispositivoAoUsuario = dispositivo.dessassociarDispositivoAoUsuario();
        Assert.assertEquals(dessassociarDispositivoAoUsuario, CodigoResposta.CODIGO1000);
    }
    
}
