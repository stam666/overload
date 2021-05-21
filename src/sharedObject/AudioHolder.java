package sharedObject;

import javafx.scene.media.AudioClip;

public class AudioHolder {
	private static final AudioHolder instance = new AudioHolder();
	//public static AudioClip Almost_Time_Up;
	public AudioClip buttonPressed;
	public static  AudioHolder getInstance() {
	    return instance;
	}
	public AudioHolder() {
		//Almost_Time_Up = new AudioClip(ClassLoader.getSystemResource("sound/almostTimeUp.wav").toString());
		buttonPressed = new AudioClip(ClassLoader.getSystemResource("effectButtonPressed.mp3").toString());
	}
	public void playPressed() {
		 buttonPressed.setCycleCount(1);
		 buttonPressed.setVolume(0.3D);
		 buttonPressed.play();
	}
}
