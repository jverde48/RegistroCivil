package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

@Data
@Component
@ViewScoped
@ManagedBean(name = "nacimientoNormalBean")
public class NacimientoNormalBean extends NacimientosPrincipalBean implements Serializable{

    private static Logger logger = Logger.getLogger(NacimientoNormalBean.class);


    
    
    @PostConstruct
    public void init() {
    	setPaises(getPaisService().findAll());
    	setPaisesInegi(getInegiPaisService().findAll());
        setAtendioPartoList(getAtendioPartoService().findAll());
        setParentescoList(getParentescoService().findAll());
        setTipoPartoList(getTipoPartoService().findAll());
        setLugarPartoList(getLugarPartoService().findAll());
        setEscolaridadList(getEscolaridadService().findAll());
        setTipoLocalidadList(getTipoLocalidadService().findAll());
        setEstadoCivilList(getEstadoCivilService().findAll());
        setSituacionLaboralList(getSituacionLaboralService().findAll());
        setPosicionTrabajoList(getPuestoTrabajoService().findAll());
        setCompareceList(getCompareceService().findAll());

        getNacimientoDTO().getRegistrado().setPaisNacimiento(getPaisService().findMexico());
        
        if(getEstadoCivilList()!=null) {
        	for(CatEstadoCivilDTO estadoCivil: getEstadoCivilList()) {
            	if(estadoCivil.getDescripcion().equals("Soltero")) {
            	    	getNacimientoDTO().getRegistrado().setEstadoCivil(estadoCivil);
            		break;
            	}
            }
        }
 
        setEstadosRegistrado(getEstadoService().recuperarPorPais
        		(getNacimientoDTO().getRegistrado().getPaisNacimiento()));
    }

    /**
     * Metodo para guardar un nuevo registro de nacimiento
     */
    public void guardaRegistro() throws IOException {


            getNacimientoDTO().getActaNacimiento().setTipoOperacion(ConstantesComunes.TIPO_OPERACION_NACIONAL);
            setNacimientoDTO(getNacimientoService().guardarNacimiento
            (getNacimientoDTO(), getExistenciaAbueloUnoProgenitorUno(), getExistenciaAbueloDosProgenitorUno(), 
            		getExistenciaAbueloUnoProgenitorDos(), getExistenciaAbueloDosProgenitorDos(), getPadres(), 
            		getComparece()));
        if(getNacimientoDTO().getCodigoError()==ConstantesComunes.CODIGO_EXITOSO) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance().addMessage
                    (null, new FacesMessage
                            (FacesMessage.SEVERITY_INFO,"Exito", "Se ha generado el acta de nacimiento"));

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath()
                    .concat(ConstantesComunes.DETALLE_NACIMIENTO));
        }
        else if(getNacimientoDTO().getCodigoError()==ConstantesComunes.CODIGO_ERROR) {
            FacesContext.getCurrentInstance().addMessage
                    (null, new FacesMessage
                            (FacesMessage.SEVERITY_ERROR,"Error", "Ocurrio un problema al generar el acta de nacimiento"));
            RequestContext.getCurrentInstance().execute("errorDialog.show()");
        }



    }
    
    /**
     * Metodo para recupear los estados por pais de una persona en especifico
     * (Progenitor Uno, Progenitor Dos, Testigo Uno, Testigo Dos, Persona Distinta
     * que comparece)
     * @param tipoPersona
     */
    public void consultaEstados(Integer tipoPersona) {
    	PersonaDTO persona = obtienePersona(tipoPersona);
    	PaisDTO pais = persona.getPaisNacimiento();
    	
    	switch(tipoPersona) {
    	case 2:
    		setEstadosProgenitorUno(getEstadoService().recuperarPorPais(pais));
    		break;
    	case 3:
    		setEstadosProgenitorDos(getEstadoService().recuperarPorPais(pais));
    		break;
    	case 8:
    		setEstadosTestigoUno(getEstadoService().recuperarPorPais(pais));
    		break;
    	case 9:
    		setEstadosTestigoDos(getEstadoService().recuperarPorPais(pais));
    		break;
    	case 10:
    		setEstadosPersonaDistintaComparece(getEstadoService().recuperarPorPais(pais));
    		break;
    	}
    }
    
    /**
     * Metodo que carga los municipios de un estado seleccionado segun la persona
     * @param tipoPersona
     */
    public void consultaMuncipios(Integer tipoPersona) {   	
    	PersonaDTO persona = obtienePersona(tipoPersona);
    	EstadoDTO estado = persona.getEntidadNacimiento();
    	
    	switch(tipoPersona) {
    	case 1:
    		setMunicipiosResgistrado(getMunicipioService().recuperarMunicipiosPorEstado(estado));
    		break;
    	case 2:
    		setMunicipiosProgenitorUno(getMunicipioService().recuperarMunicipiosPorEstado(estado));
    		break;
    	case 3:
    		setMunicipiosProgenitorDos(getMunicipioService().recuperarMunicipiosPorEstado(estado));
    		break;
    	case 8:
    		setMunicipiosTestigoUno(getMunicipioService().recuperarMunicipiosPorEstado(estado));
    		break;
    	case 9:
    		setMunicipiosTestigoDos(getMunicipioService().recuperarMunicipiosPorEstado(estado));
    		break;
    	case 10:
    		setMunicipiosPersonaDistintaComparece(getMunicipioService().recuperarMunicipiosPorEstado(estado));
    		break;
    	}
    	
    }
    
    public void consultaEstadosInegi(Integer tipoPersona) {
    	PersonaDTO persona = obtienePersona(tipoPersona);  	
    	PaisDTO pais = persona.getDomicilio().getPais();
    	switch(tipoPersona) {
    	case 1:
    		setEstadosInegiRegistrado(getInegiEstadoService().recupearEstadosPorPais(pais));
    		break;
    	case 2:
    		setEstadosInegiProgenitorUno(getInegiEstadoService().recupearEstadosPorPais(pais));
    		break;
    	case 3:
    		setEstadosInegiProgenitorDos(getInegiEstadoService().recupearEstadosPorPais(pais));
    		break;
    	case 8:
    		setEstadosInegiTestigoUno(getInegiEstadoService().recupearEstadosPorPais(pais));
    		break;
    	case 9:
    		setEstadosInegiTestigoDos(getInegiEstadoService().recupearEstadosPorPais(pais));
    		break;
    	case 10:
    		setEstadosInegiPersonaDistintaComarece(getInegiEstadoService().recupearEstadosPorPais(pais));
    		break;
    	}
    	
    }
    
    public void consultaMunicipiosInegi(Integer tipoPersona) {
    	PersonaDTO persona = obtienePersona(tipoPersona);
    	EstadoDTO estado = persona.getDomicilio().getEstado();
    	switch(tipoPersona) {
    	case 1:
    		setMunicipiosInegiRegistrado(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
    		break;
    	case 2:
    		setMunicipiosInegiProgenitorUno(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
    		break;
    	case 3:	
    		setMunicipiosInegiProgenitorDos(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
    		break;
    	case 8:
    		setMunicipiosInegiTestigoUno(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
    		break;
    	case 9:
    		setMunicipiosInegiTestigoDos(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
    		break;
    	case 10:
    		setMunicipiosInegiPersonaDistintaComparece(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
    	}
    }
    
    public void consultaLocalidadesInegi(Integer tipoPersona) {
    	PersonaDTO persona = obtienePersona(tipoPersona);
    	MunicipioDTO municipio = persona.getDomicilio().getMunicipio();
    	switch(tipoPersona) {
    	case 1:
    		setLocalidadesRegistrado(getLocalidadService().findAllByMunicipio(municipio));
    		break;
    	case 2:
    		setLocalidadesProgenitorUno(getLocalidadService().findAllByMunicipio(municipio));
    		break;
    	case 3:
    		setLocalidadesProgenitorDos(getLocalidadService().findAllByMunicipio(municipio));
    		break;
    	case 8:
    		setLocalidadesTestigoUno(getLocalidadService().findAllByMunicipio(municipio));
    		break;
    	case 9:
    		setLocalidadesTestigoDos(getLocalidadService().findAllByMunicipio(municipio));
    		break;
    	case 10:
    		setLocalidadesPersonaDistintaComparece (getLocalidadService().findAllByMunicipio(municipio));
    		break;
    	}
    }
    
    
    /**
     * Metodo para recuperar una persona dependiendo su rol
     * @param tipoPersona
     * @return PersonaDTO
     */
    private PersonaDTO obtienePersona(Integer tipoPersona) {
    	PersonaDTO persona = null;
    	
    	switch (tipoPersona) {
		case 1:
			persona = getNacimientoDTO().getRegistrado();
			break;
		case 2:
			persona = getNacimientoDTO().getProgenitorUno();
			break;
		case 3:
			persona = getNacimientoDTO().getProgenitorDos();
			break;
		case 4:
			persona = getNacimientoDTO().getAbueloUnoProgenitorUno();
			break;
		case 5:
			persona = getNacimientoDTO().getAbuelaUnoProgenitorDos();
			break;
		case 6:
			persona = getNacimientoDTO().getAbueloDosProgenitorUno();
			break;
		case 7:
			persona = getNacimientoDTO().getAbueloDosProgenitorDos();
			break;	
		case 8:
			persona = getNacimientoDTO().getTestigoUno();
			break;	
		case 9:
			persona = getNacimientoDTO().getTestigoDos();
			break;
		case 10:
			persona = getNacimientoDTO().getPersonaDistintaComparece();
			break;
		}
    	return persona;
    }
    
    /**
	 * Metodo para cambiar el template necesario para el formulario de los
	 * padres y cargar la lista de paises correspondiente
	 */
    @Override
	public void cambiaTemplateProgenitores() {
		if (getPadres() == 1) {
			setTemplatePadres(ConstantesComunes.TEMPLATE_DATOS_PERSONALES_PROGENITOR_UNO);
		} else if (getPadres() == 2) {
			setTemplatePadres(ConstantesComunes.TEMPLATE_DATOS_PERSONALES_AMBOS_PADRES);
		}
	}

    /**
	 * Metodo para cargar template de comparece
	 */
    @Override
	public void cambiaTemplateComparece() {
		if (getNacimientoDTO().getCompareceDTO().getId().intValue() == ConstantesComunes.COMPARCENCIA_OTRO) {
			setTemplateComparece(ConstantesComunes.TEMPLATE_DATOS_PERSONALES_COMPARECE);
		}
	}

}
