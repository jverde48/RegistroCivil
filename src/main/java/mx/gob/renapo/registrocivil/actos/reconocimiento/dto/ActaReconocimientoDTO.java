package mx.gob.renapo.registrocivil.actos.reconocimiento.dto;


import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatParentescoDTO;
import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class ActaReconocimientoDTO extends ActaDTO {

    @Autowired
    private CatParentescoDTO parentescoTestigoUno;
    @Autowired
    private CatParentescoDTO parentescoTestigoDos;

    private CatParentescoDTO parentescoOtorgaConsentimiento;

    private String ocupacionTestigoUno;

    private String ocupacionTestigoDos;

}
