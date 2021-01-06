/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.backing;


import fiuaemex.entities.Alumnos;
import fiuaemex.facade.AlumnosFacadeLocal;
import java.io.Serializable;
import java.util.Locale;
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
public class LoginAlumnos implements Serializable {
    
    private String correo;
    private String password;
    private Alumnos alumno;
    
    @EJB
    private AlumnosFacadeLocal alumnosFacade;

    /**
     * Creates a new instance of LoginAlumnos
     */
    public LoginAlumnos() {
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
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
    
    public String validarLogin(){
        String outcome = null;
        alumno = alumnosFacade.consultarAlumnos(correo, password);
        
        if(alumno != null){
            outcome="alumnos";
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no valido","Usuario no valido");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return outcome;
    }  
    
}
