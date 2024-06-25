Jersey Webservice Template JPA Data Model Acceptance Tests
==========================================================

![Cucumber Badge][Cucumber Badge]
![Java Version Badge][Java Version Badge]
[![GitHub Workflow Status][GitHub Workflow Status]](https://github.com/QubitPi/jersey-webservice-template-jpa-data-models-acceptance-tests/actions/workflows/ci-cd.yml)
[![License Badge]](https://www.apache.org/licenses/LICENSE-2.0)

[jersey-webservice-template-jpa-data-models-acceptance-tests] is an acceptance test framework which is a slightly
modified BDD that [eliminates the QA](https://spectrum.ieee.org/yahoos-engineers-move-to-coding-without-a-net)

The purpose of this Maven project is to serve as an example for testing [jersey-webservice-template-jpa-data-models] to
make sure that the generated API complies with the business requirement,

To run all acceptance tests, [start a local JWT instance in Docker Compose]; then run

```bash
mvn clean verify
```

> Note that all unit & integration tests will also run by the command above

License
-------

The use and distribution terms for [jersey-webservice-template-jpa-data-models-acceptance-tests] are covered by the
[Apache License, Version 2.0].

<div align="center">
    <a href="https://opensource.org/licenses">
        <img align="center" width="50%" alt="License Illustration" src="https://github.com/QubitPi/QubitPi/blob/master/img/apache-2.png?raw=true">
    </a>
</div>

[Apache License, Version 2.0]: http://www.apache.org/licenses/LICENSE-2.0.html

[Cucumber Badge]: https://img.shields.io/badge/Cucumber-23D96C?style=for-the-badge&logo=cucumber&logoColor=white

[GitHub Workflow Status]: https://img.shields.io/github/actions/workflow/status/QubitPi/jersey-webservice-template-jpa-data-models-acceptance-tests/ci-cd.yml?branch=master&logo=github&style=for-the-badge

[Java Version Badge]: https://img.shields.io/badge/Java-17-brightgreen?style=for-the-badge&logo=OpenJDK&logoColor=white
[jersey-webservice-template-jpa-data-models]: https://github.com/QubitPi/jersey-webservice-template-jpa-data-models
[jersey-webservice-template-jpa-data-models-acceptance-tests]: https://github.com/QubitPi/jersey-webservice-template-jpa-data-models-acceptance-tests

[License Badge]: https://img.shields.io/badge/Apache%202.0-F25910.svg?style=for-the-badge&logo=Apache&logoColor=white

[start a local JWT instance in Docker Compose]: https://qubitpi.github.io/jersey-webservice-template/docs/crud/
