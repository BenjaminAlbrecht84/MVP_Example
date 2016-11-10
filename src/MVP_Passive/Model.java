package MVP_Passive;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Benjamin on 08.11.16.
 */
public class Model {

    private static final ArrayList<Character> DNA_ALPHABET = new ArrayList<>(Arrays.asList('A', 'C', 'T', 'G'));
    private static final ArrayList<Character> RNA_ALPHABET = new ArrayList<>(Arrays.asList('A', 'C', 'U', 'G'));

    private ArrayList<String> rnaSequences;
    private ArrayList<String> dnaSequences;

    private StringProperty status = new SimpleStringProperty();

    public Model() {
        rnaSequences = new ArrayList<String>();
        dnaSequences = new ArrayList<String>();
    }

    public void addSequence(String seq, boolean isDNA) {
        if (checkSequence(seq, isDNA)) {
            if (isDNA)
                dnaSequences.add(seq);
            else
                rnaSequences.add(seq);
            status.setValue("Sequence added!");
        }
    }

    private boolean checkSequence(String seq, boolean isDNA) {
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (!checkCharacter(c, isDNA))
                return false;
        }
        return true;
    }

    private boolean checkCharacter(char c, boolean isDNA) {
        if (isDNA && !DNA_ALPHABET.contains(c)) {
            status.setValue("Not a correct DNA base:" + c);
            return false;
        }
        if (!isDNA && !RNA_ALPHABET.contains(c)) {
            status.setValue("Not a correct RNA base: " + c);
            return false;
        }
        return true;
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }
}
