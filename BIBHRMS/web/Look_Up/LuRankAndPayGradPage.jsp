<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : DavePro
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
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
                    var LuRankAndPayGradPage=jQuery.noConflict();
                </script>
               <!-- <link HREF="../FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{Look_Up$LuRankAndPayGradPage.panelBorder1Bean.renderCenter}"
                        renderEast="#{Look_Up$LuRankAndPayGradPage.panelBorder1Bean.renderEast}"
                        renderNorth="#{Look_Up$LuRankAndPayGradPage.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Look_Up$LuRankAndPayGradPage.panelBorder1Bean.renderSouth}"
                        renderWest="#{Look_Up$LuRankAndPayGradPage.panelBorder1Bean.renderWest}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                        <f:facet name="north">
                            <ice:panelGroup id="page_header" style="height: 117px">
                                <ice:panelLayout id="header" layout="flow" style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                    styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup id="menu_left" style=" height:312px;">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height: 660px;top:25px; left: 5px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 655px;position: absolute; width: 213px" styleClass="list_menu">
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
                                                        <ice:commandLink action="#{Look_Up$LuRankAndPayGradPage.cmdLeaveRequest_action}" id="cmdLeaveRequest"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Organization Structure"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Look_Up$LuRankAndPayGradPage.cmdLeaveApprove_action}" id="cmdLeaveApprove"
                                                            style="color:#306682;font-weight:bold" value="Job Type"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Look_Up$LuRankAndPayGradPage.cmdLeaveBalance_action}" id="cmdLeaveBalance"
                                                            style="color:#306682;font-weight:bold" value="Job Qualifications "/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Look_Up$LuRankAndPayGradPage.cmdLeaveTransferRequest_action}"
                                                            id="cmdLeaveTransferRequest" style="color:#306682;font-weight:bold" value="Increment Salary"/>
                                                    </li>
                                                    
                                                </ul>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible3" style="border:none">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup4" styleClass="">
                                                    <ice:outputText id="headNote" value="Available Rank "/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid1" width="100%">
                                                <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:225px; width: 100%">
                                                    <ice:panelLayout id="StatusContainer" style="border-style: none; background-color: transparent; height: 78px; position: absolute; width: 100%">
                                                        <ice:selectOneListbox binding="#{Look_Up$LuRankAndPayGradPage.selectOneListbox1}" id="selectOneListbox1"
                                                            partialSubmit="true" size="2"
                                                            style="border: 1px solid rgb(115, 179, 206); height: 223px; left: 0px; top: -5px; position: absolute; width: 190px"
                                                            value="#{Look_Up$LuRankAndPayGradPage.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Look_Up$LuRankAndPayGradPage.selectOneListbox1_processValueChange}">
                                                            <f:selectItems id="selectOneListbox1selectItems" value="#{Look_Up$LuRankAndPayGradPage.rankList}"/>
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
                            <ice:panelGroup id="page_display" style="height: 680px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 700px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css" style="height: 650px;">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="SALARY SCALE "/>
                                        </legend>
                                        <ice:panelLayout id="pnProfile" style="height: 627px; left: 0px; top: 20px; position: absolute; width: 100%">
                                            <ice:panelGroup id="RetirementApproval1" style="height: 590px" styleClass="filedset_border">
                                                <ice:outputText id="lblEmployeementHistory1"
                                                    style="font-size: 11px; font-weight: bold; left: 30px; top: 25px; position: absolute" value="BUNNA Salary Scale"/>
                                                <label style="left: 20px; top: 50px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                <label style="left: 20px; top: 280px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                <label style="left: 20px; top: 545px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                <label style="left: 20px; top: 590px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                <ice:outputText id="lblRank" style="margin-left: 15px; margin-top: 60px; top: 25px; position: absolute"
                                                    styleClass="insideTextLable" value="Rank :"/>
                                                <ice:outputText id="outputTextCperson"
                                                    style="margin-left: 15px; margin-top: 100px; top: 25px; position: absolute" styleClass="insideTextLable" value="Maximum Days :"/>
                                                <ice:inputText binding="#{Look_Up$LuRankAndPayGradPage.txtRank}" disabled="true" id="txtRank"
                                                    partialSubmit="true" required="true"
                                                    style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 150px; margin-top: 65px; position: absolute; width: 210px" styleClass="insideInputTextAny"/>
                                                <ice:inputText binding="#{Look_Up$LuRankAndPayGradPage.txtBigSalary}" disabled="true" id="txtBigSalary"
                                                    partialSubmit="true" required="true"
                                                    style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 150px; margin-top: 105px; position: absolute; width: 110px" styleClass="insideInputTextAny"/>
                                                <ice:inputTextarea binding="#{Look_Up$LuRankAndPayGradPage.txtRemark}" disabled="true" id="txtRemark"
                                                    partialSubmit="true"
                                                    style="border: 1px solid rgb(134, 182, 210); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 68px; margin-left: 150px; margin-top: 150px; position: absolute; width: 475px" styleClass="insideInputTextAny"/>
                                                <ice:outputText id="outputText15" style="left: 35px; top: 300px; position: absolute" value="Step No :"/>
                                                <ice:commandButton action="#{Look_Up$LuRankAndPayGradPage.btnAddPayGrade_action}"
                                                    binding="#{Look_Up$LuRankAndPayGradPage.btnAddPayGrade}" disabled="true" id="btnAddPayGrade"
                                                    partialSubmit="true"
                                                    style="margin-left: 150px; margin-top: 10px; left: 400px; top: 330px; position: absolute; width: 175px" value="Add"/>
                                                <ice:panelLayout id="pnlPayGrade" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 146px; left: 25px; top: 370px; overflow: auto; position: absolute; width: 732px">
                                                    <ice:dataTable id="dataTable1" style="top: -10px; position: absolute; width: 100%"
                                                        value="#{Look_Up$LuRankAndPayGradPage.payGradeTableList}" var="currentRow">
                                                        <ice:column id="column1">
                                                            <ice:outputText id="outputText1" value="#{currentRow['payGrade']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText3" value="Step No"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column2">
                                                            <ice:outputText id="outputText4" value="#{currentRow['salary']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText5" value="Salary"/>
                                                            </f:facet>
                                                            <ice:rowSelector id="rowSelectorEvaSession" multiple="false" preStyleOnSelection="true"
                                                                selectionListener="#{Look_Up$LuRankAndPayGradPage.rowSelectorEvaSession_processMyEvent}"
                                                                toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:outputText id="lblStep_No"
                                                    style="left: 400px; top: 300px; position: absolute; text-align: left; width: 100px" value="Salary:"/>
                                                <ice:inputText binding="#{Look_Up$LuRankAndPayGradPage.txtSarlary}" id="txtSarlary" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 500px; top: 300px; position: absolute; width: 210px"/>
                                                <ice:selectOneMenu binding="#{Look_Up$LuRankAndPayGradPage.drlStepNo}" id="drlStepNo" partialSubmit="true"
                                                    style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 300px; position: absolute; width: 150px;&#xa;border: 1px solid rgb(134, 182, 210); " value="#{Look_Up$LuRankAndPayGradPage.selectOneMenu1Bean.selectedObject}">
                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{Look_Up$LuRankAndPayGradPage.payGradeScale}"/>
                                                </ice:selectOneMenu>
                                                <ice:commandButton action="#{Look_Up$LuRankAndPayGradPage.btnSave_action}"
                                                    binding="#{Look_Up$LuRankAndPayGradPage.btnSave}" disabled="true" id="btnSave" partialSubmit="true"
                                                    style="margin-left: 130px; margin-top: 520px; left: 40px; top: 35px; position: absolute; width: 90px"
                                                    styleClass="styleContButton" value="Save"/>
                                                <ice:commandButton action="#{Look_Up$LuRankAndPayGradPage.btnUpdate_action}"
                                                    binding="#{Look_Up$LuRankAndPayGradPage.btnUpdate}" disabled="true" id="btnUpdate"
                                                    style="margin-left: 240px; margin-top: 520px; left: 160px; top: 35px; position: absolute; width: 90px"
                                                    styleClass="styleContButton" value="Update"/>
                                                <ice:commandButton action="#{Look_Up$LuRankAndPayGradPage.btnDelete_action}"
                                                    binding="#{Look_Up$LuRankAndPayGradPage.btnDelete}" disabled="true" id="btnDelete"
                                                    style="margin-left: 460px; margin-top: 520px; left: 170px; top: 35px; position: absolute; width: 90px"
                                                    styleClass="styleContButton" value="Delete"/>
                                                <ice:commandButton action="#{Look_Up$LuRankAndPayGradPage.btnNew_action}"
                                                    binding="#{Look_Up$LuRankAndPayGradPage.btnNew}" id="btnNew" partialSubmit="true"
                                                    style="margin-left: 130px; margin-top: 520px; left: -75px; top: 35px; position: absolute; width: 90px" value="New"/>
                                                <ice:commandButton action="#{Look_Up$LuRankAndPayGradPage.btnEdit_action}"
                                                    binding="#{Look_Up$LuRankAndPayGradPage.btnEdit}" disabled="true" id="btnEdit" partialSubmit="true"
                                                    style="margin-left: 130px; margin-top: 520px; left: 155px; top: 35px; position: absolute; width: 90px" value="Edit"/>
                                                <ice:outputText id="outputText2"
                                                    style="margin-left: 400px; margin-top: 100px; top: 25px; position: absolute; text-align: left; width: 100px" value="Max. Salary :"/>
                                                <ice:inputText binding="#{Look_Up$LuRankAndPayGradPage.txtMaxSalary}" id="txtMaxSalary" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 500px; margin-top: 105px; position: absolute; width: 110px"/>
                                                <ice:outputText id="outputText16" style="left: 25px; top: 190px; position: absolute" value="Description:"/>
                                                <ice:selectBooleanCheckbox binding="#{Look_Up$LuRankAndPayGradPage.choOnlyPayGrade}" id="choOnlyPayGrade"
                                                    partialSubmit="true"
                                                    style="border: 1px solid rgb(134, 182, 210); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 340px; position: absolute" value="#{Look_Up$LuRankAndPayGradPage.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                <ice:outputText id="outputText6" style="left: 175px; top: 340px; position: absolute" value="To Modify Pay Grade Click Here   "/>
                                                <ice:commandButton action="#{Look_Up$LuRankAndPayGradPage.btnCancel_action}"
                                                    binding="#{Look_Up$LuRankAndPayGradPage.btnCancel}" id="btnCancel"
                                                    style="margin-left: 460px; margin-top: 520px; left: 60px; top: 35px; position: absolute; width: 90px" value="Cancel"/>
                                            </ice:panelGroup>
                                        </ice:panelLayout>
                                    </fieldset>
                                </ice:panelLayout>
                            </ice:panelGroup>

                        </f:facet>
                        <f:facet name="south">
                            <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                <label style="margin-left:10px;color:#FFFFFF;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | BUNNA INTERNATIONAL BANK Human Resource Management System - PayGrade.
                                </label>
                            </ice:panelLayout>
                        </f:facet>
                    </ice:panelBorder>
                    <ice:panelPopup autoCentre="true" binding="#{Look_Up$LuRankAndPayGradPage.pnlPopUpMsgConf}" draggable="true" id="pnlPopUpMsgConf"
                        modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 623px">
                        <f:facet name="header">
                            <ice:panelGrid id="panelGridPopUpMsgConf" style="display: block; height: 20px; width: 400px">
                                <ice:outputText id="lblPopUpMsgTitleConf" value="BUNNA INTERNATIONAL BANK Human Resource Management System"/>
                            </ice:panelGrid>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelGroupPopUpMsgBodyConf" style="display: block; height: 94px; position: relative; width: 586">
                                <ice:commandButton action="#{Look_Up$LuRankAndPayGradPage.btnPopUpNoConf_action}" id="btnPopUpNoConf" rendered="true"
                                    style="left: 450px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No" visible="true"/>
                                <ice:commandButton action="#{Look_Up$LuRankAndPayGradPage.btnPopUpYesConf_action}" id="btnPopUpYesConf" rendered="true"
                                    style="background-position: 0 100%; background-repeat: no-repeat; left: 320px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                    value="Yes" visible="true"/>
                                <ice:outputText binding="#{Look_Up$LuRankAndPayGradPage.lblPopUpMsgMainConf}" id="lblPopUpMsgMainConf" style="left: 24px; top: 15px; position: absolute; width: 567px"/>
                                <ice:commandButton binding="#{Look_Up$LuRankAndPayGrad.btnOK}" id="btnOK" rendered="false"
                                    style="left: 450px; top: 60px; position: absolute; visibility: visible; width: 70px" value="Ok"/>
                                <ice:commandButton binding="#{Look_Up$LuRankAndPayGrad.btnOk}" id="btnOk" rendered="false"
                                    style="left: 450px; top: 60px; position: absolute; visibility: visible; width: 70px" value="Ok"/>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Look_Up$LuRankAndPayGradPage.pnConfirmationMessage}" clientOnly="true" draggable="false"
                        id="pnConfirmationMessage" modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px;  position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlConfirmationMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnConfirmationTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                <ice:commandLink action="#{Look_Up$LuRankAndPayGradPage.cmdConfirmationCloseMesssage_action}" id="cmdConfirmationCloseMesssage"
                                    immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 15px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelConfirmationGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout binding="#{Leave$LeaveRequestPage.pnlConfirmationMessageBody}" id="pnlConfirmationMessageBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{Look_Up$LuRankAndPayGradPage.lblFormMessage4}" id="lblFormMessage4" style="background-color: #F5F5F5;"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
