package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for(int i = 0; i < 8; i++){
            sprite.add(new Image(new FileInputStream("src/Assets/Running"+i+".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        int newX = 0;
        int imageNum = 1;
        while (true) {
            try {
                super.setX(newX+=10);
                super.setImage(sprite.get(imageNum++));
                Thread.sleep(50);
//                super.setX(newX++);
//                Thread.sleep(500);
//                super.setX(300);
//                Thread.sleep(500); //800
//                super.setX(400);
                if(newX>800){
                    newX=0;
                }
                if(imageNum==7){
                    imageNum=0;
                }
            } 
            catch (InterruptedException ex) {}
        }
    }
}
