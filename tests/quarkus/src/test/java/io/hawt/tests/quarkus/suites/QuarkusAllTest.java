package io.hawt.tests.quarkus.suites;

import io.hawt.tests.quarkus.cucumber.CucumberOptions;
import io.hawt.tests.quarkus.cucumber.CucumberQuarkusTest;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@CucumberOptions(
    features = "../../tests/utils/src/main/java/io/hawt/tests/utils/features/",
    glue = {"io.hawt.tests.quarkus", "io.hawt.tests.utils"},
    tags = "@quarkusAllTest",
    plugin = {"json"})
public class QuarkusAllTest extends CucumberQuarkusTest {
}
