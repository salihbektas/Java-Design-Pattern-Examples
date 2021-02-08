public class YellowLight implements LightState{
    private TrafficLight trafficLight;

    public YellowLight(TrafficLight o){
        trafficLight = o;
    }

    @Override
    public void displayLight() {
        System.out.println("Yellow light displayed 3 seconds.");
    }

    @Override
    public void switchLight() {
        trafficLight.setLight(trafficLight.getRedLight());
    }
}
