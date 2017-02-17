/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright mekete
 */
package fphrms.Organization;

import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.tree.IceUserObject;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import javax.faces.FacesException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import manager.organizationManager.OrganizationManager;
import fphrms.Help.Template;
import fphrms.pageSecurity.PageAdmin;
import fphrms.pageSecurity.ChangeUserPassword;
import fphrms.pageSecurity.Login;
import fphrms.PowerDeligation.PowerDeligationApprovePage;
import fphrms.Report.MainReport;
import fphrms.pageSecurity.Error;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class OrganizationTreePage extends AbstractPageBean {

    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public OrganizationTreePage() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     *
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

    // </editor-fold>
    // Perform application initialization that must complete
    // *after* managed components are initialized
    // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    public void prerender() {
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    private static DefaultMutableTreeNode addNode(DefaultMutableTreeNode parent,
            String title, String DPlan) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        IceUserObject userObject = new IceUserObject(node);

        userObject.setLeafIcon("../xmlhttp/css/rime/css-images/tree_document.gif");
        userObject.setBranchContractedIcon("../xmlhttp/css/rime/css-images/tree_folder_closed.gif");
        userObject.setBranchExpandedIcon("../xmlhttp/css/rime/css-images/tree_folder_open.gif");
        userObject.setBranchContractedIcon("../xmlhttp/css/rime/css-images/tree_nav_bottom_close.gif");
        userObject.setExpanded(true);

        node.setUserObject(userObject);
        //userObject.setTreeNode(employee);
        //branch
        if (title != null) {
            userObject.setText(title);
            userObject.setLeaf(false);
            userObject.setExpanded(false);
            node.setAllowsChildren(true);
        } // leaf node
        else {
            userObject.setText(DPlan);
            userObject.setLeaf(true);
            node.setAllowsChildren(false);
        }
        // finally add the node to the parent.
        if (parent != null) {
            parent.add(node);
        }

        return node;
    }

    public static DefaultTreeModel getTreeModel() {
        OrganizationManager organizationManager = new OrganizationManager();
        String hederValue = null;
        try {
            OrganizationManager root = organizationManager.readRoot();
            ArrayList<OrganizationManager> allDepartments = organizationManager.readAllOrganizations();
            ArrayList<OrganizationManager> buffer = new ArrayList<OrganizationManager>();
            hederValue = root.getDeptDescription() + "#" + root.getDeptCode();
            buffer.add(root);
            DefaultMutableTreeNode rootNode = addNode(null, "Mugher Cement", "");
            DefaultMutableTreeNode currentNode = rootNode;

            int index = 0;
            while (index < buffer.size()) {
                DefaultMutableTreeNode innerNode = null;
                String innNode = "";
                if (innerNode == null) {
                    innNode = "node is null ";
                } else {
                    innNode = "depth of inner node of treee"+Integer.toString(innerNode.getDepth());
                }
                OrganizationManager current = buffer.get(index);
                currentNode = addNode(currentNode, current.getDeptDescription() + "#" + current.getDeptCode(), "");
                int innerIndex = 0;
                while (innerIndex < allDepartments.size()) {
                    if (current.getDeptCode().equalsIgnoreCase(allDepartments.get(innerIndex).getBranchID())) {
                        innerNode = addNode(currentNode, allDepartments.get(innerIndex).getDeptDescription() + "#" + allDepartments.get(innerIndex).getDeptCode(), "");
                        buffer.add(allDepartments.get(innerIndex));
                        allDepartments.remove(innerIndex);
                    }
                    innerIndex++;
                }
                index++;
            }
            return new DefaultTreeModel(rootNode);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        // tree1.setRendered(false);
        }
    // panelLayout3.setRendered(true);
    }

   
    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected Template getHelp$Template() {
        return (Template) getBean("Help$Template");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PageAdmin getpageSecurity$PageAdmin() {
        return (PageAdmin) getBean("pageSecurity$PageAdmin");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ChangeUserPassword getpageSecurity$ChangeUserPassword() {
        return (ChangeUserPassword) getBean("pageSecurity$ChangeUserPassword");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected Login getpageSecurity$Login() {
        return (Login) getBean("pageSecurity$Login");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PowerDeligationApprovePage getPowerDeligation$PowerDeligationApprovePage() {
        return (PowerDeligationApprovePage) getBean("PowerDeligation$PowerDeligationApprovePage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected MainReport getReport$MainReport() {
        return (MainReport) getBean("Report$MainReport");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected Error getpageSecurity$Error() {
        return (Error) getBean("pageSecurity$Error");
    }

   
}
