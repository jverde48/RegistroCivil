package mx.gob.renapo.registrocivil.actos.defuncion.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.actos.defuncion.dto.DefuncionDTO;
import mx.gob.renapo.registrocivil.actos.defuncion.service.DefuncionService;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.comun.bean.BusquedaBean;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.showcase.dto.PersonaDto;
import mx.gob.renapo.registrocivil.util.ConsultaInformacionService;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 24/04/14
 * Time: 05:13 PM
 * To change this template use File | Settings | File Templates.
 */


@ManagedBean(name="consultaRegistroDefuncionBean")
@ViewScoped
@Data
@Component
public class ConsultaRegistroDefuncionBean extends BusquedaBean {

    private static Logger log = Logger.getLogger(BusquedaBean.class);
    private static final long serialVersionUID = 1L;

    private DefuncionDTO defuncionDTO;
    private List<DefuncionDTO> listaDefunciones;

    @Autowired
    private DefuncionService defuncionService;

    @PostConstruct
    public void init() {
        setVacio(true);
    }



    public void realizarBusquedaFinado() throws  Exception{
        if (isCadena())
            listaDefunciones = defuncionService.consultaPorCadena(getCadenaValue());
        else if (isNumeroActa())
            listaDefunciones = defuncionService.consultaPorNumeroActa(
                    String.valueOf(getNumeroActaValue()), getAnioRegistro());

        restablecerValoresBusqueda();
    }
    public void renderBusqueda() {
        if (getSeleccionBusqueda().equals("CD")) {
            setVacio(false);
            setCadena(true);
            setNumeroActa(false);
            setNumeroActaValue(null);
            setAnioRegistro(null);

            if (listaDefunciones != null && listaDefunciones.isEmpty())
                listaDefunciones.clear();

        } else if (getSeleccionBusqueda().equals("NA")){
            setVacio(false);
            setCadena(false);
            setNumeroActa(true);
            setCadenaValue("");

            if (listaDefunciones != null && listaDefunciones.isEmpty())
                listaDefunciones.clear();

        } else {
            setVacio(true);
            setCadena(false);
            setNumeroActa(false);

            setCadenaValue("");
            setNumeroActaValue(null);
            setAnioRegistro(null);

            if (listaDefunciones != null && listaDefunciones.isEmpty())
                listaDefunciones.clear();
        }
    }


    public void limpiarTablaResultados() {
        log.info("LIMPIANDO LISTA DE RESULTADOS");
        listaDefunciones.clear();
    }

    private void restablecerValoresBusqueda() {
        setVacio(true);
        setCadena(false);
        setNumeroActa(false);
        setSeleccionBusqueda("SL");

        setCadenaValue("");
        setNumeroActaValue(null);
        setAnioRegistro(null);
    }

    
}
