import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

public class ControllerNormal {

    @FXML
    private Label calcul;
    @FXML
    private Label resultat;
    private int number;
    private String numberText = "";
    private String resultatText = "";
    private int number2;
    private int action;

    public void addition() {
        if (action == 0) {
            number2 = number;
            number = 0;
            action = 1;
            numberText = numberText + " + ";
            calcul.setText(numberText);
        }
    }

    public void soustraction() {
        if (action == 0) {
            number2 = number;
            number = 0;
            action = 2;
            numberText = numberText + " - ";
            calcul.setText(numberText);
        }
    }

    public void multiplication() {
        if (action == 0) {
            number2 = number;
            number = 0;
            action = 3;
            numberText = numberText + " * ";
            calcul.setText(numberText);
        }
    }

    public void division() {
        if (action == 0) {
            number2 = number;
            number = 0;
            action = 4;
            numberText = numberText + " / ";
            calcul.setText(numberText);
        }
    }

    public void carré() {
        if (action == 0) {
            resultat.setText(String.valueOf(number * number));
            action = 9;
        }
    }

    public void racineCarrée() {
        if (action == 0) {
            resultat.setText(String.valueOf(Math.sqrt((float)number)));
            action = 9;
        }
    }

    public void unSurx() {
        if (action == 0) {
            resultat.setText(String.valueOf(1 / (float)number));
            action = 9;
        }
    }

    public void negatif() {
        number = number * -1;
        if (action == 0) {
            numberText = String.valueOf(number);
        }
        if (action == 1) {
            numberText = number2 + " + " + number;
        }
        if (action == 2) {
            numberText = number2 + " - " + number;
        }
        if (action == 3) {
            numberText = number2 + " * " + number;
        }
        if (action == 4) {
            numberText = number2 + " / " + number;
        }
        calcul.setText(numberText);
    }

    public void effacer() {
        action = 9;
        erase();
    }

    public void egale() {
        switch(action) {
            case 0:
                break;
            case 1:
                resultat.setText(String.valueOf(number + number2));
                action = 9;
                break;
            case 2:
                resultat.setText(String.valueOf(number2 - number));
                action = 9;
                break;
            case 3:
                resultat.setText(String.valueOf(number * number2));
                action = 9;
                break;
            case 4:
                resultat.setText(String.valueOf((float)number2 / (float)number));
                action = 9;
                break;
        }
    }

    public void b1() {
        erase();
        number = Integer.parseInt((number) + "1");
        numberText = numberText + "1";
        calcul.setText(numberText);
    }

    public void b2() {
        erase();
        number = Integer.parseInt(String.valueOf(number) + "2");
        numberText = numberText + "2";
        calcul.setText(String.valueOf(numberText));    }

    public void b3() {
        erase();
        number = Integer.parseInt(String.valueOf(number) + "3");
        numberText = numberText + "3";
        calcul.setText(String.valueOf(numberText));    }

    public void b4() {
        erase();
        number = Integer.parseInt(String.valueOf(number) + "4");
        numberText = numberText + "4";
        calcul.setText(String.valueOf(numberText));    }

    public void b5() {
        erase();
        number = Integer.parseInt(String.valueOf(number) + "5");
        numberText = numberText + "5";
        calcul.setText(String.valueOf(numberText));    }

    public void b6() {
        erase();
        number = Integer.parseInt(String.valueOf(number) + "6");
        numberText = numberText + "6";
        calcul.setText(String.valueOf(numberText));    }

    public void b7() {
        erase();
        number = Integer.parseInt(String.valueOf(number) + "7");
        numberText = numberText + "7";
        calcul.setText(String.valueOf(numberText));    }

    public void b8() {
        erase();
        number = Integer.parseInt(String.valueOf(number) + "8");
        numberText = numberText + "8";
        calcul.setText(String.valueOf(numberText));    }

    public void b9() {
        erase();
        number = Integer.parseInt(String.valueOf(number) + "9");
        numberText = numberText + "9";
        calcul.setText(String.valueOf(numberText));    }

    public void b0() {
        erase();
        number = Integer.parseInt(String.valueOf(number) + "0");
        numberText = numberText + "0";
        calcul.setText(String.valueOf(numberText));
    }

    private void erase() {
        if (action == 9) {
            action = 0;
            number = 0;
            number2 = 0;
            numberText = "";
            calcul.setText("");
            resultat.setText("");
        }
    }

    @FXML Label labelTemperature;
    @FXML Spinner temperature;
    @FXML Label labelMasse;
    @FXML Spinner masse;
    @FXML Label labelLongeur;
    @FXML Spinner longeur;
    @FXML Label labelVitesse;
    @FXML Spinner vitesse;
    @FXML Label labelAngle;
    @FXML Spinner angle;
    @FXML Label labelVolume;
    @FXML Spinner volume;
    @FXML Label labelDevise;
    @FXML Spinner devise;
    @FXML Label labelTemps;
    @FXML Spinner temps;

    public void farenheit() {
        if (labelTemperature.getText().equals("C")) {
            temperature.getValueFactory().setValue(((int)temperature.getValue() * 9/5 + 32));
        }
        if (labelTemperature.getText().equals("K")) {
            temperature.getValueFactory().setValue((((int)temperature.getValue() - 273) * 9/5 + 32));
        }
        labelTemperature.setText("F");
    }

    public void celcius() {
        if (labelTemperature.getText().equals("F")) {
            temperature.getValueFactory().setValue(((int)temperature.getValue() - 32) * 5/9);
        }
        if (labelTemperature.getText().equals("K")) {
            temperature.getValueFactory().setValue((int)temperature.getValue() - 273);
        }
        labelTemperature.setText("C");
    }

    public void kelvin() {
        if (labelTemperature.getText().equals("F")) {
            temperature.getValueFactory().setValue(((int)temperature.getValue() - 32) * 5/9 + 273);
        }
        if (labelTemperature.getText().equals("C")) {
            temperature.getValueFactory().setValue((int)temperature.getValue() + 273);
        }
        labelTemperature.setText("K");
    }

    public void grams() {
        if (labelMasse.getText().equals("kg")) {
            masse.getValueFactory().setValue((int)masse.getValue() * 1000);
        }
        if (labelMasse.getText().equals("lb")) {
            masse.getValueFactory().setValue((int)masse.getValue() * 454);
        }
        labelMasse.setText("g");
    }

    public void kilograms() {
        if (labelMasse.getText().equals("g")) {
            masse.getValueFactory().setValue((int)masse.getValue() / 1000);
        }
        if (labelMasse.getText().equals("lb")) {
            masse.getValueFactory().setValue((int)masse.getValue() / 2);
        }
        labelMasse.setText("kg");
    }

    public void livres() {
        if (labelMasse.getText().equals("g")) {
            masse.getValueFactory().setValue((int)masse.getValue() / 454);
        }
        if (labelMasse.getText().equals("kg")) {
            masse.getValueFactory().setValue((int)masse.getValue() * 2);
        }
        labelMasse.setText("lb");
    }

    public void miles() {
        if (labelLongeur.getText().equals("km")) {
            longeur.getValueFactory().setValue((int)longeur.getValue() / 2);
        }
        if (labelLongeur.getText().equals("ft")) {
            longeur.getValueFactory().setValue((int)longeur.getValue() / 5280);
        }
        labelLongeur.setText("mi");
    }

    public void kilometres() {
        if (labelLongeur.getText().equals("mi")) {
            longeur.getValueFactory().setValue((int)longeur.getValue() * 2);
        }
        if (labelLongeur.getText().equals("ft")) {
            longeur.getValueFactory().setValue((int)longeur.getValue() / 3281);
        }
        labelLongeur.setText("km");
    }

    public void pieds() {
        if (labelLongeur.getText().equals("mi")) {
            longeur.getValueFactory().setValue((int)longeur.getValue() * 5280);
        }
        if (labelLongeur.getText().equals("km")) {
            longeur.getValueFactory().setValue((int)longeur.getValue() * 3281);
        }
        labelLongeur.setText("ft");
    }

    public void kmh() {
        if (labelVitesse.getText().equals("m/s")) {
            vitesse.getValueFactory().setValue((int)vitesse.getValue() * 4);
        }
        labelVitesse.setText("km/h");
    }

    public void ms() {
        if (labelVitesse.getText().equals("km/h")) {
            vitesse.getValueFactory().setValue((int)vitesse.getValue() / 4);
        }
        labelVitesse.setText("m/s");
    }

    public void radien() {
        if (labelAngle.getText().equals("π")) {
            angle.getValueFactory().setValue((int)angle.getValue() * 3);
        }
        if (labelAngle.getText().equals("°")) {
            angle.getValueFactory().setValue((int)angle.getValue() / 57);
        }
        labelAngle.setText("rad");
    }

    public void pi() {
        if (labelAngle.getText().equals("rad")) {
            angle.getValueFactory().setValue((int)angle.getValue() / 3);
        }
        if (labelAngle.getText().equals("°")) {
            angle.getValueFactory().setValue((int)angle.getValue() / 180);
        }
        labelAngle.setText("π");
    }

    public void degre() {
        if (labelAngle.getText().equals("rad")) {
            angle.getValueFactory().setValue((int)angle.getValue() * 57);
        }
        if (labelAngle.getText().equals("π")) {
            angle.getValueFactory().setValue((int)angle.getValue() * 180);
        }
        labelAngle.setText("°");
    }

    public void cm3() {
        if (labelVolume.getText().equals("m³")) {
            volume.getValueFactory().setValue((int)volume.getValue() * 1000000);
        }
        labelVolume.setText("cm³");
    }

    public void m3() {
        if (labelVolume.getText().equals("cm³")) {
            volume.getValueFactory().setValue((int)volume.getValue() / 1000000);
        }
        labelVolume.setText("m³");
    }

    public void CA() {
        if (labelDevise.getText().equals("UK£")) {
            devise.getValueFactory().setValue((int)devise.getValue() * 2);
        }
        if (labelDevise.getText().equals("JPY¥")) {
            devise.getValueFactory().setValue((int)devise.getValue() / 83);
        }
        labelDevise.setText("CA$");
    }

    public void UK() {
        if (labelDevise.getText().equals("CA$")) {
            devise.getValueFactory().setValue((int)devise.getValue() / 2);
        }
        if (labelDevise.getText().equals("JPY¥")) {
            devise.getValueFactory().setValue((int)devise.getValue() / 142);
        }
        labelDevise.setText("UK£");
    }

    public void JPY() {
        if (labelDevise.getText().equals("CA$")) {
            devise.getValueFactory().setValue((int)devise.getValue() * 83);
        }
        if (labelDevise.getText().equals("UK£")) {
            devise.getValueFactory().setValue((int)devise.getValue() * 142);
        }
        labelDevise.setText("JPY¥");
    }

    public void sec() {
        if (labelTemps.getText().equals("min")) {
            temps.getValueFactory().setValue((int)temps.getValue() / 60);
        }
        if (labelTemps.getText().equals("h")) {
            temps.getValueFactory().setValue((int)temps.getValue() / 3600);
        }
        labelTemps.setText("s");
    }

    public void min() {
        if (labelTemps.getText().equals("s")) {
            temps.getValueFactory().setValue((int)temps.getValue() * 60);
        }
        if (labelTemps.getText().equals("h")) {
            temps.getValueFactory().setValue((int)temps.getValue() / 60);
        }
        labelTemps.setText("min");
    }

    public void heure() {
        if (labelTemps.getText().equals("min")) {
            temps.getValueFactory().setValue((int)temps.getValue() * 60);
        }
        if (labelTemps.getText().equals("s")) {
            temps.getValueFactory().setValue((int)temps.getValue() * 3600);
        }
        labelTemps.setText("h");
    }

}
