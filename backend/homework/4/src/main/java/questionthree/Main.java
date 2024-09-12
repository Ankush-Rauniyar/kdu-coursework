package questionthree;


public class Main {
    public static void main(String[] args){
        Integer[] arr = {23,56,4,6,78};
        int first = 0;
        int second = 3;
        ExchangePosition exchangePosition = new ExchangePosition();
        exchangePosition.changeposition(arr,first,second);

        String[] another ={"apple","ball","cat","dog","egg"};
        int left = 2;
        int right = 4;
        exchangePosition.changeposition(another,left,right);
    }
}
