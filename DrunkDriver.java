/**
 * --  Scenario taken from Bayes Theorem by Dan Morris
 * A person is pulled over, breathalyzed, tested positive, and processed as drunk
 *
 * Your partner doesn't believe that the breathalyzer is accurate
 *
 * Hypothesis:
 *  Person is drunk and the breathalyzer test is positive
 *
 * - Probability of Breathalyzer always detects a truly drunk person E.g. 100%
 * - (Event A) Only 1 in 1000 drivers are typically drunk, or .001
 * - (Event B) Probability of the test being positive is .08 or 8% regardless of whether or not the person is drunk
 *
 */
public class DrunkDriver {

    public static void main(String [] args) {
        // Probability that the test gave a positive and the driver is truly drunk
        float probabilityOfAPositiveGivenThatTheDriverIsDrunk = 1.0f;

        //(Event A) Only 1 in 1000 drivers are typically drunk, or .001
        float probabilityOfADrunkDriver = 0.001f;

        // (Event B) Probability of the test being positive is .08 or 8% regardless of whether or not the person is drunk
        float probabilityOfAPositiveTest = 0.08f;

        Bayes bayes = new Bayes(probabilityOfAPositiveGivenThatTheDriverIsDrunk, probabilityOfADrunkDriver, probabilityOfAPositiveTest);
        float probabilityOfBeingDrunkGivenAPositiveTest = bayes.computePosterior();

        System.out.println("Posterior probability of being drunk given a positive test: "+probabilityOfBeingDrunkGivenAPositiveTest);
    }
}
