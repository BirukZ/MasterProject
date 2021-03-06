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
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div style="left: 8px; top: -16px; position: absolute">
                        <ice:panelBorder id="whole_page" renderCenter="#{Termination$TransferApprovePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Termination$TransferApprovePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Termination$TransferApprovePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Termination$TransferApprovePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Termination$TransferApprovePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 117px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 129px; left: 0px; position: relative; width: 100%z; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px;top:15px; left: 5px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="Search Area"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 105px; width: 100%">
                                                        <ice:outputText id="outputText19" value=""/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
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
                                                            <ice:commandLink action="#{Termination$TransferApprovePage.lnkResignApprovePage_action}"
                                                                id="lnkResignApprovePage" style="color:#306682;font-weight:bold" value="Resign Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Termination$TransferApprovePage.lnkClearancePage_action}"
                                                                id="lnkClearancePage" style="color:#306682;font-weight:bold" value="Clearance"/>
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
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:600px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 400px; position: absolute; width: 100%">
                                                            <ice:outputText id="outputText32"
                                                                style="font-family: Cambria; left: 10px; top: 10px; position: absolute" value="New Request Arrival  List"/>
                                                            <ice:selectOneListbox
                                                                binding="#{Termination$TransferApprovePage.selectRequestApprovableRequestLists}"
                                                                id="selectRequestApprovableRequestLists" partialSubmit="true" size="2"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); height: 500px; left: 10px; top: 30px; position: absolute; width: 180px"
                                                                value="#{Termination$TransferApprovePage.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Termination$TransferApprovePage.selectRequestApprovableRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{Termination$TransferApprovePage.requestListsToBeApproved}"/>
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
                                <ice:panelGroup dragListener="#{Termination$TransferApprovePage.page_display_processMyEvent}" id="page_display" style="height:1200px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 1200px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 1180px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="MANAGE EMPLOYEE TRANSFER REQUEST(S)"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" layout="flow" style="height: 1190px; left: 0px; top: 24px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 1200px; ;visibility: visible;" visible="true">
                                                    <ice:outputText id="outputText1" style="font-family: Cambria; left: 40px; top: 40px; position: absolute" value="Employee Id "/>
                                                    <ice:outputText id="outputText3" style="font-family: Cambria; left: 40px; top: 80px; position: absolute" value="Full Name "/>
                                                    <ice:outputText id="outputText4" style="font-family: Cambria; left: 40px; top: 120px; position: absolute" value="Gender :"/>
                                                    <ice:outputText id="outputText5" style="font-family: Cambria; left: 40px; top: 200px; position: absolute" value="Employee Type "/>
                                                    <ice:outputText id="outputText6" style="font-family: Cambria; left: 40px; top: 160px; position: absolute" value="Department "/>
                                                    <ice:outputText id="outputText7" style="font-family: Cambria; left: 40px; top: 245px; position: absolute" value="Position "/>
                                                    <ice:outputText id="outputText8" style="font-family: Cambria; left: 440px; top: 245px; position: absolute" value="Hire Date "/>
                                                    <ice:outputText id="outputText9" style="font-family: Cambria; left: 40px; top: 280px; position: absolute" value="Age "/>
                                                    <ice:outputText id="outputText10" style="font-family: Cambria; left: 440px; top: 280px; position: absolute" value="Service Year "/>
                                                    <ice:outputText id="outputText11" style="font-family: Cambria; left: 40px; top: 320px; position: absolute" value="Date Requested "/>
                                                    <ice:outputText id="outputText12" style="font-family: Cambria; left: 440px; top: 320px; position: absolute" value="Transfer Type "/>
                                                    <ice:outputText id="outputText13" style="font-family: 'Cambria'; left: 49px; top: 577px; position: absolute" value="Supportive Information Attached "/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.lblEmployeeId}" id="lblEmployeeId"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Cambria'; left: 150px; top: 40px; position: absolute; width: 260px" value=":"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.lblFullName}" id="lblFullName"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 80px; position: absolute; width: 260px" value=":"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.lblDepartment}" id="lblDepartment"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Cambria'; left: 150px; top: 160px; position: absolute; width: 356px" value=":"/>
                                                    <ice:selectBooleanCheckbox binding="#{Termination$TransferApprovePage.chkMale}" disabled="true" id="chkMale"
                                                        partialSubmit="true" style="left: 225px; top: 125px; position: absolute" value="#{Termination$TransferApprovePage.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Termination$TransferApprovePage.chkPermanet}" disabled="true"
                                                        id="chkPermanet" partialSubmit="true" style="left: 225px; top: 210px; position: absolute" value="#{Termination$TransferApprovePage.selectBooleanCheckbox3Bean.selectedBoolean}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Termination$TransferApprovePage.chkContrat}" disabled="true"
                                                        id="chkContrat" partialSubmit="true" style="left: 330px; top: 210px; position: absolute" value="#{Termination$TransferApprovePage.selectBooleanCheckbox4Bean.selectedBoolean}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Termination$TransferApprovePage.chkFemale}" disabled="true"
                                                        id="chkFemale" partialSubmit="true" style="left: 330px; top: 125px; position: absolute" value="#{Termination$TransferApprovePage.selectBooleanCheckbox5Bean.selectedBoolean}"/>
                                                    <ice:outputText id="outputText2" style="font-family: Cambria; left: 150px; top: 120px; position: absolute" value="Male"/>
                                                    <ice:outputText id="outputText14" style="font-family: Cambria; left: 270px; top: 120px; position: absolute" value="Female"/>
                                                    <ice:outputText id="outputText16" style="font-family: Cambria; left: 150px; top: 200px; position: absolute" value="Permanent"/>
                                                    <ice:outputText id="outputText17" style="font-family: Cambria; left: 271px; top: 200px; position: absolute" value="Contrat"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.lblPosition}" id="lblPosition"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Times New Roman',Times,serif; font-style: normal; left: 150px; top: 245px; position: absolute; width: 260px" value=":"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.lblHireDate}" id="lblHireDate"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 525px; top: 245px; position: absolute; width: 213px" value=":"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.lblAge}" id="lblAge"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Cambria'; left: 150px; top: 280px; position: absolute; width: 90px" value=":"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.lblServiceYear}" id="lblServiceYear"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 525px; top: 280px; position: absolute; width: 213px" value=":"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.lblTransfertype}" id="lblTransfertype"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 525px; top: 320px; position: absolute; width: 213px" value=":"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.lblDateRequested}" id="lblDateRequested"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 320px; position: absolute; width: 260px" value=":"/>
                                                    <ice:panelLayout id="panelLayout16" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 102px; margin-left: 15px; left: 10px; top: 601px; overflow: auto; position: absolute; width: 732px">
                                                        <ice:dataTable binding="#{Termination$TransferApprovePage.tblAttachedFile}" id="tblAttachedFile"
                                                            value="#{Termination$TransferApprovePage.fileAttachment}" var="currentRow" width="100%">
                                                            <ice:column id="column1" style="width: 10px">
                                                                <h:graphicImage id="image1" style="width: 10px" value="#{currentRow['imageIcon']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText31" value="File"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column4" style="width: 200px">
                                                                <h:commandLink action="#{Termination$TransferApprovePage.lnkDocumentAttached_action}"
                                                                    binding="#{Termination$TransferApprovePage.lnkDocumentAttached}" id="lnkDocumentAttached"
                                                                    style="color:blue" value="#{currentRow['imageName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText37" value="Attached Document"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlDownload" style="height: 38px; left: 289px; top: 553px; position: absolute; width: 20%">
                                                        <ice:outputResource attachment="false" fileName="#{Termination$TransferApprovePage.fileName}"
                                                            id="downloadButton" label="DownLoad" mimeType="#{Termination$TransferApprovePage.mimeType}"
                                                            rendered="#{Termination$TransferApprovePage.downloadAvailable}"
                                                            resource="#{Termination$TransferApprovePage.faResource}"
                                                            style="left: 40px; top: 10px; position: relative; width: 75px" type="button"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 138px; margin-left: 15px; left: 10px; top: 721px; overflow: auto; position: absolute; width: 707px">
                                                        <ice:dataTable id="dataTable" style="height: 8px; left: 5px; top: 0px"
                                                            value="#{Termination$TransferApprovePage.decisionsMadeOnRequest}" var="currentRow" width="685">
                                                            <ice:column id="colNumber">
                                                                <ice:outputText id="optTxtForColumnNumber" value="#{currentRow['counter']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextNumber" value="NO"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colDecisionGiven">
                                                                <ice:outputText id="optTxtForColumnDecisionGiven" value="#{currentRow['givenDecision']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextDecisionGiven" value="Decision"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colEmpId">
                                                                <ice:outputText id="optTxtForColumnEmpId" value="#{currentRow['deciderEmployeeId']}"/>
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
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutDecider" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 208px; margin-left: 15px; left: 10px; top: 889px; overflow: auto; position: absolute; width: 707px">
                                                        <ice:outputLabel id="lblDeciderDepartment" style="left: 48px; top: 24px; position: absolute" value="DeciderDepartment"/>
                                                        <ice:outputLabel id="lblDeciderId" style="left: 48px; top: 48px; position: absolute" value="DeciderId"/>
                                                        <ice:outputLabel id="lblDeciderRank" style="left: 48px; top: 72px; position: absolute" value="DeciderRank"/>
                                                        <ice:inputText binding="#{Termination$TransferApprovePage.txtDeciderDepartment}" disabled="true"
                                                            id="txtDeciderDepartment" style="left: 166px; top: 22px; position: absolute"/>
                                                        <ice:inputText binding="#{Termination$TransferApprovePage.txtDeciderId}" disabled="true"
                                                            id="txtDeciderId" style="left: 166px; top: 46px; position: absolute"/>
                                                        <ice:inputText binding="#{Termination$TransferApprovePage.txtDeciderRank}" disabled="true"
                                                            id="txtDeciderRank" style="left: 166px; top: 70px; position: absolute"/>
                                                        <ice:outputLabel id="lblDeciderFullName" style="left: 408px; top: 24px; position: absolute" value="DeciderFullName"/>
                                                        <ice:outputLabel id="deciderPosition" style="left: 408px; top: 48px; position: absolute" value="DeciderPosition"/>
                                                        <ice:inputText binding="#{Termination$TransferApprovePage.txtDeciderFullName}" disabled="true"
                                                            id="txtDeciderFullName" style="left: 526px; top: 22px; position: absolute"/>
                                                        <ice:inputText binding="#{Termination$TransferApprovePage.txtDeciderPosition}" disabled="true"
                                                            id="txtDeciderPosition" style="left: 526px; top: 46px; position: absolute"/>
                                                        <ice:selectOneMenu binding="#{Termination$TransferApprovePage.drlDecision}" id="drlDecision"
                                                            partialSubmit="true" style="height: 23px; left: 166px; top: 94px; position: absolute; width: 143px"
                                                            value="#{Termination$TransferApprovePage.selectedObjectOneMenuDecisionType.selectedObject}" valueChangeListener="#{Termination$TransferApprovePage.drlDecision_processValueChange}">
                                                            <f:selectItems id="selectDecisionAvailable" value="#{Termination$TransferApprovePage.availableDecisionsToMakeList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputLabel id="lblDecision" style="left: 48px; top: 96px; position: absolute" value="Decision"/>
                                                        <ice:inputTextarea binding="#{Termination$TransferApprovePage.txtaDeciderComment}"
                                                            id="txtaDeciderComment" style="left: 166px; top: 118px; position: absolute; width: 496px"/>
                                                        <ice:outputLabel id="lblDeciderComment" style="left: 48px; top: 120px; position: absolute" value="Comment"/>
                                                        <ice:commandButton action="#{Termination$TransferApprovePage.btnSearchDecider_action}"
                                                            binding="#{Termination$TransferApprovePage.btnSearchDecider}" id="btnSearchDecider"
                                                            style="left: 319px; top: 38px; position: absolute" value="Change"/>
                                                        <!--  <ice:outputText id="outputText18"
                                                            style="font-family: 'Cambria'; left: 48px; top: 168px; position: absolute" value="Select this if you want to forward to committee"/>
                                                        <ice:selectBooleanCheckbox binding="#{Termination$TransferApprovePage.chkCommittee}" id="chkCommittee"
                                                            partialSubmit="true" style="left: 312px; top: 180px; position: absolute"
                                                            value="#{Termination$TransferApprovePage.selectBooleanCheckbox3Bean.selectedBoolean}" valueChangeListener="#{Termination$TransferApprovePage.chkCommittee_processValueChange}"/>-->
                                                    </ice:panelLayout>
                                                    <ice:graphicImage binding="#{Termination$TransferApprovePage.imgEmployeePicture}" height="194"
                                                        id="imgEmployeePicture" rendered="true"
                                                        style="border: 1px solid rgb(153, 153, 153); left: 550px; top: 24px; position: absolute"
                                                        value="/Employee/images/blank.gif" width="172"/>
                                                    <ice:commandButton action="#{Termination$TransferApprovePage.btnPostDecision_action}"
                                                        binding="#{Termination$TransferApprovePage.btnPostDecision}" id="btnPostDecision"
                                                        style="left: 313px; top: 1065px; position: absolute; width: 120px" value="Post"/>
                                                    <ice:outputText id="outputText22" style="font-family: Cambria; left: 40px; top: 400px; position: absolute" value="To Department"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.lblToDepartment}" id="lblToDepartment"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Times New Roman','Times',serif; font-size: 12px; font-style: normal; left: 150px; top: 400px; position: absolute; width: 282px" value=":"/>
                                                    <ice:selectBooleanCheckbox binding="#{Termination$TransferApprovePage.chkEnternalSameDepartment}"
                                                        disabled="true" id="chkEnternalSameDepartment" partialSubmit="true"
                                                        style="left: 208px; top: 365px; position: absolute" value="#{Termination$TransferApprovePage.defaultSelectedData1.selectedBoolean}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Termination$TransferApprovePage.chkEnternalCrossDepartment}"
                                                        disabled="true" id="chkEnternalCrossDepartment" partialSubmit="true"
                                                        style="left: 405px; top: 365px; position: absolute" value="#{Termination$TransferApprovePage.defaultSelectedData2.selectedBoolean}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Termination$TransferApprovePage.chkExternal}" disabled="true"
                                                        id="chkExternal" partialSubmit="true" style="left: 550px; top: 365px; position: absolute" value="#{Termination$TransferApprovePage.defaultSelectedData3.selectedBoolean}"/>
                                                    <ice:inputTextarea binding="#{Termination$TransferApprovePage.txtRemarkReq}" id="txtRemarkReq" style="height: 56px; left: 191px; top: 479px; position: absolute; width: 525px"/>
                                                    <ice:outputText id="lblRemark" style="left: 49px; top: 505px; position: absolute" value="Reason For Transfer:"/>
                                                    <ice:outputText id="outputText15" style="font-family: 'Cambria'; left: 25px; top: 697px; position: absolute" value="State Transition Request History "/>
                                                    <ice:panelLayout binding="#{Termination$TransferApprovePage.pnlLayoutCommitteeMember}"
                                                        id="pnlLayoutCommitteeMember" rendered="false"
                                                        style="height: 50px; margin-left: 10px; margin-top: 10px; left: 1px; top: 1050px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblCommitteeType1" style="left: 47px; top: 13px; position: absolute" value="Type"/>
                                                        <ice:outputLabel id="lblCommitteeCommittee1" style="left: 361px; top: 9px; position: absolute" value="Committee"/>
                                                        <ice:selectOneMenu binding="#{Termination$TransferApprovePage.drlCommittee}" disabled="true"
                                                            id="drlCommittee" partialSubmit="true"
                                                            style="left: 429px; top: 15px; position: absolute; width: 192px"
                                                            value="#{Termination$TransferApprovePage.selectedObjectCommittee.selectedObject}" valueChangeListener="#{Termination$TransferApprovePage.drlCommittee_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems1" value="#{Termination$TransferApprovePage.committeeType}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Termination$TransferApprovePage.drlCommitteeType}" id="drlCommitteeType"
                                                            partialSubmit="true" style="left: 119px; top: 13px; position: absolute; width: 192px"
                                                            value="#{Termination$TransferApprovePage.selectedObjectCommitteeType.selectedObject}" valueChangeListener="#{Termination$TransferApprovePage.drlCommitteeType_processValueChange}">
                                                            <f:selectItems id="selectOneMenuCommitteeType1" value="#{Termination$TransferApprovePage.committeeType}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:commandButton action="#{Termination$TransferApprovePage.btnAddCommittee_action}"
                                                            id="btnAddCommittee1" style="left: 623px; top: 9px; position: absolute" value="+"/>
                                                    </ice:panelLayout>
                                                    <ice:outputText id="outputText18" style="font-family: Cambria; left: 40px; top: 425px; position: absolute" value="To Position"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.txtToPosition}" id="txtToPosition" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Times New Roman','Times',serif; font-size: 12px; font-style: normal; left: 121px; top: 425px; position: absolute; width: 143px"/>
                                                    <ice:outputText id="outputText21" style="font-family: Cambria; left: 260px; top: 425px; position: absolute" value="To Salary"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.txtToSalary}" id="txtToSalary" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Times New Roman','Times',serif; font-size: 12px; font-style: normal; left: 313px; top: 425px; position: absolute; width: 88px"/>
                                                    <ice:outputText id="outputText26" style="font-family: Cambria; left: 420px; top: 425px; position: absolute" value="To PayGrade"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.toPayGrade}" id="toPayGrade" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Times New Roman','Times',serif; font-size: 12px; font-style: normal; left: 500px; top: 425px; position: absolute; width: 88px"/>
                                                    <ice:outputText id="outputText28" style="font-family: Cambria; left: 590px; top: 425px; position: absolute" value="ToRank"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.txtToRank}" id="txtToRank" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Times New Roman','Times',serif; font-size: 12px; font-style: normal; left: 650px; top: 425px; position: absolute; width: 88px"/>
                                                    <ice:outputText id="outputText20" style="font-family: Cambria; left: 260px; top: 455px; position: absolute" value="SalaryChanged"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.txtSlaryChanged}" id="txtSlaryChanged" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Times New Roman','Times',serif; font-size: 12px; font-style: normal; left: 360px; top: 455px; position: absolute; width: 88px"/>
                                                    <ice:outputText id="outputText23" style="font-family: Cambria; left: 270px; top: 280px; position: absolute" value="PrevSalary"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.lblPrevSalary}" id="lblPrevSalary" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Cambria'; left: 337px; top: 280px; position: absolute; width: 83px"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.out_txt_toPositionName}"
                                                        id="out_txt_toPositionName" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Times New Roman','Times',serif; font-size: 12px; font-style: normal; height: 18px; left: 73px; top: 457px; position: absolute; width: 182px"/>
                                                    <ice:outputText id="outputText27" style="font-family: Cambria; left: 470px; top: 455px; position: absolute" value="Promoted"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.txt_promoted}" id="txt_promoted" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Times New Roman','Times',serif; font-size: 12px; font-style: normal; left: 550px; top: 455px; position: absolute; width: 88px"/>
                                                    <ice:outputText id="outputText29" style="font-family: Cambria; left: 440px; top: 400px; position: absolute" value="Effective From"/>
                                                    <ice:outputText binding="#{Termination$TransferApprovePage.effectiveFrom}" id="effectiveFrom" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Times New Roman','Times',serif; font-size: 12px; font-style: normal; left: 540px; top: 400px; position: absolute; width: 138px"/>
                                                </ice:panelGroup>
                                                <ice:outputText id="outputText24" style="left: 40px; top: 360px; position: absolute" value="Enternal Same Department"/>
                                                <ice:outputText id="outputText25" style="font-size: 12px; left: 260px; top: 360px; position: absolute" value="Enternal Cross Department"/>
                                                <ice:outputText id="outputText30" style="font-size: 12px; left: 500px; top: 360px; position: absolute" value="External"/>
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
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">Bunna International Bank |Information System Department |Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Termination$TransferApprovePage.pnlPopUpAttachment}" clientOnly="true" draggable="true"
                            id="pnlPopUpAttachment" modal="true" rendered="false" style="display: block; height: 455px; left: 97px; top: 146px; position: absolute; width: 812px">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridPopUpAttachment" styleClass="popupHeaderWrapper">
                                    <ice:outputText id="PopUpAttachmentTitle" style="width:400px" styleClass="popupHeaderText" value="Bunna Bank  Human Resource Management System-Request Commented History"/>
                                    <ice:commandButton actionListener="#{Termination$TransferApprovePage.modalPnlCloseBtnAttachment_processAction}" alt="Close"
                                        id="modalPnlCloseBtnAttachment" image="/resources/images/close.gif" immediate="true" partialSubmit="true"
                                        style="left: 789px; top: -1px; position: absolute" styleClass="popupHeaderImage" title="Close Popup" type="button"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="pnlgroupPopUpAttach" style="display: block; height: 387px; position: relative; width: 762px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:graphicImage binding="#{Termination$TransferApprovePage.gimgAttachedDocuments}" height="364" id="gimgAttachedDocuments"
                                        style="left: 5px; top: 5px; position: absolute" width="761"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Termination$TransferApprovePage.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Bank Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Termination$TransferApprovePage.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Termination$TransferApprovePage.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Termination$TransferApprovePage.pnlTransionHistory}" clientOnly="true" draggable="true"
                            id="pnlTransionHistory" modal="true" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 398px; left: 97px; top: 226px; position: absolute; width: 1118px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridTransionHistory" style="background-color: rgb(48, 102, 130); display: block; height: 27px" width="1117">
                                    <ice:outputText id="lblTransionHistoryTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle;" value="Bunna Bank Human Resource Management System-State Transition Request History"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupTransionHistoryBody" style="display: block; height: 342px; position: relative; width: 1068px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:commandButton action="#{Termination$TransferApprovePage.btnTransionHistoryClose_action}" id="btnTransionHistoryClose"
                                        immediate="true" partialSubmit="true" style="left: 900px; top: 296px; position: absolute; width: 108px" value="Close" visible="true"/>
                                    <ice:panelLayout id="panelLayout17_"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 251px;overflow: auto; position: absolute; width: 1000px" styleClass="message">
                                        <ice:dataTable id="dataTable1_" style="left: -50px; top: -20px; position: relative" var="currentRow" width="100%">
                                            <ice:column id="column3_">
                                                <ice:outputText id="outputText36_" value="#{currentRow['requestId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText38_" value="Request Id"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column5_">
                                                <ice:outputText id="outputText39_" value="#{currentRow['requestType']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText41_" value="Request Type"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column6_">
                                                <ice:outputText id="outputText48_" value="#{currentRow['fromState']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText49_" value="From State"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column7_">
                                                <ice:outputText id="outputText50_" value="#{currentRow['fromOwner']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText51_" value="State Owner Group"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column8_">
                                                <ice:outputText id="outputText52_" value="#{currentRow['toState']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText53_" value="To State"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column9_">
                                                <ice:outputText id="outputText54_" value="#{currentRow['toOwner']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText55_" value="State Owner Group"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column10_">
                                                <ice:outputText id="outputText56_" value="#{currentRow['remark']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText57_" value="Remark"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column106456_">
                                                <ice:outputText id="outputText56453_" value="#{currentRow['insertedDate']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText5734534_" value="Date"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column106f4d56_">
                                                <ice:outputText id="outputText5qf6453_" value="#{currentRow['insertedBy']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText573sw4534_" value="By"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="col2um1n106f4d56_">
                                                <ice:outputText id="o1ut3putText5qf6453_" value="#{currentRow['action']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="out1put3Text573sw4534_" value="Action"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Termination$TransferApprovePage.pnlPopupCommitteeMembers}" id="pnlPopupCommitteeMembers"
                            modal="true" rendered="false" style="height: 453px; left: 408px; top: 240px; position: absolute; width: 813px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupCommitteeMembers" style="display: block; height: 20px; text-align: left" width="772">
                                    <ice:outputText dir="left" id="otxtCommitteeMembers" style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - CONFIRM ON DECISION"/>
                                    <ice:commandLink action="#{Termination$TransferApprovePage.btnClosePopupCommitteeMembers_action}"
                                        id="btnClosePopupCommitteeMembers" style="left: 650px; top: -20px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutCommitteeMembers" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 284px; margin-left: 15px; left: 10px; top: 50px; overflow: auto; position: absolute; width: 770px">
                                    <ice:panelLayout id="pnlLayoutPopupCommitteeMembers" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 237px; margin-left: 15px; left: 0px; top: 24px; overflow: auto; position: absolute; width: 740px">
                                        <ice:panelLayout id="pnlLayoutPopupCommitteeMembersMessage2" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 40px; margin-left: 15px; left: 0px; top: 14px; overflow: auto; position: absolute; width: 693px">
                                            <ice:outputLabel binding="#{Termination$TransferApprovePage.lblSignInReminder}" id="lblSignInReminder" value="Signin using your username"/>
                                            <ice:commandLink action="#{Termination$TransferApprovePage.cmdLnkClosePopupCommitteeMembers_action}"
                                                binding="#{Termination$TransferApprovePage.cmdLnkClosePopupCommitteeMembers}"
                                                id="cmdLnkClosePopupCommitteeMembers" rendered="true" style="color: rgb(48, 102, 130)" value="CLOSE"/>
                                        </ice:panelLayout>
                                        <ice:dataTable id="dataTableCommitteeMembers" style="height: 8px; left: 14px; top: 60px; position: absolute"
                                            value="#{Termination$TransferApprovePage.committeeMembersList}" var="currentRow" width="697">
                                            <ice:column id="colPopupMemberId">
                                                <ice:outputText id="optTxtPopupForColumnMemberId" value="#{currentRow['employeeId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupMemberId" value="ID"/>
                                                </f:facet>
                                                <ice:rowSelector id="rowSelector1" selectionListener="#{Termination$TransferApprovePage.rowSelectorCommitteeMember_processMyEvent}"/>
                                            </ice:column>
                                            <ice:column id="colPopupMemberFullName">
                                                <ice:outputText id="optTxtPopupForColumnMemberFullName" value="#{currentRow['employeeFullName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupMemberFullName" value="Full Name"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupMemberResponsiblty">
                                                <ice:outputText id="optTxtPopupForColumnMemberResponsiblty" value="#{currentRow['memberResponsibility']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextMemberResponsiblty" value="Responsiblty"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupUserName">
                                                <ice:inputText id="txtPopupForColumnUserName" value="#{currentRow['userName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupUserName" value="UserName"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupPassWord">
                                                <ice:inputSecret id="txtPopupForColumnPassWord" value="#{currentRow['passWord']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPassWord" value="PassWord"/>
                                                </f:facet>
                                                <ice:rowSelector id="rowSelectorCommitteeMember" multiple="false" preStyleOnSelection="true"
                                                    selectionListener="#{Termination$TransferApprovePage.rowSelectorCommitteeMember_processMyEvent}"
                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                            </ice:column>
                                            <ice:column id="colPopupMemberLogIn" rendered="true">
                                                <ice:commandLink action="#{Termination$TransferApprovePage.btnPopupForColumnMemberLogIn_action}"
                                                    id="btnPopupForColumnMemberLogIn" value="Login"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupMemberLogIn" value="Log In"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupLoginConfirmed">
                                                <ice:outputText id="optTxtPopupForColumnLoginConfirmed" value="#{currentRow['logInConfirmed']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupLoginConfirmed" value="Confirmed"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <div class="some" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
                            <input id="cal_day_names" type="hidden" value="ሰ,ማ,ረ,�?,ዓ,ቅ,እ"/>
                            <input id="cal_month_names" type="hidden" value="መስከረ�?,ጥቅ�?ት,ህዳር,ታህሳስ,ጥር,የካቲት,መጋቢት,ሚያ�?ያ,�?ንቦት,ሰኔ,ሀ�?ሌ,�?ሀሴ,ጷ�?ሜ"/>
                        </div>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
