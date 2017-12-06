package TACS.pessoa;

import TACS.common.DTO;
import TACS.hobbies.HobbieDAO;
import TACS.pessoa.PessoaDAO;
import TACS.infraestrutura.TransacaoHibernate;
import TACS.pessoa.Pessoa;
import TACS.hobbies.Hobbie;
import java.util.Set;
import java.util.stream.Collectors;

public class PessoaDTO extends DTO<Pessoa> {

    private Long id;

    private Set<Long> relacoes;

    private Set<Long> interesses;
 
    public static PessoaDTO converterDominio(Pessoa p) {
        PessoaDTO dto = new PessoaDTO();
        dto.id = p.getId();
        dto.relacoes = p
                .getRelacoes()
                .parallelStream()
                .map(Pessoa::getId)
                .collect(Collectors.toSet());
        dto.interesses = p
                .getInteresses()
                .parallelStream()
                .map(Hobbie::getId)
                .collect(Collectors.toSet());
        return dto;
    }
    
    public static Pessoa converterDTO(PessoaDTO p) {
        PessoaDAO dao = new PessoaDAO(
                new TransacaoHibernate(),
                Pessoa.class);
        
        Set<Pessoa> relacoes = p
                .getInteresses()
                .parallelStream()
                .map(dao::buscaUm)
                .collect(Collectors.toSet());

        HobbieDAO hobbieDao = new HobbieDAO(
        new TransacaoHibernate(), Hobbie.class);

        Set<Hobbie> interesses = p
                .getInteresses()
                .parallelStream()
                .map(hobbieDao::buscaUm)
                .collect(Collectors.toSet());
        
        return new Pessoa(relacoes, interesses);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Long> getRelacoes() {
        return relacoes;
    }

    public void setRelacoes(Set<Long> relacoes) {
        this.relacoes = relacoes;
    }

    public Set<Long> getInteresses() {
        return interesses;
    }

    public void setInteresses(Set<Long> interesses) {
        this.interesses = interesses;
    }
}
