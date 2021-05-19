package actionPane;

import input.InputUtility;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
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
			
			chooseZeroButton = new Button("Zero");
			chooseZeroButton.setOnAction((ActionEvent event) -> {
				InputUtility.setChoosePoleZero(true);
			});
			chooseZeroButton.setPrefSize(256, 200);
			this.getChildren().add(chooseZeroButton);
			//////////////////////////////////////////////////////////////////////
			chooseOneButton = new Button("One");
			chooseOneButton.setOnAction((ActionEvent event) -> {
				InputUtility.setChoosePoleOne(true);
			});
			chooseOneButton.setPrefSize(256, 200);
			this.getChildren().add(chooseOneButton);
			
			
		}
		

}
