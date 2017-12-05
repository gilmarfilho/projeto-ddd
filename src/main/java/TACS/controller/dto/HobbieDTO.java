package TACS.controller.dto;

import TACS.model.domain.Hobbie;

public class HobbieDTO extends DTO<Hobbie>{
    private Long id;
    
    public static HobbieDTO converterDominio(Hobbie dominio){
        HobbieDTO dto = new HobbieDTO();
        dto.id = dominio.getId();
        return dto;
    }
    
    public static Hobbie converterDTO(HobbieDTO dto){
        Long id = dto.getId();
        return new Hobbie(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
