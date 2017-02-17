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
                        <ice:panelBorder id="whole_page" renderCenter="#{Routines$IncrementSalaryRequest.panelBorder1Bean.renderCenter}"
                            renderEast="#{Routines$IncrementSalaryRequest.panelBorder1Bean.renderEast}"
                            renderNorth="#{Routines$IncrementSalaryRequest.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Routines$IncrementSalaryRequest.panelBorder1Bean.renderSouth}"
                            renderWest="#{Routines$IncrementSalaryRequest.panelBorder1Bean.renderWest}"
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
                                <ice:panelGroup id="menu_left" style="height: 613px; top: 37px; position: relative">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 670px; left: 0px; top: -12px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 640px; left: 5px; top: 0px; position: absolute; width: 213px" styleClass="list_menu">
                                            <ice:panelCollapsible expanded="true" id="colsEmployeeSearchByName" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup4">
                                                        <ice:outputText id="lblRecruitmentRequest" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid4" style="height: 200px; width: 100%;border:none">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Routines$IncrementSalary.cmdAssignQuestionnaire_action}"
                                                                id="cmdAssignQuestionnaire" immediate="true" partialSubmit="true"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Salary Scale"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Routines$IncrementSalary.cmdQuestionnaire_action}" id="cmdQuestionnaire"
                                                                immediate="true" partialSubmit="true"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Organization Structure"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Routines$IncrementSalary.cmdAnalyzeGrading_action}"
                                                                id="cmdAnalyzeGrading" immediate="true" partialSubmit="true"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Employee Profile"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Routines$IncrementSalary.cmdAnalyzeReGrading_action}"
                                                                id="cmdAnalyzeReGrading" immediate="true" partialSubmit="true"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Job Type"/>
                                                        </li>
                                                    </ul>
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
                                        style="height: 720px; left: 10px; top: 20px; position: relative; width: 800px; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 800px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Yearly Salary Increment"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 800px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup id="leaveRequest" style="height: 745px; width: 95%" styleClass="filedset_normal">
                                                    <ice:panelLayout id="panelDetail12" style="border: 1px solid rgb(204, 204, 204); height: 170px; left: 10px; top: 40px; position: absolute; width: 780px">
                                                        <ice:outputText id="outputText1" style="font-size: 10px; left: 38px; top: 20px; position: absolute" value="Increment Day"/>
                                                        <ice:outputText id="outputText3" style="font-size: 10px; left: 38px; top: 54px; position: absolute" value="Request Date"/>
                                                        <ice:inputText binding="#{Routines$IncrementSalaryRequest.txtIncremntDay}" id="txtIncremntDay" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 17px; position: absolute; width: 190px"/>
                                                        <ice:inputText binding="#{Routines$IncrementSalaryRequest.txtRequestDate}" id="txtRequestDate" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 54px; position: absolute; width: 190px"/>
                                                        <ice:outputText id="outputText2" style="font-size: 10px; left: 38px; top: 88px; position: absolute" value="Description"/>
                                                        <ice:inputTextarea binding="#{Routines$IncrementSalaryRequest.txtDescription}" id="txtDescription" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 88px; position: absolute; width: 591px"/>
                                                        <ice:commandButton action="#{Routines$IncrementSalaryRequest.btnIncrementDay_action}"
                                                            id="btnIncrementDay" image="/resources/images/cal_button.gif"
                                                            style="left: 325px; top: 22px; position: absolute" value="submit"/>
                                                        <ice:commandButton action="#{Routines$IncrementSalaryRequest.btnRequestDate_action}" id="btnRequestDate"
                                                            image="/resources/images/cal_button.gif" style="left: 325px; top: 58px; position: absolute" value="submit"/>
                                                        <ice:selectInputDate binding="#{Routines$IncrementSalaryRequest.calIncrementDay}" id="calIncrementDay"
                                                            renderMonthAsDropdown="true" renderYearAsDropdown="true" rendered="false"
                                                            style="height: 212px; left: 100px; top: 40px; position: absolute; width: 190px; z-index: 400"
                                                            value="#{Routines$IncrementSalaryRequest.selectInputDate1Bean.date1}" valueChangeListener="#{Routines$IncrementSalaryRequest.calIncrementDay_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{Routines$IncrementSalaryRequest.calRequestDate}" id="calRequestDate"
                                                            renderMonthAsDropdown="true" renderYearAsDropdown="true" rendered="false"
                                                            style="height: 212px; left: 100px; top: 75px; position: absolute; width: 190px; z-index: 40"
                                                            value="#{Routines$IncrementSalaryRequest.selectInputDateBean2.date1}" valueChangeListener="#{Routines$IncrementSalaryRequest.calRequestDate_processValueChange}"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtIncremntDay" id="message1"
                                                            infoClass="infoMessage" showSummary="true" style="left: 350px; top: 20px; position: absolute" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{Routines$IncrementSalaryRequest.lySalayIncremantButton}"
                                                        id="lySalayIncremantButton" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 47px; left: 10px; top: 220px; position: absolute; width: 780px">
                                                        <ice:commandButton action="#{Routines$IncrementSalaryRequest.button1_action}" id="button1"
                                                            style="left: 20px; top: 6px; position: absolute; width: 99px" value="Calculate "/>
                                                        <ice:outputText id="outputText4"
                                                            style="font-size: 10px; left: 200px; top: 5px; position: absolute; text-decoration: underline" value="Total Employee "/>
                                                        <ice:outputText binding="#{Routines$IncrementSalaryRequest.lblTotalEmployee}" id="lblTotalEmployee"
                                                            style="font-size: 10px; font-weight: bold; height: 19px; left: 205px; top: 24px; position: absolute; width: 58px" value="0"/>
                                                        <ice:outputText id="outputText6"
                                                            style="font-size: 10px; left: 350px; top: 5px; position: absolute; text-decoration: underline" value="Employees Calculated they Increment"/>
                                                        <ice:outputText binding="#{Routines$IncrementSalaryRequest.lblEmployeeCalculatedSalary}"
                                                            id="lblEmployeeCalculatedSalary"
                                                            style="font-size: 10px; font-weight: bold; left: 400px; top: 25px; position: absolute" value="0"/>
                                                        <ice:outputText id="outputText7"
                                                            style="font-size: 10px; left: 570px; top: 5px; position: absolute; text-decoration: underline" value="Employees not Calculated they Increment"/>
                                                        <ice:outputText binding="#{Routines$IncrementSalaryRequest.lblNotEmployeeNotincremtn}"
                                                            id="lblNotEmployeeNotincremtn"
                                                            style="font-size: 10px; font-weight: bold; left: 650px; top: 25px; position: absolute" value="0"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyRequestInformation" style="border: 1px solid rgb(204, 204, 204); height: 467px; left: 10px; top: 275px; position: absolute; width: 780px;overflow:auto">
                                                        <ice:dataTable id="tblEmpsForInc" style="left:0;top:-10;width:100%;position:absolute"
                                                            value="#{Routines$IncrementSalaryRequest.incrementPayGradeManagerList}" var="currentRow"
                                                            varStatus="rowIndex" width="100%">
                                                            <ice:column id="column1No" style="height: 25px; width: 43px">
                                                                <ice:outputText id="outputText5No" value="#{rowIndex.index+1}"/>
                                                                <f:facet name="headerNo">
                                                                    <ice:outputText id="outputText6No" value="No"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnEmpId">
                                                                <ice:outputText id="outputTextEmpId" value="#{currentRow['empId']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextEmpId2" value="Emp Id"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnEmpName">
                                                                <ice:outputText id="outputTextEmpName" value="#{currentRow['empName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextEmpName2" value="Full Name"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnDept">
                                                                <ice:outputText id="outputTextDept" value="#{currentRow['deptDesc']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextDept2" value="Department"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnHday">
                                                                <ice:outputText id="outputTextHday" value="#{currentRow['hiredDate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextHday2" value="Hired Date"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnCpgrade">
                                                                <ice:outputText id="outputTextCPgrade" value="#{currentRow['currentPayGrade']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextCPgrade2" value="Paygrade"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnCsalary">
                                                                <ice:outputText id="outputTextSalary" value="#{currentRow['currentSalary']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextSalary2" value="Salary"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnNpgrade">
                                                                <ice:outputText id="outputTextNpgrade" value="#{currentRow['nextPayGrade']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextNpgrade2" value="Next Paygrade"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnPercentage">
                                                                <ice:outputText id="outputTextPercentage" value="#{currentRow['incPercentage']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextPercentage2" value="Percentage"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnNsalary">
                                                                <ice:outputText id="outputTextNsalary" value="#{currentRow['nextSalary']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputNsalary2" value="Next Salary"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnSelect">
                                                                <ice:selectBooleanCheckbox binding="#{Routines$IncrementSalaryRequest.chkSelected}"
                                                                    id="chkSelected" partialSubmit="true" value="#{currentRow['selected']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputSelect" value="Select"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lySalaryIncrement" rendered="true" style="border: 1px solid rgb(204, 204, 204); left: 5px; top: 750px; position: absolute; width: 780px">
                                                        <ice:commandButton action="#{Routines$IncrementSalaryRequest.btn_action}" id="btn"
                                                            style="margin-left: 40px; width: 140px" value="submit"/>
                                                        <ice:commandButton action="#{Routines$IncrementSalaryRequest.btnReport_action}" id="btnReport"
                                                            style="margin-left: 40px; width: 140px" value="Show me on Report"/>
                                                        <ice:commandButton action="#{Routines$IncrementSalaryRequest.bntUnCheckAll_action}" id="bntUnCheckAll"
                                                            style="margin-left: 40px; width: 140px" value="Uncheck All"/>
                                                        <ice:commandButton action="#{Routines$IncrementSalaryRequest.btnCheckAll_action}" id="btnCheckAll"
                                                            style="margin-left: 40px; width: 140px" value="Check All"/>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
