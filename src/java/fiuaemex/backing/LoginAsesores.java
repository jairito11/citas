/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.backing;


import fiuaemex.entities.Asesores;
import fiuaemex.facade.AsesoresFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author desa
 */
@ManagedBean
@SessionScoped
public class LoginAsesores implements Serializable {
    
    private String correo;
    private String password;
    private Asesores asesor;
    
    @EJB
    private AsesoresFacadeLocal asesoresFacade;
    
    /**
     * Creates a new instance of LoginAsesores
     */
    public LoginAsesores() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Asesores getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesores asesor) {
        this.asesor = asesor;
    }
    
    public String validarLogin(){
        String outcome = null;
        asesor = asesoresFacade.consultarAsesores(correo, password);
        
        if(asesor != null){
            outcome="asesores";
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no valido","Usuario no valido");
            FacesContext.getCurrentInstance().addMessage(null, msg);            
        }
        return outcome;
    }
}
