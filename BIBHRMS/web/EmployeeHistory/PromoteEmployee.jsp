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
                <ice:outputStyle href="../resources/ETH/KAMSI_CAL_STYLE.css" id="outputStyle22"/>
                <script src="../resources/ETH/KAMSI_CAL_SCRIPT.js"></script>
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
                                        style="height: 600px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 600px; left: 0px; position: absolute; width: 213px" styleClass="left_menu">
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
                                                    <ice:selectOneListbox binding="#{EmployeeHistory$PromoteEmployee.selectOneListbox1}" id="selectOneListbox1"
                                                        partialSubmit="true" size="2" style="height:100px; border: 1px solid #73b3ce;"
                                                        value="#{EmployeeHistory$PromoteEmployee.defaultSelectedData7.selectedObject}" valueChangeListener="#{EmployeeHistory$PromoteEmployee.selectOneListbox1_processValueChange}">
                                                        <f:selectItems id="selectOneListbox1selectItems1" value="#{EmployeeHistory$PromoteEmployee.newPromotionRequestsDates}"/>
                                                    </ice:selectOneListbox>
                                                    <ice:panelTabSet id="panelTabSet1" style="width:100%" tabPlacement="Top">
                                                        <ice:panelTab id="tabinbox" label="In Box">
                                                            <ice:panelLayout id="panelLayout2" style="position: inherit; width: 100%; height: 100%;">
                                                                <ice:commandButton action="#{EmployeeHistory$PromoteEmployee.buttonViewAll_action}"
                                                                    binding="#{EmployeeHistory$PromoteEmployee.buttonViewAll}" id="buttonViewAll" value="View All"/>
                                                                <ice:selectOneListbox
                                                                    binding="#{EmployeeHistory$PromoteEmployee.selectOneListbox2RequestForPromo}"
                                                                    id="selectOneListbox2RequestForPromo" partialSubmit="true" size="2"
                                                                    style="height:150px; border: 1px solid #73b3ce;"
                                                                    value="#{EmployeeHistory$PromoteEmployee.selectOneListbox2Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$PromoteEmployee.selectOneListbox2RequestForPromo_processValueChange}">
                                                                    <f:selectItems id="selectOneListbox2selectItems" value="#{EmployeeHistory$PromoteEmployee.newPromotionResponsedApprove}"/>
                                                                </ice:selectOneListbox>
                                                            </ice:panelLayout>
                                                        </ice:panelTab>
                                                    </ice:panelTabSet>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="panelCollapsibleHistory">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup4History" styleClass="">
                                                        <ice:outputText id="lblSearchHistory" value="Promotion History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid2History">
                                                    <ice:panelLayout id="panelLayout2IndividualsHistory" style="position: inherit; width: 100%; height: 100%;">
                                                        <ice:outputText id="lblPromotedEmps" style=" color:#ba7109 " value="Promoted Employees"/>
                                                        <ice:selectOneListbox binding="#{EmployeeHistory$PromoteEmployee.selectOneListbox1IndividualHistory}"
                                                            id="selectOneListbox1IndividualHistory" partialSubmit="true" size="2"
                                                            style="height:110px; border: 1px solid #73b3ce; width:180px;"
                                                            value="#{EmployeeHistory$PromoteEmployee.defaultSelectedData5.selectedObject}" valueChangeListener="#{EmployeeHistory$PromoteEmployee.selectOneListbox1IndividualHistory_processValueChange}">
                                                            <f:selectItems id="selectOneListbox1selectItems" value="#{EmployeeHistory$PromoteEmployee.promotedIndividuals}"/>
                                                        </ice:selectOneListbox>
                                                    </ice:panelLayout>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 800px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 750px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 770px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Promote Approved Employees"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 730px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelLayout id="PanelLayOutPromotionRequesters"
                                                    style="height: 250px; margin-left: 15px; margin-top: -5px; top: 40px; overflow: auto; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                    <ice:dataTable binding="#{EmployeeHistory$PromoteEmployee.dataTable1}" id="dataTable1"
                                                        style="left: 0px; top: -10px; position: absolute"
                                                        value="#{EmployeeHistory$PromoteEmployee.requestersForPromotion}" var="currentRow" width="727">
                                                        <ice:column id="column4">
                                                            <ice:outputText id="outputText2" value="#{currentRow['fullName']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText3" styleClass="insideInputTableHeader" value="Full Name"/>
                                                            </f:facet>
                                                            <ice:rowSelector binding="#{EmployeeHistory$PromoteEmployee.rowSelectorPromoteEmployee}"
                                                                id="rowSelectorPromoteEmployee" multiple="false" preStyleOnSelection="true"
                                                                selectionListener="#{EmployeeHistory$PromoteEmployee.rowSelectorPromoteEmployee_processMyEvent}"
                                                                toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                        </ice:column>
                                                        <ice:column id="column5EducTypeDesc">
                                                            <ice:outputText id="outputText4EducTypeDesc" value="#{currentRow['jobDescription']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText5EducTypeDesc" styleClass="insideInputTableHeader" value="Job Description"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column55EducTypeDesc">
                                                            <ice:outputText id="outputText4Edu3cTypeDesc" value="#{currentRow['educLevelId']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText5Educ3TypeDesc" styleClass="insideInputTableHeader" value="Education"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column5" rendered="false">
                                                            <ice:outputText id="outputText4" value="#{currentRow['qualification']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText5" styleClass="insideInputTableHeader" value="Qualification"/>
                                                            </f:facet>
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
                                                        <ice:column id="column6Exp3erience">
                                                            <ice:outputText id="outp3utText6Experience" value="#{currentRow['relatExp']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText13Ex3perience" styleClass="insideInputTableHeader" value="Experience"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column6EducLevelDescPercent">
                                                            <ice:outputText id="outputText6EducLevelDescPercent" value="#{currentRow['toalExamResult']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText13EducLevelDescPercent" styleClass="insideInputTableHeader" value="%Exame Result"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column6ExperiencePercent">
                                                            <ice:outputText id="outputText6ExperiencePercent" value="#{currentRow['promotionPercentageValue']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText13ExperiencePercent" styleClass="insideInputTableHeader" value="%Performance"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column6PerformancePercent">
                                                            <ice:outputText id="outputText6PerformancePercent" value="#{currentRow['employeeDisciplineResult']}"/>
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
                                                <ice:panelLayout id="PanelLayOutPromoteEmployeeSetting"
                                                    style="height: 300px; margin-left: 15px; margin-top: 260px; overflow: auto; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                    <ice:panelLayout id="PanelLayOutPromoteEmployeeStatus"
                                                        style="height: 30px; margin-left: 10px; margin-top: 5px; overflow: auto; position: absolute; width: 724px" styleClass="insideContainerMainPromo">
                                                        <ice:outputText binding="#{EmployeeHistory$PromoteEmployee.outputTextEmpInfo}" id="outputTextEmpInfo"
                                                            style="color: #053868; font-size: 14px; margin-left: 200px; margin-top: 5px;  position: absolute;" value=""/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="PanelLayOutPromoteEmployeePayGrade"
                                                        style="height: 245px; margin-left: 10px; margin-top: 45px; overflow: auto; position: absolute; width: 352px" styleClass="insideContainerMainPromo">
                                                        <ice:outputText id="outputTextLeftJobCode"
                                                            style="font-size: 13px; margin-left: 10px; margin-top: 80px; position: absolute" value="Job description :"/>
                                                        <ice:inputText binding="#{EmployeeHistory$PromoteEmployee.inputTextJobCode}" disabled="true"
                                                            id="inputTextJobCode" style="border-style: none none solid none; background-color: rgb(246, 247, 247); border-bottom-color: rgb(0, 0, 0); border-bottom-width: 1px; color: rgb(0, 0, 0); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 110px; top: 80px; position: absolute; width: 200px"/>
                                                        <ice:inputText binding="#{EmployeeHistory$PromoteEmployee.inputTextJobCodeID}" disabled="true"
                                                            id="inputTextJobCodeID" rendered="false" style="border: none; border-bottom:1px solid #000000; background-color: #f6f7f7; color: #000000; font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 0px; position: absolute; width: 200px"/>
                                                        <ice:outputText id="outputTextRightRank"
                                                            style="font-size: 13px; margin-left: 10px; margin-top: 120px; position: absolute" value="Rank: "/>
                                                        <ice:inputText binding="#{EmployeeHistory$PromoteEmployee.inputTextRank}" disabled="true"
                                                            id="inputTextRank" style="border-style: none none solid none; background-color: rgb(246, 247, 247); border-bottom-color: rgb(0, 0, 0); border-bottom-width: 1px; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 110px; top: 120px; position: absolute; width: 200px"/>
                                                        <ice:outputText id="outputTextRightPayGrade"
                                                            style="font-size: 13px; margin-left: 10px; margin-top: 160px; position: absolute" value="Pay Grade: "/>
                                                        <ice:inputText binding="#{EmployeeHistory$PromoteEmployee.inputTextPayGrade}" disabled="true"
                                                            id="inputTextPayGrade" style="border-style: none none solid none; background-color: rgb(246, 247, 247); border-bottom-color: rgb(0, 0, 0); border-bottom-width: 1px; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 110px; top: 160px; position: absolute; width: 200px"/>
                                                        <ice:outputText id="outputTextRightSalary"
                                                            style="font-size: 13px; margin-left: 10px; margin-top: 200px; position: absolute" value="Salary: "/>
                                                        <ice:inputText binding="#{EmployeeHistory$PromoteEmployee.inputTextSalary}" disabled="true"
                                                            id="inputTextSalary" style="border-style: none none solid none; background-color: rgb(246, 247, 247); border-bottom-color: rgb(0, 0, 0); border-bottom-width: 1px; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 110px; top: 200px; position: absolute; width: 200px"/>
                                                        <ice:outputText id="outputText7"
                                                            style="font-size: 13px; margin-left: 10px; margin-top: 35px; position: absolute" value="Department"/>
                                                        <ice:outputText binding="#{EmployeeHistory$PromoteEmployee.lblFromDepartment}" id="lblFromDepartment"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 50px; left: 110px; top: 10px; position: absolute; width: 240px" value="outputText"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="PanelLayOutPromoteEmployeePayGradeTobe"
                                                        style="border-left: solid 1px solid  #b0c6db 1px; height: 245px; margin-left: 380px; margin-top: 45px; overflow: auto; position: absolute; width: 360px" styleClass="insideContainerMainPromo">
                                                        <ice:outputText id="outputTextLeftJobCodeActual"
                                                            style="font-size: 13px; margin-left: 10px; margin-top: 80px; position: absolute" value="Job description : "/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$PromoteEmployee.drlJobCode}" id="drlJobCode"
                                                            partialSubmit="true" rendered="false"
                                                            style="border-style: none none solid none; background-color: rgb(246, 247, 247); border-bottom-color: rgb(0, 0, 0); border-bottom-width: 1px; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 120px; margin-top: 80px; position: absolute; width: 200px" value="#{EmployeeHistory$PromoteEmployee.selectOneMenu1Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems3" value="#{EmployeeHistory$PromoteEmployee.listOfJobType}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputTextActual"
                                                            style="font-size: 13px; margin-left: 10px; margin-top: 120px; position: absolute" value="Rank: "/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$PromoteEmployee.drlToRank}" id="drlToRank"
                                                            partialSubmit="true" rendered="false"
                                                            style="border-style: none none solid none; background-color: rgb(246, 247, 247); border-bottom-color: rgb(0, 0, 0); border-bottom-width: 1px; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 120px; margin-top: 120px; position: absolute; width: 200px"
                                                            value="#{EmployeeHistory$PromoteEmployee.defaultSelectedData1.selectedObject}" valueChangeListener="#{EmployeeHistory$PromoteEmployee.drlToRank_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems1" value="#{EmployeeHistory$PromoteEmployee._jobRank}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputTextRightPayGradeActual"
                                                            style="font-size: 13px; margin-left: 10px; margin-top: 160px; position: absolute" value="Pay Grade: "/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$PromoteEmployee.drlToPayGrade}" id="drlToPayGrade"
                                                            partialSubmit="true" rendered="false"
                                                            style="border-style: none none solid none; background-color: rgb(246, 247, 247); border-bottom-color: rgb(0, 0, 0); border-bottom-width: 1px; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 120px; margin-top: 160px; position: absolute; width: 200px"
                                                            value="#{EmployeeHistory$PromoteEmployee.defaultSelectedData2.selectedObject}" valueChangeListener="#{EmployeeHistory$PromoteEmployee.drlToPayGrade_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems2" value="#{EmployeeHistory$PromoteEmployee.payGradeOpt}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputTextRightSalaryActual"
                                                            style="font-size: 13px; margin-left: 10px; margin-top: 200px; position: absolute" value="Salary: "/>
                                                        <ice:inputText binding="#{EmployeeHistory$PromoteEmployee.txtToSalary}" disabled="true" id="txtToSalary" style="border-style: none none solid none; background-color: rgb(246, 247, 247); border-bottom-color: rgb(0, 0, 0); border-bottom-width: 1px; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 200px; position: absolute; width: 200px"/>
                                                        <ice:outputText id="outputText9"
                                                            style="font-size: 13px; margin-left: 10px; margin-top: 35px; position: absolute" value="Department"/>
                                                        <ice:outputText binding="#{EmployeeHistory$PromoteEmployee.lblDepartmentTO}" id="lblDepartmentTO"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 50px; left: 110px; top: 10px; position: absolute; width: 240px" value="outputText"/>
                                                        <ice:outputText binding="#{EmployeeHistory$PromoteEmployee.lblToJobDescription}"
                                                            id="lblToJobDescription"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 120px; margin-top: 80px; position: absolute; text-align: left; width: 200px" value=":"/>
                                                        <ice:outputText binding="#{EmployeeHistory$PromoteEmployee.lblToRank}" id="lblToRank"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 120px; margin-top: 120px; position: absolute; text-align: left; width: 200px" value=":"/>
                                                        <ice:outputText binding="#{EmployeeHistory$PromoteEmployee.lblPayGrade}" id="lblPayGrade"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 120px; margin-top: 160px; position: absolute; text-align: left; width: 200px" value=":"/>
                                                    </ice:panelLayout>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="PanelLayOutInsidVacancyListRequester"
                                                    style="height: 90px; margin-left: 15px; margin-top: 580px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                    <ice:outputText id="outputText14Promoter" style="margin-left: 20px; margin-top: 12px;  position: absolute;"
                                                        styleClass="insideInputTextAnyPerfo" value="Promoter:"/>
                                                    <ice:inputText binding="#{EmployeeHistory$PromoteEmployee.inputTextPromoter}" id="inputTextPromoter" style="border: none; border-bottom:1px solid #000000; background-color: #efeff0; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 130px; top: 10px; position: absolute; width: 220px"/>
                                                    <ice:outputText id="outputText14DateOfPromotion"
                                                        style="margin-left: 20px; margin-top: 58px;  position: absolute;" styleClass="insideInputTextAnyPerfo" value="Promotion Date:"/>
                                                    <ice:inputText binding="#{EmployeeHistory$PromoteEmployee.inputTextDateOfPromotion}" disabled="true"
                                                        id="inputTextDateOfPromotion" style="border: none; border-bottom:1px solid #000000; background-color: #efeff0; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 130px; top: 50px; position: absolute; width: 220px"/>
                                                    <ice:commandButton action="#{EmployeeHistory$PromoteEmployee.buttonDateOfPromotion_action}"
                                                        id="buttonDateOfPromotion" image="/resources/images/cal_icon.JPG" immediate="true" partialSubmit="true"
                                                        style="left:330px; top: 52px; position: absolute" value="submit"/>
                                                    <ice:outputText id="outputText14ReferenceNo"
                                                        style="margin-left: 400px; margin-top: 12px;  position: absolute;" styleClass="insideInputTextAnyPerfo" value="Reference NO"/>
                                                    <ice:inputText binding="#{EmployeeHistory$PromoteEmployee.inputTextReferenceNo}" id="inputTextReferenceNo" style="border: none; border-bottom:1px solid #000000; background-color: #efeff0; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 510px; top: 10px; position: absolute; width: 220px"/>
                                                    <ice:outputText id="outputText14ReferenceDate"
                                                        style="margin-left: 400px; margin-top: 58px;  position: absolute;" styleClass="insideInputTextAnyPerfo" value="Reference Date:"/>
                                                    <ice:inputText binding="#{EmployeeHistory$PromoteEmployee.inputTextReferenceDate}"
                                                        id="inputTextReferenceDate" style="border: none; border-bottom:1px solid #000000; background-color: #efeff0; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 510px; top: 50px; position: absolute; width: 220px"/>
                                                    <ice:commandButton action="#{EmployeeHistory$PromoteEmployee.buttonCalReferenceDate_action}"
                                                        id="buttonCalReferenceDate" image="/resources/images/cal_icon.JPG" immediate="true" partialSubmit="true"
                                                        style="left:710px; top: 52px; position: absolute" value="submit"/>
                                                    <ice:selectInputDate binding="#{EmployeeHistory$PromoteEmployee.calPromotionDate}" id="calPromotionDate"
                                                        rendered="false" style="height: 212px; left: 360px; top: -144px; position: absolute; width: 190px"
                                                        value="#{EmployeeHistory$PromoteEmployee.selectInputDate1Bean.date1}" valueChangeListener="#{EmployeeHistory$PromoteEmployee.calPromotionDate_processValueChange}"/>
                                                    <ice:selectInputDate binding="#{EmployeeHistory$PromoteEmployee.calReferenceDate}" id="calReferenceDate"
                                                        rendered="false" style="height: 212px; left: 736px; top: -137px; position: absolute; width: 190px"
                                                        value="#{EmployeeHistory$PromoteEmployee.selectInputDateBean2.date1}" valueChangeListener="#{EmployeeHistory$PromoteEmployee.calReferenceDate_processValueChange}"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="PanelLayOutInsidVacancyListRequesterButton"
                                                    style="height: 40px; margin-left: 15px; margin-top: 682px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                    <ice:commandButton action="#{EmployeeHistory$PromoteEmployee.btnPromote_action}"
                                                        binding="#{EmployeeHistory$PromoteEmployee.btnPromote}" id="btnPromote"
                                                        style="margin-left: 190px; width: 80px; top: -2px; position: absolute" value="Promote"/>
                                                    <ice:commandButton action="#{EmployeeHistory$PromoteEmployee.btnUpdate_action}"
                                                        binding="#{EmployeeHistory$PromoteEmployee.btnUpdate}" id="btnUpdate" rendered="false"
                                                        style="margin-left: 280px; width: 80px; top: -2px; position: absolute" value="Update"/>
                                                    <ice:commandButton action="#{EmployeeHistory$PromoteEmployee.btnReject_action}" id="btnDemote"
                                                        rendered="false" style="margin-left: 370px; width: 80px; top: -2px; position: absolute" value="Demote"/>
                                                    <ice:commandButton id="btnCancel" rendered="false"
                                                        style="margin-left: 460px; width: 80px; top: -2px; position: absolute" value="Cancel"/>
                                                </ice:panelLayout>
                                                <ice:inputText binding="#{EmployeeHistory$PromoteEmployee.inputTextAdvertID}" id="inputTextAdvertID" rendered="false"/>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label style="margin-left:20px;color:white;font-weight:bold;font-family:Narkisim">BUNNA INTERNATIONAL BANK.Human Resource Management And Integrated Payroll System.</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$PromoteEmployee.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{EmployeeHistory$PromoteEmployee.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{EmployeeHistory$PromoteEmployee.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$PromoteEmployee.evaResultPopUpMsg}" draggable="true" id="evaResultPopUpMsg"
                            modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 380px">
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
                                        <ice:selectOneMenu binding="#{EmployeeHistory$PromoteEmployee.selectOneMenu1evaResultPopUpMsg}"
                                            id="selectOneMenu1evaResultPopUpMsg" partialSubmit="true" style=" border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width:200px; left: 110px; top: 10px; position: absolute">
                                            <f:selectItems id="selectOneMenu1selectItems" value="#{EmployeeHistory$PromoteEmployee.toFilterResultUsingSession}"/>
                                        </ice:selectOneMenu>
                                        <ice:outputText id="outputText14evaResultNoteIssue" style="color: red ;left: 10px; top: 60px;  position: absolute;"
                                            styleClass="insideInputTextAnyPerfo" value="Notes and Issue:"/>
                                        <ice:outputText binding="#{EmployeeHistory$PromoteEmployee.outputText14evaResultNoteIssueVal}"
                                            id="outputText14evaResultNoteIssueVal" style="color: black ;left: 10px; top: 80px;  position: absolute;"
                                            styleClass="insideInputTextAnyPerfo" value="Val"/>
                                        <ice:commandButton action="#{EmployeeHistory$PromoteEmployee.button2Ok_action}"
                                            binding="#{EmployeeHistory$PromoteEmployee.button2Ok}" id="button2Ok"
                                            style="left: 200px; top: 40px;  position: absolute; height: 25px; font-size: 10px; width: 50px" value="Ok"/>
                                        <ice:commandButton action="#{EmployeeHistory$PromoteEmployee.button2Cancel_action}"
                                            binding="#{EmployeeHistory$PromoteEmployee.button2Cancel}" id="button2Cancel"
                                            style="left: 255px; top: 40px;  position: absolute; height: 25px; font-size: 10px; width: 60px" value="Cancel"/>
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
