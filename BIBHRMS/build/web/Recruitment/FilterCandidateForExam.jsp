<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : May 24, 2010, 6:48:31 AM
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
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div style="width: 100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder height="480" id="whole_page" renderCenter="#{Page1.panelBorder1Bean.renderCenter}"
                            renderEast="#{Page1.panelBorder1Bean.renderEast}" renderNorth="#{Page1.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Page1.panelBorder1Bean.renderSouth}" renderWest="#{Page1.panelBorder1Bean.renderWest}"
                            style="top: 5px; position: relative" styleClass="whole_page" width="1040">
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
                                <ice:panelGroup id="menu_left" style=" height:100%;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 550px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 663px; left: 8px; top: 15px; position: absolute; width: 213px" styleClass="list_menu">
                                            <ice:panelCollapsible binding="#{Page1.panelCollapsible2}" expanded="true" id="panelCollapsible2" style="top:10px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup2" styleClass="">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid1" width="100%">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$FilterCandidateForExam.cmdRecruitmentRequest_action}"
                                                                id="cmdRecruitmentRequest" style="color: rgb(48, 102, 130); font-weight: bold" value="Recruitment Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$FilterCandidateForExam.cmdrecApproval_action}"
                                                                id="cmdrecApproval" style="color: rgb(48, 102, 130); font-weight: bold" value="Request Approved "/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$FilterCandidateForExam.cmdvacNotice_action}"
                                                                id="cmdvacNotice" style="color: rgb(48, 102, 130); font-weight: bold" value="Maintain Advertisement"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$FilterCandidateForExam.cmdRegisterCandidate_action}"
                                                                id="cmdRegisterCandidate" style="color: rgb(48, 102, 130); font-weight: bold" value="Register Candidate"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$FilterCandidateForExam.cmdfilterCandidate_action}"
                                                                id="cmdfilterCandidate" style="color: rgb(48, 102, 130); font-weight: bold" value="Filter Candidate"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible1" style="hight:200px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass="">
                                                        <ice:outputText id="outputText1" value="Select Requirement Id "/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid2" style="height: 325px;">
                                                    <ice:commandLink action="#{Recruitment$FilterCandidateForExam.cmdSetDisplayCriteria_action}"
                                                        id="cmdSetDisplayCriteria" rendered="false"
                                                        style="left: 22px; top: -30px; position: relative; width: 100px" value=" Set Display Criteria "/>
                                                    <ice:commandButton action="#{Recruitment$FilterCandidateForExam.btnSortCriteria_action}"
                                                        id="btnSortCriteria" rendered="false" style="left: 8px; top: 3px; position: relative; width: 135px" value="Set Display Criteria"/>
                                                    <ice:selectOneMenu id="selectOneMenu1" partialSubmit="true"
                                                        style="left: 2px; top: -130px; position: relative; width: 135px" value="Set Display Criteria" valueChangeListener="#{Recruitment$FilterCandidateForExam.selectOneMenu1_processValueChange}">
                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{Recruitment$FilterCandidateForExam.bachCode}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:commandLink action="#{Recruitment$FilterCandidateForExam.cmdPrepare_action}" id="cmdPrepare"
                                                        rendered="false" style="left: 40px; top: -230px; position: relative; " value="[ Prepare ]"/>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 650px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 400px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 620px;width:790px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="LIST OF RECRUITMENT CANDIDATES  "/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 560px; left: 0px; top: -20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 560px" styleClass="filedset_normal">
                                                    <ice:panelLayout id="lyRequestTable"
                                                        style="height: 150px; margin-left: 10px; margin-top: 410px; left: 15px; top: -361px; overflow: auto; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:dataTable id="dataTableRecRequest" style="left: 0px; top: -10px; position: absolute"
                                                            value="#{Recruitment$FilterCandidateForExam.recruitRecuestList}" var="currentRow" width="727">
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
                                                    <ice:panelLayout id="lyTableControl" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 258px; left: 25px; top: 217px; position: absolute; overflow:auto; width: 742px" styleClass="insideContainerMain iceDatTblCol">
                                                        <ice:dataTable binding="#{Recruitment$FilterCandidateForExam.tblCandidate}" id="tblCandidate"
                                                            rendered="false" sortAscending="true" style="left: 0px; top: 10px; position: absolute; width: 100%"
                                                            value="#{Recruitment$FilterCandidateForExam.candidateIdList}" var="currentRow" varStatus="rowIndex">
                                                            <ice:column id="colCandidateID">
                                                                <ice:outputText id="txtCandidateID" value="#{currentRow['canidateId']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblCandidateID" value="Candidate ID"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column5">
                                                                <ice:outputText id="outputText13" value="#{currentRow['cgpa']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblCGPA" value="CGPA"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column99">
                                                                <ice:outputText id="outputText113" value="#{currentRow['levelOfEducation']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblLevelOfEducation" value="Education Level"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column6">
                                                                <ice:outputText id="txtExperience" value="#{currentRow['experience']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblExperience" value="Experience"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colGender">
                                                                <ice:outputText id="txtgender" value="#{currentRow['gender']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblgender" value="Gender"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colAge">
                                                                <ice:outputText id="txtAge" value="#{currentRow['age']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblDateOfBirth" value="Age"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="calCandidate">
                                                                <f:facet name="header"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblApprove" value="Approve"/>
                                                                </f:facet>
                                                                <ice:selectBooleanCheckbox
                                                                    binding="#{Recruitment$FilterCandidateForExam.cboMakeCadidateCertify}"
                                                                    id="cboMakeCadidateCertify" value="#{currentRow['selected']}"/>
                                                                <ice:rowSelector binding="#{Recruitment$FilterCandidateForExam.rowSelectorCommitteeMember}"
                                                                    id="rowSelectorCommitteeMember" mouseOverClass="tableRowMouseOver"
                                                                    selectionListener="#{Recruitment$FilterCandidateForExam.rowSelectorExamMember_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                        <ice:dataTable id="dtl_candidateList" value="#{Recruitment$FilterCandidateForExam.candidateListForExam}"
                                                            var="currentRow" varStatus="rowIndex">
                                                            <ice:column id="column1">
                                                                <ice:outputText id="outputText2" value="#{currentRow['candidateID']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="txt_canId" value="Candidate ID"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column2">
                                                                <ice:outputText id="outputText5" value="#{currentRow['candidateName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="txt_can_name" value="Candidate Name"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column8">
                                                                <ice:outputText id="outputText10" value="#{currentRow['sex']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText12" value="Gender"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column3">
                                                                <ice:outputText id="outputText9"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="txt_can_educ_back" value="Education Back Ground"/>
                                                                </f:facet>
                                                                <ice:commandLink
                                                                    action="#{Recruitment$FilterCandidateForExam.cmdViewEnducationBackGround_action}"
                                                                    id="cmdViewEnducationBackGround" style="color: rgb(48, 102, 130); font-weight: bold" value="View Education"/>
                                                            </ice:column>
                                                            <ice:column id="column4">
                                                                <ice:outputText id="outputText11"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="txt_can_exp_back" value="Expirance Back Ground"/>
                                                                </f:facet>
                                                                <ice:rowSelector binding="#{Recruitment$FilterCandidateForExam.rowEducationBackGraund}"
                                                                    id="rowEducationBackGraund" mouseOverClass="tableRowMouseOver"
                                                                    selectionListener="#{Recruitment$FilterCandidateForExam.rowSelectorCandidateMember_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                                <ice:commandLink
                                                                    action="#{Recruitment$FilterCandidateForExam.cmdViewExpiranceBackGround_action}"
                                                                    id="cmdViewExpiranceBackGround" style="color: rgb(48, 102, 130); font-weight: bold" value="View Expirance"/>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 44px; margin-left: 15px; left: 10px; top: 505px; overflow: auto; position: absolute; width: 765px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Recruitment$FilterCandidateForExam.btnSave_action}"
                                                            binding="#{Recruitment$FilterCandidateForExam.btnSave}" id="btnSave" rendered="false"
                                                            style="left: 216px; top: 0px; position: absolute; width: 71px" value="Save"/>
                                                        <ice:commandButton action="#{Recruitment$FilterCandidateForExam.btnReset_action}"
                                                            binding="#{Recruitment$FilterCandidateForExam.btnReset}" id="btnReset" rendered="false"
                                                            style="left: 336px; top: 0px; position: absolute; width: 71px" value="Reset"/>
                                                        <ice:commandButton action="#{Recruitment$FilterCandidateForExam.btn_canForExam_action}"
                                                            binding="#{Recruitment$FilterCandidateForExam.btn_canForExam}" disabled="true" id="btn_canForExam"
                                                            style="height: 23px; left: 300px; top: 0px; position: absolute; width: 143px" value="Select For Exam"/>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
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
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$FilterCandidateForExam.pnDisplayCriteria}" clientOnly="true" draggable="false"
                            id="pnDisplayCriteria" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 300px; left: 400px; top: 300px; position: absolute; width: 300px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridDisplayCriteria" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 528px">
                                    <ice:outputText id="pnCriteriaDisplayCriteriaTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 400px" value="BUNNA INTERNATIONAL BANK Human Resource Management:Display Criteria"/>
                                    <ice:commandLink action="#{Recruitment$FilterCandidateForExam.modalPnlCloseDisplayCriteria_action}"
                                        id="modalPnlCloseDisplayCriteria" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 505px; top: 1px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupDisplayCriteria" style="display: block; height: 325px; position: relative; width: 483px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlDisplayCriteriaBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 295px; position: relative; width: 415px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel id="lblFormDisplayCriteria" style="background-color: #F5F5F5;"/>
                                        <ice:panelLayout id="lyExameDisplayCriteria" style="border: 1px solid rgb(204, 204, 204); height: 305px; margin-left: 10px; margin-top: 0px; left: 0px; top: 10px; position: absolute; width: 460px">
                                            <ice:outputText id="lblDisplayOnly"
                                                style="font-style: normal; font-weight: bold; left: 10px; top: 5px; position: absolute" value="Display Criteria"/>
                                            <ice:outputText id="txtPracticaleExameTaken" rendered="false"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 250px; top: 40px; position: absolute" value="Work Experiance"/>
                                            <ice:inputText binding="#{Recruitment$FilterCandidateForExam.txtAge1}" id="txtAge1" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 50px; top: 150px; position: absolute; width: 30px"/>
                                            <ice:inputText binding="#{Recruitment$FilterCandidateForExam.inputTextAgeValue}" id="inputTextAgeValue" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 90px; top: 150px; position: absolute; width: 50px"/>
                                            <ice:inputText binding="#{Recruitment$FilterCandidateForExam.txtAgeRightComp}" id="txtAgeRightComp" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 170px; top: 150px; position: absolute; width: 30px"/>
                                            <ice:inputText binding="#{Recruitment$FilterCandidateForExam.inputTextAgeValueRight}" id="inputTextAgeValueRight" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 210px; top: 150px; position: absolute; width: 50px"/>
                                            <ice:outputText id="txtAge2"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 148px; top: 148px; position: absolute" value="AND:"/>
                                            <ice:outputText id="txtAge3"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 288px; top: 148px; position: absolute; width: 93px" value="Needed Number"/>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="lyisplayCriteriaButton" layout="flow" style="border-width: 1px; border-color: rgb(204, 204, 204); border-top-style: solid; height: 80px; left: 25px; top: 40px; position: absolute; vertical-align: top; width: 440px">
                                            <ice:outputText id="lblPractical_ResultGreaterThan"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 8px; top: 120px; position: absolute; text-align: left" value="Age"/>
                                            <ice:outputText id="lblGreaterThanSign" rendered="false"
                                                style="font-size: 12px; font-style: normal; font-weight: bold; left: 95px; top: 10px; position: absolute; text-align: left" value="&gt;"/>
                                            <ice:inputText binding="#{Recruitment$FilterCandidateForExam.txtWorkExperiance}" id="txtWorkExperiance" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 118px; top: 36px; position: absolute; width: 90px"/>
                                            <ice:outputText id="lblWrittenExamResultGreaterThan"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 8px; top: 40px; position: absolute" value="Work Experiance"/>
                                            <ice:outputText id="lblGreaterWritenThanSign"
                                                style="font-size: 12px; font-style: normal; font-weight: bold; left: 95px; top: 40px; position: absolute; text-align: left" value="&gt;"/>
                                            <ice:outputText escape="false" id="lblInterviewResult"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left:8px; top: 10px; position: absolute" value="Gender"/>
                                            <ice:outputText id="lblGreaterThanSignFor"
                                                style="font-size: 12px; font-style: normal; font-weight: bold; left: 93px; top: 10px; position: absolute; text-align: left" value="="/>
                                            <ice:inputText binding="#{Recruitment$FilterCandidateForExam.txtGender}" id="txtGender" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 118px; top: 6px; position: absolute; width: 90px"/>
                                            <ice:outputText id="lblAdvertDateTo"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 8px; top: 66px; position: absolute" value="GPA"/>
                                            <ice:outputText id="lblGreaterThanSignForGpa"
                                                style="font-size: 12px; font-style: normal; font-weight: bold; left: 95px; top: 63px; position: absolute; text-align: left" value="&gt;"/>
                                            <ice:inputText binding="#{Recruitment$FilterCandidateForExam.txtGPA}" id="txtGPA"
                                                onclick="dispalyCalendar(event,'form1:txtAdvertDateTO', 'form1');" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 118px; top: 66px; position: absolute; width: 90px"/>
                                            <ice:inputText binding="#{Recruitment$FilterCandidateForExam.inputTextNeededNumber}" id="inputTextNeededNumber" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 386px; top: 118px; position: absolute; width: 50px"/>
                                            <ice:outputLabel id="outputLabel1" style="left: 240px; top: 11px; position: absolute" value="Experience Relation"/>
                                            <ice:selectOneRadio binding="#{Recruitment$FilterCandidateForExam.rdRelation}" id="rdRelation" partialSubmit="true"
                                                style="height: 23px; left: 240px; top: 48px; position: absolute; width: 144px" value="#{Recruitment$FilterCandidateForExam.selectOneRadio1Bean.selectedObject}">
                                                <f:selectItems id="selectOneRadio1selectItems" value="#{Recruitment$FilterCandidateForExam.relationTypeList}"/>
                                            </ice:selectOneRadio>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="lyisplaySort" style="border-width: 1px; border-color: rgb(204, 204, 204); border-top-style: solid; border-bottom-style: solid; height: 70px; left: 25px; top: 192px; position: absolute; vertical-align: top; width: 440px">
                                            <ice:outputText id="lblSortBY" rendered="true"
                                                style="font-style: normal; font-weight: bold; left: -5px; top: 5px; position: absolute" value="Sort By"/>
                                            <ice:outputText id="txtSortByExamResult" rendered="true"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 8px; top: 35px; position: absolute" value="By Work Experiance"/>
                                            <ice:outputText id="txtSortBy" rendered="true"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 240px; top: 35px; position: absolute" value="By GPA"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$FilterCandidateForExam.choWorkExperiance}" id="choWorkExperiance"
                                                partialSubmit="true" style="left: 128px; top: 35px; position: absolute"
                                                value="#{Recruitment$FilterCandidateForExam.defaultSelectedData4.selectedBoolean}" valueChangeListener="#{Recruitment$FilterCandidateForExam.choWorkExperiance_processValueChange}"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$FilterCandidateForExam.choByGpa}" id="choByGpa"
                                                partialSubmit="true" style="left: 350px; top: 35px; position: absolute"
                                                value="#{Recruitment$FilterCandidateForExam.defaultSelectedData3.selectedBoolean}" valueChangeListener="#{Recruitment$FilterCandidateForExam.choByGpa_processValueChange}"/>
                                        </ice:panelLayout>
                                        <ice:commandButton action="#{Recruitment$FilterCandidateForExam.btnSet_action}" id="btnSet" partialSubmit="true"
                                            style="left: 30px; top: 270px; position: absolute; width: 80px" value="Set"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$FilterCandidateForExam.pnDisplayEducationBackGround}" clientOnly="true"
                            draggable="false" id="pnDisplayEducationBackGround" modal="false" rendered="flase"
                            style="border-style: none; background-color: transparent; display: block; height: 300px; left: 200px; top: 300px; position: absolute; width: 300px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridDisplayEducationBackGround" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 528px">
                                    <ice:outputText id="pnEducstionBackGroundTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 400px" value="BUNNA INTERNATIONAL BANK Human Resource Management:Display Education"/>
                                    <ice:commandLink action="#{Recruitment$FilterCandidateForExam.modalPnlCloseEducationBackGround_action}"
                                        id="modalPnlCloseEducationBackGround" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 505px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupEducationBackGround" style="display: block; height: 325px; position: relative; width: 483px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlEducationBackGround" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 295px; position: relative; width: 415px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel id="lblFormEducationBackGround" style="background-color: #F5F5F5;"/>
                                        <ice:panelLayout id="EducationBackGround" style="border: 1px solid rgb(204, 204, 204); height: 305px; margin-left: 10px; margin-top: 0px; left: 0px; top: 10px; position: absolute; width: 460px">
                                            <ice:outputText id="lblEducationOnly"
                                                style="font-style: normal; font-weight: bold; left: 10px; top: 5px; position: absolute" value="Edcation BackGround"/>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="lyisplayEducationBackGround" layout="flow" style="border-width: 1px; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); border-top-style: solid; height: 270px; left: 25px; top: 40px; position: absolute; vertical-align: top; width: 440px; -rave-layout: grid overflow:auto">
                                            <ice:dataTable id="dtl_EducationBack" style="left: -10px; top: 14px; position: absolute"
                                                value="#{Recruitment$FilterCandidateForExam.canEducationBackGround}" var="currentRow" width="432">
                                                <ice:column groupOn="#{currentRow['candidateName']}" id="column9">
                                                    <ice:outputText id="outputText100" value="#{currentRow['candidateName']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText15" value="Candidate Name"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column10">
                                                    <ice:outputText id="outputText101" value="#{currentRow['canEducationLevel']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText17" value="Level"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column11">
                                                    <ice:outputText id="outputText102" value="#{currentRow['canEducationType']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText19" value="Graduated By"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column12">
                                                    <ice:outputText id="outputText20" value="#{currentRow['cgpa']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText21" value="CGPA"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column13">
                                                    <ice:outputText id="outputText22" value="#{currentRow['instiutation']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText23" value="Instiutation"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column14">
                                                    <ice:outputText id="outputText24" value="#{currentRow['yearOfGraduation']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText25" value="Graduation Year"/>
                                                    </f:facet>
                                                </ice:column>
                                            </ice:dataTable>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$FilterCandidateForExam.pnSelectCandidateForExam}" clientOnly="true"
                            draggable="true" id="pnSelectCandidateForExam" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 374px; left: 200px; top: 200px; position: absolute; width: 494px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridCandidateForExam" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 528px">
                                    <ice:outputText id="pnCandidateForExam"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 400px" value="BUNNA INTERNATIONAL BANK Human Resource Management:Select For Exam "/>
                                    <ice:commandLink action="#{Recruitment$FilterCandidateForExam.modalPnlCloseCandidateForExam_action}"
                                        id="modalPnlCloseCandidateForExam" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 505px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupCandiateForExam" style="display: block; height: 325px; position: relative; width: 483px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlCandidateForExamSelection" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 295px; position: relative; width: 415px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel id="lblFormCandidateForExam" style="background-color: #F5F5F5;"/>
                                        <ice:panelLayout id="SelectCandidateForExam" style="border: 1px solid rgb(204, 204, 204); height: 305px; margin-left: 10px; margin-top: 0px; left: 0px; top: 10px; position: absolute; width: 460px">
                                            <ice:outputText id="SelectCandiateOnly"
                                                style="font-style: normal; font-weight: bold; left: 10px; top: 5px; position: absolute" value="Select Candidate For Exam"/>
                                            <ice:selectInputText action="#{Recruitment$FilterCandidateForExam.txtSearchCandidate_action}"
                                                binding="#{Recruitment$FilterCandidateForExam.txtSearchCandidate}" id="txtSearchCandidate"
                                                listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true" rows="10"
                                                style="left: 110px; top: 55px; position: absolute" valueChangeListener="#{ApplicationBean1.changeList}">
                                                <f:facet name="selectInputText">
                                                    <ice:panelGrid columnClasses="fullNameCandidate,empIdCol" columns="2">
                                                        <ice:outputText id="lblFullNameAutoComplete2" value="#{employeeList.fullName}"/>
                                                        <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{employeeList.empIdentification}"/>
                                                    </ice:panelGrid>
                                                </f:facet>
                                            </ice:selectInputText>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="lyisplayCandiateFroExam" layout="flow" style="border-width: 1px; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); border-top-style: solid; height: 270px; left: 25px; top: 40px; position: absolute; vertical-align: top; width: 440px; -rave-layout: grid overflow:auto">
                                            <ice:outputText id="outputText4" style="left: 0px; top: 24px; position: absolute" value="CandidateName"/>
                                            <ice:panelLayout id="pnlSelectedDataTable" layout="flow"
                                                style="border-style: none; background-color: transparent; display: block; height: 91px; left: 0px; top: 96px; overflow: auto; position: absolute; width: 365px; -rave-layout: grid" styleClass="message">
                                                <ice:dataTable id="dataForExamCandidate" style="left: 110px; top: 14px; position: absolute"
                                                    value="#{Recruitment$FilterCandidateForExam.finalSelectedCandidate}" var="currentRow">
                                                    <ice:column id="column7">
                                                        <ice:outputText id="outputText220" value="#{currentRow['candidateName']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText230" value="FullName"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column24">
                                                        <ice:outputText id="outputText2201" value="#{currentRow['candidateID']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText43" value="ID"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column25">
                                                        <ice:outputText id="outputText2200" value="#{currentRow['batchId']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText45" value="Batch Code"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>
                                            </ice:panelLayout>
                                            <ice:outputText id="outputText7" style="left: 58px; top: 68px; position: absolute" value="FullName:-"/>
                                            <ice:outputText binding="#{Recruitment$FilterCandidateForExam.out_txt_fullName}" id="out_txt_fullName" style="color: rgb(204, 0, 0); font-family: 'Times New Roman',Times,serif; font-size: 14px; left: 120px; top: 70px; position: absolute; text-decoration: underline; width: 166px"/>
                                            <ice:commandButton action="#{Recruitment$FilterCandidateForExam.button2_action}" id="button2"
                                                style="height: 32px; left: 312px; top: 14px; position: absolute; width: 81px" value="ADD"/>
                                            <ice:outputText id="outputText42" style="font-size: 18px; left: 269px; top: 66px; position: absolute; width: 24px" value="("/>
                                            <ice:outputText binding="#{Recruitment$FilterCandidateForExam.out_txt_batchCode}" id="out_txt_batchCode" style="color: #ff0066; left: 285px; top: 72px; position: absolute; text-decoration: underline"/>
                                            <ice:outputText id="outputText44" style="font-size: 18px; left: 365px; top: 66px; position: absolute" value=")"/>
                                            <ice:commandButton action="#{Recruitment$FilterCandidateForExam.button3_action}" id="button3"
                                                style="height: 24px; left: 144px; top: 230px; position: absolute; width: 120px" value="Pass"/>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$FilterCandidateForExam.pnDisplayExpiranceBackGround}" clientOnly="true"
                            draggable="false" id="pnDisplayExpiranceBackGround" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 370px; left: 200px; top: 300px; position: absolute; width: 590px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridDisplayExpiranceBackGround" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 560px">
                                    <ice:outputText id="pnExpiranceBackGroundTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 400px" value="BUNNA INTERNATIONAL BANK Human Resource Management:Display Expirance"/>
                                    <ice:commandLink action="#{Recruitment$FilterCandidateForExam.modalPnlCloseExpiranceBackGround_action}"
                                        id="modalPnlCloseExpiranceBackGround" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 558px; top: 10px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupExpiranceBackGround" style="display: block; height: 325px; position: relative; width: 540px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlExoiranceBackGround" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 295px; position: relative; width: 470px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel id="lblFormExpiranceBackGround" style="background-color: #F5F5F5;"/>
                                        <ice:panelLayout id="ExpiranceGround" style="border: 1px solid rgb(204, 204, 204); height: 305px; margin-left: 10px; margin-top: 0px; left: 0px; top: 10px ;position: absolute; width: 520px">
                                            <ice:outputText id="lblExpiranceOnly"
                                                style="font-style: normal; font-weight: bold; left: 10px; top: 5px; position: absolute" value="Expirance BackGround"/>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="lyisplayExpiranceBackGround" layout="flow" style="border-width: 1px; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); border-top-style: solid; height: 270px; left: 0px; top: 40px; overflow: auto; position: absolute; vertical-align: top; width: 527px; -rave-layout: grid">
                                            <ice:dataTable id="dtl_expBackGround" style="left: 14px; top: 14px; position: absolute"
                                                value="#{Recruitment$FilterCandidateForExam.canExpirancebackGround}" var="currentRow">
                                                <ice:column groupOn="#{currentRow['candidateName']}" id="column15">
                                                    <ice:outputText id="outputText14" value="#{currentRow['candidateName']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText16" value="Name"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column16">
                                                    <ice:outputText id="outputText18" value="#{currentRow['orgName']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText26" value="Org Name"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column17">
                                                    <ice:outputText id="outputText27" value="#{currentRow['position']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText28" value="Position"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column18">
                                                    <ice:outputText id="outputText29" value="#{currentRow['startDate']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText30" value="StartDate"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column19">
                                                    <ice:outputText id="outputText31" value="#{currentRow['endDate']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText32" value="EndDate"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column20">
                                                    <ice:outputText id="outputText33" value="#{currentRow['expYear']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText34" value="TotYear"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column22">
                                                    <ice:outputText id="outputText37" value="#{currentRow['expMonth']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText38" value="TotMonth"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column23">
                                                    <ice:outputText id="outputText39" value="#{currentRow['expDay']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText40" value="TotDay"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column21">
                                                    <ice:outputText id="outputText35" value="#{currentRow['relation']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText36" value="Related"/>
                                                    </f:facet>
                                                </ice:column>
                                            </ice:dataTable>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$FilterCandidateForExam.pnlPopupCommitteeMembers}" id="pnlPopupCommitteeMembers"
                            modal="FALSE" rendered="false" style="height: 453px; left: 408px; top: 240px; position: absolute; width: 813px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupCommitteeMembers" style="display: block; height: 20px; text-align: left" width="772">
                                    <ice:outputText dir="left" id="otxtCommitteeMembers" style="display: block; height: 20px; text-align: right" value="BIB HRMS - CONFIRM ON DECISION"/>
                                    <ice:commandLink action="#{Recruitment$FilterCandidateForExam.btnClosePopupCommitteeMembers_action}"
                                        id="btnClosePopupCommitteeMembers" style="right: 0px; top: -20px; position: absolute" value="CLOSE"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutCommitteeMembers" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 284px; margin-left: 15px; left: 10px; top: 50px; overflow: auto; position: absolute; width: 770px">
                                    <ice:panelLayout id="pnlLayoutPopupCommitteeMembers" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 237px; margin-left: 15px; left: 0px; top: 24px; overflow: auto; position: absolute; width: 740px">
                                        <ice:panelLayout id="pnlLayoutPopupCommitteeMembersMessage2" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 40px; margin-left: 15px; left: 0px; top: 14px; overflow: auto; position: absolute; width: 693px">
                                            <ice:outputLabel id="lblSignInReminder" value="Signin using your username"/>
                                            <ice:commandLink action="#{Recruitment$FilterCandidateForExam.cmdLnkClosePopupCommitteeMembers_action}"
                                                binding="#{Recruitment$FilterCandidateForExam.cmdLnkClosePopupCommitteeMembers}"
                                                id="cmdLnkClosePopupCommitteeMembers" rendered="true" style="color: rgb(48, 102, 130)" value="CLOSE"/>
                                        </ice:panelLayout>
                                        <ice:dataTable id="dataTableCommitteeMembers" style="height: 8px; left: 14px; top: 60px; position: absolute"
                                            value="#{Recruitment$FilterCandidateForExam.committeeMembersList}" var="currentRow" width="697">
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
                                                    action="#{Recruitment$FilterCandidateForExam.btnPopupForColumnMemberLogIn_actionForFinalRecuritment}"
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
                                                    selectionListener="#{Recruitment$FilterCandidateForExam.rowSelectorCommitteeMember_processMyEvent}" toggleOnClick="true"/>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$FilterCandidateForExam.pnConfirmationMessage}" clientOnly="true"
                            draggable="false" id="pnConfirmationMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 300px; top: 400px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup binding="#{Recruitment$FilterCandidateForExam.pnlConfirmationMessage}" id="pnlConfirmationMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnConfirmationTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management:Message"/>
                                    <ice:commandLink action="#{Recruitment$FilterCandidateForExam.cmdConfirmationCloseMesssage_action}"
                                        id="cmdConfirmationCloseMesssage" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 690px; top: 3px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Recruitment$FilterCandidateForExam.panelConfirmationGroupMessage}" id="panelConfirmationGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Recruitment$FilterCandidateForExam.pnlConfirmationMessageBody}" id="pnlConfirmationMessageBody"
                                        layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Recruitment$FilterCandidateForExam.lblFormMessage4}" id="lblFormMessage4" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
    <ice:commandButton id="button1" value="submit"/>
</jsp:root>
