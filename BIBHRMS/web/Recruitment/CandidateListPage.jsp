<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2011, 7:48:31 AM
    Author     : BravoZulu
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
                    function CandidateListPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
                <!--   <link HREF="./FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <jsp:forward page="sortableTable.iface"/>
                <ice:form id="form1">
                    <div style="width: 100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder height="1003" id="whole_page" renderCenter="#{Page1.panelBorder1Bean.renderCenter}"
                            renderEast="#{Page1.panelBorder1Bean.renderEast}" renderNorth="#{Page1.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Page1.panelBorder1Bean.renderSouth}" renderWest="#{Page1.panelBorder1Bean.renderWest}"
                            style="top: 5px; position: relative" styleClass="whole_page" width="1040">
                            <f:facet name="north">
                                <ice:panelGroup dragListener="#{Page1.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style=" height:100%;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 1035px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" layout="flow"
                                            style="height: 1015px; left: 0px; top: 24px; position: absolute; width: 213px" styleClass="list_menu">
                                            <ice:panelCollapsible binding="#{Page1.panelCollapsible2}" expanded="true" id="panelCollapsible2" style="top:10px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup2" styleClass="">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid1" width="100%">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$CandidateListPage.cmdRecruitmentRequest_action}"
                                                                id="cmdRecruitmentRequest" style="color: rgb(48, 102, 130); font-weight: bold" value="Recruitment Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$CandidateListPage.cmdrecApproval_action}" id="cmdrecApproval"
                                                                style="color: rgb(48, 102, 130); font-weight: bold" value="Request Approved "/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$CandidateListPage.cmdvacNotice_action}" id="cmdvacNotice"
                                                                style="color: rgb(48, 102, 130); font-weight: bold" value="Maintain Advertisement"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$CandidateListPage.cmdRegisterCandidate_action}"
                                                                id="cmdRegisterCandidate" style="color: rgb(48, 102, 130); font-weight: bold" value="Register Candidate"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$CandidateListPage.cmdfilterCandidate_action}"
                                                                id="cmdfilterCandidate" style="color: rgb(48, 102, 130); font-weight: bold" value="Filter Candidate"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$CandidateListPage.cmdexamQuestion_action}"
                                                                id="cmdexamQuestion" style="color: rgb(48, 102, 130); font-weight: bold" value="Degree Of Exam "/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible1" style="height: 348px; hight: 200.0px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass="">
                                                        <ice:outputText id="outputText1" value="Select Requirement Id "/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid2" style="height: 312px">
                                                    <ice:commandLink action="#{Recruitment$CandidateListPage.cmdSetDisplayCriteria_action}"
                                                        id="cmdSetDisplayCriteria" rendered="false"
                                                        style="left: 22px; top: -30px; position: relative; width: 100px" value="[ Set Display Criteria ]"/>
                                                    <ice:commandButton action="#{Recruitment$CandidateListPage.btnSortCriteria_action}" id="btnSortCriteria"
                                                        rendered="false" style="left: 8px; top: 40px; position: relative; width: 135px" value="Set Display Criteria"/>
                                                    <ice:selectOneMenu id="selectOneMenu1" partialSubmit="true"
                                                        style="left: 2px; position: relative; width: 135px" value="Set Display Criteria" valueChangeListener="#{Recruitment$CandidateListPage.selectOneMenu1_processValueChange}">
                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{Recruitment$CandidateListPage.bachCode}"/>
                                                        <ice:outputText id="outputText19" style="left: 0px; top: 20px" value="New Batch"/>
                                                    </ice:selectOneMenu>
                                                      <ice:selectOneMenu id="selectOneMenu2Biruk" partialSubmit="true"
                                                        style="left: 2px; position: relative; width: 135px" value="Set Display Criteria" valueChangeListener="#{Recruitment$CandidateListPage.selectOneMenu1Biruk_processValueChange}">
                                                        <f:selectItems id="selectOneMenu1selectItemsBiruk" value="#{Recruitment$CandidateListPage.bachCodeBiruk}"/>
                                                        <ice:outputText id="outputText19biruk" style="left: 0px; top: 50px" value="Old Batch"/>
                                                    </ice:selectOneMenu>
                                                    <ice:commandLink action="#{Recruitment$CandidateListPage.cmdPrepare_action}" id="cmdPrepare"
                                                        rendered="false" style="left: 40px; top:10px; position: relative; " value="[ Prepare ]"/>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 950px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 950px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 955px;width:790px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="LIST OF RECRUITMENT CANDIDATES  "/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 950px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelLayout id="lyRequestTable"
                                                    style="height: 239px; margin-left: 10px; margin-top: 410px; left: 15px; top: -364px; overflow: auto; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                    <ice:dataTable id="dataTableRecRequest" style="left: 0px; top: -10px; position: absolute"
                                                        value="#{Recruitment$CandidateListPage.recruitRecuestList}" var="currentRow" width="727">
                                                        <ice:column groupOn="#{currentRow['requiredJobType']}" id="columnJT">
                                                            <ice:outputText id="outputTextJT" value="#{currentRow['requiredJobType']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText3" value="Job Type"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['minQual']}" id="columnMQ">
                                                            <ice:outputText id="outputTextMQ" value="#{currentRow['minQual']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText6" value="Min Qual"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['educLevel']}" id="columnELevel">
                                                            <ice:outputText id="outputTextELevel" value="#{currentRow['educLevel']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText6ELevel" value="Educ Level"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['minExp']}" id="columnMexp">
                                                            <ice:outputText id="outputTextMexp" value="#{currentRow['minExp']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8" value="Min Exp"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['minRespon']}" id="columnMresp">
                                                            <ice:outputText id="outputTextMresp" value="#{currentRow['minRespon']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8r" value="Min Resp"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['addSkill']}" id="columnASkill">
                                                            <ice:outputText id="outputTextAskill" value="#{currentRow['addSkill']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8AS" value="Add Skill"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['numberRequiredEmployee']}" id="columnRNum">
                                                            <ice:outputText id="outputTextRNum" value="#{currentRow['numberRequiredEmployee']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8RN" value="Req Num"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['requirementType']}" id="columnEmpTy">
                                                            <ice:outputText id="outputTextEmpTy" value="#{currentRow['requirementType']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8ET" value="Emp Type"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['workingPlace']}" id="columnDepartment">
                                                            <ice:outputText id="outputTextDepartment" value="#{currentRow['workingPlace']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8Department" value="Department"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['remark']}" id="columnRecRemark">
                                                            <ice:outputText id="outputTextRecRemark" value="#{currentRow['remark']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8RecRemark" value="Remark"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="lyTableControl"
                                                    style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 231px; left: 24px; top: 312px; overflow: auto; position: absolute; width: 733px" styleClass="insideContainerMain iceDatTblCol">
                                                    <ice:dataTable binding="#{Recruitment$CandidateListPage.tblCandidate}" id="tblCandidate"
                                                        sortAscending="true" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                        value="#{Recruitment$CandidateListPage.recruitCandidateListBiruk}" var="currentRow" varStatus="rowIndex">
                                                        <ice:column id="column111">
                                                            <ice:outputText id="outputText777" value="#{rowIndex.index+1}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8666" value="No"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column5">
                                                            <ice:outputText id="outputText13" value="#{currentRow['fullName']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblCGPA" value="FullName"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colCandidateID">
                                                            <ice:outputText id="txtCandidateID" value="#{currentRow['candidateID']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblCandidateID" value="Candidate ID"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colGender">
                                                            <ice:outputText id="txtgender" value="#{currentRow['gender']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblgender" value="Gender"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column1">
                                                            <ice:outputText id="outputText7" value="#{currentRow['writtenExam']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8" value="Written Result"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column binding="#{Recruitment$CandidateListPage.column2}" id="column2">
                                                            <ice:outputText id="outputText9" value="#{currentRow['interview']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblinterviewExamResult" value="Interview Result"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column3">
                                                            <ice:outputText id="outputText11" value="#{currentRow['practical']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblPracticalExam" value="Practical Result"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column4">
                                                            <ice:outputText id="outputText12" value="#{currentRow['totalResult']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblTotal" value="Total"/>
                                                            </f:facet>
                                                            <ice:rowSelector binding="#{Recruitment$CandidateListPage.rowSelector1}" id="rowSelector1"
                                                                mouseOverClass="tableRowMouseOver"
                                                                selectionListener="#{Recruitment$CandidateListPage.rowSelectorCommitteeMember_processMyEvent}"
                                                                toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                        </ice:column>
                                                        <ice:column id="column6">
                                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.cboMakeCadidateCertify}"
                                                                id="cboMakeCadidateCertify" partialSubmit="true" value="#{currentRow['pass']}"/>
                                                            <ice:outputText id="outputText20"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText21" value="Approve"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlApproval" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 262px; margin-left: 15px; left: 9px; top: 624px; overflow: auto; position: absolute; width: 750px; -rave-layout: grid">
                                                    <ice:outputLabel id="outputLabel12" rendered="false"
                                                        style="font-size: 12px; left: 50px; top: 92px; position: absolute" value="#{msgAttendance.Position}"/>
                                                    <ice:outputLabel id="outputLabel16" rendered="false"
                                                        style="font-size: 12px; left: 430px; top: 92px; position: absolute" value="#{msgAttendance.Position}"/>
                                                    <ice:outputLabel binding="#{Recruitment$CandidateListPage.stxtAppJobPosition}" id="stxtAppJobPosition"
                                                        rendered="false" style="font-size: 10px; left: 120px; top: 92px; position: absolute; width: 193px"/>
                                                    <ice:outputLabel binding="#{Recruitment$CandidateListPage.stxtCertJobPosition}" id="stxtCertJobPosition"
                                                        rendered="false" style="font-size: 10px; left: 505px; top: 92px; position: absolute; width: 200px"/>
                                                    <ice:commandButton action="#{Recruitment$CandidateListPage.btnApprove_action}"
                                                        binding="#{Recruitment$CandidateListPage.btnApprove}" id="btnApprove"
                                                        style="height: 30px; left: 120px; top: 206px; position: absolute; width: 263px" value="Pushe To Employee &amp; Close Recuritment"/>
                                                    <ice:panelLayout id="panelLayout1" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 165px; margin-left: 15px; left: 168px; top: 24px; overflow: auto; position: absolute; width: 454px; -rave-layout: grid">
                                                        <ice:dataTable id="dataTable1" style="left: 62px; top: 14px; position: absolute"
                                                            value="#{Recruitment$CandidateListPage.lastSelectedCandiate}" var="currentRow">
                                                            <ice:column id="column7biruk">
                                                                <ice:outputText id="outputTextfullname" value="#{currentRow['fullName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblPracticalExam" value="FullName"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column8biruk">
                                                                <ice:outputText id="outputTextfcandidtaeID" value="#{currentRow['candidateID']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblCandID" value="CandidateID"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column9">
                                                                <ice:outputText id="outputTexttotal" value="#{currentRow['totalResult']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblTotal" value="TotalResult"/>
                                                                </f:facet>
                                                                <ice:rowSelector binding="#{Recruitment$CandidateListPage.rowSelector2}" id="rowSelector2"
                                                                    mouseOverClass="tableRowMouseOver"
                                                                    selectionListener="#{Recruitment$CandidateListPage.rowSelectorLastCandidateSelection_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:commandButton action="#{Recruitment$CandidateListPage.button1_action}" id="button1"
                                                        style="height: 30px; left: 432px; top: 206px; position: absolute; width: 143px" value="Remove Fro The List"/>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid">
                                        <jsp:directive.include file="/FOOTER.jspf"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$CandidateListPage.pnCriteria}" clientOnly="true" draggable="false"
                            id="pnCriteria" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 270px; left: 400px; top: 300px; position: absolute; width: 300px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnCriteria" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 528px">
                                    <ice:outputText id="pnCriteriaTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 400px" value="Bunna International Bank Human Resource Management:Degree Of Exam"/>
                                    <ice:commandLink action="#{Recruitment$CandidateListPage.modalPnlCloseCriteria_action}" id="modalPnlCloseCriteria"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 505px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupCriteria" style="display: block; height: 210px; position: relative; width: 483px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlCriteriaBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 180px; position: relative; width: 415px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel id="lblFormCriteria" style="background-color: #F5F5F5;"/>
                                        <ice:outputText id="outputText2"
                                            style="font-size: 10px; font-style: normal; font-weight: lighter; left: 19px; top: 15px; position: absolute" value="Batch Code"/>
                                        <ice:selectOneMenu binding="#{Recruitment$CandidateListPage.drlPersentageBatchCode}" id="drlPersentageBatchCode"
                                            partialSubmit="true"
                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 75px; top: 15px; position: absolute; width: 100px"
                                            value="#{Recruitment$CandidateListPage.selectOneMenu2Bean.selectedObject}" valueChangeListener="#{Recruitment$CandidateListPage.drlPersentageBatchCode_processValueChange}">
                                            <f:selectItems id="selectOneMenu2selectItems" value="#{Recruitment$CandidateListPage.bachCode}"/>
                                        </ice:selectOneMenu>
                                        <ice:panelLayout id="lyExamePersetaile" style="border: 1px solid rgb(204, 204, 204); height: 90px; margin-left: 10px; margin-top: 0px; left: 0px; top: 60px; position: absolute; width: 460px">
                                            <ice:outputText id="outputText3"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 19px; top: 20px; position: absolute" value="Written Result"/>
                                            <ice:outputText id="outputText4" rendered="true"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 250px; top: 54px; position: absolute" value="Other"/>
                                            <ice:outputText id="outputText10"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 19px; top: 54px; position: absolute" value="Interview Result"/>
                                            <ice:outputText id="outputText14"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 250px; top: 20px; position: absolute" value="Practical Result"/>
                                            <ice:inputText binding="#{Recruitment$CandidateListPage.txtWrittenPersentage}" id="txtWrittenPersentage" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 14px; position: absolute; width: 80px"/>
                                            <ice:inputText binding="#{Recruitment$CandidateListPage.txtOtherPercentage}" id="txtOtherPercentage" rendered="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 350px; top: 50px; position: absolute; width: 80px"/>
                                            <ice:inputText binding="#{Recruitment$CandidateListPage.txtInterviewPersentage}" id="txtInterviewPersentage" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 50px; position: absolute; width: 80px"/>
                                            <ice:inputText binding="#{Recruitment$CandidateListPage.txtPracticalPersentage}" id="txtPracticalPersentage" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 350px; top: 14px; position: absolute; width: 80px"/>
                                            <ice:outputText id="outputText15"
                                                style="font-style: normal; font-weight: lighter; left: 210px; top: 15px; position: absolute" value="%"/>
                                            <ice:outputText id="outputText16" rendered="true"
                                                style="font-style: normal; font-weight: lighter; left: 440px; top: 54px; position: absolute" value="%"/>
                                            <ice:outputText id="outputText17"
                                                style="font-style: normal; font-weight: lighter; left: 440px; top: 20px; position: absolute" value="%"/>
                                            <ice:outputText id="outputText18"
                                                style="font-style: normal; font-weight: lighter; left: 210px; top: 50px; position: absolute" value="%"/>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="lyExameButton" style="border: 1px solid rgb(204, 204, 204); height: 43px; left: 10px; top: 155px; position: absolute; vertical-align: top; width: 460px">
                                            <ice:commandButton action="#{Recruitment$CandidateListPage.btnSavePersentage_action}"
                                                binding="#{Recruitment$CandidateListPage.btnSavePersentage}" id="btnSavePersentage"
                                                style="margin-left: 5px; margin-top: -10px; width: 60px" value="Save"/>
                                            <ice:commandButton action="#{Recruitment$CandidateListPage.btnEditPersentage_action}"
                                                binding="#{Recruitment$CandidateListPage.btnEditPersentage}" id="btnEditPersentage"
                                                style="margin-left: 40px; width: 60px" value="Edit"/>
                                            <ice:commandButton action="#{Recruitment$CandidateListPage.btnUpdatePersentage_action}"
                                                binding="#{Recruitment$CandidateListPage.btnUpdatePersentage}" id="btnUpdatePersentage"
                                                style="margin-left: 40px; width: 60px" value="Update"/>
                                            <ice:commandButton action="#{Recruitment$CandidateListPage.btnDeletePersentage_action}"
                                                binding="#{Recruitment$CandidateListPage.btnDeletePersentage}" id="btnDeletePersentage"
                                                style="margin-left: 40px; width: 60px" value="Delete"/>
                                        </ice:panelLayout>
                                        <ice:selectOneMenu id="selectOneMenu2" partialSubmit="true"
                                            style="left: 334px; top: 15px; position: absolute; width: 143px"
                                            value="#{Recruitment$CandidateListPage.defaultSelectedData20.selectedObject}" valueChangeListener="#{Recruitment$CandidateListPage.selectOneMenu2_processValueChange}">
                                            <f:selectItems id="selectOneMenu2selectItems1" value="#{Recruitment$CandidateListPage.candidateNameList}"/>
                                        </ice:selectOneMenu>
                                        <ice:outputText id="outputText5" style="left: 230px; top: 15px; position: absolute" value="CandidateName"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$CandidateListPage.pnDisplayCriteria}" clientOnly="true" draggable="false"
                            id="pnDisplayCriteria" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 276px; left: 168px; top: 96px; position: absolute; width: 300px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridDisplayCriteria" style="background-color: rgb(48, 102, 130); height: 16px; padding-top: 8px; width: 549px">
                                    <ice:outputText id="pnCriteriaDisplayCriteriaTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 400px" value="Bunna International Bank Human Resource Management:Display Criteria"/>
                                    <ice:commandLink action="#{Recruitment$CandidateListPage.modalPnlCloseDisplayCriteria_action}"
                                        id="modalPnlCloseDisplayCriteria" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 529px; top: 1px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupDisplayCriteria" style="display: block; height: 341px; position: relative; width: 507px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlDisplayCriteriaBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 303px; position: relative; width: 432px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel id="lblFormDisplayCriteria" style="background-color: #F5F5F5;"/>
                                        <ice:panelLayout id="lyExameDisplayCriteria" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 333px; margin-left: 10px; margin-top: 0px; left: -10px; top: 0px; position: absolute; width: 501px; -rave-layout: grid">
                                            <ice:outputText id="lblDisplayOnly"
                                                style="font-style: normal; font-weight: bold; left: 10px; top: 5px; position: absolute" value="Display Only"/>
                                            <ice:outputText id="txtThewrittenexamtaken"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 24px; top: 24px; position: absolute" value="The written exam taken"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.choThewrittenexamtaken}"
                                                id="choThewrittenexamtaken" partialSubmit="true" style="left: 142px; top: 22px; position: absolute" value="#{Recruitment$CandidateListPage.defaultSelectedData2.selectedBoolean}"/>
                                            <ice:outputText id="txtTheInterviewexamtaken"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 24px; top: 48px; position: absolute" value="The Interview exam taken "/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.choTheInterviewexamtaken}"
                                                id="choTheInterviewexamtaken" partialSubmit="true" style="left: 142px; top: 46px; position: absolute" value="#{Recruitment$CandidateListPage.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                            <ice:outputText id="txtPracticaleExameTaken"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 240px; top: 24px; position: absolute" value="The practical exam taken "/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.chotxtPracticaleExameTaken}"
                                                id="chotxtPracticaleExameTaken" partialSubmit="true" style="left: 382px; top: 22px; position: absolute" value="#{Recruitment$CandidateListPage.selectBooleanCheckbox3Bean.selectedBoolean}"/>
                                            <ice:outputText id="lblApproved"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 240px; top: 48px; position: absolute" value="Approved"/>
                                            <ice:outputText id="lblCertified"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 336px; top: 48px; position: absolute" value="Certified "/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.choApproved}" id="choApproved"
                                                partialSubmit="true" style="left: 310px; top: 46px; position: absolute" value="#{Recruitment$CandidateListPage.defaultSelectedData6.selectedBoolean}"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.choCertified}" id="choCertified"
                                                partialSubmit="true" style="left: 382px; top: 46px; position: absolute" value="#{Recruitment$CandidateListPage.defaultSelectedData5.selectedBoolean}"/>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="lyisplayCriteriaButton" layout="flow"
                                            style="border-width: 1px; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); border-top-style: solid; height: 80px; left: 24px; top: 72px; position: absolute; vertical-align: top; visibility: visible; width: 440px; -rave-layout: grid" visible="true">
                                            <ice:outputText id="lblPractical_ResultGreaterThan"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 8px; top: 10px; position: absolute; text-align: left" value="Practical Result         "/>
                                            <ice:outputText id="lblGreaterThanSign"
                                                style="font-size: 12px; font-style: normal; font-weight: bold; left: 95px; top: 10px; position: absolute; text-align: left" value="&gt;"/>
                                            <ice:inputText binding="#{Recruitment$CandidateListPage.txtWrittenExamResultGreaterThan}"
                                                id="txtWrittenExamResultGreaterThan" style="font-size: 10px; font-style: normal; font-weight: lighter; left: 130px; top: 36px; position: absolute; text-align: left; width: 90px"/>
                                            <ice:outputText id="lblWrittenExamResultGreaterThan"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 8px; top: 40px; position: absolute" value="Written  Result"/>
                                            <ice:outputText id="lblGreaterWritenThanSign"
                                                style="font-size: 12px; font-style: normal; font-weight: bold; left: 95px; top: 40px; position: absolute; text-align: left" value="&gt;"/>
                                            <ice:inputText binding="#{Recruitment$CandidateListPage.txtPracticalResultGreaterThan}"
                                                id="txtPracticalResultGreaterThan" style="font-size: 10px; font-style: normal; font-weight: lighter; left: 130px; top: 6px; position: absolute; text-align: left; width: 90px"/>
                                            <ice:outputText escape="false" id="lblInterviewResult"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 240px; top: 10px; position: absolute" value="Interview Result"/>
                                            <ice:outputText id="lblGreaterThanSignFor"
                                                style="font-size: 12px; font-style: normal; font-weight: bold; left: 325px; top: 10px; position: absolute; text-align: left" value="&gt;"/>
                                            <ice:inputText binding="#{Recruitment$CandidateListPage.txtInterviewResult}" id="txtInterviewResult" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 350px; top: 6px; position: absolute; width: 90px"/>
                                            <ice:outputText id="lblAdvertDateTo"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 240px; top: 40px; position: absolute" value="GPA"/>
                                            <ice:outputLabel id="outputLabel1" style="left: 0px; top: 73px; position: absolute" value="Experiance Relation"/>
                                            <ice:outputText id="lblGreaterThanSignForGpa"
                                                style="font-size: 12px; font-style: normal; font-weight: bold; left: 325px; top: 36px; position: absolute; text-align: left" value="&gt;"/>
                                            <ice:selectOneRadio binding="#{Recruitment$CandidateListPage.rdRelation}" id="rdRelation" partialSubmit="true"
                                                style="height: 23px; left: 120px; top: 72px; position: absolute; width: 239px"
                                                value="#{Recruitment$CandidateListPage.defaultSelectedData19.selectedObject}" valueChangeListener="#{Recruitment$CandidateListPage.rdRelation_processValueChange}">
                                                <f:selectItems id="selectOneRadio1selectItems" value="#{Recruitment$CandidateListPage.relationTypeList}"/>
                                            </ice:selectOneRadio>
                                            <ice:inputText binding="#{Recruitment$CandidateListPage.txtGPA}" id="txtGPA"
                                                onclick="dispalyCalendar(event,'form1:txtAdvertDateTO', 'form1');" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 350px; top: 36px; position: absolute; width: 90px"/>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="lyisplaySort" style="border-width: 1px; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); border-top-style: solid; border-bottom-style: solid; height: 117px; left: 24px; top: 168px; position: absolute; vertical-align: top; width: 440px">
                                            <ice:outputText id="lblSortBY" rendered="true"
                                                style="font-style: normal; font-weight: bold; left: 0px; top: 0px; position: absolute" value="Sort By"/>
                                            <ice:outputText id="txtSortByExamResult" rendered="true"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 0px; top: 24px; position: absolute" value="By Exam Result"/>
                                            <ice:outputText id="txtSortBy" rendered="true"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 0px; top: 48px; position: absolute" value="By GPA:"/>
                                            <ice:outputText id="txtMs" rendered="false"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 240px; top: 75px; position: absolute" value="Maritial Stat:"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.choExamResult}" id="choExamResult"
                                                partialSubmit="true" style="left: 94px; top: 22px; position: absolute"
                                                value="#{Recruitment$CandidateListPage.defaultSelectedData4.selectedBoolean}" valueChangeListener="#{Recruitment$CandidateListPage.choExamResult_processValueChange}"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.choByGpa}" id="choByGpa" partialSubmit="true"
                                                style="left: 94px; top: 46px; position: absolute"
                                                value="#{Recruitment$CandidateListPage.defaultSelectedData3.selectedBoolean}" valueChangeListener="#{Recruitment$CandidateListPage.choByGpa_processValueChange}"/>
                                            <ice:outputText id="txtGender" rendered="true"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 168px; top: 24px; position: absolute" value="Gender:"/>
                                            <ice:outputText id="txtAge" rendered="true"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 0px; top: 72px; position: absolute" value="Age:"/>
                                            <ice:outputText id="txtGenderMale"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 288px; top: 24px; position: absolute" value="M:"/>
                                            <ice:outputText id="txtGenderFemale"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 360px; top: 24px; position: absolute" value="F:"/>
                                            <ice:inputText binding="#{Recruitment$CandidateListPage.txtAge1}" id="txtAge1" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 118px; top: 70px; position: absolute; width: 30px"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.selectBooleanCheckboxMSNM}"
                                                id="selectBooleanCheckboxMSNM" partialSubmit="true" rendered="false"
                                                style="left: 420px; top: 75px; position: absolute"
                                                value="#{Recruitment$CandidateListPage.defaultSelectedData10.selectedBoolean}" valueChangeListener="#{Recruitment$CandidateListPage.selectBooleanCheckboxMSNM_processValueChange}"/>
                                            <ice:outputText id="txtGenderMari" rendered="false"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 340px; top: 75px; position: absolute" value="Mar:"/>
                                            <ice:outputText id="txtGenderNMari" rendered="false"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 390px; top: 75px; position: absolute" value="NMar:"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.selectBooleanCheckboxSex}"
                                                id="selectBooleanCheckboxSex" partialSubmit="true" style="left: 238px; top: 22px; position: absolute"
                                                value="#{Recruitment$CandidateListPage.defaultSelectedData13.selectedBoolean}" valueChangeListener="#{Recruitment$CandidateListPage.selectBooleanCheckboxSex_processValueChange}"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.selectBooleanCheckboxAge}"
                                                id="selectBooleanCheckboxAge" partialSubmit="true" style="left: 94px; top: 70px; position: absolute"
                                                value="#{Recruitment$CandidateListPage.defaultSelectedData14.selectedBoolean}" valueChangeListener="#{Recruitment$CandidateListPage.selectBooleanCheckboxAge_processValueChange}"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.selectBooleanCheckboxMS}"
                                                id="selectBooleanCheckboxMS" partialSubmit="true" rendered="false"
                                                style="left: 310px; top: 75px; position: absolute"
                                                value="#{Recruitment$CandidateListPage.defaultSelectedData15.selectedBoolean}" valueChangeListener="#{Recruitment$CandidateListPage.selectBooleanCheckboxMS_processValueChange}"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.selectBooleanCheckboxSexM}"
                                                id="selectBooleanCheckboxSexM" partialSubmit="true" style="left: 310px; top: 22px; position: absolute"
                                                value="#{Recruitment$CandidateListPage.defaultSelectedData16.selectedBoolean}" valueChangeListener="#{Recruitment$CandidateListPage.selectBooleanCheckboxSexM_processValueChange}"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.selectBooleanCheckboxSexMF}"
                                                id="selectBooleanCheckboxSexMF" partialSubmit="true" style="left: 382px; top: 22px; position: absolute"
                                                value="#{Recruitment$CandidateListPage.defaultSelectedData17.selectedBoolean}" valueChangeListener="#{Recruitment$CandidateListPage.selectBooleanCheckboxSexMF_processValueChange}"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.selectBooleanCheckboxMSM}"
                                                id="selectBooleanCheckboxMSM" partialSubmit="true" rendered="false"
                                                style="left: 360px; top: 75px; position: absolute"
                                                value="#{Recruitment$CandidateListPage.defaultSelectedData18.selectedBoolean}" valueChangeListener="#{Recruitment$CandidateListPage.selectBooleanCheckboxMSM_processValueChange}"/>
                                            <ice:inputText binding="#{Recruitment$CandidateListPage.inputTextAgeValue}" id="inputTextAgeValue" required="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 166px; top: 70px; position: absolute; width: 50px"/>
                                            <ice:outputText id="txtAge2"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 240px; top: 72px; position: absolute" value="AND:"/>
                                            <ice:inputText binding="#{Recruitment$CandidateListPage.txtAgeRightComp}" id="txtAgeRightComp" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 286px; top: 70px; position: absolute; width: 30px"/>
                                            <ice:inputText binding="#{Recruitment$CandidateListPage.inputTextAgeValueRight}" id="inputTextAgeValueRight"
                                                required="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 334px; top: 70px; position: absolute; width: 50px"/>
                                        </ice:panelLayout>
                                        <ice:commandButton action="#{Recruitment$CandidateListPage.btnSet_action}" id="btnSet"
                                            style="left: 192px; top: 302px; position: absolute; width: 80px" value="Set"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$CandidateListPage.pnlPopupCommitteeMembers}" id="pnlPopupCommitteeMembers"
                            modal="FALSE" rendered="false" style="height: 453px; left: 408px; top: 240px; position: absolute; width: 813px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupCommitteeMembers" style="display: block; height: 20px; text-align: left" width="772">
                                    <ice:outputText dir="left" id="otxtCommitteeMembers" style="display: block; height: 20px; text-align: right" value="BIB HRMS - CONFIRM ON DECISION"/>
                                    <ice:commandLink action="#{Recruitment$CandidateListPage.btnClosePopupCommitteeMembers_action}"
                                        id="btnClosePopupCommitteeMembers" style="right: 0px; top: -20px; position: absolute" value="CLOSE"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutCommitteeMembers" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 284px; margin-left: 15px; left: 10px; top: 50px; overflow: auto; position: absolute; width: 770px">
                                    <ice:panelLayout id="pnlLayoutPopupCommitteeMembers" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 237px; margin-left: 15px; left: 0px; top: 24px; overflow: auto; position: absolute; width: 740px">
                                        <ice:panelLayout id="pnlLayoutPopupCommitteeMembersMessage2" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 40px; margin-left: 15px; left: 0px; top: 14px; overflow: auto; position: absolute; width: 693px">
                                            <ice:outputLabel id="lblSignInReminder" value="Signin using your username"/>
                                            <ice:commandLink action="#{Recruitment$CandidateListPage.cmdLnkClosePopupCommitteeMembers_action}"
                                                binding="#{Recruitment$CandidateListPage.cmdLnkClosePopupCommitteeMembers}"
                                                id="cmdLnkClosePopupCommitteeMembers" rendered="true" style="color: rgb(48, 102, 130)" value="CLOSE"/>
                                        </ice:panelLayout>
                                        <ice:dataTable id="dataTableCommitteeMembers" style="height: 8px; left: 14px; top: 60px; position: absolute"
                                            value="#{Recruitment$CandidateListPage.committeeMembersList}" var="currentRow" width="697">
                                            <ice:column id="colPopupMemberId">
                                                <ice:outputText id="optTxtPopupForColumnMemberId" value="#{currentRow['employeeId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupMemberId" value="ID"/>
                                                </f:facet>
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
                                            </ice:column>
                                            <ice:column id="colPopupMemberLogIn" rendered="true">
                                                <ice:commandLink
                                                    action="#{Recruitment$CandidateListPage.btnPopupForColumnMemberLogIn_actionForFinalRecuritment}"
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
                                                <ice:rowSelector id="rowSelectorCommitteeMember" immediate="true" multiple="false" preStyleOnSelection="true"
                                                    selectionListener="#{Recruitment$CandidateListPage.rowSelectorCommitteeMember_processMyEvent}" toggleOnClick="true"/>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$CandidateListPage.pnConfirmationMessage}" clientOnly="true" draggable="false"
                            id="pnConfirmationMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 300px; top: 400px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup binding="#{Recruitment$CandidateListPage.pnlConfirmationMessage}" id="pnlConfirmationMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnConfirmationTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna International Bank  Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Recruitment$CandidateListPage.cmdConfirmationCloseMesssage_action}"
                                        id="cmdConfirmationCloseMesssage" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 690px; top: 3px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Recruitment$CandidateListPage.panelConfirmationGroupMessage}" id="panelConfirmationGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Recruitment$CandidateListPage.pnlConfirmationMessageBody}" id="pnlConfirmationMessageBody"
                                        layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Recruitment$CandidateListPage.lblFormMessage4}" id="lblFormMessage4" style="background-color: #F5F5F5;"/>
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