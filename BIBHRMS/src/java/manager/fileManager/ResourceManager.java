/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.fileManager;

import com.icesoft.faces.context.Resource;
import com.icesoft.faces.context.Resource.Options;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import javax.faces.context.ExternalContext;

/**
 *
 * @author Fekadu
 */
public class ResourceManager implements Resource, Serializable {

    private String resourceName;
    private InputStream inputStream;
    private final Date lastModified;
    private ExternalContext extContext;
    public static byte[] fileFromDb;
    public static byte[] uploadedFileDoc;
    public static String uploadedFileName;
    public static boolean fromDb = true;
    public static int fileId;

    public ResourceManager(ExternalContext ec, String resourceName) {
        this.extContext = ec;
        this.resourceName = resourceName;
        this.lastModified = new Date();
    }

    /**
     * This intermediate step of reading in the files from the JAR, into a
     * byte array, and then serving the Resource from the ByteArrayInputStream,
     * is not strictly necessary, but serves to illustrate that the Resource
     * content need not come from an actual file, but can come from any source,
     * and also be dynamically generated. In most cases, applications need not
     * provide their own concrete implementations of Resource, but can instead
     * simply make use of com.icesoft.faces.context.ByteArrayResource,
     * com.icesoft.faces.context.FileResource, com.icesoft.faces.context.JarResource.
     */
    public InputStream open() throws IOException {
        if (inputStream == null) {
            if (fromDb) {
                if (fileFromDb != null) {
                    try {
                        byte[] byteArray = fileFromDb;
                        inputStream = new ByteArrayInputStream(byteArray);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
            }
        }
        return inputStream;
    }

    public String calculateDigest() {
        return resourceName;
    }

    public Date lastModified() {
        return lastModified;
    }

    public void withOptions(Options arg0) throws IOException {
    }
}
