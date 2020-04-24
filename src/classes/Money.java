package classes;

public class Money {
    private int card;
    private int cash;
    private int bonus;
    Money() {
        this.card = new RandomNum(new Data().getCardLimit()).getSeed();
        this.cash = new RandomNum(new Data().getCashLimit()).getSeed();
        this.bonus = new RandomNum(new Data().getBonusLimit()).getSeed();
    }

    int getAllMoney() {
        return bonus + card + cash;
    }

    int getBonus() {
        return bonus;
    }

    int getCard() {
        return card;
    }

    int getCash() {
        return cash;
    }

    void setBonus(int bonus) {
        this.bonus = bonus;
    }

    void setCard(int card) {
        this.card = card;
    }

    void setCash(int cash) {
        this.cash = cash;
    }
}
