package sharedObject;

import javafx.scene.media.AudioClip;

public class AudioHolder {
	private static final AudioHolder instance = new AudioHolder();
	public static AudioClip Almost_Time_Up;
	public static AudioClip buttonPressed;
	public static AudioHolder getInstance() {
	    return instance;
	}
	private AudioHolder() {
		//Almost_Time_Up = new AudioClip(ClassLoader.getSystemResource("sound/almostTimeUp.wav").toString());
		buttonPressed = new AudioClip(ClassLoader.getSystemResource("sound/effectButtonPressed.mp3").toString());
	}
}
