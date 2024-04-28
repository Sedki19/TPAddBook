package application;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

public class AddBookControlor implements Initializable {
	DataClass data;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnom.setCellValueFactory(new PropertyValueFactory("nom"));	
		cprenom.setCellValueFactory(new PropertyValueFactory("prenom"));
		cemail.setCellValueFactory(new PropertyValueFactory("email"));
		data = new DataClass();
		for (Person p : data.getImportList()) {
			table.getItems().add(p);
		}
		
		
		
		
	}

    @FXML
    private Button addtab;

    @FXML
    private TableColumn<Person, String> cemail;

    @FXML
    private TableColumn<Person, String> cnom;

    @FXML
    private TableColumn<Person,String> cprenom;

    @FXML
    private Button del;

    @FXML
    private TextField email;

    @FXML
    private Button exporter;

    @FXML
    private Button importer;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private Button quitter;

    @FXML
    private TableView<Person> table;
    
    @FXML
    public void addColumn(ActionEvent e) {//need to work on this + editable table
    	Window owner = addtab.getScene().getWindow();
    	if(nom.getText() == "" && prenom.getText() == "" && email.getText() == "") {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText(null);
    		alert.setContentText("Remplir tout les champs !");
    		alert.initOwner(owner);
    		alert.show();
    	}
    	else if(nom.getText() == "") {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText(null);
    		alert.setContentText("Nom vide !");
    		alert.initOwner(owner);
    		alert.show();
    		
    		
    	}
    	else if(prenom.getText() == ""){
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText(null);
    		alert.setContentText("Prenom vide !");
    		alert.initOwner(owner);
    		alert.show();
    	}
    	else if(email.getText() == "") {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText(null);
    		alert.setContentText("Email vide !");
    		alert.initOwner(owner);
    		alert.show();
    	}
    	else if (!(isEmailAdress(email.getText()))) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText(null);
    		alert.setContentText("Email Invalid !");
    		alert.initOwner(owner);
    		alert.show();
    	}
    	
    	else {
    	table.getItems().add(new Person(nom.getText(),prenom.getText(),email.getText())); 
    	}
    	
    	
    }
    
    @FXML
    public void delColumn(ActionEvent e) {
    	
    table.getItems().remove(table.getSelectionModel().getSelectedItem());
   
    }

    @FXML
    public void quitter (ActionEvent e) {
    	Platform.exit();
    	
    }
    
    
    @FXML
    public void export (ActionEvent e) {
    	data.setExportList(table.getItems());
    }
	
    @FXML
    public void importfun (ActionEvent e) {
    	for(Person p :data.getImportList()) {
    		table.getItems().add(p);
    	}
    
    }
    
    public static boolean isEmailAdress(String email){
    	Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$" );
    	Matcher m = p.matcher(email.toUpperCase());
    	return m.matches();
    	}

}
