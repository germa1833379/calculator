import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent scient = FXMLLoader.load(getClass().getResource("calcuScientifique.fxml"));
            Parent prog = FXMLLoader.load(getClass().getResource("programmeur.fxml"));

            TabPane tabPane = new TabPane();
            tabPane.getTabs().add(new Tab("Scientifique",scient));
            tabPane.getTabs().add(new Tab("Programmeur",prog));


            primaryStage.setTitle("Calculatrice Scientifique");
            primaryStage.setScene(new Scene(tabPane));
            primaryStage.show();



        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
