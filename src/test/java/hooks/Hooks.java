package hooks;

import common.Common;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Common {

    @Before (value = "@Chrome")
    public void startChrome () {
        startBrowser();
    }

    @Before (value = "@ChromeHeadless")
    public void ChromeHeadless () {
        startBrowserHeadless();
    }

    @After (value = "@Chrome")
    public void stopChrome (){
//        stopBrowser();
    }

    @After (value = "@ChromeHeadless")
    public void stopChromeHeadless (){
        stopBrowserHeadless();
    }
}
