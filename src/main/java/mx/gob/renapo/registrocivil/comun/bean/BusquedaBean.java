package mx.gob.renapo.registrocivil.comun.bean;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.showcase.dto.PersonaDto;
import mx.gob.renapo.registrocivil.util.ConsultaInformacionService;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@Data
@ManagedBean(name = "busquedaBean")
@ViewScoped
public class BusquedaBean implements Serializable {
    private static Logger log = Logger.getLogger(BusquedaBean.class);

    @Autowired
    private UtileriaService utileriaService;

    @ManagedProperty(value = "#{consultaInformacionService}")
    private ConsultaInformacionService consultaInformacionService;

    /*
     * Para busqueda por curp
     */
    private String curpValue;
    
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
     */
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private EstadoDTO estado;
    private String sexo;
    
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
    private boolean isCurp;
    private boolean isCadena;
    private boolean isDatosPersonales;
    private boolean isNumeroActa;
    private boolean isVacio;
    
    private List<PersonaDto> listaPersonas;
    private List<CatEstado> listaEstados;

    public void realizarBusqueda() {
        try {
            if (isCurp) {
                consultaInformacionService.consultaPersona("", null, curpValue, cadenaValue);
            } else if (isCadena) {
                consultaInformacionService.consultaPersona("", null, curpValue, cadenaValue);
            } else if (isDatosPersonales) {
                consultaInformacionService.consultaPersona("", utileriaService.getDatosPersonales(nombre,
                        primerApellido, segundoApellido, fechaNacimiento, sexo, estado, false),
                        curpValue, cadenaValue.toString());
            }
        } catch (NoSuchAlgorithmException nae) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,"Error de Consulta al WS", nae.getMessage()));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,"Excepciones de Aplicativo", e.getMessage()));
            e.printStackTrace();
        }
    }

}
