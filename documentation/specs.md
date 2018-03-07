# Specification

### Introduction
The purpose of this project is to familiarize myself with the most widely used
path-finding algorithms; **Dijkstra**, **A\***, and **IDA\*** as well as the data
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

### Inputs
The program is passed a graph from [Moving AI](http://www.movingai.com/benchmarks/). As well as
the starting and end nodes.

No further input is needed from the user after these are passed, the program
will run to completion and output
* Analysis of time and memory used by each algorithm
* Number of operations

### Complexity goals
Algorithm | Time Complexity | Space Complexity
----------|-----------------|-----------------
Dijkstra | O(\|V\|^2) | O(\|V\|^2)
A\* | O(\|V\|^2) | O(\|V\|^2)
IDA\* | O(\|V\|^2) | O(length_of_path)

### Sources
* [CLRS](http://ressources.unisciel.fr/algoprog/s00aaroot/aa00module1/res/%5BCormen-AL2011%5DIntroduction_To_Algorithms-A3.pdf)
* [A-Star tutorial](http://web.mit.edu/eranki/www/tutorials/search/)
* [Red Blob Games](https://www.redblobgames.com/)
* [Kivinen, TKT20001](https://moodle.helsinki.fi/pluginfile.php/1726667/mod_resource/content/15/tira.pdf)
* [Korf, Depth-First Iterative-Deepening..., 1985](https://cse.sc.edu/~mgv/csce580f09/gradPres/korf_IDAStar_1985.pdf)
* Wiki, Stackoverflow
* [Moving AI](http://www.movingai.com/benchmarks/) Maps
