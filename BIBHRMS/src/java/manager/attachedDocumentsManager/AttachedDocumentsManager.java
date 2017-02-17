/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.attachedDocumentsManager;

import entity.attachedDocument.AttachedDocumentsEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author mekete
 */
public class AttachedDocumentsManager {

    AttachedDocumentsEntity attachedDocumentsEntity = new AttachedDocumentsEntity();

    public boolean saveAttachedDacument(String referencingTable, String primaryKeyOfreferencedTable, String fileNameOfDocument, String fileFormatOfDocument, byte[] document, String recordedBy, String recordedDateAndTime) {
        attachedDocumentsEntity = new AttachedDocumentsEntity(referencingTable, primaryKeyOfreferencedTable, fileNameOfDocument, fileFormatOfDocument, document, recordedBy, recordedDateAndTime);
        try {
            attachedDocumentsEntity.insertAttachedDocument();
            return true;
        } catch (SQLException sqle) {
            ErrorLogWriter.writeError(sqle);
            return false;
        }
    }

    /**   
     * @see AttachedDocumentsEntity.selectAttachedDocuments(String referencingTableName, String primaryKeyValueRefereningTable)
     */
    public ArrayList<HashMap> getAttachedDocuments(String referencingTableName, String primaryKeyValueRefereningTable) {
        try {
            ArrayList<HashMap> _attachedDocumentsList = new ArrayList<HashMap>();
            ResultSet _rs = attachedDocumentsEntity.selectAttachedDocuments(referencingTableName, primaryKeyValueRefereningTable);
            while (_rs.next()) {
                HashMap data = new HashMap();
                data.put("attachedDocumentId", _rs.getInt("ATTACHED_DOCUMENT_ID"));
                data.put("referencingTable", referencingTableName);
                data.put("referencingTablePrimaryey", primaryKeyValueRefereningTable);
                data.put("fileNameOfDocument", _rs.getString("FILE_NAME_OF_DOCUMENT"));
                data.put("fileFormatOfDocument", _rs.getString("FILE_FORMAT_OF_DOCUMENT"));
                data.put("document", _rs.getBlob("DOCUMENT"));
                data.put("recordedBy", _rs.getString("RECORDED_BY"));
                data.put("recordedDateAndTime", _rs.getString("RECORDED_DATE_AND_TIME"));
                _attachedDocumentsList.add(data);
            }
            return _attachedDocumentsList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public HashMap getAttachedDocument(String attachedDocumentId) {
        try {
            ResultSet _rs = attachedDocumentsEntity.selectAttachedDocument(attachedDocumentId);
            HashMap data = new HashMap();
            if (_rs.next()) {
                data.put("attachedDocumentId", attachedDocumentId);
                data.put("referencingTable", _rs.getInt("REFERENING_TABLE"));
                data.put("referencingTablePrimaryey", _rs.getInt("REFERENCING_TABLE_PRIMARYKEY"));
                data.put("fileNameOfDocument", _rs.getString("FILE_NAME_OF_DOCUMENT"));
                data.put("fileFormatOfDocument", _rs.getString("FILE_FORMAT_OF_DOCUMENT"));
                data.put("document", _rs.getBlob("DOCUMENT"));
                data.put("recordedBy", _rs.getString("RECORDED_BY"));
                data.put("recordedDateAndTime", _rs.getString("RECORDED_DATE_AND_TIME"));
            } else {
                data.put("attachedDocumentId", "");
                data.put("referencingTable", "");
                data.put("referencingTablePrimaryey", "");
                data.put("fileNameOfDocument", "");
                data.put("fileFormatOfDocument", "");
                data.put("document", "");
                data.put("recordedBy", "");
                data.put("recordedDateAndTime", "");
            }
            return data;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
}


