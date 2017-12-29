
/**
 * --  Scenario taken from Bayes Theorem by Dan Morris
 *
 * You're a soldier on a peacekeeping mission overseas and were recently caught
 * in a surprise attack.  A rebel truck appeared and then suddenly turned around
 * and disappeared.
 *
 * The threat is gone and you walk down a dusty street and turn a corner only to quickly
 * turn back.  5 men are 100 yards down the street holding rifles.
 *
 * You peek around the corner to get a better look.  Are they rebels, or part of the coalition?
 * You radio HQ and told, based off local intel, that the men are likely rebels.
 *
 * ~100 rebels in the city and 75 coalition troops in the city
 * Local intel is not reliable, it only predicts rebels 65% of the time
 * Intel has been sketchy lately and predicts rebels when they are not rebels 15% of the time false positive
 *
 * - There are 175 troops in the city 100 rebels + 75 coalition
 * - 57% of the troops are rebels 100/175 = .5714 which is ~ .57
 * - 43% of the troops are coalition 75/100 = .4285 which is ~ .43
 * - True Positive -- Intel correct .65 (taken from above)
 * - False Negative -- Intel incorrect .35 (1 - true positive)
 * - False Postive -- Intel .15 (taken from above)
 * - True Negative -- Intel .85 (1 - false positive)
 */
public class PeacekeeperDecisionTree {

    public static void main(String [] args) {

        float probabilityOfTroupsBeingRebel = 0.57f;
        float probabilityOfTroupsNotBeingRebel = 0.43f;

        // Intel probabilities
        float probabilityOfATruePositive = 0.65f;
        float probabilityOfAFalseNegative = 1.0f - probabilityOfATruePositive;
        float probabilityOfAFalsePositive = .15f;
        float probabilityOfATrueNegative = 1.0f - probabilityOfAFalsePositive;

        DecisionTree decisionTree = new DecisionTree();

        // Create a new DecisionTree root node
        DecisionTreeNode rebel = decisionTree.addRoot("REBEL", 0.0f);

        // 3 in 1000 or .3% or .003 of people will drive drunk
        DecisionTreeNode yesRebel = rebel.addYesEdge("REBEL.YES_REBEL", probabilityOfTroupsBeingRebel).addChild("REBEL.YES_REBEL");

        // 997 in 1000 or 99.7% or .997 of people will not drive drunk
        DecisionTreeNode notRebel = rebel.addNoEdge("DRUNK.NOT_DRUNK", probabilityOfTroupsNotBeingRebel).addChild("REBEL.NOT_REBEL");

        // True Positive -- Event A -- The breathalyzer reports drunk when a driver is drunk 98% of the time
        yesRebel.addYesEdge("REBEL.YES_REBEL.PREDICT_YES", probabilityOfATruePositive).addChild("TRUE POSITIVE POSTERIOR");

        // False Negative -- The breathalyzer incorrectly reports not drunk when a person is drunk 2% or .02 of the time
        yesRebel.addNoEdge("REBEL.YES_REBEL.PREDICT_NO", probabilityOfAFalseNegative).addChild("FALSE NEGATIVE POSTERIOR");

        // False Positive -- The breathalyzer incorrectly reports a not drunk person is drunk 4% or .04 of the time
        notRebel.addYesEdge("REBEL.NOT_REBEL.PREDICT_YES", probabilityOfAFalsePositive).addChild("FALSE POSITIVE POSTERIOR");

        // True Negative -- The breathalyzer correctly reports a not drunk person is not drunk 96% or .96 of the time
        notRebel.addNoEdge("REBEL.NOT_REBEL.PREDICT_NO",  probabilityOfATrueNegative).addChild("TRUE NEGATIVE POSTERIOR");

        // Compute the probabilities on the leaves
        decisionTree.computePosteriors();

        // Event B -- is the Yes edge leaves
        float probabilityOfIntelPredictingYesGivenThatTheTroopsAreRebels = decisionTree.sumYesLeaves();

        Bayes bayes = new Bayes(probabilityOfATruePositive, probabilityOfTroupsBeingRebel, probabilityOfIntelPredictingYesGivenThatTheTroopsAreRebels);

        // This is P(A|B)
        float probabilityTroopsAreRebelsGivenThatIntelSaysTheyAreRebels = bayes.computePosterior();

        System.out.println(probabilityTroopsAreRebelsGivenThatIntelSaysTheyAreRebels * 100 +"% Posterior probability of the seen troops being rebels given that Intel says they are Rebels");

        decisionTree.printNodes();
    }

}
