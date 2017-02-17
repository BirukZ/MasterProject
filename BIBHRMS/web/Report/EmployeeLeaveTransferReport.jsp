<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EmployeeLeaveReport
    Created on : Jul 30, 2012, 11:33:57 PM
    Author     : PROJECT
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Employee Leave Transfer Report</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.js" type="text/javascript"></script>
                <title>HRMS Reports</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColVis/media/js/ColVis.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/TableTools.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/ZeroClipboard.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColReorder/media/js/ColReorder.js" type="text/javascript"></script>
                <script type="text/javascript">
                    var EmployeeLeaveTransferReport=jQuery.noConflict();
                    var element = document.getElementById("[id='form1:dataTable1']");

                    EmployeeLeaveTransferReport(document).ready(function () {
                        EmployeeLeaveTransferReport("[id='form1:dataTable1']").dataTable({
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
                    <h:dataTable border="1" headerClass="list-header" id="dataTable1"
                        rowClasses="list-row-even,list-row-odd iceMnuPopVrt iceMnuPopVrtItem iceMnuBarVrtItemLabel oddRow"
                        style="left: 24px; top: 120px; position: absolute" styleClass="display"
                        value="#{Report$EmployeeLeaveTransferReport.listOfEmployeeLeaveRequest}" var="currentRow">
                        <h:column id="colEmployeeId">
                            <h:outputText id="txtEmployeeId" style=" font-size: 12px; text-align: center" value="#{currentRow['employeeId']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblEmployeeId" style="font-family: Nyala,'Visual Geez Unicode'; font-size: 12px" value="መታወቂያ ቁጥር"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colEmployeeName">
                            <h:outputText id="txtEmployeeName" style=" font-size: 12px; text-align: center" value="#{currentRow['employeeFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblEmployeeName" style="font-family: Nyala,'Visual Geez Unicode'; font-size: 12px" value="ሠራተኛ ሥም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colSex">
                            <h:outputText id="txtSex" style=" font-size: 12px; text-align: center" value="#{currentRow['sex']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblSex" style="font-family: Nyala,'Visual Geez Unicode'; font-size: 12px" value="ጾታ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="collRequestDate">
                            <h:outputText id="txtRequestDate" style=" font-size: 12px; text-align: center" value="#{currentRow['requestDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblRequestDate" style="font-family: Nyala,'Visual Geez Unicode'; font-size: 12px" value="ፈቃድ የተጠየቀበት ቀን"/>
                            </f:facet>
                        </h:column>
                        <h:column id="collOrganization">
                            <h:outputText id="txtOrganization" style=" font-size: 12px; text-align: center" value="#{currentRow['organizationHead']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblOrganization" style="font-family: Nyala,'Visual Geez Unicode'; font-size: 12px" value="ዋና ሥራ አስፈጻሚ/ ሥራ አስፈጻሚ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="collDepartment">
                            <h:outputText id="txtDepartment" style=" font-size: 12px; text-align: center" value="#{currentRow['department']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDepartment" style="font-family: Nyala,'Visual Geez Unicode'; font-size: 12px" value="የሥራ  ሂደት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="collTeam">
                            <h:outputText id="txtTeam" style=" font-size: 12px; text-align: center" value="#{currentRow['team']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblTeam" style="font-family: Nyala,'Visual Geez Unicode'; font-size: 12px" value="ቡድን"/>
                            </f:facet>
                        </h:column>
                        <h:column id="collShift">
                            <h:outputText id="txtShift" style=" font-size: 12px; text-align: center" value="#{currentRow['firstphisicalYear']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblShift" style="font-family: Nyala,'Visual Geez Unicode'; font-size: 12px" value="የ 2004 ዓ.ም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="collLeaveYear">
                            <h:outputText id="txtLeaveYear" style=" font-size: 12px; text-align: center" value="#{currentRow['secondPhisicalYear']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblLeaveYear" style="font-family: Nyala,'Visual Geez Unicode'; font-size: 12px" value="የ 2005 ዓ.ም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="collLeaveType">
                            <h:outputText id="txtLeaveType" style=" font-size: 12px; text-align: center" value="#{currentRow['leaveType']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblLeaveType" style="font-family: Nyala,'Visual Geez Unicode'; font-size: 12px" value=" ዓይነት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="collLeaveDayes">
                            <h:outputText id="txtLeaveDayes" style=" font-size: 12px; text-align: center" value="#{currentRow['requestLeaveDays']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblLeaveDayes" style="font-family: Nyala,'Visual Geez Unicode'; font-size: 12px" value=" መጠን"/>
                            </f:facet>
                        </h:column>
                        <h:column id="collLeaveFromTO">
                            <h:outputText id="txtLeaveFromTO" style="font-family: Nyala,'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['fromTo']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblLeaveFromTO" style="font-family: Nyala,'Visual Geez Unicode'; font-size: 12px" value="ከ - እስከ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="collRemark">
                            <h:outputText id="txtRemark" style="font-family: Nyala,'Visual Geez Unicode'; font-size: 12px" value="#{currentRow['remark']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblRemark" style="font-family: Nyala,'Visual Geez Unicode'; font-size: 12px" value="የተላለፈበት ምክንያት"/>
                            </f:facet>
                        </h:column>
                    </h:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
