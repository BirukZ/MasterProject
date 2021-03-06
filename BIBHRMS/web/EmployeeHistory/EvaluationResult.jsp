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
                        background-color:#FFF;
                        padding: 13px 13px 13px 52px;
                        background-position: 13px 5px;
                        border: solid 1px #BD8;
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
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div style="width:100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder height="480" id="whole_page" renderCenter="#{EmployeeHistory$EvaluationResult.panelBorder1Bean.renderCenter}"
                            renderEast="#{EmployeeHistory$EvaluationResult.panelBorder1Bean.renderEast}"
                            renderNorth="#{EmployeeHistory$EvaluationResult.panelBorder1Bean.renderNorth}"
                            renderSouth="#{EmployeeHistory$EvaluationResult.panelBorder1Bean.renderSouth}"
                            renderWest="#{EmployeeHistory$EvaluationResult.panelBorder1Bean.renderWest}" style="top: 5px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 117px">
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
                                        style="height: 610px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 608px; left: 5px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_TasksEvaResult">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_headerEvaResult">
                                                        <ice:outputText id="lblCommonTasksEvaResult" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid headerClass="iceDatTblColHdr1" id="commonTasksGroup_Grid" width="100%">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <ice:panelSeries id="Common_Tasks_Series" rows="3" style="width:100%" value="CommonTasks" var="commontasks">
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationResult.commandLink2_action}"
                                                                    id="commandLink2" style="color:#306682;font-weight:bold" value="Evaluation Result"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationResult.commandLink1_action}"
                                                                    id="commandLink1" style="color:#306682;font-weight:bold" value="Evaluation Criteria"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationResult.commandLink3_action}"
                                                                    id="commandLink3" style="color:#306682;font-weight:bold" value="Evaluation Session"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationNavigation.commandLink4_action}"
                                                                    id="commandLink4" style="color:#306682;font-weight:bold" value="View Result"/>
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
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible1">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass="">
                                                        <ice:outputText id="outputText3" value="Evaluation Result History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid1">
                                                    <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationResult.selectOneMenuSessionResultFilter}"
                                                        id="selectOneMenuSessionResultFilter" partialSubmit="true"
                                                        style=" border: 1px solid rgb(115, 179, 206); background-color:#fdfdfd; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width:178px; left: -2px; top: 110px;"
                                                        value="#{EmployeeHistory$EvaluationResult.defaultSelectedData14.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationResult.selectOneMenuSessionResultFilter_processValueChange}">
                                                        <f:selectItems id="selectOneMenu1selectItems1" value="#{EmployeeHistory$EvaluationResult.toFilterResultUsingSession}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:panelLayout binding="#{EmployeeHistory$EvaluationResult.panelLayoutEvaSessionResult}"
                                                        id="panelLayoutEvaSessionResult" style="height: 134px; position: inherit; width: 190px">
                                                        <ice:selectOneListbox binding="#{EmployeeHistory$EvaluationResult.selectOneListbox1}"
                                                            id="selectOneListbox1" immediate="true" partialSubmit="true" size="2"
                                                            style="height: 130px; position: inherit; width: 180px"
                                                            value="#{EmployeeHistory$EvaluationResult.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationResult.selectOneListbox1_processValueChange}">
                                                            <f:selectItems id="selectOneListbox1selectItems" value="#{EmployeeHistory$EvaluationResult.sessionResultHistory}"/>
                                                        </ice:selectOneListbox>
                                                    </ice:panelLayout>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible1ResultComplain">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1ResultComplain" styleClass="">
                                                        <ice:outputText id="outputText3ResultComplain" value="Complains on Evaluation Result"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid1ResultComplain">
                                                    <ice:outputText id="outputText5ResultComplain" value="Text Description"/>
                                                    <ice:panelLayout id="panelLayoutResultComplain" style="height: 134px; position: inherit; width: 190px">
                                                        <ice:selectOneListbox id="selectOneListbox2ResultComplain" partialSubmit="true" size="2"
                                                            style="height: 130px; position: inherit; width: 180px"
                                                            value="#{EmployeeHistory$EvaluationResult.selectOneListbox2Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationResult.selectOneListbox2ResultComplain_processValueChange}">
                                                            <f:selectItems id="selectOneListbox2selectItemsResultComplain" value="#{EmployeeHistory$EvaluationResult.sessionResultHistoryComplained}"/>
                                                        </ice:selectOneListbox>
                                                    </ice:panelLayout>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 710px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 680px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 660px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Evaluation Result "/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 620px; left: 0px; top: -20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="EvaluationResultPG" style="height: 670px">
                                                    <ice:panelLayout binding="#{EmployeeHistory$EvaluationResult.pnevaResultMessage}" id="pnevaResultMessage"
                                                        style="left: 172px; top:-36px;position: absolute; height:3px; width: 544px" styleClass="message">
                                                        <h:outputLabel binding="#{EmployeeHistory$EvaluationResult.lblevaResultFormMessage}" id="lblevaResultFormMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyRequestEvaluatorName"
                                                        style="height: 30px; margin-left: 220px; margin-top: 5px; position: absolute; width: 580px" styleClass="">
                                                        <ice:outputText id="lblStatusEvaluator"
                                                            style="font-size: 16px; color: #023369; font-weight:bold; left: -30px; top: 10px; position: absolute" value="Evaluator:"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EvaluationResult.lblStatusEvaluatorValue}"
                                                            id="lblStatusEvaluatorValue"
                                                            style="font-size: 12px; color: #dc6a0e; font-weight:bold; font-family: Arial, Helvetica, sans-serif;                                                                         left: 70px; top: 12px; position: absolute" value="Evaluator's Name"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{EmployeeHistory$EvaluationResult.pnevaResultMessageInfo}"
                                                        id="pnevaResultMessageInfo" style="left: 140px; top:10px;position: absolute; height:4px; width: 544px" styleClass="insideContainerMain">
                                                        <h:outputLabel binding="#{EmployeeHistory$EvaluationResult.lblevaResultFormMessageInfo}" id="lblevaResultFormMessageInfo"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLayoutTableControllerEvaResultOther"
                                                        style=" width:744px; height:220px; left: 17px; top: 310px; overflow: auto; position: absolute;" styleClass="insideContainerMain">
                                                        <ice:dataTable id="dataTableEvaResultOther" style="left: 0px; top:  -10px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationResult.evaResultOPtOther}" var="currentRow" width="727">
                                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.columnEvaSessionCriteria}" id="columnEvaSessionCriteria">
                                                                <ice:outputText id="outputText1" styleClass="insideTextLable" value="#{currentRow['evaCrtName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText2" value="Evaluation Criteria"/>
                                                                </f:facet>
                                                                <ice:rowSelector binding="#{EmployeeHistory$EvaluationResult.rowSelectorEvaResult}"
                                                                    id="rowSelectorEvaResult" multiple="false" preStyleOnSelection="true" rendered="false"
                                                                    selectionListener="#{EmployeeHistory$EvaluationResult.rowSelectorEvaResult_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.columnEvaSessionResultR}"
                                                                id="columnEvaSessionResultR" rendered="false">
                                                                <ice:inputText binding="#{EmployeeHistory$EvaluationResult.inputTextSelectedValue}"
                                                                    id="inputTextSelectedValue" immediate="true" partialSubmit="true" style="width:30px;" value="#{currentRow['selectedValue']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText6R" value="R"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.columnEvaSessionResult}" id="columnEvaSessionResult">
                                                                <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationResult.checkbox1hi1}"
                                                                    id="checkbox1hi1" immediate="true" partialSubmit="true" value="#{currentRow['selected1']}" valueChangeListener="#{EmployeeHistory$EvaluationResult.checkbox1hi1_processValueChange}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText4" value="1"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.columnEvaSessionResult1}" id="columnEvaSessionResult1">
                                                                <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationResult.checkbox1hi2}"
                                                                    id="checkbox1hi2" immediate="true" partialSubmit="true" value="#{currentRow['selected2']}" valueChangeListener="#{EmployeeHistory$EvaluationResult.checkbox1hi2_processValueChange}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText41" value="2"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.columnEvaSessionResult2}" id="columnEvaSessionResult2">
                                                                <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationResult.checkbox1hi3}"
                                                                    id="checkbox1hi3" immediate="true" partialSubmit="true" value="#{currentRow['selected3']}" valueChangeListener="#{EmployeeHistory$EvaluationResult.checkbox1hi3_processValueChange}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText42" value="3"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.columnEvaSessionResult3}" id="columnEvaSessionResult3">
                                                                <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationResult.checkbox1hi4}"
                                                                    id="checkbox1hi4" immediate="true" partialSubmit="true" value="#{currentRow['selected4']}" valueChangeListener="#{EmployeeHistory$EvaluationResult.checkbox1hi4_processValueChange}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText43" value="4"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.columnEvaSessionResult4}" id="columnEvaSessionResult4">
                                                                <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationResult.checkbox1hi5}"
                                                                    id="checkbox1hi5" immediate="true" partialSubmit="true" value="#{currentRow['selected5']}" valueChangeListener="#{EmployeeHistory$EvaluationResult.checkbox1hi5_processValueChange}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText44" value="5"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.columnEvaSessionRemark}" id="columnEvaSessionRemark">
                                                                <ice:inputTextarea binding="#{EmployeeHistory$EvaluationResult.inputTextareaEvaSessionRemark}"
                                                                    id="inputTextareaEvaSessionRemark" immediate="true" partialSubmit="true"
                                                                    style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); border-color:#86b6d2; font-family: 'Lucida Sans'; height:50px; width:200px; font-size: 11px; font-style: normal; font-weight: lighter; " value="#{currentRow['remark']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText6" value="Remark"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.columnEvaSessionResult3InValid}"
                                                                id="columnEvaSessionResult3InValid" rendered="true">
                                                                <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationResult.checkbox1hi4Invalid}"
                                                                    disabled="false" id="checkbox1hi4Invalid" immediate="true" partialSubmit="true"
                                                                    value="#{currentRow['invalid']}" valueChangeListener="#{EmployeeHistory$EvaluationResult.checkbox1hi4Invalid_processValueChange}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText43Invalid" value="Invalid"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.columnEvaSessionResult3Complain}"
                                                                id="columnEvaSessionResult3Complain" rendered="false">
                                                                <ice:selectBooleanCheckbox disabled="true" id="checkbox1hi4Complain" immediate="true"
                                                                    partialSubmit="true" value="#{currentRow['selectedComp']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText43Complain" value="Complain"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.columnEvaSessionComplainRemarkOther}" id="columnEvaSessionComplainRemarkOther">
                                                                <ice:inputTextarea
                                                                    binding="#{EmployeeHistory$EvaluationResult.inputTextareaEvaSessionComplainRemarkOther}"
                                                                    disabled="true" id="inputTextareaEvaSessionComplainRemarkOther" immediate="true"
                                                                    partialSubmit="true" required="false"
                                                                    style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); border-color:#86b6d2; font-family: 'Lucida Sans'; height:50px; width:200px; font-size: 11px; font-style: normal; font-weight: lighter; " value="#{currentRow['complainRemark']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText6OtherComplain" value="Complain Remark"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.columnEvaSessionResult3ComplainApprove}"
                                                                id="columnEvaSessionResult3ComplainApprove" rendered="false">
                                                                <ice:selectBooleanCheckbox disabled="true" id="checkbox1hi4ComplainApprove" immediate="true"
                                                                    partialSubmit="true" value="#{currentRow['selectedAppComp']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText43ComplainApprove" value="Approve"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.columnEvaSessionResolverRemarkOther}" id="columnEvaSessionResolverRemarkOther">
                                                                <ice:inputTextarea
                                                                    binding="#{EmployeeHistory$EvaluationResult.inputTextareaEvaSessionResolverRemarkOther}"
                                                                    disabled="true" id="inputTextareaEvaSessionResolverRemarkOther" immediate="true"
                                                                    partialSubmit="true" required="false"
                                                                    style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); border-color:#86b6d2; font-family: 'Lucida Sans'; height:50px; width:200px; font-size: 11px; font-style: normal; font-weight: lighter; " value="#{currentRow['resolverRemark']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText6OtherResolver" value="Resolver's Remark"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLOutAutorizer"
                                                        style="height: 120px; margin-left: 20px; margin-top: 50px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationResult.selectOneMenuEvaResult}"
                                                            id="selectOneMenuEvaResult" partialSubmit="true"
                                                            style=" border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width:250px; left: 160px; top: 40px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationResult.defaultSelectedData8.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationResult.selectOneMenuEvaResult_processValueChange}">
                                                            <f:selectItems binding="#{EmployeeHistory$EvaluationResult.selectOneMenu1selectItemsEvaResult}"
                                                                id="selectOneMenu1selectItemsEvaResult" value="#{EmployeeHistory$EvaluationResult.resultPurpose}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="selectOneMenuEvaResult"
                                                            id="messageselectOneMenuEvaResult" infoClass="infoMessage"
                                                            style="font-size: 11px; left: 410px; top: 40px; position: absolute; text-decoration: blink; width: 97px" warnClass="warnMessage"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EvaluationResult.outputTextselectOneMenuEvaResult}"
                                                            id="outputTextselectOneMenuEvaResult" rendered="false"
                                                            style="color: red; text-decoration: blink; font-size: 11px; font-weight: bold; left: 343px; top: 43px; position: absolute" value=""/>
                                                        <ice:outputText id="outputTextEvaResultPurpose" style="left: 40px; top: 40px; position: absolute"
                                                            styleClass="insideTextLable" value="Purpose :"/>
                                                        <ice:outputText id="outputTextEvaResultStartingDate" style="left: 40px; top: 80px; position: absolute"
                                                            styleClass="insideTextLable" value="Starting Date :"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EvaluationResult.outputTextEvaResultStartingDateAnswer}"
                                                            id="outputTextEvaResultStartingDateAnswer"
                                                            style="left: 160px; top:80px; color: rgb(54, 76, 94); position: absolute"
                                                            styleClass="insideInputTextAny1" value="Starting Date :"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationResult.inputTextEvaResultSessionEmpID}"
                                                            id="inputTextEvaResultSessionEmpID" rendered="false" style="left: 560px; top: 120px; color: rgb(54, 76, 94); position: absolute"/>
                                                        <ice:outputText id="outputTextEvaResultAutorized" style="left: 460px; top: 40px; position: absolute"
                                                            styleClass="insideTextLable" value="Autorized By :"/>
                                                        <ice:outputText id="outputTextEvaResultEndingDate" style="left: 460px; top: 80px; position: absolute "
                                                            styleClass="insideTextLable" value="Ending Date :"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EvaluationResult.outputTextEvaResultEndingDateAnswer}"
                                                            id="outputTextEvaResultEndingDateAnswer"
                                                            style="left: 600px; top: 80px; color: rgb(54, 76, 94); position: absolute"
                                                            styleClass="insideInputTextAny1" value="Ending Date :"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EvaluationResult.outputTextEvaResultAutorizedAnswer}"
                                                            id="outputTextEvaResultAutorizedAnswer"
                                                            style="left: 600px; top: 40px; color: rgb(54, 76, 94); position: absolute"
                                                            styleClass="insideInputTextAny1" value="Autorized By :"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{EmployeeHistory$EvaluationResult.panelLOutTOBeEvaluated}"
                                                        id="panelLOutTOBeEvaluated"
                                                        style="height: 120px; margin-left: 20px; margin-top: 175px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:outputText id="outputTextEvaResultToEvaluatedFilter"
                                                            style="left: 40px; top: 10px; position: absolute" styleClass="insideTextLable" value="Filter Employees :"/>
                                                        <ice:selectOneMenu id="selectOneMenu1Filter" partialSubmit="true"
                                                            style=" border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width:300px; left: 220px; top: 10px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationResult.defaultSelectedData13.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationResult.selectOneMenu1Filter_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems1Filter" value="#{EmployeeHistory$EvaluationResult.toFilterEmployeesBy}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputTextEvaResultToEvaluated" style="left: 40px; top: 50px; position: absolute"
                                                            styleClass="insideTextLable" value="Search Employee to Evaluate :"/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationResult.selectOneMenuToBeEvaluated}"
                                                            id="selectOneMenuToBeEvaluated" partialSubmit="true"
                                                            style=" border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width:300px; left: 220px; top: 50px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationResult.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationResult.selectOneMenuToBeEvaluated_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{EmployeeHistory$EvaluationResult.allEmpToBeEvaluated}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText binding="#{EmployeeHistory$EvaluationResult.outputTextselectOneMenuEvaResultEvaluatee}"
                                                            id="outputTextselectOneMenuEvaResultEvaluatee" rendered="false"
                                                            style="color: red; text-decoration: blink; font-size: 11px; font-weight: bold; left: 575px; top: 53px; position: absolute" value=""/>
                                                        <ice:outputText id="outputText19" style="left: 460px; top: 90px; position: absolute"
                                                            styleClass="insideTextLable" value="#{msgsh.dept}"/>
                                                        <ice:outputText id="outputText20" style="left: 40px; top: 90px; position: absolute"
                                                            styleClass="insideTextLable" value="#{msgsh.fullName}"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EvaluationResult.outputTextEvaRSessionEmpName}"
                                                            id="outputTextEvaRSessionEmpName"
                                                            style="left: 160px; top: 90px; color: rgb(54, 76, 94); position: absolute"
                                                            styleClass="insideInputTextAny1" value="Employee Name"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EvaluationResult.outputTextEvaRSessionEmpDepartment}"
                                                            id="outputTextEvaRSessionEmpDepartment"
                                                            style="left: 600px; top: 80px; color: rgb(54, 76, 94); position: absolute"
                                                            styleClass="insideInputTextAny1" value="Department"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLOutResultAverage" layout="flow"
                                                        style="height: 51px; margin-left: 20px; margin-top: 550px; overflow: auto; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:dataTable id="dataTable2" style="left: 0px; top: 0px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationResult.evaResultOPtAverage}" var="currentRow" width="744">
                                                            <ice:column colspan="2" id="column2">
                                                                <ice:outputText id="outputText9Result" style="margin-left: 50px; " value="RESULT"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText8" value=""/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column3">
                                                                <ice:outputText id="outputText9" style="margin-left: 100px; " value="#{currentRow['totalRsult']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText10" value="TOTAL"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column4">
                                                                <ice:outputText id="outputText11" style="margin-left: 100px; " value="#{currentRow['averageResult']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText12" value="AVERAGE"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnBiruk4">
                                                                <ice:outputText id="outputTextBiruk11" style="margin-left: 100px; " value="#{currentRow['percentValue']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextBiruk12" value="PERCENTAGE"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLOutResultButtons" layout="flow"
                                                        style="height: 45px; margin-left: 20px; margin-top: 630px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationResult.buttonEvaResultNew_action}"
                                                            binding="#{EmployeeHistory$EvaluationResult.buttonEvaResultNew}" id="buttonEvaResultNew"
                                                            partialSubmit="true" style="margin-left:80px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="New"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationResult.buttonEvaResultSave_action}"
                                                            binding="#{EmployeeHistory$EvaluationResult.buttonEvaResultSave}" id="buttonEvaResultSave"
                                                            partialSubmit="true" style="margin-left:170px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Save"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationResult.buttonEvaResultEdit_action}"
                                                            binding="#{EmployeeHistory$EvaluationResult.buttonEvaResultEdit}" id="buttonEvaResultEdit"
                                                            partialSubmit="true" style="margin-left:260px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Edit"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationResult.buttonEvaResultUpdate_action}"
                                                            binding="#{EmployeeHistory$EvaluationResult.buttonEvaResultUpdate}" id="buttonEvaResultUpdate"
                                                            partialSubmit="true" style="margin-left:350px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Update"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationResult.buttonEvaResultDelete_action}"
                                                            binding="#{EmployeeHistory$EvaluationResult.buttonEvaResultDelete}" id="buttonEvaResultDelete"
                                                            partialSubmit="true" style="margin-left:440px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Delete"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationResult.buttonEvaResultCancel_action}"
                                                            binding="#{EmployeeHistory$EvaluationResult.buttonEvaResultCancel}" id="buttonEvaResultCancel"
                                                            partialSubmit="true" style="margin-left:530px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Cancel"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationResult.button1_action}"
                                                            binding="#{EmployeeHistory$EvaluationResult.btn_percent_Save}" disabled="true" id="btn_percent_Save"
                                                            style="margin-left:620px; margin-top:10px; width:120;  position: absolute" value="SavePercentValue"/>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: center;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid">
                                        <jsp:directive.include file="/FOOTER.jspf"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$EvaluationResult.evaResultPopUpMsg}" draggable="true"
                            id="evaResultPopUpMsg" modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 623px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridevaResultPopUpMsg" style="display: block; height: 20px; width: 500px">
                                    <ice:outputText id="lblevaResultPopUpMsgTitle" value="BUNNA INTERNATIONAL BANK Human Resource Management System"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupevaResultPopUpMsgBody" style="display: block; height: 94px; position: relative; width: 586">
                                    <ice:commandButton action="#{EmployeeHistory$EvaluationResult.btnevaResultPopUpNo_action}"
                                        binding="#{EmployeeHistory$EvaluationResult.btnevaResultPopUpNo}" id="btnevaResultPopUpNo" rendered="true"
                                        style="left: 510px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No" visible="true"/>
                                    <ice:commandButton action="#{EmployeeHistory$EvaluationResult.btnevaResultPopUpYes_action}"
                                        binding="#{EmployeeHistory$EvaluationResult.btnevaResultPopUpYes}" id="btnevaResultPopUpYes" rendered="true"
                                        style="background-position: 0 100%; background-repeat: no-repeat; left: 430px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                        value="Yes" visible="true"/>
                                    <ice:outputText binding="#{EmployeeHistory$EvaluationResult.lblevaResultPopUpMsgMain}" id="lblevaResultPopUpMsgMain" style="left:95px; top: 30px; position: absolute; width: 496px"/>
                                    <ice:panelLayout id="panelLayoutImageHolderEvaResult" rendered="true"
                                        style=" width:62px; height:56px; left: 10px; top: 15px; position: absolute;" styleClass="popUpBgimage" visible="true"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$EvaluationResult.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{EmployeeHistory$EvaluationResult.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{EmployeeHistory$EvaluationResult.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$EvaluationResult.evaResultPopUpResolveComp}" draggable="true"
                            id="evaResultPopUpResolveComp" modal="true" rendered="false" style="display: block; height: 210px; left: 97px; top: 226px; position: absolute; width: 723px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridevaResultPopUpResolveComp" style="display: block; height: 20px; width: 600px">
                                    <ice:outputText id="lblevaResultPopUpResolveCompTitle" value="Update Resolved Evaluation Result"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupevaResultPopUpResolveCompBody" style="display: block; height: 152px; position: relative; width: 686">
                                    <ice:panelLayout id="panelLayoutRsolvedCompEvaResult"
                                        style=" width:686px; height:100px; left: 0px; top: 0px; overflow: auto; position: absolute;"
                                        styleClass="insideContainerMain" visible="true">
                                        <ice:dataTable id="dataTable1" style="left: 0px; top:-10px; position: absolute;"
                                            value="#{EmployeeHistory$EvaluationResult.evaResultOPtCompResolvePop}" var="currentRow" width="669">
                                            <ice:column id="column1">
                                                <ice:outputText id="outputTextPopEvaCriteria" value="#{currentRow['evaCrtName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText8EvaCriteria" value="Evaluation Criteria"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.column2Sel1}" id="column2Sel1">
                                                <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationResult.outputText9PopSel1}" disabled="true"
                                                    id="outputText9PopSel1" immediate="true" partialSubmit="true" value="#{currentRow['selected1']}" valueChangeListener="#{EmployeeHistory$EvaluationResult.outputText9PopSel1_processValueChange}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText10PopSel1" value="1"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.column3Sel2}" id="column3Sel2">
                                                <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationResult.outputText11PopSel2}" disabled="true"
                                                    id="outputText11PopSel2" immediate="true" partialSubmit="true" value="#{currentRow['selected2']}" valueChangeListener="#{EmployeeHistory$EvaluationResult.outputText11PopSel2_processValueChange}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText12PopSel2" value="2"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.column3Sel3}" id="column3Sel3">
                                                <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationResult.outputText11PopSel3}"
                                                    id="outputText11PopSel3" immediate="true" partialSubmit="true" value="#{currentRow['selected3']}" valueChangeListener="#{EmployeeHistory$EvaluationResult.outputText11PopSel3_processValueChange}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText12PopSel3" value="3"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.column3Sel4}" id="column3Sel4">
                                                <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationResult.outputText11PopSel4}"
                                                    id="outputText11PopSel4" immediate="true" partialSubmit="true" value="#{currentRow['selected4']}" valueChangeListener="#{EmployeeHistory$EvaluationResult.outputText11PopSel4_processValueChange}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText12PopSel4" value="4"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.column3Sel5}" id="column3Sel5">
                                                <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EvaluationResult.outputText11PopSel5}"
                                                    id="outputText11PopSel5" immediate="true" partialSubmit="true" value="#{currentRow['selected5']}" valueChangeListener="#{EmployeeHistory$EvaluationResult.outputText11PopSel5_processValueChange}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText12PopSel5" value="5"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column binding="#{EmployeeHistory$EvaluationResult.column3SelR}" id="column3SelR" rendered="false">
                                                <ice:inputText binding="#{EmployeeHistory$EvaluationResult.outputText11PopSelR}" id="outputText11PopSelR"
                                                    immediate="true" partialSubmit="true" value="#{currentRow['selectedValue']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText12PopSelR" value="R"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="columnEvaSessionRemarkPopUP">
                                                <ice:inputTextarea disabled="true" id="inputTextareaEvaSessionRemarkOtherPop" immediate="true"
                                                    partialSubmit="true"
                                                    style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); border-color:#86b6d2; font-family: 'Lucida Sans'; height:50px; width:200px; font-size: 11px; font-style: normal; font-weight: lighter; " value="#{currentRow['remark']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText6OtherPop" value="Remark"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                    <ice:panelLayout id="panelLayoutRsolvedCompEvaResultButton"
                                        style=" width:686px; height:40px; left: 0px; top: 110px; position: absolute;" styleClass="insideContainerMain" visible="true">
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationResult.btnevaResultPopUpResolveCompCancel_action}"
                                            binding="#{EmployeeHistory$EvaluationResult.btnevaResultPopUpResolveCompCancel}"
                                            id="btnevaResultPopUpResolveCompCancel" rendered="true"
                                            style="left: 100px; top: -4px; position: absolute; visibility: visible; width: 70px" value="Cancel" visible="true"/>
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationResult.btnevaResultPopUpResolveCompUpdate_action}"
                                            binding="#{EmployeeHistory$EvaluationResult.btnevaResultPopUpResolveCompUpdate}"
                                            id="btnevaResultPopUpResolveCompUpdate" rendered="true"
                                            style="background-position: 0 100%; background-repeat: no-repeat; left: 10px; top: -4px; position: absolute; visibility: visible; width: 70px"
                                            value="Update" visible="true"/>
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
