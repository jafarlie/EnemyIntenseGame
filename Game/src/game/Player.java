package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	
	Random r = new Random();
	Handler handler;

	public Player(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,32,32);
	}


	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp((int)x, 0, Game.WIDTH - 37);
		y = Game.clamp((int)y, 0, Game.HEIGHT - 60);
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.BLUE, 32, 32, 0.05f,handler));
		
		collision();

	}
	
	private void collision(){
		for(int i=0;i < handler.obj.size();i++){
			
			GameObject tempObject = handler.obj.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy   ){
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -=2;
				}
			}
			
		}
	}
	
	


	public void render(Graphics g) {
		
		g.setColor(Color.BLUE);
		g.fillRect((int)x, (int)y, 32, 32);
	
	}

}
