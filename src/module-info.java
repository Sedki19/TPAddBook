module TpAddBook {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	
	opens application to javafx.base,javafx.graphics, javafx.fxml;
}
