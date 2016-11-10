package MVP_Passive;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * Created by Benjamin on 08.11.16.
 */
public class View_Passive extends BorderPane {

    Label enterSequence;
    TextArea text;
    CheckBox isDNA, isRNA;
    Button save;

    public View_Passive() {

        enterSequence = new Label("Enter your sequence:");
        text = new TextArea();
        isDNA = new CheckBox("isDNA");
        isRNA = new CheckBox("isRNA");
        save = new Button("save");

        createLayout();
        initFields();
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
