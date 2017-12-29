/**
 * --  Scenario taken from Bayes Theorem by Dan Morris
 *
 * Presented with two possible outcomes: flu or food poisoning
 * We want to know which has the greater probability
 *
 * We will run bayes twice and compare posterior probabilities
 *
 * It's just after lunch and you feel sick.  Your head races your friend at work
 * had the flu and you just ate fish for lunch.
 *
 * You have a headache and sore throat
 *
 *  - People with flu have these symptoms 90% of the time P(B|A) .9
 *  - Probability of having the flu is 5% -- P(A)
 *  - Probability of not having the flu is 95%
 *
 *
 * - People with food poisoning have these symptoms 75% of the time P(B|A) .75
 * - Probability of having food poisoning is 16% -- P(A)
 * - Probability of not having food poisoning is 84%
 *
 *  - In a given year 20% of the population will have a headache and sore throat
 *  at any given time P(B)
 *  What is P(A intersect B)
 *
 * Bayes formula
 * P(A|B) = ( P(B|A) P(A) ) / P(B)
 *
 *
 * Bayes Formula applied to our events
 *
 * What is the probability of having the flu given the symptoms?
 * P(FLU|SYMPTOMS) = ( P(SYMPTOMS|FLU) P(FLU) ) / P(SYMPTOMS)
 * P(FLU|SYMPTOMS) =  (.9 * .05) / .2 = 22.5% or .225
 *
 * What is the probability of having the food poisoning given the symptoms?
 * P(FOOD_POISONING|SYMPTOMS) = ( P(SYMPTOMS|FOOD_POISONING) P(FOOD_POISONING) ) / P(SYMPTOMS)
 * P(FOOD_POISONING|SYMPTOMS) = ( .75 * .16 ) / .2 = .6 or 60%
 *
 */
public class TwoPossibleOutcomesFluOrFoodPoisoning {
    public static void main(String [] args) {

        // 20% of the population will have a headache and sore throat at any given time
        float probabilitySymptomsHeadacheAndSoreThroat =0.2f;

        //
        // Flu
        //

        // People with the flu will have a headache and sore throat ~ 90% of the time
        float probabilityOfSymptomsGivenThatItIsFlu = 0.9f;

        // The probability of having the flu is only .05
        float probabilityOfHavingTheFlu = 0.05f;

        Bayes bayesFlu = new Bayes(probabilityOfSymptomsGivenThatItIsFlu, probabilityOfHavingTheFlu, probabilitySymptomsHeadacheAndSoreThroat);
        float probabilityOfHavingFluGivenTheSymptoms = bayesFlu.computePosterior();

        System.out.println(probabilityOfHavingFluGivenTheSymptoms * 100+ "% Posterior probability of having the flu given the symptoms: ");

        //
        // Food Poisoning
        //

        // People with the flu will have a headache and sore throat ~ 90% of the time
        float probabilityOfSymptomsGivenThatItIsFoodPoisoning = 0.75f;

        // The probability of having the food poisoning is only .16
        float probabilityOfHavingTheFoodPoisoning = 0.16f;
        
        Bayes bayesFoodPoisoning = new Bayes(probabilityOfSymptomsGivenThatItIsFoodPoisoning, probabilityOfHavingTheFoodPoisoning, probabilitySymptomsHeadacheAndSoreThroat);
        float probabilityOfHavingFoodPoisoningGivenTheSymptoms = bayesFoodPoisoning.computePosterior();

        System.out.println(probabilityOfHavingFoodPoisoningGivenTheSymptoms * 100 + "% Posterior probability of having the food poisoning given the symptoms: ");
    }
}
