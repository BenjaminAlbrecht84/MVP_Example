package MVP_Classic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Benjamin on 08.11.16.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Model model = new Model();
        View view = new View(model);
        new Presenter(view, model);

        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
