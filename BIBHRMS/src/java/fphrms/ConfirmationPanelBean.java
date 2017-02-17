/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms;

import java.io.Serializable;

/**
 *
 * @author DPClone
 */
public class ConfirmationPanelBean implements Serializable {

    private boolean withConfirmation = true;

    public boolean isWithConfirmation() {
        return withConfirmation;
    }

    public void setWithConfirmation(boolean withConfirmation) {
        this.withConfirmation = withConfirmation;
    }
}
