import java.util.Arrays;
import java.util.Objects;

public class MovieTheatre {
    String[][] seatingChart;

    // ANSI escape codes for changing the text colour in the CLI
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String availableSeat = ANSI_GREEN + "O" + ANSI_RESET;
    public static final String reservedSeat = ANSI_RED + "X" + ANSI_RESET;

    public MovieTheatre(int numOfRows, int numOfCols){
        this.seatingChart = new String[numOfRows][numOfCols];

        for (int row=0; row < numOfRows; row++){
            for (int col=0; col< numOfCols; col++){
                seatingChart[row][col] = availableSeat;
            }
        }
    }

    public void displaySeatingChart () {
        System.out.println();
        System.out.println("Seating Chart:");
        for (int row=0; row < this.seatingChart.length; row++){
            System.out.println(Arrays.toString(this.seatingChart[row]));
        }
        System.out.println();
    }

    public void reserveSeat (int row, int col){
        try {
            if (Objects.equals(seatingChart[row][col], reservedSeat)) {
                System.out.println("Seat at [row " + row + ", column " + col + "] is already reserved, please try a different seat.");
            } else {
                seatingChart[row][col] = reservedSeat;
                System.out.println("Seat at [row " + row + ", column " + col + "] has been successfully reserved.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Seat does not exist, please enter a valid seat location.");
        }
    }

    public void cancelSeat (int row, int col){
        try {
            if (Objects.equals(seatingChart[row][col], availableSeat)) {
                System.out.println("Cancellation failed, there is no reserved seat at [row " + row + ", column " + col + "].");
            } else {
                seatingChart[row][col] = availableSeat;
                System.out.println("Reservation at seat [row " + row + ", column " + col + "] has been successfully cancelled.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Seat does not exist, please enter a valid seat location.");
        }
    }

}
