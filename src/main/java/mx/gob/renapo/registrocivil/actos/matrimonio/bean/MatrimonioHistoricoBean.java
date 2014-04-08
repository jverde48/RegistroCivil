package mx.gob.renapo.registrocivil.actos.matrimonio.bean;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.springframework.stereotype.Component;


@Data
@Component
@ViewScoped
@ManagedBean(name = "matrimonioHistoricoBean")
public class MatrimonioHistoricoBean extends MatrimonioBean {

}
