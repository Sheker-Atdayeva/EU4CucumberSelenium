package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class ContactsStepDefs {


    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> expectedOptions) {
        System.out.println("menuOptions.size" + expectedOptions.size());
        System.out.println(expectedOptions);
        List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);
        Assert.assertEquals(expectedOptions, actualOptions);
        System.out.println("actualOptions = " + actualOptions);
        System.out.println("expectedOptions = " + expectedOptions);
    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userInfo) {
        String username = userInfo.get("username");
        String password = userInfo.get("password");
        new LoginPage().login(username,password);
        String expectedName = userInfo.get("firstname");
        String expectedlastname = userInfo.get("lastname");

        Assert.assertEquals(expectedName + " " + expectedlastname,new DashboardPage().getUserName());

    }

}
