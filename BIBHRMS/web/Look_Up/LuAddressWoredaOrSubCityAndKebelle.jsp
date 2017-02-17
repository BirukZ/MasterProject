<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : ONE
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
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
                    function IncrementSalaryRequest(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
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
                                    style="height: 600px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 600px; left: -4px; position: absolute; width: 213px" styleClass="list_menu">
                                        <ice:panelCollapsible binding="#{Page1.panelCollapsible2}" expanded="true" id="panelCollapsible2" toggleOnClick="true">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup2" styleClass="">
                                                    <ice:outputText id="deaderCommonTaskGroup" value="Common Task "/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid1">
                                                <ice:panelGroup id="lyRegionAndZoneOrCity" style="text-align: left; width: 160px" styleClass="iceDatTblColHdr">
                                                    <ice:commandLink action="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.cmdRegionAndZoneOrCity_action}"
                                                        id="cmdRegionAndZoneOrCity" style="color: rgb(48, 102, 130); font-weight: bold" value="Region And Zone/City"/>
                                                </ice:panelGroup>
                                                <br/>
                                                <ice:panelGroup id="lyEmployeeProfile" style="text-align: left; width: 160px" styleClass="iceDatTblColHdr">
                                                    <ice:commandLink action="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.cmdEmployeeProfile_action}"
                                                        id="cmdEmployeeProfile" style="color: rgb(48, 102, 130); font-weight: bold" value="Woreda/SubCity"/>
                                                </ice:panelGroup>
                                                <br/>
                                                <ice:panelGroup id="lyKebelle" style="text-align: left; width: 160px" styleClass="iceDatTblColHdr">
                                                    <ice:commandLink action="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.cmdKebelle_action}" id="cmdKebelle"
                                                        style="color: rgb(48, 102, 130); font-weight: bold" value="Kebelle"/>
                                                </ice:panelGroup>
                                                <br/>
                                                <ice:panelGroup id="lyRankId" style="text-align: left; width: 160px" styleClass="iceDatTblColHdr">
                                                    <ice:commandLink action="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.cmdRank_action}" id="cmdRank"
                                                        style="color: rgb(48, 102, 130); font-weight: bold" value="Rank And PayGrade"/>
                                                </ice:panelGroup>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup dragListener="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.page_display_processMyEvent}" id="page_display" style="height: 620px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 600px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css" style="height: 580px;">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="Kebelle Registration "/>
                                        </legend>
                                        <ice:panelLayout id="pnProfile" style="height: 579px; left: 0px; top: -20px; position: absolute; width: 100%">
                                            <ice:panelLayout binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.message}" id="message"
                                                style="left: 0px; top: -68px; position: absolute; width: 720px" styleClass="message">
                                                <ice:outputLabel binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.lblFormMessage}" id="lblFormMessage" value="success"/>
                                            </ice:panelLayout>
                                            <ice:outputText binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.lblStatus}" id="lblStatus" rendered="false"
                                                style="left: 235px; top: -25px; position: absolute" value="Status"/>
                                            <ice:panelLayout binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.panelLayout1}" id="panelLayout1"
                                                style="height: 550px; left: 5px; top: 0px; position: absolute; width: 770px" styleClass="collabsable_bg">
                                                <ice:selectOneMenu binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.drlReligon}" id="drlReligon"
                                                    partialSubmit="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 140px; top: 41px; position: absolute; width: 100px"
                                                    value="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.drlReligon_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.region}"/>
                                                </ice:selectOneMenu>
                                                <ice:outputText id="lblReligon" style="font-size: 10px; left: 38px; top: 47px; position: absolute" value="Religon"/>
                                                <ice:outputText id="lblZoneOrCityID1" style="font-size: 10px; left: 414px; top: 47px; position: absolute" value="Zone/City"/>
                                                <ice:selectOneMenu binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.drlZoneOrCity}" id="drlZoneOrCity"
                                                    partialSubmit="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 513px; top: 41px; position: absolute; width: 190px"
                                                    value="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.defaultSelectedData2.selectedObject}" valueChangeListener="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.drlZoneOrCity_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems1" value="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.optZoneCityType}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectOneMenu binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.drlWoreda}" id="drlWoreda"
                                                    partialSubmit="true"
                                                    style="background-color: rgb(242, 246, 240); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 140px; top: 86px; position: absolute; width: 100px;border: 1px solid rgb(115, 179, 206);"
                                                    value="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.selectOneMenu2Bean.selectedObject}" valueChangeListener="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.drlWoreda_processValueChange}">
                                                    <f:selectItems id="selectOneMenu2selectItems" value="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.optWoredaCity}"/>
                                                </ice:selectOneMenu>
                                                <ice:outputText id="lblWoredaSubCity" style="font-size: 10px; left: 38px; top: 92px; position: absolute" value="Woreda/ Sub City "/>
                                                <ice:panelLayout id="panelLayout2" style="border-top: solid orange 1px; height: 400px; left: 0px; top: 140px; position: absolute; width: 100%">
                                                    <ice:outputText id="outputText4" style="font-size: 10px; left: 38px; top: 20px; position: absolute" value="kebelle Name"/>
                                                    <ice:outputText id="lblDescription" style="font-size: 10px; left: 38px; top: 78px; position: absolute" value="Description"/>
                                                    <ice:inputText binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.txtkebeleName}" id="txtkebeleName"
                                                        required="true" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 140px; top: 14px; position: absolute; width: 145px;border: 1px solid rgb(115, 179, 206);"/>
                                                    <ice:inputTextarea binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.txtKabeleDescription}"
                                                        id="txtKabeleDescription" style="background-color: rgb(242, 246, 240); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 68px; left: 140px; top: 59px; position: absolute; width: 566px;border: 1px solid rgb(115, 179, 206);"/>
                                                    <ice:commandButton action="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnAdd_action}"
                                                        binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnAdd}" id="btnAdd"
                                                        style="left: 320px; top: 130px; position: absolute; width: 100px" value="Add"/>
                                                    <ice:panelLayout id="panelLayout16" style="border: 1px solid rgb(204, 204, 204); height: 125px; margin-left: 15px; left: 10px; top: 180px; overflow: auto; position: absolute; width: 732px">
                                                        <ice:dataTable binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.tblWoreda}" id="tblWoreda"
                                                            style="left: 30px; top: 5px; position: absolute; width: 650px" value="#{SessionBean1.optKebele}" var="currentRow">
                                                            <ice:column id="column1" style="text-align: center; width: 50px">
                                                                <ice:outputText id="outputText7" value="#{currentRow['id']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText8" value="ID"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column2" style="text-align: center; width: 100px;font-size: 10px;">
                                                                <ice:outputText id="outputText9" value="#{currentRow['name']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText10" value="Kebele Name"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column3" style="text-align: center; width: 200px;font-size: 10px;">
                                                                <ice:outputText id="outputText11" value="#{currentRow['description']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText12" value="Description"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colEdit" style="text-align: center; width: 100px;font-size: 15px;">
                                                                <ice:commandLink action="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.linkEdit_action}"
                                                                    binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.linkEdit}" id="linkEdit"
                                                                    style="color: #34599c;margin-left: 12px" value="Edit"/>
                                                                <ice:commandLink action="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.linkDelete_action}"
                                                                    id="linkDelete" style="color: rgb(52, 89, 156); margin-left: 10px" value="Delete"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblEdit" value="Edit/Delete"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.panelLayout3}" id="panelLayout3" style="left: 30px; top: 325px; position: absolute">
                                                        <ice:commandButton action="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnSave_action}"
                                                            binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnSave}" id="btnSave"
                                                            style="margin-left: 120px; width: 80px" value="New"/>
                                                        <ice:commandButton action="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnUpdate_action}"
                                                            binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnUpdate}" id="btnUpdate"
                                                            style="margin-left: 50px; width: 80px" value="Edit"/>
                                                        <ice:commandButton action="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnReset_action}"
                                                            binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnReset}" id="btnReset"
                                                            style="margin-left: 50px; width: 80px" value="Reset"/>
                                                        <ice:commandButton action="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnDelete_action}"
                                                            binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnDelete}" id="btnDelete"
                                                            style="margin-left: 50px; width: 80px" value="Delete"/>
                                                    </ice:panelLayout>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtkebeleName" id="message2"
                                                        infoClass="infoMessage" showDetail="true"
                                                        style="font-size: 10px; left: 150px; top: 40px; position: absolute" warnClass="warnMessage"/>
                                                </ice:panelLayout>
                                                <ice:outputText binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.lblErrorMessageForReligion}"
                                                    id="lblErrorMessageForReligion" rendered="false"
                                                    style="color: red; font-size: 10px; font-weight: bold; left: 180px; top: 65px; position: absolute" value="outputText"/>
                                                <ice:outputText binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.lblErrorMessageforZone}"
                                                    id="lblErrorMessageforZone" rendered="false"
                                                    style="color: red; font-size: 10px; font-weight: bold; left: 580px; top: 65px; position: absolute" value="outputText"/>
                                                <ice:outputText binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.lblErrorMessageForWoreda}"
                                                    id="lblErrorMessageForWoreda" rendered="false"
                                                    style="color: red; font-size: 10px; font-weight: bold; left: 180px; top: 113px; position: absolute" value="outputText"/>
                                            </ice:panelLayout>
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
                    <ice:panelPopup autoCentre="true" binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.pnlPopUpMsgConf}" draggable="true"
                        id="pnlPopUpMsgConf" modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 623px">
                        <f:facet name="header">
                            <ice:panelGrid id="panelGridPopUpMsgConf" style="display: block; height: 20px; width: 500px">
                                <ice:outputText id="lblPopUpMsgTitleConf" value="BUNNA INTERNATIONAL BANK Human Resource Management System"/>
                            </ice:panelGrid>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup dragListener="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.panelGroupPopUpMsgBodyConf_processMyEvent}"
                                id="panelGroupPopUpMsgBodyConf" style="display: block; height: 94px; position: relative; width: 586">
                                <ice:commandButton action="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnPopUpNoConf_action}"
                                    binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnPopUpNoConf}" id="btnPopUpNoConf" rendered="false"
                                    style="left: 450px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No" visible="true"/>
                                <ice:commandButton action="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnPopUpYesConf_action}"
                                    binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnPopUpYesConf}" id="btnPopUpYesConf" rendered="true"
                                    style="background-position: 0 100%; background-repeat: no-repeat; left: 320px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                    value="Yes" visible="true"/>
                                <ice:outputText binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.lblPopUpMsgMainConf}" id="lblPopUpMsgMainConf" style="left: 95px; top: 15px; position: absolute; width: 496px"/>
                                <ice:graphicImage height="56" id="gimgPopUpMsgConf" style="left: 10px; top: 15px; position: absolute" value="" width="62"/>
                                <ice:commandButton action="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnOK_action}"
                                    binding="#{Look_Up$LuAddressWoredaOrSubCityAndKebelle.btnOK}" id="btnOK" rendered="true"
                                    style="left: 450px; top: 60px; position: absolute; visibility: visible; width: 70px" value="Ok"/>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
