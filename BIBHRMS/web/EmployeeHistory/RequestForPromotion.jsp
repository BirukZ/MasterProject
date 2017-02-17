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
            function LeaveScheduleApprove(field){

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
                                <ice:panelGroup id="menu_left" style="height: 300px">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 580px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 450px; left: 5px; position: absolute; width: 213px" styleClass="left_menu">
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
                                                        <li>
                                                            <ice:commandLink action="#{EmployeeHistory$RequestForPromotion.cmdDegreeOfPromoteAssement_action}"
                                                                id="cmdDegreeOfPromoteAssement" rendered="false" style="color:#306682;font-weight:bold" value="Degree of Exam"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{EmployeeHistory$RequestForPromotion.cmdExperience_action}"
                                                                id="cmdExperience" style="color:#306682;font-weight:bold" value="Experience"/>
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
                                                    <ice:selectOneListbox binding="#{EmployeeHistory$RequestForPromotion.selectOneListboxSelectDate1}"
                                                        id="selectOneListboxSelectDate1" partialSubmit="true" size="2"
                                                        style="height:100px; border: 1px solid #73b3ce;"
                                                        value="#{EmployeeHistory$RequestForPromotion.defaultSelectedData1.selectedObject}" valueChangeListener="#{EmployeeHistory$RequestForPromotion.selectOneListboxSelectDate1_processValueChange}">
                                                        <f:selectItems id="selectOneListbox1selectItems" value="#{EmployeeHistory$RequestForPromotion.newPromotionRequestsDates}"/>
                                                    </ice:selectOneListbox>
                                                    <ice:panelTabSet id="panelTabSet1" style="width:100%" tabPlacement="Top">
                                                        <ice:panelTab id="tabinbox" label="In Box">
                                                            <ice:panelLayout id="panelLayout2" style="position: inherit; width: 100%; height: 100%;">
                                                                <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.buttonViewAll_action}"
                                                                    binding="#{EmployeeHistory$RequestForPromotion.buttonViewAll}" id="buttonViewAll" value="View All"/>
                                                                <ice:selectOneListbox
                                                                    binding="#{EmployeeHistory$RequestForPromotion.selectOneListboxPromotionRequestes}"
                                                                    id="selectOneListboxPromotionRequestes" partialSubmit="true" size="2"
                                                                    style="border: 1px solid rgb(115, 179, 206); height: 177px; width: 170px"
                                                                    value="#{EmployeeHistory$RequestForPromotion.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$RequestForPromotion.selectOneListboxPromotionRequestes_processValueChange}">
                                                                    <f:selectItems id="selectOneListbox1selectItemsPromotionRequestes" value="#{EmployeeHistory$RequestForPromotion.newPromotionRequests}"/>
                                                                </ice:selectOneListbox>
                                                            </ice:panelLayout>
                                                        </ice:panelTab>
                                                        <ice:panelTab id="tabSearch" label="Response ">
                                                            <ice:panelLayout id="panelLayoutResponseG" style="position: inherit; width: 100%; height: 100%;">
                                                                <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.buttonViewAllR_action}"
                                                                    binding="#{EmployeeHistory$RequestForPromotion.buttonViewAllR}" id="buttonViewAllR" value="View All"/>
                                                                <ice:selectOneListbox binding="#{EmployeeHistory$RequestForPromotion.selectOneListbox1Response}"
                                                                    id="selectOneListbox1Response" partialSubmit="true" size="2"
                                                                    style="border: 1px solid rgb(115, 179, 206); height: 180px; width: 170px"
                                                                    value="#{EmployeeHistory$RequestForPromotion.defaultSelectedData2.selectedObject}" valueChangeListener="#{EmployeeHistory$RequestForPromotion.selectOneListbox1Response_processValueChange}">
                                                                    <f:selectItems id="selectOneListbox1selectItems1" value="#{EmployeeHistory$RequestForPromotion.newPromotionResponse}"/>
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
                                <ice:panelGroup id="page_display" style="height: 730px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 720px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 705px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Requests for Promotion"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 710px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelLayout id="PanelLayOutInsidVacancyList"
                                                    style="height: 175px; margin-left: 8px; margin-top: 30px; overflow: auto; position: absolute; width: 765px" styleClass="insideContainerMain">
                                                    <ice:dataTable id="tblAdvertisment" rules="all"
                                                        style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                        value="#{EmployeeHistory$RequestForPromotion.vacancyList}" var="currentRow" width="727">
                                                        <ice:column groupOn="#{currentRow['jobType']}" id="colJob">
                                                            <ice:outputText id="txtJob" value="#{currentRow['jobType']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblJob" styleClass="insideInputTableHeader" value="Job Type"/>
                                                            </f:facet>
                                                            <ice:rowSelector binding="#{EmployeeHistory$RequestForPromotion.rowSelectorVacancyNoticeList}"
                                                                id="rowSelectorVacancyNoticeList" multiple="false" preStyleOnSelection="true" rendered="false"
                                                                selectionListener="#{EmployeeHistory$RequestForPromotion.rowSelectorVacancyNoticeList_processMyEvent}"
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
                                                <ice:panelLayout id="lyRequestStatus"
                                                    style="height: 30px; margin-left: 240px; margin-top: -57px; left: 0px; top: 57px; position: absolute; width: 580px" styleClass="">
                                                    <ice:outputText id="lblStatus"
                                                        style="font-size: 16px; color: #023369; font-weight:bold; left: 5px; top: 7px; position: absolute" value="Status:"/>
                                                    <ice:outputText binding="#{EmployeeHistory$RequestForPromotion.lblStatusValue}" id="lblStatusValue"
                                                        style="font-size: 12px; color: #dc6a0e; font-weight:bold; font-family: Arial, Helvetica, sans-serif;left: 72px; top: 10px; position: absolute" value="Promotion Request Status."/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="PanelLayOutInsidVacancyListRequester" rendered="false"
                                                    style="height: 150px; margin-left: 8px; margin-top: 475px; position: absolute; width: 640px" styleClass="insideContainerMain">
                                                    <ice:selectBooleanCheckbox binding="#{EmployeeHistory$RequestForPromotion.chkExameResult}"
                                                        id="chkExameResult" partialSubmit="true"
                                                        style="margin-left: 15px; margin-top: 14px;  position: absolute;" value="#{EmployeeHistory$RequestForPromotion.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                    <ice:outputText id="outputText14TotalService"
                                                        style="margin-left: 30px; margin-top: 12px;  position: absolute;" styleClass="insideInputTextAnyPerfo" value="Exame Result"/>
                                                    <ice:inputText binding="#{EmployeeHistory$RequestForPromotion.txtExameResult}" id="txtExameResult" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 130px; top: 7px; position: absolute; width: 50px"/>
                                                    <ice:outputText id="outputText14TotalServicePercent"
                                                        style="margin-left: 190px; margin-top: 12px;  position: absolute;" styleClass="insideInputTextAnyPerfo" value="%"/>
                                                    <ice:selectBooleanCheckbox binding="#{EmployeeHistory$RequestForPromotion.chkPerformance}"
                                                        id="chkPerformance" partialSubmit="true"
                                                        style="margin-left: 15px; margin-top: 60px;  position: absolute;" value="#{EmployeeHistory$RequestForPromotion.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                                    <ice:outputText id="outputText14Performance"
                                                        style="margin-left: 30px; margin-top: 58px;  position: absolute;" styleClass="insideInputTextAnyPerfo" value="Performance"/>
                                                    <ice:inputText binding="#{EmployeeHistory$RequestForPromotion.txtPerformance}" id="txtPerformance" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 130px; top: 47px; position: absolute; width: 50px"/>
                                                    <ice:outputText id="outputText14PerformancePercent"
                                                        style="margin-left: 190px; margin-top: 52px;  position: absolute;" styleClass="insideInputTextAnyPerfo" value="%"/>
                                                    <ice:selectBooleanCheckbox binding="#{EmployeeHistory$RequestForPromotion.chkDiscipline}" id="chkDiscipline"
                                                        partialSubmit="true" style="margin-left: 350px; margin-top: 14px;  position: absolute;" value="#{EmployeeHistory$RequestForPromotion.selectBooleanCheckbox3Bean.selectedBoolean}"/>
                                                    <ice:outputText id="outputText14EducationLevel"
                                                        style="margin-left: 370px; margin-top: 12px; position: absolute; text-align: left; width: 100px"
                                                        styleClass="insideInputTextAnyPerfo" value="Discipline"/>
                                                    <ice:inputText binding="#{EmployeeHistory$RequestForPromotion.txtDiscipline}" id="txtDiscipline" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 530px; top: 7px; position: absolute; width: 50px"/>
                                                    <ice:outputText id="outputText14EducationLevelPercent"
                                                        style="margin-left: 590px; margin-top: 12px;  position: absolute;" styleClass="insideInputTextAnyPerfo" value="%"/>
                                                    <ice:selectBooleanCheckbox binding="#{EmployeeHistory$RequestForPromotion.selectBooleanCheckbox4Training}"
                                                        id="selectBooleanCheckbox4Training" partialSubmit="true"
                                                        style="margin-left: 350px; margin-top: 60px;  position: absolute;" value="#{EmployeeHistory$RequestForPromotion.selectBooleanCheckbox4Bean.selectedBoolean}"/>
                                                    <ice:outputText id="outputText14Training" rendered="false"
                                                        style="margin-left: 370px; margin-top: 58px;  position: absolute;" styleClass="insideInputTextAnyPerfo" value="Training Related to Position"/>
                                                    <ice:inputText binding="#{EmployeeHistory$RequestForPromotion.inputText1Training}" id="inputText1Training"
                                                        rendered="false" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 530px; top: 47px; position: absolute; width: 50px"/>
                                                    <ice:outputText id="outputText14TrainingPercent" rendered="false"
                                                        style="margin-left: 190px; margin-top: 52px;  position: absolute;" styleClass="insideInputTextAnyPerfo" value="%"/>
                                                    <ice:outputText id="outputText19"
                                                        style="margin-left: 370px; margin-top: 58px; position: absolute; width: 50px" value="Experience "/>
                                                    <ice:selectBooleanCheckbox id="selectBooleanCheckbox1" partialSubmit="true" rendered="false"
                                                        style="margin-left: 350px; margin-top: 60px;  position: absolute;" value="#{EmployeeHistory$RequestForPromotion.defaultSelectedData4.selectedBoolean}"/>
                                                    <ice:inputText id="inputText1" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 530px; top: 47px; position: absolute; width: 50px"/>
                                                    <ice:selectBooleanCheckbox id="selectBooleanCheckbox2" partialSubmit="true" rendered="false"
                                                        style="margin-left: 15px; margin-top: 106px;  position: absolute;" value="#{EmployeeHistory$RequestForPromotion.defaultSelectedData5.selectedBoolean}"/>
                                                    <ice:inputText id="inputText2" rendered="false" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 130px; top: 106px; position: absolute; width: 50px"/>
                                                    <ice:outputText id="lbl" rendered="false" style="margin-left: 30px; margin-top: 106px; position: absolute" value="Education"/>
                                                    <ice:outputText id="outputText20" rendered="false"
                                                        style="margin-left: 190px; margin-top: 106px;  position: absolute;" value="%"/>
                                                    <ice:outputText id="outputText21" rendered="false"
                                                        style="margin-left: 370px; margin-top: 106px; position: absolute; width: 50px" value="outputText"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="PanelLayOutInsidVacancyListRequesterButton"
                                                    style="height: 73px; margin-left: 670px; margin-top: 475px; position: absolute; width: 100px" styleClass="insideContainerMain">
                                                    <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.btnRequest_action}"
                                                        binding="#{EmployeeHistory$RequestForPromotion.btnRequest}" id="btnRequest" rendered="false"
                                                        style="margin-left: 10px; width: 80px; top: -2px; position: absolute" value="Evaluate"/>
                                                    <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.btnSave_action}"
                                                        binding="#{EmployeeHistory$RequestForPromotion.btnSave}" id="btnSave"
                                                        style="margin-left: 10px; width: 80px; top: 35px; position: absolute" value="Save"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout binding="#{EmployeeHistory$RequestForPromotion.pnlLayoutCommitteeMember}"
                                                    id="pnlLayoutCommitteeMember"
                                                    style="height: 71px; margin-left: 10px; margin-top: 10px; left: -2px; top: 467px; position: absolute; width: 657px" styleClass="insideContainerMain">
                                                    <ice:outputLabel id="lblCommitteeType1" rendered="false" style="left: 47px; top: 13px; position: absolute" value="Type"/>
                                                    <ice:outputLabel id="lblCommitteeCommittee1" style="left: 281px; top: 13px; position: absolute" value="Committee"/>
                                                    <ice:selectOneMenu binding="#{EmployeeHistory$RequestForPromotion.drlCommittee}" id="drlCommittee"
                                                        partialSubmit="true" style="left: 348px; top: 18px; position: absolute; width: 192px"
                                                        value="#{EmployeeHistory$RequestForPromotion.selectedObjectCommittee.selectedObject}" valueChangeListener="#{EmployeeHistory$RequestForPromotion.drlCommittee_processValueChange}">
                                                        <f:selectItems id="selectOneMenu1selectItems21" value="#{EmployeeHistory$RequestForPromotion.committeeList}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:selectOneMenu binding="#{EmployeeHistory$RequestForPromotion.drlCommitteeType}" id="drlCommitteeType"
                                                        partialSubmit="true" rendered="false" style="left: 78px; top: 15px; position: absolute; width: 192px"
                                                        value="#{EmployeeHistory$RequestForPromotion.selectedObjectCommitteeType.selectedObject}" valueChangeListener="#{EmployeeHistory$RequestForPromotion.drlCommitteeType_processValueChange}">
                                                        <f:selectItems id="selectOneMenuCommitteeType1" value="#{EmployeeHistory$RequestForPromotion.committeeType}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.btnAddCommittee_action}"
                                                        id="btnAddCommittee1" style="left: 548px; top: 6px; position: absolute" value="+"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="PanelLayOutPromotionRequesters"
                                                    style="height: 260px; margin-left: 8px; margin-top: 210px; overflow: auto; position: absolute; width: 765px" styleClass="insideContainerMain">
                                                    <ice:dataTable binding="#{EmployeeHistory$RequestForPromotion.dataTable1}" id="dataTable1"
                                                        style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                        value="#{EmployeeHistory$RequestForPromotion.requestersForPromotion}" var="currentRow">
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
                                                        <ice:column id="column5" rendered="false">
                                                            <ice:outputText id="outputText4" value="#{currentRow['qualification']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText5" styleClass="insideInputTableHeader" value="Qualification"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column6EducLevelDesc" rendered="false" style="visibility:false">
                                                            <ice:outputText id="outputText6EducLevelDesc" value="#{currentRow['educLevelDesc']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText13EducLevelDesc" styleClass="insideInputTableHeader" value="Education Level"/>
                                                            </f:facet>
                                                            <ice:rowSelector binding="#{EmployeeHistory$RequestForPromotion.rowSelectorPromotionRequester}"
                                                                id="rowSelectorPromotionRequester" multiple="false" preStyleOnSelection="true"
                                                                selectionListener="#{EmployeeHistory$RequestForPromotion.rowSelectorPromotionRequester_processMyEvent}"
                                                                toggleOnClick="true" value="#{currentRow['selectPromotionRequester']}"/>
                                                        </ice:column>
                                                        <ice:column id="column6" rendered="false">
                                                            <ice:outputText id="outputText6" value="#{currentRow['educLevel']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText13" styleClass="insideInputTableHeader" value="Education Level"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column6Experience">
                                                            <ice:outputText id="outputText6Experience" value="#{currentRow['experience']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText13Experience" styleClass="insideInputTableHeader" value="Total Experience"/>
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
                                                            <ice:outputText id="outputText6ExperiencePercent" value="#{currentRow['performanceValue']}"/>
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
                                                        </ice:column> 
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:inputText binding="#{EmployeeHistory$RequestForPromotion.inputTextAdvertID}" id="inputTextAdvertID" rendered="false"/>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup dragListener="#{Employee$EmployeePage.page_footer_processMyEvent}" id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <ice:outputLabel id="outputLabel1"
                                            style="color: rgb(255, 255, 255); font-family: serif; font-size: 14px; font-style: italic; font-weight: bolder; height: 18px; left: 24px; top: 0px; position: absolute; width: 622px" value="BUNNA INTERNATIONAL BANK Human Resource Management System - Maintain Jobs."/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$RequestForPromotion.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BIB Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{EmployeeHistory$RequestForPromotion.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{EmployeeHistory$RequestForPromotion.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$RequestForPromotion.evaResultPopUpMsg}" draggable="true"
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
                                        <ice:selectOneMenu binding="#{EmployeeHistory$RequestForPromotion.selectOneMenu1evaResultPopUpMsg}"
                                            id="selectOneMenu1evaResultPopUpMsg" partialSubmit="true"
                                            style=" border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width:200px; left: 110px; top: 10px; position: absolute" value="#{EmployeeHistory$RequestForPromotion.selectOneMenu1Bean.selectedObject}">
                                            <f:selectItems id="selectOneMenu1selectItems" value="#{EmployeeHistory$RequestForPromotion.toFilterResultUsingSession}"/>
                                        </ice:selectOneMenu>
                                        <ice:outputText id="outputText14evaResultNoteIssue" style="color: red ;left: 10px; top: 60px;  position: absolute;"
                                            styleClass="insideInputTextAnyPerfo" value="Notes and Issue:"/>
                                        <ice:outputText binding="#{EmployeeHistory$RequestForPromotion.outputText14evaResultNoteIssueVal}"
                                            id="outputText14evaResultNoteIssueVal" style="color: black ;left: 10px; top: 80px;  position: absolute;"
                                            styleClass="insideInputTextAnyPerfo" value="Val"/>
                                        <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.button2Ok_action}"
                                            binding="#{EmployeeHistory$RequestForPromotion.button2Ok}" id="button2Ok"
                                            style="left: 200px; top: 40px;  position: absolute; height: 25px; font-size: 10px; width: 50px" value="Ok"/>
                                        <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.button2Cancel_action}"
                                            binding="#{EmployeeHistory$RequestForPromotion.button2Cancel}" id="button2Cancel"
                                            style="left: 255px; top: 40px;  position: absolute; height: 25px; font-size: 10px; width: 60px" value="Cancel"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$RequestForPromotion.popupPromotionAssessmentResult}" clientOnly="true"
                            draggable="false" id="popupPromotionAssessmentResult" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 320px; left: 400px; top: 300px; position: absolute; width: 300px; z-index: 1" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridPromotionAssessmentResult" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 528px">
                                    <ice:outputText id="txtPromotionAssessmentResult"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 400px" value="BIB Human Resource Management System : Assessment Result "/>
                                    <ice:commandLink action="#{EmployeeHistory$RequestForPromotion.modalPnlCloseDisplayAssessmentResult_action}"
                                        id="modalPnlCloseDisplayAssessmentResult" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 560px; top: 15px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupPromotionAssessmentResult" style="display: block; height: 400px; position: relative; width: 483px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlPromotionAssessmentResultBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 370px; position: relative; width: 415px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel id="lblFormDisplayAssessmentResult" style="background-color: #F5F5F5;"/>
                                        <ice:panelLayout id="pnlPromotionAssessmentResultDetail" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 371px; margin-left: 10px; margin-top: 0px; left: 0px; top: 10px; position: absolute; width: 460px">
                                            <ice:outputText id="outputTextInterviewResult"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 19px; top: 10px; position: absolute" value="Interview Result"/>
                                            <ice:outputText id="outputTextWrittenResult"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 19px; top: 50px; position: absolute" value="Written Result "/>
                                            <ice:outputText id="outputTextPresentationResult"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 19px; top: 90px; position: absolute" value="Presentation Result"/>
                                            <ice:outputText id="outputTextOtherResult"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 19px; top: 130px; position: absolute; text-align: left" value="Performance"/>
                                            <ice:outputText id="outputTextRecommendation"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 19px; top: 170px; position: absolute; text-align: left" value="Recommendation "/>
                                            <ice:outputText id="outputTextRemark"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 19px; top: 240px; position: absolute; text-align: left" value="Remark "/>
                                            <ice:inputText binding="#{EmployeeHistory$RequestForPromotion.txtInterviewResult}" id="txtInterviewResult" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 10px; position: absolute; text-align: left; width: 90px"/>
                                            <ice:inputText binding="#{EmployeeHistory$RequestForPromotion.txtWrittenResult}" id="txtWrittenResult" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 50px; position: absolute; text-align: left; width: 90px"/>
                                            <ice:inputText binding="#{EmployeeHistory$RequestForPromotion.txtPresentationResult}" id="txtPresentationResult" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 90px; position: absolute; text-align: left; width: 90px"/>
                                            <ice:inputText binding="#{EmployeeHistory$RequestForPromotion.txtOtherResult}" id="txtOtherResult" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 130px; position: absolute; text-align: left; width: 90px"/>
                                            <ice:inputTextarea binding="#{EmployeeHistory$RequestForPromotion.txtRec}" id="txtRec" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 166px; position: absolute; text-align: left; width: 315px"/>
                                            <ice:inputTextarea binding="#{EmployeeHistory$RequestForPromotion.txtRem}" id="txtRem" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 240px; position: absolute; text-align: left; width: 315px"/>
                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtInterviewResult" id="message1"
                                                infoClass="infoMessage"
                                                style="height: 22px; left: 215px; top: 10px; position: absolute; text-align: center; vertical-align: middle; width: 22px" warnClass="warnMessage"/>
                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtWrittenResult" id="message2"
                                                infoClass="infoMessage"
                                                style="height: 22px; left: 215px; top: 50px; position: absolute; text-align: center; vertical-align: middle; width:22px" warnClass="warnMessage"/>
                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtPresentationResult" id="message3"
                                                infoClass="infoMessage"
                                                style="height: 22px; left: 215px; top: 90px; position: absolute; text-align: center; vertical-align: middle; width: 22px" warnClass="warnMessage"/>
                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtOtherResult" id="message4"
                                                infoClass="infoMessage"
                                                style="height: 22px; left: 215px; top: 130px; position: absolute; text-align: center; vertical-align: middle; width: 22px" warnClass="warnMessage"/>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="pnlAssessmentResultButton" style="border-width: 1px; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); border-top-style: solid; height: 40px; margin-left: 2px; left: 22px; top: 336px; position: absolute; width: 431px; -rave-layout: grid">
                                            <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.btnSaveAssessmentResult_action}"
                                                binding="#{EmployeeHistory$RequestForPromotion.btnSaveAssessmentResult}" id="btnSaveAssessmentResult"
                                                style="margin-left: 40px; width: 80px" value="Save"/>
                                            <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.btnEditAssessmentResult_action}"
                                                binding="#{EmployeeHistory$RequestForPromotion.btnEditAssessmentResult}" id="btnEditAssessmentResult"
                                                style="margin-left: 40px; width: 80px" value="Edit"/>
                                            <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.btnUpdateAssessmentResult_action}"
                                                binding="#{EmployeeHistory$RequestForPromotion.btnUpdateAssessmentResult}" id="btnUpdateAssessmentResult"
                                                style="margin-left: 40px; width: 80px" value="Update"/>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$RequestForPromotion.pnDegreeOfAss}" clientOnly="true" draggable="false"
                            id="pnDegreeOfAss" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 270px; left: 408px; top: 264px; position: absolute; width: 300px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnDegreeOfAss" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 528px">
                                    <ice:outputText id="OutputTextDegreeOfAss"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 400px" value="BIB Human Resource Management : Degree of Assessment"/>
                                    <ice:commandLink action="#{EmployeeHistory$RequestForPromotion.modalPnlCloseDegreeOfAss_action}"
                                        id="modalPnlCloseDegreeOfAss" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 550px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupDegreeOfAss" style="display: block; height: 210px; position: relative; width: 483px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlDegreeOfAssBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 180px; position: relative; width: 415px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel id="lblFormCriteria" style="background-color: #F5F5F5;"/>
                                        <ice:panelLayout id="pnlDegreeOfAssBatch" style="border: 1px solid rgb(204, 204, 204); height: 35px; left: 10px; top: 10px; position: absolute; vertical-align: top; width: 460px">
                                            <ice:outputText id="outputTextBatchCide"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 19px; top: 3px; position: absolute" value="Batch Code"/>
                                            <ice:selectOneMenu binding="#{EmployeeHistory$RequestForPromotion.ddnBatchCode}" id="ddnBatchCode"
                                                partialSubmit="true"
                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 3px; position: absolute; width: 165px"
                                                value="#{EmployeeHistory$RequestForPromotion.defaultSelectedData3.selectedObject}" valueChangeListener="#{EmployeeHistory$RequestForPromotion.ddnBatchCode_processValueChange}">
                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{EmployeeHistory$RequestForPromotion.bachCode}"/>
                                            </ice:selectOneMenu>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="pnlDegreeOfAssessment" style="border: 1px solid rgb(204, 204, 204); height: 90px; margin-left: 10px; margin-top: -40px; left: 0px; top: 95px; position: absolute; width: 460px">
                                            <ice:outputText id="outputText3"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 19px; top: 20px; position: absolute" value="Written Result"/>
                                            <ice:outputText id="outputText4" rendered="true"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 250px; top: 54px; position: absolute" value="Other Result"/>
                                            <ice:outputText id="outputText10"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 19px; top: 54px; position: absolute" value="Interview Result"/>
                                            <ice:outputText id="outputText14"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 250px; top: 20px; position: absolute" value="Presentation Result"/>
                                            <ice:inputText binding="#{EmployeeHistory$RequestForPromotion.txtWrittenPercentage}" id="txtWrittenPercentage" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 14px; position: absolute; width: 80px"/>
                                            <ice:inputText binding="#{EmployeeHistory$RequestForPromotion.txtOtherPercentage}" id="txtOtherPercentage"
                                                rendered="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 350px; top: 50px; position: absolute; width: 80px"/>
                                            <ice:inputText binding="#{EmployeeHistory$RequestForPromotion.txtInterviewPercentage}" id="txtInterviewPercentage" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 50px; position: absolute; width: 80px"/>
                                            <ice:inputText binding="#{EmployeeHistory$RequestForPromotion.txtPresentaionPercentage}"
                                                id="txtPresentaionPercentage" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 350px; top: 14px; position: absolute; width: 80px"/>
                                            <ice:outputText id="outputText15"
                                                style="font-style: normal; font-weight: lighter; left: 210px; top: 15px; position: absolute" value="%"/>
                                            <ice:outputText id="outputText16" rendered="true"
                                                style="font-style: normal; font-weight: lighter; left: 440px; top: 54px; position: absolute" value="%"/>
                                            <ice:outputText id="outputText17"
                                                style="font-style: normal; font-weight: lighter; left: 440px; top: 20px; position: absolute" value="%"/>
                                            <ice:outputText id="outputText18"
                                                style="font-style: normal; font-weight: lighter; left: 210px; top: 50px; position: absolute" value="%"/>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="pnlDegreeOfAssCrude" style="border: 1px solid rgb(204, 204, 204); height: 43px; left: 10px; top: 155px; position: absolute; vertical-align: top; width: 460px">
                                            <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.btnSavePercentage_action}"
                                                binding="#{EmployeeHistory$RequestForPromotion.btnSavePercentage}" id="btnSavePercentage"
                                                style="margin-left: 5px; margin-top: -10px; width: 60px" value="Save"/>
                                            <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.btnEditPercentage_action}"
                                                binding="#{EmployeeHistory$RequestForPromotion.btnEditPercentage}" id="btnEditPercentage"
                                                style="margin-left: 40px; width: 60px" value="Edit"/>
                                            <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.btnUpdatePercentage_action}"
                                                binding="#{EmployeeHistory$RequestForPromotion.btnUpdatePercentage}" id="btnUpdatePercentage"
                                                style="margin-left: 40px; width: 60px" value="Update"/>
                                            <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.btnDeletePercentage_action}"
                                                binding="#{EmployeeHistory$RequestForPromotion.btnDeletePercentage}" id="btnDeletePercentage"
                                                style="margin-left: 40px; width: 60px" value="Delete"/>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$RequestForPromotion.pnlPopupViewEmployees_History}" draggable="true"
                            id="pnlPopupViewEmployees_History" modal="true" rendered="false" style="height: 381px; left: 744px; top: 360px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions1" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader1"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - "/>
                                    <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.btnClosePopupViewPrevieousDecisions1_action}"
                                        id="btnClosePopupViewPrevieousDecisions1" style="left: 650px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewEmpHistory" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 284px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupEmpHistoryTable"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 217px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px" styleClass="insideContainerMain">
                                        <ice:dataTable binding="#{EmployeeHistory$RequestForPromotion.dataTableEmpHistory}" id="dataTableEmpHistory"
                                            style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{EmployeeHistory$RequestForPromotion.empExperienceModel}" var="currentRow">
                                            <ice:column id="colNumber1">
                                                <ice:outputText id="optTxtForColumnNumber1" value="#{currentRow['counter']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextNumber1" value="NO"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colJobDesc">
                                                <ice:outputText id="optTxtForJobDesc" value="#{currentRow['jobDesc']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerJobDesc" value="Job Description"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colSartDate">
                                                <ice:outputText id="optTxtForSartDate" value="#{currentRow['startDate']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextSartDate" value="Start Date"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colEndDate">
                                                <ice:outputText id="optTxtForEndDate" value="#{currentRow['endDate']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEndDate" value="End Date"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colOption">
                                                <ice:selectBooleanCheckbox binding="#{Recruitment$CandidateListPage.cboMakeEmployee}" disabled="false"
                                                    id="cboMakeEmployee" value="#{currentRow['related']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="lblEmployee" value="Approved"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                    <ice:commandButton action="#{EmployeeHistory$RequestForPromotion.btnSet_action}" id="btnSet"
                                        style="left: 24px; top: 230px; position: absolute; z-index: 99" value="Set"/>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
