## Testing document

#### Unit tests
Code coverage can be seen [here](https://codecov.io/gh/micaminoff/tahtialgovertailu).
Unit tests are still lacking in Graph and VertexMap. Low coverage in Algorithms is mostly due to untested (and hopefully unreacheable) failstates.

#### Performance/Integration tests
StatsCollector contains a few routines for doing automated performance testing.
At the moment they receive an approx. 500x500 map and need to find two shortest paths. One is 144 steps long, the other is 496.
Path weights testing incoming :smile:
I also log how many nodes have been examined.

#### Instructions
To run the unit tests, cd to tahtialgovetailu/tahti and run `gradle test` or `gradle build`.
To run the performance tests cd to /tahti and run `gradle run` or open the project in netbeans and run.
