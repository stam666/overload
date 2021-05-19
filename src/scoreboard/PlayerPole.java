package scoreboard;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import player.Player;
import sharedObject.ImageHolder;

public class PlayerPole extends Pane{
	public PlayerPole(int idx,Player player) {
		Canvas canvas = new Canvas(200,130);
		GraphicsContext gc= canvas.getGraphicsContext2D();
		//String img_path=ClassLoader.getSystemResource("pole/1D/blue/dark/1.png").toString();
		if(idx==0) {
			draw(gc,ImageHolder.getInstance().bluePole1D.get(player.getSub().get(0).getCounter()),6,0);
			draw(gc,ImageHolder.getInstance().bluePole1D.get(player.getSub().get(1).getCounter()),102,0);
		}else if(idx==1) {
			draw(gc,ImageHolder.getInstance().greenPole1D.get(player.getSub().get(0).getCounter()),6,0);
			draw(gc,ImageHolder.getInstance().greenPole1D.get(player.getSub().get(1).getCounter()),102,0);
		}else if(idx==2) {
			draw(gc,ImageHolder.getInstance().pinkPole1D.get(player.getSub().get(0).getCounter()),6,0);
			draw(gc,ImageHolder.getInstance().pinkPole1D.get(player.getSub().get(1).getCounter()),102,0);
		}
		else if(idx==3) {
			draw(gc,ImageHolder.getInstance().redPole1D.get(player.getSub().get(0).getCounter()),6,0);
			draw(gc,ImageHolder.getInstance().redPole1D.get(player.getSub().get(1).getCounter()),102,0);
		}
		else if(idx==4) {
			draw(gc,ImageHolder.getInstance().yellowPole1D.get(player.getSub().get(0).getCounter()),6,0);
			draw(gc,ImageHolder.getInstance().yellowPole1D.get(player.getSub().get(1).getCounter()),102,0);
		}


		this.getChildren().add(canvas);
		
	}
	private void draw(GraphicsContext gc,Image img,int x,int y) {
		gc.drawImage(img, x, y,90,130);
	}
}
