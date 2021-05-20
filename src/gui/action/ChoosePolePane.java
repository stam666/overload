package gui.action;

import input.InputUtility;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import main.GameLogic;
import main.logic;
import javafx.event.ActionEvent;

public class ChoosePolePane extends HBox{
	

		private Button chooseZeroButton;
		private Button chooseOneButton;
		public ChoosePolePane() {
			this.setAlignment(Pos.CENTER);
			int width=1024,height=200;
			this.setMinWidth(width);
			this.setMaxWidth(height);
			this.setMinHeight(height);
			this.setMaxHeight(height);
			this.setSpacing(25);
			
			chooseZeroButton = new Button();
			Image img0 =GameLogic.getPlayer().getSub().get(0).get1D();
		    ImageView view0 = new ImageView(img0);
		    view0.setFitHeight(180);
		    view0.setFitWidth(124);
		    chooseZeroButton.setGraphic(view0);
			chooseZeroButton.setOnAction((ActionEvent event) -> {
				InputUtility.setChoosePoleZero(true);
			});
			chooseZeroButton.setPrefSize(256, 200);
			this.getChildren().add(chooseZeroButton);
			//////////////////////////////////////////////////////////////////////
			chooseOneButton = new Button();
			Image img1 =GameLogic.getPlayer().getSub().get(1).get1D();
		    ImageView view1 = new ImageView(img1);
		    view1.setFitHeight(180);
		    view1.setFitWidth(124);
		    chooseOneButton.setGraphic(view1);
			chooseOneButton.setOnAction((ActionEvent event) -> {
				InputUtility.setChoosePoleOne(true);
			});
			chooseOneButton.setPrefSize(256, 200);
			this.getChildren().add(chooseOneButton);
			
			
		}
		

}
