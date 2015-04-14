#!/usr/bin/env python3
from __future__ import unicode_literals, division, print_function

def find(number, modulo):
    t, newt = 0, 1
    r, newr = modulo, number

    while newr:
        quotient = r // newr
        t, newt = newt, t - quotient * newt
        r, newr = newr, r - quotient * newr

    if r > 1:
        return None

    if t < 0:
        t += modulo

    return t


def repeat(rep, func, *args):
    result = func(*args)
    for _ in range(rep - 1):
        repeated_result = func(*args)
        assert repeated_result == result
    return result


def main():
    rep = int(input())
    number = int(input())
    modulo = int(input())

    result = repeat(rep, find, number, modulo)
    if result is None:
        print("Not invertible")
    else:
        print(result)


if __name__ == '__main__':
    main()
