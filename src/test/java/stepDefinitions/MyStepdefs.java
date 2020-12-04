package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.Master;

import static javaClasses.aboutProperty.*;
import static javaClasses.userInformation.*;

public class MyStepdefs extends Master {

    @Given("^the user is on the policy enquiry page$")
    public void theUserIsOnThePolicyEnquiryPage() {
        enquiryPage();
    }

    @When("^the user's personal information such as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" is entered$")
    public void theUserSPersonalInformationSuchAsIsEntered(String title, String fName, String LName, String MaritalStatus, String smoking) throws Throwable {
        AboutYou(title,fName,LName,MaritalStatus,smoking);
    }

    @Then("^details should get saved successfully$")
    public void detailsShouldGetSavedSuccessfully() {
        System.out.println("Information are entered successfully");
    }


    @When("^the user select statement option as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void theUserSelectStatementOptionAs(String isAgree, String businessPurpose, String bankrupt, String judgement, String renewalCancellation, String HomeIncCancelled, String convicted) throws Throwable {
        statementsAboutYou(isAgree,businessPurpose,bankrupt,judgement,renewalCancellation,HomeIncCancelled,convicted);
    }


    @When("^the user enter the property information as \"([^\"]*)\" \"([^\"]*)\"$")
    public void theUserEnterThePropertyInformationAs(String address, String propertyType) throws Throwable {
        aboutYourProperty(address,propertyType);
    }
    
    @And("^the user enter the personal information, property information,Insurance history, Cover details$")
    public void theUserEnterThePersonalInformationPropertyInformationInsuranceHistoryCoverDetails() throws InterruptedException {
        AboutYou("mr","Dinesh","Mariathas","married","No");
        statementsAboutYou("I agree","I agree","I agree","I agree","I agree","I agree","I agree");
        aboutYourProperty("Greenford","house");
        StatementsAboutYourProperty();
        SafetyAndSecurity();
        jointPolicyHolder();
        aboutInsuranceHistory();
        AboutTheCover();

    }

    @When("^the user select the go compare quotes$")
    public void theUserSelectTheGoCompareQuotes() {
        //selectGoCompareButton();

    }

    @Then("^quote details should be retrieved successfully$")
    public void quoteDetailsShouldBeRetrievedSuccessfully() {
    }
}
