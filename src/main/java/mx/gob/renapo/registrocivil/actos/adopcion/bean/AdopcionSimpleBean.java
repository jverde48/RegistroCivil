package mx.gob.renapo.registrocivil.actos.adopcion.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;


@Data
@Component
@ViewScoped
@ManagedBean(name = "adopcionSimpleBean")
public class AdopcionSimpleBean extends AdopcionPrincipalBean implements Serializable {

    private static Logger logger = Logger.getLogger(AdopcionSimpleBean.class);

    boolean mostrarDatosAdoptado;


    @PostConstruct
    public void init() {
        setPaises(getPaisService().findAll());
        setPaisesInegi(getInegiPaisService().findAll());
        setTipoLocalidadList(getTipoLocalidadService().findAll());
        setEstadoCivilList(getEstadoCivilService().findAll());
        getAdopcionDTO().getPersona().setPaisNacimiento(getPaisService().findMexico());

        if(getEstadoCivilList()!=null) {
            for(CatEstadoCivilDTO estadoCivil: getEstadoCivilList()) {
                if(estadoCivil.getDescripcion().equals("Soltero")) {
                    getAdopcionDTO().getPersona().setEstadoCivil(estadoCivil);
                    break;
                }
            }
        }

        setEstadosAdoptado(getEstadoService().recuperarPorPais
                (getAdopcionDTO().getPersona().getPaisNacimiento()));

        //TODO Datos de prueba
        /*getAdopcionDTO().getPersona().setCurp("VEMJ910503HGTRRS01");
        getAdopcionDTO().getPersona().setCadenaNacimiento("34324334333324233243");
        getAdopcionDTO().getPersona().setNombre("eqewqWqwq");
        getAdopcionDTO().getPersona().setPrimerApellido("ERWRE");
        getAdopcionDTO().getPersona().setSegundoApellido("EDQWDWQ");
        getAdopcionDTO().getPersona().setFechaNacimientoInc("Enero");
        getAdopcionDTO().getPersona().getDomicilio().setCalle("IJEDR");
        getAdopcionDTO().getPersona().getDomicilio().setCodigoPostal("09700");
        getAdopcionDTO().getPersona().getDomicilio().setColonia("WQDWQD");
        getAdopcionDTO().getPersona().getDomicilio().setNumeroExterior("2323");
        getAdopcionDTO().getPersona().getDomicilio().setNumeroInteror("432");

        getAdopcionDTO().getActaAdopcionAdopDTO().getEntidadRegistro().setNombreEstado("ERWREW");
        getAdopcionDTO().getActaAdopcionAdopDTO().getMunicipioRegistro().setNombreMunicipio("MOIO");
        getAdopcionDTO().getActaAdopcionAdopDTO().getLocalidadRegistro().setNombreLocalidad("Queretaro");
        getAdopcionDTO().getActaAdopcionAdopDTO().getOficialia().setNombreOficialia("HOLA");

        getAdopcionDTO().getProgenitor().setCurp("VEMJ910503HGTRRS01");
        getAdopcionDTO().getProgenitor().setCadenaNacimiento("32423324334324334333");
        getAdopcionDTO().getProgenitor().setNombre("Wqwqeqewq");
        getAdopcionDTO().getProgenitor().setPrimerApellido("ERWRE");
        getAdopcionDTO().getProgenitor().setSegundoApellido("EDQWDWQ");
        getAdopcionDTO().getProgenitor().setFechaNacimientoInc("Enero");
        getAdopcionDTO().getProgenitor().getDomicilio().setCalle("IJEDR");
        getAdopcionDTO().getProgenitor().getDomicilio().setCodigoPostal("09700");
        getAdopcionDTO().getProgenitor().getDomicilio().setColonia("WQDWQD");
        getAdopcionDTO().getProgenitor().getDomicilio().setNumeroExterior("2323");
        getAdopcionDTO().getProgenitor().getDomicilio().setNumeroInteror("432");

        getAdopcionDTO().getAdoptante().setCurp("VEMJ910503HGTRRS01");
        getAdopcionDTO().getAdoptante().setCadenaNacimiento("32423324334324334333");
        getAdopcionDTO().getAdoptante().setNombre("eqewqWqwq");
        getAdopcionDTO().getAdoptante().setPrimerApellido("ERWRE");
        getAdopcionDTO().getAdoptante().setSegundoApellido("EDQWDWQ");
        getAdopcionDTO().getAdoptante().setFechaNacimientoInc("Enero");
        getAdopcionDTO().getAdoptante().getDomicilio().setCalle("IJEDR");
        getAdopcionDTO().getAdoptante().getDomicilio().setCodigoPostal("09700");
        getAdopcionDTO().getAdoptante().getDomicilio().setColonia("WQDWQD");
        getAdopcionDTO().getAdoptante().getDomicilio().setNumeroExterior("2323");
        getAdopcionDTO().getAdoptante().getDomicilio().setNumeroInteror("432");

        getAdopcionDTO().getTestigoUno().setCurp("VEMJ910503HGTRRS01");
        getAdopcionDTO().getTestigoUno().setCadenaNacimiento("42332433432433433332");
        getAdopcionDTO().getTestigoUno().setNombre("eqewqWqwq");
        getAdopcionDTO().getTestigoUno().setPrimerApellido("ERWRE");
        getAdopcionDTO().getTestigoUno().setSegundoApellido("EDQWDWQ");
        getAdopcionDTO().getTestigoUno().setFechaNacimientoInc("Enero");
        getAdopcionDTO().getTestigoUno().getDomicilio().setCalle("IJEDR");
        getAdopcionDTO().getTestigoUno().getDomicilio().setCodigoPostal("09700");
        getAdopcionDTO().getTestigoUno().getDomicilio().setColonia("WQDWQD");
        getAdopcionDTO().getTestigoUno().getDomicilio().setNumeroExterior("2323");
        getAdopcionDTO().getTestigoUno().getDomicilio().setNumeroInteror("432");

        getAdopcionDTO().getTestigoDos().setCurp("VEMJ910503HGTRRS01");
        getAdopcionDTO().getTestigoDos().setCadenaNacimiento("33432433433332423324");
        getAdopcionDTO().getTestigoDos().setNombre("qeqewqWqw");
        getAdopcionDTO().getTestigoDos().setPrimerApellido("ERWRE");
        getAdopcionDTO().getTestigoDos().setSegundoApellido("EDQWDWQ");
        getAdopcionDTO().getTestigoDos().setFechaNacimientoInc("Enero");
        getAdopcionDTO().getTestigoDos().getDomicilio().setCalle("IJEDR");
        getAdopcionDTO().getTestigoDos().getDomicilio().setCodigoPostal("09700");
        getAdopcionDTO().getTestigoDos().getDomicilio().setColonia("WQDWQD");
        getAdopcionDTO().getTestigoDos().getDomicilio().setNumeroExterior("2323");
        getAdopcionDTO().getTestigoDos().getDomicilio().setNumeroInteror("432");*/


    }



    public void onRowSelect() {
        mostrarDatosAdoptado = true;
        //Se debe buscar el progenitor del adoptado
    }

    /**
     * Metodo para guardar un nuevo registro de adopcion
     */
    public void guardaRegistro() throws IOException {
        getAdopcionDTO().getActaAdopcion().setTipoOperacion(ConstantesComunes.TIPO_OPERACION_NACIONAL);
        setAdopcionDTO(getAdopcionService().guardarAdopcion
                (getAdopcionDTO(), getExistenciaAbueloUnoAdoptante(), getExistenciaAbueloDosAdoptante()));
        if(getAdopcionDTO().getCodigoError()==ConstantesComunes.CODIGO_EXITOSO) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance().addMessage
                    (null, new FacesMessage
                            (FacesMessage.SEVERITY_INFO,"Exito", "Se ha modificado el acta de nacimiento"));

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath()
                    .concat(ConstantesComunes.DETALLE_ADOPCION));
        }
        else if(getAdopcionDTO().getCodigoError()==ConstantesComunes.CODIGO_ERROR) {
            FacesContext.getCurrentInstance().addMessage
                    (null, new FacesMessage
                            (FacesMessage.SEVERITY_ERROR,"Error", "Ocurrio un problema al generar el acta de nacimiento"));
            RequestContext.getCurrentInstance().execute("errorDialog.show()");
        }
    }

    public void setPersona(PersonaDTO persona, String tipoPersona) {
        logger.info("LA PERSONA: " + persona);
        logger.info("TIPO PERSONA: " + tipoPersona);

        if (!"".equals(tipoPersona) && tipoPersona.equals("ADOPTADO"))
            getAdopcionDTO().setPersona(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("ADOPTANTE"))
            getAdopcionDTO().setAdoptante(persona);
        else if(!"".equals(tipoPersona) && tipoPersona.equals("PUADOPTANTE"))
            getAdopcionDTO().setPadreUnoAdoptante(persona);
        else if(!"".equals(tipoPersona) && tipoPersona.equals("PDADOPTANTE"))
            getAdopcionDTO().setPadreDosAdoptante(persona);
        else if(!"".equals(tipoPersona) && tipoPersona.equals("TESTIGOU"))
            getAdopcionDTO().setTestigoUno(persona);
        else if(!"".equals(tipoPersona) && tipoPersona.equals("TESTIGOD"))
            getAdopcionDTO().setTestigoDos(persona);
    }
}
