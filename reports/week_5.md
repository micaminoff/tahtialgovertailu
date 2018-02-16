#### Time spent - 10h

## Worklog
#### All week
* Trying to understand D\* and D\*-lite. Also IDA\*
#### 15.2
* Researched IDA\*
#### 16.2
* Test coverage => 90\%
* Added more comments
* Implemented memory stats collecting
* Started implementing IDA\*, encountered tough bug. Trying to solve.
* Fixed A\* heuristic to improve performance by a factor of 2.
* Tidied up the stats formatting and upped the reps and added a more intense test.

#### Issues this week
* IDA\* is not behaving properly.
* A\* is still slower than Dijkstra on a fairly open map. I'm fairly confident it has to do with overzealous datastructure resizing, but I haven't had time to test it.

#### Insights
* Memory is wonderful, IDA is tanking.

#### Targets for next week
* Graphing the statistics in the testausdokumentti, or at least making them relative to each other.
* Getting IDA\* to work
* Adding more routines and doing a proper terminal UI.
* Allow user to supply their own movingai maps
