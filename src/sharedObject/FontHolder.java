package sharedObject;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.text.Font;

public class FontHolder {
	private static final FontHolder instance = new FontHolder();
	public Font gameFont_20,gameFont_70,gameFont_50,gameFont_40,gameFont_200;
	
	public static FontHolder getInstance() {
	    return instance;
	}
	
	public FontHolder() {
		String src ="font/monogram.ttf";
		gameFont_50 = loadFont(src,50);
		gameFont_40 = loadFont(src,40);
		gameFont_20 = loadFont(src,20);
		gameFont_70 = loadFont(src,70);
		gameFont_200 = loadFont(src,200);
	}
	
	public Font loadFont(String src,int size) {
		String res = ClassLoader.getSystemResource(src).toString();
		return Font.loadFont(res,size);
	}
	
	
}
