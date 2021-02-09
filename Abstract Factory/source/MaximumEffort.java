public class MaximumEffort extends Smartphone{
    MaximumEffort(Market o) {
        super(o);
    }

    @Override
    protected void enclosePhoneCase() {
        System.out.println("151x73x7.7 mm, dustproof, aluminum, " + market.createWaterproof() + " case enclosed.");
    }

    @Override
    protected void attachCamera() {
        System.out.println("12Mp front, 8Mp rear " + market.createCameraZoom() + " camera attached.");
    }

    @Override
    protected void attachStorage() {
        if(market.createStorage().getMax() >= 64){
            System.out.println("MicroSD support, 64GB storage attached.");
        }
        else{
            System.out.println("MicroSD support, " + market.createStorage().getMax() +" storage attached.");
        }
    }

    @Override
    protected void attachBattery() {
        System.out.println("27h, 3600mAh " + market.createBatteryType() + " battery attached.");
    }

    @Override
    protected void attachDisplay() {
        System.out.println("5.5 inc " + market.createDisplayDepth() + " display attached.");
    }

    @Override
    protected void attachCPUAndRam() {
        System.out.println("2.8GHz " + market.createCPUCores() + " CPU and 8GB Ram attached.");
    }
}
