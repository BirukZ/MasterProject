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
                        <ice:panelBorder id="whole_page" renderCenter="#{Training$TrainingNeedAssessementApprovePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Training$TrainingNeedAssessementApprovePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Training$TrainingNeedAssessementApprovePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Training$TrainingNeedAssessementApprovePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Training$TrainingNeedAssessementApprovePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="height: 1117px">
                                    <ice:panelLayout id="left_menu1" layout="flow" style="height: 1098px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:900px; left: -4px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header" style="height: 43px">
                                                        <ice:outputText id="lblSearchArea" value="Login Person Information"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" style="height: 264px" width="100%">
                                                    <ice:panelLayout id="loginContainer" style="height: 115px; position: absolute; width: 204px">
                                                        <ice:inputText binding="#{Training$TrainingNeedAssessementApprovePage.txtDepartment}" id="txtDepartment" style="left: 25px; top: 49px; position: absolute"/>
                                                        <ice:inputText binding="#{Training$TrainingNeedAssessementApprovePage.txtLoginId}" id="txtLoginId" style="height: 24px; left: 25px; top: -50px; position: absolute; width: 64px"/>
                                                        <ice:inputText binding="#{Training$TrainingNeedAssessementApprovePage.txtFullName}" id="txtFullName" style="left: 25px; top: 2px; position: absolute"/>
                                                        <ice:outputLabel id="lblDepartment" style="left: 25px; top: 24px; position: absolute" value="Department:"/>
                                                        <ice:outputLabel id="lblFullName" style="left: 24px; top: -24px; position: absolute" value="Full Name:"/>
                                                        <ice:outputLabel id="lblLoginId" style="left: 24px; top: -74px; position: absolute" value="Login Person Id:"/>
                                                        <ice:inputText binding="#{Training$TrainingNeedAssessementApprovePage.txtPosition}" id="txtPosition" style="left: 25px; top: 96px; position: absolute"/>
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
                                                            <ice:selectOneListbox binding="#{Training$TrainingNeedAssessementApprovePage.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 180px; width: 190px"
                                                                value="#{Training$TrainingNeedAssessementApprovePage.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Training$TrainingNeedAssessementApprovePage.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Training$TrainingNeedAssessementApprovePage.pendingRequestList}"/>
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
                                                                value="#{Training$TrainingNeedAssessementApprovePage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Training$TrainingNeedAssessementApprovePage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{Training$TrainingNeedAssessementApprovePage.requestHistoryList}"/>
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
                                <ice:panelGroup dragListener="#{Training$TrainingNeedAssessementApprovePage.page_display_processMyEvent}" id="page_display" style="height:1000px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 1200px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 1200px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Training Approve"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 1082px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 1057px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout1" style="height: 1056px; top: 0px; position: absolute; width: 100%">
                                                        <ice:panelLayout id="pnlLayoutRequester"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 125px; margin-left: 15px; left: 13px; top: 23px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:selectInputText
                                                                action="#{Training$TrainingNeedAssessementApprovePage.txtRequesterFullName_action}"
                                                                binding="#{Training$TrainingNeedAssessementApprovePage.txtRequesterFullName}"
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
                                                            <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="#{msgTraining.Requester}"/>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgTraining.Deparment}"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 384px; top: 24px; position: absolute" value="#{msgTraining.employeeid}"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementApprovePage.txtRequesterDepartment}"
                                                                disabled="true" id="txtRequesterDepartment" style="left: 124px; top: 61px; position: absolute; width: 528px"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementApprovePage.txtRequesterId}"
                                                                id="txtRequesterId" immediate="true" partialSubmit="true" style="left: 476px; top: 26px; position: absolute; width: 175px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgTraining.FullName}"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="#{msgTraining.Position}"/>
                                                            <ice:inputText action="#{Training$TrainingNeedAssessementApprovePage.txtRequesterPosition_action}"
                                                                binding="#{Training$TrainingNeedAssessementApprovePage.txtRequesterPosition}" disabled="true"
                                                                id="txtRequesterPosition" style="left: 122px; top: 95px; position: absolute; width: 532px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputRequestAttributes"
                                                            style="height: 390px; margin-left: 15px; left: 13px; top: 159px; overflow: auto; position: absolute; width: 703px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblAppliedDate" style="left: 408px; top: 106px; position: absolute" value="#{msgTraining.AppliedDate}"/>
                                                            <ice:outputLabel id="lblBudjetYear" style="left: 50px; top: 98px; position: absolute" value="#{msgTraining.BudjeYear}"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementApprovePage.txtAppliedDate}"
                                                                disabled="true" id="txtAppliedDate" style="left: 483px; top: 105px; position: absolute; width: 132px"/>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementApprovePage.drlBudgetYear}"
                                                                id="drlBudgetYear" partialSubmit="true"
                                                                style="left: 123px; top: 103px; position: absolute; width: 193px" value="#{Training$TrainingNeedAssessementApprovePage.selectedObjectOfBudjetYearList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems22" value="#{Training$TrainingNeedAssessementApprovePage.budjetYearList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblStartDate" style="left: 411px; top: 232px; position: absolute" value="#{msgTraining.StartDate}"/>
                                                            <ice:outputLabel id="lblEndDate" style="left: 416px; top: 262px; position: absolute" value="#{msgTraining.EndDate}"/>
                                                            <ice:outputLabel id="lblPriority" style="left: 411px; top: 173px; position: absolute" value="#{msgTraining.Priority}"/>
                                                            <ice:outputLabel id="lblNeedSource" style="left: 390px; top: 142px; position: absolute" value="#{msgTraining.TrainingReason}"/>
                                                            <ice:outputLabel id="lblTrainingTitle" style="left: 51px; top: 36px; position: absolute" value="#{msgTraining.Title}"/>
                                                            <ice:outputLabel id="lblTrainingCategory" style="left: 48px; top: 0px; position: absolute" value="#{msgTraining.Category}"/>
                                                            <ice:outputLabel id="lblGeneralComment" style="left: 385px; top: 12px; position: absolute" value="#{msgTraining.Comment}"/>
                                                            <ice:inputTextarea binding="#{Training$TrainingNeedAssessementApprovePage.txtaGeneralComment}"
                                                                id="txtaGeneralComment" style="height: 50px; left: 483px; top: 4px; position: absolute; width: 159px"/>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementApprovePage.drlPriority}"
                                                                id="drlPriority" partialSubmit="true"
                                                                style="left: 483px; top: 175px; position: absolute; width: 159px" value="#{Training$TrainingNeedAssessementApprovePage.selectedObjectOfPriorityList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{Training$TrainingNeedAssessementApprovePage.priorityList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementApprovePage.drlNeedSource}"
                                                                id="drlNeedSource" partialSubmit="true"
                                                                style="left: 483px; top: 142px; position: absolute; width: 159px" value="#{Training$TrainingNeedAssessementApprovePage.selectedObjectOfNeedSourcesList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems2" value="#{Training$TrainingNeedAssessementApprovePage.needSourceList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementApprovePage.drlTrainingName}"
                                                                id="drlTrainingName" partialSubmit="true"
                                                                style="left: 123px; top: 38px; position: absolute; width: 193px"
                                                                value="#{Training$TrainingNeedAssessementApprovePage.selectedObjectOfNeedTariningNameList.selectedObject}" valueChangeListener="#{Training$TrainingNeedAssessementApprovePage.drlTrainingName_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems3" value="#{Training$TrainingNeedAssessementApprovePage.tariningNameList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementApprovePage.drlTrainingCategory}"
                                                                id="drlTrainingCategory" partialSubmit="true"
                                                                style="left: 122px; top: 8px; position: absolute; width: 193px" value="#{Training$TrainingNeedAssessementApprovePage.selectedObjectOfTrainingCategoryList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems4" value="#{Training$TrainingNeedAssessementApprovePage.trainingCategoryList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementApprovePage.txtTentativeStartDate}"
                                                                id="txtTentativeStartDate" style="left: 485px; top: 236px; position: absolute; width: 131px"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementApprovePage.txtTentativeEndDate}"
                                                                id="txtTentativeEndDate" style="left: 486px; top: 268px; position: absolute; width: 128px"/>
                                                            <ice:outputLabel id="lblDuration" style="left: 412px; top: 198px; position: absolute" value="#{msgTraining.Duration}"/>
                                                            <ice:outputLabel id="lblTrainer" style="left: 49px; top: 143px; position: absolute" value="#{msgTraining.Trainer}"/>
                                                            <ice:outputLabel id="lblInstitutionOrPlace" style="left: 51px; top: 175px; position: absolute" value="#{msgTraining.Institution}"/>
                                                            <ice:selectInputDate id="calAssignedDate" rendered="false"
                                                                style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                                                value="#{Committee$CommitteeMemberRegistrationPage.selectInputDate1Bean.date1}" valueChangeListener="#{Committee$CommitteeMemberRegistrationPage.calAssignedDate_processValueChange}"/>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementApprovePage.drlDurationCategory}"
                                                                id="drlDurationCategory" partialSubmit="true"
                                                                style="left: 483px; top: 203px; position: absolute; width: 159px" value="#{Training$TrainingNeedAssessementApprovePage.selectedObjectOfDurationCategoryList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{Training$TrainingNeedAssessementApprovePage.durationCategoryList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementApprovePage.drlTrainerType}"
                                                                id="drlTrainerType" partialSubmit="true"
                                                                style="left: 125px; top: 141px; position: absolute; width: 190px"
                                                                value="#{Training$TrainingNeedAssessementApprovePage.selectedObjectOfTrainerTypeList.selectedObject}" valueChangeListener="#{Training$TrainingNeedAssessementApprovePage.drlTrainerType_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems13" value="#{Training$TrainingNeedAssessementApprovePage.trainerTypeList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementApprovePage.drlInstitutionOrPlace}"
                                                                id="drlInstitutionOrPlace" partialSubmit="true"
                                                                style="left: 124px; top: 176px; position: absolute; width: 190px" value="#{Training$TrainingNeedAssessementApprovePage.selectedObjectOfInstitutionOrPlaceList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu2selectItems" value="#{Training$TrainingNeedAssessementApprovePage.institutionOrPlaceList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputText
                                                                action="#{Training$TrainingNeedAssessementApprovePage.txtUnavailableTrainingTitle_action}"
                                                                binding="#{Training$TrainingNeedAssessementApprovePage.txtUnavailableTrainingTitle}"
                                                                disabled="true" id="txtUnavailableTrainingTitle" style="left: 124px; top: 67px; position: absolute; width: 518px"/>
                                                            <ice:outputLabel id="lblPurpose" style="left: 72px; top: 336px; position: absolute" value="#{msgTraining.Purpose}"/>
                                                            <ice:outputLabel id="lblPlanned" style="left: 168px; top: 336px; position: absolute" value="#{msgTraining.Planned}"/>
                                                            <ice:outputLabel id="lblUnplanned" style="left: 288px; top: 336px; position: absolute" value="#{msgTraining.Unplanned}"/>
                                                            <ice:selectBooleanCheckbox binding="#{Training$TrainingNeedAssessementApprovePage.ckbPlanned}"
                                                                id="ckbPlanned" partialSubmit="true" style="left: 142px; top: 340px; position: absolute" value="#{Training$TrainingNeedAssessementApprovePage.defaultSelectedDataPlanned.selectedBoolean}"/>
                                                            <ice:selectBooleanCheckbox binding="#{Training$TrainingNeedAssessementApprovePage.ckbUnplanned}"
                                                                id="ckbUnplanned" partialSubmit="true" style="left: 262px; top: 340px; position: absolute" value="#{Training$TrainingNeedAssessementApprovePage.defaultSelectedDataUnplanned.selectedBoolean}"/>
                                                            <ice:commandButton action="#{Training$TrainingNeedAssessementApprovePage.btnCalcNoOfDays_action}"
                                                                id="btnCalcNoOfDays" style="left: 400px; top: 286px; position: absolute" value="No. of Days"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementApprovePage.txtNoOfDays}" id="txtNoOfDays" style="left: 486px; top: 298px; position: absolute; width: 128px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputParticipantLists"
                                                            style="height: 197px; margin-left: 15px; left: 14px; top: 576px; overflow: auto; position: absolute; width: 706px" styleClass="insideContainerMain">
                                                            <ice:dataTable id="dataTableParticipantLists"
                                                                style="height: 8px; left: 20px; top: 0px; position: absolute"
                                                                value="#{Training$TrainingNeedAssessementApprovePage.participantLists}" var="currentRow" width="665">
                                                                <ice:column id="colNumber">
                                                                    <ice:outputText id="optTxtForColumnFullName" value="#{currentRow['fullName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextFullName" value="Full Name"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRepitition">
                                                                    <ice:outputText id="optTxtForColumnJobTitleName" value="#{currentRow['jobTitleName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextJobTitleName" value="Job Title "/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colStatus">
                                                                    <h:outputText id="outputText1" value="#{currentRow['selected']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextStatus" value="Status "/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutDecider"
                                                            style="height: 174px; margin-left: 15px; left: 13px; top: 790px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblDeciderDepartment" style="left: 24px; top: 24px; position: absolute" value="#{msgTraining.DeciderDepartment}"/>
                                                            <ice:outputLabel id="lblDeciderId" style="left: 24px; top: 48px; position: absolute" value="#{msgTraining.DeciderId}"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementApprovePage.txtDeciderDepartment}"
                                                                disabled="true" id="txtDeciderDepartment" style="left: 166px; top: 22px; position: absolute"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementApprovePage.txtDeciderId}" disabled="true"
                                                                id="txtDeciderId" style="left: 167px; top: 57px; position: absolute"/>
                                                            <ice:outputLabel id="lblDeciderFullName" style="left: 360px; top: 24px; position: absolute" value="#{msgTraining.DeciderFullName}"/>
                                                            <ice:outputLabel id="deciderPosition" style="left: 360px; top: 48px; position: absolute" value="#{msgTraining.DeciderPosition}"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementApprovePage.txtDeciderFullName}"
                                                                disabled="true" id="txtDeciderFullName" style="left: 526px; top: 22px; position: absolute"/>
                                                            <ice:inputText binding="#{Training$TrainingNeedAssessementApprovePage.txtDeciderPosition}"
                                                                disabled="true" id="txtDeciderPosition" style="left: 528px; top: 56px; position: absolute"/>
                                                            <ice:selectOneMenu binding="#{Training$TrainingNeedAssessementApprovePage.drlDecision}"
                                                                id="drlDecision" partialSubmit="true"
                                                                style="height: 23px; left: 167px; top: 89px; position: absolute; width: 143px" value="#{Training$TrainingNeedAssessementApprovePage.selectedObjectOneMenuDecisionType.selectedObject}">
                                                                <f:selectItems id="selectDecisionAvailable" value="#{Training$TrainingNeedAssessementApprovePage.availableDecisionsToMakeList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblDecision" style="left: 24px; top: 72px; position: absolute" value="#{msgTraining.Decision}"/>
                                                            <ice:inputTextarea binding="#{Training$TrainingNeedAssessementApprovePage.txtaDeciderComment}"
                                                                id="txtaDeciderComment" style="left: 166px; top: 118px; position: absolute; width: 496px"/>
                                                            <ice:outputLabel id="lblDeciderComment" style="left: 24px; top: 120px; position: absolute" value="#{msgTraining.Comment}"/>
                                                            <ice:commandLink
                                                                action="#{Training$TrainingNeedAssessementApprovePage.lnkViewPrevieousDecisions_action}"
                                                                binding="#{Training$TrainingNeedAssessementApprovePage.lnkViewPrevieousDecisions}"
                                                                id="lnkViewPrevieousDecisions" style=" left: 432px; top: 96px; position: absolute" value="View decisions made on this request"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="height: 41px; margin-left: 15px; left: 13px; top: 987px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Training$TrainingNeedAssessementApprovePage.btnPostDecision_action}"
                                                                binding="#{Training$TrainingNeedAssessementApprovePage.btnPostDecision}" id="btnPostDecision"
                                                                style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{Training$TrainingNeedAssessementApprovePage.saveOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Training$TrainingNeedAssessementApprovePage.btnReset_action}"
                                                                id="btnReset" style="left: 336px; top: 0px; position: absolute; width: 71px" value="Reset"/>
                                                            <ice:commandLink action="#{Training$TrainingNeedAssessementApprovePage.lnkPreviousTraining_action}"
                                                                id="lnkPreviousTraining" style="left: 430px; top: 5px; position: absolute; width: 263px" value="View Previous Training taken by Employee"/>
                                                        </ice:panelLayout>
                                                        <ice:selectInputDate binding="#{Training$TrainingNeedAssessementApprovePage.calTentativeEndDate}"
                                                            id="calTentativeEndDate" rendered="false" style="left: 312px; top: 336px; position: absolute"
                                                            value="#{Training$TrainingNeedAssessementApprovePage.selectInputDate2Bean.date1}" valueChangeListener="#{Training$TrainingNeedAssessementApprovePage.calTentativeEndDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{Training$TrainingNeedAssessementApprovePage.calTentativeStartDate}"
                                                            id="calTentativeStartDate" rendered="false" style="left: 312px; top: 336px; position: absolute"
                                                            value="#{Training$TrainingNeedAssessementApprovePage.selectInputDate1Bean.date1}" valueChangeListener="#{Training$TrainingNeedAssessementApprovePage.calTentativeStartDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{Training$TrainingNeedAssessementApprovePage.calAppliedDate}"
                                                            id="calAppliedDate" rendered="false" style="left: 317px; top: 106px; position: absolute"
                                                            value="#{Training$TrainingNeedAssessementApprovePage.selectInputDateBean3.date1}" valueChangeListener="#{Training$TrainingNeedAssessementApprovePage.calAppliedDate_processValueChange}"/>
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
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">Bunna International Bank |Information System Department |Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingNeedAssessementApprovePage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Bank Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Training$TrainingNeedAssessementApprovePage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Training$TrainingNeedAssessementApprovePage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Training$TrainingNeedAssessementApprovePage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Training$TrainingNeedAssessementApprovePage.lblSuccessOrErrorMessage}"
                                            id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingNeedAssessementApprovePage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="            Bunna Bank HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Training$TrainingNeedAssessementApprovePage.outputTextConfirmDelete}"
                                            id="outputTextConfirmDelete" style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Training$TrainingNeedAssessementApprovePage.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Training$TrainingNeedAssessementApprovePage.btnPopupCancelDelete_action}"
                                            id="btnPopupCancelDelete" style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingNeedAssessementApprovePage.pnlPopupViewPrevieousDecisions}"
                            draggable="true" id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="Bunna Bank HRMS - View request status "/>
                                    <ice:commandLink action="#{Training$TrainingNeedAssessementApprovePage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Training$TrainingNeedAssessementApprovePage.decisionsMadeOnRequest}" var="currentRow">
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
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingNeedAssessementApprovePage.pnlPopupViewPrevieousTrainings}"
                            draggable="true" id="pnlPopupViewPrevieousTrainings" modal="true" rendered="false" style="height: 357px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousTrainings" style="display: block; height: 48px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousTrainingsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="Bunna Bank HRMS - View Previous Training Status "/>
                                    <ice:commandLink action="#{Training$TrainingNeedAssessementApprovePage.btnCloseViewPreviesTrainings_action}"
                                        id="btnClosePopupViewPrevieousTrainings" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousTrainings" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 128px; margin-left: 15px; left: -10px; top: 110px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable1" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableTrainingType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Training$TrainingNeedAssessementApprovePage.previousTrainingRequest}" var="currentRow">
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
