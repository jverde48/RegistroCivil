package mx.gob.renapo.registrocivil.showcase.beans;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Data;
import mx.gob.renapo.registrocivil.entity.CatEstado;
import mx.gob.renapo.registrocivil.showcase.dto.PersonaDto;

@Data
public abstract class BusquedaBean {
    /*
     * Para busqueda por curp
     */
    private String curpValue;
    
    /*
     * Para busqueda por cadena
     */
    private Long cadenaValue;
    
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
     * Para saber cual busqueda eligio
     */
    private boolean isCurp;
    private boolean isCadena;
    private boolean isDatosPersonales;
    
    private List<PersonaDto> listaPersonas;
    private List<CatEstado> listaEstados;
    
    private Pattern pattern;
    private Matcher matcher;
}
