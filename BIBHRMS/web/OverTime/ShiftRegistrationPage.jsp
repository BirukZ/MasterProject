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
        <f:loadBundle basename="Localization.HRLocaalization_Shift" var="msgshif"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Shift Registration</title>
                <link HREF="../header_icon.ico" REL="icon"/>
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
                    function EmployeeShiftPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
                <script type="text/javascript">

                    var _gaq = _gaq || [];
                    _gaq.push(['_setAccount', 'UA-24327002-1']);
                    _gaq.push(['_trackPageview']);

                    (function() {
                        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
                        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
                        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
                    })();

                    function plusone_clicked() {
                        $('#thankyou').fadeIn(300);
                    }

                    $(document).ready(function() {
                        $('#floating_timepicker').timepicker({
                            onSelect: function(time, inst) {
                                $('#floating_selected_time').html('You selected ' + time);
                            }
                        });
                        $('#tabs').tabs();
                    });


                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{OverTime$ShiftRegistrationPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{OverTime$ShiftRegistrationPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{OverTime$ShiftRegistrationPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{OverTime$ShiftRegistrationPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{OverTime$ShiftRegistrationPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none; height:117px; ">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200); height: 645px; top: 25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 117px; left: 0px; top: 0px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header"/>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" style="height: 117px" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%"/>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 685px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 675px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 600px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Shift Registration Page"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 649px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{OverTime$ShiftRegistrationPage.pnlGrpPowerAllContent_processMyEvent}"
                                                    id="pnlGrpPowerAllContent" style="height: 622px" styleClass="icePnlGrp filedset_border">
                                                    <ice:panelLayout id="pnlLayoutEmployees" layout="flow" rendered="true"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 415px; margin-left: 15px; left: 20px; top: 54px; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:panelLayout id="pnlLayoutTable"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 237px; margin-left: 10px; left: 14px; top: 144px; overflow: auto; position: absolute; width: 670px" styleClass="insideContainerMain">
                                                            <ice:dataTable binding="#{OverTime$ShiftRegistrationPage.dataTable}" id="dataTable"
                                                                style="height: 8px; left: 0px; top: 0px; overflow: auto; position: absolute; width: 100%"
                                                                value="#{OverTime$ShiftRegistrationPage.emp}" var="currentRow">
                                                                <ice:column id="colSelected" rendered="#{OverTime$ShiftRegistrationPage.selectedColumnRendered}">
                                                                    <ice:selectBooleanCheckbox binding="#{OverTime$ShiftRegistrationPage.ckbForColumnSelected}"
                                                                        disabled="true" id="ckbForColumnSelected" partialSubmit="true" value="#{currentRow['selected']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextSelected" value="Selected"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colEmployeeId">
                                                                    <ice:outputText id="optTxtForEmployeeid" value="#{currentRow['id']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headertextEmployeeId" value="Emp Id"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colDisciplimeName">
                                                                    <ice:outputText id="optTxtForColumnFullName" value="#{currentRow['full_name']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextFullName" value="Full Name"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRepitition">
                                                                    <ice:outputText id="optTxtForColumnDepartmentName" value="#{currentRow['job_position']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextDepartmentName" value="JobPosition"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column binding="#{OverTime$ShiftRegistrationPage.colStartTime}" id="colStartTime">
                                                                    <h:selectBooleanCheckbox binding="#{OverTime$ShiftRegistrationPage.chkShone}" id="chkShone"
                                                                        value="#{currentRow['shift_one']}" valueChangeListener="#{OverTime$ShiftRegistrationPage.chkShone_processValueChange}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextStartTime" value="Sh1"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colEndDate">
                                                                    <h:selectBooleanCheckbox binding="#{OverTime$ShiftRegistrationPage.chkShtow}" id="chkShtow"
                                                                        value="#{currentRow['shift_two']}" valueChangeListener="#{OverTime$ShiftRegistrationPage.chkShtow_processValueChange}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEndDate" value="Sh2"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelectorOverTime9" multiple="false" preStyleOnSelection="true" selectionListener="#{OverTime$ShiftRegistrationPage.rowSelectorOverTime_processMyEvent}"/>
                                                                </ice:column>
                                                                <ice:column id="colEndTime">
                                                                    <h:selectBooleanCheckbox binding="#{OverTime$ShiftRegistrationPage.chkShThree}"
                                                                        id="chkShThree" value="#{currentRow['shift_three']}" valueChangeListener="#{OverTime$ShiftRegistrationPage.chkShThree_processValueChange}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEndTime" value="Sh3"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelectorOverTime4" multiple="false" preStyleOnSelection="true" selectionListener="#{OverTime$ShiftRegistrationPage.rowSelectorOverTime_processMyEvent}"/>
                                                                </ice:column>
                                                                <ice:column id="column1">
                                                                    <h:selectBooleanCheckbox binding="#{OverTime$ShiftRegistrationPage.chkShFour}"
                                                                        id="chkShFour" value="#{currentRow['shift_four']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextStartTime2" value="Sh4"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="columns2">
                                                                    <h:selectBooleanCheckbox binding="#{OverTime$ShiftRegistrationPage.chkShFive}"
                                                                        id="chkShFive" value="#{currentRow['shift_five']}" valueChangeListener="#{OverTime$ShiftRegistrationPage.chkShFive_processValueChange}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextStartTime1" value="Sh5"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column2" rendered="false">
                                                                    <ice:commandLink action="#{OverTime$ShiftRegistrationPage.cmdLnkEdit1_action}"
                                                                        id="cmdLnkEdit1" value="Ok"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEdit111" value="Edit"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:inputText binding="#{OverTime$ShiftRegistrationPage.txtfDepartment}" id="txtfDepartment" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 22px; position: absolute; width: 361px"/>
                                                        <ice:commandButton action="#{OverTime$ShiftRegistrationPage.btnTree_action}" id="btnTree"
                                                            image="/resources/images/pic3-tree-icon.jpg" style="left: 480px; top: 24px; position: absolute" value="Tree"/>
                                                        <ice:panelLayout binding="#{OverTime$ShiftRegistrationPage.panelLayout3}" id="panelLayout3"
                                                            layout="flow" rendered="false"
                                                            style="border-width: 2px; border-style: solid; height: 360px; left: 450px; top: 45px; overflow: scroll; position: absolute; width: 400px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:tree action="#{OverTime$ShiftRegistrationPage.tree1_action}"
                                                                binding="#{OverTime$ShiftRegistrationPage.tree1}" id="tree1"
                                                                style="height: 286px; margin-left: 0px; margin-top: 0px; text-align: left; width: 190px"
                                                                value="#{OverTime$ShiftRegistrationPage.tree1Model.model}" var="item">
                                                                <ice:treeNode id="treeNode1">
                                                                    <f:facet name="icon">
                                                                        <ice:panelGroup id="panelGroup1" style="display: inline;">
                                                                            <ice:graphicImage id="graphicImage1" value="#{item.userObject.icon}"/>
                                                                        </ice:panelGroup>
                                                                    </f:facet>
                                                                    <f:facet name="content">
                                                                        <ice:panelGroup id="panelGroup2" style="display: inline;">
                                                                            <ice:commandLink action="#{OverTime$ShiftRegistrationPage.commandLink1_action}"
                                                                                actionListener="#{OverTime$ShiftRegistrationPage.commandLink1_processAction}"
                                                                                id="commandLink1" partialSubmit="true">
                                                                                <ice:outputText id="outputText2" value="#{item.userObject.text}"/>
                                                                            </ice:commandLink>
                                                                        </ice:panelGroup>
                                                                    </f:facet>
                                                                </ice:treeNode>
                                                            </ice:tree>
                                                        </ice:panelLayout>
                                                        <ice:inputText binding="#{OverTime$ShiftRegistrationPage.txtFrom}" id="txtFrom" style="margin-left: 5px; margin-right: 400px; left: 115px; top: 70px; position: absolute; width: 191px"/>
                                                        <ice:inputText binding="#{OverTime$ShiftRegistrationPage.txtTo}" id="txtTo" style="margin-left: 5px; margin-right: 400px; left: 115px; top: 94px; position: absolute; width: 191px"/>
                                                        <ice:outputLabel id="outputLabel1" style="position: absolute; left: 24px; top: 72px" value="#{msgshif.From}"/>
                                                        <ice:outputLabel id="outputLabel2" style="left: 24px; top: 96px; position: absolute" value="#{msgshif.To}"/>
                                                        <ice:outputLabel id="outputLabel3" style="left: 24px; top: 24px; position: absolute" value="#{msgshif.Department}"/>
                                                        <ice:commandButton action="#{OverTime$ShiftRegistrationPage.btnCalendarSatartDate_action}"
                                                            binding="#{OverTime$ShiftRegistrationPage.btnCalendarSatartDate}" id="btnCalendarSatartDate"
                                                            image="/resources/images/cal_button.gif" immediate="true"
                                                            style="left: 312px; top: 72px; position: absolute" value="submit"/>
                                                        <ice:selectInputDate binding="#{OverTime$ShiftRegistrationPage.calStartDate}" id="calStartDate"
                                                            rendered="false"
                                                            style="left:400px; top: 0px; position: absolute; height:180px; width: 190px; z-index:150"
                                                            value="#{OverTime$ShiftRegistrationPage.selectInputDate1Bean.date1}" valueChangeListener="#{OverTime$ShiftRegistrationPage.calStartDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{OverTime$ShiftRegistrationPage.calendDate}" id="calendDate"
                                                            rendered="false"
                                                            style="left:400px; top: 0px; position: absolute; height:180px; width: 190px; z-index:150"
                                                            value="#{OverTime$ShiftRegistrationPage.selectInputDate1Bean.date1}" valueChangeListener="#{OverTime$ShiftRegistrationPage.calendDate_processValueChange}"/>
                                                        <ice:commandButton action="#{OverTime$ShiftRegistrationPage.btnCalendarEndDate_action}"
                                                            binding="#{OverTime$ShiftRegistrationPage.btnCalendarEndDate}" id="btnCalendarEndDate"
                                                            image="/resources/images/cal_button.gif" immediate="true"
                                                            style="left: 312px; top: 96px; position: absolute" value="submit"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtFrom" id="message1"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 336px; top: 72px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtTo" id="message2"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 336px; top: 96px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtfDepartment" id="message3"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 528px; top: 24px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 30px; margin-left: 15px; left: 20px; top: 510px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{OverTime$ShiftRegistrationPage.btnSave_action}" id="btnSave"
                                                            style="left: 240px; top: -10px; position: absolute; width: 71px" value="Save"/>
                                                        <ice:commandButton action="#{OverTime$ShiftRegistrationPage.btnReset_action}" id="btnReset"
                                                            style="left: 360px; top: -10px; position: absolute; width: 71px" value="Reset"/>
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
                                                href="http://www.google.come" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |informationSystem|Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{OverTime$ShiftRegistrationPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{OverTime$ShiftRegistrationPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{OverTime$ShiftRegistrationPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{OverTime$ShiftRegistrationPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{OverTime$ShiftRegistrationPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
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
