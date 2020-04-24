package classes;

class Time {
    int hours;
    int minutes;
    Time(int loop) {
        this.hours = loop / 60 + new Data().getHourWhenOpen();
        this.minutes = loop % 60;
    }
    String get() {
        String zeroH = "";
        String zeroM = "";
        if (hours<new Data().getOneDigitNumbers()) {
            zeroH = "0";
        }
        if (minutes<new Data().getOneDigitNumbers()) {
            zeroM = "0";
        }
            return "["+zeroH+hours + ": " +zeroM+ minutes+"] ";

    }
}
