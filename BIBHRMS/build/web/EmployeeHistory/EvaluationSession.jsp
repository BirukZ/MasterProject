<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Profile
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
            function EvaluationNavigation(field){

                if (field.defaultValue == field.value) field.value = '';
                else if (field.value == '') field.value = field.defaultValue;

            }
        </script>
                <link HREF="../FederalIcon.ico" REL="icon"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div style="width:100%">
                        <ice:panelBorder height="480" id="whole_page" renderCenter="#{EmployeeHistory$EvaluationSession.panelBorder1Bean.renderCenter}"
                            renderEast="#{EmployeeHistory$EvaluationSession.panelBorder1Bean.renderEast}"
                            renderNorth="#{EmployeeHistory$EvaluationSession.panelBorder1Bean.renderNorth}"
                            renderSouth="#{EmployeeHistory$EvaluationSession.panelBorder1Bean.renderSouth}"
                            renderWest="#{EmployeeHistory$EvaluationSession.panelBorder1Bean.renderWest}" style="top: 5px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup dragListener="#{EmployeeHistory$EvaluationSession.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup dragListener="#{EmployeeHistory$ComplaintPage_2.menu_left_processMyEvent}" id="menu_left" style=" height:100%;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 612px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 608px; left: 5px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible binding="#{EmployeeHistory$EvaluationSession.pnl_col_Common_Tasks}" expanded="true"
                                                id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid" width="100%">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <ice:panelSeries id="Common_Tasks_Series" rows="3" style="width:100%" value="CommonTasks" var="commontasks">
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationSession.commandLink1_action}"
                                                                    id="commandLink1" style="color:#306682;font-weight:bold" value="Evaluation Session"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationSession.commandLink2_action}"
                                                                    id="commandLink2" style="color:#306682;font-weight:bold" value="Evaluation Result"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationSession.commandLink3_action}"
                                                                    id="commandLink3" style="color:#306682;font-weight:bold" value="Evaluation Criteria"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationNavigation.commandLink4_action}"
                                                                    binding="#{EmployeeHistory$EvaluationSession.commandLink4}" id="commandLink4"
                                                                    style="color:#306682;font-weight:bold" value="View Result"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationNavigation.commandLink5_action}"
                                                                    id="commandLink5" style="color:#306682;font-weight:bold" value="Resolve Result"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationNavigation.commandLink6_action}"
                                                                    id="commandLink6" style="color:#306682;font-weight:bold" value="Evaluation Navigator"/>
                                                            </li>
                                                        </ice:panelSeries>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="panelCollapsibleEvaSessionAuthorizerHistory" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass="">
                                                        <ice:outputText id="outputText3" value="Sessions Started Before"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid1EvaSessionAuthorizerHistory">
                                                    <ice:panelLayout binding="#{EmployeeHistory$EvaluationSession.panelLayoutaEvaSessionAuthorizerHistory}"
                                                        id="panelLayoutaEvaSessionAuthorizerHistory" style="height: 310px; position: inherit; width: 190px">
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationSession.button1AuthorizerHistory_action}"
                                                            binding="#{EmployeeHistory$EvaluationSession.button1AuthorizerHistory}"
                                                            id="button1AuthorizerHistory" partialSubmit="true" value="Show History"/>
                                                        <ice:selectOneListbox
                                                            binding="#{EmployeeHistory$EvaluationSession.selectOneListbox1EvaSessionAuthorizerHistory}"
                                                            id="selectOneListbox1EvaSessionAuthorizerHistory" partialSubmit="true" size="2"
                                                            style="height: 220px; position: inherit; width: 180px"
                                                            value="#{EmployeeHistory$EvaluationSession.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationSession.selectOneListbox1EvaSessionAuthorizerHistory_processValueChange}">
                                                            <f:selectItems
                                                                binding="#{EmployeeHistory$EvaluationSession.selectOneListbox1selectItemsEvaSessionAuthorizerHistory}"
                                                                id="selectOneListbox1selectItemsEvaSessionAuthorizerHistory" value="#{EmployeeHistory$EvaluationSession.sessionAuthorizerHistory}"/>
                                                        </ice:selectOneListbox>
                                                    </ice:panelLayout>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 680px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 680px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 650px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Start New Session "/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 689px; left: 0px; top: -20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{EmployeeHistory$EvaluationSession.RetirementApproval1_processMyEvent}"
                                                    id="RetirementApproval1" style="height: 650px">
                                                    <ice:panelLayout binding="#{EmployeeHistory$EvaluationSession.pnevaEvaSessionMessage}"
                                                        id="pnevaEvaSessionMessage" style="left: 172px; top:-36px;position: absolute; height:3px; width: 544px" styleClass="message">
                                                        <h:outputLabel binding="#{EmployeeHistory$EvaluationSession.lblevaEvaSessionFormMessage}" id="lblevaEvaSessionFormMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLOutEvaSessionAbove"
                                                        style="height: 230px; margin-left: 5px; margin-top: 50px; position: absolute; width: 730px" styleClass="insideContainerMain">
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationSession.inputTextSessionAutorID}" disabled="true"
                                                            id="inputTextSessionAutorID" rendered="false" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 160px; top: 20px; width:150px; position: absolute"/>
                                                        <ice:outputText id="outputTextEvaSessionEmpTitle" style="left: 40px; top: 40px; position: absolute"
                                                            styleClass="insideTextLable" value="Title :"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationSession.inputTextEvaSessionTitle}"
                                                            id="inputTextEvaSessionTitle" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 160px; top: 40px; width:150px; position: absolute"/>
                                                        <ice:outputText id="outputTextEvaSessionJob" style="left: 420px; top: 40px; position: absolute"
                                                            styleClass="insideTextLable" value="Profession :"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationSession.inputTextEvaSessionDepartment}"
                                                            id="inputTextEvaSessionDepartment" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 560px; top: 40px; width:150px; position: absolute"/>
                                                        <ice:outputText id="outputTextEvaSessionAutorized" style="left: 40px; top: 80px; position: absolute"
                                                            styleClass="insideTextLable" value="Auotorized By :"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationSession.inputTextEvaSessionAutorized}"
                                                            id="inputTextEvaSessionAutorized" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 160px; top: 80px; width:150px; position: absolute"/>
                                                        <ice:outputText id="outputTextEvaSessionReferenceNO" style="left: 420px; top: 120px; position: absolute"
                                                            styleClass="insideTextLable" value="Reference Number :"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationSession.inputTextEvaSessionReferenceNO}"
                                                            id="inputTextEvaSessionReferenceNO" partialSubmit="true" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 560px; top: 120px; width:150px; position: absolute"/>
                                                        <ice:outputText id="outputTextEvaSessionReferenceDate"
                                                            style="left: 40px; top: 120px; position: absolute" styleClass="insideTextLable" value="Reference Date :"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationSession.inputTextEvaSessionReferenceDate}"
                                                            id="inputTextEvaSessionReferenceDate" partialSubmit="true"
                                                            style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 160px; top: 120px; width:150px; position: absolute"
                                                            validator="#{EmployeeHistory$EvaluationSession.inputTextEvaSessionReferenceDate_validate}" valueChangeListener="#{EmployeeHistory$EvaluationSession.inputTextEvaSessionReferenceDate_processValueChange}"/>
                                                        <ice:message binding="#{EmployeeHistory$EvaluationSession.message1ReferenceDate}"
                                                            errorClass="errorMessage" fatalClass="fatalMessage" for="inputTextEvaSessionReferenceDate"
                                                            id="message1ReferenceDate" infoClass="infoMessage"
                                                            style="left:  320px; top: 122px; text-decoration: blink; position: absolute" warnClass="warnMessage"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EvaluationSession.outputTextForReferenceDate}"
                                                            id="outputTextForReferenceDate" rendered="false"
                                                            style="color: red; text-decoration: blink; font-size: 10px; font-weight: bold; left:  320px; top: 122px; position: absolute" value=""/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationSession.buttonCalReferenceDate_action}"
                                                            actionListener="#{EmployeeHistory$EvaluationSession.buttonCalReferenceDate_processAction}"
                                                            id="buttonCalReferenceDate" image="/resources/images/cal_icon.JPG" immediate="true"
                                                            partialSubmit="true" style="left:296px; top: 122px; position: absolute" value="submit"/>
                                                        <ice:outputText id="outputTextEvaSessionPurpose" style="left: 420px; top: 80px; position: absolute"
                                                            styleClass="insideTextLable" value="Purpose :"/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationSession.selectOneMenuEvaSession}"
                                                            id="selectOneMenuEvaSession" partialSubmit="true"
                                                            style=" border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width:140px; left: 560px; top: 80px; width:150px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationResult.defaultSelectedData8.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationSession.selectOneMenuEvaSession_processValueChange}">
                                                            <f:selectItems binding="#{EmployeeHistory$EvaluationSession.selectOneMenu1selectItemsEvaSession}"
                                                                id="selectOneMenu1selectItemsEvaSession" value="#{EmployeeHistory$EvaluationSession.sessionCategory}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="selectOneMenuEvaSession"
                                                            id="message1selectOneMenuEvaSession" infoClass="infoMessage"
                                                            style="left:  720px; top: 80px; text-decoration: blink; position: absolute" warnClass="warnMessage"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EvaluationSession.outputTextForselectOneMenuEvaSession}"
                                                            id="outputTextForselectOneMenuEvaSession" rendered="false"
                                                            style="color: red; text-decoration: blink; font-size: 10px; font-weight: bold; left:  720px; top: 80px; position: absolute" value=""/>
                                                        <ice:outputText id="outputTextEvaSessionStartingDate" style="left: 40px; top: 160px; position: absolute"
                                                            styleClass="insideTextLable" value="Session Starting Date :"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationSession.inputTextEvaSessionStartingDate}"
                                                            id="inputTextEvaSessionStartingDate" partialSubmit="true"
                                                            style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 160px; top: 160px; width:150px; position: absolute"
                                                            validator="#{EmployeeHistory$EvaluationSession.inputTextEvaSessionStartingDate_validate}" valueChangeListener="#{EmployeeHistory$EvaluationSession.inputTextEvaSessionStartingDate_processValueChange}"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="inputTextEvaSessionStartingDate"
                                                            id="message1StartingDate" infoClass="infoMessage"
                                                            style="left:  320px; top: 162px; text-decoration: blink; position: absolute" warnClass="warnMessage"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EvaluationSession.outputTextForStartingDate}"
                                                            id="outputTextForStartingDate" rendered="false"
                                                            style="color: red; text-decoration: blink; font-size: 10px; font-weight: bold; left:  320px; top: 162px; position: absolute" value=""/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationSession.buttonCalStartingDate_action}"
                                                            actionListener="#{EmployeeHistory$EvaluationSession.buttonCalStartingDate_processAction}"
                                                            id="buttonCalStartingDate" image="/resources/images/cal_icon.JPG" immediate="true"
                                                            partialSubmit="true" style="left:296px; top: 162px; position: absolute" value="submit"/>
                                                        <ice:outputText id="outputTextEvaSessionEndingDate" style="left: 420px; top: 160px; position: absolute"
                                                            styleClass="insideTextLable" value="Session Ending Date :"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationSession.inputTextEvaSessionEndingDate}"
                                                            id="inputTextEvaSessionEndingDate" partialSubmit="true"
                                                            style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 560px; top: 160px; width:150px; position: absolute"
                                                            validator="#{EmployeeHistory$EvaluationSession.inputTextEvaSessionEndingDate_validate}" valueChangeListener="#{EmployeeHistory$EvaluationSession.inputTextEvaSessionEndingDate_processValueChange}"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="inputTextEvaSessionEndingDate"
                                                            id="message1EndinggDate" infoClass="infoMessage"
                                                            style="left:  720px; top: 156px; text-decoration: blink; position: absolute" warnClass="warnMessage"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EvaluationSession.outputTextForEndingDate}"
                                                            id="outputTextForEndingDate" rendered="false"
                                                            style="color: red; text-decoration: blink; font-size: 9px; font-weight: bold; left:  720px; top: 156px; position: absolute" value=""/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationSession.buttonCalEndingDate_action}"
                                                            id="buttonCalEndingDate" image="/resources/images/cal_icon.JPG" immediate="true"
                                                            partialSubmit="true" style="left:696px; top: 162px; position: absolute" value="submit"/>
                                                        <ice:selectInputDate binding="#{EmployeeHistory$EvaluationSession.calFromDate}" id="calFromDate"
                                                            rendered="false" style="left: 340px; top: 16px; position: absolute; height:212px; width: 190px"
                                                            value="#{EmployeeHistory$EvaluationSession.selectInputDate1Bean.date1}" valueChangeListener="#{EmployeeHistory$EvaluationSession.calFromDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{EmployeeHistory$EvaluationSession.calReferenceDate}"
                                                            id="calReferenceDate" rendered="false"
                                                            style="left: 340px; top: 5px; position: absolute; height:212px; width: 190px"
                                                            value="#{EmployeeHistory$EvaluationSession.selectInputDateBean2.date1}" valueChangeListener="#{EmployeeHistory$EvaluationSession.calReferenceDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{EmployeeHistory$EvaluationSession.calEndingDate}" id="calEndingDate"
                                                            rendered="false" style="left: 700px; top: 5px; position: absolute; height:212px; width: 190px"
                                                            value="#{EmployeeHistory$EvaluationSession.selectInputDateBean3.date1}" valueChangeListener="#{EmployeeHistory$EvaluationSession.calEndingDate_processValueChange}"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationSession.txtStartDate}" id="txtStartDate" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 160px; top: 200px; position: absolute; width: 150px"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationSession.calendarStartDate_action}"
                                                            binding="#{EmployeeHistory$EvaluationSession.calendarStartDate}" id="calendarStartDate"
                                                            image="/resources/images/cal_icon.JPG" immediate="true" partialSubmit="true"
                                                            style="left:296px; top: 200px; position: absolute" value="submit"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationSession.txtEnddate}" id="txtEnddate" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 560px; top: 200px; width:150px; position: absolute"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationSession.calendarEndDate_action}"
                                                            binding="#{EmployeeHistory$EvaluationSession.calendarEndDate}" id="calendarEndDate"
                                                            image="/resources/images/cal_icon.JPG" immediate="true" partialSubmit="true"
                                                            style="left:696px; top: 200px; position: absolute" value="submit"/>
                                                        <ice:outputLabel id="outputLabel1" style="left: 40px; top: 200px; position: absolute" value="Evaluation Start Date"/>
                                                        <ice:outputLabel id="outputLabel2" style="left: 420px; top: 200px; position: absolute" value="Evaluation End Date"/>
                                                        <ice:selectInputDate binding="#{EmployeeHistory$EvaluationSession.calSessionStartDate}"
                                                            id="calSessionStartDate" rendered="false"
                                                            style="left: 340px; top: 36px; position: absolute; height:212px; width: 190px"
                                                            value="#{EmployeeHistory$EvaluationSession.selectInputDateBean4.date1}" valueChangeListener="#{EmployeeHistory$EvaluationSession.calSessionStartDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{EmployeeHistory$EvaluationSession.sessionEndDate}" id="sessionEndDate"
                                                            rendered="false" style="left: 700px; top: 35px; position: absolute; height:212px; width: 190px"
                                                            value="#{EmployeeHistory$EvaluationSession.selectInputDateBean5.date1}" valueChangeListener="#{EmployeeHistory$EvaluationSession.sessionEndDate_processValueChange}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{EmployeeHistory$EvaluationSession.panelLayoutTableControllerSession}"
                                                        id="panelLayoutTableControllerSession"
                                                        style="height: 225px; left: 35px; top: 366px; overflow: auto; position: absolute; width: 730" styleClass="insideContainerMain">
                                                        <ice:dataTable binding="#{EmployeeHistory$EvaluationSession.dataTableEvaSession}"
                                                            id="dataTableEvaSession" style="left: 0px; top:  -10px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationSession.evaSessionOPt}" var="currentRow" width="727">
                                                            <ice:column binding="#{EmployeeHistory$EvaluationSession.columnEvaSessionId}" id="columnEvaSessionId">
                                                                <ice:outputText id="outputText1" value="#{currentRow['evaSessionId']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText2" value="Session ID"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnStartDate">
                                                                <ice:outputText id="outputText3" value="#{currentRow['startDate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText4" value="Session Start Date"/>
                                                                </f:facet>
                                                                <ice:rowSelector binding="#{EmployeeHistory$EvaluationSession.rowSelectorEvaSession}"
                                                                    id="rowSelectorEvaSession" multiple="false" preStyleOnSelection="true"
                                                                    selectionListener="#{EmployeeHistory$EvaluationSession.rowSelectorEvaSession_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                            <ice:column id="columnEndDate">
                                                                <ice:outputText id="outputText5" value="#{currentRow['endDate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextEndDate" value="Session End Date"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnReferenceNo">
                                                                <ice:outputText id="outputText7" value="#{currentRow['referenceNo']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextReferenceNo" value="Reference No"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnReferenceDate">
                                                                <ice:outputText id="outputTextrrd" value="#{currentRow['referenceDate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextReferenceDate" value="Reference Date"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnPurpose">
                                                                <ice:outputText id="outputTextppse" value="#{currentRow['purpose']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextPurpose" value="Purpose"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationSession.columnAuthorId}" id="columnAuthorId">
                                                                <ice:outputText id="outputTextAAI" value="#{currentRow['authorizedEmpID']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextAauthorizedEmpID" value="Autorized By"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationSession.newStartDate}" id="newStartDate">
                                                                <ice:outputText id="newStartDate1" value="#{currentRow['start_new_Date']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="newStartDate2" value="Start Date"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationSession.newEndDate}" id="newEndDate">
                                                                <ice:outputText id="newEndDate1" value="#{currentRow['end_new_Date']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="newEndDate2" value="End Date"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLOutEvaSessionaAdd"
                                                        style="height: 40px; margin-left: 5px; margin-top:310px; position: absolute; width: 730px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationSession.btnNewSessionESession_action}"
                                                            binding="#{EmployeeHistory$EvaluationSession.btnNewSessionESession}" id="btnNewSessionESession"
                                                            partialSubmit="true" style="left: 10px; top: -4px; width:100px; position: absolute" value="Add Session"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLOutEvaSessionSavebtn"
                                                        style="height: 40px; margin-left: 0px; margin-top: 550px; left: 35px; top: 56px; position: absolute; width: 716px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationSession.buttonNewESession_action}"
                                                            binding="#{EmployeeHistory$EvaluationSession.buttonNewESession}" id="buttonNewESession"
                                                            partialSubmit="true" style="margin-left:80px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="New"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationSession.buttonStartESession_action}"
                                                            binding="#{EmployeeHistory$EvaluationSession.buttonStartESession}" id="buttonStartESession"
                                                            partialSubmit="true" style="margin-left:170px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Start"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationSession.buttonEditESession_action}"
                                                            binding="#{EmployeeHistory$EvaluationSession.buttonEditESession}" id="buttonEditESession"
                                                            partialSubmit="true" style="margin-left:260px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Edit"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationSession.buttonUpdateESession_action}"
                                                            binding="#{EmployeeHistory$EvaluationSession.buttonUpdateESession}" id="buttonUpdateESession"
                                                            partialSubmit="true" style="margin-left:350px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Update"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationSession.buttonDeleteESession_action}"
                                                            binding="#{EmployeeHistory$EvaluationSession.buttonDeleteESession}" id="buttonDeleteESession"
                                                            partialSubmit="true" style="margin-left:440px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Delete"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationSession.buttonResetESession_action}"
                                                            binding="#{EmployeeHistory$EvaluationSession.buttonResetESession}" id="buttonResetESession"
                                                            partialSubmit="true" style="margin-left:530px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Cancel"/>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
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
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$EvaluationSession.evaSessionPopUpMsg}" draggable="true"
                            effect="#{EmployeeHistory$EvaluationSession.evaSessionPopeffectWindow}" id="evaSessionPopUpMsg" modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 200px; position: absolute; width: 623px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridevaSessionPopUpMsg" style="display: block; height: 20px; width: 623px">
                                    <ice:outputText id="lblevaSessionPopUpMsgTitle" value="HoPR Human Resource Management System"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupEvaSessionPopUpMsgBody" style="display: block; height: 94px; position: relative; width: 586">
                                    <ice:commandButton action="#{EmployeeHistory$EvaluationSession.btnevaSessionPopUpNo_action}"
                                        binding="#{EmployeeHistory$EvaluationSession.btnevaSessionPopUpNo}" id="btnevaSessionPopUpNo" rendered="true"
                                        style="left: 510px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No" visible="true"/>
                                    <ice:commandButton action="#{EmployeeHistory$EvaluationSession.btnevaSessionPopUpYes_action}"
                                        binding="#{EmployeeHistory$EvaluationSession.btnevaSessionPopUpYes}" id="btnevaSessionPopUpYes" rendered="true"
                                        style="background-position: 0 100%; background-repeat: no-repeat; left: 430px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                        value="Yes" visible="true"/>
                                    <ice:outputText binding="#{EmployeeHistory$EvaluationSession.lblevaSessionPopUpMsgMain}" id="lblevaSessionPopUpMsgMain" style="left:95px; top: 30px; position: absolute; width: 496px"/>
                                    <ice:panelLayout id="panelLayoutSessionImageHolder" rendered="true"
                                        style=" width:62; height:56px; left: 10px; top: 15px; position: absolute;" styleClass="popUpBgimage" visible="true"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body"/>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$EvaluationSession.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{EmployeeHistory$EvaluationSession.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{EmployeeHistory$EvaluationSession.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <div class="some" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
                            <input id="cal_day_names" type="hidden" value="ሰ,ማ,ረ,ሐ,ዓ,ቅ,እ"/>
                            <input id="cal_month_names" type="hidden" value="መስከረም,ጥቅምት,ህዳር,ታህሳስ,ጥር,የካቲት,መጋቢት,ሚያዝያ,ግንቦት,ሰኔ,ሀምሌ,ነሀሴ,ጷግሜ"/>
                        </div>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
