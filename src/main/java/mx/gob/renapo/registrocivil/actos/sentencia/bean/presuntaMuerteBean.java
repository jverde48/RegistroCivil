package mx.gob.renapo.registrocivil.actos.sentencia.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 4/04/14
 * Time: 05:20 PM
 * To change this template use File | Settings | File Templates.
 */

@Data
@Component
@ViewScoped
@ManagedBean(name = "presuntaMuerteBean")
public class presuntaMuerteBean extends sentenciaBean implements Serializable{
}
