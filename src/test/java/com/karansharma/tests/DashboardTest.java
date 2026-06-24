package com.karansharma.tests;

import com.karansharma.base.BaseDriver;
import com.karansharma.pages.DashboardPage;
import com.karansharma.pages.LoginPage;
import com.karansharma.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseDriver {

    private void doLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
    }

    @Test(description = "Dashboard should display Products as page title")
    public void testDashboardTitleVisible() {
        doLogin();
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertEquals(dashboard.getPageTitle(), "Products",
                "Dashboard title should be Products");
    }

    @Test(description = "Cart icon should be visible on dashboard")
    public void testCartIconVisible() {
        doLogin();
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isCartIconVisible(),
                "Cart icon should be visible after login");
    }

    @Test(description = "Dashboard should display 6 inventory items")
    public void testInventoryItemCount() {
        doLogin();
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertEquals(dashboard.getInventoryItemCount(), 6,
                "Dashboard should display exactly 6 products");
    }

    @Test(description = "Adding backpack to cart should update cart badge to 1")
    public void testAddToCart() {
        doLogin();
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.addBackpackToCart();
        Assert.assertEquals(dashboard.getCartBadgeCount(), "1",
                "Cart badge should show 1 after adding backpack");
    }
}