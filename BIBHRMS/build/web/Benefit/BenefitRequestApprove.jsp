<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : DavePro
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization_Benefit" var="msgsb"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Approve Benefit Payment Request </title>
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
                    function BenefitRequestPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1275" id="img" src="../resources/images/WholePageBG.png" width="1500"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Benefit$BenefitRequestApprove.panelBorder1Bean.renderCenter}"
                            renderEast="#{Benefit$BenefitRequestApprove.panelBorder1Bean.renderEast}"
                            renderNorth="#{Benefit$BenefitRequestApprove.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Benefit$BenefitRequestApprove.panelBorder1Bean.renderSouth}"
                            renderWest="#{Benefit$BenefitRequestApprove.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none; height:400px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px;top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; top :20px; left: 5px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Pending" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="Pending_Group_Header">
                                                        <ice:outputText id="lblPending" value="Pending"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="BoardPending" width="100%">
                                                    <ice:panelGroup id="Pending_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height:100px; width: 100%">
                                                        <ice:panelLayout id="PendingContainer" style="height: 93px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{Benefit$BenefitRequestApprove.selectPending}" id="selectPending"
                                                                partialSubmit="true" size="2"
                                                                style="height: 94px; left: 0px; top: 0px; position: relative; width: 190px"
                                                                validator="#{Benefit$BenefitRequestApprove.selectPending_validate}"
                                                                value="#{Benefit$BenefitRequestApprove.selectObjectOfPendingBean.selectedObject}" valueChangeListener="#{Benefit$BenefitRequestApprove.selectPending_processValueChange}">
                                                                <f:selectItems id="selectOneListboxPending" value="#{Benefit$BenefitRequestApprove.pendingRequestLists}"/>
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
                                                    <ice:panelGroup id="History_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:280px; width: 100%">
                                                        <ice:panelLayout id="HistoryStatusContainer" style="height: 285px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{Benefit$BenefitRequestApprove.selectMyHistoryLists}"
                                                                id="selectMyHistoryLists" partialSubmit="true" size="6" style="height: 240px; width: 190px"
                                                                value="#{Benefit$BenefitRequestApprove.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Benefit$BenefitRequestApprove.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{Benefit$BenefitRequestApprove.requestHistoryLists}"/>
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
                                <ice:panelGroup dragListener="#{Benefit$BenefitRequestApprove.page_display_processMyEvent}" id="page_display" style="height: 1100px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 1100px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 1100px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="APPROVE BENEFIT PAYMNET REQUEST"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 1057px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Benefit$BenefitRequestApprove.pnlGroupAll_processMyEvent}" id="pnlGroupAll"
                                                    style="height: 1030px; left: 0px; top: 0px; position: absolute" styleClass="filedset_border">
                                                    <ice:panelLayout id="pnlLayoutRequester" layout="flow"
                                                        style="height: 156px; margin-left: 15px; left: 9px; top: 45px; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:selectInputText action="#{Benefit$BenefitRequestApprove.txtRequesterFullName_action}"
                                                            binding="#{Benefit$BenefitRequestApprove.txtRequesterFullName}" disabled="true"
                                                            id="txtRequesterFullName" immediate="true" listValue="#{ApplicationBean1.list}"
                                                            listVar="employeeList" partialSubmit="true" rows="10"
                                                            style="left: 166px; top: 22px; position: absolute"
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="#{msgsb.requester}"/>
                                                        <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgsb.Department}"/>
                                                        <ice:outputLabel id="lblRequesterId" style="left: 456px; top: 24px; position: absolute" value="#{msgsb.Id}"/>
                                                        <ice:inputText binding="#{Benefit$BenefitRequestApprove.txtRequesterDepartment}" disabled="true"
                                                            id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{Benefit$BenefitRequestApprove.txtRequesterId}" disabled="true"
                                                            id="txtRequesterId" immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                        <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgsb.FullName}"/>
                                                        <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="#{msgsb.Position}"/>
                                                        <ice:inputText binding="#{Benefit$BenefitRequestApprove.txtRequesterPosition}" disabled="true"
                                                            id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterId" id="message1"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 480px; top: 24px; position: absolute; width: 46px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterFullName"
                                                            id="message7" infoClass="infoMessage"
                                                            style="height: 20px; left: 384px; top: 24px; position: absolute; width: 46px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterDepartment"
                                                            id="message8" infoClass="infoMessage"
                                                            style="height: 20px; left: 672px; top: 48px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterPosition"
                                                            id="message9" infoClass="infoMessage"
                                                            style="height: 20px; left: 672px; top: 96px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutRequestInfo" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 252px; margin-left: 15px; left: 9px; top: 216px; overflow: auto; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblAppliedDate" style="left: 24px; top: 168px; position: absolute" value="#{msgsb.remark}"/>
                                                        <ice:inputText binding="#{Benefit$BenefitRequestApprove.txtStartDate}" disabled="true" id="txtStartDate" style="left: 166px; top: 70px; position: absolute; width: 167px"/>
                                                        <ice:selectOneMenu binding="#{Benefit$BenefitRequestApprove.drlRequestType}" disabled="true"
                                                            id="drlRequestType" partialSubmit="true"
                                                            style="left: 168px; top: 48px; position: absolute; width: 167px"
                                                            value="#{Benefit$BenefitRequestApprove.selectObjectOfTerminationCatagory.selectedObject}" valueChangeListener="#{Benefit$BenefitRequestApprove.drlRequestType_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{Benefit$BenefitRequestApprove.subsidyLocation}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:inputTextarea binding="#{Benefit$BenefitRequestApprove.txtRemark}" disabled="true" id="txtRemark" style="left: 166px; top: 142px; position: absolute; width: 287px"/>
                                                        <ice:outputLabel id="lblDescription" style="left: 24px; top: 72px; position: absolute" value="#{msgsb.StrartDate}"/>
                                                        <ice:outputLabel id="lblTerminationCatagory" style="left: 24px; top: 96px; position: absolute" value="#{msgsb.EndDate}"/>
                                                        <ice:outputLabel id="lblPaidSlary" rendered="false" style="left: 408px; top: 120px; position: absolute" value="Penality Payment"/>
                                                        <ice:commandButton action="#{Benefit$BenefitRequestApprove.btnCalculatePenality_action}"
                                                            binding="#{Benefit$BenefitRequestApprove.btnCalculatePenality}" id="btnCalculatePenality"
                                                            rendered="false" style="left: 168px; top: 162px; position: absolute; width: 191px" value="Claculate Penality Payment"/>
                                                        <ice:inputText binding="#{Benefit$BenefitRequestApprove.txtPenality}" disabled="true" id="txtPenality"
                                                            rendered="false" style="left: 526px; top: 118px; position: absolute"/>
                                                        <ice:selectBooleanCheckbox binding="#{Benefit$BenefitRequestApprove.chksuccesisor}" id="chksuccesisor"
                                                            partialSubmit="true" rendered="false" style="position: absolute; left: 96px; top: 24px"
                                                            value="#{Benefit$BenefitRequestApprove.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Benefit$BenefitRequestApprove.chksuccesisor_processValueChange}"/>
                                                        <ice:outputLabel id="lblSuccesior" rendered="false" style="left: 144px; top: 24px; position: absolute" value="Does the Terminator has a Succesiosor?"/>
                                                        <ice:inputText binding="#{Benefit$BenefitRequestApprove.txtendDate}" disabled="true" id="txtendDate" style="left: 166px; top: 94px; position: absolute; width: 167px"/>
                                                        <ice:outputLabel id="lblTerminationCatagory1"
                                                            style="left: 24px; top: 48px; position: absolute; width: 93px" value="#{msgsb.requestType}"/>
                                                        <ice:inputText binding="#{Benefit$BenefitRequestApprove.txtAppliedDate}" disabled="true"
                                                            id="txtAppliedDate" style="left: 166px; top: 22px; position: absolute; width: 167px"/>
                                                        <ice:outputLabel id="lblDescription1" style="left: 24px; top: 24px; position: absolute" value="#{msgsb.AppliedDate}"/>
                                                        <ice:commandLink action="#{Benefit$BenefitRequestApprove.lnkViewPrevieousDecisions_action}"
                                                            id="lnkViewPrevieousDecisions1" style="left: 408px; top: 216px; position: absolute" value="View Status of this request"/>
                                                        <ice:inputText action="#{Benefit$BenefitRequestApprove.txtDepartment_action}"
                                                            binding="#{Benefit$BenefitRequestApprove.txtDepartment}" disabled="true" id="txtDepartment" style="left: 166px; top: 118px; position: absolute; width: 383px"/>
                                                        <ice:outputLabel id="lblRequesterDepartment1" style="left: 24px; top: 120px; position: absolute" value="#{msgsb.Department}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons" layout="flow" rendered="true"
                                                        style="height: 44px; margin-left: 15px; left: 9px; top: 960px; overflow: auto; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Benefit$BenefitRequestApprove.btnSave_action}"
                                                            binding="#{Benefit$BenefitRequestApprove.btnSave}" disabled="true" id="btnSave"
                                                            style="left: 264px; top: 0px; position: absolute; width: 71px" value="#{msgsb.btnSave}"/>
                                                        <ice:commandButton action="#{Benefit$BenefitRequestApprove.btnReset_action}"
                                                            binding="#{Benefit$BenefitRequestApprove.btnReset}" id="btnReset"
                                                            style="left: 360px; top: 0px; position: absolute; width: 70px" value="#{msgsb.btnReset}"/>
                                                    </ice:panelLayout>
                                                    <ice:selectInputDate binding="#{Benefit$BenefitRequestApprove.calTerminationDate}" id="calTerminationDate"
                                                        rendered="false"
                                                        style="height: 212px; left: 300px; top: 200px; position: absolute; width: 190px; z-index:50"
                                                        value="#{Benefit$BenefitRequestApprove.selectInputDate1Bean.date1}" valueChangeListener="#{Benefit$BenefitRequestApprove.calTerminationDate_processValueChange}"/>
                                                    <ice:selectInputDate binding="#{Benefit$BenefitRequestApprove.calAppliedDate}" id="calAppliedDate"
                                                        rendered="false" style="height: 212px; left: 117px; top: 150px; position: absolute; width: 190px"
                                                        value="#{Benefit$BenefitRequestApprove.selectInputDate1Bean.date1}" valueChangeListener="#{Benefit$BenefitRequestApprove.calAppliedDate_processValueChange}"/>
                                                    <!--/ice:panelLayout-->
                                                    <ice:panelLayout binding="#{Benefit$BenefitRequestApprove.pnlLayoutTree}" id="pnlLayoutTree" layout="flow"
                                                        rendered="false"
                                                        style="border-width: 2px; border-style: solid; height: 356px; left: 11px; top: 200px; overflow: scroll; position: absolute; width: 368px; -rave-layout: grid;z-index:50px" styleClass="insideContainerMain">
                                                        <ice:tree binding="#{Benefit$BenefitRequestApprove.tree}" id="tree"
                                                            style="height: 356px; margin-left: 0px; margin-top: 0px; left: 0px; top: 0px; position: absolute; text-align: left; width: 356px"
                                                            value="#{Benefit$BenefitRequestApprove.treeModel.model}" var="item">
                                                            <ice:treeNode binding="#{Benefit$BenefitRequestApprove.treeNode2}" id="treeNode2">
                                                                <f:facet name="icon">
                                                                    <ice:panelGroup binding="#{Benefit$BenefitRequestApprove.panelGroup1}" id="panelGroup1" style="display: inline;">
                                                                        <ice:graphicImage binding="#{Benefit$BenefitRequestApprove.graphicImage2}"
                                                                            id="graphicImage2" value="#{item.userObject.icon}"/>
                                                                    </ice:panelGroup>
                                                                </f:facet>
                                                                <f:facet name="content">
                                                                    <ice:panelGroup binding="#{Benefit$BenefitRequestApprove.panelGroup2}" id="panelGroup2" style="display: inline;">
                                                                        <ice:commandLink
                                                                            actionListener="#{Benefit$BenefitRequestApprove.cmdLnkTree_processAction}"
                                                                            binding="#{Benefit$BenefitRequestApprove.cmdLnkTree}" id="cmdLnkTree" partialSubmit="true">
                                                                            <ice:outputText id="outputText1" value="#{item.userObject.text}"/>
                                                                        </ice:commandLink>
                                                                    </ice:panelGroup>
                                                                </f:facet>
                                                            </ice:treeNode>
                                                        </ice:tree>
                                                    </ice:panelLayout>
                                                    <ice:outputLink id="outputLink1" value="outputLink"/>
                                                    <ice:panelLayout id="pnlLayoutDataTable1" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 276px; margin-left: 15px; left: 9px; top: 480px; overflow: auto; position: absolute; width: 708px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:dataTable id="dataTableEmployeeList"
                                                            style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                                            value="#{Benefit$BenefitRequestApprove.employeeList}" var="currentRow">
                                                            <ice:column id="colEmpId1">
                                                                <ice:outputText id="txtPopupForColumnBenefitName1" value="#{currentRow['empId']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupBenefitName1" value="EmpID"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelector1"
                                                                    selectionListener="#{Benefit$BenefitRequestApprove.rowSelector1_processAction}" value="#{currentRow['rendered']}"/>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplineTypeCode1">
                                                                <ice:outputText id="txtPopupForColumnBenefitType1" value="#{currentRow['fullName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextBenefitType1" value="Full Name"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column1">
                                                                <ice:outputText id="outputText4" value="#{currentRow['attendance']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText5" value="Attendance"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column2">
                                                                <ice:outputText id="outputText6" value="#{currentRow['rate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText7" value="Rate"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column3">
                                                                <ice:outputText id="outputText8" value="#{currentRow['totalAmount']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText9" value="Total Amount"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colEdit1" rendered="false">
                                                                <ice:commandLink action="#{Benefit$BenefitRequestApprove.cmdLnkEdit1_action}" id="cmdLnkEdit1" value="Ok"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextEdit1" value="Edit"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colRemove1" rendered="false">
                                                                <ice:commandLink action="#{Benefit$BenefitRequestApprove.cmdLnkRemove1_action}"
                                                                    id="cmdLnkRemove1" value="Remove"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextRemove1" value="Remove"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutDecider1" layout="flow"
                                                        style="height: 174px; margin-left: 15px; left: 9px; top: 768px; position: absolute; width: 697px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblDeciderDepartment1" style="left: 48px; top: 24px; position: absolute" value="#{msgsb.DeciderDepartment}"/>
                                                        <ice:outputLabel id="lblDeciderId1" style="left: 48px; top: 48px; position: absolute" value="#{msgsb.DeciderId}"/>
                                                        <ice:inputText binding="#{Benefit$BenefitRequestApprove.txtDeciderDepartment}" disabled="true"
                                                            id="txtDeciderDepartment" style="left: 166px; top: 22px; position: absolute"/>
                                                        <ice:inputText binding="#{Benefit$BenefitRequestApprove.txtDeciderId}" disabled="true" id="txtDeciderId" style="left: 166px; top: 46px; position: absolute"/>
                                                        <ice:outputLabel id="lblDeciderFullName1" style="left: 408px; top: 24px; position: absolute" value="#{msgsb.DeciderFullName}"/>
                                                        <ice:outputLabel id="deciderPosition1" style="left: 408px; top: 48px; position: absolute" value="#{msgsb.DeciderPosition}"/>
                                                        <ice:inputText binding="#{Benefit$BenefitRequestApprove.txtDeciderFullName}" disabled="true"
                                                            id="txtDeciderFullName" style="left: 526px; top: 22px; position: absolute; width: 147px"/>
                                                        <ice:inputText binding="#{Benefit$BenefitRequestApprove.txtDeciderPosition}" disabled="true"
                                                            id="txtDeciderPosition" style="left: 526px; top: 46px; position: absolute"/>
                                                        <ice:selectOneMenu binding="#{Benefit$BenefitRequestApprove.drlDecision}" id="drlDecision"
                                                            partialSubmit="true" style="height: 23px; left: 167px; top: 83px; position: absolute; width: 143px" value="#{Termination$TerminationApprovePage.selectedObjectOneMenuDecisionType.selectedObject}">
                                                            <f:selectItems id="selectDecisionAvailable1" value="#{Benefit$BenefitRequestApprove.availableDecisionsToMakeList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputLabel id="lblDecision1" style="left: 53px; top: 78px; position: absolute" value="#{msgsb.Decision}"/>
                                                        <ice:inputTextarea binding="#{Benefit$BenefitRequestApprove.txtaDeciderComment}" id="txtaDeciderComment" style="left: 166px; top: 118px; position: absolute; width: 496px"/>
                                                        <ice:outputLabel id="lblDeciderComment1" style="left: 48px; top: 120px; position: absolute" value="#{msgsb.Comment}"/>
                                                        <ice:commandLink action="#{Benefit$BenefitRequestApprove.lnkViewPrevieousDecisions_action}"
                                                            id="lnkViewPrevieousDecisions2" style="left: 432px; top: 96px; position: absolute" value="View decisions made on this request"/>
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
                                                href="http://www.google.com" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |INFORMATION SYSTEM DIVISION |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Benefit$BenefitRequestApprove.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Benefit$BenefitRequestApprove.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Benefit$BenefitRequestApprove.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Benefit$BenefitRequestApprove.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Benefit$BenefitRequestApprove.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupConfirmDelete" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText id="outputText3" style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Benefit$BenefitRequestApprove.btnPopupOkDelete_action}"
                                            binding="#{Benefit$BenefitRequestApprove.btnPopupOkDelete}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Benefit$BenefitRequestApprove.btnPopupCancelDelete_action}"
                                            binding="#{Benefit$BenefitRequestApprove.btnPopupCancelDelete}" id="btnPopupCancelDelete"
                                            style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Benefit$BenefitRequestApprove.pnlPopupConfirmViewRequest}" draggable="true"
                            id="pnlPopupConfirmViewRequest" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupConfirmViewRequest" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmViewRequestPopupHeader" value="BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmViewRequestBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmViewRequestBody">
                                        <ice:outputText id="outTxtConfirmViewRequest" style="left: 20px; top: 0px; position: absolute; width: 360px" value="THIS EMPLOYEE ALREADY POSTED REQUEST\nWANT TO VIEW THE REQUEST?"/>
                                        <ice:commandButton action="#{Benefit$BenefitRequestApprove.btnPopupConfirmViewRequestYes_action}"
                                            id="btnPopupConfirmViewRequestyes" style="left: 96px; top: 35px; position: absolute; width: 88px" value="Yes"/>
                                        <ice:commandButton action="#{Benefit$BenefitRequestApprove.btnPopupConfirmViewRequestNo_action}"
                                            id="btnPopupConfirmViewRequestNo" style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Benefit$BenefitRequestApprove.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - "/>
                                    <ice:commandButton action="#{Benefit$BenefitRequestApprove.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="left: 650px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Benefit$BenefitRequestApprove.decisionsMadeOnRequest}" var="currentRow">
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
