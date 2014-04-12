package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatEstadoCivilDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Component;

@ManagedBean(name = "nacimientoHistoricoBean")
@Data
@ViewScoped
@Component
public class NacimientoHistoricoBean extends NacimientosPrincipalBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

        getNacimientoHistoricoDTO().getRegistrado().setPaisNacimiento(getPaisService().findMexico());

        if(getEstadoCivilList()!=null) {
            for(CatEstadoCivilDTO estadoCivil: getEstadoCivilList()) {
                if(estadoCivil.getDescripcion().equals("Soltero")) {
                    getNacimientoHistoricoDTO().getRegistrado().setEstadoCivil(estadoCivil);
                    break;
                }
            }
        }

        setEstadosRegistrado(getEstadoService().recuperarPorPais
                (getNacimientoHistoricoDTO().getRegistrado().getPaisNacimiento()));
    }

    /**
     * Metodo para guardar un nuevo registro de nacimiento
     */
    public void guardaRegistro() throws IOException {
        getNacimientoHistoricoDTO().getActaNacimiento().setTipoOperacion(ConstantesComunes.TIPO_OPERACION_NACIONAL);
        setNacimientoHistoricoDTO(getNacimientoService().guardarNacimiento
                (getNacimientoHistoricoDTO(), getExistenciaAbueloUnoProgenitorUno(), getExistenciaAbueloDosProgenitorUno(),
                        getExistenciaAbueloUnoProgenitorDos(), getExistenciaAbueloDosProgenitorDos(), getPadres(),
                        getComparece()));
        if(getNacimientoHistoricoDTO().getCodigoError()==ConstantesComunes.CODIGO_EXITOSO) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance().addMessage
                    (null, new FacesMessage
                            (FacesMessage.SEVERITY_INFO,"Exito", "Se ha generado el acta de nacimiento"));

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath()
                    .concat(ConstantesComunes.DETALLE_NACIMIENTO));
        }
        else if(getNacimientoHistoricoDTO().getCodigoError()==ConstantesComunes.CODIGO_ERROR) {
            FacesContext.getCurrentInstance().addMessage
                    (null, new FacesMessage
                            (FacesMessage.SEVERITY_ERROR,"Error", "Ocurrio un problema al generar el acta de nacimiento"));
            RequestContext.getCurrentInstance().execute("errorDialog.show()");
        }
    }

}
