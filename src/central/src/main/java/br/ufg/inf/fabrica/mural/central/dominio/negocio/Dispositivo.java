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
import br.ufg.inf.fabrica.mural.central.persistencia.StubUsuarioDao;
import java.util.logging.Logger;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author Bruno
 */
public class Dispositivo {
    
    static final Logger logger = Logger.getLogger("Dispositivo");
    
    private String identificadorGCM;
    private Usuario usuario;
    private String listaNotificacao;
    
    public Dispositivo(String identificadorGCM, Usuario usuario){
        this.identificadorGCM = identificadorGCM;
        this.usuario = usuario;
        
        BasicConfigurator.configure();
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
            return CodigoResposta.Codigo1000;
        } catch(ValidaDispositivoException e1){
            logger.info(CodigoResposta.Codigo1007.getDescricao());
            return CodigoResposta.Codigo1007;
        } catch(VerificaUsuarioNotificacaoDirigidaException e2){
            logger.info(CodigoResposta.Codigo1006.getDescricao());
            return CodigoResposta.Codigo1006;
        } catch(ValidaCredencialException e3){
            logger.info(CodigoResposta.Codigo1002.getDescricao());
            return CodigoResposta.Codigo1002;
        }

    }
    
    private boolean validarDispositivo(String identificador) throws ValidaDispositivoException{
        return new StubDispositivoDao().validarDispositivo(identificador);
    }
    
    private boolean verificarUsuarioNotificacaoDirigida() throws VerificaUsuarioNotificacaoDirigidaException{
        return new StubUsuarioDao().verificarUsuarioNotificacaoDirigida(usuario);
    }
    
    private boolean validarCredencial(Usuario usuario) throws ValidaCredencialException{
        return new StubAutenticadorCAS().validarCredencial(usuario);
    }
    
    /*Existem outros metodos definidos no modelo de dominio 
      que nao participam desta funcionalidade
      portanto nao foram incluidos nesta classe.*/
    
}
