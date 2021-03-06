/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import entitys.EntityManager;
import main.Debug;
import map.MapManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Jan
 */
public class Keyboard {
    
    public static void keyInput(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
        changeState(gc, s);
        if(gc.getInput().isKeyPressed(Input.KEY_F3)) {
            Debug.toggleDebug();
        }
        if(s.getCurrentStateID() == 1) {
            playerInput(gc, s , delta);
        }
        
        if (gc.getInput().isKeyPressed(Input.KEY_R)) {
            MapManager.reloadCurrentMap();
        }
    }
    
    private static void changeState(GameContainer gc, StateBasedGame s) {
        if (gc.getInput().isKeyPressed(Input.KEY_G) && s.getCurrentStateID() == 0) {
            gc.getInput().clearKeyPressedRecord();
            s.enterState(1);
        } else if (gc.getInput().isKeyPressed(Input.KEY_M) && s.getCurrentStateID() == 2) {
            gc.getInput().clearKeyPressedRecord();
            s.enterState(0);
        } else if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            if (s.getCurrentStateID() == 1) {
                gc.getInput().clearKeyPressedRecord();
                s.enterState(2);
            } else if (s.getCurrentStateID() == 2) {
                gc.getInput().clearKeyPressedRecord();
                s.enterState(1);
            }
        }
    }
    
    private static void playerInput(GameContainer gc, StateBasedGame s, int delta) {
        if(gc.getInput().isKeyPressed(Input.KEY_W)) {
                EntityManager.player.jump();
            }            
            if(gc.getInput().isKeyDown(Input.KEY_A) && !gc.getInput().isKeyDown(Input.KEY_D)) {
                EntityManager.player.moveSidewards(false, delta);
            }
            if(gc.getInput().isKeyDown(Input.KEY_S)) {
                
            }
            if(gc.getInput().isKeyDown(Input.KEY_D) && !gc.getInput().isKeyDown(Input.KEY_A)) {
                EntityManager.player.moveSidewards(true, delta);
            }
            if(gc.getInput().isKeyDown(Input.KEY_SPACE)) {
                
            }
            if(!gc.getInput().isKeyDown(Input.KEY_A) && !gc.getInput().isKeyDown(Input.KEY_D)) {
                EntityManager.player.slowSidewards(delta);
            }
    }
}
