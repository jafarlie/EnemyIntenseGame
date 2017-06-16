package game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> obj = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i =0; i< obj.size();i++){
			GameObject tempObject = obj.get(i);
			
			tempObject.tick();
		}
		
	}
	
	public void render(Graphics g){
		for(int i =0; i< obj.size();i++){
			GameObject tempObject = obj.get(i);
			tempObject.render(g);
		}
		
	}
	
	public void clearEnemys(){
		for(int i =0; i< obj.size();i++){
			GameObject tempObject = obj.get(i);
			if(tempObject.getId() != ID.Player){
				removeObject(tempObject);
			}
			//removeObject(tempObject);
		}
	}
	
	public void addObject(GameObject obj){
		this.obj.add(obj);
		
	}
	
	public void removeObject(GameObject object){
		this.obj.remove(object);
	}
	public boolean isClear(){
		if(this.obj.size() == 0){
			return true;
		}
		return false;
	}

}
