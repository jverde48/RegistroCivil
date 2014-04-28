package mx.gob.renapo.registrocivil.showcase.beans;

import lombok.Data;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 27/04/14
 * Time: 06:12 PM
 * To change this template use File | Settings | File Templates.
 */

@Data
@RequestScoped
@ManagedBean(name = "loginBean")
public class LoginBean {
    private String usuario;
    private String contrasenia;

    public void login() {
        System.out.println("USUARIO: " + usuario);
        System.out.println("CONTRASENIA: " + contrasenia);
    }

    public void cancelar() throws IOException {
        usuario = "";
        contrasenia = "";
    }
}
