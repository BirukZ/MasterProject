<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EmployeeYearBones
    Created on : Dec 18, 2012, 2:26:45 PM
    Author     : Dereje
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
                        <ice:panelBorder id="whole_page" renderCenter="#{EmployeeBones$RequestYearBones.panelBorder1Bean.renderCenter}"
                            renderEast="#{EmployeeBones$RequestYearBones.panelBorder1Bean.renderEast}"
                            renderNorth="#{EmployeeBones$RequestYearBones.panelBorder1Bean.renderNorth}"
                            renderSouth="#{EmployeeBones$RequestYearBones.panelBorder1Bean.renderSouth}"
                            renderWest="#{EmployeeBones$RequestYearBones.panelBorder1Bean.renderWest}"
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
                                <ice:panelGroup id="menu_left" style="height: 613px; top: 5px; position: relative">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 670px; left: 0px; top: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 640px; left: 0px; top: 15px; position: absolute; width: 213px" styleClass="list_menu">
                                            <ice:panelCollapsible expanded="true" id="colsEmployeeSearchByName" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup4" styleClass=""/>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" style="height:193px" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%;"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{EmployeeBones$RequestYearBones.lnkEvaluationResultPage_action}"
                                                                id="lnkEvaluationResultPage" style="color:#333333;font-weight:bold" value="Evaluation Result"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{EmployeeBones$RequestYearBones.lnkApproveYearlyBonusPage_action}"
                                                                id="lnkApproveYearlyBonusPage" style="color:#333333;font-weight:bold" value="Approve Yearly Bonus"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="colsRequestLisrt">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" style="height: 250px" width="100%">
                                                    <ice:panelGroup id="status_Group" style="border-style: none; margin: -5px -5px -5px -10px; padding: 7px; background-color: transparent; display: block; float: left; height: 510px; left: -5px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 400px; position: absolute; width: 100%">
                                                            <ice:outputText id="lblPerviousRequestList"
                                                                style="font-family: Cambria; left: 10px; top: 10px; position: absolute" value="Pervious Request List  "/>
                                                            <ice:selectOneListbox accesskey="" id="chkPerviousRequestList" partialSubmit="true" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); height: 300px; left: 10px; top: 30px; position: absolute; width: 180px"
                                                                value="#{EmployeeBones$RequestYearBones.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{EmployeeBones$RequestYearBones.chkPerviousRequestList_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{EmployeeBones$RequestYearBones.prerviousRequestList}"/>
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
                                <ice:panelGroup id="page_display" style="height: 810px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 700px; left: 10px; position: relative; top: 20px; width: 800px; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 780px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Request Yearly Bonus "/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 760px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup id="leaveRequest" style="height: 745px; width: 95%" styleClass="filedset_normal">
                                                    <ice:panelLayout id="panelDetail12" style="border: 1px solid rgb(204, 204, 204); height: 170px; left: 10px; top: 40px; position: absolute; width: 780px">
                                                        <ice:outputText id="outputText1" style="font-size: 10px; left: 38px; top: 20px; position: absolute" value="Prepare In:"/>
                                                        <ice:outputText id="outputText2" style="font-size: 10px; left: 38px; top: 54px; position: absolute" value="Approve Bones Amount : "/>
                                                        <ice:outputText id="outputText3" style="font-size: 10px; left: 38px; top: 88px; position: absolute" value="Evaluation From :"/>
                                                        <ice:selectOneMenu binding="#{EmployeeBones$RequestYearBones.drlPrepareIn}" id="drlPrepareIn"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 17px; position: absolute; width: 170px"
                                                            value="#{EmployeeBones$RequestYearBones.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{EmployeeBones$RequestYearBones.drlPrepareIn_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{EmployeeBones$RequestYearBones.listOfLocation}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:inputText binding="#{EmployeeBones$RequestYearBones.txtEvaluationTo}" id="txtEvaluationTo" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 570px; top: 88px; position: absolute; width: 170px"/>
                                                        <ice:commandButton action="#{EmployeeBones$RequestYearBones.btnCalculateEmpBonees_action}"
                                                            id="btnCalculateEmpBonees" style="left: 200px; top: 120px; position: absolute; width: 160px" value="Calculate"/>
                                                        <ice:outputText id="outputText11" style="font-size: 10px; left: 450px; top: 54px; position: absolute" value="Number Of Employee:"/>
                                                        <ice:outputText binding="#{EmployeeBones$RequestYearBones.txtEmployeeNumber}" id="txtEmployeeNumber"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 570px; top: 54px; position: absolute; width: 160px" value=":"/>
                                                        <ice:outputText id="outputText13" style="font-size: 10px; left: 450px; top: 20px; position: absolute" value="Budget Year:"/>
                                                        <ice:selectOneMenu binding="#{EmployeeBones$RequestYearBones.drlBonusYear}" id="drlBonusYear"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 570px; top: 17px; position: absolute; width: 170px" value="#{EmployeeBones$RequestYearBones.selectOneMenu2Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu2selectItems" value="#{EmployeeBones$RequestYearBones.listOfYear}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputText4" style="font-size: 10px; left: 450px; top: 88px; position: absolute" value="Evaluation To :"/>
                                                        <ice:selectOneMenu binding="#{EmployeeBones$RequestYearBones.drlBonesAmount}" id="drlBonesAmount"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 54px; position: absolute; width: 170px" value="#{EmployeeBones$RequestYearBones.selectOneMenu4Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu4selectItems" value="#{EmployeeBones$RequestYearBones.listOfBones}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:inputText binding="#{EmployeeBones$RequestYearBones.txtEvaluationFrom}" id="txtEvaluationFrom" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 88px; position: absolute; width: 170px"/>
                                                        <ice:commandButton action="#{EmployeeBones$RequestYearBones.button4_action}" id="button4"
                                                            image="/resources/images/cal_button.gif" style="left: 325px; top: 93px; position: absolute" value="submit"/>
                                                        <ice:commandButton action="#{EmployeeBones$RequestYearBones.button5_action}" id="button5"
                                                            image="/resources/images/cal_button.gif" style="left: 725px; top: 93px; position: absolute" value="submit"/>
                                                        <ice:selectInputDate binding="#{EmployeeBones$RequestYearBones.calEvaluationFrom}"
                                                            id="calEvaluationFrom" rendered="false"
                                                            style="height: 212px; left: 160px; top: 110px; position: absolute; width: 190px; z-index: 200"
                                                            value="#{EmployeeBones$RequestYearBones.selectInputDate1Bean.date1}" valueChangeListener="#{EmployeeBones$RequestYearBones.calEvaluationFrom_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{EmployeeBones$RequestYearBones.calEvaluationTo}" id="calEvaluationTo"
                                                            rendered="false"
                                                            style="height: 212px; left: 560px; top: 110px; position: absolute; width: 190px;&#xa;z-index:200"
                                                            value="#{EmployeeBones$RequestYearBones.selectInputDate2Bean.date1}" valueChangeListener="#{EmployeeBones$RequestYearBones.calEvaluationTo_processValueChange}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyRequestInformationTable" style="border: 1px solid rgb(204, 204, 204); height: 500px; left: 10px; top: 220px; overflow: auto; position: absolute; width: 780px">
                                                        <ice:dataTable id="dataTable1" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                            value="#{EmployeeBones$RequestYearBones.listOfEmployee}" var="currentRow">
                                                            <ice:column id="column1">
                                                                <ice:outputText id="outputText5" value="#{currentRow['employeeId']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText6" value="Employee Id"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column2">
                                                                <ice:outputText id="outputText7" value="#{currentRow['employeeName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText8" value="Employee Name"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colExprience">
                                                                <ice:outputText id="txtExprience" value="#{currentRow['exprience']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblExprience" value="Exprience"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colSalary">
                                                                <ice:outputText id="txtSalary" value="#{currentRow['salary']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblSalary" value="Salary"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column3">
                                                                <ice:outputText id="outputText9" value="#{currentRow['evaluationResult']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText10" value="Evaluation"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelectorBonessRequest" multiple="false" preStyleOnSelection="true"
                                                                    selectionListener="#{EmployeeBones$RequestYearBones.rowSelectorBonessRequest_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selectList']}"/>
                                                            </ice:column>
                                                            <ice:column id="colMon">
                                                                <ice:outputText id="txtMonth" value="#{currentRow['acquireMonth']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblMonth" value="Acquire Percentage"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colBirr">
                                                                <ice:outputText id="txtBirr" value="#{currentRow['amountInBirr']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblBirr" value="Amount in Birr  "/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyApproverInformation" style="border: 1px solid rgb(204, 204, 204); left: 10px; top: 730px; position: absolute; width: 780px">
                                                        <ice:commandButton action="#{EmployeeBones$RequestYearBones.btnRequest_action}"
                                                            binding="#{EmployeeBones$RequestYearBones.btnRequest}" id="btnRequest" partialSubmit="true"
                                                            style="margin-left: 40px; width: 120px" value="Request"/>
                                                        <ice:commandButton action="#{EmployeeBones$RequestYearBones.bntRemove_action}"
                                                            binding="#{EmployeeBones$RequestYearBones.bntRemove}" id="bntRemove"
                                                            style="margin-left: 40px; width: 120px" value="Remove"/>
                                                        <ice:commandButton action="#{EmployeeBones$RequestYearBones.button2_action}" id="button2"
                                                            rendered="false" style="margin-left: 40px; width: 120px" value="Cancel"/>
                                                        <ice:commandButton id="button3" rendered="false" style="margin-left: 40px; width: 120px" value="Update"/>
                                                    </ice:panelLayout>
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
                                                href="http://www.google.com" style="margin-left:10px;color:#333333;">BUNNA INTERNATIONAL BANK |information |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeBones$RequestYearBones.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management"/>
                                    <ice:commandLink action="#{EmployeeBones$RequestYearBones.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{EmployeeBones$RequestYearBones.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
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
