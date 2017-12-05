package TACS.controller.dto;

import java.util.Set;

public class MarketingDTO extends DTO {
    private PessoaDTO avaliado;
    private Set<HobbieDTO> alvo;

    public PessoaDTO getAvaliado() {
        return avaliado;
    }

    public void setAvaliado(PessoaDTO avaliado) {
        this.avaliado = avaliado;
    }

    public Set<HobbieDTO> getAlvo() {
        return alvo;
    }

    public void setAlvo(Set<HobbieDTO> alvo) {
        this.alvo = alvo;
    }
}
