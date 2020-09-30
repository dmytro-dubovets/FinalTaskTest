package cucumber.hooks;


import driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class DriverHooks {

    @Before
    public void setUpDriver() {
        DriverSingleton.getDriver();
    }

    @After
    public void closeDriver() {
        DriverSingleton.tearDown();
    }

}

