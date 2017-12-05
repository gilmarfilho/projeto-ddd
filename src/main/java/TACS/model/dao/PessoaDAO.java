package TACS.model.dao;

import TACS.model.domain.Pessoa;

public class PessoaDAO extends DAO<Pessoa, Long> {
    
    public PessoaDAO(ProvedorTransacao transacao, Class<Pessoa> clazzP) {
        super(transacao, clazzP);
    }
    
}
