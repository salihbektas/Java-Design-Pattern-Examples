public class Global implements Market{
    @Override
    public BatteryType createBatteryType() {
        return new Cobalt();
    }

    @Override
    public CameraZoom createCameraZoom() {
        return new X2();
    }

    @Override
    public CPUCores createCPUCores() {
        return new DualCores();
    }

    @Override
    public DisplayDepth createDisplayDepth() {
        return new Display24Bit();
    }

    @Override
    public Storage createStorage() {
        return new Max32();
    }

    @Override
    public Waterproof createWaterproof() {
        return new HalfMeter();
    }
}
