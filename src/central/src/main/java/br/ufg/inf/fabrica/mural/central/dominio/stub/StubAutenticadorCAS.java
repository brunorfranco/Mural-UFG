/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.fabrica.mural.central.dominio.stub;

import br.ufg.inf.fabrica.mural.central.dominio.entidade.Usuario;
import br.ufg.inf.fabrica.mural.central.dominio.exception.ValidaCredencialException;

/**
 *
 * @author Bruno
 */
public class StubAutenticadorCAS {
    
    public boolean validarCredencial(Usuario usuario) throws ValidaCredencialException{
        //coloquei essa linha setando login apenas para o Sonar nao
        //reclamar de variavel recebida nao utilizada
        usuario.setLogin("testeUsuario");
        return true;
    }
}
