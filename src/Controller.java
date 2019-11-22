
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable
{

    @FXML
    Label label;
    StringProperty calc=new SimpleStringProperty();
    String curr="";
    @FXML
    public void add(ActionEvent event){
        String added = ((Button)event.getSource()).getText();

        curr+=added;
        calc.setValue(curr);
    }
    @Override
    public void initialize(URL location, ResourceBundle resource) {
        label.textProperty().bind(calc);
    }
    public void calculate(){
        char[] input= curr.toCharArray();
        ArrayList<Character> finalArray = new ArrayList<>();
        ArrayList<Character> temp = new ArrayList<>();
        String lol = "";
        for(int i=0;i<input.length;i++){
            char curr=input[i];
            if(Character.isDigit(curr)||curr=='e'||curr=='π'){
                finalArray.add(curr);
            }else if (curr=='*'){

            }else if (curr=='/'){

            }else if (curr=='^'){

            }else if (curr=='-'){

            }else if (curr=='+'){
                temp.add(curr);
            }else if (curr=='s'||curr=='i'||curr=='n'||curr=='o'||curr=='t'||curr=='a'||curr=='r'){
                lol+=(Character.toString(curr));
               if(lol.equals("sin")) {
                   temp.add('s');
                   lol="";
               }
                if(lol.equals("cos")) {
                    temp.add('c');lol="";
                }
                if(lol.equals("tan")) {
                    temp.add('t');lol="";
                }if(lol.equals("arcsin")) {
                    temp.add('j');lol="";
                }if(lol.equals("arccos")) {
                    temp.add('k');lol="";
                }
                if(lol.equals("arctan")) {
                    temp.add('l');lol="";
                }
                if(lol.equals("rac")) {
                    temp.add('r');lol="";
                }

            }
        }
    }
    public void remove(){

    }
    public StringProperty calcProperty(){
        return calc;
    }
}

