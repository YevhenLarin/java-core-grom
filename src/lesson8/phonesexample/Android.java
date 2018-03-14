package lesson8.phonesexample;

public class Android extends Phone {
    String androidVersion;
    int screenSize;

    String secredDeviceCode;

    public Android(int price, double weight, String countryProduced, String androidVersion, int screenSize, String secredDeviceCode) {
        super(price, weight, countryProduced);

        //this - reference to the current class object
        //super - reference to the parent class object

        this.androidVersion = androidVersion;
        this.screenSize = screenSize;
        this.secredDeviceCode = secredDeviceCode;
    }

    void installNewAndroidVersion() {
        System.out.println("installNewAndroidVersion invoked...");
    }
}
