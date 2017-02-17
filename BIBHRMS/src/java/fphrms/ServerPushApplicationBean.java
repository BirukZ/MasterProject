/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms;

import com.icesoft.faces.async.render.SessionRenderer;
import java.util.ArrayList;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author DPClone
 */
public class ServerPushApplicationBean extends ServerPushNotification {

    public ServerPushApplicationBean() {
    }

    public synchronized void NewResignRequests(ActionEvent ae) {
        super.NewResignRequests(ae);
        SessionRenderer.render("all");
    }
}
