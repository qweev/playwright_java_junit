package wojtek.com.pages;

import com.microsoft.playwright.Page;
import wojtek.com.BaseChromeTest;

public class BasePage {
    Page page = null;

    public BasePage(){
        page = BaseChromeTest.page;
    }

    // common methods for all pages

}
