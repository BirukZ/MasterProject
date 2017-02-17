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
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/xp/xp.css" id="outputStyle2"/>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.js" type="text/javascript"></script>
                <title>HRMS Reports</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColVis/media/js/ColVis.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/TableTools.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/ZeroClipboard.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColReorder/media/js/ColReorder.js" type="text/javascript"></script>
                <script type="text/javascript">
                    var EmployeeLeaveBalanceReport=jQuery.noConflict();
                    var element = document.getElementById("[id='form1:dataTable1']");
                    var asInitVals = new Array();                    
                    EmployeeLeaveBalanceReport(document).ready(function () {
                        var oTable = EmployeeLeaveBalanceReport("[id='form1:dataTable1']").dataTable({

                            "sDom": 'CT"clear"Rlfrtip',
                            "oTableTools": {
                                "sSwfPath": "../resources/DataTables-1.9.2/extras/TableTools/media/swf/copy_csv_xls_pdf.swf"
                            },
                            "sPaginationType": "full_numbers",
                            "oLanguage": {
                                "sSearch": "Search all columns:"
                            }
                        });

                        EmployeeLeaveBalanceReport("tfoot input").keyup( function () {
                            /* Filter on the column (the index) of this element*/
                            oTable.fnFilter( this.value, EmployeeLeaveBalanceReport("tfoot input").index(this),true ,true,true);
                            //alert("Qaz");
                           
                        } );



                        /*
                         * Support functions to provide a little bit of 'user friendlyness' to the textboxes in
                         * the footer
                         */
                        EmployeeLeaveBalanceReport("tfoot input").each( function (i) {
                            asInitVals[i] = this.value;
                        } );

                        EmployeeLeaveBalanceReport("tfoot input").focus( function () {
                            if ( this.className == "search_init" )
                            {
                                this.className = "";
                                this.value = "";
                            }
                        } );

                        EmployeeLeaveBalanceReport("tfoot input").blur( function (i) {
                            if ( this.value == "" )
                            {
                                this.className = "search_init";
                                this.value = asInitVals[EmployeeLeaveBalanceReport("tfoot input").index(this)];
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
                <link href="../resources/DataTables-1.9.2/extras/ColReorder/media/css/ColReorder.css" rel="stylesheet" type="text/css"/>            </head>


            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">

                    <h:dataTable border="1" headerClass="list-header" id="dataTable1"
                                 rowClasses="list-row-even,list-row-odd iceMnuPopVrt iceMnuPopVrtItem iceMnuBarVrtItemLabel oddRow"
                                 style="left: 0px; top: 120px; position: absolute"  styleClass="display" value="#{Report$EmployeeLeaveBalanceReport.listOfEmployeeLeaveRequest}" var="currentRow">
                        <h:column id="colEmployeeId">
                            <h:outputText id="txtEmployeeId" style=" font-size: 12px; text-align: center" value="#{currentRow['employeeId']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblEmployeeId" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Employee ID"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="lblEmployeeId2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Employee ID"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colEmployeeName">
                            <h:outputText id="txtEmployeeName" style=" font-size: 12px; text-align: center" value="#{currentRow['employeeFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblEmployeeName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="FullName"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="lblEmployeeName2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="FullName"/>
                            </f:facet>
                        </h:column>
                          <h:column id="collTeam">
                            <h:outputText id="txtTeam" style=" font-size: 12px; text-align: center" value="#{currentRow['hireDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblTeam" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Hire Date"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="lblTeam2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Hire Date"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colSex">
                            <h:outputText id="txtSex" style=" font-size: 12px; text-align: center" value="#{currentRow['salary']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblSex" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Salary"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="lblSex2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Salary"/>
                            </f:facet>
                        </h:column>
                        <h:column id="collOrganization">
                            <h:outputText id="txtOrganization" style=" font-size: 12px; text-align: center" value="#{currentRow['departmentName']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblOrganization" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Department"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="lblOrganization2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Department"/>
                            </f:facet>

                        </h:column>
                        <h:column id="collDepartment">
                            <h:outputText id="txtDepartment" style=" font-size: 12px; text-align: center" value="#{currentRow['jobName']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDepartment" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="JobName"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="lblDepartment2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="JobName"/>
                            </f:facet>
                        </h:column>
                      
                        <h:column id="collOffice">
                            <h:outputText id="txtOffice" style=" font-size: 12px; text-align: center" value="#{currentRow['team']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblOffice" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Leave Type"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="lblOffice2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Leave Type"/>
                            </f:facet>
                        </h:column>
                       <!-- <h:column id="collShift">
                            <h:outputText id="txtShift" style=" font-size: 12px; text-align: center" value="#{currentRow['phisicalLeaveYearFirst']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblShift" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የ 2004 ዓ.ም"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="lblShift2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="የ 2004 ዓ.ም"/>
                            </f:facet>
                        </h:column>-->
                        <h:column id="collLeaveType">
                            <h:outputText id="txtLeaveType" style=" font-size: 12px; text-align: center" value="#{currentRow['usedLeveBalance']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblLeaveType" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="TotalLeaveUtilazed"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="lblLeaveType2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="TotalLeaveUtilazed"/>
                            </f:facet>
                        </h:column>
                        <h:column id="collLeaveDayes">
                            <h:outputText id="txtLeaveDayes" style=" font-size: 12px; text-align: center" value="#{currentRow['totalAmountBalance']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblLeaveDayes" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Annula Leave Balance"/>
                            </f:facet>
                            <f:facet name="footer">
                                <h:inputText id="lblLeaveDayes2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Annula Leave Balance"/>
                            </f:facet>

                        </h:column>


                    </h:dataTable>
                    <div>

                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
