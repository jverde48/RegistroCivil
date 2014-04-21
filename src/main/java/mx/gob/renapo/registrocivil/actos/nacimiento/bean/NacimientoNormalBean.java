package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
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
            setNacimientoDTO(getNacimientoService().guardarNacimiento
            (getNacimientoDTO(), getExistenciaAbueloUnoProgenitorUno(), getExistenciaAbueloDosProgenitorUno(),
            		getExistenciaAbueloUnoProgenitorDos(), getExistenciaAbueloDosProgenitorDos(), getMadreSoltera(),
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

}
