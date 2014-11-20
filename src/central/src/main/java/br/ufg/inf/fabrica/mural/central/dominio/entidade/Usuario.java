/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.fabrica.mural.central.dominio.entidade;

import java.util.Collection;

/**
 *
 * @author Bruno
 */
public class Usuario {
    
    private long id;
    private String login;
    private String senha;
    private Boolean apenasProdutor;
    private boolean administrador;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean isApenasProdutor() {
        return apenasProdutor;
    }

    public void setApenasProdutor(Boolean apenasProdutor) {
        this.apenasProdutor = apenasProdutor;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
    
    public Collection obterUsuarioGrupo(GrupoDestinatario grupoDestinatario){
        //nao faz parte desse pacote implementar esse metodo
        return null;
    }
    
}
