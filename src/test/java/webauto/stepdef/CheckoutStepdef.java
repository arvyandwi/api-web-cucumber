package webauto.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webauto.BasePageObject;
import webauto.page.CartPage;
import webauto.page.HomePage;
import webauto.page.NavigationBar;
import webauto.page.ProductDetailPage;

public class CheckoutStepdef extends BasePageObject {

    NavigationBar navbar;
    HomePage home;
    ProductDetailPage detail;
    CartPage cart;
    String getItemName;
    String getItemPrice;

    @And("user click the product")
    public void userClickTheProduct() throws InterruptedException {
        home = new HomePage(driver);
        this.getItemName = home.getItemName();
        this.getItemPrice = home.getItemPrice();
        home.selectItem();
    }

    @And("verify it's the product")
    public void verifyItsTheProduct() throws InterruptedException {
        detail = new ProductDetailPage(driver);
        detail.verifyProductName(this.getItemName);
        detail.verifyProductPrice(this.getItemPrice);
    }

    @And("click add cart")
    public void clickAddCart() {
        detail.clickAddCart();
    }

    @And("verify popup and confirm")
    public void verifyPopupAndConfirm() {
        detail.verifySuccessAddToCart();
    }

    @And("user click navbar cart")
    public void userClickNavbarCart() {
        navbar = new NavigationBar(driver);
        navbar.clickCart();
    }

    @And("verify product cart is correct")
    public void verifyProductCartIsCorrect() throws InterruptedException {
        cart = new CartPage(driver);
        cart.verifyProductName(this.getItemName);
        cart.verifyProductPrice(this.getItemPrice);
    }

    @When("user click place order")
    public void userClickPlaceOrder() {
        cart.clickPlaceOrder();
    }

    @And("user input all mandatory payment details")
    public void userInputAllMandatoryPaymentDetails() throws InterruptedException {
        Thread.sleep(5000);
        cart.inputName();
        cart.inputCountry();
        cart.inputCity();
        cart.inputCardNumber();
        cart.inputMonth();
        cart.inputYear();
    }

    @And("user click checkout")
    public void userClickCheckout() {
        cart.clickPurchase();
    }

    @Then("user successfully checkout the product")
    public void userSuccessfullyCheckoutTheProduct() {
        cart.verifySucessfulCheckout();
    }

    @And("click confirm")
    public void clickConfirm() throws InterruptedException {
        Thread.sleep(5000);
        cart.clickConfirmPopup();
    }

    @When("user click delete product")
    public void userClickDeleteProduct() throws InterruptedException {
        cart.clickDeleteProduct();
        Thread.sleep(5000);
    }

    @Then("verify cart is empty")
    public void verifyCartIsEmpty() {
        cart.verifyCartIsEmpty();
    }
}
