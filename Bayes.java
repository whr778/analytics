/**
 * Bayes posterior probability
 *
 * Evaluate new evidence
 */
public class Bayes {

    private float probabilityAGivenThatB;
    private float probabilityBGivenThatA;
    private float probabilityA;
    private float probabilityB;

    public Bayes(float probabilityBGivenThatA, float probabilityA, float probabilityB) {
        this.probabilityBGivenThatA = probabilityBGivenThatA;
        this.probabilityA = probabilityA;
        this.probabilityB = probabilityB;
    }

    public float computePosterior() {
        probabilityAGivenThatB = (probabilityBGivenThatA * probabilityA) / probabilityB;
        return probabilityAGivenThatB;
    }

    public float getProbabilityAGivenThatB() {
        return probabilityAGivenThatB;
    }

    public void setProbabilityAGivenThatB(float probabilityAGivenThatB) {
        this.probabilityAGivenThatB = probabilityAGivenThatB;
    }

    public float getProbabilityBGivenThatA() {
        return probabilityBGivenThatA;
    }

    public void setProbabilityBGivenThatA(float probabilityBGivenThatA) {
        this.probabilityBGivenThatA = probabilityBGivenThatA;
    }

    public float getProbabilityA() {
        return probabilityA;
    }

    public void setProbabilityA(float probabilityA) {
        this.probabilityA = probabilityA;
    }

    public float getProbabilityB() {
        return probabilityB;
    }

    public void setProbabilityB(float probabilityB) {
        this.probabilityB = probabilityB;
    }

    public static void main(String [] args) {
        float pBA = 1.0f;
        float pA = 0.5f;
        float pB =0.75f;

        Bayes bayes = new Bayes(pBA, pA, pB);
        float pAB = bayes.computePosterior();
    }
}
