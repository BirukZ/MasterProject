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
                <ice:outputStyle href="../resources/ETH/KAMSI_CAL_STYLE.css" id="outputStyle22"/>
                <script src="../resources/ETH/KAMSI_CAL_SCRIPT.js"></script>
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
            function LeaveScheduleApprove(field){

                if (field.defaultValue == field.value) field.value = '';
                else if (field.value == '') field.value = field.defaultValue;

            }
        </script>
            </head>
            <body id="outputBody1" onload="showCal()" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div style="left: 8px; top: 0px; position: absolute; width: 100%">
                        <img alt="" class="source-image" height="auto" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
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
                                                            <ice:commandLink action="#{EmployeeHistory$EmployeePromote.cmdPromotionRequest_action}"
                                                                id="cmdPromotionRequest" style="color:#306682;font-weight:bold" value="Promotion Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{EmployeeHistory$EmployeePromote.cmdrecPromotionApproval_action}"
                                                                id="cmdrecPromotionApproval" style="color:#306682;font-weight:bold" value="Approve Promotion Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{EmployeeHistory$EmployeePromote.cmdrecPromoteEmployee_action}"
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
                                                <ice:panelGrid id="pgrSegetion" width="100%">
                                                    <ice:panelGroup id="pgPromotionSegestion" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:300px; width: 100%">
                                                        <ice:panelLayout id="lyPromotionSegetion" style="border-style: none; background-color: transparent; height: 78px; position: absolute; width: 100%">
                                                            <ice:outputText id="lblSelectDate" style=" color:#ba7109 " value="Employee Not Promoted IN Two Years"/>
                                                            <ice:commandButton action="#{EmployeeHistory$EmployeePromote.buttonDisplayCriteria_action}"
                                                                binding="#{EmployeeHistory$EmployeePromote.buttonDisplayCriteria}"
                                                                id="buttonDisplayCriteria" value="Display Criteria "/>
                                                            <ice:selectOneListbox binding="#{EmployeeHistory$EmployeePromote.selectOneListbox1}"
                                                                id="selectOneListbox1" partialSubmit="true" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); height: 223px; left: 10px; top: 60px; position: absolute; width: 182px"
                                                                value="#{EmployeeHistory$EmployeePromote.defaultSelectedData7.selectedObject}" valueChangeListener="#{EmployeeHistory$EmployeePromote.selectOneListbox1_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems1" value="#{EmployeeHistory$EmployeePromote.qualifiedIndividualsBasedOnYear}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="panelCollapsibleHistory">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup4History" styleClass="">
                                                        <ice:outputText id="lblSearchHistory" value="Promotion History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid111" width="100%">
                                                    <ice:panelGroup id="status_Group12" style="border-style: none; margin: -5px -5px -5px -10px; padding: 7px; background-color: transparent; display: block; float: left; height: 250px; left: -5px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer12" style="border-style: none; background-color: transparent; height: 78px; position: absolute; width: 100%">
                                                            <ice:outputText id="lblPromotedEmps12" style=" color:#ba7109 " value="Promoted Employees History"/>
                                                            <ice:selectOneListbox
                                                                binding="#{EmployeeHistory$EmployeePromote.selectOneListbox1IndividualHistory}"
                                                                id="selectOneListbox1IndividualHistory" partialSubmit="true" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); height: 200px; left: 10px; top: 20px; position: absolute; width: 182px"
                                                                value="#{EmployeeHistory$EmployeePromote.defaultSelectedData5.selectedObject}" valueChangeListener="#{EmployeeHistory$EmployeePromote.selectOneListbox1IndividualHistory_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{EmployeeHistory$EmployeePromote.promotedIndividuals}"/>
                                                            </ice:selectOneListbox>
                                                            <ice:commandButton action="#{EmployeeHistory$EmployeePromote.btnReport_action}"
                                                                id="btnReport" style="left: 20px; top: 220px; position: absolute" value="Preview on Report "/>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 840px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 750px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 800px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Promote Military Employees"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 780px; left: 0px; top: -8px; position: absolute; width: 100%">
                                                <ice:panelGroup id="leaveRequest" style="height: 740px; left: 2px; top: -10px; position: absolute; width: 95%" styleClass="filedset_normal">
                                                    <ice:panelLayout id="panelDetail12" style="border: 1px solid rgb(204, 204, 204); height: 370px; left: 5px; top: 10px; position: absolute; width: 740px">
                                                        <ice:outputText id="outputText3"
                                                            style="font-siz: 11px; font-weight: bold; left: 20px; top: 10px; position: absolute" value="EMPLOYEE INFORMATION  "/>
                                                        <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EmployeePromote.choDisplayOnPage}"
                                                            id="choDisplayOnPage" partialSubmit="true"
                                                            style="font-size: 11px; font-weight: bold; left: 250px; top: 10px; position: absolute"
                                                            value="#{EmployeeHistory$EmployeePromote.defaultSelectedData23.selectedBoolean}" valueChangeListener="#{EmployeeHistory$EmployeePromote.choDisplayOnPage_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EmployeePromote.choPrivewOnReport}"
                                                            id="choPrivewOnReport" partialSubmit="true"
                                                            style="font-size: 11px; font-weight: bold; left: 380px; top: 10px; position: absolute"
                                                            value="#{EmployeeHistory$EmployeePromote.defaultSelectedData24.selectedBoolean}" valueChangeListener="#{EmployeeHistory$EmployeePromote.choPrivewOnReport_processValueChange}"/>
                                                        <ice:outputText id="outputText4" style="font-size: 12px; left: 38px; top: 65px; position: absolute" value="EmployeeId:"/>
                                                        <ice:outputText id="outputText5" style="font-size: 12px; left: 38px; top: 105px; position: absolute" value="Full Name"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EmployeePromote.txtEmployeeID}" id="txtEmployeeID" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 65px; position: absolute; width: 145px"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EmployeePromote.btnSearch_action}" id="btnSearch"
                                                            style="left: 310px; top: 55px; position: absolute; width: 105px" value="Search"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EmployeePromote.lblFullName}" escape="false"
                                                            id="lblFullName" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 105px; position: absolute; width: 260px"/>
                                                        <ice:outputText id="outputText6" style="font-size: 12px; left: 35px; top: 145px; position: absolute" value="Gender"/>
                                                        <ice:outputText id="outputText8" style="font-size: 12px; left: 184px; top: 145px; position: absolute" value="Male "/>
                                                        <ice:outputText id="outputText10" style="font-size: 12px; left: 290px; top: 145px; position: absolute" value="Female "/>
                                                        <ice:outputText id="lblDepartment" style="font-size: 12px; left: 35px; top: 185px; position: absolute" value="Department "/>
                                                        <ice:outputText binding="#{EmployeeHistory$EmployeePromote.lblDepartmentDes}"
                                                            id="lblDepartmentDes" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 178px; position: absolute; width: 356px"/>
                                                        <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EmployeePromote.choMale}" disabled="true"
                                                            id="choMale" partialSubmit="true"
                                                            style="background-color: rgb(242, 246, 240); left: 150px; top: 145px; position: absolute" value="#{EmployeeHistory$EmployeePromote.defaultSelectedData8.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EmployeePromote.choFemale}"
                                                            disabled="true" id="choFemale" partialSubmit="true"
                                                            style="background-color: rgb(242, 246, 240); left: 257px; top: 145px; position: absolute" value="#{EmployeeHistory$EmployeePromote.defaultSelectedData9.selectedBoolean}"/>
                                                        <ice:graphicImage binding="#{EmployeeHistory$EmployeePromote.imgMember}" height="213"
                                                            id="imgMember"
                                                            style="border: 1px solid rgb(153, 153, 153); height: 205px; left: 525px; top: 24px; position: absolute"
                                                            url="/Employee/images/blank.gif" width="190"/>
                                                        <ice:outputText id="outputText13" style="font-size: 12px; left: 35px; top: 245px; position: absolute" value="Job Position "/>
                                                        <ice:outputText binding="#{EmployeeHistory$EmployeePromote.lblJobPosition}" id="lblJobPosition" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 245px; position: absolute; width: 260px"/>
                                                        <ice:outputText id="outputText15" style="font-size: 12px; left: 444px; top: 245px; position: absolute" value="Hire Date"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EmployeePromote.lblHireDate}" id="lblHireDate" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 525px; top: 245px; position: absolute; width: 205px"/>
                                                        <ice:outputText id="outputText17" style="font-size: 12px; left: 33px; top: 285px; position: absolute" value="Total Service Year"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EmployeePromote.lblTotalServiceYear}" escape="false"
                                                            id="lblTotalServiceYear" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 285px; position: absolute; width: 260px"/>
                                                        <ice:outputText escape="false" id="lblRankDescription"
                                                            style="font-size: 12px; left: 444px; top: 285px; position: absolute" value="Rank"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EmployeePromote.lblRankDescr}" escape="false"
                                                            id="lblRankDescr" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 525px; top: 285px; position: absolute; width: 205px"/>
                                                        <ice:outputText id="outputText11" style="font-size: 12px; left: 33px; top: 325px; position: absolute" value="#{msgs.PayGrade}"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EmployeePromote.lblPayGrade}" id="lblPayGrade" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 325px; position: absolute; width: 260px"/>
                                                        <ice:outputText id="lblOldSalarylebel"
                                                            style="font-size: 12px; left: 444px; top: 325px; position: absolute" value="Salary"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EmployeePromote.lblOldSalary}" id="lblOldSalary" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 525px; top: 325px; position: absolute; width: 205px"/>
                                                        <ice:outputText id="lblDisplayOnPage"
                                                            style="font-size: 12px; left: 270px; top: 10px; position: absolute" value="Preview on Page "/>
                                                        <ice:outputText id="outputText42" style="font-size: 12px; left: 400px; top: 10px; position: absolute" value="Preview on Report "/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="PanelLayOutPromoteEmployeeSetting"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 280px; left: 5px; top: 400px; position: absolute; width: 740px" styleClass="insideContainerMain">
                                                        <ice:outputText id="outputText7"
                                                            style="font-size: 11px; font-weight: bold; left: 20px; top: 10px; position: absolute" value="Promote To"/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EmployeePromote.drlZerf}" disabled="true"
                                                            id="drlZerf" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 30px; position: absolute; width: 190px"
                                                            value="#{EmployeeHistory$EmployeePromote.defaultSelectedData10.selectedObject}" valueChangeListener="#{EmployeeHistory$EmployeePromote.drlZerf_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems4" value="#{EmployeeHistory$EmployeePromote.zerf}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EmployeePromote.drlDirectorate}" disabled="true"
                                                            id="drlDirectorate" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 523px; top: 30px; position: absolute; width: 190px"
                                                            value="#{EmployeeHistory$EmployeePromote.selectOneMenu2Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EmployeePromote.drlDirectorate_processValueChange}">
                                                            <f:selectItems id="selectOneMenu2selectItems" value="#{EmployeeHistory$EmployeePromote.directorate}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EmployeePromote.drlDivision}" disabled="true"
                                                            id="drlDivision" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 70px; position: absolute; width: 190px"
                                                            value="#{EmployeeHistory$EmployeePromote.selectOneMenu3Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EmployeePromote.drlDivision_processValueChange}">
                                                            <f:selectItems id="selectOneMenu3selectItems" value="#{EmployeeHistory$EmployeePromote.devision}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EmployeePromote.drlMastebaberia}" disabled="true"
                                                            id="drlMastebaberia" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 523px; top: 70px; position: absolute; width: 190px"
                                                            value="#{EmployeeHistory$EmployeePromote.selectOneMenu4Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EmployeePromote.drlMastebaberia_processValueChange}">
                                                            <f:selectItems id="selectOneMenu4selectItems" value="#{EmployeeHistory$EmployeePromote.mastebaberi}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EmployeePromote.drlTeam}" disabled="true"
                                                            id="drlTeam" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 110px; position: absolute; width: 190px"
                                                            value="#{EmployeeHistory$EmployeePromote.selectOneMenu5Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EmployeePromote.drlTeam_processValueChange}">
                                                            <f:selectItems id="selectOneMenu5selectItems" value="#{EmployeeHistory$EmployeePromote.team}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputText19" style="font-size: 10px; left: 31px; top: 30px; position: absolute" value="#{msgs.Zerf}"/>
                                                        <ice:outputText id="outputText20" style="font-size: 10px; left: 414px; top: 30px; position: absolute" value="#{msgs.Directorate }"/>
                                                        <ice:outputText id="outputText21" style="font-size: 10px; left: 31px; top: 70px; position: absolute" value="#{msgs.Division}"/>
                                                        <ice:outputText id="outputText22" style="font-size: 10px; left: 414px; top: 70px; position: absolute" value="#{msgs.MASTEBABERIYA}"/>
                                                        <ice:outputText id="outputText23" style="font-size: 10px; left: 31px; top: 110px; position: absolute" value="#{msgs.Team}"/>
                                                        <ice:outputText id="outputText24" style="font-size: 10px; left: 414px; top: 110px; position: absolute" value="#{msgs.JobCode}"/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EmployeePromote.drlProfession}" disabled="true"
                                                            id="drlProfession" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 523px; top: 110px; position: absolute; width: 190px" value="#{EmployeeHistory$EmployeePromote.selectOneMenu6Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu6selectItems" value="#{EmployeeHistory$EmployeePromote.perofation}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputText25" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; height: 10px; left: 10px; top: 140px; position: absolute; width: 720px"/>
                                                        <ice:outputText id="outputText26" style="font-size: 10px; left: 414px; top: 172px; position: absolute" value="#{msgs.Title}"/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EmployeePromote.drlTitle}" disabled="true"
                                                            id="drlTitle" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 523px; top: 172px; position: absolute; width: 190px" value="#{EmployeeHistory$EmployeePromote.selectOneMenu7Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu7selectItems" value="#{EmployeeHistory$EmployeePromote._title}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputText27" style="font-size: 10px; left: 31px; top: 172px; position: absolute" value="Employee Type"/>
                                                        <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EmployeePromote.choMilitary}"
                                                            disabled="true" id="choMilitary" partialSubmit="true"
                                                            style="background-color: rgb(242, 246, 240); left: 150px; top: 172px; position: absolute"
                                                            value="#{EmployeeHistory$EmployeePromote.defaultSelectedData11.selectedBoolean}" valueChangeListener="#{EmployeeHistory$EmployeePromote.choMilitary_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EmployeePromote.choCivil}" disabled="true"
                                                            id="choCivil" partialSubmit="true"
                                                            style="background-color: rgb(242, 246, 240); left: 257px; top: 172px; position: absolute"
                                                            value="#{EmployeeHistory$EmployeePromote.defaultSelectedData12.selectedBoolean}" valueChangeListener="#{EmployeeHistory$EmployeePromote.choCivil_processValueChange}"/>
                                                        <ice:outputText id="outputText29" style="font-size: 12px; left: 184px; top: 172px; position: absolute" value="Military"/>
                                                        <ice:outputText id="outputText28" style="font-size: 12px; left: 290px; top: 172px; position: absolute" value="Civil "/>
                                                        <ice:outputText id="outputText30" style="font-size: 10px; left: 31px; top: 212px; position: absolute" value="#{msgs.RankId}"/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EmployeePromote.drlRankId}" disabled="true"
                                                            id="drlRankId" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 212px; position: absolute; width: 190px"
                                                            value="#{EmployeeHistory$EmployeePromote.selectOneMenu8Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EmployeePromote.drlRankId_processValueChange}">
                                                            <f:selectItems id="selectOneMenu8selectItems" value="#{EmployeeHistory$EmployeePromote._jobRank}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputText31" style="font-size: 10px; left: 414px; top: 212px; position: absolute" value="#{msgs.PayGrade}"/>
                                                        <ice:outputText id="outputText32" style="font-size: 10px; left: 31px; top: 252px; position: absolute" value="#{msgs.Salary}"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EmployeePromote.lblSalary}" id="lblSalary"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 253px; position: absolute; width: 190px" value="outputText"/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EmployeePromote.drlPayGrade}" disabled="true"
                                                            id="drlPayGrade" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 523px; top: 212px; position: absolute; width: 190px"
                                                            value="#{EmployeeHistory$EmployeePromote.selectOneMenu9Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EmployeePromote.drlPayGrade_processValueChange}">
                                                            <f:selectItems id="selectOneMenu9selectItems" value="#{EmployeeHistory$EmployeePromote.payGradeOpt}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:inputText binding="#{EmployeeHistory$EmployeePromote.txtPromotionDate}"
                                                            id="txtPromotionDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 523px; top: 253px; position: absolute; width: 190px"/>
                                                        <ice:outputText id="lblPromotionDate"
                                                            style="font-size: 10px; left: 414px; top: 252px; position: absolute" value="Promotion Date:"/>
                                                        <ice:commandButton id="btnCalender" image="/Employee/images/calendar.gif"
                                                            onclick="getId('form1:txtPromotionDate'),getVisual(event);"
                                                            style="left: 696px; top: 255px; position: absolute" value="submit"/>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                                <ice:panelLayout id="PanelLayOutInsidVacancyListRequesterButton"
                                                    style="height: 40px; margin-left: 25px; margin-top: 700px; position: absolute; width: 740px" styleClass="insideContainerMain">
                                                    <ice:commandButton action="#{EmployeeHistory$EmployeePromote.btnPromote_action}"
                                                        binding="#{EmployeeHistory$EmployeePromote.btnPromote}" disabled="true" id="btnPromote"
                                                        style="margin-left: 50px; position: absolute; width: 80px" value="Promote"/>
                                                    <ice:commandButton action="#{EmployeeHistory$EmployeePromote.btnUpdate_action}"
                                                        binding="#{EmployeeHistory$EmployeePromote.btnUpdate}" disabled="true" id="btnUpdate"
                                                        style="margin-left: 300px; position: absolute; width: 80px" value="Update"/>
                                                    <ice:commandButton action="#{EmployeeHistory$EmployeePromote.btnCancel_action}"
                                                        binding="#{EmployeeHistory$EmployeePromote.btnCancel}" disabled="true" id="btnCancel"
                                                        style="margin-left: 580px; position: absolute; width: 80px" value="Cancel"/>
                                                </ice:panelLayout>
                                                <ice:inputText binding="#{EmployeeHistory$EmployeePromote.inputTextAdvertID}" id="inputTextAdvertID" rendered="false"/>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label style="margin-left:20px;color:white;font-weight:bold;font-family:Narkisim">Federal Police Commission.Human Resource Management And Integrated Payroll System.</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$EmployeePromote.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="House of Peoples Representative Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{EmployeeHistory$EmployeePromote.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{EmployeeHistory$EmployeePromote.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$EmployeePromote.evaResultPopUpMsg}" draggable="true"
                            id="evaResultPopUpMsg" modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 380px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridevaResultPopUpMsg" style="display: block; height: 20px; width: 277px">
                                    <ice:outputText id="lblevaResultPopUpMsgTitle" value="Set Evaluation Criteria"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupevaResultPopUpMsgBody" style="display: block; height: 94px; position: relative; width: 340">
                                    <ice:panelLayout id="PanelLayOutevaResultPopUpMsg"
                                        style="height: 100px; margin-left: 0px; margin-top: -5px; overflow: auto; position: absolute; width: 340px" styleClass="insideContainerMain">
                                        <ice:outputText id="outputText14evaResultPopUpMsg" style="left: 10px; top: 12px;  position: absolute;"
                                            styleClass="insideInputTextAnyPerfo" value="Select Session:"/>
                                        <ice:selectOneMenu binding="#{EmployeeHistory$EmployeePromote.selectOneMenu1evaResultPopUpMsg}"
                                            id="selectOneMenu1evaResultPopUpMsg" partialSubmit="true" style=" border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width:200px; left: 110px; top: 10px; position: absolute">
                                            <f:selectItems id="selectOneMenu1selectItems" value="#{EmployeeHistory$EmployeePromote.toFilterResultUsingSession}"/>
                                        </ice:selectOneMenu>
                                        <ice:outputText id="outputText14evaResultNoteIssue" style="color: red ;left: 10px; top: 60px;  position: absolute;"
                                            styleClass="insideInputTextAnyPerfo" value="Notes and Issue:"/>
                                        <ice:outputText binding="#{EmployeeHistory$EmployeePromote.outputText14evaResultNoteIssueVal}"
                                            id="outputText14evaResultNoteIssueVal" style="color: black ;left: 10px; top: 80px;  position: absolute;"
                                            styleClass="insideInputTextAnyPerfo" value="Val"/>
                                        <ice:commandButton action="#{EmployeeHistory$EmployeePromote.btnOK_action}"
                                            binding="#{EmployeeHistory$EmployeePromote.btnOK}" id="btnOK"
                                            style="left: 200px; top: 40px;  position: absolute; height: 25px; font-size: 10px; width: 50px" value="Ok"/>
                                        <ice:commandButton action="#{EmployeeHistory$EmployeePromote.btnCancel1_action}"
                                            binding="#{EmployeeHistory$EmployeePromote.btnCancel1}" id="btnCancel1"
                                            style="left: 255px; top: 40px;  position: absolute; height: 25px; font-size: 10px; width: 60px" value="Cancel"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup binding="#{EmployeeHistory$EmployeePromote.panelPopup1}" draggable="true" id="panelPopup1" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 300px; left: 300px; top: 400px; position: absolute; width: 517px" visible="true">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid2" style="background-color: rgb(48, 102, 130); height: 20px; left: 0px; padding-top: 8px; width: 705px">
                                    <ice:outputText id="outputText2" style="color: #ffffff" value="Federal Police Human Resource Management:Display Criteria"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupDisplayCriteria" style="display: block; height: 280px; position: relative; width: 677px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlDisplayCriteriaBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 245px; position: relative; width: 610px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel id="lblFormDisplayCriteria" style="background-color: #F5F5F5;"/>
                                        <ice:panelLayout id="lyExameDisplayCriteria" style="border: 1px solid rgb(204, 204, 204); height: 250px; margin-left: 10px; margin-top: 0px; left: 0px; top: 10px; position: absolute; width: 655px">
                                            <ice:outputText id="outputText9"
                                                style="font-style: normal; font-weight: bold; left: 10px; top: 5px; position: absolute" value="Promotion Selection Criteria "/>
                                            <ice:outputText id="outputText12"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 50px; top:80px; position: absolute" value="Total Service"/>
                                            <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EmployeePromote.selectBooleanCheckbox1TotalService1}"
                                                id="selectBooleanCheckbox1TotalService1" immediate="true" partialSubmit="true"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 15px; top: 85px; position: absolute" value="#{EmployeeHistory$EmployeePromote.defaultSelectedData17.selectedBoolean}"/>
                                            <ice:inputText binding="#{EmployeeHistory$EmployeePromote.inputTextPOPTotalS}" id="inputTextPOPTotalS" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 245px; top: 82px; position: absolute; width: 60px"/>
                                            <ice:outputText id="outputText14"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 400px; top: 40px; position: absolute" value="Include employee with minor discipline issue"/>
                                            <ice:outputText id="outputText16"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 50px; top:40px; position: absolute" value="Employees promoted"/>
                                            <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EmployeePromote.selectBooleanCheckboxIncProWith}"
                                                id="selectBooleanCheckboxIncProWith" immediate="true" partialSubmit="true"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 15px; top: 45px; position: absolute" value="#{EmployeeHistory$EmployeePromote.defaultSelectedData19.selectedBoolean}"/>
                                            <ice:inputText binding="#{EmployeeHistory$EmployeePromote.inputTextPOPIncPromWith}"
                                                id="inputTextPOPIncPromWith" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 265px; top: 42px; position: absolute; width: 40px"/>
                                            <ice:selectBooleanCheckbox id="selectBooleanCheckbox2" partialSubmit="true"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 360px; top: 45px; position: absolute" value="#{EmployeeHistory$EmployeePromote.defaultSelectedData18.selectedBoolean}"/>
                                            <ice:outputText id="outputText18"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 400px; top: 82px; position: absolute" value="Include employee with major discipline issue"/>
                                            <ice:outputText id="outputText33"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 310px; top: 40px; position: absolute" value="Year"/>
                                            <ice:selectBooleanCheckbox id="selectBooleanCheckbox4" partialSubmit="true"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 360px; top: 85px; position: absolute" value="#{EmployeeHistory$EmployeePromote.defaultSelectedData20.selectedBoolean}"/>
                                            <ice:outputText id="outputText34"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 310px; top: 82px; position: absolute" value="Year"/>
                                            <ice:outputText id="outputText35"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 50px; top: 122px; position: absolute" value="Evaluation Result  "/>
                                            <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EmployeePromote.choPerformance}" id="choPerformance"
                                                immediate="true" partialSubmit="true"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 15px; top: 125px; position: absolute"
                                                value="#{EmployeeHistory$EmployeePromote.selectBooleanCheckbox5Bean.selectedBoolean}" valueChangeListener="#{EmployeeHistory$EmployeePromote.choPerformance_processValueChange}"/>
                                            <ice:inputText binding="#{EmployeeHistory$EmployeePromote.inputTextPOPPerformance}"
                                                id="inputTextPOPPerformance" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 245px; top: 122px; position: absolute; width: 60px"/>
                                            <ice:commandButton action="#{EmployeeHistory$EmployeePromote.buttonSelectCSEmp_action}"
                                                id="buttonSelectCSEmp" style="left: 20px; top: 200px; position: absolute; width: 80px; eft: 30.0px;" value="Select"/>
                                            <ice:outputText id="outputText36"
                                                style="color: #333300; font-size: 12px; font-style: normal; font-weight: bold; left: 150px; top: 122px; position: absolute" value="&gt;"/>
                                            <ice:outputText id="outputText37"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 50px; top: 164px; position: absolute" value="Employee not discipline issue with in "/>
                                            <ice:selectBooleanCheckbox binding="#{EmployeeHistory$EmployeePromote.selectBooleanCheckboxDicipCrit}"
                                                id="selectBooleanCheckboxDicipCrit" partialSubmit="true"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 15px; top: 165px; position: absolute" value="#{EmployeeHistory$EmployeePromote.defaultSelectedData22.selectedBoolean}"/>
                                            <ice:inputText binding="#{EmployeeHistory$EmployeePromote.inputTextDicipCri}" id="inputTextDicipCri" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 245px; top: 160px; position: absolute; width: 60px"/>
                                            <ice:outputText id="outputText38"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 310px; top: 165px; position: absolute" value="Year"/>
                                            <ice:inputText binding="#{EmployeeHistory$EmployeePromote.inputTextPromoteFrequency}"
                                                id="inputTextPromoteFrequency" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 42px; position: absolute; width: 30px"/>
                                            <ice:outputText id="outputText39"
                                                style="font-size: 10px; font-style: normal; font-weight: lighter; left: 185px; top: 40px; position: absolute" value="'s  Not Promoted in"/>
                                            <ice:selectOneMenu binding="#{EmployeeHistory$EmployeePromote.selectOneMenuSelectSessionIn}" disabled="true"
                                                id="selectOneMenuSelectSessionIn" partialSubmit="true"
                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 450px; top: 120px; position: absolute; width: 180px"
                                                value="#{EmployeeHistory$EmployeePromote.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{EmployeeHistory$EmployeePromote.selectOneMenuSelectSessionIn_processValueChange}">
                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{EmployeeHistory$EmployeePromote.toFilterResultUsingSession}"/>
                                            </ice:selectOneMenu>
                                            <ice:outputText binding="#{EmployeeHistory$EmployeePromote.outputText14evaResultPopUpMsg1}"
                                                id="outputText14evaResultPopUpMsg1"
                                                style="font-style: normal; font-weight: lighter; left: 350px; top: 120px; position: absolute; font-size: 10.0px;" value="Select Session:"/>
                                            <ice:outputText id="outputText40"
                                                style="color: rgb(255, 51, 51); font-size: 10px; font-style: normal; font-weight: lighter; left: 110px; top: 230px; position: absolute" value="Note:  All the above text boxes should be filled only with positive integers otherwise error will issued!!!!"/>
                                            <ice:outputText id="outputText41"
                                                style="color: rgb(51, 51, 0); font-size: 12px; font-style: normal; font-weight: bold; left: 150px; top: 82px; position: absolute" value="&gt;"/>
                                        </ice:panelLayout>
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
