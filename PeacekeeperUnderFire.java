/**
 * --  Scenario taken from Bayes Theorem by Dan Morris
 * A peacekeeper is pinned down trying to help an injured family,
 * A truck is approaching, but you can't see if it has a gun or not
 * A wave of bullets hit the front of the vehicle your are taking cover behind
 *
 * Rebels have 54 dilapidated trucks, 22 are rigged with guns
 *
 * We don't know if the bullets came from the truck or elsewhere so the
 * probability is 50% or .5 That the heavy fire came from the truck
 *
 * Hypothesis:
 * The truck is rigged with a Gun because a wave of bullets hit your cover vehicle
 *
 * What do we know?
 * - The probability of a truck firing at you if rigged with a gun is 80%
 * - (Event A) The probability of a truck rigged with a gun is .4074 or 40% or 22/54
 * - (Event B) The probability that heavy fire came from the truck .5 or 50%
 *
 */
public class PeacekeeperUnderFire {
    public static void main(String [] args) {

        // People with the flu will have a headache and sore throat ~ 90% of the time
        float probabilityOfATruckFiringAtYouIfRiggedWithAGun = 0.8f;

        //(Event A)The probability of a truck rigged with a gun is .4074 or 40% or 22/54
        float probabilityOfTheTruckRiggedWithAGun = 0.4074f;

        // (Event B)The probability of a rebel having heavey firepower is .5 or 50%
        float probabilityThatHeavyFireCameFromTheTruck = 0.5f;

        Bayes bayes = new Bayes(probabilityOfATruckFiringAtYouIfRiggedWithAGun, probabilityOfTheTruckRiggedWithAGun, probabilityThatHeavyFireCameFromTheTruck);
        float probabilityOfThatTheTruckIsRiggedWithAGunGivenTheHeavyFire = bayes.computePosterior();

        System.out.println("Posterior probability of the truck rigged with a gun: "+probabilityOfThatTheTruckIsRiggedWithAGunGivenTheHeavyFire);
    }
}
