<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Templete
    Created on : Dec 26, 2012, 10:33:40 AM
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Employee Registration</title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/images/main.css"/>
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
                    function IncrementSalaryRequest(field){
                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;
                    }
                </script>
                <link HREF="../header_icon.ico" REL="icon"/>
            </head>
            <body id="outputBody1">
                <ice:form id="form1">
                    <div style="width:100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{DailyWorker$DailyWorkerAttendancePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{DailyWorker$DailyWorkerAttendancePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{DailyWorker$DailyWorkerAttendancePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{DailyWorker$DailyWorkerAttendancePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{DailyWorker$DailyWorkerAttendancePage.panelBorder1Bean.renderWest}"
                            style="top: 5px; position: relative; background:transparent;" styleClass="whole_page" width="1024">
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
                                <ice:panelGroup id="menu_left" style="height: 613px; top: 0px; position: relative">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 670px; left: 10px; top: 10px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 640px; left: 0px; top: 15px; position: absolute; width: 213px" styleClass="list_menu">
                                            <ice:panelCollapsible expanded="true" id="colsEmployeeSearchByName" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup4" styleClass=""/>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;display: block;float:left;height: 270px; width: 100%">
                                                        <ice:outputLabel id="lblJob"
                                                            style="left: 10px; top: 40px; position: absolute; text-align: center; width: 177px" value="Job"/>
                                                        <ice:outputLabel id="lblDateOfAttandanceTaken"
                                                            style="left: 10px; top: 85px; position: absolute; text-align: center; width: 177px" value="#{msgAttendance.Date}"/>
                                                        <ice:inputText binding="#{DailyWorker$DailyWorkerAttendancePage.txtfAbsentDateSearch}"
                                                            id="txtfAbsentDateSearch" style="border: 1px solid rgb(115, 179, 206); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 15px; top: 105px; position: absolute; width: 180px"/>
                                                        <ice:commandButton action="#{DailyWorker$DailyWorkerAttendancePage.btnSearchAttendance_action}"
                                                            id="btnSearchAttendance" partialSubmit="true"
                                                            style="left: 30px; top: 125px; position: absolute; width: 153px" value="#{msgAttendance.Search}"/>
                                                        <ice:commandButton action="#{DailyWorker$DailyWorkerAttendancePage.calDateAttendaceSearch_action}"
                                                            binding="#{DailyWorker$DailyWorkerAttendancePage.calDateAttendaceSearch}"
                                                            id="calDateAttendaceSearch" image="/resources/images/cal_button.gif" partialSubmit="true"
                                                            style="left: 177px; top: 110px; position: absolute" value="submit"/>
                                                        <ice:panelGroup id="panDefineAttendance" style="margin: 140px 5px 5px -5px; padding: 7px; background-color: transparent; display: block; float: left; height: 270px; left: -5px; width: 100%"/>
                                                        <ice:selectOneMenu binding="#{DailyWorker$DailyWorkerAttendancePage.drlSearchJob}" id="drlSearchJob"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 15px; top: 60px; position: absolute; width: 180px" value="#{DailyWorker$DailyWorkerAttendancePage.defaultSelectedData1.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems1" value="#{DailyWorker$DailyWorkerAttendancePage.listOfJobs}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectInputDate binding="#{DailyWorker$DailyWorkerAttendancePage.calSearchDate}" id="calSearchDate"
                                                            rendered="false" style="height: 212px; left: 10px; top: 120px; position: absolute; width: 190px"
                                                            value="#{DailyWorker$DailyWorkerAttendancePage.selectInputDateBean1.date1}" valueChangeListener="#{DailyWorker$DailyWorkerAttendancePage.calSearchDate_processValueChange}"/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="colsRequestLisrt">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass=""/>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid1" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:225px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="border-style: none; background-color: transparent; height: 78px; position: absolute; width: 100%"/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 900px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 811px; left: 0px; top:20px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 750px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="#{msgAttendance.MaintainAttendanceRecord}"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 770px; left: 0px; top: 24px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 695px" styleClass="filedset_border">
                                                    <ice:inputText binding="#{DailyWorker$DailyWorkerAttendancePage.txtfAttendaceDate}" id="txtfAttendaceDate"
                                                        partialSubmit="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 30px; position: absolute; width: 190px"/>
                                                    <ice:commandButton action="#{DailyWorker$DailyWorkerAttendancePage.btnSave_action}"
                                                        binding="#{DailyWorker$DailyWorkerAttendancePage.btnSave}" disabled="true" id="btnSave"
                                                        partialSubmit="true" style="left: 190px; top: 660px; position: absolute; width: 120px" value="#{msgAttendance.Save}"/>
                                                    <ice:commandButton action="#{DailyWorker$DailyWorkerAttendancePage.btnUpdate_action}"
                                                        binding="#{DailyWorker$DailyWorkerAttendancePage.btnUpdate}" disabled="true" id="btnUpdate"
                                                        partialSubmit="true" style="left: 335px; top: 660px; position: absolute; width: 120px" value="#{msgAttendance.Update}"/>
                                                    <ice:commandButton action="#{DailyWorker$DailyWorkerAttendancePage.btnDelete_action}"
                                                        binding="#{DailyWorker$DailyWorkerAttendancePage.btnDelete}" disabled="true" id="btnDelete"
                                                        style="left: 620px; top: 660px; position: absolute; width: 120px" value="Delete"/>
                                                    <ice:panelLayout id="pnlAbsentee" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 486px; left: 30px; top: 150px; overflow: auto; position: absolute; width: 732px">
                                                        <ice:dataTable id="tblAbsentee" style="  top: -10px; position: absolute; width: 100%"
                                                            value="#{DailyWorker$DailyWorkerAttendancePage.attendancedailyWorker}" var="currentRow">
                                                            <ice:column id="colEmpFullName1" style="width:250px;cursor:pointer;">
                                                                <h:outputText id="outputTex234t5" value="#{currentRow['dailyWorkerFullName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText71" value="Full Name"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column3" style="text-align: center;">
                                                                <ice:selectBooleanCheckbox binding="#{DailyWorker$DailyWorkerAttendancePage.chkPresent}"
                                                                    id="chkPresent" partialSubmit="true" value="#{currentRow['present']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblPresent" value="Present "/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colDayCval" style="text-align: center;">
                                                                <ice:inputText binding="#{DailyWorker$DailyWorkerAttendancePage.txtDayValue}" id="txtDayValue"
                                                                    style="text-align: center;width:100px" value="#{currentRow['dayValue']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblDayVal" value="Day Value"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colStatus">
                                                                <ice:selectBooleanCheckbox binding="#{DailyWorker$DailyWorkerAttendancePage.chkStatus}"
                                                                    id="chkStatus" partialSubmit="true" value="#{currentRow['selected']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblSelectMekeDesstion" value="Select Here for Decision"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:outputLabel id="lblDate" style="font-size: 12px; left: 600px; top: -20px; position: absolute" value="#{msgAttendance.currentDate}"/>
                                                    <ice:outputLabel id="outputLabel2" style="font-size: 12px; left: 40px; top: 35px; position: absolute" value="#{msgAttendance.Date}"/>
                                                    <ice:outputLabel id="outputLabel1" style="font-size: 12px; left: 40px; top: 110px; position: absolute" value="Job :"/>
                                                    <ice:outputLabel binding="#{Attendance$AttendancePage.stxtDate}" id="stxtDate" style="color: rgb(153, 102, 0); font-size: 12px; font-weight: bold; left: 680px; top: -21px; position: absolute; width: 104px"/>
                                                    <ice:commandButton action="#{DailyWorker$DailyWorkerAttendancePage.calDateAttendace_action}"
                                                        binding="#{DailyWorker$DailyWorkerAttendancePage.calDateAttendace}" id="calDateAttendace"
                                                        image="/resources/images/cal_button.gif" partialSubmit="true"
                                                        style="left: 345px; top: 36px; position: absolute" value="submit"/>
                                                    <ice:outputLabel id="drlReportedByEmployeeID" rendered="false" style="left: 200px; top: 10px; position: absolute; width: 100px"/>
                                                    <ice:outputLabel id="htxtfAppEmpId" rendered="false" style="left: 100px; top: 10px; position: absolute; width: 100px"/>
                                                    <ice:outputLabel id="htxtfCertEmpId" rendered="false" style="left: 10px; top: 10px; position: absolute; width: 105px"/>
                                                    <ice:commandButton action="#{DailyWorker$DailyWorkerAttendancePage.btnTakeAttendance_action}"
                                                        binding="#{DailyWorker$DailyWorkerAttendancePage.btnTakeAttendance}" id="btnTakeAttendance"
                                                        partialSubmit="true" style="left: 45px; top: 660px; position: absolute; width: 120px" value="#{msgAttendance.New}"/>
                                                    <ice:commandButton action="#{DailyWorker$DailyWorkerAttendancePage.btnCancelAttendance_action}"
                                                        binding="#{DailyWorker$DailyWorkerAttendancePage.btnCancelAttendance}" id="btnCancelAttendance"
                                                        partialSubmit="true" style="left: 480px; top: 660px; position: absolute; width: 120px" value="#{msgAttendance.Cancel}"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtfAbsentDate" id="message1"
                                                        infoClass="infoMessage"
                                                        style="font-size: 11px; left: 370px; top: 35px; position: absolute; width: 146px" warnClass="warnMessage"/>
                                                    <ice:outputText id="lblAttendanceIdDB" rendered="false"/>
                                                    <ice:outputText id="outputText1" style="font-size: 12px; left: 40px; top: 65px; position: absolute" value=" Full Name"/>
                                                    <ice:outputText id="outputText5" rendered="false"
                                                        style="color: rgb(0, 51, 0); font-family: Cambria; font-size: 14px; font-weight: bold; left: 50px; top: 400px; position: absolute" value="R : Report"/>
                                                    <ice:outputText id="outputText7" rendered="false"
                                                        style="color: rgb(0, 51, 0); font-family: Cambria; font-size: 14px; font-weight: bold; left: 150px; top: 400px; position: absolute" value="C : Cancel"/>
                                                    <ice:outputText id="outputText8" rendered="false"
                                                        style="color: rgb(0, 51, 0); font-family: Cambria; font-size: 14px; font-weight: bold; left: 250px; top: 400px; position: absolute" value="MT : Measure Taken"/>
                                                    <ice:outputText id="outputText9" rendered="false"
                                                        style="color: rgb(0, 51, 0); font-family: Cambria; font-size: 14px; font-weight: bold; left: 420px; top: 400px; position: absolute" value="MR : Measure Revoked"/>
                                                    <ice:outputText binding="#{DailyWorker$DailyWorkerAttendancePage.lblFullName}" id="lblFullName"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 170px; top: 60px; position: absolute; width: 507px" value=":"/>
                                                    <ice:selectOneMenu binding="#{DailyWorker$DailyWorkerAttendancePage.drlJob}" id="drlJob"
                                                        partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 105px; position: absolute;  width: 226px"
                                                        value="#{DailyWorker$DailyWorkerAttendancePage.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{DailyWorker$DailyWorkerAttendancePage.drlJob_processValueChange}">
                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{DailyWorker$DailyWorkerAttendancePage.listOfJobs}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:selectInputDate binding="#{DailyWorker$DailyWorkerAttendancePage.calenderDate}" id="calenderDate"
                                                        rendered="false"
                                                        style="height: 212px; left: 163px; top: 55px; position: absolute; width: 190px; z-index: 1000"
                                                        value="#{DailyWorker$DailyWorkerAttendancePage.selectInputDate1Bean.date1}" valueChangeListener="#{DailyWorker$DailyWorkerAttendancePage.calenderDate_processValueChange}"/>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{DailyWorker$DailyWorkerAttendancePage.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management"/>
                                    <ice:commandLink action="#{DailyWorker$DailyWorkerAttendancePage.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{DailyWorker$DailyWorkerAttendancePage.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{DailyWorker$DailyWorkerAttendancePage.employeePlanPopUpMsg}" draggable="true"
                            id="employeePlanPopUpMsg" modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 623px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridemployeePopUpMsg" style="display: block; height: 20px; width: 500px">
                                    <ice:outputText id="lblemployeePopUpMsgTitle" value="BUNNA INTERNATIONAL BANK  Human Resource Management "/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupemployeePopUpMsgBody" style="display: block; height: 94px; position: relative; width:586px">
                                    <ice:commandButton action="#{DailyWorker$DailyWorkerAttendancePage.btntemployeePopUpNo_action}" id="btntemployeePopUpNo"
                                        immediate="true" partialSubmit="true" rendered="true"
                                        style="left: 510px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No" visible="true"/>
                                    <ice:commandButton action="#{DailyWorker$DailyWorkerAttendancePage.btntemployeePopUpYes_action}" id="btntemployeePopUpYes"
                                        immediate="true" partialSubmit="true" rendered="true"
                                        style="background-position: 0 100%; background-repeat: no-repeat; left: 430px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                        value="Yes" visible="true"/>
                                    <ice:outputText binding="#{DailyWorker$DailyWorkerAttendancePage.lblemployeePopUpMsgMain}" id="lblemployeePopUpMsgMain" style="font-size: 18px; left: 95px; top: 30px; position: absolute; width: 496px"/>
                                    <ice:panelLayout id="panelLayoutImageHolderemployee" rendered="true"
                                        style=" width:62; height:56px; left: 10px; top: 15px; position: absolute;" styleClass="popUpBgimage" visible="true"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
