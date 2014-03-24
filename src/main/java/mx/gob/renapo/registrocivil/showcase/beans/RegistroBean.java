package mx.gob.renapo.registrocivil.showcase.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.comun.bean.BusquedaBean;
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
        if (getSeleccionBusqueda().equals("Curp")) {
            setCurp(true);
            setCadena(false);
            setDatosPersonales(false);
        } else if (getSeleccionBusqueda().equals("Cadena")) {
            setCurp(false);
            setCadena(true);
            setDatosPersonales(false);
        } else if (getSeleccionBusqueda().equals("DP")) {
            setCurp(false);
            setCadena(false);
            setDatosPersonales(true);
        }
    }
    
    public void realizarBusqueda() {
        if (isCurp()) {

        } else if (isCadena()) {

        } else if (isDatosPersonales()) {

        }
    }
}
