/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.Transfer;


import entity.Transfer.ApprovedTransfer;
import entity.Transfer.TransferEntity;
import entity.Transfer.TransfereeEntity;
import java.util.ArrayList;
import manager.authorizationManager.AuthorizationManager;

/**
 *
 * @author Abushu
 */
public class TransferManager {

    private TransfereeEntity transfereeEntity = new TransfereeEntity();
    private TransferEntity transferEntity = new TransferEntity();
    private ApprovedTransfer approvedTransfer = new ApprovedTransfer();


    // <editor-fold defaultstate="collapsed" desc="Constractor, getters and setters">
    public TransferManager() {
    }

    public TransferManager(TransfereeEntity transfereeEntity, TransferEntity transferEntity, ApprovedTransfer approvedTransfer) {
        this.transfereeEntity = transfereeEntity;
        this.transferEntity = transferEntity;
        this.approvedTransfer = approvedTransfer;
    }

    /**
     * @return the transfereeEntity
     */
    public TransfereeEntity getTransfereeEntity() {
        return transfereeEntity;
    }

    /**
     * @param transfereeEntity the transfereeEntity to set
     */
    public void setTransfereeEntity(TransfereeEntity transfereeEntity) {
        this.transfereeEntity = transfereeEntity;
    }

    /**
     * @return the transferEntity
     */
    public TransferEntity getTransferEntity() {
        return transferEntity;
    }

    /**
     * @param transferEntity the transferEntity to set
     */
    public void setTransferEntity(TransferEntity transferEntity) {
        this.transferEntity = transferEntity;
    }

    /**
     * @return the approvedTransfer
     */
    public ApprovedTransfer getApprovedTransfer() {
        return approvedTransfer;
    }

    /**
     * @param approvedTransfer the approvedTransfer to set
     */
    public void setApprovedTransfer(ApprovedTransfer approvedTransfer) {
        this.approvedTransfer = approvedTransfer;
    }
// </editor-fold >

    public boolean saveTransferRequest() {
        return this.transferEntity.saveTransferRequest();
    }

    public boolean updateTransferRequest() {
        return this.transferEntity.updateTransferRequest();
    }

    public void readTransferRequest(String transferRequestId) {

        transferEntity = this.transferEntity.readTransferRequest(transferRequestId);
    }

    public boolean cancelTransferRequest() {
        return this.transferEntity.cancelTransferRequest(this.transferEntity.getTransferId());
    }

 public boolean approveTransfer(ApprovedTransfer approvedTransfer) {

     if(approvedTransfer.getAction().equalsIgnoreCase("Reject")){
      transferEntity.setStatus("-"+approvedTransfer.getStateName());
     }else if(approvedTransfer.getAction().endsWith("Re-submit")){
      transferEntity.setStatus(transferEntity.getInitialState());
     }else{

     String nextState ="";// AuthorizationManager.readNextState(approvedTransfer.getStateName(), "10");
         transferEntity.setStatus(nextState);
     }
        return this.transferEntity.approveTransfer(this.approvedTransfer);
    }

    public ArrayList<String> readApproveableLists(String states) {
        return this.transferEntity.readApproveableLists(states);
    }

    public ArrayList<String> readHistory(String user) {
        return this.transferEntity.readHistory(user);
    }
}
