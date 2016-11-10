package MVP_Classic;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * Created by Benjamin on 08.11.16.
 */
public class View extends BorderPane {

    Label enterSequence;
    TextArea text;
    CheckBox isDNA, isRNA;
    Button save;

    public View(Model model) {

        enterSequence = new Label("Enter your sequence:");
        text = new TextArea();
        isDNA = new CheckBox("isDNA");
        isRNA = new CheckBox("isRNA");
        save = new Button("save");

        initFields();
        createLayout();
        initBindings(model);

    }

    // init bindings following the classical MVP-Pattern
    private void initBindings(Model model) {

        // binding property of the view to property of the model
        model.statusProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                text.setText(newValue);
            }
        });

    }

    private void initFields() {
        isDNA.setSelected(false);
        isRNA.setSelected(false);
        save.setDisable(true);
    }

    private void createLayout() {

        setPadding(new Insets(10, 10, 10, 10));

        HBox box = new HBox(isDNA, isRNA, save);
        box.setSpacing(10);

        setTop(enterSequence);
        setCenter(text);
        setBottom(box);

    }

}
