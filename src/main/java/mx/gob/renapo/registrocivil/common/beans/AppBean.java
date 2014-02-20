package mx.gob.renapo.registrocivil.common.beans;

import lombok.Data;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Author: Benek
 * Date: 20/02/14
 * Time: 01:21
 * www.javamexico.org
 */
@ManagedBean
@Data
@ApplicationScoped
public class AppBean {

    public void preRenderView() {
        HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
    }

}
