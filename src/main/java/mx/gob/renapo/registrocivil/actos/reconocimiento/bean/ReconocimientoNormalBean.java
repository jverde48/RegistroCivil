package mx.gob.renapo.registrocivil.actos.reconocimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ReconocimientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@Data
@Component
@ViewScoped
@ManagedBean(name = "reconocimientoNormalBean")
public class ReconocimientoNormalBean {

    @Autowired
    private ReconocimientoDTO reconocimientoDTO;
}
