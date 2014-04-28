package mx.gob.renapo.registrocivil.seguridad.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Author: Benek
 * Date: 25/04/14
 * Time: 06:08
 * www.javamexico.org
 */
@Data
@RequestScoped
@ManagedBean(name = "loginBean")
@Component
public class LoginBean{

    private static Logger log = Logger.getLogger(LoginBean.class);

    private String usuario;
    private String contrasenia;

    public void login() throws IOException{
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(this.getUsuario(), this.getContrasenia());
            Authentication result = authenticationManager.authenticate(request);
            log.debug("Usuario " + usuario + " es valido.");
            SecurityContextHolder.getContext().setAuthentication(result);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath()
                .concat(ConstantesComunes.INDEX));
    }

    public void logout() throws IOException{
        SecurityContextHolder.clearContext();
        log.debug("Usuario " + usuario + " ha cerrado sesion.");
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath()
                .concat(ConstantesComunes.INDEX));
    }

    public String getUsuarioLogueado(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public String cancelar() throws IOException { return null; }

    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
}
