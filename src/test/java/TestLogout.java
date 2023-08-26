
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.object.*;
public class TestLogout extends TestObject {

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{{"realtester", "123456", "realtester"}, //login with username
                {"realtester@yopmail.com", "123456", "realtester"}, //login with email
                {"adminmngr@yopmail.com", "123456", "adminmngr"} //login with admin user
                // the last 2 credentials should fail as they are invalid
        };
    }
    @Test (dataProvider = "getUsers")
    public void testLogoutAsRegisteredUserFromProfilePage(String username, String password, String name) {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();
        Header header = new Header(getDriver());
        header.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
        String signInText = loginPage.getSignInElementText();
        Assert.assertEquals(signInText, "Sign in");
        loginPage.populateUsername(username);
        loginPage.populatePassword(password);
        loginPage.clickSignInButton();

        HeaderRegisteredUser headerRegisteredUser = new HeaderRegisteredUser(getDriver());
        headerRegisteredUser.clickProfile();

        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(profilePage.isUrlLoaded(), "The Profile URL is not correct!");
        Assert.assertEquals(username, name, "The username is incorrect!");

        headerRegisteredUser.clickLogoutButton();

        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
    }

    @Test (dataProvider = "getUsers", priority = 1)
    public void testLogoutAsRegisteredUserFromPostPage(String username, String password, String name) {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();

        Header header = new Header(getDriver());
        header.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
        String signInText = loginPage.getSignInElementText();
        Assert.assertEquals(signInText, "Sign in");
        loginPage.populateUsername(username);
        loginPage.populatePassword(password);
        loginPage.clickSignInButton();

        HeaderRegisteredUser headerRegisteredUser = new HeaderRegisteredUser(getDriver());
        headerRegisteredUser.clickProfile();

        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(profilePage.isUrlLoaded(), "The Profile URL is not correct!");
        Assert.assertEquals(username, name, "The username is incorrect!");

        headerRegisteredUser.clickNewPost();

        PostPage postPage = new PostPage(getDriver());
        Assert.assertTrue(postPage.isUrlLoaded(), "The ProfileCreate URL is not correct!");

        headerRegisteredUser.clickLogoutButton();

        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
    }

    @Test (priority = 2)
    public void testLogoutFromHomePageAsGuestUser() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();

        Header header = new Header(getDriver());
        Assert.assertFalse(header.isLogoutButtonDisplayed(), "LogoutButton is displayed as Guest!");
    }
    @Test (priority = 3)
    public void testLogoutFromLoginPageAsGuestUser() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateTo();

        Header header = new Header(getDriver());
        Assert.assertFalse(header.isLogoutButtonDisplayed(), "LogoutButton is displayed as Guest!");
    }
    @Test (priority = 4)
    public void testLogoutAsRegisteredUserFromLoginPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();
        Header header = new Header(getDriver());
        header.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");

        Assert.assertFalse(header.isLogoutButtonDisplayed(), "LogoutButton is displayed as RegisteredUser!");
    }
}
