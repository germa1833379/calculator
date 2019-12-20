import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;

import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProgrammeurController implements Initializable {
    //CONVERSION
    @FXML
    ChoiceBox choiceBox;
    @FXML
    Label label;
    @FXML
    TextArea tA;
    @FXML
    HBox hBox;
    @FXML
    TextArea textArea;

    StringProperty result=new SimpleStringProperty();
    String temp = "";
    ObjectProperty<Long> operationValue = new SimpleObjectProperty<>();

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        label.textProperty().bind(result);
        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                refresh();
            }
        });
        textArea.textProperty().bindBidirectional(operationValue,new LongStringConverter());
        //TODO RENDU ICI ESSAYER DE LIER LE CODE ET LE RESULT
    }
    @FXML
    public void refresh(){
        temp=tA.getText();
        switch(choiceBox.getSelectionModel().selectedIndexProperty().get()){
            case 0:
                try {
                    String thisResult="";
                    byte[] infoBin = temp.getBytes("UTF-8");
                    for (byte b : infoBin) {
                        String bin = Integer.toBinaryString(b);
                        if ( bin.length() < 8 )
                            bin = "0" + bin;
                        thisResult+=bin;
                    }
                    result.set(thisResult);
                }catch (Exception e){
                    System.out.println("Erreur 1");
                }
                break;
            case 1:
                String octalString="";
                for(int i = 0; i < temp.length(); i++){
                    octalString += Integer.toOctalString(temp.charAt(i));
                }
                result.set(octalString);
                break;
            case 2:
                try {
                    String thisResult="";
                    byte[] infoBin = temp.getBytes("UTF-8");
                    for (byte b : infoBin) {
                        String bin = Integer.toBinaryString(b);
                        bin=Integer.toString(Integer.parseInt(bin,2));
                        thisResult+=bin;
                    }
                    result.set(thisResult);
                }catch (Exception e){
                    System.out.println("Erreur 3");
                }

                break;
            case 3:
                try {
                    result.set(String.format("%x", new BigInteger(1, temp.getBytes("UTF-8"))));
                }catch (Exception e){
                    System.out.println("Erreur 4");
                }
                break;
        }
    }

    //Opérations binaires

    @FXML
    Button leftS,rightS,or,xor,not,and;


    public void callLeftS(){

        System.out.println(Integer.parseInt(textArea.getText()));
        String curr = textArea.getText();
        //textArea.setText(curr>>1);
    }
    public void callRightS(){

    }
    public void callOr(){

    }
    public void callXor(){

    }
    public void callNot(){

    }
    public void callAnd(){

    }
    public List getBytes(){
        boolean firstPass=true;
        List<String> allBinairy = new ArrayList<>();
        for(int i=0;i<textArea.getText().length();i++){
            if((i+1%8)==0&&!firstPass){
                allBinairy.add(textArea.getText(i-8,i));
            }
            firstPass=false;
        }
        return allBinairy;
    }


}
