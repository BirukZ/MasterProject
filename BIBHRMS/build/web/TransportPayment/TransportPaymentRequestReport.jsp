<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : TrainingRequestReport
    Created on : Jul 12, 2012, 10:47:36 AM
    Author     : tomgenial
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <!-- <head id="outputHead1">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/xp/xp.css" id="outputStyle2"/>
            </head> -->
            <head id="outputHead1">
                <title>Transport Payment Request Report</title>
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
                <ice:form id="form1">
                    <h:dataTable border="1" headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd"
                        style="font-size: 12px; left: 0px; top: 144px; position: absolute"
                        value="#{TransportPayment$TransportPaymentRequestReport.trainingRequestReport}" var="currentRow">
                        <h:column id="clmnId">
                            <h:outputText id="outputText1" value="#{currentRow['employeeId']}"/>
                            <f:facet name="header">
                                <h:outputText id="empId" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የመ/ ቁ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnName">
                            <h:outputText id="outputText5" value="#{currentRow['fullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="fullName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሰልጣኙ ስም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnSex">
                            <h:outputText id="outputText8" value="#{currentRow['sex']}"/>
                            <f:facet name="header">
                                <h:outputText id="sex" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ጾታ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnserviceAbsentDate">
                            <h:outputText id="outputText9" value="#{currentRow['serviceAbsentDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="serviceAbsentDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሰርቪስ ቀሪ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnemployeeAbsentDate">
                            <h:outputText id="outputText10" value="#{currentRow['employeeAbsentDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="employeeAbsentDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ሰርቪሱ በቀረበት የሰራተኛው ቀሪ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnSex">
                            <h:outputText id="outputText11" value="#{currentRow['tarifPerDay']}"/>
                            <f:facet name="header">
                                <h:outputText id="sex" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ታሪፍ በቀን"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnpaymentForserviceAbsent">
                            <h:outputText id="outputText12" value="#{currentRow['paymentForserviceAbsent']}"/>
                            <f:facet name="header">
                                <h:outputText id="paymentForserviceAbsent" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ሰርቪስ ለቀረበት ክፍያ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmndaysInMonth">
                            <h:outputText id="outputText13" value="#{currentRow['daysInMonth']}"/>
                            <f:facet name="header">
                                <h:outputText id="daysInMonth" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የወሩ ቀናት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmntotalEmployeeAbsentDays">
                            <h:outputText id="outputText14" value="#{currentRow['totalEmployeeAbsentDays']}"/>
                            <f:facet name="header">
                                <h:outputText id="totalEmployeeAbsentDays" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ጠቅላላ የሰራተኛ ቀሪ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnextraPaymentPerDay">
                            <h:outputText id="outputText15" value="#{currentRow['extraPaymentPerDay']}"/>
                            <f:facet name="header">
                                <h:outputText id="extraPaymentPerDay" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ተጨማሪ ታሪፍ በቀን"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmntotalExtraPayment">
                            <h:outputText id="outputText16" value="#{currentRow['totalExtraPayment']}"/>
                            <f:facet name="header">
                                <h:outputText id="totalExtraPayment" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ለተጨማሪ ታሪፍ ክፍያ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmntotalPayment">
                            <h:outputText id="outputText17" value="#{currentRow['totalPayment']}"/>
                            <f:facet name="header">
                                <h:outputText id="totalPayment" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ጠቅላላ የሰርቪስ ክፍያ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmndepartmentPath">
                            <h:outputText id="outputText18" value="#{currentRow['departmentPath']}"/>
                            <f:facet name="header">
                                <h:outputText id="departmentPath" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የጠየቀው የሥራ ሂደት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnjobDescription">
                            <h:outputText id="outputText19" value="#{currentRow['jobDescription']}"/>
                            <f:facet name="header">
                                <h:outputText id="jobDescription" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሰልጣኙ የሥራ መደብ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnappliedDate">
                            <h:outputText id="outputText20" value="#{currentRow['appliedDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="appliedDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ሥልጠና እንዲሰጥ የተጠየቀበት ቀን"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnstartDate">
                            <h:outputText id="outputText21" value="#{currentRow['startDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="startDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ከ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnendDate">
                            <h:outputText id="outputText22" value="#{currentRow['endDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="endDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="እስከ"/>
                            </f:facet>
                        </h:column>
                    </h:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
