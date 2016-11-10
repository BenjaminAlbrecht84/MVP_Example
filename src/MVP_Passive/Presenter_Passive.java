package MVP_Passive;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Created by Benjamin on 08.11.16.
 */
public class Presenter_Passive {

    private View_Passive view;
    private Model model;
    private StringProperty status;

    public Presenter_Passive(View_Passive view, Model model) {
        this.view = view;
        this.model = model;
        status = new SimpleStringProperty();
        attachEvents();
        initBindings();
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

    // init bindings following the passive MVP-Pattern
    private void initBindings() {

        // binding property of the model to property of the controller
        model.statusProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                status.setValue(newValue);
            }
        });

        // binding property of the controller to the property of the view
        status.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                view.text.setText(status.getValue());
            }
        });

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
