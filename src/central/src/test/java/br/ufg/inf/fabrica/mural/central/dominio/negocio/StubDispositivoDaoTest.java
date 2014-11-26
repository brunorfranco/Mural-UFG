/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.fabrica.mural.central.dominio.negocio;

import br.ufg.inf.fabrica.mural.central.dominio.entidade.Usuario;
import br.ufg.inf.fabrica.mural.central.dominio.exception.ValidaDispositivoException;
import br.ufg.inf.fabrica.mural.central.persistencia.StubDispositivoDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author Bruno
 */
public class StubDispositivoDaoTest {
    
    @Test
    public void localizaDispositivoPorIdentificadorTeste(){
        StubDispositivoDao stubDispositivoDao = new StubDispositivoDao();
        Dispositivo dispositivo = null;
        try {
            dispositivo = stubDispositivoDao.localizaDispositivoPorIdentificador("testeIdentificador");
        } catch (ValidaDispositivoException ex) {
            Logger.getLogger(StubDispositivoDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dispositivo dispositivoTeste = new Dispositivo("testeIdentificador", new Usuario());
        Assert.assertEquals(dispositivoTeste.toString(), dispositivo.toString());
    }
    
}
