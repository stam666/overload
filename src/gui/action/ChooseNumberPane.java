package gui.action;

import java.util.ArrayList;

import input.InputUtility;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import sharedObject.FontHolder;

public class ChooseNumberPane extends HBox {
	ArrayList<Button> numberButton;
	
	public ChooseNumberPane() {
		numberButton = new ArrayList<Button>();
		this.setAlignment(Pos.CENTER);
		int width = 1024, height = 200;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		this.setSpacing(15);
		
		for (int i = 0; i <= 8; i++) {
			Button b = new Button(String.valueOf(i));
			b.setFont(FontHolder.getInstance().gameFont_40);
			b.setPrefSize(90, 90);
			numberButton.add(b);
			this.getChildren().add(b);
		}
		numberButton.get(0).setOnAction((ActionEvent event) -> {
			InputUtility.setNumberOfRings(0);
		});
		numberButton.get(1).setOnAction((ActionEvent event) -> {
			InputUtility.setNumberOfRings(1);
		});
		numberButton.get(2).setOnAction((ActionEvent event) -> {
			InputUtility.setNumberOfRings(2);
		});
		numberButton.get(3).setOnAction((ActionEvent event) -> {
			InputUtility.setNumberOfRings(3);
		});
		numberButton.get(4).setOnAction((ActionEvent event) -> {
			InputUtility.setNumberOfRings(4);
		});
		numberButton.get(5).setOnAction((ActionEvent event) -> {
			InputUtility.setNumberOfRings(5);
		});
		numberButton.get(6).setOnAction((ActionEvent event) -> {
			InputUtility.setNumberOfRings(6);
		});
		numberButton.get(7).setOnAction((ActionEvent event) -> {
			InputUtility.setNumberOfRings(7);
		});
		numberButton.get(8).setOnAction((ActionEvent event) -> {
			InputUtility.setNumberOfRings(8);
		});

	}
}
