<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2011, 2:48:31 AM
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
                border: solid 1px #BD8;
                border: solid 1px #BD8;
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
                <!-- <link HREF="./FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1">
                <ice:form id="form1">
                    <div style="width:100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder height="480" id="whole_page" renderCenter="#{Recruitment$RecruitmentRequest.panelBorder1Bean.renderCenter}"
                            renderEast="#{Recruitment$RecruitmentRequest.panelBorder1Bean.renderEast}"
                            renderNorth="#{Recruitment$RecruitmentRequest.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Recruitment$RecruitmentRequest.panelBorder1Bean.renderSouth}"
                            renderWest="#{Recruitment$RecruitmentRequest.panelBorder1Bean.renderWest}" style="top: 5px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup dragListener="#{Recruitment$RecruitmentRequest.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
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
                                        style="height: 600px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 600px; left: 0px; top: 24px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible1" style="top:10px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass="">
                                                        <ice:outputText id="lblRecruitmentRequest" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid1" width="100%">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$RecruitmentRequest.cmdRecruitmentApproval_action}"
                                                                id="cmdRecruitmentApproval" immediate="true" partialSubmit="true"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Recruitment Approve"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$RecruitmentRequest.cmdVacancyNotice_action}"
                                                                id="cmdVacancyNotice" immediate="true" partialSubmit="true"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Maintain Advertisement"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$RecruitmentRequest.cmdFilterCandidates_action}"
                                                                id="cmdFilterCandidates" immediate="true" partialSubmit="true"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Filter Candidates"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$RecruitmentRequest.cmdExamQuestions_action}"
                                                                id="cmdExamQuestions" immediate="true" partialSubmit="true"
                                                                style="color:#306682;font-weight:bold" value="Filter Candidate For Exam"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$RecruitmentRequest.cmdRegisterCandidate_action}"
                                                                id="cmdRegisterCandidate" immediate="true" partialSubmit="true"
                                                                style="color:#306682;font-weight:bold" value="Register Candidate"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <!-- <ice:panelCollapsible expanded="true" id="panelCollapsible4">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup3" styleClass="">
                                                        <ice:outputText id="lblRequesterName" value="Type Requeater Name"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid3">
                                                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background: #FFF;border: 1px solid #d9d9d9;display: block;float:left;height: 55px; width: 100%">
                                                        <ice:selectInputText action="#{Recruitment$RecruitmentRequest.txtSearByName_action}"
                                                            binding="#{Recruitment$RecruitmentRequest.txtSearByName}" id="txtSearByName"
                                                            listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true" rows="10" valueChangeListener="#{ApplicationBean1.updateList}">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="photoCol,fullNameCol,empIdentificationCol" columns="3">
                                                                    <ice:graphicImage height="40px" id="graphicImageSerch" value="#{employeeList.photo}" width="40px"/>
                                                                    <ice:outputText id="lblFullNameAutoComplete2"
                                                                        style="left:70px; top:15px; position: absolute" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete2"
                                                                        style="left:250px; top:15px; position: absolute" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible> -->
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible3">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup2" styleClass="">
                                                        <ice:outputText id="outputText4" value="Recruitment Request History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid2">
                                                    <ice:panelTabSet id="panelTabSet1" style="width:100%" tabPlacement="Top">
                                                        <ice:panelTab id="tabSearch" label="Requests ">
                                                            <ice:panelGrid id="search_panelGrid">
                                                                <ice:panelGroup id="btnSearchEmployeeState" style="border: 0px solid rgb(217, 217, 217); margin: -5px -5px -5px -10px;   background-color: rgb(255, 255, 255); display: block; float: left; height: 250px; width: 170px; left: -5px">
                                                                    <ice:panelLayout id="layoutRecHist"
                                                                        style="height: 245px; margin-left: 1px; margin-top: 1px; position: absolute; width: 175px" styleClass="insideContainerMain">
                                                                        <ice:outputText id="outputTextSearchHist"
                                                                            style=" margin:5px 0 0 3px; position: absolute;" value="From Date"/>
                                                                        <ice:inputText binding="#{Recruitment$RecruitmentRequest.inputTextSearchHist}"
                                                                            id="inputTextSearchHist"
                                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; margin:5px 0 0 50px; position: absolute;   height:20px; width:117px" validator="#{Recruitment$RecruitmentRequest.inputTextSearchHist_validate}"/>
                                                                        <ice:outputText id="outputTextSearchHistTo"
                                                                            style=" margin:40px 0 0 3px;  position: absolute;" value="To Date"/>
                                                                        <ice:inputText binding="#{Recruitment$RecruitmentRequest.inputTextSearchHistTo}"
                                                                            id="inputTextSearchHistTo"
                                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; margin:40px 0 0 50px; position: absolute;   height:20px; width:117px" validator="#{Recruitment$RecruitmentRequest.inputTextSearchHistTo_validate}"/>
                                                                        <ice:commandButton action="#{Recruitment$RecruitmentRequest.btnCalenderRecTo_action}"
                                                                            binding="#{Recruitment$RecruitmentRequest.btnCalenderRecTo}" id="btnCalenderRecTo"
                                                                            image="/resources/images/cal_icon.JPG" immediate="true"
                                                                            style="margin-left: 150px; margin-top: 40px; position: absolute" value="submit"/>
                                                                        <ice:commandButton action="#{Recruitment$RecruitmentRequest.btnAddSearchRecHist_action}"
                                                                            binding="#{Recruitment$RecruitmentRequest.btnAddSearchRecHist}"
                                                                            id="btnAddSearchRecHist" partialSubmit="true"
                                                                            style=" font-size: 11px; margin-left:4px; margin-top: 68px; width: 82px; height:22px; position: absolute" value="Date Search"/>
                                                                        <ice:commandButton
                                                                            action="#{Recruitment$RecruitmentRequest.btnAddSearchRecHistAll_action}"
                                                                            binding="#{Recruitment$RecruitmentRequest.btnAddSearchRecHistAll}"
                                                                            id="btnAddSearchRecHistAll" partialSubmit="true"
                                                                            style=" font-size: 11px; margin-left:90px; margin-top: 68px; width: 75px; height:22px; position: absolute" value="All Search"/>
                                                                        <ice:panelLayout id="panelRecHist" style="border: 1px solid #a5c9cf; margin: 90px 0 0 5px; height:150px; overflow: -moz-scrollbars-horizontal; width:160px; position: absolute">
                                                                            <ice:selectOneListbox
                                                                                binding="#{Recruitment$RecruitmentRequest.selectOneListboxRecHist}"
                                                                                id="selectOneListboxRecHist" partialSubmit="true" size="2"
                                                                                style="border: 1px solid #a5c9cf;  height:150px;"
                                                                                value="#{Recruitment$RecruitmentRequest.defaultSelectedData5.selectedObject}" valueChangeListener="#{Recruitment$RecruitmentRequest.selectOneListboxRecHist_processValueChange}">
                                                                                <f:selectItems
                                                                                binding="#{Recruitment$RecruitmentRequest.selectOneListbox1selectItemsRecHist}"
                                                                                id="selectOneListbox1selectItemsRecHist" value="#{Recruitment$RecruitmentRequest.requestsUsingDate}"/>
                                                                            </ice:selectOneListbox>
                                                                        </ice:panelLayout>
                                                                        <ice:commandButton action="#{Recruitment$RecruitmentRequest.btnCalenderRecF_action}"
                                                                            binding="#{Recruitment$RecruitmentRequest.btnCalenderRecF}" id="btnCalenderRecF"
                                                                            image="/resources/images/cal_icon.JPG" immediate="true"
                                                                            style="margin-left: 150px; margin-top: 5px; position: absolute" value="submit"/>
                                                                    </ice:panelLayout>
                                                                </ice:panelGroup>
                                                            </ice:panelGrid>
                                                            <ice:selectInputDate binding="#{Recruitment$RecruitmentRequest.calFromDate}" id="calFromDate"
                                                                renderYearAsDropdown="true" rendered="false"
                                                                style="height: 212px; left: 200px; top: 350px; position: absolute; width: 190px; z-index: 99"
                                                                value="#{Recruitment$RecruitmentRequest.selectInputDate1Bean.date1}" valueChangeListener="#{Recruitment$RecruitmentRequest.calFromDate_processValueChange}"/>
                                                        </ice:panelTab>
                                                        <!-- <ice:panelTab binding="#{Recruitment$RecruitmentRequest.tabinbox}" id="tabinbox" label="Response">
                                                            <ice:panelLayout id="panelLayout2" style="position: inherit; width: 100%; height: 100%;">
                                                                <ice:selectOneListbox binding="#{Recruitment$RecruitmentApprove.selectOneListbox1RGiven}"
                                                                    id="selectOneListbox1RGiven" partialSubmit="true" size="2"
                                                                    style="height:180px; border: 1px solid #73b3ce;"
                                                                    value="#{Recruitment$RecruitmentApprove.defaultSelectedData6.selectedObject}" valueChangeListener="#{Recruitment$RecruitmentApprove.selectOneListbox1RGiven_processValueChange}">
                                                                    <f:selectItems id="selectOneListbox1selectItems1Rgiven" value="#{Recruitment$RecruitmentApprove.response}"/>
                                                                </ice:selectOneListbox>
                                                            </ice:panelLayout>
                                                        </ice:panelTab>-->
                                                    </ice:panelTabSet>
                                                    <br/>
                                                    <br/>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 760px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 720px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 720px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Recruitment Request"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 741px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelLayout binding="#{Recruitment$RecruitmentRequest.message}" id="message"
                                                    style="left: 0px; top: -33px; position: absolute; width: 720px; z-index: 9" styleClass="message">
                                                    <ice:outputLabel binding="#{Recruitment$RecruitmentRequest.lblFormMessage}" id="lblFormMessage" value="success"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="lyApproved1"
                                                    style="height: 325px; margin-left: 10px; margin-top: 0px; top: 75px; position: absolute; width: 760px" styleClass="insideContainerMain">
                                                    <ice:outputText id="lblRequesterId" style="font-size: 10px; left: 24px; top: 10px; position: absolute" value="#{msgs.Requester}"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentRequest.txtRequester}" disabled="true" id="txtRequester" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 10px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="lblRequiredJobType" style="font-size: 10px; left: 408px; top: 10px; position: absolute" value="#{msgs.RequiredJobType}"/>
                                                    <ice:selectOneMenu binding="#{Recruitment$RecruitmentRequest.drlRequiredJobType}" id="drlRequiredJobType"
                                                        partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240);  color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 526px; top: 10px; position: absolute; width: 190px" valueChangeListener="#{Recruitment$RecruitmentRequest.drlRequiredJobType_processValueChange}">
                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{Recruitment$RecruitmentRequest.readJob}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:outputText id="outputText1" style="font-size: 10px; left: 24px; top: 100px; position: absolute" value="#{msgs.MinQualification}"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentRequest.txtMinQualifcation}" disabled="true"
                                                        id="txtMinQualifcation" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 100px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="lblMinExperience" style="font-size: 10px; left: 408px; top: 100px; position: absolute" value="#{msgs.MinExperience}"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentRequest.txtMinExperiance}" disabled="true"
                                                        id="txtMinExperiance" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 526px; top: 100px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="lblMinResponsibilities"
                                                        style="font-size: 10px; left: 24px; top: 140px; position: absolute" value="#{msgs.MinResponsibilities}"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentRequest.txtMinResponsiblity}" disabled="true"
                                                        id="txtMinResponsiblity" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 140px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="lblAdditionalSkill" style="font-size: 10px; left: 408px; top: 140px; position: absolute" value="#{msgs.AdditionalSkill}"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentRequest.txtAdditionalskill}" disabled="true"
                                                        id="txtAdditionalskill" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 526px; top: 140px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="lblNumberRequiredEmployee"
                                                        style="font-size: 10px; left: 24px; top: 180px; position: absolute" value="#{msgs.NumberRequiredEmployee}"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentRequest.txtNumberOfEmployee}" id="txtNumberOfEmployee"
                                                        required="true"
                                                        style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 180px; position: absolute; width: 56px"
                                                        validator="#{Recruitment$RecruitmentRequest.txtNumberOfEmployee_validate}" value="1"/>
                                                    <ice:outputText id="lblemploymentType" style="font-size: 10px; left: 408px; top: 180px; position: absolute" value="#{msgs.employmentType}"/>
                                                    <ice:selectOneMenu binding="#{Recruitment$RecruitmentRequest.drlEmployeeMentType}" id="drlEmployeeMentType"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 526px; top: 180px; position: absolute; width: 190px"
                                                        value="#{Recruitment$RecruitmentRequest.selectOneMenu2Bean.selectedObject}" valueChangeListener="#{Recruitment$RecruitmentRequest.drlEmployeeMentType_processValueChange}">
                                                        <f:selectItems id="selectOneMenu2selectItems" value="#{Recruitment$RecruitmentRequest.recritmentType}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:inputTextarea binding="#{Recruitment$RecruitmentRequest.txtARemark}" id="txtARemark" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 68px; left: 166px; top: 240px; position: absolute; width: 548px"/>
                                                    <ice:outputText id="txtRemark" style="font-size: 10px; left: 24px; top: 240px; position: absolute" value="#{msgs.Remark}"/>
                                                    <ice:outputText binding="#{Recruitment$RecruitmentRequest.txtConfirmation}" id="txtConfirmation"
                                                        rendered="false"
                                                        style="color: rgb(0, 153, 255); font-family: Georgia,'Times New Roman',times,serif; font-size: 14px; left: 31px; top: -10px; position: absolute" value="outputText"/>
                                                    <ice:outputText id="outputText2" style="font-size: 10px; left: 24px; top: 60px; position: absolute" value="Rank"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentRequest.txtRunk}" disabled="true" id="txtRunk" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 60px; position: absolute; width: 190px"/>
                                                    <ice:inputText binding="#{Recruitment$RecruitmentRequest.txtSalary}" disabled="true" id="txtSalary" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 526px; top: 60px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="outputText5" style="font-size: 10px; left: 408px; top: 60px; position: absolute" value="#{msgs.Salary}"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="lyRequestTable"
                                                    style="height: 150px; margin-left: 10px; margin-top: 410px; top: 80px; overflow: auto; position: absolute; width: 760px" styleClass="insideContainerMain">
                                                    <ice:dataTable id="dataTableRecRequest" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                        value="#{Recruitment$RecruitmentRequest.recruitRecuestList}" var="currentRow" width="727">
                                                        <ice:column groupOn="#{currentRow['requiredJobType']}" id="columnJT">
                                                            <ice:outputText id="outputTextJT" value="#{currentRow['requiredJobType']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText3" value="Job Type"/>
                                                            </f:facet>
                                                            <ice:rowSelector binding="#{Recruitment$RecruitmentRequest.rowSelectorRecruitmentRequest}"
                                                                id="rowSelectorRecruitmentRequest" multiple="false" preStyleOnSelection="true"
                                                                selectionListener="#{Recruitment$RecruitmentRequest.rowSelectorRecruitmentRequest_processMyEvent}"
                                                                toggleOnClick="true" value="#{currentRow['selected']}"/>
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
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtNumberOfEmployee" id="message1"
                                                    infoClass="infoMessage" showDetail="true"
                                                    style="font-size: 10px; left: 225px; top: 280px; position: absolute" warnClass="warnMessage"/>
                                                <ice:outputText binding="#{Recruitment$RecruitmentRequest.lblErrorMessageRequired}" id="lblErrorMessageRequired"
                                                    rendered="false"
                                                    style="color: red; font-size: 10px; font-weight: bolder; left: 715px; top: 27px; position: absolute" value="outputText"/>
                                                <ice:outputText binding="#{Recruitment$RecruitmentRequest.lblErrorMessageForEmployeeType}"
                                                    id="lblErrorMessageForEmployeeType" rendered="false"
                                                    style="color: #ff0000; font-size: 10px; left: 625px; top: 280px; position: absolute" value="outputText"/>
                                                <ice:panelLayout id="panelLayout1" style="height: 40px; left: 10px; top: 30px; position: absolute; width: 760px" styleClass="insideContainerMain">
                                                    <ice:inputText binding="#{Recruitment$RecruitmentRequest.txtPlaceWorking}" id="txtPlaceWorking" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 10px; position: absolute; width: 551px"/>
                                                    <ice:outputText id="lblWorkingPlace1" style="font-size: 10px; left: 24px; position: absolute" value="Working Place"/>
                                                    <ice:commandButton action="#{Recruitment$RecruitmentRequest.btnTree_action}" id="btnTree"
                                                        image="/Employee/images/pic3-tree-icon.jpg" partialSubmit="true"
                                                        style="left: 700px; top: 11px; position: absolute" value="Tree"/>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="lyAddtableMess"
                                                style="height: 50px; margin-left: 10px; margin-top: 350px; top: 70px; position: absolute; width: 760px" styleClass="insideContainerMain">
                                                <ice:commandButton action="#{Recruitment$RecruitmentRequest.btnAddTable_action}"
                                                    binding="#{Recruitment$RecruitmentRequest.btnAddTable}" id="btnAddTable"
                                                    style="margin-left: 10px; position: absolute; width: 160px" value="Add to Table"/>
                                                <ice:commandButton action="#{Recruitment$RecruitmentRequest.btnAdvertise_action}"
                                                    binding="#{Recruitment$RecruitmentRequest.btnAdvertise}" id="btnAdvertise" rendered="false"
                                                    style="margin-left: 650px;   width: 80px; position: absolute" value="Advertise"/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="lyRequestStatus"
                                                style="height: 30px; margin-left: 200px; margin-top: -57px; position: absolute; width: 680px" styleClass="">
                                                <ice:outputText id="lblStatus"
                                                    style="font-size: 16px; color: #023369; font-weight:bold; left: 5px; top: 7px; position: absolute" value="Status:"/>
                                                <ice:outputText binding="#{Recruitment$RecruitmentRequest.lblStatusValue}" id="lblStatusValue"
                                                    style="font-size: 12px; color: #dc6a0e; font-weight:bold; font-family: Arial, Helvetica, sans-serif;left: 72px; top: 10px; position: absolute" value="Recruitment Request Status."/>
                                                <ice:outputText id="lblAdvertisement"
                                                    style="font-size: 16px; color: #023369; font-weight:bold; left: 300px; top: 7px; position: absolute" value="Advertised:"/>
                                                <ice:outputText binding="#{Recruitment$RecruitmentRequest.lblAdvertisementValue}" id="lblAdvertisementValue"
                                                    style="font-size: 12px; color: #dc6a0e; font-weight:bold; font-family: Arial, Helvetica, sans-serif; left: 400px; top: 10px; position: absolute" value="Advertisement Status."/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="lybuttons"
                                                style="height: 50px; margin-left: 10px; margin-top: 570px; top: 80px; position: absolute; width: 760px" styleClass="insideContainerMain">
                                                <ice:commandButton action="#{Recruitment$RecruitmentRequest.btnNew_action}"
                                                    binding="#{Recruitment$RecruitmentRequest.btnNew}" id="btnNew" style="margin-left: 40px; width: 80px" value="New"/>
                                                <ice:commandButton action="#{Recruitment$RecruitmentRequest.btnSave_action}"
                                                    binding="#{Recruitment$RecruitmentRequest.btnSave}" id="btnSave" style="margin-left: 40px; width: 80px" value="Save"/>
                                                <ice:commandButton action="#{Recruitment$RecruitmentRequest.btnEdit_action}"
                                                    binding="#{Recruitment$RecruitmentRequest.btnEdit}" id="btnEdit" style="margin-left: 40px; width: 80px" value="Edit"/>
                                                <ice:commandButton action="#{Recruitment$RecruitmentRequest.btnUpdate_action}"
                                                    actionListener="#{Recruitment$RecruitmentRequest.btnUpdate_processAction}"
                                                    binding="#{Recruitment$RecruitmentRequest.btnUpdate}" id="btnUpdate" style="margin-left: 40px; width: 80px" value="Update"/>
                                                <ice:commandButton actionListener="#{Recruitment$RecruitmentRequest.btnReset_processAction}"
                                                    binding="#{Recruitment$RecruitmentRequest.btnReset}" id="btnReset" immediate="true" partialSubmit="true"
                                                    style="margin-left: 40px; width: 80px" value="#{msgs.cmdReset}"/>
                                                <ice:commandButton action="#{Recruitment$RecruitmentRequest.btnDelete_action}"
                                                    actionListener="#{Recruitment$RecruitmentRequest.btnDelete_processAction}"
                                                    binding="#{Recruitment$RecruitmentRequest.btnDelete}" id="btnDelete" style="margin-left: 40px; width: 80px" value="#{msgs.cmdDelete}"/>
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
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$RecruitmentRequest.panelPopupRecruitRequest}" draggable="true"
                            id="panelPopupRecruitRequest" modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 200px; position: absolute; width: 650px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid3RecruitRequest" style="display: block; height: 20px; width: 623px">
                                    <ice:outputText id="outputText2RecruitRequest" value="BUNNA INTERNATIONAL BANK human Resource Management System"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="panelGrid4RecruitRequest" style="display: block; height: 94px; position: relative; width: 586">
                                    <ice:commandButton action="#{Recruitment$RecruitmentRequest.btnRecruitRequestPopUpNo_action}"
                                        binding="#{Recruitment$RecruitmentRequest.btnRecruitRequestPopUpNo}" id="btnRecruitRequestPopUpNo" rendered="true"
                                        style="left: 510px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No" visible="true"/>
                                    <ice:commandButton action="#{Recruitment$RecruitmentRequest.btnRecruitRequestPopUpYes_action}"
                                        binding="#{Recruitment$RecruitmentRequest.btnRecruitRequestPopUpYes}" id="btnRecruitRequestPopUpYes" rendered="true"
                                        style="background-position: 0 100%; background-repeat: no-repeat; left: 430px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                        value="Yes" visible="true"/>
                                    <ice:outputText binding="#{Recruitment$RecruitmentRequest.lblRecruitRequestPopUpMsgMain}" id="lblRecruitRequestPopUpMsgMain" style="left:95px; top: 30px; position: absolute; width: 496px"/>
                                    <ice:panelLayout binding="#{Recruitment$RecruitmentRequest.panelLayoutRecruitRequestImageHolder}"
                                        id="panelLayoutRecruitRequestImageHolder" rendered="true"
                                        style=" width:62; height:56px; left: 10px; top: 15px; position: absolute;" styleClass="popUpBgimage" visible="true"/>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelLayout binding="#{Recruitment$RecruitmentRequest.pnlLayoutTree}" id="pnlLayoutTree" layout="flow" rendered="false"
                            style="border-width: 2px; border-style: solid; height: 356px; left: 700px; top: 240px; overflow: scroll; position: absolute; width: 504px; -rave-layout: grid" styleClass="insideContainerMain">
                            <ice:tree binding="#{Recruitment$RecruitmentRequest.treeOrgStructure}" id="tree"
                                style="height: 286px; margin-left: 0px; margin-top: 0px; left: 0px; top: 0px; position: absolute; text-align: left; width: 190px"
                                value="#{Recruitment$RecruitmentRequest.treeModel.model}" var="item">
                                <ice:treeNode id="treeNode2">
                                    <f:facet name="icon">
                                        <ice:panelGroup id="panelGroup1" style="display: inline;">
                                            <ice:graphicImage id="graphicImage2" value="#{item.userObject.icon}"/>
                                        </ice:panelGroup>
                                    </f:facet>
                                    <f:facet name="content">
                                        <ice:panelGroup id="panelGroup2" style="display: inline;">
                                            <ice:commandLink actionListener="#{Recruitment$RecruitmentRequest.cmdLnkTree_processAction}" id="cmdLnkTree" partialSubmit="true">
                                                <ice:outputText id="outputText1" value="#{item.userObject.text}"/>
                                            </ice:commandLink>
                                        </ice:panelGroup>
                                    </f:facet>
                                </ice:treeNode>
                            </ice:tree>
                        </ice:panelLayout>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
