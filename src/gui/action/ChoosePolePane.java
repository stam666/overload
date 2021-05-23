package gui.action;

import input.InputUtility;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import main.GameLogic;
import sharedObject.AudioHolder;
import javafx.event.ActionEvent;

public class ChoosePolePane extends HBox {

	private Button chooseZeroButton;
	private Button chooseOneButton;

	public ChoosePolePane() {
		this.setAlignment(Pos.CENTER);
		int width = 1024, height = 180;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		this.setSpacing(25);

		chooseZeroButton = new Button();
		Image img0 = GameLogic.getPlayer().getSub().get(0).get1D();
		ImageView view0 = new ImageView(img0);
		view0.setFitHeight(140);
		view0.setFitWidth(97);
		chooseZeroButton.setGraphic(view0);
		chooseZeroButton.setOnAction((ActionEvent event) -> {
			AudioHolder.getInstance().playPressed();
			InputUtility.setChoosePoleZero(true);
		});
		chooseZeroButton.setPrefSize(256, 160);
		this.getChildren().add(chooseZeroButton);
		//////////////////////////////////////////////////////////////////////
		chooseOneButton = new Button();
		Image img1 = GameLogic.getPlayer().getSub().get(1).get1D();
		ImageView view1 = new ImageView(img1);
		view1.setFitHeight(140);
		view1.setFitWidth(97);
		chooseOneButton.setGraphic(view1);
		chooseOneButton.setOnAction((ActionEvent event) -> {
			AudioHolder.getInstance().playPressed();
			InputUtility.setChoosePoleOne(true);
		});
		chooseOneButton.setPrefSize(256, 160);
		this.getChildren().add(chooseOneButton);

	}

}
