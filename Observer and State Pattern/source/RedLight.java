public class RedLight implements LightState{
    private TrafficLight trafficLight;

    public RedLight(TrafficLight o){
        trafficLight = o;
    }

    @Override
    public void displayLight() {
        System.out.println("Red light displayed 15 seconds.");

    }

    @Override
    public void switchLight() {
        trafficLight.setLight(trafficLight.getGreenLight());
    }
}
