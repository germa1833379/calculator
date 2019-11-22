import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable
{

    @FXML
    Label label;
    StringProperty calc=new SimpleStringProperty();
    String curr="";
    @FXML
    public void add(ActionEvent event){
        curr+=((Button)event.getSource()).getText();
        calc.setValue(curr);
    }
    @Override
    public void initialize(URL location, ResourceBundle resource) {
        label.textProperty().bind(calc);
    }
    public void calculate(){

    }
    public void remove(){

    }
    public StringProperty calcProperty(){
        return calc;
    }
}

