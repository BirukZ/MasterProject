<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : biruk
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <!-- <link HREF="../header_icon.ico" REL="icon"/>-->
                <title>ReportCritera Page</title>
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
                    function ReportPageRegistration(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{Page1.panelBorder1Bean.renderCenter}"
                        renderEast="#{Page1.panelBorder1Bean.renderEast}" renderNorth="#{Page1.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Page1.panelBorder1Bean.renderSouth}" renderWest="#{Page1.panelBorder1Bean.renderWest}"
                        style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                        <f:facet name="north">
                            <ice:panelGroup dragListener="#{Page1.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
                                <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow"
                                    style="height: 129px; left: 0px; position: relative; width: 100%z; -rave-layout: grid" styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                                <!-- End Header -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup id="menu_left" style=" height:100%;">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height: 512px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 573px; left: -4px; position: absolute; width: 213px" styleClass="list_menu">
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible2" toggleOnClick="true">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup2" styleClass="">
                                                    <ice:outputText id="outputText2" value="header Value"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid4" style="height: 200px; width: 100%;border:none">
                                                <ice:commandLink action="#{ReportCritera$ReportCritera.cmdReportPageList_action}"
                                                    binding="#{ReportCritera$ReportCritera.cmdReportPageList}" id="cmdReportPageList" value="Report Page List"/>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible id="panelCollapsible1">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup1" styleClass="">
                                                    <ice:outputText id="outputText1" value="header Value"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid1" width="100%">
                                                <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:225px; width: 100%">
                                                    <ice:outputText id="outputText3" value="Text Description"/>
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
                                    style="height: 590px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css" style="height: 500px; width:790px">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="ReportCriteraType "/>
                                        </legend>
                                        <ice:panelLayout binding="#{ReportCritera$ReportCritera.pnl_Type}" id="pnl_Type" layout="flow"
                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 130px; margin-left: 0px; left: 5px; top: 35px; position: absolute; width: 775px; -rave-layout: grid" styleClass="insideContainerMain">
                                            <ice:outputLabel id="outputLabel1" style="font-size: 10px; left: 26px; top: 26px; position: absolute" value="Type"/>
                                            <ice:outputLabel id="outputLabel2" style="font-size: 10px; left: 420px; top: 26px; position: absolute" value="Catagory"/>
                                            <ice:outputLabel id="outputLabel3" style="font-size: 10px; left: 26px; top: 71px; position: absolute" value="Report Name"/>
                                            <ice:selectOneMenu binding="#{ReportCritera$ReportCritera.drl_type}" id="drl_type" partialSubmit="true"
                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 112px; top: 24px; position: absolute; width: 190px" value="#{ReportCritera$ReportCritera.selectOneMenu1Bean.selectedObject}">
                                                <f:selectItems id="selectOneMenu1selectItems" value="#{ReportCritera$ReportCritera.reportTypes}"/>
                                            </ice:selectOneMenu>
                                            <ice:selectOneMenu binding="#{ReportCritera$ReportCritera.drl_report_Name}" id="drl_report_Name"
                                                partialSubmit="true"
                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 112px; top: 70px; position: absolute; width: 190px" value="#{ReportCritera$ReportCritera.selectOneMenu2Bean.selectedObject}">
                                                <f:selectItems id="selectOneMenu2selectItems" value="#{ReportCritera$ReportCritera.reportPage}"/>
                                            </ice:selectOneMenu>
                                            <ice:selectOneMenu binding="#{ReportCritera$ReportCritera.drl_catagory}" id="drl_catagory" partialSubmit="true"
                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 502px; top: 24px; position: absolute; width: 239px"
                                                value="#{ReportCritera$ReportCritera.selectOneMenu3Bean.selectedObject}" valueChangeListener="#{ReportCritera$ReportCritera.drl_catagory_processValueChange}">
                                                <f:selectItems id="selectOneMenu3selectItems" value="#{ReportCritera$ReportCritera.reportCatagori}"/>
                                            </ice:selectOneMenu>
                                        </ice:panelLayout>
                                        <ice:panelLayout binding="#{ReportCritera$ReportCritera.pnl_critera}" id="pnl_critera" layout="flow"
                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 220px; left: 5px; top: 175px; position: absolute; width: 770px; -rave-layout: grid" styleClass="insideContainerMain">
                                            <ice:outputLabel id="outputLabel4" style="font-size: 10px; left: 26px; top: 26px; position: absolute" value="StartDate"/>
                                            <ice:outputLabel id="outputLabel5" style="font-size: 10px; left: 420px; top: 26px; position: absolute" value="End Date"/>
                                            <ice:inputText binding="#{ReportCritera$ReportCritera.txt_start_day}" id="txt_start_day" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 112px; top: 24px; position: absolute; width: 197px"/>
                                            <ice:inputText binding="#{ReportCritera$ReportCritera.txt_end_date}" id="txt_end_date" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 502px; top: 24px; position: absolute; width: 197px"/>
                                            <ice:commandButton action="#{ReportCritera$ReportCritera.btn_StartDay_action}" id="btn_StartDay"
                                                image="/resources/images/cal_button.gif" style="left: 294px; top: 31px; position: absolute" value="submit"/>
                                            <ice:commandButton action="#{ReportCritera$ReportCritera.btn_EndDate_action}" id="btn_EndDate"
                                                image="/resources/images/cal_button.gif" style="left: 684px; top: 31px; position: absolute" value="submit"/>
                                            <ice:selectInputDate binding="#{ReportCritera$ReportCritera.calStartDate}" id="calStartDate" rendered="false"
                                                style="left: 115px; top: 48px; position: absolute; z-index: 100"
                                                value="#{ReportCritera$ReportCritera.calStartDateBean.date1}" valueChangeListener="#{ReportCritera$ReportCritera.calStartDate_processValueChange}"/>
                                            <ice:selectInputDate binding="#{ReportCritera$ReportCritera.calEndDate}" id="calEndDate" rendered="false"
                                                style="left: 507px; top: 48px; position: absolute; z-index: 100"
                                                value="#{ReportCritera$ReportCritera.calEndDateBean.date1}" valueChangeListener="#{ReportCritera$ReportCritera.calEndDate_processValueChange}"/>
                                            <ice:panelLayout id="pnl_group_radio" layout="flow"
                                                style="border: 1px solid rgb(204, 204, 204); height: 45px; margin-left: 15px; left: 50px; top: 70px; position: absolute; width: 621px; -rave-layout: grid" styleClass="insideContainerMain">
                                                <ice:selectOneRadio id="selectOneRadio_Report_Duration" partialSubmit="true"
                                                    style="left: 150px; top: 10px; position: absolute; text-align: center" valueChangeListener="#{ReportCritera$ReportCritera.selectOneRadio_Report_Duration_processValueChange}">
                                                    <f:selectItem itemLabel=" Monthly" itemValue="#{ReportCritera$ReportCritera.MONTHLY }"/>
                                                    <f:selectItem itemLabel=" Quarterly" itemValue="#{ReportCritera$ReportCritera.quarterly }"/>
                                                    <f:selectItem itemLabel=" semiannually" itemValue="#{ReportCritera$ReportCritera.semiannually }"/>
                                                    <f:selectItem itemLabel=" annually" itemValue="#{ReportCritera$ReportCritera.annually }"/>
                                                </ice:selectOneRadio>
                                            </ice:panelLayout>
                                            <ice:outputLabel binding="#{ReportCritera$ReportCritera.outputLabel_Month}" id="outputLabel_Month" rendered="false"
                                                style="left: 26px; top: 128px; position: absolute" value="Select Month "/>
                                            <ice:selectOneMenu binding="#{ReportCritera$ReportCritera.drl_Month}" id="drl_Month" partialSubmit="true"
                                                rendered="false" style="left: 102px; top: 128px; position: absolute; width: 208px" value="#{ReportCritera$ReportCritera.defaultSelectedData1.selectedObject}">
                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{ReportCritera$ReportCritera.monthList}"/>
                                            </ice:selectOneMenu>
                                            <ice:outputLabel binding="#{ReportCritera$ReportCritera.outputLabel_Quarterly}" id="outputLabel_Quarterly"
                                                rendered="false" style="left: 26px; top: 128px; position: absolute" value="Select Quarter Type"/>
                                            <!-- <ice:selectOneMenu binding="#{ReportCritera$ReportCritera.drl_querterly}" id="drl_querterly" partialSubmit="true"
                                                rendered="false" style="left: 140px; top: 128px; position: absolute; width: 208px" value="#{ReportCritera$ReportCritera.defaultSelectedData2.selectedObject}">
                                                <f:selectItems id="selectOneMenu1selectItems2" value="#{ReportCritera$ReportCritera.quaterList}"/>
                                            </ice:selectOneMenu>
                                            -->
                                            <ice:outputLabel binding="#{ReportCritera$ReportCritera.outputLabel_Semiannuale}" id="outputLabel_Semiannuale"
                                                rendered="false" style="left: 26px; top: 128px; position: absolute" value="Select SemiAnnual"/>
                                            <ice:selectOneMenu binding="#{ReportCritera$ReportCritera.drl_SemiAnnual}" id="drl_SemiAnnual" partialSubmit="true"
                                                rendered="false" style="left: 140px; top: 128px; position: absolute; width: 207px" value="#{ReportCritera$ReportCritera.defaultSelectedData3.selectedObject}">
                                                <f:selectItems id="selectOneMenu1selectItems3" value="#{ReportCritera$ReportCritera.simiAnnual}"/>
                                            </ice:selectOneMenu>
                                            <ice:outputLabel binding="#{ReportCritera$ReportCritera.outputLabel_annuale_type}" id="outputLabel_annuale_type"
                                                rendered="false" style="left: 26px; top: 128px; position: absolute" value="Select Annual Type"/>
                                            <ice:selectOneMenu binding="#{ReportCritera$ReportCritera.drl_annual_Type}" id="drl_annual_Type"
                                                partialSubmit="true" rendered="false" style="left: 154px; top: 128px; position: absolute; width: 181px" value="#{ReportCritera$ReportCritera.defaultSelectedData4.selectedObject}">
                                                <f:selectItems id="selectOneMenu1selectItems4" value="#{ReportCritera$ReportCritera.drl_annual_TypeDefaultItems}"/>
                                            </ice:selectOneMenu>
                                            <ice:selectOneMenu binding="#{ReportCritera$ReportCritera.drl_BudjetYear}" id="drl_BudjetYear" partialSubmit="true"
                                                rendered="false" style="left: 102px; top: 155px; position: absolute; width: 208px" value="#{ReportCritera$ReportCritera.defaultSelectedData5.selectedObject}">
                                                <f:selectItems id="selectOneMenu1selectItems5" value="#{ReportCritera$ReportCritera.budjetYearList}"/>
                                            </ice:selectOneMenu>
                                            <ice:selectOneMenu binding="#{ReportCritera$ReportCritera.drl_BujetYear_Simiannual}" id="drl_BujetYear_Simiannual"
                                                partialSubmit="true" rendered="false" style="left: 102px; top: 155px; position: absolute; width: 208px" value="#{ReportCritera$ReportCritera.defaultSelectedData5.selectedObject}">
                                                <f:selectItems id="selectOneMenu1selectItems55" value="#{ReportCritera$ReportCritera.newBudjetYearList}"/>
                                            </ice:selectOneMenu>
                                            <ice:outputLabel binding="#{ReportCritera$ReportCritera.outputLabel_BudjetYear}" id="outputLabel_BudjetYear"
                                                rendered="false" style="left: 26px; top: 155px; position: absolute" value="Select Year"/>
                                            <ice:outputText id="lblCustomizale" style="font-size: 10px; left: 26px; top: 185px; position: absolute" value="Customizale"/>
                                            <ice:selectBooleanCheckbox binding="#{ReportCritera$ReportCritera.choCustomizaleReport}" id="choCustomizaleReport"
                                                partialSubmit="true" style="color: rgb(54, 76, 94); left: 112px; top: 190px; position: absolute" value="#{ReportCritera$ReportCritera.defaultSelectedData10.selectedBoolean}"/>
                                        </ice:panelLayout>
                                        <ice:panelLayout binding="#{ReportCritera$ReportCritera.pnl_Other}" id="pnl_Other" layout="flow"
                                            style="border: 1px solid rgb(204, 204, 204); height: 99px; left: 5px; top: 405px; position: absolute; width: 770px; -rave-layout: grid" styleClass="insideContainerMain">
                                            <ice:outputText id="lblEmployeeId" style="font-size: 10px; left: 26px; top: 26px; position: absolute" value="Employee Id"/>
                                            <ice:inputText binding="#{ReportCritera$ReportCritera.txtEmployeeId}" id="txtEmployeeId" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 112px; top: 24px; position: absolute; width: 197px"/>
                                            <ice:outputText id="lblAllEmployee" style="font-size: 10px; left: 420px; top: 26px; position: absolute" value="All Employee"/>
                                            <ice:selectBooleanCheckbox binding="#{ReportCritera$ReportCritera.choAllEmployee}" id="choAllEmployee"
                                                partialSubmit="true"
                                                style="background-color: rgb(242, 246, 240);; color: rgb(54, 76, 94); left: 490px; top: 30px; position: absolute" value="#{ReportCritera$ReportCritera.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                        </ice:panelLayout>
                                    </fieldset>
                                    <ice:panelLayout binding="#{ReportCritera$ReportCritera.pnl_Btn}" id="pnl_Btn" layout="flow"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 40px; margin-left: 20px; left: -20px; top: 520px; position: absolute; width: 790px" styleClass="insideContainerMain">
                                        <ice:commandButton binding="#{ReportCritera$ReportCritera.btn_Reset}" id="btn_Reset"
                                            style="left: 500px; top: 0px; position: absolute; width: 171px" value="Reset"/>
                                        <ice:commandButton action="#{ReportCritera$ReportCritera.btn_NewGenerate_action}"
                                            binding="#{ReportCritera$ReportCritera.btn_NewGenerate}" id="btn_NewGenerate"
                                            style="left: 280px; top: 0px; position: absolute; width: 173px" value="Generate Tabular"/>
                                        <ice:commandButton action="#{ReportCritera$ReportCritera.btn_generateJasper_action}"
                                            binding="#{ReportCritera$ReportCritera.btn_generateJasper}" id="btn_generateJasper"
                                            style="left: 72px; top: 0px; position: absolute; width: 143px" value="Generate Jasper"/>
                                    </ice:panelLayout>
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
                    <ice:panelPopup autoCentre="true" binding="#{ReportCritera$ReportCritera.pnlPopupSuccessOrFailure}" clientOnly="true" draggable="false"
                        id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnMessageTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Bank Human Resource Management System:Message"/>
                                <ice:commandLink action="#{ReportCritera$ReportCritera.btnClosePopupSuccessOrFailure_action}" id="btnClosePopupSuccessOrFailure"
                                    immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout binding="#{ReportCritera$ReportCritera.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{ReportCritera$ReportCritera.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
