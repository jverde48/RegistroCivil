package mx.gob.renapo.registrocivil.component;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoService;
import mx.gob.renapo.registrocivil.catalogos.service.CatPaisService;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.service.PersonaService;
import mx.gob.renapo.registrocivil.util.ConsultaInformacionService;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 13/03/14
 * Time: 00:49
 * To change this template use File | Settings | File Templates.
 */

@Data
@Component
@ViewScoped
@ManagedBean(name = "componenteBusqueda")
public class ComponenteBusqueda implements Serializable {
    private static Logger log = Logger.getLogger(ComponenteBusqueda.class);

    private boolean isCurp;
    private boolean isCadena;
    private boolean isDatosPersonales;
    private boolean isSelectRegistro;
    private boolean hasErrors;

    private String curpValue;
    private String cadenaValue;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private String sexo;
    private EstadoDTO estadoNacimiento;
    private String seleccionBusqueda;

    private PersonaDTO personaSeleccionada;
    private List<PersonaDTO> listaBusqueda;
    private List<EstadoDTO> listaEstados;
    private List<String> listaSeleccion;

    @Autowired
    private CatEstadoService estadoService;

    @Autowired
    private CatPaisService paisService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private UtileriaService utileriaService;

    @Autowired
    private ConsultaInformacionService consultaService;

    @PostConstruct
    public void cargarInformacion() {
        listaEstados = estadoService.recuperarPorPais(
                paisService.findMexico());
        listaSeleccion = crearListaSeleccion();
        isSelectRegistro = false;
        hasErrors = false;
    }

    public void actualizarContenido() {
        if (seleccionBusqueda.equals("Seleccione")) {
            isCurp = false;
            isCadena = false;
            isDatosPersonales = false;
            hasErrors = false;

            curpValue = "";
            cadenaValue = "";

            nombre = "";
            primerApellido = "";
            segundoApellido = "";
            fechaNacimiento = null;
            sexo = "";
            estadoNacimiento = null;
        } else {
            if (seleccionBusqueda.equals("Curp")) {
                isCurp = true;
                isCadena = false;
                isDatosPersonales = false;
                hasErrors = false;

                cadenaValue = "";

                nombre = "";
                primerApellido = "";
                segundoApellido = "";
                fechaNacimiento = null;
                sexo = "";
                estadoNacimiento = null;
            } else if (seleccionBusqueda.equals("Cadena")) {
                isCurp = false;
                isCadena = true;
                isDatosPersonales = false;
                hasErrors = false;

                curpValue = "";
                nombre = "";
                primerApellido = "";
                segundoApellido = "";
                fechaNacimiento = null;
                sexo = "";
                estadoNacimiento = null;
            } else {
                isCurp = false;
                isCadena = false;
                isDatosPersonales = true;
                hasErrors = false;

                curpValue = "";
                cadenaValue = "";
            }
        }

        if (listaBusqueda != null)
            listaBusqueda.clear();

        isSelectRegistro = false;
    }

    public void seleccionarRegistro() {
        isSelectRegistro = true;
        log.info("PERSONA: " + personaSeleccionada);
    }

    public void realizarBusqueda() {
        if (isCurp) {
            log.info("REALIZANDO BUSQUEDA DE CURP: " + curpValue);
            if (curpValue != null && !curpValue.isEmpty()) {
                listaBusqueda = personaService.findByCurp(curpValue.toUpperCase());

                if (listaBusqueda == null) {
                    //listaBusqueda = consultaService.consultaPersona("", null, curpValue, null);
                }
            } else
                hasErrors = true;
        } else if (isCadena) {
            log.info("REALIZANDO BUSQUEDA DE CURP: " + cadenaValue);
            if (cadenaValue != null && !cadenaValue.isEmpty()) {
                listaBusqueda = personaService.findByCadena(cadenaValue);

                if (listaBusqueda == null) {
                    //listaBusqueda = consultaService.consultaPersona("", null, "", cadenaValue);
                }
            }  else
                hasErrors = true;
        } else if (isDatosPersonales) {
            log.info("REALIZANDO BUSQUEDA DE CURP: " + nombre);
            if ((nombre != null && !nombre.isEmpty()) &&
                    (primerApellido != null && !primerApellido.isEmpty()) &&
                    (sexo != null && !sexo.isEmpty()) && (fechaNacimiento != null) &&
                    (estadoNacimiento != null)) {
                HashMap<String, Object> datospersonales = utileriaService.getDatosPersonales(
                        nombre.toUpperCase(), primerApellido.toUpperCase(), segundoApellido.toUpperCase(),
                        fechaNacimiento, sexo.toUpperCase(), estadoNacimiento, true);
                listaBusqueda = personaService.findByDatosPersonales(datospersonales);

                if (listaBusqueda == null) {
                    datospersonales = utileriaService.getDatosPersonales(
                            nombre.toUpperCase(), primerApellido.toUpperCase(), segundoApellido.toUpperCase(),
                            fechaNacimiento, sexo.toUpperCase(), estadoNacimiento, false);
                    //listaBusqueda = consultaService.consultaPersona("", datospersonales, null, null);
                }
            } else
                hasErrors = true;
        }
    }

    public void limpiarDialog() {
        log.info("LIMPIANDO DIALOG");
        isCurp = false;
        isCadena = false;
        isSelectRegistro = false;
        isDatosPersonales = false;
        hasErrors = false;

        curpValue = "";
        cadenaValue = "";

        sexo = "";
        nombre = "";
        primerApellido = "";
        segundoApellido = "";
        fechaNacimiento = null;
        estadoNacimiento = null;

        if (listaBusqueda != null)
            listaBusqueda.clear();
        personaSeleccionada = null;
        seleccionBusqueda = "Seleccione";
    }

    private static List<String> crearListaSeleccion() {
        List<String> listaSeleccion = new ArrayList<String>();
        listaSeleccion.add("Seleccione");
        listaSeleccion.add("Curp");
        listaSeleccion.add("Cadena");
        listaSeleccion.add("Datos Personales");
        return listaSeleccion;
    }

    public void asignarValor() {

    }

}
