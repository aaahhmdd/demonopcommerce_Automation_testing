package org.example.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Objects;


import org.openqa.selenium.interactions.Actions;


public class P03_homePage {

    WebDriver driver;

    // Locators F03
    private final By currencyDropdown = By.cssSelector("select[id=\"customerCurrency\"]");
    private final By EuroCurrency = By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]");
    private final By productPrices = By.cssSelector("div[class=\"prices\"]");//span[class="price actual-price"]
    // locators F04
    private final By searchBox = By.cssSelector("input[type=\"text\"]");
    private final By searchButton = By.cssSelector("button[class=\"button-1 search-box-button\"]");
    private final By searchResult = By.cssSelector("div[class=\"item-grid\"]");//div[class="product-item"]
    private final By firstSearchResult = By.cssSelector("div[class=\"product-item\"]");

    private String searchKeyword;

    // Locators F05
    private final By firstSliderShow = By.linkText("1");
    private final By secondSliderShow = By.linkText("2");
    private final By slider = By.cssSelector("div[id=\"nivo-slider\"]");

    // locators F06
    private final By facebook = By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]");
    private final By twitter = By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]");
    private final By rss = By.cssSelector("a[href=\"/news/rss/1\"]");
    private final By youtube = By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]");

    // locators F07
    private final By HTCWishList = By.cssSelector("div[data-productid=\"18\"] button[class=\"button-2 add-to-wishlist-button\"]");
    private final By msg = By.cssSelector("div[class=\"bar-notification success\"]");
    private final By closeMsg = By.cssSelector("span[class=\"close\"]");
    private final By wishlistTab = By.cssSelector("a[class=\"ico-wishlist\"]");
    private final By quantity = By.cssSelector("input[name=\"itemquantity11270\"]");

    // locators F08
    private final By mainCategoriesLocator = By.xpath("//ul[@class=\"top-menu notmobile\"]/li");
    private final By pageTitle = By.cssSelector("div[class=\"page-title\"]");


    // Constructor
    public P03_homePage(WebDriver driver) {
        this.driver = driver;
    }

    // page actions F03
    public void selectCurrency(String currency) {
        driver.findElement(currencyDropdown).click();
        driver.findElement(EuroCurrency).click();
    }
    public List<WebElement> getProductPrices() {
        return driver.findElements(productPrices);
    }

    // page actions F04
    public List<WebElement> getSearchResults() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElements(searchResult);
    }

    public void clickOnFirstSearchResult() {
        driver.findElement(firstSearchResult).click();
    }

    public void searchForProduct(String product) {
        searchKeyword = product;
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }

    public void searchForSKU(String sku) {
        searchKeyword = sku;
        driver.findElement(searchBox).sendKeys(sku);
        driver.findElement(searchButton).click();
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public String getProductSKU() {
        WebElement skuElement = driver.findElement(By.tagName("img"));
        return skuElement.getText();
    }

    // page actions F05
    // Click on the first slider
    public void clickFirstSlider() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(firstSliderShow).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(slider).click();
    }
    // Click on the second slider
    public void clickSecondSlider() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(secondSliderShow).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(slider).click();
    }

    // page actions F06
    public void clickOnFaceBook() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(facebook).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnTwitter() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(twitter).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnRss() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(rss).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnYoutube() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(youtube).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // page actions F07
    public By getSuccessMessage() {
        return this.msg;
    }

    public void clickOnHtcWishList() {
        driver.findElement(HTCWishList).click();
    }

    public String showMsg() {
        return driver.findElement(msg).getText().toLowerCase().trim();
    }

    public String getColorMsg() {
        return driver.findElement(closeMsg).getCssValue("background-color");
    }

    public void clickOnWishlistTab() {
        driver.findElement(wishlistTab).click();
    }

    public int getQuantity() {
        return Integer.parseInt(Objects.requireNonNull(driver.findElement(quantity).getAttribute("value")));
    }

    // page actions F08
    // Get the title of the sub-category page
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    int count = 7;
    int selectedCategory = 0;
    int min = 0;
    int max = count - 1;

    // Hover on a random main category
    public String hoverOnMainCategory() {
        Actions actions = new Actions(driver);
        List<WebElement> mainLinks = driver.findElements(mainCategoriesLocator);
        int count = mainLinks.size();
        System.out.println("count is " + count);
        int min = 0;
        int max = count - 1;
        selectedCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
        actions.moveToElement(mainLinks.get(selectedCategory)).perform();
        String selectedCategoryText = mainLinks.get(selectedCategory).getText();
        System.out.println("to know which category is selected:   " + selectedCategoryText);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return selectedCategoryText;
    }

    // Store sub-categories for a given main category
    public List<WebElement> storeSubCategoriesForCategory() {
        selectedCategory = selectedCategory + 1;
        String locator = "(//ul[@class='top-menu notmobile']//ul)[" + selectedCategory + "]/li";
        List<WebElement> subCategoryLinks = driver.findElements(By.xpath(locator));
        return subCategoryLinks;
    }


    // Select a random sub-category and click on it
    public String selectRandomSubCategory(List<WebElement> subCategoryLinks) {
        String selectedSubCategoryText;


        int subCategoryCount = subCategoryLinks.size();
        System.out.println("profile links " + subCategoryCount);
        System.out.println(subCategoryLinks.get(0).getText());
        System.out.println(subCategoryLinks.get(1).getText());
        System.out.println(subCategoryLinks.get(2).getText());
        int selectedSubCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
        selectedSubCategoryText = subCategoryLinks.get(selectedSubCategory).getText();
        subCategoryLinks.get(selectedSubCategory).click();

        return selectedSubCategoryText;
    }

}
