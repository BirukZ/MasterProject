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
                        <ice:panelBorder id="whole_page" renderCenter="#{EmployeeBones$ApproveYearlyBones.panelBorder1Bean.renderCenter}"
                            renderEast="#{EmployeeBones$ApproveYearlyBones.panelBorder1Bean.renderEast}"
                            renderNorth="#{EmployeeBones$ApproveYearlyBones.panelBorder1Bean.renderNorth}"
                            renderSouth="#{EmployeeBones$ApproveYearlyBones.panelBorder1Bean.renderSouth}"
                            renderWest="#{EmployeeBones$ApproveYearlyBones.panelBorder1Bean.renderWest}"
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
                                                            <ice:commandLink action="#{EmployeeBones$ApproveYearlyBones.lnkEvaluationResultPage_action}"
                                                                id="lnkEvaluationResultPage" style="color:#333333;font-weight:bold" value="Evaluation Result"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{EmployeeBones$ApproveYearlyBones.lnkApproveYearlyBonusPage_action}"
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
                                                <ice:panelGrid id="StatusBoard" style="height: 450px" width="100%">
                                                    <ice:panelGroup id="status_Group" style="border-style: none; margin: -5px -5px -5px -10px; padding: 7px; background-color: transparent; display: block; float: left; height: 530px; left: -5px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 400px; position: absolute; width: 100%">
                                                            <ice:outputText id="lblPerviousRequestList"
                                                                style="font-family: Cambria; left: 10px; top: 10px; position: absolute" value=" Request List  "/>
                                                            <ice:selectOneListbox accesskey="" id="chkPerviousRequestList" partialSubmit="true" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); height: 300px; left: 10px; top: 30px; position: absolute; width: 180px"
                                                                value="#{EmployeeBones$ApproveYearlyBones.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{EmployeeBones$ApproveYearlyBones.chkPerviousRequestList_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{EmployeeBones$ApproveYearlyBones.prerviousRequestList}"/>
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
                                <ice:panelGroup id="page_display" style="height: 930px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 700px; left: 10px; position: relative; top: 20px; width: 800px; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 900px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Approve Yearly Bonus Request "/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 860px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup id="leaveRequest" style="height: 745px; width: 95%" styleClass="filedset_normal">
                                                    <ice:panelLayout id="panelDetail12" style="border: 1px solid rgb(204, 204, 204); height: 170px; left: 10px; top: 40px; position: absolute; width: 780px">
                                                        <ice:outputText id="lblPrepareIn" style="font-size: 10px; left: 38px; top: 20px; position: absolute" value="Prepare In:"/>
                                                        <ice:outputText id="lblBegetYearEndDate"
                                                            style="font-size: 10px; left: 38px; top: 54px; position: absolute" value="Beget Year End Date  :"/>
                                                        <ice:outputText id="lblEmployeeEvaluationYear"
                                                            style="font-size: 10px; left: 38px; top: 88px; position: absolute" value="Request Date :"/>
                                                        <ice:outputText id="outputText11" style="font-size: 10px; left: 450px; top: 54px; position: absolute" value="Number Of Employee:"/>
                                                        <ice:outputText binding="#{EmployeeBones$ApproveYearlyBones.txtEmployeeNumber}" id="txtEmployeeNumber"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 570px; top: 54px; position: absolute; width: 160px" value=":"/>
                                                        <ice:outputText id="lblBegetYear" style="font-size: 10px; left: 450px; top: 20px; position: absolute" value="Beget Year: "/>
                                                        <ice:outputText id="outputText4" style="font-size: 10px; left: 450px; top: 88px; position: absolute" value="Approve Bones Amount: "/>
                                                        <ice:outputText binding="#{EmployeeBones$ApproveYearlyBones.txtPrepareIn}" id="txtPrepareIn"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 17px; position: absolute; width: 189px" value=":"/>
                                                        <ice:outputText binding="#{EmployeeBones$ApproveYearlyBones.txtBegetYearEndDate}"
                                                            id="txtBegetYearEndDate"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 54px; position: absolute; width: 189px" value=":"/>
                                                        <ice:outputText binding="#{EmployeeBones$ApproveYearlyBones.txtEmployeeEvaluationYear}"
                                                            id="txtEmployeeEvaluationYear"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 88px; position: absolute; width: 189px" value=":"/>
                                                        <ice:outputText binding="#{EmployeeBones$ApproveYearlyBones.txtBegetYear}" id="txtBegetYear"
                                                            style="border-bottom: solid rgb(153,153,153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 570px; top: 17px; position: absolute; width: 170px" value=":"/>
                                                        <ice:outputText binding="#{EmployeeBones$ApproveYearlyBones.txtApproveBonesAmount}"
                                                            id="txtApproveBonesAmount"
                                                            style="border-width: 1px; background-color: rgb(242, 246, 240); border-bottom-color: rgb(153,153,153); border-bottom-style: solid; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 570px; top: 88px; position: absolute; width: 170px" value=":"/>
                                                        <ice:outputText id="lblRequester" style="font-size: 10px; left: 38px; top: 122px; position: absolute" value="Requester"/>
                                                        <ice:outputText binding="#{EmployeeBones$ApproveYearlyBones.txtRequester}" id="txtRequester"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 122px; position: absolute; width: 573px" value=":"/>
                                                        <ice:commandButton action="#{EmployeeBones$ApproveYearlyBones.btnMakeitSelectable_action}"
                                                            id="btnMakeitSelectable"
                                                            style="font-size: 10px; left: 600px; top: 140px; position: absolute; width: 160px" value="Make it Selectable "/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyRequestInformationTable" style="border: 1px solid rgb(204, 204, 204); height: 400px; left: 10px; top: 220px; overflow: auto; position: absolute; width: 780px">
                                                        <ice:dataTable id="dataTable1" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                            value="#{EmployeeBones$ApproveYearlyBones.listOfEmployee}" var="currentRow">
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
                                                            <ice:column id="colApprove">
                                                                <ice:selectBooleanCheckbox binding="#{EmployeeBones$ApproveYearlyBones.chkMakeApproveHere}"
                                                                    id="chkMakeApproveHere" partialSubmit="true" value="#{currentRow['selected']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblApprove" value="Select Here for Decision"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panLeaveApprove" style="border: 1px solid rgb(204, 204, 204); height: 220px; left: 10px; top: 630px; overflow: auto; position: absolute; width: 780px">
                                                        <ice:outputLabel id="lblDeciderDepartment"
                                                            style="font-family: Cambria; left: 20px; top: 30px; position: absolute" value="DeciderDepartment"/>
                                                        <ice:outputLabel id="lblDeciderId"
                                                            style="font-family: Cambria; left: 20px; top: 70px; position: absolute" value="DeciderId"/>
                                                        <ice:inputText binding="#{Leave$LeaveApprovePage.txtDeciderId}" disabled="true" id="txtDeciderId" style="left: 140px; top: 70px; position: absolute"/>
                                                        <ice:outputLabel id="lblDeciderFullName" style="left: 390px; top: 30px; position: absolute" value="Decider FullName"/>
                                                        <ice:outputLabel id="deciderPosition"
                                                            style="font-family: Cambria; left: 390px; top: 70px; position: absolute" value="Decider Position"/>
                                                        <ice:outputLabel id="lblDecision"
                                                            style="font-family: Cambria; left: 20px; top: 110px; position: absolute" value="Decision"/>
                                                        <ice:inputTextarea binding="#{EmployeeBones$ApproveYearlyBones.txtaDeciderComment}"
                                                            id="txtaDeciderComment" style="border: 1px solid rgb(115, 179, 206); height: 63px; left: 140px; top: 145px; position: absolute; width: 560px"/>
                                                        <ice:outputLabel id="lblDeciderComment"
                                                            style="font-family: Cambria; left: 20px; top: 150px; position: absolute" value="Comment"/>
                                                        <ice:outputText binding="#{EmployeeBones$RequestYearBones.lblDecider_Department}"
                                                            id="lblDecider_Department"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 140px; top: 30px; position: absolute; width: 200px" value=":"/>
                                                        <ice:outputText binding="#{EmployeeBones$RequestYearBones.lblEmployeeFullName}" id="lblEmployeeFullName"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 500px; top: 30px; position: absolute; width: 210px" value=":"/>
                                                        <ice:outputText binding="#{EmployeeBones$RequestYearBones.lblDeciderPosition}" id="lblDeciderPosition"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 500px; top: 70px; position: absolute; width: 210px" value=":"/>
                                                        <ice:selectOneMenu binding="#{EmployeeBones$ApproveYearlyBones.drlDecision}" id="drlDecision"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); left: 140px; top: 105px; position: absolute; width: 200px" value="#{EmployeeBones$RequestYearBones.defaultSelectedData2.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems1" value="#{EmployeeBones$ApproveYearlyBones.decisionList}"/>
                                                        </ice:selectOneMenu>
                                                    </ice:panelLayout>
                                                    <ice:commandButton action="#{EmployeeBones$ApproveYearlyBones.btnSave_action}"
                                                        binding="#{Leave$LeaveApprovePage.btnSave}" id="btnSave"
                                                        style="left: 169px; top: 860px; position: absolute; width: 120px" value="Save"/>
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
                                                href="http://www.GOOGLE.COM" style="margin-left:10px;color:#333333;">BUNNA INTERNATIONAL BANK |INFORMATION |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeBones$ApproveYearlyBones.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management"/>
                                    <ice:commandLink action="#{EmployeeBones$ApproveYearlyBones.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{EmployeeBones$ApproveYearlyBones.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
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
