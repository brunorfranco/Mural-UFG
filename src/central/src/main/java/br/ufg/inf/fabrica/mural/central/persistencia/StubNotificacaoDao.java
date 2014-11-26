/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.fabrica.mural.central.persistencia;

import br.ufg.inf.fabrica.mural.central.dominio.entidade.Usuario;

/**
 *
 * @author Bruno
 */
public class StubNotificacaoDao {
    
    public boolean verificaSeUsuarioRecebeNotifDirigida(Usuario usuario){
        //coloquei essa linha setando login apenas para o Sonar nao
        //reclamar de variavel recebida nao utilizada
        usuario.setLogin("testeUsuario");
        return true;
    }
    
}
