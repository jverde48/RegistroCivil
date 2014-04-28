package mx.gob.renapo.registrocivil.actos.adopcion.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.adopcion.dto.AdopcionDTO;
import mx.gob.renapo.registrocivil.actos.adopcion.service.AdopcionService;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.showcase.dto.PersonaDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@ManagedBean(name="consultaRegistroAdopcionBean")
@ViewScoped
@Data
@Component
public class ConsultaRegistroAdopcionBean implements Serializable {

    private static Logger log = Logger.getLogger(ConsultaRegistroAdopcionBean.class);

    @Autowired
    AdopcionService adopcionService;

    /*
     * Para busqueda por cadena
     */
    private String cadenaValue;

    /*
     * Para busqueda por numero de Acta
     */
    private Long numeroActaValue;

    /*
     * Para buscar por la seleccion elegida
     */
    private String seleccionBusqueda;

    /*
     * Para saber que tipo de busqueda se realiza
     * Puede Aplicar para todos los actos
     */
    private String tipoBusqueda;

    /*
     * Para saber cual busqueda eligio
     */
    private boolean isCadena;
    private boolean isNumeroActa;
    private boolean isVacio;

    private List<PersonaDto> listaPersonas;
    private List<CatEstado> listaEstados;
    private List<AdopcionDTO> listaAdopciones;

    public void realizarBusqueda() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        if (isCadena)
            listaAdopciones = adopcionService.consultaAdopcionPorCadena(cadenaValue);
        else if (isNumeroActa)
            listaAdopciones = adopcionService.consultaAdopcionPorNumeroActa(
                    calendar.get(Calendar.YEAR), String.valueOf(numeroActaValue));
    }


    public void renderBusqueda() {
        if (seleccionBusqueda.equals("CD")) {
            setVacio(false);
            setCadena(true);
            setNumeroActa(false);
        } else if (seleccionBusqueda.equals("NA")){
            setVacio(false);
            setCadena(false);
            setNumeroActa(true);
        } else {
            setVacio(true);
            setCadena(false);
            setNumeroActa(false);
        }
    }


}
