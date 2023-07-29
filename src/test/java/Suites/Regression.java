package Suites;

import infra.Common.Common;
import infra.Common.Config;
import infra.YoutubeCom.MainPage;
import org.junit.jupiter.api.*;

public class Regression {
    private static String startURL = "";
    private static String environment = "";
    private static Common common = null;

    //To run suites in parallel
    //mvn clean test -Dtest=Suites.Sanity,Suites.Regression

    @BeforeAll
    public static void setup(){
        startURL = Config.getProperty("start.url");
        environment = System.getenv("environment");

        common = new Common();
    }

    @BeforeEach
    public void init(){
        common.LaunchBrowser(Common.Browser.CHROME);
    }

    @Test
    void test_2(){

        common.NavigateTo("https://www.youtube.com/");

        common.Await(5);

        MainPage mainPage = new infra.YoutubeCom.MainPage(common);

        mainPage.verifyMainPage();

        mainPage.setSearchText("hello");

        mainPage.clickSearchButton();

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
