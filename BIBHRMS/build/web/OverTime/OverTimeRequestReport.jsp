<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : OverTimeRequestReport
    Created on : Jul 19, 2012, 2:58:52 PM
    Author     : tomgenial 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <!--<head id="outputHead1">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/xp/xp.css" id="outputStyle2"/>
            </head> -->
            <head id="outputHead1">
                <title>Over Time Request Report</title>
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
                    <!-- <h:dataTable border="1" headerClass="list-header" id="dataTable12"
                   rowClasses="list-row-even,list-row-odd"
                    style="position: absolute; left: 0px; top: 216px"
                        value="#{OverTime$OverTimeRequestReport.overTimeRequestReport}"
                        var="currentRow" width="336">
                        <h:column id="clmnrequesterId">
                            <h:outputText id="outputText1" value="#{currentRow['requesterId']}"/>
                            <f:facet name="header">
                                <h:outputText id="requesterId" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="መለያ ቁጥር "/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnrequesterFullName">
                            <h:outputText id="outputText2" value="#{currentRow['requesterFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="requesterFullName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ሥም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnrequesterDeptPath">
                            <h:outputText id="outputText3" value="#{currentRow['requesterDeptPath']}"/>
                            <f:facet name="header">
                                <h:outputText id="requesterDeptPath" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ መደብ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnrequesterJobDesc">
                            <h:outputText id="outputText4" value="#{currentRow['requesterJobDesc']}"/>
                            <f:facet name="header">
                                <h:outputText id="requesterJobDesc" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ ክፍል"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnappliedDate">
                            <h:outputText id="outputText5" value="#{currentRow['appliedDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="appliedDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ትርፍ ሰዓቱን የተጠየቀበት ቀን"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnstartDate">
                            <h:outputText id="outputText6" value="#{currentRow['startDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="startDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ከ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnendDate">
                            <h:outputText id="outputText7" value="#{currentRow['endDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="endDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="እስከ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnstartTime">
                            <h:outputText id="outputText8" value="#{currentRow['startTime']}"/>
                            <f:facet name="header">
                                <h:outputText id="startTime" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="መነሻ ሰአት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnendTime">
                            <h:outputText id="outputText9" value="#{currentRow['endTime']}"/>
                            <f:facet name="header">
                                <h:outputText id="endTime" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="መድረሻ ሰአት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnTimeDifference">
                            <h:outputText id="outputText10" value="#{currentRow['timeDifference']}"/>
                            <f:facet name="header">
                                <h:outputText id="endTime" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="እስከ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnreason">
                            <h:outputText id="outputText11" value="#{currentRow['reason']}"/>
                            <f:facet name="header">
                                <h:outputText id="reason" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ትርፍ ሰዓቱ የተጠየቀበት ምክንያት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnemployeeId">
                            <h:outputText id="outputText12" value="#{currentRow['employeeId']}"/>
                            <f:facet name="header">
                                <h:outputText id="employeeId" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="መለያ ቁጥር"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnemployeeFullName">
                            <h:outputText id="outputText13" value="#{currentRow['employeeFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="employeeFullName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ሥም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnemployeeDeptPath">
                            <h:outputText id="outputText14" value="#{currentRow['employeeDeptPath']}"/>
                            <f:facet name="header">
                                <h:outputText id="employeeDeptPath" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ መደብ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnemployeeJobDesc">
                            <h:outputText id="outputText15" value="#{currentRow['employeeJobDesc']}"/>
                            <f:facet name="header">
                                <h:outputText id="employeeJobDesc" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ ክፍል"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnofficeOrShift">
                            <h:outputText id="outputText16" value="#{currentRow['officeOrShift']}"/>
                            <f:facet name="header">
                                <h:outputText id="officeOrShift" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ ሰዓት"/>
                            </f:facet>
                        </h:column>
                    </h:dataTable>
                    -->
                    <h:dataTable border="1" headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd"
                        style="font-size: 12px; left: 0px; top: 216px; position: absolute" value="#{OverTime$OverTimeRequestReport.overTimeRequestReport}" var="currentRow">
                        <h:column id="clmnrequesterId">
                            <h:outputText id="outputText1" value="#{currentRow['requesterId']}"/>
                            <f:facet name="header">
                                <h:outputText id="requesterId" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="መለያ ቁጥር "/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnrequesterFullName">
                            <h:outputText id="outputText2" value="#{currentRow['requesterFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="requesterFullName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የጠያቂው ሥም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnrequesterDeptPath">
                            <h:outputText id="outputText3" value="#{currentRow['requesterDeptPath']}"/>
                            <f:facet name="header">
                                <h:outputText id="requesterDeptPath" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ መደብ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnrequesterJobDesc">
                            <h:outputText id="outputText4" value="#{currentRow['requesterJobDesc']}"/>
                            <f:facet name="header">
                                <h:outputText id="requesterJobDesc" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ ክፍል"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnappliedDate">
                            <h:outputText id="outputText5" value="#{currentRow['appliedDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="appliedDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ትርፍ ሰዓቱን የተጠየቀበት ቀን"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnstartDate">
                            <h:outputText id="outputText6" value="#{currentRow['startDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="startDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ከ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnendDate">
                            <h:outputText id="outputText7" value="#{currentRow['endDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="endDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="እስከ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnstartTime">
                            <h:outputText id="outputText8" value="#{currentRow['startTime']}"/>
                            <f:facet name="header">
                                <h:outputText id="startTime" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="መነሻ ሰአት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnendTime">
                            <h:outputText id="outputText9" value="#{currentRow['endTime']}"/>
                            <f:facet name="header">
                                <h:outputText id="endTime" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="መድረሻ ሰአት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmntimeDifference">
                            <h:outputText id="outputText10" value="#{currentRow['timeDifference']}"/>
                            <f:facet name="header">
                                <h:outputText id="timeDifference" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ጠቅላላ ሰአት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnreason">
                            <h:outputText id="outputText11" value="#{currentRow['reason']}"/>
                            <f:facet name="header">
                                <h:outputText id="reason" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ትርፍ ሰዓቱ የተጠየቀበት ምክንያት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnemployeeId">
                            <h:outputText id="outputText12" value="#{currentRow['employeeId']}"/>
                            <f:facet name="header">
                                <h:outputText id="employeeId" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="መለያ ቁጥር"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnemployeeFullName">
                            <h:outputText id="outputText13" value="#{currentRow['employeeFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="employeeFullName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተጠየቀለት ሥም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnemployeeDeptPath">
                            <h:outputText id="outputText14" value="#{currentRow['employeeDeptPath']}"/>
                            <f:facet name="header">
                                <h:outputText id="employeeDeptPath" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ መደብ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnemployeeJobDesc">
                            <h:outputText id="outputText15" value="#{currentRow['employeeJobDesc']}"/>
                            <f:facet name="header">
                                <h:outputText id="employeeJobDesc" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ ክፍል"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnofficeOrShift">
                            <h:outputText id="outputText16" value="#{currentRow['officeOrShift']}"/>
                            <f:facet name="header">
                                <h:outputText id="officeOrShift" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ ሰዓት"/>
                            </f:facet>
                        </h:column>
                    </h:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
