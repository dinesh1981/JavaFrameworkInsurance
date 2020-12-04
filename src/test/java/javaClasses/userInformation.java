package javaClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Master;

import java.util.List;

public class userInformation extends Master {

    public static void enquiryPage() {
        driver.navigate().to((p.getProperty("url")));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector((p.getProperty("FirstName")))));
    }

    public static void AboutYou(String title, String fName, String lName, String maritalStatus, String buttonSelection) throws InterruptedException {

        List<WebElement> firstName = driver.findElements(By.cssSelector(p.getProperty("FirstName")));
        if (isWebElementExist(firstName)) {
            waitForVisibility(driver.findElement(By.cssSelector(p.getProperty("Title"))));
            selectByMethod(driver.findElement(By.cssSelector(p.getProperty("Title")))).selectByValue(title);

            driver.findElement(By.cssSelector(p.getProperty("FirstName"))).sendKeys(fName);
            driver.findElement(By.cssSelector(p.getProperty("LastName"))).sendKeys(lName);

            selectByMethod(driver.findElement(By.cssSelector(p.getProperty("DayDropDown")))).selectByIndex(2);
            selectByMethod(driver.findElement(By.cssSelector(p.getProperty("MonthDropDown")))).selectByIndex(2);
            selectByMethod(driver.findElement(By.cssSelector(p.getProperty("YearDropDown")))).selectByValue("1985");
            selectByMethod((driver.findElement(By.cssSelector(p.getProperty("MaritalStatus"))))).selectByValue(maritalStatus);

            driver.findElement(By.xpath(p.getProperty("Occupation"))).sendKeys("Computer Engineer");
            shortSleep();
            driver.findElement(By.xpath(p.getProperty("Occupation"))).sendKeys(Keys.ARROW_DOWN);
            if (buttonSelection.equalsIgnoreCase("yes")) {
                driver.findElement(By.xpath(p.getProperty("AnyBodySmokeYes"))).click();
            } else {
                driver.findElement(By.xpath(p.getProperty("AnyBodySmokeNo"))).click();
            }
            driver.findElement(By.cssSelector(p.getProperty("Telephone"))).sendKeys("07474747474");
            driver.findElement(By.cssSelector(p.getProperty("Email"))).sendKeys("test@mailinator.com");
        }

    }


    public static boolean AgreeOrDisagree(String statement, String agreeXpath, String disagreeXpath) {
        boolean isAgree;
        if (statement.equalsIgnoreCase("I Agree")) {
            driver.findElement(By.xpath(agreeXpath)).click();
            isAgree = true;
        } else {
            driver.findElement(By.xpath(disagreeXpath)).click();
            isAgree = false;
        }
        return isAgree;
    }

    public static void statementsAboutYou(String isAgree, String businessPurpose, String bankrupt, String judgement, String renewalRefused, String homeIncCancelled, String Convicted) {

        if (isAgree.equalsIgnoreCase("I agree")) {
            driver.findElement(By.xpath(p.getProperty("StatAbtYouAgree"))).click();
        } else {
            driver.findElement(By.xpath(p.getProperty("StatAbtYouDisagree"))).click();

            if (!AgreeOrDisagree(businessPurpose, p.getProperty("BusinessPurposeAgree"), p.getProperty("BusinessPurposeDisagree"))) {
                selectByMethod((driver.findElement(By.cssSelector("div[class='row question-row-what-type-of-busines'] select")))).selectByIndex(2);
                selectByMethod((driver.findElement(By.cssSelector("div[class='row question-row-number-of-employees'] select")))).selectByIndex(4);
                selectByMethod((driver.findElement(By.xpath("//select[@data-di-id='di-id-95367377-62d69f5f']")))).selectByIndex(2);
            }

            if(!AgreeOrDisagree(bankrupt, p.getProperty("BankruptAgree"), p.getProperty("BankruptDisagree"))){
                selectByMethod((driver.findElement(By.cssSelector("div[class='row question-row-is-the-bankruptcy-ty'] select")))).selectByIndex(1);
                driver.findElement(By.xpath("(//div[@class='row question-row-has-this-been-discha']//button)[2]")).click();
            }

            if(!AgreeOrDisagree(judgement, p.getProperty("CourtJudgementAgree"), p.getProperty("CourtJudgementDisagree"))){
                selectByMethod((driver.findElement(By.cssSelector("div[class='row question-row-how-many-cc-js-have'] select")))).selectByIndex(2);
            }

            AgreeOrDisagree(renewalRefused, p.getProperty("RenewalRefusedAgree"), p.getProperty("RenewalRefusedDisagree"));
            AgreeOrDisagree(homeIncCancelled, p.getProperty("HomeIncCancellationAgree"), p.getProperty("HomeIncCancellationDisagree"));
            AgreeOrDisagree(Convicted, p.getProperty("ConvictedAgree"), p.getProperty("ConvictedDisagree"));

        }

    }
}
