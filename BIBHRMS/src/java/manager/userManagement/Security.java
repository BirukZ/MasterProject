/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.userManagement;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.JOptionPane;

/**
 *
 * @author tseinsa
 */
public class Security implements Filter {

    SiteSecurityManager siteSecurityManager = new SiteSecurityManager();
    FilterConfig config = null;
    ServletContext servletContext = null;
    public static String resourceUrl;

    public void init(FilterConfig fConfig) throws ServletException {
        config = fConfig;
        servletContext = config.getServletContext();
    }

    /**
     * For Secured resources this method checks the user to be authenticated
     * and authorized to get the resource
     * @param req the Servlet request object
     * @param res Servlet response object
     * @param chain the filterChain object
     * @throws java.io.IOException
     * @throws javax.servlet.ServletException
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) req;
        resourceUrl = httpReq.getRequestURI();
        HttpServletResponse httpRes = (HttpServletResponse) res;
        //  resource exist and  not secured
     //   JOptionPane.showMessageDialog(null, resourceUrl);
        if (!siteSecurityManager.isSecurResource(httpReq.getRequestURI())) {
            //if request page is login page
            //user sign in -> forward to previously asked page
            if (httpReq.getRequestURI().compareTo(httpReq.getContextPath() + "/pageSecurity/Login.jsp") == 0 &&
                    //SessionBean1.getUserName() != null &&
                    httpReq.getSession().getAttribute("userName") != null &&
                    //SessionBean1.getPassword() != null &&
                    httpReq.getSession().getAttribute("password") != null &&
                    //SessionBean1.getRequestedPage() != null) {
                    httpReq.getSession().getAttribute("requestedPage") != null) {
                httpRes.sendRedirect(httpReq.getSession().getAttribute("requestedPage").toString());
            } //any page which need no security
            else {
                chain.doFilter(httpReq, httpRes);
            }
        } //if requested resource is secure -> check username and password
        else if (httpReq.getSession().getAttribute("userName") == null || httpReq.getSession().getAttribute("password") == null) {
            httpReq.getSession().setAttribute("requestedPage", httpReq.getRequestURI());
            httpRes.sendRedirect(httpReq.getContextPath() + "/pageSecurity/Login.jsp");
        } // if user already logged in -> authenticate and authorize user
        else if (siteSecurityManager.isValidUser(httpReq.getSession().getAttribute("userName").toString(), httpReq.getSession().getAttribute("password").toString())) {
            //if the user is accessing for the first time -> redirect to changeUserPassword Page
            if (siteSecurityManager.isFirstTimeAccess(httpReq.getSession().getAttribute("userName").toString())) {
                httpReq.getSession().setAttribute("firstTimeFlag", new Integer(0));
                httpReq.getSession().setAttribute("requestedPage", httpReq.getRequestURI());
                httpRes.sendRedirect(httpReq.getContextPath() + "/pageSecurity/ChangeUserPassword.jsp");
            } //else redirect to the the requested page
            else {
                httpReq.getSession().setAttribute("firstTimeFlag", new Integer(1));
                // if valid user (authenticated) -> authorize
                if (siteSecurityManager.isAuthorizeUser(httpReq.getSession().getAttribute("userName").toString(), httpReq.getRequestURI()))
                {
                    httpReq.getSession().setAttribute("requestedPage", httpReq.getRequestURI());
                    chain.doFilter(httpReq, httpRes);
                } // if not authorized
                else {
                    // login  error u'r are not allowed the resource???
                    httpReq.getSession().setAttribute("requestedPage", httpReq.getRequestURI());
                    httpRes.sendRedirect(httpReq.getContextPath() + "/AccessDenied.jsp");
                }
            }
        } // if not valid user
        else {
            httpReq.getSession().setAttribute("userName", null);
            httpReq.getSession().setAttribute("password", null);
            httpReq.getSession().setAttribute("requestedPage", httpReq.getRequestURI());
            httpRes.sendRedirect(httpReq.getContextPath() + "/pageSecurity/Login.jsp");

        }

    }

    public void destroy() {
    }
}
