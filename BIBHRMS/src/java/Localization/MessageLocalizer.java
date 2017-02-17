/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Localization;

/**
 *
 * @author mekete
 */
public class MessageLocalizer {

    public MessageLocalizer() {
    }

    /**
     * @return a string bundle for the current locale.<br>
     * The method checks the current locale by itself
     * @param <b>messageToBeLocalized</b> the the variable of the property file
     * @param <b>propertyFileName</b> the name of the file which contain the variable<b>messageToBeLocalized</b>
     */
    public static String getLocalizedMessage(String messageToBeLocalized, String propertyFileName) {
        try {
            java.util.Locale locale = javax.faces.context.FacesContext.getCurrentInstance().getViewRoot().getLocale();
            java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle(propertyFileName, locale);
            return rb.getString(messageToBeLocalized);
        } catch (java.util.MissingResourceException ex) {
            ex.printStackTrace();
            return "??" + messageToBeLocalized + "??";
        }
    }
}
