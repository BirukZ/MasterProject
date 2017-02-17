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
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
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
                    function JobTypesPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1000px" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Organization$JobTypesPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Organization$JobTypesPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Organization$JobTypesPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Organization$JobTypesPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Organization$JobTypesPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
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
                                <ice:panelGroup id="menu_left" style="height: 551px">
                                    <ice:panelLayout id="left_menu1" layout="flow" style="height: 500px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 500px; left: -4px; position: absolute; width: 213px" styleClass="left_menu">
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
                                                            <ice:commandLink action="#{Organization$JobTypesPage.lnkOrganizationStructure_action}"
                                                                id="lnkOrganizationStructure" style="color:#306682;font-weight:bold" value="organization Structure"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Organization$JobTypesPage.lnkJobtypeQualification_action}"
                                                                id="lnkJobtypeQualification" style="color:#306682;font-weight:bold" value="Jobtype Qualification"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible id="panelCollapsible1">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass="">
                                                        <ice:outputText id="outputText1" value="Search By Job Name"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid2">
                                                    <ice:selectInputText action="#{Organization$JobTypesPage.txtSearchByName1_action}" id="txtSearchByName"
                                                        listValue="#{Organization$JobTypesPage.list}" listVar="jobList" partialSubmit="true" rows="5"
                                                        style="left: 0px; top: 0px; position: relative; width: 300px" valueChangeListener="#{Organization$JobTypesPage.txtSearchByName_processValueChange}">
                                                        <f:facet name="selectInputText">
                                                            <ice:panelGrid columnClasses="empIdCol,fullNameCol" columns="2">
                                                                <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{jobList.jobId}"/>
                                                                <ice:outputText id="lblFullNameAutoComplete2" value="#{jobList.jobName}"/>
                                                            </ice:panelGrid>
                                                        </f:facet>
                                                    </ice:selectInputText>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="Pending"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:350px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 350px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{Organization$JobTypesPage.selectJobTypesList}"
                                                                id="selectJobTypesList" partialSubmit="true" size="6" style="height: 340px; width: 190px"
                                                                value="#{Organization$JobTypesPage.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Organization$JobTypesPage.selectJobTypesList_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Organization$JobTypesPage.jobTypesList}"/>
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
                                <ice:panelGroup id="page_display" style="height: 600px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 531px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 560px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Job Defiantion "/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 529px; left: 0px; top: 50px; position: absolute; width: 100%">
                                                <ice:panelGroup id="pnlLayoutAttributes" style="height: 465px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayoutOne" style="height: 464px; top: 0px; position: absolute; width: 100%">
                                                        <ice:panelLayout id="PanelLayOutJobAtrributes"
                                                            style="height: 371px; margin-left: 15px; margin-top: 40px; top: -27px; position: absolute; width: 719px" styleClass="insideContainerMain">
                                                            <ice:outputText id="lblJobCodeDescription"
                                                                style="font-size: 10px; left: 38px; top: 158px; position: absolute" value="Description"/>
                                                            <ice:inputText binding="#{Organization$JobTypesPage.txtJobCode}" id="txtJobCode" style="left: 146px; top: 15px; position: absolute; width: 186px"/>
                                                            <ice:inputTextarea binding="#{Organization$JobTypesPage.txtaJobDescription}" id="txtaJobDescription" style="left: 144px; top: 157px; position: absolute; width: 505px"/>
                                                            <ice:outputText id="lblJobName" style="font-size: 10px; left: 34px; top: 55px; position: absolute" value=" Job  Name:"/>
                                                            <ice:inputTextarea binding="#{Organization$JobTypesPage.txtaJobName}" id="txtaJobName" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 145px; top: 50px; position: absolute; width: 507px"/>
                                                            <ice:outputText id="lblresponsibility"
                                                                style="font-size: 10px; left: 40px; top: 319px; position: absolute" value="Responsibility:"/>
                                                            <ice:inputTextarea binding="#{Organization$JobTypesPage.txtaJobResponsiblity}"
                                                                id="txtaJobResponsiblity" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 145px; top: 302px; position: absolute; width: 506px"/>
                                                            <ice:outputText id="lblRank" style="font-size: 10px; left: 36px; top: 116px; position: absolute" value="Rank:"/>
                                                            <ice:outputText id="lblCode" style="font-size: 10px; left: 39px; top: 14px; position: absolute" value="Code :"/>
                                                            <ice:outputText id="lblLevel" style="font-size: 10px; left: 430px; top: 113px; position: absolute" value="Level :"/>
                                                            <ice:selectOneMenu binding="#{Organization$JobTypesPage.drlRank}" id="drlRank" partialSubmit="true"
                                                                style="left: 142px; top: 118px; position: absolute; width: 190px" value="#{Organization$JobTypesPage.selectedObjectJobRank.selectedObject}">
                                                                <f:selectItems id="selectOneRankXX" value="#{Organization$JobTypesPage.jobRankList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Organization$JobTypesPage.drlJobLevel}" id="drlJobLevel"
                                                                partialSubmit="true" style="left: 493px; top: 113px; position: absolute; width: 155px" value="#{Organization$JobTypesPage.selectedObjectJobLevel.selectedObject}">
                                                                <f:selectItems id="selectRankLevel" value="#{Organization$JobTypesPage.jobLevelList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputText id="lblAdditionalSkills"
                                                                style="font-size: 10px; left: 39px; top: 236px; position: absolute" value="Additional Skills:"/>
                                                            <ice:inputTextarea binding="#{Organization$JobTypesPage.txtAAdditionalSkill}"
                                                                id="txtAAdditionalSkill" style="left: 144px; top: 226px; position: absolute; width: 506px"/>
                                                            <ice:outputText id="lblConfirmation" rendered="false"
                                                                style="font-size: 14px; left: 40px; top: 0px; position: absolute" value="outputText"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="height: 54px; margin-left: 15px; left: 0px; top: 401px; overflow: auto; position: absolute; width: 718px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Organization$JobTypesPage.btnSaveOrUpdate_action}" id="btnSaveOrUpdate"
                                                                style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{Organization$JobTypesPage.saveOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Organization$JobTypesPage.btnDelete_action}"
                                                                binding="#{Organization$JobTypesPage.btnDelete}" id="btnDelete" rendered="false"
                                                                style="left: 317px; top: -1px; position: absolute; width: 71px" value="Delete"/>
                                                            <ice:commandButton action="#{Organization$JobTypesPage.btnReset_action}" id="btnReset"
                                                                style="left: 420px; top: 0px; position: absolute; width: 71px" value="Reset"/>
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
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">Bunna International Bank |Information System Department  |Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Organization$JobTypesPage.pnlPopupSuccessOrFailure}" clientOnly="true" draggable="false"
                            id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Organization$JobTypesPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Organization$JobTypesPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Organization$JobTypesPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Organization$JobTypesPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Organization$JobTypesPage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Organization$JobTypesPage.outputTextConfirmDelete}" id="outputTextConfirmDelete"
                                            style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Organization$JobTypesPage.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Organization$JobTypesPage.btnPopupCancelDelete_action}" id="btnPopupCancelDelete"
                                            style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
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
