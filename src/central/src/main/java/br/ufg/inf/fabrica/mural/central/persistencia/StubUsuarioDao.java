/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.fabrica.mural.central.persistencia;

import br.ufg.inf.fabrica.mural.central.dominio.entidade.Usuario;
import br.ufg.inf.fabrica.mural.central.dominio.exception.VerificaUsuarioNotificacaoDirigidaException;

/**
 *
 * @author Bruno
 */
public class StubUsuarioDao {
    
    public boolean verificarUsuarioNotificacaoDirigida(Usuario usuario) throws VerificaUsuarioNotificacaoDirigidaException{
        //coloquei essa linha setando login apenas para o Sonar nao
        //reclamar de variavel recebida nao utilizada
        usuario.setLogin("testeUsuario");
        return true;
    }
    
    public Usuario buscaUsuarioByLoginSenha(String login, String senha){
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);
        return usuario;
    }
}
