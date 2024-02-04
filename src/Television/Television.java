package Television;

public class Television {

    public boolean isOn;
    private int volume;
    private static int channel = 1;

    public void powerOn() {
        isOn = true;
    }

    public void powerOff() {
        isOn = false;
    }

    public void increaseVolume() {
        volume += 2;
    }

    public int getVolume() {
        return volume;
    }

    public void decreaseVolume() {
        volume -= 2;
    }

    public void nextChannel() {
        boolean isWithinChannelRange = channel >= 1 && channel < 21;
        if (isOn && isWithinChannelRange) {
            channel++;
        }

    }

    public int getChannel() {
        return channel;
    }

    public void prevChannel() {
        if (isOn){
            if (channel > 1 && channel < 21) {
                channel--;

            }
        }


    }
}
