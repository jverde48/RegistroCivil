package mx.gob.renapo.registrocivil.actos.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.common.beans.BusquedaBean;
import mx.gob.renapo.registrocivil.common.beans.PersonaBean;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;

@ManagedBean(name="consultaNacimientoBean")
@ViewScoped
@Data
@EqualsAndHashCode(callSuper=false)
public class ConsultaRegistroBean extends BusquedaBean implements Serializable {
    private static Logger log = Logger.getLogger(ConsultaRegistroBean.class);
    private static final long serialVersionUID = 1L;

    private List<String> listaBusqueda;
    private List<PersonaBean> listaConsultaPersona;
    
    @PostConstruct
    public void cargarInformacion() {
        //listaBusqueda = ConstantesComunes.LISTA_BUSQUEDA_NACIMIENTO;
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
}
