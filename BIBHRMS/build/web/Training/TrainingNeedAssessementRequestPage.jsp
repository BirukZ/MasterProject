<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : BravoZulu
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
                        <ice:panelBorder id="whole_page" renderCenter="#{Training$TrainingNeedAssessementRequestPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Training$TrainingNeedAssessementRequestPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Training$TrainingNeedAssessementRequestPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Training$TrainingNeedAssessementRequestPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Training$TrainingNeedAssessementRequestPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1024">
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
                                <ice:panelGroup id="menu_left" style="border:none; height:1000px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:1000px;top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: -4px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header" style="height: 43px">
                                                        <ice:outputText id="lblSearchArea" value="Login Person Information"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" style="height: 264px" width="100%">
                                                    <ice:panelLayout id="loginContainer" style="height: 115px; position: absolute; width: 204px">
                                                        <ice:inputText binding="#{Training$TrainingNeedAssessementRequestPage.txtDepartment}" id="txtDepartment" style="left: 25px; top: 49px; position: absolute"/>
                                                        <ice:inputText binding="#{Training$TrainingNeedAssessementRequestPage.txtLoginId}" id="txtLoginId" style="height: 24px; left: 25px; top: -50px; position: absolute; width: 64px"/>
                                                        <ice:inputText binding="#{Training$TrainingNeedAssessementRequestPage.txtFullName}" id="txtFullName" style="left: 25px; top: 2px; position: absolute"/>
                                                        <ice:outputLabel id="lblDepartment" style="left: 25px; top: 24px; position: absolute" value="Department:"/>
                                                        <ice:outputLabel id="lblFullName" style="left: 24px; top: -24px; position: absolute" value="Full Name:"/>
                                                        <ice:outputLabel id="lblLoginId" style="left: 24px; top: -74px; position: absolute" value="Login Person Id:"/>
                                                        <ice:inputText binding="#{Training$TrainingNeedAssessementRequestPage.txtPosition}" id="txtPosition" style="left: 25px; top: 96px; position: absolute"/>
                                                        <ice:outputLabel id="lblPosition" style="left: 25px; top: 70px; position: absolute" value="Position:"/>
                                                    </ice:panelLayout>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li></li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="Pending"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:190px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 185px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox id="selectMyRequestLists" partialSubmit="true" size="6"
                                                                style="height: 180px; width: 190px"
                                                                value="#{Training$TrainingNeedAssessementRequestPage.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Training$TrainingNeedAssessementRequestPage.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Training$TrainingNeedAssessementRequestPage.pendingRequestList}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_history" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="history_Group_Header">
                                                        <ice:outputText id="lblHistoryStatus" value="History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="HistoryStatusBoard" width="100%">
                                                    <ice:panelGroup id="History_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:190px; width: 100%">
                                                        <ice:panelLayout id="HistoryStatusContainer" style="height: 185px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox id="selectMyHistoryLists" partialSubmit="true" size="6"
                                                                style="height: 180px; width: 190px"
                                                                value="#{Training$TrainingNeedAssessementRequestPage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Training$TrainingNeedAssessementRequestPage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{Training$TrainingNeedAssessementRequestPage.requestHistoryList}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup dragListener="#{Training$TrainingNeedAssessementRequestPage.page_display_processMyEvent}" id="page_display" style="height:1100px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 1100px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 1100px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Training Request"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 980px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Training$TrainingNeedAssessementRequestPage.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 980px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout1" style=" top:0px; width: 100%; position: absolute; height: 100%;">
                                                        <ice:panelLayout id="pnlLayoutRequester"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 125px; margin-left: 15px; left: 13px; top: 23px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:selectInputText
                                                                action="#{Training$TrainingNeedAssessementRequestPage.txtRequesterFullName_action}"
                                                                binding="#{Training$TrainingNeedAssessementRequestPage.txtRequesterFullName}"
                                                                id="txtRequesterFullName" immediate="true" listValue="#{ApplicationBean1.list}"
                                                                listVar="employeeList" partialSubmit="true" rows="10"
                                                                style="left: 129px; top: 22px; position: absolute"
                                                                valueChangeListener="#{ApplicationBean1.updateList}" width="239">
                                                                <f:facet name="selectInputText">
                                                                    <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                        <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                        <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                    </ice:panelGrid>
                                                                </f:facet>
                                                            </ice:selectInputText>
                                                            <ice:outputLabel id="lblRequester" style="color: #0066cc; left: 10px; top: 4px; position: absolute" value="#{msgTraining.Requester}"/>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgTraining.Deparment}"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 384px; top: 24px; position: absolute" value="#{msgTraining.employeeid}"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementRequestPage.txtRequesterDepartment}"
                                                                disabled="true" id="txtRequesterDepartment" style="left: 124px; top: 61px; position: absolute; width: 528px"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementRequestPage.txtRequesterId}"
                                                                id="txtRequesterId" immediate="true" partialSubmit="true" style="left: 476px; top: 26px; position: absolute; width: 175px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgTraining.FullName}"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="#{msgTraining.Position}"/>
                                                            <ice:inputText action="#{Training$TrainingNeedAssessementRequestPage.txtRequesterPosition_action}"
                                                                binding="#{Training$TrainingNeedAssessementRequestPage.txtRequesterPosition}" disabled="true"
                                                                id="txtRequesterPosition" style="left: 122px; top: 95px; position: absolute; width: 532px"/>
                                                            <ice:commandButton action="#{Training$TrainingNeedAssessementRequestPage.btnSearchRequester_action}"
                                                                id="btnSearchRequester" image="/resources/images/fig_search.gif" style="left: 602px; top: 29px; position: absolute"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputRequestAttributes"
                                                            style="height: 335px; margin-left: 15px; left: 13px; top: 159px; overflow: auto; position: absolute; width: 703px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblAppliedDate" style="left: 395px; top: 106px; position: absolute" value="#{msgTraining.AppliedDate}"/>
                                                            <ice:outputLabel id="lblBudjetYear" style="left: 50px; top: 98px; position: absolute" value="#{msgTraining.BudjeYear}"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementRequestPage.txtAppliedDate}"
                                                                disabled="true" id="txtAppliedDate" style="left: 483px; top: 105px; position: absolute; width: 132px"/>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementRequestPage.drlBudgetYear}"
                                                                id="drlBudgetYear" partialSubmit="true"
                                                                style="left: 124px; top: 104px; position: absolute; width: 193px" value="#{Training$TrainingNeedAssessementRequestPage.selectedObjectOfBudjetYearList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems22" value="#{Training$TrainingNeedAssessementRequestPage.budjetYearList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblStartDate" style="left: 411px; top: 232px; position: absolute" value="#{msgTraining.StartDate}"/>
                                                            <ice:outputLabel id="lblEndDate" style="left: 416px; top: 262px; position: absolute" value="#{msgTraining.EndDate}"/>
                                                            <ice:outputLabel id="lblPriority" style="left: 411px; top: 173px; position: absolute" value="#{msgTraining.Priority}"/>
                                                            <ice:outputLabel id="lblNeedSource"
                                                                style="left: 370px; top: 144px; position: absolute; width: 115px" value="#{msgTraining.TrainingReason}"/>
                                                            <ice:outputLabel id="lblTrainingTitle" style="left: 51px; top: 36px; position: absolute" value="#{msgTraining.Title}"/>
                                                            <ice:outputLabel id="lblTrainingCategory" style="left: 45px; top: -1px; position: absolute" value="#{msgTraining.Category}"/>
                                                            <ice:outputLabel id="lblGeneralComment" style="left: 385px; top: 12px; position: absolute" value="Comment"/>
                                                            <ice:inputTextarea binding="#{Training$TrainingNeedAssessementRequestPage.txtaGeneralComment}"
                                                                id="txtaGeneralComment" style="height: 50px; left: 483px; top: 4px; position: absolute; width: 159px"/>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementRequestPage.drlPriority}"
                                                                id="drlPriority" partialSubmit="true"
                                                                style="left: 483px; top: 175px; position: absolute; width: 159px" value="#{Training$TrainingNeedAssessementRequestPage.selectedObjectOfPriorityList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{Training$TrainingNeedAssessementRequestPage.priorityList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementRequestPage.drlNeedSource}"
                                                                id="drlNeedSource" partialSubmit="true"
                                                                style="left: 483px; top: 142px; position: absolute; width: 159px" value="#{Training$TrainingNeedAssessementRequestPage.selectedObjectOfNeedSourcesList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems2" value="#{Training$TrainingNeedAssessementRequestPage.needSourceList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementRequestPage.drlTrainingName}"
                                                                id="drlTrainingName" partialSubmit="true"
                                                                style="left: 123px; top: 38px; position: absolute; width: 193px"
                                                                value="#{Training$TrainingNeedAssessementRequestPage.selectedObjectOfNeedTariningNameList.selectedObject}" valueChangeListener="#{Training$TrainingNeedAssessementRequestPage.drlTrainingName_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems3" value="#{Training$TrainingNeedAssessementRequestPage.tariningNameList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementRequestPage.drlTrainingCategory}"
                                                                id="drlTrainingCategory" partialSubmit="true"
                                                                style="left: 122px; top: 8px; position: absolute; width: 193px"
                                                                value="#{Training$TrainingNeedAssessementRequestPage.selectedObjectOfTrainingCategoryList.selectedObject}" valueChangeListener="#{Training$TrainingNeedAssessementRequestPage.drlTrainingCategory_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems4" value="#{Training$TrainingNeedAssessementRequestPage.trainingCategoryList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementRequestPage.txtTentativeStartDate}"
                                                                disabled="true" id="txtTentativeStartDate" style="left: 485px; top: 236px; position: absolute; width: 131px"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementRequestPage.txtTentativeEndDate}"
                                                                disabled="true" id="txtTentativeEndDate" style="left: 486px; top: 268px; position: absolute; width: 128px"/>
                                                            <ice:outputLabel id="lblNumberOfAttendants" style="left: 49px; top: 208px; position: absolute" value="#{msgTraining.NoofEmp}"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementRequestPage.txtNumberOfAttendants}"
                                                                disabled="true" id="txtNumberOfAttendants"
                                                                style="left: 125px; top: 207px; position: absolute; width: 64px" value="#{Training$TrainingNeedAssessementRequestPage.numberOfEmployees}"/>
                                                            <ice:commandButton action="#{Training$TrainingNeedAssessementRequestPage.btnCalStartDate_action}"
                                                                binding="#{Training$TrainingNeedAssessementRequestPage.btnCalStartDate}" id="btnCalStartDate"
                                                                image="/resources/images/cal_icon.JPG" style="left: 619px; top: 236px; position: absolute"/>
                                                            <ice:commandButton action="#{Training$TrainingNeedAssessementRequestPage.btnCalEndDate_action}"
                                                                binding="#{Training$TrainingNeedAssessementRequestPage.btnCalEndDate}" id="btnCalEndDate"
                                                                image="/resources/images/cal_icon.JPG" style="left: 618px; top: 265px; position: absolute"/>
                                                            <ice:outputLabel id="lblDuration" style="left: 412px; top: 198px; position: absolute" value="#{msgTraining.Duration}"/>
                                                            <ice:outputLabel id="lblTrainer" style="left: 49px; top: 143px; position: absolute" value="#{msgTraining.Trainer}"/>
                                                            <ice:outputLabel id="lblInstitutionOrPlace" style="left: 51px; top: 175px; position: absolute" value="#{msgTraining.Institution}"/>
                                                            <ice:selectInputDate id="calAssignedDate" rendered="false"
                                                                style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                                                value="#{Committee$CommitteeMemberRegistrationPage.selectInputDate1Bean.date1}" valueChangeListener="#{Committee$CommitteeMemberRegistrationPage.calAssignedDate_processValueChange}"/>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementRequestPage.drlDurationCategory}"
                                                                id="drlDurationCategory" partialSubmit="true"
                                                                style="left: 483px; top: 203px; position: absolute; width: 159px" value="#{Training$TrainingNeedAssessementRequestPage.selectedObjectOfDurationCategoryList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{Training$TrainingNeedAssessementRequestPage.durationCategoryList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementRequestPage.drlTrainerType}"
                                                                id="drlTrainerType" partialSubmit="true"
                                                                style="left: 125px; top: 141px; position: absolute; width: 190px"
                                                                value="#{Training$TrainingNeedAssessementRequestPage.selectedObjectOfTrainerTypeList.selectedObject}" valueChangeListener="#{Training$TrainingNeedAssessementRequestPage.drlTrainerType_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems13" value="#{Training$TrainingNeedAssessementRequestPage.trainerTypeList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementRequestPage.drlInstitutionOrPlace}"
                                                                id="drlInstitutionOrPlace" partialSubmit="true"
                                                                style="left: 124px; top: 176px; position: absolute; width: 190px"
                                                                value="#{Training$TrainingNeedAssessementRequestPage.selectedObjectOfInstitutionOrPlaceList.selectedObject}" valueChangeListener="#{Training$TrainingNeedAssessementRequestPage.drlInstitutionOrPlace_processValueChange}">
                                                                <f:selectItems id="selectOneMenu2selectItems" value="#{Training$TrainingNeedAssessementRequestPage.institutionOrPlaceList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputText
                                                                action="#{Training$TrainingNeedAssessementRequestPage.txtUnavailableTrainingTitle_action}"
                                                                binding="#{Training$TrainingNeedAssessementRequestPage.txtUnavailableTrainingTitle}"
                                                                disabled="true" id="txtUnavailableTrainingTitle" style="left: 124px; top: 67px; position: absolute; width: 518px"/>
                                                            <ice:outputLabel id="lblPurpose" style="left: 50px; top: 302px; position: absolute" value="#{msgTraining.Purpose}"/>
                                                            <ice:outputLabel id="lblPlanned" style="left: 157px; top: 306px; position: absolute" value="#{msgTraining.Planned}"/>
                                                            <ice:outputLabel id="lblUnplanned" style="left: 347px; top: 303px; position: absolute" value="#{msgTraining.Unplanned}"/>
                                                            <ice:selectBooleanCheckbox binding="#{Training$TrainingNeedAssessementRequestPage.ckbPlanned}"
                                                                id="ckbPlanned" partialSubmit="true" style="left: 127px; top: 304px; position: absolute"
                                                                value="#{Training$TrainingNeedAssessementRequestPage.defaultSelectedDataPlanned.selectedBoolean}" valueChangeListener="#{Training$TrainingNeedAssessementRequestPage.ckbPlanned_processValueChange}"/>
                                                            <ice:selectBooleanCheckbox binding="#{Training$TrainingNeedAssessementRequestPage.ckbUnplanned}"
                                                                id="ckbUnplanned" partialSubmit="true" style="left: 313px; top: 306px; position: absolute"
                                                                value="#{Training$TrainingNeedAssessementRequestPage.defaultSelectedDataUnplanned.selectedBoolean}" valueChangeListener="#{Training$TrainingNeedAssessementRequestPage.ckbUnplanned_processValueChange}"/>
                                                            <ice:commandLink action="#{Training$TrainingNeedAssessementRequestPage.commandLink1_action}"
                                                                id="commandLink1" immediate="true" partialSubmit="true"
                                                                style="height: 25px; left: 640px; top: 148px; position: absolute; width: 35px" value="[+]"/>
                                                            <ice:commandLink action="#{Training$TrainingNeedAssessementRequestPage.commandLink2_action}"
                                                                id="commandLink2" style="height: 25px; left: 315px; top: 182px; position: absolute; width: 35px" value="[+]"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutParticipant"
                                                            style="height: 163px; left: 29px; top: 504px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:selectInputText
                                                                action="#{Training$TrainingNeedAssessementRequestPage.txtParticipantFullName_action}"
                                                                binding="#{Training$TrainingNeedAssessementRequestPage.txtParticipantFullName}"
                                                                id="txtParticipantFullName" immediate="true" listValue="#{ApplicationBean1.list}"
                                                                listVar="employeeList" partialSubmit="true" rows="10"
                                                                style="left: 129px; top: 22px; position: absolute"
                                                                valueChangeListener="#{ApplicationBean1.updateList}" width="239">
                                                                <f:facet name="selectInputText">
                                                                    <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                        <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                        <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                    </ice:panelGrid>
                                                                </f:facet>
                                                            </ice:selectInputText>
                                                            <ice:outputLabel id="lblParticipant"
                                                                style="color: #0066cc; left: 10px; top: 4px; position: absolute" value="#{msgTraining.Participants}"/>
                                                            <ice:outputLabel id="lblParticipantDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgTraining.Deparment}"/>
                                                            <ice:outputLabel id="lblParticipantId" style="left: 384px; top: 24px; position: absolute" value="#{msgTraining.employeeid}"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementRequestPage.txtParticipantDepartment}"
                                                                disabled="true" id="txtParticipantDepartment" style="left: 122px; top: 68px; position: absolute; width: 528px"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementRequestPage.txtParticipantId}"
                                                                id="txtParticipantId" immediate="true" partialSubmit="true" style="left: 476px; top: 26px; position: absolute; width: 175px"/>
                                                            <ice:outputLabel id="lblParticipantFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgTraining.FullName}"/>
                                                            <ice:outputLabel id="lblParticipantPosition" style="left: 48px; top: 96px; position: absolute" value="#{msgTraining.Position}"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementRequestPage.txtParticipantPosition}"
                                                                disabled="true" id="txtParticipantPosition" style="left: 122px; top: 95px; position: absolute; width: 532px"/>
                                                            <ice:commandButton
                                                                action="#{Training$TrainingNeedAssessementRequestPage.btnSearchParticipant_action}"
                                                                id="btnSearchParticipant" image="/resources/images/fig_search.gif" style="left: 602px; top: 29px; position: absolute"/>
                                                            <ice:commandButton action="#{Training$TrainingNeedAssessementRequestPage.btnAddToTable_action}"
                                                                binding="#{Training$TrainingNeedAssessementRequestPage.btnAddToTable}" id="btnAddToTable"
                                                                style="left: 528px; top: 119px; position: absolute; width: 118px" value="Add to table"/>
                                                            <ice:commandLink
                                                                action="#{Training$TrainingNeedAssessementRequestPage.lnkViewPrevieousDecisions_action}"
                                                                binding="#{Training$TrainingNeedAssessementRequestPage.lnkViewPrevieousDecisions}"
                                                                id="lnkViewPrevieousDecisions"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; left: 60px; top: 126px; position: absolute" value="View status of  this request"/>
                                                            <ice:commandLink action="#{Training$TrainingNeedAssessementRequestPage.commandLink3_action}"
                                                                id="commandLink3"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; left: 235px; top: 126px; position: absolute" value="View Previous Training taken by Employee"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputParticipantLists"
                                                            style="height: 207px; margin-left: 15px; left: 14px; top: 680px; overflow: auto; position: absolute; width: 706px" styleClass="insideContainerMain">
                                                            <ice:dataTable id="dataTableParticipantLists"
                                                                style="height: 8px; left: 20px; top: 0px; position: absolute"
                                                                value="#{Training$TrainingNeedAssessementRequestPage.participantLists}" var="currentRow" width="665">
                                                                <ice:column id="colNumber">
                                                                    <ice:outputText id="optTxtForColumnFullName" value="#{currentRow['fullName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextFullName" value="Full Name"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colFullName">
                                                                    <ice:outputText id="optTxtForColumnDeparmentName" value="#{currentRow['departmentName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextDeparmentName" value="Deparment"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRepitition">
                                                                    <ice:outputText id="optTxtForColumnJobTitleName" value="#{currentRow['jobTitleName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextJobTitleName" value="Job Title "/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRemove" rendered="#{Training$TrainingNeedAssessementRequestPage.removeColumnRendered}">
                                                                    <ice:commandLink action="#{Training$TrainingNeedAssessementRequestPage.cmdLnkRemove_action}"
                                                                        id="cmdLnkRemove" value="Remove"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextRemove" value="Remove"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colDatabaseStatus" rendered="#{Training$TrainingNeedAssessementRequestPage.removeColumnRendered}">
                                                                    <ice:outputText id="outTxtStatuSelectedDatabaseStatus" value="#{currentRow['databaseStatus']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextDatabaseStatus" value="Status "/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colStatus" rendered="#{Training$TrainingNeedAssessementRequestPage.statusColumnRendered}">
                                                                    <ice:selectBooleanCheckbox disabled="true" id="ckBoxStatuSelectedStatus"
                                                                        partialSubmit="true" value="#{currentRow['selected']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextStatus" value="Status "/>
                                                                    </f:facet>
                                                                    <ice:rowSelector binding="#{Training$TrainingNeedAssessementRequestPage.rowSelector}"
                                                                        id="rowSelector" multiple="false" preStyleOnSelection="true"
                                                                        selectionListener="#{Training$TrainingNeedAssessementRequestPage.rowSelector_processMyEvent}"
                                                                        toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="height: 41px; margin-left: 15px; left: 14px; top: 900px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Training$TrainingNeedAssessementRequestPage.btnSaveOrUpdate_action}"
                                                                binding="#{Training$TrainingNeedAssessementRequestPage.btnSaveOrUpdate}" id="btnSaveOrUpdate"
                                                                style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{Training$TrainingNeedAssessementRequestPage.saveOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Training$TrainingNeedAssessementRequestPage.btnReset_action}"
                                                                id="btnReset" style="left: 336px; top: 0px; position: absolute; width: 71px" value="Reset"/>
                                                            <ice:commandButton action="#{Training$TrainingNeedAssessementRequestPage.btnDelete_action}"
                                                                binding="#{Training$TrainingNeedAssessementRequestPage.btnDelete}" id="btnDelete"
                                                                rendered="false" style="left: 450px; top: 0px; position: absolute; width: 71px" value="Delete"/>
                                                        </ice:panelLayout>
                                                        <ice:selectInputDate binding="#{Training$TrainingNeedAssessementRequestPage.calTentativeEndDate}"
                                                            id="calTentativeEndDate" rendered="false" style="left: 312px; top: 336px; position: absolute"
                                                            value="#{Training$TrainingNeedAssessementRequestPage.selectInputDate2Bean.date1}" valueChangeListener="#{Training$TrainingNeedAssessementRequestPage.calTentativeEndDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{Training$TrainingNeedAssessementRequestPage.calTentativeStartDate}"
                                                            id="calTentativeStartDate" rendered="false" style="left: 312px; top: 336px; position: absolute"
                                                            value="#{Training$TrainingNeedAssessementRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{Training$TrainingNeedAssessementRequestPage.calTentativeStartDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{Training$TrainingNeedAssessementRequestPage.calAppliedDate}"
                                                            id="calAppliedDate" rendered="false" style="left: 317px; top: 106px; position: absolute"
                                                            value="#{Training$TrainingNeedAssessementRequestPage.selectInputDateBean3.date1}" valueChangeListener="#{Training$TrainingNeedAssessementRequestPage.calAppliedDate_processValueChange}"/>
                                                        <ice:panelPopup autoCentre="true"
                                                            binding="#{Training$TrainingNeedAssessementRequestPage.lpAddTrainingReason}" clientOnly="true"
                                                            draggable="true" id="lpAddTrainingReason" modal="true" rendered="false"
                                                            style="display: block; height: 300px; left: 97px; top: 226px; position: absolute; width: 343px;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;" visible="true">
                                                            <f:facet name="header">
                                                                <ice:panelGrid id="panelGridAddTrainingReason" style="display: block; height: 20px; width: 300px">
                                                                    <ice:outputText
                                                                        binding="#{Training$TrainingNeedAssessementRequestPage.lblAddTrainingReason}"
                                                                        id="lblAddTrainingReason" value="You Can Add or Remove Training Reason Here"/>
                                                                    <ice:commandButton
                                                                        action="#{Training$TrainingNeedAssessementRequestPage.buttonCloseTrainingReason_action}"
                                                                        binding="#{Training$TrainingNeedAssessementRequestPage.buttonCloseTrainingReason}"
                                                                        id="buttonCloseTrainingReason" immediate="true" partialSubmit="true"
                                                                        style="left:302px; font-size: 11px; border-color: red; color:red; margin-top: -23px; position: absolute; visibility: visible; height:25px; width:25px" value="x"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                            <f:facet name="body">
                                                                <ice:panelGroup
                                                                    dragListener="#{Training$TrainingNeedAssessementRequestPage.panelGroupTrainingReasonMsgBody1_processMyEvent}"
                                                                    id="panelGroupTrainingReasonMsgBody1" style="display: block; height: 240px; position: relative; width: 300">
                                                                    <ice:panelGroup id="panelGroupTrainingReasonMsgBody2"
                                                                        style="top:0px; display: block; height: 90px; position: relative; width: 300" styleClass="icePnlGrp insideContainerPop">
                                                                        <ice:outputText id="popupTrainingReason1"
                                                                            style="font-size: 10px;margin-left: 5px; margin-top: 10px; position: absolute" value="Training Reason:"/>
                                                                        <ice:inputText
                                                                            binding="#{Training$TrainingNeedAssessementRequestPage.txt_TrainigReaoun}"
                                                                            id="txt_TrainigReaoun" partialSubmit="true" style="margin-left: 88px; margin-top: 14px; position: absolute;   width: 150px"/>
                                                                        <ice:outputText id="popupTrainingReasonType1"
                                                                            style="font-size: 10px;margin-left: 5px; margin-top: 50px; position: absolute" value="Description:"/>
                                                                        <ice:commandButton
                                                                            action="#{Training$TrainingNeedAssessementRequestPage.btnTrainingReasonAdd1_action}"
                                                                            binding="#{Training$TrainingNeedAssessementRequestPage.btnTrainingReasonAdd1}"
                                                                            id="btnTrainingReasonAdd1" partialSubmit="true"
                                                                            style="left:246px; margin-top: 60px; position: absolute; visibility: visible; height:25px; width: 50px"
                                                                            value="Add" visible="true"/>
                                                                        <ice:inputText
                                                                            binding="#{Training$TrainingNeedAssessementRequestPage.txt_traingDescrioption}"
                                                                            id="txt_traingDescrioption" partialSubmit="true" style="margin-left: 60px; margin-top: 52px; width: 150px"/>
                                                                    </ice:panelGroup>
                                                                    <ice:panelGroup id="panelGroupempTrainingReasonMsgBodyDelete1" rendered="false"
                                                                        style="top:30px; display: block; height: 50px; position: relative; width: 300" styleClass="icePnlGrp insideContainerPop">
                                                                        <ice:outputText id="popupTrainingReasonDelete1"
                                                                            style="font-size: 10px;margin-left: 2px; margin-top: 10px; position: absolute" value="Are you shure you want to delete the record?"/>
                                                                        <ice:commandButton action="#{Employee$EmployeePage.buttonempTitleY_action}"
                                                                            id="buttonTrainingReasonY1" partialSubmit="true"
                                                                            style="left:240px; margin-top: 20px; position: absolute; visibility: visible; height:25px; width: 25px" value="Y"/>
                                                                        <ice:commandButton action="#{Employee$EmployeePage.buttonempTitleN_action}"
                                                                            id="buttonTrainingReasonN1" partialSubmit="true"
                                                                            style="left:270px; margin-top: 20px; position: absolute; visibility: visible; height:25px; width: 25px" value="N"/>
                                                                    </ice:panelGroup>
                                                                    <ice:panelGroup id="panelGroupTrainingReasonMsgBody3"
                                                                        style="top:8px; display: block; height: 100px; overflow: auto; position: relative; width: 300" styleClass="icePnlGrp insideContainerPop">
                                                                        <ice:dataTable id="dataTableAddTrainingReason1"
                                                                            style="left: -2px; top:  -10px; width: 283px; position: absolute"
                                                                            value="#{Training$TrainingNeedAssessementRequestPage.traingOption}" var="currentRow">
                                                                            <ice:column id="column1trainingReason">
                                                                                <h:outputText id="outputText1" value="#{currentRow['trainingReason']}"/>
                                                                                <f:facet name="header">
                                                                                <ice:outputText id="outputText4TrainingReason1" value="Training Reason"/>
                                                                                </f:facet>
                                                                            </ice:column>
                                                                            <ice:column id="column2TrainingDescription">
                                                                                <h:outputText id="outputText3" value="#{currentRow['trainingDescription']}"/>
                                                                                <f:facet name="header">
                                                                                <ice:outputText id="outputText4TrainingReasonType1" value="Description" visible="true"/>
                                                                                </f:facet>
                                                                            </ice:column>
                                                                            <ice:column id="column1">
                                                                                <h:outputText id="outputText5" value="#{currentRow['status']}"/>
                                                                                <f:facet name="header">
                                                                                <ice:outputText id="outputText2" value="Status"/>
                                                                                </f:facet>
                                                                            </ice:column>
                                                                            <ice:column id="column2">
                                                                                <h:commandLink
                                                                                action="#{Training$TrainingNeedAssessementRequestPage.lnkAddTrainingReason_action}"
                                                                                id="lnkAddTrainingReason" value="Remove"/>
                                                                                <f:facet name="header">
                                                                                <ice:outputText id="outputText4" value="Remove"/>
                                                                                </f:facet>
                                                                                <ice:rowSelector
                                                                                binding="#{Training$TrainingNeedAssessementRequestPage.rowSelector1}"
                                                                                id="rowSelector1" multiple="false" preStyleOnSelection="true"
                                                                                selectionListener="#{Training$TrainingNeedAssessementRequestPage.rowSelector1_processMyEvent}"
                                                                                toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                                            </ice:column>
                                                                        </ice:dataTable>
                                                                    </ice:panelGroup>
                                                                    <ice:panelGroup id="panelGroupTrainingReasonMsgBodyButtons1"
                                                                        style="top:15px; display: block; height: 30px; position: relative; width: 300" styleClass="icePnlGrp insideContainerPop">
                                                                        <ice:commandButton
                                                                            action="#{Training$TrainingNeedAssessementRequestPage.btnTrainingReasonNew1_action}"
                                                                            id="btnTrainingReasonNew1" immediate="true" partialSubmit="true"
                                                                            style="left: 76px; top: -7px; position: absolute; visibility: visible; height:25px; width: 50px"
                                                                            value="New" visible="true"/>
                                                                        <ice:commandButton
                                                                            action="#{Training$TrainingNeedAssessementRequestPage.btnTrainingReasonSave1_action}"
                                                                            binding="#{Training$TrainingNeedAssessementRequestPage.btnTrainingReasonSave1}"
                                                                            id="btnTrainingReasonSave1" partialSubmit="true"
                                                                            style="left: 180px; top: -7px; position: absolute; visibility: visible; height:25px; width: 50px"
                                                                            value="Save" visible="true"/>
                                                                    </ice:panelGroup>
                                                                </ice:panelGroup>
                                                            </f:facet>
                                                        </ice:panelPopup>
                                                        <ice:panelPopup autoCentre="true"
                                                            binding="#{Training$TrainingNeedAssessementRequestPage.lpAddInstitution}" clientOnly="true"
                                                            draggable="true" id="lpAddInstitution" modal="true" rendered="false" style="display: block; height: 300px; left: 97px; top: 226px; position: absolute; width: 343px;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: visible;visibility: hidden;">
                                                            <f:facet name="header">
                                                                <ice:panelGrid id="panelGridAddInstitution" style="display: block; height: 20px; width: 300px">
                                                                    <ice:outputText binding="#{Training$TrainingNeedAssessementRequestPage.lblAddInstitution}"
                                                                        id="lblAddInstitution" value="You Can Add or Remove Institution Here"/>
                                                                    <ice:commandButton
                                                                        action="#{Training$TrainingNeedAssessementRequestPage.buttonCloseInstitution_action}"
                                                                        binding="#{Training$TrainingNeedAssessementRequestPage.buttonCloseInstitution}"
                                                                        id="buttonCloseInstitution" immediate="true" partialSubmit="true"
                                                                        style="left:302px; font-size: 11px; border-color: red; color:red; margin-top: -23px; position: absolute; visibility: visible; height:25px; width:25px" value="x"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                            <f:facet name="body">
                                                                <ice:panelGroup
                                                                    dragListener="#{Training$TrainingNeedAssessementRequestPage.panelGroupInstitutionMsgBody1_processMyEvent}"
                                                                    id="panelGroupInstitutionMsgBody1" style="display: block; height: 240px; position: relative; width: 300">
                                                                    <ice:panelGroup id="panelGroupInstitutionMsgBody2"
                                                                        style="top:0px; display: block; height: 90px; position: relative; width: 300" styleClass="icePnlGrp insideContainerPop">
                                                                        <ice:outputText id="lblInstitution"
                                                                            style="font-size: 10px;margin-left: 5px; margin-top: 10px; position: absolute" value="Institution:"/>
                                                                        <ice:inputText binding="#{Training$TrainingNeedAssessementRequestPage.txtInstitution}"
                                                                            id="txtInstitution" partialSubmit="true" style="margin-left: 88px; margin-top: 14px; position: absolute;   width: 150px"/>
                                                                        <ice:outputText id="lblDescription"
                                                                            style="font-size: 10px;margin-left: 5px; margin-top: 50px; position: absolute" value="Description:"/>
                                                                        <ice:commandButton
                                                                            action="#{Training$TrainingNeedAssessementRequestPage.btnInstitutionAdd1_action}"
                                                                            binding="#{Training$TrainingNeedAssessementRequestPage.btnInstitutionAdd1}"
                                                                            id="btnInstitutionAdd1" partialSubmit="true"
                                                                            style="left:246px; margin-top: 60px; position: absolute; visibility: visible; height:25px; width: 50px"
                                                                            value="Add" visible="true"/>
                                                                        <ice:inputText binding="#{Training$TrainingNeedAssessementRequestPage.txtDescription}"
                                                                            id="txtDescription" partialSubmit="true" style="margin-left: 60px; margin-top: 52px; width: 150px"/>
                                                                    </ice:panelGroup>
                                                                    <ice:panelGroup id="panelGroupempInstitutionMsgBodyDelete1" rendered="false"
                                                                        style="top:30px; display: block; height: 50px; position: relative; width: 300" styleClass="icePnlGrp insideContainerPop"/>
                                                                    <ice:panelGroup id="panelGroupInstitutionMsgBody3"
                                                                        style="top:8px; display: block; height: 100px; overflow: auto; position: relative; width: 300" styleClass="icePnlGrp insideContainerPop">
                                                                        <ice:dataTable id="dataTableAddInstitution1"
                                                                            style="left: -2px; top:  -10px; width: 283px; position: absolute"
                                                                            value="#{Training$TrainingNeedAssessementRequestPage.institutionOption}" var="currentRow">
                                                                            <ice:column id="column1Institution">
                                                                                <h:outputText id="outputText1" value="#{currentRow['institution']}"/>
                                                                                <f:facet name="header">
                                                                                <ice:outputText id="outputText4Institution1" value="Institution"/>
                                                                                </f:facet>
                                                                                <ice:rowSelector
                                                                                binding="#{Training$TrainingNeedAssessementRequestPage.rowSelector2}"
                                                                                id="rowSelector2"
                                                                                selectionListener="#{Training$TrainingNeedAssessementRequestPage.rowSelector2_processMyEvent}"
                                                                                toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                                            </ice:column>
                                                                            <ice:column id="column2InstitutionDescription">
                                                                                <h:outputText id="outputText3" value="#{currentRow['institutionDescription']}"/>
                                                                                <f:facet name="header">
                                                                                <ice:outputText id="outputText4InstitutionType1" value="Description" visible="true"/>
                                                                                </f:facet>
                                                                            </ice:column>
                                                                            <ice:column id="column1">
                                                                                <h:outputText id="outputText5" value="#{currentRow['status']}"/>
                                                                                <f:facet name="header">
                                                                                <ice:outputText id="outputText2" value="Status"/>
                                                                                </f:facet>
                                                                            </ice:column>
                                                                            <ice:column id="column2">
                                                                                <h:commandLink
                                                                                action="#{Training$TrainingNeedAssessementRequestPage.lnkAddInstitution_action}"
                                                                                id="lnkAddInstitution" value="Remove"/>
                                                                                <f:facet name="header">
                                                                                <ice:outputText id="outputText4" value="Remove"/>
                                                                                </f:facet>
                                                                            </ice:column>
                                                                        </ice:dataTable>
                                                                    </ice:panelGroup>
                                                                    <ice:panelGroup id="panelGroupInstitutionMsgBodyButtons1"
                                                                        style="top:15px; display: block; height: 30px; position: relative; width: 300" styleClass="icePnlGrp insideContainerPop">
                                                                        <ice:commandButton
                                                                            action="#{Training$TrainingNeedAssessementRequestPage.btnInstitutionNew1_action}"
                                                                            id="btnInstitutionNew1" immediate="true" partialSubmit="true"
                                                                            style="left: 76px; top: -7px; position: absolute; visibility: visible; height:25px; width: 50px"
                                                                            value="New" visible="true"/>
                                                                        <ice:commandButton
                                                                            action="#{Training$TrainingNeedAssessementRequestPage.btnInstitutionSave1_action}"
                                                                            binding="#{Training$TrainingNeedAssessementRequestPage.btnInstitutionSave1}"
                                                                            id="btnInstitutionSave1" partialSubmit="true"
                                                                            style="left: 180px; top: -7px; position: absolute; visibility: visible; height:25px; width: 50px"
                                                                            value="Save" visible="true"/>
                                                                    </ice:panelGroup>
                                                                </ice:panelGroup>
                                                            </f:facet>
                                                        </ice:panelPopup>
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
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">Bunna International Bank |
Information System Department |Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingNeedAssessementRequestPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Bank Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Training$TrainingNeedAssessementRequestPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Training$TrainingNeedAssessementRequestPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Training$TrainingNeedAssessementRequestPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Training$TrainingNeedAssessementRequestPage.lblSuccessOrErrorMessage}"
                                            id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingNeedAssessementRequestPage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="            Bunna Bank HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Training$TrainingNeedAssessementRequestPage.outputTextConfirmDelete}"
                                            id="outputTextConfirmDelete" style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Training$TrainingNeedAssessementRequestPage.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Training$TrainingNeedAssessementRequestPage.btnPopupCancelDelete_action}"
                                            id="btnPopupCancelDelete" style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingNeedAssessementRequestPage.pnlPopupViewPrevieousDecisions}"
                            draggable="true" id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="Bunna Bank HRMS - View request status "/>
                                    <ice:commandLink action="#{Training$TrainingNeedAssessementRequestPage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Training$TrainingNeedAssessementRequestPage.decisionsMadeOnRequest}" var="currentRow">
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
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingNeedAssessementRequestPage.pnlPopupViewPrevieousTrainings}"
                            draggable="true" id="pnlPopupViewPrevieousTrainings" modal="true" rendered="false" style="height: 261px; left: 408px; top: 250px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridpnlPopupViewPrevieousTrainings" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousTrainingsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="Bunna Bank HRMS - View Previous Training Status "/>
                                    <ice:commandLink action="#{Training$TrainingNeedAssessementRequestPage.btnCloseViewPreviesTrainings_action}"
                                        id="btnClosepnlPopupViewPrevieousTrainings" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousTrainings" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable1" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableTrainingType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Training$TrainingNeedAssessementRequestPage.previousTrainingRequest}" var="currentRow">
                                            <ice:column id="colNumber">
                                                <ice:outputText id="optTxtForColumnNumber" value="#{currentRow['counter']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextNumber" value="NO"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colEmpId">
                                                <ice:outputText id="optTxtForColumnEmpId" value="#{currentRow['deciderEmployeeId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEmpId" value="Employee Id"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colEmpFullName">
                                                <ice:outputText id="optTxtForColumnEmpFullName" value="#{currentRow['deciderFullName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEmpFullName" value="Training Name"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colDecisionGiven">
                                                <ice:outputText id="optTxtForColumnDecisionGiven" value="#{currentRow['givenDecision']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextDecisionGiven" value="Start Date"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colDate">
                                                <ice:outputText id="optTxtForDate" value="#{currentRow['decidedDateAndTIme']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextDate" value="End Date"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colCommentGiven">
                                                <ice:outputText id="optTxtForCommentGiven" value="#{currentRow['commentGiven']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextCommentGiven" value="Trained By"/>
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
