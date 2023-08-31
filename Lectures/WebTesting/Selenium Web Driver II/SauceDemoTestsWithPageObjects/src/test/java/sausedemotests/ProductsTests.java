package sausedemotests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ProductsTests extends BaseTest {
    @BeforeEach
    public void beforeTest(){
        loginPage.navigate();
        loginPage.fillLoginForm("standard_user", "secret_sauce");
        inventoryPage.waitForPageTitle();
    }

    @Test
    public void productAddedToShoppingCart_when_addToCart(){

        String backpackTitle = "Sauce Labs Backpack";
        String shirtTitle = "Sauce Labs Bolt T-Shirt";

        inventoryPage.addProductByTitle(backpackTitle);
        inventoryPage.addProductByTitle(shirtTitle);

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        var items = driver.findElements(By.className("inventory_item_name"));

        Assertions.assertEquals(2, items.size(), "Items count not as expected");

        Assertions.assertEquals(backpackTitle, items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(shirtTitle, items.get(1).getText(), "Item title not as expected");
    }

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation(){
        String backpackTitle = "Sauce Labs Backpack";
        String shirtTitle = "Sauce Labs Bolt T-Shirt";
        inventoryPage.addProductByTitle(backpackTitle);
        inventoryPage.addProductByTitle(shirtTitle);

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        driver.findElement(By.id("checkout")).click();

        // fill form
        fillShippingDetails("Fname", "lname", "zip");

        driver.findElement(By.id("continue")).click();

        var items = driver.findElements(By.className("inventory_item_name"));
        Assertions.assertEquals(2, items.size(), "Items count not as expected");

        var total = driver.findElement(By.className("summary_total_label")).getText();
        double expectedPrice = 29.99 + 15.99 + 3.68;
        String expectedTotal = String.format("Total: $%.2f", expectedPrice);

        Assertions.assertEquals(2, items.size(), "Items count not as expected");
        Assertions.assertEquals(backpackTitle, items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(shirtTitle, items.get(1).getText(), "Item title not as expected");
        Assertions.assertEquals(expectedTotal, total, "Items total price not as expected");
    }

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm(){
        // Add Backpack and T-shirt to shopping cart

        // Click on shopping Cart

        // Fill Contact Details

        // Complete Order

        // Assert Items removed from Shopping Cart
    }
}