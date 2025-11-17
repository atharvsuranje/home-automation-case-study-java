package model.devices;

import model.interfaces.EntertainmentControlable;

public class TV extends Device implements EntertainmentControlable {
	
	int volumeLevel;
	int channel;
	boolean isMuted;
	
	public TV(String name) {
		super(name);
		this.volumeLevel = 5;
		this.channel = 1;
		this.isMuted = false;
	}

	public TV(String name, int volumeLevel, int channel, boolean isMuted) {
		super(name);
		this.volumeLevel = volumeLevel;
		this.channel = channel;
		this.isMuted = isMuted;
	}

	public int getVolumeLevel() {
		return volumeLevel;
	}

	public void setVolumeLevel(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public boolean isMuted() {
		return isMuted;
	}

	public void setMuted(boolean isMuted) {
		this.isMuted = isMuted;
	}

	@Override
	public void volumeUp() {
		if (isMuted) {
			isMuted = false;
		}
		if (volumeLevel < 100) {
			volumeLevel++;
		}
		System.out.println("Volume Increased to " + volumeLevel);
		
	}

	@Override
	public void volumeDown() {
		if (volumeLevel > 0) {
			volumeLevel--;
		}
		System.out.println("Volume decreased to " + volumeLevel);
		
	}

	@Override
	public void nextChannel() {
		channel++;
		System.out.println("Channel change to " + channel);
		
	}

	@Override
	public void previousChannel() {
		channel--;
		System.out.println("Channel change to " + channel);
		
	}

	@Override
	public void switchChannel(int newchannel) {
		
		
	}
	
}
