package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {
     
    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for(int i = 0; i < 3; i++){
            sprite.add(new Image(new FileInputStream("src/Assets/Jumping"+i+".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        int newY = 270;
        boolean up = true;
        int imageNum = 2;
        while (true) {
            try {
                super.setImage(sprite.get(imageNum));
                if(up){
                   this.setY(newY+=5);
                }else{
                   this.setY(newY-=5);
                }
                
                Thread.sleep(60);
                if(newY==370){
                    up = false;
                    imageNum=0;
                }else if(newY==170){
                    up = true;
                    imageNum=1;
                }
            } 
            catch (InterruptedException ex) {} 
        }
    }
}
