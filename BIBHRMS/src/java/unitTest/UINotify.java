/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTest;

import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.context.effects.JavascriptContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Tamrat
 */
public class UINotify {

    public UINotify() {
    }

    private static final int error = -1;
    private static final int success = 1;
    private static final int warning = 0;

    public static int getError() {
        return error;
    }

    public static int getSuccess() {
        return success;
    }

    public static int getWarning() {
        return warning;
    }

    private static final String styleSuccess = "successMesg";
    private static final String styleWarning = "warnMesg";
    private static final String styleError = "errorMesg";

    public static void showMessage(PanelLayout messageBdy,
            javax.faces.component.html.HtmlOutputLabel messageLable,
            int status, String message) {

        String styleClass = "";
        if (status == success) {
            styleClass = styleSuccess;
        } else if (status == warning) {
            styleClass = styleWarning;
        } else if (status == error) {
            styleClass = styleError;
        } else {
        }
        messageLable.setValue(message);
        messageBdy.setStyleClass(styleClass);
        messageBdy.setRendered(true);

        String fadeTime = ("10000");
        String javaScriptText = "$j(document).ready(function(){ " +
                "$j('." + styleClass + "').show(); " +
                "$j('." + styleClass + "').fadeOut(" + fadeTime + ");});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }
}
