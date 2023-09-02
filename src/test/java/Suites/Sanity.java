package Suites;

import infra.Common.Common;
import infra.Common.Config;
import infra.QaDocs.MainPage;
import org.junit.jupiter.api.*;


public class Sanity {
    private static String startURL = "";
    private static Common common = null;

    //To run suites in parallel
    //mvn clean test -Dtest=Suites.Sanity,Suites.Regression

    @BeforeAll
    public static void setup(){
        startURL = Config.getProperty("start.url");

        common = new Common();
    }

    @BeforeEach
    public void init(){

        common.LaunchBrowser(Common.Browser.CHROME);
    }

    @Test
    void test_1(){

        common.NavigateTo(startURL);

        common.Await(5);

        MainPage mainPage = new infra.QaDocs.MainPage(common);

        mainPage.verifyMainPage();

        mainPage.clickLetsBeginButton();

        common.Await(5);
    }

    @AfterEach
    public void teardown() {

        common.CloseBrowser();
    }

    @AfterAll
    public static void cleanup() {

    }
}
