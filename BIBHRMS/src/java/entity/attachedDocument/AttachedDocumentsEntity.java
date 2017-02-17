/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.attachedDocument;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class AttachedDocumentsEntity
extends ConnectionManager{

    int attachedDocumentId;// ATTACHED_DOCUMENT_ID
    String referencingTable;//REFERENING_TABLE
    String referencingTablePrimaryey;//REFERENCING_TABLE_PRIMARYKEY
    String fileNameOfDocument;//FILE_NAME_OF_DOCUMENT
    String fileFormatOfDocument;//FILE_FORMAT_OF_DOCUMENT
    byte[] document;//DOCUMENT
    String recordedBy;//RECORDED_BY
    String recordedDateAndTime;//RECORDED_DATE_AND_TIME
    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

    public void releaseResources() throws SQLException {
        if (_rs != null) {
            _rs.close();
        }
        if (_ps != null) {
            _ps.close();
        }
        if (_con != null) {
         closePooledConnections(_con);
        }
    }
    public AttachedDocumentsEntity() {
    }

    public AttachedDocumentsEntity(String referencingTable, String referencingTablePrimaryey, String fileNameOfDocument, String fileFormatOfDocument, byte[] document) {
        this.referencingTable = referencingTable;
        this.referencingTablePrimaryey = referencingTablePrimaryey;
        this.fileNameOfDocument = fileNameOfDocument;
        this.fileFormatOfDocument = fileFormatOfDocument;
        this.document = document;
    }

    public AttachedDocumentsEntity(String referencingTable, String referencingTablePrimaryey, String fileNameOfDocument, String fileFormatOfDocument, byte[] document, String recordedBy, String recordedDateAndTime) {
        this(referencingTable, referencingTablePrimaryey, fileNameOfDocument, fileFormatOfDocument, document);
        this.recordedBy = recordedBy;
        this.recordedDateAndTime = recordedDateAndTime;
    }

    public AttachedDocumentsEntity(int attachedDocumentId, String referencingTable, String referencingTablePrimaryey, String fileNameOfDocument, String fileFormatOfDocument, byte[] document, String recordedBy, String recordedDateAndTime) {
        this(referencingTable, referencingTablePrimaryey, fileNameOfDocument, fileFormatOfDocument, document, recordedBy, recordedDateAndTime);
        this.attachedDocumentId = attachedDocumentId;
    }
    
    
  

    public int insertAttachedDocument() throws SQLException {
        String _insertQuery = "INSERT INTO  HR_ALL_ATTACHED_DOCUMENTS" +
                " (REFERENING_TABLE, REFERENCING_TABLE_PRIMARYKEY," +
                " FILE_NAME_OF_DOCUMENT,FILE_FORMAT_OF_DOCUMENT, DOCUMENT," +
                " RECORDED_BY,RECORDED_DATE_AND_TIME)" +
                " VALUES (?,?,?,?,?,?,?) ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);

            _ps.setString(1, referencingTable);
            _ps.setString(2, referencingTablePrimaryey);
            _ps.setString(3, fileNameOfDocument);
            _ps.setString(4, fileFormatOfDocument);
            _ps.setBytes(5, document);
            _ps.setString(6, recordedBy);
            _ps.setString(7, recordedDateAndTime);
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    /**
     * Returns ResultSet object of a attached documents.<br>
     * @param  referencingTableName the attached document is refferenced by this table.
     * @param primaryKeyValueRefereningTable the table should have a single primary key.
     * the primary key should not be composite value;
     * @throws  SQLException
     */
    public ResultSet selectAttachedDocuments(String referencingTableName, String primaryKeyValueRefereningTable) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_ALL_ATTACHED_DOCUMENTS WHERE REFERENING_TABLE= ? AND  REFERENCING_TABLE_PRIMARYKEY= ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, referencingTableName);
            _ps.setString(2, primaryKeyValueRefereningTable);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     * Returns ResultSet object of a attached documents.<br>
     * @param  primary key of table HR_ALL_ATTACHED_DOCUMENTS.
     * returns either single or sezo size result set;
     * @throws  SQLException
     */
    public ResultSet selectAttachedDocument(String attachedDocumentId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_ALL_ATTACHED_DOCUMENTS WHERE ATTACHED_DOCUMENT_ID= ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, attachedDocumentId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
}
