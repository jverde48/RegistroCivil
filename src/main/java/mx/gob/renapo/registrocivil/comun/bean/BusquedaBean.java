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
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@Data
@ManagedBean(name = "busquedaBean")
@ViewScoped
@Component
public class BusquedaBean implements Serializable {
    private static Logger log = Logger.getLogger(BusquedaBean.class);

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
    private Integer anioRegistro;

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
}
