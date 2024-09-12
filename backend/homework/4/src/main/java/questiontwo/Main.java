package questiontwo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Main method started");

        TicketReservation ticketReservation = new TicketReservation();
        ticketReservation.bookFlight("Ankush","Rauniyar",22,"Male","Economy","4567abcd");

        String cancellationNumber = "DEF456";
        boolean cancellationResult = ticketReservation.cancel(cancellationNumber);
        logger.info("Cancellation Result: {}",cancellationResult);

        logger.info("Main method completed");
    }

}