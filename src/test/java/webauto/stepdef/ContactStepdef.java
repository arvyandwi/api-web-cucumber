package webauto.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webauto.BasePageObject;
import webauto.page.ContactPage;
import webauto.page.NavigationBar;

public class ContactStepdef extends BasePageObject {

    NavigationBar navbar;
    ContactPage contact;

    @And("user click contact on navigation tab")
    public void userClickContactOnNavigationTab() throws InterruptedException {
        navbar = new NavigationBar(driver);
        Thread.sleep(5000);
        navbar.clickContact();
    }

    @When("user input all contact info")
    public void userInputAllContactInfo() throws InterruptedException {
        Thread.sleep(5000);
        contact = new ContactPage(driver);
        contact.inputEmail();
        contact.inputContactName();
        contact.inputTextMessage();
    }

    @And("user click send")
    public void userClickSend() {
        contact.clickSend();
    }

    @Then("user successfully send message and popup will appear")
    public void userSuccessfullySendMessageAndPopupWillAppear() {
        contact.verifySuccessSendMessage();
    }
}
