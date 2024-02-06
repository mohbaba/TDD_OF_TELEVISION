package Television;

import java.util.ArrayList;

public class Television {

    public boolean isOn;

    private final ArrayList<Channel> channels = new ArrayList<>();
    private int volume;
    private static int channel;

    public void powerOn() {
        isOn = true;
    }

    public void powerOff() {
        isOn = false;
    }

    public void increaseVolume() {
        boolean isWithinVolumeRange = volume >= 0 && volume < 100;
        if (isOn && isWithinVolumeRange) {
            volume += 2;
        }

    }

    public int getVolume() {
        return volume;
    }

    public void decreaseVolume() {
        boolean isWithinVolumeRange = volume > 0 && volume <= 100;
        if (isOn && isWithinVolumeRange) {
            volume -= 2;
        }

    }

    public Channel nextChannel() {
        boolean isWithinRange = channel >= 0 && channel < channels.size();
        Channel chan = channels.get(0);
        try{
            if (isOn && isWithinRange) {
                return channels.get(++channel);
            }
        } catch (IndexOutOfBoundsException e) {
            return chan;
        }
        return chan;

    }

    public int getChannel() {
        return channel;
    }

    public Channel prevChannel() {
        boolean isWithinChannelRange = channel >=0 && channel < channels.size();
        Channel chan = channels.get(0);
        try{
            if (isOn && isWithinChannelRange ){
                return channels.get(--channel);
            }
        } catch (IndexOutOfBoundsException e) {
            return chan ;
        }


        return chan;
    }

    public ArrayList<Channel> getChannels() {
        return channels;
    }

    public void searchForChannels(){
        for (int number = 0; number < 50; number++) {
            channels.add(new Channel(number));

        }
    }
}
