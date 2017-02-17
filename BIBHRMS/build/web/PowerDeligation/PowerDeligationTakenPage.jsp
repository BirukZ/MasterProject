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
                    function EyeWitnessesPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1000px" id="img" src="../resources/images/"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{PowerDeligation$PowerDeligationTakenPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{PowerDeligation$PowerDeligationTakenPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{PowerDeligation$PowerDeligationTakenPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{PowerDeligation$PowerDeligationTakenPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{PowerDeligation$PowerDeligationTakenPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none; height:470px; ">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(200,200,200); height:770px;top:15px left: 3px;top:25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: 3px;top:2px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="Search Area"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 100px; width: 100%">
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
                                                            <ice:commandLink id="lnkPayrollPeriodLists" style="color:#306682;font-weight:bold" value="Workflow Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="lnkPayrollSetUp" style="color:#306682;font-weight:bold" value="Workflow Group Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="lnkAccrualEntries" style="color:#306682;font-weight:bold" value="Workflow User Group Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="lnkPersonalDeductions" style="color:#306682;font-weight:bold" value="Workflow States Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="lnkGovernmentDeductions" style="color:#306682;font-weight:bold" value="Workflow Transition Page"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="Status"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height:322px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="position: absolute;height: 187px; width: 100%">
                                                            <ice:outputLabel id="lblMsgStatusForRequest"
                                                                style="color: white; font-weight: bold; margin-left: 20px; margin-top: 65px; left: 20px; position: absolute; width: 187px" value="Request History  Board"/>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height:790px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 775px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 760px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Payroll List and assign a dedecated person"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 770px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelLayout binding="#{PowerDeligation$PowerDeligationTakenPage.pnProfile}" id="pnProfile" style="height: 770px; width: 100%">
                                                    <ice:panelGroup binding="#{PowerDeligation$PowerDeligationTakenPage.pnlGrpPowerDeligationContent}"
                                                        id="pnlGrpPowerDeligationContent" style="height: 686px" styleClass="icePnlGrp filedset_border">
                                                        <label></label>
                                                        <label></label>
                                                        <ice:panelLayout id="pnlLayoutDeligator" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 107px; margin-left: 15px; left: 20px; top: 30px; position: absolute; width: 707px">
                                                            <ice:outputLabel id="lblDeligatorDepartment" style="left: 48px; top: 24px; position: absolute" value="DeligatorDepartment"/>
                                                            <ice:outputLabel id="lblDeligatorId" style="left: 48px; top: 48px; position: absolute" value="DeligatorId"/>
                                                            <ice:outputLabel id="lblDeligatorRank" style="left: 48px; top: 72px; position: absolute" value="DeligatorRank"/>
                                                            <ice:inputText disabled="true" id="txtDeligatorDepartment" style="left: 166px; top: 22px; position: absolute"/>
                                                            <ice:inputText disabled="true" id="txtDeligatorId" style="left: 166px; top: 46px; position: absolute"/>
                                                            <ice:inputText disabled="true" id="txtDeligatorRank" style="left: 166px; top: 70px; position: absolute"/>
                                                            <ice:outputLabel id="lblDeligatorFullName" style="left: 408px; top: 24px; position: absolute" value="DeligatorFullName"/>
                                                            <ice:outputLabel id="lblDeligatorPosition" style="left: 408px; top: 48px; position: absolute" value="DeligatorPosition"/>
                                                            <ice:outputLabel id="lblDeligatorTItile" style="left: 408px; top: 72px; position: absolute" value="DeligatorTItile"/>
                                                            <ice:inputText disabled="true" id="txtDeligatorFullName" style="left: 526px; top: 22px; position: absolute"/>
                                                            <ice:inputText disabled="true" id="txtDeligatorPosition" style="left: 526px; top: 46px; position: absolute"/>
                                                            <ice:inputText disabled="true" id="txtDeligatorTItile" style="left: 526px; top: 70px; position: absolute"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutDeligatee" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204); height: 98px; margin-left: 15px; left: 20px; top: 150px; overflow: auto; position: absolute; width: 707px">
                                                            <ice:outputLabel id="lblDeligateeDepartment" style="left: 48px; top: 24px; position: absolute" value="DeligateeDepartment"/>
                                                            <ice:outputLabel id="lblDeligateeId" style="left: 48px; top: 48px; position: absolute" value="DeligateeId"/>
                                                            <ice:outputLabel id="lblDeligateeRank" style="left: 48px; top: 72px; position: absolute" value="DeligateeRank"/>
                                                            <ice:inputText disabled="true" id="txtDeligateeDepartment" style="left: 166px; top: 22px; position: absolute"/>
                                                            <ice:inputText action="#{PowerDeligation$PowerDeligationTakenPage.txtDeligateeId_action}"
                                                                disabled="true" id="txtDeligateeId" style="left: 166px; top: 46px; position: absolute"/>
                                                            <ice:inputText disabled="true" id="txtDeligateeRank" style="left: 166px; top: 70px; position: absolute"/>
                                                            <ice:outputLabel id="lblDeligateeFullName" style="left: 408px; top: 24px; position: absolute" value="DeligateeFullName"/>
                                                            <ice:outputLabel id="lblDeligateePosition" style="left: 408px; top: 48px; position: absolute" value="DeligateePosition"/>
                                                            <ice:outputLabel id="lblDeligateeTItile" style="left: 408px; top: 72px; position: absolute" value="DeligateeTItile"/>
                                                            <ice:inputText disabled="true" id="txtDeligateeFullName" style="left: 526px; top: 22px; position: absolute"/>
                                                            <ice:inputText disabled="true" id="txtDeligateePosition" style="left: 526px; top: 46px; position: absolute"/>
                                                            <ice:inputText binding="#{PowerDeligation$PowerDeligationTakenPage.txtDeligateeTItile}"
                                                                disabled="true" id="txtDeligateeTItile" style="left: 526px; top: 70px; position: absolute"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutDeligation" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 86px; margin-left: 15px; left: 20px; top: 454px; overflow: auto; position: absolute; width: 707px">
                                                            <ice:inputText disabled="true" id="txtApprovedStartDate" style="left: 166px; top: 10px; position: absolute"/>
                                                            <ice:outputLabel id="lblApprovedStartDate" style="left: 72px; top: 10px; position: absolute" value="ApprovedStartDay"/>
                                                            <ice:inputText disabled="true" id="txtApprovedEndDate" style="left: 526px; top: 10px; position: absolute"/>
                                                            <ice:outputLabel id="lblApprovedEndDate" style="left: 408px; top: 10px; position: absolute" value="ApprovedEndDate"/>
                                                            <ice:inputText disabled="true" id="txtTakenStartDate" style="left: 166px; top: 50px; position: absolute"/>
                                                            <ice:outputLabel id="lblTakenStartDate" style="left: 72px; top: 50px; position: absolute" value="TakenStartDay"/>
                                                            <ice:inputText disabled="true" id="txtTakenEndDate" style="left: 526px; top: 46px; position: absolute"/>
                                                            <ice:outputLabel id="lblTakenEndDate" style="left: 408px; top: 50px; position: absolute" value="takenEndDay"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 44px; margin-left: 15px; left: 20px; top: 560px; overflow: auto; position: absolute; width: 707px">
                                                            <ice:commandButton action="#{PowerDeligation$PowerDeligationTakenPage.btnPostDecision_action}"
                                                                disabled="true" id="btnPostDecision"
                                                                style="left: 216px; top: 0px; position: absolute; width: 71px" value="Save"/>
                                                            <ice:commandButton action="#{PowerDeligation$PowerDeligationApprovePage.btnReset_action}"
                                                                id="btnReset" style="left: 336px; top: 0px; position: absolute; width: 71px" value="#{msgs.Reset}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutDecider" style="border-width: 1px; border-style: solid; border-color:  rgb(204, 204, 204); height: 174px; margin-left: 15px; left: 20px; top: 265px; overflow: auto; position: absolute; width: 707px">
                                                            <ice:outputLabel id="lblDeciderDepartment" style="left: 48px; top: 24px; position: absolute" value="DeciderDepartment"/>
                                                            <ice:outputLabel id="lblDeciderId" style="left: 48px; top: 48px; position: absolute" value="DeciderId"/>
                                                            <ice:outputLabel id="lblDeciderRank" style="left: 48px; top: 72px; position: absolute" value="DeciderRank"/>
                                                            <ice:inputText binding="#{PowerDeligation$PowerDeligationTakenPage.txtDeciderDepartment}"
                                                                disabled="true" id="txtDeciderDepartment" style="left: 166px; top: 22px; position: absolute"/>
                                                            <ice:inputText binding="#{PowerDeligation$PowerDeligationTakenPage.txtDeciderId}" disabled="true"
                                                                id="txtDeciderId" style="left: 166px; top: 46px; position: absolute"/>
                                                            <ice:inputText binding="#{PowerDeligation$PowerDeligationTakenPage.txtDeciderRank}" disabled="true"
                                                                id="txtDeciderRank" style="left: 166px; top: 70px; position: absolute"/>
                                                            <ice:outputLabel id="lblDeciderFullName" style="left: 408px; top: 24px; position: absolute" value="DeciderFullName"/>
                                                            <ice:outputLabel id="deciderPosition" style="left: 408px; top: 48px; position: absolute" value="DeciderPosition"/>
                                                            <ice:outputLabel id="lblDeciderTItile" style="left: 408px; top: 72px; position: absolute" value="DeciderTItile"/>
                                                            <ice:inputText binding="#{PowerDeligation$PowerDeligationTakenPage.txtDeciderFullName}"
                                                                disabled="true" id="txtDeciderFullName" style="left: 526px; top: 22px; position: absolute"/>
                                                            <ice:inputText binding="#{PowerDeligation$PowerDeligationTakenPage.txtDeciderPosition}"
                                                                disabled="true" id="txtDeciderPosition" style="left: 526px; top: 46px; position: absolute"/>
                                                            <ice:inputText binding="#{PowerDeligation$PowerDeligationTakenPage.txtDeciderTItile}"
                                                                disabled="true" id="txtDeciderTItile" style="left: 526px; top: 70px; position: absolute"/>
                                                            <ice:inputTextarea binding="#{PowerDeligation$PowerDeligationTakenPage.txtaDeciderCommen1}"
                                                                disabled="true" id="txtaDeciderCommen1" style="left: 166px; top: 118px; position: absolute; width: 503px"/>
                                                            <ice:outputLabel id="lblDeciderComment" style="left: 48px; top: 120px; position: absolute" value="Comment"/>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelLayout>
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
