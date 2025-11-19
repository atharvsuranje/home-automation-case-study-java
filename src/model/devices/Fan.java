package model.devices;

import model.interfaces.SpeedControlable;
import model.interfaces.markup.BedroomAllowable;
import model.interfaces.markup.DiningAreaAllowable;
import model.interfaces.markup.KitchenAllowable;
import model.interfaces.markup.LivingAreaAllowable;

public class Fan extends Device implements BedroomAllowable,SpeedControlable,DiningAreaAllowable,KitchenAllowable,LivingAreaAllowable{
	private int currentSpeed;
	private static final int MIN_SPEED = 0;
	private static final int MAX_SPEED = 5;

	public Fan(String name) {
		super(name);
		currentSpeed=MIN_SPEED;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}
	
	@Override
	public boolean speedUp() {
		if (currentSpeed < MAX_SPEED) {
	        currentSpeed++;
	        return true;
	    }
	    return false;
	}

	@Override
	public boolean speedDown() {
		if (currentSpeed > MIN_SPEED) {
	        currentSpeed--;
	        return true;
	    }
	    return false;
	}
}
