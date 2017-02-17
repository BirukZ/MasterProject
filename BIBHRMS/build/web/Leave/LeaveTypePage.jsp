<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : LeaveTypePage
    Created on : Feb 26, 2012, 7:48:31 AM
    Author     : Dereje
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
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
                    var LeaveTypePage=jQuery.noConflict();
                </script>
              <!--  <link HREF="../FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{Page1.panelBorder1Bean.renderCenter}"
                                     renderEast="#{Page1.panelBorder1Bean.renderEast}" renderNorth="#{Page1.panelBorder1Bean.renderNorth}"
                                     renderSouth="#{Page1.panelBorder1Bean.renderSouth}" renderWest="#{Page1.panelBorder1Bean.renderWest}"
                                     style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                        <f:facet name="north">
                            <ice:panelGroup dragListener="#{Page1.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
                                <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow" style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                                 styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                                <!-- End Header -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup id="menu_left" style=" height:312px;">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                                 style="height: 660px;top:25px; left: 5px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 655px;position: absolute; width: 213px" styleClass="list_menu">
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible1" style="border:none">
                                            <f:facet name="header">
                                                <ice:panelGroup id="trainingManagementMenu" styleClass="">
                                                    <ice:outputText id="outputTextMTplan" value="Search Area"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGridTrainingManage">
                                                <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 55px; width: 100%">
                                                    <ice:outputText id="outputText19" value=""/>
                                                </ice:panelGroup>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible4" style="border:none">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroupSearch" styleClass="">
                                                    <ice:outputText id="lblHeadSearchByNameTraining" value="Common Tasks"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="commonTasksGroup_Grid11" style="height:193px" width="100%">
                                                <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%;"/>
                                                <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                    <li>
                                                        <ice:commandLink action="#{Leave$LeaveTypePage.cmdLeaveRequest_action}" id="cmdLeaveRequest"
                                                                         style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Leave Request"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Leave$LeaveTypePage.cmdLeaveApprove_action}" id="cmdLeaveApprove"
                                                                         style="color:#306682;font-weight:bold" value="Leave Approve"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Leave$LeaveTypePage.cmdLeaveBalance_action}" id="cmdLeaveBalance"
                                                                         style="color:#306682;font-weight:bold" value="Leave Balance"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Leave$LeaveTypePage.cmdLeaveTransferRequest_action}"
                                                                         id="cmdLeaveTransferRequest" style="color:#306682;font-weight:bold" value="Leave Transfer Request"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Leave$LeaveTypePage.cmdLeaveTransferApprove_action}"
                                                                         id="cmdLeaveTransferApprove" style="color:#306682;font-weight:bold" value="LeaveTransferApprove"/>
                                                    </li>
                                                </ul>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible3" style="border:none">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup4" styleClass="">
                                                    <ice:outputText id="headNote" value="Status"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid3">
                                                <ice:panelGroup id="pnlgrpStatus" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 270px; width: 100%"/>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 680px">
                                <ice:panelLayout id="container" layout="flow"
                                                 style="height: 700px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css" style="height: 650px;">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="Maintain Leave Type "/>
                                        </legend>
                                        <ice:panelLayout id="pnProfile" style="height: 627px; left: 0px; top: 20px; position: absolute; width: 100%">
                                            <ice:panelGroup id="RetirementApproval1" style="height: 590px" styleClass="filedset_border">
                                                <ice:outputText id="lblEmployeementHistory1"
                                                                style="font-size: 11px; font-weight: bold; left: 30px; top: 25px; position: absolute" value="LEAVE TYPE INFORMATION"/>
                                                <label style="left: 20px; top: 50px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                <label style="left: 20px; top: 315px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                <label style="left: 20px; top: 545px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                <label style="left: 20px; top: 590px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                <ice:outputText id="outputTextName" style="margin-left: 15px; margin-top: 60px; top: 25px; position: absolute"
                                                                styleClass="insideTextLable" value="Leave Type Name:"/>
                                                <ice:outputText id="outputText15"
                                                                style="margin-left: 400px; margin-top: 60px; top: 18px; position: absolute; text-align: left; width: 100px" value="Leave Type"/>
                                                <ice:outputText id="outputTextCperson"
                                                                style="margin-left: 15px; margin-top: 100px; top: 25px; position: absolute" styleClass="insideTextLable" value="Minimum Days:"/>
                                                <ice:outputText id="outputTextRemark"
                                                                style="margin-left: 15px; margin-top: 140px; top: 25px; position: absolute" styleClass="insideTextLable" value="Gender:"/>
                                                <ice:inputText binding="#{Leave$LeaveTypePage.txtLeaveTypeName}" disabled="true" id="txtLeaveTypeName"
                                                               partialSubmit="true" required="true"
                                                               style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 150px; margin-top: 65px; position: absolute; width: 210px" styleClass="insideInputTextAny"/>
                                                <ice:inputText binding="#{Leave$LeaveTypePage.txtMinimumDays}" disabled="true" id="txtMinimumDays"
                                                               partialSubmit="true" required="true"
                                                               style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 150px; margin-top: 105px; position: absolute; width: 110px" styleClass="insideInputTextAny"/>
                                                <ice:inputTextarea binding="#{Leave$LeaveTypePage.txtRemark}" disabled="true" id="txtRemark"
                                                                   partialSubmit="true"
                                                                   style="border: 1px solid rgb(134, 182, 210); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 73px; margin-left: 150px; margin-top: 220px; position: absolute; width: 475px" styleClass="insideInputTextAny"/>
                                                <ice:commandButton action="#{Leave$LeaveTypePage.btnAddLeaveType_action}"
                                                                   binding="#{Leave$LeaveTypePage.btnAddLeaveType}" disabled="true" id="btnAddLeaveType" partialSubmit="true"
                                                                   style="margin-left: 150px; margin-top: 216px; left: 430px; top: 110px; position: absolute; width: 175px" value="Add"/>
                                                <ice:panelLayout id="pnlAbsentee" style="border-width: 1px; border-style: solid; border-color:
                                                                 rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204);
                                                                 height: 146px; left: 25px; top: 370px; overflow: auto; position: absolute; width: 732px">
                                                    <ice:dataTable binding="#{Leave$LeaveTypePage.dataTableTrainerInfo}" id="dataTableTrainerInfo"
                                                                   style="top: -10px; position: absolute; width: 100%" value="#{Leave$LeaveTypePage.leaveTypeList}"
                                                                   var="currentRow" width="661">
                                                        <ice:column id="column1">
                                                            <ice:outputText id="outputText1" value="#{currentRow['leaveTypeName']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText3" value="Leave Type"/>
                                                            </f:facet>
                                                            <ice:rowSelector id="rowSelectorAbsentee" multiple="false"
                                                                             selectionListener="#{Leave$LeaveTypePage.rwSelectorPeriodList_processMyEvent}" value="#{currentRow['selected']}"/>
                                                        </ice:column>
                                                        <ice:column id="colMinimumDays">
                                                            <ice:outputText id="lblMinimumDays" value="#{currentRow['minimumDays']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblLblMinimumDays" value="Minimum Days"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colMaximumDays">
                                                            <ice:outputText id="lblMaximumDays" value="#{currentRow['maximumDays']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblLblMaximumDays" value="Maximum Days"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colForGender">
                                                            <ice:outputText id="lblForGender" value="#{currentRow['forGender']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblLblForGender" value="Gender"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colForEmploymentTypeDays">
                                                            <ice:outputText id="lblForEmploymentTypeDays" value="#{currentRow['forEmploymentType']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="colLblForEmploymentType" value="Employment Type"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column3">
                                                            <ice:outputText id="outputText7" value="#{currentRow['remark']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblTblRemark" value="Remark"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:commandButton action="#{Leave$LeaveTypePage.btnSaveLeaveType_action}"
                                                                   binding="#{Leave$LeaveTypePage.btnSaveLeaveType}" disabled="true" id="btnSaveLeaveType"
                                                                   style="margin-left: 130px; margin-top: 520px; left: 40px; top: 35px; position: absolute; width: 90px"
                                                                   styleClass="styleContButton" value="Save"/>
                                                <ice:commandButton action="#{Leave$LeaveTypePage.btnUpdateLeaveType_action}"
                                                                   binding="#{Leave$LeaveTypePage.btnUpdateLeaveType}" disabled="true" id="btnUpdateLeaveType"
                                                                   style="margin-left: 240px; margin-top: 520px; left: 160px; top: 35px; position: absolute; width: 90px"
                                                                   styleClass="styleContButton" value="Update"/>
                                                <ice:commandButton action="#{Leave$LeaveTypePage.btnDeleteTrainer_action}"
                                                                   binding="#{Leave$LeaveTypePage.btnDeleteLeaveType}" disabled="true" id="btnDeleteLeaveType"

                                                                   style="margin-left: 460px; margin-top: 520px; left: 170px; top: 35px; position: absolute; width: 90px"
                                                                   styleClass="styleContButton" value="Delete"/>
                                                <ice:commandButton action="#{Leave$LeaveTypePage.btnCancelTrainer_action}"
                                                                   binding="#{Leave$LeaveTypePage.btnCancelLeaveType}" disabled="true" id="btnCancelLeaveType" immediate="true"
                                                                   partialSubmit="true"
                                                                   style="margin-left: 350px; margin-top: 520px; left: 165px; top: 35px; position: absolute; width: 90px"
                                                                   styleClass="styleContButton" value="Cancel"/>
                                                <ice:commandButton action="#{Leave$LeaveTypePage.btnNewLeaveType_action}"
                                                                   binding="#{Leave$LeaveTypePage.btnNewLeaveType}" id="btnNewLeaveType" partialSubmit="true"
                                                                   style="margin-left: 130px; margin-top: 520px; left: -75px; top: 35px; position: absolute; width: 90px" value="New"/>
                                                <ice:commandButton action="#{Leave$LeaveTypePage.btnEditLeaveType_action}"
                                                                   binding="#{Leave$LeaveTypePage.btnEditLeaveType}" disabled="true" id="btnEditLeaveType" partialSubmit="true"
                                                                   style="margin-left: 130px; margin-top: 520px; left: 155px; top: 35px; position: absolute; width: 90px" value="Edit"/>
                                                <ice:outputLabel binding="#{Leave$LeaveTypePage.lblTrainerId}" id="lblTrainerId" rendered="false"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlLeaveType" id="message1"
                                                             infoClass="infoMessage"
                                                             style="color: #ff0000; margin-left: 540px; margin-top: 80px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtMinimumDays" id="message2"
                                                             infoClass="infoMessage"
                                                             style="color: #ff0000; margin-left: 15px; margin-top: 60px; left: 250px; top: 65px; position: absolute; width: 126px" warnClass="warnMessage"/>
                                                <ice:outputText id="outputText2"
                                                                style="margin-left: 400px; margin-top: 100px; top: 25px; position: absolute; text-align: left; width: 100px" value="Maximum Days"/>
                                                <ice:inputText binding="#{Leave$LeaveTypePage.txtMaximumDays}" id="txtMaximumDays" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 500px; margin-top: 105px; position: absolute; width: 110px"/>
                                                <ice:selectBooleanCheckbox binding="#{Leave$LeaveTypePage.choFemale}" id="choFemale" partialSubmit="true"
                                                                           style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 150px; margin-top: 150px; position: absolute"
                                                                           value="#{Leave$LeaveTypePage.defaultSelectedData7.selectedBoolean}" valueChangeListener="#{Leave$LeaveTypePage.choFemale_processValueChange}"/>
                                                <ice:selectBooleanCheckbox binding="#{Leave$LeaveTypePage.choMale}" id="choMale" partialSubmit="true"
                                                                           style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 230px; margin-top: 150px; position: absolute"
                                                                           value="#{Leave$LeaveTypePage.selectBooleanCheckbox2Bean.selectedBoolean}" valueChangeListener="#{Leave$LeaveTypePage.choMale_processValueChange}"/>
                                                <ice:outputText id="outputText9"
                                                                style="left: 270px; top: 160px; position: absolute; text-align: left; width: 40px" value="Male"/>
                                                <ice:outputText escape="false" id="outputText8"
                                                                style="left: 190px; top: 160px; position: absolute; text-align: left; width: 40px" value="Female"/>
                                                <ice:outputText id="outputText10" style="margin-left: 15px; margin-top: 180px; top: 25px; position: absolute" value="Employment Type"/>
                                                <ice:selectBooleanCheckbox binding="#{Leave$LeaveTypePage.choBoth}" id="choBoth" partialSubmit="true"
                                                                           style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 310px; top: 165px; position: absolute"
                                                                           value="#{Leave$LeaveTypePage.selectBooleanCheckbox3Bean.selectedBoolean}" valueChangeListener="#{Leave$LeaveTypePage.choBoth_processValueChange}"/>
                                                <ice:selectBooleanCheckbox binding="#{Leave$LeaveTypePage.choNormal}" id="choNormal" partialSubmit="true"
                                                                           style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 150px; margin-top: 190px; position: absolute"
                                                                           value="#{Leave$LeaveTypePage.selectBooleanCheckbox4Bean.selectedBoolean}" valueChangeListener="#{Leave$LeaveTypePage.choNormal_processValueChange}"/>
                                                <ice:selectBooleanCheckbox binding="#{Leave$LeaveTypePage.choTOHigherWorker}" id="choTOHigherWorker"
                                                                           partialSubmit="true"
                                                                           style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 230px; margin-top: 190px; position: absolute"
                                                                           value="#{Leave$LeaveTypePage.selectBooleanCheckbox5Bean.selectedBoolean}" valueChangeListener="#{Leave$LeaveTypePage.choTOHigherWorker_processValueChange}"/>
                                                <ice:selectBooleanCheckbox binding="#{Leave$LeaveTypePage.choBothForPostion}" id="choBothForPostion"
                                                                           partialSubmit="true"
                                                                           style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 390px; top: 205px; position: absolute"
                                                                           value="#{Leave$LeaveTypePage.selectBooleanCheckbox6Bean.selectedBoolean}" valueChangeListener="#{Leave$LeaveTypePage.choBothForPostion_processValueChange}"/>
                                                <ice:outputText id="outputText14"
                                                                style="left: 330px; top: 160px; position: absolute; text-align: left; width: 40px" value="Both "/>
                                                <ice:outputText id="outputText13"
                                                                style="left: 190px; top: 200px; position: absolute; text-align: left; width: 40px" value="Employee"/>
                                                <ice:outputText id="outputText12"
                                                                style="left: 270px; top: 200px; position: absolute; text-align: left; width: 100px" value="Management "/>
                                                <ice:outputText id="outputText11"
                                                                style="left: 410px; top: 200px; position: absolute; text-align: left; width: 40px" value="Both "/>
                                                <ice:selectOneMenu binding="#{Leave$LeaveTypePage.drlLeaveType}" id="drlLeaveType" partialSubmit="true"
                                                                   style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 500px; margin-top: 60px; position: absolute; width: 186px" value="#{Leave$LeaveTypePage.defaultSelectedData13.selectedObject}">
                                                    <f:selectItems id="selectOneMenu1selectItems2" value="#{Leave$LeaveTypePage.selectLeaveType}"/>
                                                </ice:selectOneMenu>
                                                <ice:outputText id="outputText16" style="left: 35px; top: 250px; position: absolute" value="Remark"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtLeaveTypeName" id="mesLeaveTypeName"
                                                             infoClass="infoMessage"
                                                             style="color: #ff0000; margin-left: 215px; margin-top: 80px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtMaximumDays" id="message5"
                                                             infoClass="infoMessage"
                                                             style="color: rgb(255, 0, 0); margin-left: 15px; margin-top: 70px; left: 490px; top: 65px; position: absolute; width: 126px" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="choBoth" id="message6"
                                                             infoClass="infoMessage"
                                                             style="color: rgb(255, 0, 0); left: 380px; top: 160px; position: absolute; width: 126px" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="choBothForPostion" id="message7"
                                                             infoClass="infoMessage"
                                                             style="color: rgb(255, 0, 0); left: 460px; top: 200px; position: absolute; width: 126px" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRemark" id="message8"
                                                             infoClass="infoMessage"
                                                             style="color: rgb(255, 0, 0); left: 250px; top: 310px; position: absolute; width: 126px" warnClass="warnMessage"/>
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
                                        href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |information |Software Department.</a> |</label>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                    <ice:panelPopup autoCentre="true" binding="#{Leave$LeaveTypePage.pnMessage}" clientOnly="true" draggable="false" id="pnMessage"
                                    modal="false" rendered="false"
                                    style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 400px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnMessageTitle"
                                                style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                <ice:commandLink action="#{Leave$LeaveTypePage.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage" immediate="true"
                                                 style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                                 styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlMessageBody" layout="flow"
                                                 style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{Leave$LeaveTypePage.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <!--This is trainer specification-->
                    <!--This is training type-->
                    <!--This is training category-->
                    <ice:panelConfirmation acceptLabel="Yes " cancelLabel="No" id="deleteConfirmPanel" message="Are you sure you want to delete this rate ?"
                                           rendered="#{Leave$LeaveTypePage.confirmationPanelBean.withConfirmation}" title="BUNNA INTERNATIONAL BANK-Human Resource"/>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
