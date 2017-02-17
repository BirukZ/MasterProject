<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : DisciplineReport
    Created on : Jul 12, 2012, 7:07:00 PM
    Author     : BravoZulu
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Employee Provision Report For Management </title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.js" type="text/javascript"></script>
                <title>HRMS Reports</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColVis/media/js/ColVis.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/TableTools.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/ZeroClipboard.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColReorder/media/js/ColReorder.js" type="text/javascript"></script>
                <script type="text/javascript">
                    var ManagerProbationPeriod=jQuery.noConflict();
                    var element = document.getElementById("[id='form1:dataTable1']");
                    var asInitVals = new Array();
                    ManagerProbationPeriod(document).ready(function () {
                        var oTable = ManagerProbationPeriod("[id='form1:dataTable1']").dataTable({

                            "sDom": 'CT"clear"Rlfrtip',
                            "oTableTools": {
                                "sSwfPath": "../resources/DataTables-1.9.2/extras/TableTools/media/swf/copy_csv_xls_pdf.swf"
                            },
                            "sPaginationType": "full_numbers",
                            "oLanguage": {
                                "sSearch": "Search all columns:"
                            }
                        });

                        ManagerProbationPeriod("tfoot input").keyup( function () {
                            /* Filter on the column (the index) of this element*/
                            oTable.fnFilter( this.value, ManagerProbationPeriod("tfoot input").index(this),true ,true,true);
                            //alert("Qaz");

                        } );



                        /*
                         * Support functions to provide a little bit of 'user friendlyness' to the textboxes in
                         * the footer
                         */
                        ManagerProbationPeriod("tfoot input").each( function (i) {
                            asInitVals[i] = this.value;
                        } );

                        ManagerProbationPeriod("tfoot input").focus( function () {
                            if ( this.className == "search_init" )
                            {
                                this.className = "";
                                this.value = "";
                            }
                        } );

                        ManagerProbationPeriod("tfoot input").blur( function (i) {
                            if ( this.value == "" )
                            {
                                this.className = "search_init";
                                this.value = asInitVals[ManagerProbationPeriod("tfoot input").index(this)];
                            }
                        } );
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
                        rowClasses="list-row-even,list-row-odd iceMnuPopVrt iceMnuPopVrtItem iceMnuBarVrtItemLabel oddRow" rules="all"
                        style="left: 24px; top: 120px; position: absolute" styleClass="display" value="#{Report$ManagerProbationPeriod.personalInfoReport}" var="currentRow">
                        <h:column id="column1">
                            <h:outputText id="outputText1" value="#{currentRow['empID']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Employee ID"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="colId1" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="empID"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column2">
                            <h:outputText id="outputText3" value="#{currentRow['empFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText4" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Employee Full Name"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="colId11" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Employee Full Name"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column3">
                            <h:outputText id="outputText5" value="#{currentRow['age']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText6" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Age"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="colId12" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Age"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column4">
                            <h:outputText id="outputText50" value="#{currentRow['empSex']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText26" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Sex"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="colId13" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Sex"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column7">
                            <h:outputText id="outputText32" value="#{currentRow['hireDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText33" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Hire Date"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="colId16" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Hire Date"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column15">
                            <h:outputText id="outputText55" value="#{currentRow['jobName']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText41" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Job Position "/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="colId242" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Job Position"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column17">
                            <h:outputText id="outputText42" value="#{currentRow['rank']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText19" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="rank"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="colId25" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="rank"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column60">
                            <h:outputText id="outputText65" value="#{currentRow['department']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText75" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Department"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="colId26" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Department"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column76">
                            <h:outputText id="outputText95" value="#{currentRow['workPlace']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText101" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Work Place"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="colId27" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Work Place"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column761">
                            <h:outputText id="outputText951" value="#{currentRow['jobDescription']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText1013" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Date After Hire"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="colId273" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Date After Hire"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column181">
                            <h:outputText id="outputText431" value="#{currentRow['currentSalary']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText201" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Current Salary"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="colId29" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="currentSalary"/>
                            </f:facet>
                        </h:column>
                    </h:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
