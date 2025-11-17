package model.devices;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Device {
	private final String name;
	private boolean isOn;
	private LocalDateTime lastStateChangedTime;
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	public Device(String name) { 
		this.name = name;
		
		this.lastStateChangedTime=null;
	}

	public String getName() {
		return name;
	}

	public boolean isOn() {
		return isOn;
	}

	public LocalDateTime getLastStateChangedTime() {
		return lastStateChangedTime;
	}
	
	public boolean turnOn() {
		if(!isOn) {
			isOn=true;
			lastStateChangedTime=LocalDateTime.now();
			return true;
		}
		return false;
	}
	
	public boolean turnOff() {
		if(isOn) {
			isOn=false;
			lastStateChangedTime = LocalDateTime.now();
			return true;
		}
		return false;
	}
	
	public String timeInCurrentState() {
		if(lastStateChangedTime==null) {
			return "0s";
		}
		
		Duration duration = Duration.between(lastStateChangedTime, LocalDateTime.now());
		long totalSeconds=duration.getSeconds();
		
		long hours=totalSeconds/3600;
		long minutes= (totalSeconds%3600)/60;
		long seconds= totalSeconds%60;
		
		StringBuilder sb=new StringBuilder();
		if(hours>0) sb.append(hours).append("h ");
		if(minutes>0 || hours>0) sb.append(minutes).append("m ");
		sb.append(seconds).append("s");
		
		return sb.toString().trim();
	}
	
	public String getLastChangedTime() {
		if(lastStateChangedTime == null) {
			return "Not changed yet";
		}
		return lastStateChangedTime.format(FORMATTER);
	}
	
	@Override
	public String toString() {
        return name + " | State: " + (isOn ? "ON" : "OFF") +
          " | Since: " + getLastChangedTime() +
          " | Active For: " + timeInCurrentState();
    }
}
