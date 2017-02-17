<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ClearanceReport
    Created on : Jul 17, 2012, 4:39:43 AM
    Author     : Admin 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Cleranced Employees Report</title>
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
                                "sSwfPath": "DataTables-1.9.2/extras/TableTools/media/swf/copy_csv_xls_pdf.swf"
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
                    <ice:dataTable border="1" headerClass="iceDatTblHdr displayHdr list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd"
                        style="left: 38px; top: 86px; position: absolute" styleClass="iceDatTbl display" value="#{SecurtyGurd$ClearedReport.cleranceList}" var="currentRow">
                        <ice:column id="clmnId1">
                            <ice:outputText id="outputText1" value="#{currentRow['reqId']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colId1" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="መለያ  ቁጥር"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnRequesterName1">
                            <ice:outputText id="outputText2" value="#{currentRow['reqName']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colrequesterName1" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ሥም"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnJobPostion1">
                            <ice:outputText id="outputText3" value="#{currentRow['sex']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colJobPostion1" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ፆታ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnDate1">
                            <ice:outputText id="outputText5" value="#{currentRow['postion']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colCurrentEducation1" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ መደብ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnAge1">
                            <ice:outputText id="outputText9" value="#{currentRow['departement']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colAge1" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ ክፍል"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column2">
                            <ice:outputText id="outputText12" value="#{currentRow['terminationAcceptan']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText13" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሚለቅበት ቀን"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column5">
                            <ice:outputText id="outputText18" value="#{currentRow['finishedUnfin']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText19" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ዕዳ አወራርዶ የጨረሰ/ያልጨረሰ "/>
                            </f:facet>
                        </ice:column>
                    </ice:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
