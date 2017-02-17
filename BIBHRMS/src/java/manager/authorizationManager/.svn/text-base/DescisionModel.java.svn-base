/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.authorizationManager;

/**
 *
 * @author mekete
 */
public class DescisionModel {

    private int decisiopId;//@Column(name = "_PROCESSED_ID")
    private int requestId; //@Column(name = "OVER_TIME_REQUEST_ID")
    private String processedBy;//@Column(name = "PROCEESED_BY")
    private String decision;//@Column(name = "DECISION_BY")
    private String nextState;//   @Column(name = "NEXT_STATE")
    private String commentGiven;// @Column(name = "COMMENT_GIVEN")
    private String recordedBy;//  @Column(name = "RECORDED_BY")//  String userName;
    private String recorededDateAndTime;//  @Column(name = "TIME_STAMP")

    public DescisionModel() {
    }

    public DescisionModel(int requestId, String processedBy, String decision, String nextState, String commentGiven, String recordedBy, String recorededDateAndTime) {
        this.requestId = requestId;
        this.processedBy = processedBy;
        this.decision = decision;
        this.nextState = nextState;
        this.commentGiven = commentGiven;
        this.recordedBy = recordedBy;
        this.recorededDateAndTime = recorededDateAndTime;
    }

   

    public String getCommentGiven() {
        return commentGiven;
    }

    public void setCommentGiven(String commentGiven) {
        this.commentGiven = commentGiven;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public int getDecisiopId() {
        return decisiopId;
    }

    public void setDecisiopId(int decisiopId) {
        this.decisiopId = decisiopId;
    }

    public String getNextState() {
        return nextState;
    }

    public void setNextState(String nextState) {
        this.nextState = nextState;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public String getRecordedBy() {
        return recordedBy;
    }

    public void setRecordedBy(String recordedBy) {
        this.recordedBy = recordedBy;
    }

    public String getRecorededDateAndTime() {
        return recorededDateAndTime;
    }

    public void setRecorededDateAndTime(String recorededDateAndTime) {
        this.recorededDateAndTime = recorededDateAndTime;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
}
