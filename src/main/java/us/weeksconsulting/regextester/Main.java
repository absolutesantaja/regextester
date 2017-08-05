package us.weeksconsulting.regextester;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    @FXML
    private TextField regexTextField;
    @FXML
    private TextField inputTextField;
    @FXML
    private TextField replaceTextField;
    @FXML
    private TextArea outputTextArea;

    @FXML
    private void handleKeyReleased(KeyEvent ke) {
        if (!regexTextField.getText().equals("")) {
            try {
                StringBuilder sb = new StringBuilder();
                Pattern p = Pattern.compile(regexTextField.getText());
                Matcher m = p.matcher(inputTextField.getText());
                if (m.matches()) {
                    sb.append("Match: ").append(m.group()).append('\n');
                    for (int i = 1; i <= m.groupCount(); i++) {
                        sb.append("Group ").append(i).append(": ").append(m.group(i)).append('\n');
                    }
                } else {
                    sb.append("Match: No Match Found").append('\n');
                }
                if (!replaceTextField.getText().equals("")) {
                    sb.append("ReplaceAll Text: ").append(m.replaceAll(replaceTextField.getText())).append('\n');
                    sb.append("ReplaceFirst Text: ").append(m.replaceFirst(replaceTextField.getText())).append('\n');
                }
                outputTextArea.setText(sb.toString());
            } catch (Exception ex) {
                outputTextArea.setText(ex.getMessage());
            }
        }
    }


    public void initialize() {
    }
}
