<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EmployeeReport
    Created on : Jul 11, 2012, 9:15:08 PM
    Author     : PROJECT
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Employee Report</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.js" type="text/javascript"></script>
                <title>HRMS Reports</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColVis/media/js/ColVis.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/TableTools.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/ZeroClipboard.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColReorder/media/js/ColReorder.js" type="text/javascript"></script>
                <script type="text/javascript">
                    var EmployeeEducationReport=jQuery.noConflict();
                    var element = document.getElementById("[id='form1:dataTable1']");

                    EmployeeEducationReport(document).ready(function () {
                        EmployeeEducationReport("[id='form1:dataTable1']").dataTable({
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
                    <ice:dataTable headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd"
                        style="left: 24px; top: 120px; position: absolute" styleClass="display"
                        value="#{Report$EmployeeEducationReport.listOfEmployeeEducationDate}" var="currentRow">
                        <ice:column id="column1">
                            <h:outputText id="outputText1" value="#{currentRow['employeeId']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="መታወቂያ ቁጥር"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column2">
                            <h:outputText id="outputText3" value="#{currentRow['employeeName']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText4" style="font-family: 'Visual Geez Unicode'" value="ሠራተኛ ሥም"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colEducationTypee">
                            <h:outputText id="lblEducationType" value="#{currentRow['educationType']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblCaEducationType" style="font-family: 'Visual Geez Unicode'" value="የትምህርቱ ዓይነት"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colEducationLevel">
                            <h:outputText id="lblEducationLevel" value="#{currentRow['educationLevel']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisEducationLevel" style="font-family: 'Visual Geez Unicode'" value="የትምህርት  ደረጃ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colFamilyGender">
                            <h:outputText id="lblFamilyGender" value="#{currentRow['institution']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblFamilyGendere" style="font-family: 'Visual Geez Unicode'" value="የተማረበት ተቋም"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colFmilyDateOfBirth">
                            <h:outputText id="lblFmilyDateOfBirth" value="#{currentRow['completedDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisFmilyDateOfBirth" style="font-family: 'Visual Geez Unicode'" value="ትምህርቱን  ያጠናቀቀበት ጊዜ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colFamilyAge" style="font-family: 'Visual Geez Unicode'">
                            <h:outputText id="lblFamilyAgey" value="#{currentRow['result']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlayFamilyAge" style="font-family: 'Visual Geez Unicode'" value="ውጤት"/>
                            </f:facet>
                        </ice:column>
                    </ice:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
