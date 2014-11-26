/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.fabrica.mural.central.dominio.enumerado;

/**
 *
 * @author Bruno
 */
public enum CodigoResposta {
    
    CODIGO1000("Solicitação tratada com sucesso"),
    CODIGO1002("Credencial de usuário apresentadas são inválidas junto ao CAS"),
    CODIGO1005("Identificador do dispositivo não informado"),
    CODIGO1006("Credencial não informada."),
    CODIGO1007("Dispositivo informado não localizado"),
    CODIGO1008("Dispositivo informado não localizado");
    
    private String descricao;
    
    CodigoResposta(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
}
