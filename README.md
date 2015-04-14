Benchmark of modular inversion implementations
==============================================

This project is a comparison of Java and Python implementation of modular
inversion using extended Euclidean algorithm. It's an exercise in Objective
Programming course.

Surprisingly the implementation in Java was the slowest in all tests but one,
in which it beat CPython, but PyPy was still faster. A possible reason is the
fact that Python's big integer arithmetic is built in and compiled into
machine code and Java's BigInteger library is pure Java.

I have been informed that Java performs much better on the Java version
mentioned below, in which it outperforms PyPy. (Thanks, Albert)

    java version "1.9.0-ea"
    Java(TM) SE Runtime Environment (build 1.9.0-ea-b57)
    Java HotSpot(TM) 64-Bit Server VM (build 1.9.0-ea-b57, mixed mode)

Results of the tests are visible below:

    [michal@michal-desktop po-modular-inversion]$ python run.py  2> /dev/null
    Program 0: ('python2', 'inverse.py')
    Program 1: ('python3', 'inverse.py')
    Program 2: ('pypy', 'inverse.py')
    Program 3: ('pypy3', 'inverse.py')
    Program 4: ('java', 'Inverse')
    1 repetitions. 1000 digit number modulo 317 digit number.
    0. 0.05830789100036782
    1. 0.1199673699993582
    2. 0.24869586100066954
    3. 0.2680027140013408
    4. 0.40932341500047187
    10 repetitions. 1000 digit number modulo 317 digit number.
    0. 0.06258755299859331
    1. 0.12290915099947597
    2. 0.2504154300004302
    3. 0.2697188679994724
    4. 0.4655989969996881
    100 repetitions. 1000 digit number modulo 317 digit number.
    0. 0.08998527500079945
    1. 0.15276076599911903
    2. 0.3005664490010531
    3. 0.33046812000065984
    4. 0.7799865910001245
    1000 repetitions. 1000 digit number modulo 317 digit number.
    0. 0.3940653290010232
    1. 0.455716857999505
    2. 0.4915066260000458
    3. 0.5432661499999085
    4. 1.2346479219995672
    10000 repetitions. 1000 digit number modulo 317 digit number.
    0. 3.450619222001478
    1. 3.5474540940012957
    2. 2.1179232340000453
    3. 2.4623816380008066
    4. 3.826755054999012
    100000 repetitions. 1000 digit number modulo 317 digit number.
    0. 35.657987746999424
    1. 34.7566720979994
    2. 19.138078464999126
    3. 21.958562694999273
    4. 28.5218864999988
    1 repetitions. 33265 digit number modulo 65087 digit number.
    0. 1.0442228590000013
    1. 1.1299708400001691
    2. 0.8218019409996487
    3. 0.8548083290006616
    4. 4.980489417001081
    10 repetitions. 33265 digit number modulo 65087 digit number.
    0. 3.1615342460008833
    1. 3.231725405999896
    2. 2.252944451000076
    3. 2.3325135900013265
    4. 9.322112019999622
    100 repetitions. 33265 digit number modulo 65087 digit number.
    0. 24.37740457899963
    1. 24.580740240000523
    2. 16.20926664900071
    3. 16.585373017000165
    4. 49.334208939000746
    1000 repetitions. 33265 digit number modulo 65087 digit number.
    0. 238.2224159439993
    1. 241.18747648200042
    2. 157.46555446599814
    3. 164.16851683100322
    4. 435.6440571940002

The environment:

    [michal@michal-desktop ~]$ uname -mrs
    Linux 3.18.6-1-ARCH x86_64
    [michal@michal-desktop ~]$ python2 --version
    Python 2.7.9
    [michal@michal-desktop ~]$ python3 --version
    Python 3.4.3
    [michal@michal-desktop ~]$ pypy --version
    Python 2.7.8 (10f1b29a2bd2, Feb 05 2015, 16:50:17)
    [PyPy 2.5.0 with GCC 4.9.2 20141224 (prerelease)]
    [michal@michal-desktop ~]$ pypy3 --version
    Python 3.2.5 (b2091e973da69152b3f928bfaabd5d2347e6df46, Nov 18 2014, 20:15:54)
    [PyPy 2.4.0 with GCC 4.9.2]
    [michal@michal-desktop ~]$ java -version
    Picked up _JAVA_OPTIONS: -Dawt.useSystemAAFontSettings=on
    java version "1.7.0_75"
    OpenJDK Runtime Environment (IcedTea 2.5.4) (Arch Linux build 7.u75_2.5.4-1-x86_64)
    OpenJDK 64-Bit Server VM (build 24.75-b04, mixed mode)
