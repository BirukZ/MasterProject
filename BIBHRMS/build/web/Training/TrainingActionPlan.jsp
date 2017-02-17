<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : mekete
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HR_Localization_Training" var="msgTraining"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
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
                    var $j=jQuery.noConflict();
                    function TrainingNameRegistrationPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Training$TrainingActionPlan.panelBorder1Bean.renderCenter}"
                            renderEast="#{Training$TrainingActionPlan.panelBorder1Bean.renderEast}"
                            renderNorth="#{Training$TrainingActionPlan.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Training$TrainingActionPlan.panelBorder1Bean.renderSouth}"
                            renderWest="#{Training$TrainingActionPlan.panelBorder1Bean.renderEast}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 117px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 129px; left: 0px; position: relative; width: 100%z; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="border:none; height:370px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:370px;top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:370px; left: -4px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" width="100%"/>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height:600px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 600px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 560px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Training Action Plan"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 573px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Training$TrainingActionPlan.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 526px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayoutMain" style="height: 516px; left: 11px; top: 0px; position: absolute; width: 719px">
                                                        <ice:panelLayout id="pnlLayputRequest"
                                                            style="height: 439px; margin-left: 12px; left: -7px; top: 14px; overflow: auto; position: absolute; width: 708px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Training$TrainingActionPlan.btnRemoveAllFromGroup_action}"
                                                                id="btnRemoveAllFromGroup" style="left: 312px; top: 374px; position: absolute; width: 95px" value="&lt;&lt;Remove All"/>
                                                            <ice:commandButton action="#{Training$TrainingActionPlan.btnAddAllToGroup_action}"
                                                                id="btnAddAllToGroup" style="left: 312px; top: 326px; position: absolute; width: 95px" value="#{msgTraining.Addall}"/>
                                                            <ice:commandButton action="#{Training$TrainingActionPlan.btnRemoveFromGroup_action}"
                                                                id="btnRemoveFromGroup" style="left: 312px; top: 278px; position: absolute; width: 95px" value="&lt; Remove"/>
                                                            <ice:commandButton action="#{Training$TrainingActionPlan.btnAddToGroup_action}" id="btnAddToGroup"
                                                                style="left: 312px; top: 230px; position: absolute; width: 95px" value="Add &gt;"/>
                                                            <ice:outputLabel id="lblTrainner" style="left: 439px; top: 31px; position: absolute" value="Trainner"/>
                                                            <ice:outputLabel binding="#{Training$TrainingActionPlan.lblGroupOrInstitute}"
                                                                id="lblGroupOrInstitute" style="left: 439px; top: 62px; position: absolute" value="Institute"/>
                                                            <ice:outputLabel id="lblBudjetYear" style="left: 35px; top: 25px; position: absolute" value="Budjet Year"/>
                                                            <ice:outputLabel id="lblNotAssigned"
                                                                style="background-color: rgb(210, 210, 210); left: 24px; top: 192px; position: absolute; text-align: center; width: 239px" value="Not Assigned"/>
                                                            <ice:outputLabel id="lblAssigned"
                                                                style="background-color: rgb(210, 210, 210); left: 432px; top: 192px; position: absolute; text-align: center; width: 239px" value="Assigned"/>
                                                            <ice:selectManyListbox binding="#{Training$TrainingActionPlan.selManyListNotAssigned}"
                                                                id="selManyListNotAssigned" partialSubmit="true"
                                                                style="height: 204px; left: 22px; top: 214px; position: absolute; width: 242px" value="#{Training$TrainingActionPlan.selectManyListbox1Bean.selectedItems}">
                                                                <f:selectItems id="selectManyListbox1selectItems" value="#{Training$TrainingActionPlan.notAssignedTrainingNeedsList}"/>
                                                            </ice:selectManyListbox>
                                                            <ice:selectManyListbox binding="#{Training$TrainingActionPlan.selManyListAssigned}"
                                                                id="selManyListAssigned" partialSubmit="true"
                                                                style="height: 197px; left: 430px; top: 214px; position: absolute; width: 242px"
                                                                value="#{Training$TrainingActionPlan.selectManyListbox2Bean.selectedItems}" valueChangeListener="#{Training$TrainingActionPlan.selManyListAssigned_processValueChange}">
                                                                <f:selectItems id="selectManyListbox2selectItems" value="#{Training$TrainingActionPlan.assignedTrainingNeedsList}"/>
                                                            </ice:selectManyListbox>
                                                            <ice:selectOneMenu binding="#{Training$TrainingActionPlan.drlInstitutionToAssign}"
                                                                id="drlInstitutionToAssign" immediate="true" partialSubmit="true"
                                                                style="left: 502px; top: 61px; position: absolute; width: 177px"
                                                                value="#{Training$TrainingActionPlan.selectedRequestFromInstitutionList.selectedObject}" valueChangeListener="#{Training$TrainingActionPlan.drlInstitutionToAssign_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{Training$TrainingActionPlan.institutionOrTrainnerList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$TrainingActionPlan.drlBudjetYear}" id="drlBudjetYear"
                                                                immediate="true" partialSubmit="true"
                                                                style="left: 123px; top: 25px; position: absolute; width: 145px"
                                                                value="#{Training$TrainingActionPlan.selectedRequestFromMyBudjetYearList.selectedObject}" valueChangeListener="#{Training$TrainingActionPlan.drlBudjetYear_processValueChange}">
                                                                <f:selectItems id="selectOneMenuBudjetYear" value="#{Training$TrainingActionPlan.budjetYearList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$TrainingActionPlan.drlTrainingLevel}" id="drlTrainingLevel"
                                                                immediate="true" partialSubmit="true"
                                                                style="left: 502px; top: 30px; position: absolute; width: 177px"
                                                                value="#{Training$TrainingActionPlan.selectedRequestFromTrainnerTypeList.selectedObject}" valueChangeListener="#{Training$TrainingActionPlan.drlTrainnerCategory_processValueChange}">
                                                                <f:selectItems id="selectOneMenuTrainnerCategory" value="#{Training$TrainingActionPlan.trainerTypeList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$TrainingActionPlan.drlOnOff}" id="drlOnOff" immediate="true"
                                                                partialSubmit="true" style="left: 123px; top: 55px; position: absolute; width: 145px"
                                                                value="#{Training$TrainingActionPlan.defaultSelectedData5.selectedObject}" valueChangeListener="#{Training$TrainingActionPlan.drlOnOff_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{Training$TrainingActionPlan.onOrOffWork}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="outputLabel1" style="left: 35px; top: 55px; position: absolute" value="On/Off Work"/>
                                                            <ice:inputText binding="#{Training$TrainingActionPlan.txtStartDate}" id="txtStartDate" style="left: 502px; top: 91px; position: absolute; width: 130px"/>
                                                            <ice:inputText binding="#{Training$TrainingActionPlan.txtEndDate}" id="txtEndDate" style="left: 502px; top: 120px; position: absolute; width: 130px"/>
                                                            <ice:outputLabel id="lblStartDate" style="left: 384px; top: 90px; position: absolute; width: 110px" value="Start Date"/>
                                                            <ice:outputLabel id="lblEndDate" style="left: 384px; top: 120px; position: absolute; width: 110px" value="End Date"/>
                                                            <ice:commandButton action="#{Training$TrainingActionPlan.btnStartTime_action}" id="btnStartTime"
                                                                image="/resources/images/cal_icon.JPG"
                                                                style="height: 23px; left: 640px; top: 90px; position: absolute; width: 31px" value="submit"/>
                                                            <ice:commandButton action="#{Training$TrainingActionPlan.button1_action}" id="button1"
                                                                image="/resources/images/cal_icon.JPG"
                                                                style="height: 24px; left: 640px; top: 120px; position: absolute; width: 31px" value="submit"/>
                                                            <ice:inputText binding="#{Training$TrainingActionPlan.txtNoOfDays}" id="txtNoOfDays" style="left: 502px; top: 150px; position: absolute; width: 50px"/>
                                                            <ice:commandButton action="#{Training$TrainingActionPlan.btnNoOfDays_action}" id="btnNoOfDays"
                                                                style="left: 384px; top: 140px; position: absolute; width: 96px" value="No. Of Days"/>
                                                            <ice:selectInputDate binding="#{Training$TrainingActionPlan.calTentativeStartDate}"
                                                                id="calTentativeStartDate" rendered="false" style="left: 312px; top: 236px; position: absolute"
                                                                value="#{Training$TrainingActionPlan.selectInputDate1Bean.date1}" valueChangeListener="#{Training$TrainingActionPlan.calTentativeStartDate_processValueChange}"/>
                                                            <ice:selectInputDate binding="#{Training$TrainingActionPlan.calTentativeEndDate}"
                                                                id="calTentativeEndDate" rendered="false" style="left: 312px; top: 236px; position: absolute"
                                                                value="#{Training$TrainingActionPlan.selectInputDate2Bean.date1}" valueChangeListener="#{Training$TrainingActionPlan.calTentativeEndDate_processValueChange}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="height: 44px; left: 0px; top: 470px; position: absolute; width: 704px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Training$TrainingActionPlan.btnSave_action}" id="btnSave"
                                                                style="left: 274px; top: 2px; position: absolute; width: 71px" value="Save"/>
                                                            <ice:commandButton action="#{Training$TrainingActionPlan.btnReset_action}" id="btnReset"
                                                                style="left: 371px; top: 1px; position: absolute; width: 71px" value="Reset"/>
                                                        </ice:panelLayout>
                                                    </ice:panelLayout>
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
                                                style="margin-left:10px;color:white;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">Bunna International Bank |Information System Department|Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingActionPlan.pnlPopupSuccessOrFailure}" clientOnly="true" draggable="false"
                            id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Bank Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Training$TrainingActionPlan.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Training$TrainingActionPlan.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Training$TrainingActionPlan.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Training$TrainingActionPlan.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingActionPlan.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="            Bunna Bank HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Training$TrainingActionPlan.outputTextConfirmDelete}" id="outputTextConfirmDelete"
                                            style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Training$TrainingActionPlan.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Training$TrainingActionPlan.btnPopupCancelDelete_action}" id="btnPopupCancelDelete"
                                            style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingActionPlan.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="Bunna Bank HRMS - View request status "/>
                                    <ice:commandLink action="#{Training$TrainingActionPlan.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Training$TrainingActionPlan.decisionsMadeOnRequest}" var="currentRow">
                                            <ice:column id="colNumber">
                                                <ice:outputText id="optTxtForColumnNumber" value="#{currentRow['counter']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextNumber" value="NO"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colDecisionGiven">
                                                <ice:outputText id="optTxtForColumnDecisionGiven" value="#{currentRow['givenDecision']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextDecisionGiven" value="Decision"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colEmpId">
                                                <ice:outputText id="optTxtForColumnEmpId" value="#{currentRow['deciderEmployeeId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEmpId" value="EmpId"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colEmpFullName">
                                                <ice:outputText id="optTxtForColumnEmpFullName" value="#{currentRow['deciderFullName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEmpFullName" value="Employee Full Name"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colCommentGiven">
                                                <ice:outputText id="optTxtForCommentGiven" value="#{currentRow['commentGiven']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextCommentGiven" value="Comment Given"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colDate">
                                                <ice:outputText id="optTxtForDate" value="#{currentRow['decidedDateAndTIme']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextDate" value="Date"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
