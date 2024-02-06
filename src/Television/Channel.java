package Television;

public class Channel {
    private final int id;
    private String channelName;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Channel(int id){
        this.id = id;

    }

    public String toString(){
        return String.format("Channel %d",id);
    }
}
