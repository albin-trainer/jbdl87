package com.geeks.threads;
public class WaitNotifyExample {
public static void main(String[] args) {
	Video v=new Video();
	Audio a=new Audio();
	v.setAudio(a);
	a.setV(v);
	Thread t1=new Thread(v,"Video");
	Thread t2=new Thread(a,"Audio");
t1.start();t2.start();
}
}
class Video implements Runnable{
	Audio audio;
	public void setAudio(Audio audio) {
		this.audio = audio;
	}
	public void run() {
		playVideo();
	}
	private synchronized void playVideo() {
		for(int i=1;i<=10;i++) {
			System.out.println("*****Playing Video "+i);
			//Notify the Audio ...
			synchronized(audio) { //acquiring the lock of audio
			audio.notify();
			}
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
}
class Audio implements Runnable{
	private Video v;
	
	public void setV(Video v) {
		this.v = v;
	}
	public void run() {
	playAudio();
	}
	private synchronized  void playAudio() {
		for(int i=1;i<=10;i++) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("----->Playing Audio "+i);
			synchronized (v) {
				v.notify();
			}
		}		
	}
	
}