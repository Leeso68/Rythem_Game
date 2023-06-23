package dynamic_beat_15;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import dynamic_beat_16.Beat;
import dynamic_beat_3.Main;

public class Game extends Thread {

	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteline.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameinfo.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;

	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (!note.isProceeded()) {
				noteList.remove(i);
				i--;
			} else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.BLUE);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Arial Black", Font.BOLD, 30));
		g.drawString("000000", 580, 702);
	}

	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
		new Music("SL.mp3", false).start();
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
		new Music("SL.mp3", false).start();
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
		new Music("SL.mp3", false).start();
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
		new Music("Space.mp3", false).start();
	}

	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
		new Music("SL.mp3", false).start();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
		new Music("SL.mp3", false).start();
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
		new Music("SL.mp3", false).start();
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}

	@Override
	public void run() {
		dropNotes(this.titleName);
	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if (titleName.equals("Fablik - Say My Name") && difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime, "Space"), new Beat(startTime + gap * 21, "Space"),
					new Beat(startTime + gap * 26, "S"), new Beat(startTime + gap * 27, "D"),
					new Beat(startTime + gap * 31, "Space"), new Beat(startTime + gap * 33, "J"),
					new Beat(startTime + gap * 38, "K"), new Beat(startTime + gap * 43, "K"),
					new Beat(startTime + gap * 47, "K"), new Beat(startTime + gap * 51, "L"),
					new Beat(startTime + gap * 56, "J"), new Beat(startTime + gap * 61, "L"),
					new Beat(startTime + gap * 66, "J"), new Beat(startTime + gap * 71, "L"),
					new Beat(startTime + gap * 76, "J"), new Beat(startTime + gap * 81, "L"),
					new Beat(startTime + gap * 86, "J"), new Beat(startTime + gap * 91, "L"),
					new Beat(startTime + gap * 95, "K"), new Beat(startTime + gap * 104, "S"),
					new Beat(startTime + gap * 105, "F"), new Beat(startTime + gap * 107, "D"),
					new Beat(startTime + gap * 109, "Space"), new Beat(startTime + gap * 117, "D"),
					new Beat(startTime + gap * 120, "J"), new Beat(startTime + gap * 125, "L"),
					new Beat(startTime + gap * 131, "J"), new Beat(startTime + gap * 136, "L"),
					new Beat(startTime + gap * 141, "J"), new Beat(startTime + gap * 146, "L"),
					new Beat(startTime + gap * 151, "K"), new Beat(startTime + gap * 156, "K"),
					new Beat(startTime + gap * 161, "J"), new Beat(startTime + gap * 172, "L"),
					new Beat(startTime + gap * 177, "Space"), new Beat(startTime + gap * 179, "L"),
					new Beat(startTime + gap * 184, "S"), new Beat(startTime + gap * 189, "L"),
					new Beat(startTime + gap * 194, "S"), new Beat(startTime + gap * 199, "L"),
					new Beat(startTime + gap * 204, "S"), new Beat(startTime + gap * 209, "L"),
					new Beat(startTime + gap * 214, "S"), new Beat(startTime + gap * 219, "F"),
					new Beat(startTime + gap * 224, "F"), new Beat(startTime + gap * 229, "J"),
					new Beat(startTime + gap * 234, "J"), new Beat(startTime + gap * 245, "F"),
					new Beat(startTime + gap * 250, "Space"), new Beat(startTime + gap * 252, "L"),
					new Beat(startTime + gap * 257, "J"), new Beat(startTime + gap * 262, "K"),
					new Beat(startTime + gap * 267, "J"), new Beat(startTime + gap * 272, "K"),
					new Beat(startTime + gap * 277, "F"), new Beat(startTime + gap * 281, "D"),
					new Beat(startTime + gap * 286, "F"), new Beat(startTime + gap * 291, "D"),
					new Beat(startTime + gap * 296, "J"), new Beat(startTime + gap * 301, "K"),
					new Beat(startTime + gap * 306, "J"), new Beat(startTime + gap * 311, "K"),
					new Beat(startTime + gap * 316, "J"), new Beat(startTime + gap * 317, "F"),
					new Beat(startTime + gap * 322, "Space"), new Beat(startTime + gap * 324, "L"),
					new Beat(startTime + gap * 329, "S"), new Beat(startTime + gap * 334, "F"),
					new Beat(startTime + gap * 339, "S"), new Beat(startTime + gap * 344, "F"),
					new Beat(startTime + gap * 349, "J"), new Beat(startTime + gap * 354, "K"),
					new Beat(startTime + gap * 359, "J"), new Beat(startTime + gap * 364, "K"),
					new Beat(startTime + gap * 369, "L"), new Beat(startTime + gap * 374, "L"),
					new Beat(startTime + gap * 379, "L"), new Beat(startTime + gap * 384, "F"),
					new Beat(startTime + gap * 389, "D"), new Beat(startTime + gap * 390, "F"),
					new Beat(startTime + gap * 395, "Space"), };
		} else if (titleName.equals("Fablik - Say My Name") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] { new Beat(startTime, "Space"), };
		} else if (titleName.equals("Joakim Karud - Good Old Days") && difficulty.equals("Easy")) {

			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime, "Space"), new Beat(startTime, "Space"),
					new Beat(startTime, "Space"),
					new Beat(startTime + gap * 18, "F"),
					new Beat(startTime + gap * 19, "S"),
					new Beat(startTime + gap * 20, "D"),
					new Beat(startTime + gap * 21, "S"),
					new Beat(startTime + gap * 23, "F"),
					new Beat(startTime + gap * 28, "Space"),
					new Beat(startTime + gap * 40, "K"),
					new Beat(startTime + gap * 50, "L"),
					new Beat(startTime + gap * 56, "J"),
					new Beat(startTime + gap * 72, "J"),
					new Beat(startTime + gap * 82, "F"),
					new Beat(startTime + gap * 102, "D"),
					new Beat(startTime + gap * 115, "F"),
					new Beat(startTime + gap * 117, "D"),
					new Beat(startTime + gap * 120, "J"),
					new Beat(startTime + gap * 125, "L"),
					new Beat(startTime + gap * 131, "J"),
					new Beat(startTime + gap * 136, "L"),
					new Beat(startTime + gap * 152, "K"),
					new Beat(startTime + gap * 158, "K"),
					new Beat(startTime + gap * 166, "J"),
					new Beat(startTime + gap * 172, "L"),
					new Beat(startTime + gap * 177, "Space"),
					new Beat(startTime + gap * 179, "L"),
					new Beat(startTime + gap * 184, "S"),
					new Beat(startTime + gap * 189, "L"),
					new Beat(startTime + gap * 195, "S"),
					new Beat(startTime + gap * 200, "L"),
					new Beat(startTime + gap * 200, "K"),
					new Beat(startTime + gap * 204, "K"),
					new Beat(startTime + gap * 209, "J"),
					new Beat(startTime + gap * 214, "J"),
					new Beat(startTime + gap * 219, "F"),
					new Beat(startTime + gap * 224, "F"),
					new Beat(startTime + gap * 229, "J"),
					new Beat(startTime + gap * 234, "J"),
					new Beat(startTime + gap * 245, "F"),
					new Beat(startTime + gap * 250, "Space"),
					new Beat(startTime + gap * 257, "J"),
					new Beat(startTime + gap * 262, "K"),
					new Beat(startTime + gap * 267, "J"),
					new Beat(startTime + gap * 272, "K"),
					new Beat(startTime + gap * 278, "F"),
					new Beat(startTime + gap * 280, "D"),
					new Beat(startTime + gap * 282, "F"),
					new Beat(startTime + gap * 284, "D"),
					new Beat(startTime + gap * 296, "J"),
					new Beat(startTime + gap * 301, "K"),
					new Beat(startTime + gap * 306, "J"),
					new Beat(startTime + gap * 311, "K"),
					new Beat(startTime + gap * 316, "J"),
					new Beat(startTime + gap * 317, "F"),
					new Beat(startTime + gap * 322, "Space"),
					new Beat(startTime + gap * 324, "L"),
					new Beat(startTime + gap * 329, "S"),
					new Beat(startTime + gap * 334, "F"),
					new Beat(startTime + gap * 339, "S"),
					new Beat(startTime + gap * 344, "F"),
					new Beat(startTime + gap * 349, "J"),
					new Beat(startTime + gap * 354, "K"),
					new Beat(startTime + gap * 359, "J"),
					new Beat(startTime + gap * 364, "K"),
					new Beat(startTime + gap * 369, "L"),
					new Beat(startTime + gap * 374, "L"),
					new Beat(startTime + gap * 379, "L"),
					new Beat(startTime + gap * 384, "F"),
					new Beat(startTime + gap * 389, "D"),
					new Beat(startTime + gap * 390, "F"),
					new Beat(startTime + gap * 395, "Space"), };

		} else if (titleName.equals("Joakim Karud - Good Old Days") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] { new Beat(startTime, "Space"),
					};

		} else if (titleName.equals("MBB - Feel Good") && difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[]
				{
					new Beat(startTime, "Space"),
					new Beat(startTime + gap * 18, "F"),
					new Beat(startTime + gap * 22, "S"),
					new Beat(startTime + gap * 26, "Space"),
					new Beat(startTime + gap * 32, "F"),
					new Beat(startTime + gap * 38, "F"),
					new Beat(startTime + gap * 45, "F"),
					new Beat(startTime + gap * 51, "F"),
					new Beat(startTime + gap * 60, "D"),
					new Beat(startTime + gap * 66, "D"),
					new Beat(startTime + gap * 76, "S"),
					new Beat(startTime + gap * 82, "S"),
					new Beat(startTime + gap * 91, "F"),
					new Beat(startTime + gap * 97, "F"),
					new Beat(startTime + gap * 107, "D"),
					new Beat(startTime + gap * 113, "D"),
					new Beat(startTime + gap * 117, "S"),
					new Beat(startTime + gap * 123, "S"),
					new Beat(startTime + gap * 130, "F"),
					new Beat(startTime + gap * 136, "F"),
					new Beat(startTime + gap * 142, "F"),
					new Beat(startTime + gap * 150, "Space"),
					new Beat(startTime + gap * 165, "Space"),
					new Beat(startTime + gap * 181, "D"),
					new Beat(startTime + gap * 193, "F"),
					new Beat(startTime + gap * 198, "D"),
					new Beat(startTime + gap * 204, "F"),
					new Beat(startTime + gap * 208, "S"),
					new Beat(startTime + gap * 214, "Space"),
					new Beat(startTime + gap * 234, "S"),
					new Beat(startTime + gap * 236, "D"),
					new Beat(startTime + gap * 241, "K"),
					new Beat(startTime + gap * 248, "D"),
					new Beat(startTime + gap * 257, "F"),
					new Beat(startTime + gap * 262, "F"),
					new Beat(startTime + gap * 275, "D"),
					new Beat(startTime + gap * 280, "S"),
					new Beat(startTime + gap * 285, "S"),
					new Beat(startTime + gap * 290, "D"),
					new Beat(startTime + gap * 301, "K"),
					new Beat(startTime + gap * 311, "K"),
					new Beat(startTime + gap * 316, "D"),
					new Beat(startTime + gap * 321, "D"),
					new Beat(startTime + gap * 321, "K"),
					new Beat(startTime + gap * 328, "K"),
					new Beat(startTime + gap * 333, "D"),
					new Beat(startTime + gap * 338, "D"),
					new Beat(startTime + gap * 343, "K"),
					new Beat(startTime + gap * 348, "K"),
					new Beat(startTime + gap * 353, "D"),
					new Beat(startTime + gap * 358, "L"),
					new Beat(startTime + gap * 363, "J"),
					new Beat(startTime + gap * 368, "L"),
					new Beat(startTime + gap * 373, "J"),
					new Beat(startTime + gap * 378, "L"),
					new Beat(startTime + gap * 383, "K"),
					new Beat(startTime + gap * 388, "K"),
					new Beat(startTime + gap * 388, "S"),
					new Beat(startTime + gap * 393, "L"),
					new Beat(startTime + gap * 400, "Space"),
					new Beat(startTime + gap * 402, "Space"),
					new Beat(startTime + gap * 407, "S"),
					new Beat(startTime + gap * 412, "D"),
					new Beat(startTime + gap * 417, "S"),
					new Beat(startTime + gap * 422, "F"),
					new Beat(startTime + gap * 427, "S"),
					new Beat(startTime + gap * 432, "F"),
					new Beat(startTime + gap * 437, "F"),
					new Beat(startTime + gap * 442, "D"),
					new Beat(startTime + gap * 447, "F"),
					new Beat(startTime + gap * 452, "F"),
					new Beat(startTime + gap * 459, "Space"),
					new Beat(startTime + gap * 464, "K"),
					new Beat(startTime + gap * 469, "J"),
					new Beat(startTime + gap * 474, "K"),
					new Beat(startTime + gap * 479, "J"),
					new Beat(startTime + gap * 484, "K"),
					new Beat(startTime + gap * 489, "J"),
					new Beat(startTime + gap * 494, "K"),
					new Beat(startTime + gap * 499, "J"),
					new Beat(startTime + gap * 503, "K"),
					new Beat(startTime + gap * 508, "D"),
					new Beat(startTime + gap * 513, "D"),
					new Beat(startTime + gap * 518, "S"),
					new Beat(startTime + gap * 518, "K"),
				};

		} else if (titleName.equals("MBB - Feel Good") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] { new Beat(startTime, "Space"), };

		} else if (titleName.equals("Sora – Roa") && difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[]
				{
					new Beat(startTime + gap * 2, "F"),
					new Beat(startTime + gap * 10, "F"),
					new Beat(startTime + gap * 14, "S"),
					new Beat(startTime + gap * 18, "Space"),
					new Beat(startTime + gap * 35, "F"),
					new Beat(startTime + gap * 39, "S"),
					new Beat(startTime + gap * 43, "Space"),
					new Beat(startTime + gap * 49, "Space"),
					new Beat(startTime + gap * 51, "D"),
					new Beat(startTime + gap * 53, "D"),
					new Beat(startTime + gap * 55, "D"),
					new Beat(startTime + gap * 57, "D"),
					new Beat(startTime + gap * 62, "Space"),
					new Beat(startTime + gap * 70, "F"),
					new Beat(startTime + gap * 74, "S"),
					new Beat(startTime + gap * 78, "F"),
					new Beat(startTime + gap * 82, "D"),
					new Beat(startTime + gap * 86, "D"),
					new Beat(startTime + gap * 90, "F"),
					new Beat(startTime + gap * 94, "S"),
					new Beat(startTime + gap * 99, "Space"),
					new Beat(startTime + gap * 103, "S"),
					new Beat(startTime + gap * 107, "S"),
					new Beat(startTime + gap * 111, "S"),
					new Beat(startTime + gap * 115, "S"),
					new Beat(startTime + gap * 119, "S"),
					new Beat(startTime + gap * 123, "S"),
					new Beat(startTime + gap * 127, "S"),
					new Beat(startTime + gap * 131, "S"),
					new Beat(startTime + gap * 135, "S"),
					new Beat(startTime + gap * 139, "S"),
					new Beat(startTime + gap * 143, "S"),
					new Beat(startTime + gap * 147, "S"),
					new Beat(startTime + gap * 151, "S"),
					new Beat(startTime + gap * 155, "S"),
					new Beat(startTime + gap * 159, "S"),
					new Beat(startTime + gap * 159, "K"),
					new Beat(startTime + gap * 163, "K"),
					new Beat(startTime + gap * 167, "K"),
					new Beat(startTime + gap * 171, "K"),
					new Beat(startTime + gap * 175, "K"),
					new Beat(startTime + gap * 179, "K"),
					new Beat(startTime + gap * 183, "K"),
					new Beat(startTime + gap * 187, "K"),
					new Beat(startTime + gap * 191, "K"),
					new Beat(startTime + gap * 195, "K"),
					new Beat(startTime + gap * 199, "K"),
					new Beat(startTime + gap * 203, "J"),
					new Beat(startTime + gap * 207, "J"),
					new Beat(startTime + gap * 211, "J"),
					new Beat(startTime + gap * 215, "J"),
					new Beat(startTime + gap * 219, "J"),
					new Beat(startTime + gap * 223, "J"),
					new Beat(startTime + gap * 227, "L"),
					new Beat(startTime + gap * 231, "L"),
					new Beat(startTime + gap * 235, "L"),
					new Beat(startTime + gap * 239, "L"),
					new Beat(startTime + gap * 243, "L"),
					new Beat(startTime + gap * 243, "K"),
					new Beat(startTime + gap * 247, "D"),
					new Beat(startTime + gap * 251, "F"),
					new Beat(startTime + gap * 255, "K"),
					new Beat(startTime + gap * 259, "K"),
					new Beat(startTime + gap * 263, "K"),
					new Beat(startTime + gap * 267, "K"),
					new Beat(startTime + gap * 271, "K"),
					new Beat(startTime + gap * 275, "J"),
					new Beat(startTime + gap * 279, "J"),
					new Beat(startTime + gap * 283, "J"),
					new Beat(startTime + gap * 287, "J"),
					new Beat(startTime + gap * 291, "J"),
					new Beat(startTime + gap * 295, "J"),
					new Beat(startTime + gap * 295, "S"),
					new Beat(startTime + gap * 299, "S"),
					new Beat(startTime + gap * 303, "S"),
					new Beat(startTime + gap * 307, "S"),
					new Beat(startTime + gap * 311, "S"),
					new Beat(startTime + gap * 315, "S"),
					new Beat(startTime + gap * 319, "Space"),
					new Beat(startTime + gap * 320, "F"),
					new Beat(startTime + gap * 323, "D"),
					new Beat(startTime + gap * 327, "D"),
					new Beat(startTime + gap * 331, "D"),
					new Beat(startTime + gap * 335, "D"),
					new Beat(startTime + gap * 339, "F"),
					new Beat(startTime + gap * 343, "S"),
					new Beat(startTime + gap * 347, "S"),
					new Beat(startTime + gap * 351, "S"),
					new Beat(startTime + gap * 355, "Space"),
					new Beat(startTime + gap * 362, "S"),
					new Beat(startTime + gap * 367, "S"),
					new Beat(startTime + gap * 370, "S"),
					new Beat(startTime + gap * 375, "D"),
					new Beat(startTime + gap * 379, "F"),
					new Beat(startTime + gap * 383, "D"),
					new Beat(startTime + gap * 387, "F"),
					new Beat(startTime + gap * 391, "D"),
					new Beat(startTime + gap * 395, "F"),
					new Beat(startTime + gap * 399, "S"),
					new Beat(startTime + gap * 403, "S"),
					new Beat(startTime + gap * 407, "F"),
					new Beat(startTime + gap * 411, "F"),
					new Beat(startTime + gap * 415, "D"),
					new Beat(startTime + gap * 419, "D"),
					new Beat(startTime + gap * 425, "Space"),
					new Beat(startTime + gap * 431, "D"),
					new Beat(startTime + gap * 435, "S"),
					new Beat(startTime + gap * 439, "S"),
					new Beat(startTime + gap * 443, "S"),
					new Beat(startTime + gap * 447, "F"),
					new Beat(startTime + gap * 451, "F"),
					new Beat(startTime + gap * 455, "F"),
					new Beat(startTime + gap * 459, "F"),
					new Beat(startTime + gap * 463, "D"),
					new Beat(startTime + gap * 467, "D"),
					new Beat(startTime + gap * 473, "Space"),
					new Beat(startTime + gap * 473, "Space"),
					new Beat(startTime + gap * 479, "K"),
					new Beat(startTime + gap * 483, "L"),
					new Beat(startTime + gap * 487, "K"),
					new Beat(startTime + gap * 491, "K"),
					new Beat(startTime + gap * 495, "L"),
					new Beat(startTime + gap * 499, "J"),
					new Beat(startTime + gap * 503, "J"),
					new Beat(startTime + gap * 507, "K"),
					new Beat(startTime + gap * 511, "K"),
					new Beat(startTime + gap * 515, "L"),
					new Beat(startTime + gap * 519, "D"),
					new Beat(startTime + gap * 523, "D"),
					new Beat(startTime + gap * 527, "S"),
					new Beat(startTime + gap * 531, "S"),
					new Beat(startTime + gap * 535, "F"),
					new Beat(startTime + gap * 539, "F"),
					new Beat(startTime + gap * 543, "D"),
					new Beat(startTime + gap * 547, "D"),
					new Beat(startTime + gap * 551, "Space"),
					new Beat(startTime + gap * 557, "K"),
					new Beat(startTime + gap * 563, "D"),
					new Beat(startTime + gap * 566, "L"),
					new Beat(startTime + gap * 570, "K"),
					new Beat(startTime + gap * 574, "J"),
					new Beat(startTime + gap * 578, "K"),
					new Beat(startTime + gap * 582, "L"),
					new Beat(startTime + gap * 586, "L"),
					new Beat(startTime + gap * 590, "K"),
					new Beat(startTime + gap * 594, "K"),
					new Beat(startTime + gap * 598, "L"),
					new Beat(startTime + gap * 602, "K"),
					new Beat(startTime + gap * 606, "L"),
					};

		} else if (titleName.equals("Sora – Roa") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] { new Beat(startTime, "Space"), };

		}
		int i = 0;
		gameMusic.start();
		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void judge(String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (input.equals(note.getNoteType())) {
				note.judge();
				break;
			}
		}
	}
}
