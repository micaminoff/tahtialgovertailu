# Toteutus

## Structure

    └── tahti
        ├── algorithm
        │   ├── AStar.java
        │   ├── IDAStar.java
        │   ├── Dijkstra.java
        │   └── SearchAlgorithm.java
        ├── datastructure
        │   ├── Graph.java
        │   ├── PriorityQ.java
        │   ├── Vertex.java
        │   ├── VertexStack.java
        │   └── VertexMap.java
        ├── io
        │   ├── IO.java
        │   ├── Console.java
        │   └── Stub.java
        ├── App.java
        └── StatCollector.java

The  `App` class prvoides the interface for interacting with the rest of the program. It only needs to know about the `StatCollector` class and `io`-package.
`StatCollector` needs to have access to the high-level datastructures `Graph` and `Vertex` as well as the entire `algorithm`-package to be able to define the parameters of the search.

The `io`-package is used to parse user input or provide mock inputs during testing (`console` and `stub` respectively).
`StatCollector` offers several predifined routines for performance testing as well as a custom routine creation method. 

The `algorithm`-package includes all currently implemented search algorithms. They need access to the `datastructures`-package for obvious reasons.

The `datastructure`-package contains all custom datastructures. These classes only need to know about the Vertex implementation.

## Implementation details
### Algorithms
Dijkstra works as a BFS which always selects the vertex that minimizes distance(source -> vertex). This is achieved by using a Priority Queue, implemented as a min heap.

A\* works like Dijkstra, but always selects the vertex that minimizes f(vertex -> target). f() is calculated as distance(source -> vertex) + h(vertex -> target), where h() is the heuristic function. The heuristic function in this implementation is simply the manhattan distance. To get the lowest f() we again use a Priority queue.

IDA\* is a DFS that selects the next vertex in the current path with A\*'s heuristic function (again, with a backing PQ). The "iterative deepening" part requires some explanation. The initial "threshold" for the DFS is h(start -> target). This means if we don't find the target before all paths exceed the threshold, we return and increment the threshold and try again. The aglorithm also uses a Stack to avoid visiting nodes already visited on this path.

### Datastructures
* Graph is a 2d-array of Vertices: it offers methods for resetting the state of all Vertices, getting a vertex's neighbors and finding a Vertex given its coordinates.
* Vertex is the basic building block of the program. It is rich in information - containing its position in the graph, its move cost (terrain), its f-value for A\* and IDA\* as well as an id for easier hashing.
* PriorityQ is a min-heap of QItems, which are simply (Vertex, int)-pairs. PriorityQ offers methods for getting its size, its top value (min) and inserting a new item. Internally it agressively monitors memory usage.
* VertexMap is a Hash Table, backed by an array of MapEntries, which are simply (key, value)-pairs. Collisions are handled by chaining, so technically the MapEntry also implements a linked list. VertexMap offers methods for adding or getting items, finding out if the table contains a Vertex and getting the number of elements in the table (including chained items). This strucutre also agressively monitors memory usage.
* VertexStack is a simple stack implemented as a linked list.

## O-analysis
#### Dijkstra
Time: 
Because we use a min heap, the time required to update and select the next vertex is O(log(V)).
Since the amount of edges in the chosen graphs can be represented as 4*\|V\| we can state that for this case the time complexity is O(Vlog(V)). If we extend the graph representation this becomes (Elog(V)).

Space:
Again, since there are at most 4 neighbors of a given vertex, the number of edges can be represented as 4*\|V\|. This is the worst case number of open nodes for a given vertex. Extending this to the whole graph we get O(L\*V) where L = length of path.

#### A\*
Time:
Worst case is exactly the same as Dijkstra. However in practice the heuristic will seldom be completely worthless and allows approx O(log(V)) performance. If the optimal heuristic is used, this becomes O(L) where L is the length of the path.

Space:
Worst case is exactly the same as Dijkstra. With optimal heuristic this becomes O(4\*L) = O(L).

#### IDA\*
Time:
IDA\* must explore all paths that satisfy f(source -> v) = threshold. If the target is found in the first pass time complexity is O(L) - the same as A\* with the optimal heuristic. In any other case it must increase the threshold and search again. This complexity is complex and huge.

Space:
Since IDA\* only stores its current path its space complexity is O(L)

#### Performance analysis
Open maps with branching factor=4:

* Dijkstra and A\* perform far better than IDA\* - by several orders in magnitude - if the problem is not absolutely trivial.
* IDA\* always uses linear memory while both other algorithms' memory consumption grows.
* A\* visits and remembers fewer nodes than Dijkstra, but performs worse in some cases due to agressive memory management in backing datastructures. IDA\* visits FAR more nodes than either of the others.

Algorithm | Path Length | Time | Nodes visited | Nodes in memory
----------|-------------|------|---------------|----------------
Dijkstra | 35 | 2ms | 4776 | 1417
A\* | 35 | 0ms | 708 | 243
IDA\* | 35 | 102ms | 118116 | 35
Dijkstra | 36 | 2ms | 5032 | 1488
A\* | 36 | 0ms | 716 | 255
IDA\* | 36 | 513ms | 605234 | 36
Dijkstra | 37 | 2ms | 5052 | 1491
A\* | 37 | 0ms | 820 | 290
IDA\* | 37 | 1786ms | 2150410 | 37

Mazelike maps with branching factor ~ 2:

* Dijkstra and A\* perform far better than IDA\* - by several orders in magnitude - if the problem is not absolutely trivial.
* For simpler problems IDA\* and A\* perform better than Dijkstra. As the problem grows IDA\* suffers while A\* and Dijkstra stay relatively equal.
* However, IDA\* always uses linear memory while both other algorithms' memory consumption grows.
* A\* visits and remembers fewer nodes than Dijkstra, but performs worse in some cases due to agressive memory management in backing datastructures. IDA\* visits FAR more nodes than either of the others.

Algorithm | Path Length | Time | Nodes visited | Nodes in memory
----------|-------------|------|---------------|----------------
Dijkstra | 8 | 2ms | 72 | 50
A\* | 8 | 0ms | 40 | 13
IDA\* | 8 | 0ms | 41 | 8
Dijkstra | 34 | 2ms | 420 | 242
A\* | 34 | 0ms | 280 | 76
IDA\* | 34 | 0ms | 888 | 34
Dijkstra | 952 | 3ms | 8576 | 4422
A\* | 952 | 1ms | 8416 | 2108
IDA\* | 952 | 2322ms | 1544880 | 952

### Deficiencies
Need to finish the tests.
Balance between performance and memory management to make sure A\* performs better than Dijkstra.
MORE ROUTINES.
