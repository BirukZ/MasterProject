<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Mar 5, 2012, 7:48:31 AM
    Author     : BravoZulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Qualifications for job type</title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
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
                    function OrganizationJobType(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1000px" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Organization$OrganizationJobType.panelBorder1Bean.renderCenter}"
                            renderEast="#{Organization$OrganizationJobType.panelBorder1Bean.renderEast}"
                            renderNorth="#{Organization$OrganizationJobType.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Organization$OrganizationJobType.panelBorder1Bean.renderSouth}"
                            renderWest="#{Organization$OrganizationJobType.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup dragListener="#{Organization$OrganizationJobType.menu_left_processMyEvent}" id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow" style="height: 786px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 786px; left: -4px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="Search By Job Name"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:selectInputText action="#{Organization$OrganizationJobType.txtSearchByName_action}"
                                                        id="txtSearchByName" listValue="#{Organization$OrganizationJobType.list}" listVar="jobList"
                                                        partialSubmit="true" rows="5" style="left: 0px; top: 0px; position: relative; width: 300px" valueChangeListener="#{Organization$OrganizationJobType.txtSearchByName_processValueChange}">
                                                        <f:facet name="selectInputText">
                                                            <ice:panelGrid columnClasses="empIdCol,fullNameCol" columns="2">
                                                                <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{jobList.jobId}"/>
                                                                <ice:outputText id="lblFullNameAutoComplete2" value="#{jobList.jobName}"/>
                                                            </ice:panelGrid>
                                                        </f:facet>
                                                    </ice:selectInputText>
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
                                                        <li>
                                                            <ice:commandLink action="#{Organization$OrganizationJobType.cmdLnkOrgStructure_action}"
                                                                id="cmdLnkOrgStructure" style="color:#306682;font-weight:bold" value="Organization structure"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Organization$OrganizationJobType.cmdLnkJobTypes_action}"
                                                                id="cmdLnkJobTypes" style="color:#306682;font-weight:bold" value="Job types registration"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Pending" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header_Pending">
                                                        <ice:outputText id="lblStatusPending" value="Pending"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoardPending" width="100%">
                                                    <ice:panelGroup id="status_Group_Pending" style="padding: 0px; background:transparent;border:none;display: block;float:left;height:420px; width: 100%">
                                                        <ice:panelLayout id="StatusContainerPending" style="height: 425px; position: absolute; width: 190px">
                                                            <ice:selectOneListbox binding="#{Organization$OrganizationJobType.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 406px; width: 190px"
                                                                value="#{Organization$OrganizationJobType.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Organization$OrganizationJobType.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Organization$OrganizationJobType.jobTypesList}"/>
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
                                <ice:panelGroup id="page_display" style="height: 775px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 760px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 740px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Register Qualification"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 700px; left: 0px; top: 25px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 685px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout1" style="height: 691px; left: 10px; top: 10px; position: absolute; width: 731px">
                                                        <ice:panelLayout id="PanelLayOutJobAtrributes"
                                                            style="height: 152px; margin-left: 15px; margin-top: 40px; top: -27px; position: absolute; width: 702px" styleClass="insideContainerMain">
                                                            <ice:outputText id="lblJobCodeDescription"
                                                                style="font-size: 10px; left: 39px; top: 88px; position: absolute" value="Description"/>
                                                            <ice:inputText binding="#{Organization$OrganizationJobType.txtJobCode}" disabled="true"
                                                                id="txtJobCode" style="left: 501px; top: 13px; position: absolute; width: 190px"/>
                                                            <ice:inputTextarea binding="#{Organization$OrganizationJobType.txtaJobDescription}" disabled="true"
                                                                id="txtaJobDescription" style="left: 140px; top: 88px; position: absolute; width: 190px"/>
                                                            <ice:outputText id="lblJobName" style="font-size: 10px; left: 35px; top: 17px; position: absolute" value=" Job  Name:"/>
                                                            <ice:inputTextarea binding="#{Organization$OrganizationJobType.txtaJobName}" disabled="true"
                                                                id="txtaJobName" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 13px; position: absolute; width: 190px"/>
                                                            <ice:outputText id="lblresponsibility"
                                                                style="font-size: 10px; left: 400px; top: 81px; position: absolute" value="Responsibility:"/>
                                                            <ice:inputTextarea binding="#{Organization$OrganizationJobType.txtaJobResponsiblity}"
                                                                id="txtaJobResponsiblity" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 504px; top: 86px; position: absolute; width: 190px"/>
                                                            <ice:outputText id="lblRank" style="font-size: 10px; left: 406px; top: 45px; position: absolute" value="Rank:"/>
                                                            <ice:outputText id="lblCode" style="font-size: 10px; left: 406px; top: 11px; position: absolute" value="Code :"/>
                                                            <ice:selectOneMenu binding="#{Organization$OrganizationJobType.drlRank}" disabled="true"
                                                                id="drlRank" partialSubmit="true"
                                                                style="left: 503px; top: 52px; position: absolute; width: 190px" value="#{Organization$JobTypesRegistrationPage.selectedObjectJobRank.selectedObject}">
                                                                <f:selectItems id="selectOneRankXX" value="#{Organization$JobTypesRegistrationPage.jobRankList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputText id="lblConfirmation" rendered="false"
                                                                style="font-size: 14px; left: 40px; top: 0px; position: absolute" value="outputText"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputRequest"
                                                            style="height: 430px; margin-left: 15px; left: 0px; top: 180px; overflow: auto; position: absolute; width: 703px" styleClass="insideContainerMain">
                                                            <ice:panelLayout id="pnlLayputEducLevelExperienceFiller"
                                                                style="height: 153px; margin-left: 15px; left: -2px; top: 10px; overflow: auto; position: absolute; width: 392px" styleClass="insideContainerMain">
                                                                <ice:outputText id="lblEducationLevel"
                                                                    style="font-size: 10px; left: 31px; top: 10px; position: absolute" value="Educ Level"/>
                                                                <ice:outputText id="lblExperience"
                                                                    style="font-size: 10px; left: 33px; top: 65px; position: absolute" value="Experience"/>
                                                                <ice:selectOneMenu binding="#{Organization$OrganizationJobType.drlEducationLevel}"
                                                                    id="drlEducationLevel" partialSubmit="true"
                                                                    style="left: 124px; top: 13px; position: absolute; width: 189px"
                                                                    value="#{Organization$OrganizationJobType.selectedObjectOfEducationLevel.selectedObject}" valueChangeListener="#{Organization$OrganizationJobType.drlEducationLevel_processValueChange}">
                                                                    <f:selectItems id="selectOneMenu1selectItems1" value="#{Organization$OrganizationJobType.educationlevelList}"/>
                                                                </ice:selectOneMenu>
                                                                <ice:inputText binding="#{Organization$OrganizationJobType.txtExperience}" id="txtExperience" style="left: 123px; top: 68px; position: absolute; width: 107px"/>
                                                                <ice:commandButton
                                                                    action="#{Organization$OrganizationJobType.btnAddToTableExperEducLevel_action}"
                                                                    id="btnAddToTableExperEducLevel"
                                                                    style=" left: 231px; top: 98px; position: absolute; width: 93px" value="Add to table"/>
                                                            </ice:panelLayout>
                                                            <ice:panelLayout id="pnlLayputEducLevelExperience"
                                                                style="height: 236px; margin-left: 15px; left: -1px; top: 175px; overflow: auto; position: absolute; width: 392px" styleClass="insideContainerMain">
                                                                <ice:dataTable id="dataTableEducLevelExperience"
                                                                    style="height: 8px; left: 20px; top: 0px; position: absolute"
                                                                    value="#{Organization$OrganizationJobType.experienceEducLevelQualificationList}"
                                                                    var="currentRow" width="336">
                                                                    <ice:column id="colEducationTypeLevelDatabaseStatus">
                                                                        <ice:outputText id="optTxtForColumnEducationLevelDatabaseStatus" value="#{currentRow['databaseStatus']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextEducLevelDatabaseStatus" value="Status"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colEducationLevel">
                                                                        <ice:outputText id="optTxtForColumnEducationLevel" value="#{currentRow['levelOfEducationName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextEducationLevel" value="Level"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colExperience">
                                                                        <ice:outputText id="optTxtForColumnExperience" value="#{currentRow['experienceNeeded']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextExperience" value="Experience"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colRemoveEducLevelExp">
                                                                        <ice:commandLink
                                                                            action="#{Organization$OrganizationJobType.cmdLnkRemoveEducLevelExperience_action}"
                                                                            id="cmdLnkRemoveEducLevelExp" value="Remove"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextRemoveEducLevelExp" value="Remove"/>
                                                                        </f:facet>
                                                                        <ice:rowSelector id="rowSelectorJobType" multiple="false" preStyleOnSelection="true"
                                                                            selectionListener="#{Organization$OrganizationJobType.rowSelectorEducLevelExperience_processMyEvent}"
                                                                            toggleOnClick="true" value="#{currentRow['seledtJobList']}"/>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                            <ice:panelLayout id="pnlLayputFieldOfStudyFiller"
                                                                style="height: 151px; margin-left: 480px; left: -61px; top: 10px; overflow: auto; position: absolute; width: 266px" styleClass="insideContainerMain">
                                                                <ice:outputText id="lblEducationCategory"
                                                                    style="font-size: 10px; left: 8px; top: 15px; position: absolute" value="Educ Category"/>
                                                                <ice:outputText id="lblFieldOfStudy"
                                                                    style="font-size: 10px; left: 10px; top: 70px; position: absolute" value="Field"/>
                                                                <ice:selectOneMenu binding="#{Organization$OrganizationJobType.drlEducationCategory}"
                                                                    id="drlEducationCategory" partialSubmit="true"
                                                                    style="left: 86px; top: 22px; position: absolute; width: 146px"
                                                                    value="#{Organization$OrganizationJobType.selectedObjectOfEducationCategory.selectedObject}" valueChangeListener="#{Organization$OrganizationJobType.drlEducationCategory_processValueChange}">
                                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{Organization$OrganizationJobType.educationCategotyList}"/>
                                                                </ice:selectOneMenu>
                                                                <ice:selectOneMenu binding="#{Organization$OrganizationJobType.drlEducationType}"
                                                                    id="drlEducationType" immediate="true" partialSubmit="true"
                                                                    style="left: 89px; top: 76px; position: absolute; width: 143px" value="#{Organization$OrganizationJobType.selectedObjectOdEducType.selectedObject}">
                                                                    <f:selectItems id="selectManyMenu1selectItems" value="#{Organization$OrganizationJobType.educationTypeList}"/>
                                                                </ice:selectOneMenu>
                                                                <ice:commandButton action="#{Organization$OrganizationJobType.btnAddToTableEducType_action}"
                                                                    id="btnAddToTableEducType" style="left: 153px; top: 100px; position: absolute" value="Add to table"/>
                                                            </ice:panelLayout>
                                                            <ice:panelLayout id="pnlLayputFieldOfStudy"
                                                                style="height: 235px; margin-left: 480px; left: -61px; top: 176px; overflow: auto; position: absolute; width: 263px" styleClass="insideContainerMain">
                                                                <ice:dataTable id="dataTableEducatinType"
                                                                    style="height: 8px; left: 20px; top: 0px; position: absolute"
                                                                    value="#{Organization$OrganizationJobType.educationQualificationTypeList}" var="currentRow" width="226">
                                                                    <ice:column id="colEducationLevelDatabaseStatus">
                                                                        <ice:outputText id="optTxtForColumnEducationTypeDatabaseStatus" value="#{currentRow['databaseStatus']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextEducLevelDatabaseStatus" value="Status"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colEducationTypeName">
                                                                        <ice:outputText id="optTxtForColumnEducationTypeName" value="#{currentRow['educationTypeName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextEducLevelName" value="Educ Type"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colRemoveEducationTypeName">
                                                                        <ice:commandLink
                                                                            action="#{Organization$OrganizationJobType.cmdLnkRemoveEducationType_action}"
                                                                            id="cmdLnkRemoveEducationTypeName" value="Remove"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextRemoveEducationTypeName" value="Remove"/>
                                                                        </f:facet>
                                                                        <ice:rowSelector id="rowSelectorJobTypeEducType" multiple="false"
                                                                            preStyleOnSelection="true" selectionListener="#{Organization$OrganizationJobType.rowSelectorEducationType_processMyEvent}"/>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="height: 54px; margin-left: 15px; left: -1px; top: 625px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Organization$OrganizationJobType.btnSaveOrUpdate_action}"
                                                                id="btnSaveOrUpdate" style="left: 216px; top: 0px; position: absolute; width: 71px" value="Save"/>
                                                            <ice:commandButton action="#{Organization$OrganizationJobType.btnReset_action}" id="btnReset"
                                                                style="left: 336px; top: 0px; position: absolute; width: 71px" value="Reset"/>
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
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">Bunna Intenational Bank |Information System Department  |Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Organization$OrganizationJobType.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Organization$OrganizationJobType.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Organization$OrganizationJobType.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Organization$OrganizationJobType.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Organization$OrganizationJobType.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Organization$OrganizationJobType.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Organization$OrganizationJobType.outputTextConfirmDelete}" id="outputTextConfirmDelete"
                                            style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Organization$OrganizationJobType.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Organization$OrganizationJobType.btnPopupCancelDelete_action}" id="btnPopupCancelDelete"
                                            style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
