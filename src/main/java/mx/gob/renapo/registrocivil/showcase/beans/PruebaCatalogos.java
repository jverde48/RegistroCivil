package mx.gob.renapo.registrocivil.showcase.beans;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoService;
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
 * Date: 20/03/14
 * Time: 00:33
 * To change this template use File | Settings | File Templates.
 */
@Component
@ViewScoped
@Data
@ManagedBean(name = "pruebaCatalogosBean")
public class PruebaCatalogos implements Serializable {

    @Autowired
    private CatEstadoService estadoService;

    private EstadoDTO estado;
    private List<EstadoDTO> listaEstados;

    @PostConstruct
    public void cargarInformacion() {
        System.out.println("es null ------------------------ " + estadoService);
        listaEstados = estadoService.findAll();
    }

}
