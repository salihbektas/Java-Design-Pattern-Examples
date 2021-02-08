import java.util.ArrayList;

/**
 * Mobese camera class
 * Observable class of traffic lights
 * if detect heavy traffic set long durations green of traffic lights
 * if traffic is normal set normal duration green of traffic light
 */
public class HiTech {
    private ArrayList<TrafficLight> listOfTrafficLights;

    public HiTech(){
        listOfTrafficLights = new ArrayList<>();
    }

    /**
     * Adding subject method
     * @param o traffic light to register
     */
    public void registerTrafficLight(TrafficLight o){
        listOfTrafficLights.add(o);
    }

    /**
     * Remove subject method
     * @param o traffic light to remove
     */
    public void removeTrafficLight(TrafficLight o){
        listOfTrafficLights.remove(o);
    }

    /**
     * change duration of green light time
     * @param flag true if heavy traffic, false if normal traffic
     */
    public void changeDetected(boolean flag){

        for(TrafficLight trafficLight : listOfTrafficLights)
            trafficLight.changeGreenLightDuration(flag);
    }
}
