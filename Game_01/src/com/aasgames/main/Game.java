package com.aasgames.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

	
	
	
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	public Thread thread;
	private boolean isRunning = true;
	private final int WIDTH = 240, HEIGHT = 160;
	private final int SCALE = 3;
	
	private BufferedImage image;
	

	public Game() {
	setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
	initFrame();
	image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	}
			
	
	public void initFrame() {
		frame = new JFrame("Game #1");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		}catch(InterruptedException e ) {
			e.printStackTrace();
		}
	}
	public void tick() {
		
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		g.setColor(new Color(0,0,255));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g.dispose();
		g= bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH*SCALE, HEIGHT*SCALE,null);
		bs.show();
		
	}
	
	
	@Override
	public void run() {
		long lasTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		while(isRunning) {
			long no
			delta+= (now1 - lasTime)/ns;
			lasTime = now1;
			if(delta>=1) {
				
			}
			
		}
		
	}	
		


}
