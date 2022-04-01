package client;

public class settings {
    private boolean darkMode;
    private double volume;

    public settings()
    {
        this.darkMode=false;
        this.volume = 100;
    }
    public settings(boolean darkMode,double volume)
    {
        this.darkMode=darkMode;
        this.volume=volume;
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    public double getVolume() {
        return volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }
}
