package webtests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
     static void configure(){
        Configuration.baseUrl ="https://alfabank.ru/";
    }
    @AfterEach
     void attachment(){
        Selenide.closeWebDriver();
    }
}
