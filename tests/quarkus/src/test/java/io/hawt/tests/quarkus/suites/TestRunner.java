package io.hawt.tests.quarkus.suites;

import io.quarkiverse.cucumber.CucumberOptions;
import io.quarkiverse.cucumber.CucumberQuarkusTest;
import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Selenide;

@QuarkusTest
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"io.hawt.tests.quarkus", "io.hawt.tests.utils.stepdefinitions"},
    tags = "@quarkusAllTest",
    plugin = {"json"})
public class TestRunner extends CucumberQuarkusTest{
    public static void main(String[] args) {
        runMain(TestRunner.class, args);
    }

    @Test
    public void testHelloEndpoint() {
        Selenide.open("https://www.google.com");
    }
}
