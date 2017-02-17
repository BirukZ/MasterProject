<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SalaryDelegationRequestReport
    Created on : Jul 18, 2012, 8:53:36 PM
    Author     : Biruk 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
       <html id="outputHtml1">
            <head id="outputHead1">
                <title>Salary Delegation Request Report</title>
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
                    <h:dataTable border="1" headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd iceMnuPopVrt iceMnuPopVrtItem iceMnuBarVrtItemLabel oddRow"
                       style="left: 24px; top: 120px; position: absolute" styleClass="display"
                        value="#{SalaryDelegation$SalaryDelegationRequestReport.salaryDelegationRequestModel}" var="currentRow">
                        <h:column id="column1">
                            <h:outputText id="outputText1" value="#{currentRow['delegatorId']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የወካይ መለያ ቁጥር"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column2">
                            <h:outputText id="outputText3" value="#{currentRow['delegatorFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText4" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የወካይ ሥም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column3">
                            <h:outputText id="outputText5" value="#{currentRow['delegatorDepartment']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText6" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የወካይ የሥራ ክፍል"/>
                            </f:facet>
                        </h:column>
                         <h:column id="column31">
                            <h:outputText id="outputText51" value="#{currentRow['delegateId']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText61" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተወካዩ መለያ ቁጥር "/>
                            </f:facet>
                        </h:column>
                         <h:column id="column32">
                            <h:outputText id="outputText52" value="#{currentRow['delegateFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText62" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተወካዩ ሥም "/>
                            </f:facet>
                        </h:column>
                         <h:column id="column33">
                            <h:outputText id="outputText53" value="#{currentRow['delegateDepartment']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText63" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተወካዩ  የሥራ ክፍል"/>
                            </f:facet>
                        </h:column>
                         <h:column id="column34">
                            <h:outputText id="outputText54" value="#{currentRow['delegationStartDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText64" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተወከለበት ቀን ከ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column35">
                            <h:outputText id="outputText55" value="#{currentRow['delegationEndDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText65" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተወከለበት ቀን አስከ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column37">
                            <h:outputText id="outputText57" value="#{currentRow['delegationReasoun']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText67" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የውክልናው ዓይነት ደመወዝ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column38">
                            <h:outputText id="outputText58" value="#{currentRow['delegationTypeSalary']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText68" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የውክልናው ዓይነት  "/>
                            </f:facet>
                        </h:column>
                     
                    </h:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
