package entities;


public class Vehicle {
    private Tyre tyre;
    private Speaker speaker;
    private int price;

    private String factory;

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
}
