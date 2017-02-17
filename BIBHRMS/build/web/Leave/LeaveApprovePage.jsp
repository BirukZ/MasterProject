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
                    function ManageAdvertisement(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Leave$LeaveApprovePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Leave$LeaveApprovePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Leave$LeaveApprovePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Leave$LeaveApprovePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Leave$LeaveApprovePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 75px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 75px; left: 0px; position: relative; width: 100%z; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px;top:62px; left: 5px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none;">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" style="height:193px" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%;"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Leave$LeaveApprovePage.lnkResignApprovePage_action}"
                                                                id="lnkResignApprovePage" style="color:#333333;font-weight:bold" value="Leave Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$LeaveApprovePage.lnkClearancePage_action}" id="lnkClearancePage"
                                                                style="color:#333333;font-weight:bold" value="Employee Profile"/>
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
                                                <ice:panelGrid id="StatusBoard" style="height: 580px" width="100%">
                                                    <ice:panelGroup id="status_Group" style="border-style: none; margin: -5px -5px -5px -10px; padding: 7px; background-color: transparent; display: block; float: left; height: 550px; left: -5px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 400px; position: absolute; width: 100%">
                                                            <ice:outputText id="outputText32"
                                                                style="font-family: Cambria; left: 10px; top: 10px; position: absolute" value="New Request Arrival  List"/>
                                                            <ice:selectOneListbox binding="#{Leave$LeaveApprovePage.lstNewRequests}" id="lstNewRequests"
                                                                partialSubmit="true" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); height: 300px; left: 10px; top: 30px; position: absolute; width: 180px"
                                                                value="#{Leave$LeaveApprovePage.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Leave$LeaveApprovePage.lstNewRequests_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{Leave$LeaveApprovePage.requestListsToBeApproved}"/>
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
                                <ice:panelGroup id="page_display" style="height:975px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 970px; left: 0px; top: 62px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 900px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="MANAGE EMPLOYEE Leave REQUEST(S)"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 810px; left: 0px; top: 25px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 800px" styleClass="filedset_border">
                                                    <label style="left: 20px; top: 940px; border-bottom:0.5px groove #176674; width:750px; position: absolute;"></label>
                                                    <label style="left: 20px; top: 985px; border-bottom:0.5px groove #176674; width:750px; position: absolute;"></label>
                                                    <ice:outputText id="outputText1" style="font-family: Cambria; left: 40px; top: 40px; position: absolute" value="Employee Id "/>
                                                    <ice:outputText id="outputText3" style="font-family: Cambria; left: 40px; top: 80px; position: absolute" value="Full Name "/>
                                                    <ice:outputText id="outputText4" style="font-family: Cambria; left: 40px; top: 120px; position: absolute" value="Gender :"/>
                                                    <ice:outputText id="outputText6" style="font-family: Cambria; left: 40px; top: 160px; position: absolute" value="Department "/>
                                                    <ice:outputText id="outputText8" style="font-family: Cambria; left: 40px; top: 240px; position: absolute" value="Service Year "/>
                                                    <ice:outputText id="lblDateRequested1"
                                                        style="font-family: Cambria; left: 40px; top: 200px; position: absolute" value="Position "/>
                                                    <ice:outputText binding="#{Leave$LeaveApprovePage.lblEmployeeId}" id="lblEmployeeId"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Cambria'; left: 150px; top: 40px; position: absolute; width: 260px" value=":"/>
                                                    <ice:outputText binding="#{Leave$LeaveApprovePage.lblFullName}" id="lblFullName"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 80px; position: absolute; width: 260px" value=":"/>
                                                    <ice:outputText binding="#{Leave$LeaveApprovePage.lblDepartment}" id="lblDepartment"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Cambria';left: 150px; top: 160px; position: absolute; width: 356px" value=":"/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$LeaveApprovePage.chkMale}" disabled="true" id="chkMale"
                                                        partialSubmit="true" style="left: 208px; top: 123px; position: absolute" value="#{Leave$LeaveApprovePage.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$LeaveApprovePage.chkFemale}" disabled="true" id="chkFemale"
                                                        partialSubmit="true" style="left: 290px; top: 123px; position: absolute" value="#{Leave$LeaveApprovePage.selectBooleanCheckbox5Bean.selectedBoolean}"/>
                                                    <ice:outputText id="outputText2" style="font-family: Cambria; left: 150px; top: 120px; position: absolute" value="Male"/>
                                                    <ice:outputText id="outputText14" style="font-family: Cambria; left: 250px; top: 120px; position: absolute" value="Female"/>
                                                    <ice:outputText binding="#{Leave$LeaveApprovePage.lblPosition}" id="lblPosition"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Cambria'; left: 150px; top: 200px; position: absolute; width: 360px" value=":"/>
                                                    <ice:outputText binding="#{Leave$LeaveApprovePage.lblHireDate}" id="lblHireDate"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 240px; position: absolute; text-align: left; width: 192px" value=":"/>
                                                    <ice:panelLayout id="PanelLayOutJobSpecificAtrributesAddChoose"
                                                        style="border-style: solid; border-color: rgb(204, 204, 204); height: 200px; left: 26px; top: 290px; overflow: auto; position: absolute; width: 730px" styleClass="insideContainerMain">
                                                        <ice:dataTable id="dataTable1" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                            value="#{Leave$LeaveApprovePage.listOfLeaveRequest}" var="currentRow">
                                                            <ice:column id="column1">
                                                                <ice:outputText id="outputText5" value="#{currentRow['leaveType']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblLeaveType" value="Leave Type"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column2">
                                                                <ice:outputText id="outputText10" value="#{currentRow['leaveDayes']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblRequestedleaveday" value="Requested Leave Day  "/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column3">
                                                                <ice:outputText id="outputText12" value="#{currentRow['requestedDateFrom']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblFromDate" value="From Date"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rwSelectorLeaveApprove" immediate="true" multiple="false"
                                                                    selectionListener="#{Leave$LeaveApprovePage.rwSelectorLeaveApprove_processMyEvent}" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                            <ice:column id="column4">
                                                                <ice:outputText id="txtToDate" value="#{currentRow['requestedDateTo']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblToDate" value="To Date"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colLeaveBalance">
                                                                <ice:outputText id="txtLeaveBalance" value="#{currentRow['leaveBalance']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblLeaveBalance" value="Leave Balance"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colFromYear">
                                                                <ice:outputText id="txtFromYear" value="#{currentRow['physicalYear']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblFromYear" value="From Year"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colReturnDate">
                                                                <ice:outputText id="txtReturnDate" value="#{currentRow['returnDate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblReturnDate" value="Return Date"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column5">
                                                                <ice:outputText id="txtReasonLeaveRequest" value="#{currentRow['requestReason']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblReasonLeaveRequest" value="Reason"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colApprove" style="text-align:center;">
                                                                <ice:selectBooleanCheckbox id="chkApproveList" partialSubmit="true" value="#{currentRow['approveList']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblSelectApprove" value="Select Here for Decision"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panLeaveApprove" style="border: 1px solid rgb(204, 204, 204); height: 251px; margin-left: 15px; left: 10px; top: 500px; overflow: auto; position: absolute; width: 732px">
                                                        <ice:outputLabel id="lblDeciderDepartment"
                                                            style="font-family: Cambria; left: 20px; top: 30px; position: absolute" value="DeciderDepartment"/>
                                                        <ice:outputLabel id="lblDeciderId"
                                                            style="font-family: Cambria; left: 20px; top: 70px; position: absolute" value="DeciderId"/>
                                                        <ice:inputText binding="#{Leave$LeaveApprovePage.txtDeciderId}" disabled="true" id="txtDeciderId" style="left: 140px; top: 70px; position: absolute"/>
                                                        <ice:outputLabel id="lblDeciderFullName" style="left: 390px; top: 30px; position: absolute" value="Decider FullName"/>
                                                        <ice:outputLabel id="deciderPosition"
                                                            style="font-family: Cambria; left: 390px; top: 70px; position: absolute" value="Decider Position"/>
                                                        <ice:selectOneMenu binding="#{Leave$LeaveApprovePage.drlDecision}" id="drlDecision" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); left: 140px; top: 105px; position: absolute; width: 200px" value="#{Termination$TerminationApprovePage.selectedObjectOneMenuDecisionType.selectedObject}">
                                                            <f:selectItems id="selectDecisionAvailable" value="#{Leave$LeaveApprovePage.availableDecisionsToMakeList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputLabel id="lblDecision"
                                                            style="font-family: Cambria; left: 20px; top: 110px; position: absolute" value="Decision"/>
                                                        <ice:inputTextarea binding="#{Leave$LeaveApprovePage.txtaDeciderComment}" id="txtaDeciderComment" style="border: 1px solid rgb(115, 179, 206); height: 63px; left: 140px; top: 145px; position: absolute; width: 560px"/>
                                                        <ice:outputLabel id="lblDeciderComment"
                                                            style="font-family: Cambria; left: 20px; top: 150px; position: absolute" value="Comment"/>
                                                        <ice:commandButton action="#{OverTime$OverTimeApprovePage.btnSearchDecider_action}"
                                                            binding="#{OverTime$OverTimeApprovePage.btnSearchDecider}" id="btnSearchDecider"
                                                            style="left: 290px; top: 63px; position: absolute" value="Change"/>
                                                        <ice:commandLink action="#{Leave$LeaveApprovePage.lnkViewPrevieousDecisions_action}"
                                                            binding="#{OverTime$OverTimeApprovePage.lnkViewPrevieousDecisions}" id="lnkViewPrevieousDecisions"
                                                            style="left: 432px; top: 120px; position: absolute" value="View decisions made on this request"/>
                                                        <ice:outputText binding="#{Leave$LeaveApprovePage.lblDecider_Department}" id="lblDecider_Department"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Nyala,Cambria; font-size: 10px; font-weight: bold; left: 140px; top: 30px; position: absolute; width: 200px" value=":"/>
                                                        <ice:outputText binding="#{Leave$LeaveApprovePage.lblEmployeeFullName}" id="lblEmployeeFullName"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 500px; top: 30px; position: absolute; width: 210px" value=":"/>
                                                        <ice:outputText binding="#{Leave$LeaveApprovePage.lblDeciderPosition}" id="lblDeciderPosition"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 500px; top: 70px; position: absolute; width: 210px" value=":"/>
                                                    </ice:panelLayout>
                                                    <ice:graphicImage binding="#{Leave$LeaveApprovePage.imgEmployeePicture}" height="194"
                                                        id="imgEmployeePicture"
                                                        style="border: 1px solid rgb(153, 153, 153); left: 550px; top: 24px; position: absolute"
                                                        url="/Employee/images/blank.gif" width="172"/>
                                                    <ice:commandButton action="#{Leave$LeaveApprovePage.btnSave_action}"
                                                        binding="#{Leave$LeaveApprovePage.btnSave}" id="btnSave"
                                                        style="left: 169px; top: 760px; position: absolute; width: 120px" value="Save"/>
                                                    <ice:commandLink action="#{Leave$LeaveApprovePage.lnkTransionHistory_action}"
                                                        binding="#{Leave$LeaveApprovePage.lnkTransionHistory}" id="lnkTransionHistory" immediate="true"
                                                        partialSubmit="true" rendered="false"
                                                        style="color: rgb(46, 100, 128); font-family: Cambria; font-size: 14px; font-style: normal; font-weight: bold; left: 490px; top: 515px; position: absolute; z-index: 100; cursor: pointer;" value="[ View State Transition Request History ]"/>
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
                                                style="margin-left:10px;color:#333333;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com" style="margin-left:10px;color:#333333;">BUNNA INTERNATIONAL BANK |information |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$LeaveApprovePage.pnlPopUpAttachment}" clientOnly="true" draggable="true"
                            id="pnlPopUpAttachment" modal="true" rendered="false" style="display: block; height: 455px; left: 97px; top: 146px; position: absolute; width: 812px">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridPopUpAttachment" styleClass="popupHeaderWrapper">
                                    <ice:outputText id="PopUpAttachmentTitle" style="width:400px" styleClass="popupHeaderText" value="BUNNA INTERNATIONAL BANK Human Resource Management System-Request Commented History"/>
                                    <ice:commandButton actionListener="#{Leave$LeaveApprovePage.modalPnlCloseBtnAttachment_processAction}" alt="Close"
                                        id="modalPnlCloseBtnAttachment" image="/resources/images/close.gif" immediate="true" partialSubmit="true"
                                        style="left: 789px; top: -1px; position: absolute" styleClass="popupHeaderImage" title="Close Popup" type="button"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="pnlgroupPopUpAttach" style="display: block; height: 387px; position: relative; width: 762px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:graphicImage binding="#{Leave$LeaveApprovePage.gimgAttachedDocuments}" height="364" id="gimgAttachedDocuments"
                                        style="left: 5px; top: 5px; position: absolute" width="761"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$LeaveApprovePage.pnMessage}" clientOnly="true" draggable="false" id="pnMessage"
                            modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK FHuman Resource Management"/>
                                    <ice:commandLink action="#{Leave$LeaveApprovePage.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Leave$LeaveApprovePage.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$LeaveApprovePage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="border-style: none; background-color: transparent; display: block; height: 200px; left: 97px; top: 226px; position: absolute; width: 600px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions"
                                    style="background-color: rgb(48, 102, 130);                              display: block; height: 27px" width="670">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="color: white; margin-top: 8px; top: 8px; text-align: left; vertical-align: middle;width:90%" value="bunna HRMS - View request status "/>
                                    <ice:commandLink action="#{Leave$LeaveApprovePage.btnClosePopupViewPrevieousDecisions_action}"
                                        binding="#{Leave$LeaveApprovePage.btnClosePopupViewPrevieousDecisions}" id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; left: 653px; top: 0px; position: absolute; width: 19px"/>
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
                                        <ice:outputText binding="#{Leave$LeaveApprovePage.lblDesstionStatus}" id="lblDesstionStatus" rendered="false"
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
