package sharedObject;

import javafx.scene.media.AudioClip;

public class AudioHolder {
	private static final AudioHolder instance = new AudioHolder();
	public AudioClip buttonPressed, gameSound;

	public static AudioHolder getInstance() {
		return instance;
	}

	public AudioHolder() {
		buttonPressed = new AudioClip(ClassLoader.getSystemResource("sound/effectButtonPressed.mp3").toString());
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
