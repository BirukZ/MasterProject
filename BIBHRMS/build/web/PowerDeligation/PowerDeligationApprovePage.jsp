<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : PowerDeligationApprovePage
    Created on : Jan 26, 2011, 7:48:31 AM
    Author     : BravoZulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization_PowerDeligation" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Power Deligation Decision</title>
               <!-- <link href="../mugher_icon.ico" rel="icon"/>-->
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
                    function EyeWitnessesPage(field){
                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;
                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{PowerDeligation$PowerDeligationApprovePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{PowerDeligation$PowerDeligationApprovePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{PowerDeligation$PowerDeligationApprovePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{PowerDeligation$PowerDeligationApprovePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{PowerDeligation$PowerDeligationApprovePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                        style="border-width: 1px; border-style: solid; border-color: rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200); height: 933px; top: 25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: 3px;top:2px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="&quot;&quot;"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 250px; width: 100%">
                                                        <ice:outputText id="outputText19" value=""/>
                                                        <ice:outputText id="outputText1" value=""/>
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
                                                            <ice:commandLink
                                                                action="#{PowerDeligation$PowerDeligationApprovePage.lnkPowerDeligationRequest_action}"
                                                                id="lnkPowerDeligationRequest" style="color:#306682;font-weight:bold" value="Deligation Request Page"/>
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
                                                            <ice:selectOneListbox id="selectOneListboxRequestListsByStatus" partialSubmit="true" size="2"
                                                                style="height: 216px; width: 190px"
                                                                value="#{PowerDeligation$PowerDeligationApprovePage.selectedObjectListboxRequestByStatus.selectedObject}" valueChangeListener="#{PowerDeligation$PowerDeligationApprovePage.selectAllRequestListsByStatus_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestLists1" value="#{PowerDeligation$PowerDeligationApprovePage.approvableRequests}"/>
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
                                                                value="#{PowerDeligation$PowerDeligationApprovePage.selectedObjectRequestsByHistory.selectedObject}" valueChangeListener="#{PowerDeligation$PowerDeligationApprovePage.selectRequestHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistorySelectItems" value="#{PowerDeligation$PowerDeligationApprovePage.requestHistoryLists}"/>
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
                                <ice:panelGroup id="page_display" style="height:1100px">
                                    <ice:panelLayout binding="#{PowerDeligation$PowerDeligationApprovePage.container}" id="container" layout="flow"
                                        style="height: 1050px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 1000px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Delegation Approve"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 900px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="PowerDeligationContent" style="height: 900px" styleClass="filedset_border">
                                                    <ice:panelLayout id="pnlLayoutRequester"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 135px; margin-left: 15px; left: 20px; top: 320px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtRequesterFullName}"
                                                            disabled="true" id="txtRequesterFullName" style="left: 166px; top: 20px; position: absolute; width: 239px"/>
                                                        <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="Requester"/>
                                                        <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="Department"/>
                                                        <ice:outputLabel id="lblRequesterId" style="left: 480px; top: 24px; position: absolute" value="Id"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtRequesterDepartment}"
                                                            disabled="true" id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtRequesterId}" disabled="true"
                                                            id="txtRequesterId" immediate="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                        <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="FullName"/>
                                                        <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="Position"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtRequesterPosition}"
                                                            disabled="true" id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutDeligator"
                                                        style="border-width: 1px; border-style: solid; border-color:  rgb(204, 204, 204); height: 140px; margin-left: 15px; left: 20px; top: 30px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblDeligator" style="left: 10px; top:4px; position: absolute" value="Deligator"/>
                                                        <ice:outputLabel id="lblDeligatorDepartment" style="left: 48px; top: 62px; position: absolute" value="Department"/>
                                                        <ice:outputLabel id="lblDeligatorId" style="left: 480px; top: 24px; position: absolute" value="Id"/>
                                                        <ice:outputLabel id="lblDeligatorFullName" style="left: 48px; top: 24px; position: absolute" value="FullName"/>
                                                        <ice:outputLabel id="lblDeligatorPosition" style="left: 48px; top: 96px; position: absolute" value="Position"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtDeligatorDepartment}"
                                                            disabled="true" id="txtDeligatorDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtDeligatorId}" disabled="true"
                                                            id="txtDeligatorId" style="left: 526px; top: 22px; position: absolute; width: 143px"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtDeligatorFullName}"
                                                            disabled="true" id="txtDeligatorFullName" style="left: 166px; top: 22px; position: absolute; width: 239px"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtDeligatorPosition}"
                                                            disabled="true" id="txtDeligatorPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutDeligatee"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 144px; margin-left: 15px; left: 20px; top: 180px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblDeligatee" style="left: 10px; top:4px; position: absolute" value="Deligatee"/>
                                                        <ice:outputLabel id="lblDeligateeDepartment" style="left: 48px; top: 62px; position: absolute" value="Department"/>
                                                        <ice:outputLabel id="lblDeligateeId" style="left: 480px; top: 24px; position: absolute" value="Id"/>
                                                        <ice:outputLabel id="lblDeligateeFullName" style="left: 48px; top: 24px; position: absolute" value="FullName"/>
                                                        <ice:outputLabel id="lblDeligateePosition" style="left: 48px; top: 96px; position: absolute" value="Position"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtDeligateeDepartment}"
                                                            disabled="true" id="txtDeligateeDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtDeligateeId}" disabled="true"
                                                            id="txtDeligateeId" style="left: 526px; top: 22px; position: absolute; width: 143px"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtDeligateeFullName}"
                                                            disabled="true" id="txtDeligateeFullName" style="left: 166px; top: 22px; position: absolute; width: 239px"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtDeligateePosition}"
                                                            disabled="true" id="txtDeligateePosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutDeligation" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 148px; margin-left: 15px; left: 20px; top: 465px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtStartDate}" disabled="true"
                                                            id="txtStartDate" style="left: 166px; top: 10px; position: absolute"/>
                                                        <ice:outputLabel id="lblStartDate1" style="left: 72px; top: 10px; position: absolute" value="StartDay"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtEndDate}" disabled="true"
                                                            id="txtEndDate" style="left: 526px; top: 10px; position: absolute; width: 143px"/>
                                                        <ice:outputLabel id="lblEndDate1" style="left: 408px; top: 10px; position: absolute" value="EndDate"/>
                                                        <ice:inputTextarea binding="#{PowerDeligation$PowerDeligationApprovePage.txtaReason}" disabled="true"
                                                            id="txtaReason" style="left: 166px; top: 40px; position: absolute; width: 503px"/>
                                                        <ice:outputLabel id="lblReason1" style="left: 72px; top: 48px; position: absolute" value="Reason"/>
                                                        <ice:outputLabel id="lblDeligatedPosition" style="left: 72px; top: 96px; position: absolute" value="Position"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtDeligatedPosition}"
                                                            disabled="true" id="txtDeligatedPosition" style="left: 166px; top: 95px; position: absolute; width: 503px"/>
                                                        <ice:outputLabel id="outputLabel1" style="left: 72px; top: 120px; position: absolute" value="Delegation Wieght"/>
                                                        <ice:outputLabel binding="#{PowerDeligation$PowerDeligationApprovePage.out_wieght}" id="out_wieght" style="left: 192px; top: 120px; position: absolute"/>
                                                        <ice:outputLabel id="outputLabel3" style="left: 216px; top: 120px; position: absolute" value="%"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txt_DocRefNumber}" disabled="true"
                                                            id="txt_DocRefNumber" style="position: absolute; left: 526px; top: 120px"/>
                                                        <ice:outputLabel id="outputLabel2" style="position: absolute; left: 408px; top: 120px" value="Doc.Refe.No"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutDecider" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color:  rgb(204, 204, 204); height: 200px; margin-left: 15px; left: 20px; top: 620px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblDeciderDepartment" style="left: 48px; top: 24px; position: absolute" value="DeciderDepartment"/>
                                                        <ice:outputLabel id="lblDeciderId" style="left: 48px; top: 48px; position: absolute" value="DeciderId"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtDeciderDepartment}"
                                                            disabled="true" id="txtDeciderDepartment" style="left: 166px; top: 22px; position: absolute"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtDeciderId}" disabled="true"
                                                            id="txtDeciderId" style="left: 166px; top: 46px; position: absolute"/>
                                                        <ice:outputLabel id="lblDeciderFullName" style="left: 408px; top: 24px; position: absolute" value="DeciderFullName"/>
                                                        <ice:outputLabel id="deciderPosition" style="left: 408px; top: 48px; position: absolute" value="DeciderPosition"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtDeciderFullName}"
                                                            disabled="true" id="txtDeciderFullName" style="left: 526px; top: 22px; position: absolute"/>
                                                        <ice:inputText binding="#{PowerDeligation$PowerDeligationApprovePage.txtDeciderPosition}"
                                                            disabled="true" id="txtDeciderPosition" style="left: 526px; top: 46px; position: absolute"/>
                                                        <ice:selectOneMenu binding="#{PowerDeligation$PowerDeligationApprovePage.drlDecision}" id="drlDecision"
                                                            partialSubmit="true" style="height: 23px; left: 166px; top: 94px; position: absolute; width: 143px"
                                                            value="#{PowerDeligation$PowerDeligationApprovePage.selectedObjectOneMenuDecisionType.selectedObject}" valueChangeListener="#{PowerDeligation$PowerDeligationApprovePage.drlDecision_processValueChange}">
                                                            <f:selectItems id="selectDecisionAvailable" value="#{PowerDeligation$PowerDeligationApprovePage.availableDecisionsToMakeList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputLabel id="lblDecision" style="left: 48px; top: 96px; position: absolute" value="Decision"/>
                                                        <ice:inputTextarea binding="#{PowerDeligation$PowerDeligationApprovePage.txtaDeciderComment}"
                                                            id="txtaDeciderComment" style="left: 166px; top: 130px; position: absolute; width: 503px"/>
                                                        <ice:outputLabel id="lblDeciderComment" style="left: 48px; top: 144px; position: absolute" value="Comment"/>
                                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationApprovePage.btnSearchDecider_action}"
                                                            id="btnSearchDecider" style="left: 319px; top: 38px; position: absolute" value="#{PowerDeligation$PowerDeligationApprovePage.changeOrSearchDeciderButtonLabel}"/>
                                                        <ice:commandLink action="#{PowerDeligation$PowerDeligationApprovePage.lnkViewPrevieousDecisions_action}"
                                                            binding="#{PowerDeligation$PowerDeligationApprovePage.lnkViewPrevieousDecisions}"
                                                            id="lnkViewPrevieousDecisions"
                                                            style="color:#306682;font-weight:bold; left: 480px; top: 84px; position: absolute" value="View status of  this request"/>
                                                        <ice:commandLink action="#{PowerDeligation$PowerDeligationApprovePage.lnkViewBenefitePackage_action}"
                                                            id="lnkViewBenefitePackage" style="position: absolute; left: 480px; top: 105px" value="View Benefit Package"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons"
                                                        style="border-width: 1px; border-style: solid; border-color:  rgb(204, 204, 204); height: 44px; margin-left: 15px; left: 20px; top: 830px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationApprovePage.btnPostDecision_action}"
                                                            binding="#{PowerDeligation$PowerDeligationApprovePage.btnPostDecision}" disabled="true"
                                                            id="btnPostDecision" style="left: 216px; top: 0px; position: absolute; width: 71px" value="Post"/>
                                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationApprovePage.btnReset_action}" id="btnReset"
                                                            style="left: 336px; top: 0px; position: absolute; width: 71px" value="#{msgs.Reset}"/>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
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
                        <ice:panelPopup autoCentre="true" binding="#{PowerDeligation$PowerDeligationRequestPage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value=" BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{PowerDeligation$PowerDeligationRequestPage.outputText3}" id="outputText3"
                                            style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{PowerDeligation$PowerDeligationRequestPage.btnPopupCancelDelete_action}"
                                            id="btnPopupCancelDelete" style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{PowerDeligation$PowerDeligationApprovePage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{PowerDeligation$PowerDeligationApprovePage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{PowerDeligation$PowerDeligationApprovePage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{PowerDeligation$PowerDeligationApprovePage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{PowerDeligation$PowerDeligationApprovePage.lblSuccessOrErrorMessage}"
                                            id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{PowerDeligation$PowerDeligationApprovePage.pnlPopupViewPrevieousDecisions}"
                            draggable="true" id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA INTERNATIONAL BANK HRMS - View request status "/>
                                    <ice:commandLink action="#{PowerDeligation$PowerDeligationApprovePage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{PowerDeligation$PowerDeligationApprovePage.decisionsMadeOnRequestList}" var="currentRow">
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
                        <ice:panelPopup autoCentre="true" binding="#{PowerDeligation$PowerDeligationApprovePage.pnlPopupViewBenefitePakage}" draggable="true"
                            id="pnlPopupViewBenefitePakage" modal="true" rendered="false" style="height: 261px; left: 150px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupBenefitePakage" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="viewBenefitePakage" style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - "/>
                                    <ice:commandButton action="#{PowerDeligation$PowerDeligationApprovePage.btnCloseViewBenefitePakage_action}"
                                        id="btnClosePopupBenfitePakage" style="left: 650px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewBenefitePakage" style=" height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTablebenefite" style=" height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableBenefite" style="left: 0px; top: 0px; height:8px; position: absolute"
                                            value="#{PowerDeligation$PowerDeligationApprovePage.benefitePakage}" var="currentRow">
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
                                            <ice:column id="colBenefitMontary">
                                                <ice:outputText id="optTxtBenefitMontary" value="#{currentRow['monetary']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextBenefitMontary" value="Montary"/>
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
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
