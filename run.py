#!/usr/bine/nv python3
"""Script to benchmark implementations of modular inverse."""

import io
import math
import subprocess
import time


BIG_PRIMES = [
    2**110503 - 1,
    (391581*2**(216193))-1
    #2**132049 - 1
]
MEDIUM_PRIMES = [
    10**1000 - 500001,  # http://primes.utm.edu/curios/page.php?number_id=8250
    (10**317 - 1) // 9
]


class Test(object):
    @staticmethod
    def digits(number):
        """Return the number of decimal digits of given number."""
        return int(math.ceil(math.log(number, 10)))

    def __init__(self, repetitions, number, modulo):
        self.repetitions = repetitions
        self.number = number
        self.modulo = modulo

    def __str__(self):
        msg = "{} repetitions. {} digit number modulo {} digit number."
        return msg.format(
            self.repetitions,
            self.digits(self.number), self.digits(self.modulo))

    def execute(self, program):
        input_numbers = [self.repetitions, self.number, self.modulo]
        input_str = "\n".join(map(str, input_numbers)) + '\n'
        stdin = input_str.encode()
        start = time.perf_counter()
        process = subprocess.Popen(
                program,
                stdin=subprocess.PIPE, stdout=subprocess.PIPE)
        stdout, stderr = process.communicate(stdin)
        stop = time.perf_counter()
        return (stop - start, stdout)


TESTS = (
    [Test(10**x, *MEDIUM_PRIMES) for x in range(6)] +
    [Test(10**x, *BIG_PRIMES) for x in range(4)]
)

PROGRAMS = (("python2", "inverse.py"),
            ("python3", "inverse.py"),
            ("java", "Inverse"))


def main():
    for num, program in enumerate(PROGRAMS):
        print("Program {}: {}".format(num, program))
    for test in TESTS:
        print(test)
        first_run = True
        prev_result = None
        for num, program in enumerate(PROGRAMS):
            time, result = test.execute(program)
            print("{}. {}".format(num, time))
            if first_run:
                first_run = False
                prev_result = result
            else:
                assert result == prev_result


if __name__ == '__main__':
    main()
