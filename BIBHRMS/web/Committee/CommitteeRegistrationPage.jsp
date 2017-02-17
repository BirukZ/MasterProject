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
                    function EyeWitnessesPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1000px" id="img" src="../resources/images/"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Committee$CommitteeRegistrationPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Committee$CommitteeRegistrationPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Committee$CommitteeRegistrationPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Committee$CommitteeRegistrationPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Committee$CommitteeRegistrationPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                        style="border-width: 1px; border-style: solid; border-color: rgb(200,200,200); height:770px;top:15px left: 3px;top:25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: 3px;top:2px; position: absolute; width: 213px" styleClass="left_menu">
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
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink id="lnkPayrollPeriodLists" style="color:#306682;font-weight:bold" value="Workflow Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="lnkPayrollSetUp" style="color:#306682;font-weight:bold" value="Workflow Group Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="lnkAccrualEntries" style="color:#306682;font-weight:bold" value="Workflow User Group Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="lnkPersonalDeductions" style="color:#306682;font-weight:bold" value="Workflow States Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="lnkGovernmentDeductions" style="color:#306682;font-weight:bold" value="Workflow Transition Page"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="Status"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height:322px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="position: absolute;height: 187px; width: 100%">
                                                            <ice:outputLabel id="lblMsgStatusForRequest"
                                                                style="color: white; font-weight: bold; margin-left: 20px; margin-top: 65px; left: 20px; position: absolute; width: 187px" value="Request History  Board"/>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height:790px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 775px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 760px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Committee Formation "/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 770px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelLayout binding="#{Committee$CommitteeRegistrationPage.pnProfile}" id="pnProfile" style="height: 770px; width: 100%">
                                                    <ice:panelGroup binding="#{Committee$CommitteeRegistrationPage.pnlGrpPowerDeligationContent}"
                                                        id="pnlGrpPowerDeligationContent" style="height: 686px" styleClass="icePnlGrp filedset_border">
                                                        <ice:panelLayout id="pnlLayoutDataTable"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 238px; margin-left: 15px; left: 20px; top: 318px; overflow: auto; position: absolute; width: 706px" styleClass="insideContainerMain">
                                                            <ice:dataTable id="dataTable"
                                                                style="height: 8px; left: 20px; top: 0px; overflow: auto; position: absolute"
                                                                value="#{Committee$CommitteeRegistrationPage.committeeLists}" var="currentRow" width="641">
                                                                <ice:column id="colCommitteeName">
                                                                    <ice:inputText id="optTxtForCommitteeName" value="#{currentRow['committeeName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerCommitteeName" value="Name"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colCommitteeType">
                                                                    <ice:selectOneMenu id="drlForCommitteeType" value="#{currentRow['committeeType']}">
                                                                        <f:selectItems id="selectOneMenuForCommitteeType" value="#{Committee$CommitteeRegistrationPage.committeeTypesListFromLu}"/>
                                                                    </ice:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerCommitteeType" value="Type"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colDescription">
                                                                    <ice:inputText id="txtForColumnDescription" value="#{currentRow['description']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextDescription" value="Description"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colResponsiblity">
                                                                    <ice:inputText id="txtForColumnResponsiblity" value="#{currentRow['responsiblity']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextResponsiblity" value="Responsiblity"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colFormerName">
                                                                    <ice:inputText id="optTxtForColumnFormerName" value="#{currentRow['formerName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextFormerName" value="Former Name"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colFormerDepartment">
                                                                    <ice:inputText id="optTxtForColumnFormerDepartment" value="#{currentRow['formerDepartment']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextFormerDepartment" value="FormerDepartment"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colFormerPosition">
                                                                    <ice:inputText id="optTxtForColumnFormerPosition" value="#{currentRow['formerPosition']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextFormerPosition" value="FormerPosition"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colEstablishedDate">
                                                                    <ice:inputText id="optTxtForColumnEstablishedDate" value="#{currentRow['establishedDate']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEstablishedDate" value="Est. Date"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelectorOverTime" multiple="false" preStyleOnSelection="true" selectionListener="#{Committee$CommitteeRegistrationPage.rowSelectorOverTime_processMyEvent}"/>
                                                                </ice:column>
                                                                <ice:column id="colCommitteeStatus">
                                                                    <ice:selectOneMenu id="drlForCommitteeStatus" value="#{currentRow['committeeStatus']}">
                                                                        <f:selectItems id="selectOneMenuForCommitteeStatus" value="#{Committee$CommitteeRegistrationPage.committeeStatusList}"/>
                                                                    </ice:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerCommitteeStatuse" value="Status"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colEdit">
                                                                    <ice:commandLink action="#{Committee$CommitteeRegistrationPage.cmdLnkOk_action}"
                                                                        id="cmdLnkOk" value="Ok"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEdit" value="Edit"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRemove">
                                                                    <ice:commandLink action="#{Committee$CommitteeRegistrationPage.cmdLnkRemove_action}"
                                                                        id="cmdLnkRemove" panelConfirmation="pnlConfirmForDelete" value="Remove"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextRemove" value="Remove"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 44px; margin-left: 15px; left: 20px; top: 560px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Committee$CommitteeRegistrationPage.btnSave_action}" id="btnSave"
                                                                style="left: 216px; top: 0px; position: absolute; width: 71px" value="Save"/>
                                                            <ice:commandButton action="#{Committee$CommitteeRegistrationPage.btnReset_action}" id="btnReset"
                                                                style="left: 336px; top: 0px; position: absolute; width: 71px" value="Reset"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutCommitteeAttributes" layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 261px; margin-left: 15px; left: 20px; top: 31px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblNamet" style="left: 360px; top: 0px; position: absolute" value="Name"/>
                                                            <ice:outputLabel id="lblEstablishedDate" style="left: 48px; top: 48px; position: absolute" value="Est. Date"/>
                                                            <ice:outputLabel id="lblCommitteeStatus" style="left: 360px; top: 48px; position: absolute" value="Status"/>
                                                            <ice:outputLabel id="lblCommitteeType" style="left: 49px; top: 11px; position: absolute" value="Type"/>
                                                            <ice:outputLabel id="lblResponsiblity" style="left: 30px; top: 144px; position: absolute" value="Responsiblity"/>
                                                            <ice:outputLabel id="lblDescription" style="left: 30px; top: 92px; position: absolute" value="Description"/>
                                                            <ice:inputText binding="#{Committee$CommitteeRegistrationPage.txtCommitteeName}"
                                                                id="txtCommitteeName" style="left: 431px; top: 10px; position: absolute; width: 191px"/>
                                                            <ice:selectOneMenu binding="#{Committee$CommitteeRegistrationPage.drlCommitteeType}"
                                                                id="drlCommitteeType" partialSubmit="true"
                                                                style="left: 120px; top: 12px; position: absolute; width: 141px" value="#{Committee$CommitteeRegistrationPage.selectOneMenu1Bean.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{Committee$CommitteeRegistrationPage.committeeTypesListFromLu}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Committee$CommitteeRegistrationPage.drlCommitteeStatus}"
                                                                id="drlCommitteeStatus" partialSubmit="true"
                                                                style="left: 430px; top: 46px; position: absolute; width: 193px" value="#{Committee$CommitteeRegistrationPage.selectedObjectCommitteeStatus.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{Committee$CommitteeRegistrationPage.committeeStatusList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputTextarea binding="#{Committee$CommitteeRegistrationPage.txtaDescription}"
                                                                id="txtaDescription" style="left: 118px; top: 74px; position: absolute; width: 503px"/>
                                                            <ice:inputText binding="#{Committee$CommitteeRegistrationPage.txtEstablishedDate}" disabled="true"
                                                                id="txtEstablishedDate" style="left: 118px; top: 46px; position: absolute; width: 143px"/>
                                                            <ice:inputTextarea binding="#{Committee$CommitteeRegistrationPage.txtaResponsiblity}"
                                                                id="txtaResponsiblity" style="left: 118px; top: 132px; position: absolute; width: 503px"/>
                                                            <ice:commandButton action="#{Committee$CommitteeRegistrationPage.btnCalEstablishedDate_action}"
                                                                id="btnCalEstablishedDate" image="/resources/images/cal_icon.JPG"
                                                                style="left: 264px; top: 46px; position: absolute" value="submit"/>
                                                            <ice:selectInputDate binding="#{Committee$CommitteeRegistrationPage.calEstablishedDate}"
                                                                id="calEstablishedDate" rendered="false"
                                                                style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                                                value="#{Committee$CommitteeRegistrationPage.selectInputDate1Bean.date1}" valueChangeListener="#{Committee$CommitteeRegistrationPage.calEstablishedDate_processValueChange}"/>
                                                            <ice:commandButton action="#{Committee$CommitteeRegistrationPage.btn_PopCommittee_action}"
                                                                id="btn_PopCommittee" style="left: 265px; top: 5px; position: absolute; width: 27px" value="+"/>
                                                            <ice:outputText id="outputText1" style="left: 24px; top: 192px; position: absolute" value="Former Name"/>
                                                            <ice:outputLabel binding="#{Committee$CommitteeRegistrationPage.out_txt_FormaerName}"
                                                                id="out_txt_FormaerName" style="left: 150px; top: 192px; position: absolute"/>
                                                            <ice:outputLabel id="outputLabel4" style="left: 360px; top: 192px; position: absolute" value="Former Position"/>
                                                            <ice:outputLabel binding="#{Committee$CommitteeRegistrationPage.out_txt_formerPosition}"
                                                                id="out_txt_formerPosition" style="left: 470px; top: 192px; position: absolute"/>
                                                            <ice:outputLabel id="outputLabel6" style="left: 24px; top: 226px; position: absolute" value="Former Department"/>
                                                            <ice:outputLabel binding="#{Committee$CommitteeRegistrationPage.out_txt_FormerDepartment}"
                                                                id="out_txt_FormerDepartment" style="left: 150px; top: 226px; position: absolute"/>
                                                        </ice:panelLayout>
                                                        <ice:commandButton action="#{Committee$CommitteeRegistrationPage.btnAddToTable_action}"
                                                            id="btnAddToTable" style="left: 635px; top: 284px; position: absolute" value="Add to table"/>
                                                    </ice:panelGroup>
                                                </ice:panelLayout>
                                                <ice:panelPopup autoCentre="true" binding="#{Committee$CommitteeRegistrationPage.pnlPopUp}" clientOnly="true"
                                                    draggable="true" id="pnlPopUp" modal="false" rendered="false"
                                                    style="height: 350px; left: 150px; top: 72px; position: absolute" styleClass="icePnlPop">
                                                    <f:facet name="header">
                                                        <ice:panelGroup id="pnlPopUpHdr" style="background-color: rgb(48, 102, 130); height: 24px; width: 600px" styleClass="icePnlGrp">
                                                            <ice:panelLayout id="pnlPopUpTtl" layout="flow" style="" styleClass="popUpHdrTtl">
                                                                <ice:outputText id="lblPopTitle" style="color: white" value="#{msgs.lblPopTitle}"/>
                                                            </ice:panelLayout>
                                                        </ice:panelGroup>
                                                    </f:facet>
                                                    <f:facet name="body">
                                                        <ice:panelLayout binding="#{Committee$CommitteeRegistrationPage.pnlContainer}" id="pnlContainer"
                                                            layout="flow"
                                                            style="display: block; height: 267px; left: 1px; top: 27px; position: absolute; width: 595px; -rave-layout: grid" styleClass="popUpBody">
                                                            <!--body element here-->
                                                            <ice:outputLabel id="outputLabel1" style="left: 72px; top: 24px; position: absolute" value="Commitee Name"/>
                                                            <ice:outputLabel id="outputLabel2" style="left: 72px; top: 72px; position: absolute" value="Describtion"/>
                                                            <ice:inputTextarea binding="#{Committee$CommitteeRegistrationPage.txt_commitedesc}"
                                                                id="txt_commitedesc" style="height: 119px; left: 142px; top: 70px; position: absolute; width: 383px"/>
                                                            <ice:inputText binding="#{Committee$CommitteeRegistrationPage.txt_CommiteeName}"
                                                                id="txt_CommiteeName" style="height: 24px; left: 190px; top: 22px; position: absolute; width: 335px"/>
                                                            <ice:commandButton action="#{Committee$CommitteeRegistrationPage.btn_Save_action}"
                                                                binding="#{Committee$CommitteeRegistrationPage.btn_Save}" id="btn_Save"
                                                                style="left: 240px; top: 206px; position: absolute" value="Save"/>
                                                            <ice:commandButton action="#{Committee$CommitteeRegistrationPage.btn_Close_action}"
                                                                binding="#{Committee$CommitteeRegistrationPage.btn_Close}" id="btn_Close"
                                                                image="/resources/images/close.gif"
                                                                style="left: 552px; top: 0px; position: absolute; width: 23px" value="X"/>
                                                        </ice:panelLayout>
                                                    </f:facet>
                                                </ice:panelPopup>
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
                        <ice:panelPopup autoCentre="true" binding="#{Committee$CommitteeRegistrationPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Committee$CommitteeRegistrationPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Committee$CommitteeRegistrationPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Committee$CommitteeRegistrationPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Committee$CommitteeRegistrationPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                    <ice:panelConfirmation acceptLabel="yes" cancelLabel="No" id="pnlConfirmForDelete" message="Are you sure you want to remove this recored ?"
                        rendered="true" title=" Confirm Remove "/>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
