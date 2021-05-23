package scene;

import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneHolder {
	private Stage bindStage;
	public StartScene startScene;
	
	public SceneHolder(Stage bindStage) {
		this.bindStage = bindStage;
	}
	
	public void initialize() {
		startScene = new StartScene();
		switchScene(startScene);
		Media media = new Media(ClassLoader.getSystemResource("sound/game.mp3").toString());
		MediaPlayer mediaPlayer1 = new MediaPlayer(media);
		mediaPlayer1.setOnEndOfMedia(new Runnable() {
		       public void run() {
		    	   mediaPlayer1.seek(Duration.ZERO);
		       }
		   });
		mediaPlayer1.setVolume(0.3D);
		mediaPlayer1.play();
		
	}
	
	
	public void switchScene(Scene nextScene) {
		bindStage.setResizable(false);
		bindStage.setScene(nextScene);
		bindStage.sizeToScene();
	}
	
}
