/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TACS.controller.dto;

/**
 *
 * @author eddyosos
 */
public class InteresseDTO extends DTO {
    private HobbieDTO interesse;
    private PessoaDTO interessada;

    public HobbieDTO getInteresse() {
        return interesse;
    }

    public void setInteresse(HobbieDTO interesse) {
        this.interesse = interesse;
    }

    public PessoaDTO getInteressada() {
        return interessada;
    }

    public void setInteressada(PessoaDTO interessada) {
        this.interessada = interessada;
    }
    
    
}
