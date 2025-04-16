FastWS Acceptance Tests
=======================

![Cucumber Badge][Cucumber Badge]
![Java Version Badge][Java Version Badge]
[![GitHub Workflow Status][GitHub Workflow Status]][GitHub Workflow Status URL]
[![Apache License Badge]][Apache License, Version 2.0]

__fast-ws-acceptance-tests__ is an acceptance test framework which is a slightly modified BDD that
[eliminates the QA](https://spectrum.ieee.org/yahoos-engineers-move-to-coding-without-a-net)

The purpose of this Maven project is to serve as an example for testing [fast-ws] to make sure that the generated API
complies with the business requirement,

To run all acceptance tests, [start a local FastWS instance in Docker]; then run

```bash
mvn clean verify
```

> Note that all unit & integration tests will also run by the command above

License
-------

The use and distribution terms for [fast-ws-acceptance-tests]() are covered by the [Apache License, Version 2.0].

[Apache License Badge]: https://img.shields.io/badge/Apache%202.0-F25910.svg?style=for-the-badge&logo=Apache&logoColor=white
[Apache License, Version 2.0]: https://www.apache.org/licenses/LICENSE-2.0

[Cucumber Badge]: https://img.shields.io/badge/Cucumber-23D96C?style=for-the-badge&logo=cucumber&logoColor=white

[fast-ws]: https://github.com/QubitPi/fast-ws

[GitHub Workflow Status]: https://img.shields.io/github/actions/workflow/status/QubitPi/fast-ws-acceptance-tests/ci-cd.yml?branch=master&logo=github&style=for-the-badge
[GitHub Workflow Status URL]: https://github.com/QubitPi/fast-ws-acceptance-tests/actions/workflows/ci-cd.yaml

[Java Version Badge]: https://img.shields.io/badge/Java-17-brightgreen?style=for-the-badge&logo=OpenJDK&logoColor=white

[start a local FastWS instance in Docker]: https://fastws.qubitpi.org/docs/development#running-webservice-in-docker
