package gui.start;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sharedObject.FontHolder;

public class ButtonStart extends HBox{
	Button playButton,exitButton;
	public ButtonStart() {
		this.setAlignment(Pos.CENTER);
		int width=1024,height=368;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		this.setSpacing(30);
		playButton=new Button("Play");
		playButton.setFont(FontHolder.getInstance().gameFont_50);
	
		exitButton=new Button("Exit");
		exitButton.setFont(FontHolder.getInstance().gameFont_50);
		exitButton.setOnMouseClicked(e -> System.exit(0));
		this.getChildren().addAll(playButton,exitButton);
	}
}
