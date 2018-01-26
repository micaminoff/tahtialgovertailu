#### Time spent - 11h

## Worklog
#### 23.1
* Spent far too long getting gradle to work
* Fixed $JAVA_HOME and other gradle/JDK-related issues
* Settled on Graph representation and implemented needed classes

#### 26.1
* Implemented Dijkstra badly
* Fixed Dijkstra
* Broke Dijkstra
* Implemented Dijkstra better
* Wrote tests
* Integration with Travis CI and Codecov
* Wrote report

## Progress/Future

The project is chugging forward, I had some unforseen environment problems with gradle, travis, and Java. But I fixed it all.
I'm surprised I've already created a graph representation, even though it is created with already existing data structures.

This week I learned I'm smarted than many people trying to implement Dijkstra, but also way dumber than many others. I also realized I need a better way to figure out if there is an edge between two vertices.
I didn't have too much trouble with the actual coding this week - mainly some conceptual problems with when to iterate through which set, but paper and pen helps.

Tentative schedule for coming weeks:
* 3 - A* and D* (and graph generation / conversion)
* 4 - Main program, comparisons, graph generation
* 5 - Replace Sets, Lists, Maps (Queue, Heap) with own implementations
* 6 - Optimization, finishing touches
