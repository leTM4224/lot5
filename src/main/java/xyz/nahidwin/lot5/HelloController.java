package xyz.nahidwin.lot5;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class HelloController {
    @FXML private Button btn;
    @FXML private ImageView img;

    @FXML
    protected void pressed() {
        img.setVisible(true);
    }
}