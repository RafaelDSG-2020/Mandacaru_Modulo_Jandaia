package cucumber.steps;

import br.com.mandacaru.livecodebdd.controller.ProductController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;




import static org.springframework.test.util.AssertionErrors.assertTrue;
//@CucumberContextConfiguration
public class AddProductsSteps {
    ProductController products  = new ProductController();
    @Given("The store already has registered products")
    public void theStoreAlreadyHasRegisteredProducts() {
        products = new ProductController();
        products.addRegisteredProduct("Smartphone");
        products.addRegisteredProduct("Headset");
    }

    @And("The store has fewer than {int} products")
    public void theStoreHasFewerThanProducts(int arg0) {
        assertTrue("The store has fewer than {int} products",
                products.getProductCount()<arg0);
    }

    @And("The product does not exist in the store")
    public void theProductDoesNotExistInTheStore() {
        assertTrue("The product does not exist in the store",
                !products.isProductRegistered("Power Bank"));
    }

    @When("The user is going to add a product to the store")
    public void theUserIsGoingToAddAProductToTheStore() {
        products.addRegisteredProduct("Power Bank");
    }

    @Then("The product must be added successfully")
    public void theProductMustBeAddedSuccessfully() {
        assertTrue("The product must be added successfully",
                products.isProductRegistered("Power Bank"));
    }
}
