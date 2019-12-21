
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.lang.reflect.Array;
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
        ArrayList<String> finalArray = new ArrayList<>();
        Stack<Character> temp = new Stack<>();
        String lol = "";
        String last = "";
        for(int i=0;i<input.length;i++){
            char curr=input[i];
            if(!Character.isDigit(curr)&&curr!='e'&&curr!='π'){
                last="";
            }
            if(Character.isDigit(curr)||curr=='e'||curr=='π'){
                try {
                    if (last.equals("")) {
                        switch(curr){
                            case 'π':
                                finalArray.add(Double.toString(Math.PI));
                                break;
                            case 'e':
                                finalArray.add(Double.toString(Math.E));
                                break;
                                default:
                                    finalArray.add(Character.toString(curr));
                                    last = Character.toString(curr);
                                    break;
                        }

                    } else {
                        finalArray.remove(finalArray.size() - 1);
                        last += Character.toString(curr);
                        finalArray.add(last);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (curr=='*'){
                int sizeTemp=temp.size();
                for (int p =0;p<sizeTemp;p++){
                    if(temp.peek().equals('*')||temp.peek().equals('/')||temp.peek().equals('^')){
                        finalArray.add(temp.pop().toString());
                    }
                }temp.add('*');
            }else if (curr=='/'){
                int sizeTemp=temp.size();
                for (int p =0;p<sizeTemp;p++){
                    if(temp.peek().equals('*')||temp.peek().equals('/')||temp.peek().equals('^')){
                        finalArray.add(temp.pop().toString());
                    }
                }temp.add('/');
            }else if (curr=='^'){
                int sizeTemp=temp.size();
                for (int p =0;p<sizeTemp;p++){
                    if(temp.peek().equals('^')){
                        finalArray.add(temp.pop().toString());
                    }
                }temp.add('^');
            }else if (curr=='('){
                temp.add('(');
            }else if (curr==')'){
                int sizeTemp=temp.size();
                for (int p =0;p<sizeTemp;p++){
                    try {
                        if (!temp.peek().equals('(')) {
                            finalArray.add(temp.pop().toString());
                        } else {
                            temp.pop();
                            break;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("Pas de parenthèse qui match");
                    }

                }
            }else if (curr=='-'){
                int sizeTemp=temp.size();
                for (int p =0;p<sizeTemp;p++){
                    if(temp.peek().equals('-')||temp.peek().equals('+')||temp.peek().equals('*')||temp.peek().equals('/')||temp.peek().equals('^')){
                        finalArray.add(temp.pop().toString());
                    }
                }temp.add('-');
            }else if (curr=='+'){
                int sizeTemp=temp.size();
                for (int p =0;p<sizeTemp;p++){
                    if(temp.peek().equals('-')||temp.peek().equals('+')||temp.peek().equals('*')||temp.peek().equals('/')||temp.peek().equals('^')){
                        finalArray.add(temp.pop().toString());
                    }
                }temp.add('+');
            }else if (curr=='%') {
                temp.add('%');
            }else if (curr=='s'||curr=='i'||curr=='n'||curr=='o'||curr=='t'||curr=='a'||curr=='r'||curr=='c') {
                    lol += (Character.toString(curr));
                    if (lol.equals("sin")) {
                        temp.add('s');
                        lol = "";
                    }
                    if (lol.equals("cos")) {
                        temp.add('c');
                        lol = "";
                    }
                    if (lol.equals("tan")) {
                        temp.add('t');
                        lol = "";
                    }
                    if (lol.equals("arcsin")) {
                        temp.add('j');
                        lol = "";
                    }
                    if (lol.equals("arccos")) {
                        temp.add('k');
                        lol = "";
                    }
                    if (lol.equals("arctan")) {
                        temp.add('l');
                        lol = "";
                    }
                    if (lol.equals("rac")) {
                        temp.add('r');
                        lol = "";
                    }
                }
            }
            int sizeTemp=temp.size();
        for (int i =0;i<sizeTemp;i++){
            finalArray.add(temp.get(sizeTemp-1-i).toString());
            temp.remove(sizeTemp-i-1);
        }
        System.out.println((finalArray.toString()));
        System.out.println("Fini le string");
        boolean solved=false;
        String loperator="";
        double prem=707;//BUGGED
        double deux=606;
        int posOperator=0;
        double thisRep=101;

        while(!solved) {
            for(int i=0;i<finalArray.size();i++) {
                thisRep=101;
                prem=707;
                deux= 606;
                String temp1 = finalArray.get(i);
                if(temp1.equals("π")){
                    temp1=Double.toString(Math.PI);
                }
                if (loperator.equals("")&&(temp1.equals("s") || temp1.equals("c") || temp1.equals("t") ||
                        temp1.equals("r") || temp1.equals("*") || temp1.equals("^") || temp1.equals("%") || temp1.equals("m") || temp1.equals("+") ||
                        temp1.equals("/")|| temp1.equals("j")|| temp1.equals("k")|| temp1.equals("l"))){
                    loperator=temp1;
                    posOperator=i;
                }
                if(!loperator.equals("")&&!(temp1.equals("s") || temp1.equals("c") || temp1.equals("t") ||
                        temp1.equals("j")|| temp1.equals("k")|| temp1.equals("l"))){

                    prem=Double.parseDouble(finalArray.get(posOperator-2));
                    deux=Double.parseDouble(finalArray.get(posOperator-1));

                    //REMOVE DE LARRAY
                        finalArray.remove(posOperator);
                        finalArray.remove(posOperator-1);
                        //REMOVE PAS le posOperator-2 PARCEQUE IL LE REMPLACE APRÈS

                    switch (loperator){
                        case "r":
                            thisRep=Math.pow(prem,1/deux);
                            break;
                        case "*":
                            thisRep=prem*deux;
                            break;
                        case "^":
                            thisRep=Math.pow(prem,deux);
                            break;
                        case "%":
                            thisRep=prem%deux;
                            break;
                        case "/":
                            thisRep=prem/deux;
                            break;
                        case "+":
                            thisRep=prem+deux;
                            break;
                        case "-":
                            thisRep=prem-deux;
                            break;

                    }
                    loperator="";
                    finalArray.set(posOperator-2,Double.toString(thisRep));

                }
                if(!loperator.equals("")&&(temp1.equals("s") || temp1.equals("c") || temp1.equals("t") ||
                        temp1.equals("j")|| temp1.equals("k")|| temp1.equals("l"))) {

                    prem=Double.parseDouble(finalArray.get(posOperator-1));

                    finalArray.remove(posOperator);

                    switch (loperator) {
                        case "s":
                            thisRep = Math.sin(prem);
                            break;
                        case "c":
                            thisRep = Math.cos(prem);
                            break;
                        case "t":
                            thisRep = Math.tan(prem);
                            break;
                        case "j":
                            thisRep = Math.asin(prem);
                            break;
                        case "k":
                            thisRep = Math.acos(prem);
                            break;
                        case "l":
                            thisRep = Math.atan(prem);
                            break;
                    }
                    loperator="";
                    finalArray.set(posOperator-1,Double.toString(thisRep));
                }
            }
            if(finalArray.size()==1){
                solved=true;
            }
        }
        calc.setValue(finalArray.get(0));
        System.out.println(finalArray.get(0));

    }
    public void remove(){
        try {
            int wow = curr.length();
            curr = curr.substring(0, wow - 1);
            calc.setValue(curr);
        }catch (Exception e){
            System.out.println("Pu rien a enlever");
        }
    }
    public void eraseAll(){
        curr="";
        calc.setValue("");
    }
    public StringProperty calcProperty(){
        return calc;
    }
}

