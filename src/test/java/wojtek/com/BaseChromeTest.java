package wojtek.com;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Paths;
import java.util.List;

public class BaseChromeTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    public static Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                                                    .setArgs(List.of("--start-maximized")) //to open with max window, must be set in options and in context !!!
                                                    .setChannel("msedge")
                                                    .setHeadless(false);

        browser = playwright.chromium().launch(options);
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext(new Browser.NewContextOptions()
                                                    .setViewportSize(null) // to open with max window, must be set in options and in context !!!
                                                    .setIgnoreHTTPSErrors(true)
                                                    .setRecordVideoDir(Paths.get("videos"))
                                                    .setRecordVideoSize(640,480)
                                                    .setBaseURL("https://10.20.202.44"));



        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    public void openLoginPage(){
        page.navigate("/login");
    }

}
