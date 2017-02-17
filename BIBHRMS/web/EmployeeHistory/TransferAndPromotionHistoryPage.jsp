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
            function TransferAndPromotionHistoryPage(field){

                if (field.defaultValue == field.value) field.value = '';
                else if (field.value == '') field.value = field.defaultValue;

            }
        </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1000px" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{EmployeeHistory$TransferAndPromotionHistoryPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{EmployeeHistory$TransferAndPromotionHistoryPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{EmployeeHistory$TransferAndPromotionHistoryPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{EmployeeHistory$TransferAndPromotionHistoryPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{EmployeeHistory$TransferAndPromotionHistoryPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height:840px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 775px; left: 0px; position: relative; width: 1020px; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 810px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Promotion and Transfer History "/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 800px; left: 0px; top: 30px; position: absolute; width: 1000px">
                                                <ice:panelGroup id="RetirementApproval" style="height: 755px;width: 980px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout1" style=" top:0px; width: 100%; position: absolute; height: 100%;">
                                                        <ice:panelLayout id="pnlLayoutRequester"
                                                            style="border: 1px solid rgb(204, 204, 204); height: 135px; margin-left: 15px; left: 0px; top: 28px; position: absolute; width: 950px" styleClass="insideContainerMain">
                                                            <ice:selectInputText
                                                                action="#{EmployeeHistory$TransferAndPromotionHistoryPage.txtRequesterFullName_action}"
                                                                binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.txtRequesterFullName}"
                                                                id="txtRequesterFullName" immediate="true" listValue="#{ApplicationBean1.list}"
                                                                listVar="employeeList" partialSubmit="true" rows="10"
                                                                style="background-color: rgb(242, 246, 240); background-image: url(&lt;Not Set&gt;); left: 166px; top: 22px; position: absolute"
                                                                valueChangeListener="#{ApplicationBean1.updateList}" width="335">
                                                                <f:facet name="selectInputText">
                                                                    <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                        <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                        <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                    </ice:panelGrid>
                                                                </f:facet>
                                                            </ice:selectInputText>
                                                            <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="Requester"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 550px; top: 24px; position: absolute" value="Id"/>
                                                            <ice:inputText binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.txtRequesterId}"
                                                                id="txtRequesterId" immediate="true" partialSubmit="true" style="background-color: rgb(242, 246, 240); left: 650px; top: 22px; position: absolute; width: 259px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="FullName"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="Position"/>
                                                            <ice:inputText binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.txtRequesterDepartment}"
                                                                disabled="true" id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 743px"/>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="Department"/>
                                                            <ice:inputText binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.txtRequesterPosition}"
                                                                disabled="true" id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 743px"/>
                                                            <ice:commandButton
                                                                action="#{EmployeeHistory$TransferAndPromotionHistoryPage.btnSearchRequester_action}"
                                                                id="btnSearchRequester" image="/resources/images/fig_search.gif" style="left: 849px; top: 25px; position: absolute"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutAttributes"
                                                            style="border: 1px solid rgb(204, 204, 204); height: 400px; margin-left: 15px; left: 0px; top: 170px; position: absolute; width: 950px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblRequestingDepartment" style="left: 48px; top: 24px; position: absolute" value="Req. Dept"/>
                                                            <ice:inputText binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.txtRequestingDepartment}"
                                                                disabled="true" id="txtRequestingDepartment" style="left: 166px; top: 22px; position: absolute; width: 700px"/>
                                                            <ice:commandButton
                                                                action="#{EmployeeHistory$TransferAndPromotionHistoryPage.btnTreeRequesterDepartment_action}"
                                                                id="btnTreeRequesterDepartment" image="/Employee/images/pic3-tree-icon.jpg" immediate="true"
                                                                style="left: 850px; top: 23px; position: absolute" value="Tree"/>
                                                            <ice:outputLabel id="lblPrevJobType" style="left: 48px; top: 138px; position: absolute" value="Prev.JobType"/>
                                                            <ice:selectOneMenu binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.drlPrevJobType}"
                                                                id="drlPrevJobType" partialSubmit="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 166px; top: 138px; position: absolute; width: 215px" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.selectedObjectOfPrevJobTypeList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.jobPositionList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblNewJobType" style="left: 500px; top: 138px; position: absolute" value="New JobType"/>
                                                            <ice:selectOneMenu binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.drlNewJobType}"
                                                                id="drlNewJobType" partialSubmit="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 650px; top: 138px; position: absolute; width: 215px" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.selectedObjectOfNewJobTypeList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu2selectItems2" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.jobPositionList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblPromotionType" style="left: 48px; top: 325px; position: absolute" value="PromotionType"/>
                                                            <ice:selectOneMenu binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.drlPromotionType}"
                                                                id="drlPromotionType" partialSubmit="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 166px; top: 325px; position: absolute; width: 170px" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.selectedObjectOfPromotionTypeList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu3selectItems" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.promotionTypeList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblPreviousRank" style="left: 48px; top: 176px; position: absolute" value="Prev. Rank"/>
                                                            <ice:selectOneMenu binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.drlPreviousRank}"
                                                                id="drlPreviousRank" partialSubmit="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 166px; top: 176px; position: absolute; width: 170px" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.selectedObjectOfPreviousRankList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu4selectItems" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.rankList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblNewRank" style="left: 500px; top: 176px; position: absolute" value="New Rank"/>
                                                            <ice:selectOneMenu binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.drlNewRank}"
                                                                id="drlNewRank" partialSubmit="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); font-family: Arial,Helvetica,sans-serif; left: 650px; top: 176px; position: absolute; width: 170px" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.selectedObjectOfNewRankList.selectedObject}">
                                                                <f:selectItems id="selectOneMenu2selectItems1" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.rankList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblReason" style="left: 48px; top: 265px; position: absolute" value="Reason"/>
                                                            <ice:inputTextarea binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.txtaReason}"
                                                                id="txtaReason" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); height: 58px; left: 166px; top: 251px; position: absolute; width: 696px"/>
                                                            <ice:outputLabel id="lblRequestDate" style="left: 48px; top: 62px; position: absolute" value="Req. Date"/>
                                                            <ice:inputText binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.txtRequestDate}"
                                                                disabled="true" id="txtRequestDate" immediate="true" partialSubmit="true" style="background-color: rgb(242, 246, 240); left: 166px; top: 62px; position: absolute; width: 215px"/>
                                                            <ice:outputLabel id="lblPromotionDate" style="left: 500px; top: 62px; position: absolute" value="Prom. Date"/>
                                                            <ice:inputText binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.txtPromotionDate}"
                                                                disabled="true" id="txtPromotionDate" immediate="true" partialSubmit="true" style="background-color: rgb(242, 246, 240); left: 650px; top: 62px; position: absolute; width: 215px"/>
                                                            <ice:outputLabel id="lblRequestLetterNumber" style="left: 48px; top: 100px; position: absolute" value="Req. Ref. No"/>
                                                            <ice:inputText binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.txtRequestLetterNumber}"
                                                                id="txtRequestLetterNumber" immediate="true" partialSubmit="true"
                                                                style="background-color: rgb(242, 246, 240); left: 166px; top: 100px; position: absolute; width: 215px"
                                                                styleClass="iceInpTxt-dis" value="00000"/>
                                                            <ice:outputLabel id="lblPromotionLetterNumber" style="left: 500px; top: 100px; position: absolute" value="Promo. ref. No"/>
                                                            <ice:inputText binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.txtPromotionLetterNumber}"
                                                                id="txtPromotionLetterNumber" immediate="true" partialSubmit="true"
                                                                style="background-color: rgb(242, 246, 240); left: 650px; top: 100px; position: absolute; width: 215px" value="00000"/>
                                                            <ice:outputLabel id="lblPrevSalary" style="left: 48px; top: 213px; position: absolute" value="PrevSalary"/>
                                                            <ice:inputText binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.txtPrevSalary}"
                                                                id="txtPrevSalary" immediate="true" partialSubmit="true" style="background-color: rgb(242, 246, 240); left: 166px; top: 213px; position: absolute; width: 170px"/>
                                                            <ice:outputLabel id="lblNewSalary" style="left: 500px; top: 213px; position: absolute" value="New Salary"/>
                                                            <ice:inputText binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.txtNewSalary}"
                                                                id="txtNewSalary" immediate="true" partialSubmit="true" style="background-color: rgb(242, 246, 240); left: 650px; top: 213px; position: absolute; width: 170px"/>
                                                            <ice:outputLabel id="lblAdvertisnmentNumber" style="left: 500px; top: 325px; position: absolute" value="Adv No"/>
                                                            <ice:inputText binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.txtAdvertisnmentNumber}"
                                                                id="txtAdvertisnmentNumber" immediate="true" partialSubmit="true"
                                                                style="background-color: rgb(242, 246, 240); left: 650px; top: 325px; position: absolute; width: 170px" value="00000"/>
                                                            <ice:outputLabel id="lblCompletedDate" style="left: 48px; top: 363px; position: absolute" value="CompletedDate"/>
                                                            <ice:inputText binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.txtCompletedDate}"
                                                                disabled="true" id="txtCompletedDate" immediate="true" partialSubmit="true"
                                                                style="left: 166px; top: 363px; position: absolute; width: 170px" value="1900-01-01"/>
                                                            <ice:commandButton
                                                                action="#{EmployeeHistory$TransferAndPromotionHistoryPage.btnCalRequestedDate_action}"
                                                                id="btnCalRequestedDate" image="/resources/images/cal_button.gif" immediate="true"
                                                                style="left: 366px; top: 68px; position: absolute" value="submit"/>
                                                            <ice:commandButton
                                                                action="#{EmployeeHistory$TransferAndPromotionHistoryPage.btnCalPromotionDate_action}"
                                                                id="btnCalPromotionDate" image="/resources/images/cal_button.gif" immediate="true"
                                                                style="left: 850px; top: 68px; position: absolute" value="submit"/>
                                                            <ice:commandButton
                                                                action="#{EmployeeHistory$TransferAndPromotionHistoryPage.btnCalCompletedDate_action}"
                                                                id="btnCalCompletedDate" image="/resources/images/cal_button.gif" immediate="true"
                                                                style="left: 320px; top: 369px; position: absolute" value="submit"/>
                                                            <ice:commandButton action="#{EmployeeHistory$TransferAndPromotionHistoryPage.btnAddToTable_action}"
                                                                id="btnAddToTable" style="left: 533px; top: 355px; position: absolute; width: 146px" value="Add To Table"/>
                                                            <ice:selectInputDate binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.calDateSelector}"
                                                                id="calDateSelector" renderMonthAsDropdown="true" renderYearAsDropdown="true" rendered="false"
                                                                style="height: 212px; left: 160px; top: 85px; position: absolute; width: 190px"
                                                                value="#{EmployeeHistory$TransferAndPromotionHistoryPage.selectInputDateBean3.date1}" valueChangeListener="#{EmployeeHistory$TransferAndPromotionHistoryPage.calDateSelector_processValueChange}"/>
                                                            <label style="left: 5px; top: 315px; border-bottom:0.5px groove #176674; width:940px; position: absolute;"></label>
                                                            <ice:selectInputDate binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.calPromotionDate}"
                                                                id="calPromotionDate" renderMonthAsDropdown="true" renderYearAsDropdown="true" rendered="false"
                                                                style="height: 212px; left: 645px; top: 85px; position: absolute; width: 190px"
                                                                value="#{EmployeeHistory$TransferAndPromotionHistoryPage.selectInputDateBean4.date1}" valueChangeListener="#{EmployeeHistory$TransferAndPromotionHistoryPage.calPromotionDate_processValueChange}"/>
                                                            <ice:selectInputDate binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.calCompletedDates}"
                                                                id="calCompletedDates" renderMonthAsDropdown="true" renderYearAsDropdown="true" rendered="false"
                                                                style="height: 212px; left: 160px; top: 200px; position: absolute; width: 190px;z-index:200"
                                                                value="#{EmployeeHistory$TransferAndPromotionHistoryPage.selectInputDateBean5.date1}" valueChangeListener="#{EmployeeHistory$TransferAndPromotionHistoryPage.calCompletedDates_processValueChange}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputRequest"
                                                            style="height: 136px; margin-left: 15px; left: 0px; top: 580px; overflow: auto; position: absolute; width: 950px" styleClass="insideContainerMain">
                                                            <ice:dataTable id="dataTableAllCommittedOffencesOfEmployee"
                                                                style="height: 8px; left: 0px; top: -10px; position: absolute; width: 100%"
                                                                value="#{EmployeeHistory$TransferAndPromotionHistoryPage.transferAndPromotionHistoryList}" var="currentRow">
                                                                <ice:column id="colRequesterDepartmentTable">
                                                                    <ice:selectOneMenu id="drlRequesterDepartmentTable" partialSubmit="true" value="#{currentRow['requesterDepartment']}">
                                                                        <f:selectItems id="selectOneMenuRequesterDepartmentTbl" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.requesterDepartmentList}"/>
                                                                    </ice:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextRequesterDepartmentTable" value="Dept"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colPromotionTypeTbl">
                                                                    <ice:selectOneMenu id="drlPromotionTypeTbl" partialSubmit="true" value="#{currentRow['promotionType']}">
                                                                        <f:selectItems id="selectOneMenuPromotionTypeTbl" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.promotionTypeList}"/>
                                                                    </ice:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextPromotionType" value="Promo Type"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colPreviousJobPositionTbl">
                                                                    <ice:selectOneMenu id="drlpreviousJobPositionTbl" partialSubmit="true" value="#{currentRow['previousJobPosition']}">
                                                                        <f:selectItems id="selectOneMenuPreviousJobPositionTbl" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.jobPositionList}"/>
                                                                    </ice:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextPreviousJobPosition" value="Prev Job Pos"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colNewJobPosition">
                                                                    <ice:selectOneMenu id="drlNewJobPositionTbl" partialSubmit="true" value="#{currentRow['newJobPosition']}">
                                                                        <f:selectItems id="selectOneMenuNewJobPositionTbl" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.jobPositionList}"/>
                                                                    </ice:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextNewJobPosition" value="new Job Pos"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colPreviousRankTbl">
                                                                    <ice:selectOneMenu id="drlpreviousJobRankTbl" partialSubmit="true" value="#{currentRow['previousRank']}">
                                                                        <f:selectItems id="selectOneMenuPreviousRankTbl" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.rankList}"/>
                                                                    </ice:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextPreviousRank" value="Prev Rank"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colNewRankTbl">
                                                                    <ice:selectOneMenu id="drlnewRanlTbl" partialSubmit="true" value="#{currentRow['newRank']}">
                                                                        <f:selectItems id="selectOneMenuNewRankTbl" value="#{EmployeeHistory$TransferAndPromotionHistoryPage.rankList}"/>
                                                                    </ice:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextNewRankTbl" value="new Rank"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colPreviousSalaryTbl">
                                                                    <ice:outputText id="optTxtForPreviousSalaryTbl" value="#{currentRow['previousSalary']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextPreviousSalaryTbl" value="Prev Salary"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colNewSalary">
                                                                    <ice:outputText id="optTxtForColumnNewSalary" value="#{currentRow['newSalary']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextNewSalary" value="New Salary"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colPromotionDateTbl">
                                                                    <ice:outputText id="optTxtForColPromotionDateTbl" value="#{currentRow['promotionDate']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextPromotionDateTbl" value="Prom Date"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colCompletedDateTbl">
                                                                    <ice:inputText id="optTxtForCompletedDateTbl" value="#{currentRow['completedDate']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextCompletedDateTbl" value="Comp Date"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colPromotionRequestDateTbl">
                                                                    <ice:inputText id="optTxtForPromotionRequestDateTbl" value="#{currentRow['promotionRequestDate']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextPromotionRequestDateTbl" value="Req Date"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colPromotionRequestLetterNumberTbl">
                                                                    <ice:inputText id="optTxtForPromotionRequestLetterNumberTbl" value="#{currentRow['promotionRequestLetterNumber']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextPromotionRequestLetterNumberTbl" value="Promo.Req. No"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colPromotionLetterNumberTbl">
                                                                    <ice:inputText id="optTxtForPromotionLetterNumberTbl" value="#{currentRow['promotionLetterNumber']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextPromotionLetterNumberTbl" value="Prom. No"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colAdvertisenmentNumberTbl">
                                                                    <ice:inputText id="optTxtForAdvertisenmentNumberTbl" value="#{currentRow['advertisenmentNumber']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextAdvertisenmentNumberTbl" value="Adv No"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colReasonTbl">
                                                                    <ice:inputTextarea id="optTxtForReasonTbl" value="#{currentRow['reason']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextReasonTbl" value="Reason"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelectorOverTime" multiple="false" preStyleOnSelection="true" selectionListener="#{EmployeeHistory$TransferAndPromotionHistoryPage.rowSelector_processMyEvent}"/>
                                                                </ice:column>
                                                                <ice:column id="colEdit">
                                                                    <ice:commandLink action="#{EmployeeHistory$TransferAndPromotionHistoryPage.cmdLnkOk_action}"
                                                                        id="cmdLnkOk" value="Ok"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEdit" value="Edit"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRemove">
                                                                    <ice:commandLink
                                                                        action="#{EmployeeHistory$TransferAndPromotionHistoryPage.cmdLnkRemove_action}"
                                                                        id="cmdLnkRemove" panelConfirmation="pnlConfirmForDelete" value="Remove"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextRemove" value="Remove"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons" style="margin-left: 15px; margin-top: 725px; width: 950px" styleClass="insideContainerMain">
                                                            <ice:commandButton
                                                                action="#{EmployeeHistory$TransferAndPromotionHistoryPage.btnSaveOrUpdate_action}"
                                                                id="btnSaveOrUpdate" style="margin-left: 350px; width: 80px" value="#{OverTime$OverTimeRequestPage.newOrEditOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{EmployeeHistory$TransferAndPromotionHistoryPage.btnReset_action}"
                                                                id="btnReset" style="margin-left: 50px; width: 80px" value="Reset"/>
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
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |information |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelLayout binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.pnlLayoutTree}" id="pnlLayoutTree" layout="flow"
                            rendered="false"
                            style="border-width: 2px; border-style: solid; height: 416px; left: 400px; top: 400px; overflow: scroll; position: absolute; width: 400px; z-index: 400; -rave-layout: grid" styleClass="insideContainerMain">
                            <ice:tree binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.organizationTree}" id="organizationTree"
                                style="height: 286px; margin-left: 0px; margin-top: 0px; text-align: left; width: 190px"
                                value="#{EmployeeHistory$TransferAndPromotionHistoryPage.treeModel.model}" var="item">
                                <ice:treeNode id="treeNode">
                                    <f:facet name="icon">
                                        <ice:panelGroup id="panelGroup1" style="display: inline;">
                                            <ice:graphicImage id="graphicImage1" value="#{item.userObject.icon}"/>
                                        </ice:panelGroup>
                                    </f:facet>
                                    <f:facet name="content">
                                        <ice:panelGroup id="panelGroup2" style="display: inline;">
                                            <ice:commandLink actionListener="#{EmployeeHistory$TransferAndPromotionHistoryPage.treeLink_processAction}"
                                                id="commandLink1" partialSubmit="true">
                                                <ice:outputText id="outputText2" value="#{item.userObject.text}"/>
                                            </ice:commandLink>
                                        </ice:panelGroup>
                                    </f:facet>
                                </ice:treeNode>
                            </ice:tree>
                        </ice:panelLayout>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.pnlPopupSuccessOrFailure}"
                            clientOnly="true" draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{EmployeeHistory$TransferAndPromotionHistoryPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.pnlMessageBody}" id="pnlMessageBody"
                                        layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.lblSuccessOrErrorMessage}"
                                            id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="            bunna HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.outputTextConfirmDelete}"
                                            id="outputTextConfirmDelete" style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{EmployeeHistory$TransferAndPromotionHistoryPage.btnPopupOkDelete_action}"
                                            id="btnPopupOkDelete" style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{EmployeeHistory$TransferAndPromotionHistoryPage.btnPopupCancelDelete_action}"
                                            id="btnPopupCancelDelete" style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$TransferAndPromotionHistoryPage.pnlPopupViewPrevieousDecisions}"
                            draggable="true" id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="bunna HRMS - View request status "/>
                                    <ice:commandLink action="#{EmployeeHistory$TransferAndPromotionHistoryPage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{EmployeeHistory$TransferAndPromotionHistoryPage.transferAndPromotionHistoryList}" var="currentRow">
                                            <ice:column id="colNumber">
                                                <ice:outputText id="optTxtForColumnNumber" value="#{currentRow['counter']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextNumber" value="NO"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colDecisionGiven">
                                                <ice:outputText id="optTxtForColumnDecisionGiven" value="#{currentRow['givenDecision']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextDecisionGiven" value="Decision"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colEmpId">
                                                <ice:outputText id="optTxtForColumnEmpId" value="#{currentRow['deciderEmployeeId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEmpId" value="EmpId"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colEmpFullName">
                                                <ice:outputText id="optTxtForColumnEmpFullName" value="#{currentRow['deciderFullName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEmpFullName" value="Employee Full Name"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colCommentGiven">
                                                <ice:outputText id="optTxtForCommentGiven" value="#{currentRow['commentGiven']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextCommentGiven" value="Comment Given"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colDate">
                                                <ice:outputText id="optTxtForDate" value="#{currentRow['decidedDateAndTIme']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextDate" value="Date"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>