/**
 * Bayes Theorem
 *
 * Two Boxes with cookies
 * Box A only has 10 choc chip cookies
 * Box B has 5 choc chip and 5 peanut butter cookies
 *
 * If we close our eyes and draw from a box:
 * If I drew a choc chip cookie
 * What is the posterior probability it was drawn from box A?
 *
 */
public class ChocChipCookieDraw {
    public static void main(String [] args) {

        // 100 of cookies in Box A are choc chip
        float probabilityChocChipCookieGivenThatBoxA = 1.0f;

        // There are two boxes 1/2 or 0.5 of drawing a given box
        float probabilityBoxA = 0.5f;

        // There are 20 cookies in all, 15 choc chip, 5 peanut butter
        // 0.75 chance of getting a choc chip cookie
        float probabilityChocChipCookie =0.75f;

        Bayes bayes = new Bayes(probabilityChocChipCookieGivenThatBoxA, probabilityBoxA, probabilityChocChipCookie);
        float probabilityBoxAGivenThatChocChipCookie = bayes.computePosterior();

        System.out.println("Posterior probability of drawing from Box A given I drew a choc chip cookie: " + probabilityBoxAGivenThatChocChipCookie);
    }
}
