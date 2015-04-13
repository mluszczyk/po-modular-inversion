import java.util.Scanner;
import java.math.BigInteger;

class NoInverseException extends Exception {
    public NoInverseException() {super();}
}

class Inverse {
    /*
     * From http://en.wikipedia.org/wiki/Extended_Euclidean_algorithm#Modular
     * _integers
     */
    public static BigInteger find(BigInteger number, BigInteger modulo)
            throws NoInverseException {
        BigInteger t = BigInteger.ZERO, newT = BigInteger.ONE;
        BigInteger r = modulo, newR = number;
        while (!newR.equals(BigInteger.ZERO)) {
            BigInteger quotient = r.divide(newR);
            BigInteger tempT = t.subtract(quotient.multiply(newT));
            t = newT;
            newT = tempT;
            BigInteger tempR = r.subtract(quotient.multiply(newR));
            r = newR;
            newR = tempR;
        }
        if (r.subtract(BigInteger.ONE).signum() == 1) {
            throw new NoInverseException();
        }
        if (t.signum() == -1) {
            t = t.add(modulo);
        }
        return t;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberString = scanner.next();
        String moduloString = scanner.next();
        BigInteger number = new BigInteger(numberString);
        BigInteger modulo = new BigInteger(moduloString);
        try {
            BigInteger result = find(number, modulo);
            System.out.println(result.toString());
        } catch (NoInverseException exc) {
            System.out.println("Not invertible");
        }
    }
}
