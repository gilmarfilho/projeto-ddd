package TACS.pessoa;

import TACS.common.DAO;
import TACS.infraestrutura.ProvedorTransacao;
import TACS.pessoa.Pessoa;

public class PessoaDAO extends DAO<Pessoa, Long> {
    
    public PessoaDAO(ProvedorTransacao transacao, Class<Pessoa> clazzP) {
        super(transacao, clazzP);
    }
    
}
