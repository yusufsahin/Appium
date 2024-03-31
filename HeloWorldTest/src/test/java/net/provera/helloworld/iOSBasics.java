package net.provera.helloworld;

import org.junit.jupiter.api.Test;
import io.appium.java_client.AppiumBy;

public class iOSBasics extends IosBaseTest{

    @Test
    public void iOSBasicsTest() {
        //Xpath, classname, IOS, iosClassCHain, IOSPredicateString, accessibility id, id

        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        //Xpath -XMl language- App source
        //	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label =='Text Entry'`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello World");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        //	driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'"));
        //driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'"));
        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
        String text=	driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'")).getText();
        System.out.println(text);

        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();
    }
}
