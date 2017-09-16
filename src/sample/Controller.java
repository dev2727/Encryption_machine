package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller  implements Initializable{

    @FXML
    Text textError;
    @FXML
    TextArea textOrg ;
    @FXML
    TextField textFieldA ;
    @FXML
    TextField textFieldB;
    @FXML
    TextArea textCrypte ;
    @FXML
    Text error;
    static String textOrgfield;
    TextOriginal t = new TextOriginal();

    public void crypteButtonClicked(ActionEvent actionEvent) {
            textCrypte.setText("");
            TextCrypte.textCrypte = "";
        if (textOrg.getText().equals("") || textFieldA.getText().equals("") || textFieldB.getText().equals("")) {
            textError.setText("Please fill all text fields");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info Dialog");
            alert.setHeaderText("Please fill all text fields");
            alert.show();
        } else {
            textOrgfield = textOrg.getText();
            int a = Integer.valueOf(textFieldA.getText());
            int b = Integer.valueOf(textFieldB.getText());
            textOrgfield = textOrgfield.toUpperCase();
            if (!textOrgfield.matches("[A-Za-z\\s]+")) {
                textError.setText("Entries must be letters");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Entries must be letters");
                alert.show();
            }

            if (a >= 1 && a <= 25 && b >= 0 && b <= 25 && !t.mod(a)) {
                textCrypte.setText(TextCrypte.concatinTextResult(a,b));
            } else {
                textError.setText("Check A,B values");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Values must be between :\n 1<= A <=25 AND 0<= B <=25 \n for  A it shouldn't be 1,2,13 or 26 ");
                alert.show();
            }

        }
    }

    public void resetButtonClicked(ActionEvent actionEvent) {
        textCrypte.setText("");
        textOrg.setText("");
        TextCrypte.textCrypte = "";
        textFieldA.setText("");
        textFieldB.setText("");
        textError.setText("");

    }

    public void uploadButtonClicked(ActionEvent actionEvent) throws FileNotFoundException {
        FileChooser file = new FileChooser();
        file.setTitle("Open resouece file");
        file.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text files", "*.txt")
        );
        File selectedFile = file.showOpenDialog(Main.primaryStage);
        FileReader fr = new FileReader(selectedFile);
        String str = "";
        int i;
        try {
            while ((i = fr.read()) != -1)
                str += (char) i;

           textOrg.setText(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

        @Override
    public void initialize(URL location, ResourceBundle resources) {
        TextOriginal t = new TextOriginal();
        t.remplirTab(t.alphabets);
    }
}