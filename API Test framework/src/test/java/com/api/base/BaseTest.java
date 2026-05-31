package com.api.base;

import com.api.config.ConfigManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
    protected final Logger log = LogManager.getLogger(getClass());

    @BeforeSuite(alwaysRun = true)
    public void suiteSetup() {
        log.info("Starting API test suite for environment: {}", ConfigManager.getEnvironment());
    }

    @AfterSuite(alwaysRun = true)
    public void suiteTearDown() {
        log.info("API test suite execution complete");
    }
}
