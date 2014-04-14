package mx.gob.renapo.registrocivil.actos.adopcion.dto;

import lombok.Data;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AdopcionDTO {

    //La persona que sera adoptada
    @Autowired
    PersonaDTO persona;
    //La persona que es progenitor del adoptado
    @Autowired
    PersonaDTO progenitor;
    //La persona que adopta
    @Autowired
    PersonaDTO adoptante;
    //Abuelos del adoptado
    @Autowired
    PersonaDTO padreUnoProgenitor;
    @Autowired
    PersonaDTO padreDosProgenitor;
    @Autowired
    PersonaDTO padreUnoAdoptante;
    @Autowired
    PersonaDTO padreDosAdoptante;
    @Autowired
    PersonaDTO testigoUno;
    @Autowired
    PersonaDTO testigoDos;

}
