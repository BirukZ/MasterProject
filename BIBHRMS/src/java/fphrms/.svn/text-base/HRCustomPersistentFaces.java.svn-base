/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms;

/**
 *
 * @author DPClone
 */
import com.icesoft.faces.webapp.xmlhttp.PersistentFacesServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HRCustomPersistentFaces extends PersistentFacesServlet {

    @Override
    public void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
        try {
            super.service(arg0, arg1);
        } catch (Exception ex) {
             arg0.getSession().invalidate();
            arg1.sendRedirect(arg0.getContextPath() + "/ResourceNotFound.jsp");
        // redirect only to other of jsf filter ( no *.jsp ...)
        }
    }
}
