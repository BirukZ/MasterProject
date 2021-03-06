<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : BravoZulu
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
                    function ReserveLeaveApprovePage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
               <!-- <link HREF="../FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Leave$ReserveLeaveApprovePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Leave$ReserveLeaveApprovePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Leave$ReserveLeaveApprovePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Leave$ReserveLeaveApprovePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Leave$ReserveLeaveApprovePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;top:40px; position: relative;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px;top:15px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 470px; left: 5px; top: 20px; position: absolute; width: 213px" styleClass="left_menu">
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
                                                            <ice:commandLink action="#{Leave$ReserveLeaveApprovePage.lnkLeaveRequest_action}"
                                                                id="lnkLeaveRequest" style="color:#333333;font-weight:bold" value="Leave Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$ReserveLeaveApprovePage.lnkPayrollSetUp_action}"
                                                                id="lnkPayrollSetUp" style="color:#333333;font-weight:bold" value="Approve Leave Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$ReserveLeaveApprovePage.lnkTransferAnnualLeave_action}"
                                                                id="lnkTransferAnnualLeave" style="color:#333333;font-weight:bold" value="Transfer Annual Leave"/>
                                                        </li>
                                                        <li></li>
                                                        <li></li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="."/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:225px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="border-style: none; background-color: transparent; height: 78px; position: absolute; width: 100%">
                                                            <ice:selectOneListbox id="selectOneListbox1" partialSubmit="true" size="2"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); height: 223px; left: 10px; top: -5px; position: absolute; width: 182px"
                                                                value="#{Leave$ReserveLeaveApprovePage.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Leave$ReserveLeaveApprovePage.selectOneListbox1_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{Leave$ReserveLeaveApprovePage.requestListsToBeApproved}"/>
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
                                <ice:panelGroup id="page_display" style="height:900px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 775px;top:65px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 825px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Transfer Leave Amount"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 770px; left: 0px; top: 22px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 755px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelDetail12" style="border: 1px solid rgb(204, 204, 204); height: 235px; left: 30px; top: 20px; position: absolute; width: 725px">
                                                        <ice:outputText id="lblEmployeeID" style="font-size: 10px; left: 38px; top: 20px; position: absolute" value="Employee ID :"/>
                                                        <ice:outputText id="outputText1" style="font-size: 10px; left: 38px; top: 54px; position: absolute" value="Full Name"/>
                                                        <ice:outputText binding="#{Leave$ReserveLeaveApprovePage.lblFull_Name}" id="lblFull_Name"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 54px; position: absolute; width: 370px" value=":"/>
                                                        <ice:outputText id="lbllDepartment2" style="font-size: 10px; left: 38px; top: 88px; position: absolute" value="Department :"/>
                                                        <ice:outputText binding="#{Leave$ReserveLeaveApprovePage.lblDepartment}" id="lblDepartment"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 88px; position: absolute; width: 370px" value=":"/>
                                                        <ice:outputText id="lblJobPosition" style="font-size: 10px; left: 38px; top: 137px; position: absolute" value="Job Position"/>
                                                        <ice:outputText binding="#{Leave$ReserveLeaveApprovePage.lblPosition}" id="lblPosition"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 137px; position: absolute; width: 370px" value=":"/>
                                                        <ice:outputText id="lblGender" style="font-size: 11px; left: 38px; top: 171px; position: absolute" value="Gender:"/>
                                                        <ice:graphicImage binding="#{Leave$ReserveLeaveApprovePage.imgEmployeePicture}" height="194"
                                                            id="imgEmployeePicture"
                                                            style="border: 1px solid rgb(153, 153, 153); left: 545px; top: 10px; position: absolute"
                                                            value="/Employee/images/blank.gif" width="172"/>
                                                        <ice:outputText id="outputText8" style="font-size: 11px; left: 38px; top: 205px; position: absolute" value="Total Service Year"/>
                                                        <ice:outputText binding="#{Leave$ReserveLeaveApprovePage.lblServiceYear}" id="lblServiceYear"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 205px; position: absolute; width: 170px" value=":"/>
                                                        <ice:outputText binding="#{Leave$ReserveLeaveApprovePage.lblEmployeeId}" id="lblEmployeeId"
                                                            style="border-width: 1px; background-color: rgb(242, 246, 240); border-bottom-color: rgb(153, 153, 153); border-bottom-style: solid; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 17px; position: absolute; width: 190px" value=":"/>
                                                        <ice:outputText id="lblMale" style="font-size: 11px; left: 175px; top: 171px; position: absolute" value="Male"/>
                                                        <ice:outputText id="outputText9" style="font-size: 11px; left: 260px; top: 171px; position: absolute" value="Female"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ReserveLeaveApprovePage.choMale}" disabled="true"
                                                            id="choMale" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 150px; top: 175px; position: absolute" value="#{Leave$ReserveLeaveApprovePage.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ReserveLeaveApprovePage.choFemale}" disabled="true"
                                                            id="choFemale" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 235px; top: 175px; position: absolute" value="#{Leave$ReserveLeaveApprovePage.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyRequestInformation" style="border: 1px solid rgb(204, 204, 204); height: 200px; left: 30px; top: 260px; position: absolute; width: 725px;    overflow:auto">
                                                        <ice:dataTable binding="#{Leave$ReserveLeaveApprovePage.dataTable1}" id="dataTable1"
                                                            style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                            value="#{Leave$ReserveLeaveApprovePage.avilebelLeaveList}" var="currentRow">
                                                            <ice:column id="column1">
                                                                <ice:outputText id="outputText4" value="#{currentRow['leaveYear']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText5" value="Leave Year"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column2">
                                                                <ice:outputText id="outputText6" value="#{currentRow['avilbelLeveDay']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText7" value="Available Leave Days"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colStartDate">
                                                                <ice:outputText id="outStartDate" value="#{currentRow['startDate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblStartDate" value="Start Date"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colEndDate">
                                                                <ice:outputText id="outEndDate" value="#{currentRow['endDate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblEndDatee" value="End Date"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colRemark">
                                                                <ice:outputText id="outRemarke" value="#{currentRow['remark']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblRemark" value="Remark"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colLeaveTransferApprove" style="width: 50px">
                                                                <ice:selectBooleanCheckbox id="cboMakeLeaveTransferApprove" partialSubmit="true" value="#{currentRow['approveLeaveTransfer']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblLeaveTransferApprove" value="Select for Decision"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:commandButton action="#{Leave$ReserveLeaveApprovePage.btnSaveDecision_action}" id="btnSaveDecision"
                                                        style="left: 180px; top: 725px; position: absolute; width: 120px" value="Save"/>
                                                </ice:panelGroup>
                                                <ice:panelLayout id="panelLayoute17" style="border: 1px solid rgb(204, 204, 204); height: 251px; margin-left: 15px; left: 15px; top: 470px; overflow: auto; position: absolute; width: 724px">
                                                    <ice:outputText id="outputText26" style="font-family: Cambria; left: 20px; top: 30px; position: absolute" value="Decider Department :"/>
                                                    <ice:outputText id="outputText27" style="font-family: Cambria; left: 420px; top: 70px; position: absolute" value="Decider Position"/>
                                                    <ice:outputText id="outputText28" style="font-family: Cambria; left: 20px; top: 70px; position: absolute" value="Decider Id :"/>
                                                    <ice:outputText id="outputText29" style="font-family: Cambria; left: 20px; top: 110px; position: absolute" value="Decision :"/>
                                                    <ice:outputText binding="#{Leave$ReserveLeaveApprovePage.lblDecider_Department}" id="lblDecider_Department"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 30px; position: absolute; width: 240px" value=":"/>
                                                    <ice:outputText binding="#{Leave$ReserveLeaveApprovePage.lblDeciderPosition}" id="lblDeciderPosition"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 525px; top: 70px; position: absolute; width: 190px" value=":"/>
                                                    <ice:outputText binding="#{Leave$ReserveLeaveApprovePage.txtDeciderId}" id="txtDeciderId"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 70px; position: absolute; width: 240px" value=":"/>
                                                    <ice:outputText id="outputText23" style="font-family: Cambria; left: 20px; top: 150px; position: absolute" value="Comment :"/>
                                                    <ice:inputTextarea binding="#{Leave$ReserveLeaveApprovePage.txtaDeciderComment}" id="txtaDeciderComment" style="border: 1px solid rgb(115, 179, 206); height: 88px; left: 150px; top: 150px; position: absolute; width: 558px"/>
                                                    <ice:outputText id="outputText3" style="font-family: Cambria; left: 420px; top: 30px; position: absolute" value="Decider FullName"/>
                                                    <ice:selectOneMenu binding="#{Leave$ReserveLeaveApprovePage.drlDecision}" id="drlDecision"
                                                        partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); left: 150px; top: 105px; position: absolute; width: 260px" value="#{Leave$ReserveLeaveApprovePage.defaultSelectedData2.selectedObject}">
                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{Leave$ReserveLeaveApprovePage.availableDecisionsToMakeList}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:outputText binding="#{Leave$ReserveLeaveApprovePage.lblEmployeeFullName}" id="lblEmployeeFullName"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 525px; top: 30px; position: absolute; width: 190px" value=":"/>
                                                    <ice:commandLink action="#{Leave$ReserveLeaveApprovePage.lnkViewPrevieousDecisions_action}"
                                                        id="lnkViewPrevieousDecisions" style="left: 432px; top: 120px; position: absolute" value="View decisions made on this request"/>
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
                                                style="margin-left:10px;color:#FFFFFF;font-weight:bold;font-family:Cambria">Copyright © 2005-20006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com" style="margin-left:10px;color:#FFFFFF;">BUNNA INTERNATIONAL BANK |information |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                    </div>
                    <ice:panelPopup autoCentre="true" binding="#{Leave$ReserveLeaveApprovePage.pnConfirmationMessage}" clientOnly="true" draggable="false"
                        id="pnConfirmationMessage" modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlConfirmationMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnConfirmationTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                <ice:commandLink action="#{Leave$ReserveLeaveApprovePage.cmdConfirmationCloseMesssage_action}" id="cmdConfirmationCloseMesssage"
                                    immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 744px; top: 15px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup binding="#{Leave$ReserveLeaveApprovePage.panelConfirmationGroupMessage}" id="panelConfirmationGroupMessage"
                                style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout binding="#{Leave$ReserveLeaveApprovePage.pnlConfirmationMessageBody}" id="pnlConfirmationMessageBody"
                                    layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{Leave$ReserveLeaveApprovePage.lblFormMessage4}" id="lblFormMessage4" style="background-color: #F5F5F5;"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Leave$ReserveLeaveApprovePage.pnlPopupViewPrevieousDecisions}" draggable="true"
                        id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="border-style: none; background-color: transparent; display: block; height: 200px; left: 97px; top: 226px; position: absolute; width: 600px">
                        <f:facet name="header">
                            <ice:panelGrid id="panelGridPopupViewPrevieousDecisions"
                                style="background-color: rgb(48, 102, 130);                              display: block; height: 27px" width="670">
                                <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                    style="color: white; margin-top: 8px; top: 8px; text-align: left; vertical-align: middle;width:90%" value="bunna HRMS - View request status "/>
                                <ice:commandLink action="#{Leave$ReserveLeaveApprovePage.btnClosePopupViewPrevieousDecisions_action}"
                                    id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; left: 653px; top: 0px; position: absolute; width: 19px"/>
                            </ice:panelGrid>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="pnlLayoutViewPrevieousDecisions" style="display: block; height: 230px; position: relative; width: 640px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlLayoutPopupTable"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 200px; overflow: auto; position: absolute; width: 575px" styleClass="message">
                                    <ice:dataTable id="dataTable3" style="left: -5px; top: -10px; position: absolute; width: 112%"
                                        value="#{Leave$ReserveLeaveApprovePage.decisionsMadeOnRequest}" var="currentRow">
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
                                    <ice:outputText binding="#{Leave$ReserveLeaveApprovePage.lblDesstionStatus}" id="lblDesstionStatus" rendered="false"
                                        style="color: rgb(153, 204, 255); font-size: 24px; left: 50px; right: 50px; top: 50px; position: absolute" value="Not Yet Decisions Given"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
