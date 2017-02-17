<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : PromorTransfercandidateReg
    Created on : Jul 25, 2012, 10:31:37 AM
    Author     : HRMS
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Promotion Report</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.js" type="text/javascript"></script>
                <title>HRMS Reports</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColVis/media/js/ColVis.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/TableTools.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/ZeroClipboard.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColReorder/media/js/ColReorder.js" type="text/javascript"></script>
                <script type="text/javascript">
                    var IncrementSalary=jQuery.noConflict();
                    var element = document.getElementById("[id='form1:dataTable1']");

                    IncrementSalary(document).ready(function () {
                        IncrementSalary("[id='form1:dataTable1']").dataTable({
                            "sDom": 'CT"clear"Rlfrtip',
                            "oTableTools": {
                                "sSwfPath": "../resources/DataTables-1.9.2/extras/TableTools/media/swf/copy_csv_xls_pdf.swf"
                            },
                            "sPaginationType": "full_numbers"
                        });
                    });
                </script>
                <link href="../resources/DataTables-1.9.2/media/css/demo_page.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/media/css/demo_table.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/media/css/demo_table_jui.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/media/js/jquery.dataTables.min.js" media="all" rel="stylesheet" type="text/css"/>
                <link href="../resources/media/themes/smoothness/jquery-ui-1.7.2.custom.css" media="all" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/extras/TableTools/media/css/TableTools.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/extras/TableTools/media/css/TableTools_JUI.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/extras/ColVis/media/css/ColVis.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/extras/ColReorder/media/css/ColReorder.css" rel="stylesheet" type="text/css"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <h:form id="form1">
                    <h:dataTable  border="1" headerClass="list-header" id="dataTable1"
                   rowClasses="list-row-even,list-row-odd iceMnuPopVrt iceMnuPopVrtItem iceMnuBarVrtItemLabel oddRow"
                        style="left: 24px; top: 120px; position: absolute" styleClass="display"
                        value="#{Routines$PromorTransfercandidateReg.promtionReport}" var="currentRow">
                        <h:column id="column4">
                            <h:outputText id="outputText7" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['jobType']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText8" value="Job Title"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column5">
                            <h:outputText id="outputText9" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['rank']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText10" value="Rank"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column6">
                            <h:outputText id="outputText11" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['salary']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText12" value="Salary"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column7">
                            <h:outputText id="outputText13" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['directorate']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText15" value="Department"/>
                            </f:facet>
                        </h:column>
                        
                        <h:column id="column11">
                            <h:outputText id="outputText243" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['empID']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText225" value="CandidateID"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colsex">
                            <h:outputText id="txtsex" value="#{currentRow['sex']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblsex" value="Sex"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colAge">
                            <h:outputText id="txtage" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['age']}"/>
                            <f:facet name="header">
                                <h:outputText id="outxtage" value="Age"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colRank">
                            <h:outputText id="outputRank" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['fullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="outpuRank7" value="Canidate FullName"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colJob">
                            <h:outputText id="outpuJob" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['toReasult']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputJob9" value="Total Result"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colWritenEcam">
                            <h:outputText id="outputexam" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['interviewExam']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputexam8" value="Writen exam"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colInterview">
                            <h:outputText id="outputInterview" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['perforamcneValue']}"/>
                            <f:facet name="header">
                                <h:outputText id="outpInterview5" value="Perforamnce Result"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column12">
                            <h:outputText id="outputText26" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['educLevel']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText27" value="Educational Level"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column13">
                            <h:outputText id="outputText28" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['educType']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText29" value="Education Type"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colEducLevle">
                            <h:outputText id="outputEducLevle" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['educLevel']}"/>
                            <f:facet name="header">
                                <h:outputText id="outEducLevle" value="Educ Level"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colEducType">
                            <h:outputText id="outputEducType" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['experience']}"/>
                            <f:facet name="header">
                                <h:outputText id="outEducType" value="Expirance"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colCgpa">
                            <h:outputText id="outCgpa" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['advertDateFrom']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputCgpa" value="AdvertDateFrom"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column14">
                            <h:outputText id="outputText30" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['advertDateTo']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText31" value="AdvertDateTo"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column15">
                            <h:outputText id="outputText32" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['refNo']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText33" value="ReferanceNumber"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column16">
                            <h:outputText id="outputText34" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['promotionReasoun']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText35" value="Promotion Reasoun"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colAdvertismen">
                            <h:outputText id="outputAdvertismen4" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['approvDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="outAdvertismen5" value="PromtionApproveDate"/>
                            </f:facet>
                        </h:column>
                       
                    </h:dataTable>
                </h:form>
            </body>
        </html>
    </f:view>
</jsp:root>
