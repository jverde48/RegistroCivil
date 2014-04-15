package mx.gob.renapo.registrocivil.actos.defuncion.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: fase1_16
 * Date: 24/03/14
 * Time: 03:51 AM
 * To change this template use File | Settings | File Templates.
 */

@ManagedBean(name="defuncionHistoricoBean")
@ViewScoped
@Data
@Component
public class DefuncionHistoricoBean extends DefuncionesPrincipalBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(DefuncionNormalBean.class);

    @PostConstruct
    public void init() {
        setListaPaisesFinado(getPaisService().findAll());
        setListaPaisesInegiFinado(getInegiPaisService().findAll());
        setListaPaisesDeclarante(getPaisService().findAll());
        setListaPaisesInegiDeclarante(getInegiPaisService().findAll());
        setListaPaisesInegiLugarFallecimiento(getInegiPaisService().findAll());
        setListaPaisesInegiTestigoUno(getInegiPaisService().findAll());
        setListaPaisesTestigoUno(getPaisService().findAll());
        setListaPaisesInegiTestigoDos(getInegiPaisService().findAll());
        setListaPaisesTestigoDos(getPaisService().findAll());
        setListaPaisesConyuge(getPaisService().findAll());
        setListaPaisesProgenitorUno(getPaisService().findAll());
        setListaPaisesProgenitorDos(getPaisService().findAll());
        setListaParentesco(getParentescoService().findAll());
        setListaEscolaridad(getEscolaridadService().findAll());
        setListaSituacionLaboral(getSituacionLaboralService().findAll());
        setListaEstadoCivil(getEstadoCivilService().findAll());
        setListaPuesto(getPuestoService().findAll());
        setListaLugarFallece(getLugarFalleceService().findAll());
        setListaDestinoCadaver(getDestinoCadaverService().findAll());
        setListaEstadosEstadisticos(getEstadoService().
                recuperarPorPais(getPaisService().findMexico()));

    }

    /**
     * Metodo para guardar un nuevo registro de Defuncion
     */

    public void guardaRegistroHistoricoDefuncion() throws IOException {
        getDefuncionDTO().setNormal(false);
        getDefuncionDTO().setHistorico(true);
        getDefuncionDTO().setEspecial(false);

        System.out.println("Entro +++++++++++++++++++++++++++++++++++++");
        setDefuncionDetalle(getDefuncionService().guardarDefuncion(getDefuncionDTO(),getExistenciaConyuge(),
                getExistenciaProgenitorUno(), getExistenciaProgenitorDos()));
        if (getDefuncionDetalle().getCodigoRespuesta().equals(0)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,"El registro se ha guardado correctamente.", ""));

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath()
                    .concat(ConstantesComunes.DETALLE_DEFUNCION));
        } else {

        }
    }





}
