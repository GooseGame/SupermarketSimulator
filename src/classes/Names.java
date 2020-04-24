package classes;

import java.util.ArrayList;
import java.util.Random;

class Names {
    private ArrayList<String> maleNames = new ArrayList<String>() {
        {
            add("Bob");
            add("Andrew");
            add("Peter");
            add("Homer");
            add("John");
            add("Jim");
            add("Gustavo");
            add("Keanu");
            add("Patric");
            add("Jakub");
            add("Ricardo");
            add("Paul");
            add("Kobi");
            add("Edward");
            add("Vinnie");
            add("Owen");
            add("Fletcher");
            add("Dillon");
            add("Zac");
            add("Preston");
            add("Vincent");
        }
    };
    private ArrayList<String> femaleNames = new ArrayList<String>() {
        {
            add("Ashlie");
            add("Margaret");
            add("Loise");
            add("Marge");
            add("Evie");
            add("Marley");
            add("Olly");
            add("Eleanor");
            add("Elodie");
            add("Savannah");
            add("Darcie");
            add("Maisy");
            add("Dottie");
            add("Alexis");
            add("Kara");
            add("Caitlin");
            add("Vanessa");

        }
    };
    private ArrayList<String> surnames = new ArrayList<String>() {
        {
            add(" Smith");
            add(" Milos");
            add(" Watson");
            add(" Pinkman");
            add(" Freeman");
            add(" Simpson");
            add(" White");
            add(" Rose");
            add(" Mcdonald");
            add(" Robertson");
            add(" Price");
            add(" Richardson");
            add(" Hart");
            add(" Stone");
            add(" Read");
        }
    };
    String getName() {
        boolean isMale = new Random().nextBoolean();
        int rn;
        int rs = new RandomNum(surnames.size()).getSeed();
        if (isMale) {
            rn = new RandomNum(maleNames.size()).getSeed();
            return maleNames.get(rn) + surnames.get(rs);
        }
        else {
            rn = new RandomNum(femaleNames.size()).getSeed();
            return femaleNames.get(rn) + surnames.get(rs);
        }
    }
}
