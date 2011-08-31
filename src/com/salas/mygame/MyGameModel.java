package com.salas.mygame;

import javax.microedition.khronos.opengles.GL10;

import com.salas.miniengine.GEModel;
import com.salas.miniengine.GEModelSprite;

public class MyGameModel extends GEModel {
	private int pulseCounter;

	MyGameModel() {
		super();
		pulseCounter = 0;
		float[] mat;
		for (int z = 0; z < 3; z++) {
			for (int x = 0; x < 10; x++) {
				if ( z == 0) {
					mat = new float[] {x/3.0f, 0, 0, 1};					
				} else if (z == 1) {
					mat = new float[] {0, x/3.0f, 0, 1};										
				} else {
					mat = new float[] {0, 0, x/3.0f, 1};					
				}
				sprites.add(new GEModelSprite(x*2.0f, 0, z*2, mat));
			}
		}
		GEModelSprite extra = new GEModelSprite(0.0f, 10.0f, 0, matWhite);
		extra.animateRotate(true);
		sprites.add(extra);
	}

	public void render(GL10 gl) {
		int counter = 0;
	    for (GEModelSprite asprite : sprites) {
	    	if (counter == pulseCounter) {
	    		asprite.move(0, 3, 0);
	    	}
	    	asprite.render(gl);
	    	if (counter == pulseCounter) {
	    		asprite.move(0, -3, 0);
	    	}
	    	counter++;
	    }
	}
	
	public void pulse() {
		pulseCounter++;
		if (pulseCounter == 30) pulseCounter = 0;
	}
}