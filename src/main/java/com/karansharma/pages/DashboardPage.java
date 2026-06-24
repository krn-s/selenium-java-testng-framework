package com.karansharma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By pageTitle      = By.cssSelector("[data-test='title']");
    private By cartIcon       = By.cssSelector("[data-test='shopping-cart-link']");
    private By inventoryItems = By.cssSelector("[data-test='inventory-item-name']");
    private By addToCartBtn   = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    private By cartBadge      = By.cssSelector("[data-test='shopping-cart-badge']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return driver.findElement(pageTitle).getText();
    }

    public boolean isCartIconVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon));
        return driver.findElement(cartIcon).isDisplayed();
    }

    public int getInventoryItemCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryItems));
        List<WebElement> items = driver.findElements(inventoryItems);
        return items.size();
    }

    public String getFirstItemName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryItems));
        return driver.findElement(inventoryItems).getText();
    }

    public void addBackpackToCart() {
        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(addToCartBtn)
        );
        btn.click();

        // Wait for Remove button to appear — confirms item was added successfully
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("[data-test='remove-sauce-labs-backpack']")
        ));
    }

    public String getCartBadgeCount() {
        // Badge appears in DOM only after item added — use presenceOfElement not visibility
        wait.until(ExpectedConditions.presenceOfElementLocated(cartBadge));
        return driver.findElement(cartBadge).getText();
    }
}