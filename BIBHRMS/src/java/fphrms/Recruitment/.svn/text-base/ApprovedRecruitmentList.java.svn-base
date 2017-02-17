/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Recruitment;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlForm;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import java.io.IOException;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import javax.faces.event.ActionEvent;
import javax.faces.application.*;
import com.icesoft.faces.component.ext.HtmlOutputText;
import java.util.HashMap;
import javax.el.ExpressionFactory;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import manager.recruitmentManager.AdvertisementManager;
import manager.recruitmentManager.RecruitmentManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ApprovedRecruitmentList extends AbstractPageBean {

    AdvertisementManager advertisementManager = new AdvertisementManager();
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    RecruitmentManager recruitmentManager = new RecruitmentManager();

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
    private PanelCollapsible panelCollapsible2 = new PanelCollapsible();

    public PanelCollapsible getPanelCollapsible2() {
        return panelCollapsible2;
    }

    public void setPanelCollapsible2(PanelCollapsible pc) {
        this.panelCollapsible2 = pc;
    }
    private PanelLayout container = new PanelLayout();

    public PanelLayout getContainer() {
        return container;
    }

    public void setContainer(PanelLayout pl) {
        this.container = pl;
    }
    private PanelLayout approved_recruitment_list = new PanelLayout();
    static int n;

    public PanelLayout getApproved_recruitment_list() {
        String department;
        HtmlGraphicImage img;
        HtmlOutputText text;

        n = recruitmentManager.count();
//        if (n <= 6) {
////            btnNext.setRendered(false);
//        }
        HtmlCommandLink link[] = new HtmlCommandLink[n];
        //  n = APPROVED_RECRUITMENT_LIST_SIZE < n ? APPROVED_RECRUITMENT_LIST_SIZE : n;
        lblOutputext.setValue(n + " Requests");

        String coded = "id";
        HashMap[] list = recruitmentManager.buildRecruitmentList();


        if (n > 0) {
              lblNotAvilabelMessage.setRendered(false);
            for (int i = 0; i < n; i++) {
                department = recruitmentManager.readDepartment(list[i].get("REQUESTER_ID").toString());
                coded = "id";
                coded = coded + list[i].get("recruit_Request_Id").toString();
                link[i] = new HtmlCommandLink();
                link[i].setStyle("COLOR: #096b89; TEXT-DECORATION: none");
                link[i].setValue(list[i].get("JOB_DESCRIPTION"));

                link[i].setId(coded);
                FacesContext context = FacesContext.getCurrentInstance();

                Application application = context.getApplication();
                ExpressionFactory ef = application.getExpressionFactory();

                Application app = FacesContext.getCurrentInstance().getApplication();
                javax.faces.el.MethodBinding mb = app.createMethodBinding("#{Recruitment$ApprovedRecruitmentList.commandLink_action}", new Class[]{ActionEvent.class});
                link[i].setActionListener(mb);


                text = new HtmlOutputText();
                text.setStyleClass("list_element_text");
                text.setEscape(false);
                text.setValue("<br/>" + "Department" + " : " + department +
                        "<br/>" + "Approved Date" + " : " + list[i].get("approved_Date") + " <br /><br />");


                img = new HtmlGraphicImage();
                img.setUrl("/resources/line.JPG");
                approved_recruitment_list.getChildren().add(link[i]);
                approved_recruitment_list.getChildren().add(text);
                approved_recruitment_list.getChildren().add(img);
            }
        } else {
            lblNotAvilabelMessage.setRendered(true);
        }
        return approved_recruitment_list;

    }

    public void setApproved_recruitment_list(PanelLayout pl) {
        this.approved_recruitment_list = pl;
    }
    private HtmlForm form1 = new HtmlForm();

    public HtmlForm getForm1() {
        return form1;
    }

    public void setForm1(HtmlForm hf) {
        this.form1 = hf;
    }
    private HtmlOutputText lblOutputext = new HtmlOutputText();

    public HtmlOutputText getLblOutputext() {
        return lblOutputext;
    }

    public void setLblOutputext(HtmlOutputText hot) {
        this.lblOutputext = hot;
    }
    private HtmlOutputText lblNotAvilabelMessage = new HtmlOutputText();

    public HtmlOutputText getLblNotAvilabelMessage() {
        return lblNotAvilabelMessage;
    }

    public void setLblNotAvilabelMessage(HtmlOutputText hot) {
        this.lblNotAvilabelMessage = hot;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ApprovedRecruitmentList() {
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
        HtmlCommandLink link1 = new HtmlCommandLink();
        link1 = new HtmlCommandLink();
        link1.setStyle("COLOR: #096b89; TEXT-DECORATION: none");
        link1.setValue("JOB_DESCRIPTION");
        link1.setId("coded");
                    FacesContext context = FacesContext.getCurrentInstance();

        Application application = context.getApplication();
        ExpressionFactory ef = application.getExpressionFactory();
//            MethodExpression me = ef.createMethodExpression(context.getELContext(), "#{Recruitment$ApprovedRecruitmentList.commandLink1_processAction}", String.class, new Class[]{});
        Application app = FacesContext.getCurrentInstance().getApplication();
        javax.faces.el.MethodBinding mb = app.createMethodBinding("#{Recruitment$ApprovedRecruitmentList.commandLink_action}", new Class[]{ActionEvent.class});
        link1.setActionListener(mb);
        form1.getChildren().add(link1);

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

    public void panelBorder1north_processMyEvent(DragEvent de) {
    }

    public String commandLink1_processAction() {

        String indexValue = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("Id");

        return indexValue;



    }

    public String commandLink_action(ActionEvent event) {
        String adver = "advert";
        Object obj = event.getSource();
        String lastItem = null;
        if (obj instanceof HtmlCommandLink) {
            HtmlCommandLink item = (HtmlCommandLink) obj;
            if (item != null) {
                lastItem = item.getId().toString();

            }
        }

        lastItem = lastItem.substring(2);

        advertisementManager.setSearchCode(lastItem);
        try {
            this.redirect();
        } catch (Exception ex) {
        }
//        FacesContext facesContext=javax.faces.context.FacesContext.getCurrentInstance();
//        FacesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "OUTCOME");
        return adver;
    }

    void redirect() throws IOException {
//        FacesContext.getCurrentInstance().getExternalContext().redirect("/Recruitment/MaintainAdvertisement.jsp");
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response =
                (HttpServletResponse) context.getExternalContext().getResponse();
        response.sendRedirect("../Recruitment/MaintainAdvertisement.jsp");
        context.responseComplete();

    }

    public String commandLink1_action() {
        //return null means stay on the same page
        String adver = "advert";


        return adver;
    }

    public void commandLink1_processAction(ActionEvent ae) {
    }

    public String hlnkRequestCommented_action() {
        //return null means stay on the same page
        return "RequirementRequest";
    }

    public String lnkTerminationApprovalComment_action() {
        //return null means stay on the same page
        return "ApprovedRecruitmentList";
    }

    public String lnkResignationType_action() {
        //return null means stay on the same page
        return "MaintainAdvertisement";
    }

    public String commandLink3_action() {
        //return null means stay on the same page
        return "FilterCandidates";
    }
}
