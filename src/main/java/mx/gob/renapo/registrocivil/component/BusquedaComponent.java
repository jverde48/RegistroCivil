package mx.gob.renapo.registrocivil.component;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.util.dto.PersonaDTO;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
@ViewScoped
@ManagedBean(name = "componenteBusqueda")
public class BusquedaComponent {
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
    private String estadoNacimiento;
    private String seleccionBusqueda;

    private PersonaDTO personaSeleccionada;
    private List<PersonaDTO> listaBusqueda;
    private List<CatEstado> listaEstados;
    private List<String> listaSeleccion;

    @PostConstruct
    public void cargarInformacion() {
        if (listaEstados == null)
            listaEstados = new ArrayList<CatEstado>();

        CatEstado estado = new CatEstado();
        estado.setDescripcion("Guadalajara");
        estado.setId(1L);
        estado.setIdRenapo(1L);
        estado.setMunicipios(null);
        listaEstados.add(estado);

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
            estadoNacimiento = "";
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
                estadoNacimiento = "";
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
                estadoNacimiento = "";
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
        log.info("-------- " + isSelectRegistro);
        isSelectRegistro = true;
        log.info("-------- " + isSelectRegistro);

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

        PersonaDTO persona1 = new PersonaDTO();
        persona1.setNombre("JESUS");
        persona1.setPrimerApellido("VERDE");
        persona1.setSegundoApellido("MARTINEZ");
        persona1.setSexo("MASCULINO");
        persona1.setFechaNacimiento(new Date());
        persona1.setEstadoNacimiento("GUANAJUATO");
        persona1.setCurp("VEMJ910503HGTRRS01");

        listaBusqueda.add(persona1);
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
        estadoNacimiento = "";

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
