<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2011, 7:48:31 AM
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
                    function MaintainAdvertisement(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
                <!--   <link HREF="../FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/images/main.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <script src="../Script/Ethiopian_Calendar.js" type="text/javascript"></script>
                <ice:form id="form1">
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{Page1.panelBorder1Bean.renderCenter}"
                        renderEast="#{Page1.panelBorder1Bean.renderEast}" renderNorth="#{Page1.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Page1.panelBorder1Bean.renderSouth}" renderWest="#{Page1.panelBorder1Bean.renderWest}"
                        style="top: 0px; position: relative" styleClass="whole_page" width="1040">
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
                            <ice:panelGroup id="menu_left" style=" height:100%;">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height: 670px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 640px; left: 0px; top: 15px; position: absolute; width: 213px" styleClass="list_menu">
                                        <ice:panelCollapsible binding="#{Page1.panelCollapsible2}" expanded="true" id="panelCollapsible2" toggleOnClick="true">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup2" styleClass="">
                                                    <ice:outputText id="outputText2" value="Common Tasks"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid1">
                                                <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                    <li>
                                                        <ice:commandLink action="#{Recruitment$CandidatesPage.cmdRecruitmentRequest_action}"
                                                            id="cmdRecruitmentRequest" style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Recruitment Request"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Recruitment$CandidatesPage.cmCandidateExperience_action}"
                                                            id="cmCandidateExperience" style="color: rgb(48, 102, 130); font-weight: bold" value="Candidate Experience"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Recruitment$CandidatesPage.cmdvacNotice_action}" id="cmdvacNotice"
                                                            style="color: rgb(48, 102, 130); font-weight: bold" value="Maintain Advertisement"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Recruitment$CandidatesPage.cmdFilterCandidateForExam_action}"
                                                            id="cmdFilterCandidateForExam" style="color: rgb(48, 102, 130); font-weight: bold" value="Filter Candidate For Exam"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Recruitment$CandidatesPage.cmdexamQuestion_action}" id="cmdexamQuestion"
                                                            style="color: rgb(48, 102, 130); font-weight: bold" value="Exam Result "/>
                                                    </li>
                                                </ul>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible1">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup1" styleClass="">
                                                    <ice:outputText id="outputText1" value="Search Candidate"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid2">
                                                <ice:selectInputText action="#{Recruitment$CandidatesPage.txtSearchCandidate_action}" id="txtSearchCandidate"
                                                    listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true" rows="10" valueChangeListener="#{ApplicationBean1.changeList}">
                                                    <f:facet name="selectInputText">
                                                        <ice:panelGrid columnClasses="fullNameCandidate,empIdCol" columns="2">
                                                            <ice:outputText id="lblFullNameAutoComplete2" value="#{employeeList.fullName}"/>
                                                            <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{employeeList.empIdentification}"/>
                                                        </ice:panelGrid>
                                                    </f:facet>
                                                </ice:selectInputText>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 800px;width:790px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 770px; left: -5px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <ice:panelLayout binding="#{Recruitment$CandidatesPage.message}" id="message"
                                        style="left: 0px; top: -31px; position: absolute; width: 720px" styleClass="message">
                                        <ice:outputLabel binding="#{Recruitment$CandidatesPage.lblFormMessage}" id="lblFormMessage"/>
                                    </ice:panelLayout>
                                    <fieldset class="filedset_css" style="height: 780px;">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="Candidate Registration"/>
                                        </legend>
                                        <ice:panelLayout id="pnProfile" layout="flow" style="height: 720px; left: 0px; top: 0px; position: absolute; width: 100%">
                                            <ice:panelGroup id="RetirementApproval" style=" height: 580px" styleClass="filedset_normal">
                                                <ice:panelLayout id="lyBasicInformation" layout="flow"
                                                    style="border: 1px solid rgb(204, 204, 204); height: 140px; margin-left: 10px; margin-top: 0px; left: 15px; top: 85px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                    <ice:outputText id="lblFirstName" style="font-size: 10px; left: 19px; top: 20px; position: absolute" value="First Name"/>
                                                    <ice:inputText binding="#{Recruitment$CandidatesPage.txtFirstName}" id="txtFirstName" required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 14px; position: absolute; width: 190px"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtFirstName" id="message1"
                                                        infoClass="infoMessage" showDetail="true"
                                                        style="font-size: 10px; left: 210px; top: 37px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:outputText id="lblMidelName" style="font-size: 10px; left: 396px; top: 20px; position: absolute" value="Midel Name"/>
                                                    <ice:outputText id="lblLastName" style="font-size: 10px; left: 19px; top: 54px; position: absolute" value="Last Name"/>
                                                    <ice:inputText binding="#{Recruitment$CandidatesPage.txtMidelName}" id="txtMidelName" required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 498px; top: 14px; position: absolute; width: 190px"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtMidelName" id="message2"
                                                        infoClass="infoMessage" showDetail="true"
                                                        style="font-size: 10px; left: 570px; top: 37px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:inputText binding="#{Recruitment$CandidatesPage.txtLastName}" id="txtLastName" required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 50px; position: absolute; width: 190px"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtLastName" id="message3"
                                                        infoClass="infoMessage" showDetail="true"
                                                        style="font-size: 10px; left: 210px; top: 73px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:outputText id="lblGender" style="font-size: 10px; left: 396px; top: 54px; position: absolute" value="Gender"/>
                                                    <ice:selectOneMenu binding="#{Recruitment$CandidatesPage.drlGender}" id="drlGender" partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 50px; position: absolute; width: 90px"
                                                        value="#{Recruitment$CandidatesPage.defaultSelectedData1.selectedObject}" valueChangeListener="#{Recruitment$CandidatesPage.drlGender_processValueChange}">
                                                        <f:selectItems id="selectOneMenu1selectItems1" value="#{Recruitment$CandidatesPage.gender}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:outputText binding="#{Recruitment$CandidatesPage.lblErrorMessageForGender}"
                                                        id="lblErrorMessageForGender" rendered="false"
                                                        style="color: red; font-size: 10px; font-weight: bolder; left: 572px; top: 73px; position: absolute" value="outputtext"/>
                                                    <ice:outputText id="lblDateOfBirth" style="font-size: 10px; left: 19px; top: 88px; position: absolute" value="Date of Birth"/>
                                                    <ice:inputText binding="#{Recruitment$CandidatesPage.txtDateOfBirth}" id="txtDateOfBirth"
                                                        partialSubmit="true" required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 86px; position: absolute; width: 190px"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDateOfBirth" id="message4"
                                                        infoClass="infoMessage" showDetail="true"
                                                        style="font-size: 10px; left: 210px; top: 109px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:commandButton action="#{Recruitment$CandidatesPage.btnCalender_action}"
                                                        binding="#{Recruitment$CandidatesPage.btnCalender}" id="btnCalender"
                                                        image="/Employee/images/calendar.gif" immediate="true"
                                                        style="border-width: 1px; background-color: rgb(242, 246, 240); left: 312px; top: 89px; position: absolute" value="submit"/>
                                                    <ice:selectInputDate binding="#{Recruitment$CandidatesPage.calDateOfBirth}" id="calDateOfBirth"
                                                        renderMonthAsDropdown="true" renderYearAsDropdown="true" rendered="false"
                                                        style="height: 189px; left: 336px; top: 0px; position: absolute; width: 213px; z-index: 99"
                                                        value="#{Recruitment$CandidatesPage.selectInputDate1Bean.date1}" valueChangeListener="#{Recruitment$CandidatesPage.calDateOfBirth_processValueChange}"/>
                                                    <ice:outputText binding="#{Recruitment$CandidatesPage.outputText3}" id="outputText3" style="color: red; font-style: italic; font-variant: small-caps; font-weight: lighter; left: 22px; top: 111px; position: absolute; width: 102px"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlAddress" style="border: 1px solid rgb(204, 204, 204); height: 125px; margin-left: 2px; left: 22px; top: 230px; position: absolute; width: 745px; -rave-layout: grid">
                                                    <ice:outputText id="lblResidentialAddress"
                                                        style="font-size: 10px; left: 19px; top: 20px; position: absolute" value="Residential address:"/>
                                                    <ice:inputText binding="#{Recruitment$CandidatesPage.txtResidentialAddress}" id="txtResidentialAddress" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 14px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="lblTelOffice" style="font-size: 10px; left: 19px; top: 54px; position: absolute" value="Work phone number:"/>
                                                    <ice:inputText binding="#{Recruitment$CandidatesPage.txtOficeTelephone}" id="txtOficeTelephone" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 50px; position: absolute; width: 190px"/>
                                                    <ice:inputText binding="#{Recruitment$CandidatesPage.txtTelResidence}" id="txtTelResidence" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 14px; position: absolute; width: 190px"/>
                                                    <ice:outputText escape="false" id="lblTelResidence"
                                                        style="font-size: 10px; left: 396px; top: 20px; position: absolute" value="Home phone number:"/>
                                                    <ice:outputText id="lblMobile" style="font-size: 10px; left: 396px; top: 54px; position: absolute" value="Mobile phone number:"/>
                                                    <ice:inputText binding="#{Recruitment$CandidatesPage.txtMobile}" id="txtMobile" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 50px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="lblEmail" style="font-size: 10px; left: 19px; top: 88px; position: absolute" value="E-mail:"/>
                                                    <ice:inputText binding="#{Recruitment$CandidatesPage.txtEmail}" id="txtEmail" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 86px; position: absolute; width: 190px"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlAdvertismnetList" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 200px; margin-left: 2px; left: 22px; top: 350px; position: absolute; width: 745px; -rave-layout: grid">
                                                    <ice:outputText id="lblLevelofEducation" style="font-size: 10px; left: 19px; top: 20px; position: absolute" value=" Level of Education"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtLevelOfEducation" id="message5"
                                                        infoClass="infoMessage" showDetail="true"
                                                        style="font-size: 10px; left: 210px; top: 38px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:outputText id="lblGraduatedby" style="font-size: 10px; left: 396px; top: 20px; position: absolute" value="Graduated by"/>
                                                    <ice:inputText binding="#{Recruitment$CandidatesPage.txtGraduatedby}" id="txtGraduatedby" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 527px; top: 19px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="lblCGPA" style="font-size: 10px; left: 19px; top: 54px; position: absolute" value="Cumulative GPA"/>
                                                    <ice:inputText binding="#{Recruitment$CandidatesPage.txtCGPA}" id="txtCGPA"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 50px; position: absolute; width: 60px" value="0"/>
                                                    <ice:outputText id="lblExperience"
                                                        style="font-size: 10px; left: 576px; top: -24px; position: absolute; width: 93px" value="No of Exp year"/>
                                                    <ice:outputText id="lblTotalNoOfPage" style="font-size: 10px; left: 408px; top: -24px; position: absolute" value="Total No of pages"/>
                                                    <ice:inputText binding="#{Recruitment$CandidatesPage.txtNoPage}" id="txtNoPage" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; height: 20px; left: 502px; top: -26px; position: absolute; width: 56px"/>
                                                    <ice:inputText binding="#{Recruitment$CandidatesPage.txtExperience}" id="txtExperience" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 670px; top: -26px; position: absolute; width: 60px"/>
                                                    <ice:outputText id="lblYearOfGraduation" style="left: 396px; top: 48px; position: absolute" value="Year Of Graduation"/>
                                                    <ice:commandButton action="#{Recruitment$CandidatesPage.btnCalenderYearOfGraduation_action}"
                                                        binding="#{Recruitment$CandidatesPage.btnCalenderYearOfGraduation}" id="btnCalenderYearOfGraduation"
                                                        image="/Employee/images/calendar.gif" immediate="true"
                                                        style="border-width: 1px; background-color: rgb(242, 246, 240); left: 696px; top: 48px; position: absolute; z-index: 5" value="submit"/>
                                                    <ice:selectInputDate binding="#{Recruitment$CandidatesPage.calDateOfGraduation}" id="calDateOfGraduation"
                                                        renderMonthAsDropdown="true" renderYearAsDropdown="true" rendered="false"
                                                        style="height: 212px; left: 528px; top: -24px; position: absolute; width: 190px; z-index: 10"
                                                        value="#{Recruitment$CandidatesPage.selectInputDateBean1.date1}" valueChangeListener="#{Recruitment$CandidatesPage.calDateOfGraduation_processValueChange}"/>
                                                    <ice:inputText binding="#{Recruitment$CandidatesPage.txtYearOfGraduation}" id="txtYearOfGraduation" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; height: 20px; left: 526px; top: 46px; position: absolute; width: 167px"/>
                                                    <ice:selectOneMenu binding="#{Recruitment$CandidatesPage.drlLevelOfEducation}" id="drlLevelOfEducation"
                                                        partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 139px; top: 20px; position: absolute; width: 122px"
                                                        value="#{Recruitment$CandidatesPage.defaultSelectedData8.selectedObject}" valueChangeListener="#{Recruitment$CandidatesPage.drlLevelOfEducation_processValueChange}">
                                                        <f:selectItems id="selectOneMenu1selectItems3" value="#{Recruitment$CandidatesPage.educLevelOpt}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:outputText id="outputText4" style="left: 24px; top: 96px; position: absolute" value="Instiution"/>
                                                    <ice:inputText binding="#{Recruitment$CandidatesPage.txt_Instution}" id="txt_Instution" style="left: 140px; top: 94px; position: absolute"/>
                                                    <ice:commandButton action="#{Recruitment$CandidatesPage.btn_AddEduc_action}"
                                                        binding="#{Recruitment$CandidatesPage.btn_AddEduc}" id="btn_AddEduc"
                                                        style="left: 168px; top: 134px; position: absolute; width: 71px" value="ADD"/>
                                                    <ice:commandButton action="#{Recruitment$CandidatesPage.btn_SaveEducation_action}"
                                                        binding="#{Recruitment$CandidatesPage.btn_SaveEducation}" id="btn_SaveEducation"
                                                        style="left: 288px; top: 134px; position: absolute" value="SaveEducation"/>
                                                    <ice:commandButton action="#{Recruitment$CandidatesPage.btn_edu_new_action}"
                                                        binding="#{Recruitment$CandidatesPage.btn_edu_new}" id="btn_edu_new"
                                                        style="left: 48px; top: 134px; position: absolute; width: 71px" value="New"/>
                                                    <ice:commandButton action="#{Recruitment$CandidatesPage.btn_Educedit_action}"
                                                        binding="#{Recruitment$CandidatesPage.btn_Educedit}" id="btn_Educedit"
                                                        style=" left: 432px; top: 134px; position: absolute; width: 71px" value="Edit"/>
                                                    <ice:commandButton action="#{Recruitment$CandidatesPage.btn_Educupdate_action}"
                                                        binding="#{Recruitment$CandidatesPage.btn_Educupdate}" id="btn_Educupdate"
                                                        style="left: 528px; top: 134px; position: absolute; width: 71px" value="Update"/>
                                                    <ice:commandButton action="#{Recruitment$CandidatesPage.btn_Educdelete_action}"
                                                        binding="#{Recruitment$CandidatesPage.btn_Educdelete}" id="btn_Educdelete"
                                                        style="left: 648px; top: 134px; position: absolute" value="Delete"/>
                                                </ice:panelLayout>
                                                <ice:outputText id="lblEmployeementHistory"
                                                    style="font-size: 11px; font-weight: bold; left: 25px; top: 25px; position: absolute" value="Candidate Basic Information "/>
                                                <ice:outputText id="lblRecruitmentBatchCode" style="font-size: 10px; left: 49px; top: 49px; position: absolute" value=" Batch Code"/>
                                                <ice:outputText id="lblCandidateType" style="font-size: 10px; left: 433px; top: 49px; position: absolute" value="Job Type"/>
                                                <ice:selectOneMenu binding="#{Recruitment$CandidatesPage.drlBatchCode}" id="drlBatchCode" partialSubmit="true"
                                                    style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 167px; top: 47px; position: absolute; width: 190px" valueChangeListener="#{Recruitment$CandidatesPage.drlBatchCode_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{Recruitment$CandidatesPage.bachCode}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectOneMenu binding="#{Recruitment$CandidatesPage.drlJobType}" id="drlJobType" partialSubmit="true"
                                                    style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 527px; top: 47px; position: absolute; width: 140px"
                                                    value="#{Recruitment$CandidatesPage.selectOneMenu2Bean.selectedObject}" valueChangeListener="#{Recruitment$CandidatesPage.drlJobType_processValueChange}">
                                                    <f:selectItems id="selectOneMenu2selectItems" value="#{Recruitment$CandidatesPage.jobTypeList}"/>
                                                </ice:selectOneMenu>
                                                <ice:panelLayout id="panelLayout1" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 40px; margin-left: 2px; left: 23px; top: 690px; position: absolute; width: 745px; -rave-layout: grid">
                                                    <ice:commandButton action="#{Recruitment$CandidatesPage.btnNew_action}"
                                                        binding="#{Recruitment$CandidatesPage.btnNew}" id="btnNew" immediate="true" partialSubmit="true"
                                                        style="margin-left: 40px; width: 80px" value="New"/>
                                                    <ice:commandButton action="#{Recruitment$CandidatesPage.btnSave_action}"
                                                        binding="#{Recruitment$CandidatesPage.btnSave}" id="btnSave" style="margin-left: 40px; width: 80px" value="Save"/>
                                                    <ice:commandButton action="#{Recruitment$CandidatesPage.btnEdit_action}"
                                                        binding="#{Recruitment$CandidatesPage.btnEdit}" id="btnEdit" style="margin-left: 40px; width: 80px" value="Edit"/>
                                                    <ice:commandButton action="#{Recruitment$CandidatesPage.btnUpdate_action}"
                                                        binding="#{Recruitment$CandidatesPage.btnUpdate}" id="btnUpdate" style="margin-left: 40px; width: 80px" value="Update"/>
                                                    <ice:commandButton action="#{Recruitment$CandidatesPage.btnReset_action}"
                                                        binding="#{Recruitment$CandidatesPage.btnReset}" id="btnReset" immediate="true" partialSubmit="true"
                                                        style="margin-left: 40px; width: 80px" value="#{msgs.cmdReset}"/>
                                                    <ice:commandButton action="#{Recruitment$CandidatesPage.btnDelete_action}"
                                                        binding="#{Recruitment$CandidatesPage.btnDelete}" id="btnDelete" style="margin-left: 40px; width: 80px" value="#{msgs.cmdDelete}"/>
                                                </ice:panelLayout>
                                                <ice:outputText binding="#{Recruitment$CandidatesPage.lblMesageConfirm}" id="lblMesageConfirm" rendered="true" style="color: rgb(32, 51, 96); font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 14px; font-style: normal; font-weight: bold; left: 38px; top: -10px; position: absolute"/>
                                                <ice:outputText binding="#{Recruitment$CandidatesPage.lblErrorMessageForBachCode}"
                                                    id="lblErrorMessageForBachCode" rendered="false"
                                                    style="color: red; font-size: 10px; font-weight: bolder; left: 237px; top: 91px; position: absolute" value="outputText"/>
                                                <ice:outputText binding="#{Recruitment$CandidatesPage.lblErrorMessageForCandidate}"
                                                    id="lblErrorMessageForCandidate" rendered="false"
                                                    style="color: red; font-size: 10px; font-weight: bolder; left: 550px; top: 91px; position: absolute" value="outputText"/>
                                                <webuijsf:panelLayout id="layoutPanel1" panelLayout="flow" style="width: 128px; height: 128px;"/>
                                            </ice:panelGroup>
                                            <ice:panelLayout id="pnl_EducationDatatable" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 100px; margin-left: 24px; left: 0px; top: 576px; overflow: auto; position: absolute; width: 741px; -rave-layout: grid">
                                                <ice:dataTable id="dataTable_Education" style="left: 74px; top: -10px; position: absolute"
                                                    value="#{Recruitment$CandidatesPage.candidateEducationList}" var="currentRow">
                                                    <ice:column id="column2">
                                                        <ice:outputText id="outputText5" value="#{currentRow['status']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText7" value="Status"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column1">
                                                        <ice:outputText id="txtCanID" value="#{currentRow['candidateID']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText6" value="CandidateID"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column3">
                                                        <ice:outputText id="txtInstiution" value="#{currentRow['instiution']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText10" value="Instiution"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column4">
                                                        <ice:outputText id="txtFiledOfStudy" value="#{currentRow['filedOfStudy']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText12" value="Filed of Study"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column5">
                                                        <ice:outputText id="txtEducationCat" value="#{currentRow['leavelOFEducation']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText14" value="Education Level"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column6">
                                                        <ice:outputText id="txtcgpaForData" value="#{currentRow['cgpa']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText16" value="CGPA"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column7">
                                                        <ice:outputText id="txtgraduationYear" value="#{currentRow['graduationYear']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText18" value="GraduationYear"/>
                                                        </f:facet>
                                                        <ice:rowSelector id="rowSelectorEmployeeExperance1" preStyleOnSelection="true"
                                                            selectionListener="#{Recruitment$CandidatesPage.rowSelectorCandidateEducation_processMyEvent}"
                                                            toggleOnClick="true" value="#{currentRow['selectedEducatuon']}"/>
                                                    </ice:column>
                                                </ice:dataTable>
                                            </ice:panelLayout>
                                        </ice:panelLayout>
                                    </fieldset>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="south">
                            <ice:panelGroup id="page_footer" style=" text-align: left;">
                                <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                    <label style="margin-left:20px;color:white;font-weight:bold;font-family:Cambria">BUNNA INTERNATIONAL BANK.Human Resource Management System.</label>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                    <ice:panelPopup autoCentre="true" binding="#{Recruitment$CandidatesPage.popupExamDetail}" draggable="false" id="popupExamDetail"
                        modal="true" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: -1000px; position: absolute; width: 720px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridpnMessage" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 751px">
                                <ice:outputText id="pnMessageTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Exame Result "/>
                                <ice:commandLink action="#{Recruitment$CandidatesPage.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage" immediate="true"
                                    style="border: 1px solid rgb(48, 102, 130); background-image: url(../resources/close_icon.gif); height: 19px; left: 728px; top: 2px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelGroupMessage" style="display: block; height: 300px; position: relative; width: 700px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlRequestBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 270px; position: relative; width: 626px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                    <ice:panelLayout id="lyExampResult" style="height: 200px; left: 10px; top: 10px; position: absolute; width: 710px">
                                        <ice:outputText id="lblWrittenExamResult"
                                            style="font-size: 10px; font-style: normal; font-weight: lighter; left: 7px; top: 40px; position: absolute" value="Written Exam Result"/>
                                        <ice:outputText id="lblInterviewResult"
                                            style="font-size: 10px; font-style: normal; font-weight: lighter; left: 8px; top: 74px; position: absolute" value="Interview"/>
                                        <ice:outputText escape="false" id="lblPractical"
                                            style="font-size: 10px; font-style: normal; font-weight: normal; left: 384px; top: 40px; position: absolute" value="Practical "/>
                                        <ice:outputText id="lblOther"
                                            style="font-size: 10px; font-style: normal; font-weight: normal; left: 384px; top: 74px; position: absolute" value="Other"/>
                                        <ice:outputText id="lblRecommendation"
                                            style="font-size: 10px; font-style: normal; font-weight: normal; left: 8px; top: 126px; position: absolute" value="Remark / Recommendation "/>
                                        <ice:inputText binding="#{Recruitment$CandidatesPage.txtwrittenExam}" id="txtwrittenExam" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 135px; top: 39px; position: absolute"/>
                                        <ice:inputText binding="#{Recruitment$CandidatesPage.txtInterview}" id="txtInterview" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 135px; top: 73px; position: absolute"/>
                                        <ice:inputText binding="#{Recruitment$CandidatesPage.txtPractical}" id="txtPractical" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 483px; top: 39px; position: absolute"/>
                                        <ice:inputText binding="#{Recruitment$CandidatesPage.txtOther}" id="txtOther" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 483px; top: 73px; position: absolute"/>
                                        <ice:inputTextarea binding="#{Recruitment$CandidatesPage.txtRecommendation}" id="txtRecommendation"
                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 68px; left: 135px; top: 108px; position: absolute; width: 472px" visible="true"/>
                                        <ice:outputText binding="#{Recruitment$CandidatesPage.lblNameOfCandidateResult}" id="lblNameOfCandidateResult"
                                            style="font-size: 10px; font-style: normal; font-weight: lighter; left: 7px; top: 5px; position: absolute" value="condomina"/>
                                    </ice:panelLayout>
                                    <ice:panelLayout id="pnlCandidateButton" style="border-width: 1px; border-color: rgb(204, 204, 204); border-top-style: solid; height: 45px; margin-left: 2px; left: 0px; top: 220px; position: absolute; width: 685px; -rave-layout: grid">
                                        <ice:commandButton action="#{Recruitment$CandidatesPage.btnSaveExam_action}"
                                            binding="#{Recruitment$CandidatesPage.btnSaveExam}" id="btnSaveExam" style="margin-left: 40px; width: 80px" value="#{msgs.cmdSave}"/>
                                        <ice:commandButton action="#{Recruitment$CandidatesPage.btnEditExam_action}"
                                            binding="#{Recruitment$CandidatesPage.btnEditExam}" id="btnEditExam" style="margin-left: 40px; width: 80px" value=" #{msgs.cmdEdit}"/>
                                        <ice:commandButton action="#{Recruitment$CandidatesPage.btnUpdateExam_action}"
                                            binding="#{Recruitment$CandidatesPage.btnUpdateExam}" id="btnUpdateExam" style="margin-left: 40px; width: 80px" value="#{msgs.cmdUpdate}"/>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Recruitment$CandidatesPage.panelPopupRecruitRequest}" draggable="true"
                        id="panelPopupRecruitRequest" modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 200px; position: absolute; width: 650px">
                        <f:facet name="header">
                            <ice:panelGrid id="panelGrid3RecruitRequest" style="display: block; height: 20px; width: 623px">
                                <ice:outputText id="outputText2RecruitRequest" value="BUNNA INTERNATIONAL BANK Human Resource Management System"/>
                            </ice:panelGrid>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGrid id="panelGrid4RecruitRequest" style="display: block; height: 94px; position: relative; width: 586">
                                <ice:commandButton action="#{Recruitment$CandidatesPage.btnRecruitRequestPopUpNo_action}" id="btnRecruitRequestPopUpNo"
                                    partialSubmit="true" rendered="true" style="left: 510px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                    value="No" visible="true"/>
                                <ice:commandButton action="#{Recruitment$CandidatesPage.btnRecruitRequestPopUpYes_action}" id="btnRecruitRequestPopUpYes"
                                    partialSubmit="true" rendered="true"
                                    style="background-position: 0 100%; background-repeat: no-repeat; left: 430px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                    value="Yes" visible="true"/>
                                <ice:outputText binding="#{Recruitment$CandidatesPage.lblRecruitRequestPopUpMsgMain}" id="lblRecruitRequestPopUpMsgMain" style="left:95px; top: 30px; position: absolute; width: 496px"/>
                                <ice:panelLayout id="panelLayoutRecruitRequestImageHolder" rendered="true"
                                    style=" width:62; height:56px; left: 10px; top: 15px; position: absolute;" styleClass="popUpBgimage" visible="true"/>
                            </ice:panelGrid>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Recruitment$CandidatesPage.pnMessage}" clientOnly="true" draggable="false" id="pnMessage"
                        modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridpnMessageExame" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnMessageTitleExam"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                <ice:commandLink action="#{Recruitment$CandidatesPage.modalPnlCloseMesssageExam_action}" id="modalPnlCloseMesssageExam"
                                    immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 692px; top: 2px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup binding="#{Recruitment$CandidatesPage.panelGroupMessageExam}" id="panelGroupMessageExam"
                                style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout binding="#{Recruitment$CandidatesPage.pnlMessageBodyExam}" id="pnlMessageBodyExam" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{Recruitment$CandidatesPage.lblFormMessageExam}" id="lblFormMessageExam" style="background-color: #F5F5F5;"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Recruitment$CandidatesPage.pnConfirmationMessage}" clientOnly="true" draggable="false"
                        id="pnConfirmationMessage" modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlConfirmationMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnConfirmationTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                <ice:commandLink action="#{Recruitment$CandidatesPage.cmdConfirmationCloseMesssage_action}" id="cmdConfirmationCloseMesssage"
                                    immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 690px; top: 3px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup binding="#{Recruitment$CandidatesPage.panelConfirmationGroupMessage}" id="panelConfirmationGroupMessage"
                                style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout binding="#{Recruitment$CandidatesPage.pnlConfirmationMessageBody}" id="pnlConfirmationMessageBody"
                                    layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel id="lblFormMessage4" style="background-color: #F5F5F5;"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <div class="some">
                        <input id="cal_day_names" type="hidden" value="ሰ,ማ,ረ,ሐ,ዓ,ቅ,እ"/>
                        <input id="cal_month_names" type="hidden" value="መስከረም,ጥቅምት,ህዳር,ታህሳስ,ጥር,የካቲት,መጋቢት,ሚያዝያ,ግንቦት,ሰኔ,ሀምሌ,ነሀሴ,ጷግሜ"/>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
