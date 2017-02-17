<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : BravoZulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
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
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <script src="../Script/Ethiopian_Calendar.js"></script>
                <script src="../Script/jquery-1.3.2.min.js"></script>
                <ice:form id="form1">
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{Page1.panelBorder1Bean.renderCenter}"
                        renderEast="#{Page1.panelBorder1Bean.renderEast}" renderNorth="#{Page1.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Page1.panelBorder1Bean.renderSouth}" renderWest="#{Page1.panelBorder1Bean.renderWest}"
                        style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                        <f:facet name="north">
                            <ice:panelGroup dragListener="#{Page1.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
                                <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow" style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                    styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                                <!-- End Header -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup id="menu_left" style=" height:100%;">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height: 312px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 136px; left: -4px; position: absolute; width: 213px" styleClass="list_menu">
                                        <ice:panelCollapsible binding="#{Page1.panelCollapsible2}" id="panelCollapsible2"
                                            style="left: 1px; top: 30px; position: absolute; height:46 px; width: 214px" toggleOnClick="true">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup2" styleClass="">
                                                    <ice:outputText id="outputText2" value="header Value"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid1">
                                                <ice:outputText id="outputText3" value="Text Description"/>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                    </ice:panelLayout>
                                    <ice:panelLayout id="search" layout="flow"
                                        style="height: 46px; left: -5px; top: 163px; position: absolute; width: 212px; -rave-layout: grid" styleClass="search"/>
                                    <ice:panelLayout id="status" layout="flow"
                                        style="height: 63px; left: -3px; top: 218px; position: absolute; width: 212px; -rave-layout: grid" styleClass="status"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 498px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 490px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <ice:panelLayout binding="#{Recruitment$CandidateEducation.canEducationall}" id="canEducationall" layout="flow" style="border-width: 1px; border-style: dotted; height: 453px; left: 0px; top: 24px; position: absolute; width: 838px; -rave-layout: grid"/>
                                    <ice:panelLayout id="pnlAdvertismnetList" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 447px; margin-left: 2px; left: 22px; top: 30px; position: absolute; width: 745px; -rave-layout: grid">
                                        <ice:outputText id="lblLevelofEducation" style="font-size: 10px; left: 24px; top: 72px; position: absolute" value=" Level of Education"/>
                                        <ice:outputText id="lblGraduatedby" style="font-size: 10px; left: 408px; top: 72px; position: absolute" value="Graduated by"/>
                                        <ice:inputText binding="#{Recruitment$CandidateEducation.txtGraduatedby}" id="txtGraduatedby" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 526px; top: 70px; position: absolute; width: 190px"/>
                                        <ice:outputText id="lblCGPA" style="font-size: 10px; left: 24px; top: 120px; position: absolute" value="Cumulative GPA"/>
                                        <ice:inputText binding="#{Recruitment$CandidateEducation.txtCGPA}" id="txtCGPA"
                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 118px; position: absolute; width: 60px" value="0"/>
                                        <ice:outputText id="lblYearOfGraduation" style="left: 408px; top: 120px; position: absolute" value="Year Of Graduation"/>
                                        <ice:commandButton action="#{Recruitment$CandidateEducation.btnCalenderYearOfGraduation_action}"
                                            binding="#{Recruitment$CandidateEducation.btnCalenderYearOfGraduation}" id="btnCalenderYearOfGraduation"
                                            image="/Employee/images/calendar.gif" immediate="true"
                                            style="border-width: 1px; background-color: rgb(242, 246, 240); left: 696px; top: 120px; position: absolute; z-index: 5" value="submit"/>
                                        <ice:selectInputDate binding="#{Recruitment$CandidateEducation.calDateOfGraduation}" id="calDateOfGraduation"
                                            renderMonthAsDropdown="true" renderYearAsDropdown="true" rendered="false"
                                            style="height: 212px; left: 528px; top: -24px; position: absolute; width: 190px; z-index: 10"
                                            value="#{Recruitment$CandidateEducation.selectInputDateBean1.date1}" valueChangeListener="#{Recruitment$CandidateEducation.calDateOfGraduation_processValueChange}"/>
                                        <ice:inputText binding="#{Recruitment$CandidateEducation.txtYearOfGraduation}" id="txtYearOfGraduation" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; height: 20px; left: 526px; top: 118px; position: absolute; width: 167px"/>
                                        <ice:selectOneMenu binding="#{Recruitment$CandidateEducation.drlLevelOfEducation}" id="drlLevelOfEducation"
                                            partialSubmit="true"
                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 142px; top: 70px; position: absolute; width: 239px"
                                            value="#{Recruitment$CandidateEducation.defaultSelectedData8.selectedObject}" valueChangeListener="#{Recruitment$CandidateEducation.drlLevelOfEducation_processValueChange}">
                                            <f:selectItems id="selectOneMenu1selectItems3" value="#{Recruitment$CandidateEducation.educLevelOpt}"/>
                                        </ice:selectOneMenu>
                                        <ice:outputText id="outputText4" style="left: 24px; top: 168px; position: absolute" value="Instiution"/>
                                        <ice:inputText binding="#{Recruitment$CandidateEducation.txt_Instution}" id="txt_Instution" style="left: 142px; top: 166px; position: absolute; width: 239px"/>
                                        <ice:commandButton action="#{Recruitment$CandidateEducation.btn_AddEduc_action}"
                                            binding="#{Recruitment$CandidateEducation.btn_AddEduc}" id="btn_AddEduc"
                                            style="height: 46px; left: 408px; top: 182px; position: absolute; width: 95px" value="ADD"/>
                                        <ice:commandButton action="#{Recruitment$CandidateEducation.btn_SaveEducation_action}"
                                            binding="#{Recruitment$CandidateEducation.btn_SaveEducation}" id="btn_SaveEducation"
                                            style="height: 47px; left: 72px; top: 374px; position: absolute; width: 114px" value="SaveEducation"/>
                                        <ice:commandButton action="#{Recruitment$CandidateEducation.btn_edu_new_action}"
                                            binding="#{Recruitment$CandidateEducation.btn_edu_new}" id="btn_edu_new"
                                            style="height: 47px; left: 240px; top: 182px; position: absolute; width: 96px" value="New"/>
                                        <ice:commandButton action="#{Recruitment$CandidateEducation.btn_Educedit_action}"
                                            binding="#{Recruitment$CandidateEducation.btn_Educedit}" id="btn_Educedit"
                                            style="height: 47px; left: 240px; top: 374px; position: absolute; width: 96px" value="Edit"/>
                                        <ice:commandButton action="#{Recruitment$CandidateEducation.btn_Educupdate_action}"
                                            binding="#{Recruitment$CandidateEducation.btn_Educupdate}" id="btn_Educupdate"
                                            style="height: 47px; left: 384px; top: 374px; position: absolute; width: 96px" value="Update"/>
                                        <ice:commandButton action="#{Recruitment$CandidateEducation.btn_Educdelete_action}"
                                            binding="#{Recruitment$CandidateEducation.btn_Educdelete}" id="btn_Educdelete"
                                            style="height: 47px; left: 528px; top: 374px; position: absolute; width: 95px" value="Delete"/>
                                        <ice:panelLayout id="pnlDataTable" layout="flow" style="border-width: 1px; border-style: dotted; height: 117px; left: 24px; top: 240px; position: absolute; width: 694px; -rave-layout: grid"/>
                                        <ice:dataTable id="dataTable_Education" style="left: 62px; top: 254px; position: absolute"
                                            value="#{Recruitment$CandidateEducation.candidateEducationList}" var="currentRow">
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
                                                    selectionListener="#{Recruitment$CandidateEducation.rowSelectorCandidateEducation_processMyEvent}"
                                                    toggleOnClick="true" value="#{currentRow['selectedEducatuon']}"/>
                                            </ice:column>
                                        </ice:dataTable>
                                        <ice:panelLayout binding="#{Recruitment$CandidateEducation.pnl_NameSearch}" id="pnl_NameSearch" layout="flow" style="border-width: 1px; border-style: dotted; height: 45px; left: 48px; top: 0px; position: absolute; width: 622px">
                                            <ice:selectInputText action="#{Recruitment$CandidateEducation.txtSearchCandidate_action}" id="txtSearchCandidate"
                                            listValue="#{Recruitment$CandidateEducation.matchesList}" listVar="employeeList" partialSubmit="true" rows="10"
                                                style="left: 240px; top: 5px; position: absolute" valueChangeListener="#{ApplicationBean1.changeListForCandidateEducation}">
                                                <f:facet name="selectInputText">
                                                    <ice:panelGrid columnClasses="fullNameCandidate,empIdCol" columns="2">
                                                        <ice:outputText id="lblFullNameAutoComplete2" value="#{employeeList.fullName}"/>
                                                        <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{employeeList.empIdentification}"/>
                                                    </ice:panelGrid>
                                                </f:facet>
                                            </ice:selectInputText>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="south">
                            <ice:panelGroup id="page_footer" style=" text-align: center;">
                                <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">This is the
                                Footer</ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
