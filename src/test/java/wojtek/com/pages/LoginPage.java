package wojtek.com.pages;

import com.microsoft.playwright.options.AriaRole;

public class LoginPage extends BasePage{

    public LoginPage enterUserName(String name){
        page.getByPlaceholder("Username").fill(name);
        return this;
    }

    public LoginPage enterPassword(String name){
        page.getByPlaceholder("Password").fill(name);
        return this;
    }

    public void clickSignIn(){
        page.getByRole(AriaRole.BUTTON).click();
    }

    public void aa(){

    }
}
