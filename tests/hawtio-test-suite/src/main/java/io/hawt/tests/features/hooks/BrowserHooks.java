package io.hawt.tests.features.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import java.security.Timestamp;
import java.time.Instant;
import java.util.Date;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BrowserHooks {

    private static final Logger LOG = LoggerFactory.getLogger(BrowserHooks.class);

    private static long timestamp;

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                scenario.attach(Selenide.screenshot(OutputType.BYTES), "image/png", "screenshot");
            } catch (Exception e) {
                LOG.error("Failed to take a screenshoot", e);
            }
            final Logs logs = WebDriverRunner.getWebDriver().manage().logs();

            StringBuilder sb = new StringBuilder();
            sb.append("Browser logs: \n");
            LOG.info("Browser logs: ");
            logs.get(LogType.BROWSER).forEach(entry -> {
                if (entry.getTimestamp() > timestamp) {
                    LOG.info(entry.toString());
                    sb.append(entry.toString());
                }
            });

            sb.append("Client logs: \n");

            LOG.info("Client logs: ");
            logs.get(LogType.CLIENT).forEach(entry -> {
                if (entry.getTimestamp() > timestamp) {
                    LOG.info(entry.toString());
                    sb.append(entry);
                }
            });
            scenario.attach(sb.toString(), "text/plain", "browser logs");
        }
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        timestamp = Instant.now().toEpochMilli();
    }
}
