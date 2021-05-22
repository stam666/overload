package gui.score;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import main.GameLogic;
import player.Player;
import sharedObject.ImageHolder;

public class PlayerPole extends Pane{
	private int idx;
	private Player player;
	public PlayerPole(int idx,Player player) {
		this.idx=idx;this.player=player;
		Canvas canvas = new Canvas(200,130);
		GraphicsContext gc= canvas.getGraphicsContext2D();
		//String img_path=ClassLoader.getSystemResource("pole/1D/blue/dark/1.png").toString();
		if(GameLogic.getNowState()>=3 && GameLogic.getPlayer().getName().equals(player.getName())) {
			gc.setFill(Color.GOLD);
			if(GameLogic.getNowSubPlayer().getIdx()==0) {
				gc.fillRoundRect(6, 0, 90, 130,15,15);
			}else if(GameLogic.getNowSubPlayer().getIdx()==1) {
				gc.fillRect(102, 0, 90, 130);
			}
		}
		draw(gc,player.getSub().get(0).get1D(),6,0);
		draw(gc,player.getSub().get(1).get1D(),102,0);
		/*if(idx==0) {
			draw(gc,ImageHolder.getInstance().darkBluePole1D.get(player.getSub().get(0).getRings()),6,0);
			draw(gc,ImageHolder.getInstance().lightBluePole1D.get(player.getSub().get(1).getRings()),102,0);
		}else if(idx==1) {
			draw(gc,ImageHolder.getInstance().darkGreenPole1D.get(player.getSub().get(0).getRings()),6,0);
			draw(gc,ImageHolder.getInstance().lightGreenPole1D.get(player.getSub().get(1).getRings()),102,0);
		}else if(idx==2) {
			draw(gc,ImageHolder.getInstance().darkPinkPole1D.get(player.getSub().get(0).getRings()),6,0);
			draw(gc,ImageHolder.getInstance().lightPinkPole1D.get(player.getSub().get(1).getRings()),102,0);
		}
		else if(idx==3) {
			draw(gc,ImageHolder.getInstance().darkRedPole1D.get(player.getSub().get(0).getRings()),6,0);
			draw(gc,ImageHolder.getInstance().lightRedPole1D.get(player.getSub().get(1).getRings()),102,0);
		}
		else if(idx==4) {
			draw(gc,ImageHolder.getInstance().darkYellowPole1D.get(player.getSub().get(0).getRings()),6,0);
			draw(gc,ImageHolder.getInstance().lightYellowPole1D.get(player.getSub().get(1).getRings()),102,0);
		}*/


		this.getChildren().add(canvas);
		
	}
	private void draw(GraphicsContext gc,Image img,int x,int y) {
		gc.drawImage(img, x, y,90,130);
	}
	public void update() {
		this.getChildren().clear();
		Canvas canvas = new Canvas(200,130);
		GraphicsContext gc= canvas.getGraphicsContext2D();
		if(GameLogic.getNowState()>=3 && GameLogic.getPlayer().getName().equals(player.getName())) {
			gc.setFill(Color.GOLD);
			if(GameLogic.getNowSubPlayer().getIdx()==0) {
				gc.fillRoundRect(6, 0, 90, 130,15,15);
			}else if(GameLogic.getNowSubPlayer().getIdx()==1) {
				gc.fillRect(102, 0, 90, 130);
			}
		}
		draw(gc,player.getSub().get(0).get1D(),6,0);
		draw(gc,player.getSub().get(1).get1D(),102,0);
		this.getChildren().add(canvas);
	}
}
