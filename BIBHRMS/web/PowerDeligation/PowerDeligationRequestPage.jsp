<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : OffenderDeffencePage
    Created on : Jan 26, 2011, 7:48:31 AM
    Author     : mekete VS BravoZulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization_PowerDeligation" var="msgpw"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Power Deligation Request</title>
                <link href="../mugher_icon.gif" rel="icon"/>
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
            function EyeWitnessesPage(field){

                if (field.defaultValue == field.value) field.value = '';
                else if (field.value == '') field.value = field.defaultValue;

            }
        </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <!--img alt="" class="source-image" height="1000px" id="img" src="../resources/images/"/-->
                        <ice:panelBorder id="whole_page" renderCenter="#{PowerDeligation$PowerDeligationRequestPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{PowerDeligation$PowerDeligationRequestPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{PowerDeligation$PowerDeligationRequestPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{PowerDeligation$PowerDeligationRequestPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{PowerDeligation$PowerDeligationRequestPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none; height:470px; ">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(200,200,200); height:770px;top:15px left: 3px; top:25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: 3px; top:2px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="Search Area"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 120px; width: 100%">
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
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{PowerDeligation$PowerDeligationRequestPage.lnkPowDelApprove_action}"
                                                                id="lnkPowDelApprove" style="color:#306682;font-weight:bold" value="Approve"/>
                                                        </li>
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
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:210px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 213px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox id="selectRequestLists" partialSubmit="true" size="2"
                                                                style="height: 216px; width: 190px"
                                                                value="#{PowerDeligation$PowerDeligationRequestPage.selectedObjectRequestsByStatus.selectedObject}" valueChangeListener="#{PowerDeligation$PowerDeligationRequestPage.selectRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{PowerDeligation$PowerDeligationRequestPage.pendingRequestLists}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_history" style="border-style: none; height: 260px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="history_Group_Header">
                                                        <ice:outputText id="lblHistoryStatus" value="History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="HistoryStatusBoard" style="height: 180px" width="100%">
                                                    <ice:panelGroup id="History_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:178px; width: 100%">
                                                        <ice:panelLayout id="HistoryStatusContainer" style="height: 189px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox id="selectRequestHistoryLists" partialSubmit="true" size="6"
                                                                style="height: 168px; width: 190px"
                                                                value="#{PowerDeligation$PowerDeligationRequestPage.selectedObjectRequestsByHistory.selectedObject}" valueChangeListener="#{PowerDeligation$PowerDeligationRequestPage.selectRequestHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistorySelectItems" value="#{PowerDeligation$PowerDeligationRequestPage.requestHistoryLists}"/>
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
                                <ice:panelGroup id="page_display" style="height:890px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 875px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 860px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Power Deligation Request"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 790px; left: 22px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{PowerDeligation$PowerDeligationRequestPage.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 750px" styleClass="filedset_border">
                                                    <ice:panelLayout id="pnlLayoutDeligation"
                                                        style="height: 214px; left: 20px; top: 470px; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txtStartDate}" disabled="true"
                                                            id="txtStartDate" rendered="true" style="left: 166px; top: 30px; position: absolute"/>
                                                        <ice:outputLabel id="lblStartDate" style="left: 72px; top: 24px; position: absolute" value="#{msgpw.Startdate}"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txtEndDate}" disabled="true"
                                                            id="txtEndDate" readonly="true" style="left: 526px; top: 30px; position: absolute; width: 147px"/>
                                                        <ice:outputLabel id="lblEndDate" style="left: 408px; top: 24px; position: absolute" value="#{msgpw.EndDate}"/>
                                                        <ice:inputTextarea binding="#{PowerDeligation$PowerDeligationRequestPage.txtaReason}" id="txtaReason" style="left: 166px; top: 70px; position: absolute; width: 503px"/>
                                                        <ice:outputLabel id="lblReason" style="left: 72px; top: 72px; position: absolute" value="#{msgpw.Reason}"/>
                                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnCalendarSatartDate_action}"
                                                            id="btnCalendarSatartDate" image="images/cal_icon.JPG" immediate="true"
                                                            style="left: 312px; top: 30px; position: absolute" value="submit"/>
                                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnCalendarEndDate_action}"
                                                            binding="#{PowerDeligation$PowerDeligationRequestPage.btnCalendarEndDate}" id="btnCalendarEndDate"
                                                            image="images/cal_icon.JPG" immediate="true" style="left: 672px; top: 30px; position: absolute" value="submit"/>
                                                        <ice:outputLabel id="lblDeligatedPosition" style="left: 72px; top: 168px; position: absolute" value="#{msgpw.Position}"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txtDeligatedPosition}"
                                                            disabled="true" id="txtDeligatedPosition" style="left: 166px; top: 162px; position: absolute; width: 503px"/>
                                                        <ice:commandLink
                                                            action="#{PowerDeligation$PowerDeligationRequestPage.lnkRecordTakenAndRevokedDate_action}"
                                                            binding="#{PowerDeligation$PowerDeligationRequestPage.lnkRecordTakenAndRevokedDate}"
                                                            id="lnkRecordTakenAndRevokedDate" style="left: 24px; top: 192px; position: absolute" value="Record Taken And Revoked Date"/>
                                                        <ice:commandLink action="#{PowerDeligation$PowerDeligationRequestPage.lnkViewPrevieousDecisions_action}"
                                                            binding="#{PowerDeligation$PowerDeligationRequestPage.lnkViewPrevieousDecisions}"
                                                            id="lnkViewPrevieousDecisions" style="left: 240px; top: 192px; position: absolute" value="View status of this request"/>
                                                    <!--    <ice:outputLabel id="outputLabel3" style="left: 72px; top: 120px; position: absolute" value="#{msgpw.Weight}"/>-->
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txt_weight}" id="txt_weight"
                                                            rendered="false" style="left: 166px; top: 100px; position: absolute"/>
                                                      <!--  <ice:outputLabel id="outputLabel4" style="left: 192px; top: 130px; position: absolute" value="%"/>-->
                                                      <!--  <ice:outputText binding="#{PowerDeligation$PowerDeligationRequestPage.out_txt_wieht}" id="out_txt_wieht" style="left: 168px; top: 130px; position: absolute"/>-->
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txt_DocReferance}"
                                                            id="txt_DocReferance" style="left: 526px; top: 128px; position: absolute; width: 147px"/>
                                                        <ice:outputLabel id="outputLabel5" style="left: 408px; top: 130px; position: absolute" value="#{msgpw.Documentreferencenumber}"/>
                                                        <ice:commandLink action="#{PowerDeligation$PowerDeligationRequestPage.lnkViewBenefitPackage_action}"
                                                            id="lnkViewBenefitPackage" style="left: 432px; top: 192px; position: absolute" value="View benefit package "/>
                                                        <ice:selectBooleanCheckbox binding="#{PowerDeligation$PowerDeligationRequestPage.chk_EndDateCheak}"
                                                            id="chk_EndDateCheak" partialSubmit="true" style="left: 590px; top: 5px; position: absolute"
                                                            value="#{PowerDeligation$PowerDeligationRequestPage.defaultSelectedData5.selectedBoolean}" valueChangeListener="#{PowerDeligation$PowerDeligationRequestPage.chk_EndDateCheak_processValueChange}"/>
                                                        <ice:outputText id="outputText4" style="position: absolute; left: 480px; top: 0px" value="With Out EndDate"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutDeligator" layout="flow"
                                                        style=" height: 135px; left: 20px; top: 170px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:selectInputText action="#{PowerDeligation$PowerDeligationRequestPage.txtDeligatorFullName_action}"
                                                            binding="#{PowerDeligation$PowerDeligationRequestPage.txtDeligatorFullName}"
                                                            id="txtDeligatorFullName" immediate="true" listValue="#{ApplicationBean1.list}"
                                                            listVar="employeeList" partialSubmit="true" rows="10"
                                                            style="left: 166px; top: 22px; position: absolute"
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="215">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:outputLabel id="lblDeligator" style="left: 10px; top:4px; position: absolute" value="#{msgpw.Deligator}      "/>
                                                        <ice:outputLabel id="lblDeligatorDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgpw.Department}"/>
                                                        <ice:outputLabel id="lblDeligatorId" style="left: 456px; top: 24px; position: absolute" value="#{msgpw.ID}"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txtDeligatorDepartment}"
                                                            disabled="true" id="txtDeligatorDepartment" style="left: 166px; top: 60px; position: absolute; width: 377px"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txtDeligatorId}"
                                                            id="txtDeligatorId" immediate="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                        <ice:outputLabel id="lblDeligatorFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgpw.FullName}"/>
                                                        <ice:outputLabel id="lblDeligatorPosition" style="left: 48px; top: 96px; position: absolute" value="#{msgpw.Position}"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txtDeligatorPosition}"
                                                            disabled="true" id="txtDeligatorPosition" style="left: 166px; top: 94px; position: absolute; width: 377px"/>
                                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnSearchDeligator_action}"
                                                            id="btnSearchDeligator" image="/resources/images/fig_search.gif" rendered="true" style="left: 648px; top: 24px; position: absolute"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutRequester"
                                                        style="height: 135px;  left: 20px; top: 20px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:selectInputText action="#{PowerDeligation$PowerDeligationRequestPage.txtRequesterFullName_action}"
                                                            binding="#{PowerDeligation$PowerDeligationRequestPage.txtRequesterFullName}"
                                                            id="txtRequesterFullName" immediate="true" listValue="#{ApplicationBean1.list}"
                                                            listVar="employeeList" partialSubmit="true" rows="10"
                                                            style="left: 166px; top: 22px; position: absolute"
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="215">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="#{msgpw.Requester}"/>
                                                        <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgpw.Department}"/>
                                                        <ice:outputLabel id="lblRequesterId" style="left: 480px; top: 24px; position: absolute" value="#{msgpw.ID}"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txtRequesterDepartment}"
                                                            disabled="true" id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txtRequesterId}"
                                                            id="txtRequesterId" immediate="true" style="left: 550px; top: 22px; position: absolute; width: 124px"/>
                                                        <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgpw.FullName}"/>
                                                        <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="#{msgpw.Position}"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txtRequesterPosition}"
                                                            disabled="true" id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnSearchRequester_action}"
                                                            id="btnSearchRequester" image="/resources/images/fig_search.gif" rendered="true" style="left: 648px; top: 24px; position: absolute"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutDeligatee"
                                                        style=" height: 135px;  left: 20px; top: 320px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:selectInputText action="#{PowerDeligation$PowerDeligationRequestPage.txtDeligateeFullName_action}"
                                                            binding="#{PowerDeligation$PowerDeligationRequestPage.txtDeligateeFullName}"
                                                            id="txtDeligateeFullName" immediate="true" listValue="#{ApplicationBean1.list}"
                                                            listVar="employeeList" partialSubmit="true" rows="10"
                                                            style="left: 166px; top: 22px; position: absolute"
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="215">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:outputLabel id="lbltxtDeligatee" style="left: 10px; top:4px; position: absolute" value="#{msgpw.Deligatee}"/>
                                                        <ice:outputLabel id="lblDeligateeDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgpw.Department}"/>
                                                        <ice:outputLabel id="lblDeligateeId" style="left: 456px; top: 24px; position: absolute" value="#{msgpw.ID}"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txtDeligateeDepartment}"
                                                            disabled="true" id="txtDeligateeDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txtDeligateeId}"
                                                            id="txtDeligateeId" immediate="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                        <ice:outputLabel id="lblDeligateeFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgpw.FullName}"/>
                                                        <ice:outputLabel id="lblDeligateePosition" style="left: 48px; top: 96px; position: absolute" value="#{msgpw.Position}"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txtDeligateePosition}"
                                                            disabled="true" id="txtDeligateePosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnSearchDeligatee_action}"
                                                            binding="#{Discipline$DisciplineRequestPage.btnSearchDeligatee}" id="btnSearchDeligatee"
                                                            image="/resources/images/fig_search.gif" immediate="true" rendered="true" style="left: 648px; top: 24px; position: absolute"/>
                                                        <ice:selectBooleanCheckbox
                                                            binding="#{PowerDeligation$PowerDeligationRequestPage.checkboxDelegateStatus}"
                                                            id="checkboxDelegateStatus" partialSubmit="true" style="left: 622px; top: -65px; position: absolute"
                                                            value="#{PowerDeligation$PowerDeligationRequestPage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{PowerDeligation$PowerDeligationRequestPage.checkboxDelegateStatus_processValueChange}"/>
                                                        <ice:outputLabel id="outputLabel1"
                                                            style="height: 21px; left: 576px; top: -96px; position: absolute; width: 118px" value="#{msgpw.NewDepartment}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{PowerDeligation$PowerDeligationRequestPage.pnlLayoutButtons}"
                                                        id="pnlLayoutButtons" rendered="true"
                                                        style=" height: 45px; left: 20px; top: 690px;  position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnSaveOrEditOrUpdate_action}"
                                                            binding="#{PowerDeligation$PowerDeligationRequestPage.btnSaveOrEditOrUpdate}"
                                                            id="btnSaveOrEditOrUpdate" style="left: 200px; top: 0px; position: absolute; width: 71px" value="#{PowerDeligation$PowerDeligationRequestPage.newOrEditOrUpdateLabel}"/>
                                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnDelete_action}"
                                                            binding="#{PowerDeligation$PowerDeligationRequestPage.btnDelete}" disabled="true" id="btnDelete"
                                                            style="left: 300px; top: 0px; position: absolute; width: 71px" value="#{msgpw.Delete}"/>
                                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnReset_action}" id="btnReset"
                                                            style="left: 400px; top: 0px; position: absolute; width: 71px" value="#{msgpw.btnRest}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{PowerDeligation$PowerDeligationRequestPage.pnlLayoutTree}" id="pnlLayoutTree"
                                                        layout="flow" rendered="false"
                                                        style="border-width: 2px; border-style: solid; height: 356px; left: 11px; top: 78px; overflow: scroll; position: absolute; width: 264px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:tree binding="#{PowerDeligation$PowerDeligationRequestPage.treeOrgStructure}" id="tree"
                                                            style="height: 286px; margin-left: 0px; margin-top: 0px; left: 0px; top: 48px; position: absolute; text-align: left; width: 190px"
                                                            value="#{PowerDeligation$PowerDeligationRequestPage.treeModel.model}" var="item">
                                                            <ice:treeNode id="treeNode2">
                                                                <f:facet name="icon">
                                                                    <ice:panelGroup id="panelGroup1" style="display: inline;">
                                                                        <ice:graphicImage id="graphicImage2" value="#{item.userObject.icon}"/>
                                                                    </ice:panelGroup>
                                                                </f:facet>
                                                                <f:facet name="content">
                                                                    <ice:panelGroup id="panelGroup2" style="display: inline;">
                                                                        <ice:commandLink
                                                                            actionListener="#{PowerDeligation$PowerDeligationRequestPage.cmdLnkTree_processAction}"
                                                                            id="cmdLnkTree" partialSubmit="true">
                                                                            <ice:outputText id="outputText1" value="#{item.userObject.text}"/>
                                                                        </ice:commandLink>
                                                                    </ice:panelGroup>
                                                                </f:facet>
                                                            </ice:treeNode>
                                                        </ice:tree>
                                                    </ice:panelLayout>
                                                    <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnResetHistory_action}"
                                                        binding="#{PowerDeligation$PowerDeligationRequestPage.btnResetHistory}" id="btnResetHistory"
                                                        rendered="false" style="left: 350px; top: 525px; position: absolute" value="Reset"/>
                                                    <ice:panelPopup binding="#{PowerDeligation$PowerDeligationRequestPage.popup_OrganazationSturctue}"
                                                        clientOnly="true" draggable="false" id="popup_OrganazationSturctue" modal="false" rendered="false"
                                                        style="border-style: none; background-color: transparent; display: block; height: 470px; left: 30px; top: 200px; position: absolute; width: 667px" styleClass="message">
                                                        <f:facet name="header">
                                                            <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                                                <ice:outputText id="pnMessageTitle"
                                                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:OrganazationStructure"/>
                                                                <ice:commandLink
                                                                    action="#{PowerDeligation$PowerDeligationRequestPage.btnClosePopupOrganzation_action}"
                                                                    id="btnClosePopupOrganazation" immediate="true"
                                                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                                                    styleClass="popupHeaderImage" title="Close Popup"/>
                                                            </ice:panelGroup>
                                                        </f:facet>
                                                        <f:facet name="body">
                                                            <ice:panelGroup binding="#{PowerDeligation$PowerDeligationRequestPage.organzationSturcture}"
                                                                id="organzationSturcture"
                                                                style="display: block; height: 450px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                                                <ice:panelLayout binding="#{PowerDeligation$PowerDeligationRequestPage.organzationMessageBody}"
                                                                    id="organzationMessageBody" layout="flow"
                                                                    style="background-color: rgb(245, 245, 245); display: block; height: 450px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                                                    <ice:tree binding="#{PowerDeligation$PowerDeligationRequestPage.tree1}" id="tree1"
                                                                        style="height: 286px; margin-left: 0px; margin-top: 0px; text-align: left; width: 190px"
                                                                        value="#{PowerDeligation$PowerDeligationRequestPage.tree1Model.model}" var="item">
                                                                        <ice:treeNode id="treeNode1">
                                                                            <f:facet name="icon">
                                                                                <ice:panelGroup id="panelGroup1" style="display: inline;">
                                                                                <ice:graphicImage id="graphicImage1" value="#{item.userObject.icon}"/>
                                                                                </ice:panelGroup>
                                                                            </f:facet>
                                                                            <f:facet name="content">
                                                                                <ice:panelGroup id="panelGroup2" style="display: inline;">
                                                                                <ice:commandLink
                                                                                actionListener="#{PowerDeligation$PowerDeligationRequestPage.commandLink1_processActionNew}"
                                                                                id="commandLink1" partialSubmit="true">
                                                                                <ice:outputText id="outputText2" value="#{item.userObject.text}"/>
                                                                                </ice:commandLink>
                                                                                </ice:panelGroup>
                                                                            </f:facet>
                                                                        </ice:treeNode>
                                                                    </ice:tree>
                                                                    <ice:selectOneMenu binding="#{PowerDeligation$PowerDeligationRequestPage.drl_Position}"
                                                                        id="drl_Position" partialSubmit="true"
                                                                        style="left: 466px; top: 5px; position: absolute; width: 155px"
                                                                        value="#{PowerDeligation$PowerDeligationRequestPage.defaultSelectedData2.selectedObject}" valueChangeListener="#{PowerDeligation$PowerDeligationRequestPage.drl_Position_processValueChange}">
                                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{PowerDeligation$PowerDeligationRequestPage.perofation}"/>
                                                                    </ice:selectOneMenu>
                                                                    <ice:outputLabel id="outputLabel2" style="left: 416px; top: 6px; position: absolute" value="Position"/>
                                                                </ice:panelLayout>
                                                            </ice:panelGroup>
                                                        </f:facet>
                                                    </ice:panelPopup>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                            <ice:selectInputDate binding="#{PowerDeligation$PowerDeligationRequestPage.calStartDate}" id="calStartDate"
                                                popupDateFormat="yyyy-MM-DD" renderMonthAsDropdown="true" rendered="false"
                                                style="height: 117px; left: 166px; top: 400px; position: absolute; width: 190px"
                                                value="#{PowerDeligation$PowerDeligationRequestPage.selectInputDateSatrtDate.date1}" valueChangeListener="#{PowerDeligation$PowerDeligationRequestPage.calStartDate_processValueChange}"/>
                                            <ice:selectInputDate binding="#{PowerDeligation$PowerDeligationRequestPage.calEndDate}" id="calEndDate"
                                                popupDateFormat="yyyy/MM/dd" renderMonthAsDropdown="true" rendered="false"
                                                style="height: 117px; left: 485px; top: 400px; position: absolute; width: 190px"
                                                value="#{PowerDeligation$PowerDeligationRequestPage.selectInputDateEndDate.date1}" valueChangeListener="#{PowerDeligation$PowerDeligationRequestPage.calEndDate_processValueChange}"/>
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
                        <ice:panelPopup autoCentre="true" binding="#{PowerDeligation$PowerDeligationRequestPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnOrganazationMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageOrganzationTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{PowerDeligation$PowerDeligationRequestPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{PowerDeligation$PowerDeligationRequestPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{PowerDeligation$PowerDeligationRequestPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{PowerDeligation$PowerDeligationRequestPage.lblSuccessOrErrorMessage}"
                                            id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{PowerDeligation$PowerDeligationRequestPage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{PowerDeligation$PowerDeligationRequestPage.outputTextConfirmDelete}"
                                            id="outputTextConfirmDelete" style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnPopupCancelDelete_action}"
                                            id="btnPopupCancelDelete" style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{PowerDeligation$PowerDeligationRequestPage.pnlPopupViewPrevieousDecisions}"
                            draggable="true" id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - "/>
                                    <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="left: 650px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style=" height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style=" height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTable" style="left: 0px; top: 0px; height:8px; position: absolute"
                                            value="#{PowerDeligation$PowerDeligationRequestPage.decisionsMadeOnRequestList}" var="currentRow">
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
                        <ice:panelPopup autoCentre="true" binding="#{PowerDeligation$PowerDeligationRequestPage.pnlPopupViewBenefitePakage}" draggable="true"
                            id="pnlPopupViewBenefitePakage" modal="true" rendered="false" style="height: 261px; left: 150px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupBenefitePakage" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="viewBenefitePakage" style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - "/>
                                    <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnCloseViewBenefitePakage_action}"
                                        id="btnClosePopupBenfitePakage" style="left: 650px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewBenefitePakage" style=" height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTablebenefite" style=" height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableBenefite" style="left: 0px; top: 0px; height:8px; position: absolute"
                                            value="#{PowerDeligation$PowerDeligationRequestPage.benefitePakage}" var="currentRow">
                                            <ice:column id="colName">
                                                <ice:outputText id="optTxtForColumnName" value="#{currentRow['benefiteName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextName" value="Benefit Name"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colBenefitValue">
                                                <ice:outputText id="optTxtBenefitValue" value="#{currentRow['benefiteValue']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerBenefitValue" value="Benefit Value"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colBenefitDuration">
                                                <ice:outputText id="optTxtForBenefitDuration" value="#{currentRow['benefiteDuration']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextBenefitDuration" value="Benefit Duration"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPercent">
                                                <ice:outputText id="optTxtForPercent" value="#{currentRow['inpercent']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPercent" value="In Pencent"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colMontaryValue">
                                                <ice:outputText id="optTxtForMontaryValue" value="#{currentRow['monetaryValue']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextMontary" value="Montary Value"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colpercentValue">
                                                <ice:outputText id="optTxtForpercentValue" value="#{currentRow['percent']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextDate" value="Percent Value"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{PowerDeligation$PowerDeligationRequestPage.pnlPopupRegisterTakenRevokedDate}"
                            draggable="true" id="pnlPopupRegisterTakenRevokedDate" modal="true" rendered="false" style="height: 261px;  position: absolute; width: 645px">
                            <f:facet name="header">
                                <ice:panelGrid id="pnlGrdRegisterTakenRevokedDate" style="display: block; height: 20px" width="610">
                                    <ice:outputText id="otxtRegisterTakenRevokedDateHeader"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA HRMS : SET START OR END DATE "/>
                                    <ice:commandLink action="#{PowerDeligation$PowerDeligationRequestPage.cmdLnkClosePopupRegisterTakenRevokedDate_action}"
                                        id="cmdLnkClosePopupRegisterTakenRevokedDate" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 621px; top: 3px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupRegisterTakenRevokedDateBody" style="display: block; height: 206px; top: 20px" width="610">
                                    <ice:panelLayout id="pnlLayoutRegisterTakenRevokedDateBody" layout="flow">
                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txtTakenRevokedStartDate}" disabled="true"
                                            id="txtTakenRevokedStartDate" immediate="true" rendered="true" style="left: 90px; top: 60px; position: absolute"/>
                                        <ice:outputLabel id="lblTakenRevokedStartDate" style="left: 30px; top:60px; position: absolute" value="StartDay"/>
                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationRequestPage.txtTakenRevokedEndDate}" disabled="true"
                                            id="txtTakenRevokedEndDate" immediate="true" style="left: 406px; top: 60px; position: absolute; width: 147px"/>
                                        <ice:outputLabel id="lblTakenRevokedEndDate" style="left: 336px; top: 60px;position: absolute" value="EndDate"/>
                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnTakenRevokedCalendarSatartDate_action}"
                                            id="btnTakenRevokedCalendarSatartDate" image="images/cal_icon.JPG" immediate="true"
                                            style="left: 240px; top: 60px; position: absolute" value="submit"/>
                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnTakenRevokedCalendarEndDate_action}"
                                            id="btnTakenRevokedCalendarEndDate" image="images/cal_icon.JPG" immediate="true"
                                            style="left: 552px; top: 60px; position: absolute" value="submit"/>
                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnPopupSaveTakenRevokedDate_action}"
                                            id="btnPopupSaveTakenRevokedDate" style="left: 216px; top: 90px; position: absolute; width: 88px" value="Save"/>
                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnReseTakenRevokedDate_action}"
                                            id="btnReseTakenRevokedDate" style="left: 312px; top: 90px; position: absolute; width: 96px" value="Reset"/>
                                        <ice:selectInputDate binding="#{PowerDeligation$PowerDeligationRequestPage.calTakenRevokedStartDate}"
                                            id="calTakenRevokedStartDate" rendered="false"
                                            style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                            value="#{PowerDeligation$PowerDeligationRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{PowerDeligation$PowerDeligationRequestPage.calTakenRevokedStartDate_processValueChange}"/>
                                        <ice:selectInputDate binding="#{PowerDeligation$PowerDeligationRequestPage.calTakenRevokedEndDate}"
                                            id="calTakenRevokedEndDate" rendered="false"
                                            style="left: 324px; top: 16px; position: absolute; height:212px; width: 190px"
                                            value="#{PowerDeligation$PowerDeligationRequestPage.selectInputDateBean2.date1}" valueChangeListener="#{PowerDeligation$PowerDeligationRequestPage.calTakenRevokedEndDate_processValueChange}"/>
                                        <ice:outputText binding="#{PowerDeligation$PowerDeligationRequestPage.outTxtCurrentStatus}" id="outTxtCurrentStatus"
                                            style="font-size: 16px; font-weight: bold; left: 48px; top: -30px; position: absolute; width: 550px" value="                                        "/>
                                        <ice:outputLabel id="outputLabel6" value="ExpireDelegation"/>
                                        <ice:selectBooleanCheckbox binding="#{PowerDeligation$PowerDeligationRequestPage.chk_ExpireDelegation}"
                                            id="chk_ExpireDelegation" partialSubmit="true"
                                            value="#{PowerDeligation$PowerDeligationRequestPage.defaultSelectedData3.selectedBoolean}" valueChangeListener="#{PowerDeligation$PowerDeligationRequestPage.chk_ExpireDelegation_processValueChange}"/>
                                        <ice:outputLabel id="outputLabel7" style="left: 168px;" value="Extend Delegation"/>
                                        <ice:selectBooleanCheckbox binding="#{PowerDeligation$PowerDeligationRequestPage.chk_ExtendDelegation}"
                                            id="chk_ExtendDelegation" partialSubmit="true"
                                            value="#{PowerDeligation$PowerDeligationRequestPage.defaultSelectedData4.selectedBoolean}" valueChangeListener="#{PowerDeligation$PowerDeligationRequestPage.chk_ExtendDelegation_processValueChange}"/>
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
