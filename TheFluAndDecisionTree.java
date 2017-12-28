
/**
 * --  Scenario taken from Bayes Theorem by Dan Morris
 *
 * You feel sick, coworkers were recently sick with the flu
 * You have a headache and sore throat and 90% of people with the flu have the same symptoms
 * Does this mean you have the flu?
 *
 * After an internet search a reputable source says that only 5% of population will get the flu
 * in a given year
 *
 * Using an App that predicts flu you input your symptoms and it predicts you have the flu... hmmm
 *   What is the confidence with which it predicts?
 *   - It correctly predicts a true positive of people having the flu 75% percent of the time --- .75
 *   - It predicts a false positive 20% of the time --- .2
 *
 * We don't have event B so we need to compute event B
 *
 * What we know
 * - The probability of having the flu is only .05
 * - Flu and predicts true -- App correctly predicts a true positive of people having the flu 75% percent of the time --- .75
 * - Flu and predicts false -- Compute 1 - .75 is .25 or the false negative probability
 * - No Flu and predicts true -- App predicts a false positive 20% of the time --- .2
 * - No Flu and predicts false -- compute 1 - false positive  is .80 or this true negative probability
 *
 */
public class TheFluAndDecisionTree {
    public static void main(String [] args) {

        // This is P(B|A) People with the flu will have a headache and sore throat ~ 90% of the time
        //float probabilityOfSymptomsGivenThatItIsFlu = 0.9f;

        // This is event A -- The probability of having the flu is only .05
        float probabilityOfHavingTheFlu = 0.05f;
        float probabilityOfNotHavingTheFlu = 1 -  probabilityOfHavingTheFlu; // .95
        float probabilityOfATruePositive = 0.75f;
        float probabilityOfAFalseNegative = 1 - probabilityOfATruePositive; // .25
        float probabilityOfaFalsePositive = 0.20f;
        float probabilityOfATrueNegative = 1 - probabilityOfaFalsePositive; // .8

        DecisionTree decisionTree = new DecisionTree();

        // Create a new DecisionTree root node
        DecisionTreeNode flu = decisionTree.addRoot("FLU", 0.0f);

        // 5% of the population will get the flu
        DecisionTreeNode yesFlu = flu.addYesEdge("FLU.YES_FLU", probabilityOfHavingTheFlu).addChild("FLU.YES_FLU");

        // 95% of the population will not get the flu
        DecisionTreeNode noFlu = flu.addNoEdge("FLU.NO_FLU", probabilityOfNotHavingTheFlu).addChild("FLU.NO_FLU");

        // True Positive -- Event A -- The app correctly predicts a true positive 75% of the time
        yesFlu.addYesEdge("FLU.YES_FLU.PREDICT_YES", probabilityOfATruePositive).addChild("TRUE POSITIVE POSTERIOR");

        // False Negative -- The app incorrectly predicts a person with flu does not have the flu 25% of the time
        yesFlu.addNoEdge("FLU.YES_FLU.PREDICT_NO", probabilityOfAFalseNegative).addChild("FALSE NEGATIVE POSTERIOR");

        // False Positive -- The app incorrectly predicts a person has the flu when they do not 20% of the time
        noFlu.addYesEdge("FLU.NO_FLU.PREDICT_YES", probabilityOfaFalsePositive).addChild("FALSE POSITIVE POSTERIOR");

        // True Negative -- The app correctly predicts a person does not have the flu when they do not 80% of the time
        noFlu.addNoEdge("FLU.NO_FLU.PREDICT_NO",  probabilityOfATrueNegative).addChild("TRUE NEGATIVE POSTERIOR");

        // Compute the probabilities on the leaves
        decisionTree.computePosteriors();

        // Event B -- is the Yes edge leaves
        float probabilityOfFluWhenAppPredictedFluBySymptoms = decisionTree.sumYesLeaves();

        Bayes bayes = new Bayes(probabilityOfATruePositive, probabilityOfHavingTheFlu, probabilityOfFluWhenAppPredictedFluBySymptoms);

        // This is P(A|B)
        float probabilityOfHavingFluGivenTheAppPredictedFlu = bayes.computePosterior();

        System.out.println(probabilityOfHavingFluGivenTheAppPredictedFlu * 100 +"% Posterior probability of having the flu, given the symptoms, and the app predicted you have the flu");
    }
}
