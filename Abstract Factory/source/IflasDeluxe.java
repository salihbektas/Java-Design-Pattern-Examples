public class IflasDeluxe extends Smartphone{
    IflasDeluxe(Market o) {
        super(o);
    }

    @Override
    protected void enclosePhoneCase() {
        System.out.println("149x73x7.7 mm, aluminum, " + market.createWaterproof() + " case enclosed.");
    }

    @Override
    protected void attachCamera() {
        System.out.println("12Mp front, 5Mp rear " + market.createCameraZoom() + " camera attached.");
    }

    @Override
    protected void attachStorage() {
        if(market.createStorage().getMax() >= 32){
            System.out.println("MicroSD support, 32GB storage attached.");
        }
        else{
            System.out.println("MicroSD support, " + market.createStorage().getMax() +" storage attached.");
        }
    }

    @Override
    protected void attachBattery() {
        System.out.println("20h, 2800mAh " + market.createBatteryType() + " battery attached.");
    }

    @Override
    protected void attachDisplay() {
        System.out.println("5.3 inc " + market.createDisplayDepth() + " display attached.");
    }

    @Override
    protected void attachCPUAndRam() {
        System.out.println("2.2GHz " + market.createCPUCores() + " CPU and 6GB Ram attached.");
    }
}
