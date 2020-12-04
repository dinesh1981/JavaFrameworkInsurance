package javaClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Master;

public class aboutProperty extends Master {

    public static void aboutYourProperty(String propertyAddress,String propertyType){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.findElement(By.cssSelector(p.getProperty("AddressOfProperty"))).sendKeys(propertyAddress);
        shortSleep();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-testid='enter-address']")));
        driver.findElement(By.cssSelector(p.getProperty("AddressOfProperty"))).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector(p.getProperty("AddressOfProperty"))).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-di-id='di-id-debf71c4-5b09475c']")));
        driver.findElement(By.xpath(p.getProperty("CorrespondenceAddressSame"))).click();

        if(propertyType.equalsIgnoreCase("house"))
            propertyTypeHouse(propertyType);

        if(propertyType.equalsIgnoreCase("flat_apartment"))
            propertyTypeFlat(propertyType);

        if(propertyType.equalsIgnoreCase("bungalow"))
            propertyTypeHouse(propertyType);

        if(propertyType.equalsIgnoreCase("other"))
            propertyTypeHouse(propertyType);

    }

    public static void propertyTypeHouse(String propertyType){
        selectByMethod(driver.findElement(By.cssSelector(p.getProperty("TypeOfProperty")))).selectByValue(propertyType);
        selectByMethod(driver.findElement(By.cssSelector("div[class='row question-row-which-of-these-best'] select"))).selectByIndex(1);
        driver.findElement(By.cssSelector("div[class='row question-row-approximately-in-whi'] input")).sendKeys("1988");
        selectByMethod(driver.findElement(By.cssSelector(p.getProperty("Rooms")))).selectByIndex(1);
        selectByMethod(driver.findElement(By.cssSelector(p.getProperty("propertyOwnership")))).selectByIndex(1);
        selectByMethod(driver.findElement(By.cssSelector(p.getProperty("propertyOccupied")))).selectByIndex(1);
        selectByMethod(driver.findElement(By.cssSelector(p.getProperty("whenOccupied")))).selectByIndex(1);
        driver.findElement(By.xpath(p.getProperty("trees"))).click();
        driver.findElement(By.xpath(p.getProperty("flatRoof"))).click();
    }

    public static void propertyTypeFlat(String propertyType){
        selectByMethod(driver.findElement(By.cssSelector(p.getProperty("TypeOfProperty")))).selectByValue(propertyType);
        selectByMethod(driver.findElement(By.cssSelector("div[class='row question-row-which-of-these-best'] select"))).selectByIndex(1);
        driver.findElement(By.xpath("(//div[@class='row question-row-are-there-more-than']//button)[2]")).click();
        driver.findElement(By.xpath("(//div[@class='row question-row-are-there-more-than'])[2]//button[2]")).click();

        driver.findElement(By.cssSelector("div[class='row question-row-approximately-in-whi'] input")).sendKeys("1988");
        selectByMethod(driver.findElement(By.cssSelector(p.getProperty("Rooms")))).selectByIndex(1);
        selectByMethod(driver.findElement(By.cssSelector(p.getProperty("propertyOwnership")))).selectByIndex(1);
        selectByMethod(driver.findElement(By.cssSelector(p.getProperty("propertyOccupied")))).selectByIndex(1);
        selectByMethod(driver.findElement(By.cssSelector(p.getProperty("whenOccupied")))).selectByIndex(1);
        driver.findElement(By.xpath(p.getProperty("trees"))).click();
        driver.findElement(By.xpath(p.getProperty("flatRoof"))).click();
    }



    public static void StatementsAboutYourProperty(){
        driver.findElement(By.xpath("(//div[@class='row question-row-do-you-agree-with-th'])[2]//div[@class='btn-group']/button[1]")).click();
    }

    public static void SafetyAndSecurity(){
        driver.findElement(By.xpath(p.getProperty("Locks"))).click();
        driver.findElement(By.xpath(p.getProperty("LockableEntrance"))).click();
        driver.findElement(By.xpath(p.getProperty("PatioDoor"))).click();
        driver.findElement(By.xpath(p.getProperty("ExternalDoor"))).click();
        driver.findElement(By.xpath(p.getProperty("BurglarAlaram"))).click();
    }

    public static void jointPolicyHolder(){
        driver.findElement(By.xpath("//div[@class='row question-row-would-you-like-to-ad']//button[2]"));
    }

    public static void aboutInsuranceHistory(){
        selectByMethod(driver.findElement(By.cssSelector("div[class='row question-row-how-many-consecutive'] select"))).selectByIndex(1);
        driver.findElement(By.xpath("//div[@class='row question-row-in-the-past-3-years']//button[2]")).click();
    }

    public static void AboutTheCover(){
        driver.findElement(By.cssSelector("button[data-testid='today']")).click();
        selectByMethod(driver.findElement(By.cssSelector("div[class='row question-row-please-select-what-t'] select"))).selectByIndex(1);
        selectByMethod(driver.findElement(By.cssSelector("div[class='row question-row-standard-excess-oth'] select"))).selectByIndex(1);

    }

    public static void selectGoCompareButton(){
        driver.findElement(By.cssSelector("button[data-testid='submit']")).click();

    }
}
