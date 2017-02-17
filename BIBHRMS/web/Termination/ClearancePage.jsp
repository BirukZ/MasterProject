<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : Bravozulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization_Termination" var="msgst"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle11"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <script src="../Script/Ethiopian_Calendar.js"></script>
                <script src="../Script/jquery-1.3.2.min.js"></script>
                <script src="../Script/jquery.notice.js"></script>
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
             <!--   <link HREF="../FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{Termination$ClearancePage.panelBorder1Bean.renderCenter}"
                        renderEast="#{Termination$ClearancePage.panelBorder1Bean.renderEast}"
                        renderNorth="#{Termination$ClearancePage.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Termination$ClearancePage.panelBorder1Bean.renderSouth}"
                        renderWest="#{Termination$ClearancePage.panelBorder1Bean.renderWest}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                        <f:facet name="north">
                            <ice:panelGroup id="page_header" style="height: 117px">
                                <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow" style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                    styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                                <!-- End Header -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelLayout id="left_menu1" layout="flow"
                                style="border:none;height:845px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                <ice:panelLayout id="list_menu2" style="height:845px;top:15px; left: 5px; position: absolute; width: 213px" styleClass="list_menu">
                                    <ice:panelCollapsible expanded="true" id="pnl_col_Search" rendered="false" style="border:none">
                                        <f:facet name="header">
                                            <ice:panelGroup id="search_Group_Header">
                                                <ice:outputText id="lblSearchArea" value="Search Area"/>
                                            </ice:panelGroup>
                                        </f:facet>
                                        <ice:panelGrid id="search_panelGrid" width="100%">
                                            <ice:panelGroup id="search_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;display: block;float:left;width: 100%">
                                                <ice:panelGroup id="btnSearchEmployeeState" style="height: 185px">
                                                    <ice:outputLabel id="ByID" style="left: 7px; top: 79px; position: absolute; width: 24px" value="By EmpID"/>
                                                    <ice:commandButton action="#{Termination$ClearancePage.btnSearchEmplyeeState_action}"
                                                        id="btnSearchEmplyeeState" style="left: 151px; top: 69px; position: absolute" value="Search"/>
                                                    <ice:outputLabel id="byName" style="left: 7px; top: 31px; position: absolute; width: 24px" value="ByName"/>
                                                </ice:panelGroup>
                                            </ice:panelGroup>
                                        </ice:panelGrid>
                                    </ice:panelCollapsible>
                                    <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" rendered="false" style="border:none">
                                        <f:facet name="header">
                                            <ice:panelGroup id="commonTasksGroup_header">
                                                <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                            </ice:panelGroup>
                                        </f:facet>
                                        <ice:panelGrid id="commonTasksGroup_Grid" width="100%">
                                            <ice:panelGroup id="commonTasksGroup_Group" style="width:100%"/>
                                            <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                <li>
                                                    <ice:commandLink action="#{Termination$ClearancePage.commandLink1_action}"
                                                        actionListener="#{Termination$ClearancePage.commandLink1_processAction}"
                                                        binding="#{Termination$ClearancePage.commandLink1}" id="commandLink1"
                                                        style="color:#306682;font-weight:bold" value="Clearing Department Setting"/>
                                                </li>
                                            </ul>
                                        </ice:panelGrid>
                                    </ice:panelCollapsible>
                                    <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                        <f:facet name="header">
                                            <ice:panelGroup id="status_Group_Header">
                                                <ice:outputText id="lblStatus" value="Clearance Request Lists"/>
                                            </ice:panelGroup>
                                        </f:facet>
                                        <ice:panelGrid id="statusPanelGrid" style="height: 1005px" width="100%">
                                            <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:225px; width: 100%">
                                                <ice:panelLayout id="StatusContainer" style="border-style: none; background-color: transparent; height: 500px; position: absolute; width: 100%">
                                                    <ice:selectOneListbox binding="#{Termination$ClearancePage.lstClearancerequest}" id="lstClearancerequest"
                                                        partialSubmit="true" size="2"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); height: 320px; left: -2px; top: -362px; position: absolute; width: 190px"
                                                        tabindex="1" value="#{Termination$ClearancePage.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Termination$ClearancePage.lstClearancerequest_processValueChange}">
                                                        <f:selectItems id="selectOneListbox1selectItems" value="#{Termination$ClearancePage.clearanceRequests}"/>
                                                    </ice:selectOneListbox>
                                                    <ice:outputText id="lblInfoAboutClearance" style="left: 0px; top: 24px; position: absolute" value="List of cleared employees.by selecting a single employee you can generate a report also by clicking the Generate Report button."/>
                                                    <ice:selectOneListbox binding="#{Termination$ClearancePage.lstClearancerequestCleared}"
                                                        id="lstClearancerequestCleared" partialSubmit="true" size="2"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); height: 300px; left: -2px; top: 94px; position: absolute; width: 190px"
                                                        tabindex="1" value="#{Termination$ClearancePage.selectOneListbox1BeanCleared.selectedObject}" valueChangeListener="#{Termination$ClearancePage.lstClearancerequestCleared_processValueChange}">
                                                        <f:selectItems id="selectOneListbox1selectItems111" value="#{Termination$ClearancePage.clearanceRequestsCleared}"/>
                                                    </ice:selectOneListbox>
                                                </ice:panelLayout>
                                            </ice:panelGroup>
                                        </ice:panelGrid>
                                    </ice:panelCollapsible>
                                </ice:panelLayout>
                            </ice:panelLayout>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height:1700px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 1650px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css" style="height: 1650px;">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="Manage Clearance Request Here"/>
                                        </legend>
                                        <ice:panelLayout id="pnProfile" style="height: 1650px; left: 0px;  top: 15px;  position: absolute; width: 100%">
                                            <ice:panelGroup dragListener="#{Termination$ClearancePage.ClearanceManager_processMyEvent}" id="ClearanceManager"
                                                style="height: 1650px; margin-top: 5px" styleClass="filedset_border">
                                                <ice:panelLayout id="pnlClearingDepartmentDetail" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 120px; left: 35px; top: 630px; overflow: auto; position: absolute; width: 697px">
                                                    <ice:dataTable id="dataTable1" value="#{Termination$ClearancePage.clearedDepartmentDetail}" var="currentRow" width="100%">
                                                        <ice:column id="column1">
                                                            <ice:outputText id="outputText8" value="#{currentRow['employeeId']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText11" value="Employee Id"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column4">
                                                            <ice:outputText id="outputText16" value="#{currentRow['employeeFullName']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText17" value="Employee Full Name"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column6">
                                                            <ice:outputText id="outputText20" value="#{currentRow['clearedDate']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText21" value="Cleared Date"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlClearingDepartmentDetailInfo" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 582px; left: 11px; top: 774px; overflow: auto; position: absolute; width: 720px; -rave-layout: grid">
                                                    <ice:outputText id="outputText22" style="font-weight: bold; left: 24px; top: 0px; position: absolute" value="#{msgst.Anyasset}"/>
                                                    <ice:outputText id="outputText23" style="left: 120px; top: 24px; position: absolute" value="#{msgst.Yes}"/>
                                                    <ice:outputText id="outputText24" style="left: 216px; top: 24px; position: absolute" value="#{msgst.No}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Termination$ClearancePage.chkYes}" id="chkYes" partialSubmit="true"
                                                        style="left: 94px; top: 22px; position: absolute"
                                                        value="#{Termination$ClearancePage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Termination$ClearancePage.chkYes_processValueChange}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Termination$ClearancePage.chkNo}" id="chkNo" partialSubmit="true"
                                                        style="left: 190px; top: 22px; position: absolute"
                                                        value="#{Termination$ClearancePage.defaultSelectedData18.selectedBoolean}" valueChangeListener="#{Termination$ClearancePage.chkNo_processValueChange}"/>
                                                    <ice:inputTextarea binding="#{Termination$ClearancePage.txtRemark}" disabled="true" id="txtRemark" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 71px; left: 142px; top: 214px; position: absolute; width: 407px"/>
                                                    <ice:outputText id="outputText25" style="left: 72px; top: 72px; position: absolute; width: 69px" value="#{msgst.InCash}"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRemark" id="message1"
                                                        infoClass="infoMessage" style="height: 21px; left: 648px; top: 120px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                    <ice:outputLabel id="lblBenefit1"
                                                        style="height: 41px; left: 360px; top: 120px; position: absolute; width: 118px" value="#{msgst.search}"/>
                                                    <ice:selectInputText action="#{Termination$ClearancePage.txtSearchByDevice_action}"
                                                        binding="#{Termination$ClearancePage.txtSearchByDevice}" disabled="true" id="txtSearchByDevice"
                                                        immediate="true" listValue="#{Termination$ClearancePage.list}" listVar="deviceList" partialSubmit="true"
                                                        style="left: 480px; top: 120px; position: absolute;visibility: visible;"
                                                        valueChangeListener="#{Termination$ClearancePage.txtSearchByDevice_processValueChange}" visible="true" width="100">
                                                        <f:facet name="selectInputText">
                                                            <ice:panelGrid columnClasses="empIdCol,fullNameCol" columns="2">
                                                                <ice:outputText id="lblFullNameAutoComplete2" value="#{deviceList.diviceName}"/>
                                                                <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{deviceList.diviceCode}"/>
                                                            </ice:panelGrid>
                                                        </f:facet>
                                                    </ice:selectInputText>
                                                    <ice:outputLabel id="lblBenefit2" style="left: 360px; top: 168px; position: absolute" value="#{msgst.saftyDevice}"/>
                                                    <ice:inputText binding="#{Termination$ClearancePage.txtDeviceNAme}" disabled="true" id="txtDeviceNAme" style="height: 21px; left: 478px; top: 166px; position: absolute; width: 167px"/>
                                                    <ice:commandButton action="#{Termination$ClearancePage.btnAddToTable1_action}"
                                                        binding="#{Termination$ClearancePage.btnAddToTable1}" disabled="true" id="btnAddToTable1"
                                                        style="left: 504px; top: 302px; position: absolute" value="#{msgst.Add}"/>
                                                    <ice:commandButton action="#{Termination$ClearancePage.btnUpdate_action}"
                                                        binding="#{Termination$ClearancePage.btnUpdate}" disabled="true" id="btnUpdate"
                                                        style="left: 576px; top: 494px; position: absolute" value="#{msgst.update}"/>
                                                    <ice:outputText id="outputText26" style="left: 24px; top: 240px; position: absolute; width: 69px" value="#{msgst.PleaseDescribeHere}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Termination$ClearancePage.chkIncash}" disabled="true" id="chkIncash"
                                                        partialSubmit="true" style="left: 46px; top: 70px; position: absolute"
                                                        value="#{Termination$ClearancePage.defaultSelectedData19.selectedBoolean}" valueChangeListener="#{Termination$ClearancePage.chkIncash_processValueChange}"/>
                                                    <ice:outputText id="outputText27" style="left: 240px; top: 72px; position: absolute; width: 69px" value="#{msgst.InKind}"/>
                                                    <ice:inputText binding="#{Termination$ClearancePage.txtAmountOfBirr}" disabled="true" id="txtAmountOfBirr" style="left: 142px; top: 142px; position: absolute"/>
                                                    <ice:outputText id="outputText28" style="left: 24px; top: 144px; position: absolute; width: 117px" value="#{msgst.AmountOfBirr}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Termination$ClearancePage.chkInKind}" disabled="true" id="chkInKind"
                                                        partialSubmit="true" style="position: absolute; left: 216px; top: 72px" value="#{Termination$ClearancePage.defaultSelectedData20.selectedBoolean}"/>
                                                    <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage"
                                                        for="txtAmountOfBirr" id="message2" infoClass="iceMsgInfo infoMessage"
                                                        style="height: 20px; left: 288px; top: 144px; position: absolute; width: 45px" warnClass="iceMsgWarn warnMessage"/>
                                                    <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage" for="txtDeviceNAme"
                                                        id="message3" infoClass="iceMsgInfo infoMessage"
                                                        style="height: 20px; left: 648px; top: 168px; position: absolute; width: 45px" warnClass="iceMsgWarn warnMessage"/>
                                                    <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage" for="txtRemark"
                                                        id="message4" infoClass="iceMsgInfo infoMessage"
                                                        style="height: 69px; left: 552px; top: 216px; position: absolute; width: 45px" warnClass="iceMsgWarn warnMessage"/>
                                                    <ice:panelLayout id="pnl_ItemDataTablePNL" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 69px; left: 11px; top: 360px; overflow: auto; position: absolute; width: 645px; -rave-layout: grid">
                                                        <ice:dataTable binding="#{Termination$ClearancePage.dataTableClerace}" id="dataTableClerace"
                                                            style="height: 8px; width: 600px" value="#{Termination$ClearancePage.itemTypeList}" var="currentRow">
                                                            <ice:column id="colPopupItemNAme1">
                                                                <ice:inputText id="txtPopupForColumnBenefitName2" value="#{currentRow['itemName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupBenefitName2" value="Item Name"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelector3"
                                                                    selectionListener="#{Termination$ClearancePage.rowSelector1_processAction}" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplineTypeCode2">
                                                                <ice:inputText id="txtPopupForColumnBenefitType2" value="#{currentRow['price']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextBenefitType2" value="Price"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupDescription1">
                                                                <ice:inputText id="txtPopupForColumnDescription1" value="#{currentRow['description']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupDescription1" value="Description"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colEdit1">
                                                                <ice:commandLink action="#{Termination$ClearancePage.cmdLnkEdit_action}" id="cmdLnkEdit1" value="Ok"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextEdit1" value="Edit"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colRemove1">
                                                                <ice:commandLink action="#{Termination$ClearancePage.cmdLnkRemove_action}" id="cmdLnkRemove1" value="Remove"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextRemove1" value="Remove"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlClearingDepsTableContainer" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 206px; left: 35px; top: 390px; overflow: auto; position: absolute; width: 720px">
                                                    <ice:dataTable binding="#{Termination$ClearancePage.tblClearingDep1}" id="tblClearingDep1"
                                                        style="margin-left: 10px; left: -10px; top: -10px; position: absolute"
                                                        value="#{Termination$ClearancePage.availabledepartment}" var="currentRow" width="722">
                                                        <ice:column id="column2" style="width: 250px">
                                                            <ice:outputText id="outputText3" value="#{currentRow['description']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText4" value="Department Name"/>
                                                            </f:facet>
                                                            <ice:rowSelector id="rwSelectorPeriodList" immediate="true" multiple="false"
                                                                selectionListener="#{Termination$ClearancePage.rwSelectorPeriodList_processMyEvent}" value="#{currentRow['selected']}"/>
                                                        </ice:column>
                                                        <ice:column id="column3">
                                                            <ice:outputText id="outputText5" value="#{currentRow['returnedDescriptionText']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText6" value="Returned"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column5">
                                                            <ice:outputText id="outputText7" value="#{currentRow['clearedStatusText']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText12" value="Status"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlDecision" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 241px; left: 11px; top: 1374px; overflow: auto; position: absolute; width: 720px">
                                                    <label style="left: 20px; top: 180px; border-bottom:0.5px groove #176674; width:680px; position: absolute;"></label>
                                                    <label style="left: 20px; top: 230px; border-bottom:0.5px groove #176674; width:680px; position: absolute;"></label>
                                                    <ice:outputText id="outputText13" style="left: 10px; top: 60px; position: absolute" value="#{msgst.Id}"/>
                                                    <ice:outputText id="outputText15" style="left: 380px; top: 60px; position: absolute" value="#{msgst.FullName }"/>
                                                    <ice:outputText id="outputText18" style="left: 10px; top: 90px; position: absolute" value="#{msgst.Position}"/>
                                                    <ice:outputText id="outputText19" style="left: 380px; top: 90px; position: absolute" value="#{msgst.Department}"/>
                                                    <ice:commandButton action="#{Termination$ClearancePage.btnClearEmployee_action}"
                                                        binding="#{Termination$ClearancePage.btnClearEmployee}" disabled="true" id="btnClearEmployee"
                                                        style="left: 72px; top: 182px; position: absolute; width: 120px" value="#{msgst.btnClearEmployee}"/>
                                                    <ice:commandButton action="#{Termination$ClearancePage.btnUnclearEmployee_action}"
                                                        binding="#{Termination$ClearancePage.btnUnclearEmployee}" disabled="true" id="btnUnclearEmployee"
                                                        style="left: 264px; top: 182px; position: absolute; width: 143px" value="#{msgst.btnUnClearEmployee}"/>
                                                    <ice:outputText binding="#{Termination$ClearancePage.lblClearingEmployeeId}" id="lblClearingEmployeeId" style="border-bottom-style: solid; border-bottom-width: 1px; left: 100px; top: 60px; position: absolute; width: 250px"/>
                                                    <ice:outputText binding="#{Termination$ClearancePage.lblClearingJobPosition}" id="lblClearingJobPosition" style="border-bottom-style: solid; border-bottom-width: 1px; left: 100px; top: 90px; position: absolute; width: 250px"/>
                                                    <ice:outputText binding="#{Termination$ClearancePage.lblClearingDepartment}" id="lblClearingDepartment" style="border-bottom-style: solid; border-bottom-width: 1px; left: 460px; top: 90px; position: absolute; width: 250px"/>
                                                    <ice:outputText binding="#{Termination$ClearancePage.lblClearingFullName}" id="lblClearingFullName" style="border-bottom-style: solid; border-bottom-width: 1px; left: 460px; top: 60px; position: absolute; width: 250px"/>
                                                    <ice:outputText id="outputText2"
                                                        style="font-size: 18px; font-style: normal; font-weight: bold; left: 10px; top: 20px; position: absolute" value="For Authorized Department Staff Only."/>
                                                    <ice:commandButton action="#{Termination$ClearancePage.btnFinalizeClearance_action}"
                                                        binding="#{Termination$ClearancePage.btnFinalizeClearance}" disabled="true" id="btnFinalizeClearance"
                                                        style="left: 456px; top: 182px; position: absolute; width: 130px" value="#{msgst.btnFinalizeClearance}"/>
                                                    <ice:commandButton action="#{Termination$ClearancePage.btnFinalReport_action}"
                                                        binding="#{Termination$ClearancePage.btnFinalReport}" disabled="true" id="btnFinalReport"
                                                        rendered="false" style="left: 440px; top: 180px; position: absolute; width: 130px" value="Generate Report"/>
                                                </ice:panelLayout>
                                                <ice:outputLabel id="outputLabel2" style="font-size: 12px; left: 30px; top: 70px; position: absolute" value="#{msgst.FullName}"/>
                                                <ice:outputLabel id="outputLabel3" style="font-size: 12px; left: 30px; top: 110px; position: absolute" value="#{msgst.Position}"/>
                                                <ice:inputText action="#{Termination$ClearancePage.txtClearPosition_action}"
                                                    binding="#{Termination$ClearancePage.txtClearPosition}" disabled="true" id="txtClearPosition"
                                                    immediate="true" partialSubmit="true" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 105px; position: absolute; width: 357px"/>
                                                <ice:outputLabel id="outputLabel4" style="font-size: 12px; left: 35px; top: 174px; position: absolute" value="#{msgst.TerminationDueTo}"/>
                                                <ice:inputText binding="#{Termination$ClearancePage.txtClearDueTo}" disabled="true" id="txtClearDueTo"
                                                    immediate="true" partialSubmit="true" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 172px; position: absolute; width: 357px"/>
                                                <ice:outputLabel id="outputLabel5" style="font-size: 12px; left: 580px; top: 45px; position: absolute" value="#{msgst.EmployeePicture }"/>
                                                <ice:inputText binding="#{Termination$ClearancePage.txtClearFullName}" disabled="true" id="txtClearFullName"
                                                    immediate="true" partialSubmit="true" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 65px; position: absolute; width: 357px"/>
                                                <ice:outputLabel id="outputLabel6"
                                                    style="font-size: 12px; font-weight: bold; left: 59px; top: 366px; position: absolute" value="List Of Clearing Departments."/>
                                                <ice:selectBooleanCheckbox binding="#{Termination$ClearancePage.chkResign}" disabled="true" id="chkResign"
                                                    partialSubmit="true" rendered="false" style="left: 170px; top: 145px; position: absolute"/>
                                                <ice:selectBooleanCheckbox binding="#{Termination$ClearancePage.chkAgeLimit}" disabled="true" id="chkAgeLimit"
                                                    partialSubmit="true" rendered="false" style="left: 400px; top: 145px; position: absolute" value="#{Termination$ClearancePage.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                                <ice:selectBooleanCheckbox binding="#{Termination$ClearancePage.chkNonAgeLimit}" disabled="true"
                                                    id="chkNonAgeLimit" partialSubmit="true" rendered="false"
                                                    style="left: 170px; top: 185px; position: absolute" value="#{Termination$ClearancePage.selectBooleanCheckbox3Bean.selectedBoolean}"/>
                                                <ice:selectBooleanCheckbox binding="#{Termination$ClearancePage.chkTransfer}" disabled="true" id="chkTransfer"
                                                    partialSubmit="true" rendered="false" style="left: 400px; top: 185px; position: absolute" value="#{Termination$ClearancePage.selectBooleanCheckbox4Bean.selectedBoolean}"/>
                                                <ice:outputLabel id="outputLabel7" rendered="false"
                                                    style="font-size: 12px; left: 190px; top: 143px; position: absolute" value="Resignation "/>
                                                <ice:outputLabel id="outputLabel8" rendered="false"
                                                    style="font-size: 12px; left: 420px; top: 143px; position: absolute" value="Age Limit "/>
                                                <ice:outputLabel id="outputLabel9" rendered="false"
                                                    style="font-size: 12px; left: 190px; top: 183px; position: absolute" value="On Force Retirement"/>
                                                <ice:outputLabel id="outputLabel10" rendered="false"
                                                    style="font-size: 12px; left: 420px; top: 185px; position: absolute" value="Transfer "/>
                                                <ice:outputText id="outputText1"
                                                    style="font-family: Cambria; font-weight: bold; left: 30px; top: 290px; position: absolute; width: 719px" value="An Employee Clearance form is required for every separating employee, including employees transferring from one department to another and employees going on an extended leave of absence without pay ensuring the return of all Bunna International Bank owned items such as Id, and equipments; that access to Bunna International Bannk environment has been canceled."/>
                                                <ice:outputLabel id="outputLabel11"
                                                    style="font-size: 12px; font-weight: bold; left: 30px; top: 270px; position: absolute" value="Note :"/>
                                                <ice:graphicImage binding="#{Termination$ClearancePage.imgEmployeePicture}" height="194" id="imgEmployeePicture"
                                                    style="border: 1px solid rgb(153, 153, 153); left: 550px; top: 64px; position: absolute"
                                                    value="/Employee/images/blank.gif" width="172"/>
                                                <ice:outputLabel id="outputLabel12"
                                                    style="font-size: 12px; font-weight: bold; left: 59px; top: 606px; position: absolute" value="Select any row from the table above to see detail view of the department clearance."/>
                                                <ice:outputLabel id="outputLabel13"
                                                    style="font-size: 12px; font-weight: bold; left: 59px; top: 750px; position: absolute" value="Clearance information need to be considered while cleraing the selected employee."/>
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
                                            href="http://http://www.bunnabanksc.com" style="text-decoration:none;color:orange">Bunna International Bank |Information System Department |Software Division.</a> |</label>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                    <ice:panelPopup autoCentre="false" binding="#{Termination$ClearancePage.pnlPopUpClearingDepSetting}" clientOnly="true" draggable="true"
                        id="pnlPopUpClearingDepSetting" modal="true" rendered="false" style="display: block; height: 323px; left: 97px; top: 226px; position: absolute; width: 634px">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridPopUpResignTye" styleClass="popupHeaderWrapper">
                                <ice:outputText id="PopUpResignTyeTitle" style="width:400px" styleClass="popupHeaderText" value="Bunna Bank Human Resource Management System - Clearing Department Setting"/>
                                <ice:commandButton actionListener="#{Termination$ClearancePage.modalPnlCloseBtn_processAction}" alt="Close"
                                    id="modalPnlCloseBtn" image="/resources/images/close.gif" style="left: 614px; top: 2px; position: absolute"
                                    styleClass="popupHeaderImage" title="Close Popup" type="button"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="lblSelected" style="display: block; height: 256px; position: relative; width: 586" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="panelLayout16" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 234px; left: 22px; top: 13px; overflow: auto; position: absolute; width: 552px">
                                    <ice:dataTable binding="#{Termination$ClearancePage.tblClearingDep}" id="tblClearingDep" scrollFooter="true"
                                        scrollHeight="true" sortAscending="true" style="left: 5px; right: 5px; top: 5px; position: absolute"
                                        value="#{Termination$ClearancePage.availabledepartment}" var="currentRow" width="541">
                                        <ice:rowSelector id="rowSelector5" multiple="true" value="#{currentRow['status']}"/>
                                        <ice:column id="column5" style="width: 191px">
                                            <ice:outputText id="outputText9" value="#{currentRow['description']}"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText10" value="Available Departments"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column id="column7">
                                            <h:selectBooleanCheckbox binding="#{Termination$ClearancePage.ckboClearing}" id="ckboClearing"
                                                value="#{currentRow['status']}" valueChangeListener="#{Termination$ClearancePage.ckboClearing_processValueChange}"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText14" value="Select Clearing Department"/>
                                            </f:facet>
                                        </ice:column>
                                    </ice:dataTable>
                                </ice:panelLayout>
                                <ice:inputHidden id="lblHResignationTypeID"/>
                                <ice:outputLabel binding="#{Termination$ClearancePage.outputLabel1}" id="outputLabel1"/>
                                <ice:inputHidden binding="#{Termination$ClearancePage.inputHidden1}" id="inputHidden1" value="selected"/>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Termination$ClearancePage.pnMessage}" clientOnly="true" draggable="false" id="pnMessage"
                        modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnMessageTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Bannk Human Resource Management:Message"/>
                                <ice:commandLink action="#{Termination$ClearancePage.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage" immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlMessageBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{Termination$ClearancePage.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
