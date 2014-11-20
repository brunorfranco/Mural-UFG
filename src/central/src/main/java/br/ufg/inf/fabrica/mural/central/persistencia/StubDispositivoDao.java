/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.fabrica.mural.central.persistencia;

import br.ufg.inf.fabrica.mural.central.dominio.exception.ValidaDispositivoException;

/**
 *
 * @author Bruno
 */
public class StubDispositivoDao {
    
    public boolean validarDispositivo(String identificador) throws ValidaDispositivoException{
        return true;
    }
}
