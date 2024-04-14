package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.application.Application;
import model.company.Company;
import model.enums.APPLICATIONSTATUS;
import model.enums.INDUSTRY;
import model.job.Job;
import model.user.RegularUser;
import model.utilities.DataUpdateInterface;

public class AddApplicationWindowController {
	
	private RegularUser user;
	
	private DataUpdateInterface dataUpdateInterface;

    @FXML
    private Button btn_save;
    
    @FXML
    private Button btn_cancel;

    @FXML
    private ComboBox<String> statusComboBox;
    
    @FXML
    private ComboBox<String> industryComboBox;
    
    @FXML
    private TextField jobNameField;

    @FXML
    private TextField companyNameField;

    @FXML
    private DatePicker dateAppliedPicker; 
    
    @FXML
    private TextField jobLinkField;
    
    // constructor
    public AddApplicationWindowController(RegularUser user, DataUpdateInterface dataUpdateInterface) {
        this.user = user;
        this.dataUpdateInterface = dataUpdateInterface; 
    }
    
    private ObservableList<Application> applications;
    
    public void initialize() {
    	
		// set up the items in the combo box
    	ArrayList<String> industryList = Arrays.stream(INDUSTRY.values())
                .map(Enum::name)
                .collect(Collectors.toCollection(ArrayList::new));

		industryComboBox.setItems(FXCollections.observableArrayList(industryList));
		
		// set up the items in the status combo box
        ObservableList<String> statusOptions = FXCollections.observableArrayList(
            "TOAPPLY", "DORESEARCH", "APPLIED", "SENTLINKEDIN", "INTERVIEW", "REJECTED", "GETOFFER"
        );
        statusComboBox.setItems(statusOptions);

    }
    

    
    @FXML
    void cancelApplication(ActionEvent event) {
    	// close the pop up window
    	System.out.println("closing the window");
    	// find the stage
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    
    @FXML
    void AddNewApplication(ActionEvent event) {
    	
    	// get the selected industry
    	String selectedIndustry = industryComboBox.getValue();

    	String companyName = companyNameField.getText();

    	// create the company
    	Company company = new Company(INDUSTRY.valueOf(selectedIndustry), companyName);
    	user.getCompanyList().addCompany(company);
    	
    	// create the job
    	String jobName = jobNameField.getText();
    	String jobLink = jobLinkField.getText();

    	Job job = new Job(company, jobName,jobLink);
    
    	// create an application
    	Application app = new Application(job);
    	user.getApplicationList().addApplication(app);
    	
    	
    	System.out.println("saved the new application!");
    	System.out.println("current application list: " + user.getApplicationList());

    	
    	// close the current window
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        
        // reload the application table
        if(dataUpdateInterface != null) {
            dataUpdateInterface.updateTable();
        }

    }
    
}
