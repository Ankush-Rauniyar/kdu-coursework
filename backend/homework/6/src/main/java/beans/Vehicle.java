package beans;


public class Vehicle {
    private Tyre tyre;
    private Speaker speaker;
    private int price;

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
