package mx.gob.renapo.registrocivil.component;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoService;
import mx.gob.renapo.registrocivil.util.dto.PersonaDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class BusquedaComponent implements Serializable {
    private static Logger log = Logger.getLogger(BusquedaComponent.class);

    private boolean isCurp;
    private boolean isCadena;
    private boolean isDatosPersonales;
    private boolean isSelectRegistro;

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

    @PostConstruct
    public void cargarInformacion() {
        if (listaEstados == null)
            listaEstados = new ArrayList<EstadoDTO>();
        //listaEstados = estadoService.findAll();

        listaSeleccion = crearListaSeleccion();

        if (listaBusqueda == null)
            listaBusqueda = new ArrayList<PersonaDTO>();

        isSelectRegistro = false;
    }

    public void actualizarContenido() {
        if (seleccionBusqueda.equals("Seleccione")) {
            isCurp = false;
            isCadena = false;
            isDatosPersonales = false;

            curpValue = "";
            cadenaValue = "";

            nombre = "";
            primerApellido = "";
            segundoApellido = "";
            fechaNacimiento = null;
            sexo = "";
            estadoNacimiento = null;
            listaBusqueda.clear();
        } else {
            if (seleccionBusqueda.equals("Curp")) {
                isCurp = true;
                isCadena = false;
                isDatosPersonales = false;
                listaBusqueda.clear();

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
                listaBusqueda.clear();

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

                curpValue = "";
                cadenaValue = "";
                listaBusqueda.clear();
            }
        }
    }

    public void seleccionarRegistro() {
        isSelectRegistro = true;

        log.info("Persona seleccionada " + personaSeleccionada == null);
        if (personaSeleccionada != null) {
            log.info("nombre" + personaSeleccionada.getNombre());
            log.info("primer apellido" + personaSeleccionada.getPrimerApellido());
            log.info("segundo apellido" + personaSeleccionada.getSegundoApellido());
        }
    }

    public void realizarBusqueda() {
        if (isCurp) {

        } else if (isCadena) {

        } else if (isDatosPersonales) {

        }
    }

    public void limpiarDialog() {
        isCurp = false;
        isCadena = false;
        isSelectRegistro = false;
        isDatosPersonales = false;

        curpValue = "";
        cadenaValue = "";

        sexo = "";
        nombre = "";
        primerApellido = "";
        segundoApellido = "";
        fechaNacimiento = null;
        estadoNacimiento = null;

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

}
