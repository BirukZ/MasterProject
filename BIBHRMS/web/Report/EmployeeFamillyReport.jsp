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
                <script src="../resources/DataTables-1.9.4/media/js/jquery.js" type="text/javascript"></script>
                <title>HRMS Reports</title>
                <script src="../resources/DataTables-1.9.4/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.4/extras/ColVis/media/js/ColVis.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.4/extras/TableTools/media/js/TableTools.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.4/extras/TableTools/media/js/ZeroClipboard.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.4/extras/ColReorder/media/js/ColReorder.js" type="text/javascript"></script>
                <script type="text/javascript">
                    var EmployeeFamillyReport=jQuery.noConflict();
                    var element = document.getElementById("[id='form1:dataTable1']");

                    EmployeeFamillyReport(document).ready(function () {
                        EmployeeFamillyReport("[id='form1:dataTable1']").dataTable({
                            "sDom": 'CT"clear"Rlfrtip',
                            "oTableTools": {
                                "sSwfPath": "../resources/DataTables-1.9.4/extras/TableTools/media/swf/copy_csv_xls_pdf.swf"
                            },
                            "sPaginationType": "full_numbers"
                        });
                    });

                    EmployeeFamillyReport(document).ready(function() {
                        oTable = $('#outputText1').dataTable({
                            "bJQueryUI": true,
                            "sPaginationType": "full_numbers"
                        });
                    } );

                    var asInitVals = new Array();

                    $(document).ready(function() {
                        var oTable = EmployeeFamillyReport("[id='form1:dataTable1']").dataTable( {
                            "oLanguage": {
                                "sSearch": "Search all columns:"
                            }
                        } );

                        $("tfoot input").keyup( function () {
                            /* Filter on the column (the index) of this element */
                            oTable.fnFilter( this.value, $("tfoot input").index(this) );
                        } );



                        /*
                         * Support functions to provide a little bit of 'user friendlyness' to the textboxes in
                         * the footer
                         */
                        $("tfoot input").each( function (i) {
                            asInitVals[i] = this.value;
                        } );

                        $("tfoot input").focus( function () {
                            if ( this.className == "search_init" )
                            {
                                this.className = "";
                                this.value = "";
                            }
                        } );

                        $("tfoot input").blur( function (i) {
                            if ( this.value == "" )
                            {
                                this.className = "search_init";
                                this.value = asInitVals[$("tfoot input").index(this)];
                            }
                        } );
                    } );




                </script>
                <link href="../resources/DataTables-1.9.4/media/css/demo_page.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.4/media/css/demo_table.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.4/media/css/demo_table_jui.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.4/media/js/jquery.dataTables.min.js" media="all" rel="stylesheet" type="text/css"/>
                <link href="../resources/media/themes/smoothness/jquery-ui-1.7.2.custom.css" media="all" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.4/extras/TableTools/media/css/TableTools.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.4/extras/TableTools/media/css/TableTools_JUI.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.4/extras/ColVis/media/css/ColVis.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.4/extras/ColReorder/media/css/ColReorder.css" rel="stylesheet" type="text/css"/>

            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:dataTable headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd"
                                   style="left: 24px; top: 120px; position: absolute" styleClass="display"
                                   value="#{Report$EmployeeFamillyReport.listOfEmployeeFamily}" var="currentRow">
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
                        <ice:column id="colFamilyName">
                            <h:outputText id="lblFamilyName" value="#{currentRow['familyName']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblCaFamilyName" style="font-family: 'Visual Geez Unicode'" value="የቤተሰብ ሥም"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colFamilyRelation">
                            <h:outputText id="lblFamilyRelation" value="#{currentRow['familyRelation']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisFamilyRelation" style="font-family: 'Visual Geez Unicode'" value="ዝምድና"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colFamilyGender">
                            <h:outputText id="lblFamilyGender" value="#{currentRow['familyGender']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblFamilyGendere" style="font-family: 'Visual Geez Unicode'" value="ጾታ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colFmilyDateOfBirth">
                            <h:outputText id="lblFmilyDateOfBirth" value="#{currentRow['familyDateOfBirth']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisFmilyDateOfBirth" style="font-family: 'Visual Geez Unicode'" value="የትውልድ  ዘመን"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colFamilyAge" style="font-family: 'Visual Geez Unicode'">
                            <h:outputText id="lblFamilyAgey" value="#{currentRow['familyAge']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlayFamilyAge" style="font-family: 'Visual Geez Unicode'" value="ዕድሜ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colFamilyIsAlive">
                            <h:outputText id="lblFamilyIsAlive" value="#{currentRow['familyIsAlive']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlayFamilyIsAlive" style="font-family: 'Visual Geez Unicode'" value="በህይወት  አለ"/>
                            </f:facet>
                        </ice:column>
                    </ice:dataTable>


                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
