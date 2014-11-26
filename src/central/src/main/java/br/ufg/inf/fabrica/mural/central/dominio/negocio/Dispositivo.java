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
import br.ufg.inf.fabrica.mural.central.persistencia.StubDispositivoDao;
import br.ufg.inf.fabrica.mural.central.persistencia.StubNotificacaoDao;
import br.ufg.inf.fabrica.mural.central.persistencia.StubUsuarioDao;
import org.apache.log4j.Logger;

/**
 *
 * @author Bruno
 */
public class Dispositivo {
    
    private static final Logger LOGGER = Logger.getLogger("Dispositivo");
    
    private final String identificadorGCM;
    private final Usuario usuario;
    private String listaNotificacao;
    
    public Dispositivo(String identificadorGCM, Usuario usuario){
        this.identificadorGCM = identificadorGCM;
        this.usuario = usuario;
    }

    public String getIdentificadorGCM() {
        return identificadorGCM;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getListaNotificacao() {
        return listaNotificacao;
    }
    
    public CodigoResposta dessassociarDispositivoAoUsuario(){
        try{
            validarDispositivo(identificadorGCM);
            verificarUsuarioNotificacaoDirigida();
            validarCredencial(usuario);
            return CodigoResposta.CODIGO1000;
        } catch(ValidaDispositivoException e1){
            LOGGER.error(CodigoResposta.CODIGO1007.getDescricao(), e1);
            return CodigoResposta.CODIGO1007;
        } catch(VerificaUsuarioNotificacaoDirigidaException e2){
            LOGGER.error(CodigoResposta.CODIGO1006.getDescricao(), e2);
            return CodigoResposta.CODIGO1006;
        } catch(ValidaCredencialException e3){
            LOGGER.error(CodigoResposta.CODIGO1002.getDescricao(), e3);
            return CodigoResposta.CODIGO1002;
        }

    }
    
    public boolean validarDispositivo(String identificador) throws ValidaDispositivoException{
        Dispositivo dispositivo = new StubDispositivoDao().localizaDispositivoPorIdentificador(identificador);
        if(dispositivo == null) {
            return false;
        } 
        return true;
    }
    
    public boolean verificarUsuarioNotificacaoDirigida() throws VerificaUsuarioNotificacaoDirigidaException{
        Usuario usuarioByLoginSenha = new StubUsuarioDao().buscaUsuarioByLoginSenha(usuario.getLogin(), usuario.getSenha());
        boolean verificacao = new StubNotificacaoDao().verificaSeUsuarioRecebeNotifDirigida(usuarioByLoginSenha);
        return verificacao;
    }
    
    private boolean validarCredencial(Usuario usuario) throws ValidaCredencialException{
        return new StubAutenticadorCAS().validarCredencial(usuario);
    }
    
    @Override
    public String toString() {
        return "Dispositivo{" + "identificadorGCM=" + identificadorGCM + "}";
    }
    /*Existem outros metodos definidos no modelo de dominio 
      que nao participam desta funcionalidade
      portanto nao foram incluidos nesta classe.*/
    
}
