
package sharedObject;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public class ImageHolder {
	
	private static final ImageHolder instance = new ImageHolder();
	public Image nothing;
	public Image startBackground;
	public List<Image> bluePole1D;
	public List<Image> greenPole1D;
	public List<Image> pinkPole1D;
	public List<Image> redPole1D;
	public List<Image> yellowPole1D;
	public Image bluePole;
	public Image greenPole;
	public Image pinkPole;
	public Image redPole;
	public Image yellowPole;
	public List<Image> ring;
	public Image tile;
	
	public static ImageHolder getInstance() {
	    return instance;
	}
	
	public ImageHolder() {
		
		nothing = loadImage("nothing/nothing", "png");
		startBackground=loadImage("background/start", "jpg");
		bluePole1D = loadImageList("pole/1D/blue/blue_", "png", 8);
		greenPole1D = loadImageList("pole/1D/green/green_", "png", 8);
		pinkPole1D = loadImageList("pole/1D/pink/pink_", "png", 8);
		redPole1D = loadImageList("pole/1D/red/red_", "png", 8);
		yellowPole1D = loadImageList("pole/1D/yellow/yellow_", "png", 8);
		
		bluePole = loadImage("pole/3D/blue", "png");
		greenPole = loadImage("pole/3D/green", "png");
		pinkPole = loadImage("pole/3D/pink", "png");
		redPole = loadImage("pole/3D/red", "png");
		yellowPole = loadImage("pole/3D/yellow", "png");
		
		ring = loadImageList("ring/ring_", "png", 2);
		
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
	
//	public static Image[][] Pole1D= new Image[5][9];
//	public static final String[] Pole1DColor= new String[] {"blue","green","pink","red","yellow"};
//	
//	public static void loadImage() {
//		for(int j=0;j<=4;j++) {
//			for(int i=0;i<=8;i++) {
//				String numberOfRing = String.valueOf(i);
//				String img_path=ClassLoader.getSystemResource("pole/1D/"+Pole1DColor[j]+numberOfRing+".png").toString();
//				Pole1D[j][i]=new Image(img_path);
//			}
//		}
//		
//	}
	
}
