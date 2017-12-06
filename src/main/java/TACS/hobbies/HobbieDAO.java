package TACS.hobbies;

import TACS.common.DAO;
import TACS.infraestrutura.ProvedorTransacao;

public class HobbieDAO extends DAO<Hobbie, Long>{

    public HobbieDAO(ProvedorTransacao transacao, Class<Hobbie> clazzP) {
        super(transacao, clazzP);
    }
    
}
