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
        <f:loadBundle basename="Localization.HRLocalization_Education" var="msgse"/>
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
                    function AgreementAndDutyRegistration(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div style="height: 792px">
                        <ice:panelBorder height="792" id="whole_page" renderCenter="#{Education$InstitutionRegistrationPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Education$InstitutionRegistrationPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Education$InstitutionRegistrationPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Education$InstitutionRegistrationPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Education$InstitutionRegistrationPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblRecordedInstitutions" value="Institutions"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:490px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 485px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{Education$InstitutionRegistrationPage.selectInstitutionList}"
                                                                id="selectInstitutionList" partialSubmit="true" size="6" style="height: 480px; width: 190px"
                                                                value="#{Education$InstitutionRegistrationPage.selectedObjectFromInstitutionList.selectedObject}" valueChangeListener="#{Education$InstitutionRegistrationPage.selectInstitutionList_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Education$InstitutionRegistrationPage.institutionList}"/>
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
                                <ice:panelGroup id="page_display" style="height: 661px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 627px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 640px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Istitution registration"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 601px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Education$InstitutionRegistrationPage.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 574px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout1" style="height: 588px; top: 0px; position: absolute; width: 100%">
                                                        <ice:panelLayout id="pnlLayputRequest" layout="flow"
                                                            style="height: 460px; margin-left: 15px; left: 4px; top: 17px; overflow: auto; position: absolute; width: 703px; -rave-layout: grid"
                                                                styleClass="insideContainerMain">&gt;
                                                           <ice:outputText
                                                                id="lblStatus" style="font-family: 'Cambria'; left: 24px; top: 48px; position: absolute" value="#{msgse.Status}"/>
                                                            <ice:outputText id="lblInEthiopia"
                                                                style="font-family: 'Cambria'; left: 432px; top: 48px; position: absolute" value="#{msgse.InEthiopia}"/>
                                                            <ice:outputText id="lblName"
                                                                style="font-family: 'Cambria'; left: 24px; top: 72px; position: absolute" value="#{msgse.Name}"/>
                                                            <ice:outputText id="lblLocation"
                                                                style="font-family: 'Cambria'; left: 24px; top: 120px; position: absolute" value="#{msgse.Location}"/>
                                                            <ice:outputText id="lblContactPerson"
                                                                style="font-family: 'Cambria'; left: 24px; top: 216px; position: absolute" value="#{msgse.ContactPerson}"/>
                                                            <ice:outputText id="lblPhoneNo"
                                                                style="font-family: 'Cambria'; left: 24px; top: 168px; position: absolute" value="#{msgse.PhoneNum}"/>
                                                            <ice:outputText id="lblEmail"
                                                                style="font-family: 'Cambria'; left: 397px; top: 195px; position: absolute" value="#{msgse.Email}"/>
                                                            <ice:outputText id="lblFax"
                                                                style="font-family: 'Cambria'; left: 24px; top: 192px; position: absolute" value="#{msgse.Fax}"/>
                                                            <ice:outputText id="lblWebSite"
                                                                style="font-family: 'Cambria'; left: 392px; top: 166px; position: absolute" value="#{msgse.Website}"/>
                                                            <ice:outputText id="lblTinNo"
                                                                style="font-family: 'Cambria'; left: 384px; top: 216px; position: absolute" value="#{msgse.TinNumber}"/>
                                                            <ice:outputText id="lblRemark"
                                                                style="font-family: 'Cambria'; left: 24px; top: 264px; position: absolute" value="#{msgse.Remark }"/>
                                                            <ice:outputText id="lblAccredited"
                                                                style="font-family: 'Cambria'; left: 395px; top: 326px; position: absolute" value="#{msgse.Accredited}"/>
                                                            <ice:outputText id="lblTrainingOrEduc"
                                                                style="font-family: 'Cambria'; left: 24px; top: 336px; position: absolute" value="#{msgse.EducationOrTraining}"/>
                                                            <ice:outputText id="lblDescription"
                                                                style="font-family: 'Cambria'; left: 24px; top: 384px; position: absolute" value="#{msgse.Description}"/>
                                                            <ice:inputText binding="#{Education$InstitutionRegistrationPage.txtName}" id="txtName" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 70px; position: absolute; width: 431px"/>
                                                            <ice:inputTextarea binding="#{Education$InstitutionRegistrationPage.txtaLocationDescription}"
                                                                id="txtaLocationDescription"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 59px; left: 142px; top: 94px; position: absolute; width: 431px" valueChangeListener="#{Education$InstitutionRegistrationPage.txtaLocationDescription_processValueChange}"/>
                                                            <ice:inputText binding="#{Education$InstitutionRegistrationPage.txtContactPerson}"
                                                                id="txtContactPerson" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 214px; position: absolute; width: 220px"/>
                                                            <ice:inputText binding="#{Education$InstitutionRegistrationPage.txtPhoneNo}" id="txtPhoneNo"
                                                                immediate="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 166px; position: absolute; width: 220px"/>
                                                            <ice:inputText binding="#{Education$InstitutionRegistrationPage.txtEmail}" id="txtEmail" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 454px; top: 190px; position: absolute; width: 215px"/>
                                                            <ice:inputTextarea binding="#{Education$InstitutionRegistrationPage.txtRemark}" id="txtRemark"
                                                                immediate="true" style="border-width: 1px; border-style: solid; height: 47px; left: 142px; top: 262px; position: absolute; width: 503px"/>
                                                            <ice:inputTextarea binding="#{Education$InstitutionRegistrationPage.txtDescription}"
                                                                id="txtDescription" style="border-width: 1px; border-style: solid; height: 47px; left: 142px; top: 365px; position: absolute; width: 503px"/>
                                                            <ice:inputText binding="#{Education$InstitutionRegistrationPage.txtFax}" id="txtFax" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 190px; position: absolute; width: 220px"/>
                                                            <ice:inputText binding="#{Education$InstitutionRegistrationPage.txtWebsite}" id="txtWebsite" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 454px; top: 166px; position: absolute; width: 215px"/>
                                                            <ice:inputText binding="#{Education$InstitutionRegistrationPage.txtTinNo}" id="txtTinNo" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 454px; top: 214px; position: absolute; width: 215px"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtName" id="message1"
                                                                infoClass="infoMessage"
                                                                style="font-size: 16px; height: 22px; left: 600px; top: 72px; position: absolute; text-align: center; vertical-align: middle; width: 22px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtAddress" id="message2"
                                                                infoClass="infoMessage"
                                                                style="font-size: 16px; height: 22px; left: 600px; top: 120px; position: absolute; text-align: center; vertical-align: middle; width: 22px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtPhoneNo" id="message3"
                                                                infoClass="infoMessage"
                                                                style="font-size: 10px; height: 22px; left: 360px; top: 168px; position: absolute; text-align: center; vertical-align: middle; width: 22px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtEmail" id="message4"
                                                                infoClass="infoMessage"
                                                                style="font-size: 10px; height: 22px; left: 672px; top: 192px; position: absolute; text-align: center; vertical-align: middle; width: 22px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtFax" id="message5"
                                                                infoClass="infoMessage"
                                                                style="font-size: 10px; height: 22px; left: 360px; top: 192px; position: absolute; text-align: center; vertical-align: middle; width: 22px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtWebsite" id="message6"
                                                                infoClass="infoMessage"
                                                                style="font-size: 10px; height: 22px; left: 672px; top: 168px; position: absolute; text-align: center; vertical-align: middle; width: 22px" warnClass="warnMessage"/>
                                                            <ice:selectOneMenu binding="#{Education$InstitutionRegistrationPage.drlStatus}" id="drlStatus"
                                                                partialSubmit="true" style="left: 142px; top: 46px; position: absolute; width: 202px" value="#{Education$InstitutionRegistrationPage.selectedObjectFromStatusList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{Education$InstitutionRegistrationPage.statusList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Education$InstitutionRegistrationPage.drlLocationCategory}"
                                                                id="drlLocationCategory" partialSubmit="true"
                                                                style="left: 478px; top: 46px; position: absolute; width: 193px" value="#{Education$InstitutionRegistrationPage.selectedObjectFromLocationCategoryList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu2selectItems" value="#{Education$InstitutionRegistrationPage.locationCategoryList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Education$InstitutionRegistrationPage.drlEducationOrTraining}"
                                                                id="drlEducationOrTraining" partialSubmit="true"
                                                                style="left: 142px; top: 334px; position: absolute; width: 200px" value="#{Education$InstitutionRegistrationPage.selectedObjectFromEducationOrTrainingList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu3selectItems" value="#{Education$InstitutionRegistrationPage.educationOrTrainingList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Education$InstitutionRegistrationPage.drlAccreditedOrNot}"
                                                                id="drlAccreditedOrNot" partialSubmit="true"
                                                                style="left: 478px; top: 334px; position: absolute; width: 167px" value="#{Education$InstitutionRegistrationPage.selectedObjectFromAccreditedOrNotList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{Education$InstitutionRegistrationPage.accreditionList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlEducationOrTraining"
                                                                id="message7" infoClass="infoMessage"
                                                                style="left: 336px; top: 336px; position: absolute; width: 47px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlAccreditedOrNot"
                                                                id="message8" infoClass="infoMessage"
                                                                style="height: 20px; left: 648px; top: 336px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlStatus" id="message9"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 360px; top: 48px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlLocationCategory"
                                                                id="message10" infoClass="infoMessage"
                                                                style="height: 20px; left: 672px; top: 48px; position: absolute; width: 23px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtTinNo" id="message11"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 672px; top: 216px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="height: 54px; margin-left: 15px; left: 9px; top: 504px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Education$InstitutionRegistrationPage.btnSaveOrUpdate_action}"
                                                                id="btnSaveOrUpdate" style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{Education$InstitutionRegistrationPage.saveOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Education$InstitutionRegistrationPage.btnReset_action}" id="btnReset"
                                                                style="left: 336px; top: 0px; position: absolute; width: 71px" value="#{msgse.btnRest}"/>
                                                            <ice:commandButton action="#{Education$InstitutionRegistrationPage.btnDelete_action}"
                                                                binding="#{Education$InstitutionRegistrationPage.btnDelete}" id="btnDelete"
                                                                style="left: 468px; top: 0px; position: absolute; width: 71px" value="#{msgse.btnDelete}"/>
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
                                                href="http://www.insa.gov.et" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |INFORMATION |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Education$InstitutionRegistrationPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Education$InstitutionRegistrationPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Education$InstitutionRegistrationPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Education$InstitutionRegistrationPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Education$InstitutionRegistrationPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$InstitutionRegistrationPage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="            BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Education$InstitutionRegistrationPage.outputTextConfirmDelete}" id="outputTextConfirmDelete"
                                            style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Education$InstitutionRegistrationPage.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Education$InstitutionRegistrationPage.btnPopupCancelDelete_action}"
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
