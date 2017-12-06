package TACS.hobbies;

import TACS.common.Entidade;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Hobbie extends Entidade {

    public Hobbie(long id) {
        super(id);
    }

    public Hobbie() {
        
    }
}
