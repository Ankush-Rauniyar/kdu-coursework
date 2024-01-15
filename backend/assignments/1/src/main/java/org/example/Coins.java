package org.example;

public class Coins {
    private int rank;
    private String name;
    private String symbol;

    private double price;
    private long volume;

    public Coins(int rank,String name,String symbol,double price,long volume){
        this.rank = rank;
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
    }
    public double getPrice() {
        return price;
    }

    public int getRank() {
        return rank;
    }

    public long getVolume() {
        return volume;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }
}
