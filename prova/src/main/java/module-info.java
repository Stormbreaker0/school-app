module it.unife.lp {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens it.unife.lp to javafx.fxml;
    opens it.unife.lp.controller to javafx.fxml;
    exports it.unife.lp;
}
