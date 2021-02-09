public abstract class Smartphone {
    Market market;
    Smartphone(Market o){
        this.market = o;
    }
    public void makePhone(){
        attachCPUAndRam();
        attachDisplay();
        attachBattery();
        attachStorage();
        attachCamera();
        enclosePhoneCase();
    }

    protected abstract void enclosePhoneCase();

    protected abstract void attachCamera();

    protected abstract void attachStorage();

    protected abstract void attachBattery();

    protected abstract void attachDisplay();

    protected abstract void attachCPUAndRam();
}
