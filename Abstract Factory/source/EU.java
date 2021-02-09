public class EU implements Market{
    @Override
    public BatteryType createBatteryType() {
        return new Ion();
    }

    @Override
    public CameraZoom createCameraZoom() {
        return new X3();
    }

    @Override
    public CPUCores createCPUCores() {
        return new QuadCores();
    }

    @Override
    public DisplayDepth createDisplayDepth() {
        return new Display24Bit();
    }

    @Override
    public Storage createStorage() {
        return new Max64();
    }

    @Override
    public Waterproof createWaterproof() {
        return new OneMeter();
    }
}
