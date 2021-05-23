package sharedObject;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class AudioHolder {
	private static final AudioHolder instance = new AudioHolder();
	//public static AudioClip Almost_Time_Up;
	public AudioClip buttonPressed,gameSound;
	public static  AudioHolder getInstance() {
	    return instance;
	}
	public AudioHolder() {
		//Almost_Time_Up = new AudioClip(ClassLoader.getSystemResource("sound/almostTimeUp.wav").toString());
		buttonPressed = new AudioClip(ClassLoader.getSystemResource("effectButtonPressed.mp3").toString());
		gameSound = new AudioClip(ClassLoader.getSystemResource("sound/game.mp3").toString());
		
	}
	public void playPressed() {
		 buttonPressed.setCycleCount(1);
		 buttonPressed.setVolume(0.7D);
		 buttonPressed.play();
	}
	public void playGameSound() {
		gameSound.setCycleCount(AudioClip.INDEFINITE);
		gameSound.setVolume(0.3D);
		gameSound.play();
	}
}
