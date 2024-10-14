package factory;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

import utils.WebActions;

public class DriverFactory {
    public Browser browser;
    public static BrowserContext context;
    public static Page page;

    public static ThreadLocal<Page> threadLocalDriver = new ThreadLocal<>(); //For Parallel execution
    public static ThreadLocal<BrowserContext> threadLocalContext = new ThreadLocal<>();
    
    //Launches Browser as set by user in config file
    public Page initDriver(String browserName) {
        BrowserType browserType = null;
        
        // determine launch options
        boolean headless = Boolean.valueOf(WebActions.getProperty("headless"));
        int slowMo = Integer.valueOf(WebActions.getProperty("slowmo"));
                
        switch (browserName) {
            case "firefox":
                browserType = Playwright.create().firefox();
                browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(slowMo));
                break;
            case "chrome":
                browserType = Playwright.create().chromium();
                browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(slowMo));
                break;
            case "webkit":
                browserType = Playwright.create().webkit();
                browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(slowMo));
                break;
        }
        if (browserType == null) throw new IllegalArgumentException("Could not Launch Browser for type" + browserType);
        context = browser.newContext();
        
        // if fullscreen
        boolean fullscreen = Boolean.valueOf(WebActions.getProperty("fullscreen"));
        if(fullscreen) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int) screenSize.getWidth();
            int height = (int) screenSize.getHeight();
            
            context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));        	
        } else context = browser.newContext();
        	    
        //Below line is used to start the trace file
        context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(false));
        page = context.newPage();
        threadLocalDriver.set(page);
        threadLocalContext.set(context);
        return page;
    }

    public static synchronized Page getPage() {
        return threadLocalDriver.get(); // Will return Initialized Thread Local Driver
    }

    public static synchronized BrowserContext getContext() {
        return threadLocalContext.get(); // Will return Initialized Thread Local Context
    }

}
