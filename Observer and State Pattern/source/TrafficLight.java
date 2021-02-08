public class TrafficLight {
    private LightState redLight;
    private LightState yellowLight;
    private LightState greenLight;

    private LightState currentLight;

    /**
     * Constructor setting light states
     * initial current state is red
     */
    public TrafficLight(){
        redLight = new RedLight(this);
        yellowLight = new YellowLight(this);
        greenLight = new GreenLight(this);
        currentLight = redLight;
    }

    public void work(){
        currentLight.displayLight();
        currentLight.switchLight();
    }

    void setLight(LightState o){
        currentLight = o;
    }

    /**
     * change green light duration depending on traffic
     * @param flag true if traffic is heavy, false if traffic is normal
     */
    void changeGreenLightDuration(boolean flag){
        if(flag)
            ((GreenLight)greenLight).setLongDuration();
        else
            ((GreenLight)greenLight).setInitialDuration();
    }

    LightState getRedLight() {
        return redLight;
    }

    LightState getYellowLight() { return yellowLight; }

    LightState getGreenLight() {
        return greenLight;
    }
}
