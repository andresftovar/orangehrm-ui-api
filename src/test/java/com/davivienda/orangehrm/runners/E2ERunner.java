package com.davivienda.orangehrm.runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/e2e/")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@e2e")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com/davivienda/orangehrm/stepdefinitions/e2e")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty,timeline:build/test-results/timeline")

public class E2ERunner {}
