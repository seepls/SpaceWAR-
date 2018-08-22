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
  
  


}


