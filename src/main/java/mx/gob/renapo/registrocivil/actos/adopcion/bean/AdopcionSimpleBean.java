package mx.gob.renapo.registrocivil.actos.adopcion.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.adopcion.dto.AdopcionDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;


@Data
@Component
@ViewScoped
@ManagedBean(name = "adopcionSimpleBean")
public class AdopcionSimpleBean implements Serializable {

    private static Logger logger = Logger.getLogger(AdopcionSimpleBean.class);
    //La persona que sera adoptada
    PersonaDTO persona;
    //La persona que es progenitor del adoptado
    PersonaDTO progenitor;
    //La persona que adopta
    PersonaDTO adoptante;
    boolean mostrarDatosAdoptado;
    @Autowired
    AdopcionDTO adopcionDTO;


    //En caso de que se registren los abuelos del adoptado
    private Boolean existenciaAbueloUnoProgenitor;
    private Boolean existenciaAbueloDosProgenitor;
    private Boolean existenciaAbueloUnoAdoptante;
    private Boolean existenciaAbueloDosAdoptante;

    @PostConstruct
    public void init() {
        persona = new PersonaDTO();
        progenitor = new PersonaDTO();
        adoptante =  new PersonaDTO();
    }
    public void onRowSelect() {
        mostrarDatosAdoptado = true;
        //Se debe buscar el progenitor del adoptado
    }
}
