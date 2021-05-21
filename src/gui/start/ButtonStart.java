package gui.start;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.Main;
import scene.GameScene;
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
		this.getStylesheets().add(ClassLoader.getSystemResource("styleSheet.css").toString());
		playButton=new Button("Play");
		playButton.setPrefSize(150, 80);
		playButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				Main.sceneHolder.switchScene((Scene)new GameScene());
			}
		});
		
		
		
		playButton.setFont(FontHolder.getInstance().gameFont_50);
		
		
		exitButton=new Button("Exit");
		exitButton.setFont(FontHolder.getInstance().gameFont_50);
		exitButton.setPrefSize(150, 80);
		exitButton.setOnMouseClicked(e -> System.exit(0));
		this.getChildren().addAll(playButton,exitButton);
	}
}
