## Toteutus

#### Structure
.
└── tahti
    ├── algorithm
    │   ├── AStar.java
    │   ├── Dijkstra.java
    │   └── SearchAlgorithm.java
    ├── datastructure
    │   ├── Graph.java
    │   ├── PriorityQ.java
    │   ├── Vertex.java
    │   └── VertexMap.java
    ├── Main.java
    └── StatCollector.java

For now, main runs the three routines defined in StatCollector. This is basically a large integration test that tests all classes.
StatCollector passes a datastructure.graph to AStar and Dijkstra in algorithm, who in turn use the datastructure package to find a path through the given graph.

I'll improve this representation later, the project might still change slightly in layout as I work on a ui and controller.

#### O-analysis
not yet

#### Performance analysis
not yet due to unfinished stats collecting class

#### Deficiencies
* More algorithms/implementations to test
* More varied stats collecting and better presentation
* Custom peformance tests
