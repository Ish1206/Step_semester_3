package string.assigment_problems;

import java.util.Scanner;

class SeatDuplicationChecker {

    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    boolean alreadyPrinted = false;

                    for (int k = 0; k < i; k++) {
                        if (seatNumbers[k] == seatNumbers[i])
                            alreadyPrinted = true;
                    }

                    if (!alreadyPrinted) {
                        System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                        duplicateFound = true;
                    }
                }
            }
        }

        if (!duplicateFound)
            System.out.println("No Duplicate Seats Found");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] seatNumbers = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter seat number: ");
            seatNumbers[i] = sc.nextInt();
        }

        checkDuplicateSeats(seatNumbers);
    }
}
