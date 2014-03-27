package mx.gob.renapo.registrocivil.actos.matrimonio.bean;

import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 21/03/14
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
@Data
@Component
@ViewScoped
@ManagedBean(name = "matrimonioNormalBean")
public class MatrimonioNormalBean extends MatrimonioBean implements Serializable {

    private static Logger log = Logger.getLogger(MatrimonioBean.class);

    @PostConstruct
    public void cargarInformacion() {
        setListaPaises(getPaisService().findAll());

        setListaPaisesInegi(getInegiPaisService().findAll());
        setListaEstadoCivil(getEstadoCivilService().findAll());
        setListaSituacionLaboral(getSituacionLaboralService().findAll());

        setListaParentesco(getParentescoService().findAll());
        setListaEscolaridad(getEscolaridadService().findAll());
        setListaPuestos(getPuestoService().findAll());
        setListaRegimen(getRegimenService().findAll());
    }

    public void registrarMatrinonio() {
        if (getMatrimonioService().registrarMatrimonio(getMatrimonio())) {

        } else {

        }
    }
}
