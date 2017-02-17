<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EvaluationReportPage
    Created on : Nov 30, 2011, 9:10:29 AM
    Author     : Administrator 
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
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
                    var EvaluationReportPage=jQuery.noConflict();
                </script>
                <link HREF="../FederalIcon.ico" REL="icon"/>
            </head>
            <body id="outputBody1" onload="showCal()" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{EmployeeHistory$EvaluationReportPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{EmployeeHistory$EvaluationReportPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{EmployeeHistory$EvaluationReportPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{EmployeeHistory$EvaluationReportPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{EmployeeHistory$EvaluationReportPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height:75px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height:75px; left: 0px; position: relative; width: 100%z; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px;top:15px left: 5px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: 5px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="#{msgTermination.commonTasks}"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group" style="height:220px;width:100%">
                                                        <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                            <ice:panelSeries id="Common_Tasks_Series" rows="3" style="width:100%" value="CommonTasks" var="commontasks">
                                                                <li>
                                                                    <ice:commandLink action="#{EmployeeHistory$EvaluationCriterias.commandLink1_action}"
                                                                        id="commandLink1" style="color:#333333;font-weight:bold" value="Evaluation Criteria"/>
                                                                </li>
                                                                <li>
                                                                    <ice:commandLink action="#{EmployeeHistory$EvaluationCriterias.commandLink3_action}"
                                                                        id="commandLink3" style="color:#333333;font-weight:bold" value="Evaluation Session"/>
                                                                </li>
                                                                <li>
                                                                    <ice:commandLink action="#{EmployeeHistory$EvaluationCriterias.commandLink2_action}"
                                                                        id="commandLink2" style="color:#333333;font-weight:bold" value="Evaluation Result"/>
                                                                </li>
                                                                <li>
                                                                    <ice:commandLink action="#{EmployeeHistory$EvaluationNavigation.commandLink4_action}"
                                                                        id="commandLink4" style="color:#333333;font-weight:bold" value="View Result"/>
                                                                </li>
                                                                <li>
                                                                    <ice:commandLink action="#{EmployeeHistory$EvaluationNavigation.commandLink5_action}"
                                                                        id="commandLink5" style="color:#333333;font-weight:bold" value="Resolve Result"/>
                                                                </li>
                                                                <li>
                                                                    <ice:commandLink action="#{EmployeeHistory$EvaluationNavigation.commandLink6_action}"
                                                                        id="commandLink6" style="color:#333333;font-weight:bold" value="Evaluation Navigator"/>
                                                                </li>
                                                            </ice:panelSeries>
                                                        </ul>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height:890px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 875px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 860px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Generate Evaluation report(s)"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 870px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 786px" styleClass="filedset_border">
                                                    <label style="left: 20px; top:520px; border-bottom:0.5px groove #176674; width:750px; position: absolute;"></label>
                                                    <label style="left: 20px; top: 565px; border-bottom:0.5px groove #176674; width:750px; position: absolute;"></label>
                                                    <ice:panelLayout id="PanelLayOutRportGeneralCriTop"
                                                        style="height: 40px; margin-left: 10px; margin-top: 10px; position: absolute; width: 724px" styleClass="insideContainerMain">
                                                        <ice:outputText id="outputText6SingleReport"
                                                            style="font-family: 'Cambria'; left: 20px; top: 10px; position: absolute" value="Single Report :"/>
                                                        <ice:selectBooleanCheckbox
                                                            binding="#{EmployeeHistory$EvaluationReportPage.selectBooleanCheckboxSingleR}"
                                                            id="selectBooleanCheckboxSingleR" partialSubmit="true"
                                                            style="left: 100px; top: 13px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationReportPage.defaultSelectedData226.selectedBoolean}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.selectBooleanCheckboxSingleR_processValueChange}"/>
                                                        <ice:outputText id="outputText6"
                                                            style="font-family: 'Cambria'; left: 150px; top: 10px; position: absolute" value="General Report :"/>
                                                        <ice:selectBooleanCheckbox
                                                            binding="#{EmployeeHistory$EvaluationReportPage.selectBooleanCheckboxGeneralR}"
                                                            id="selectBooleanCheckboxGeneralR" partialSubmit="true"
                                                            style="left: 250px; top: 13px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationReportPage.defaultSelectedData227.selectedBoolean}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.selectBooleanCheckboxGeneralR_processValueChange}"/>
                                                        <ice:outputText id="outputTextEmployeeID"
                                                            style="font-family: 'Cambria'; left:420px; top: 10px; position: absolute" value="Employee ID :"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationReportPage.inputTextEmployeeID}"
                                                            id="inputTextEmployeeID" style="left: 520px; top: 8px; position: absolute"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLayout16" style="border: 1px solid rgb(204, 204, 204); height: 167px; margin-left: 15px; left: 10px; top: 620px; overflow: auto; position: absolute; width: 732px">
                                                        <ice:dataTable binding="#{EmployeeHistory$EvaluationReportPage.dtResult}" id="dtResult"
                                                            value="#{EmployeeHistory$EvaluationReportPage.evaluatedEmpList}" var="currentRow" width="100%">
                                                            <ice:column id="column1">
                                                                <ice:outputText id="outputText1" value="#{currentRow['employeeId']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText3" value="EMPLOYEE ID"/>
                                                                </f:facet>
                                                                <ice:rowSelector binding="#{EmployeeHistory$EvaluationReportPage.rowSelectorEvaReport}"
                                                                    id="rowSelectorEvaReport" multiple="false" preStyleOnSelection="true" rendered="true"
                                                                    selectionListener="#{EmployeeHistory$EvaluationReportPage.rowSelectorEvaReport_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                            <ice:column id="column2">
                                                                <ice:outputText id="outputText4" value="#{currentRow['fullName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText5" value="FULL NAME"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column4" rendered="false">
                                                                <ice:outputText id="outputText26" value="#{currentRow['dateTerminated']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText27" value="Total"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="PanelLayOutRportGeneralCri"
                                                        style="height: 260px; margin-left: 10px; margin-top: 70px; position: absolute; width: 724px" styleClass="insideContainerMain">
                                                        <ice:outputText id="outputText8"
                                                            style="font-family: 'Cambria'; left: 20px; top: 20px; position: absolute" value="Employments Type :"/>
                                                        <ice:outputText escape="false" id="outputText9"
                                                            style="font-family: 'Cambria'; left:20px; top: 60px; position: absolute" value="Sex :"/>
                                                        <ice:outputText id="outputText10"
                                                            style="font-family: 'Cambria'; left: 20px; top: 100px; position: absolute" value="Employee Title :"/>
                                                        <ice:outputText escape="false" id="outputText2"
                                                            style="font-family: 'Cambria'; left: 150px; top: 20px; position: absolute" value="Shift"/>
                                                        <ice:outputText escape="false" id="outputText15"
                                                            style="font-family: 'Cambria'; left: 300px; top: 20px; position: absolute" value="Offise"/>
                                                        <ice:outputText escape="false" id="outputText16"
                                                            style="font-family: 'Cambria'; left: 400px; top: 20px; position: absolute" value="Permanent "/>
                                                        <ice:outputText escape="false" id="outputText17"
                                                            style="font-family: 'Cambria'; left: 600px; top: 20px; position: absolute" value="Contrat "/>
                                                        <ice:outputText escape="false" id="outputText18"
                                                            style="font-family: 'Cambria'; left: 150px; top: 60px; position: absolute" value="Female "/>
                                                        <ice:outputText escape="false" id="outputText20"
                                                            style="font-family: 'Cambria'; left: 300px; top: 60px; position: absolute" value="Male"/>
                                                        <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationReportPage.chkMilitery}"
                                                            id="chkMilitery" partialSubmit="true" style="left: 200px; top: 22px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationReportPage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.chkMilitery_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationReportPage.chkCivil}" id="chkCivil"
                                                            partialSubmit="true" style="left: 350px; top: 22px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationReportPage.selectBooleanCheckbox2Bean.selectedBoolean}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.chkCivil_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationReportPage.chkPermanent}"
                                                            id="chkPermanent" immediate="true" style="left: 500px; top: 22px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationReportPage.selectBooleanCheckbox3Bean.selectedBoolean}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.chkPermanent_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationReportPage.chkContrat}" id="chkContrat"
                                                            immediate="true" style="left: 650px; top: 22px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationReportPage.selectBooleanCheckbox4Bean.selectedBoolean}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.chkContrat_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationReportPage.chkMale}" id="chkMale"
                                                            immediate="true" style="left: 350px; top: 62px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationReportPage.selectBooleanCheckbox5Bean.selectedBoolean}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.chkMale_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationReportPage.chkFemale}" id="chkFemale"
                                                            immediate="true" style="left: 200px; top: 62px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationReportPage.selectBooleanCheckbox6Bean.selectedBoolean}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.chkFemale_processValueChange}"/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationReportPage.cboEmployeeTitle}"
                                                            id="cboEmployeeTitle" immediate="true" partialSubmit="true"
                                                            style="left: 150px; top: 95px; position: absolute; width: 146px" value="#{EmployeeHistory$EvaluationReportPage.defaultSelectedData222.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{EmployeeHistory$EvaluationReportPage.titles}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationReportPage.cboSector}" id="cboSector"
                                                            partialSubmit="true" required="true"
                                                            style="left: 150px; top: 135px; position: absolute; width: 146px"
                                                            value="#{EmployeeHistory$EvaluationReportPage.defaultSelectedData1.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.cboSector_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems1" value="#{EmployeeHistory$EvaluationReportPage.zerf}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationReportPage.cboDirectorate}" id="cboDirectorate"
                                                            immediate="true" partialSubmit="true"
                                                            style="left: 150px; top: 175px; position: absolute; width: 146px"
                                                            value="#{EmployeeHistory$EvaluationReportPage.defaultSelectedData2.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.cboDirectorate_processValueChange}">
                                                            <f:selectItems id="selectOneMenu2selectItems1" value="#{EmployeeHistory$EvaluationReportPage.directorate}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationReportPage.cboDivision}" id="cboDivision"
                                                            immediate="true" partialSubmit="true"
                                                            style="left: 480px; top: 175px; position: absolute; width: 146px"
                                                            value="#{EmployeeHistory$EvaluationReportPage.selectOneMenu3Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.cboDivision_processValueChange}">
                                                            <f:selectItems id="selectOneMenu3selectItems" value="#{EmployeeHistory$EvaluationReportPage.division}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationReportPage.cboCooperative}" id="cboCooperative"
                                                            immediate="true" partialSubmit="true"
                                                            style="left: 150px; top: 215px; position: absolute; width: 146px"
                                                            value="#{EmployeeHistory$EvaluationReportPage.selectOneMenu4Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.cboCooperative_processValueChange}">
                                                            <f:selectItems id="selectOneMenu4selectItems" value="#{EmployeeHistory$EvaluationReportPage.mastebaberia}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationReportPage.cboTeam}" id="cboTeam"
                                                            immediate="true" partialSubmit="true"
                                                            style="left: 480px; top: 215px; position: absolute; width: 146px"
                                                            value="#{EmployeeHistory$EvaluationReportPage.selectOneMenu5Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.cboTeam_processValueChange}">
                                                            <f:selectItems id="selectOneMenu5selectItems" value="#{EmployeeHistory$EvaluationReportPage.team}"/>
                                                            <ice:outputText id="outputText23"
                                                                style="font-family: 'Cambria'; left: 20px; top: 145px; position: absolute" value="Sector *:"/>
                                                            <ice:outputText id="outputText25"
                                                                style="font-family: 'Cambria'; left: 20px; top: 185px; position: absolute" value="Directorate :"/>
                                                            <ice:outputText id="outputText28"
                                                                style="font-family: 'Cambria'; left: 350px; top: 185px; position: absolute" value="Division :"/>
                                                            <ice:outputText id="outputText29"
                                                                style="font-family: 'Cambria'; left: 350px; top: 225px; position: absolute" value="Team :"/>
                                                            <ice:outputText id="outputText30"
                                                                style="font-family: 'Cambria'; left: 20px; top: 225px; position: absolute" value="Cooperative :"/>
                                                        </ice:selectOneMenu>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="cboSector" id="message3"
                                                            infoClass="infoMessage" style="font-family: 'Cambria'; left: 320px; top: 145px; position: absolute" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="PanelLayOutRportSpecificCri"
                                                        style="height: 150px; margin-left: 10px; margin-top: 350px; position: absolute; width: 724px" styleClass="insideContainerMain">
                                                        <ice:outputText id="outputTextPurpose"
                                                            style="font-family: 'Cambria'; left: 20px; top: 15px; position: absolute" value="Purpose :"/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationReportPage.selectOneMenuEvaPurpose}"
                                                            id="selectOneMenuEvaPurpose" partialSubmit="true"
                                                            style="left: 150px; top: 10px; position: absolute; width: 146px"
                                                            value="#{EmployeeHistory$EvaluationReportPage.defaultSelectedData223.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.selectOneMenuEvaPurpose_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems2" value="#{EmployeeHistory$EvaluationReportPage.sessionCategory}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputText11" rendered="false"
                                                            style="font-family: 'Cambria'; left: 100px; top: 95px; position: absolute" value="From *"/>
                                                        <ice:outputText id="outputText12" rendered="false"
                                                            style="font-family: 'Cambria'; left: 350px; top: 95px; position: absolute" value="To *"/>
                                                        <ice:outputText id="outputText14" rendered="false"
                                                            style="font-family: 'Cambria'; left: 20px; top: 95px; position: absolute" value="Session Date :"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationReportPage.txtFromDate}" id="txtFromDate"
                                                            partialSubmit="true" rendered="false" required="true" style="left: 150px; top: 95px; position: absolute"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationReportPage.txtToDate}" id="txtToDate"
                                                            partialSubmit="true" rendered="false" required="true" style="left: 480px; top: 95px; position: absolute"/>
                                                        <ice:outputText id="outputTextAutorizer"
                                                            style="font-family: 'Cambria'; left: 20px; top: 55px; position: absolute" value="Authorized By :"/>
                                                        <ice:outputText id="outputTextEvaluator"
                                                            style="font-family: 'Cambria'; left: 350px; top: 55px; position: absolute" value="Evaluated By :"/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationReportPage.iceSelOneMnuAuthorizedBy}"
                                                            id="iceSelOneMnuAuthorizedBy" partialSubmit="true"
                                                            style="left: 150px; top: 50px; position: absolute; width: 146px"
                                                            value="#{EmployeeHistory$EvaluationReportPage.defaultSelectedData224.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.iceSelOneMnuAuthorizedBy_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems3" value="#{EmployeeHistory$EvaluationReportPage.autorizerID}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationReportPage.selectOneMenuEvaluatedBy}"
                                                            id="selectOneMenuEvaluatedBy" partialSubmit="true"
                                                            style="left: 480px; top: 50px; position: absolute; width: 146px" value="#{EmployeeHistory$EvaluationReportPage.defaultSelectedData225.selectedObject}">
                                                            <f:selectItems id="selectOneMenu2selectItems" value="#{EmployeeHistory$EvaluationReportPage.evaluatorID}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtToDate" id="message1"
                                                            infoClass="infoMessage" rendered="false"
                                                            style="font-family: 'Cambria'; left: 635px; top: 95px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtFromDate" id="message2"
                                                            infoClass="infoMessage" rendered="false"
                                                            style="font-family: 'Cambria'; left: 305px; top: 95px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:commandButton id="btnFromDate" image="/resources/images/cal_button.gif" immediate="true"
                                                            onclick="getId('form1:txtFromDate'),getPosition(this.id);" rendered="false"
                                                            style="left: 278px; top: 97px; position: absolute; z-index: 100" value="submit"/>
                                                        <ice:commandButton id="btnToDate" image="/resources/images/cal_button.gif" immediate="true"
                                                            onclick="getId('form1:txtToDate'),getPosition(this.id);" rendered="false"
                                                            style="left: 608px; top: 95px; position: absolute; z-index: 100" value="submit"/>
                                                        <ice:outputText id="outputText7ManagedSession"
                                                            style="font-family: 'Cambria'; left: 350px; top: 15px; position: absolute" value="Managed Session :"/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationReportPage.selectOneMenu1ManagedSession}"
                                                            id="selectOneMenu1ManagedSession" partialSubmit="true"
                                                            style="left: 480px; top: 10px; position: absolute; width: 146px"
                                                            value="#{EmployeeHistory$EvaluationReportPage.defaultSelectedData228.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationReportPage.selectOneMenu1ManagedSession_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems4" value="#{EmployeeHistory$EvaluationReportPage.managedSessions}"/>
                                                        </ice:selectOneMenu>
                                                    </ice:panelLayout>
                                                    <ice:commandButton action="#{EmployeeHistory$EvaluationReportPage.btnSearch_action}"
                                                        binding="#{EmployeeHistory$EvaluationReportPage.btnSearch}" id="btnSearch"
                                                        style="left: 50px; top: 520px; position: absolute" value="Search "/>
                                                    <ice:commandButton action="#{EmployeeHistory$EvaluationReportPage.btnReset_action}"
                                                        binding="#{EmployeeHistory$EvaluationReportPage.btnReset}" id="btnReset"
                                                        style="left: 200px; top: 532px; position: absolute" type="reset" value="Reset"/>
                                                    <ice:commandButton action="#{EmployeeHistory$EvaluationReportPage.btnPreviewSelected_action}"
                                                        binding="#{EmployeeHistory$EvaluationReportPage.btnPreviewSelected}" id="btnPreviewSelected"
                                                        style="left: 350px; top: 520px; position: absolute" value="Preview Report"/>
                                                    <ice:outputText id="outputText31" style="font-family: 'Cambria'; left: 50px; top: 570px; position: absolute" value="Search result will be displayed on the below table based on your searching parameter."/>
                                                    <ice:outputText id="outputText32" style="font-family: 'Cambria'; left: 50px; top: 590px; position: absolute" value="Record found :"/>
                                                    <ice:outputText binding="#{EmployeeHistory$EvaluationReportPage.lblRecordFound}" id="lblRecordFound" style="font-family: 'Cambria'; left: 130px; top: 590px; position: absolute"/>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label
                                                style="margin-left:10px;color:#333333;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com" style="margin-left:10px;color:#333333;">BUNNA INTERNATIONAL BANK |INFORMATION|Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$EvaluationReportPage.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{EmployeeHistory$EvaluationReportPage.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{EmployeeHistory$EvaluationReportPage.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <div class="some" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
                            <input id="cal_day_names" type="hidden" value="ሰ,ማ,ረ,�?,ዓ,ቅ,እ"/>
                            <input id="cal_month_names" type="hidden" value="መስከረ�?,ጥቅ�?ት,ህዳር,ታህሳስ,ጥር,የካቲት,መጋቢት,ሚያ�?ያ,�?ንቦት,ሰኔ,ሀ�?ሌ,�?ሀሴ,ጷ�?ሜ"/>
                        </div>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
