package model.devices;

import model.interfaces.EntertainmentControlable;
import model.interfaces.markup.BedroomAllowable;
import model.interfaces.markup.LivingAreaAllowable;

public class TV extends Device implements EntertainmentControlable, BedroomAllowable, LivingAreaAllowable {
	
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
	public boolean volumeUp() {
		if (isMuted) {
			isMuted = false;
		}
		if (volumeLevel < 100) {
			volumeLevel++;
		}
		return true;
		
	}

	@Override
	public boolean volumeDown() {
		if (volumeLevel > 0) {
			volumeLevel--;
		}
		return true;
		
	}

	@Override
	public boolean nextChannel() {
		channel++;
		return true;
		
	}

	@Override
	public boolean previousChannel() {
		channel--;
		System.out.println("Channel change to " + channel);
		return true;
		
	}

	@Override
	public boolean switchChannel(int newChannel) {
		if (newChannel > 0) {
			channel = newChannel;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				" | Volume: " + volumeLevel +
		        " | Channel: " + channel +
		        " | Muted: " + (isMuted ? "YES" : "NO");
	}
}
