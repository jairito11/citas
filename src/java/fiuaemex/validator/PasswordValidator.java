/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author desa
 */
public class PasswordValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String password = (String) value;
        
        if (password.length() < 5 || password.length() > 15) {
            throw new ValidatorException(new FacesMessage("La contraseña debe tener entre 5 y 10 caracteres"));
        }
    }
    
}
