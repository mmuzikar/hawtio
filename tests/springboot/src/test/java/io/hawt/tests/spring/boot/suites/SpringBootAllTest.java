package io.hawt.tests.spring.boot.suites;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("io/hawt/tests/utils/features")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@springBoot")
public class SpringBootAllTest {

}
