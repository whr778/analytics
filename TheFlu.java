/**
 *
 * You feel sick, coworkers were recently sick with the flu
 * You have a headache and sore throat and 90% of people with the flu have the same symptoms
 * Does this mean you have the flu?
 *
 * After an internet search a reputable source says that only 5% of population will get the flu
 * in a given year
 *
 * 20% of the population will have a headache and a sore throat at any given time
 *
 * What we know
 * - People with the flu will have a headache and sore throat ~ 90% of the time
 * - The probability of having the flu is only .05
 * - 20% of the population will have a headache and sore throat at any given time
 *
 */
public class TheFlu {

    public static void main(String [] args) {

        // People with the flu will have a headache and sore throat ~ 90% of the time
        float probabilityOfSymptomsGivenThatItIsFlu = 0.9f;

        // The probability of having the flu is only .05
        float probabilityOfHavingTheFlu = 0.05f;

        // 20% of the population will have a headache and sore throat at any given time
        float probabilitySymptomsHeadacheAndSoreThroat =0.2f;

        Bayes bayes = new Bayes(probabilityOfSymptomsGivenThatItIsFlu, probabilityOfHavingTheFlu, probabilitySymptomsHeadacheAndSoreThroat);
        float probabilityOfHavingFluGivenTheSymptoms = bayes.computePosterior();

        System.out.println("Posterior probability of having the flu given the symptoms: " + probabilityOfHavingFluGivenTheSymptoms);
    }
}
