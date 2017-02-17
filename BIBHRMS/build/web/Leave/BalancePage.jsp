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
        <f:loadBundle basename="Localization.HRLocalization_Termination" var="msgTermination"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
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
                    var BalancePage=jQuery.noConflict();

                </script>
                <!-- <link HREF="../FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder height="480" id="whole_plstRequestsListage" renderCenter="#{Leave$BalancePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Leave$BalancePage.panelBorder1Bean.renderEast}" renderNorth="#{Leave$BalancePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Leave$BalancePage.panelBorder1Bean.renderSouth}" renderWest="#{Leave$BalancePage.panelBorder1Bean.renderEast}"
                            style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 117px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="border:none; height:510px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:675px;top:15px;left: 5px;position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:675px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="#{msgTermination.searchArea}"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid4" style="height: 200px; width: 100%;border:none">
                                                    <ice:selectInputText action="#{Leave$BalancePage.txtSearchByName_action}" id="txtSearchByName"
                                                        immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true"
                                                        rows="10" style="left: 5px; top: 50px; position: absolute"
                                                        valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                        <f:facet name="selectInputText">
                                                            <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                <ice:outputText id="lblFullNameAutoComplete2" value="#{employeeList.fullName}"/>
                                                                <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{employeeList.empIdentification}"/>
                                                            </ice:panelGrid>
                                                        </f:facet>
                                                    </ice:selectInputText>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="#{msgTermination.commonTasks}"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" style="height:193px" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%;"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Leave$BalancePage.lnkResignApprovePage_action}" id="lnkResignApprovePage"
                                                                style="color:#306682;font-weight:bold" value="Leave Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$BalancePage.lnkClearancePage_action}" id="lnkClearancePage"
                                                                style="color:#306682;font-weight:bold" value="Leave Approve"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$BalancePage.lnkLeaveBalance_action}" id="lnkLeaveBalance"
                                                                style="color:#306682;font-weight:bold" value="Transfer Annual Leave"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible1">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass="">
                                                        <ice:outputText id="outputText7" value="header Value"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid1" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:225px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" layout="flow" style="border-style: none; background-color: transparent; height: 189px; position: absolute; width: 214px; -rave-layout: grid">
                                                            <ice:commandButton action="#{Leave$BalancePage.button2_action}" id="button2"
                                                                style="height: 47px; left: 0px; top: 14px; position: absolute; width: 195px" value="View Balance As of ToDay"/>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 1030px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height:1015px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 1000px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Leave Balance"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 987px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Leave$BalancePage.RetirementApproval_processMyEvent}" id="RetirementApproval"
                                                    style="height:940px" styleClass="filedset_border">
                                                    <ice:outputText id="lblEmployeementHistory"
                                                        style="font-size: 11px; font-weight: bold; left: 30px; top: 20px; position: absolute" value="#{msgTermination.empInfo}"/>
                                                    <label style="left: 20px; top: 40px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                    <label style="left: 20px; top: 955px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                    <label style="left: 20px; top: 910px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                    <ice:commandButton action="#{Leave$BalancePage.btnEditLeaveBalance_action}"
                                                        binding="#{Leave$BalancePage.btnEditLeaveBalance}" id="btnEditLeaveBalance" partialSubmit="true"
                                                        style="left: 280px; top: 910px; position: absolute; width: 90px" value="#{msgTermination.edit}"/>
                                                    <ice:commandButton action="#{Leave$BalancePage.btnCancelLeaveBalance_action}" id="btnCancelLeaveBalance"
                                                        style="left: 530px; top: 910px; position: absolute; width: 90px" value="#{msgTermination.cancel}"/>
                                                    <ice:outputText escape="false" id="outputText1"
                                                        style="font-size: 12px; left: 38px; top: 65px; position: absolute" value="#{msgTermination.empId}"/>
                                                    <ice:outputText id="outputText2" style="font-size: 12px; left: 33px; top: 325px; position: absolute" value="#{msgTermination.totalServiceYear}"/>
                                                    <ice:outputText id="outputText5" style="font-size: 12px; left: 35px; top: 245px; position: absolute" value="Employee Type"/>
                                                    <ice:outputText id="outputText6" style="font-size: 12px; left: 38px; top: 105px; position: absolute" value="Full Name"/>
                                                    <ice:outputText id="outputText8" style="font-size: 12px; left: 35px; top: 145px; position: absolute" value="#{msgTermination.gender}"/>
                                                    <ice:outputText escape="false" id="outputText9"
                                                        style="font-size: 12px; left: 35px; top: 285px; position: absolute" value="#{msgTermination.jobPosition}"/>
                                                    <ice:commandButton action="#{Leave$BalancePage.btnUpdateLeaveBalance_action}"
                                                        binding="#{Leave$BalancePage.btnUpdateLeaveBalance}" id="btnUpdateLeaveBalance" immediate="true"
                                                        style="left: 410px; top: 910px; position: absolute; width: 90px" value="#{msgTermination.update}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$BalancePage.cbMale}" disabled="true" id="cbMale"
                                                        partialSubmit="true"
                                                        style="background-color: rgb(242, 246, 240); left: 150px; top: 145px; position: absolute" value="#{Leave$BalancePage.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$BalancePage.cbFemale}" disabled="true" id="cbFemale"
                                                        style="background-color: rgb(242, 246, 240); left: 257px; top: 145px; position: absolute" value="#{Leave$BalancePage.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                                    <ice:outputText id="outputText17" style="font-size: 12px; left: 184px; top: 145px; position: absolute" value="#{msgTermination.male}"/>
                                                    <ice:outputText id="outputText18" style="font-size: 12px; left: 290px; top: 145px; position: absolute" value="#{msgTermination.female}"/>
                                                    <ice:inputText binding="#{Leave$BalancePage.txtEmployeeId}" id="txtEmployeeId" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 60px; position: absolute; width: 145px"/>
                                                    <ice:commandButton action="#{Leave$BalancePage.btnNewLeaveBalance_action}"
                                                        binding="#{Leave$BalancePage.btnNewLeaveBalance}" id="btnNewLeaveBalance" partialSubmit="true"
                                                        style="left: 30px; top: 910px; position: absolute; width: 90px" value="#{msgTermination.new}"/>
                                                    <ice:outputLabel binding="#{Leave$BalancePage.lblFormMessage}" id="lblFormMessage" style="color: rgb(204, 102, 0); font-size: 11px; font-weight: bold; left: 0px; top: -55px; position: absolute; width: 532px"/>
                                                    <ice:commandButton action="#{Leave$BalancePage.btnSaveLeaveBalance_action}"
                                                        binding="#{Leave$BalancePage.btnSaveLeaveBalance}" disabled="true" id="btnSaveLeaveBalance"
                                                        style="left: 150px; top: 910px; position: absolute; width: 90px" value="Save"/>
                                                    <ice:outputText id="outputText43" style="font-size: 12px; left: 35px; top: 185px; position: absolute" value="Department "/>
                                                    <ice:outputText id="outputText24" style="font-size: 12px; left: 444px; top: 285px; position: absolute" value="#{msgTermination.hiredDate}"/>
                                                    <ice:commandButton action="#{Leave$BalancePage.btnDeleteLeaveBalance_action}"
                                                        binding="#{Leave$BalancePage.btnDeleteLeaveBalance}" id="btnDeleteLeaveBalance" immediate="true"
                                                        partialSubmit="true" style="left: 650px; top: 910px; position: absolute; width: 90px" value="Delete"/>
                                                    <ice:commandButton action="#{Leave$BalancePage.btnSearch_action}" binding="#{Leave$BalancePage.btnSearch}"
                                                        id="btnSearch" partialSubmit="true" style="left: 310px; top: 47px; position: absolute; width: 105px" value="Search"/>
                                                    <ice:outputText binding="#{Leave$BalancePage.lblFullName}" id="lblFullName"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 105px; position: absolute; width: 356px" value=":"/>
                                                    <ice:outputText binding="#{Leave$BalancePage.lblDepartment}" id="lblDepartment" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 149px; top: 165px; position: absolute; width: 380px"/>
                                                    <ice:outputText id="outputText11" style="font-size: 12px; left: 179px; top: 246px; position: absolute" value="Nonclerical"/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$BalancePage.chkCivil}" disabled="true" id="chkCivil"
                                                        partialSubmit="true"
                                                        style="background-color: rgb(242, 246, 240); left: 153px; top: 244px; position: absolute" value="#{Leave$BalancePage.selectBooleanCheckbox3Bean.selectedBoolean}"/>
                                                    <ice:outputText id="outputText42" style="font-size: 12px; left: 275px; top: 246px; position: absolute" value="Clerical"/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$BalancePage.chkContrat}" disabled="true" id="chkContrat"
                                                        partialSubmit="true"
                                                        style="background-color: rgb(242, 246, 240); left: 249px; top: 244px; position: absolute" value="#{Leave$BalancePage.selectBooleanCheckbox4Bean.selectedBoolean}"/>
                                                    <ice:outputText binding="#{Leave$BalancePage.lblPosition}" id="lblPosition"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 285px; position: absolute; width: 260px" value=":"/>
                                                    <ice:outputText binding="#{Leave$BalancePage.lblServiceYear}" id="lblServiceYear"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 325px; position: absolute; width: 260px" value=":"/>
                                                    <ice:graphicImage binding="#{Leave$BalancePage.imgEmployeePicture}" height="194" id="imgEmployeePicture"
                                                        style="border: 1px solid rgb(153, 153, 153); left: 550px; top: 64px; position: absolute"
                                                        value="/Employee/images/blank.gif" width="172"/>
                                                    <ice:outputText binding="#{Leave$BalancePage.lblHireDate}" id="lblHireDate"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 525px; top: 285px; position: absolute; width: 213px" value=":"/>
                                                    <ice:inputText binding="#{Leave$BalancePage.txtCurrentDate}" disabled="true" id="txtCurrentDate"
                                                        required="true" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 540px; top: 325px; position: absolute; width: 159px"/>
                                                    <ice:outputText id="outputText4" style="font-size: 12px; left: 444px; top: 325px; position: absolute" value="To Day"/>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                        <ice:panelLayout id="panelLayout1" style="height: 375px; left: 30px; top: 390px; position: absolute; width: 725px; -rave-layout: grid">
                                            <ice:panelLayout id="pnlAccrualEntry" layout="flow" style="height: 116px; left: 0px; top: 0px; position: absolute; width: 700px; -rave-layout: grid">
                                                <ice:outputText binding="#{Leave$BalancePage.lblSelectResignresign}" id="lblSelectResignresign" rendered="false"
                                                    style="font-size: 10px; left: 38px; top: 305px; position: absolute" value="#{msgTermination.selectResignReason}"/>
                                                <!--   <ice:outputText id="txtCurrentDate1" rendered="true"
                                                    style="font-size: 12px; left: 5px; top: 25px; position: absolute" value="Physical Year "/> -->
                                                <!--   <ice:outputText id="outputText3" rendered="true"
                                                    style="font-size: 12px; left: 416px; top: 25px; position: absolute" value="Leave Amount:"/> -->
                                                <ice:commandButton action="#{Leave$BalancePage.btnAddToTable_action}"
                                                    binding="#{Leave$BalancePage.btnAddToTable}" disabled="true" id="btnAddToTable"
                                                    style="height: 50px; left: 456px; top: 62px; position: absolute; width: 153px" value="Add"/>
                                                <!--  <ice:outputText id="lblUsedLeaveAmount" rendered="true"
                                                    style="font-size: 12px; left: 5px; top: 72px; position: absolute" value="Used Leave Amount"/>-->
                                                <!-- <ice:inputText binding="#{Leave$LeaveBalancePage.txtUsedLeaveAmount}" id="txtUsedLeaveAmount" rendered="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 140px; top: 62px; position: absolute; width: 159px"/> -->
                                                <ice:outputText id="outputText12" style="left: 240px; top: 24px; position: absolute" value="Total Leave Amount"/>
                                                <ice:outputText binding="#{Leave$BalancePage.lblTotalAmount}" id="lblTotalAmount" style="color: rgb(255, 0, 51); font-family: 'Times New Roman','Times',serif; font-size: 14px; left: 360px; top: 24px; position: absolute"/>
                                                <ice:outputText id="outputText13" style="left: 384px; top: 24px; position: absolute" value="Days"/>
                                                <ice:selectBooleanCheckbox binding="#{Leave$BalancePage.chkMakeReady}" id="chkMakeReady" partialSubmit="true"
                                                    style="left: 70px; top: 70px; position: absolute"
                                                    value="#{Leave$BalancePage.defaultSelectedData133.selectedBoolean}" valueChangeListener="#{Leave$BalancePage.chkMakeReady_processValueChange}"/>
                                                <ice:outputText id="outputText3" style="left: 48px; top: 86px; position: absolute" value="Make Ready "/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="panelLayout16" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 213px; margin-left: 15px; left: -15px; top: 144px; overflow: auto; position: absolute; width: 100%">
                                                <ice:dataTable binding="#{Leave$BalancePage.tblLeaveBalance}" clientOnly="true" id="tblLeaveBalance"
                                                    style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                    value="#{Leave$BalancePage.employeeLeaveBalace}" var="currentRow" width="100%">
                                                    <ice:column groupOn="#{currentRow['employeeId']}" id="colEmployeeId" style="width: 88px;text-align:center;">
                                                        <ice:outputText id="txtTblEmployeeId" value="#{currentRow['employeeId']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="lblTblEmployeeId" style="font-size: 10px; text-align: center; width: 86px" value="EMPLOYEE ID"/>
                                                        </f:facet>
                                                        <ice:rowSelector id="rowSelectorEvaSession" multiple="false" preStyleOnSelection="true"
                                                            selectionListener="#{Leave$BalancePage.rowSelectorEvaSession_processMyEvent}" toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['employeeFullName']}" id="colemployeeFullName" style="width: 290px;">
                                                        <ice:outputText id="txtTblEmployeeFullName" value="#{currentRow['employeeFullName']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="lblTBlEmployeeFullName" style="font-size: 10px; width: 238px" value="FULL NAME"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colphysicalYear" style="text-align:center;width: 100px;">
                                                        <ice:outputText id="txtTblPhysicalYear" value="#{currentRow['year']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="lblTBLPhysicalYear" style="font-size: 10px; width: 100px" value="PHYSICAL YEAR"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colAmount" style="text-align:center;">
                                                        <ice:outputText id="txtTblLeaveAmount" value="#{currentRow['amountt']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="lblTblLeaveAmount" style="font-size: 10px; width: 40px" value="LEAVE AMOUNT"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colUsedLeaveAmount" style="text-align:center;">
                                                        <ice:inputText id="txtTblUsedLeaveAmount" style="width:40px;" value="#{currentRow['usedLeaveAmount']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="lblTblUsedLeaveAmount" style="font-size: 10px; width: 40px" value="USED LEAVE AMOUNT"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['reminingLeaveAmout']}" id="colRemainingLeaveAmount" style="text-align:center;">
                                                        <ice:outputText id="txtTblRemainingLeaveAmount" value="#{currentRow['reminingLeaveAmout']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="lblTblRemainingLeaveAmount" style="font-size: 10px; width: 40px" value="REMAINING LEAVE AMOUNT"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>
                                            </ice:panelLayout>
                                            <ice:commandButton action="#{Leave$BalancePage.btnPrepare_action}" binding="#{Leave$BalancePage.btnPrepare}"
                                                disabled="true" id="btnPrepare" style="height: 50px; left: 156px; top: 62px; position: absolute; width: 153px" value="Prepare As ToDay"/>
                                        </ice:panelLayout>
                       <ice:panelPopup autoCentre="true" binding="#{Leave$BalancePage.pnMessageForEmployeeStatus}" clientOnly="true" draggable="true"
                            id="pnMessageForEmployeeStatus" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent;display: block; height: 134px; left: -100px; top: 100px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessageEmployeeStatus" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitleEmployeeStatus"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Leave$BalancePage.modalPnlCloseMesssageEmployeeStatus_action}"
                                        id="modalPnlCloseMesssageEmployeeStatus" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px;left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessageEmployeeStatus"
                                    style="display: block; height: 100px;position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBodyEmployeeStatus" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 70px; position: relative;                                         width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Leave$BalancePage.lblFormMessage1EmployeeStatus}" id="lblFormMessage1EmployeeStatus" style="color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle"/>
                                        <ice:commandButton action="#{Leave$BalancePage.btnSatusDisplayYse_action}" id="btnSatusDisplayYse"
                                            style="left: 450px; top: 55px; position: absolute; width: 50px" value="Yes"/>
                                        <ice:commandButton action="#{Leave$BalancePage.btnSatusDisplayNo_action}" id="btnSatusDisplayNo"
                                            style="left: 560px; top: 55px; position: absolute; width: 50px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label
                                                style="margin-left:10px;color:white;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com " style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK|information |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$BalancePage.pnlPopUpAttachment}" clientOnly="true" draggable="true"
                            id="pnlPopUpAttachment" modal="true" rendered="false" style="display: block; height: 455px; left: 97px; top: 146px; position: absolute; width: 812px">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridPopUpAttachment" styleClass="popupHeaderWrapper">
                                    <ice:outputText id="PopUpAttachmentTitle" style="width:400px" styleClass="popupHeaderText" value="BUNNA INTERNATIONAL BANK Human Resource Management System-Request Commented History"/>
                                    <ice:commandButton actionListener="#{Leave$BalancePage.modalPnlCloseBtnAttachment_processAction}" alt="Close"
                                        id="modalPnlCloseBtnAttachment" image="/resources/images/close.gif" immediate="true" partialSubmit="true"
                                        style="left: 789px; top: -1px; position: absolute" styleClass="popupHeaderImage" title="Close Popup" type="button"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="pnlgroupPopUpAttach" style="display: block; height: 387px; position: relative; width: 762px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:graphicImage binding="#{Leave$BalancePage.gimgAttachedDocuments}" height="364" id="gimgAttachedDocuments"
                                        style="left: 5px; top: 5px; position: absolute" width="761"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$BalancePage.pnMessage}" clientOnly="true" draggable="false" id="pnMessage"
                            modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 263px; top: 600px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Leave$BalancePage.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Leave$BalancePage.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$BalancePage.pnlPopUpMsg}" draggable="true" id="pnlPopUpMsg" modal="true"
                            rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 623px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopUpMsg" style="display: block; height: 20px; width: 500px">
                                    <ice:outputText id="lblPopUpMsgTitle" value="BUNNA INTERNATIONAL BANK Human Resource Management System"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupPopUpMsgBody" style="display: block; height: 94px; position: relative; width: 586px">
                                    <ice:commandButton action="#{Leave$BalancePage.btnPopUpNo_action}" id="btnPopUpNo"
                                        style="left: 480px; top: 60px; position: absolute; width: 70px" value="NO" visible="true"/>
                                    <ice:commandButton action="#{Leave$BalancePage.btnPopUpYes_action}" id="btnPopUpYes"
                                        style="left: 370px; top: 60px; position: absolute; width: 70px" value="Yes" visible="true"/>
                                    <ice:outputText id="lblPopUpMsgMain"
                                        style="font-size: 18px; left: 40px; top: 15px; position: absolute; text-align: left; width: 478px" value="Are you sure you want to delete ?"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$BalancePage.pnlPopupViewLeaveBalalceAsOFToDay}" draggable="true"
                            id="pnlPopupViewLeaveBalalceAsOFToDay" modal="true" rendered="false" style="border-style: none; background-color: transparent; display: block; height: 200px; left: 97px; top: 226px; position: absolute; width: 600px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions"
                                    style="background-color: rgb(48, 102, 130);  display: block; height: 27px" width="670">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="color: white; margin-top: 8px; top: 8px; text-align: left; vertical-align: middle;width:90%" value="BUNNA HRMS - View Leave Balance As of To Day "/>
                                    <ice:commandLink action="#{Leave$BalancePage.btnClosePopupViewLeaveBalnce_action}" id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; left: 653px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="pnlLayoutViewPrevieousDecisions" style="display: block; height: 230px; position: relative; width: 640px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlLayoutPopupTable"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 200px; overflow: auto; position: absolute; width: 575px" styleClass="message">
                                        <ice:dataTable binding="#{Leave$BalancePage.tblLeaveBalanceForViewBalance}" clientOnly="true"
                                            id="tblLeaveBalanceForViewBalance" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                            value="#{Leave$BalancePage.employeeLeaveBalace}" var="currentRow" width="100%">
                                            <ice:column groupOn="#{currentRow['employeeId']}" id="colEmployeeId" style="width: 88px;text-align:center;">
                                                <ice:outputText id="txtTblEmployeeIdForView" value="#{currentRow['employeeId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="lblTblEmployeeIdForView" style="font-size: 10px; text-align: center; width: 86px" value="EMPLOYEE ID"/>
                                                </f:facet>
                                                <!-- <ice:rowSelector id="rowSelectorEvaSessionForView" multiple="false" preStyleOnSelection="true"
                                                            selectionListener="#{Leave$LeaveBalancePage.rowSelectorEvaSession_processMyEvent}"
                                                            toggleOnClick="true" value="#{currentRow['selected']}"/>-->
                                            </ice:column>
                                            <ice:column groupOn="#{currentRow['employeeFullName']}" id="colemployeeFullNameForView" style="width: 290px;">
                                                <ice:outputText id="txtTblEmployeeFullNameForView" value="#{currentRow['employeeFullName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="lblTBlEmployeeFullNameForView" style="font-size: 10px; width: 238px" value="FULL NAME"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colphysicalYear" style="text-align:center;width: 100px;">
                                                <ice:outputText id="txtTblPhysicalYearForView" value="#{currentRow['year']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="lblTBLPhysicalYearForView" style="font-size: 10px; width: 100px" value="PHYSICAL YEAR"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colAmountForView" style="text-align:center;">
                                                <ice:outputText id="txtTblLeaveAmountForView" value="#{currentRow['amountt']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="lblTblLeaveAmountForView" style="font-size: 10px; width: 40px" value="LEAVE AMOUNT"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colUsedLeaveAmountForView" style="text-align:center;">
                                                <ice:inputText disabled="true" id="txtTblUsedLeaveAmountForView" style="width:40px;" value="#{currentRow['usedLeaveAmount']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="lblTblUsedLeaveAmountForView" style="font-size: 10px; width: 40px " value="USED LEAVE AMOUNT"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column groupOn="#{currentRow['reminingLeaveAmout']}" id="colRemainingLeaveAmountForView" style="text-align:center;">
                                                <ice:outputText id="txtTblRemainingLeaveAmountForView" value="#{currentRow['reminingLeaveAmout']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="lblTblRemainingLeaveAmountForView" style="font-size: 10px; width: 40px" value="REMAINING LEAVE AMOUNT"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colRemainingLeaveAmountasOFToDay" style="text-align:center;">
                                                <ice:outputText id="txtTblLeaveAsOfToDay" value="#{currentRow['leaveAsofToDay']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="lblTblLeaveAsOfToDay" style="font-size: 10px; width: 40px" value="LEAVE AS OF TO DAY"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$BalancePage.pnlPopupViewLeaveBalalceAsOFToDayForZeroYear}" draggable="true"
                            id="pnlPopupViewLeaveBalalceAsOFToDayForZeroYear" modal="true" rendered="false" style="border-style: none; background-color: transparent; display: block; height: 130px; left: 317px; top: 226px; position: absolute; width: 189px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewLeaveAsofTwoDaysForZeroYear"
                                    style="background-color: rgb(48, 102, 130);  display: block; height: 27px" width="170">
                                    <ice:outputText dir="left" id="otxtViewPrevieousLeaveBalanceForZeroyears"
                                        style="color: white; margin-top: 8px; top: 8px; text-align: left; vertical-align: middle;width:90%" value="View Leave Balance As Of To Day"/>
                                    <ice:commandLink action="#{Leave$BalancePage.btnClosePopupViewLeaveBalnceForZeroYear_action}"
                                        id="btnClosePopupViewLeaveBalanceForZeroYears" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 140px; left: 153px; top: 20px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="pnlLayoutViewLeaveBalanceForZeroYear"
                                    style="display: block; height: 130px; position: relative; width: 140px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlLayoutPopupTableForLeaveBalanceZeroYear" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 101px; overflow: auto; position: absolute; width: 77px; -rave-layout: grid" styleClass="message">
                                        <ice:outputText id="outputText14"
                                            style="color: #ff3300; font-family: 'Times New Roman',Times,serif; font-size: 12px; height: 43px; left: 0px; top: 0px; position: absolute; width: 141px" value="This Employee Has Less Than One Year Expirance And The Leave Amount Is"/>
                                        <ice:outputText binding="#{Leave$BalancePage.outTxt_LeaveAmount}" id="outTxt_LeaveAmount" style="color: rgb(51, 0, 51); font-family: 'Times New Roman','Times',serif; font-size: 18px; font-weight: bold; left: 24px; top: 72px; position: absolute; width: 69px"/>
                                        <ice:outputText id="outputText15" style="left: 110px; top: 72px; position: absolute" value="Days"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
                <div class="growlUI" id="demo12" style="background: url(check48.png) no-repeat 10px 10px">
                    <h1 style="color: white; padding: 5px 5px 5px 75px; text-align: left"></h1>
                </div>
            </body>
        </html>
    </f:view>
</jsp:root>
