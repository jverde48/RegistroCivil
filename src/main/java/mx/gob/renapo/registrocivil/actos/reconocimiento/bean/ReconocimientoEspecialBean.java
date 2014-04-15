package mx.gob.renapo.registrocivil.actos.reconocimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ReconocimientoDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 22/03/14
 * Time: 02:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Data
@Component
@ViewScoped
@ManagedBean(name = "reconocimientoEspecialBean")
public class ReconocimientoEspecialBean extends ReconocimientoBean implements Serializable{

    @Autowired
    private ReconocimientoDTO reconocimientoDTO;

    private static Logger log = Logger.getLogger(ReconocimientoBean.class);

    @PostConstruct
    public void cargarInformacion() {

        setListaEstadoCivilReconocido(getEstadoCivilService().findAll());
        setListaEstadoCivilReconocedor(getEstadoCivilService().findAll());
        setListaEstadoCivilTestigoUno(getEstadoCivilService().findAll());
        setListaEstadoCivilTestigoDos(getEstadoCivilService().findAll());
        setListaEstadocivilPersonaConsentimiento(getEstadoCivilService().findAll());
        setListaEstadoCivilAbueloUnoProgenitor(getEstadoCivilService().findAll());
        setListaEstadoCivilAbueloDosProgenitor(getEstadoCivilService().findAll());

        setListaPaisReconocido(getPaisService().findAll());
        setListaPaisReconocedor(getPaisService().findAll());
        setListaPaisTestigoUno(getPaisService().findAll());
        setListaPaisTestigoDos(getPaisService().findAll());
        setListaPaisPersonaConsentimiento(getPaisService().findAll());
        setListaPaisAbueloUnoProgenitor(getPaisService().findAll());
        setListaPaisAbueloDosReconocedor(getPaisService().findAll());

        setListaPaisInegiReconocido(getInegiPaisService().findAll());
        setListaPaisInegiReconocedor(getInegiPaisService().findAll());
        setListaPaisInegiTestigoUno(getInegiPaisService().findAll());
        setListaPaisInegiTestigoDos(getInegiPaisService().findAll());
        setListaPaisInegiPersonaConsentimiento(getInegiPaisService().findAll());
        setListaPaisInegiAbueloUnoProgenitor(getInegiPaisService().findAll());
        setListaPaisInegiAbueloDosProgenitor(getInegiPaisService().findAll());

        setListaParentescoReconocedor(getParentescoService().findAll());
        setListaParentescoTestigoUno(getParentescoService().findAll());
        setListaParentescoTestigoDos(getParentescoService().findAll());
        setListaParentescoPersonaConsentimiento(getParentescoService().findAll());
        setListaParentescoAbueloUnoProgenitor(getParentescoService().findAll());
        setListaParentescoAbueloDosProgenitor(getParentescoService().findAll());

        setListaTipoLocalidadReconocido(getTipoLocalidadService().findAll());
        setListaTipoLocalidadReconocedor(getTipoLocalidadService().findAll());
        setListaTipoLocalidadTestigoUno(getTipoLocalidadService().findAll());
        setListaTipoLocalidadTestigoDos(getTipoLocalidadService().findAll());
        setListaTipoLocalidadPersonaConsentimiento(getTipoLocalidadService().findAll());
        setListaTipoLocalidadAbueloUnoProgenitor(getTipoLocalidadService().findAll());
        setListaTipoLocalidadAbueloDosProgenitor(getTipoLocalidadService().findAll());

    }

}
