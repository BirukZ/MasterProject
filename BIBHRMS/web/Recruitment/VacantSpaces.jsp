<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : VacantSpaces
    Created on : Feb 4, 2011, 6:50:56 AM
    Author     : kibrom
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
                <style type="text/css">
                    .message {
                        display: none;
                        margin: 0 0 13px 0;
                        background-color:#EFA;
                        padding: 13px 13px 13px 52px;
                        background-position: 13px 5px;
                        border: solid 1px #BD8;                                                                                                                                                border: solid 1px #BD8;
                    }
                    .message2 {
                        display: none;
                        margin: 0 0 13px 0;
                        background-color:#EFA;
                        padding: 13px 13px 13px 52px;
                        background-position: 13px 5px;
                        border: solid 1px #BD8;                                                                                                                                                border: solid 1px #BD8;
                    }
                    .success{
                        color: #336600;
                        font-size: 12px;
                        font-weight: bold;
                        text-align: center;
                        vertical-align: middle;
                        top:5px;left: 0px;
                        position: absolute;
                        width: 100%
                    }
                    .error{
                        color: red;
                        font-size: 12px;
                        font-weight: bold;
                        text-align: center;
                        vertical-align: middle;
                        top:5px;left: 0px;
                        position: absolute;
                        width: 100%
                    }
                    .success1{
                        color: #336600;
                        font-size: 11px;
                        font-weight: bold;
                        height: 16px;
                        left: 5px;
                        top: 2px;
                        position: absolute;
                        text-align: left;
                        width: 391px
                    }
                    .error1{
                        color: red;
                        font-size: 11px;
                        font-weight: bold;
                        height: 16px;
                        left: 5px;
                        top: 2px;
                        position: absolute;
                        text-align: left;
                        width: 391px
                    }
                </style>
                <script language="javascript" type="text/javascript">
                    var $j=jQuery.noConflict();
                    function CandidateExperiencesPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
             <!--  <link HREF="./FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{Recruitment$VacantSpaces.panelBorder1Bean.renderCenter}"
                        renderEast="#{Recruitment$VacantSpaces.panelBorder1Bean.renderEast}"
                        renderNorth="#{Recruitment$VacantSpaces.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Recruitment$VacantSpaces.panelBorder1Bean.renderSouth}" renderWest="#{Page1.panelBorder1Bean.renderWest}"
                        style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                        <f:facet name="north">
                            <ice:panelGroup dragListener="#{Page1.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
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
                                    style="height: 312px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 273px; left: -4px; top: 13px; position: absolute; width: 213px" styleClass="list_menu">
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible1">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup1">
                                                    <ice:outputText id="lblRecruitmentRequest1" value="Common Tasks"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid headerClass="icePnlGrdHdr iceDatTblColHdr1" id="panelGrid1" width="100%">
                                                <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                    <li>
                                                        <ice:commandLink action="#{Recruitment$VacantSpaces.cmdRecruitment_action}" id="cmdRecruitment1"
                                                            immediate="true" partialSubmit="true"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Recruitment Request"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Recruitment$VacantSpaces.cmdRecruitmentApproval_action}"
                                                            id="cmdVacancyNoticeList" immediate="true" partialSubmit="true"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Vacancy Notice List"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Recruitment$VacantSpaces.cmdVacancyNotice_action}" id="cmdVacancyNotice1"
                                                            immediate="true" partialSubmit="true"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Maintain Advertisement"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Recruitment$VacantSpaces.cmdFilterCandidates_action}"
                                                            id="cmdFilterCandidates1" immediate="true" partialSubmit="true"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Filter Candidates"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Recruitment$VacantSpaces.cmdVacantSpaces_action}" id="cmdRecruitmentApproval"
                                                            immediate="true" partialSubmit="true" style="color:#306682;font-weight:bold" value="Recruitment Approval"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Recruitment$VacantSpaces.cmdRegisterCandidate_action}"
                                                            id="cmdRegisterCandidate1" immediate="true" partialSubmit="true"
                                                            style="color:#306682;font-weight:bold" value="Register Candidate"/>
                                                    </li>
                                                </ul>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 502px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="background-color: white; height: 500px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <ice:panelLayout id="plotablecontainer"
                                        style="border-width: 1px; border-style: dotted; height: 478px; left: 0px; top: 0px; position: absolute; width: 766px" styleClass="table_container">
                                        <ice:dataTable binding="#{Recruitment$VacantSpaces.tblInitiateReq}" id="tblInitiateReq" style="height: 39px"
                                            value="#{Recruitment$VacantSpaces.initiateManagerlist}" var="currentRow" width="733">
                                            <ice:column id="column1">
                                                <ice:outputText id="outputText1" value="#{currentRow['departmentName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText4" value="Department"/>
                                                </f:facet>
                                                <ice:rowSelector binding="#{Recruitment$VacantSpaces.rowSelector}" id="rowSelector" selectionListener="#{Recruitment$VacantSpaces.rowSelector_processAction}"/>
                                            </ice:column>
                                            <ice:column id="column2">
                                                <ice:outputText id="outputText5" value="#{currentRow['jobName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText6" value="Job"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column4">
                                                <ice:outputText id="outputText9" value="#{currentRow['requiredNumber']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText10" value="Required num"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column3">
                                                <ice:outputText id="outputText7" value="#{currentRow['numberOfEmp']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText8" value="Existing number"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column5">
                                                <h:outputText id="outputText2" value="#{currentRow['vacantPossession']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText11" value="vacantPossession"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                    <ice:commandButton action="#{Recruitment$VacantSpaces.btnInitiateRec1_action}" id="btnInitiateRec1" rendered="false"
                                        style="left: 576px; top: 110px; position: absolute" value="Initiate Recruitment"/>
                                    <ice:outputLabel id="lblDepartment" rendered="false" style="font-size: 10px; left: 24px; top: 24px; position: absolute" value="Department Name :"/>
                                    <ice:outputLabel binding="#{Recruitment$VacantSpaces.lblDisDepartment}" id="lblDisDepartment" rendered="false"
                                        style="font-size: 10px; left: 144px; top: 24px; position: absolute" value="Department Name dis"/>
                                    <ice:outputLabel id="lblJob" rendered="false" style="font-size: 10px; left: 24px; top: 72px; position: absolute" value="Job :"/>
                                    <ice:outputLabel binding="#{Recruitment$VacantSpaces.lblDislblJob}" id="lblDislblJob" rendered="false"
                                        style="font-size: 10px; left: 144px; top: 72px; position: absolute" value="job dis"/>
                                    <ice:outputLabel id="lblDepartment2" rendered="false" style="font-size: 10px; left: 480px; top: 72px; position: absolute" value="Required num :"/>
                                    <ice:outputLabel binding="#{Recruitment$VacantSpaces.lblDisRequirednum}" id="lblDisRequirednum" rendered="false"
                                        style="font-size: 10px; left: 600px; top: 72px; position: absolute" value="Required num :"/>
                                    <ice:outputLabel id="lblTotalNumOfEmployee" rendered="false"
                                        style="font-size: 10px; left: 480px; top: 24px; position: absolute" value="Total Num Of Employee :"/>
                                    <ice:outputLabel binding="#{Recruitment$VacantSpaces.lblDisTotalNumOfEmployee}" id="lblDisTotalNumOfEmployee"
                                        rendered="false" style="font-size: 10px; left: 600px; top: 24px; position: absolute" value="Total Num Of Employee"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="south">
                            <ice:panelGroup id="page_footer" style=" text-align: center;">
                                <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                    <label style="margin-left:20px;color:white;font-weight:bold;font-family:Cambria">BUNNA INTERNATIONAL BANK Human Resource Management System.</label>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
