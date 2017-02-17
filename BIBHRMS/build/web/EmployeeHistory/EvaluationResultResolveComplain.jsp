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
                        <ice:panelBorder height="480" id="whole_page" renderCenter="#{Organization$JobType.panelBorder1Bean.renderCenter}"
                            renderEast="#{Organization$JobType.panelBorder1Bean.renderEast}" renderNorth="#{Organization$JobType.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Organization$JobType.panelBorder1Bean.renderSouth}" renderWest="#{Organization$JobType.panelBorder1Bean.renderWest}"
                            style="top: 5px; position: relative" styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup dragListener="#{Organization$JobType.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup dragListener="#{EmployeeHistory$EvaluationResultResolveComplain.menu_left_processMyEvent}" id="menu_left" style=" height:100%;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 610px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 608px; left: 5px; position: absolute; width: 213px" styleClass="left_menu">
                                            <!--<ice:panelCollapsible expanded="true" id="pnl_col_SearchEvavResult">
                <f:facet name="header">
                    <ice:panelGroup id="search_Group_HeaderEvaResult">
                        <ice:outputText id="lblSearchAreaEvaResult" value="Search Area"/>
                    </ice:panelGroup>
                </f:facet>
                <ice:panelGrid id="panelGridSearchevaSessionEvaResult">
                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-2px;margin: -5px 0px -5px -10px;padding: 7px; background: #FFF;border: 1px solid #d9d9d9;display: block;float:left;height: 80px; width: 100%">
                        <ice:outputLabel id="lblDateOfAttandanceTaken"
                                         style="font-weight: bold; font-size:12px; color:#e08713; left: 10px; top: 80px; position: absolute; text-align: center; width: 177px" value="Search By Name"/>
                        <ice:selectInputText
                            action="#{EmployeeHistory$EvaluationResultResolveComplain.txtSearchByNameEvaResult_action}"
                            binding="#{EmployeeHistory$EvaluationResultResolveComplain.txtSearchByNameEvaResult}"
                            id="txtSearchByNameEvaResult" immediate="true" listValue="#{ApplicationBean1.matchesListResult}"
                            listVar="employeeList" partialSubmit="true" rows="10"
                            valueChangeListener="#{ApplicationBean1.evaResultUpdateList}" width="180">
                        <f:facet name="selectInputText">
                            <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                <ice:outputText id="lblFullNameAutoCompleteEvaResult" value="#{employeeList.fullName}"/>
                                <ice:outputText id="lblEmployeeIdAutoCompleteEvaResult" value="#{employeeList.empIdentification}"/>
                            </ice:panelGrid>
                        </f:facet>
                        </ice:selectInputText>
                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtSearchByNameEvaResult"
                                     id="message1evaSessionEvaResult" infoClass="infoMessage" warnClass="warnMessage"/>
                        <ice:outputText
                            binding="#{EmployeeHistory$EvaluationResultResolveComplain.outputTextevaSessionEvaResultSerarch}"
                            id="outputTextevaSessionEvaResultSerarch" rendered="false"
                            style="color: red; text-decoration: blink; font-size: 12px; font-weight: bold;" value=""/>
                    </ice:panelGroup>
                </ice:panelGrid>
                </ice:panelCollapsible>-->
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
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationResultResolveComplain.commandLink2_action}"
                                                                    id="commandLink2" style="color:#306682;font-weight:bold" value="Evaluation Result"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationResultResolveComplain.commandLink1_action}"
                                                                    id="commandLink1" style="color:#306682;font-weight:bold" value="Evaluation Criteria"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationResultResolveComplain.commandLink3_action}"
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
                                                    <ice:outputText id="outputText5" value="Text Description"/>
                                                    <ice:panelLayout binding="#{EmployeeHistory$EvaluationResultResolveComplain.panelLayoutEvaSessionResult}"
                                                        id="panelLayoutEvaSessionResult" style="height: 284px; position: inherit; width: 190px">
                                                        <ice:selectOneListbox binding="#{EmployeeHistory$EvaluationResultResolveComplain.selectOneListbox1}"
                                                            id="selectOneListbox1" immediate="true" partialSubmit="true" size="2"
                                                            style="height: 274px; position: inherit; width: 180px"
                                                            value="#{EmployeeHistory$EvaluationResultResolveComplain.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationResultResolveComplain.selectOneListbox1_processValueChange}">
                                                            <f:selectItems id="selectOneListbox1selectItems" value="#{EmployeeHistory$EvaluationResultResolveComplain.sessionResultHistory}"/>
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
                                                <ice:outputLabel value="Evaluation Result Approve/Reject Complain"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 620px; left: 0px; top: -20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="EvaluationResultPG" style="height: 694px" styleClass="filedset_border">
                                                    <ice:panelLayout binding="#{EmployeeHistory$EvaluationResultResolveComplain.pnevaResultMessage}"
                                                        id="pnevaResultMessage" style="left: 172px; top:-36px;position: absolute; height:3px; width: 544px" styleClass="message">
                                                        <h:outputLabel binding="#{EmployeeHistory$EvaluationResultResolveComplain.lblevaResultFormMessage}" id="lblevaResultFormMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyRequestEvaluatorName"
                                                        style="height: 30px; margin-left: 200px; margin-top: -57px; position: absolute; width: 580px" styleClass="">
                                                        <ice:outputText id="lblStatusEvaluator"
                                                            style="font-size: 16px; color: #023369; font-weight:bold; left: 170px; top: 10px; position: absolute" value="Resolver:"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EvaluationResultResolveComplain.lblStatusEvaluatorValue}"
                                                            id="lblStatusEvaluatorValue"
                                                            style="font-size: 12px; color: #dc6a0e; font-weight:bold; font-family: Arial, Helvetica, sans-serif;left: 255px; top: 12px; position: absolute" value="Evaluator's Name"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{EmployeeHistory$EvaluationResultResolveComplain.pnevaResultMessageInfo}"
                                                        id="pnevaResultMessageInfo" style="left: 140px; top:10px;position: absolute; height:4px; width: 544px" styleClass="message2">
                                                        <ice:panelLayout id="pnevaResultMessageInfoPic" style="position: absolute; height:50px; width: 50px" styleClass="messageinfo"/>
                                                        <h:outputLabel binding="#{EmployeeHistory$EvaluationResultResolveComplain.lblevaResultFormMessageInfo}" id="lblevaResultFormMessageInfo"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout
                                                        binding="#{EmployeeHistory$EvaluationResultResolveComplain.panelLayoutTableControllerEvaResultOther}"
                                                        id="panelLayoutTableControllerEvaResultOther"
                                                        style=" width:744; height:250px; left: 17px; top: 250px; overflow: auto; position: absolute;" styleClass="insideContainerMain">
                                                        <ice:dataTable binding="#{EmployeeHistory$EvaluationResultResolveComplain.dataTableEvaResultOther}"
                                                            id="dataTableEvaResultOther" style="left: 0px; top:  -10px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationResultResolveComplain.evaResultOPtOther}" var="currentRow" width="727">
                                                            <ice:column id="columnEvaSessionCriteriaOther">
                                                                <ice:outputText id="outputText1Other" styleClass="insideTextLable" value="#{currentRow['evaCrtName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText2Other" value="Evaluation Criteria"/>
                                                                </f:facet>
                                                                <ice:rowSelector
                                                                    binding="#{EmployeeHistory$EvaluationResultResolveComplain.rowSelectorEvaResult}"
                                                                    id="rowSelectorEvaResult" multiple="false" preStyleOnSelection="true" rendered="false"
                                                                    selectionListener="#{EmployeeHistory$EvaluationResultResolveComplain.rowSelectorEvaResult_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                            <ice:column id="columnEvaSessionResultOther">
                                                                <ice:selectBooleanCheckbox
                                                                    binding="#{EmployeeHistory$EvaluationResultResolveComplain.checkbox1hi1Other}"
                                                                    disabled="true" id="checkbox1hi1Other" immediate="true" partialSubmit="true" value="#{currentRow['selected1']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText4" value="1"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnEvaSessionResult1">
                                                                <ice:selectBooleanCheckbox
                                                                    binding="#{EmployeeHistory$EvaluationResultResolveComplain.checkbox1hi2Other}"
                                                                    disabled="true" id="checkbox1hi2Other" immediate="true" partialSubmit="true" value="#{currentRow['selected2']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText41Other" value="2"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnEvaSessionResult2Other">
                                                                <ice:selectBooleanCheckbox
                                                                    binding="#{EmployeeHistory$EvaluationResultResolveComplain.checkbox1hi3Other}"
                                                                    disabled="true" id="checkbox1hi3Other" immediate="true" partialSubmit="true" value="#{currentRow['selected3']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText42Other" value="3"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnEvaSessionResult3Other">
                                                                <ice:selectBooleanCheckbox
                                                                    binding="#{EmployeeHistory$EvaluationResultResolveComplain.checkbox1hi4Other}"
                                                                    disabled="true" id="checkbox1hi4Other" immediate="true" partialSubmit="true" value="#{currentRow['selected4']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText43Other" value="4"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnEvaSessionResult4Other">
                                                                <ice:selectBooleanCheckbox
                                                                    binding="#{EmployeeHistory$EvaluationResultResolveComplain.checkbox1hi5Other}"
                                                                    disabled="true" id="checkbox1hi5Other" immediate="true" partialSubmit="true" value="#{currentRow['selected5']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText44Other" value="5"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnEvaSessionResultR" rendered="false">
                                                                <ice:inputText
                                                                    binding="#{EmployeeHistory$EvaluationResultResolveComplain.inputTextSelectedValueOther}"
                                                                    id="inputTextSelectedValueOther" immediate="true" partialSubmit="true" rendered="true"
                                                                    style="width:30px;" value="#{currentRow['selectedValue']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText6ROther" value="R"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnEvaSessionRemarkOther">
                                                                <ice:inputTextarea disabled="true" id="inputTextareaEvaSessionRemarkOther" immediate="true"
                                                                    partialSubmit="true"
                                                                    style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); border-color:#86b6d2; font-family: 'Lucida Sans'; height:50px; width:200px; font-size: 11px; font-style: normal; font-weight: lighter; " value="#{currentRow['remark']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText6Other" value="Remark"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnEvaSessionResult3Complain">
                                                                <ice:selectBooleanCheckbox disabled="true" id="checkbox1hi4Complain" immediate="true"
                                                                    partialSubmit="true" value="#{currentRow['selectedComp']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText43Complain" value="Complain"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnEvaSessionComplainRemarkOther">
                                                                <ice:inputTextarea
                                                                    binding="#{EmployeeHistory$EvaluationResultResolveComplain.inputTextareaEvaSessionComplainRemarkOther}"
                                                                    disabled="true" id="inputTextareaEvaSessionComplainRemarkOther" immediate="true"
                                                                    partialSubmit="true"
                                                                    style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); border-color:#86b6d2; font-family: 'Lucida Sans'; height:50px; width:200px; font-size: 11px; font-style: normal; font-weight: lighter; " value="#{currentRow['complainRemark']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText6OtherComplain" value="Complain Remark"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnEvaSessionResult3ComplainApprove">
                                                                <ice:selectBooleanCheckbox
                                                                    binding="#{EmployeeHistory$EvaluationResultResolveComplain.checkbox1hi4ComplainApprove}"
                                                                    id="checkbox1hi4ComplainApprove" immediate="true" partialSubmit="true" value="#{currentRow['selectedAppComp']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText
                                                                        binding="#{EmployeeHistory$EvaluationResultResolveComplain.outputText43ComplainApprove}"
                                                                        id="outputText43ComplainApprove" value="Approve"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnEvaSessionResolverRemarkOther">
                                                                <ice:inputTextarea
                                                                    binding="#{EmployeeHistory$EvaluationResultResolveComplain.inputTextareaEvaSessionResolverRemarkOther}"
                                                                    disabled="false" id="inputTextareaEvaSessionResolverRemarkOther" immediate="true"
                                                                    partialSubmit="true"
                                                                    style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); border-color:#86b6d2; font-family: 'Lucida Sans'; height:50px; width:200px; font-size: 11px; font-style: normal; font-weight: lighter; " value="#{currentRow['resolverRemark']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText6OtherResolver" value="Resolver's Remark"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLOutAutorizer"
                                                        style="height: 150px; margin-left: -3px; margin-top: -5px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationResultResolveComplain.selectOneMenuEvaResult}"
                                                            id="selectOneMenuEvaResult" partialSubmit="true"
                                                            style=" border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width:200px; left: 160px; top: 40px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationResultResolveComplain.defaultSelectedData8.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationResultResolveComplain.selectOneMenuEvaResult_processValueChange}">
                                                            <f:selectItems
                                                                binding="#{EmployeeHistory$EvaluationResultResolveComplain.selectOneMenu1selectItemsEvaResult}"
                                                                id="selectOneMenu1selectItemsEvaResult" value="#{EmployeeHistory$EvaluationResultResolveComplain.resultPurposeForDisplay}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationResultResolveComplain.selectOneMenu1SelectDate}"
                                                            id="selectOneMenu1SelectDate" partialSubmit="true"
                                                            style=" border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width:200px; left: 160px; top: 80px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationResultResolveComplain.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationResultResolveComplain.selectOneMenu1SelectDate_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{EmployeeHistory$EvaluationResultResolveComplain.resultDateForDisplay}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputTextEvaResultEvaluatedBy" style="left: 460px; top: 40px; position: absolute"
                                                            styleClass="insideTextLable" value="Evaluated By:"/>
                                                        <ice:selectOneMenu
                                                            binding="#{EmployeeHistory$EvaluationResultResolveComplain.selectOneMenu1EvaluatorName}"
                                                            id="selectOneMenu1EvaluatorName" partialSubmit="true"
                                                            style=" border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width:160px; left: 570px; top: 40px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationResultResolveComplain.defaultSelectedData13.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationResultResolveComplain.selectOneMenu1EvaluatorName_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems1EvaluatorName" value="#{EmployeeHistory$EvaluationResultResolveComplain.resultResolver}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="selectOneMenuEvaResult"
                                                            id="messageselectOneMenuEvaResult" infoClass="infoMessage"
                                                            style="font-size: 11px; left: 388px; top: 80px; position: absolute; text-decoration: blink; width: 97px" warnClass="warnMessage"/>
                                                        <ice:outputText
                                                            binding="#{EmployeeHistory$EvaluationResultResolveComplain.outputTextselectOneMenuEvaResult}"
                                                            id="outputTextselectOneMenuEvaResult" rendered="false"
                                                            style="color: red; text-decoration: blink; font-size: 11px; font-weight: bold; left: 398px; top: 80px; position: absolute" value=""/>
                                                        <ice:outputText id="outputTextEvaResultPurposeSessionDate"
                                                            style="left: 40px; top: 80px; position: absolute" styleClass="insideTextLable" value="Select Date:"/>
                                                        <ice:outputText id="outputTextEvaResultPurpose" style="left: 40px; top: 40px; position: absolute"
                                                            styleClass="insideTextLable" value="Purpose :"/>
                                                        <ice:outputText id="outputTextEvaResultStartingDate" style="left: 40px; top: 120px; position: absolute"
                                                            styleClass="insideTextLable" value="Starting Date :"/>
                                                        <ice:outputText
                                                            binding="#{EmployeeHistory$EvaluationResultResolveComplain.outputTextEvaResultStartingDateAnswer}"
                                                            id="outputTextEvaResultStartingDateAnswer"
                                                            style="left: 160px; top: 120px; color: rgb(54, 76, 94); position: absolute"
                                                            styleClass="insideInputTextAny1" value="Starting Date :"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationResultResolveComplain.inputTextEvaResultSessionID}"
                                                            id="inputTextEvaResultSessionID" rendered="false" style="left: 160px; top: 160px; color: rgb(54, 76, 94); position: absolute"/>
                                                        <ice:inputText
                                                            binding="#{EmployeeHistory$EvaluationResultResolveComplain.inputTextEvaResultSessionEmpID}"
                                                            id="inputTextEvaResultSessionEmpID" rendered="false" style="left: 560px; top: 160px; color: rgb(54, 76, 94); position: absolute"/>
                                                        <ice:outputText id="outputTextEvaResultAutorized" style="left: 460px; top: 80px; position: absolute"
                                                            styleClass="insideTextLable" value="Autorized By :"/>
                                                        <ice:outputText
                                                            binding="#{EmployeeHistory$EvaluationResultResolveComplain.outputTextEvaResultAutorizedAnswer}"
                                                            id="outputTextEvaResultAutorizedAnswer"
                                                            style="left: 600px; top: 80px; color: rgb(54, 76, 94); position: absolute"
                                                            styleClass="insideInputTextAny1" value="Autorized By :"/>
                                                        <ice:outputText id="outputTextEvaResultEndingDate" style="left: 460px; top: 120px; position: absolute "
                                                            styleClass="insideTextLable" value="Ending Date :"/>
                                                        <ice:outputText
                                                            binding="#{EmployeeHistory$EvaluationResultResolveComplain.outputTextEvaResultEndingDateAnswer}"
                                                            id="outputTextEvaResultEndingDateAnswer"
                                                            style="left: 600px; top: 120px; color: rgb(54, 76, 94); position: absolute"
                                                            styleClass="insideInputTextAny1" value="Ending Date :"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLOutTOBeEvaluated"
                                                        style="height: 60px; margin-left: -3px; margin-top: 160px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:outputText id="outputText19" style="left: 460px; top: 20px; position: absolute"
                                                            styleClass="insideTextLable" value="#{msgsh.dept}"/>
                                                        <ice:outputText id="outputText20" style="left: 40px; top: 20px; position: absolute"
                                                            styleClass="insideTextLable" value="#{msgsh.fullName}"/>
                                                        <ice:outputText
                                                            binding="#{EmployeeHistory$EvaluationResultResolveComplain.outputTextEvaRSessionEmpName}"
                                                            id="outputTextEvaRSessionEmpName"
                                                            style="left: 160px; top: 20px; color: rgb(54, 76, 94); position: absolute"
                                                            styleClass="insideInputTextAnyKey" value="Employee Name"/>
                                                        <ice:outputText
                                                            binding="#{EmployeeHistory$EvaluationResultResolveComplain.outputTextEvaRSessionEmpDepartment}"
                                                            id="outputTextEvaRSessionEmpDepartment"
                                                            style="left: 600px; top: 20px; color: rgb(54, 76, 94); position: absolute"
                                                            styleClass="insideInputTextAny1" value="Department"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLOutResultAverage"
                                                        style="height: 51px; margin-left: -3px; margin-top: 530px; overflow: auto; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:dataTable id="dataTable2" style="left: 0px; top:  -10px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationResultResolveComplain.evaResultOPtAverage}" var="currentRow" width="727">
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
                                                            <ice:column id="column4Biruk">
                                                                <ice:outputText id="outputText11Biruk" style="margin-left: 100px; " value="#{currentRow['percentValue']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText12Biruk" value="PERCENTAGEVALUE"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLOutResultButtons"
                                                        style="height: 45px; margin-left: -3px; margin-top: 610px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:commandButton
                                                            action="#{EmployeeHistory$EvaluationResultResolveComplain.buttonEvaResultComplain_action}"
                                                            binding="#{EmployeeHistory$EvaluationResultResolveComplain.buttonEvaResultComplain}" disabled="true"
                                                            id="buttonEvaResultComplain" partialSubmit="true"
                                                            style="margin-left:230px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Resolve"/>
                                                        <ice:commandButton binding="#{EmployeeHistory$EvaluationResultResolveComplain.buttonEvaResultEdit}"
                                                            id="buttonEvaResultEdit" partialSubmit="true" rendered="false"
                                                            style="margin-left:260px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Edit"/>
                                                        <ice:commandButton binding="#{EmployeeHistory$EvaluationResultResolveComplain.buttonEvaResultUpdate}"
                                                            id="buttonEvaResultUpdate" partialSubmit="true" rendered="false"
                                                            style="margin-left:350px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Update"/>
                                                        <ice:commandButton binding="#{EmployeeHistory$EvaluationResultResolveComplain.buttonEvaResultCancel}"
                                                            id="buttonEvaResultCancel" partialSubmit="true" rendered="false"
                                                            style="margin-left:440px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Cancel"/>
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
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$EvaluationResultResolveComplain.pnMessage}" clientOnly="true"
                            draggable="false" id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{EmployeeHistory$EvaluationResultResolveComplain.modalPnlCloseMesssage_action}"
                                        id="modalPnlCloseMesssage" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{EmployeeHistory$EvaluationResultResolveComplain.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
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