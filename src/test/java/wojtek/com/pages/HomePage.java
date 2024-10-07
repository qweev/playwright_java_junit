package wojtek.com.pages;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class HomePage extends BasePage{

    public String getLoggedUserName(){
        String user = page.locator("//button[@aria-label='Account Summary Button']/span/span").innerText(); // xpath locator

        System.out.println("!!! logged in user " + user);

        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("videos/screenshot.png")));

        return user;
    }

}
