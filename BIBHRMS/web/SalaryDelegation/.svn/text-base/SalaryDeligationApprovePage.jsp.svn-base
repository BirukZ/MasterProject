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
<f:loadBundle basename="Localization.HRLocalization_PowerDeligation" var="msgs"/>
<html id="outputHtml1">
    <head id="outputHead1">
        <title>Salary Deligation Request</title>
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
            function EducationPaymentApprovePage(field){

                if (field.defaultValue == field.value) field.value = '';
                else if (field.value == '') field.value = field.defaultValue;

            }
        </script>
    </head>
    <body id="outputBody1" style="-rave-layout: grid">
        <ice:form id="form1">
        <div>
            <!--img alt="" class="source-image" height="1000px" id="img" src="../resources/images/"/-->
                        <ice:panelBorder id="whole_page" renderCenter="#{SalaryDelegation$SalaryDeligationApprovePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{SalaryDelegation$SalaryDeligationApprovePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{SalaryDelegation$SalaryDeligationApprovePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{SalaryDelegation$SalaryDeligationApprovePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{SalaryDelegation$SalaryDeligationApprovePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                     style="border-width: 1px; border-style: solid; border-color: rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200); height: 773px; top: 25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                        <ice:panelLayout id="list_menu2" style="height: 787px; left: 3px; top: 2px; position: absolute; width: 213px" styleClass="left_menu">
                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                <f:facet name="header">
                                    <ice:panelGroup id="search_Group_Header">
                                        <ice:outputText id="lblSearchArea" value="Search Area"/>
                                    </ice:panelGroup>
                                </f:facet>
                                <ice:panelGrid id="search_panelGrid" width="100%"/>
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
                                            <ice:commandLink action="#{SalaryDelegation$SalaryDeligationApprovePage.lnkPowDelApprove_action}"
                                                             id="lnkPowDelApprove" style="color:#306682;font-weight:bold" value="Salary Delegation Request"/>
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
                                                                  value="#{SalaryDelegation$SalaryDeligationApprovePage.selectedObjectRequestsByStatus.selectedObject}" valueChangeListener="#{SalaryDelegation$SalaryDeligationApprovePage.selectRequestLists_processValueChange}">
                                                <f:selectItems id="selectOneListbox1selectItems" value="#{SalaryDelegation$SalaryDeligationApprovePage.pendingRequestLists}"/>
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
                                                                  value="#{SalaryDelegation$SalaryDeligationApprovePage.selectedObjectRequestsByHistory.selectedObject}" valueChangeListener="#{SalaryDelegation$SalaryDeligationApprovePage.selectRequestHistoryLists_processValueChange}">
                                                <f:selectItems id="selectOneListboxHistorySelectItems" value="#{SalaryDelegation$SalaryDeligationApprovePage.requestHistoryLists}"/>
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
            <ice:panelGroup id="page_display" style="height: 829px">
                <ice:panelLayout id="container" layout="flow"
                                 style="height: 775px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                <fieldset class="filedset_css" style="height: 760px;">
                    <legend class="legend_css">
                        <ice:outputLabel value="Salary Deligation Approve"/>
                    </legend>
                    <ice:panelLayout id="pnProfile" style="height: 818px; left: 0px; top: 20px; position: absolute; width: 100%">
                    <ice:panelGroup id="RetirementApproval" style="height: 781px" styleClass="filedset_border">
                    <ice:panelLayout id="pnlLayoutDeligation"
                                     style=" height: 190px; left: 35px; top: 320px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtStartDate}" disabled="true"
                                       id="txtStartDate" immediate="true" rendered="true" style="left: 170px; top: 43px; position: absolute"/>
                        <ice:outputLabel id="lblStartDate" style="left: 42px; top: 43px; position: absolute" value="StartDay"/>
                        <ice:outputLabel id="lblAppliedDate" style="left: 415px; top: 49px; position: absolute" value="Applied Date"/>
                        <ice:outputLabel id="lblDocReferenceNumber" style="left: 414px; top: 77px; position: absolute" value="Doc. ref. Number"/>
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtEndDate}" disabled="true"
                                       id="txtEndDate" immediate="true" readonly="true" style="left: 170px; top: 80px; position: absolute; width: 147px"/>
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtAppliedDate}" disabled="true"
                                       id="txtAppliedDate" readonly="true" style="left: 527px; top: 44px; position: absolute; width: 147px"/>
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtDocReferenceNumber}"
                                       disabled="true" id="txtDocReferenceNumber" style="left: 529px; top: 77px; position: absolute; width: 147px"/>
                        <ice:outputLabel id="lblEndDate" style="left: 41px; top: 80px; position: absolute" value="EndDate"/>
                        <ice:inputTextarea binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtaRemark}" id="txtaRemark"
                                           immediate="true" style="left: 171px; top: 118px; position: absolute; width: 503px"/>
                        <ice:outputLabel id="lblRemark" style="left: 80px; top: 115px; position: absolute" value="Reason"/>
                        <ice:outputLabel id="lblDelegateOnlySalary" style="left: 196px; top: 10px; position: absolute" value="Salary Only"/>
                        <ice:outputLabel id="lblDelegateEverything" style="left: 553px; top: 11px; position: absolute" value="Every income"/>
                        <ice:selectBooleanCheckbox
                            binding="#{SalaryDelegation$SalaryDeligationApprovePage.ckbDelegateOnlySalary}" disabled="true"
                            id="ckbDelegateOnlySalary" partialSubmit="true" style="left: 167px; top: 12px; position: absolute" value="#{SalaryDelegation$SalaryDeligationApprovePage.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                        <ice:selectBooleanCheckbox
                            binding="#{SalaryDelegation$SalaryDeligationApprovePage.ckbDelegateEverything}" disabled="true"
                            id="ckbDelegateEverything" partialSubmit="true" style="left: 524px; top: 15px; position: absolute" value="#{SalaryDelegation$SalaryDeligationApprovePage.defaultSelectedData2.selectedBoolean}"/>
                    </ice:panelLayout>
                    <ice:panelLayout id="pnlLayoutDeligator"
                                     style="height: 135px; left: 40px; top: 20px; position: absolute; width: 700px" styleClass="insideContainerMain">
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtDeligatorFullName}"
                                       disabled="true" id="txtDeligatorFullName" immediate="true" style="left: 166px; top: 22px; position: absolute; width: 263px"/>
                        <ice:outputLabel id="lblDeligator" style="left: 10px; top:4px; position: absolute" value="Deligator"/>
                        <ice:outputLabel id="lblDeligatorDepartment" style="left: 48px; top: 62px; position: absolute" value="Department"/>
                        <ice:outputLabel id="lblDeligatorId" style="left: 480px; top: 24px; position: absolute" value="Id"/>
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtDeligatorDepartment}"
                                       disabled="true" id="txtDeligatorDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtDeligatorId}" disabled="true"
                                       id="txtDeligatorId" immediate="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                        <ice:outputLabel id="lblDeligatorFullName" style="left: 48px; top: 24px; position: absolute" value="FullName"/>
                        <ice:outputLabel id="lblDeligatorPosition" style="left: 48px; top: 96px; position: absolute" value="Position"/>
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtDeligatorPosition}"
                                       disabled="true" id="txtDeligatorPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                    </ice:panelLayout>
                    <ice:panelLayout id="pnlLayoutDeligatee"
                                     style="height: 135px; left: 35px; top: 170px; position: absolute; width: 707px" styleClass="insideContainerMain">
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtDeligateeFullName}"
                                       disabled="true" id="txtDeligateeFullName" immediate="true" partialSubmit="true" style="left: 166px; top: 22px; position: absolute; width: 263px"/>
                        <ice:outputLabel id="lbltxtDeligatee" style="left: 10px; top:4px; position: absolute" value="Deligatee"/>
                        <ice:outputLabel id="lblDeligateeDepartment" style="left: 48px; top: 62px; position: absolute" value="Department"/>
                        <ice:outputLabel id="lblDeligateeId" style="left: 480px; top: 24px; position: absolute" value="Id"/>
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtDeligateeDepartment}"
                                       disabled="true" id="txtDeligateeDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtDeligateeId}" disabled="true"
                                       id="txtDeligateeId" immediate="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                        <ice:outputLabel id="lblDeligateeFullName" style="left: 48px; top: 24px; position: absolute" value="FullName"/>
                        <ice:outputLabel id="lblDeligateePosition" style="left: 48px; top: 96px; position: absolute" value="Position"/>
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtDeligateePosition}"
                                       disabled="true" id="txtDeligateePosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                    </ice:panelLayout>
                    <ice:panelLayout binding="#{SalaryDelegation$SalaryDeligationApprovePage.pnlLayoutButtons}"
                                     id="pnlLayoutButtons" rendered="true"
                                     style="height: 44px; left: 40px; top: 725px; overflow: auto; position: absolute; width: 704px" styleClass="insideContainerMain">
                        <ice:commandButton action="#{SalaryDelegation$SalaryDeligationApprovePage.btnPostDecision_action}"
                                           binding="#{SalaryDelegation$SalaryDeligationApprovePage.btnPostDecision}" id="btnPostDecision"
                                           style="left: 274px; top: 1px; position: absolute; width: 71px" value="#{SalaryDelegation$SalaryDeligationApprovePage.newOrEditOrUpdateLabel}"/>
                        <ice:commandButton action="#{SalaryDelegation$SalaryDeligationApprovePage.btnReset_action}"
                                           id="btnReset" style="left: 376px; top: 2px; position: absolute; width: 71px" value="Reset"/>
                    </ice:panelLayout>
                    <ice:panelLayout binding="#{SalaryDelegation$SalaryDeligationApprovePage.pnlLayoutTree}" id="pnlLayoutTree"
                                     layout="flow" rendered="false"
                                     style="border-width: 2px; border-style: solid; height: 356px; left: 11px; top: 78px; overflow: scroll; position: absolute; width: 264px; -rave-layout: grid" styleClass="insideContainerMain">
                    <ice:tree binding="#{SalaryDelegation$SalaryDeligationApprovePage.treeOrgStructure}" id="tree"
                              style="height: 286px; margin-left: 0px; margin-top: 0px; left: 0px; top: 48px; position: absolute; text-align: left; width: 190px"
                              value="#{SalaryDelegation$SalaryDeligationApprovePage.treeModel.model}" var="item">
                    <ice:treeNode id="treeNode2">
                    <f:facet name="icon">
                        <ice:panelGroup id="panelGroup1" style="display: inline;">
                            <ice:graphicImage id="graphicImage2" value="#{item.userObject.icon}"/>
                        </ice:panelGroup>
                    </f:facet>
                    <f:facet name="content">
                        <ice:panelGroup id="panelGroup2" style="display: inline;">
                            <ice:commandLink
                                actionListener="#{SalaryDelegation$SalaryDeligationApprovePage.cmdLnkTree_processAction}"
                                id="cmdLnkTree" partialSubmit="true">
                            <ice:outputText id="outputText1" value="#{item.userObject.text}"/>
                            </ice:commandLink>
                        </ice:panelGroup>
                    </f:facet>
                    </ice:treeNode>
                    </ice:tree>
                    </ice:panelLayout>
                    <ice:commandButton action="#{SalaryDelegation$SalaryDeligationApprovePage.btnResetHistory_action}"
                                       binding="#{SalaryDelegation$SalaryDeligationApprovePage.btnResetHistory}" id="btnResetHistory"
                                       rendered="false" style="left: 350px; top: 525px; position: absolute" value="Reset"/>
                    <ice:panelLayout id="pnlLayoutDecider"
                                     style="height: 187px; left: 40px; top: 525px; overflow: auto; position: absolute; width: 700px" styleClass="insideContainerMain">
                        <ice:outputLabel id="lblDeciderDepartment1" style="left: 48px; top: 24px; position: absolute" value="DeciderDepartment"/>
                        <ice:outputLabel id="lblDeciderId1" style="left: 49px; top: 56px; position: absolute" value="DeciderId"/>
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtDeciderDepartment}"
                                       disabled="true" id="txtDeciderDepartment" style="left: 166px; top: 22px; position: absolute"/>
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtDeciderId}" disabled="true"
                                       id="txtDeciderId" style="left: 167px; top: 59px; position: absolute"/>
                        <ice:outputLabel id="lblDeciderFullName1" style="left: 409px; top: 22px; position: absolute" value="DeciderFullName"/>
                        <ice:outputLabel id="deciderPosition1" style="left: 410px; top: 52px; position: absolute" value="DeciderPosition"/>
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtDeciderFullName}"
                                       disabled="true" id="txtDeciderFullName" style="left: 526px; top: 22px; position: absolute"/>
                        <ice:inputText binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtDeciderPosition}"
                                       disabled="true" id="txtDeciderPosition" style="left: 527px; top: 54px; position: absolute"/>
                        <!-- <ice:selectOneMenu binding="#{SalaryDelegation$SalaryDeligationApprovePage.drlDecision1}"
                                                            id="drlDecision1" partialSubmit="true"
                                                            style="height: 23px; left: 169px; top: 90px; position: absolute; width: 143px" value="#{Termination$TerminationApprovePage.selectedObjectOneMenuDecisionType.selectedObject}">
                                                            <f:selectItems id="selectDecisionAvailable1" value="#{OverTime$OverTimeApprovePage.availableDecisionsToMakeList}"/>
                                                        </ice:selectOneMenu>-->
                        <ice:outputLabel id="lblDecision1" style="left: 51px; top: 90px; position: absolute" value="Decision"/>
                        <ice:inputTextarea binding="#{SalaryDelegation$SalaryDeligationApprovePage.txtaDeciderComment}"
                                           id="txtaDeciderComment" style="left: 169px; top: 130px; position: absolute; width: 504px"/>
                        <ice:outputLabel id="lblDeciderComment1" style="left: 48px; top: 120px; position: absolute" value="Comment"/>
                        <ice:commandButton action="#{OverTime$OverTimeApprovePage.btnSearchDecider_action}"
                                           id="btnSearchDecider1" style="left: 317px; top: 52px; position: absolute" value="Change"/>
                        <ice:commandLink id="lnkViewPrevieousDecisions2"
                                         style="color: rgb(48, 102, 130); font-weight: bold; left: 432px; top: 96px; position: absolute" value="View decisions made on this request"/>
                        <ice:selectOneMenu binding="#{SalaryDelegation$SalaryDeligationApprovePage.drlDecision}"
                                           id="drlDecision" partialSubmit="true"
                                           style="height: 23px; left: 169px; top: 90px; position: absolute; width: 143px" value="#{SalaryDelegation$SalaryDeligationApprovePage.defaultSelectedData3.selectedObject}">
                            <f:selectItems id="selectOneMenu1selectItems" value="#{SalaryDelegation$SalaryDeligationApprovePage.availableDecisionsToMakeList}"/>
                        </ice:selectOneMenu>
                    </ice:panelLayout>
                </ice:panelGroup>
                </ice:panelLayout>
                <ice:selectInputDate binding="#{SalaryDelegation$SalaryDeligationApprovePage.calStartDate}" id="calStartDate"
                                     popupDateFormat="yyyy-MM-DD" renderMonthAsDropdown="true" rendered="false"
                                     style="height: 117px; left: 144px; top: 200px; position: absolute; width: 190px"
                                     value="#{SalaryDelegation$SalaryDeligationApprovePage.selectInputDateSatrtDate.date1}" valueChangeListener="#{SalaryDelegation$SalaryDeligationApprovePage.calStartDate_processValueChange}"/>
                <ice:selectInputDate binding="#{SalaryDelegation$SalaryDeligationApprovePage.calEndDate}" id="calEndDate"
                                     popupDateFormat="yyyy/MM/dd" renderMonthAsDropdown="true" rendered="false"
                                     style="height: 117px; left: 485px; top: 200px; position: absolute; width: 190px"
                                     value="#{SalaryDelegation$SalaryDeligationApprovePage.selectInputDateEndDate.date1}" valueChangeListener="#{SalaryDelegation$SalaryDeligationApprovePage.calEndDate_processValueChange}"/>
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
            <ice:panelPopup autoCentre="true" binding="#{SalaryDelegation$SalaryDeligationApprovePage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                <f:facet name="header">
                    <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                        <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Mugher Human Resource Management System:Message"/>
                        <ice:commandLink action="#{SalaryDelegation$SalaryDeligationApprovePage.btnClosePopupSuccessOrFailure_action}"
                                         id="btnClosePopupSuccessOrFailure" immediate="true"
                                         style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                         styleClass="popupHeaderImage" title="Close Popup"/>
                    </ice:panelGroup>
                </f:facet>
                <f:facet name="body">
                    <ice:panelGroup binding="#{SalaryDelegation$SalaryDeligationApprovePage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                        <ice:panelLayout binding="#{SalaryDelegation$SalaryDeligationApprovePage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                         style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                            <h:outputLabel binding="#{SalaryDelegation$SalaryDeligationApprovePage.lblSuccessOrErrorMessage}"
                                           id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                        </ice:panelLayout>
                    </ice:panelGroup>
                </f:facet>
            </ice:panelPopup>
            <ice:panelPopup autoCentre="true" binding="#{SalaryDelegation$SalaryDeligationApprovePage.pnlPopupViewPrevieousDecisions}"
                            draggable="true" id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                <f:facet name="header">
                    <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                        <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="MUGHER HRMS - "/>
                        <ice:commandButton action="#{SalaryDelegation$SalaryDeligationApprovePage.btnCloseViewPreviesDecisions_action}"
                                           id="btnClosePopupViewPrevieousDecisions" style="left: 650px; top: -10px; position: absolute" value="X"/>
                    </ice:panelGrid>
                </f:facet>
                <f:facet name="body">
                    <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                        <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                            <ice:dataTable id="dataTable" style="left: 0px; top: 0px; height:8px; position: absolute"
                                           value="#{SalaryDelegation$SalaryDeligationApprovePage.decisionsMadeOnRequestList}" var="currentRow">
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
