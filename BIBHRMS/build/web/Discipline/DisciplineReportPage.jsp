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
        <html id="outputHtml1">
            <head id="outputHead1">
                <link HREF="./resources/images/header_icon.ico" REL="icon"/>
                <title>Discipline Issue Page</title>
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
        function ReportPageRegistration(field){

            if (field.defaultValue == field.value) field.value = '';
            else if (field.value == '') field.value = field.defaultValue;

        }
    </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Discipline$DisciplineReportPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Discipline$DisciplineReportPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Discipline$DisciplineReportPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Discipline$DisciplineReportPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Discipline$DisciplineReportPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="height: 690px">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200); height: 720px; top: 25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 690px; left: 0px; top: 0px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="Search Area"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 100px; width: 100%">
                                                        <ice:outputText id="outputText19" value=""/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" width="100%">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplineReportPage.lnkDisciplineApprove_action}"
                                                                id="lnkDisciplineApprove" style="color:#306682;font-weight:bold" value="Discipline Approve"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplineReportPage.lnkDisciplineRegistrationPage_action}"
                                                                id="lnkDisciplineRegistrationPage" style="color:#306682;font-weight:bold" value="Discipline Types"/>
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
                                                    <ice:panelGroup id="status_Group_Pending" style="padding: 0px; background:transparent;border:none;display: block;float:left;height:120px; width: 100%">
                                                        <ice:panelLayout id="StatusContainerPending" style="height: 125px; position: absolute; width: 190px"/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_History" style="border-style: none; height: 311px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header_History">
                                                        <ice:outputText id="lblStatusHistory" value="History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoardHistory" width="100%">
                                                    <ice:panelGroup id="status_Group_History" style="padding: 0px; background:transparent;border:none;display: block;float:left;height:120px; width: 100%">
                                                        <ice:panelLayout id="StatusContainerHistory" style="height: 261px; position: absolute; width: 190px"/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height:740px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 600px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 710px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="DISPLINE REQUEST"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 730px; left: 0px; top: -20px; position: absolute; width: 791px">
                                                <ice:panelLayout id="pnProfile" style="height: 731px; left: 0px; top: 0px; position: absolute; width: 782px">
                                                    <ice:panelGroup id="pnlGrpEvaluationContent" style="height: 694px" styleClass="icePnlGrp filedset_border">
                                                        <ice:panelLayout id="pnlLayoutForWhom"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 40px; margin-left: 15px; left: 20px; top: 20px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:selectBooleanCheckbox binding="#{Discipline$DisciplineReportPage.ckbStatusAny}"
                                                                id="ckbStatusAny" partialSubmit="true" style="left: 6px; top: 16px; position: absolute"
                                                                value="#{Discipline$DisciplineReportPage.defaultSelectedData4.selectedBoolean}" valueChangeListener="#{Discipline$DisciplineReportPage.ckbStatusAny_processValueChange}"/>
                                                            <ice:selectBooleanCheckbox binding="#{Discipline$DisciplineReportPage.ckbStatusApproved}"
                                                                id="ckbStatusApproved" immediate="true" partialSubmit="true"
                                                                style="left: 161px; top: 13px; position: absolute"
                                                                value="#{Discipline$DisciplineReportPage.defaultSelectedData5.selectedBoolean}" valueChangeListener="#{Discipline$DisciplineReportPage.ckbStatusApproved_processValueChange}"/>
                                                            <ice:selectBooleanCheckbox binding="#{Discipline$DisciplineReportPage.ckbStatusOnProgress}"
                                                                id="ckbStatusOnProgress" immediate="true" partialSubmit="true"
                                                                style="left: 334px; top: 13px; position: absolute"
                                                                value="#{Discipline$DisciplineReportPage.defaultSelectedData6.selectedBoolean}" valueChangeListener="#{Discipline$DisciplineReportPage.ckbStatusOnProgress_processValueChange}"/>
                                                            <ice:selectBooleanCheckbox binding="#{Discipline$DisciplineReportPage.ckbStatusRejected}"
                                                                id="ckbStatusRejected" immediate="true" partialSubmit="true"
                                                                style="left: 523px; top: 10px; position: absolute"
                                                                value="#{Discipline$DisciplineReportPage.defaultSelectedData7.selectedBoolean}" valueChangeListener="#{Discipline$DisciplineReportPage.ckbStatusRejected_processValueChange}"/>
                                                            <ice:outputLabel id="lblStatusAny" style="left: 47px; top: 10px; position: absolute" value="Any status"/>
                                                            <ice:outputLabel id="lblStatusApproved" style="left: 193px; top: 8px; position: absolute" value="Approved"/>
                                                            <ice:outputLabel id="lblStatusOnProgress" style="left: 361px; top: 9px; position: absolute" value="On progress"/>
                                                            <ice:outputLabel id="lblStatusRejected" style="left: 548px; top: 8px; position: absolute" value="Rejected"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutRequester"
                                                            style=" height: 135px; margin-left: 15px; left: 20px; top: 75px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblAnyRequestRequester" style="left: 43px; top: -4px; position: absolute" value="Select this for any requester, else select an employee"/>
                                                            <ice:selectBooleanCheckbox binding="#{Discipline$DisciplineReportPage.ckbAnyRequester}"
                                                                id="ckbAnyRequester" partialSubmit="true" style="left: 5px; top: 2px; position: absolute"
                                                                value="#{Discipline$DisciplineReportPage.defaultSelectedDataAnyRequester.selectedBoolean}" valueChangeListener="#{Discipline$DisciplineReportPage.ckbAnyRequester_processValueChange}"/>
                                                            <ice:selectInputText action="#{Discipline$DisciplineReportPage.txtRequesterFullName_action}"
                                                                binding="#{Discipline$DisciplineReportPage.txtRequesterFullName}" id="txtRequesterFullName"
                                                                immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList"
                                                                partialSubmit="true" rows="10" style="left: 166px; top: 22px; position: absolute"
                                                                valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                                <f:facet name="selectInputText">
                                                                    <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                        <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                        <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                    </ice:panelGrid>
                                                                </f:facet>
                                                            </ice:selectInputText>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="Department"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="Id"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineReportPage.txtRequesterDepartment}" disabled="true"
                                                                id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineReportPage.txtRequesterId}" id="txtRequesterId"
                                                                immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="FullName"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="Position"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineReportPage.txtRequesterPosition}" disabled="true"
                                                                id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                            <ice:commandButton action="#{Discipline$DisciplineReportPage.btnSearchRequester_action}"
                                                                binding="#{Discipline$DisciplineReportPage.btnSearchRequester}" id="btnSearchRequester"
                                                                image="/resources/images/fig_search.gif" style="left: 648px; top: 24px; position: absolute"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutEmployee"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 135px; margin-left: 15px; left: 20px; top: 222px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblAnyRequestAccused" style="left: 48px; top: 0px; position: absolute" value="Select this for any accused employee, else select an employee"/>
                                                            <ice:selectBooleanCheckbox binding="#{Discipline$DisciplineReportPage.ckbAnyAccused}"
                                                                id="ckbAnyAccused" partialSubmit="true" style="left: 9px; top: 4px; position: absolute"
                                                                value="#{Discipline$DisciplineReportPage.defaultSelectedDataAnyAccused.selectedBoolean}" valueChangeListener="#{Discipline$DisciplineReportPage.ckbAnyAccused_processValueChange}"/>
                                                            <ice:outputLabel id="lblEmployeeDepartment" style="left: 48px; top: 62px; position: absolute" value="Department"/>
                                                            <ice:outputLabel id="lblEmployeeId" style="left: 432px; top: 24px; position: absolute" value="Id"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineReportPage.txtAccusedDepartment}" disabled="true"
                                                                id="txtAccusedDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineReportPage.txtAccusedId}" id="txtAccusedId"
                                                                immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblEmployeeFullName" style="left: 48px; top: 24px; position: absolute" value="FullName"/>
                                                            <ice:outputLabel id="lblEmployeePosition" style="left: 48px; top: 96px; position: absolute" value="Position"/>
                                                            <ice:selectInputText action="#{Discipline$DisciplineReportPage.txtAccusedFullName_action}"
                                                                binding="#{Discipline$DisciplineReportPage.txtAccusedFullName}" id="txtAccusedFullName"
                                                                immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList"
                                                                partialSubmit="true" rows="10" style="height: 23px; left: 166px; top: 22px; position: absolute"
                                                                valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                                <f:facet name="selectInputText">
                                                                    <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                        <ice:outputText id="lblFullNameAutoCompleteAccused" value="#{employeeList.fullName}"/>
                                                                        <ice:outputText id="lblEmployeeIdAutoCompleteAccused" value="#{employeeList.empIdentification}"/>
                                                                    </ice:panelGrid>
                                                                </f:facet>
                                                            </ice:selectInputText>
                                                            <ice:inputText binding="#{Discipline$DisciplineReportPage.txtAccusedPosition}" disabled="true"
                                                                id="txtAccusedPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                            <ice:commandButton action="#{Discipline$DisciplineReportPage.btnSearchAccused_action}"
                                                                binding="#{Discipline$DisciplineReportPage.btnSearchAccused}" id="btnSearchAccused"
                                                                image="/resources/images/fig_search.gif" style="left: 648px; top: 24px; position: absolute"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutDecider"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 319px; margin-left: 15px; left: 20px; top: 365px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblAnyRequestParameter" style="left: 48px; top: 9px; position: absolute" value="Any Parameter"/>
                                                            <ice:selectBooleanCheckbox binding="#{Discipline$DisciplineReportPage.ckbAnyRequestParameter}"
                                                                id="ckbAnyRequestParameter" immediate="true" partialSubmit="true"
                                                                style="left: 10px; top: 10px; position: absolute"
                                                                value="#{Discipline$DisciplineReportPage.defaultSelectedDataAnyParameter.selectedBoolean}" valueChangeListener="#{Discipline$DisciplineReportPage.ckbAnyRequestParameter_processValueChange}"/>
                                                            <ice:outputLabel id="lblDisciplineStartDate" style="left: 48px; top: 42px; position: absolute" value="From Date"/>
                                                            <ice:outputLabel id="lblDisciplineEndDate" style="left: 49px; top: 80px; position: absolute" value="To Date"/>
                                                            <ice:outputLabel id="lblDisciplineType" style="left: 403px; top: 42px; position: absolute" value="DisciplineType"/>
                                                            <ice:outputLabel id="lblPenalty" style="left: 409px; top: 80px; position: absolute" value="Penalized : "/>
                                                            <ice:inputText binding="#{Discipline$DisciplineReportPage.txtDisciplineStartDate}" disabled="true"
                                                                id="txtDisciplineStartDate" style="left: 168px; top: 42px; position: absolute"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineReportPage.txtDisciplineEndDate}" disabled="true"
                                                                id="txtDisciplineEndDate" style="left: 168px; top: 81px; position: absolute"/>
                                                            <ice:outputLabel id="lblRepitition222" rendered="false"
                                                                style="left: 408px; top: 48px; position: absolute" value="Repitition"/>
                                                            <ice:selectOneMenu binding="#{Discipline$DisciplineReportPage.drlDisciplineType}"
                                                                id="drlDisciplineType" immediate="true" partialSubmit="true"
                                                                style="left: 527px; top: 46px; position: absolute; width: 143px" value="#{Discipline$DisciplineReportPage.selectedObjectOfDisciplineType.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{Discipline$DisciplineReportPage.disciplineTypesList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Discipline$DisciplineReportPage.drlPenalty}" id="drlPenalty"
                                                                partialSubmit="true" style="left: 527px; top: 79px; position: absolute; width: 143px" value="#{Discipline$DisciplineReportPage.selectedDataOfPenality.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems2" value="#{Discipline$DisciplineTypesRegistrationPage.penaltyTypesListOption}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:commandButton action="#{Discipline$DisciplineReportPage.btnCalendarDisciplineDate_action}"
                                                                id="btnCalendarDisciplineDate" image="/resources/images/cal_icon.JPG"
                                                                style="left: 314px; top: 42px; position: absolute" value="submit"/>
                                                            <ice:commandButton action="#{Discipline$DisciplineReportPage.btnCalendarReportedDate_action}"
                                                                id="btnCalendarReportedDate" image="/resources/images/cal_icon.JPG"
                                                                style="left: 313px; top: 81px; position: absolute" value="submit"/>
                                                            <ice:commandButton action="#{Discipline$DisciplineReportPage.btnPrieviewAll_action}"
                                                                binding="#{Discipline$DisciplineReportPage.btnPrieviewAll}" id="btnPrieviewAll"
                                                                style="left: 432px; top: 113px; position: absolute; width: 120px" value="Preview"/>
                                                            <ice:commandButton action="#{Discipline$DisciplineReportPage.btnGenerateReport_action}"
                                                                id="btnGenerateReport" style="left: 288px; top: 114px; position: absolute; width: 120px" value="Search"/>
                                                            <ice:commandButton action="#{Discipline$DisciplineReportPage.btnReset_action}" id="btnReset"
                                                                style="left: 576px; top: 110px; position: absolute; width: 120px" value="Reset"/>
                                                            <ice:panelLayout id="pnlLayoutTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 159px; margin-left: 15px; left: 9px; top: 150px; overflow: auto; position: absolute; width: 669px">
                                                                <ice:dataTable id="dataTable"
                                                                    style="left: 20px; top: 0px; height:8px; width:615px; position: absolute"
                                                                    value="#{Discipline$DisciplineReportPage.generatedReportList}" var="currentRow">
                                                                    <ice:column id="colRequesterFullName">
                                                                        <ice:outputText id="optTxtForColumnRequesterFullName" value="#{currentRow['requesterFullName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextRequesterFullName" value="Requester "/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colAccusedFullName">
                                                                        <ice:outputText id="optTxtForColumnAccusedFullName" value="#{currentRow['offenderFullName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextAccusedFullName" value="Accused "/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colDisciplimeName">
                                                                        <ice:outputText id="optTxtForColumnDisciplimeName" value="#{currentRow['offenceType']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextDisciplimeName" value="Discipline Name "/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colOffenceDate">
                                                                        <ice:outputText id="optTxtForColumnOffenceDate" value="#{currentRow['dateOfOffence']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextOffenceDate" value="Offence Date "/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colRepitition">
                                                                        <ice:outputText id="optTxtForColumnRepitition" value="#{currentRow['repititionOfOffence']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextRepitition" value="Repitition "/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colPenalty">
                                                                        <ice:outputText id="optTxtForColumnPenalty" value="#{currentRow['penalty']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextPenalty" value="Penalty "/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                        </ice:panelLayout>
                                                        <ice:selectInputDate binding="#{Discipline$DisciplineReportPage.calOffenceDate}" id="calOffenceDate"
                                                            rendered="false" style="left: 150px; top: 280px; position: absolute"
                                                            value="#{Discipline$DisciplineReportPage.calOffenceDateBean.date1}" valueChangeListener="#{Discipline$DisciplineReportPage.calOffenceDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{Discipline$DisciplineReportPage.calReportedDate}" id="calReportedDate"
                                                            rendered="false" style="left: 150px; top: 280px; position: absolute"
                                                            value="#{Discipline$DisciplineReportPage.calReportedDateBean.date1}" valueChangeListener="#{Discipline$DisciplineReportPage.calReportedDate_processValueChange}"/>
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
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineReportPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Mugher Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Discipline$DisciplineReportPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Discipline$DisciplineReportPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Discipline$DisciplineReportPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Discipline$DisciplineReportPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
