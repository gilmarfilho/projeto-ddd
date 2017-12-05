package TACS.controller.service;

import TACS.controller.dto.HobbieDTO;
import java.util.stream.Collectors;

import TACS.model.dao.DAO.BlocoAtualizar;
import TACS.model.dao.HobbieDAO;
import TACS.model.dao.TransacaoHibernate;
import TACS.model.domain.Hobbie;
import java.util.Set;

public class HobbieService {

        private final HobbieDAO dao = new HobbieDAO(
                new TransacaoHibernate(),Hobbie.class);
        
	public HobbieDTO criar(final HobbieDTO dto) {
            Hobbie nova = HobbieDTO.converterDTO(dto);
            return HobbieDTO.converterDominio(nova);
	}
        
        public HobbieDTO buscar(final long id) {
            Hobbie p = dao.buscaUm(id);
            return HobbieDTO.converterDominio(p);
        }
        
        public Set<HobbieDTO> listar() {
            return dao
                .buscarTodos()
                .parallelStream()
                .map(HobbieDTO::converterDominio)
                .collect(Collectors.toSet());
        }
        
        public HobbieDTO atualizar(final HobbieDTO dto) {
            BlocoAtualizar<Hobbie> atualizacao = (entidade) -> {
                return HobbieDTO.converterDTO(dto);
            };
            
            dao.atualizar(atualizacao, dto.getId());
            return dto;
        }
        
        public HobbieDTO remover(final HobbieDTO dto) {
            dao.deletar(HobbieDTO.converterDTO(dto));
            return dto;
        }
}