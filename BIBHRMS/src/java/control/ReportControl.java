/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.sun.webui.jsf.model.Option;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Locale;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import manager.globalUseManager.ErrorLogWriter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.fill.JRSwapFileVirtualizer;
import net.sf.jasperreports.engine.util.JRSwapFile;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author AltSysAltSys
 */
public class ReportControl {

    public Option[] loadReports;

    /**
     *
     */
    public ReportControl() {
    }
    DateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    ResultSet rsFiltered, Rs = null;
    JRResultSetDataSource jrRss = null;

    public static byte[] extractByteArray(File file) {//read the byte information of the image.
        FileInputStream fileInputStream = null;
        byte[] byteFile = null;
        try {

            int len = 0;
            fileInputStream = new FileInputStream(file);
            InputStream inputStream = fileInputStream;
            len = inputStream.available();
            byteFile = new byte[len];
            inputStream.read(byteFile, 0, len);

        } catch (Exception ex) {
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception ex) {
            }
        }
        return byteFile;
    }

    /**
     *
     * @param code
     * @param servletOutputStream
     * @param type
     * @param request
     */
    public void getReport(String jasperLocation, String jasperName, ServletOutputStream servletOutputStream, String type, HttpServletResponse response, HttpServletRequest request, HashMap parameters, Collection data) {
        try {
            JRBeanCollectionDataSource jrbc = new JRBeanCollectionDataSource(data, false);
            JasperPrint jsPrint = JasperFillManager.fillReport(jasperLocation, parameters, jrbc);
            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jsPrint);
            if (type.compareTo("pdf") == 0) {
                //    response.setContentType("application/pdf");
                //    response.setHeader("Content-disposition", "inline; filename=\"" + jasperName + ".pdf\"");
                //        formatReportAsPdfStream(jsPrint, servletOutputStream);
            } else {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                formatReportAsHtmlStream(jsPrint, servletOutputStream, request);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

     public void getReportNew(String jasperLocation, String jasperName, ServletOutputStream servletOutputStream, String type, HttpServletResponse response, HttpServletRequest request, HashMap parameters, Collection data,Collection data1,Collection data2) {
        try {
            JRBeanCollectionDataSource jrbc = new JRBeanCollectionDataSource(data, false);
            JRBeanCollectionDataSource jrbc1 = new JRBeanCollectionDataSource(data, false);
            JRBeanCollectionDataSource jrbc2 = new JRBeanCollectionDataSource(data, false);
            JasperPrint jsPrint = JasperFillManager.fillReport(jasperLocation, parameters, jrbc);
            JasperPrint jsPrintNew = JasperFillManager.fillReport(jasperLocation, parameters, jrbc1);
            JasperPrint jsPrintNew1 = JasperFillManager.fillReport(jasperLocation, parameters, jrbc2);
            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jsPrint);
             request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jsPrintNew);
              request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jsPrintNew1);
            if (type.compareTo("pdf") == 0) {
                //    response.setContentType("application/pdf");
                //    response.setHeader("Content-disposition", "inline; filename=\"" + jasperName + ".pdf\"");
                //        formatReportAsPdfStream(jsPrint, servletOutputStream);
            } else {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                formatReportAsHtmlStream(jsPrint, servletOutputStream, request);
                formatReportAsHtmlStream(jsPrintNew, servletOutputStream, request);
                formatReportAsHtmlStream(jsPrintNew1, servletOutputStream, request);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getReportNewFormat(String jasperLocation,
            String format,
            ServletOutputStream servletOutputStream,
            String type, HttpServletResponse response, HttpServletRequest request,
            HashMap parameters, Collection data) {
        try {
            String _path = System.getProperty("user.home");
            _path = _path + File.separatorChar + "ReportData";
            File swapFileVirtualizer = new File(jasperLocation);
            if (!swapFileVirtualizer.isFile()) {
                swapFileVirtualizer.mkdir();
            }
            format="html";
            JRSwapFileVirtualizer fileVirtualizer = new JRSwapFileVirtualizer(10, new JRSwapFile(_path, 2048, 2048));
            parameters.put("REPORT_VIRTUALIZER", fileVirtualizer);
            File jasperFile = new File(jasperLocation);
            ServletOutputStream outputStream = null;
            byte[] reportDesignByte = getBytesFromFile(jasperFile);
            ByteArrayInputStream reportDesign = new ByteArrayInputStream(reportDesignByte);
            JasperPrint jsPrint = null;
            JRBeanCollectionDataSource jrbc = new JRBeanCollectionDataSource(data, false);
            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jsPrint);
           //   jsPrint = JasperFillManager.fillReport(reportDesign, data);


//                      reportDesign, param, dataSource);

            if (format.compareTo("html") == 0) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                outputStream = response.getOutputStream();
                formatReportAsHtmlStream(jsPrint, outputStream, request);
            } else if (format.compareTo("pdf") == 0) {
                response.setContentType("application/pdf");
                response.setHeader("Cache-Control", "no-cache");
                response.setHeader("Cache-Control", "max-age=0");
                response.setHeader("Content-disposition", "attachment; filename=Report.pdf");
                outputStream = response.getOutputStream();
                formatReportAsPdfStream(jsPrint, outputStream);
            } else if (format.compareTo("xlsx") == 0) {
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                response.setHeader("Cache-Control", "no-cache");
                response.setHeader("Cache-Control", "max-age=0");
                outputStream = response.getOutputStream();
                response.setHeader("Content-disposition", "attachment; filename=Report.xlsx");
                response.flushBuffer();
                formatReportAsXlsStream(jsPrint, outputStream);
            } else if (format.compareTo("docx") == 0) {
                response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                response.setHeader("Cache-Control", "no-cache");
                response.setHeader("Cache-Control", "max-age=0");
                response.setHeader("Content-disposition", "attachment; filename=Report.docx");
                outputStream = response.getOutputStream();
                response.flushBuffer();
                formatReportAsDocxStream(jsPrint, outputStream);
            }














        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getReport(String jasperLocation, ServletOutputStream servletOutputStream, String type, HttpServletResponse response, HttpServletRequest request, HashMap parameters, JRResultSetDataSource data) {
        try {
//            JRBeanCollectionDataSource jrbc = new JRBeanCollectionDataSource(data, false);
            JasperPrint jsPrint = JasperFillManager.fillReport(jasperLocation, parameters, data);
            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jsPrint);
            if (type.compareTo("pdf") == 0) {
                //    response.setContentType("application/pdf");
                //    response.setHeader("Content-disposition", "inline; filename=\"" + jasperName + ".pdf\"");
                //        formatReportAsPdfStream(jsPrint, servletOutputStream);
            } else {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                formatReportAsHtmlStream(jsPrint, servletOutputStream, request);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getReportSummery(String jasperLocation, String jasperName, ServletOutputStream servletOutputStream, String type, HttpServletResponse response, HttpServletRequest request, HashMap parameters, JRMapCollectionDataSource data) {
        try {
            JasperPrint jsPrint = JasperFillManager.fillReport(jasperLocation, parameters, data);
            //
            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jsPrint);

            if (type.compareTo("pdf") == 0) {
                //    response.setContentType("application/pdf");
                //    response.setHeader("Content-disposition", "inline; filename=\"" + jasperName + ".pdf\"");
                //        formatReportAsPdfStream(jsPrint, servletOutputStream);
            } else {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                formatReportAsHtmlStream(jsPrint, servletOutputStream, request);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void GenerateReport(File jasperLocation, String jasperName, ServletOutputStream servletOutputStream, String type, HttpServletResponse response, HttpServletRequest request, Map parameters, JRMapCollectionDataSource data) {
        try {
            byte[] loc = extractByteArray(jasperLocation);
            InputStream inputStream = new ByteArrayInputStream(loc);
            JasperPrint jsPrint = JasperFillManager.fillReport(inputStream, parameters, data);
            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jsPrint);
            if (type.compareTo("pdf") == 0) {
                response.setContentType("application/pdf");//inline//attachment
                response.addHeader("Content-disposition", "attachment;filename=" + jasperName + ".pdf");
                formatReportAsPdfStream(jsPrint, servletOutputStream, request);
            } else if (type.compareTo("html") == 0) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                response.addHeader("Content-disposition", "attachment;filename=" + jasperName + ".htm");
                formatReportAsHtmlStream(jsPrint, servletOutputStream, request);

            } else if (type.compareTo("excel") == 0) {
                response.setContentType("application/vnd.ms-excel");
                response.addHeader("Content-disposition", "attachment;filename=" + jasperName + ".xls");
                formatReportAsExcelStream(jsPrint, servletOutputStream, request);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void formatReportAsPdfStream(JasperPrint jsPrint, ServletOutputStream servletOutputStream, HttpServletRequest request) {
        try {
            JRPdfExporter pdfExporter = new JRPdfExporter();
            pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jsPrint);
            pdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
            pdfExporter.exportReport();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void formatReportAsHtmlStream(JasperPrint _jsPrint, ServletOutputStream _outputStream, HttpServletRequest request) {
        try {
            JRHtmlExporter htmlExporter = new JRHtmlExporter();
            htmlExporter.setParameter(JRExporterParameter.JASPER_PRINT, _jsPrint);
            htmlExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, _outputStream);
            htmlExporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, request.getContextPath() + "/servlets/image?image=");
            htmlExporter.exportReport();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void formatReportAsExcelStream(JasperPrint _jsPrint, ServletOutputStream _outputStream, HttpServletRequest request) {
        try {
            JRXlsExporter XlExporter = new JRXlsExporter();
            XlExporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, _jsPrint);
            XlExporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, _outputStream);
            XlExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
            XlExporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.FALSE);
            XlExporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            XlExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
            XlExporter.exportReport();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
////            if (toDate.equals("")) {
////                toDate = fo.format(new java.util.Date());
////            }
////            parameters.put("startDate", fromDate);
////            parameters.put("endDate", toDate);
////            Rs = reportEntity.readReport(code, empType, fromDate, toDate, dept);
////            if (Rs != null) {
////
////                jrRss = new JRResultSetDataSource(Rs);
////                JasperPrint jsPrint = JasperFillManager.fillReport(bias, parameters, jrRss);
////
////                if (type.compareTo("pdf") == 0) {
////                    formatReportAsPdfStream(jsPrint, servletOutputStream, request);
////                } else {
////                    formatReportAsHtmlStream(jsPrint, servletOutputStream, request);
////                }
////
////            } else {
////                String str = "<html> <body> <center><h3> No data found " +
////                        "</h3> </center> </body> </html>";
////                servletOutputStream.write(str.getBytes());
////            }
////
////
////        } catch (Exception ex) {
////            ex.printStackTrace();
////            ErrorLogWriter.writeError(ex);
////        }
////    }
    private Option[] reportOpt;

    public void getReportSummary(File jasperLocation, String jasperName, ServletOutputStream servletOutputStream, String type, HttpServletResponse response, HttpServletRequest request, Map parameters, JRMapCollectionDataSource data) {
        try {
            byte[] loc = extractByteArray(jasperLocation);
            InputStream inputStream = new ByteArrayInputStream(loc);
            JasperPrint jsPrint = JasperFillManager.fillReport(inputStream, parameters, data);
            generateReport(jsPrint, jasperName, servletOutputStream, type, response, request);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void generateReport(JasperPrint jsPrint, String jasperName, ServletOutputStream servletOutputStream, String type, HttpServletResponse response, HttpServletRequest request) {
        try {
            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jsPrint);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            ServletContext servletContext = (ServletContext) externalContext.getContext();
            if (type.compareTo("pdf") == 0) {
                String webContentRoot = servletContext.getRealPath("/");
                webContentRoot = webContentRoot + "PayRoll/PayRoll.pdf";
                File file = new File(webContentRoot);
                response.setContentType("application/pdf");//inline//attachment
                response.addHeader("Content-disposition", "attachment;filename=" + jasperName + ".pdf");
                JasperExportManager.exportReportToPdfFile(jsPrint, file.getPath());
                formatReportAsPdfStream(jsPrint, servletOutputStream, request);
            } else if (type.compareTo("html") == 0) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                response.addHeader("Content-disposition", "attachment;filename=" + jasperName + ".htm");
                formatReportAsHtmlStream(jsPrint, servletOutputStream, request);

            } else if (type.compareTo("excel") == 0) {
                response.setContentType("application/vnd.ms-excel");
                response.addHeader("Content-disposition", "attachment;filename=" + jasperName + ".xls");
                formatReportAsExcelStream(jsPrint, servletOutputStream, request);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return the reportOpt
     */
    public Option[] getReportOpt() {
        return reportOpt;
    }

    /**
     * @param reportOpt the reportOpt to set
     */
    public void setReportOpt(Option[] reportOpt) {
        this.reportOpt = reportOpt;
    }
    /////////////////////////////////////////new Add

    public void generateReport(HttpServletResponse response,
            HttpServletRequest request, String format,
            String fileName, HashMap param, Object data) {
        try {
            try {
            String _path = System.getProperty("user.home");
            _path = _path + File.separatorChar + "ReportData";
            File swapFileVirtualizer = new File(_path);
            if (!swapFileVirtualizer.isFile()) {
                swapFileVirtualizer.mkdir();
            }
            JRSwapFileVirtualizer fileVirtualizer = new JRSwapFileVirtualizer(10, new JRSwapFile(_path, 2048, 2048));
            param.put("REPORT_VIRTUALIZER", fileVirtualizer);
            File jasperFile = new File(fileName);
            ServletOutputStream outputStream = null;
            byte[] reportDesignByte = getBytesFromFile(jasperFile);
            ByteArrayInputStream reportDesign = new ByteArrayInputStream(reportDesignByte);
            JasperPrint jsPrint = null;
            if (data != null) {
                if ((data instanceof OracleCachedRowSet)) {
                    OracleCachedRowSet cachedResultSet = (OracleCachedRowSet) data;
                    if (cachedResultSet != null) {
                        if (cachedResultSet.next()) {
                            cachedResultSet.beforeFirst();
                            JRResultSetDataSource dataSource = new JRResultSetDataSource(cachedResultSet);
                            jsPrint = JasperFillManager.fillReport(reportDesign, param, dataSource);
                        }
                    }
                } else if ((data instanceof Collection)) {
                    Collection collection = (Collection) data;
                    if (collection != null) {
                        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(collection);
                        jsPrint = JasperFillManager.fillReport(reportDesign, param, dataSource);
                    }
                }
                if (format.compareTo("html") == 0) {
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/html;charset=UTF-8");
                    outputStream = response.getOutputStream();
                    formatReportAsHtmlStream(jsPrint, outputStream, request);
                } else if (format.compareTo("pdf") == 0) {
                    response.setContentType("application/pdf");
                    response.setHeader("Cache-Control", "no-cache");
                    response.setHeader("Cache-Control", "max-age=0");
                    response.setHeader("Content-disposition", "attachment; filename=Report.pdf");
                    outputStream = response.getOutputStream();
                    formatReportAsPdfStream(jsPrint, outputStream);
                } else if (format.compareTo("xlsx") == 0) {
                    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                    response.setHeader("Cache-Control", "no-cache");
                    response.setHeader("Cache-Control", "max-age=0");
                    outputStream = response.getOutputStream();
                    response.setHeader("Content-disposition", "attachment; filename=Report.xlsx");
                    response.flushBuffer();
                    formatReportAsXlsStream(jsPrint, outputStream);
                } else if (format.compareTo("docx") == 0) {
                    response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                    response.setHeader("Cache-Control", "no-cache");
                    response.setHeader("Cache-Control", "max-age=0");
                    response.setHeader("Content-disposition", "attachment; filename=Report.docx");
                    outputStream = response.getOutputStream();
                    response.flushBuffer();
                    formatReportAsDocxStream(jsPrint, outputStream);
                }
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                Locale locale = context.getViewRoot().getLocale();
                String message;
                if (locale.toString().compareToIgnoreCase("am_ET") == 0) {
                    if (data == null) {
                        message = "? ?? ?? ???? ????? .";
                    } else {
                        message = "??? ??? ??? ";
                    }
                } else {
                    if (data == null) {
                        message = "Can not establish connection to Database.";
                    } else {
                        message = "No Data Found";
                    }
                }
                outputStream.println("<html> <body> <center><h3> " + message + " " + "</h3> </center> </body> </html>");
                outputStream.close();
            }
            fileVirtualizer.cleanup();

           } catch (ClassCastException ex) {
            ex.printStackTrace();
           // ErrorLogWriter.writeError(ex);
        }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }

    public static void formatReportAsPdfStream(JasperPrint jsPrint, ServletOutputStream outputStream) {
        try {
            JRPdfExporter pdfExporter = new JRPdfExporter();
            pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jsPrint);
            pdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
            pdfExporter.exportReport();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }

    public static void formatReportAsXlsStream(JasperPrint jsPrint, ServletOutputStream outputStream) {
        try {
            JRXlsxExporter xlsExporter = new JRXlsxExporter();
            xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, jsPrint);
            xlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
            xlsExporter.exportReport();
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
        }
    }

    public static void formatReportAsDocxStream(JasperPrint jsPrint, ServletOutputStream outputStream) {
        try {
            JRDocxExporter docxExporter = new JRDocxExporter();
            docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jsPrint);
            docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
            docxExporter.exportReport();
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
        }
    }

    public static byte[] getBytesFromFile(File file)
            throws IOException {
        InputStream is = new FileInputStream(file);
        long length = file.length();
        if (length > 2147483647L) {
            throw new IOException(" File is too large " + file.getName());
        }
        byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead = 0;
        while ((offset < bytes.length) && ((numRead = is.read(bytes, offset, bytes.length - offset)) >= 0)) {

            offset += numRead;
        }
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }
        is.close();
        return bytes;
    }
}
