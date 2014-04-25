package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import mx.gob.renapo.registrocivil.catalogos.dto.CatEstadoCivilDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


@ManagedBean(name = "nacimientoEspecialBean")
@ViewScoped
@Component
public class NacimientoEspecialBean extends NacimientosPrincipalBean implements Serializable{
	
	
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
        getNacimientoDTO().setRegistroNormal(false);
        getNacimientoDTO().setRegistroHistorico(false);
        getNacimientoDTO().setRegistroEspecial(true);

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




}
