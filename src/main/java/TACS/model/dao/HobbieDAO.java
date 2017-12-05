package TACS.model.dao;

import TACS.model.domain.Hobbie;

public class HobbieDAO extends DAO<Hobbie, Long>{

    public HobbieDAO(ProvedorTransacao transacao, Class<Hobbie> clazzP) {
        super(transacao, clazzP);
    }
    
}
