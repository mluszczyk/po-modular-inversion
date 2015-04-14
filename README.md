Benchmark of modular inversion implementations
==============================================

This project is a comparison of Java and Python implementation of modular
inversion using extended Euclidean algorithm. It's an exercise in Objective
Programming course.

Surprisingly Python implementation appeared to be faster in all test cases
but one.

Results of the tests are visible below:

    [ml360314@students modular-inverse]$ python3 run.py 2> /dev/null
    Program 0: ('python2', 'inverse.py')
    Program 1: ('python3', 'inverse.py')
    Program 2: ('java', 'Inverse')
    1 repetitions. 1000 digit number modulo 317 digit number.
    0. 0.048581020993879065
    1. 0.09771182999247685
    2. 0.4174427720136009
    10 repetitions. 1000 digit number modulo 317 digit number.
    0. 0.05212729101185687
    1. 0.09908674901816994
    2. 0.47469642900978215
    100 repetitions. 1000 digit number modulo 317 digit number.
    0. 0.06783126899972558
    1. 0.113053384993691
    2. 0.4473314629867673
    1000 repetitions. 1000 digit number modulo 317 digit number.
    0. 0.22811055698548444
    1. 0.26872870899387635
    2. 0.8481703149736859
    10000 repetitions. 1000 digit number modulo 317 digit number.
    0. 1.850048906984739
    1. 1.8080952770251315
    2. 2.5005659099842887
    100000 repetitions. 1000 digit number modulo 317 digit number.
    0. 16.624915919004707
    1. 15.753268376021879
    2. 14.034624810999958
    1 repetitions. 33265 digit number modulo 65087 digit number.
    0. 0.5258190179883968
    1. 0.5791864120110404
    2. 2.9018302480108105
    10 repetitions. 33265 digit number modulo 65087 digit number.
    0. 1.3563796470116358
    1. 1.4183120559901
    2. 4.627125086000888
    100 repetitions. 33265 digit number modulo 65087 digit number.
    0. 8.828104480024194
    1. 8.735911305993795
    2. 14.300775431998773
    1000 repetitions. 33265 digit number modulo 65087 digit number.
    0. 74.87063616601517
    1. 76.76473909898777
    2. 128.79995640399284

The environment 

    [ml360314@students modular-inverse]$ python2 --version
    Python 2.7.6
    [ml360314@students modular-inverse]$ python3 --version
    Python 3.3.4
    [ml360314@students modular-inverse]$ java -version
    Picked up _JAVA_OPTIONS: -Xmx384M
    java version "1.7.0_51"
