package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import org.apache.log4j.Logger;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.comun.bean.BusquedaBean;

@ManagedBean(name="consultaNacimientoBean")
@ViewScoped
@Data
@EqualsAndHashCode(callSuper=false)
public class ConsultaNacimientoBean extends BusquedaBean implements Serializable {
    private static Logger log = Logger.getLogger(ConsultaNacimientoBean.class);
    private static final long serialVersionUID = 1L;

    private List<PersonaDTO> listaConsultaPersona;
    private PersonaDTO persona;


    public void renderBusqueda() {
        if (getSeleccionBusqueda().equals("CD")) {
            setCurp(false);
            setVacio(false);
            setCadena(true);
            setNumeroActa(false);
            setDatosPersonales(false);
        } else if (getSeleccionBusqueda().equals("NA")){
            setCurp(false);
            setVacio(false);
            setCadena(false);
            setNumeroActa(true);
            setDatosPersonales(false);
        } else {
            setCurp(false);
            setVacio(true);
            setCadena(false);
            setNumeroActa(false);
            setDatosPersonales(false);
        }
    }

    private void restablecerValoresBusqueda() {
        setVacio(true);
        setCadena(false);
        setNumeroActa(false);
        setSeleccionBusqueda("SL");
    }
}