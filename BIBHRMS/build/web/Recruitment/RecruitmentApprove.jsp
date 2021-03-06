<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : CandidateEducation
    Created on : Mar 23, 2012, 11:04:13 AM
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
                    function CandidateExperiencesPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
                <!--  <link HREF="./FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1">
                <ice:form id="form1">
                    <div style="width:100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder height="480" id="whole_page" renderCenter="#{Recruitment$RecruitmentApprove.panelBorder1Bean.renderCenter}"
                            renderEast="#{Recruitment$RecruitmentApprove.panelBorder1Bean.renderEast}"
                            renderNorth="#{Recruitment$RecruitmentApprove.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Recruitment$RecruitmentApprove.panelBorder1Bean.renderSouth}"
                            renderWest="#{Recruitment$RecruitmentApprove.panelBorder1Bean.renderWest}" style="height: 630px; top: 5px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup dragListener="#{Recruitment$RecruitmentApprove.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="height: 850px">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 530px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 530px; left: 24px; top: 10px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible1" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass="">
                                                        <ice:outputText id="lblRecruitmentRequest" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid1" width="100%">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$RecruitmentApprove.cmdRecruitment_action}"
                                                                id="cmdRecruitment" immediate="true" partialSubmit="true"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Recruitment Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$RecruitmentApprove.cmdRecruitmentApproval_action}"
                                                                id="cmdRecruitmentApproval" immediate="true" partialSubmit="true"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Request Approved  List"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$RecruitmentApprove.cmdVacancyNotice_action}"
                                                                id="cmdVacancyNotice" immediate="true" partialSubmit="true"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Maintain Advertisement"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$RecruitmentApprove.cmdFilterCandidates_action}"
                                                                id="cmdFilterCandidates" immediate="true" partialSubmit="true"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Filter Candidates"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$RecruitmentApprove.cmdVacantSpaces_action}"
                                                                id="cmdVacantSpaces" immediate="true" partialSubmit="true"
                                                                style="color:#306682;font-weight:bold" value="Vacant Spaces"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$RecruitmentApprove.cmdRegisterCandidate_action}"
                                                                id="cmdRegisterCandidate" immediate="true" partialSubmit="true"
                                                                style="color:#306682;font-weight:bold" value="Register Candidate"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status1" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header1">
                                                        <ice:outputText id="lblStatus1" value="Pending"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="statusBoard1" width="100%">
                                                    <ice:panelGroup id="status_Group1" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:200px; width: 100%">
                                                        <ice:panelLayout id="statusContainer1" style="height: 261px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox
                                                                binding="#{Recruitment$RecruitmentApprove.selectRequestApprovableRequestLists}"
                                                                id="selectRequestApprovableRequestLists" partialSubmit="true" size="6"
                                                                style="height: 192px; width: 100%"
                                                                value="#{Recruitment$RecruitmentApprove.selectedRequestFromApprovableList.selectedObject}" valueChangeListener="#{Recruitment$RecruitmentApprove.selectRequestApprovableRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved1" value="#{Recruitment$RecruitmentApprove.requestListsToBeApproved}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_history1" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="history_Group_Header1">
                                                        <ice:outputText id="lblHistoryStatus1" value="History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="historyStatusBoard1" width="100%">
                                                    <ice:panelGroup id="history_Group1" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:310px; width: 100%">
                                                        <ice:panelLayout id="historyStatusContainer1" style="height: 309px; position: absolute; width: 100%">
                                                            <ice:selectOneListbox binding="#{Recruitment$RecruitmentApprove.selectMyHistoryLists}"
                                                                id="selectMyHistoryLists" partialSubmit="true" size="6" style="height: 312px; width: 100%"
                                                                value="#{Recruitment$RecruitmentApprove.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Recruitment$RecruitmentApprove.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed1" value="#{Recruitment$RecruitmentApprove.requestHistoryList}"/>
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
                                <ice:panelGroup dragListener="#{Recruitment$RecruitmentApprove.page_display_processMyEvent}" id="page_display" style="height: 850px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 830px; left: 15px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 720px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Recruitment Approve"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 700px; left: 0px; top: 50px; position: absolute; width: 100%">
                                                <ice:panelLayout binding="#{Recruitment$RecruitmentApprove.message}" id="message"
                                                    style="left: 0px; top: -87px; position: absolute; width: 720px" styleClass="message">
                                                    <ice:outputLabel binding="#{Recruitment$RecruitmentApprove.lblFormMessage}" id="lblFormMessage" value="success"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="lyApproved1"
                                                    style="height: 240px; margin-left: 10px; margin-top: 0px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                    <ice:outputText id="lblRequesterId" style="font-size: 10px; left: 31px; top: 26px; position: absolute" value="#{msgs.Requester}"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentApprove.txtRequester}" disabled="true" id="txtRequester" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 25px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="lblRequiredJobType" style="font-size: 10px; left: 414px; top: 25px; position: absolute" value="#{msgs.RequiredJobType}"/>
                                                    <ice:outputText id="outputText1" style="font-size: 10px; left: 31px; top: 60px; position: absolute" value="#{msgs.MinQualification}"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentApprove.txtMinQualifcation}" disabled="true"
                                                        id="txtMinQualifcation" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 165px; top: 55px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="lblMinExperience" style="font-size: 10px; left: 414px; top: 60px; position: absolute" value="#{msgs.MinExperience}"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentApprove.txtMinExperiance}" disabled="true"
                                                        id="txtMinExperiance" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 523px; top: 55px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="lblMinResponsibilities"
                                                        style="font-size: 10px; left: 31px; top: 89px; position: absolute" value="#{msgs.MinResponsibilities}"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentApprove.txtMinResponsiblity}" disabled="true"
                                                        id="txtMinResponsiblity" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 165px; top: 85px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="lblAdditionalSkill" style="font-size: 10px; left: 414px; top: 89px; position: absolute" value="#{msgs.AdditionalSkill}"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentApprove.txtAdditionalskill}" disabled="true"
                                                        id="txtAdditionalskill" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 523px; top: 85px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="lblNumberRequiredEmployee"
                                                        style="font-size: 10px; left: 31px; top: 120px; position: absolute" value="#{msgs.NumberRequiredEmployee}"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentApprove.txtNumberOfEmployee}" id="txtNumberOfEmployee"
                                                        required="true"
                                                        style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 165px; top: 115px; position: absolute; width: 56px" validator="#{Recruitment$RecruitmentApprove.txtNumberOfEmployee_validate}"/>
                                                    <ice:outputText id="lblemploymentType" style="font-size: 10px; left: 414px; top: 120px; position: absolute" value="#{msgs.employmentType}"/>
                                                    <ice:inputTextarea binding="#{Recruitment$RecruitmentApprove.txtARemark}" id="txtARemark" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 68px; left: 165px; top: 160px; position: absolute; width: 548px"/>
                                                    <ice:outputText id="txtRemark" style="font-size: 10px; left: 31px; top: 190px; position: absolute" value="#{msgs.Remark}"/>
                                                    <ice:outputText binding="#{Recruitment$RecruitmentApprove.txtConfirmation}" id="txtConfirmation"
                                                        rendered="false"
                                                        style="color: rgb(0, 153, 255); font-family: Georgia,'Times New Roman',times,serif; font-size: 14px; left: 31px; top: -10px; position: absolute" value="outputText"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentApprove.txtEmployeeMentType}" id="txtEmployeeMentType" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 523px; top: 115px; position: absolute; width: 98px"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentApprove.txtRequiredJobType}" id="txtRequiredJobType" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 523px; top: 25px; position: absolute; width: 190px"/>
                                                </ice:panelLayout>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtNumberOfEmployee" id="message1"
                                                    infoClass="infoMessage" showDetail="true"
                                                    style="font-size: 10px; left: 225px; top: 120px; position: absolute" warnClass="warnMessage"/>
                                                <ice:outputText binding="#{Recruitment$RecruitmentApprove.lblErrorMessageRequired}" id="lblErrorMessageRequired"
                                                    rendered="false"
                                                    style="color: red; font-size: 10px; font-weight: bolder; left: 715px; top: 27px; position: absolute" value="outputText"/>
                                                <ice:outputText binding="#{Recruitment$RecruitmentApprove.lblErrorMessageForEmployeeType}"
                                                    id="lblErrorMessageForEmployeeType" rendered="false"
                                                    style="color: red; font-size: 10px; font-weight: bolder; left: 670px; top: 117px; position: absolute" value="outputText"/>
                                                <ice:panelLayout binding="#{Recruitment$RecruitmentApprove.pnlLayoutDecider}" id="pnlLayoutDecider"
                                                    style="height: 202px; margin-left: 10px; margin-top: 250px; position: absolute; width: 744px"
                                                    styleClass="insideContainerMain" visible="true">
                                                    <ice:outputLabel id="lblDeciderDepartment" style="left: 48px; top: 24px; position: absolute" value="DeciderDepartment"/>
                                                    <ice:outputLabel id="lblDeciderId" style="left: 48px; top: 48px; position: absolute" value="DeciderId"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentApprove.txtDeciderDepartment}" disabled="true"
                                                        id="txtDeciderDepartment" style="left: 166px; top: 22px; position: absolute"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentApprove.txtDeciderId}" disabled="true" id="txtDeciderId" style="left: 166px; top: 46px; position: absolute"/>
                                                    <ice:outputLabel id="lblDeciderFullName" style="left: 408px; top: 24px; position: absolute" value="DeciderFullName"/>
                                                    <ice:outputLabel id="deciderPosition" style="left: 408px; top: 48px; position: absolute" value="DeciderPosition"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentApprove.txtDeciderFullName}" disabled="true"
                                                        id="txtDeciderFullName" style="left: 526px; top: 22px; position: absolute"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentApprove.txtDeciderPosition}" disabled="true"
                                                        id="txtDeciderPosition" style="left: 526px; top: 46px; position: absolute"/>
                                                    <ice:selectOneMenu binding="#{Recruitment$RecruitmentApprove.drlDecision}" id="drlDecision"
                                                        partialSubmit="true" style="height: 23px; left: 167px; top: 89px; position: absolute; width: 143px"
                                                        value="#{Recruitment$RecruitmentApprove.selectedObjectOneMenuDecisionType.selectedObject}" valueChangeListener="#{Recruitment$RecruitmentApprove.drlDecision_processValueChange}">
                                                        <f:selectItems binding="#{Recruitment$RecruitmentApprove.selectDecisionAvailable}"
                                                            id="selectDecisionAvailable" value="#{Recruitment$RecruitmentApprove.availableDecisionsToMakeList}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:outputLabel id="lblDecision" style="left: 49px; top: 88px; position: absolute" value="Decision"/>
                                                    <ice:inputTextarea binding="#{Recruitment$RecruitmentApprove.txtaDeciderComment}" id="txtaDeciderComment" style="left: 166px; top: 118px; position: absolute; width: 496px"/>
                                                    <ice:outputLabel id="lblDeciderComment" style="left: 48px; top: 120px; position: absolute" value="Comment"/>
                                                    <ice:commandButton action="#{Recruitment$RecruitmentApprove.btnSearchDecider_action}"
                                                        binding="#{Recruitment$RecruitmentApprove.btnSearchDecider}" id="btnSearchDecider"
                                                        style="left: 319px; top: 38px; position: absolute" value="Change"/>
                                                    <ice:commandLink action="#{Recruitment$RecruitmentApprove.lnkViewPrevieousDecisions_action}"
                                                        binding="#{Recruitment$RecruitmentApprove.lnkViewPrevieousDecisions}" id="lnkViewPrevieousDecisions"
                                                        style=" left: 432px; top: 96px; position: absolute" value="View decisions made on this request"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="lybuttons"
                                                    style="height: 50px; margin-left: 10px; margin-top: 410px; top: 60px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                    <ice:commandButton action="#{Recruitment$RecruitmentApprove.btnPostDecision_action}"
                                                        actionListener="#{Recruitment$RecruitmentApprove.btnPostDecision_processAction}"
                                                        binding="#{Recruitment$RecruitmentApprove.btnPostDecision}" disabled="true" id="btnPostDecision"
                                                        style="left: 180px; top: 5px; position: absolute; width: 80px" value="Save"/>
                                                    <ice:commandButton action="#{Recruitment$RecruitmentApprove.btnResetApp_action}"
                                                        binding="#{Recruitment$RecruitmentApprove.btnResetApp}" disabled="true" id="btnResetApp"
                                                        partialSubmit="true" style="left: 280px; top: 5px; position: absolute; width: 80px" value="Reset"/>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="lyRequestStatus"
                                                style="height: 30px; margin-left: 200px; margin-top: -57px; position: absolute; width: 580px" styleClass="">
                                                <ice:outputText id="lblStatus"
                                                    style="font-size: 16px; color: #023369; font-weight:bold; left: 5px; top: 7px; position: absolute" value="Status:"/>
                                                <ice:outputText binding="#{Recruitment$RecruitmentApprove.lblStatusValue}" id="lblStatusValue"
                                                    style="font-size: 12px; color: #dc6a0e; font-weight:bold; font-family: Arial, Helvetica, sans-serif;                                                     left: 72px; top: 10px; position: absolute" value="Recruitment Request Status."/>
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
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$RecruitmentApprove.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - View request status "/>
                                    <ice:commandLink action="#{Recruitment$RecruitmentApprove.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Recruitment$RecruitmentApprove.decisionsMadeOnRequest}" var="currentRow">
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
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$RecruitmentApprove.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Recruitment$RecruitmentApprove.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Recruitment$RecruitmentApprove.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$RecruitmentApprove.pnlPopupApprove}" clientOnly="true" draggable="false"
                            id="pnlPopupApprove" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 249px; left: 63px; top: 800px; position: absolute; width: 816px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage111" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 821px">
                                    <ice:commandButton action="#{Recruitment$RecruitmentApprove.btnClosePop_action}" id="btnClosePop"
                                        style="height: 25px; left: 840px; top: 5px; position: absolute; width: 30px; z-index: 100" value="x"/>
                                    <ice:outputText id="pnMessageTitle111"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage111" style="display: block; height: 201px; position: relative; width: 770px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody111" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 176px; position: relative; width: 706px; -rave-layout: grid" styleClass="message">
                                        <ice:outputText id="lblNumberOfApprovedEmployee" style="font-size: 10px; left: 407px; top: 31px; position: absolute" value="Number Of Approved Employee"/>
                                        <ice:inputText binding="#{Recruitment$RecruitmentApprove.txtApprovedNumberofEmployee}" id="txtApprovedNumberofEmployee"
                                            style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 600px; top: 25px; position: absolute; width: 100px" validator="#{Recruitment$RecruitmentApprove.txtApprovedNumberofEmployee_validate}"/>
                                        <ice:outputText id="lblBachCode" style="font-size: 10px; left: 31px; top: 60px; position: absolute" value="Bach Code"/>
                                        <ice:outputText id="lblApprovedBy" style="font-size: 10px; left: 31px; top: 26px; position: absolute" value="ApprovedBy"/>
                                        <ice:inputText binding="#{Recruitment$RecruitmentApprove.txtApprovedBy}" id="txtApprovedBy" readonly="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 25px; position: absolute; width: 190px"/>
                                        <ice:inputText binding="#{Recruitment$RecruitmentApprove.txtBachCode}" id="txtBachCode" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 60px; position: absolute; width: 190px"/>
                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtApprovedNumberofEmployee" id="message2"
                                            infoClass="infoMessage" showDetail="true"
                                            style="color: red; font-size: 10px; font-weight: bolder; left: 620px; top: 52px; position: absolute" warnClass="warnMessage"/>
                                        <ice:commandButton action="#{Recruitment$RecruitmentApprove.btnApprove_action}"
                                            binding="#{Recruitment$RecruitmentApprove.btnApprove}" id="btnApprove"
                                            style="left: 504px; top: 158px; position: absolute" value="Approve"/>
                                    </ice:panelLayout>
                                    <ice:panelLayout binding="#{Recruitment$RecruitmentApprove.pnlLayoutCommitteeMember}" id="pnlLayoutCommitteeMember"
                                        style="height: 50px; margin-left: 10px; margin-top: 10px; left: 10px; top: 90px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                        <ice:outputLabel id="lblCommitteeType1" rendered="false" style="left: 47px; top: 13px; position: absolute" value="Type"/>
                                        <ice:outputLabel id="lblCommitteeCommittee1" style="left: 361px; top: 9px; position: absolute" value="Committee"/>
                                        <ice:selectOneMenu binding="#{Recruitment$RecruitmentApprove.drlCommittee}" id="drlCommittee" partialSubmit="true"
                                            style="left: 429px; top: 15px; position: absolute; width: 192px"
                                            value="#{Recruitment$RecruitmentApprove.selectedObjectCommittee.selectedObject}" valueChangeListener="#{Recruitment$RecruitmentApprove.drlCommittee_processValueChange}">
                                            <f:selectItems id="selectOneMenu1selectItems1" value="#{Recruitment$RecruitmentApprove.committeeList}"/>
                                        </ice:selectOneMenu>
                                        <ice:selectOneMenu binding="#{Recruitment$RecruitmentApprove.drlCommitteeType}" id="drlCommitteeType"
                                            partialSubmit="true" rendered="false" style="left: 119px; top: 13px; position: absolute; width: 192px"
                                            value="#{Recruitment$RecruitmentApprove.selectedObjectCommitteeType.selectedObject}" valueChangeListener="#{Recruitment$RecruitmentApprove.drlCommitteeType_processValueChange}">
                                            <f:selectItems id="selectOneMenuCommitteeType1" value="#{Recruitment$RecruitmentApprove.committeeType}"/>
                                        </ice:selectOneMenu>
                                        <ice:commandButton action="#{Recruitment$RecruitmentApprove.btnAddCommittee_action}" id="btnAddCommittee1"
                                            rendered="false" style="left: 623px; top: 9px; position: absolute" value="+"/>
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
