package xyz.nahidwin.lot5.controler;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class HelloController {
    @FXML private ImageView img;

    @FXML
    protected void pressed() {
        img.setVisible(true);
    }
}