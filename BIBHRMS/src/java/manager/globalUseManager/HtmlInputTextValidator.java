/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.globalUseManager;

/**
 *
 * @author Administrator
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Administrator
*/

import com.icesoft.faces.component.ext.HtmlInputText;

/**
 * This Concrete Class is used to validate ICEface text box controller
 * Its main activity is to retrieve data in the component and set and clear error marks
 * @author Elias
 */
class HtmlInputTextValidator extends Validator {

    private HtmlInputText textBox = null;//IceFace HtmlInputText, Holdes the text box controller to be validated.

    /**
     * Constructor to initialize this class with HtmlInputText
     * @param control IceFace data entry text box component to initialize with.
     */
    public HtmlInputTextValidator(HtmlInputText control) {

        textBox = control;
    }

    /**
     * A method used to clear error indications from data entry component,
     * this includes clearing of color set, message text, and javascript methods
     * set to be called to display message text.
     */
    @Override
    public void clearErrorIndication() {
        String styleClass = textBox.getStyleClass();

        styleClass = styleClass.replaceAll("iceInpTxt", "").trim();//Remove the defoult added stayle class
        styleClass = styleClass.replaceAll(EMPTY_ERROR_STYLE, "").trim();
        styleClass = styleClass.replaceAll(FORMAT_ERROR_STYLE, "").trim();
        styleClass = styleClass.replaceAll(OUT_OF_RANGE_ERROR_STYLE, "").trim();

        textBox.setStyleClass(styleClass);
        textBox.setTitle("");
        textBox.setAlt("");
        textBox.setOnmouseover("");
    }

    /**
     * A method used to set error indication on data entry component,
     * this include to set error indicator color, descriptive message text and JavaScript  methods
     * to be called to display error description message.
     * @param styleClass - style class to highlight data entry components with error.
     * @param message - error description message to be displayed
     */
    @Override
    public void setErrorIndication(String styleClass, String message) {
        styleClass = textBox.getStyleClass() + " " + styleClass;
        styleClass = styleClass.replace("iceInpTxt", "").trim();//Remove the defoult added stayle class
        textBox.setStyleClass(styleClass);
        textBox.setTitle(message);
        textBox.setAlt(message);

        textBox.setOnmouseover("displayMessage(this);");
        textBox.setOnmouseout("hideMessage();");
    }

    /**
     * A method which is used to return user entered data from data entry component.
     * @return Object - value of the data entry component (user entered data)
     */
    @Override
    public Object getComponentData() {
        return textBox.getText();
    }
}
