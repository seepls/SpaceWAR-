import java.awt.*;
import java.awt.image.*;
import java.net.URL;
import javax.imageio.*;

public class Enemy{
 private boolean ready, hit ,dead ;
 private Color color ;
 private BufferedImage  bd1 , bd2 ,bd3 ,bd4 ,bd5 ,bd6 ,bd7 ,bd8,bd9 , image;
 private double x ,y ,dx ,dy ,rad , speed ;
 private int r , health , type ,rank ;
 private long hitTimer ;
 public Enemy ( int type , int rank ){
 this.type = type ;
 this.rank = rank ;
 if(type == 1) {
 if (bd1  == null  )bd1 = new   Generals().loadImg("/img/badass/badAss_1.png");
      if (rank == 1) {
				speed = 3;
				r = 15;
				health = 1;
			}
      
      if (rank == 2) {
				speed = 3;
				r = 20;
				health = 2;
			}
      if (rank == 3) {
				speed = 1.5;
				r = 25;
				health = 3;
			}
      if (rank == 4) {
				speed = 1.5;
				r = 30;
				health = 5;
			}
			image = bd1;
		}
 
