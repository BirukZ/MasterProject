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
                                                            <ice:commandLink id="cmdRecruitment" style="color:#306682;font-weight:bold" value="Recruitment Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="cmdrecApproval" style="color:#306682;font-weight:bold" value="Request Approved List"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="cmdVacancyNotice" style="color:#306682;font-weight:bold" value="Maintain Advertisement"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$VacancyNoticeList.cmdfilterCandidate_action}"
                                                                id="cmdfilterCandidate" style="color:#306682;font-weight:bold" value="Filter Candidates"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Recruitment$VacancyNoticeList.cmdRegisterCandidate_action}"
                                                                id="cmdRegisterCandidate" style="color:#306682;font-weight:bold" value="Register Candidate"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible5">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup4" styleClass="">
                                                        <ice:outputText id="lblSearch" value="Non Responsed Vacancies"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid3">
                                                    <ice:selectOneListbox id="selectOneListbox1" partialSubmit="true" size="2"
                                                        style="height:100px; border: 1px solid #73b3ce;" value="#{Recruitment$VacancyNoticeList.selectOneListbox1Bean.selectedObject}">
                                                        <f:selectItems id="selectOneListbox1selectItems" value="#{Recruitment$VacancyNoticeList.noneResponsedVacancies}"/>
                                                    </ice:selectOneListbox>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup dragListener="#{Recruitment$VacancyNoticeList.page_display_processMyEvent}" id="page_display" style="height: 545px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 530px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 510px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Internal Vacancy Notice List"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 505px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelLayout id="PanelLayOutInsidVacancyList"
                                                    style="height: 390px; margin-left: 15px; margin-top: 5px; top: 30px; overflow: auto; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                    <ice:dataTable id="tblAdvertisment" rules="all" style="left: 0px; top: -10px; position: absolute"
                                                        value="#{Recruitment$VacancyNoticeList.vacancyList}" var="currentRow" width="727">
                                                        <ice:column groupOn="#{currentRow['jobType']}" id="colJob">
                                                            <ice:outputText id="txtJob" value="#{currentRow['jobType']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblJob" value="Job Type"/>
                                                            </f:facet>
                                                            <ice:rowSelector binding="#{Recruitment$VacancyNoticeList.rowSelectorVacancyNoticeList}"
                                                                id="rowSelectorVacancyNoticeList" multiple="false" preStyleOnSelection="true" rendered="false"
                                                                selectionListener="#{Recruitment$VacancyNoticeList.rowSelectorVacancyNoticeList_processMyEvent}"
                                                                toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['requiredNo']}" id="colRequiredNo">
                                                            <ice:outputText id="txtJobRequiredNo" value="#{currentRow['requiredNo']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblJobRequiredNo" value="Required Number"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['qualification']}" id="column1Qualification">
                                                            <ice:outputText id="outputText7Qualification" value="#{currentRow['qualification']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8Qualification" value="Qualification"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['educLevel']}" id="column1EducLevel">
                                                            <ice:outputText id="outputText7EducLevel" value="#{currentRow['educLevel']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8EducLevel" value="Educ Level"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['experience']}" id="column1Experience">
                                                            <ice:outputText id="outputText7Experience" value="#{currentRow['experience']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8Experience" value="Experience"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['advertisementDateFrom']}" id="column1">
                                                            <ice:outputText id="outputText7" value="#{currentRow['advertisementDateFrom']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText8" value="Advertisement Date From"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['advertisementDateTo']}" id="column2">
                                                            <ice:outputText id="outputText9" value="#{currentRow['advertisementDateTo']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText10" value="Advetisement Date To"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column groupOn="#{currentRow['recruitmentBatchCode']}" id="column3">
                                                            <ice:outputText id="outputText11" value="#{currentRow['recruitmentBatchCode']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText12" value="Recruitment Request Code"/>
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
                                                        <ice:column groupOn="#{currentRow['jobType']}" id="column34RequestPromotion">
                                                            <h:selectBooleanCheckbox binding="#{Recruitment$VacancyNoticeList.checkbox1RequestPromotion}"
                                                                id="checkbox1RequestPromotion" value="#{currentRow['requestPromotion']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText34RequestPromotion" value="Request for Promotion"/>
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
                                                <ice:panelLayout id="PanelLayOutInsidVacancyListRequester"
                                                    style="height: 40px; margin-left: 15px; margin-top: 410px; left: 9px; top: 22px; position: absolute; width: 500px" styleClass="insideContainerMain">
                                                    <ice:outputText id="lblRequesterId" style="font-size: 10px; left: 31px; top: 10px; position: absolute" value="Requester ID:"/>
                                                    <ice:inputText binding="#{Recruitment$VacancyNoticeList.txtRequester}" id="txtRequester" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 10px; position: absolute; width: 190px"/>
                                                    <ice:inputText binding="#{Recruitment$VacancyNoticeList.inputTextEmpEducID}" id="inputTextEmpEducID" rendered="false"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="PanelLayOutInsidVacancyListRequesterButton"
                                                    style="height: 40px; margin-left: 520px; margin-top: 410px; left: 32px; top: 22px; position: absolute; width: 216px" styleClass="insideContainerMain">
                                                    <ice:commandButton action="#{Recruitment$VacancyNoticeList.btnRequest_action}"
                                                        binding="#{Recruitment$VacancyNoticeList.btnRequest}" id="btnRequest"
                                                        style="margin-left: 40px; width: 80px; top: -2px; position: absolute" value="Request"/>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label style="margin-left:20px;color:white;font-weight:bold;font-family:Narkisim">BUNNA INTERNATIONAL BANK.Human Resource Management System.</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Recruitment$VacancyNoticeList.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Recruitment$VacancyNoticeList.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Recruitment$VacancyNoticeList.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
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
