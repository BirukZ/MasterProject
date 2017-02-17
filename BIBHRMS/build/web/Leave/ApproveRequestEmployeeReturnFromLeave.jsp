<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Aprile 16, 2011, 7:48:31 AM
    Author     : ONE1423
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
                <ice:outputStyle href="../resources/ETH/KAMSI_CAL_STYLE.css" id="outputStyle22"/>
                <script src="../resources/ETH/KAMSI_CAL_SCRIPT.js"></script>
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
                    var ApproveRequestEmployeeReturnFromLeave=jQuery.noConflict();
                </script>
              <!--  <link HREF="../FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" onload="showCal()" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Leave$ApproveRequestEmployeeReturnFromLeave.panelBorder1Bean.renderCenter}"
                            renderEast="#{Leave$ApproveRequestEmployeeReturnFromLeave.panelBorder1Bean.renderEast}"
                            renderNorth="#{Leave$ApproveRequestEmployeeReturnFromLeave.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Leave$ApproveRequestEmployeeReturnFromLeave.panelBorder1Bean.renderSouth}"
                            renderWest="#{Leave$ApproveRequestEmployeeReturnFromLeave.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 75px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 75px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="height: 783px; top: 35px; position: relative">
                                    <ice:panelLayout id="left_menu1" layout="flow" style="height: 467px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 500px; left: 5px; top: 16px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" style="height: 120px" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Leave$ApproveRequestEmployeeReturnFromLeave.lnkDisciplineApprove_action}"
                                                                id="lnkDisciplineApprove" style="color:#333333;font-weight:bold" value="Leave Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$ApproveRequestEmployeeReturnFromLeave.lnkDisciplineRequest_action}"
                                                                id="lnkDisciplineRequest" style="color:#333333;font-weight:bold" value="Leave Approve"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink
                                                                action="#{Leave$ApproveRequestEmployeeReturnFromLeave.lnkDisciplinePenality_action}"
                                                                id="lnkDisciplinePenality" style="color:#333333;font-weight:bold" value=" Leave Balance"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$ApproveRequestEmployeeReturnFromLeave.lnkCommitteeMembers_action}"
                                                                id="lnkCommitteeMembers" style="color:#333333;font-weight:bold" value="Leave Transfer Request"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="Requests List"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid1" style="height: 300px" width="100%">
                                                    <ice:panelGroup id="status_Group" style="border-style: none; margin: -5px -5px -5px -10px; padding: 7px; background-color: transparent; display: block; float: left; height: 300px; left: -5px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 225px; position: absolute; width: 100%">
                                                            <ice:selectOneListbox id="slbEmployee" partialSubmit="true" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); height: 250px; left: 10px; top: -2px; position: absolute; width: 180px;"
                                                                value="#{Leave$ApproveRequestEmployeeReturnFromLeave.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Leave$ApproveRequestEmployeeReturnFromLeave.slbEmployee_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{Leave$ApproveRequestEmployeeReturnFromLeave.requestListsToBeApproved}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="panelCollapsiblePaymentRequest">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass="">
                                                        <ice:outputText id="outputText1" value="Payment Request List"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGridPaymentRequest" style="height: 212px" width="100%">
                                                    <ice:panelGroup id="statusGroupPaymentRequest" style="border-style: none; margin: -5px -5px -5px -10px; padding: 7px; background-color: transparent; display: block; float: left; height: 212px; left: -5px; width: 100%">
                                                        <ice:panelLayout binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.statusContainerPaymentRequest}"
                                                            id="statusContainerPaymentRequest" style="height: 225px; position: absolute; width: 100%">
                                                            <ice:selectOneListbox
                                                                binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.listLeavePaymetRequest}"
                                                                id="listLeavePaymetRequest" partialSubmit="true" rendered="true" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); height: 210px; left: 10px; top: 5px; position: absolute; width: 180px"
                                                                value="#{Leave$ApproveRequestEmployeeReturnFromLeave.defaultSelectedData9.selectedObject}" valueChangeListener="#{Leave$ApproveRequestEmployeeReturnFromLeave.listLeavePaymetRequest_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems1" value="#{Leave$ApproveRequestEmployeeReturnFromLeave.listOfPaymentRequest}"/>
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
                                <ice:panelGroup id="page_display" style="height: 870px; width: 100%">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 690px; left: 0px; top: 60px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 800px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Request Retuern From Leave"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 650px; left: 0px; top: 30px; position: absolute; width: 100%">
                                                <ice:panelLayout id="panelLayout2" style="height: 745px" styleClass="filedset_border">
                                                    <ice:panelLayout id="pnProfilepage" style="height: 670px; left: 0px; top: -20px; position: relative; width: 750px">
                                                        <ice:outputText id="lblCommenteName" style="left: 30px; top: 74px; position: absolute" value="Full Name :"/>
                                                        <ice:commandButton action="#{Leave$ApproveRequestEmployeeReturnFromLeave.btnSettleSave_action}"
                                                            binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.btnSettleSave}" disabled="true"
                                                            id="btnSettleSave" rendered="false" style="left: 20px; top: 680px; position: absolute; width: 120px" value="Settle "/>
                                                        <ice:outputText id="lblEmployeeIdCab"
                                                            style="font-family: Cambria; left: 30px; top: 33px; position: absolute" value="Employee ID :"/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblFullName}" id="lblFullName"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 74px; position: absolute; width: 370px" value=":"/>
                                                        <ice:outputText id="outputText2" style="left: 30px; top: 115px; position: absolute" value="Department :"/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblEmployeeDepartment}"
                                                            id="lblEmployeeDepartment"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 115px; position: absolute; width: 370px" value=":"/>
                                                        <ice:outputText id="outputText15" style="left: 30px; top: 156px; position: absolute" value="Job Position"/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblJobPosition}"
                                                            id="lblJobPosition"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 156px; position: absolute; width: 370px" value=":"/>
                                                        <ice:outputText id="outputText17" style="left: 30px; top: 197px; position: absolute" value="Gender:"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.choMaleSe}"
                                                            disabled="true" id="choMaleSe" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 150px; top: 197px; position: absolute" value="#{Leave$ApproveRequestEmployeeReturnFromLeave.defaultSelectedData7.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.choFemaleSe}"
                                                            disabled="true" id="choFemaleSe" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 235px; top: 197px; position: absolute" value="#{Leave$ApproveRequestEmployeeReturnFromLeave.defaultSelectedData8.selectedBoolean}"/>
                                                        <ice:outputText id="lblMale" style="font-size: 11px; left: 175px; top: 197px; position: absolute" value="Male"/>
                                                        <ice:outputText id="lblFemale" style="font-size: 11px; left: 260px; top: 197px; position: absolute" value="Femalet"/>
                                                        <ice:graphicImage binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.imgEmployeePicture}"
                                                            height="210" id="imgEmployeePicture"
                                                            style="border: 1px solid rgb(153, 153, 153); left: 540px; top: 33px; position: absolute"
                                                            url="/Employee/images/blank.gif" value="/Employee/images/blank.gif" width="202"/>
                                                        <ice:outputText id="outputText21" style="left: 30px; top: 279px; position: absolute" value="Leave Days"/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblLeaveType}" id="lblLeaveType"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 238px; position: absolute; width: 370px" value=":"/>
                                                        <ice:outputText id="outputText23" style="left: 30px; top: 238px; position: absolute" value="Leave Type"/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblLeaveDays}" id="lblLeaveDays"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 279px; position: absolute; width: 200px" value=":"/>
                                                        <ice:outputText id="outputText22" style="left: 30px; top: 361px; position: absolute; width: 88px" value="Reason Leave"/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblReason}" id="lblReason"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 361px; position: absolute; width: 580px" value=":"/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblEndDateLevel}"
                                                            id="lblEndDateLevel"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 530px; top: 320px; position: absolute; width: 200px" value=":"/>
                                                        <ice:outputText id="outputText25" style="left: 410px; top: 320px; position: absolute" value="End Date"/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblStartDate}" id="lblStartDate"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 320px; position: absolute; width: 200px" value=":"/>
                                                        <ice:outputText id="outputText27" style="left: 30px; top: 320px; position: absolute" value="Start Date"/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblEmployeeId}"
                                                            id="lblEmployeeId"
                                                            style="border-width: 1px; border-color: rgb(115, 179, 206); background-color: rgb(242, 246, 240); border-bottom-style: solid; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 33px; position: absolute; width: 256px" value=":"/>
                                                        <ice:outputText id="outputText3" style="left: 30px; top: 390px; position: absolute; width: 90px" value="Requested Return Date"/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblRequestedRetrunDate}"
                                                            id="lblRequestedRetrunDate"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 400px; position: absolute; width: 138px" value=":"/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblReasonReturnFromLeaveca}"
                                                            id="lblReasonReturnFromLeaveca" style="left: 30px; top: 435px; position: absolute; width: 112px" value="Reason of Return From Leave"/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblReasonReturnFromLeave}"
                                                            id="lblReasonReturnFromLeave"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 440px; position: absolute; width: 580px" value=":"/>
                                                        <ice:outputText id="outputText4" style="left: 300px; top: 400px; position: absolute; width: 130px" value="Requested From Year "/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblPhsicalYear}"
                                                            id="lblPhsicalYear"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 450px; top: 400px; position: absolute; width: 270px" value=":"/>
                                                        <ice:outputText id="outputText5" style="left: 400px; top: 279px; position: absolute" value="Remaining Leave Days "/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblRemainingLeaveDays}"
                                                            id="lblRemainingLeaveDays"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 530px; top: 279px; position: absolute; width: 200px" value=":"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panLeaveApprove" style="border: 1px solid rgb(204, 204, 204); height: 235px; left: 5px; top: 460px; overflow: auto; position: absolute; width: 732px">
                                                        <ice:outputLabel id="lblDeciderDepartment"
                                                            style="font-family: Cambria; left: 20px; top: 30px; position: absolute" value="DeciderDepartment"/>
                                                        <ice:outputLabel id="lblDeciderId"
                                                            style="font-family: Cambria; left: 20px; top: 70px; position: absolute" value="DeciderId"/>
                                                        <ice:inputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.txtDeciderId}" disabled="true"
                                                            id="txtDeciderId" style="left: 140px; top: 70px; position: absolute"/>
                                                        <ice:outputLabel id="lblDeciderFullName" style="left: 390px; top: 30px; position: absolute" value="Decider FullName"/>
                                                        <ice:outputLabel id="deciderPosition"
                                                            style="font-family: Cambria; left: 390px; top: 70px; position: absolute" value="Decider Position"/>
                                                        <ice:selectOneMenu binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.drlDecision}" id="drlDecision"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); left: 140px; top: 105px; position: absolute; width: 200px" value="#{Leave$ApproveRequestEmployeeReturnFromLeave.selectedObjectOneMenuDecisionType.selectedObject}">
                                                            <f:selectItems id="selectDecisionAvailable" value="#{Leave$ApproveRequestEmployeeReturnFromLeave.availableDecisionsToMakeList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputLabel id="lblDecision"
                                                            style="font-family: Cambria; left: 20px; top: 110px; position: absolute" value="Decision"/>
                                                        <ice:inputTextarea binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.txtaDeciderComment}"
                                                            id="txtaDeciderComment" style="border: 1px solid rgb(115, 179, 206); height: 63px; left: 140px; top: 145px; position: absolute; width: 560px"/>
                                                        <ice:outputLabel id="lblDeciderComment"
                                                            style="font-family: Cambria; left: 20px; top: 150px; position: absolute" value="Comment"/>
                                                        <ice:commandButton action="#{OverTime$OverTimeApprovePage.btnSearchDecider_action}"
                                                            binding="#{OverTime$OverTimeApprovePage.btnSearchDecider}" id="btnSearchDecider" rendered="false"
                                                            style="left: 290px; top: 63px; position: absolute" value="Change"/>
                                                        <ice:commandLink
                                                            action="#{Leave$ApproveRequestEmployeeReturnFromLeave.lnkViewPrevieousDecisions_action}"
                                                            binding="#{OverTime$OverTimeApprovePage.lnkViewPrevieousDecisions}" id="lnkViewPrevieousDecisions"
                                                            style="left: 432px; top: 120px; position: absolute" value="View decisions made on this request"/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblDecider_Department}"
                                                            id="lblDecider_Department" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 140px; top: 30px; position: absolute; width: 200px"/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblEmployeeFullName}"
                                                            id="lblEmployeeFullName" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 500px; top: 30px; position: absolute; width: 210px"/>
                                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblDeciderPosition}"
                                                            id="lblDeciderPosition" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 500px; top: 70px; position: absolute; width: 210px"/>
                                                    </ice:panelLayout>
                                                    <ice:commandButton action="#{Leave$ApproveRequestEmployeeReturnFromLeave.btnSave_action}" id="btnSave"
                                                        style="left: 169px; top: 700px; position: absolute; width: 120px" value="Save"/>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label
                                                style="margin-left:10px;color:#333333;font-weight:bold;font-family:Cambria">Copyright  2005-2006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com" style="margin-left:10px;color:#333333;">BUNNA INTERNATIONAL BANK |information |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.pnConfirmationMessage}" clientOnly="true"
                            draggable="false" id="pnConfirmationMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 150px; top: 400px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlConfirmationMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnConfirmationTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Leave$ApproveRequestEmployeeReturnFromLeave.cmdConfirmationCloseMesssage_action}"
                                        id="cmdConfirmationCloseMesssage" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 742px; top: 15px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelConfirmationGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.pnlConfirmationMessageBody}"
                                        id="pnlConfirmationMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblFormMessage4}" id="lblFormMessage4" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.pnConfirmationForDelete}" clientOnly="true"
                            draggable="false" id="pnConfirmationForDelete" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 150px; left: 95px; top: 794px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlConfirmationHeader" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnConfirmationDeleteTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Leave$ApproveRequestEmployeeReturnFromLeave.cmdConfirmationCloseDeleete_action}"
                                        id="cmdConfirmationCloseDeleete" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 742px; top: 15px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelConfirmationDelete"
                                    style="display: block; height: 100px;visibility:hidden;                                 position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlConfirmationDeleteBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 70px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblFormDeleteMessage}" id="lblFormDeleteMessage" style="background-color: #F5F5F5;color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle"/>
                                        <ice:commandButton action="#{Leave$ApproveRequestEmployeeReturnFromLeave.bntYES_action}" id="bntYES"
                                            style="left: 428px; top: 55px; position: absolute; width: 80px" value="Yes"/>
                                        <ice:commandButton action="#{Leave$ApproveRequestEmployeeReturnFromLeave.button2_action}" id="button2"
                                            style="left: 540px; top: 55px; position: absolute; width: 80px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.pnlPopupViewPrevieousDecisions}"
                            draggable="true" id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="border-style: none; background-color: transparent; display: block; height: 200px; left: 97px; top: 226px; position: absolute; width: 600px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions"
                                    style="background-color: rgb(48, 102, 130);                              display: block; height: 27px" width="670">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="color: white; margin-top: 8px; top: 8px; text-align: left; vertical-align: middle;width:90%" value="BUNNA HRMS - View request status "/>
                                    <ice:commandLink action="#{Leave$ApproveRequestEmployeeReturnFromLeave.btnClosePopupViewPrevieousDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; left: 653px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="pnlLayoutViewPrevieousDecisions" style="display: block; height: 230px; position: relative; width: 640px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlLayoutPopupTable"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 200px; overflow: auto; position: absolute; width: 575px" styleClass="message">
                                        <ice:dataTable id="dataTable3" style="left: -5px; top: -10px; position: absolute; width: 112%"
                                            value="#{Leave$LeaveApprovePage.decisionsMadeOnRequest}" var="currentRow">
                                            <ice:column id="column10">
                                                <ice:outputText id="outputText25" value="#{currentRow['counter']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextNumber" value="NO"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column11">
                                                <ice:outputText id="outputText27" value="#{currentRow['givenDecision']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextDecisionGiven" value="Decision"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column12">
                                                <ice:outputText id="outputText29" value="#{currentRow['deciderEmployeeId']}"/>
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
                                        <ice:outputText binding="#{Leave$ApproveRequestEmployeeReturnFromLeave.lblDesstionStatus}" id="lblDesstionStatus"
                                            rendered="false"
                                            style="color: rgb(153, 204, 255); font-size: 24px; left: 50px; right: 50px; top: 50px; position: absolute" value="Not Yet Decisions Given"/>
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
