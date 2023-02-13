package webtests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.remote.tracing.Tags;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class UserLoginTests {
    @Test
    public void checkInvalidDataUserLogin(){
        open("https://alfabank.ru/");
        $x("//a[text()='Альфа-Онлайн']").click();
        $x("//input[@aria-label='Логин']").setValue("WrongLogin");
        $x("//input[@aria-label='Пароль']").setValue("Password");
        $x("//span[text()='Войти']").click();
        $(byTagAndText("div","Некорректные данные. Пожалуйста, попробуйте ещё раз."))
                .shouldBe(Condition.visible);

    }

    @ValueSource(strings = {
            "Логин",
            "Пароль"
    })
    @ParameterizedTest( name = "Проверка попытки логина с заполненным {0}")
    public void loginWithEmpty(String data){
        open("https://alfabank.ru/");
        $x("//a[text()='Альфа-Онлайн']").click();
        $x(String.format("//input[@aria-label='%s']", data)).setValue("Passwordddd");
        $x("//span[text()='Войти']");
    }

}
