
package TACS.controller.dto;

public class RelacaoDTO extends DTO {
    private PessoaDTO relacionante;
    private PessoaDTO relacionada;

    public PessoaDTO getRelacionante() {
        return relacionante;
    }

    public void setRelacionante(PessoaDTO relacionante) {
        this.relacionante = relacionante;
    }

    public PessoaDTO getRelacionada() {
        return relacionada;
    }

    public void setRelacionada(PessoaDTO relacionada) {
        this.relacionada = relacionada;
    }
}
