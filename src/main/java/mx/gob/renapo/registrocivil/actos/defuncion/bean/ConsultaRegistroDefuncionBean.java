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
public class ConsultaRegistroDefuncionBean implements Serializable {
    private static Logger log = Logger.getLogger(BusquedaBean.class);

    @Autowired
    private DefuncionService defuncionService;

    /*
     * Para busqueda por curp
     
    private String curpValue;
    */
    /*
     * Para busqueda por cadena
     */
    private String cadenaValue;

    /*
     * Para busqueda por numero de Acta
     */
    private Long numeroActaValue;

    /*
     * Para busqueda por datos personales
     
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private EstadoDTO estado;
    private String sexo;
    */
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
    private List<DefuncionDTO> listaDefunciones;

    public void realizarBusqueda() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        if (isCadena)
            listaDefunciones = defuncionService.consultaDefuncionPorCadena(cadenaValue);
        else if (isNumeroActa)
            listaDefunciones = defuncionService.consultaDefuncionPorNumeroActa(
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
