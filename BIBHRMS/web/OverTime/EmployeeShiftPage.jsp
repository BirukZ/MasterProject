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
                <title>Shift Viewer</title>
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
                        <ice:panelBorder id="whole_page" renderCenter="#{OverTime$EmployeeShiftPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{OverTime$EmployeeShiftPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{OverTime$EmployeeShiftPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{OverTime$EmployeeShiftPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{OverTime$EmployeeShiftPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
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
                                <ice:panelGroup id="menu_left" style="border:none; height:1000px; ">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(200,200,200); height:980px;top:15px left: 3px;top:25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: 3px;top:2px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="Search Area"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="pnlGrpSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 100px; width: 100%">
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
                                                            <ice:commandLink action="#{OverTime$EmployeeShiftPage.lnkOverTimeAttendance_action}"
                                                                id="lnkOverTimeAttendance" style="color:#306682;font-weight:bold" value="Attendance"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{OverTime$EmployeeShiftPage.lnkOverTimeReport_action}"
                                                                id="lnkOverTimeReport" style="color:#306682;font-weight:bold" value="Report"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height:1000px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height:995px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 970px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Employee Shift Viewer Page"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 382px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{OverTime$EmployeeShiftPage.pnlGrpPowerAllContent_processMyEvent}"
                                                    id="pnlGrpPowerAllContent" style="height: 382px" styleClass="icePnlGrp filedset_border">
                                                    <ice:panelLayout id="pnlLayoutEmployees" layout="flow" rendered="true"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 350px; margin-left: 15px; margin-right: 15px; left: 10px; top: 10px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="outputLabel3"
                                                            style="margin-left: 5px; margin-right: 400px; left: 67px; top: 240px; position: absolute; width: 10%" value="#{msgshif.shiftName}"/>
                                                        <ice:inputText binding="#{OverTime$EmployeeShiftPage.txtShiftName}" disabled="true" id="txtShiftName" style="margin-left: 5px; margin-right: 400px; left: 163px; top: 142px; position: absolute; width: 167"/>
                                                        <ice:inputText binding="#{OverTime$EmployeeShiftPage.txtEmpId}" id="txtEmpId" immediate="true"
                                                            partialSubmit="true" style="margin-left: 5px; margin-right: 400px; left: 163px; top: 46px; position: absolute; width: 25%"/>
                                                        <ice:outputLabel id="outputLabel5"
                                                            style="margin-left: 5px; margin-right: 400px; left: 70px; top: 40px; position: absolute; width: 10%" value="#{msgshif.empId}"/>
                                                        <ice:inputText action="#{OverTime$EmployeeShiftPage.txtStart_Date_action}"
                                                            binding="#{OverTime$EmployeeShiftPage.txtStart_Date}" disabled="true" id="txtStart_Date" style="margin-left: 5px; margin-right: 400px; left: 163px; top: 75px; position: absolute; width: 167"/>
                                                        <ice:outputLabel id="outputLabel6"
                                                            style="margin-left: 5px; margin-right: 400px; left: 67px; top: 72px; position: absolute; width: 10%" value="#{msgshif.StartedDate}"/>
                                                        <ice:commandButton action="#{OverTime$EmployeeShiftPage.btnSearch_action}"
                                                            binding="#{OverTime$EmployeeShiftPage.btnSearch}" id="btnSearch"
                                                            image="/resources/images/fig_search.gif" partialSubmit="true"
                                                            style="margin-left: 5px; margin-right: 400px; left: 320px; top: 50px; position: absolute" value="submit"/>
                                                        <ice:selectInputDate binding="#{OverTime$EmployeeShiftPage.calViewDate}" id="calViewDate"
                                                            rendered="false" style="height: 212px; left: 400px; top: 180px; position: absolute; width: 190px"
                                                            value="#{OverTime$EmployeeShiftPage.selectInputDate1Bean.date1}"
                                                            valueChangeListener="#{OverTime$EmployeeShiftPage.calViewDate_processValueChange}" visible="true"/>
                                                        <ice:selectInputDate binding="#{OverTime$EmployeeShiftPage.calNewShiftStratDate}"
                                                            id="calNewShiftStratDate" rendered="false"
                                                            style="height: 212px; left: 400px; top: 280px; position: absolute; width: 190px"
                                                            value="#{OverTime$EmployeeShiftPage.selectInputDate1BeanNewStarat.date1}"
                                                            valueChangeListener="#{OverTime$EmployeeShiftPage.calNewShiftStartDate_processValueChange}" visible="true"/>
                                                        <ice:selectInputDate binding="#{OverTime$EmployeeShiftPage.calNewShiftEndDate}" id="calNewShiftEndDate"
                                                            rendered="false" style="height: 212px; left: 400px; top: 280px; position: absolute; width: 190px"
                                                            value="#{OverTime$EmployeeShiftPage.selectInputDate1BeanNewEnd.date1}"
                                                            valueChangeListener="#{OverTime$EmployeeShiftPage.calNewShiftEndDate_processValueChange}" visible="true"/>
                                                        <ice:outputLabel id="outputLabel7"
                                                            style="margin-left: 5px; margin-right: 400px; left: 67px; top: 144px; position: absolute; width: 10%" value="#{msgshif.shiftName}"/>
                                                        <ice:selectOneMenu binding="#{OverTime$EmployeeShiftPage.drl_shiftType}" disabled="true"
                                                            id="drl_shiftType" partialSubmit="true"
                                                            style="margin-left: 5px; margin-right: 400px; left: 187px; top: 244px; position: absolute; width: 143px" value="#{OverTime$EmployeeShiftPage.selectOneMenu1Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{OverTime$EmployeeShiftPage.shiftList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectInputText action="#{OverTime$EmployeeShiftPage.txtEmployeeFullName_action}"
                                                            binding="#{OverTime$EmployeeShiftPage.txtEmployeeFullName}" id="txtEmployeeFullName"
                                                            immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true"
                                                            style="margin-left: 5px; margin-right: 400px; left: 500px; top: 40px; position: absolute; width: 25%" valueChangeListener="#{ApplicationBean1.updateList}">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:outputLabel id="outputLabel8"
                                                            style="margin-left: 5px; margin-right: 400px; left:400px; top: 40px; position: absolute; width: 10%" value="#{msgshif.FullName}"/>
                                                        <ice:outputText id="outputText1" style="left: 72px; top: 106px; position: absolute; width: 47px" value="#{msgshif.EndDate}"/>
                                                        <ice:inputText action="#{OverTime$EmployeeShiftPage.txt_EndDate_action}"
                                                            binding="#{OverTime$EmployeeShiftPage.txt_EndDate}" disabled="true" id="txt_EndDate" style="left: 166px; top: 105px; position: absolute; width: 167px"/>
                                                        <ice:outputText id="outputText3" style="left: 72px; top: 178px; position: absolute" value="#{msgshif.Selectifyouwanttochangetheshift}"/>
                                                        <ice:selectBooleanCheckbox binding="#{OverTime$EmployeeShiftPage.chk_change_shift}"
                                                            id="chk_change_shift" partialSubmit="true" style="left: 286px; top: 180px; position: absolute"
                                                            value="#{OverTime$EmployeeShiftPage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{OverTime$EmployeeShiftPage.chk_change_shift_processValueChange}"/>
                                                        <ice:outputText id="outputText4" style="left: 408px; top: 96px; position: absolute" value="#{msgshif.SelectMonth}"/>
                                                        <ice:selectOneMenu binding="#{OverTime$EmployeeShiftPage.drl_Month}" id="drl_Month" partialSubmit="true"
                                                            style="left: 502px; top: 100px; position: absolute; width: 167px" value="#{OverTime$EmployeeShiftPage.defaultSelectedData2.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems1" value="#{OverTime$EmployeeShiftPage.monthList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputText6" style="left: 408px; top: 72px; position: absolute" value="#{msgshif.SelectYear}"/>
                                                        <ice:selectOneMenu binding="#{OverTime$EmployeeShiftPage.drl_select_Year}" id="drl_select_Year"
                                                            partialSubmit="true" style="left: 502px; top: 70px; position: absolute; width: 167px" value="#{OverTime$EmployeeShiftPage.defaultSelectedData3.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems2" value="#{OverTime$EmployeeShiftPage.budjetYearList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputText7" style="position: absolute; left: 72px; top: 216px" value="ShiftChangedDate"/>
                                                        <ice:inputText binding="#{OverTime$EmployeeShiftPage.txt_changedDate}" disabled="true"
                                                            id="txt_changedDate" style="left: 190px; top: 214px; position: absolute"/>
                                                        <ice:commandButton action="#{OverTime$EmployeeShiftPage.btn_calander_action}"
                                                            binding="#{OverTime$EmployeeShiftPage.btn_calander}" disabled="true" id="btn_calander"
                                                            image="/resources/images/cal_icon.JPG" style="left: 336px; top: 215px; position: absolute" value="submit"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtEmpId" id="message1"
                                                            infoClass="infoMessage" style="height: 20px; left: 24px; top: 48px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drl_Month" id="message2"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 672px; top: 96px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drl_select_Year" id="message3"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 672px; top: 72px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                        <ice:commandButton action="#{OverTime$EmployeeShiftPage.btn_Save_action}" id="btn_Save"
                                                            style="height: 24px; left: 216px; top: 278px; position: absolute; width: 71px" value="Save"/>
                                                        <ice:commandButton id="btn_Reset"
                                                            style="height: 23px; left: 312px; top: 278px; position: absolute; width: 71px" value="Reset"/>
                                                        <ice:outputText id="outputText2" style="left: 408px; top: 216px; position: absolute" value="New Shif tStart Date"/>
                                                        <ice:inputText binding="#{OverTime$EmployeeShiftPage.txt_NewShiftStart_Date}"
                                                            id="txt_NewShiftStart_Date" style="left: 526px; top: 214px; position: absolute"/>
                                                        <ice:outputText id="outputText5" style="left: 408px; top: 264px; position: absolute" value="New Shift End Date"/>
                                                        <ice:inputText binding="#{OverTime$EmployeeShiftPage.txt_NewShift_EndDate}" id="txt_NewShift_EndDate" style="left: 526px; top: 262px; position: absolute"/>
                                                        <ice:commandButton action="#{OverTime$EmployeeShiftPage.btncalNewStart_action}"
                                                            binding="#{OverTime$EmployeeShiftPage.btncalNewStart}" id="btncalNewStart"
                                                            image="/resources/images/cal_icon.JPG" style="left: 672px; top: 216px; position: absolute" value="submit"/>
                                                        <ice:commandButton action="#{OverTime$EmployeeShiftPage.cal_NewShiftEndDate_action}"
                                                            binding="#{OverTime$EmployeeShiftPage.cal_NewShiftEndDate}" id="cal_NewShiftEndDate"
                                                            image="/resources/images/cal_icon.JPG" style="left: 672px; top: 264px; position: absolute" value="submit"/>
                                                    </ice:panelLayout>
                                                    <ice:selectInputDate binding="#{OverTime$EmployeeShiftPage.calAppliedDate}" id="calAppliedDate"
                                                        rendered="false" style="height: 212px; left: 120px; top: 100px; position: absolute; width: 190px"
                                                        value="#{OverTime$EmployeeShiftPage.selectInputDateBean1.date1}" valueChangeListener="#{OverTime$EmployeeShiftPage.calAppliedDate_processValueChange}"/>
                                                    <ice:panelLayout binding="#{OverTime$ShiftTimeRegistrationPage.pnlLayoutTimePanel}" id="pnlLayoutTimePanel"
                                                        rendered="false"
                                                        style="border: 5px solid rgb(204, 204, 204); height: 294px; margin-left: 15px; left: 400px; top: 70px; overflow: auto; position: absolute; width: 280px" styleClass="insideContainerMain">
                                                        <ice:dataTable id="dataTableTime" rows="12"
                                                            style="border: 2px solid rgb(115, 179, 206) ;height: 8px; left: 5px; top: 25px; position: absolute; width:270px"
                                                            value="#{OverTime$EmployeeShiftPage.tableHour}" var="currentRow">
                                                            <ice:column id="colStartDate12">
                                                                <ice:commandLink actionListener="#{OverTime$EmployeeShiftPage.optTxtForColumn08_processAction}"
                                                                    id="optTxtForColumn00" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col00']}"/>
                                                            </ice:column>
                                                            <ice:column id="colStartDate02">
                                                                <ice:commandLink actionListener="#{OverTime$EmployeeShiftPage.optTxtForColumn08_processAction}"
                                                                    id="optTxtForColumn02" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col10']}"/>
                                                            </ice:column>
                                                            <ice:column id="colStartTime04">
                                                                <ice:commandLink actionListener="#{OverTime$EmployeeShiftPage.optTxtForColumn08_processAction}"
                                                                    id="optTxtForolumn04" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col20']}"/>
                                                            </ice:column>
                                                            <ice:column id="colStartTime06">
                                                                <ice:commandLink actionListener="#{OverTime$EmployeeShiftPage.optTxtForColumn08_processAction}"
                                                                    id="optTxtForColumn06" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col30']}"/>
                                                            </ice:column>
                                                            <ice:column id="colStartTime08">
                                                                <ice:commandLink actionListener="#{OverTime$EmployeeShiftPage.optTxtForColumn08_processAction}"
                                                                    id="optTxtForColumn08" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col40']}"/>
                                                            </ice:column>
                                                            <ice:column id="colStartTime10">
                                                                <ice:commandLink actionListener="#{OverTime$EmployeeShiftPage.optTxtForColumn10_processAction}"
                                                                    id="optTxtForColumn10" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col50']}"/>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                        <ice:dataPaginator for="dataTableTime" style="layout:absolute; border: 1px solid rgb(115, 179, 206) ;height: 8px; left: 5px; top: 2px; position: absolute; width:270px">
                                                            <f:facet name="first">
                                                                <ice:outputText value=" From 00:00 to 11:55  "/>
                                                            </f:facet>
                                                            <f:facet name="last">
                                                                <ice:outputText value="  From 12:00 to 23:55"/>
                                                            </f:facet>
                                                        </ice:dataPaginator>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid">
                                        <jsp:directive.include file="/FOOTER.jspf"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{OverTime$EmployeeShiftPage.pnlPopupSuccessOrFailure}" clientOnly="true" draggable="false"
                            id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px;visibility: visible;"
                            styleClass="message" visible="true">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{OverTime$EmployeeShiftPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{OverTime$EmployeeShiftPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{OverTime$EmployeeShiftPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{OverTime$EmployeeShiftPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
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
