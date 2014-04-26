package mx.gob.renapo.registrocivil.actos.matrimonio.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.service.MatrimonioService;
import mx.gob.renapo.registrocivil.comun.bean.BusquedaBean;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Green4
 * Date: 25/04/14
 * Time: 02:27 AM
 * To change this template use File | Settings | File Templates.
 */

@Data
@Component
@ViewScoped
@ManagedBean(name = "consultaMatrimonioBean")
public class ConsultaMatrimonioBean extends BusquedaBean {
    private static Logger log = Logger.getLogger(ConsultaMatrimonioBean.class);
    private static final long serialVersionUID = 1L;

    private MatrimonioDTO matrimonioDTO;
    private List<MatrimonioDTO> listaMatrimonios;

    @Autowired
    private MatrimonioService matrimonioService;

    @PostConstruct
    public void init() {
        setVacio(true);
    }

    public void realizarBusquedaRegistrado() throws  Exception{
        if (isCadena())
            listaMatrimonios = matrimonioService.consultarPorCadena(getCadenaValue());
        else if (isNumeroActa())
            listaMatrimonios = matrimonioService.consultarPorNumeroActa(
                    String.valueOf(getNumeroActaValue()), getAnioRegistro());

        log.info("Lista Resultados: " + listaMatrimonios);
        restablecerValoresBusqueda();
    }

    public void renderBusqueda() {
        if (getSeleccionBusqueda().equals("CD")) {
            setVacio(false);
            setCadena(true);
            setNumeroActa(false);
        } else if (getSeleccionBusqueda().equals("NA")){
            setVacio(false);
            setCadena(false);
            setNumeroActa(true);
        } else {
            setVacio(true);
            setCadena(false);
            setNumeroActa(false);
        }
    }

    private void restablecerValoresBusqueda() {
        setVacio(true);
        setCadena(false);
        setNumeroActa(false);
        setSeleccionBusqueda("SL");
    }
}
