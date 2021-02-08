public class Main {

    public static void main(String[] args) {
	    TrafficLight deneme = new TrafficLight();
        HiTech mobese = new HiTech();
        mobese.registerTrafficLight(deneme);
        boolean heavyTraffic = false;

        for (int i = 0; i < 3; i++) {
            if(heavyTraffic)
                System.out.println("Heavy Traffic now");
            else
                System.out.println("Normal traffic now");
            for (int j = 0; j < 5; j++) {
                deneme.work();
            }
            heavyTraffic = !heavyTraffic;
            mobese.changeDetected(heavyTraffic);
        }
    }
}
