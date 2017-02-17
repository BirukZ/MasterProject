/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.globalUseManager;




import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.faces.component.UIInput;


/**
 * Façade Class which is used as interface to validator component to simplify
 * complexity of use.
 * @author Elias
 */
public class ComponentValidator {

    /**
     * Indicates <b>no pattern</b> check is performed on the data in the component.
     * Use this if you want to check for required error only, so that component
     * is forced only not to be empty.
     */
    public static final int NO_FORMAT = 0;
    /**
     * Indicates <b>Person name (First name) </b> like Eden or Dr. Zelalem
     * Use this for fields like First name, Middle name and Last name.
     */
    public static final int PERSON_NAME = 1;
    /**
     * Indicates <b>Person Full Name</b> like Zelalem Asegid.
     * Use this for a when you accept full name in a single component.
     */
    public static final int FULL_NAME = 2;
    /**
     * Indicates <b>Short Ethiopian Date Time</b> with date format YYYY-MM-DD or YYYY/MM/DD.
     * Any other format is not accepted for Ethiopian Date. Ethiopian Date includes
     * date like 2005-13-03 which is not supported by Gregorian date.
     * It also supports Date Time value (date with time is accepted 2012-03-04 02:30 AM is accepted)
     */
    public static final int ETH_DATE = 3;
    /**
     * Indicates <b>Short Gregorian Date Time</b> with date format YYYY-MM-DD or YYYY/MM/DD
     * or DD-MM-YYYY or MM-DD-YYYY.
     * Any other format is not accepted for Gregorian Date.
     * It also supports Date Time value (date with time is accepted 2012-03-04 02:30 AM is accepted)
     */
    public static final int GC_DATE = 4;
    /**
     * Indicates <b>Email Address</b>
     */
    public static final int EMAIL = 5;
    /**
     *Indicates <b>Ethiopian Phone Number</b> pattern both landline and mobile phones.
     * Both +251911319245 and 0911319245 are accepted.
     */
    public static final int PHONE_NUMBER = 6;
    /**
     *Indicates <b>Web Site</b> pattern
     */
    public static final int WEB_SITE = 7;
    /**
     * Indicates <b>Integer Number</b> numbers like 0, -1, 1 are all accepted but
     * numbers like 3.4 are not accepted by this patter use FLOAT_NUMBER for this case
     */
    public static final int INTEGER_NUMBER = 8;
    /**
     * Indicates <b>Float Number</b>, All numbers are accepted when using this constant.
     * Numbers like 3.4, 3.0 or 3 are all accepted.
     */
    public static final int FLOAT_NUMBER = 9;
    /**
     * Used for Remark or Comment  fields, It contains almost all characters.
     */
    public static final int REMARK_COMMENT = 10;
    /**
     * Indicates <b>Text with A to Z only </b> it doesn't allow the use of any other characters
     * including numbers 0-9.
     */
    public static final int TEXT_A_TO_Z_ONLY = 11;
    /**
     * Indicates <b>Text with A to Z and Numbers only </b> it doesn't allow the use of any other characters
     * other than alphanumeric characters.
     */
    public static final int TEXT_AND_NUMBER = 12;
    /**
     * Indicates <b>Time</b> pattern like 02:30 AM
     * It only indicates time not date with time like 2011-02-03 02:30 AM is
     * not accepted use ETH_DATE or GC_DATE for this case.
     */
    public static final int TIME = 13;


    private ResourceBundle resourceBundle = null;
    private List<Validator> validationList = new ArrayList<Validator>();

    /**
     * Default constructor to initialize component validator.
     *
     */
    public void ComponentValidator() {
    }

    /**
     * A constructor to initialize component validator with resource bundle
     * used to display localized error description message.
     * @param rb the resource bundle with localized error message.
     */
    public void ComponentValidator(ResourceBundle rb) {
        resourceBundle = rb;
    }

    /**
     * This method is used to register user data entry component like IceFace TextBox
     * and IceFace ComboBox to validator component for validation.
     *
     * @param component UIInput - data entry component to be validated for error
     * @param pattern int - validation pattern to be used by validator component.
     *                  It is acceptable format of the data (Use constants in ComponentValidator)
     * @param isRequired boolean - if set to true it means this component must not be empty (flag as it is required field)
     * @return Validator - validator component with all validation parameter set
     */
    private Validator addValidator(UIInput component, int pattern, boolean isRequired) {
        Validator validator = null;
        if (component != null) {
            if (component instanceof HtmlSelectOneMenu) {//ComboBox Validator
                validator = new HtmlSelectOneMenuValidator((HtmlSelectOneMenu) component);
            } else if (component instanceof HtmlInputText) {//Textbox Validator
                validator = new HtmlInputTextValidator((HtmlInputText) component);
            }
            validator.setPattern(pattern);
            validator.setRequired(isRequired);
            validationList.add(validator);
        }
        return validator;
    }

    /**
     * This method is used to register user data entry component like IceFace TextBox
     * and IceFace ComboBox to validator component for validation.
     * <b>Note</b> This method is not used to do the actualy validation, it only register the component
     * for validation. You need to call isAllComponenetValid() of ComponentValidator object to do the validation.
     *
     * @param component UIInput - data entry component to be validated for error
     * @param pattern int - validation pattern to be used by validator component.
     *                  It is acceptable format of the data (Use constants in ComponentValidator)
     * @param isRequired boolean - if set to true it means this component must not be empty (flag as it is required field)
     * @param customMessages (Optional Parameter) String  - custom error description message to be display. You can
     * pass 0-3 parameters.
     *     1st parameter is the description message for empty errors
     *     2nd parameter is the description message for format error
     *     3rd parameter is the description message for out of range error
     *
     * If this component is initialized with resource bundle object you can also pass keys for this message
     * so the component can read error description from resource bundle.
     *
     * If those parameter are not provided, default English message (automatically generated description message) will be used for the error description.
     */
    public void addComponent(UIInput component, int pattern, boolean isRequired, String... customMessages) {
        Validator validator = addValidator(component, pattern, isRequired);
        if (validator != null) {
            setCustomMessage(validator, customMessages);
        }
    }

    /**
     * This method is used to register user data entry component like IceFace TextBox
     * and IceFace ComboBox to validator component for validation.
     * <b>Note</b> This method is not used to do the actualy validation, it only register the component
     * for validation. You need to call isAllComponenetValid() of ComponentValidator object to do the validation.
     *
     * @param component UIInput - data entry component to be validated for error
     * @param pattern String - validation pattern to be used by validator component.
     *                  It is acceptable format of the data (Use constants in ComponentValidator)
     * @param minValue Object - the minimum acceptable value for this component,
     *              if set the value will be used as minimum boundry if null no minimum boundry will be used.
     * @param maxValue Object - the maximum acceptable value for this component,
     *              if set the value will be used as maximum boundry if null no maximum boundry will be used.
     * @param isRequired boolean - if set to true it means this component must not be empty (flag as it is required field)
     * @param customMessages (Optional Parameter) String  - custom error description message to be display. You can
     * pass 0-3 parameters.
     *     1st parameter is the description message for empty errors
     *     2nd parameter is the description message for format error
     *     3rd parameter is the description message for out of range error
     *
     * If this component is initialized with resource bundle object you can also pass keys for this message
     * so the component can read error description from resource bundle.
     *
     * If those parameter are not provided, the default English message (automatically generated description message)
     * will be used for the error description.
     */
    public void addComponent(UIInput component, int pattern, Object minValue, Object maxValue, boolean isRequired, String... customMessages) {
        Validator validator = addValidator(component, pattern, isRequired);
        if (validator != null) {
            validator.setMaxValue(maxValue);
            validator.setMinValue(minValue);
            setCustomMessage(validator, customMessages);
        }
    }

    /**
     * This method is used to register user data entry component like IceFace TextBox
     * and IceFace ComboBox to validator component for validation.
     * <b>Note</b> This method is not used to do the actualy validation, it only register the component
     * for validation. You need to call isAllComponenetValid() of ComponentValidator object to do the validation.
     *
     * @param component UIInput - data entry component to be validated for error
     * @param pattern int - validation pattern to be used by validator component.
     *                  It is acceptable format of the data (Use constants in ComponentValidator)
     * @param itemList List<Object> - list of acceptable values, if provided the data in the data entry contoroller must be on of the list given.
     * @param isRequired boolean- if set to true it means this component must not be empty (flag as it is required field)
     * @param customMessages (Optional Parameter) String  - custom error description message to be display. You can
     * pass 0-3 parameters.
     *     1st parameter is the description message for empty errors
     *     2nd parameter is the description message for format error
     *     3rd parameter is the description message for out of range error
     *
     * If this component is initialized with resource bundle object you can also pass keys for this message
     * so the component can read error description from resource bundle.
     *
     * If those parameter are not provided, the default English message (automatically generated description message)
     * will be used for the error description.
     */
    public void addComponent(UIInput component, int pattern, List<Object> itemList, boolean isRequired, String... customMessages) {
        Validator validator = addValidator(component, pattern, isRequired);
        if (validator != null) {
            validator.setItemList(itemList);
            setCustomMessage(validator, customMessages);
        }
    }

    /**
     * This method is used to register user data entry component like IceFace TextBox
     * and IceFace ComboBox to validator component for validation.
     * Specially this method is used to implement custom validation pattern rather than
     * predefined patterns.
     * Use this method only if you have special data format requirement that will not be
     * addressed by the predefined patterns.
     *
     * <b>Note</b> This method is not used to do the actualy validation, it only register the component
     * for validation. You need to call isAllComponenetValid() of ComponentValidator object to do the validation.
     *
     * @param component UIInput - data entry component to be validated for error.
     * @param pattern String - custom validation pattern to be used by validator component.
     * @param isRequired boolean - if set to true it means this component must not be empty (flag as it is required field)
     * @param customMessages (Optional Parameter) String  - custom error description message to be display. You can
     * pass 0-3 parameters.
     *     1st parameter is the description message for empty errors
     *     2nd parameter is the description message for format error
     *     3rd parameter is the description message for out of range error
     *
     * If this component is initialized with resource bundle object you can also pass keys for this message
     * so the component can read error description from resource bundle.
     *
     * If those parameter are not provided, the default English message (automatically generated description message)
     * will be used for the error description.
     */
    public void addComponent(UIInput component, String pattern, boolean isRequired, String... customMessages) {
        Validator validator = addValidator(component, 0, isRequired);
        if (validator != null) {
            setCustomMessage(validator, customMessages);
            validator.setCustomPattern(pattern);
        }
    }

    /**
     * This method is used to register user data entry component like IceFace TextBox
     * and IceFace ComboBox to validator component for validation.
     * <b>Note</b> This method is not used to do the actualy validation, it only register the component
     * for validation. You need to call isAllComponenetValid() of ComponentValidator object to do the validation.
     * Specially this method is used to implement custom validation pattern rather than
     * predefined patterns.
     * Use this method only if you have special data format requirement that will not be
     * addressed by the predefined patterns.
     *
     * @param component UIInput - data entry component to be validated for error
     * @param customPattern String - validation pattern to be used by validator component.
     *                  It is acceptable format of the data (Use constants in ComponentValidator)
     * @param minValue Object - the minimum acceptable value for this component,
     *              if set the value will be used as minimum boundry if null no minimum boundry will be used.
     * @param maxValue Object - the maximum acceptable value for this component,
     *              if set the value will be used as maximum boundry if null no maximum boundry will be used.
     * @param isRequired boolean - if set to true it means this component must not be empty (flag as it is required field)
     * @param customMessages (Optional Parameter) String  - custom error description message to be display. You can
     * pass 0-3 parameters.
     *     1st parameter is the description message for empty errors
     *     2nd parameter is the description message for format error
     *     3rd parameter is the description message for out of range error
     *
     * If this component is initialized with resource bundle object you can also pass keys for this message
     * so the component can read error description from resource bundle.
     *
     * If those parameter are not provided, the default English message (automatically generated description message)
     * will be used for the error description.
     */
    public void addComponent(UIInput component, String customPattern, Object minValue, Object maxValue, boolean isRequired, String... customMessages) {
        Validator validator = addValidator(component, 0, isRequired);
        if (validator != null) {
            validator.setMaxValue(maxValue);
            validator.setMinValue(minValue);
            validator.setCustomPattern(customPattern);
            setCustomMessage(validator, customMessages);
        }
    }

    /**
     * This method is used to register user data entry component like IceFace TextBox
     * and IceFace ComboBox to validator component for validation.
     * <b>Note</b> This method is not used to do the actualy validation, it only register the component
     * for validation. You need to call isAllComponenetValid() of ComponentValidator object to do the validation.
     * Specially this method is used to implement custom validation pattern rather than
     * predefined patterns.
     * Use this method only if you have special data format requirement that will not be
     * addressed by the predefined patterns.
     *
     * @param component UIInput - data entry component to be validated for error
     * @param customPattern String - validation pattern to be used by validator component.
     *                  It is acceptable format of the data (Use constants in ComponentValidator)
     * @param itemList List<Object> - list of acceptable values, if provided the data in the data entry contoroller must be on of the list given.
     * @param isRequired boolean - if set to true it means this component must not be empty (flag as it is required field)
     * @param customMessages (Optional Parameter) String  - custom error description message to be display. You can
     * pass 0-3 parameters.
     *     1st parameter is the description message for empty errors
     *     2nd parameter is the description message for format error
     *     3rd parameter is the description message for out of range error
     *
     * If this component is initialized with resource bundle object you can also pass keys for this message
     * so the component can read error description from resource bundle.
     *
     * If those parameter are not provided, the default English message (automatically generated description message)
     * will be used for the error description.
     */
    public void addComponent(UIInput component, String customPattern, List<Object> itemList, boolean isRequired, String... customMessages) {
        Validator validator = addValidator(component, 0, isRequired);
        if (validator != null) {
            validator.setItemList(itemList);
            validator.setCustomPattern(customPattern);
            setCustomMessage(validator, customMessages);
            try {
                Pattern.compile(customPattern);
                validator.setCustomPattern(customPattern);
            } catch (PatternSyntaxException e) {
            }
        }
    }

    /**
     * Is used to mark user data entry component as format error manually.
     * It highlights the component with a format error indication color and set
     * description message on it.
     * Use this interface to mark data entry component as format error after performing your
     * own validation against the component.
     *
     * @param component UIInput - User data entry component to mark as format error.
     * @param errorMessage String - error message to be displayed on the data entry component.
     */
    public void markAsFormatError(UIInput component, String errorMessage) {
        Validator validator = addValidator(component, 0, true);
        if (validator != null) {
            setCustomMessage(validator, "", errorMessage);
            validator.clearErrorIndication();
            validator.displayAppropriateMessage(Validator.FORMAT_ERROR);
        }
    }

    /**
     * Is used to mark user data entry component as required error manually.
     * It highlights the component with a required error indication color and set
     * description message on it.
     * Use this interface to mark data entry component as required error after performing your
     * own validation against the component.
     *
     * @param component UIInput - User data entry component to mark as format error.
     * @param errorMessage String - error message to be displayed on the data entry component.
     */
    public void markAsRequiredError(UIInput component, String errorMessage) {
        Validator validator = addValidator(component, 0, true);
        if (validator != null) {
            setCustomMessage(validator, errorMessage);
            validator.clearErrorIndication();
            validator.displayAppropriateMessage(Validator.REQUIRED_ERROR);
        }
    }

    /**
     * Is used to mark user data entry component as out of range error manually.
     * It highlights the component with an out of range error indication color and set
     * description message on it.
     * Use this interface to mark data entry component as out of range error after performing your
     * own validation against the component.
     *
     * @param component UIInput - User data entry component to mark as format error.
     * @param errorMessage String - error message to be displayed on the data entry component.
     */
    public void markAsOutOfRangeError(UIInput component, String errorMessage) {
        Validator validator = addValidator(component, 0, true);
        if (validator != null) {
            setCustomMessage(validator, "", "", errorMessage);
            validator.clearErrorIndication();
            validator.displayAppropriateMessage(Validator.OUT_OF_RANGE_ERROR);
        }
    }

    /**
     * This method is used to clear any error mark from data entry component.
     * Use this method especially if you mark the component as error manually using
     * markAsFormatError, markAsRequiredError or markAsOutOfRangeError methods after performing
     * your own validation.
     *
     * @param component UIInput - user data entry component to clear error mark from it.
     */
    public void clearError(UIInput component) {
        Validator validator = addValidator(component, 0, true);
        if (validator != null) {
            validator.clearErrorIndication();
        }
    }

    /**
     * This method is used to retrieve text from resource bundle provided when initializing ComponentValidator
     * object. If text if found in the bundle it returns it else if the resource bundle is null (not initialized) or
     * key not found it returns empty string.
     * @param key String - Key of the text in resource bundle.
     * @return String - text found by the key.
     */
    private String getMessageFromBundle(String key) {
        String result = key;
        if (resourceBundle != null) {
            try {
                result = resourceBundle.getString(key);
            } catch (Exception e) {
                result = "";
            }
        }
        return result;
    }

    /**
     * This method is used to parse and set error description messages to validator object.
     * Error description is array string in order of required error, format error, and out of range error.
     * It will set only if a value is provided else auto generated message will be used.
     *
     * @param validator - Validator object to set message to.
     * @param messages - message to be parsed and set to for each type of error
     */
    private void setCustomMessage(Validator validator, String... messages) {
        if (messages != null) {
            if (messages.length > 0) {
                if (messages[0].trim().length() > 0) {
                    validator.setRequiredErrorMessage(getMessageFromBundle(messages[0]));
                }
            }
        }
        if (messages.length > 1) {
            if (messages[1].trim().length() > 0) {
                validator.setFormatErrorMessage(getMessageFromBundle(messages[1]));
            }
        }
        if (messages.length > 2) {
            if (messages[2].trim().length() > 0) {
                validator.setOutOfRangeErrorMessage(getMessageFromBundle(messages[2]));
            }
        }
    }

   /**
     * This method is used to validate all registered data entry components using
     * validation rules set during registration of component. It validates all components
     * and returns boolean value which represent validation result.
     *
     * @return boolean - if <b>true</b> all components validated are free of error
     *  if <b>false</b>  is returned one or more registered components have error and mark
     * with error indication.
     */
    public boolean isAllComponenetValid() {
        boolean result = false;
        int counter = 0;
        for (Validator validator : validationList) {//Iterate through each registered components for validation
            counter += validator.validateData();//Validate for error and add the result to count which holds count of errors
        }

        result = (counter == 0); //if count is 0 there is no error else one or more error occured
        return result;
    }
}

