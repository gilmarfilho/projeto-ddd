package TACS.marketing;

import TACS.pessoa.PessoaService;
import TACS.hobbies.HobbieDTO;
import TACS.marketing.MarketingDTO;
import TACS.pessoa.PessoaDTO;
import TACS.common.Wrapper;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class MarketingService {
    
    public double espalhamento(MarketingDTO dto) {
        return espalhamento(dto.getAvaliado());
    }
    
    public double espalhamento(PessoaDTO dto){
        Set<Long> passadas;
        passadas = new HashSet<>();
        Queue<Long> aPassar;
        aPassar = new LinkedList<>();
        
        PessoaService service = new PessoaService();
        
        Wrapper<Double> valor = new Wrapper<>(1d);
        Wrapper<Double> total = new Wrapper<>(0d);
        
        PessoaDTO raiz = service.buscar(dto.getId());

        for(int i = 0; i < 3; i++) {
            if(raiz == null) break;
            raiz.getRelacoes().forEach((p) -> {
                if(!passadas.add(p)) return;
                aPassar.add(p);
                total.set(total.get() + valor.get());
            });
            valor.set(valor.get()/2);
            raiz = service.buscar(aPassar.poll());
        }
        
        return total.get();
    }
    
    public double aderencia(MarketingDTO dto) {
        return aderencia(dto.getAvaliado(), dto.getAlvo());
    }
    
    public double aderencia(PessoaDTO dto, Set<HobbieDTO> hobbies){
        
        PessoaService service = new PessoaService();
        PessoaDTO pessoa = service.buscar(dto.getId());
        
        Wrapper<Integer> acertos = new Wrapper(0);
        Wrapper<Integer> erros = new Wrapper(0);

        Set<Long> hobbiesIndex = hobbies
                .parallelStream()
                .map(HobbieDTO::getId)
                .collect(Collectors.toSet());
        
        pessoa.getInteresses().forEach((h) -> {
            if(hobbiesIndex.contains(h)) acertos.set(acertos.get() + 1);
            else erros.set(erros.get() + 1);
        });
                
        hobbiesIndex.forEach((h) -> {
            if(pessoa.getInteresses().contains(h)) acertos.set(acertos.get() + 1);
            else erros.set(erros.get() + 1);
        });

        return (double) acertos.get() / erros.get();
    }
    
    public double marketing(MarketingDTO dto){
        return marketing(dto.getAvaliado(), dto.getAlvo());
    }
    
    public double marketing(PessoaDTO dto, Set<HobbieDTO> hobbies){
        return espalhamento(dto) * aderencia(dto, hobbies);
    }
}
