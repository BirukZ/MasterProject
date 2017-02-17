<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EmployeeReport
    Created on : Jul 11, 2012, 9:15:08 PM
    Author     : PROJECT
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <script src="../Script/Ethiopian_Calendar.js"></script>
                <script src="../Script/jquery-1.3.2.min.js"></script>
                <script src="../Script/jquery.notice.js"></script>
                <ice:outputStyle href="../resources/ETH/KAMSI_CAL_STYLE.css" id="outputStyle22"/>
                <script src="../resources/ETH/KAMSI_CAL_SCRIPT.js"></script>
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
                </script>
                <link HREF="../FederalIcon.ico" REL="icon"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelBorder id="whole_page" renderCenter="#{Report$EmployeeReportSelectionCriteria.panelBorder1Bean.renderCenter}"
                        renderEast="#{Report$EmployeeReportSelectionCriteria.panelBorder1Bean.renderEast}"
                        renderNorth="#{Report$EmployeeReportSelectionCriteria.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Report$EmployeeReportSelectionCriteria.panelBorder1Bean.renderSouth}"
                        renderWest="#{Report$EmployeeReportSelectionCriteria.panelBorder1Bean.renderWest}"
                        style="top: 5px; position: relative; background:transparent;" styleClass="whole_page" width="1024">
                        <f:facet name="north">
                            <ice:panelGroup id="page_header" style="height: 75px">
                                <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow" style="height: 75px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                    styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                                <!-- End Header -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup id="menu_left" style=" height:640px;">
                                <ice:panelLayout id="left_menu1" layout="flow" style="height: 640px;top:15px; left: 5px; position: relative; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="border: 1px solid #cccccc; height: 640px; position: absolute; width: 213px" styleClass="left_menu"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height:670px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 563px; left: 0px; top: 60px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css" style="height: 600px;">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="Manage Employee Leave Status"/>
                                        </legend>
                                        <ice:panelLayout id="pnProfile" style="height: 690px; left: 0px; top: -20px; position: absolute; width: 100%">
                                            <ice:panelGroup id="RetirementApproval" style="height: 550px" styleClass="filedsetNormal">
                                                <ice:outputText id="lblFilterReport" style="left: 48px; top: 90px; position: absolute" value="GENERATE MULTIPLE REPORT DATA "/>
                                                <ice:outputText id="choEmployeeTypeReport" style="left: 30px; top: 130px; position: absolute" value="Employee Type "/>
                                                <ice:outputText id="lblPermanet" style="left: 120px; top: 158px; position: absolute" value="Permant"/>
                                                <ice:outputText escape="false" id="lblContract" style="left: 208px; top: 158px; position: absolute" value="Contrat"/>
                                                <ice:outputText id="lblSexRepoart" style="left: 30px; top: 200px; position: absolute" value="Sex"/>
                                                <ice:outputText id="outputText16" style="left: 120px; top: 208px; position: absolute" value="Female"/>
                                                <ice:outputText id="outputText20" style="left: 208px; top: 208px; position: absolute" value="Male"/>
                                                <ice:outputText id="lblPrimeryCriteria" style="left: 30px; top: 260px; position: absolute" value="Primary Sort Criteria"/>
                                                <ice:outputText id="outputText41" style="left: 30px; top: 300px; position: absolute" value="Without Education "/>
                                                <ice:selectBooleanCheckbox id="cho" partialSubmit="true" style="left: 150px; top: 305px; position: absolute"/>
                                                <ice:selectBooleanCheckbox binding="#{Report$EmployeeReportSelectionCriteria.cholContract}" id="cholContract"
                                                    partialSubmit="true" style="left: 188px; top: 160px; position: absolute" value="#{Report$EmployeeReportSelectionCriteria.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                <ice:selectBooleanCheckbox binding="#{Report$EmployeeReportSelectionCriteria.choFemale}" id="choFemale"
                                                    partialSubmit="true" style="left: 100px; top: 210px; position: absolute" value="#{Report$EmployeeReportSelectionCriteria.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                                <ice:selectBooleanCheckbox binding="#{Report$EmployeeReportSelectionCriteria.choMale}" id="choMale"
                                                    partialSubmit="true" style="left: 188px; top: 210px; position: absolute" value="#{Report$EmployeeReportSelectionCriteria.selectBooleanCheckbox3Bean.selectedBoolean}"/>
                                                <ice:selectBooleanCheckbox binding="#{Report$EmployeeReportSelectionCriteria.choPermanet}" id="choPermanet"
                                                    partialSubmit="true" style="left: 100px; top: 160px; position: absolute" value="#{Report$EmployeeReportSelectionCriteria.selectBooleanCheckbox4Bean.selectedBoolean}"/>
                                                <ice:commandButton action="#{Report$EmployeeReportSelectionCriteria.btnGeneratefullReport_action}"
                                                    binding="#{Report$EmployeeReportSelectionCriteria.btnGeneratefullReport}" id="btnGeneratefullReport"
                                                    style="left: 72px; top: 327px; position: absolute" value="Generate Report"/>
                                                <ice:inputText id="txtEmployeeIDForReport" style="height: 21px; left: 384px; top: 140px; position: absolute; width: 212px"/>
                                                <ice:commandButton id="btnPrintSingleReport" style="left: 408px; top: 200px; position: absolute" value="Generate Single Report"/>
                                                <ice:outputText id="outputText14" style="left: 360px; top: 90px; position: absolute; width: 278px" value="GENERATE SINGEL REPORT DATA "/>
                                                <ice:selectOneMenu binding="#{Report$EmployeeReportSelectionCriteria.drlSortCriteria}" id="drlSortCriteria"
                                                    partialSubmit="true" style="left: 165px; top: 259px; position: absolute" value="#{Report$EmployeeReportSelectionCriteria.selectOneMenu1Bean.selectedObject}">
                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{Report$EmployeeReportSelectionCriteria.reportSortCriteria}"/>
                                                </ice:selectOneMenu>
                                                <ice:commandButton action="#{Report$EmployeeReportSelectionCriteria.btnExpriance_action}" id="btnExpriance"
                                                    style="left: 408px; top: 350px; position: absolute; width: 158px" value="Expriance"/>
                                            </ice:panelGroup>
                                        </ice:panelLayout>
                                    </fieldset>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
