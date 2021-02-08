public class GreenLight implements LightState{
    private TrafficLight trafficLight;
    private int duration;

    public GreenLight(TrafficLight o){
        trafficLight = o;
        duration = 60;
    }
    @Override
    public void displayLight() {
        System.out.println("Green light displayed " + duration + " seconds.");
    }

    @Override
    public void switchLight() {
        trafficLight.setLight(trafficLight.getYellowLight());
    }

    void setLongDuration(){
        duration = 90;
    }

    void setInitialDuration(){
        duration = 60;
    }

}
