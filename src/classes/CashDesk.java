package classes;

public class CashDesk {
    private int cash;
    private int cardMoneyBill;

    public CashDesk() {
        this.cash = new RandomNum(new Data().getCashDeskLimit()).getSeed();
        this.cardMoneyBill = 0;
    }

    public void addCash(int customerCash) {
        cash += customerCash;
    }
    public void addCardMoneyBill(int cardMoney) {
        cardMoneyBill += cardMoney;
    }

    public int getCash() {
        return cash;
    }

    public int getCardMoneyBill() {
        return cardMoneyBill;
    }
}
