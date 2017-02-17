<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 28, 2011, 2:48:31 AM
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
                <ice:outputStyle href="../resources/ETH/KAMSI_CAL_STYLE.css" id="outputStyle22"/>
                <script src="../resources/ETH/KAMSI_CAL_SCRIPT.js"></script>
                <style type="text/css">
                    .message {
                        display: none;
                        margin: 0 0 13px 0;
                        background-color:#EFA;
                        padding: 13px 13px 13px 52px;
                        background-position: 13px 5px;
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
                        background-color:#EFA;
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
                    function MaintainAdvertisemen(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;
                    }
                </script>
              <!--  <link HREF="../FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" onload="showCal()" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder height="480" id="whole_page" renderCenter="#{Recruitment$MaintainAdvertisement.panelBorder1Bean.renderCenter}"
                            renderEast="#{Recruitment$MaintainAdvertisement.panelBorder1Bean.renderEast}"
                            renderNorth="#{Recruitment$MaintainAdvertisement.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Recruitment$MaintainAdvertisement.panelBorder1Bean.renderSouth}"
                            renderWest="#{Recruitment$MaintainAdvertisement.panelBorder1Bean.renderWest}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup dragListener="#{Recruitment$MaintainAdvertisement.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
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
                                        style="height: 312px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 136px; left: 5px;margin-top:14px; position: absolute; width: 213px" styleClass="list_menu">
                                            <ice:panelCollapsible binding="#{Page1.panelCollapsible2}" expanded="true" id="panelCollapsible2" toggleOnClick="true">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup2">
                                                        <ice:outputText id="outputText2" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid1">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$MaintainAdvertisement.cmdRecruitment_action}"
                                                                id="cmdRecruitment" immediate="true" partialSubmit="true" style="color:#306682;font-weight:bold" value="Recruitment Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$MaintainAdvertisement.cmdrecApproval_action}"
                                                                id="cmdrecApproval" immediate="true" partialSubmit="true" style="color:#306682;font-weight:bold" value="Request Approved List"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$MaintainAdvertisement.cmdfilterCandidate_action}"
                                                                id="cmdfilterCandidate" immediate="true" partialSubmit="true"
                                                                style="color:#306682;font-weight:bold" value="Filter Candidates"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$MaintainAdvertisement.lnkRetireApprove_action}"
                                                                id="lnkRetireApprove" immediate="true" partialSubmit="true"
                                                                style="color:#306682;font-weight:bold" value="Recruitment Approve"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$MaintainAdvertisement.lnkRegisterCandidate_action}"
                                                                id="lnkRegisterCandidate" immediate="true" partialSubmit="true"
                                                                style="color:#306682;font-weight:bold" value="Register Candidate"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible1">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass="">
                                                        <ice:outputText id="outputText1" value="New Recruitment "/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid2">
                                                    <ice:selectOneMenu binding="#{Recruitment$MaintainAdvertisement.drlNewRecruitmentApproval}"
                                                        id="drlNewRecruitmentApproval" partialSubmit="true"
                                                        value="#{Recruitment$MaintainAdvertisement.defaultSelectedData6.selectedObject}" valueChangeListener="#{Recruitment$MaintainAdvertisement.drlNewRecruitmentApproval_processValueChange}">
                                                        <f:selectItems id="selectOneMenu1selectItems1" value="#{Recruitment$MaintainAdvertisement.recruitmentBatchCodeSearchOpt}"/>
                                                    </ice:selectOneMenu>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible3">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup3" styleClass="">
                                                        <ice:outputText id="outputText6" value="Previous Advertisement"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid3" style="height: 300px; width: 100%">
                                                    <ice:panelLayout id="StatusContainer" style="border-style: none; background-color: transparent; height: 78px; position: absolute; width: 100%">
                                                        <!--  <ice:selectOneMenu id="drlPreviousVacancy" partialSubmit="true"
                                                                           style="left: 0px; top: 5px; position: relative"
                                                                           value="#{Recruitment$MaintainAdvertisement.defaultSelectedData7.selectedObject}" valueChangeListener="#{Recruitment$MaintainAdvertisement.drlPreviousVacancy_processValueChange}">

                                                            <f:selectItems id="selectOneMenu1selectItems2" value="#{Recruitment$MaintainAdvertisement.previousRecruitmentAdvertise}"/>
                                                        </ice:selectOneMenu>   -->
                                                        <ice:selectOneListbox binding="#{Recruitment$MaintainAdvertisement.listPreviousAdvertisement}"
                                                            id="listPreviousAdvertisement" partialSubmit="true" size="2"
                                                            style="border: 1px solid rgb(115, 179, 206); height: 223px; left: 5px; top: -140px; position: absolute; width: 182px"
                                                            value="#{Recruitment$MaintainAdvertisement.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Recruitment$MaintainAdvertisement.listPreviousAdvertisement_processValueChange}">
                                                            <f:selectItems id="selectOneListbox1selectItems" value="#{Recruitment$MaintainAdvertisement.previousRecruitmentAdvertise}"/>
                                                        </ice:selectOneListbox>
                                                        <ice:commandButton id="btnPrevious" rendered="false"
                                                            style="left: 20px; top: 91px; position: absolute; width: 50px" value="&lt;"/>
                                                        <ice:commandButton id="btnNext" rendered="false"
                                                            style="left: 112px; top: 90px; position: absolute; width: 50px" value="&gt;"/>
                                                    </ice:panelLayout>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 713px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 750px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height:682px;">
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$MaintainAdvertisement.choOutside}" disabled="true" id="choOutside"
                                                partialSubmit="true" style="left: 647px; top: 45px; position: absolute; z-index: 10"
                                                value="#{Recruitment$MaintainAdvertisement.defaultSelectedData9.selectedBoolean}" valueChangeListener="#{Recruitment$MaintainAdvertisement.choOutside_processValueChange}"/>
                                            <ice:selectBooleanCheckbox binding="#{Recruitment$MaintainAdvertisement.choInside}" disabled="true" id="choInside"
                                                partialSubmit="true" style="left: 542px; top: 45px; position: absolute; z-index: 10"
                                                value="#{Recruitment$MaintainAdvertisement.selectBooleanCheckbox2Bean.selectedBoolean}" valueChangeListener="#{Recruitment$MaintainAdvertisement.choInside_processValueChange}"/>
                                            <ice:outputText id="lblInside" style="left: 504px; top: 43px; position: absolute" value="Inside"/>
                                            <ice:outputText id="lblOutside" style="left: 600px; top: 42px; position: absolute" value="Outside"/>
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Advertisment"/>
                                            </legend>
                                            <ice:panelLayout id="pnRequestList" style="height: 664px; left: 0px; top: -20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 622px" styleClass="filedset_normal"/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="pnlAdvertismnetBY" style="border: 1px solid rgb(204, 204, 204); height: 125px; margin-left: 2px; left: 22px; top: 250px; position: absolute; width: 745px; -rave-layout: grid">
                                                <ice:outputText escape="false" id="lblPreparedBy"
                                                    style="font-size: 10px; left: 19px; top: 20px; position: absolute" value="Prepared By"/>
                                                <ice:outputText id="lblAdvertisementDate" style="font-size: 10px; left: 19px; top: 54px; position: absolute" value=" Advert. Date From"/>
                                                <ice:inputText binding="#{Recruitment$MaintainAdvertisement.txtPreparedBy}" id="txtPreparedBy" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 138px; top: 14px; position: absolute; width: 190px"/>
                                                <ice:inputText binding="#{Recruitment$MaintainAdvertisement.txtAdvertDate_From}" id="txtAdvertDate_From"
                                                    required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 50px; position: absolute; width: 190px"/>
                                                <ice:outputText escape="false" id="lblPreparationDate"
                                                    style="font-size: 10px; left: 396px; top: 20px; position: absolute" value="Prepared Date "/>
                                                <ice:inputText binding="#{Recruitment$MaintainAdvertisement.txtPreparedDate}" id="txtPreparedDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 14px; position: absolute; width: 190px"/>
                                                <ice:outputText id="lblAdvertDateTo" style="font-size: 10px; left: 396px; top: 54px; position: absolute" value="Advert. Date To"/>
                                                <ice:inputText binding="#{Recruitment$MaintainAdvertisement.txtAdvertDateTO}" id="txtAdvertDateTO"
                                                    required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 50px; position: absolute; width: 190px"/>
                                                <ice:commandButton action="#{Recruitment$MaintainAdvertisement.btnCalender_action}"
                                                    binding="#{Recruitment$MaintainAdvertisement.btnCalender}" disabled="true" id="btnCalender"
                                                    image="/resources/images/cal_icon.JPG" immediate="true" style="left: 311px; top: 53px; position: absolute" value="submit"/>
                                                <ice:commandButton action="#{Recruitment$MaintainAdvertisement.btnCalenderTO_action}"
                                                    binding="#{Recruitment$MaintainAdvertisement.btnCalenderTO}" disabled="true" id="btnCalenderTO"
                                                    image="/resources/images/cal_icon.JPG" immediate="true" style="left: 672px; top: 53px; position: absolute" value="submit"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtAdvertDate_From" id="message1"
                                                    infoClass="infoMessage" style="font-size: 10px; left: 215px; top: 85px; position: absolute" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtAdvertDateTO" id="message2"
                                                    infoClass="infoMessage" style="font-size: 10px; left: 576px; top: 85px; position: absolute" warnClass="warnMessage"/>
                                                <ice:selectBooleanCheckbox binding="#{Recruitment$MaintainAdvertisement.choMediInformation}" disabled="true"
                                                    id="choMediInformation" partialSubmit="true" style="left: 190px; top: 88px; position: absolute" value="#{Recruitment$MaintainAdvertisement.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                <ice:outputText id="outputText11" style="font-size: 10px; left: 19px; top: 88px; position: absolute" value="To modify start and end date click here "/>
                                                <ice:selectInputDate action="#{Recruitment$RecruitmentRequest.calFromDate_processValueChange}"
                                                    binding="#{Recruitment$MaintainAdvertisement.calFromDate}" id="calFromDate" rendered="false"
                                                    style="height: 212px; left: 350px; top: 0px; position: absolute; width: 190px; z-index: 99"
                                                    value="#{Recruitment$MaintainAdvertisement.selectInputDate1Bean.date1}" valueChangeListener="#{Recruitment$MaintainAdvertisement.calFromDate_processValueChange}"/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="pnllistOfAdvertismane"
                                                style="border: 1px solid rgb(204, 204, 204); height: 173px; margin-left: 2px; left: 22px; overflow: auto;  top: 65px; position: absolute; width: 745px; -rave-layout: grid" styleClass="insideContainerMain">
                                                <ice:dataTable binding="#{Recruitment$MaintainAdvertisement.tblRequritmentList}" id="tblRequritmentList"
                                                    style="left:0px; top:-10px; position: absolute; width: 100%;"
                                                    value="#{Recruitment$MaintainAdvertisement.listOfJobType}" var="currentRow">
                                                    <ice:column id="column4">
                                                        <ice:outputText id="outputText3" value="#{currentRow['numberofrequest']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText5" value="No"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column5">
                                                        <ice:outputText id="outputText12" value="#{currentRow['job_description']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText13" value="Job Type"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column6">
                                                        <ice:outputText id="outputText14" value="#{currentRow['recruitment_Type']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText15" value="Recruitment Type"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column7">
                                                        <ice:outputText id="outputText141" value="#{currentRow['num_Of_Emps']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText151" value="Number Of Employee"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colSelectedJob">
                                                        <ice:selectBooleanCheckbox binding="#{Recruitment$MaintainAdvertisement.choJobToAdvertise}"
                                                            id="choJobToAdvertise" partialSubmit="true"
                                                            style="text-align: center;border: 1px solid rgb(115, 179, 206);  " value="#{currentRow['jobAdvertisment']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="lblSelectJobToAdvertisement" value="Select Job To Advertise"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="colSelectInside">
                                                        <ice:commandLink action="#{Recruitment$MaintainAdvertisement.cmdPreview_action}"
                                                            binding="#{Recruitment$MaintainAdvertisement.cmdPreview}" id="cmdPreview" immediate="true"
                                                            partialSubmit="true" value="Preview"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="lblInside" value="Preview"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="pnlAdvertismnetList" style="border: 1px solid rgb(204, 204, 204); height: 209px; margin-left: 2px; left: 22px; top: 390px; position: absolute; width: 745px; -rave-layout: grid">
                                                <ice:selectOneMenu binding="#{Recruitment$MaintainAdvertisement.drlOccurrence}" id="drlOccurrence"
                                                    partialSubmit="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 14px; position: absolute; width: 190px" value="#{Recruitment$MaintainAdvertisement.defaultSelectedData4.selectedObject}">
                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{Recruitment$MaintainAdvertisement.number}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectOneMenu binding="#{Recruitment$MaintainAdvertisement.drlMediType}" id="drlMediType"
                                                    partialSubmit="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 138px; top: 14px; position: absolute; width: 190px" value="#{Recruitment$MaintainAdvertisement.defaultSelectedData5.selectedObject}">
                                                    <f:selectItems id="selectOneMenu2selectItems" value="#{Recruitment$MaintainAdvertisement.mediType}"/>
                                                </ice:selectOneMenu>
                                                <ice:outputText id="lblMediaType" style="font-size: 10px; left: 19px; top: 20px; position: absolute" value="Medi Type"/>
                                                <ice:outputText id="lblOccurrence" style="font-size: 10px; left: 396px; top: 20px; position: absolute" value="Occurrence"/>
                                                <ice:outputText binding="#{Recruitment$MaintainAdvertisement.lblErrorMessageForMediaType}"
                                                    id="lblErrorMessageForMediaType" rendered="false"
                                                    style="color: red; font-size: 10px; font-weight: bolder; left: 200px; top: 40px; position: absolute" value="outputText"/>
                                                <ice:outputText binding="#{Recruitment$MaintainAdvertisement.lblErrorMessageForOccurrence}"
                                                    id="lblErrorMessageForOccurrence" rendered="false"
                                                    style="color: red; font-size: 10px; font-weight: bolder; left: 550px; top: 40px; position: absolute" value="outputText"/>
                                                <ice:commandButton action="#{Recruitment$MaintainAdvertisement.btnAdd_action}"
                                                    binding="#{Recruitment$MaintainAdvertisement.btnAdd}" id="btnAdd"
                                                    style="left: 25px; top: 54px; position: absolute; width: 118px" value="Add To Table"/>
                                                <ice:panelLayout id="pnlAdvertismnetTable" layout="flow" style="border: 1px solid rgb(204, 204, 204); height: 100px; margin-left: 2px; left: 10px; top: 100px; overflow: auto; position: absolute; width: 720px; -rave-layout: grid">
                                                    <ice:dataTable id="tblMediaInformation" style="left:0px; top:-10px; position: absolute; width: 100%;"
                                                        value="#{Recruitment$MaintainAdvertisement.mediaTypeList}" var="currentRow">
                                                        <ice:column id="column1">
                                                            <ice:outputText id="outputText4" value="#{currentRow['mediaTypeDesc']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8" value="Media Type"/>
                                                            </f:facet>
                                                            <ice:rowSelector id="rowSelectorEmployeeMediInformation" multiple="false" preStyleOnSelection="true"
                                                                selectionListener="#{Recruitment$MaintainAdvertisement.rowSelectorEmployeeMediInformation_processMyEvent}"
                                                                toggleOnClick="true" value="#{currentRow['selectedMedi']}"/>
                                                        </ice:column>
                                                        <ice:column id="column2">
                                                            <ice:outputText id="outputText9" value="#{currentRow['occuranceDesc']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText10" value="Occurrence"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column3">
                                                            <ice:outputText id="outputText7" value="#{currentRow['mediaName']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText16" value="Medi Name"/>
                                                            </f:facet>
                                                            <f:facet name="footer">
                                                                <ice:outputText id="outputText17" value=""/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:outputText id="lblMediName" style="font-size: 10px; left: 396px; top: 60px; position: absolute" value="Medi Name"/>
                                                <ice:inputText binding="#{Recruitment$MaintainAdvertisement.txtMediName}" id="txtMediName" style="left: 500px; top: 60px; position: absolute; width: 193px; z-index: 99"/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="pnlAdvertismnetButton" style="border: 1px solid rgb(204, 204, 204); height: 45px; margin-left: 2px; left: 22px; top: 610px; position: absolute; width: 745px; -rave-layout: grid">
                                                <ice:commandButton action="#{Recruitment$MaintainAdvertisement.btnNew_action}"
                                                    binding="#{Recruitment$MaintainAdvertisement.btnNew}" id="btnNew" immediate="true" partialSubmit="true"
                                                    style="margin-left: 40px; width: 80px" value="#{msgs.cmdNew}"/>
                                                <ice:commandButton action="#{Recruitment$MaintainAdvertisement.btnSave_action}"
                                                    binding="#{Recruitment$MaintainAdvertisement.btnSave}" id="btnSave" style="margin-left: 40px; width: 80px" value="#{msgs.cmdSave}"/>
                                                <ice:commandButton action="#{Recruitment$MaintainAdvertisement.btnEdit_action}"
                                                    binding="#{Recruitment$MaintainAdvertisement.btnEdit}" id="btnEdit" style="margin-left: 40px; width: 80px" value=" #{msgs.cmdEdit}"/>
                                                <ice:commandButton action="#{Recruitment$MaintainAdvertisement.btnUpdate_action}"
                                                    binding="#{Recruitment$MaintainAdvertisement.btnUpdate}" id="btnUpdate"
                                                    style="margin-left: 40px; width: 80px" value="#{msgs.cmdUpdate}"/>
                                                <ice:commandButton action="#{Recruitment$MaintainAdvertisement.btnRest_action}"
                                                    binding="#{Recruitment$MaintainAdvertisement.btnRest}" id="btnRest" immediate="true" partialSubmit="true"
                                                    style="margin-left: 40px; width: 80px" value=" #{msgs.cmdReset}"/>
                                                <ice:commandButton action="#{Recruitment$MaintainAdvertisement.btnDelete_action}"
                                                    binding="#{Recruitment$MaintainAdvertisement.btnDelete}" disabled="true" id="btnDelete"
                                                    style="margin-left: 40px; width: 80px" value=" #{msgs.cmdDelete}"/>
                                            </ice:panelLayout>
                                        </fieldset>
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
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$MaintainAdvertisement.popupRequestDetail}" draggable="false"
                            id="popupRequestDetail" modal="true" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px;  width: 720px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 751px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Request Detail "/>
                                    <ice:commandLink action="#{Recruitment$MaintainAdvertisement.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="border: 1px solid rgb(48, 102, 130); background-image: url(../resources/close_icon.gif); height: 19px; left: 728px; top: 2px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 300px; position: relative; width: 700px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlRequestBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 270px; position: relative; width: 626px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                        <ice:panelLayout id="pnlRequestList" style="border-bottom: solid rgb(204, 204, 204) 1px; height: 163px; margin-left: 2px; left: 0px; top: 0px; position: absolute; width: 685px; -rave-layout: grid">
                                            <ice:outputText id="lblBachCode" style=" font-size: 10px; left: 19px; top: 54px; position: absolute" value="Batch Code"/>
                                            <ice:outputText id="lblJobType" style="font-size: 10px; left: 19px; top: 88px; position: absolute" value="Requested By"/>
                                            <ice:outputText id="lblDeparment" style="font-size: 10px; left: 19px; top: 20px; position: absolute" value="Deparment"/>
                                            <ice:outputText id="lblRequestedBy" style="font-size: 10px; left: 19px; top: 122px; position: absolute" value="Requested Date"/>
                                            <ice:inputText binding="#{Recruitment$MaintainAdvertisement.txtBachCode}" disabled="true" id="txtBachCode" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 50px; position: absolute; width: 190px"/>
                                            <ice:inputText binding="#{Recruitment$MaintainAdvertisement.txtRequestedBy1}" disabled="true" id="txtRequestedBy1" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 86px; position: absolute; width: 190px"/>
                                            <ice:inputText binding="#{Recruitment$MaintainAdvertisement.txtBachCode1}" disabled="true" id="txtBachCode1" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 138px; top: 50px; position: absolute; width: 190px"/>
                                            <ice:inputText binding="#{Recruitment$MaintainAdvertisement.txtRequestedDate}" disabled="true" id="txtRequestedDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 122px; position: absolute; width: 190px"/>
                                            <ice:outputText id="lblRecruitmentType" style="font-size: 10px; left: 380px; top: 54px; position: absolute" value="Approved By"/>
                                            <ice:inputText binding="#{Recruitment$MaintainAdvertisement.txtApprovedBy}" disabled="true" id="txtApprovedBy" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 484px; top: 50px; position: absolute; width: 190px"/>
                                            <ice:outputText id="lblNumberOfEmployee" style="font-size: 10px; left: 380px; top: 88px; position: absolute" value="Approved Date"/>
                                            <ice:inputText binding="#{Recruitment$MaintainAdvertisement.txtApprovedDate}" disabled="true" id="txtApprovedDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 484px; top: 86px; position: absolute; width: 190px"/>
                                            <ice:outputText binding="#{Recruitment$MaintainAdvertisement.lblReqesterDepartemnt}" id="lblReqesterDepartemnt"
                                                style="border-bottom: solid #003333 1px; font-size: 12px; left: 138px; top: 14px; position: absolute" value="outputText"/>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="pnlRequestDetailList" style=" height: 163px; margin-left: 2px; left: 0px; top: 160px; position: absolute; width: 685px; -rave-layout: grid">
                                            <ice:outputText id="lblJobTypeDes" style="font-size: 10px; left: 19px; top: 20px; position: absolute" value="Job Type"/>
                                            <ice:inputText binding="#{Recruitment$MaintainAdvertisement.txtJobTypeDes}" disabled="true" id="txtJobTypeDes" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 138px; top: 14px; position: absolute; width: 190px&#xa;&#xa;"/>
                                            <ice:outputText id="lblNumberOfEmployeeDes" style="font-size: 10px; left: 19px; top: 54px; position: absolute" value="Number Of Employee"/>
                                            <ice:inputText binding="#{Recruitment$MaintainAdvertisement.txtNumberOfEmployeeDes}" disabled="true"
                                                id="txtNumberOfEmployeeDes" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 138px; top: 50px; position: absolute; width: 190px"/>
                                            <ice:outputText id="lblRecruitmentTypeDes" style="font-size: 10px; left: 380px; top: 20px; position: absolute" value="Recruitment Type"/>
                                            <ice:inputText binding="#{Recruitment$MaintainAdvertisement.txtRecruitmentTypeDes}" disabled="true"
                                                id="txtRecruitmentTypeDes" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 484px; top: 14px; position: absolute; width: 190px"/>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$MaintainAdvertisement.pnConfirmationMessage}" clientOnly="true"
                            draggable="false" id="pnConfirmationMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlConfirmationMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnConfirmationTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Recruitment$MaintainAdvertisement.cmdConfirmationCloseMesssage_action}"
                                        id="cmdConfirmationCloseMesssage" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 690px; top: 3px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelConfirmationGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Recruitment$MaintainAdvertisement.pnlConfirmationMessageBody}" id="pnlConfirmationMessageBody"
                                        layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Recruitment$MaintainAdvertisement.lblFormMessage4}" id="lblFormMessage4" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$MaintainAdvertisement.pnRequestConfirmationDleteMessage}" clientOnly="true"
                            draggable="false" id="pnRequestConfirmationDleteMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 130px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlConfirmationDleteMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnConfirmationDleteTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Recruitment$MaintainAdvertisement.cmdConfirmationDleteCloseMesssage_action}"
                                        id="cmdConfirmationDleteCloseMesssage" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 690px; top: 3px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelConfirmationDleteGroupMessage" style="display: block; height: 70px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Recruitment$MaintainAdvertisement.pnlConfirmationDleteMessageBody}"
                                        id="pnlConfirmationDleteMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 40px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Recruitment$MaintainAdvertisement.lblFormMessage45}" id="lblFormMessage45" style=" font-size: 14px; font-weight: bold; color: red; vertical-align: middle;position: absolute; margin-left: -300px;"/>
                                        <ice:commandButton action="#{Recruitment$MaintainAdvertisement.btnYesDelete_action}" id="btnYesDelete"
                                            style="left: 432px; top: 24px; position: absolute; width: 50px" value="Yes"/>
                                        <ice:commandButton action="#{Recruitment$MaintainAdvertisement.btnNoDelete_action}" id="btnNoDelete"
                                            style="left: 528px; top: 24px; position: absolute; width: 50px" value="No"/>
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