package mx.gob.renapo.registrocivil.actos.reconocimiento.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.actos.nacimiento.service.NacimientoService;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
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

@ManagedBean(name="consultaActaReconocidoBean")
@ViewScoped
@Data
@Component
@EqualsAndHashCode(callSuper=false)
public class ConsultaActaReconocidoBean implements Serializable {
    private static Logger log = Logger.getLogger(ConsultaActaReconocidoBean.class);
    private static final long serialVersionUID = 1L;

    @Autowired
    private NacimientoService nacimientoService;

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
    private boolean isCadena;
    private boolean isCurp;
    private boolean isDatosPersonales;
    private boolean isNumeroActa;
    private boolean isVacio;

    private List<PersonaDto> listaPersonas;
    private List<CatEstado> listaEstados;
    private List<NacimientoDTO> listaActaNacimientos;

    public void consultaActaReconocidoCadena() {

        System.out.println("CADENA CHIDA" + cadenaValue);
        listaActaNacimientos = nacimientoService.consultaNacimientoPorCadena(cadenaValue);

        System.out.println("Lista Nacimientos: "+ listaActaNacimientos);

    }

    public void consultaActaReconocidoNumeroActa() {

        System.out.println("NUMERO DE ACTA CHIDA");

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

    public void propiedades(){

    }
}
