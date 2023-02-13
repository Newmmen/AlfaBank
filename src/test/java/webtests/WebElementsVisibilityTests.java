package webtests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import enums.CreditTermCurrency;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

public class WebElementsVisibilityTests extends BaseTest {

    @ValueSource(strings = {
            "Карты",
            "Вклады",
            "Кредиты",
            "Ипотека",
            "Инвестиции",
            "Премиум",
            "Ещё"
    })
    @ParameterizedTest
    public void checkMainHeaderLinks(String link) {
        open("https://alfabank.ru/");
        $(String.format("[title = '%s']", link)).shouldBe(Condition.visible);
    }

    @ValueSource(strings = {
            "Кредитная карта",
            "Альфа-Счёт",
            "Альфа-Карта",
            "Ипотека от 5,8%",
            "Кредит наличными",
            "Инвестиции"
    })

    @ParameterizedTest
    public void checkPopularProductsBlock(String productName) {
        open("https://alfabank.ru/");
        $x(String.format("//div[@data-test-id='grid']//p[text()='%s']", productName))
                .shouldBe(Condition.visible);
    }

    @EnumSource(CreditTermCurrency.class)
    @ParameterizedTest
    public void checkChangingCreditTermCurrency(CreditTermCurrency currencyText) {
        open("https://alfabank.ru/");
        Selenide.$x(String.format("//p[text()='%s']/parent::button", currencyText.getCurrencyText())).shouldBe(Condition.visible);

    }


}
