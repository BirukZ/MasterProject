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
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
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
                    function CandidateExperiences(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
                <link HREF="/FederalIcon.ico" REL="icon"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Recruitment$CandidateExperiences.panelBorder1Bean.renderCenter}"
                            renderEast="#{Recruitment$CandidateExperiences.panelBorder1Bean.renderEast}"
                            renderNorth="#{Recruitment$CandidateExperiences.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Recruitment$CandidateExperiences.panelBorder1Bean.renderSouth}"
                            renderWest="#{Recruitment$CandidateExperiences.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 75px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 75px; left: 0px; position: relative; width: 100%z; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style=" height:100%;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 312px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 273px; left: -4px; top: 50px; position: absolute; width: 213px" styleClass="list_menu">
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible1">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1">
                                                        <ice:outputText id="lblRecruitmentRequest1" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid headerClass="icePnlGrdHdr iceDatTblColHdr1" id="panelGrid1" width="100%">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$CandidateExperiences.cmdRecruitment_action}"
                                                                id="cmdRecruitment1" immediate="true" partialSubmit="true"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Recruitment Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$CandidateExperiences.cmdRecruitmentApproval_action}"
                                                                id="cmdVacancyNoticeList" immediate="true" partialSubmit="true"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Vacancy Notice List"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$CandidateExperiences.cmdVacancyNotice_action}"
                                                                id="cmdVacancyNotice1" immediate="true" partialSubmit="true"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Maintain Advertisement"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$CandidateExperiences.cmdFilterCandidates_action}"
                                                                id="cmdFilterCandidates1" immediate="true" partialSubmit="true"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Filter Candidates"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$CandidateExperiences.cmdVacantSpaces_action}"
                                                                id="cmdRecruitmentApproval" immediate="true" partialSubmit="true"
                                                                style="color:#306682;font-weight:bold" value="Recruitment Approval"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$CandidateExperiences.cmdRegisterCandidate_action}"
                                                                id="cmdRegisterCandidate1" immediate="true" partialSubmit="true"
                                                                style="color:#306682;font-weight:bold" value="Register Candidate"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 640px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="background-color: white; height: 700px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <ice:panelLayout id="froLabelExperienceCode" layout="flow"
                                            style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; height: 30px; left: 10px; top: 30px; position: absolute; width: 744px; -rave-layout: grid" styleClass="insideContainerMain">
                                            <ice:outputLabel id="outputLabel1" style="left: 170px; top: 0px; position: absolute" value="Candidate Name: "/>
                                            <ice:selectInputText action="#{Recruitment$CandidateExperiences.txtSearchCandidate_action}"
                                                binding="#{Recruitment$CandidateExperiences.txtSearchCandidate}" disabled="true" id="txtSearchCandidate"
                                                listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true" rows="10"
                                                style="left: 266px; position: absolute" valueChangeListener="#{ApplicationBean1.changeList}">
                                                <f:facet name="selectInputText">
                                                    <ice:panelGrid columnClasses="fullNameCandidate,empIdCol" columns="2">
                                                        <ice:outputText id="lblFullNameAutoComplete2" value="#{employeeList.fullName}"/>
                                                        <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{employeeList.empIdentification}"/>
                                                    </ice:panelGrid>
                                                </f:facet>
                                            </ice:selectInputText>
                                            <ice:outputText id="outputText2" rendered="false" style="left: 288px; top: 2px; position: absolute" value="BathCode"/>
                                            <ice:selectOneMenu binding="#{Recruitment$CandidateExperiences.drl_BatchCode}" id="drl_BatchCode"
                                                partialSubmit="true" rendered="false" style="left: 345px; top: 0px; position: absolute; width: 119px"
                                                value="#{Recruitment$CandidateExperiences.defaultSelectedData1.selectedObject}" valueChangeListener="#{Recruitment$CandidateExperiences.drl_BatchCode_processValueChange}">
                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{Recruitment$CandidateExperiences.recruitmentBatchCodeSearchOpt}"/>
                                            </ice:selectOneMenu>
                                            <ice:outputText id="outputText3" rendered="false" style="left: 504px; top: 2px; position: absolute" value="CandidateName"/>
                                            <ice:selectOneMenu binding="#{Recruitment$CandidateExperiences.drl_CandidatName}" id="drl_CandidatName"
                                                partialSubmit="true" rendered="false" style="left: 598px; top: 0px; position: absolute; width: 119px"
                                                value="#{Recruitment$CandidateExperiences.defaultSelectedData2.selectedObject}" valueChangeListener="#{Recruitment$CandidateExperiences.drl_CandidatName_processValueChange}">
                                                <f:selectItems id="selectOneMenu1selectItems2" value="#{Recruitment$CandidateExperiences.candidateNameList}"/>
                                            </ice:selectOneMenu>
                                            <ice:outputText id="outputText4" style="left: 456px; top: 0px; position: absolute" value="CandidateID:-"/>
                                            <ice:outputText binding="#{Recruitment$CandidateExperiences.out_txt_candidate_ID}" id="out_txt_candidate_ID" style="color: #cc0000; left: 552px; top: 0px; position: absolute; width: 45px"/>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="lyInstiution" layout="flow"
                                            style="border: 1px solid rgb(204, 204, 204); height: 333px; left: 10px; top: 67px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                            <ice:outputText id="lblExInstitution" style="font-size: 10px; left: 38px; top: 15px; position: absolute" value="#{msgs.Institution}"/>
                                            <ice:inputText binding="#{Recruitment$CandidateExperiences.txtExperianceInstitution}" disabled="true"
                                                id="txtExperianceInstitution" required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 15px; position: absolute; width: 190px"/>
                                            <ice:inputText binding="#{Recruitment$CandidateExperiences.txtDisplayedExpStartDate}" id="txtDisplayedExpStartDate"
                                                required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 161px; position: absolute; width: 167px"/>
                                            <ice:commandButton action="#{Recruitment$CandidateExperiences.btnCalExpStartDate_action}" id="btnCalExpStartDate"
                                                image="/resources/images/cal_icon.JPG" immediate="true" style="margin-left: 332px; margin-top: 111px; left: 7px; top: 48px; position: absolute"/>
                                            <ice:commandButton action="#{Recruitment$CandidateExperiences.btnCalExpEndDate_action}" id="btnCalExpEndDate"
                                                image="/resources/images/cal_icon.JPG" immediate="true" style="margin-left: 680px; margin-top: 111px; left: -1px; top: 49px; position: absolute"/>
                                            <ice:inputText binding="#{Recruitment$CandidateExperiences.txtDisplayedExpEndDate}" id="txtDisplayedExpEndDate"
                                                required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 513px; top: 161px; position: absolute; width: 156px"/>
                                            <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage" for="txtExperanceSalary"
                                                id="message2" infoClass="iceMsgInfo infoMessage"
                                                style="font-size: 10px; left: 530px; top: 42px; position: absolute" warnClass="iceMsgWarn warnMessage"/>
                                            <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage" for="txtJobType"
                                                id="message3" infoClass="iceMsgInfo infoMessage"
                                                style="font-size: 10px; left: 230px; top: 88px; position: absolute" warnClass="iceMsgWarn warnMessage"/>
                                            <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage" for="txtExRank"
                                                id="message4" infoClass="iceMsgInfo infoMessage"
                                                style="font-size: 10px; left: 229px; top: 137px; position: absolute" warnClass="iceMsgWarn warnMessage"/>
                                            <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage" for="txtTermination"
                                                id="message7" infoClass="iceMsgInfo infoMessage"
                                                style="font-size: 10px; left: 300px; top: 260px; position: absolute" warnClass="iceMsgWarn warnMessage"/>
                                            <ice:outputText id="lblJobType1" style="font-size: 10px; left: 38px; top: 63px; position: absolute" value="#{msgs.JobCode}"/>
                                            <ice:inputText binding="#{Recruitment$CandidateExperiences.txtJobType}" disabled="true" id="txtJobType" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 63px; position: absolute; width: 190px"/>
                                            <ice:outputText id="lblSalary1" style="font-size: 10px; left: 414px; top: 15px; position: absolute" value="#{msgs.Salary}"/>
                                            <ice:inputText binding="#{Recruitment$CandidateExperiences.txtExperanceSalary}" disabled="true"
                                                id="txtExperanceSalary"
                                                style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 513px; top: 15px; position: absolute; width: 190px" value="0.0"/>
                                            <ice:outputText id="lblStartDate1" style="font-size: 10px; left: 38px; top: 161px; position: absolute" value="#{msgs.StartDate}"/>
                                            <ice:outputText id="lblExEndDate1"
                                                style="font-size: 10px; left: 414px; top: 161px; position: absolute; text-align: left; width: 100px" value="#{msgs.EndDate}"/>
                                            <ice:outputText id="lblExRank" style="font-size: 10px; left: 38px; top: 111px; position: absolute" value="Rank"/>
                                            <ice:inputText binding="#{Recruitment$CandidateExperiences.txtExRank}" disabled="true" id="txtExRank"
                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 111px; position: absolute; width: 167px" value="0"/>
                                            <ice:inputTextarea binding="#{Recruitment$CandidateExperiences.txtTerminationReason}" id="txtTerminationReason" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 43px; left: 166px; top: 245px; position: absolute; width: 535px"/>
                                            <ice:outputText id="outputText1" style="font-size: 10px; left: 38px; top: 250px; position: absolute" value="Termination Reason"/>
                                            <ice:commandButton action="#{Recruitment$CandidateExperiences.btnAddExperience_action}"
                                                binding="#{Recruitment$CandidateExperiences.btnAddExperience}" disabled="true" id="btnAddExperience"
                                                style="left: 620px; top: 288px; position: absolute; width: 80px" value="#{msgs.cmdAdd}"/>
                                            <ice:outputText id="lblExperiencePermanent1" style="font-size: 10px; left: 38px; top: 210px; position: absolute" value="Permanent"/>
                                            <ice:outputText id="lblExperienceContract1" style="font-size: 10px; left: 285px; top: 210px; position: absolute" value="Contract"/>
                                            <ice:outputText id="lblExperienceGovernmental1" style="font-size: 10px; left: 413px; top: 210px; position: absolute" value="Governmental"/>
                                            <ice:outputText id="lblExperiencePrivate1" style="font-size: 10px; left: 638px; top: 210px; position: absolute" value="Private"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateExperiences.ckbExperiencePermanent}" disabled="true"
                                                id="ckbExperiencePermanent" partialSubmit="true"
                                                style="font-size: 10px; left: 166px; top: 210px; position: absolute" valueChangeListener="#{Recruitment$CandidateExperiences.ckbExperiencePermanent_processValueChange}"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateExperiences.ckbExperienceContract}" disabled="true"
                                                id="ckbExperienceContract" partialSubmit="true"
                                                style="font-size: 10px; left: 340px; top: 210px; position: absolute" valueChangeListener="#{Recruitment$CandidateExperiences.ckbExperienceContract_processValueChange}"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateExperiences.ckbExperienceGovernmental}" disabled="true"
                                                id="ckbExperienceGovernmental" partialSubmit="true"
                                                style="font-size: 10px; left: 510px; top: 210px; position: absolute" valueChangeListener="#{Recruitment$CandidateExperiences.ckbExperienceGovernmental_processValueChange}"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateExperiences.ckbExperiencePrivate}" disabled="true"
                                                id="ckbExperiencePrivate" partialSubmit="true"
                                                style="font-size: 10px; left: 690px; top: 210px; position: absolute" valueChangeListener="#{Recruitment$CandidateExperiences.ckbExperiencePrivate_processValueChange}"/>
                                            <ice:selectInputDate binding="#{Recruitment$CandidateExperiences.calExpEndDate}" id="calExpEndDate"
                                                popupDateFormat="yyyy-MM-dd" renderYearAsDropdown="true" rendered="false"
                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 421px; top: 85px; position: absolute; width: 190px" valueChangeListener="#{Recruitment$CandidateExperiences.calExpEndDate_processValueChange}"/>
                                            <ice:selectInputDate binding="#{Recruitment$CandidateExperiences.calExpStartDate}" id="calExpStartDate"
                                                popupDateFormat="yyyy-MM-dd" renderYearAsDropdown="true" rendered="false"
                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 360px; top: 72px; position: absolute; width: 190px" valueChangeListener="#{Recruitment$CandidateExperiences.calExpStartDate_processValueChange}"/>
                                            <ice:selectOneMenu binding="#{Recruitment$CandidateExperiences.drlJobCode}" disabled="true" id="drlJobCode"
                                                partialSubmit="true" rendered="false"
                                                style="height: 23px; left: 538px; top: 63px; position: absolute; width: 170px"
                                                value="#{Recruitment$CandidateExperiences.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{Recruitment$CandidateExperiences.drlJobCode_processValueChange}">
                                                <f:selectItems id="selectOneMenu1selectItems" value="#{Recruitment$CandidateExperiences.perofation}"/>
                                            </ice:selectOneMenu>
                                            <ice:outputLabel id="lblJobCode" rendered="false"
                                                style="font-size: 10px; left: 414px; top: 63px; position: absolute" value="#{msgs.JobCode}"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateExperiences.ckbProfassion}" disabled="true"
                                                id="ckbProfassion" partialSubmit="true" rendered="false" style="left: 517px; top: 66px; position: absolute"
                                                value="#{Recruitment$CandidateExperiences.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Recruitment$CandidateExperiences.ckbProfassion_processValueChange}"/>
                                            <ice:selectOneRadio binding="#{Recruitment$CandidateExperiences.rdRelation}" id="rdRelation" partialSubmit="true"
                                                rendered="false" style="height: 23px; left: 528px; top: 120px; position: absolute; width: 167px" value="#{Recruitment$CandidateExperiences.selectOneRadio1Bean.selectedObject}">
                                                <f:selectItems id="selectOneRadio1selectItems1" value="#{Recruitment$CandidateExperiences.relationTypeList}"/>
                                            </ice:selectOneRadio>
                                            <ice:outputLabel id="lblRelation1" rendered="false" style="left: 408px; top: 120px; position: absolute" value="Exp Relation"/>
                                            <ice:commandLink action="#{Recruitment$CandidateExperiences.commandLink1_action}" id="commandLink1" rendered="false"
                                                style="left: 450px; top: 295px; position: absolute" value="GenerateCandidateReport"/>
                                            <ice:panelPopup autoCentre="true" binding="#{Recruitment$CandidateExperiences.pnMessage}" clientOnly="true"
                                                draggable="true" id="pnMessage" modal="false" rendered="false"
                                                style="border-style: none; background-color: transparent; display: block; height: 106px; left: 0px; top: 100px; position: absolute; width: 751px" styleClass="message">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="pnlgridpnMessageExame" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                                        <ice:outputText id="pnMessageTitleExam"
                                                            style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                                        <ice:commandLink action="#{Recruitment$CandidateExperiences.modalPnlCloseMesssageExam_action}"
                                                            id="modalPnlCloseMesssageExam" immediate="true"
                                                            style="background-image: url(../resources/close_icon.gif); height: 19px; left: 692px; top: 2px; position: absolute; width: 19px"
                                                            styleClass="popupHeaderImage" title="Close Popup"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <f:facet name="body">
                                                    <ice:panelGroup binding="#{Recruitment$CandidateExperiences.panelGroupMessageExam}"
                                                        id="panelGroupMessageExam" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                                        <ice:panelLayout binding="#{Recruitment$CandidateExperiences.pnlMessageBodyExam}"
                                                            id="pnlMessageBodyExam" layout="flow"
                                                            style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                                            <h:outputLabel binding="#{Recruitment$CandidateExperiences.lblFormMessageExam}"
                                                                id="lblFormMessageExam" style="background-color: #F5F5F5;"/>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </f:facet>
                                            </ice:panelPopup>
                                            <ice:outputText binding="#{Recruitment$CandidateExperiences.out_date_message}" id="out_date_message" style="color: #ff0066; left: 168px; top: 300px; position: absolute; width: 429px"/>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="lyTableExperiance"
                                            style="border: 1px solid rgb(204, 204, 204); height: 150px; left: 10px; top: 410px; overflow: auto; position: absolute; width: 744px" styleClass="insideContainerMain">
                                            <ice:dataTable binding="#{Recruitment$CandidateExperiences.tableExperiance}" id="tableExperiance"
                                                style="border-top: solid rgb(153, 153, 153) 1px; width: 100%"
                                                value="#{Recruitment$CandidateExperiences.candidateExpiranceList}"
                                                    var="currentRow">`
                                                <ice:column id="column1">
                                                    <ice:outputText id="txtCandiateID" value="#{currentRow['candidateId']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="CandidateID" value=" CandidateID"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colExInstitution">
                                                    <ice:outputText id="txtExInstitution1" value="#{currentRow['institution']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="lblExInstitution1" value=" #{msgs.Institution}"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colExInstitutionPvtOrGvtal">
                                                    <ice:outputText id="txtExInstitutionPvtOrGvtal1" value="#{currentRow['experiencePrivateOrGovernmental']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="lblExInstitutionPvtOrGvtal1" value="Pvt/Gvtal"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colExJobType">
                                                    <ice:outputText id="txtExJobType1" value="#{currentRow['job_Code']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="lblExJobType1" value=" #{msgs.JobCode}"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colExInstitutionPermtOrContract">
                                                    <ice:outputText id="txtExInstitutionPermtOrContract1" value="#{currentRow['experienceContractOrPrtmanent']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="lblExInstitutionPermtOrContract1" value="Per/Cont"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colExSalary">
                                                    <ice:outputText id="txtExSalary1" value="#{currentRow['salary']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="lblExSalary1" value=" #{msgs.Salary}"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colExStartDate">
                                                    <ice:outputText id="txtExStartDate1" value="#{currentRow['startDate']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="lblExStartDate1" value="#{msgs.StartDate}"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colExEndDate">
                                                    <ice:outputText id="txtExEndDate1" value="#{currentRow['copletionDate']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="lblExEndDate" value=" #{msgs.EndDate}"/>
                                                    </f:facet>
                                                    <ice:rowSelector id="rowSelectorEmployeeExperance1" preStyleOnSelection="true"
                                                        selectionListener="#{Recruitment$CandidateExperiences.rowSelectorCandidateExperance_processMyEvent}"
                                                        toggleOnClick="true" value="#{currentRow['selectedExperance']}"/>
                                                </ice:column>
                                                <ice:column id="colExRank">
                                                    <ice:outputText id="txtExRank2" value="#{currentRow['rank']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="lblExRank2" value="#{msgs.RankId}"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colExReason">
                                                    <ice:outputText id="txtExReason1" value="#{currentRow['terminationReason']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="lblExReason" value=" #{msgs.Reason}"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colExReason555">
                                                    <ice:outputText id="txtExReason255" value="#{currentRow['equvalentJobCode']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="lblExReason555" value="Eqval"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colExReason5556">
                                                    <ice:outputText id="txtExReason2556" value="#{currentRow['expRelationType']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="lblExReason5556" value="Experience Relation"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column2">
                                                    <ice:outputText id="txtexpiranceTotalYear" value="#{currentRow['years']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText5" value="Service(Year)"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column3">
                                                    <ice:outputText id="txtexpiraceInMonth" value="#{currentRow['months']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText7" value="service(Month)"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column4">
                                                    <ice:outputText id="txtexpiraceInDay" value="#{currentRow['dates']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText9" value="Service(Days)"/>
                                                    </f:facet>
                                                </ice:column>
                                            </ice:dataTable>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="buttonEXperance" layout="flow"
                                            style="height: 50px; left: 10px; top: 570px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                            <ice:commandButton action="#{Recruitment$CandidateExperiences.btnEXNew_action}"
                                                binding="#{Recruitment$CandidateExperiences.btnEXNew}" id="btnEXNew" partialSubmit="true"
                                                style="margin-left: 40px; width: 80px" value=" #{msgs.cmdNew}"/>
                                            <ice:commandButton action="#{Recruitment$CandidateExperiences.btnEXSave_action}"
                                                binding="#{Recruitment$CandidateExperiences.btnEXSave}" disabled="true" id="btnEXSave" immediate="true"
                                                style="margin-left: 40px; width: 80px" value=" #{msgs.cmdSave}"/>
                                            <ice:commandButton action="#{Recruitment$CandidateExperiences.btnEXEdit_action}"
                                                binding="#{Recruitment$CandidateExperiences.btnEXEdit}" disabled="true" id="btnEXEdit" partialSubmit="true"
                                                style="margin-left: 40px; width: 80px" value=" #{msgs.cmdEdit}"/>
                                            <ice:commandButton action="#{Recruitment$CandidateExperiences.btnEXUpdate_action}"
                                                binding="#{Recruitment$CandidateExperiences.btnEXUpdate}" disabled="true" id="btnEXUpdate" immediate="true"
                                                style="margin-left: 40px; width: 80px" value=" #{msgs.cmdUpdate}"/>
                                            <ice:commandButton action="#{Recruitment$CandidateExperiences.btnEXReset_action}"
                                                binding="#{Recruitment$CandidateExperiences.btnEXReset}" id="btnEXReset" partialSubmit="true"
                                                style="margin-left: 40px; width: 80px" value=" #{msgs.cmdReset}"/>
                                            <ice:commandButton action="#{Recruitment$CandidateExperiences.btnEXDelete_action}"
                                                binding="#{Recruitment$CandidateExperiences.btnEXDelete}" disabled="true" id="btnEXDelete" immediate="true"
                                                style="margin-left: 40px; width: 80px" value=" #{msgs.cmdDelete}"/>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label
                                                style="margin-left:10px;color:#333333;font-weight:bold;font-family:Cambria">Copyright Â© 2005-2006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com" style="margin-left:10px;color:#333333;">BUNNA INTERNATIONAL BANK |Information System Department |Software Division.</a> |</label>
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
