import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheetLoader {

    private BufferedImage spriteImg;
    private BufferedImage[] spriteSheet;
    private int width, height, rows, columns;
    
    public SpriteSheetLoader(String f, int w, int h, int r, int c) {
        width = w;
        height = h;
        rows = r;
        columns = c;
        
        spriteSheet = new BufferedImage[rows * columns];

        try {
            spriteImg = ImageIO.read(new File(f));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for(int i = 0; i < rows; i++){
    		for(int j = 0; j < columns; j++){
    			spriteSheet[(i * columns) + j] = spriteImg.getSubimage(i * width, j * height, width, height);
    		}
    	}
        
    }
    public BufferedImage getSprite(int i) {
        return spriteSheet[i];
    }

}