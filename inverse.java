import java.util.Scanner;

class NoInverseException extends Exception {
    public NoInverseException() {super();}
}

class Inverse {
    /*
     * From http://en.wikipedia.org/wiki/Extended_Euclidean_algorithm#Modular
     * _integers
     */
    public static int find(int number, int modulo) throws NoInverseException {
        int t = 0, newT = 1;
        int r = modulo, newR = number;
        while (newR != 0) {
            int quotient = r / newR;
            int tempT = t - quotient * newT;
            t = newT;
            newT = tempT;
            int tempR = r - quotient * newR;
            r = newR;
            newR = tempR;
        }
        if (r > 1) {
            throw new NoInverseException();
        }
        if (t < 0) {
            t = t + modulo;
        }
        return t;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int modulo = scanner.nextInt();
        try {
            int result = find(number, modulo);
            System.out.println(result);
        } catch (NoInverseException exc) {
            System.out.println("Not invertible");
        }
    }
}
