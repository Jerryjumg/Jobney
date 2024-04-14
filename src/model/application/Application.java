package model.application;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import model.connection.ConnectionList;
import model.document.DocumentList;
import model.enums.APPLICATIONSTATUS;
import model.enums.RATE;
import model.job.Job;
import model.note.NoteList;
import model.question.QuestionList;

public class Application {
	
	final String prefix = "application-";
	private static int nextId = 1;
//	private String jobName;
//	private String companyName;
    private String applicationId;
    private Date dateAdded;
    private String dateApplied;
    private Job associatedJob; 
    private RATE rate; 
    private Date applyDeadline;
    private APPLICATIONSTATUS status;
    private List<StatusChange> statusChangeHistory; 
    
	private QuestionList questionList;
    private NoteList noteList;
    private ConnectionList connectionList;
    private DocumentList documentList;

    public Application(Job associatedJob) {
        this.associatedJob = associatedJob;
        this.applicationId = prefix + nextId;
        this.dateAdded = new Date();
        this.status = APPLICATIONSTATUS.TOAPPLY;
        this.dateApplied = "N/A";
        nextId++;
        this.questionList = new QuestionList();
        this.noteList = new NoteList();
        this.connectionList = new ConnectionList();
        this.documentList = new DocumentList();
        
    }
    
    public Application(Job associatedJob, APPLICATIONSTATUS status, String dateApplied) {
        this.associatedJob = associatedJob;
        this.applicationId = prefix + nextId;
        this.dateAdded = new Date();
        this.status = status;
        this.dateApplied = dateApplied;
        nextId++;
    }

//    public Application(String jobName, String companyName, Date dateApplied, APPLICATIONSTATUS status) {
//        this.jobName = jobName;
//        this.companyName = companyName;
//        this.dateApplied = dateApplied;
//        this.status = status;
//        this.applicationId = prefix + nextId;
//        this.dateAdded = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
//        nextId++;
//    }
    
	public String getJobName() {
		return this.associatedJob.getJobName();
	}
	
	public Job getAssociatedJob() {
		return this.associatedJob;
	}
	
	public String getCompanyName() {
		return this.associatedJob.getAssociatedCompany().getCompanyName();
	}
	
	public String getApplicationId() {
		return this.applicationId;
	}

	public RATE getRate() {
		return this.rate;
	}
	
	public Date getApplyDeadline() {
		return this.applyDeadline;
	}
	
	public APPLICATIONSTATUS getStatus() {
		return this.status;
	}
	
	public List<StatusChange> getStatusChangeHistory(){
	 return this.statusChangeHistory;
	}
	
	 public String getDateAdded() {
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        return formatter.format(this.dateAdded);
    }

	 public String getDateApplied() {
        return this.dateApplied;
    }

    public void setDateApplied() {
    	Date date = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        this.dateApplied = formatter.format(date);
    }
    
    public void setStatus(APPLICATIONSTATUS status) {
        this.status = status;
    }
    
    public QuestionList getQuestionList() {
		return questionList;
	}

	public void setQuestionList(QuestionList questionList) {
		this.questionList = questionList;
	}

	public NoteList getNoteList() {
		return noteList;
	}

	public void setNoteList(NoteList noteList) {
		this.noteList = noteList;
	}

	public ConnectionList getConnectionList() {
		return connectionList;
	}

	public void setConnectionList(ConnectionList connectionList) {
		this.connectionList = connectionList;
	}

	public DocumentList getDocumentList() {
		return documentList;
	}

	public void setDocumentList(DocumentList documentList) {
		this.documentList = documentList;
	}

    

}
