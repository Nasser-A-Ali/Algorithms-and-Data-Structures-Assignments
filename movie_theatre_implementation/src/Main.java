import java.util.Arrays;

public class Main {
    // Demo for the main features of the program
    public static void main(String[] args) {

        MovieTheatre sampleTheatre = new MovieTheatre(5,5);

        sampleTheatre.displaySeatingChart();
//        System.out.println(cineplex.displaySeatingChart());

        sampleTheatre.reserveSeat(0,0);
        sampleTheatre.reserveSeat(1,1);
        sampleTheatre.reserveSeat(2,2);
        sampleTheatre.reserveSeat(3,3);
        sampleTheatre.reserveSeat(4,4);

        sampleTheatre.displaySeatingChart();

        sampleTheatre.cancelSeat(1,1);
        sampleTheatre.cancelSeat(3,3);
        sampleTheatre.cancelSeat(3,3);

        sampleTheatre.displaySeatingChart();

    }
}