
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
                        finalArray.add(Character.toString(curr));
                        last = Character.toString(curr);
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
                    if(temp.peek().equals('*')||temp.peek().equals('/')){
                        finalArray.add(temp.pop().toString());
                    }else
                        break;
                }temp.add('*');
            }else if (curr=='/'){
                int sizeTemp=temp.size();
                for (int p =0;p<sizeTemp;p++){
                    if(temp.peek().equals('*')||temp.peek().equals('/')){
                        finalArray.add(temp.pop().toString());
                    }else{
                        temp.add('/');
                        break;
                    }

                }temp.add('/');
            }else if (curr=='^'){
                temp.add('^');
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
                    if(temp.peek().equals('-')||temp.peek().equals('+')){
                        finalArray.add(temp.pop().toString());
                    }
                }temp.add('-');
            }else if (curr=='+'){
                int sizeTemp=temp.size();
                for (int p =0;p<sizeTemp;p++){
                    if(temp.peek().equals('-')||temp.peek().equals('+')){
                        finalArray.add(temp.pop().toString());
                    }
                }temp.add('+');
            }else if (curr=='s'||curr=='i'||curr=='n'||curr=='o'||curr=='t'||curr=='a'||curr=='r') {
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
        boolean gotFirst=false;
        String leFirst="";
        String leSecond="";
        String loperator="";
        double rep;
        double prem=19302;//BUGGED
        while(!solved){
            for(int i=0;i<finalArray.size();i++) {
                String temp1 = finalArray.get(i);finalArray.set(i,"");
                if (loperator.equals("")&&(temp1.equals("s") || temp1.equals("c") || temp1.equals("t") ||
                        temp1.equals("rac") || temp1.equals("*") || temp1.equals("^") || temp1.equals("%") || temp1.equals("-") || temp1.equals("+") ||
                        temp1.equals("/")|| temp1.equals("j")|| temp1.equals("k")|| temp1.equals("l"))) {
                    loperator = temp1;
                } else {
                    if (leFirst.equals("")) {
                        leFirst = temp1;
                    } else if (leSecond.equals("")) {
                        leSecond = temp1;
                    }
                }
                if((!leFirst.equals("")||!leSecond.equals(""))&&!loperator.equals("")){
                    double next=10000;
                    if(!gotFirst) {
                        prem = Double.parseDouble(leFirst);gotFirst=true;
                    }
                    if(!leSecond.equals("")){
                         next=Double.parseDouble(leSecond);
                    }
                    switch(loperator){
                        case("+"):prem+=next;leSecond="";loperator="";break;
                        case("-"):prem-=next;leSecond="";loperator="";break;
                        case("/"):prem=prem/next;leSecond="";loperator="";break;
                        case("%"):prem=prem%next;leSecond="";loperator="";break;
                        case("^"):prem=Math.pow(prem,next);leSecond="";loperator="";break;
                        case("*"):prem=prem*next;leSecond="";loperator="";break;
                        case("s"):prem=Math.sin(prem);loperator="";break;
                        case("c"):prem=Math.cos(prem);loperator="";break;
                        case("t"):prem=Math.tan(prem);loperator="";break;
                        case("j"):prem=Math.asin(prem);loperator="";break;//ARCSIN
                        case("k"):prem=Math.acos(prem);loperator="";break;//ARCCOS
                        case("l"):prem=Math.atan(prem);loperator="";break;//ARCTAN
                        case("rac"):prem=Math.pow(prem,1/next);
                    }
                }
            }for(int i=0;i<finalArray.size();i++){
                solved=true;
                if(!finalArray.get(i).equals("")){
                    solved=false;
                }
            }
        }
        calc.setValue(Double.toString(prem));
        finalArray.clear();
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

