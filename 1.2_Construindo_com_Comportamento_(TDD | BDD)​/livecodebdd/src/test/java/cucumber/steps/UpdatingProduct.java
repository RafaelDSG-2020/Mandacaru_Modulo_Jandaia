package cucumber.steps;

import br.com.mandacaru.livecodebdd.controller.ProductController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertFalse;
public class UpdatingProduct {

    ProductController products = new ProductController();
    @Given("The store already has registered any products")
    public void theStoreAlreadyHasRegisteredAnyProducts() {
        products.addRegisteredProduct("Phone");
        products.addRegisteredProduct("bottle");
        products.addRegisteredProduct("shoes");
        products.addRegisteredProduct("Lampad");
        products.addRegisteredProduct("Mouse");
    }

    @And("The product {string} was registered in the store")
    public void theProductWasRegisteredInTheStore(String product) {

        assertTrue("The product {string} was registered in the store",
                products.isProductRegistered(product));

    }

    @When("The user updates the product {string} to {string} in the store")
    public void theUserUpdatesTheProductToInTheStore(String oldProduct, String newProduct) {
        products.updateProduct(oldProduct,newProduct);
    }

    @Then("The product {string} should be in the store")
    public void theProductShouldBeInTheStore(String product) {
        assertTrue("The product {string} should be in the store"
                , products.isProductRegistered(product));
    }

    @And("The product {string} should no longer be in the store")
    public void theProductShouldNoLongerBeInTheStore(String product) {
        assertFalse("The product {string} should no longer be in the store"
                , products.isProductRegistered(product));
    }
}
