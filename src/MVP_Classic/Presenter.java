package MVP_Classic;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Created by Benjamin on 08.11.16.
 */
public class Presenter {

    private View view;
    private Model model;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
        attachEvents();
    }

    private void attachEvents() {

        // establishing view Logic
        view.isRNA.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                enableButton();
            }
        });

        view.isDNA.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                enableButton();
            }
        });

        view.text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                enableButton();
            }
        });

        // handling button event
        view.save.setOnAction(e -> model.addSequence(view.text.getText(), view.isDNA.isSelected()));

    }

    private void enableButton() {
        if ((view.isRNA.isSelected() && !view.isDNA.isSelected()) || (!view.isRNA.isSelected() && view.isDNA.isSelected())) {
            if (view.text.getText().length() > 5)
                view.save.setDisable(false);
            else
                view.save.setDisable(true);
        } else
            view.save.setDisable(true);
    }

}
