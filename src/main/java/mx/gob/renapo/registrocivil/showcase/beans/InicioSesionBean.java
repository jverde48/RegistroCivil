package mx.gob.renapo.registrocivil.showcase.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Author: Benek
 * Date: 27/04/14
 * Time: 19:24
 * www.javamexico.org
 */
 @ManagedBean(name="inicioSesionBean")
 @ViewScoped
public class InicioSesionBean {

    private String usuario;
    private String password;

    public String hazAlgo(){
        System.out.println("ASD: " + usuario + password);
        return "index";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
