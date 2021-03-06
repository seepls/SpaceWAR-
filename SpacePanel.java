import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class SpacePanel extends JPanel impliments Runnable , KeyListener {
public final static int width = 800 ;
public final static int height = 600 ;
private boolean running,  waveStart, keyControl= false;
private BufferedImage image ,imgPlayer , bk , background1 ,background2 ,background3,background4,background5,background6,background7,background8;
private double averageFps ;
private Graphics2D g ;
private int fps = 30, waveDelay = 2000, limitLevel = 36;
private int waveNumber ;
private long waveStartTimer , waveStartTimerDiff ;
	
private Thread thread ;
	
public static Player player ;
public static ArrayList <Bullet> bullets ;
public static ArrayList < Enemy> enemies ;
public static ArrayList<PowerUp> powerUps ;
public static ArrayList <Explosion > explosions ;\
public static ArrayList <Text> texts ;
	
  	private File flFile = null;
	private FileReader frRead = null;
	private BufferedReader brRead = null;
	private PrintWriter outputFile;
	private String scoreFile = "score.txt";
	
	public SpacePanel (){
		super();
		setPreferredSize (new Dimension(width ,height));
		setFocusable(true) ;
		requestFocus();
	}
		
	public void addNotify(){
		super.addNotify() ;
		//Thread to start our game 
		if (thread == null) { 
		thread = new Thread(this) ;
		thread.start() ;
		}
		addKeyListener(this) ;
	}
  
  	public void run() {
	  running = true ;
	  if (imgPlayer == null) imgPlayer = new Generals().loadImg("/img/hero/hero-up-transp.png");
	  }

	image = new BufferedImage ( width , height , BufferedImage.TYPE_INT_RGB);
	g = (Graphics2D) image. getGraphics ();
	g.setRenderRingHint (RenderingHints . .KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	
	
	
	if (background1 == null) background1 = new Generals().loadImg("/img/stage/stage1.jpg");
	if (background2 == null) background2 = new Generals().loadImg("/img/stage/stage2.jpg");
	if (background3 == null) background3 = new Generals().loadImg("/img/stage/stage3.png");
	if (background4 == null) background4 = new Generals().loadImg("/img/stage/stage4.jpg");
	if (background5 == null) background5 = new Generals().loadImg("/img/stage/stage5.jpg");
	if (background6 == null) background6 = new Generals().loadImg("/img/stage/stage6.jpg");
	if (background7 == null) background7 = new Generals().loadImg("/img/stage/stage7.jpg");
	if (background8 == null) background8 = new Generals().loadImg("/img/stage/stage8.jpg");
	
	player = new Player () ;
	bullets = new ArrayList<Bullet>();
		enemies = new ArrayList<Enemy>();
		powerUps = new ArrayList<PowerUp>();
		explosions = new ArrayList<Explosion>();
		texts = new ArrayList<Text>();

		waveStartTimer = 0;
		waveStartTimerDiff = 0;
		waveStart = true;
		waveNumber = 0;
	
	long startTime ;
	long URDTimeMillis;
	long waitTime = 0;
	long totalTime = 0;
	long targetTime = 1000 / fps;
	int frameCount = 0;
	int maxFrameCount = 30;
	
	while (running) {
			startTime = System.nanoTime();

			gameUpdate();
			gameRender();
			gameDraw();
			URDTimeMillis = (System.nanoTime() - startTime) / 1000000;
			waitTime = targetTime - URDTimeMillis;
			try {
			Thread.sleep(waitTime) ;
			}catch (Exception ex ) {
				
				totalTime+= System.nanoTime() - startTime;
				frameCount++ ;
				if (frameCount == maxFrameCount) {
					averageFps = 1000 / ((totalTime / frameCount) / 1000000);
					frameCount = 0;
					totalTime = 0;
				}
			}
	}
	//GameOvermessage
	g.setColor(new Color(0, 100, 255));
	g.fillRect(0, 0, width, height);
	g.setColor(Color.WHITE);
	g.setFont(new Font("Century Gothic", Font.PLAIN, 20));
	
	String s = "Game over";
	int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
	g.drawString(s, (width - length) / 3, height / 3);
	String score = "Total score: " + player.getScore();
	g.drawString(score, (width - length) / 3, height / 3 + 50);
	String maxScore = "";
	
	
			

	
