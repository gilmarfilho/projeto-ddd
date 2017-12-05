package TACS.controller.service;

import TACS.controller.dto.PessoaDTO;
import java.util.stream.Collectors;

import TACS.model.dao.DAO.BlocoAtualizar;
import TACS.model.dao.PessoaDAO;
import TACS.model.dao.TransacaoHibernate;
import TACS.model.domain.Pessoa;
import java.util.Set;

public class PessoaService {

        private final PessoaDAO dao = new PessoaDAO(
                new TransacaoHibernate(),Pessoa.class);
        
	public PessoaDTO criar(final PessoaDTO dto) {
            Pessoa nova = PessoaDTO.converterDTO(dto);
            return PessoaDTO.converterDominio(dao.criar(nova));
	}
        
        public PessoaDTO buscar(final long id) {
            Pessoa p = dao.buscaUm(id);
            return PessoaDTO.converterDominio(p);
        }
        
        public Set<PessoaDTO> listar() {
            return dao
                .buscarTodos()
                .parallelStream()
                .map(PessoaDTO::converterDominio)
                .collect(Collectors.toSet());
        }
        
        public PessoaDTO atualizar(final PessoaDTO dto) {
            BlocoAtualizar<Pessoa> atualizacao = (entidade) -> {
                return PessoaDTO.converterDTO(dto);
            };
            
            dao.atualizar(atualizacao, dto.getId());
            return dto;
        }
        
        public PessoaDTO remover(final PessoaDTO dto) {
            dao.deletar(PessoaDTO.converterDTO(dto));
            return dto;
        }
}
