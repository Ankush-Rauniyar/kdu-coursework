package questiontwo;

import java.util.*;

public class TicketReservation {

    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        Passenger passenger = new Passenger(firstName,lastName,age,gender,travelClass,confirmationNumber);
        if(confirmedList.size() >= CONFIRMEDLIST_LIMIT){
            confirmedList.add(passenger);
            return true;
        }else if(waitingList.size() >= WAITINGLIST_LIMIT){
            waitingList.add(passenger);
            return true;
        }else{
            return false;
        }

    }

    public boolean cancel(String confirmationNumber) {
        boolean confirmedRemovalOrNot = removePassenger(confirmedList.iterator(), confirmationNumber);
        if(confirmedRemovalOrNot && !waitingList.isEmpty()){
            confirmedList.add(waitingList.poll());
            return true;
        }
        if(!confirmedRemovalOrNot){
            return removePassenger(waitingList.iterator(), confirmationNumber);
        }
        return true;
    }

    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        while(iterator.hasNext()){
            Passenger passenger = iterator.next();
            if(confirmationNumber.equals(passenger.getConfirmationNumber())){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
