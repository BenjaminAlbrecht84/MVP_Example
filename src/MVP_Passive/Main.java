package MVP_Passive;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Benjamin on 08.11.16.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        View_Passive view = new View_Passive();
        Model model = new Model();
//        new Controller(view, model);
        new Presenter_Passive(view, model);

        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
