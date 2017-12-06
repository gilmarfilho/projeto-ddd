package TACS.interesse;

import TACS.pessoa.PessoaService;
import TACS.hobbies.HobbieDTO;
import TACS.pessoa.PessoaDTO;
import java.util.HashSet;
import java.util.Set;

public class InteresseService {
    public PessoaDTO interessa(PessoaDTO interessada, HobbieDTO interesse) {
        return interessa(interessada.getId(), interesse.getId());
    }
    
    public PessoaDTO interessa(InteresseDTO dto) {
        return interessa(
                dto.getInteressada().getId(), 
                dto.getInteresse().getId());
    }
    
    public PessoaDTO interessa(long interessada, long interesse) {
        PessoaService service = new PessoaService();
        
        PessoaDTO interessadaDTO = service.buscar(interessada);
        Set<Long> interesses = new HashSet<>(interessadaDTO.getInteresses());
        interesses.add(interesse);
        interessadaDTO.setInteresses(interesses);
        
        return service.atualizar(interessadaDTO);
    }
    
    public PessoaDTO desInteressa(InteresseDTO dto) {
        return desInteressa(
                dto.getInteressada().getId(), 
                dto.getInteresse().getId());
    }
    
    public PessoaDTO desInteressa(PessoaDTO desinteressada, HobbieDTO interesse) {
        return desInteressa(desinteressada.getId(), interesse.getId());
    }
    
    public PessoaDTO desInteressa(long desinteressada, long interesse) {
        PessoaService service = new PessoaService();
        
        PessoaDTO interessadaDTO = service.buscar(desinteressada);
        Set<Long> interesses = new HashSet<>(interessadaDTO.getInteresses());
        interesses.add(interesse);
        interessadaDTO.setInteresses(interesses);
        
        return service.atualizar(interessadaDTO);
    }
}
