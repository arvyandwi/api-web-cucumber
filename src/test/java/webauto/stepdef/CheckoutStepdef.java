package webauto.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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

    @Given("user click the product and click add cart")
    public void userClickTheProductAndClickAddCart() throws InterruptedException {
        home = new HomePage(driver);

        /* Get Product Details */
        this.getItemName = home.getItemName();
        this.getItemPrice = home.getItemPrice();

        /* Select The Product */
        home.selectItem();

        detail = new ProductDetailPage(driver);

        /* Verify The Product */
        detail.verifyProductName(this.getItemName);
        detail.verifyProductPrice(this.getItemPrice);

        /* Add To Cart */
        detail.clickAddCart();
    }

    @And("verify popup confirm and verify product cart is correct")
    public void verifyPopupConfirmAndVerifyProductCartIsCorrect() throws InterruptedException {
        /* Verify Success Add To Cart */
        detail.verifySuccessAddToCart();

        navbar = new NavigationBar(driver);

        /* Click Cart On Navigation Bar */
        navbar.clickCart();

        cart = new CartPage(driver);

        /* Verify The Product */
        cart.verifyProductName(this.getItemName);
        cart.verifyProductPrice(this.getItemPrice);
    }

    @When("user click place order")
    public void userClickPlaceOrder() {
        cart.clickPlaceOrder();
    }

    @And("user input all mandatory payment details and checkout")
    public void userInputAllMandatoryPaymentDetailsAndCheckout() throws InterruptedException {
        Thread.sleep(5000);

        /* Input All Mandatory Payment Details */
        cart.inputName();
        cart.inputCountry();
        cart.inputCity();
        cart.inputCardNumber();
        cart.inputMonth();
        cart.inputYear();

        /* Checkout */
        cart.clickPurchase();
    }

    @Then("user successfully checkout the product")
    public void userSuccessfullyCheckoutTheProduct() throws InterruptedException {
        cart.verifySucessfulCheckout();
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
