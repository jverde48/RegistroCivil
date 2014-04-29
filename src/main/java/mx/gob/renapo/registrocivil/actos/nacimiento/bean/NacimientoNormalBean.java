package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.comun.dto.DomicilioDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
        setMadreSoltera(false);

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
            getNacimientoDTO().setRegistroNormal(true);
            getNacimientoDTO().setRegistroHistorico(false);
            getNacimientoDTO().setRegistroEspecial(false);

            getNacimientoDTO().getActaNacimiento().setTipoOperacion(ConstantesComunes.TIPO_OPERACION_NACIONAL);
            setDetalleNacimiento(getNacimientoService().guardarNacimiento
            (getNacimientoDTO(), getExistenciaAbueloUnoProgenitorUno(), getExistenciaAbueloDosProgenitorUno(),
            		getExistenciaAbueloUnoProgenitorDos(), getExistenciaAbueloDosProgenitorDos(), getMadreSoltera(),
            		getComparece()));
        if(getDetalleNacimiento().getCodigoError()==ConstantesComunes.CODIGO_EXITOSO) {
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
	 * Metodo para cambiar el template necesario para el formulario de los
	 * padres y cargar la lista de paises correspondiente
	 */
    @Override
	public void cambiaTemplateProgenitores() {
		if (getPadres() == 1) {
            setMadreSoltera(true);
            setExistenciaAbueloDosProgenitorDos(false);
            setExistenciaAbueloUnoProgenitorDos(false);
			setTemplatePadres(ConstantesComunes.TEMPLATE_DATOS_PERSONALES_PROGENITOR_UNO);
		} else if (getPadres() == 2) {
            setMadreSoltera(false);
			setTemplatePadres(ConstantesComunes.TEMPLATE_DATOS_PERSONALES_AMBOS_PADRES);
		}
	}

    public void setPersona(PersonaDTO persona, String tipoPersona) {
        logger.info("LA PERSONA: " + persona);
        logger.info("TIPO PERSONA: " + tipoPersona);
        if(persona.getDomicilio()==null) {
            persona.setDomicilio(new DomicilioDTO());
        }

        if (!"".equals(tipoPersona) && tipoPersona.equals("REGISTRADO"))
            getNacimientoDTO().setRegistrado(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("PROGENITOR_UNO"))
            getNacimientoDTO().setProgenitorUno(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("PROGENITOR_DOS"))
            getNacimientoDTO().setProgenitorDos(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("ABUELO_UNO_PRO_UNO"))
            getNacimientoDTO().setAbueloUnoProgenitorUno(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("ABUELO_DOS_PRO_UNO"))
            getNacimientoDTO().setAbueloDosProgenitorUno(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("ABUELO_UNO_PRO_DOS"))
            getNacimientoDTO().setAbuelaUnoProgenitorDos(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("ABUELO_DOS_PRO_DOS"))
            getNacimientoDTO().setAbueloDosProgenitorDos(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TUNO"))
            getNacimientoDTO().setTestigoDos(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TDOS"))
            getNacimientoDTO().setTestigoDos(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("PER_DIST_COMPARECE"))
            getNacimientoDTO().setPersonaDistintaComparece(persona);
    }

    public void restorePersona(String tipoPersona) {
        logger.info(":::RESTAURANDO VALORES::::");
        if (!"".equals(tipoPersona) && tipoPersona.equals("REGISTRADO"))
            getNacimientoDTO().setRegistrado(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("PROGENITOR_UNO"))
            getNacimientoDTO().setProgenitorUno(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("PROGENITOR_DOS"))
            getNacimientoDTO().setProgenitorDos(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("ABUELO_UNO_PRO_UNO"))
            getNacimientoDTO().setAbueloUnoProgenitorUno(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("ABUELO_DOS_PRO_UNO"))
            getNacimientoDTO().setAbueloDosProgenitorUno(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("ABUELO_UNO_PRO_DOS"))
            getNacimientoDTO().setAbuelaUnoProgenitorDos(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("ABUELO_DOS_PRO_DOS"))
            getNacimientoDTO().setAbueloDosProgenitorDos(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TUNO"))
            getNacimientoDTO().setTestigoDos(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TDOS"))
            getNacimientoDTO().setTestigoDos(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("PER_DIST_COMPARECE"))
            getNacimientoDTO().setPersonaDistintaComparece(new PersonaDTO());
    }

}
