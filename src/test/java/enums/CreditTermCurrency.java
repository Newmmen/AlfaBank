package enums;

public enum CreditTermCurrency {
    RUB("В рублях"),
    USD("В долларах США"),
    EUR("В евро"),
    CNY("В юанях");
    private final String currency;

    CreditTermCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencyText() {
        return currency;
    }
}
