package mx.gob.renapo.registrocivil.comun.bean;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.showcase.dto.PersonaDto;
import mx.gob.renapo.registrocivil.util.ConsultaInformacionService;
import mx.gob.renapo.registrocivil.util.Utileria;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

@Data
@FacesComponent("busqueda")
public class BusquedaComponent implements Serializable {
    private static Logger log = Logger.getLogger(BusquedaBean.class);

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
    private CatEstado estado;
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

    @PostConstruct
    public void cargaInformacion() {
        setSeleccionBusqueda("Curp");
        setCurp(true);

        if (listaEstados == null)
            listaEstados = new ArrayList<CatEstado>();

        CatEstado estado1 = new CatEstado();
        estado1.setNombre("Guanajuato");
        estado1.setId(1L);
        estado1.setIdRenapo(1L);
        estado1.setMunicipios(null);

        listaEstados.add(estado1);

        estado1 = new CatEstado();
        estado1.setNombre("Durango");
        estado1.setId(2L);
        estado1.setIdRenapo(2L);
        estado1.setMunicipios(null);

        listaEstados.add(estado1);

    }

    public void renderBusqueda() {
        log.info("seleccione: " + seleccionBusqueda);
        if (seleccionBusqueda.equals("Curp")) {
            isCurp = true;
            isCadena = false;
            isDatosPersonales = false;

            //Limpia valores
            sexo = "";
            nombre = "";
            estado = null;
            cadenaValue = "";
            primerApellido = "";
            segundoApellido = "";
            fechaNacimiento = null;
        } else if (seleccionBusqueda.equals("Cadena")) {
            isCurp = false;
            isCadena = true;
            isDatosPersonales = false;

            //Limpia valores
            sexo = "";
            nombre = "";
            estado = null;
            curpValue = "";
            primerApellido = "";
            segundoApellido = "";
            fechaNacimiento = null;
        } else if (seleccionBusqueda.equals("DP")) {
            isCurp = false;
            isCadena = false;
            isDatosPersonales = true;

            //Limpia valores
            curpValue = "";
            cadenaValue = "";
        }
    }

    public void realizarBusqueda() {
        try {
            if (isCurp) {
                consultaInformacionService.consultaPersona("", null, curpValue, cadenaValue);
            } else if (isCadena) {
                consultaInformacionService.consultaPersona("", null, curpValue, cadenaValue);
            } else if (isDatosPersonales) {
                consultaInformacionService.consultaPersona("", Utileria.getDatosPersonales(nombre,
                        primerApellido, segundoApellido, fechaNacimiento, sexo, estado),
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
