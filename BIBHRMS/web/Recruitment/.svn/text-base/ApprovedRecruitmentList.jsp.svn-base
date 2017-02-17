<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : DavePro
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <script src="../Script/Ethiopian_Calendar.js"></script>
                <script src="../Script/jquery-1.3.2.min.js"></script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">

                <ice:form binding="#{Recruitment$ApprovedRecruitmentList.form1}" id="form1">
                    <div style="width:100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" height="auto" width="100%"/>
                        <ice:panelBorder height="480" id="whole_page" renderCenter="#{Recruitment$ApprovedRecruitmentList.panelBorder1Bean.renderCenter}"
                                         renderEast="#{Recruitment$ApprovedRecruitmentList.panelBorder1Bean.renderEast}"
                                         renderNorth="#{Recruitment$ApprovedRecruitmentList.panelBorder1Bean.renderNorth}"
                                         renderSouth="#{Recruitment$ApprovedRecruitmentList.panelBorder1Bean.renderSouth}"
                                         renderWest="#{Recruitment$ApprovedRecruitmentList.panelBorder1Bean.renderWest}" style="top: 5px; position: relative"
                                         styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup dragListener="#{Recruitment$ApprovedRecruitmentList.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
                                    <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow" style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                                     styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style=" height:100%;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                                     style="height:470px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: 5px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible1" style="height: 478px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass="">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid1" headerClass="iceDatTblColHdr1" width="100%">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$ApprovedRecruitmentList.hlnkRequestCommented_action}"
                                                                             id="hlnkRequestCommented" style="color:#306682;font-weight:bold" value="Recruitment Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$ApprovedRecruitmentList.lnkTerminationApprovalComment_action}"
                                                                             id="lnkTerminationApprovalComment" style="color:#306682;font-weight:bold" value="Request Approved List"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$ApprovedRecruitmentList.lnkResignationType_action}"
                                                                             id="lnkResignationType" style="color:#306682;font-weight:bold" value="Maintain Advertisement"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$ApprovedRecruitmentList.commandLink3_action}" id="commandLink3"
                                                                             style="color:#306682;font-weight:bold" value="Filter Candidates"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="cmdExamQuestion" style="color:#306682;font-weight:bold" value="Exam Questions"/>
                                                        </li>
                                                    </ul>
                                                    <br/>
                                                    <br/>
                                                    <br/>

                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 490px">
                                    <ice:panelLayout binding="#{Recruitment$ApprovedRecruitmentList.container}" id="container" layout="flow"
                                                     style="height: 476px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 460px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="LIST OF APPROVED RECRUITMENTS"/>
                                            </legend>
                                            <ice:panelLayout binding="#{Recruitment$ApprovedRecruitmentList.approved_recruitment_list}"
                                                             id="approved_recruitment_list"
                                                             style="height: 395px; left: 24px; top: 0px; overflow: auto; position: absolute; width: 450px" styleClass="icePnlClpsbl">
                                                <ice:outputStyle href="resources/stylesheet.css" id="outputStyle2"/>
                                                <ice:outputText binding="#{Recruitment$ApprovedRecruitmentList.lblOutputext}" id="lblOutputext" style="margin-left: 20px; margin-top: 370px; position: absolute"/>
                                                <ice:outputText binding="#{Recruitment$ApprovedRecruitmentList.lblNotAvilabelMessage}" id="lblNotAvilabelMessage"
                                                                rendered="false" style="font-size: 24px; height: 35px; left: 20px; top: 160px; position: absolute; width: 400px" value="Requirement request not Available"/>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid">
                                        <jsp:directive.include file="/FOOTER.jspf"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <div class="some">
                            <input id="cal_day_names" type="hidden" value="ሰ,ማ,ረ,ሐ,ዓ,ቅ,እ"/>
                            <input id="cal_month_names" type="hidden" value="መስከረም,ጥቅምት,ህዳር,ታህሳስ,ጥር,የካቲት,መጋቢት,ሚያዝያ,ግንቦት,ሰኔ,ሀምሌ,ነሀሴ,ጷግሜ"/>
                        </div>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
