public class Turkey implements Market{
    @Override
    public BatteryType createBatteryType() {
        return new Boron();
    }

    @Override
    public CameraZoom createCameraZoom() {
        return new X4();
    }

    @Override
    public CPUCores createCPUCores() {
        return new OctaCores();
    }

    @Override
    public DisplayDepth createDisplayDepth() {
        return new Display32Bit();
    }

    @Override
    public Storage createStorage() {
        return new Max128();
    }

    @Override
    public Waterproof createWaterproof() {
        return new TwoMeter();
    }
}
