<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Questionnaire
    Created on : Oct 24, 2011, 10:05:31 AM
    Author     : Bini
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Prepare Questionnaire Session</title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
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
                    var AssignQuestionnaire=jQuery.noConflict();
                </script>
            </head>
            <body id="outputBody1" onload="showCal()" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelBorder height="680" id="whole_page" renderCenter="#{Page1.panelBorder1Bean.renderCenter}"
                        renderEast="#{Page1.panelBorder1Bean.renderEast}" renderNorth="#{Page1.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Page1.panelBorder1Bean.renderSouth}" renderWest="#{Page1.panelBorder1Bean.renderWest}"
                        style="top: 0px; position: relative" styleClass="whole_page" width="1024px">
                        <f:facet name="north">
                            <ice:panelGroup id="page_header" style="height: 105px">
                                <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow" style="height: 105px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                    styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                                <!-- End Header -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup id="menu_left" style=" height:100%; border:none; ">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height: 300px; border:none; left: 5px; top:18px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 100px; border:none; left: 0px; top: 10px; position: absolute; width: 213px" styleClass="left_menu">
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible1" immediate="true" style="top:15px;border:none">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup1" styleClass="">
                                                    <ice:outputText id="lblRecruitmentRequest" value="Common Tasks"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid1" style="border:none" width="100%">
                                                <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$AssignQuestionnaire.cmdQuestions_action}" id="cmdQuestions"
                                                            immediate="true" partialSubmit="true"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Manage Questions"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$AssignQuestionnaire.cmdQuestionnaire_action}"
                                                            id="cmdQuestionnaire" immediate="true" partialSubmit="true"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Questionnaire"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$AssignQuestionnaire.cmdAnalyzeGrading_action}"
                                                            id="cmdAnalyzeGrading" immediate="true" partialSubmit="true" style="color: rgb(48, 102, 130); font-weight: bold; text-align: left"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$AssignQuestionnaire.cmdAnalyzeReGrading_action}"
                                                            id="cmdAnalyzeReGrading" immediate="true" partialSubmit="true" style="color: rgb(48, 102, 130); font-weight: bold; text-align: left"/>
                                                    </li>
                                                </ul>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible3" style="height: 328px">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup2" styleClass="">
                                                    <ice:outputText id="outputText4" value="List of Defined Questionnaires"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid2" style="border-style: none; height: 336px" width="100%">
                                                <ice:selectOneMenu binding="#{Questionnaire$AssignQuestionnaire.somQuestionnaire1}" id="somQuestionnaire1"
                                                    partialSubmit="true"
                                                    style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;  width: 180px"
                                                    value="#{Questionnaire$AssignQuestionnaire.defaultSelectedData2.selectedObject}" valueChangeListener="#{Questionnaire$AssignQuestionnaire.somQuestionnaire1_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems3" value="#{Questionnaire$AssignQuestionnaire.definedQuesList}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectOneListbox id="lisPropJob" partialSubmit="true" size="10"
                                                    style=" border: 1px solid #73b3ce;width:125px;"
                                                    value="#{Questionnaire$AssignQuestionnaire.selectOneListbox2Bean.selectedObject}" valueChangeListener="#{Questionnaire$AssignQuestionnaire.lisPropJob_processValueChange}">
                                                    <f:selectItems id="selectOneListbox1selectItems1" value="#{Questionnaire$AssignQuestionnaire.employeeWithProcessedRequests}"/>
                                                </ice:selectOneListbox>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 695px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 670px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css" style="height: 670px;">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="Questionnaire"/>
                                        </legend>
                                        <ice:panelLayout id="main_content" layout="flow" style="height: 100%; left: 5px; top: 0px; position: relative; width: 95%; -rave-layout: grid">
                                            <ice:panelLayout id="pnlRequesterinfo1" layout="flow"
                                                style="height: 212px; left: 24px; top: 10px; position: absolute; visibility: visible; width: 694px; -rave-layout: grid"
                                                styleClass="insideContainerMain" visible="true">
                                                <ice:outputText id="lblSupervisorName1"
                                                    style="font-family: Cambria; left: 24px; top: 12px; position: absolute; text-align: left; vertical-align: top; width: 95px" value="Event Description"/>
                                                <ice:outputText id="lblDirectorate1" style="font-family: 'Cambria'; left: 24px; top: 50px; position: absolute" value="From "/>
                                                <ice:outputText id="lblJobTitle1" rendered="false"
                                                    style="font-family: Cambria; left: 360px; top: 12px; position: absolute; text-align: left; vertical-align: top; width: 95px" value="Event Code"/>
                                                <ice:outputText id="lblSpecificUnit1" style="font-family: 'Cambria'; left: 24px; top: 96px; position: absolute" value="To"/>
                                                <ice:outputText id="lblSupervisorName2"
                                                    style="font-family: 'Arial','Helvetica',sans-serif; left: 24px; top: 144px; position: absolute; text-align: left; vertical-align: top; width: 71px" value="Remark"/>
                                                <ice:outputText binding="#{Questionnaire$AssignQuestionnaire.txtEventDescription}" id="txtEventDescription"
                                                    style="border-bottom-style: solid; border-bottom-width: 1px; left: 118px; top: 13px; position: absolute; width: 481px" value=":"/>
                                                <ice:outputText binding="#{Questionnaire$AssignQuestionnaire.txtJobCode}" id="txtJobCode" rendered="false"
                                                    style=" border-bottom-style: solid; border-bottom-width: 1px; left: 454px; top: 15px; position: absolute; width: 220px" value=":"/>
                                                <ice:inputTextarea binding="#{Questionnaire$AssignQuestionnaire.txtRemark}" disabled="true" id="txtRemark" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 142px; position: absolute; width: 220px"/>
                                                <ice:inputText binding="#{Questionnaire$AssignQuestionnaire.txtFromDate}" disabled="true" id="txtFromDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 51px; position: absolute; width: 220px"/>
                                                <ice:inputText binding="#{Questionnaire$AssignQuestionnaire.txtToDate}" disabled="true" id="txtToDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 94px; position: absolute; width: 220px"/>
                                                <ice:commandButton action="#{Questionnaire$AssignQuestionnaire.btnCalFrom_action}"
                                                    binding="#{Questionnaire$AssignQuestionnaire.btnCalFrom}" id="btnCalFrom"
                                                    image="/resources/images/cal_icon.JPG" immediate="true" style="left: 328px; top: 54px; position: absolute" value="submit"/>
                                                <ice:commandButton action="#{Questionnaire$AssignQuestionnaire.btnCalTo_action}"
                                                    binding="#{Questionnaire$AssignQuestionnaire.btnCalTo}" id="btnCalTo" image="/resources/images/cal_icon.JPG"
                                                    immediate="true" style="left: 329px; top: 97px; position: absolute" value="submit"/>
                                                <ice:selectInputDate binding="#{Questionnaire$AssignQuestionnaire.calFromDate}" id="calFromDate"
                                                    rendered="false" style="height: 212px; left: 336px; top: 48px; position: absolute; width: 190px; z-index: 1"
                                                    value="#{Questionnaire$AssignQuestionnaire.selectInputDate1Bean.date1}" valueChangeListener="#{Questionnaire$AssignQuestionnaire.calFromDate_processValueChange}"/>
                                                <ice:selectInputDate binding="#{Questionnaire$AssignQuestionnaire.calToDate}" id="calToDate" rendered="false"
                                                    style="height: 212px; left: 432px; top: 72px; position: absolute; width: 190px; z-index: 1"
                                                    value="#{Questionnaire$AssignQuestionnaire.selectInputDateBean2.date1}" valueChangeListener="#{Questionnaire$AssignQuestionnaire.calToDate_processValueChange}"/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="pnlTblQuestionnaire"
                                                style="border-width: 1px; border-style: solid; height: 214px; left: 24px; top: 240px; position: absolute; width: 694px; -rave-layout: grid" styleClass="insideContainerMain">
                                                <ice:dataTable id="tblDutie1" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                    value="#{Questionnaire$AssignQuestionnaire.quesManagerList}" var="currentRow" varStatus="rowIndex" width="100%">
                                                    <ice:column id="column1" style="height: 25px; width: 43px">
                                                        <ice:outputText id="outputText5" value="#{rowIndex.index+1}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText6" value="No"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column2" rendered="false" style="height: 25px; width: 269px">
                                                        <ice:outputText id="outputText7" value="#{currentRow['jobCode']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText8" value="Training Code"/>
                                                        </f:facet>
                                                        <ice:rowSelector id="rowSelectorOption" immediate="true"
                                                            selectionListener="#{Questionnaire$AssignQuestionnaire.rowSelectorOption_processMyEvent}" value="#{currentRow['selected']}"/>
                                                    </ice:column>
                                                    <ice:column id="column3">
                                                        <ice:outputText id="outputText9" value="#{currentRow['jobTitle']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText10" value="Event Description"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column4">
                                                        <ice:outputText id="outputText1" value="#{currentRow['fromDate']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText2" value="From Date"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column5">
                                                        <ice:outputText id="outputText3" value="#{currentRow['toDate']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText11" value="To Date"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column6">
                                                        <ice:outputText id="outputText12" value="#{currentRow['questDescription']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText13" value="Remark"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <f:facet name="header"/>
                                                    <ice:column id="column7">
                                                        <h:selectBooleanCheckbox id="checkbox1" readonly="true" value="#{currentRow['active']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText15" value="Active"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="pnlReviwerSection1" layout="flow"
                                                style="border-width: 1px; height: 60px; left: 24px; top: 476px; position: absolute; width: 693px; -rave-layout: grid" styleClass="insideContainerMain">
                                                <ice:outputText id="lblDirectorate2" style="font-family: 'Cambria'; left: 24px; top: 15px; position: absolute" value="Prepared By"/>
                                                <ice:outputText id="lblSpecificUnit2" style="font-family: 'Cambria'; left: 360px; top: 15px; position: absolute" value="Prepared On"/>
                                                <ice:inputText binding="#{Questionnaire$AssignQuestionnaire.txtPrpeparedOn}" id="txtPrpeparedOn" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 454px; top: 15px; position: absolute; width: 220px"/>
                                                <ice:commandButton action="#{Questionnaire$AssignQuestionnaire.btnCalPrep_action}"
                                                    binding="#{Questionnaire$AssignQuestionnaire.btnCalPrep}" id="btnCalPrep"
                                                    image="/resources/images/cal_icon.JPG" immediate="true" style="left: 657px; top: 18px; position: absolute" value="submit"/>
                                                <ice:outputText binding="#{Questionnaire$AssignQuestionnaire.txtPrparedBy}" id="txtPrparedBy" style="border-bottom-style: solid; border-bottom-width: 1px; height: 16px; left: 118px; top: 13px; position: absolute; width: 220"/>
                                                <ice:selectInputDate binding="#{Questionnaire$AssignQuestionnaire.calPreparedOn}" id="calPreparedOn"
                                                    rendered="false"
                                                    style="height: 212px; left: 432px; top: -192px; position: absolute; width: 190px; z-index: 1"
                                                    value="#{Questionnaire$AssignQuestionnaire.selectInputDateBean3.date1}" valueChangeListener="#{Questionnaire$AssignQuestionnaire.calPreparedOn_processValueChange}"/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="pnlCommandBtn1" layout="flow"
                                                style="border-width: 1px; border-style: solid; height: 60px; left: 24px; top: 552px; position: absolute; width: 693px; -rave-layout: grid" styleClass="insideContainerMain">
                                                <ice:commandButton action="#{Questionnaire$AssignQuestionnaire.btnNew_action}"
                                                    binding="#{Questionnaire$AssignQuestionnaire.btnNew}" id="btnNew"
                                                    style="left: 48px; top: 10px; position: absolute; width: 95px" value="New"/>
                                                <ice:commandButton action="#{Questionnaire$AssignQuestionnaire.btnSave_action}"
                                                    binding="#{Questionnaire$AssignQuestionnaire.btnSave}" disabled="true" id="btnSave"
                                                    style="left: 168px; top: 10px; position: absolute; width: 95px" value="Save"/>
                                                <ice:commandButton action="#{Questionnaire$AssignQuestionnaire.btnUpdate_action}"
                                                    binding="#{Questionnaire$AssignQuestionnaire.btnUpdate}" disabled="true" id="btnUpdate"
                                                    style="left: 408px; top: 10px; position: absolute; width: 95px" value="Update"/>
                                                <ice:commandButton action="#{Questionnaire$AssignQuestionnaire.btnEdit_action}"
                                                    binding="#{Questionnaire$AssignQuestionnaire.btnEdit}" disabled="true" id="btnEdit"
                                                    style="left: 288px; top: 10px; position: absolute; width: 95px" value="Edit"/>
                                                <ice:commandButton action="#{Questionnaire$AssignQuestionnaire.btnDelete_action}"
                                                    binding="#{Questionnaire$AssignQuestionnaire.btnDelete}" disabled="true" id="btnDelete"
                                                    style="left: 528px; top: 10px; position: absolute; width: 95px" value="Delete"/>
                                            </ice:panelLayout>
                                        </ice:panelLayout>
                                    </fieldset>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="south">
                            <ice:panelGroup id="page_footer" style=" text-align: center;">
                                <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">This is the Footer</ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                    <ice:panelPopup autoCentre="true" binding="#{Questionnaire$AssignQuestionnaire.pnMessage}" clientOnly="true" draggable="false"
                        id="pnMessage" modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 400px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnMessageTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="National Bank of Ethiopia Human Resource Management And Integrated Payroll System:Message"/>
                                <ice:commandLink action="#{Questionnaire$AssignQuestionnaire.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                    immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlMessageBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{Questionnaire$AssignQuestionnaire.lblFormMessage}" id="lblFormMessage" style="background-color: #F5F5F5;"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
