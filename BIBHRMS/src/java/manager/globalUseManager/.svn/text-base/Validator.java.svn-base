/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.globalUseManager;

/**
 *
 * @author Administrator
 */



import java.util.List;

/**
 * Abstract class (Parent class for specific Data entry validator
 * class (InputText and SelectOne Validator)
 * This class is used to do the actual data validation task.
 *
 * @author Elias
 */
abstract class Validator {

    //Error types constants
    /**
     * This indicate  there is no error in the data entry controller
     */
    public static final int NO_ERROR = 0;
    public static final int REQUIRED_ERROR = 1; // This indicate the component is required and it is empty
    /**
     * This indicate the data in the component has format error
     */
    public static final int FORMAT_ERROR = 2;
    /**
     * Indicate the data in the component is beyond acceptable range
     */
    public static final int OUT_OF_RANGE_ERROR = 3;

    //Error indication style class constants
    /**
     * Style sheet class to set for format error
     */
    protected static final String FORMAT_ERROR_STYLE = "formatErrorIndicator";
    /**
     * Style sheet class to set for empty error
     */
    protected static final String EMPTY_ERROR_STYLE = "emptyErrorIndicator";
    /**
     * Style sheet class to set for out of range error
     */
    protected static final String OUT_OF_RANGE_ERROR_STYLE = "outOffRangeErrorIndicator";

    //Validation criteria
    private int pattern = 0; //Indicate which pattern to use for format validation (Phone Number, Email, Website ...)
    private boolean required = false;//Indicate if the component is required or not, true means the component is marked as required and if it is empty it is an error.
    private Object minValue = null;//Acceptable minimum value for the component, if the data in the componenet is bellow this value it is an error.
    private Object maxValue = null;//Acceptable maximum value for the component, if the data in the component is abouve this value it is an error.
    private List<Object> itemList = null;//List of valid items, the data in the component must be one of the items in the list else it is an error.
    private String customPattern = "";// Custom validation pattern set by cliant. Used only when set by cliant.
    private String requiredErrorMessage = "";// Custom required error message set.
    private String formatErrorMessage = "";// Custom format error message set.
    private String outOfRangeErrorMessage = "";// Custom out of range error message set.
    private String fieldType = "";//Indicates type of pattern used email, phone, to generate validation message automaticaly

    /**
     *
     * @return itemList
     */
    public List<Object> getItemList() {
        return itemList;
    }

    /**
     *
     * @param itemList
     */
    public void setItemList(List<Object> itemList) {
        this.itemList = itemList;
    }

    public void setCustomPattern(String customPattern) {
        this.customPattern = customPattern;
    }

    /**
     * This method is used to validate data stored in the data entry component.
     * It checks the component for all types of data error required, format, range, custompattern
     * and returns 0,1,2,3 for each of error types respectively
     *
     * @return int - An integer  number which represent result of validation.
     *      <br>Validator.NO_ERROR  - There is no error in the component.
     *      <br>Validator.REQUIRED_ERROR  - empty error.
     *      <br>Validator.FORMAT_ERROR  - format error.
     *      <br>Validator.OUT_OF_RANGE_ERROR  - out of acceptable range.
     */
    public int validateData() {
        int result = Validator.NO_ERROR;
        clearErrorIndication();

        Object data = getComponentData();

        String value = "";
        if (data != null) {//Cast Object data to string if it is not null
            value = data.toString();
            value = value.trim();
        }
//Perfom each error check layer by layer with order: required->format->range
        if (isEmpty(value)) {//Required Entry validation layer
            if (required == true) {
                result = Validator.REQUIRED_ERROR;
            }
        } else if (!isCorrectFormat(value)) {//Format entry validation layer
            result = Validator.FORMAT_ERROR;
        } else if (!isInGivenRange(value)) { //Range entry validation layer
            result = Validator.OUT_OF_RANGE_ERROR;
        }

        //Finaly display error description to control and set error indication style class
        if (result != Validator.NO_ERROR) {
            displayAppropriateMessage(result);
        }
        return result;
    }

    /**
     * Checks if the given value is empty or not
     * @param value the data to check
     * @return boolean - true the value is empty else false
     */
    private boolean isEmpty(String value) {
        boolean result = true;
        result = !(value.length() > 0);
        return result;
    }

    /**
     * Check if the given value is in a correct format or not.
     * If validation pattern is selected it validates the data against selected patter
     * else it use custompattern.
     *
     * @param value - String value to check against the patter selected or custom pattern provided
     * @return boolean - true if the data matches the pattern or no check pattern is provided or selected
     *                     false if the data didn’t match the pattern provided
     */
    private boolean isCorrectFormat(String value) {
        boolean result = true;

        if (pattern != ComponentValidator.NO_FORMAT) {//Pattern match is required
            result = isPatternMatch(value);//Data doesnt match with the given pattern
        } else if (!(customPattern.length() == 0)) {//Check for existance of custom pattern set
            result = value.matches(customPattern);
        }
        return result;
    }

    /**
     * Checks if the data is in a given range.
     * The range validation can be to check if the data is one of the given items,
     * or between the given maximum and minimum bound or character length of the data
     * within the given maximum and minimum bound.
     * If item list is provided it checks for one of given item validation
     * else if the min and max bound are given it checks the data is between those bounds
     * @param value - String data to check for range validation
     * @return boolean - true if the value is in range else false.
     */
    private boolean isInGivenRange(String value) {
        boolean result = true;

        if (this.getItemList() != null && !this.getItemList().isEmpty()) {//Do one of given item list validation
            result = isOnOfGivenItem(value);
        } else {
            result = isUnderMaximumBound(value) & isAboveMinimumBound(value);
        }
        return result;
    }

    /**
     * Check if the given string data is a number or not
     * @param data - String data to check if it is number or not
     * @return boolean - true if it is number else false
     */
       private boolean isDataNumber(String data) {
        boolean result = false;
        for (char c : data.toCharArray()) {
            result = Character.isDigit(c);
            if (result == false && c != '.' && c!='-') {
                break;
            }
        }
        return result;
    }

    /**
     * Check if the given data is one of the list of items provided.
     * @param data - String data to check
     * @return boolean - true if the given data is one of the items in the list, else false.
     */
    private boolean isOnOfGivenItem(String data) {
        boolean result = false;
        boolean isNumber = isDataNumber(data);
        double numberValue = 0;
        if (isNumber) {
            numberValue = Double.parseDouble(data);
        }
        for (Object obj : this.getItemList()) {
            if (obj instanceof Number && isNumber) {
                if ((Double.parseDouble(obj.toString()) == numberValue)) {
                    result = true;
                    break;
                }
            } else if (data.equalsIgnoreCase(obj.toString())) {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * This method is used to check if the given data is under the maximum bound given.
     * It checks for bound only if maximum bound is given.
     * @param data - String data to validate for.
     * @return boolean - true if the data is under maximum bound (acceptable range), else false
     */
    private boolean isUnderMaximumBound(String data) {
        boolean result = true;
        Object bound = this.getMaxValue();
        if (bound != null) { //Check only if maximum bound is given
            if (bound instanceof Number) {
                if (isDataNumber(data)) { //check for numerical comparison
                    result = (Double.parseDouble(data) <= Double.parseDouble(bound.toString()));
                } else {//Check for character length
                    result = (data.length() <= Integer.parseInt(bound.toString()));
                }

            } else if (bound instanceof String) {//use string comparison, because both are string values
                result = (bound.toString().compareToIgnoreCase(data) >= 0);
            }
        }
        return result;
    }

    /**
     * This method is used to check if the given data is above the minimum bound given.
     * It checks for bound only if minimum bound is given.
     * @param data - String data to validate for.
     * @return boolean - true if the data is above minimum bound (acceptable range), else false
     */
    private boolean isAboveMinimumBound(String data) {
        boolean result = true;
        Object bound = this.getMinValue();
        if (bound != null) {
            if (bound instanceof Number) {
                if (isDataNumber(data)) {
                    result = (Double.parseDouble(data) >= Double.parseDouble(bound.toString()));
                } else {
                    result = (data.length() >= Integer.parseInt(bound.toString()));
                }

            } else if (bound instanceof String) {
                result = (bound.toString().compareToIgnoreCase(data) <= 0);
            }
        }
        return result;
    }

    /**
     * This method is used to prepare message for the error type occurred, and
     * set on the data entry control for future display.
     * If custom message is provided by client it uses it
     * else it will prepare automated English message.
     *
     * @param errorType - int value to indicate error type occurred
     */
    public void displayAppropriateMessage(int errorType) {

        if (errorType == Validator.REQUIRED_ERROR) {// If Error type is required error
            if (this.requiredErrorMessage.length() == 0) {
                this.requiredErrorMessage = this.fieldType + " Can't be empty";
            }
            this.setErrorIndication(Validator.EMPTY_ERROR_STYLE, this.requiredErrorMessage);

        } else if (errorType == Validator.FORMAT_ERROR) {//If Error type is format error
            if (this.formatErrorMessage.length() == 0) {
                this.formatErrorMessage = "This doesn't look like valid " + this.fieldType;
            }
            this.setErrorIndication(Validator.FORMAT_ERROR_STYLE, this.formatErrorMessage);

        } else if (errorType == Validator.OUT_OF_RANGE_ERROR) {//If Error type is range error
            if (this.outOfRangeErrorMessage.length() == 0) {

                this.outOfRangeErrorMessage = getRangeErrorMessage();
            }
            this.setErrorIndication(Validator.OUT_OF_RANGE_ERROR_STYLE, this.outOfRangeErrorMessage);
        }

    }

    /**
     * This method prepares automated error message for out of range error types.
     * @return String - prepared automated error message
     */
    private String getRangeErrorMessage() {
        String result = "The value you entered is not in acceptable range.";
        int count =1;
        if (this.itemList != null) {
            result = "";
            for (Object obj : this.itemList) {
                result += obj.toString() + ",";
                count++;
                if (count==3){//Limit item list to 3 if itemList has more than 3 items to short message display
                    break;
                }
            }

            result = "You can enter only values " + result.substring(0, result.length() - 1);
        } else {
            if (this.minValue != null & this.maxValue != null) {
                result = "You can enter only values between " + this.minValue.toString() + " and " + this.maxValue.toString();
            } else if (this.minValue != null) {
                result = "You can enter only values greater than " + this.minValue.toString();
            } else if (this.maxValue != null) {
                result = "You can enter only values less than " + this.maxValue.toString();
            }
        }

        return result;
    }

    /**
     * This method check if the given data match the pattern selected
     * or custom pattern provided if any. After checking the data against the pattern
     * selected it sets fieldType variable to specific validation pattern used for automated message preparation purpose only.
     *
     * @param data - the data to match against the pattern given
     * @return boolean - true if the data match the pattern given, else false
     */
    private boolean isPatternMatch(String data) {
        boolean result = false;

        if (data != null) {//If data is not null (it has value)
            switch (pattern) {
                case ComponentValidator.ETH_DATE://Ethiopian date format (YYYY-MM-DD OR YYYY/MM/DD)
                    result = data.matches("[1-9]{1}[0-9]{3}" + //Year
                            "((\\/)|(-))" + //- or /
                            "((((0?[1-9])|1[0-2])" + //Month 01-12
                            "((\\/)|(-))" + //- or /
                            "((0?[1-9])|([1-2][0-9])|30))" + //Date for month 01-12
                            "|13((\\/)|(-))0?[1-6])( [0-1]?[1-9]:[0-5]?[0-9](( PM)|( AM))?)?"); //13th month and date
                    fieldType = "Ethiopian Date";
                    break;
                case ComponentValidator.GC_DATE: //Gregorian Date format (YYYY-MM-DD OR YYYY/MM/DD)
                    result = data.matches("([1-9]{1}[0-9]{3}" + //Year
                            "((\\/)|(-))" + //- or /
                            "((0?[1-9])|1[0-2])" +//Month
                            "((\\/)|(-))" +//- or /
                            "((0?[1-9])|([1-2][0-9])|3[0-1]))|" + //Date
                            "(((0?[1-9])|([1-2][0-9])|3[0-1])((\\/)|(-))((0?[1-9])|1[0-2])((\\/)|(-))([1-9]{1}[0-9]{3}))");//Date
                    fieldType = "Gregorian Date";
                    break;
                case ComponentValidator.EMAIL://Email format
                    result = data.matches("(([a-zA-Z0-9-\\_\\.]+@[a-zA-Z]{2,5}" +
                            "+\\.[a-zA-Z ]{2}+$)||([a-zA-Z0-9-\\_\\.]+@[a-zA-Z]" +
                            "{2,5}+\\.[a-zA-Z ]{3}+$))");
                    fieldType = "Email Address";
                    break;
                case ComponentValidator.FLOAT_NUMBER:// Float number format
                    result = data.matches("([0-9]{1,10})|([0-9]{1,10}\\.?[0-9]{1,10})");
                    fieldType = "Number";
                    break;
                case ComponentValidator.PERSON_NAME: //First name of person eg Dr. Zelalem
                    result = data.matches("[A-Za-z-\\.\\&\\/ ]{1,60}");
                    fieldType = "Person Name";
                    break;
                case ComponentValidator.PHONE_NUMBER://Ethiopian Phone number (landline or mobile phones)
                    result = data.matches("^\\+?251\\-?\\-?[1-9][0-9]{2}\\-?[0-9]{6}|$|" +
                            "^[0][1-9][0-9]{2}\\-?[0-9]{6}|$|" +
                            "^\\+?[0-9]{1,3}\\-?\\-?[0-9]{3}\\-?[0-9]{6}$");
                    fieldType = "Phone number";
                    break;
                case ComponentValidator.REMARK_COMMENT://
                    result = data.matches("[a-zA-Z0-9 \\-]{0,200}");
                    fieldType = "Remark";
                    break;
                case ComponentValidator.TEXT_AND_NUMBER:
                    result = data.matches("^[a-zA-Z0-9\\& \\/\\.\\-#\\ ]{2,60}$");
                    fieldType = "Text";
                    break;
                case ComponentValidator.TEXT_A_TO_Z_ONLY:
                    result = data.matches("^[a-zA-Z ]+$");
                    fieldType = "Text";
                    break;
                case ComponentValidator.WEB_SITE:
                    result = data.matches("^[w]{3}+\\.[a-zA-Z0-9-]+\\.[a-zA-Z]{2,10}+\\.[a-zA-Z ]{2}+$|^[w]{3}+\\.[a-zA-Z0-9-]+\\.[a-zA-Z ]{2,10}+$");
                    fieldType = "Web Site Address";
                    break;
                case ComponentValidator.INTEGER_NUMBER:
                    result = data.matches("^\\-?[1-9 ]+[0-9]*$");
                    fieldType = "Number";
                    break;

                case ComponentValidator.TIME:
                    result = data.matches("^[0-1]?[1-9]:[0-5]?[0-9](( PM)|( AM))?$");
                    fieldType = "Time";
                    break;

                case ComponentValidator.FULL_NAME://Full name of person like Dr. Zelalem Asegid
                    result = data.matches("[a-zA-z \\.]{2,50}");
                    fieldType = "Full Name";
                    break;

                default:
                    result = false;
            }
            if (customPattern.length() > 0 && result == true) {//Check if custom pattern is given, and there is no error
                result = data.matches(customPattern); //check data against custom pattern given
            }
        }
        return result;
    }

    /**
     * Abstract method which needs to be implemented in the concrete class of this class.
     * It is used to return user entered data from data entry component. The actual implementation is
     * left to be defined by concrete class because each components have different way of retrieving data in the component
     * @return Object - value of the data entry component (user entered data)
     */
    public abstract Object getComponentData();
/**
 * Abstract method used to clear error indications from data entry component,
 * this includes clearing of color set, message text, and javascript methods
 * set to be called to display message text.
 */
    public abstract void clearErrorIndication();

/**
 * Abstract method used to set error indication on data entry component,
 * this include to set error indicator color, descriptive message text and JavaScript  methods
 * to be called to display error description message.
 * @param styleClass - style class to highlight data entry components with error.
 * @param message - error description message to be displayed
 */
    public abstract void setErrorIndication(String styleClass, String message);

    /**
     * @return the pattern
     */
    public int getPattern() {
        return pattern;
    }

    /**
     * @param pattern the pattern to set
     */
    public void setPattern(int pattern) {
        this.pattern = pattern;
    }

    /**
     * @return the required
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * @param required the required to set
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

    /**
     * @return the minValue
     */
    public Object getMinValue() {
        return minValue;
    }

    /**
     * @param minValue the minValue to set
     */
    public void setMinValue(Object minValue) {
        this.minValue = minValue;
    }

    /**
     * @return the maxValue
     */
    public Object getMaxValue() {
        return maxValue;
    }

    /**
     * @param maxValue the maxValue to set
     */
    public void setMaxValue(Object maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * @return the requiredErrorMessage
     */
    public String getRequiredErrorMessage() {
        return requiredErrorMessage;
    }

    /**
     * @param requiredErrorMessage the requiredErrorMessage to set
     */
    public void setRequiredErrorMessage(String requiredErrorMessage) {
        this.requiredErrorMessage = requiredErrorMessage;
    }

    /**
     * @return the formatErrorMessage
     */
    public String getFormatErrorMessage() {
        return formatErrorMessage;
    }

    /**
     * @param formatErrorMessage the formatErrorMessage to set
     */
    public void setFormatErrorMessage(String formatErrorMessage) {
        this.formatErrorMessage = formatErrorMessage;
    }

    /**
     * @return the outOfRangeErrorMessage
     */
    public String getOutOfRangeErrorMessage() {
        return outOfRangeErrorMessage;
    }

    /**
     * @param outOfRangeErrorMessage the outOfRangeErrorMessage to set
     */
    public void setOutOfRangeErrorMessage(String outOfRangeErrorMessage) {
        this.outOfRangeErrorMessage = outOfRangeErrorMessage;
    }
}
