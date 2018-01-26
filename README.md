# Comparison of Dijkstra, A* and D*
[![Build Status](https://travis-ci.org/micaminoff/tahtialgovertailu.svg?branch=master)](https://travis-ci.org/micaminoff/tahtialgovertailu)

[![codecov](https://codecov.io/gh/micaminoff/tahtialgovertailu/branch/master/graph/badge.svg)](https://codecov.io/gh/micaminoff/tahtialgovertailu)

### Brief Intro
The purpose of this project is to familiarize myself with the most widely used
path-finding algorithms; **Dijkstra**, **A\***, and the **D\*-family** (at least
Original D\*, hopefully either or both of Focused and Lite) as well as the data
structures needed to implement them. This project will be implemented in
**Java using Gradle and JUnit**.

A secondary purpose is to analyze and compare both time- and space-complexity
for various inputs.

I chose this problem because path-finding is a very common problem, and I wanted
to see how the more advanced algorithms work, what their features and drawbacks
are, and how they compare to each other given various inputs. **I hope to
uncover important information regarding how much performance one is willing to
give up to save on memory and vice versa.**

I *might* also sacrifice accuracy to improve A\*'s performance to see how much
time can be saved by finding a "good enough" path or how many iterations are
required to achieve for example "best path with 99% confidence" and if the
performance improvement is worth the uncertainty.

### Links in the repo
* [Source code](https://github.com/micaminoff/tahtialgovertailu/tree/master/tahti/src/main/java/tahti)
* [Documentation](https://github.com/micaminoff/tahtialgovertailu/tree/master/documentation)
* [Weekly reports](https://github.com/micaminoff/tahtialgovertailu/tree/master/reports)
