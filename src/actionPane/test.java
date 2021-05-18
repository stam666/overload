package actionPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import player.SubPlayer;

public class test extends Application {
	public void start(Stage primaryStage) {
		// TODO
		SubPlayer s= new SubPlayer();
		//VBox root = new PlayerAtSameActionPane(2,s,true);
		HBox root1 = new HBox();
		ChoosePolePane root2 = new ChoosePolePane();
		ChooseNumberPane root3 = new ChooseNumberPane();
		root1.setAlignment(Pos.CENTER);
		root1.setSpacing(20);
		int width=1024,height=256;
		root1.setMinWidth(width);
		root1.setMaxWidth(height);
		root1.setMinHeight(height);
		root1.setMaxHeight(height);
		for(int i=0;i<7;i++) {
			VBox r = new PlayerAtSameActionPane(2,s,true);
			root1.getChildren().add(r);
		}
		Button enterButton =new Button("Enter");
		enterButton.setPrefSize(100,151);
		root1.getChildren().add(enterButton);
		Scene scene = new Scene(root3);
		primaryStage.setScene(scene);
		primaryStage.setMaxWidth(1024);
		primaryStage.setMinWidth(1024);
		primaryStage.setMaxHeight(256);
		primaryStage.setMinHeight(256);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
