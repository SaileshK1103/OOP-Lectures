package Task_1;

public class Television {
    private boolean on;
    private int channel;

    // Constructor: initially off, no channel selected
    public Television() {
        on = false;
        channel = 0;
    }
    // Check if TV is on
    public boolean isOn() {
        return on;
    }
    // Toggle television state
    public void pressOnOff() {
        if(on) {
            on = false;
        }
        else {
            on = true;
        }
    }
    // Get current channel
    public int getChannel() {
        return channel;
    }
    // Set channel
    public void setChannel(int newChannel) {
        if (newChannel > 10) {
            channel = 1;
        } else {
            channel = newChannel;
        }
    }
}
