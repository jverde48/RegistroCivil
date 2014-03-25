package mx.gob.renapo.registrocivil.actos.matrimonio.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.service.MatrimonioService;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiLocalidad;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiMunicipio;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

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
        setListaNacionalidad(getNacionalidadService().findAll());
    }

    public void registrarMatrinonio() {
        if (getMatrimonioService().registrarMatrimonio(getMatrimonio())) {

        } else {

        }
    }

}
