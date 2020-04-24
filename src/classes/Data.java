package classes;

public class Data {
    private int gameLoop = 1080;
    private int basketSize = 3;
    private int childType = 1;
    private int adultType = 2;
    private int oldType = 3;
    private int firstLoopIteration = 0;
    private int countOfCustomersLimit = 50;
    private int cashDeskLimit = 100000;
    private int ageLimit = 100;
    private double discount = 0.7;
    private int childAgeBound = 18;
    private int adultAgeBound = 65;
    private int generateProductsLimit = 100;
    private int bonusLimit = 1000;
    private int cardLimit = 10000;
    private int cashLimit = 5000;
    private int priceLimit = 1000;
    private int kidsChance = 10;
    private int kidsLuckyNumber = 7;
    private int queueDelayTimeLimit = 5;
    private int hourWhenOpen = 6;
    private int oneDigitNumbers = 10;
    private int generateProductIteration = 100;

    int getGenerateProductIteration() {
        return generateProductIteration;
    }

    double getDiscount() {
        return discount;
    }

    int getAdultType() {
        return adultType;
    }

    int getBasketSize() {
        return basketSize;
    }

    int getChildType() {
        return childType;
    }

    int getAgeLimit() {
        return ageLimit;
    }

    int getCashDeskLimit() {
        return cashDeskLimit;
    }

    int getCountOfCustomersLimit() {
        return countOfCustomersLimit;
    }

    int getFirstLoopIteration() {
        return firstLoopIteration;
    }

    int getGameLoop() {
        return gameLoop;
    }

    int getOldType() {
        return oldType;
    }

    int getAdultAgeBound() {
        return adultAgeBound;
    }

    int getBonusLimit() {
        return bonusLimit;
    }

    int getCardLimit() {
        return cardLimit;
    }

    int getCashLimit() {
        return cashLimit;
    }

    int getChildAgeBound() {
        return childAgeBound;
    }

    int getGenerateProductsLimit() {
        return generateProductsLimit;
    }

    int getHourWhenOpen() {
        return hourWhenOpen;
    }

    int getKidsChance() {
        return kidsChance;
    }

    int getKidsLuckyNumber() {
        return kidsLuckyNumber;
    }

    int getOneDigitNumbers() {
        return oneDigitNumbers;
    }

    int getPriceLimit() {
        return priceLimit;
    }

    int getQueueDelayTimeLimit() {
        return queueDelayTimeLimit;
    }
}
