<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Home
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : modified by Bravo Zulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Human Resource Management System</title>
                <ice:outputStyle href="./resources/home/layout.css" id="outputStyle3"/>
                <ice:outputStyle href="./resources/home/skinn.css" id="outputStyle4"/>
                <script src="./resources/home/scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
                <script src="./resources/home/scripts/jquery.jcarousel.pack.js" type="text/javascript"></script>
                <script src="./resources/home/scripts/jquery.jcarousel.setup.js" type="text/javascript"></script>
                <script src="./resources/home/scripts/jquery.jcarousel.setupNumbers.js" type="text/javascript"></script>
                <!-- <link HREF="./resources/images/header_icon.ico" REL="icon"/>-->
            </head>
            <body id="top" style="-rave-layout: grid">
                <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
                <ice:form id="form1">
                    <ice:outputStyle href="./resources/home/layout.css" id="outputStyle3"/>
                    <script src="./resources/home/scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
                    <script src="./resources/home/scripts/jquery.jcarousel.pack.js" type="text/javascript"></script>
                    <script src="./resources/home/scripts/jquery.jcarousel.setup.js" type="text/javascript"></script>
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{Home.panelBorder1Bean.renderCenter}"
                        renderEast="#{Home.panelBorder1Bean.renderEast}" renderNorth="#{Home.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Home.panelBorder1Bean.renderSouth}" renderWest="#{Home.panelBorder1Bean.renderWest}"
                        style="border-style: none; left:180px;top: 0px; position: relative; text-align: center" styleClass="whole_page">
                        <f:facet name="north">
                            <ice:panelGroup dragListener="#{Home.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
                                <ice:panelLayout id="header" layout="flow"
                                    style="height: 100px; left: -100px; top:20px;position: relative; width: 1024px; -rave-layout: grid" styleClass="header" visible="true">
                                    <div id="header">
                                        <!--   <div class="logo" id="logo1">
                                            <ice:graphicImage height="156" id="graphicImage1" style="left: 100px; top: -20px; position: absolute"
                                                url="/resources/images/LOGO_2_1.png" width="138"/>
                                        </div> -->
                                        <!--   <ul id="nav">

                                            <li class="">
                                                <a class="normal" href="http://192.168.50.3/HRMS/Employee/EmployeePage.jsp"
                                                    style="background-position: -140px 0pt;" title="Overview">Employee<span>profiles</span>
                                                </a>
                                            </li>
                                            <li class="">
                                                <a class="work" href="http://192.168.10.172/HRMS/Leave/LeaveRequestPage.jsp" style="background-position: -140px 0pt;">Leave<span>leave request</span>
                                                </a>
                                            </li>

                                            <li class="">
                                                <a href="http://192.168.10.172/HRMS/Training/TrainingNeedAssessementRequestPage.jsp">Training<span>training request</span>
                                                </a>
                                            </li>
                                            <li class="">
                                                <a href="http://192.168.10.172/HRMS/pageSecurity/PageAdmin.jsp">Admin<span>manage resource</span>
                                                </a>
                                            </li>
                                        </ul> -->
                                    </div>
                                    <!-- <div id="topPanel">
                                        <img id="FPtext" src="./resources/images/Mug7her_HEADER.png" style="margin-left:-15px;"/>
                                        <ul>
                                            <li>
                                                <a href="#">Admin</a>
                                            </li>
                                            <li>
                                                <a href="#">Help</a>
                                            </li>
                                            <li class="active">
                                                <a class="active" href="#">Home</a>
                                            </li>
                                        </ul>
                                    </div>-->
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 380px; width: 1024px;">
                                <ice:panelLayout id="container" layout="flow"
                                    style="border:none;height: 370px; left: 0px; position: relative; width: 1024px; -rave-layout: grid;visibility: visible;visibility: visible;visibility: visible;"
                                    styleClass="page_display" visible="true">
                                    <fieldset class="filedset_css" style="height: 370px;border:none;background:none;">
                                        <ice:panelLayout id="pnProfile" style="border-style: none; left: 0px;  position: absolute; width: 800px">
                                            <!-- ####################################################################################################### -->
                                            <div id="featured_slide2" style="border:none;">
                                                <div id="featured_slide" style="border:none;">
                                                    <div id="featured_content" style="border:none;">
                                                        <ul>
                                                            <li>
                                                                <div class="floater" style="height:450px">
                                                                    <ice:panelLayout id="pnlChart"
                                                                        style="font-size: 12px; height: 400px; margin-top: -50px; position: absolute; width: 381px" styleClass="moduleDescriptionHOME">
                                                                        <ice:outputChart chartTitle="BUNNA INTERNATIONAL BANK Employees Information"
                                                                            colors="#{pieChartBean.paints}" data="#{pieChartBean.data}" height="250"
                                                                            id="pieOutputChart" labels="#{pieChartBean.labels}"
                                                                            renderOnSubmit="#{pieChartBean.newChart}" style="border-style: none; " type="pie2D" width="350"/>
                                                                    </ice:panelLayout>
                                                                    <div class="moduleLinksHOME" style="margin-top:10px;">
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:10px;margin-left:-80px">
                                                                        Welcome to <br/>BUNNA INTERNATIONAL BANK <br/>Human Resource Management System.</p>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px;">
                                                                        <p style="left:30px">ORGANIZATION PROFILE</p>
                                                                    </h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/Stracture.jpg" style=" float:left;margin-top:5px; width:100px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">This module deals with managing the organizational structure and
                                                                        Controlling job performed with their Department.</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdOrganization_action}" id="cmdOrganization"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Organization Structure"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdJobType_action}" id="cmdJobType"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Job Type"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdJobTypeQualification_action}"
                                                                                id="cmdJobTypeQualification"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Job Qualifications "/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdPayGrade_action}" id="cmdPayGrade"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Pay Grade"/>
                                                                        </span>
                                                                        <!--  <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdIncrementSalary_action}" id="cmdIncrementSalary"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Increment Salary"/>
                                                                        </span>-->
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">RECRUITING MANAGEMENT</h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/recritment.jpg" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">This module offers advanced tools to hold recruiters information and facilitate hiring process .</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdRecruitmentRequest_action}"
                                                                                id="cmdRecruitmentRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Recruitment Request"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdApprovedRecruitmentList_action}"
                                                                                id="cmdApprovedRecruitmentList"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Recruitment Approve"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdMaintainAdvertisement_action}"
                                                                                id="cmdMaintainAdvertisement"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Maintain Advertisement"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdVacancyNotice_action}" id="cmdVacancyNotice"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Internal Vacancy List"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdRegisterCandidate_action}"
                                                                                id="cmdRegisterCandidate"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Register Candidate"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdFilterCandidate_action}" id="cmdFilterCandidate"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Filter Candidate"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdFilterCandidateForExam_action}"
                                                                                id="cmdExamQuestions"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="View Registerd Candidate"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">
                                                                    EMPLOYEE PROFILE </h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/employeeProfile.png" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">
                                                                        This module handles employees registration,keep profile information and history.</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdEmployeeProfile_action}" id="cmdEmployeeProfile"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Employee "/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdTransfer_action}" id="cmdTransfer"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="TransferRequest"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdTransferApprove_action}" id="cmdTransferApprove"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="TransferApprove"/>
                                                                        </span>
                                                                        <!--  <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdEvaluation_action}" id="cmdEvaluation"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Evaluation"/>
                                                                        </span>-->
                                                                        <!--  <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdTransferHistory_action}" id="cmdTransferHistory"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Transfer/Promotion History"/>
                                                                        </span> -->
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <!--  <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">
                                                                    EMPLOYEE HISTORY </h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/employeeProfile.png" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">
                                                                        This module handles employees history activity,starting the day he/she has hired .</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>

                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdPromotionRequest_action}"
                                                                                id="cmdPromotionRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Promotion Request"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdApprovePromotionRequest_action}"
                                                                                id="cmdApprovePromotionRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Approve Promotion Request"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdPromoteEmployees_action}"
                                                                                id="cmdPromoteEmployees"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Promote Employees"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.ccmdPromoteReport_action}" id="cmdPromoteReport"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Promote Report"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li> -->
                                                            <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">
                                                                    EMPLOYEE HISTORY </h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/employeeProfile.png" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">
                                                                        This module handles employees Leave  .</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdLeaveType_action}" id="cmdLeaveType"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Leave Type"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdLeaveRequest_action}" id="cmdLeaveRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Leave Request"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdLeaveApprove_action}" id="cmdLeaveApprove"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Leave Approve"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdLeaveBalance_action}" id="cmdLeaveBalance"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Leave Balance"/>
                                                                        </span>
                                                                        <!--   <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdLeaveTransfer_action}" id="cmdLeaveTransfer"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Leave Transfer Request"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdLeaveTransferApprove_action}"
                                                                                id="cmdLeaveTransferApprove"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Leave Transfer Approve"/>
                                                                        </span> -->
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">LEAVE</h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/LeaveManage.png" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">
                                                                        This module handles employees Leave .</p>
                                                                    </div>
                                                                    <div class="moduleLinks" style="top:-20px">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkLeaveManagment_action}" id="lnkLeaveManagment"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Manage Employee Leave Status"/>
                                                                        </span>
                                                                        <!--   <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkReturnFromAnnualLeaveRequest_action}"
                                                                                id="lnkReturnFromAnnualLeaveRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Request Return From Leave "/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkReturnFromAnnualLeaveApproave_action}"
                                                                                id="lnkReturnFromAnnualLeaveApproave"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold;" value="Approve Return From Leave Request"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkEmployeeLeaveSechedule_action}"
                                                                                id="lnkEmployeeLeaveSechedule"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold;" value="Employee Leave Sechedule"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkLeaveReport_action}" id="lnkLeaveRepor"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold;" value="Leave Report"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkExtendLeave_action}" id="lnkExtendLeave"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold;" value="Extend Leavee"/>
                                                                        </span> -->
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkAssignEmployeetoHisherBoss_action}"
                                                                                id="lnkAssignEmployeetoHisherBoss"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Assign Employee to His/her Boss"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <!-- <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">
                                                                    BONES </h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/employeeProfile.png" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">
                                                                        This module handles employees Bones Request And Approve .</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnklnkYearlyBonesRequest_action}"
                                                                                id="lnkYearlyBonesRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Yearly Bones Request"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnklnkHolydayBonesRequest_action}"
                                                                                id="lnkHolydayBonesRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Holyday Bones Request"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkApproveBonesRequest_action}"
                                                                                id="lnkApproveBonesRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Approve Bones Request"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkHolydayBonesApprove_action}"
                                                                                id="lnkHolydayHonesApprove"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Holyday Bones Approve"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkEmployeeEvaluationResult_action}"
                                                                                id="lnkEmployeeEvaluationResult"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Employee Evaluation Result"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkBonesReport_action}" id="lnkBonesReport"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Bones Report"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li>-->
                                                            <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">TRAINING MANAGEMENT</h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/EmployeeTraining.jpg" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">This module handles department(s) training request and approval.</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkTrainingRequest_action}" id="lnkTrainingRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Training Request"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkTrainingApproval_action}"
                                                                                id="lnkTrainingApproval"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Training Approval"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkTrainner_action}" id="lnkTrainner"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Training Name Registration"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkActionPlan_action}" id="lnkActionPlan"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Training Action Plan"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkActionPlanCost_action}" id="lnkActionPlanCost"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value=" Action Plan Cost"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkTrainingProgress_action}"
                                                                                id="lnkTrainingProgress"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Training Progress Batch"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkTrainingProgressCost_action}"
                                                                                id="lnkTrainingProgressCost"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Training Progress Cost"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <!-- <li>
                                                             <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">SERVICE ABSENT PAYMENT</h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/EmployeeTraining.jpg" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">This module handles service absent payment request and approval.</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkServiceAbsentPaymentRequest_action}"
                                                                                id="lnkServiceAbsentPaymentRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Service Absent Payment Request"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkServiceAbsentPaymentApproval_action}"
                                                                                id="lnkServiceAbsentPaymentApproval"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Service Absent Payment Approve"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkServiceAbsentRegistration_action}"
                                                                                id="lnkServiceAbsentRegistration"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Service Absent Registration"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkAssignEmployeeInlocation_action}"
                                                                                id="lnkEmployeeLocationAssignment"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value=" Employee Location Assignment"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                           </li>-->
                                                            <!--<li>
                                                                        <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">EDUCATION MANAGEMENT</h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/EmployeeTraining.jpg" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">This module handles department(s) education request and approval.</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:14px;display:block;padding-top:-5px;">
                                                                            <ice:commandLink action="#{Home.lnkEducationRequest_action}"
                                                                                id="lnkEducationRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Education Request"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:12px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkEducationApprove_action}"
                                                                                id="lnkEducationApprove"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Approve  Education Request "/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:12px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkEducationPaymentRequest_action}"
                                                                                id="lnkEducationPaymentRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Education Pre  Payment Request"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:12px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkEducationPaymentApprove_action}"
                                                                                id="lnkEducationPaymentApprove"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Approve Education Pre Payment Request"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:12px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkEducationPostPaymentRequest_action}"
                                                                                id="lnkEducationPostPaymentRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Education Post Payment Request"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:12px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkEducationPostPaymentApprove_action}"
                                                                                id="lnkEducationPostPaymentApprove"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Approve Education Post Payment Request"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:12px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkchangeInstit_action}" id="lnkchangeInstit"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Change Institution  Request"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:12px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkprocessChangeInst_action}"
                                                                                id="lnkprocessChangeInst"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Approve Change Institution  Request"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:12px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkInstitutioRegstration_action}"
                                                                                binding="#{Home.lnkInstitutioRegstration}" id="lnkInstitutioRegstration"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Institution Registration"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:12px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkAgreementAndDuty_action}"
                                                                                binding="#{Home.lnkAgreementAndDuty}" id="lnkAgreementAndDuty"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Register Agreemnt"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li>-->
                                                            <!--   <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px;">
                                                                        <p style="left:30px">DISCIPLINE MANAGEMENT</p>
                                                                    </h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/disciplineicon.JPG" style=" float:left;margin-top:5px; width:100px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">This module deals with managing discipline issues raised in the enterprise.</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdDisciplineRequest_action}"
                                                                                id="cmdDisciplineRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Discipline Request"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdDisciplineApproval_action}"
                                                                                id="cmdDisciplineApprove"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Discipline Approval"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdAccusedDefence_action}" id="cmdAccusedDefence"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Accused Defence"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkDisciplineTypes_action}" id="lnkDisciplineTypes"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Discipline Types"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkPenaltyTypes_action}" id="lnkPenaltyTypes"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Penalty Types"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkDisciplinePenaltyTypes_action}"
                                                                                id="lnkDisciplinePenaltyTypes"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Discipline Penalty"/>
                                                                        </span>

                                                                    </div>
                                                                </div>
                                                            </li>-->
                                                            <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px;">
                                                                        <p style="left:30px">Power Deligation</p>
                                                                    </h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/disciplineicon.JPG" style=" float:left;margin-top:5px; width:100px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">This module deals with managing power and Salary Deligation  issues raised in the enterprise.</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdPowerDeligationRequest_action}"
                                                                                id="cmdPowerDeligationRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Power Deligation Request"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdPowerDeligationApprove_action}"
                                                                                id="cmdPowerDeligationApprove"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Power Deligation Approve"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdSalaryDeligationRequest_action}"
                                                                                id="cmdSalaryDeligationRequest"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Salary Deligation Request"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdSalaryDeligationApprove_action}"
                                                                                id="cmdSalaryDeligationApprove"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Salary Deligation Approve"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdViewPowerDelegationReport_action}"
                                                                                id="cmdViewPowerDelegationReport"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="View Power Delegation Approve"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">
                                                                    Evaluation</h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/Administration.png" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">
                                                                        This module handles The Evaluation of Employee</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkEvaluation_action}" id="lnkEvaluation"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Employee Evaluation"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">
                                                                    COMMITTEE</h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/Administration.png" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">
                                                                        This module handles registration of Committees and Members</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkCommittee_action}" id="lnkCommittee"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Committee Formation"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkCommitteeMember_action}" id="lnkCommitteeMember"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Committee Type Registration"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">
                                                                    BENEFIT</h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/Administration.png" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">
                                                                        This module handles registration of Benefit</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkBenefitType_action}" id="lnkBenefitType"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Benefit Types"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkPositionBenefit_action}" id="lnkPositionBenefit"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Benefit for Each Postion"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <!--  <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">
                                                                    REPORT GENERATION CRITIREA </h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/Administration.png" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">
                                                                        This Module Handles Generation of Reports </p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkReportCritera_action}" id="lnkReportCritera"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Report Genration Critera"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkReportPageList_action}" id="lnkReportpageList"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Report Page List Registration"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li> -->
                                                            <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">
                                                                    TERMINATION</h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/Administration.png" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">
                                                                        This module handles Termination Process</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <!--<span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkTerminationClearaceSetting_action}"
                                                                                id="lnkTerminationClearaceSetting"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Termination Clearace Setting"/>
                                                                        </span> -->
                                                                        <!--  <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkTerminationClearance_action}"
                                                                                id="lnkTerminationClearance"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Termination Clearance"/>
                                                                        </span>-->
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkTerminationReq_action}" id="lnkTerminationReq"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Termination Request"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkTerminationApprove_action}"
                                                                                id="lnkTerminationApprove"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Termination Approve"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkRetirmnt_action}" id="lnkRetirmnt"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Retirment Mangemnt"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <!-- <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">
                                                                    TERMINATION</h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/Administration.png" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">
                                                                        This module handles Manage Questions Process</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkManageQuestions_action}" id="lnkManageQuestions"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Manage Questions"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkDefineQuestionnaire_action}"
                                                                                id="lnkDefineQuestionnaire"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Define Questionnaire"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkAssignQuestionnaire_action}"
                                                                                id="lnkAssignQuestionnaire"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Assign Questionnaire"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkGenerateQuestionnairs_action}"
                                                                                id="lnkGenerateQuestionnairs"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Generate Questionnairs"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li>-->
                                                            <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">LOOK UP TABLES MANAGEMENT</h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/EmployeeTraining.jpg" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">This module handles dynamic look up table.</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnklookUpTables_action}" id="lnklookUpTables"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Dynamic Look up tables"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkDynamicReport_action}" id="lnkDynamicReport"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Report"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px">
                                                                    USERS AND AUTHENTICATION</h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/Administration.png" style=" float:left;margin-top:5px; width:80px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">
                                                                            This administration module provides HR personnel with the capacity
                                                                            to monitor and manage employee participation
                                                                        in a range of benefit programs.</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkAdministration_action}" id="lnkAdministration"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Administraion"/>
                                                                        </span>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.lnkAuthorization_action}" id="lnkAuthorization"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Authorization"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink id="lnkEditMyAccount"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Edit Account"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink id="lnkResetPassword"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Reset Password"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px;">
                                                                        <p style="left:30px">Extra</p>
                                                                    </h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/Stracture.jpg" style=" float:left;margin-top:5px; width:100px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">
                                                                        This module deals with managing of region,zone and kebelle information for the HR use porpose.</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdRegionAndZoneOrCity_action}"
                                                                                id="cmdRegionAndZoneOrCity"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Region And Zone/City"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdWoreda_action}" id="cmdWoreda"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Woreda"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdKebelle_action}" id="cmdKebelle"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Kebelle"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li>
                                                                <div class="floater">
                                                                    <h2 style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;color:#074869;font-size:20px;font-weight:bold;font-family:Cambria; width:320px;">
                                                                        <p style="left:30px">Benefit</p>
                                                                    </h2>
                                                                    <div class="moduleDescription">
                                                                        <img alt="" src="./resources/home/images/Stracture.jpg" style=" float:left;margin-top:5px; width:100px;height:70px"/>
                                                                        <p style=" position:relative;color:#074869;font-size:14px;font-weight:bold;font-family:Cambria;margin-top:50px;">
                                                                        This module registers Benefifit Types and their allocation to different job positions.</p>
                                                                    </div>
                                                                    <div class="moduleLinks">
                                                                        <p style=" position:relative;color:#074869;font-size:15px;font-weight:bold;font-family:Cambria;margin-top:-10px;width:500px">Click where to go from the links listed below.</p>
                                                                        <span style="z-index:2;background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdBenefitTypes_action}" id="cmdBenefitTypes"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Benefit Types"/>
                                                                        </span>
                                                                        <span style="background:url(./resources/home/images/dot-line.gif) repeat-x 0 100%;height:20px;display:block;padding-top:5px;">
                                                                            <ice:commandLink action="#{Home.cmdPositionBenefitTypes_action}"
                                                                                id="cmdPositionBenefitTypes"
                                                                                style="padding-left:20px;background:url(./resources/home/images/symbol2.gif) 0 2px no-repeat;color:green;font-weight:bold" value="Benefit to Each Position"/>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <a href="javascript:void(0);" id="featured-item-prev" style="margin-left:5px;top:130px;">
                                                    <img alt="" src="./resources/home/images/prev.png"/>
                                                </a>
                                                <a href="javascript:void(0);" id="featured-item-next" style="margin-right:5px;top:130px;">
                                                    <img alt="" src="./resources/home/images/next.png"/>
                                                </a>
                                                <div id="carousel">
                                                    <div id="buttons" style="margin-left:-10px;top:275px;position:absolute">
                                                        <a href="#" id="prev">prev</a>
                                                    </div>
                                                    <div class="jcarousel-control" id="slides" style="margin-left:30px;top:285px;position:absolute">
                                                        <ul id="unorderList" style="text-align:center;">
                                                            <li>
                                                                <a href="#" title="HOME">1</a>
                                                                <a href="#" title="ORGANIZATION PROFILE">2</a>
                                                                <a href="#" title="RECRUITING MANAGEMENT">3</a>
                                                                <a href="#" title="EMPLOYEE ">4</a>
                                                                <a href="#" title="employees history">5</a>
                                                                <a href="#" title="Leave">6</a>
                                                                <a href="#" title=" Leave ">7</a>
                                                                <a href="#" title="Training">8</a>
                                                                <a href="#" title="Discipline">9</a>
                                                            </li>
                                                            <li>
                                                                <a href="#" title="Deligation">10</a>
                                                                <a href="#" title="Committee">11</a>
                                                                <a href="#" title="Benefit Types">12</a>
                                                                <a href="#" title="Report">13</a>
                                                                <a href="#" title="Termination ">14</a>
                                                                <a href="#" title="Dynamic Look ">15</a>
                                                                <a href="#" title="Administraion">16</a>
                                                                <a href="#" title="Look UP">17</a>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                    <div id="buttons" style="margin-left:300px;top:275px;position:absolute">
                                                        <a href="#" id="next">next</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- ####################################################################################################### -->
                                        </ice:panelLayout>
                                    </fieldset>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="south">
                            <ice:panelGroup id="page_footer" style=" text-align: left;">
                                <ice:panelLayout id="footer" layout="flow" style="border-bottom:1px solid #074869;position: relative;-rave-layout: grid; width: 1024px">
                                    <ice:panelLayout style="top:5px;">
                                        <label
                                                style="margin-left:20px;color:#0690CE;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="#" style="text-decoration:none;color:#62B77F">BUNNA INTERNATIONAL BANK  </a> |</label>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
