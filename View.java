/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File; 
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JPanel {

	private final int frameWidth = 500;
	private final int frameHeight = 300;
	private final int imgWidth = 165;
	private final int imgHeight = 165;

	private int xloc = 0;
	private int yloc = 0;
	private int direction = 0;

	private int[] frameCounts = new int[8];
	private int picNum = 0;
	BufferedImage[][] pics;

	private JFrame frame = null;
	private boolean initFrame = false;

	public View() {

		pics = new BufferedImage[8][];
		BufferedImage img0 = createImage(0);
		frameCounts[0] = img0.getWidth() / imgWidth;
		BufferedImage[] pics0 = new BufferedImage[frameCounts[0]];
		for (int i = 0; i < frameCounts[0]; i++) {
			pics0[i] = img0.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
		}
		pics[0] = pics0;
		
		BufferedImage img1 = createImage(1);
		frameCounts[1] = img1.getWidth() / imgWidth;
		BufferedImage[] pics1 = new BufferedImage[frameCounts[1]];
		for (int i = 0; i < frameCounts[1]; i++) {
			pics1[i] = img1.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
		}
		pics[1] = pics1;
		
		BufferedImage img2 = createImage(2);
		frameCounts[2] = img2.getWidth() / imgWidth;
		BufferedImage[] pics2 = new BufferedImage[frameCounts[2]];
		for (int i = 0; i < frameCounts[2]; i++) {
			pics2[i] = img2.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
		}
		pics[2] = pics2;
		
		BufferedImage img3 = createImage(3);
		frameCounts[3] = img3.getWidth() / imgWidth;
		BufferedImage[] pics3 = new BufferedImage[frameCounts[3]];
		for (int i = 0; i < frameCounts[3]; i++) {
			pics3[i] = img3.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
		}
		pics[3] = pics3;
		
		BufferedImage img4 = createImage(4);
		frameCounts[4] = img4.getWidth() / imgWidth;
		BufferedImage[] pics4 = new BufferedImage[frameCounts[4]];
		for (int i = 0; i < frameCounts[4]; i++) {
			pics4[i] = img4.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
		}
		pics[4] = pics4;
		
		BufferedImage img5 = createImage(5);
		frameCounts[5] = img5.getWidth() / imgWidth;
		BufferedImage[] pics5 = new BufferedImage[frameCounts[5]];
		for (int i = 0; i < frameCounts[5]; i++) {
			pics5[i] = img5.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
		}
		pics[5] = pics5;
		
		BufferedImage img6 = createImage(6);
		frameCounts[6] = img6.getWidth() / imgWidth;
		BufferedImage[] pics6 = new BufferedImage[frameCounts[6]];
		for (int i = 0; i < frameCounts[6]; i++) {
			pics6[i] = img6.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
		}
		pics[6] = pics6;
		
		BufferedImage img7 = createImage(7);
		frameCounts[7] = img7.getWidth() / imgWidth;
		BufferedImage[] pics7 = new BufferedImage[frameCounts[7]];
		for (int i = 0; i < frameCounts[7]; i++) {
			pics7[i] = img7.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
		}
		pics[7] = pics7;

	}

	private BufferedImage createImage(int img) {
		BufferedImage bufferedImage = null;
		try {
			if (img == 0)
				bufferedImage = ImageIO.read(new File("images/orc/orc_forward_southeast.png"));
			if (img == 1)
				bufferedImage = ImageIO.read(new File("images/orc/orc_forward_southwest.png"));
			if (img == 2)
				bufferedImage = ImageIO.read(new File("images/orc/orc_forward_northwest.png"));
			if (img == 3)
				bufferedImage = ImageIO.read(new File("images/orc/orc_forward_northeast.png"));
			if (img == 4)
				bufferedImage = ImageIO.read(new File("images/orc/orc_jump_southeast.png"));
			if (img == 5)
				bufferedImage = ImageIO.read(new File("images/orc/orc_jump_southwest.png"));
			if (img == 6)
				bufferedImage = ImageIO.read(new File("images/orc/orc_jump_northwest.png"));
			if (img == 7)
				bufferedImage = ImageIO.read(new File("images/orc/orc_jump_northeast.png"));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getWidth() {
		return frameWidth;
	}

	public int getHeight() {
		return frameHeight;
	}

	public int getImageWidth() {
		return imgWidth;
	}

	public int getImageHeight() {
		return imgHeight;
	}

	public void update(int newX, int newY, int newDir) {
		if (!initFrame) {
			frame = new JFrame();
			frame.getContentPane().add(this);
			frame.setBackground(Color.gray);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(frameWidth, frameHeight);
			frame.setVisible(true);
			initFrame = true;
		}
		xloc = newX;
		yloc = newY;
		direction = newDir;	
		frame.repaint();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void paint(Graphics g) {
		picNum = (picNum + 1) % frameCounts[direction % 8];
		g.drawImage(pics[direction % 8][picNum], xloc, yloc, Color.gray, this);
	}	

}
