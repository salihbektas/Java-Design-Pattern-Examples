public class IIAmanIflas extends Smartphone{
    IIAmanIflas(Market o) {
        super(o);
    }

    @Override
    protected void enclosePhoneCase() {
        System.out.println("143x69x7.3 mm, plastic, " + market.createWaterproof() + " case enclosed.");
    }

    @Override
    protected void attachCamera() {
        System.out.println("8Mp front, 5Mp rear " + market.createCameraZoom() + " camera attached.");
    }

    @Override
    protected void attachStorage() {
        if(market.createStorage().getMax() >= 16){
            System.out.println("MicroSD support, 16GB storage attached.");
        }
        else{
            System.out.println("MicroSD support, " + market.createStorage().getMax() +" storage attached.");
        }
    }

    @Override
    protected void attachBattery() {
        System.out.println("16h, 2000mAh " + market.createBatteryType() + " battery attached.");
    }

    @Override
    protected void attachDisplay() {
        System.out.println("4.5 inc " + market.createDisplayDepth() + " display attached.");
    }

    @Override
    protected void attachCPUAndRam() {
        System.out.println("2.2GHz " + market.createCPUCores() + " CPU and 4GB Ram attached.");
    }
}
