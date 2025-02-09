package webauto.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webauto.BasePageObject;
import webauto.page.HomePage;
import webauto.page.LoginPage;

public class LoginStepdef extends BasePageObject {

    HomePage home;
    LoginPage login;

    @Given("user is on homepage")
    public void userIsOnHomepage() {
        home = new HomePage(driver);
        home.goToHomepage();
    }

    @And("user click login on navigation tab")
    public void userClickLoginOnNavigationTab() {
        home.clickLoginTab();
        login = new LoginPage(driver);
    }

    @And("user input username with {string}")
    public void userInputUsernameWith(String username) {
        login.inputUsername(username);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        login.inputPassword(password);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        login.clickLogin();
    }

    @Then("button logout will appear")
    public void buttonLogoutWillAppear() {
        home.verifyLogoutTabAppear();
    }

    @And("user click logout button")
    public void userClickLogoutButton() {
        home.clickLogoutTab();
    }

    @Then("popup will appear and show error message")
    public void popupWillAppearAndShowErrorMessage() {
        login.verifyErrorPassword();
    }
}
