package fr.esgi.feature;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/ressources/fr/esgi/feature"
)
public class RunCucumberTest {
}
