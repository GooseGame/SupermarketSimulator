package classes;

import java.util.ArrayList;

class Products {
    private ArrayList<String> names = new ArrayList<String>() {
        {
            add("Marlboro");
            add("Winston");
            add("LD");
            add("Donskoy tabak");
            add("Baltika");
            add("Bud");
            add("Talka");
            add("Jagermeister");
            add("Jateckiy Gus");
            add("Pampers");
            add("Fructoviy Sad");
            add("Baltika Besalkogolnaya");
            add("Hleb Beliy");
            add("Hleb Cherniy");
            add("Moloko");
            add("Kefir");
            add("Smetana");
            add("Sgushyonka");
            add("Bulochka");
            add("Choko Pay");
            add("Kruassani");
            add("Detskoe Shampanskoe");
            add("Dusha Greshnika (0+)");
            add("Maslo Podsolnechnoe");
            add("Agusha");
            add("Doshirak");
            add("Vafli Yashkino");
            add("Bubliki");
            add("Orbit");
            add("Kartoshka");
            add("baguette");
            add("bagels");
            add("coconut oil");
            add("colby cheese");
            add("nectarines");
            add("chambord");
            add("sweet peppers");
            add("swiss cheese");
            add("shallots");
            add("walnuts");
            add("orange peels");
            add("mustard seeds");
            add("almond extract");
            add("sweet chili sauce");
            add("hardbass");
        }
    };
    String getName(int i) {
        int rand = new RandomNum(new Data().getKidsChance()).getSeed();
        String result;
        if (rand == new Data().getKidsLuckyNumber()) {
            result = names.get(i) + "(For kids)";
        }
        else result = names.get(i);
        return result;
    }
    int getSize() {
        return names.size();
    }
}
