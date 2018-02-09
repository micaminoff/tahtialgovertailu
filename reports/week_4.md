#### Time spent - 17h

## Worklog
#### All week
* Trying to understand D\*, D\*-focused, and D\*-lite.
#### 6.2
* Belatedly fixed tests
#### 7.2
* Added lots of comments
#### 9.2
* Did lots of stuff. A lot. It's easiest to just check the commits.
* Added more maps
* Automated performance testing routines
* Improved Dijkstra by adding heap
* Redid VertexMap (a Hash Table implementation)
* Implemented a priority queue as a binary min-heap
* Improved A\* and Dijkstra by using my own priority queue
* General cleanup, testing, comments.
* Peer code review

#### Issues this week
* A\* started spitting out weird results depending on the initial size of my VertexMap (fix in [a441367])
* Thinking about how to implement D\*, decided on making my own datastructures this week instead
  * The motivation for their existance is clear, but I'm not sure how I should go about implementing any one of the variations, since my program doesn't distinguish between pathfinding and movement, so I'm not so sure a dynamic/iterative approach is of much use. I'd love some comments on this.
  * I'm considering just doing more extensive performance testing on A\* and Dijkstra with different backing datastructures and variations on the actual algorithm.
* Heapify (propagate\_up, propagate\_down) was a goddamn nightmare.

#### Insights
* Dijkstra without heap took 9s, Dijkstra with heap took 20ms. I'm fairly sure there was something wrong in my naïve implementation.
* A\* can perform worse than Dijkstra if the seemingly best path "often" leads to dead ends (routine 3).
* HashTables are waaaaaaaay easier to implement than priority queues.

#### Targets for next week
* Better stats generation
* Either implement some variation of D\* or create more variations of Dijkstra and A\* and their required datastructures
* More unit testing
* Start work on ui (terminal / gui) if I go with gui I'll look into animating the pathfinding
