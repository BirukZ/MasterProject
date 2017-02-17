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
public class ServerPushSessionBean extends ServerPushNotification {

    public ServerPushSessionBean() {
        SessionRenderer.addCurrentSession("all");
    }
}
