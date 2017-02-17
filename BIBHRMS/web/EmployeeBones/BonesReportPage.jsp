<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Templete
    Created on : Dec 26, 2012, 10:33:40 AM
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocaalization_Bones" var="msgBones"/>
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
                        <ice:panelBorder id="whole_page" renderCenter="#{EmployeeBones$BonesReportPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{EmployeeBones$BonesReportPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{EmployeeBones$BonesReportPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{EmployeeBones$BonesReportPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{EmployeeBones$BonesReportPage.panelBorder1Bean.renderWest}"
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
                                <ice:panelGroup id="menu_left" style="height: 613px;  position: relative">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 670px; left: 0px; top: 17px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 800px; left: 0px; top: 5px; position: absolute; width: 213px" styleClass="list_menu">
                                            <ice:panelCollapsible expanded="true" id="colsEmployeeSearchByName" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup4" styleClass=""/>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" style="height:193px" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%;"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{EmployeeBones$BonesReportPage.lnkReportGenrationCritera_action}"
                                                                id="lnkResignApprovePage" style="color:#306682;font-weight:bold" value="Report Genration Critera"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{EmployeeBones$BonesReportPage.lnkHolydayBonesRequest_action}"
                                                                id="lnkHolydayBonesRequest" style="color:#306682;font-weight:bold" value="Holyday Bones Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{EmployeeBones$BonesReportPage.lnkYearlyBonesRequest_action}"
                                                                id="lnkYearlyBonesRequest" style="color:#306682;font-weight:bold" value="Yearly Bones Request"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="colsRequestLisrt">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass=""/>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid1" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:470px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="border-style: none; background-color: transparent; height: 78px; position: absolute; width: 100%"/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 790px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 720px; left: 15px; position: relative; top: 20px; width: 800px; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 760px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Bones Report"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 800px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup id="leaveRequest" style="height: 800px; width: 95%" styleClass="filedset_normal">
                                                    <ice:panelLayout id="panelDetail12" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 200px; left: 10px; top: 40px; position: absolute; width: 780px">
                                                        <ice:outputText id="lblBudgetYear"
                                                            style="font-family: Cambria; left: 40px; top: 29px; position: absolute" value="#{msgBones.BudgetYear}"/>
                                                        <ice:outputText id="lblLocation"
                                                            style="font-family: Cambria; left: 450px; top: 29px; position: absolute" value="#{msgBones.Location}"/>
                                                        <ice:outputText binding="#{EmployeeBones$BonesReportPage.lblHolidayName}" id="lblHolidayName"
                                                            rendered="false" style="font-family: Cambria; left: 450px; top: 80px; position: absolute" value="#{msgBones.HolidayName}"/>
                                                        <ice:selectOneMenu binding="#{EmployeeBones$BonesReportPage.drlBudgetYear}" id="drlBudgetYear"
                                                            partialSubmit="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 200px; top: 29px; position: absolute; width: 205px" value="#{EmployeeBones$BonesReportPage.selectOneMenu1Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{EmployeeBones$BonesReportPage.listOfYear}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{EmployeeBones$BonesReportPage.drlLocation}" id="drlLocation"
                                                            partialSubmit="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 550px; top: 29px; position: absolute; width: 205px" value="#{EmployeeBones$BonesReportPage.defaultSelectedData2.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems1" value="#{EmployeeBones$BonesReportPage.listOfLocation}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="lblBonesType"
                                                            style="font-family: Cambria; left: 40px; top: 80px; position: absolute" value="#{msgBones.BonesType}"/>
                                                        <ice:selectOneRadio binding="#{EmployeeBones$BonesReportPage.optBonesType}" id="optBonesType"
                                                            partialSubmit="true"
                                                            style="border-width: 1px;  background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 200px; top: 80px; position: absolute; "
                                                            value="#{EmployeeBones$BonesReportPage.selectOneRadio1Bean.selectedObject}" valueChangeListener="#{EmployeeBones$BonesReportPage.optBonesType_processValueChange}">
                                                            <f:selectItems id="selectOneRadio1selectItems" value="#{EmployeeBones$BonesReportPage.listOfBonesType}"/>
                                                        </ice:selectOneRadio>
                                                        <ice:selectOneMenu binding="#{EmployeeBones$BonesReportPage.drlHolidayName}" id="drlHolidayName"
                                                            partialSubmit="true" rendered="false"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 550px; top: 80px; position: absolute; width: 205px" value="#{EmployeeBones$BonesReportPage.defaultSelectedData4.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems2" value="#{EmployeeBones$BonesReportPage.holiday_Name}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:commandButton action="#{EmployeeBones$BonesReportPage.btnDisplay_action}" id="btnDisplay"
                                                            style="left: 50px; top: 130px; position: absolute; width: 160px" value="Display"/>
                                                        <ice:commandButton action="#{EmployeeBones$BonesReportPage.btnHtml_action}" id="btnHtml"
                                                            image="/resources/images/html_icon.jpeg"
                                                            style="height: 50px; left: 450px; top: 140px; position: absolute; width: 70px" value="submit"/>
                                                        <ice:commandButton action="#{EmployeeBones$BonesReportPage.btnPdf_action}" id="btnPdf"
                                                            image="/resources/images/pdf_icon.jpg"
                                                            style="height: 50px; left: 540px; top: 140px; position: absolute; width: 70px" value="submit"/>
                                                        <ice:commandButton action="#{EmployeeBones$BonesReportPage.btnWord_action}" id="btnWord"
                                                            image="/resources/images/word-icon.png"
                                                            style="height: 50px; left: 620px; top: 140px; position: absolute; width: 70px" value="submit"/>
                                                        <ice:commandButton action="#{EmployeeBones$BonesReportPage.btnExcel_action}" id="btnExcel"
                                                            image="/resources/images/xls_icon.gif"
                                                            style="height: 50px; left: 700px; top: 140px; position: absolute; width: 70px" value="submit"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelTableHolder" style="border: 1px solid rgb(204, 204, 204); height: 500px; left: 10px; top: 250px; position: absolute; width: 780px">
                                                        <ice:dataTable binding="#{EmployeeBones$BonesReportPage.tblHolidayBones}" id="tblHolidayBones"
                                                            rendered="false" style="top: -10px; position: absolute; width:100%"
                                                            value="#{EmployeeBones$BonesReportPage.bonesList}" var="currentRow">
                                                            <ice:column id="column1" style="height: 23px; width: 239px">
                                                                <ice:outputText id="outputText1" value="#{currentRow['employeeid']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText2" value="EMPLOYEE ID"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column2">
                                                                <ice:outputText id="outputText3" value="#{currentRow['employeeFullName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText4" value="EMPLOYEE FULL NAME"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column3">
                                                                <ice:outputText id="outputText5" value="#{currentRow['bones']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText6" value="BONES"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                        <ice:dataTable binding="#{EmployeeBones$BonesReportPage.tblYearlyBonesList}" id="tblYearlyBonesList"
                                                            rendered="true" style="top: -10px; position: absolute; width:100%"
                                                            value="#{EmployeeBones$BonesReportPage.yearlyBonesList}" var="currentRow">
                                                            <ice:column id="colEMPLOYEEID">
                                                                <ice:outputText id="txtEMPLOYEEID" value="#{currentRow['employeeid']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblEMPLOYEEID" value="EMPLOYEE ID"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colEmpName">
                                                                <ice:outputText id="txtEmpName" value="#{currentRow['employeeFullName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblEmpName" value="EMPLOYEE FULL NAME"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colJUNESALARY">
                                                                <ice:outputText id="txtJUNESALARY" value="#{currentRow['juneSalary']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblJUNESALARY" value="JUNE SALARY"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colEXPERIENCE">
                                                                <ice:outputText id="txtEXPERIENCE" value="#{currentRow['experience']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblEXPERIENCE" value="EXPERIENCE"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colBONES">
                                                                <ice:outputText id="txtBONES" value="#{currentRow['bones']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblBONES" value="BONES"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <ice:outputLabel id="outputLabel1"
                                            style="color: rgb(48, 102, 130); font-family: serif; font-size: 14px; font-style: normal; font-weight: bolder; height: 18px; left: 48px; top: 0px; position: absolute; width: 622px" value="Mugher Cement Enterprise Human Resource Management System - Bones Report ."/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeBones$BonesReportPage.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 300px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Mugher Cement Enterprise Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{EmployeeBones$BonesReportPage.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{EmployeeBones$BonesReportPage.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
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
