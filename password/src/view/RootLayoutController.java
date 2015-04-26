package view;

import main.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;

public class RootLayoutController {
	
    private MainApp mainApp;
    private String password;
    
    @FXML private PasswordField passbox;
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    private void checkPassword(String pw) {
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("Password");
        
    	if (mainApp.getPassword().equals(pw)) {
    		
            alert.setHeaderText("The password you entered was correct!");
            //do something here
            
    	} else {
    		
            alert.setAlertType(AlertType.WARNING);
            alert.setHeaderText("The password you entered was not correct.");
            alert.setContentText("Please try again.");
            
    	}
    	alert.showAndWait();
    	passbox.setText("");
    }
    
    @FXML
    private void handleOK() {
    	password = passbox.getText();
    	checkPassword(this.password);
    }
    
    @FXML
    private void handleHelp() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("Help");
        alert.setHeaderText("Help button pressed!");
    	alert.showAndWait();
    }
    
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}