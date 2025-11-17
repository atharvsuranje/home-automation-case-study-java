package model.devices;

import model.interfaces.LightControlable;
import model.interfaces.markup.BedroomAllowable;
import model.interfaces.markup.CorridorAllowable;
import model.interfaces.markup.DiningAreaAllowable;
import model.interfaces.markup.KitchenAllowable;
import model.interfaces.markup.LivingAreaAllowable;
import model.interfaces.markup.WashroomAllowable;

public class Light extends Device implements LightControlable,BedroomAllowable,CorridorAllowable,DiningAreaAllowable,KitchenAllowable,LivingAreaAllowable,WashroomAllowable{
	 int BrightnessLevel = 1;
	 String color = "white";
	 boolean isDimmable = false;
	 
	 public Light(String name , boolean isDimmable) 
	 {
		super(name);
		this.isDimmable = isDimmable;
		
	}

	 public int getBrightnessLevel()
	 {
		return BrightnessLevel;
	}
	 public void setBrightnessLevel(int brightnessLevel)
	 {
		 BrightnessLevel = brightnessLevel;
	 }
	 public String getColor()
	 {
		 return color;
	 }
	 public void setColor(String color) 
	 {
		 this.color = color;
	 }
	 public void setDimmable(boolean isDimmable)
	 {
		
		this.isDimmable = isDimmable;
	}
	

	 @Override
	 public boolean increseBrightness() 
	 {
		if(BrightnessLevel<5&&BrightnessLevel>0)
		{
			BrightnessLevel+=1;
		}
		 if (BrightnessLevel > 5) 
		 {
			BrightnessLevel = 5;
          return true ;          
		 } 
		 else
		 	{
	           return false;
	        }	 
	 }
	 
	 @Override
	 public boolean decreseBrightness() {
		 if(BrightnessLevel>1 && BrightnessLevel <5) 
		 	{
				BrightnessLevel-=1;
			}
			 if (BrightnessLevel <= 1 )
			 { 
	          return true;
			 } else 
			 	{
		            return false;
		        }
	 }
	 
	 // in main we give a next() method for string input 
	 @Override
	 public String changeColor(String color) 	
	 {
		 this.setColor(color);	
		 return color;
	 }
	 @Override
	 public String toString()
	 {
		return "Lightname " + this.getName() + "| "+
				" BrightnessLevel = " + BrightnessLevel + "|   , color = " + color +
			"| "+	", isDimmable = " + isDimmable + " | ";
	 }
	
	 
}
