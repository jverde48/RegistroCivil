package mx.gob.renapo.registrocivil.actos.reconocimiento.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.showcase.dto.PersonaDto;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ReconocimientoDTO;
import mx.gob.renapo.registrocivil.actos.reconocimiento.service.ReconocimientoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@ManagedBean(name="consultaReconocimientoBean")
@ViewScoped
@Data
@Component
@EqualsAndHashCode(callSuper=false)
public class ConsultaReconocimientoBean implements Serializable {
    private static Logger log = Logger.getLogger(ConsultaReconocimientoBean.class);
    private static final long serialVersionUID = 1L;

    @Autowired
    private ReconocimientoService reconocimientoService;

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
    private List<ReconocimientoDTO> listaReconocimientos;

    public void consultaReconocimientoCadena() {

        listaReconocimientos = reconocimientoService.consultaReconocimientoCadena(cadenaValue);

    }

    public void consultaReconocimientoNumeroActa() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        listaReconocimientos = reconocimientoService.consultaReconocimientoNumeroActa(
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
