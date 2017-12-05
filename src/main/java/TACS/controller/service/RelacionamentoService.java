/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TACS.controller.service;

import TACS.controller.dto.PessoaDTO;
import TACS.controller.dto.RelacaoDTO;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author eddyosos
 */
public class RelacionamentoService {
    public PessoaDTO relacionar(RelacaoDTO dto) {
        return relacionar(
                dto.getRelacionante().getId(), 
                dto.getRelacionada().getId());
    }
    
    public PessoaDTO relacionar(PessoaDTO relacionante, PessoaDTO relacionada) {
        return relacionar(relacionante.getId(), relacionada.getId());
    }
    
    public PessoaDTO relacionar(long relacionante, long relacionada) {
        PessoaService service = new PessoaService();
        
        PessoaDTO relacionanteDTO = service.buscar(relacionante);
        Set<Long> relacionamentos = new HashSet<>(relacionanteDTO.getRelacoes());
        relacionamentos.add(relacionada);
        relacionanteDTO.setRelacoes(relacionamentos);
        
        return service.atualizar(relacionanteDTO);
    }
    
    public PessoaDTO desrelacionar(RelacaoDTO dto) {
        return desrelacionar(
                dto.getRelacionante().getId(), 
                dto.getRelacionada().getId());
    }
    
    public PessoaDTO desrelacionar(PessoaDTO relacionante, PessoaDTO relacionada) {
        return desrelacionar(relacionante.getId(), relacionada.getId());
    }
    
    public PessoaDTO desrelacionar(long relacionante, long relacionada) {
        PessoaService service = new PessoaService();
        
        PessoaDTO relacionanteDTO = service.buscar(relacionante);
        Set<Long> relacionamentos = new HashSet<>(relacionanteDTO.getRelacoes());
        relacionamentos.remove(relacionada);
        relacionanteDTO.setRelacoes(relacionamentos);
        
        return service.atualizar(relacionanteDTO);
    }
   
}
