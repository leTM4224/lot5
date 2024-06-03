module xyz.nahidwin.lot5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens xyz.nahidwin.lot5 to javafx.fxml;
    exports xyz.nahidwin.lot5;
}