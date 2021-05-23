package gui.end;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import main.Main;
import scene.GameScene;
import sharedObject.AudioHolder;
import sharedObject.FontHolder;

public class ButtonEnd extends HBox {
	private Button exitButton;
	public ButtonEnd() {
		this.setAlignment(Pos.CENTER);
		int width = 1024, height = 168;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		this.setSpacing(30);
		this.getStylesheets().add(ClassLoader.getSystemResource("styleSheet.css").toString());
		exitButton = new Button("Exit");
		exitButton.setId("endBtn");
		exitButton.setFont(FontHolder.getInstance().gameFont_40);
		exitButton.setPrefSize(180, 50);
		exitButton.setOnMouseClicked(e -> System.exit(0));
		this.getChildren().addAll( exitButton);
	}
}
