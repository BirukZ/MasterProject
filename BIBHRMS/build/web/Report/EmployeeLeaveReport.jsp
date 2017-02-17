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
                <script src="../resources/DataTables-1.9.2/media/js/jquery.js" type="text/javascript"></script>
                <title>HRMS Reports</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColVis/media/js/ColVis.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/TableTools.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/ZeroClipboard.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColReorder/media/js/ColReorder.js" type="text/javascript"></script>
                <script type="text/javascript">
                    var EmployeeLeaveReport=jQuery.noConflict();
                    var element = document.getElementById("[id='form1:dataTable1']");

                    EmployeeLeaveReport(document).ready(function () {
                        EmployeeLeaveReport("[id='form1:dataTable1']").dataTable({
                            "sDom": 'CT"clear"Rlfrtip',
                            "oTableTools": {
                                "sSwfPath": "../resources/DataTables-1.9.2/extras/TableTools/media/swf/copy_csv_xls_pdf.swf"
                            },
                            "sPaginationType": "full_numbers"
                        });
                    });



               var asInitVals = new Array();

			 EmployeeLeaveReport(document).ready(function() {
				var oTable = $('#example').dataTable( {
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
                <link href="../resources/DataTables-1.9.2/media/css/demo_page.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/media/css/demo_table.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/media/css/demo_table_jui.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/media/js/jquery.dataTables.min.js" media="all" rel="stylesheet" type="text/css"/>
                <link href="../resources/media/themes/smoothness/jquery-ui-1.7.2.custom.css" media="all" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/extras/TableTools/media/css/TableTools.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/extras/TableTools/media/css/TableTools_JUI.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/extras/ColVis/media/css/ColVis.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/extras/ColReorder/media/css/ColReorder.css" rel="stylesheet" type="text/css"/>




                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/xp/xp.css" id="outputStyle2"/>
            </head>




            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                  
                        <h:dataTable border="1" headerClass="list-header" id="dataTable1"
                            rowClasses="list-row-even,list-row-odd iceMnuPopVrt iceMnuPopVrtItem iceMnuBarVrtItemLabel oddRow"
                                style="left: 24px; top: 120px; position: absolute" styleClass="display" value="#{Report$EmployeeLeaveReport.listOfEmployeeLeaveRequest}" var="currentRow">
                            <h:column id="colEmployeeId">
                                <h:outputText id="txtEmployeeId" style=" font-size: 12px; text-align: center" value="#{currentRow['employeeId']}"/>
                                <f:facet name="header">
                                    <h:outputText id="lblEmployeeId" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Employee ID"/>
                                </f:facet>
                                 <f:facet name="footer">
                                <h:inputText id="lblemployeeID" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Employee ID"/>
                            </f:facet>
                            </h:column>
                            <h:column id="colEmployeeName">
                                <h:outputText id="txtEmployeeName" style=" font-size: 12px; text-align: center" value="#{currentRow['employeeFullName']}"/>
                                <f:facet name="header">
                                    <h:outputText id="lblEmployeeName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Full Name"/>
                                </f:facet>
                               <f:facet name="footer">
                                <h:inputText id="lblemployeeFullName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Full Name"/>
                            </f:facet>

                            </h:column>
                            <h:column id="colSex">
                                <h:outputText id="txtSex" style=" font-size: 12px; text-align: center" value="#{currentRow['sex']}"/>
                                <f:facet name="header">
                                    <h:outputText id="lblSex" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Sex"/>
                                </f:facet>
                                 <f:facet name="footer">
                                <h:inputText id="lblemployeeSex" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Sex"/>
                            </f:facet>
                            </h:column>
                          <!--  <h:column id="collMobile">
                                <h:outputText id="txtMobile" style=" font-size: 12px; text-align: center" value="#{currentRow['mobile']}"/>
                                <f:facet name="header">
                                    <h:outputText id="lblMobile" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Phone Number"/>
                                </f:facet>
                                 <f:facet name="footer">
                                <h:inputText id="lblemployeeMobile" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Phone Number"/>
                            </f:facet>
                            </h:column>-->
                          
                            <h:column id="collOrganization">
                                <h:outputText id="txtOrganization" style=" font-size: 12px; text-align: center" value="#{currentRow['kebelleName']}"/>
                                <f:facet name="header">
                                    <h:outputText id="lblOrganization" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Department"/>
                                </f:facet>
                                 <f:facet name="footer">
                                <h:inputText id="lblemployeeDepartment" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Department"/>
                            </f:facet>
                            </h:column>
 
                            <h:column id="collTeam">
                                <h:outputText id="txtTeam" style=" font-size: 12px; text-align: center" value="#{currentRow['mobile']}"/>
                                <f:facet name="header">
                                    <h:outputText id="lblTeam" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Position"/>
                                </f:facet>
                                 <f:facet name="footer">
                                <h:inputText id="lblemployeePosition" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Position"/>
                            </f:facet>
                            </h:column>
                            <h:column id="collOffice">
                                <h:outputText id="txtOffice" style=" font-size: 12px; text-align: center" value="#{currentRow['office']}"/>
                                <f:facet name="header">
                                    <h:outputText id="lblOffice" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Regular Leave Time"/>
                                </f:facet>
                                 <f:facet name="footer">
                                <h:inputText id="lblregularLeaveTime" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Regular Leave Time"/>
                            </f:facet>
                            </h:column>
                            <h:column id="collRequestDate">
                                <h:outputText id="txtRequestDate" style=" font-size: 12px; text-align: center" value="#{currentRow['requestDate']}"/>
                                <f:facet name="header">
                                    <h:outputText id="lblRequestDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px; text-align: center" value="Leave Request Date"/>
                                </f:facet>
                                 <f:facet name="footer">
                                <h:inputText id="lblLeaveRequestId" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Leave Request Date"/>
                            </f:facet>
                            </h:column>
                            <h:column id="collLeaveYear">

                                <h:outputText id="txtLeaveYear" style=" font-size: 12px; text-align: center" value="#{currentRow['leaveYear']}"/>
                                <f:facet name="header">
                                    <h:outputText id="lblLeaveYear" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Requested Leave Amount"/>
                                </f:facet>
                                 <f:facet name="footer">
                                <h:inputText id="lblLeaveRquestedLeaveAmount" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Requested Leave Amount"/>
                            </f:facet>
                            </h:column>
                            <h:column id="collLeaveType">
                                <h:outputText id="txtLeaveType" style=" font-size: 12px; text-align: center" value="#{currentRow['leaveType']}"/>
                                <f:facet name="header">
                                    <h:outputText id="lblLeaveType" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value=" Leave Type"/>
                                </f:facet>
                                 <f:facet name="footer">
                                <h:inputText id="lblLeaveTypeForFooter" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Leave Type"/>
                            </f:facet>
                            </h:column>
                           <!-- <h:column id="collLeaveDayes">
                                <h:outputText id="txtLeaveDayes" style=" font-size: 12px; text-align: center" value="#{currentRow['leaveDays']}"/>
                                <f:facet name="header">
                                    <h:outputText id="lblLeaveDayes" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value=" Amount"/>
                                </f:facet>
                                 <f:facet name="footer">
                                <h:inputText id="lblLeaveAmount" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Amount"/>
                            </f:facet>
                            </h:column>-->
                            <h:column id="collLeaveFromTO">
                                <h:outputText id="txtLeaveFromTO" style=" font-size: 12px; text-align: center" value="#{currentRow['leaveDays']}"/>
                                <f:facet name="header">
                                    <h:outputText id="lblLeaveFromTO" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="From-To"/>
                                </f:facet>
                                 <f:facet name="footer">
                                <h:inputText id="lblLeaveFromTo" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="From-To"/>
                            </f:facet>
                            </h:column>
                            <h:column id="collReason">
                                <h:outputText id="txtReason" style=" font-size: 12px; text-align: center" value="#{currentRow['reason']}"/>
                                <f:facet name="header">
                                    <h:outputText id="lblReason" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Reaoun"/>
                                </f:facet>
                                <f:facet name="footer">
                                <h:inputText id="lblLeaveReasoun" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Reaoun"/>
                            </f:facet>
                            </h:column>
                            <h:column id="collApproveDate">
                                <h:outputText id="txtApproveDate" style=" font-size: 12px; text-align: center" value="#{currentRow['approveDate']}"/>
                                <f:facet name="header">
                                    <h:outputText id="lblApproveDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="Approved Date"/>
                                </f:facet>
                                 <f:facet name="footer">
                                <h:inputText id="lblApprovedDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" styleClass="search_init" value="Approved Date"/>
                            </f:facet>
                            </h:column>
                        </h:dataTable>

                   
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
