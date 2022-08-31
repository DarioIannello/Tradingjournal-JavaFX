/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.tradingjournal.Entity;

/**
 *
 * @author Dario
 */
public class Trades {

    private final String pair;
    private final String bs;
    private final String date;
    private final String time;
    private final String wbel;
    private final String strat;
    private final String profit;
    private final String reasonsF;
    private final String reasonsA;
    private final String others;
    private final String learn;

    public Trades(String pair, String bs, String date, String time, String wbel, String strat, String profit, String reasonsF, String reasonsA, String others, String learn) {
        this.pair = pair;
        this.bs = bs;
        this.date = date;
        this.time = time;
        this.wbel = wbel;
        this.strat = strat;
        this.profit = profit;
        this.reasonsF = reasonsF;
        this.reasonsA = reasonsA;
        this.others = others;
        this.learn = learn;
    }

    public String getPair() {
        return pair;
    }

    public String getBs() {
        return bs;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getWbel() {
        return wbel;
    }

    public String getStrat() {
        return strat;
    }

    public String getProfit() {
        return profit;
    }

    public String getReasonsF() {
        return reasonsF;
    }

    public String getReasonsA() {
        return reasonsA;
    }

    public String getOthers() {
        return others;
    }

    public String getLearn() {
        return learn;
    }
}
