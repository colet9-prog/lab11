import java.util.Scanner;

public class SafeInput {

    /**
     * Returns a non-zero-length string.
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    /**
     * Gets any int with input validation.
     */
    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); // clear newline
                done = true;
            } else {
                System.out.println("Error: please enter an integer.");
                pipe.nextLine(); // discard bad input
            }
        } while (!done);
        return retVal;
    }

    /**
     * Gets any double with input validation.
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0;
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                System.out.println("Error: please enter a valid number.");
                pipe.nextLine();
            }
        } while (!done);
        return retVal;
    }

    /**
     * Gets an int within an inclusive range.
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        boolean done = false;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Error: number must be between " + low + " and " + high);
                }
            } else {
                System.out.println("Error: please enter an integer.");
                pipe.nextLine();
            }
        } while (!done);
        return retVal;
    }

    /**
     * Gets a double within an inclusive range.
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = 0;
        boolean done = false;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Error: number must be between " + low + " and " + high);
                }
            } else {
                System.out.println("Error: please enter a valid number.");
                pipe.nextLine();
            }
        } while (!done);
        return retVal;
    }

    /**
     * Yes/No confirmation. Returns true for Y/y, false for N/n.
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        boolean retVal = false;
        boolean done = false;
        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().trim();
            if (response.equalsIgnoreCase("Y")) {
                retVal = true;
                done = true;
            } else if (response.equalsIgnoreCase("N")) {
                retVal = false;
                done = true;
            } else {
                System.out.println("Error: please enter Y or N.");
            }
        } while (!done);
        return retVal;
    }

    /**
     * Gets a string matching a regex pattern.
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response = "";
        boolean gotAValue = false;
        do {
            System.out.print(prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regEx)) {
                gotAValue = true;
            } else {
                System.out.println("Error: input must match the pattern " + regEx);
            }
        } while (!gotAValue);
        return response;
    }

    /**
     * Prints a 60-character wide pretty header with a centered message.
     */
    public static void prettyHeader(String msg) {
        final int WIDTH = 60;
        int msgLen = msg.length();
        int totalSpaces = WIDTH - msgLen - 6; // 3 stars each side
        int leftSpaces = totalSpaces / 2;
        int rightSpaces = totalSpaces - leftSpaces;

        for (int i = 0; i < WIDTH; i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("***");
        for (int i = 0; i < leftSpaces; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < rightSpaces; i++) {
            System.out.print(" ");
        }
        System.out.println("***");

        for (int i = 0; i < WIDTH; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
