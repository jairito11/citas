/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.backing;

import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author desa
 */
@ManagedBean
@SessionScoped
public class LocaleBacking implements Serializable{
    
    private Locale locale = new Locale("es");
    /**
     * Creates a new instance of LocaleBacking
     */
    public LocaleBacking() {
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    public void cambiarIdioma(String l){
        locale = new Locale(l);
    }
}
