package cbt.cucumber;

import io.cucumber.junit.*;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features" })
public class RunCukesTest { }