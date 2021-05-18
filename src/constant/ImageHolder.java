
package constant;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ImageHolder {
	public static Image[][] Pole1D= new Image[5][9];
	public static final String[] Pole1DColor= new String[] {"blue","green","pink","red","yellow"};
	
	public static void LoadImage() {
		for(int j=0;j<=4;j++) {
			for(int i=0;i<=8;i++) {
				String numberOfRing = String.valueOf(i);
				String img_path=ClassLoader.getSystemResource("pole/1D/"+Pole1DColor[j]+numberOfRing+".png").toString();
				Pole1D[j][i]=new Image(img_path);
			}
		}
		
	}
	
}
