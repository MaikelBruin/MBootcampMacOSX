package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.ExtendedPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SpecialPage;

public class ExtendedTest extends TestShopScenario {

    String emailForAssignment = "maikel@bruin.com";
    String pwdForAssignment = "1qazxsw2";

    @Test
    public void extendedPageTest() {
        //init
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(emailForAssignment, pwdForAssignment);

        ExtendedPage extendedPage = new ExtendedPage(driver);

        extendedPage.goToSpecials();

        SpecialPage specialPage = new SpecialPage(driver);
        String headerText = specialPage.getHeaderText();

        Assertions.assertThat(headerText).as("faal").containsIgnoringCase("Price drop");

    }

    @Test
    public void extendedPageButtonsTest() {
        //init
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(emailForAssignment, pwdForAssignment);

        ExtendedPage extendedPage = new ExtendedPage(driver);

        extendedPage.specialButton.click();

        SpecialPage specialPage = new SpecialPage(driver);
        String headerText = specialPage.headerText.getText();

        Assertions.assertThat(headerText).as("faal").containsIgnoringCase("Price drop");
    }

    @Test
    public void extendedPagePagesTest() {
        //init
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(emailForAssignment, pwdForAssignment);

        ExtendedPage extendedPage = new ExtendedPage(driver);

        SpecialPage specialPage = extendedPage.goToSpecialPage();

        String headerText = specialPage.getHeaderText();

        Assertions.assertThat(headerText).as("faal").containsIgnoringCase("Price drop");

    }
}
