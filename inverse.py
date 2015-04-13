class NoInverseException(Exception):
    pass


def find(number, modulo):
    t, newt = 0, 1
    r, newr = modulo, number

    while newr:
        quotient = r / newr
        t, newt = newt, t - quotient * newt
        r, newr = newr, r - quotient * newr

    if r > 1:
        raise NoInverseException

    if t < 0:
        t += modulo

    return t


def main():
    number = int(input())
    modulo = int(input())

    try:
        result = find(number, modulo)
        print(result)
    except NoInverseException:
        print("Not invertible")


if __name__ == '__main__':
    main()
