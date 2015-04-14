import java.util.Scanner;
import java.math.BigInteger;

class Inverse {
    /*
     * From http://en.wikipedia.org/wiki/Extended_Euclidean_algorithm#Modular
     * _integers.
     * Returns BigInteger or null if inverse doesn't exist.
     */
    public static BigInteger find(BigInteger number, BigInteger modulo) {
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
            return null;
        }
        if (t.signum() == -1) {
            t = t.add(modulo);
        }
        return t;
    }

    public static BigInteger repeat(
            int repetitions, BigInteger number, BigInteger modulo) {
        String errorMsg = "Different results for consequent function calls.";
        BigInteger result = find(number, modulo);
        for (int i = 1; i < repetitions; ++i) {
            BigInteger testResult = find(number, modulo);
            if(!testResult.equals(result)) {
                throw new RuntimeException(errorMsg);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repetitions = scanner.nextInt();
        String numberString = scanner.next();
        String moduloString = scanner.next();
        BigInteger number = new BigInteger(numberString);
        BigInteger modulo = new BigInteger(moduloString);
        BigInteger result = repeat(repetitions, number, modulo);
        if(result != null) {
            System.out.println(result.toString());
        } else {
            System.out.println("Not invertible");
        }
    }
}
