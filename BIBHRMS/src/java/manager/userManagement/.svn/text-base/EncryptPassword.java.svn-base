/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.userManagement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import manager.globalUseManager.ErrorLogWriter;


/**
 *
 * @author Administrator
 */
public class EncryptPassword {

  public static String encryptPassword(String password) {

    String encryptedPassword = null;
    if (password.length() == 0) {
      System.err.println("Usage: EncryptPassword " + "cleartext");
    } else {
      MessageDigest messageDigest;
      try {
        messageDigest = MessageDigest.getInstance("MD5");
        byte[] bs;
        messageDigest.reset();
        bs = messageDigest.digest(password.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        //hex encode the digest
        for (int i = 0; i < bs.length; i++) {
          String hexVal = Integer.toHexString(0xFF & bs[i]);
          if (hexVal.length() == 1) {
            stringBuilder.append("0");
          }
          stringBuilder.append(hexVal);
        }
        encryptedPassword = stringBuilder.toString();

      } catch (NoSuchAlgorithmException ex) {
        ex.printStackTrace();
        ErrorLogWriter.writeError(ex);
      }
    }
    return encryptedPassword;
  }

//  public static void main(String[] args) {
//    String password = "test";
//    String encryptedPassword = null;
//    encryptedPassword = encryptPassword(password);
//    s.println(encryptedPassword);
//  }
}

