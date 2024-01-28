package cucumber.steps;

import br.com.mandacaru.livecodebdd.controller.ProductController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class DeleteProduct {

    ProductController products = new ProductController();
    @Given("The store already has registered many products")
    public void theStoreAlreadyHasRegisteredManyProducts() {
        products.addRegisteredProduct("Mouse");
        products.addRegisteredProduct("Keybord");
        products.addRegisteredProduct("Headset");
        products.addRegisteredProduct("Power Bank");
    }

    @And("The product {string} is registered in the store")
    public void theProductIsRegisteredInTheStore(String product) {

        assertTrue("The product {string} is registered in the store",
                products.isProductRegistered(product));
    }

    @When("The user deletes the product {string} from the store")
    public void theUserDeletesTheProductFromTheStore(String product) {
        products.deleteProduct(product); //already returns the boolean so you don't need the assert
    }

    @Then("The product {string} should be removed from the store")
    public void theProductShouldBeRemovedFromTheStore(String product) {
        assertFalse("The product {string} should be removed from the store",
                products.isProductRegistered(product));
    }

//    @And("The store should have four less product")
//    public void theStoreShouldHaveThreeLessProduct() {
//        assertTrue("the store must have 1 less product", products.getProductCount() < 4);
//    }

    @And("the store must have {int} less product")
    public void theStoreMustHaveLessProduct(int product) {
        assertTrue("the store must have {int} less product",products.getProductCount() < products.getAllProducts().size() );
    }
}
