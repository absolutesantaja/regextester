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
        try {
            StringBuilder sb = new StringBuilder();
            Pattern p = Pattern.compile(regexTextField.getText());
            Matcher m = p.matcher(inputTextField.getText());
            if (m.matches()) {
                sb.append("Match: ").append(m.group());
                for (int i = 1; i <= m.groupCount(); i++) {
                    sb.append('\n').append("Group ").append(i).append(": ").append(m.group(i));
                }
            }
            sb.append('\n').append("ReplaceAll Text: ").append(m.replaceAll(replaceTextField.getText()));
            sb.append('\n').append("ReplaceFirst Text: ").append(m.replaceFirst(replaceTextField.getText()));
            outputTextArea.setText(sb.toString());
        } catch (Exception ex) {
            outputTextArea.setText(ex.getMessage());
        }
    }


    public void initialize() {
    }
}
