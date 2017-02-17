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
            function EmployeePromote(field){

                if (field.defaultValue == field.value) field.value = '';
                else if (field.value == '') field.value = field.defaultValue;

            }
        </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div style="width:100%">
                        <img alt="" class="source-image" height="auto" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder height="480" id="whole_page" renderCenter="#{Page1.panelBorder1Bean.renderCenter}"
                            renderEast="#{Page1.panelBorder1Bean.renderEast}" renderNorth="#{Page1.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Page1.panelBorder1Bean.renderSouth}" renderWest="#{Page1.panelBorder1Bean.renderWest}"
                            style="top: 5px; position: relative" styleClass="whole_page" width="1024">
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
                                        style="height: 580px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 580px; left: 5px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible4">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup3" styleClass="">
                                                        <ice:outputText id="outputText1" value="header Value"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid1" width="100%">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{EmployeeHistory$PromoteEmployee.cmdPromotionRequest_action}"
                                                                id="cmdPromotionRequest" style="color:#306682;font-weight:bold" value="Promotion Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{EmployeeHistory$PromoteEmployee.cmdrecPromotionApproval_action}"
                                                                id="cmdrecPromotionApproval" style="color:#306682;font-weight:bold" value="Approve Promotion Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{EmployeeHistory$PromoteEmployee.cmdrecPromoteEmployee_action}"
                                                                id="cmdrecPromoteEmployee" style="color:#306682;font-weight:bold" value="Promote Employees"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible5">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup4" styleClass="">
                                                        <ice:outputText id="lblSearch" value="Promotion Requestes"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid2">
                                                    <ice:outputText id="lblSelectDate" style=" color:#ba7109 " value="Select Date"/>
                                                    <ice:selectOneListbox binding="#{EmployeeHistory$ApproveRequestPromotion.selectOneListbox1Date}"
                                                        id="selectOneListbox1Date" partialSubmit="true" size="2"
                                                        style="height:100px; border: 1px solid #73b3ce;"
                                                        value="#{EmployeeHistory$ApproveRequestPromotion.defaultSelectedData1.selectedObject}" valueChangeListener="#{EmployeeHistory$ApproveRequestPromotion.selectOneListbox1Date_processValueChange}">
                                                        <f:selectItems id="selectOneListbox1selectItems" value="#{EmployeeHistory$ApproveRequestPromotion.newPromotionRequestsDates}"/>
                                                    </ice:selectOneListbox>
                                                    <ice:panelTabSet id="panelTabSet1" style="width:100%" tabPlacement="Top">
                                                        <ice:panelTab id="tabinbox" label="In Box">
                                                            <ice:panelLayout id="panelLayout2" style="position: inherit; width: 100%; height: 100%;">
                                                                <ice:commandButton action="#{EmployeeHistory$ApproveRequestPromotion.buttonViewAll_action}"
                                                                    id="buttonViewAll" value="View All"/>
                                                                <ice:selectOneListbox
                                                                    binding="#{EmployeeHistory$ApproveRequestPromotion.selectOneListboxPromotionRequestes}"
                                                                    id="selectOneListboxPromotionRequestes" partialSubmit="true" size="2"
                                                                    style="border: 1px solid rgb(115, 179, 206); height: 180px; width: 80px"
                                                                    value="#{EmployeeHistory$ApproveRequestPromotion.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$ApproveRequestPromotion.selectOneListboxPromotionRequestes_processValueChange}">
                                                                    <f:selectItems id="selectOneListbox1selectItemsPromotionRequestes" value="#{EmployeeHistory$ApproveRequestPromotion.newPromotionRequestApprove}"/>
                                                                </ice:selectOneListbox>
                                                            </ice:panelLayout>
                                                        </ice:panelTab>
                                                        <ice:panelTab id="tabSearch" label="Response ">
                                                            <ice:panelLayout id="panelLayoutResponseG" style="position: inherit; width: 100%; height: 100%;">
                                                                <ice:commandButton action="#{EmployeeHistory$ApproveRequestPromotion.buttonViewAllR_action}"
                                                                    binding="#{EmployeeHistory$ApproveRequestPromotion.buttonViewAllR}" id="buttonViewAllR" value="View All"/>
                                                                <ice:selectOneListbox binding="#{EmployeeHistory$ApproveRequestPromotion.selectOneListbox1}"
                                                                    id="selectOneListbox1" partialSubmit="true" size="2"
                                                                    style="height:180px; border: 1px solid #73b3ce;"
                                                                    value="#{EmployeeHistory$ApproveRequestPromotion.defaultSelectedData3.selectedObject}" valueChangeListener="#{EmployeeHistory$ApproveRequestPromotion.selectOneListbox1_processValueChange}">
                                                                    <f:selectItems id="selectOneListbox1selectItems1" value="#{EmployeeHistory$ApproveRequestPromotion.newPromotionResponsedApprove}"/>
                                                                </ice:selectOneListbox>
                                                            </ice:panelLayout>
                                                        </ice:panelTab>
                                                    </ice:panelTabSet>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 660px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 580px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 635px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Approve Promotion Requestes"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" layout="flow" style="height: 630px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelLayout id="PanelLayOutInsidVacancyList"
                                                    style="height: 200px; margin-left: 8px; margin-top: -5px; top: 40px; overflow: auto; position: absolute; width: 765px" styleClass="insideContainerMain">
                                                    <ice:dataTable id="tblAdvertisment" rules="all"
                                                        style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                        value="#{EmployeeHistory$ApproveRequestPromotion.vacancyList}" var="currentRow" width="727">
                                                        <ice:column groupOn="#{currentRow['jobType']}" id="colJob">
                                                            <ice:outputText id="txtJob" value="#{currentRow['jobType']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblJob" styleClass="insideInputTableHeader" value="Job Type"/>
                                                            </f:facet>
                                                            <ice:rowSelector binding="#{EmployeeHistory$ApproveRequestPromotion.rowSelectorVacancyNoticeList}"
                                                                id="rowSelectorVacancyNoticeList" multiple="false" preStyleOnSelection="true" rendered="false"
                                                                toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['requiredNo']}" id="colRequiredNo">
                                                            <ice:outputText id="txtJobRequiredNo" value="#{currentRow['requiredNo']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblJobRequiredNo" styleClass="insideInputTableHeader" value="Required Number"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['qualification']}" id="column1Qualification">
                                                            <ice:outputText id="outputText7Qualification" value="#{currentRow['qualification']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8Qualification" styleClass="insideInputTableHeader" value="Qualification"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['educLevel']}" id="column1EducLevel">
                                                            <ice:outputText id="outputText7EducLevel" value="#{currentRow['educLevel']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8EducLevel" styleClass="insideInputTableHeader" value="Educ Level"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['experience']}" id="column1Experience">
                                                            <ice:outputText id="outputText7Experience" value="#{currentRow['experience']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8Experience" styleClass="insideInputTableHeader" value="Experience"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['advertisementDateFrom']}" id="column1">
                                                            <ice:outputText id="outputText7" value="#{currentRow['advertisementDateFrom']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8" styleClass="insideInputTableHeader" value="Advertisement Date From"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['advertisementDateTo']}" id="column2">
                                                            <ice:outputText id="outputText9" value="#{currentRow['advertisementDateTo']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText10" styleClass="insideInputTableHeader" value="Advetisement Date To"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['recruitmentBatchCode']}" id="column3">
                                                            <ice:outputText id="outputText11" value="#{currentRow['recruitmentBatchCode']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText12" styleClass="insideInputTableHeader" value="Recruitment Request Code"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column3RequestID" rendered="false">
                                                            <ice:outputText id="outputText11RequestID" value="#{currentRow['recRequestID']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText12RequestID" value="Request ID"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column3AdvertID" rendered="false">
                                                            <ice:outputText id="outputText11AdvertID" value="#{currentRow['advertID']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText12AdvertID" value="Advert ID"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column3JobCode" rendered="false">
                                                            <ice:outputText id="outputText11JobCode" value="#{currentRow['jobCode']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText12JobCode" value="JOB CODE"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:panelPopup autoCentre="true"
                                                    binding="#{EmployeeHistory$ApproveRequestPromotion.pnlPopupAllCommittedOffences}" clientOnly="true"
                                                    draggable="true" id="pnlPopupAllCommittedOffences" modal="true" rendered="false"
                                                    style="border-style: none; background-color: transparent; display: block; height: 300px; position: absolute; width: 838px" styleClass="message">
                                                    <f:facet name="header">
                                                        <ice:panelGroup id="pnlGridAllCommittedOffences" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 840px">
                                                            <ice:outputText id="pnMessageTitleAllCommittedOffences"
                                                                style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 780px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                                            <ice:commandButton
                                                                action="#{EmployeeHistory$ApproveRequestPromotion.btnClosePopupAllCommittedOffences_action}"
                                                                id="btnClosePopupAllCommittedOffences" style="top: 5px; left :860px ;   position: absolute" value="x"/>
                                                        </ice:panelGroup>
                                                    </f:facet>
                                                    <f:facet name="body">
                                                        <ice:panelGroup id="panelGroupMessageAllCommittedOffences"
                                                            style="display: block; height: 250px; position: relative; width: 800px" styleClass="icePnlGrp iceDatTblColHdr">
                                                            <ice:panelLayout id="pnlMessageBodyAllCommittedOffences" layout="flow"
                                                                style="background-color: rgb(245, 245, 245); display: block; height: 222px; position: relative; width: 734px; -rave-layout: grid" styleClass="message">
                                                                <ice:dataTable id="dataTableAllCommittedOffencesOfEmployee"
                                                                    style="left: 20px; top: 0px; height:8px; width:750px; position: absolute"
                                                                    value="#{EmployeeHistory$ApproveRequestPromotion.allCommittedOffencesOfEmployee}" var="currentRow">
                                                                    <ice:column id="colNumber">
                                                                        <ice:outputText id="optTxtForColumnNum" value="#{currentRow['disciplineProblemId']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextNum" value="NO"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column groupOn="#{currentRow['requesterId']}" id="colCommitteeName">
                                                                        <ice:outputText id="optTxtForColumnRequesteName" value="#{currentRow['requesterId']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextRequesteName" value="Requester"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colRepitition">
                                                                        <ice:outputText id="optTxtForColumnOffenceDate" value="#{currentRow['dateOfOffence']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextOffenceDate" value="OffenceDate"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colDecider">
                                                                        <ice:outputText id="optTxtForColumnOffenceType" value="#{currentRow['offenceType']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextOffenceType" value="OffenceType"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colPenality">
                                                                        <ice:outputText id="optTxtForColumnDescription" value="#{currentRow['descriptionOfOffence']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextDescription" value="Description"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                        </ice:panelGroup>
                                                    </f:facet>
                                                </ice:panelPopup>
                                                <ice:panelPopup autoCentre="true"
                                                    binding="#{EmployeeHistory$ApproveRequestPromotion.pnlPopupAllPerformanceValue}" clientOnly="true"
                                                    draggable="true" id="pnlPopupAllPerformanceValue" modal="true" rendered="false"
                                                    style="border-style: none; background-color: transparent; display: block; height: 300px; position: absolute; width: 838px" styleClass="message">
                                                    <f:facet name="header">
                                                        <ice:panelGroup id="pnlGridAllCommittedPerformance" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 840px">
                                                            <ice:outputText id="pnMessageTitleAllPerformance"
                                                                style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 780px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                                            <ice:commandButton
                                                                action="#{EmployeeHistory$ApproveRequestPromotion.btnClosePopupAllPerformanceClosed_action}"
                                                                id="btnClosePopupAllPerformanceClosed" style="top: 5px; left :860px ;   position: absolute" value="x"/>
                                                        </ice:panelGroup>
                                                    </f:facet>
                                                    <f:facet name="body">
                                                        <ice:panelGroup id="panelGroupMessageAllPerformance"
                                                            style="display: block; height: 250px; position: relative; width: 800px" styleClass="icePnlGrp iceDatTblColHdr">
                                                            <ice:panelLayout id="pnlMessageBodyAllPerformance" layout="flow"
                                                                style="background-color: rgb(245, 245, 245); display: block; height: 222px; position: relative; width: 734px; -rave-layout: grid" styleClass="message">
                                                                <ice:dataTable id="dataTableAllPerformanceOfEmployee"
                                                                    style="left: 20px; top: 0px; height:8px; width:750px; position: absolute"
                                                                    value="#{EmployeeHistory$ApproveRequestPromotion.allPerforamceResult}" var="currentRow">
                                                                    <ice:column id="colNumberPerformance">
                                                                        <ice:outputText id="optTxtForColumnNumPerformance" value="#{currentRow['performanceSessionID']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextNumPerformance" value="SessionID"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colCommitteeNamePerformance">
                                                                        <ice:outputText id="optTxtForColumnRequesterIDPerformance" value="#{currentRow['evaluatorEmp_ID']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextRequesteNamePerformance" value="EvaluatorID"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column groupOn="#{currentRow['evaluatedEmp_ID']}" id="colRepititionPerformance">
                                                                        <ice:outputText id="optTxtForColumnOffenceDatePerformance" value="#{currentRow['evaluatedEmp_ID']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextOffenceDatePerformance" value="EvaluatedEmpID"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colDeciderPerformance">
                                                                        <ice:outputText id="optTxtForColumnOffenceTypePerformance" value="#{currentRow['totalPercentValue']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextOffenceTypePerformance" value="PerformanceResult(%)"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colPenalityPerformanceOne">
                                                                        <ice:outputText id="optTxtForColumnDescriptionPerformance" value="#{currentRow['totalAvarege_Percent']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextDescriptionPerformance" value="TotalValue(%)"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colPenalityPerformance">
                                                                        <ice:outputText id="optTxtForColumnDePerformance" value="#{currentRow['perfor_EvaluationDate']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextDesPerformancen" value="EvaluationDate"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                        </ice:panelGroup>
                                                    </f:facet>
                                                </ice:panelPopup>
                                                <ice:panelLayout id="PanelLayOutInsidVacancyListRequester" rendered="false"
                                                    style="height: 100px; margin-left: 15px; margin-top: 475px;  position: absolute; width: 638px" styleClass="insideContainerMain">
                                                    <ice:selectBooleanCheckbox
                                                        binding="#{EmployeeHistory$ApproveRequestPromotion.selectBooleanCheckbox1TotalService}"
                                                        id="selectBooleanCheckbox1TotalService" partialSubmit="true" rendered="false" style="margin-left: 15px; margin-top: 14px;  position: absolute;"/>
                                                    <ice:outputText id="outputText14TotalService"
                                                        style="margin-left: 30px; margin-top: 12px;  position: absolute;" styleClass="insideInputTextAnyPerfo" value="Exame Result"/>
                                                    <ice:inputText binding="#{EmployeeHistory$ApproveRequestPromotion.txtExameResult}" disabled="true"
                                                        id="txtExameResult" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 130px; top: 7px; position: absolute; width: 50px"/>
                                                    <ice:outputText id="outputText14TotalServicePercent"
                                                        style="margin-left: 190px; margin-top: 12px;  position: absolute;" styleClass="insideInputTextAnyPerfo" value="%"/>
                                                    <ice:selectBooleanCheckbox
                                                        binding="#{EmployeeHistory$ApproveRequestPromotion.selectBooleanCheckbox2Performance}"
                                                        id="selectBooleanCheckbox2Performance" partialSubmit="true" rendered="false"
                                                        style="margin-left: 15px; margin-top: 60px;  position: absolute;"
                                                        value="#{EmployeeHistory$ApproveRequestPromotion.selectBooleanCheckbox2Bean.selectedBoolean}" valueChangeListener="#{EmployeeHistory$ApproveRequestPromotion.selectBooleanCheckbox2Performance_processValueChange}"/>
                                                    <ice:outputText id="outputText14Performance"
                                                        style="margin-left: 30px; margin-top: 58px;  position: absolute;" styleClass="insideInputTextAnyPerfo" value="Performance"/>
                                                    <ice:inputText binding="#{EmployeeHistory$ApproveRequestPromotion.txtPerformance}" disabled="true"
                                                        id="txtPerformance" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 130px; top: 47px; position: absolute; width: 50px"/>
                                                    <ice:outputText id="outputText14PerformancePercent"
                                                        style="margin-left: 190px; margin-top: 52px;  position: absolute;" styleClass="insideInputTextAnyPerfo" value="%"/>
                                                    <ice:selectBooleanCheckbox
                                                        binding="#{EmployeeHistory$ApproveRequestPromotion.selectBooleanCheckbox3EducationLevel}"
                                                        id="selectBooleanCheckbox3EducationLevel" partialSubmit="true" rendered="false"
                                                        style="margin-left: 350px; margin-top: 14px;  position: absolute;" value="#{EmployeeHistory$ApproveRequestPromotion.selectBooleanCheckbox3Bean.selectedBoolean}"/>
                                                    <ice:outputText id="outputText14EducationLevel"
                                                        style="margin-left: 370px; margin-top: 12px;  position: absolute;" styleClass="insideInputTextAnyPerfo" value="Discipline"/>
                                                    <ice:inputText binding="#{EmployeeHistory$ApproveRequestPromotion.txtDiscipline}" disabled="true"
                                                        id="txtDiscipline" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 500px; top: 7px; position: absolute; width: 50px"/>
                                                    <ice:outputText id="outputText14EducationLevelPercent"
                                                        style="margin-left: 590px; margin-top: 12px; position: absolute; width: 100px"
                                                        styleClass="insideInputTextAnyPerfo" value="%"/>
                                                    <ice:selectBooleanCheckbox
                                                        binding="#{EmployeeHistory$ApproveRequestPromotion.selectBooleanCheckbox4Training}"
                                                        id="selectBooleanCheckbox4Training" partialSubmit="true" rendered="false"
                                                        style="margin-left: 350px; margin-top: 60px;  position: absolute;" value="#{EmployeeHistory$ApproveRequestPromotion.selectBooleanCheckbox4Bean.selectedBoolean}"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="PanelLayOutInsidVacancyListRequesterButton"
                                                    style="height: 73px; margin-left: 658px; margin-top: 475px; top: 40px; position: absolute; width: 100px" styleClass="insideContainerMain">
                                                    <ice:commandButton action="#{EmployeeHistory$ApproveRequestPromotion.btnApprove_action}" id="btnApprove"
                                                        style="margin-left: 10px; width: 80px; top: -2px; position: absolute" value="Approve"/>
                                                    <ice:commandButton action="#{EmployeeHistory$ApproveRequestPromotion.btnReject_action}"
                                                        binding="#{EmployeeHistory$ApproveRequestPromotion.btnReject}" id="btnReject"
                                                        style="margin-left: 10px; width: 80px; top: 35px; position: absolute" value="Reject"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="PanelLayOutPromotionRequesters"
                                                    style="height: 250px; margin-left: 8px; margin-top: 210px; top: 40px; overflow: auto; position: absolute; width: 765px" styleClass="insideContainerMain">
                                                    <ice:dataTable binding="#{EmployeeHistory$ApproveRequestPromotion.dataTable1}" id="dataTable1"
                                                        style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                        value="#{EmployeeHistory$ApproveRequestPromotion.requesterForPromotionNew}" var="currentRow" width="727">
                                                        <ice:column id="column4">
                                                            <ice:outputText id="outputText2" value="#{currentRow['fullName']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText3" styleClass="insideInputTableHeader" value="Full Name"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column5EducTypeDesc">
                                                            <ice:outputText id="outputText4EducTypeDesc" value="#{currentRow['jobDescription']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText5EducTypeDesc" styleClass="insideInputTableHeader" value="Job Description"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="EducTypeDesc51">
                                                            <ice:outputText id="EducTypeDesc15" value="#{currentRow['educLevelId']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="EducTypeDesc5" styleClass="insideInputTableHeader" value="Education"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column6Experience">
                                                            <ice:outputText id="outputText6Experience" value="#{currentRow['experience']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText13Experience" styleClass="insideInputTableHeader" value="Experience"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column4EmpID" rendered="true">
                                                            <ice:outputText id="outputText2EmpID" value="#{currentRow['relatExp']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText3EmpID" styleClass="insideInputTableHeader" value="Experience"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column6EducLevelDescPercent">
                                                            <ice:outputText id="outputText6EducLevelDescPercent" value="#{currentRow['toalExamResult']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText13EducLevelDescPercent" styleClass="insideInputTableHeader" value="%Exame Result"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column6ExperiencePercent">
                                                            <ice:outputText id="outputText6ExperiencePercent" value="#{currentRow['promotionPercentageValue']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText13ExperiencePercent" styleClass="insideInputTableHeader" value="%Performance"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column6PerformancePercent">
                                                            <ice:outputText id="outputText6PerformancePercent" value="#{currentRow['disciplinePercentageValue']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText13PerformancePercent" styleClass="insideInputTableHeader" value="%Discipline"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column6TotalPercent">
                                                            <ice:outputText id="outputText6TotalPercent" value="#{currentRow['percentTotal']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText13TotalPercent" styleClass="insideInputTableHeader" value="%Total"/>
                                                            </f:facet>
                                                            <ice:rowSelector id="rowSelectorForApprovalMember" immediate="true" multiple="false"
                                                                preStyleOnSelection="true"
                                                                selectionListener="#{EmployeeHistory$ApproveRequestPromotion.rowSelectorForApprovalMember_processMyEvent}" toggleOnClick="true"/>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:inputText binding="#{EmployeeHistory$ApproveRequestPromotion.inputTextAdvertID}" id="inputTextAdvertID" rendered="false"/>
                                                <ice:commandLink action="#{EmployeeHistory$ApproveRequestPromotion.cmd_view_Discipline_action}"
                                                    id="cmd_view_Discipline" style="left: 96px; top: 528px; position: absolute" value="View Discipline Case"/>
                                                <ice:commandLink action="#{EmployeeHistory$ApproveRequestPromotion.cmd_view_performance_action}"
                                                    id="cmd_view_performance" style="left: 240px; top: 528px; position: absolute" value="View Performance Result"/>
                                                <ice:commandLink id="cmd_generateReport" style="left: 408px; top: 528px; position: absolute" value="ViewApplicanDetail"/>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <ice:outputLabel id="outputLabel1"
                                            style="color: rgb(255, 255, 255); font-family: serif; font-size: 14px; font-style: italic; font-weight: bolder; height: 18px; left: 24px; top: 0px; position: absolute; width: 622px" value="BUNNA INTERNATIONAL BANK Human Resource Management System"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$ApproveRequestPromotion.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{EmployeeHistory$ApproveRequestPromotion.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{EmployeeHistory$ApproveRequestPromotion.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$ApproveRequestPromotion.evaResultPopUpMsg}" draggable="true"
                            id="evaResultPopUpMsg" modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 380px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridevaResultPopUpMsg" style="display: block; height: 20px; width: 277px">
                                    <ice:outputText id="lblevaResultPopUpMsgTitle" value="Promotion Evaluation Result"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupevaResultPopUpMsgBody" style="display: block; height: 94px; position: relative; width: 340">
                                    <ice:panelLayout id="PanelLayOutevaResultPopUpMsg"
                                        style="height: 100px; margin-left: 0px; margin-top: -5px; overflow: auto; position: absolute; width: 340px" styleClass="insideContainerMain">
                                        <ice:outputText id="outputText14evaResultPopUpMsg" style="left: 10px; top: 12px;  position: absolute;"
                                            styleClass="insideInputTextAnyPerfo" value="Education Level"/>
                                        <ice:selectOneMenu binding="#{EmployeeHistory$ApproveRequestPromotion.selectOneMenu1evaResultPopUpMsg}"
                                            id="selectOneMenu1evaResultPopUpMsg" partialSubmit="true"
                                            style=" border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width:200px; left: 110px; top: 10px; position: absolute" value="#{EmployeeHistory$ApproveRequestPromotion.selectOneMenu1Bean.selectedObject}">
                                            <f:selectItems id="selectOneMenu1selectItems" value="#{EmployeeHistory$ApproveRequestPromotion.toFilterResultUsingSession}"/>
                                        </ice:selectOneMenu>
                                        <ice:outputText id="outputText14evaResultNoteIssue" style="color: red ;left: 10px; top: 60px;  position: absolute;"
                                            styleClass="insideInputTextAnyPerfo" value="Notes and Issue:"/>
                                        <ice:outputText binding="#{EmployeeHistory$ApproveRequestPromotion.outputText14evaResultNoteIssueVal}"
                                            id="outputText14evaResultNoteIssueVal" style="color: black ;left: 10px; top: 80px;  position: absolute;"
                                            styleClass="insideInputTextAnyPerfo" value="Val"/>
                                        <ice:commandButton action="#{EmployeeHistory$ApproveRequestPromotion.button2Ok_action}"
                                            binding="#{EmployeeHistory$ApproveRequestPromotion.button2Ok}" id="button2Ok"
                                            style="left: 200px; top: 40px;  position: absolute; height: 25px; font-size: 10px; width: 50px" value="Ok"/>
                                        <ice:commandButton action="#{EmployeeHistory$ApproveRequestPromotion.button2Cancel_action}"
                                            binding="#{EmployeeHistory$ApproveRequestPromotion.button2Cancel}" id="button2Cancel"
                                            style="left: 255px; top: 40px;  position: absolute; height: 25px; font-size: 10px; width: 60px" value="Cancel"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$ApproveRequestPromotion.pnlPopupCommitteeMembers}"
                            id="pnlPopupCommitteeMembers" modal="FALSE" rendered="false"
                                style="height: 453px; left: 408px; top: 240px; position: absolute; width: 813px">n
                <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupCommitteeMembers" style="display: block; height: 20px; text-align: left" width="772">
                                    <ice:outputText dir="left" id="otxtCommitteeMembers" style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - CONFIRM ON DECISION"/>
                                    <ice:commandLink action="#{EmployeeHistory$ApproveRequestPromotion.btnClosePopupCommitteeMembers_action}"
                                        id="btnClosePopupCommitteeMembers" style="right: 0px; top: -20px; position: absolute" value="CLOSE"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutCommitteeMembers" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 284px; margin-left: 15px; left: 10px; top: 50px; overflow: auto; position: absolute; width: 770px">
                                    <ice:panelLayout id="pnlLayoutPopupCommitteeMembers" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 237px; margin-left: 15px; left: 0px; top: 24px; overflow: auto; position: absolute; width: 740px">
                                        <ice:panelLayout id="pnlLayoutPopupCommitteeMembersMessage2" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 40px; margin-left: 15px; left: 0px; top: 14px; overflow: auto; position: absolute; width: 693px">
                                            <ice:outputLabel id="lblSignInReminder" value="Signin using your username"/>
                                            <ice:commandLink action="#{EmployeeHistory$ApproveRequestPromotion.cmdLnkClosePopupCommitteeMembers_action}"
                                                binding="#{EmployeeHistory$ApproveRequestPromotion.cmdLnkClosePopupCommitteeMembers}"
                                                id="cmdLnkClosePopupCommitteeMembers" rendered="true" style="color: rgb(48, 102, 130)" value="CLOSE"/>
                                        </ice:panelLayout>
                                        <ice:dataTable id="dataTableCommitteeMembers" style="height: 8px; left: 14px; top: 60px; position: absolute"
                                            value="#{EmployeeHistory$ApproveRequestPromotion.committeeMembersList}" var="currentRow" width="697">
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
                                                <ice:commandLink action="#{EmployeeHistory$ApproveRequestPromotion.btnPopupForColumnMemberLogIn_action}"
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
                                                    selectionListener="#{EmployeeHistory$ApproveRequestPromotion.rowSelectorCommitteeMember_processMyEvent}" toggleOnClick="true"/>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
