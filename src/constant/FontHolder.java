package constant;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.text.Font;

public class FontHolder {
	private static final FontHolder instance = new FontHolder();
	public Font gameFont_50,gameFont_40;
	
	public static FontHolder getInstance() {
	    return instance;
	}
	
	public FontHolder() {
		String src ="font/monogram.ttf";
		gameFont_50 = loadFont(src,50);
		gameFont_40 = loadFont(src,40);
	}
	
	public Font loadFont(String src,int size) {
		String res = ClassLoader.getSystemResource(src).toString();
		return Font.loadFont(res,size);
	}
	
	
}
