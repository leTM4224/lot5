module xyz.nahidwin.lot5 {
    requires javafx.controls;
    requires javafx.fxml;


    exports xyz.nahidwin.lot5.view;
    opens xyz.nahidwin.lot5.view to javafx.fxml;
    exports xyz.nahidwin.lot5.controler;
    opens xyz.nahidwin.lot5.controler to javafx.fxml;
    exports xyz.nahidwin.lot5.model;
    opens xyz.nahidwin.lot5.model to javafx.fxml;
}