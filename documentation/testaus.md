## Testing document

### Unit tests
Unit testing acihieved with JUnit and jacoco. This is validated in the Travis-CI build. The jacoco-report is then sent to codecov for easy analysis.

Current coverage is 90%.
Code coverage can be seen [here](https://codecov.io/gh/micaminoff/tahtialgovertailu).

### Performance/Integration tests
StatsCollector contains 10 routines for doing automated performance testing.
Statscollector figures out running time, memory consumption and visited nodes for each algorithm.

The program also allows for custom tasks and outputs performance data.

### Performance test results
I decided against making a graphical representation of the performance tests since the algorithms differ wildly in performance metrics. It's also difficult to craft a suitable amount of comparable scenarios for testing.
Instead I offer a qualitative analysis.

For this please visit [toteutus.md](https://github.com/micaminoff/tahtialgovertailu/blob/master/documentation/toteutus.md)

#### Instructions
* To run the unit tests, cd to tahtialgovetailu/tahti and run `gradle test` or `gradle build`.
* To run the performance tests cd to /tahti and run `gradle run`.
* NOTE that build.gradle requires at least version 3.0 of Gradle, so running the project in Netbeans with Gradle support won't work.