/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.fabrica.mural.central.persistencia;

import br.ufg.inf.fabrica.mural.central.dominio.entidade.Usuario;
import br.ufg.inf.fabrica.mural.central.dominio.exception.ValidaDispositivoException;
import br.ufg.inf.fabrica.mural.central.dominio.negocio.Dispositivo;

/**
 *
 * @author Bruno
 */
public class StubDispositivoDao {
    
    public Dispositivo localizaDispositivoPorIdentificador(String identificador) throws ValidaDispositivoException{
        return new Dispositivo(identificador, new Usuario());
    }
}
