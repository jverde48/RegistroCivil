package mx.gob.renapo.registrocivil.showcase.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.showcase.dto.PersonaDto;

@ManagedBean(name="registroBean")
@ViewScoped
@Data
@EqualsAndHashCode(callSuper=false)
public class RegistroBean extends BusquedaBean implements Serializable {
    private Integer id;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String calle;
    private Integer numeroInterior;
    private Integer numeroExterior;
    private String colonia;
    private String municipio;
    
    private List<String> listaMunicipios;
    private List<String> listaBusqueda;
    private List<PersonaDto> listaRegistro;
    private PersonaDto personaSeleccionada;

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(RegistroBean.class);
    
    @PostConstruct
    public void cargaInformacion() {
        setSeleccionBusqueda("Curp");
        setCurp(true);
    }
    
    public void renderBusqueda() {
        log.info("En Metodo renderBusqueda. Seleccino: " + getSeleccionBusqueda());
        if (getSeleccionBusqueda().equals("Curp")) {
            log.info("entro en curp");
            setCurp(true);
            setCadena(false);
            setDatosPersonales(false);
        } else if (getSeleccionBusqueda().equals("Cadena")) {
            log.info("entro en cadena");
            setCurp(false);
            setCadena(true);
            setDatosPersonales(false);
        } else if (getSeleccionBusqueda().equals("DP")) {
            log.info("entro en datos");
            setCurp(false);
            setCadena(false);
            setDatosPersonales(true);
        }
    }
    
    public void realizarBusqueda() {
        log.info("En Metodo realizarBusqueda");
        log.info("Is curp: " + isCurp());
        log.info("is Cadena: " + isCadena());
        log.info("is Datos personales " + isDatosPersonales());
        log.info("-------------------- " + getCurpValue());
        log.info("-------------------- " + getCadenaValue());
        
        if (isCurp()) {

        } else if (isCadena()) {
            
        } else if (isDatosPersonales()) {
            
        }
    }
    
    public void validateCurp(FacesContext faces, UIComponent uiComponen, Object value) {
        log.info("Si llego a vlidar la curp");
        if(((String) value).length() < 18) {
            FacesMessage msg = new FacesMessage("Curp: La logitud de la Curp debe ser de 18 caracteres", "");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
