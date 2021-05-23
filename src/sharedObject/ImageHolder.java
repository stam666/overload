
package sharedObject;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public class ImageHolder {
	
	private static final ImageHolder instance = new ImageHolder();
	public Image nothing;
	public Image startBackground;
	public Image endBackground;
	public Image gameBackground;
	public List<Image> darkBluePole1D;
	public List<Image> lightBluePole1D;
	public List<Image> darkGreenPole1D;
	public List<Image> lightGreenPole1D;
	public List<Image> darkRedPole1D;
	public List<Image> lightRedPole1D;
	public List<Image> darkYellowPole1D;
	public List<Image> lightYellowPole1D;
	public Image darkBluePole;
	public Image lightBluePole;
	public Image darkGreenPole;
	public Image lightGreenPole;
	public Image darkRedPole;
	public Image lightRedPole;
	public Image darkYellowPole;
	public Image lightYellowPole;
	
	public Image ring;
	public Image frontRing;
	public Image rearRing;
	public Image frontGoldRing;
	public Image rearGoldRing;
	public Image tile;
	
	public static ImageHolder getInstance() {
	    return instance;
	}
	
	public ImageHolder() {
		
		nothing = loadImage("nothing/nothing", "png");
		startBackground=loadImage("background/start", "jpg");
		endBackground=loadImage("background/end", "jpg");
		gameBackground=loadImage("background/bg", "jpg");
		darkBluePole1D = loadImageList("pole/1D/blue/dark/", "png", 8);
		lightBluePole1D = loadImageList("pole/1D/blue/light/", "png", 8);
		darkGreenPole1D = loadImageList("pole/1D/green/dark/", "png", 8);
		lightGreenPole1D = loadImageList("pole/1D/green/light/", "png", 8);
		darkRedPole1D = loadImageList("pole/1D/red/dark/", "png", 8);
		lightRedPole1D = loadImageList("pole/1D/red/light/", "png", 8);
		darkYellowPole1D = loadImageList("pole/1D/yellow/dark/", "png", 8);
		lightYellowPole1D = loadImageList("pole/1D/yellow/light/", "png", 8);
		
		darkBluePole = loadImage("pole/3D/dark/blue", "png");
		lightBluePole = loadImage("pole/3D/light/blue", "png");
		darkGreenPole = loadImage("pole/3D/dark/green", "png");
		lightGreenPole = loadImage("pole/3D/light/green", "png");
		darkRedPole = loadImage("pole/3D/dark/red", "png");
		lightRedPole = loadImage("pole/3D/light/red", "png");
		darkYellowPole = loadImage("pole/3D/dark/yellow", "png");
		lightYellowPole = loadImage("pole/3D/light/yellow", "png");
		
		ring = loadImage("ring/ring", "png");
		frontRing = loadImage("ring/frontRing", "png");
		rearRing = loadImage("ring/rearRing", "png");   
		frontGoldRing = loadImage("ring/frontGoldRing", "png");
		rearGoldRing = loadImage("ring/rearGoldRing", "png");
		
		tile = loadImage("board/tile", "png");
		
	}
	
	public Image loadImage(String prefix, String fileFormat) {
		//System.out.println(prefix + "." + fileFormat);
		return new Image(ClassLoader.getSystemResource(prefix + "." + fileFormat).toString());
	}
	
	public List<Image> loadImageList(String prefix, String fileFormat, int n) {
		List<Image> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(loadImage(prefix + i, fileFormat));
		}
		return list;
	}
	
}
