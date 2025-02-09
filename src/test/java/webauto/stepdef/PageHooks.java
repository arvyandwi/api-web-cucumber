package webauto.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import webauto.BasePageObject;

public class PageHooks extends BasePageObject {

    @Before
    public void beforeTest() {
        getDriver();
    }

    @After
    public void afterTest() {
        driver.close();
    }
}
