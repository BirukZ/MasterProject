<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : DavePro
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
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
            function OrganizationJobType(field){

                if (field.defaultValue == field.value) field.value = '';
                else if (field.value == '') field.value = field.defaultValue;

            }
        </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1000px" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Organization$JobTypesRegistrationPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Organization$JobTypesRegistrationPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Organization$JobTypesRegistrationPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Organization$JobTypesRegistrationPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Organization$JobTypesRegistrationPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1024">
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
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px;top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: -4px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="Search Area"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 55px; width: 100%">
                                                        <ice:outputText id="outputText19" value=""/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink id="lnkGovernmentDeductions" style="color:#306682;font-weight:bold" value="Workflow Transition Page"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="Pending"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:190px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 185px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{Organization$JobTypesRegistrationPage.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 180px; width: 190px"
                                                                value="#{Organization$JobTypesRegistrationPage.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Organization$JobTypesRegistrationPage.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Organization$JobTypesRegistrationPage.pendingRequestList}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_history" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="history_Group_Header">
                                                        <ice:outputText id="lblHistoryStatus" value="History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="HistoryStatusBoard" width="100%">
                                                    <ice:panelGroup id="History_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:190px; width: 100%">
                                                        <ice:panelLayout id="HistoryStatusContainer" style="height: 185px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox id="selectMyHistoryLists" partialSubmit="true" size="6"
                                                                style="height: 180px; width: 190px"
                                                                value="#{Organization$JobTypesRegistrationPage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Organization$JobTypesRegistrationPage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{Organization$JobTypesRegistrationPage.requestHistoryList}"/>
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
                                <ice:panelGroup id="page_display" style="height:790px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 775px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 760px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Payroll List and assign a dedecated person"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 770px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup id="pnlLayoutAttributes" style="height: 686px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayoutOne" style=" top:0px; width: 100%; position: absolute; height: 100%;">
                                                        <ice:panelLayout id="PanelLayOutJobAtrributes"
                                                            style="height: 224px; margin-left: 15px; margin-top: 40px; top: -27px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                            <ice:outputText id="lblCategory" style="left: 23px; top: 188px; position: absolute" value="Select Category: "/>
                                                            <ice:outputText id="lblJobCodeDescription"
                                                                style="font-size: 10px; left: 31px; top: 10px; position: absolute" value="Description"/>
                                                            <ice:inputText binding="#{Organization$JobTypesRegistrationPage.txtJobCode}" id="txtJobCode" style="left: 515px; top: 12px; position: absolute; width: 190px"/>
                                                            <ice:inputTextarea binding="#{Organization$JobTypesRegistrationPage.txtaJobDescription}"
                                                                disabled="true" id="txtaJobDescription" style="left: 136px; top: 2px; position: absolute; width: 190px"/>
                                                            <ice:outputText id="lblJobName" style="font-size: 10px; left: 31px; top: 50px; position: absolute" value=" Job  Name:"/>
                                                            <ice:inputTextarea binding="#{Organization$JobTypesRegistrationPage.txtaJobName}" id="txtaJobName" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 137px; top: 70px; position: absolute; width: 190px"/>
                                                            <ice:outputText id="lblresponsibility"
                                                                style="font-size: 10px; left: 32px; top: 129px; position: absolute" value="Responsibility:"/>
                                                            <ice:inputTextarea binding="#{Organization$JobTypesRegistrationPage.txtaJobResponsiblity}"
                                                                id="txtaJobResponsiblity" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 135px; top: 131px; position: absolute; width: 190px"/>
                                                            <ice:outputText id="lblRank" style="font-size: 10px; left: 406px; top: 45px; position: absolute" value="Rank:"/>
                                                            <ice:outputText id="lblCode" style="font-size: 10px; left: 406px; top: 11px; position: absolute" value="Code :"/>
                                                            <ice:outputText id="lblLevel" style="font-size: 10px; left: 406px; top: 84px; position: absolute" value="Level :"/>
                                                            <ice:selectOneMenu binding="#{Organization$JobTypesRegistrationPage.drlRank}" id="drlRank"
                                                                partialSubmit="true" style="left: 514px; top: 51px; position: absolute; width: 190px" value="#{Organization$JobTypesRegistrationPage.selectedObjectJobRank.selectedObject}">
                                                                <f:selectItems id="selectOneRankXX" value="#{Organization$JobTypesRegistrationPage.jobRankList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu id="drlJobLevel" partialSubmit="true"
                                                                style="left: 512px; top: 87px; position: absolute; width: 190px" value="#{Organization$JobTypesRegistrationPage.selectedObjectJobLevel.selectedObject}">
                                                                <f:selectItems id="selectRankLevel" value="#{Organization$JobTypesRegistrationPage.jobLevelList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputText id="lblAdditionalSkills"
                                                                style="font-size: 10px; left: 405px; top: 125px; position: absolute" value="Additional Skills:"/>
                                                            <ice:inputTextarea binding="#{Organization$JobTypesRegistrationPage.txtAAdditionalSkill}"
                                                                id="txtAAdditionalSkill" style="left: 513px; top: 125px; position: absolute; width: 190px"/>
                                                            <ice:outputText id="lblConfirmation" rendered="false"
                                                                style="font-size: 14px; left: 40px; top: 0px; position: absolute" value="outputText"/>
                                                            <ice:commandButton action="#{Organization$JobTypesRegistrationPage.btnAddToTable_action}"
                                                                id="btnAddToTable" style="left: 515px; top: 180px; position: absolute" value="Add to table"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputRequest"
                                                            style="height: 326px; left: 9px; top: 264px; overflow: auto; position: absolute; width: 703px" styleClass="insideContainerMain">
                                                            <ice:dataTable id="dataTableAllJobs" style="height: 8px; left: 20px; top: 0px; position: absolute"
                                                                value="#{Organization$JobTypesRegistrationPage.jobTypesDetailList}" var="currentRow" width="669">
                                                                <ice:column id="colDatabaseStatus">
                                                                    <ice:outputText id="txtaForDatabaseStatus" value="#{currentRow['databaseStatus']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextDatabaseStatus" value="Status"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colId">
                                                                    <ice:outputText id="txtaForColumnId" value="#{currentRow['jobId']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextId" value="Code"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colNumberName">
                                                                    <ice:inputText id="txtaForColumnName" value="#{currentRow['jobName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextName" value="Name"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colFullDescription">
                                                                    <ice:inputText id="optTxtForColumnDescription" value="#{currentRow['jobDescription']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextDescription" value="Description"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colResponsiblity">
                                                                    <ice:inputText id="optTxtForColumnResponsiblity" value="#{currentRow['responsiblity']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextResponsiblity" value="Responsiblity"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRank">
                                                                    <ice:selectOneMenu id="drlForColumnRank" partialSubmit="true" value="#{currentRow['rankId']}">
                                                                        <f:selectItems id="selectForColumnRank" value="#{Organization$JobTypesRegistrationPage.jobRankList}"/>
                                                                    </ice:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextRank" value="Rank"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colLevel" style="">
                                                                    <ice:selectOneMenu id="drlForColumnLevel" partialSubmit="true" value="#{currentRow['level']}">
                                                                        <f:selectItems id="selectForColumnLevel" value="#{Organization$JobTypesRegistrationPage.jobLevelList}"/>
                                                                    </ice:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextLevel" value="level"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colShiftOrNormal">
                                                                    <ice:commandLink id="radioGroupShiftOrNormal" value="#{currentRow['shiftOrNormal']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextShiftOrNormal" value="Shift"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colEdit">
                                                                    <ice:commandLink id="cmdLnkOk" value="Ok"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEdit" value="Edit"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRemove">
                                                                    <ice:commandLink action="#{Organization$JobTypesRegistrationPage.cmdLnkRemove_action}"
                                                                        id="cmdLnkRemove" panelConfirmation="pnlConfirmForDelete" value="Remove"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextRemove" value="Remove"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelectorJobType" multiple="false" preStyleOnSelection="true" selectionListener="#{Organization$JobTypesRegistrationPage.rowSelectorJobType_processMyEvent}"/>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style=" height: 54px; margin-left: 15px; left: 20px; top: 640px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Organization$JobTypesRegistrationPage.btnSaveOrUpdate_action}"
                                                                id="btnSaveOrUpdate" style="left: 216px; top: 0px; position: absolute; width: 71px" value="Save Changes"/>
                                                            <ice:commandButton action="#{Organization$JobTypesRegistrationPage.btnReset_action}" id="btnReset"
                                                                style="left: 336px; top: 0px; position: absolute; width: 71px" value="Reset"/>
                                                        </ice:panelLayout>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label
                                                style="margin-left:10px;color:white;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">Bunna Internatinal Bank|Information System Department  |Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Organization$JobTypesRegistrationPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Organization$JobTypesRegistrationPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Organization$JobTypesRegistrationPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Organization$JobTypesRegistrationPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Organization$JobTypesRegistrationPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Organization$JobTypesRegistrationPage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Organization$JobTypesRegistrationPage.outputTextConfirmDelete}" id="outputTextConfirmDelete"
                                            style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Organization$JobTypesRegistrationPage.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Organization$JobTypesRegistrationPage.btnPopupCancelDelete_action}"
                                            id="btnPopupCancelDelete" style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
