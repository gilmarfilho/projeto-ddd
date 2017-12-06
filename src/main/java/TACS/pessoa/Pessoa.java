package TACS.pessoa;

import TACS.hobbies.Hobbie;
import TACS.common.Entidade;
import TACS.infraestrutura.ExcecaoNegocio;
import static TACS.common.UtilValidacao.valida;
import java.util.Collections;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pessoa extends Entidade {
    
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Pessoa> relacoes;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Hobbie> interesses;

    /**
     * JPA/Hibernate backdoor
     */
    public Pessoa(){}
    
    public Pessoa(
            Set<Pessoa> relacoes, 
            Set<Hobbie> interesses) {
        validacoes(relacoes, interesses);
    }

     public Pessoa(
            Set<Pessoa> relacoes, 
            Set<Hobbie> interesses,
            long id) {
        super(id);
        validacoes(relacoes, interesses);
    }
    
    private void validacoes(Set<Pessoa> relacoes, Set<Hobbie> interesses) {
        this.relacoes = valida(relacoes, () -> {
            throw new ExcecaoNegocio(
                    10,
                    "Pessoa relacoes", 
                    "Relacoes nula ou inválida.");
        });
        this.interesses = valida(interesses, () -> {
            throw new ExcecaoNegocio(
                    10,
                    "Pessoa interesses", 
                    "Interesses nulo ou inválido.");
        });
    }

    public Set<Pessoa> getRelacoes() {
        return Collections.unmodifiableSet(relacoes);
    }

    public Set<Hobbie> getInteresses() {
        return Collections.unmodifiableSet(interesses);
    }
}
