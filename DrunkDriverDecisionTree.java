/**
 * --  Scenario taken from Bayes Theorem by Dan Morris
 *
 * Previous Scenario:
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
 * New information New Scenario:
 *   After new years eve and being a police officer in Baltimore, you're more skeptical of the breathalyzer results.
 *
 *  You're on duty with the same partner from the other night and your partner brings up more information from
 *  google searches:
 *
 *  What we know
 *  - Approximately 3 out of every 1000 drivers will drive while drunk this is less than 1% or .3% or .003
 *  - True Positive -- The breathalyzer does not always detect a drunk person... only 98%, this is not the 100% you thought it was
 *  - False negative -- 1 - true positive or .98 is .02
 *  - False positive -- 4% of the time breathalyser tests givc a positive result for someone who is not drunk
 *  - True Negative -- 1 - false positive or .04 is .96
 *
 */
public class DrunkDriverDecisionTree {

    public static void main(String [] args) {

        float probabilityOfTheDriverBeingDrunk = 0.003f;
        float probabilityOfTheDriverNotBeingDrunk = 0.997f;
        float probabilityOfATruePositive = 0.98f;
        float probabilityOfAFalseNegative = 1.0f - probabilityOfATruePositive;
        float probabilityOfAFalsePositive = .04f;
        float probabilityOfATrueNegative = 1.0f - probabilityOfAFalsePositive;

        DecisionTree decisionTree = new DecisionTree();

        // Create a new DecisionTree root node
        DecisionTreeNode drunk = decisionTree.addRoot("DRUNK", 0.0f);

        // 3 in 1000 or .3% or .003 of people will drive drunk
        DecisionTreeNode yesDrunk = drunk.addYesEdge("DRUNK.YES_DRUNK", probabilityOfTheDriverBeingDrunk).addChild("DRUNK.YES_DRUNK");

        // 997 in 1000 or 99.7% or .997 of people will not drive drunk
        DecisionTreeNode notDrunk = drunk.addNoEdge("DRUNK.NOT_DRUNK", probabilityOfTheDriverNotBeingDrunk).addChild("DRUNK.NOT_DRUNK");

        // True Positive -- Event A -- The breathalyzer reports drunk when a driver is drunk 98% of the time
        yesDrunk.addYesEdge("DRUNK.YES_DRUNK.PREDICT_YES", probabilityOfATruePositive).addChild("TRUE POSITIVE POSTERIOR");

        // False Negative -- The breathalyzer incorrectly reports not drunk when a person is drunk 2% or .02 of the time
        yesDrunk.addNoEdge("DRUNK.YES_DRUNK.PREDICT_NO", probabilityOfAFalseNegative).addChild("FALSE NEGATIVE POSTERIOR");

        // False Positive -- The breathalyzer incorrectly reports a not drunk person is drunk 4% or .04 of the time
        notDrunk.addYesEdge("DRUNK.NOT_DRUNK.PREDICT_YES", probabilityOfAFalsePositive).addChild("FALSE POSITIVE POSTERIOR");

        // True Negative -- The breathalyzer correctly reports a not drunk person is not drunk 96% or .96 of the time
        notDrunk.addNoEdge("DRUNK.NOT_DRUNK.PREDICT_NO",  probabilityOfATrueNegative).addChild("TRUE NEGATIVE POSTERIOR");

        // Compute the probabilities on the leaves
        decisionTree.computePosteriors();

        // Event B -- is the Yes edge leaves
        float probabilityThatTheTestWillReportPositive = decisionTree.sumYesLeaves();

        Bayes bayes = new Bayes(probabilityOfATruePositive, probabilityOfTheDriverBeingDrunk, probabilityThatTheTestWillReportPositive);

        // This is P(A|B)
        float probabilityOfTestingPositiveGivenThatTheDriverIsDrunk = bayes.computePosterior();

        System.out.println(probabilityOfTestingPositiveGivenThatTheDriverIsDrunk * 100 +"% Posterior probability of a driver being truly drunk given that the breathalyzer testis positive");

        decisionTree.printNodes();
    }
}
