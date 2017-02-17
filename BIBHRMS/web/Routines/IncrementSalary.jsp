<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : IncrementSalary
    Created on : Oct 21, 2011, 8:36:53 AM
    Author     : Bini
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Increment Salary</title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/ETH/KAMSI_CAL_STYLE.css" id="outputStyle22"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <script src="../Script/jquery-1.3.2.min.js"></script>
                <script src="../resources/ETH/KAMSI_CAL_SCRIPT.js"></script>
                <script language="javascript" type="text/javascript">
                    var IncrementSalary=jQuery.noConflict();
                </script>
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
            </head>
            <body id="outputBody1" onload="showCal()" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelBorder height="680" id="whole_page" renderCenter="#{Page1.panelBorder1Bean.renderCenter}"
                        renderEast="#{Page1.panelBorder1Bean.renderEast}" renderNorth="#{Page1.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Page1.panelBorder1Bean.renderSouth}" renderWest="#{Page1.panelBorder1Bean.renderWest}"
                        style="top: 0px; position: relative" styleClass="whole_page" width="1024px">
                        <f:facet name="north">
                            <ice:panelGroup id="page_header" style="height: 105px">
                                <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow" style="height: 105px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                    styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                                <!-- End Header -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup id="menu_left" style=" height:100%; border:none; ">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height: 300px; border:none; left: 5px; top:18px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 100px; border:none; left: 0px; top: 10px; position: absolute; width: 213px" styleClass="left_menu">
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible1" immediate="true" style="top:15px;border:none">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup1" styleClass="">
                                                    <ice:outputText id="lblRecruitmentRequest" value="Common Tasks"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid1" style="border:none" width="100%">
                                                <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                    <li>
                                                        <ice:commandLink action="#{Routines$IncrementSalary.cmdAssignQuestionnaire_action}"
                                                            id="cmdAssignQuestionnaire" immediate="true" partialSubmit="true"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Salary Scale"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Routines$IncrementSalary.cmdQuestionnaire_action}" id="cmdQuestionnaire"
                                                            immediate="true" partialSubmit="true"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Organization"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Routines$IncrementSalary.cmdAnalyzeGrading_action}" id="cmdAnalyzeGrading"
                                                            immediate="true" partialSubmit="true" style="color: rgb(48, 102, 130); font-weight: bold; text-align: left"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Routines$IncrementSalary.cmdAnalyzeReGrading_action}"
                                                            id="cmdAnalyzeReGrading" immediate="true" partialSubmit="true" style="color: rgb(48, 102, 130); font-weight: bold; text-align: left"/>
                                                    </li>
                                                </ul>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible3">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup2" styleClass="">
                                                    <ice:outputText id="outputText4"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid2" style="border:none" width="100%"/>
                                        </ice:panelCollapsible>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 995px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 970px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <ice:panelTabSet binding="#{Routines$IncrementSalary.panelTabSet}" id="panelTabSet"
                                        style="left: 0px; top: 0px; position: absolute; width: 98%" tabPlacement="Top">
                                        <ice:panelTab id="pnlTabOptions" label="Increament Salary">
                                            <ice:panelLayout id="pnlOptions" layout="flow" style="border-width: 1px; border-style: none; height: 915px; left: 0px; top: 0px; position: relative; width: 100%">
                                                <ice:panelLayout id="panelLayout4" layout="flow"
                                                    style="border-width: 1px; height: 166px; left: 15px; top: 24px; position: absolute; width: 715px; -rave-layout: grid" styleClass="insideContainerMain">
                                                    <ice:commandButton action="#{Routines$IncrementSalary.button1_action}" id="button1"
                                                        image="/resources/images/cal_icon.JPG" style="left: 344px; top: 21px; position: absolute" value="submit"/>
                                                    <ice:inputText binding="#{Routines$IncrementSalary.txtDate}" disabled="true" id="txtDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 22px; position: absolute; width: 220px"/>
                                                    <ice:selectInputDate binding="#{Routines$IncrementSalary.calFromDate}" id="calFromDate" rendered="false"
                                                        style="height: 212px; left: 336px; top: 48px; position: absolute; width: 190px; z-index: 1"
                                                        value="#{Routines$IncrementSalary.selectInputDate1Bean.date1}" valueChangeListener="#{Routines$IncrementSalary.calFromDate_processValueChange}"/>
                                                    <ice:outputLabel id="option" style="left: 24px; top: 24px; position: absolute" value="Date"/>
                                                    <ice:inputTextarea binding="#{Routines$IncrementSalary.txtaDesc}" disabled="true" id="txtaDesc" style="left: 118px; top: 70px; position: absolute; width: 551px"/>
                                                    <ice:outputLabel id="outputLabel1" style="left: 24px; top: 72px; position: absolute" value="Description"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlOption"
                                                    style="height: 615px; left: 15px; top: 212px; position: absolute; width: 715px; overflow: auto;" styleClass="insideContainerMain">
                                                    <ice:dataTable id="tblEmpsForInc" style="left:0;top:-10;width:100%;position:absolute"
                                                        value="#{Routines$IncrementSalary.incrementPayGradeManagerList}" var="currentRow" varStatus="rowIndex" width="100%">
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
                                                        <ice:column id="columnLastInc">
                                                            <ice:outputText id="outputTextLastInc" value="#{currentRow['lastIncrementDate']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputTextLastInc2" value="Last Increment"/>
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
                                                            <ice:selectBooleanCheckbox binding="#{Routines$IncrementSalary.cboSelectforIncrement}"
                                                                disabled="true" id="cboSelectforIncrement" partialSubmit="true" value="#{currentRow['selected']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputSelect" value="Select"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlCommandBtn2" layout="flow"
                                                    style="border-width: 1px; border-style: solid; height: 60px; left: 15px; top: 850px; position: absolute; width: 715px; -rave-layout: grid" styleClass="insideContainerMain">
                                                    <ice:commandButton action="#{Routines$IncrementSalary.btnNewEditOpt_action}"
                                                        binding="#{Routines$IncrementSalary.btnNewEditOpt}" id="btnNewEditOpt"
                                                        style="left: 48px; top: 14px; position: absolute; width: 95px" value="New/Edit"/>
                                                    <ice:commandButton action="#{Routines$IncrementSalary.btnDelete_action}"
                                                        binding="#{Routines$IncrementSalary.btnDelete}" id="btnDelete" rendered="false"
                                                        style="left: 368px; top: 10px; position: absolute; width: 95px" value="Update"/>
                                                    <ice:commandButton action="#{Routines$IncrementSalary.btnSaveUpdateOpt_action}"
                                                        binding="#{Routines$IncrementSalary.btnSaveUpdateOpt}" id="btnSaveUpdateOpt"
                                                        style="left: 192px; top: 14px; position: absolute; width: 95px" value="Confirm"/>
                                                    <ice:commandButton binding="#{Routines$IncrementSalary.btnDeleteGroup}" id="btnDeleteGroup" rendered="false"
                                                        style="left: 498px; top: 10px; position: absolute; width: 95px" value="Delete "/>
                                                    <ice:commandButton action="#{Routines$IncrementSalary.btnUncheckAll_action}"
                                                        binding="#{Routines$IncrementSalary.btnUncheckAll}" id="btnUncheckAll"
                                                        style="left: 336px; top: 14px; position: absolute" value="Uncheck All"/>
                                                    <ice:commandButton action="#{Routines$IncrementSalary.btnCheckAll_action}"
                                                        binding="#{Routines$IncrementSalary.btnCheckAll}" id="btnCheckAll"
                                                        style="left: 480px; top: 14px; position: absolute" value="Check All"/>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </ice:panelTab>
                                    </ice:panelTabSet>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="south">
                            <ice:panelGroup id="page_footer" style=" text-align: center;">
                                <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">This is the Footer</ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                    <ice:panelPopup autoCentre="true" binding="#{Routines$IncrementSalary.pnMessage}" clientOnly="true" draggable="false" id="pnMessage"
                        modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnMessageTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="National Bank of Ethiopia Human Resource Management And Integrated Payroll System:Message"/>
                                <ice:commandLink action="#{Routines$IncrementSalary.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage" immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlMessageBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{Routines$IncrementSalary.lblFormMessage}" id="lblFormMessage" style="background-color: #F5F5F5;"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Routines$IncrementSalary.panelPopup}" draggable="true" id="panelPopup" modal="true"
                        rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 120px; left: 96px; top: 936px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGrid id="panelGrid11" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="outputText10"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="National Bank of Ethiopia Human Resource Management And Integrated Payroll System:Message"/>
                                <ice:commandLink id="cmdConfirmationCloseDeleete" immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 744px; top: 15px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGrid>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelConfirmationDelete" style="display: block; height: 60px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlConfirmationDeleteBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 35px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel id="lblFormDeleteMessage"
                                        style="color: green; font-size: 12px; font-weight: bold; left: 24px; top: 24px; position: absolute; text-align: center; vertical-align: middle" value="ARE YOU SURE YOU WANT TO DELETE JOB ?"/>
                                    <ice:commandButton action="#{Routines$IncrementSalary.bntYES_action}" id="bntYES"
                                        style="left: 360px; top: 14px; position: absolute; width: 80px" value="Yes"/>
                                    <ice:commandButton action="#{Routines$IncrementSalary.btnNo_action}" id="btnNo"
                                        style="left: 456px; top: 14px; position: absolute; width: 80px" value="No"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Routines$IncrementSalary.popupConfirmInc}" draggable="true" id="popupConfirmInc" modal="true"
                        rendered="true" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 623px">
                        <f:facet name="header">
                            <ice:panelGrid id="panelGridemployeePopUpMsg" style="display: block; height: 20px; width: 500px">
                                <ice:outputText id="lblemployeePopUpMsgTitle" value="Mugher Cement Enterprise Human Resource Management System"/>
                            </ice:panelGrid>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelGroupemployeePopUpMsgBody" style="display: block; height: 94px; position: relative; width:586px">
                                <ice:commandButton action="#{Routines$IncrementSalary.btnPoppupNo_action}" id="btnPoppupNo" immediate="true"
                                    partialSubmit="true" rendered="true" style="left: 510px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                    value="No" visible="true"/>
                                <ice:commandButton action="#{Routines$IncrementSalary.btnPoppupYes_action}" id="btnPoppupYes" immediate="true"
                                    partialSubmit="true" rendered="true"
                                    style="background-position: 0 100%; background-repeat: no-repeat; left: 430px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                    value="Yes" visible="true"/>
                                <ice:outputText id="lblConfirmDelete" style="font-size: 18px; left: 95px; top: 14px; position: absolute; width: 496px" value="Are You Sure to increment the salary of all selected employees?"/>
                                <ice:panelLayout id="panelLayoutImageHolderemployee" rendered="true"
                                    style=" width:62; height:56px; left: 10px; top: 15px; position: absolute;" styleClass="popUpBgimage" visible="true"/>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
