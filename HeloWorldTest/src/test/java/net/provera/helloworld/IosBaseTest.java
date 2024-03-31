package net.provera.helloworld;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class IosBaseTest {
    public IOSDriver driver;
    public AppiumDriverLocalService service;

    @BeforeEach
    public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("//opt//homebrew//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();
        service.start();

        XCUITestOptions options= new XCUITestOptions();
       // options.setDeviceName("iPhone 15 Pro");
        options.setPlatformName("iOS");
        options.setDeviceName("iPhone 15 Pro");
        options.setApp("//Users//yusufsahin//Projects//Appium//HeloWorldTest//src//test//resources//UIKitCatalog.app");
        options.setPlatformVersion("17.4");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
