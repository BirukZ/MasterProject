<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : mekete and BravoZulue
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocaalization_Decipline" var="msgsDecipline"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Discipline Issue Page</title>
                <link HREF="../resources/images/header_icon.ico" REL="icon"/>
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
                    function DisciplineReportPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelBorder id="whole_page" renderCenter="#{Discipline$DisciplineRequestPage.panelBorder1Bean.renderCenter}"
                        renderEast="#{Discipline$DisciplineRequestPage.panelBorder1Bean.renderEast}"
                        renderNorth="#{Discipline$DisciplineRequestPage.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Discipline$DisciplineRequestPage.panelBorder1Bean.renderSouth}"
                        renderWest="#{Discipline$DisciplineRequestPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                            <ice:panelGroup id="menu_left" style="height: 790px">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="border-width: 1px; border-style: solid; border-color: rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200); height: 720px; top: 25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 690px; left: 0px; top: 0px; position: absolute; width: 213px" styleClass="left_menu">
                                        <ice:panelCollapsible binding="#{Discipline$DisciplineRequestPage.pnl_col_Common_Tasks}" id="pnl_col_Common_Tasks" style="border:none">
                                            <f:facet name="header">
                                                <ice:panelGroup id="commonTasksGroup_header">
                                                    <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="commonTasksGroup_Grid11" width="100%">
                                                <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                    <li>
                                                        <ice:commandLink action="#{Discipline$DisciplineRequestPage.lnkDisciplineApprove_action}"
                                                            id="lnkDisciplineApprove" style="color:#306682;font-weight:bold" value="DisciplineApprove"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Discipline$DisciplineRequestPage.lnkAccusedDefence_action}"
                                                            id="lnkAccusedDefence" style="color:#306682;font-weight:bold" value="Accused Defence"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Discipline$DisciplineRequestPage.lnkEyeWitness_action}" id="lnkEyeWitness"
                                                            style="color:#306682;font-weight:bold" value="Eye Witness"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Discipline$DisciplineRequestPage.lnkDisciplineType_action}"
                                                            id="lnkDisciplineType" style="color:#306682;font-weight:bold" value="DisciplineType"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Discipline$DisciplineRequestPage.lnkPenaltyType_action}" id="lnkPenaltyType"
                                                            style="color:#306682;font-weight:bold" value="PenaltyType"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Discipline$DisciplineRequestPage.lnkDisciplinePenalty_action}"
                                                            id="lnkDisciplinePenalty" style="color:#306682;font-weight:bold" value="DisciplinePenalty"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Discipline$DisciplineRequestPage.lnkCommittee_action}" id="lnkCommittee"
                                                            style="color:#306682;font-weight:bold" value="Committees"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Discipline$DisciplineRequestPage.lnkCommitteeMembers_action}"
                                                            id="lnkCommitteeMembers" style="color:#306682;font-weight:bold" value="CommitteeMembers"/>
                                                    </li>
                                                </ul>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible binding="#{Discipline$DisciplineRequestPage.pnl_col_Pending}" expanded="true" id="pnl_col_Pending" style="border:none">
                                            <f:facet name="header">
                                                <ice:panelGroup id="status_Group_Header_Pending">
                                                    <ice:outputText id="lblStatusPending" value="Pending"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="StatusBoardPending" width="100%">
                                                <ice:panelGroup id="status_Group_Pending" style="padding: 0px; background:transparent;border:none;display: block;float:left;height:120px; width: 100%">
                                                    <ice:panelLayout id="StatusContainerPending" style="height: 125px; position: absolute; width: 190px">
                                                        <ice:selectOneListbox id="selectPending" immediate="true" partialSubmit="true" size="7"
                                                            style="position: relative;  top: 0px; left: 0px; width: 190px"
                                                            value="#{Discipline$DisciplineRequestPage.selectedObjectPending.selectedObject}" valueChangeListener="#{Discipline$DisciplineRequestPage.selectPending_processValueChange}">
                                                            <f:selectItems id="selectOneListbox3selectItems" value="#{Discipline$DisciplineRequestPage.pendingRequestLists}"/>
                                                        </ice:selectOneListbox>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible binding="#{Discipline$DisciplineRequestPage.pnl_col_History}" expanded="true" id="pnl_col_History" style="border-style: none; ">
                                            <f:facet name="header">
                                                <ice:panelGroup id="status_Group_Header_History">
                                                    <ice:outputText id="lblStatusHistory" value="History"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="StatusBoardHistory" width="100%">
                                                <ice:panelGroup id="status_Group_History" style="padding: 0px; background:transparent;border:none;display: block;float:left;height:120px; width: 100%">
                                                    <ice:panelLayout id="StatusContainerHistory" style="height: 125px; position: absolute; width: 190px">
                                                        <ice:selectOneListbox id="selectHistory" immediate="true" partialSubmit="true" size="7"
                                                            style="position: relative;  top: 0px; left: 0px; width: 190px"
                                                            value="#{Discipline$DisciplineRequestPage.selectedObjectHistory.selectedObject}" valueChangeListener="#{Discipline$DisciplineRequestPage.selectHistory_processValueChange}">
                                                            <f:selectItems id="selectOneListboxHistory" value="#{Discipline$DisciplineRequestPage.historyRequestLists}"/>
                                                        </ice:selectOneListbox>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible binding="#{Discipline$DisciplineRequestPage.pnl_col_PendingApproved}" expanded="true"
                                            id="pnl_col_PendingApproved" style="border-style: none;">
                                            <f:facet name="header">
                                                <ice:panelGroup id="status_Group_Header_CanbeApproved">
                                                    <ice:outputText id="lblStatusPendingCanbeapproved" value="Pending Canbe Approved Here"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="StatusBoardPendingCanbeApproved" width="100%">
                                                <ice:panelGroup id="status_Group_PendingCanbeApproved" style="padding: 0px; background:transparent;border:none;display: block;float:left;height:120px; width: 100%">
                                                    <ice:panelLayout id="StatusContainerPendingCanBeApproved" style="height: 165px; position: absolute; width: 190px">
                                                        <ice:selectOneListbox id="selectPendingCanBeApproved" immediate="true" partialSubmit="true" size="7"
                                                            style="position: relative;  top: 0px; left: 0px; width: 190px"
                                                            value="#{Discipline$DisciplineRequestPage.selectedObjectPendingCanBeApproved.selectedObject}" valueChangeListener="#{Discipline$DisciplineRequestPage.selectPendingCanBeApproved_processValueChange}">
                                                            <f:selectItems id="selectOneListboxPendingCanbeApproved" value="#{Discipline$DisciplineRequestPage.pendingListsThatCanBeApproved}"/>
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
                            <ice:panelGroup id="page_display" style="height:780px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 650px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css" style="height: 730px;">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="DISPLINE REQUEST"/>
                                        </legend>
                                        <ice:panelLayout id="pnlLayoutMainBody" style="height: 713px; left: 0px; top: 20px; position: absolute; width: 791px">
                                            <ice:panelLayout id="pnProfile" style="height: 717px; left: 0px; top: 0px; position: absolute; width: 782px">
                                                <ice:panelGroup id="pnlGrpEvaluationContent" style="height: 694px" styleClass="icePnlGrp filedset_border">
                                                    <ice:panelLayout id="pnlLayoutForWhom"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 40px; margin-left: 15px; left: 20px; top: 20px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblForWhom" style=" top:10px; left:20px; position: absolute" value="For Whom You Are Applying ?"/>
                                                        <ice:selectOneRadio binding="#{Discipline$DisciplineRequestPage.radioGroupApplierType}" dir="LTR"
                                                            id="radioGroupApplierType" partialSubmit="true" style=" top:10px; left:220px; position: absolute" valueChangeListener="#{Discipline$DisciplineRequestPage.radioGroupApplierType_processValueChange}">
                                                            <f:selectItem itemLabel="Me On Subordinates" itemValue="#{Discipline$DisciplineRequestPage.IMMEDIATEBOSS}"/>
                                                            <f:selectItem itemLabel="Another Employee" itemValue="#{Discipline$DisciplineRequestPage.ANOTHEREMPLOYEE}"/>
                                                        </ice:selectOneRadio>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutRequester"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 135px; margin-left: 15px; left: 20px; top: 75px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:selectInputText action="#{Discipline$DisciplineRequestPage.txtRequesterFullName_action}"
                                                            binding="#{Discipline$DisciplineRequestPage.txtRequesterFullName}" id="txtRequesterFullName"
                                                            immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true"
                                                            rows="10" style="left: 166px; top: 22px; position: absolute"
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="#{msgsDecipline.Requester}"/>
                                                        <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgsDecipline.Department}"/>
                                                        <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="#{msgsDecipline.Id}"/>
                                                        <ice:inputText binding="#{Discipline$DisciplineRequestPage.txtRequesterDepartment}" disabled="true"
                                                            id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{Discipline$DisciplineRequestPage.txtRequesterId}" id="txtRequesterId"
                                                            immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                        <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgsDecipline.FullName}"/>
                                                        <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="#{msgsDecipline.Position}"/>
                                                        <ice:inputText binding="#{Discipline$DisciplineRequestPage.txtRequesterPosition}" disabled="true"
                                                            id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        <ice:commandButton action="#{Discipline$DisciplineRequestPage.btnSearchRequester_action}"
                                                            binding="#{Discipline$DisciplineRequestPage.btnSearchRequester}" id="btnSearchRequester"
                                                            image="/resources/images/fig_search.gif" style="left: 648px; top: 24px; position: absolute"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutEmployee"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 135px; margin-left: 15px; left: 20px; top: 222px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblAccused" style="left: 10px; top: 4px; position: absolute" value="#{msgsDecipline.Accused}"/>
                                                        <ice:outputLabel id="lblEmployeeDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgsDecipline.Department}"/>
                                                        <ice:outputLabel id="lblEmployeeId" style="left: 432px; top: 24px; position: absolute" value="#{msgsDecipline.Id}"/>
                                                        <ice:inputText binding="#{Discipline$DisciplineRequestPage.txtEmployeeDepartment}" disabled="true"
                                                            id="txtEmployeeDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{Discipline$DisciplineRequestPage.txtEmployeeId}" id="txtEmployeeId"
                                                            immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                        <ice:outputLabel id="lblEmployeeFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgsDecipline.FullName}"/>
                                                        <ice:outputLabel id="lblEmployeePosition" style="left: 48px; top: 96px; position: absolute" value="#{msgsDecipline.Position}"/>
                                                        <ice:selectInputText action="#{Discipline$DisciplineRequestPage.txtEmployeeFullName_action}"
                                                            binding="#{Discipline$DisciplineRequestPage.txtEmployeeFullName}" id="txtEmployeeFullName"
                                                            immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true"
                                                            rows="10" style="left: 166px; height: 30px; top: 22px; position: absolute"
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoCompleteAccused" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoCompleteAccused" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:inputText binding="#{Discipline$DisciplineRequestPage.txtEmployeePosition}" disabled="true"
                                                            id="txtEmployeePosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        <ice:commandButton action="#{Discipline$DisciplineRequestPage.btnSearchOffender_action}"
                                                            binding="#{Discipline$DisciplineRequestPage.btnSearchOffender}" id="btnSearchOffender"
                                                            image="/resources/images/fig_search.gif" style="left: 648px; top: 24px; position: absolute"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 44px; margin-left: 15px; left: 20px; top: 660px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Discipline$DisciplineRequestPage.btnSaveOrUpdate_action}"
                                                            binding="#{Discipline$DisciplineRequestPage.btnSaveOrUpdate}" id="btnSaveOrUpdate"
                                                            style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{Discipline$DisciplineRequestPage.saveOrEditOrUpdateLabel}"/>
                                                        <ice:commandButton action="#{Discipline$DisciplineRequestPage.btnReset_action}" id="btnReset"
                                                            style="left: 336px; top: 0px; position: absolute; width: 71px" value="Reset"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutDecider" layout="flow"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 290px; margin-left: 15px; left: 20px; top: 365px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblDisciplineDate" style="left: 48px; top: 24px; position: absolute" value="#{msgsDecipline.DisciplineDate}"/>
                                                        <ice:outputLabel id="lblReportedDate" style="left: 50px; top: 56px; position: absolute" value="#{msgsDecipline.ReportedDate}"/>
                                                        <ice:outputLabel id="lblDisciplineType" style="left: 416px; top: 26px; position: absolute" value="#{msgsDecipline.DisciplineType}"/>
                                                        <ice:inputText binding="#{Discipline$DisciplineRequestPage.txtDisciplineDate}" disabled="true"
                                                            id="txtDisciplineDate" style="left: 166px; top: 22px; position: absolute"/>
                                                        <ice:inputText binding="#{Discipline$DisciplineRequestPage.txtReportedDate}" disabled="true"
                                                            id="txtReportedDate" style="left: 167px; top: 56px; position: absolute"/>
                                                        <ice:outputLabel id="lblRepitition" rendered="false" style="left: 408px; top: 48px; position: absolute" value="Repitition"/>
                                                        <ice:inputTextarea binding="#{Discipline$DisciplineRequestPage.txtaDisciplineDescription}"
                                                            id="txtaDisciplineDescription" immediate="true" style="height: 40px; left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        <ice:outputLabel id="lblDesciplineDescription" style="left: 48px; top: 96px; position: absolute" value="#{msgsDecipline.Description}"/>
                                                        <ice:selectOneMenu binding="#{Discipline$DisciplineRequestPage.drlDisciplineType}"
                                                            id="drlDisciplineType" immediate="true" partialSubmit="true"
                                                            style="left: 526px; top: 24px; position: absolute; width: 143px"
                                                            value="#{Discipline$DisciplineRequestPage.selectedObjectOfDisciplineType.selectedObject}" valueChangeListener="#{Discipline$DisciplineRequestPage.drlDisciplineType_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{Discipline$DisciplineRequestPage.disciplineTypesList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:inputText binding="#{Discipline$DisciplineRequestPage.txtDisciplinePreviousOccurance}"
                                                            disabled="true" id="txtDisciplinePreviousOccurance" rendered="false" style="left: 526px; top: 46px; position: absolute; width: 143px"/>
                                                        <ice:commandButton action="#{Discipline$DisciplineRequestPage.btnCalendarDisciplineDate_action}"
                                                            id="btnCalendarDisciplineDate" image="/resources/images/cal_icon.JPG"
                                                            style="left: 312px; top: 24px; position: absolute" value="submit"/>
                                                        <ice:commandButton action="#{Discipline$DisciplineRequestPage.btnCalendarReportedDate_action}"
                                                            id="btnCalendarReportedDate" image="/resources/images/cal_icon.JPG"
                                                            style="left: 313px; top: 55px; position: absolute" value="submit"/>
                                                        <ice:inputTextarea binding="#{Discipline$DisciplineRequestPage.txtaRequestedMeasureToBeTaken}"
                                                            id="txtaRequestedMeasureToBeTaken" immediate="true" style="height: 40px; left: 168px; top: 145px; position: absolute; width: 503px"/>
                                                        <ice:outputLabel id="lblDesciplineDecisiontoBeTaken" style="left: 48px; top: 144px; position: absolute" value="#{msgsDecipline. RequesterInterest }"/>
                                                        <ice:inputText binding="#{Discipline$DisciplineRequestPage.txtDocReferenceNumber}"
                                                            id="txtDocReferenceNumber" immediate="true" style="left: 166px; top: 200px; position: absolute"/>
                                                        <ice:outputLabel id="lblDocReferenceNumber" style="left: 48px; top: 192px; position: absolute" value="#{msgsDecipline.DocRefNo}"/>
                                                        <ice:commandLink action="#{Discipline$DisciplineRequestPage.lnkViewPrevieousDecisions_action}"
                                                            binding="#{Discipline$DisciplineRequestPage.lnkViewPrevieousDecisions}"
                                                            id="lnkViewPrevieousDecisions" style="left: 462px; top: 261px; position: absolute" value="View decisions made this request"/>
                                                        <ice:commandLink action="#{Discipline$DisciplineRequestPage.lnkRecordEyeWitnesses_action}"
                                                            binding="#{Discipline$DisciplineRequestPage.lnkRecordEyeWitnesses}" id="lnkRecordEyeWitnesses"
                                                            rendered="true" style="left: 462px; top: 240px; position: absolute" value="Register Eye Witnesses"/>
                                                        <ice:panelLayout binding="#{Discipline$DisciplineRequestPage.pnl_EyeWitnessType}"
                                                            id="pnl_EyeWitnessType"
                                                            style="border: 1px solid rgb(204, 204, 204); height: 35px; margin-left: 15px; left: 364px; top: 195px; position: absolute; width: 310px" styleClass="insideContainerMain">
                                                            <ice:selectOneRadio binding="#{Discipline$DisciplineRequestPage.groupEyeWitnessType}" dir="LTR"
                                                                id="groupEyeWitnessType" partialSubmit="true" style=" top:0px; left:200px; position: absolute" valueChangeListener="#{Discipline$DisciplineRequestPage.groupEyeWitnessType_processValueChange}">
                                                                <f:selectItem itemLabel=" Worker" itemValue="#{Discipline$DisciplineRequestPage.WORKER}"/>
                                                                <f:selectItem itemLabel="Another" itemValue="#{Discipline$DisciplineRequestPage.NOTWORKER}"/>
                                                            </ice:selectOneRadio>
                                                            <ice:outputLabel id="lblEyeWitnessType" style="left: 5px; top: 10px; position: absolute" value="#{msgsDecipline.SelectEyeWitnessType}"/>
                                                        </ice:panelLayout>
                                                        <ice:commandLink action="#{Discipline$DisciplineRequestPage.lnkOtherWitness_action}"
                                                            binding="#{Discipline$DisciplineRequestPage.lnkOtherWitness}" id="lnkOtherWitness"
                                                            style=" left: 462px; top: 240px; position: absolute" value="Register Eye Witness"/>
                                                        <ice:outputLabel id="outputLabel16" style="left: 390px; top: 52px; position: absolute" value="#{msgsDecipline.DisciplineReputaion}"/>
                                                        <ice:selectOneMenu binding="#{Discipline$DisciplineRequestPage.drl_Reputaion}" id="drl_Reputaion"
                                                            partialSubmit="true" style="left: 526px; top: 56px; position: absolute; width: 143px"
                                                            value="#{Discipline$DisciplineRequestPage.defaultSelectedData7.selectedObject}" valueChangeListener="#{Discipline$DisciplineRequestPage.drl_Reputaion_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems2" value="#{Discipline$DisciplineRequestPage.repititionTypes}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Discipline$DisciplineRequestPage.drlDis_Type_ForManager}"
                                                            id="drlDis_Type_ForManager" partialSubmit="true" rendered="false"
                                                            style="left: 526px; top: 24px; position: absolute; width: 143px" value="#{Discipline$DisciplineRequestPage.defaultSelectedData8.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems3" value="#{Discipline$DisciplineRequestPage.disciplineTypesListForManager}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:commandLink action="#{Discipline$DisciplineRequestPage.cmd_ApproveNow_action}"
                                                            binding="#{Discipline$DisciplineRequestPage.cmd_ApproveNow}" disabled="true" id="cmd_ApproveNow"
                                                            style="left: 48px; top: 240px; position: absolute" value="#{msgsDecipline. approveNow }"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDisciplineDate" id="message6"
                                                            infoClass="infoMessage" style="height: 20px; left: 216px; top: 0px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlDisciplineType" id="message8"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 648px; top: 24px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drl_Reputaion" id="message9"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 648px; top: 48px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtaDisciplineDescription"
                                                            id="message10" infoClass="infoMessage"
                                                            style="height: 20px; left: 648px; top: 96px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtaRequestedMeasureToBeTaken"
                                                            id="message11" infoClass="infoMessage"
                                                            style="height: 20px; left: 648px; top: 144px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDocReferenceNumber"
                                                            id="message12" infoClass="infoMessage"
                                                            style="height: 20px; left: 288px; top: 192px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:selectInputDate binding="#{Discipline$DisciplineRequestPage.calOffenceDate}" id="calOffenceDate"
                                                        rendered="false" style="left: 150px; top: 280px; position: absolute"
                                                        value="#{Discipline$DisciplineRequestPage.calOffenceDateBean.date1}" valueChangeListener="#{Discipline$DisciplineRequestPage.calOffenceDate_processValueChange}"/>
                                                    <ice:selectInputDate binding="#{Discipline$DisciplineRequestPage.calReportedDate}" id="calReportedDate"
                                                        rendered="false" style="left: 150px; top: 280px; position: absolute"
                                                        value="#{Discipline$DisciplineRequestPage.calReportedDateBean.date1}" valueChangeListener="#{Discipline$DisciplineRequestPage.calReportedDate_processValueChange}"/>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
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
                    <div>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineRequestPage.pnlEyeWitnessesRegistration}" clientOnly="true"
                            draggable="false" id="pnlEyeWitnessesRegistration" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 406px; left: 3px; top: 80px; position: absolute; width: 787px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessageEyeWitnesses" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 800px">
                                    <ice:outputText id="pnMessageTitleEyeWitnesses"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 600px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Discipline$DisciplineRequestPage.btnClosePopupEyeWitnesses_action}"
                                        id="btnClosePopupEyeWitnesses" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 825px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup dragListener="#{Discipline$DisciplineRequestPage.panelGroupEyeWitnesses_processMyEvent}"
                                    id="panelGroupEyeWitnesses" style="display: block; height: 360px; position: relative; width: 771px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBodyEyeWitnesses" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 323px; position: relative;  width: 696px; -rave-layout: grid" styleClass="message">
                                        <ice:panelLayout id="pnlLayoutWitness" layout="flow"
                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 150px; margin-left: 15px; left: 10px; top: 22px; position: absolute;   width: 707px" styleClass="insideContainerMain">
                                            <ice:outputLabel id="lblWitness" style="left: 10px; top: 4px; position: absolute" value="Witness"/>
                                            <ice:outputLabel id="lblWitnessDepartment" style="left: 48px; top: 62px; position: absolute" value="Department"/>
                                            <ice:outputLabel id="lblWitnessId" style="left: 432px; top: 24px; position: absolute" value="Id"/>
                                            <ice:inputText binding="#{Discipline$DisciplineRequestPage.txtWitnessDepartment}" disabled="true"
                                                id="txtWitnessDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                            <ice:inputText binding="#{Discipline$DisciplineRequestPage.txtWitnessId}" id="txtWitnessId" immediate="true"
                                                partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                            <ice:outputLabel id="lblWitnessFullName" style="left: 48px; top: 24px; position: absolute" value="FullName"/>
                                            <ice:outputLabel id="lblWitnessPosition" style="left: 48px; top: 96px; position: absolute" value="Position"/>
                                            <ice:inputText binding="#{Discipline$DisciplineRequestPage.txtWitnessPosition}" disabled="true"
                                                id="txtWitnessPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                            <ice:commandButton action="#{Discipline$DisciplineRequestPage.btnSearchWitness_action}" id="btnSearchWitness"
                                                image="/resources/images/fig_search.gif" style="left: 648px; top: 24px; position: absolute"/>
                                            <ice:commandButton action="#{Discipline$DisciplineRequestPage.btnAddWinessToTable_action}" id="btnAddWinessToTable"
                                                style="left: 576px; top: 110px; position: absolute; width: 95px" value="Add"/>
                                            <ice:selectInputText action="#{Discipline$DisciplineRequestPage.txtWitnessFullNameNew_action}"
                                                binding="#{Discipline$DisciplineRequestPage.txtWitnessFullName_New1}" id="txtWitnessFullName_New1"
                                                immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true" rows="10"
                                                style="left: 166px; height: 30px; top: 22px; position: absolute"
                                                valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                <f:facet name="selectInputText">
                                                    <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                        <ice:outputText id="lblFullNameAutoCompleteAccused" value="#{employeeList.fullName}"/>
                                                        <ice:outputText id="lblWitnessIdAutoCompleteAccused" value="#{employeeList.empIdentification}"/>
                                                    </ice:panelGrid>
                                                </f:facet>
                                            </ice:selectInputText>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="pnlLayoutWitnessDataTable"
                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 10px; top: 190px;  position: absolute; overflow: auto; width: 700px" styleClass="insideContainerMain">
                                            <ice:dataTable id="dataTableEyeWitnesses" style="left: 10px; top: 0px; height:8px;  width:600px; position: absolute"
                                                value="#{Discipline$DisciplineRequestPage.eyeWitnessesList}" var="currentRow">
                                                <ice:column id="colStatus">
                                                    <ice:outputText id="optTxtForColumnStatus" value="#{currentRow['databaseStatus']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextStatus" value="Status"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colWitnessId">
                                                    <ice:outputText id="optTxtForColumnWitnessId" value="#{currentRow['witnessId']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextNumber" value="Witness Id"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colDecisionWitnessName">
                                                    <ice:outputText id="optTxtForColumnWitnessName" value="#{currentRow['witnessFullName']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextWitnessName" value="Witness Name"/>
                                                    </f:facet>
                                                    <ice:rowSelector id="rowSelectorDisciplinePenalty" multiple="false" preStyleOnSelection="true" selectionListener="#{Discipline$DisciplineRequestPage.rowSelectorDisciplinePenalty_processMyEvent}"/>
                                                </ice:column>
                                                <ice:column id="colEmpId">
                                                    <ice:outputText id="optTxtForColumnWitnessDepartment" value="#{currentRow['witnessDepartment']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextEmpId" value="Department"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column1">
                                                    <ice:outputText id="outputText32" value="#{currentRow['witnessCondition']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText33" value="WitnessCondition"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colRemoveEntry">
                                                    <ice:commandLink action="#{Discipline$DisciplineRequestPage.cmdLnkRemoveEntry_action}" id="cmdLnkRemoveEntry"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextRemove" value="Remove"/>
                                                    </f:facet>
                                                </ice:column>
                                            </ice:dataTable>
                                        </ice:panelLayout>
                                        <ice:commandButton action="#{Discipline$DisciplineRequestPage.btnSaveWitnesses_action}" id="btnSaveWitnesses"
                                            style="left: 288px; top: 302px; position: absolute; width: 72px" value="Save"/>
                                        <ice:commandButton action="#{Discipline$DisciplineRequestPage.btnResetWitnesses_action}" id="btnResetWitnesses"
                                            style="left: 384px; top: 302px; position: absolute; width: 71px" value="Reset"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineRequestPage.pnlOtherEyeWitnessesRegistration}" clientOnly="true"
                            draggable="true" id="pnlOtherEyeWitnessesRegistration" modal="true" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 550px; left: 3px; top: 0px; position: absolute; width: 987px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessageOtherEyeWitnesses" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 900px">
                                    <ice:outputText id="pnOtherMessageTitleEyeWitnesses"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 600px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Discipline$DisciplineRequestPage.btnCloseOtherPopupEyeWitnesses_action}"
                                        id="btnClosePopupOtherEyeWitnesses" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 825px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup dragListener="#{Discipline$DisciplineRequestPage.panelGroupOtherEyeWitnesses_processMyEvent}"
                                    id="panelGroupOtherEyeWitnesses" style="display: block; height: 500px; position: relative; width: 871px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBodyOtherEyeWitnesses"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 470px; position: relative; width: 796px; -rave-layout: grid" styleClass="message">
                                        <ice:panelLayout id="pnlLayoutOtherWitness"
                                            style="border: 1px solid rgb(204, 204, 204); height: 450px; margin-left: 15px; left: 10px; top: 22px; position: absolute; width: 820px" styleClass="insideContainerMain">
                                            <ice:panelLayout binding="#{Discipline$DisciplineRequestPage.panelLayout_Name}" id="panelLayout_Name" layout="flow"
                                                style="border: 1px solid rgb(204, 204, 204); height: 101px; margin-left: 15px; left: 0px; top: 10px; position: absolute; width: 696px" styleClass="insideContainerMain">
                                                <ice:inputText binding="#{Discipline$DisciplineRequestPage.txt_FirstName}" id="txt_FirstName"
                                                    style="left: 100px; top: 0px; position: absolute" validator="#{Discipline$DisciplineRequestPage.txt_FirstName_validate}"/>
                                                <ice:inputText binding="#{Discipline$DisciplineRequestPage.txt_LastName}" id="txt_LastName"
                                                    style="left: 100px; top: 65px; position: absolute" validator="#{Discipline$DisciplineRequestPage.txt_LastName_validate}"/>
                                                <ice:inputText binding="#{Discipline$DisciplineRequestPage.txt_MiddleName}" id="txt_MiddleName"
                                                    style="left: 100px; top: 30px; position: absolute" validator="#{Discipline$DisciplineRequestPage.txt_MiddleName_validate}"/>
                                                <ice:inputText binding="#{Discipline$DisciplineRequestPage.txt_Age}" id="txt_Age" style="left: 454px; top: 30px; position: absolute"/>
                                                <ice:outputLabel id="outputLabel1" style="left: 390px; top: 0px; position: absolute" value="Sex"/>
                                                <ice:outputLabel id="outputLabel2" style="left: 26px; top: 65px; position: absolute" value="Last Name"/>
                                                <ice:outputLabel id="outputLabel3" style="left: 26px; top: 30px; position: absolute" value="Middle Name"/>
                                                <ice:outputLabel id="outputLabel4" style="left: 26px; top: 0px; position: absolute" value="First Name"/>
                                                <ice:outputLabel id="outputLabel5" style="left: 390px; top: 26px; position: absolute" value="Age"/>
                                                <ice:selectOneMenu binding="#{Discipline$DisciplineRequestPage.drl_sex}" id="drl_sex" immediate="true"
                                                    partialSubmit="true" required="true" style="left: 454px; top: 0px; position: absolute; width: 141px">
                                                    <f:selectItems id="selectOneMenu1selectItems1" value="#{Discipline$DisciplineRequestPage.sex}"/>
                                                </ice:selectOneMenu>
                                                <ice:message binding="#{Discipline$DisciplineRequestPage.messageFirstName}" errorClass="errorMessage"
                                                    fatalClass="fatalMessage" for="txt_FirstName" id="messageFirstName" infoClass="infoMessage"
                                                    style="height: 20px; left: 234px; top: 0px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txt_LastName" id="message7"
                                                    infoClass="infoMessage" style="height: 20px; left: 234px; top: 52px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                <ice:message binding="#{Discipline$DisciplineRequestPage.messageMiddleName}" errorClass="errorMessage"
                                                    fatalClass="fatalMessage" for="txt_MiddleName" id="messageMiddleName" infoClass="infoMessage"
                                                    style="height: 20px; left: 234px; top: 26px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                <ice:outputLabel binding="#{Discipline$DisciplineRequestPage.lbl_FirstName}" id="lbl_FirstName" rendered="false"
                                                    style="color: #ff0000; left: 260px; top: 0px; position: absolute" value="Required"/>
                                                <ice:outputLabel binding="#{Discipline$DisciplineRequestPage.lbl_MiddleName}" id="lbl_MiddleName"
                                                    rendered="false" style="color: #ff0000; left: 260px; top: 26px; position: absolute" value="Required"/>
                                                <ice:outputLabel binding="#{Discipline$DisciplineRequestPage.lbl_LastName}" id="lbl_LastName" rendered="false"
                                                    style="color: #ff0033; left: 260px; top: 52px; position: absolute" value="Required"/>
                                            </ice:panelLayout>
                                            <ice:panelLayout binding="#{Discipline$DisciplineRequestPage.panelLayout_Adress}" id="panelLayout_Adress"
                                                style="border: 1px solid rgb(204, 204, 204); height: 155px; margin-left: 15px; left: 0px; top: 119px; position: absolute; width: 696px" styleClass="insideContainerMain">
                                                <ice:inputText binding="#{Discipline$DisciplineRequestPage.txt_HouseNumber}" id="txt_HouseNumber" style="left: 112px; top: 128px; position: absolute; width: 155px"/>
                                                <ice:selectOneMenu binding="#{Discipline$DisciplineRequestPage.drl_Zone}" id="drl_Zone" partialSubmit="true"
                                                    style="left: 112px; top: 66px; position: absolute; width: 155px"
                                                    value="#{Discipline$DisciplineRequestPage.defaultSelectedData6.selectedObject}" valueChangeListener="#{Discipline$DisciplineRequestPage.drl_Zone_processValueChange}">
                                                    <f:selectItems id="selectOneMenu2selectItems" value="#{Discipline$DisciplineRequestPage.woredaList}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectOneMenu binding="#{Discipline$DisciplineRequestPage.drl_Woreda}" id="drl_Woreda" immediate="true"
                                                    partialSubmit="true" required="true" style="left: 112px; top: 34px; position: absolute; width: 155px"
                                                    value="#{Discipline$DisciplineRequestPage.selectOneMenu3Bean.selectedObject}" valueChangeListener="#{Discipline$DisciplineRequestPage.drl_Woreda_processValueChange}">
                                                    <f:selectItems id="selectOneMenu3selectItems" value="#{Discipline$DisciplineRequestPage.zoneList}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectOneMenu binding="#{Discipline$DisciplineRequestPage.drl_Region}" id="drl_Region" immediate="true"
                                                    partialSubmit="true" required="true" style="left: 112px; top: 0px; position: absolute; width: 155px"
                                                    value="#{Discipline$DisciplineRequestPage.selectOneMenu4Bean.selectedObject}" valueChangeListener="#{Discipline$DisciplineRequestPage.drl_Region_processValueChange}">
                                                    <f:selectItems id="selectOneMenu4selectItems" value="#{Discipline$DisciplineRequestPage.regionOpt}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectOneMenu binding="#{Discipline$DisciplineRequestPage.drl_Kebele}" id="drl_Kebele" immediate="true"
                                                    partialSubmit="true" required="true" style="left: 112px; top: 99px; position: absolute; width: 155px" value="#{Discipline$DisciplineRequestPage.selectOneMenu5Bean.selectedObject}">
                                                    <f:selectItems id="selectOneMenu5selectItems" value="#{Discipline$DisciplineRequestPage.kebeleList}"/>
                                                </ice:selectOneMenu>
                                                <ice:outputLabel id="outputLabel6" style="left: 26px; top: 66px; position: absolute" value="Woreda/Subcity"/>
                                                <ice:outputLabel id="outputLabel7" style="left: 26px; top: 130px; position: absolute" value="House Number"/>
                                                <ice:outputLabel id="outputLabel8" style="left: 26px; top: 0px; position: absolute" value="Region"/>
                                                <ice:outputLabel id="outputLabel9" style="height: 18px; left: 26px; top: 104px; position: absolute" value="Kebele"/>
                                                <ice:outputLabel id="outputLabel10" style="left: 26px; top: 34px; position: absolute" value="Zone/city"/>
                                                <ice:inputText binding="#{Discipline$DisciplineRequestPage.txt_OfficeTel}" id="txt_OfficeTel"
                                                    style="left: 466px; top: 102px; position: absolute" validator="#{Discipline$DisciplineRequestPage.txt_OfficeTel_validate}"/>
                                                <ice:inputText binding="#{Discipline$DisciplineRequestPage.txt_Email}" id="txt_Email"
                                                    style="left: 466px; top: 66px; position: absolute" validator="#{Discipline$DisciplineRequestPage.txt_Email_validate}"/>
                                                <ice:inputText binding="#{Discipline$DisciplineRequestPage.txt_PoBox}" id="txt_PoBox"
                                                    style="left: 466px; top: 0px; position: absolute" validator="#{Discipline$DisciplineRequestPage.txt_PoBox_validate}"/>
                                                <ice:inputText binding="#{Discipline$DisciplineRequestPage.txt_Moblie}" id="txt_Moblie"
                                                    style="left: 466px; top: 34px; position: absolute" validator="#{Discipline$DisciplineRequestPage.txt_Moblie_validate}"/>
                                                <ice:inputText binding="#{Discipline$DisciplineRequestPage.txt_HomeTel}" id="txt_HomeTel"
                                                    style="left: 466px; top: 128px; position: absolute" validator="#{Discipline$DisciplineRequestPage.txt_HomeTel_validate}"/>
                                                <ice:outputLabel id="outputLabel11" style="left: 370px; top: 0px; position: absolute" value="P.O.Box"/>
                                                <ice:outputLabel id="outputLabel12" style="left: 370px; top: 102px; position: absolute" value="Telephone Office"/>
                                                <ice:outputLabel id="outputLabel13" style="left: 370px; top: 66px; position: absolute" value="E-mail"/>
                                                <ice:outputLabel id="outputLabel14" style="left: 370px; top: 34px; position: absolute" value="Mobile Number"/>
                                                <ice:outputLabel id="outputLabel15" style="left: 370px; top: 128px; position: absolute" value="Telephone Home"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txt_PoBox" id="message1"
                                                    infoClass="infoMessage" style="left: 599px; top: 1px; position: absolute" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txt_Moblie" id="message2"
                                                    infoClass="infoMessage" style="height: 20px; left: 598px; top: 26px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txt_Email" id="message3"
                                                    infoClass="infoMessage" style="height: 20px; left: 598px; top: 78px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txt_OfficeTel" id="message4"
                                                    infoClass="infoMessage" style="height: 20px; left: 598px; top: 104px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txt_HomeTel" id="message5"
                                                    infoClass="infoMessage" style="height: 20px; left: 598px; top: 130px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                            </ice:panelLayout>
                                            <ice:panelLayout binding="#{Discipline$DisciplineRequestPage.panelLayout_DataTable}" id="panelLayout_DataTable"
                                                style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204);  overflow: auto; height: 119px; margin-left: 15px; left: 10px; top: 290px; position: absolute; width: 800px" styleClass="insideContainerMain">
                                                <ice:dataTable id="dataTable1" style="left: 0px; top: 0px; position: absolute"
                                                    value="#{Discipline$DisciplineRequestPage.otherEyeWitnessesList}" var="currentRow" width="779">
                                                    <ice:column id="column14">
                                                        <ice:outputText id="outputText27" value="#{currentRow['databaseStatus']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText28" value="Status"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colFullName">
                                                        <h:inputText binding="#{Discipline$DisciplineRequestPage.txt_updateFullName}" id="txt_updateFullName" value="#{currentRow['otherwitnessFullName']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText2" value="Full Name"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colSex">
                                                        <h:inputText binding="#{Discipline$DisciplineRequestPage.txt_update_sex}" id="txt_update_sex" value="#{currentRow['otherwitnesSsex']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText4" value="Sex"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colAge">
                                                        <h:inputText binding="#{Discipline$DisciplineRequestPage.txt_update_age}" id="txt_update_age" value="#{currentRow['otherwitnessAge']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText6" value="Age"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colRegion" style="width: 40px">
                                                        <h:selectOneMenu binding="#{Discipline$DisciplineRequestPage.drl_update_region}" id="drl_update_region" value="#{currentRow['otherwitnessRegion']}">
                                                            <f:selectItems id="selectOneMenu1selectItems4" value="#{Discipline$DisciplineRequestPage.regionOpt}"/>
                                                        </h:selectOneMenu>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText3" value="Region"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colZone">
                                                        <h:selectOneMenu binding="#{Discipline$DisciplineRequestPage.drl_update_zone}" id="drl_update_zone" value="#{currentRow['otherwitnessZone']}">
                                                            <f:selectItems id="selectOneMenu1selectItems6" value="#{Discipline$DisciplineRequestPage.woredaList}"/>
                                                        </h:selectOneMenu>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText9" value="Zone"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colWoreda" style="width: 56px">
                                                        <h:selectOneMenu binding="#{Discipline$DisciplineRequestPage.drl_update_woreda}" id="drl_update_woreda" value="#{currentRow['otherwitnessWoreda']}">
                                                            <f:selectItems id="selectOneMenu1selectItems5" value="#{Discipline$DisciplineRequestPage.zoneList}"/>
                                                        </h:selectOneMenu>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText7" value="Woreda"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colKebele">
                                                        <h:selectOneMenu binding="#{Discipline$DisciplineRequestPage.drl_update_kebele}" id="drl_update_kebele" value="#{currentRow['otherwitnessKebele']}">
                                                            <f:selectItems id="selectOneMenu1selectItems7" value="#{Discipline$DisciplineRequestPage.kebeleList}"/>
                                                        </h:selectOneMenu>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText11" value="Kebele"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colHNumber">
                                                        <h:inputText binding="#{Discipline$DisciplineRequestPage.txt_update_houseNO}" id="txt_update_houseNO" value="#{currentRow['otherwitnessHouseNumber']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText13" value="House Number"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colPobox" style="width: 47px">
                                                        <h:inputText binding="#{Discipline$DisciplineRequestPage.txt_update_poBox}" id="txt_update_poBox" value="#{currentRow['otherwitnessPobox']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText15" value="P.O.Box"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colMobile">
                                                        <h:inputText binding="#{Discipline$DisciplineRequestPage.txt_updateMobile}" id="txt_updateMobile" value="#{currentRow['otherwitnessMobile']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText17" value="Mobile Number"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colEmail">
                                                        <h:inputText binding="#{Discipline$DisciplineRequestPage.txt_update_Email}" id="txt_update_Email" value="#{currentRow['otherwitnessEmail']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText19" value="E-mail"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colTeleOffice" style="width: 65px">
                                                        <h:inputText binding="#{Discipline$DisciplineRequestPage.txt_update_teleOffice}"
                                                            id="txt_update_teleOffice" value="#{currentRow['otherwitnessTeleOffice']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText21" value="Tele(Office)"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colTeleHome">
                                                        <h:inputText binding="#{Discipline$DisciplineRequestPage.txt_update_Tele_HOme}"
                                                            id="txt_update_Tele_HOme" value="#{currentRow['otherwitnessTeleHome']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText23" value="Tele(Home)"/>
                                                        </f:facet>
                                                        <ice:rowSelector id="OtherWitnessRegistration" multiple="false" preStyleOnSelection="true" selectionListener="#{Discipline$DisciplineRequestPage.OtherWitnessRegistration_processMyEvent}"/>
                                                    </ice:column>
                                                    <ice:column id="column15">
                                                        <h:commandButton action="#{Discipline$DisciplineRequestPage.btn_ReoveOther_action}"
                                                            binding="#{Discipline$DisciplineRequestPage.btn_ReoveOther}" id="btn_ReoveOther" value="Remove"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText30" value="Remove"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>
                                            </ice:panelLayout>
                                            <ice:commandButton action="#{Discipline$DisciplineRequestPage.btn_ADDTable_action}"
                                                binding="#{Discipline$DisciplineRequestPage.btn_ADDTable}" id="btn_ADDTable"
                                                style="left: 720px; top: 260px; position: absolute" value="ADD TABLE"/>
                                            <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineRequestPage.pnlPopupSuccessOrFailureOther}"
                                                clientOnly="true" draggable="false" id="pnlPopupSuccessOrFailureOther" modal="false" rendered="false"
                                                style="border-style: none; background-color: transparent; display: block; left 0px; top 10px; height: 136px;width: 667px" styleClass="message">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="pnlgridpnMessageOther" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                                        <ice:outputText id="pnMessageTitleOther"
                                                            style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                                        <ice:commandLink action="#{Discipline$DisciplineRequestPage.btnClosePopupSuccessOrFailureOther_action}"
                                                            binding="#{Discipline$DisciplineRequestPage.btnClosePopupSuccessOrFailureOther}"
                                                            id="btnClosePopupSuccessOrFailureOther" immediate="true"
                                                            style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                                            styleClass="popupHeaderImage" title="Close Popup"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <f:facet name="body">
                                                    <ice:panelGroup binding="#{Discipline$DisciplineRequestPage.panelGroupMessageOther}"
                                                        id="panelGroupMessageOther" style="display: block; height: 80px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                                        <ice:panelLayout binding="#{Discipline$DisciplineRequestPage.pnlMessageBodyOther}"
                                                            id="pnlMessageBodyOther" layout="flow"
                                                            style="background-color: rgb(245, 245, 245); display: block; height: 53px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                                            <h:outputLabel binding="#{Discipline$DisciplineRequestPage.lblSuccessOrErrorMessageOther}"
                                                                id="lblSuccessOrErrorMessageOther" style="background-color: #F5F5F5;"/>
                                                            <ice:commandLink action="#{Discipline$DisciplineRequestPage.lnkRegisterEyeWitnessOther_action}"
                                                                binding="#{Discipline$DisciplineRequestPage.lnkRegisterEyeWitnessOther}"
                                                                id="lnkRegisterEyeWitnessOther" style="background-color: #F5F5F5;" value="CLICK HERE TO REGISTER EYE WITNESS"/>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </f:facet>
                                            </ice:panelPopup>
                                        </ice:panelLayout>
                                        <ice:commandButton action="#{Discipline$DisciplineRequestPage.btnSaveOtherWitnesses_action}" id="btnSaveOtherWitnesses"
                                            style="left: 288px; top: 435px; position: absolute; width: 72px" value="Save"/>
                                        <ice:commandButton action="#{Discipline$DisciplineRequestPage.btnResetOtherWitnesses_action}"
                                            id="btnResetOtherWitnesses" style="left: 384px; top: 435px; position: absolute; width: 71px" value="Reset"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineRequestPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 136px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnOrganazationMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageOrganzationTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Discipline$DisciplineRequestPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Discipline$DisciplineRequestPage.panelGroupMessage}"
                                    dragListener="#{Discipline$DisciplineRequestPage.panelGroupMessage_processMyEvent}" id="panelGroupMessage"
                                    style="display: block; height: 80px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Discipline$DisciplineRequestPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 53px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Discipline$DisciplineRequestPage.lblSuccessOrErrorMessageNew}"
                                            id="lblSuccessOrErrorMessageNew" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineRequestPage.pnlPopupApproveHere}" clientOnly="true" draggable="false"
                            id="pnlPopupApproveHere" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 246px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpApproveHere" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitleApproveHere"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Discipline$DisciplineRequestPage.btnClosePopupApproveHere_action}"
                                        id="btnClosePopupSuccessOrFailureApproveHere" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Discipline$DisciplineRequestPage.panelGroupMessageApproveHere}" id="panelGroupMessageApproveHere"
                                    style="display: block; height: 200px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Discipline$DisciplineRequestPage.pnlMessageBody}" id="pnlMessageBodyApproveHere" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 173px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <ice:outputLabel id="outputLabel17" style="left: 24px; top: 24px; position: absolute" value="Expected Penality"/>
                                        <ice:outputLabel id="outputLabel18" style="left: 24px; top: 72px; position: absolute" value="DeductionAmount"/>
                                        <ice:outputLabel id="outputLabel19" style="left: 24px; top: 120px; position: absolute" value="DeductionDuration"/>
                                        <ice:outputLabel id="outputLabel20" style="left: 408px; top: 24px; position: absolute" value="Decision"/>
                                        <ice:outputText id="outputText34" style="left: 336px; top: 96px; position: absolute" value="Commeents "/>
                                        <ice:inputText binding="#{Discipline$DisciplineRequestPage.txt_DeductionAmount}" disabled="true"
                                            id="txt_DeductionAmount" style="left: 142px; top: 70px; position: absolute"/>
                                        <ice:inputText binding="#{Discipline$DisciplineRequestPage.txt_DeductionDuration}" disabled="true"
                                            id="txt_DeductionDuration" style="left: 142px; top: 118px; position: absolute"/>
                                        <ice:selectOneMenu binding="#{Discipline$DisciplineRequestPage.drl_Decision}" id="drl_Decision" partialSubmit="true"
                                            style="left: 478px; top: 22px; position: absolute; width: 143px" value="#{Discipline$DisciplineRequestPage.defaultSelectedData9.selectedObject}">
                                            <f:selectItems id="selectOneMenu1selectItems8" value="#{Discipline$DisciplineRequestPage.availableDecisionsToMake}"/>
                                        </ice:selectOneMenu>
                                        <ice:inputTextarea binding="#{Discipline$DisciplineRequestPage.txtArea_Commeents}" id="txtArea_Commeents" style="height: 71px; left: 406px; top: 70px; position: absolute; width: 215px"/>
                                        <ice:inputTextarea binding="#{Discipline$DisciplineRequestPage.txtArea_ExpectedPenality}" disabled="true"
                                            id="txtArea_ExpectedPenality" style="left: 142px; top: 5px; position: absolute; width: 215px"/>
                                        <ice:commandButton action="#{Discipline$DisciplineRequestPage.btn_Approve_action}" id="btn_Approve"
                                            style="height: 25px; left: 168px; top: 158px; position: absolute; width: 71px" value="Approve"/>
                                        <ice:commandButton id="btn_reset" style="height: 23px; left: 288px; top: 158px; position: absolute; width: 71px" value="Reset"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineRequestPage.pnlPopupSuccessOrFailureForApproveHere}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailureForApproveHere" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 136px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessageApproveHere" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitleApproveHerePopup"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Discipline$DisciplineRequestPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailureApproveHerePopUP" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Discipline$DisciplineRequestPage.panelGroupMessageApproveHerePopUP}"
                                    dragListener="#{Discipline$DisciplineRequestPage.panelGroupMessage_processMyEvent}" id="panelGroupMessageApproveHerePopUP"
                                    style="display: block; height: 80px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Discipline$DisciplineRequestPage.pnlMessageBodyApproveHereRequest}"
                                        id="pnlMessageBodyApproveHereRequest" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 53px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Discipline$DisciplineRequestPage.lblSuccessOrErrorMessageApproveHere}"
                                            id="lblSuccessOrErrorMessageApproveHere" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineRequestPage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 1200px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="1090">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - "/>
                                    <ice:commandButton action="#{Discipline$DisciplineRequestPage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="left: 950px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px;  position: absolute; width: 1195px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 1170px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Discipline$DisciplineRequestPage.decisionsMadeOnRequest}" var="currentRow">
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
                                            <ice:column id="colDeduction">
                                                <ice:outputText id="outputText1" value="#{currentRow['deductionAmount']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText5" value="DeductionAmount"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colDuration">
                                                <ice:outputText id="outputText8" value="#{currentRow['duration']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText10" value="Duration"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column5">
                                                <ice:outputText id="outputText12" value="#{currentRow['suggetedPenality']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText13" value="Suggested penalty "/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column6">
                                                <ice:outputText id="outputText14" value="#{currentRow['suggestedDeduction']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText15" value="Suggested penalty deduction"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column7">
                                                <ice:outputText id="outputText16" value="#{currentRow['suggestedDuration']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText17" value="Suggested deduction duration"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column8">
                                                <ice:outputText id="outputText18" value="#{currentRow['suggetedPenality']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText19" value="Approved Penalty"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column9">
                                                <ice:outputText id="outputText20" value="#{currentRow['approvedDeduction']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText21" value="Approved penalty deduction"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column10">
                                                <ice:outputText id="outputText22" value="#{currentRow['suggestedDuration']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText23" value="Approved duration "/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column11">
                                                <ice:outputText id="outputText24" value="#{currentRow['promotionSuspends']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText25" value="Suspended From Promtion"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column12">
                                                <ice:outputText id="outputText26" value="#{currentRow['promotionDuration']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText27" value="Promotion Suspend Duration"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column13">
                                                <ice:outputText id="outputText28" value="#{currentRow['transferSuspends']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText29" value="Suspended From Transfer"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column14">
                                                <ice:outputText id="outputText30" value="#{currentRow['transferDuration']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText31" value="Transfer Suspend Duration"/>
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
