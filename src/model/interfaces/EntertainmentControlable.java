package model.interfaces;

public interface EntertainmentControlable {
	boolean volumeUp();
    boolean volumeDown();
    boolean nextChannel();
    boolean previousChannel();
    boolean switchChannel(int channel);
}
