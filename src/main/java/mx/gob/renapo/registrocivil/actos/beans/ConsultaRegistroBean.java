package mx.gob.renapo.registrocivil.actos.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.common.beans.BusquedaBean;
import mx.gob.renapo.registrocivil.common.beans.PersonaBean;

@ManagedBean(name="consultaNacimientoBean")
@ViewScoped
@Data
@EqualsAndHashCode(callSuper=false)
public class ConsultaRegistroBean extends BusquedaBean implements Serializable {
    private static Logger log = Logger.getLogger(ConsultaRegistroBean.class);
    private static final long serialVersionUID = 1L;
    
    private List<PersonaBean> listaConsultaPersona;
    private PersonaBean persona;
    
    @PostConstruct
    public void cargarInformacion() {
        setVacio(true);
        if (listaConsultaPersona == null)
            listaConsultaPersona = new ArrayList<PersonaBean>();
        
        persona = new PersonaBean();
    }
    
    public void realizarBusquedaRegistrado() {
        log.info("Tipo Busqueda :::::: " + getTipoBusqueda());

        persona.setNombre("JESUS ARMANDO");
        persona.setPrimerApellido("VERDE");
        persona.setSegundoApellido("MARTINES");
        persona.setFechaNacimiento(new Date());
        persona.setEntidadNAcimiento(1);
        persona.setCurp("VEMJ910503HGTRRS01");
        
        if (!listaConsultaPersona.contains(persona))
            listaConsultaPersona.add(persona);
        
        restablecerValoresBusqueda();
    }
    
    public void renderBusqueda() {
        if (getSeleccionBusqueda().equals("CR")) {
            setCurp(true);
            setVacio(false);
            setCadena(false);
            setNumeroActa(false);
            setDatosPersonales(false);
        } else if (getSeleccionBusqueda().equals("CD")) {
            setCurp(false);
            setVacio(false);
            setCadena(true);
            setNumeroActa(false);
            setDatosPersonales(false);
        } else if (getSeleccionBusqueda().equals("DP")) {
            setCurp(false);
            setVacio(false);
            setCadena(false);
            setNumeroActa(false);
            setDatosPersonales(true);
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
        setCurp(false);
        setVacio(true);
        setCadena(false);
        setNumeroActa(false);
        setDatosPersonales(false);
        setSeleccionBusqueda("SL");
    }
}
