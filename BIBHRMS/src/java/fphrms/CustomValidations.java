/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author DPClone
 */
public class CustomValidations {

    ResourceBundle messageResource = null;
    FacesContext context = null;

    public void validateNumber(FacesContext facasContext, UIComponent uIComponent, Object value) throws ValidatorException {
        if (!StringUtils.isAlphaSpace((String) value)) {
            if (!value.toString().contains(".")) {
                messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());// get the resource bundle message
                FacesMessage facesMessage = new FacesMessage(messageResource.getString("nameValidate"));
                throw new ValidatorException(facesMessage);
            }
        }
    }
//    public void validateEmpty(FacesContext facasContext, UIComponent uIComponent, Object value) throws ValidatorException {
//        if (!StringUtils.isBlank((String) value)) {
//            if (!value.toString().contains(".")) {
//                messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());// get the resource bundle message
//                FacesMessage facesMessage = new FacesMessage(messageResource.getString("requiredMsg"));
//                throw new ValidatorException(facesMessage);
//            }
//        }
//    }
}
