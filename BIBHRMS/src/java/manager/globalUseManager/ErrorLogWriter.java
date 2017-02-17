/*
 * ErrorLogWriter.java
 *
 * Created on November 29, 2007, 10:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package manager.globalUseManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;


/**
 *
 * @author Administrator
 */
public class ErrorLogWriter {

    /** Creates a new instance of ErrorLogWriter */
    public ErrorLogWriter() {

    }

   /**
     * Writes the detail (ex.toString() and ex StackTrace) of the
     * exception ex to errorLog file
     * @param ex any type of exception
     * @return returns <b>true</b> for seccessful completion of the method,
     * <b>false</b> otherwise
     */
    public static boolean writeError(Exception ex) {
        try {
           String _path = "D:\\HRMSErrorLog.xml";
            File logError = new File(_path); //D:\\errLog.txt
            FileWriter writer;
            String currentContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
            currentContent += "\n<root>";
            if (!logError.isFile()) {
                // to create the file if it doesn't exist;
                FileOutputStream out = new FileOutputStream(logError);
                out.close();
            }
            if (logError.length() > 60) {
                char c[] = new char[(int) (logError.length()-7)];
                FileReader frdr = new FileReader(logError);
                frdr.read(c,0,(int)(logError.length()-7));
                currentContent = String.valueOf(c);
            }

            String error = "\n<date>\n\t" + new Date() + "\n</date>" +
                    "\n<message>\n\t" + ex.toString() + "\n</message>";
            StringWriter stackTrace = new StringWriter();
            ex.printStackTrace(new PrintWriter(stackTrace));
            error += "\n<stacktrace>\n\t" + stackTrace.toString() + "</stacktrace>";
            currentContent += error;
            currentContent += "\n</root>";

            writer = new FileWriter(logError);
            writer.write(currentContent);
            writer.close();

        } catch (Exception ex1) {
           //.println("Exception @ Authen : " + ex1.getMessage());
        }

        return true;
    }



}
