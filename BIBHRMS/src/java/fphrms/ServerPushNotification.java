/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms;

import com.icesoft.faces.async.render.SessionRenderer;

/**
 *
 * @author DPClone
 */
public class ServerPushNotification {

    public void NewResignRequests(javax.faces.event.ActionEvent ae) {
        SessionRenderer.render("all");
    }
}
