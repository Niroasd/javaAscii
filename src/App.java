import java.util.*;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URISyntaxException;

public class App {

    final static String imagePath = "/Q:/javaAscii/src/images/mooc.png";

    public static void main(String[] args) throws Exception {
        System.out.println(imagePath);
        returnPath();
        readImage(imagePath);
        System.out.println("out");

    }

    public static void returnPath() {
        String filepath = App.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println("The file location being executed is: " + filepath);
    }

    public static int[][] readImage(String imagePath) {
        try {
            BufferedImage image = null;
            int width = 48;
            int height = 48;
            File imageFile = new File(imagePath);

            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            image = ImageIO.read(imageFile);

            if (image == null) {
                throw new IOException("Failed to read image file: " + imagePath);
            }

            int[][] pixels = new int[width][height];

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    pixels[i][j] = image.getRGB(i, j);
                    System.out.println(image.getRGB(i, j));
                }
            }
            return pixels;

        } catch (IOException e) {
            System.err.println("Failed to read image file: " + imagePath + " - " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
