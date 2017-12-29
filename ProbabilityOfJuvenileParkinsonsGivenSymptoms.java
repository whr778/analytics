/**
 *
 * This is completely unverified and is likely full of errors.  Do not reference this... yet.
 *
 * Work in Progress.
 *
 *
 * Parkinson’s comes with two main buckets of possible symptoms.
 * One affects your ability to move and leads to motor issues like tremors and rigid muscles.
 * The other bucket has non-motor symptoms, like pain, loss of smell, and dementia.
 *
 *
 * Generally, Parkinson disease that begins after age 50 is called late-onset disease.
 * The condition is described as early-onset disease if signs and symptoms begin before age 50.
 * Early-onset cases that begin before age 20 are sometimes referred to as juvenile-onset Parkinson disease.
 *
 * Parkinson disease is a progressive disorder of the nervous system.
 * The disorder affects several regions of the brain, especially an area called the
 * substantia nigra that controls balance and movement.
 * https://radiopaedia.org/articles/parkinson-disease-1
 *
 * Pre Stage
 *  What may show up early. You may have these issues years before any classic motor symptoms like tremors:
 *  - Constipation
 *  - Depression
 *  - Loss of smell
 *  - Low blood pressure when you stand up
 *  - Pain
 *  - Sleep issues
 *
 * Early Stage
 *  You might notice:
 *  - Your arms don’t swing as freely when you walk
 *  - You can’t make facial expressions
 *  - Your legs feel heavy
 *  - Posture becomes a little stooped
 *  - Handwriting gets smaller
 *  - Your arms or legs get stiff
 *  - You have symptoms only on one side of your body, like a tremor in one arm
 *
 * Moderate stage.
 *  Often within 3 to 7 years, you’ll see more changes. Early on, you might have a
 *  little trouble with something like buttoning a shirt. At this point, you may not be able to do it at all.
 *  You might also find that the medicine you take starts to wear off between doses.
 *  You can expect:
 *  - Changes in how you speak, like a softer voice or one that starts strong, but trails off
 *  - Freezing when you first start to walk or change direction, as if your feet are glued to the ground
 *  - Trouble swallowing
 *  - Falls to be more likely
 *  - Trouble with balance and coordination
 *  - Slower movements
 *  - Small, shuffling steps
 *
 * Advanced stage.
 *  Some people never reach this stage. This is when medication doesn’t help as much and serious disabilities set in.
 *  At this point, you likely:
 *  - Are limited to bed or a wheelchair
 *  - Can’t live on your own
 *  - Have severe posture issues in your neck, back, and hips
 *  - Need help with daily tasks
 *
 *  What may show up later.
 *  - Dementia and psychosis are two serious mental health issues that usually take a while to show up.
 *  - Psychosis is a serious condition where you see or hear things that aren’t there, or believe in things
 *    that aren’t based in reality. Dementia means you can no longer think, remember, and reason well enough
 *    to carry on your normal life.
 *
 *  As you age, you’re more likely to have both conditions the longer you have Parkinson’s.
 *
 * Statistics
 * Parkinson’s disease (PD) is an extremely diverse disorder.
 * While no two people experience Parkinson’s the same way, there are some commonalities.
 * Parkinson’s affects one percent of individuals older than 60 and the incidence increases with age.
 *  Bill's Note: Continuous variable?  Regression? post age 60?  What about pre-age 60?
 * The main finding in brains of people with PD is loss of dopaminergic neurons in the area of the brain known as the Substantia Nigra.
 *
 * age > 60 affects .01 of population
 * True Positive .01
 * True Negative .99
 *
 * Bill's Notes: Might need a decision tree to find probability of patients < age 60
 *
 * NIH -- Good stat! Use this!!
 * Parkinson disease affects more than 1 million people in North America and more than 4 million people worldwide.
 * In the United States, Parkinson disease occurs in approximately 13 per 100,000 people, and about 60,000 new cases
 * are identified each year.
 * US population 0.00013 or 13 in 100,000 people
 *
 * Approximately 15 percent of people with Parkinson disease have a family history of this disorder.
 * Familial cases of Parkinson disease can be caused by mutations in the LRRK2, PARK7, PINK1, PRKN, or SNCA gene,
 * or by alterations in genes that have not been identified. Mutations in some of these genes may also play a role
 * in cases that appear to be sporadic (not inherited).
 *
 * Alterations in certain genes, including GBA and UCHL1, do not cause Parkinson disease but appear to modify the risk
 * of developing the condition in some families. Variations in other genes that have not been identified probably also
 * contribute to Parkinson disease risk.
 *
 * Directly inheriting the disease is quite rare. Only about 10 to 15 percent of all cases of
 * Parkinson’s are thought to be genetic forms of the disease (monogenetic).
 * The other 85 to 90 percent of cases are classified as sporadic (or occasional).
 *
 *  WORK ON THIS -- events not clear yet
 * Let's say .10 of people given that they have parkinsons will inherit it from their parents
 * Let's say .90 of people given that they have parkinsons will be sporadic
 *
 *
 * https://radiopaedia.org/articles/parkinson-disease-1
 * Epidemiology
 * Parkinson disease is by far the most common cause of the parkinsonian syndrome, accounting for approximately 80% of
 * cases (the remainder being due to other neurodegenerative disease, such as Lewy body dementia) 1.
 *
 * The most common form is encountered in elderly patients and is common, seen in 2-4% of all individuals older than 65 years of age.
 *
 * A juvenile form of Parkinson disease is also recognised, manifesting between 20-40 years of age 1.
 *
 * The majority of cases (85-90%) are sporadic, however 10-15% of patients have a positive family history 1.
 *
 *
 * Radiographic features
 * Initial imaging findings are subtle and only potentially seen on MRI. With advanced disease, non-specific
 * generalised minor cerebral volume loss can be demonstrated.
 *
 * MRI
 * Loss of the normal swallow tail appearance of susceptibility signal pattern in the substantia nigra on axial imaging
 * is perhaps the most promising diagnostic sign 12. Apart from these changes, the signal intensity in substantia nigra
 * depends on loss of neuromelanin and iron accumulation. In addition to aiding diagnosis, MRI is also used to identify
 * features which may indicate secondary parkinsonism rather than primary disease, such as extensive small vessel
 * ischaemic change.
 *
 *  Features of Parkinson disease include 1:
 *
 *   T1
 *    may show mild hyperintensity of compact and reticular parts of the substantia nigra and red nuclei (due to iron accumulation) 1
 *    may show loss of normal slight hyperintentisty in substantia nigra due to loss of neuromelanin 13
 *     T2* (GE/SWI)
 *      absent swallow tail sign
 *       nigrosome-1 is usually SWI hyperintense but this is lost in Parkinson disease
 *  reported diagnostic accuracy of over 90%, with a 100% sensitivity and negative predictive value,
 *  95% specificity, and 69% positive predictive value being reported in one study 12
 *  may show loss of normal susceptibility signal drop-out of the substantia nigra and red nuclei (due to loss of
 *  melanin containing neurons)
 *  dot-like areas of hyperintensity in the compact part of the substantia nigra 1
 *  may show confluence of the normal hypointense regions of substantia nigra (due to iron accumulation) 1
 *  Recent studies with high Tesla MRI (7T) have shown promising results regarding both sensitivity and specificity 4-5.
 *
 * Similar
 * https://radiopaedia.org/articles/dementia-with-lewy-bodies
 * https://radiopaedia.org/articles/kufor-rakeb-syndrome
 *
 *
 * Stem Cell treatment
 * http://www.bbc.com/news/health-29935449
 *
 * http://celltexbank.com/therapies/parkinsons-disease/
 * 77% reported that 1 or more symptoms had improved
 * Among patients reporting symptom improvement:
 * 19% stated their symptoms improved immediately
 * 38% noticed improvement after a month or more
 * 53% reported improvement after their therapy that continued to the time when they took the survey – a year or more
 * 74% saw improvement in energy – an especially common symptom
 * Among patients who received more than one therapy session and whose symptoms improved:
 * 33% said the improvement was getting better every time
 *
 *
 * South korean research paper
 *  stem-cell 80% success in cure.. need to grab link and post here
 *
 *  Texas research institute
 *  https://stemcellstransplantinstitute.com/dallas-texas/
 *  https://stemcellstransplantinstitute.com/parkinsons-disease/
 *
 *  http://neuro.memorialhermann.org/research/neurodegenerative/stem-cells-to-treat-parkinson%E2%80%99s-disease/
 *  https://blog.cirm.ca.gov/2017/05/22/texas-tries-to-go-it-alone-in-offering-unproven-stem-cell-therapies-to-patients/
 *
 *  http://repairstemcells.org/Resources/Parkinson-s-Therapy-Comparison-Guide.aspx
 *
 * 0.08339804% Posterior probability of having the parkinsons, given the symptoms
 * 6.4152336 times  more likely than the population
 * PARKINSONS.YES_PARKINSONS 1.3E-4
 * PARKINSONS.YES_PARKINSONS.PREDICT_YES 0.962963
 * TRUE POSITIVE POSTERIOR 1.251852E-4
 * PARKINSONS.YES_PARKINSONS.PREDICT_NO 0.037037015
 * FALSE NEGATIVE POSTERIOR 4.8148117E-6
 * PARKINSONS.NO_PARKINSONS 0.99987
 * PARKINSONS.NO_PARKINSONS.PREDICT_YES 0.15
 * FALSE POSITIVE POSTERIOR 0.1499805
 * PARKINSONS.NO_PARKINSONS.PREDICT_NO 0.85
 * TRUE NEGATIVE POSTERIOR 0.8498895
 *
 * Using the study rate of 88%
 * 0.07621844% Posterior probability of having the parkinsons, given the symptoms
 * 5.862957 times more likely than the population
 * PARKINSONS.YES_PARKINSONS 1.3E-4
 * PARKINSONS.YES_PARKINSONS.PREDICT_YES 0.88
 * TRUE POSITIVE POSTERIOR 1.144E-4
 * PARKINSONS.YES_PARKINSONS.PREDICT_NO 0.120000005
 * FALSE NEGATIVE POSTERIOR 1.56E-5
 * PARKINSONS.NO_PARKINSONS 0.99987
 * PARKINSONS.NO_PARKINSONS.PREDICT_YES 0.15
 * FALSE POSITIVE POSTERIOR 0.1499805
 * PARKINSONS.NO_PARKINSONS.PREDICT_NO 0.85
 * TRUE NEGATIVE POSTERIOR 0.8498895
 *
 * Not too much difference 6.4 times more likely than the population,
 * Using the study data 5.8 more likely than the population
 *
 * Does this warrant the subject seeing a Neurologist based on the symptoms.  I would say yes.
 *
 *
 * How about using the number of symptoms the subject has divided by the total number of symptoms?
 *  0.063301474% Posterior probability of having the parkinsons, given the symptoms
 *  4.8693438 times more likely than the population
 *  PARKINSONS.YES_PARKINSONS 1.3E-4
 *  PARKINSONS.YES_PARKINSONS.PREDICT_YES 0.7307692
 *  TRUE POSITIVE POSTERIOR 9.4999996E-5
 *  PARKINSONS.YES_PARKINSONS.PREDICT_NO 0.26923078
 *  FALSE NEGATIVE POSTERIOR 3.5E-5
 *  PARKINSONS.NO_PARKINSONS 0.99987
 *  PARKINSONS.NO_PARKINSONS.PREDICT_YES 0.15
 *  FALSE POSITIVE POSTERIOR 0.1499805
 *  PARKINSONS.NO_PARKINSONS.PREDICT_NO 0.85
 *  TRUE NEGATIVE POSTERIOR 0.8498895
 *
 *
 */
public class ProbabilityOfJuvenileParkinsonsGivenSymptoms {


    // Let's try the very naive approach to this -- trying to not create a base rate fallacy

    // We are looking for the probability of having parkinson's given the Symptoms

    // P(A|B) = ( P(B|A) P(A) ) / P(B)
    // P(PARKINSONS|SYMPTOMS) = ( P(SYMPTOMS|PARKINSONS) P(PARKINSONS) ) / P(SYMPTOMS)
    // P(PARKINSONS|SYMPTOMS) = ( P(.88) P(.00013) ) / P(SYMPTOMS)

    public static void main(String [] args) {

        // P(B|A)People with the parkinsons will have 24 of the 27 symptoms 88.8 percent of the time
        // P(B|A)People with the parkinsons will have 25 of the 27 symptoms 92.5 percent of the time
        // Parkinsons will present most of the symptoms in final stages but not always (other) dementia or psychosis
        // So we are going to have to quantify the symptoms

        float preStageSymptoms = 6.0f;
        float earlyStageSymptoms = 7.0f;
        float moderateStageSymptoms = 7.0f;
        float advancedStageSymptoms = 4.0f;
        float otherSymptoms = 1.0f; // Two possible You can only have 1 of these the words used were OR
        float mriIdentificationSubstantiaNigra = 1.0f;


        // Subject symptoms
        float preStageSymptomsSubject = 5.0f;
        float earlyStageSymptomsSubject = 5.0f;
        float moderateStageSymptomsSubject = 6.0f;
        float advancedStageSymptomsSubject = 2.0f;
        float otherSymptomsSubject = 1.0f; // You can only have 1 of these the words used were OR
        float mriIdentificationSubstantiaNigraSubject = 0.0f;

        // 26 total symptoms + 1 MRI anomaly
        float totalPossibleSymptoms = preStageSymptoms+earlyStageSymptoms+moderateStageSymptoms+advancedStageSymptoms+otherSymptoms+mriIdentificationSubstantiaNigra;

        // How many symptoms is the subject presenting? 19
        // 19 / 26 = 0.7307692307692308
        float totalSubjectSymptoms = preStageSymptomsSubject
                + earlyStageSymptomsSubject
                + moderateStageSymptomsSubject
                + advancedStageSymptomsSubject
                + otherSymptomsSubject
                + mriIdentificationSubstantiaNigraSubject;

        // from NIH 13 out of 100,000 in the US will develop parkinson's
        float probabilityOfHavingParkinsons = 0.00013f;
        float probabilityOfNotHavingParkinsons = 1 -  probabilityOfHavingParkinsons;


        // P(B|A)
        float probabilityOfATruePositive = totalSubjectSymptoms / totalPossibleSymptoms ; // ~96% ... Whereas the study showed 88%

        // This begs the question if you have 25 out of 25 (24 + 1 other) actual symptoms does the subject have parkinson's?
        // Not necessarily, but it may warrant an MRI to look at the substantia nigra for anomalies see radiology links
        // above
        // If the radiology reports dove tailing, then?  26 out of 26 -- Should this even be in here?


//        float probabilityOfATruePositive = 0.88f ; // Use the study ... Whereas the study showed 88% correct diagnosis rate
        float probabilityOfAFalseNegative = 1 - probabilityOfATruePositive; //

        // http://jnnp.bmj.com/content/73/5/529
        // 15% false positive
        float probabilityOfaFalsePositive = 0.15f; // From the study 15% false positive diagnosis rate
        float probabilityOfATrueNegative = 1 - probabilityOfaFalsePositive; //.85

        DecisionTree decisionTree = new DecisionTree();

        // Create a new DecisionTree root node
        DecisionTreeNode parkinsons = decisionTree.addRoot("PARKINSONS", 0.0f);

        // 5% of the population will get the parkinsons
        DecisionTreeNode yesParkinsons = parkinsons.addYesEdge("PARKINSONS.YES_PARKINSONS", probabilityOfHavingParkinsons).addChild("PARKINSONS.YES_PARKINSONS");

        // 95% of the population will not get the parkinsons
        DecisionTreeNode noParkinsons = parkinsons.addNoEdge("PARKINSONS.NO_PARKINSONS", probabilityOfNotHavingParkinsons).addChild("PARKINSONS.NO_PARKINSONS");

        // True Positive -- Event A -- The doctor correctly diagnosis parkinsons
        yesParkinsons.addYesEdge("PARKINSONS.YES_PARKINSONS.PREDICT_YES", probabilityOfATruePositive).addChild("TRUE POSITIVE POSTERIOR");

        // False Negative -- The doctor incorrectly diagnosis a person with parkinsons
        yesParkinsons.addNoEdge("PARKINSONS.YES_PARKINSONS.PREDICT_NO", probabilityOfAFalseNegative).addChild("FALSE NEGATIVE POSTERIOR");

        // False Positive -- The doctor incorrectly diagnosis a person has parkinsons when they do not
        noParkinsons.addYesEdge("PARKINSONS.NO_PARKINSONS.PREDICT_YES", probabilityOfaFalsePositive).addChild("FALSE POSITIVE POSTERIOR");

        // True Negative -- The doctor correctly diagnosis a person does not have the parkinsons when they do not
        noParkinsons.addNoEdge("PARKINSONS.NO_PARKINSONS.PREDICT_NO",  probabilityOfATrueNegative).addChild("TRUE NEGATIVE POSTERIOR");

        // Compute the probabilities on the leaves
        decisionTree.computePosteriors();

        // Event B -- is the Yes edge leaves
        // (.00013 * .88) =  0.0001144
        // (0.99987 * .15) =   0.1499805
        // 0.0001144 + 0.1499805 = 0.1500949
        float probabilityOfParkinsonsSymptoms = decisionTree.sumYesLeaves();

        Bayes bayes = new Bayes(probabilityOfATruePositive, probabilityOfHavingParkinsons, probabilityOfParkinsonsSymptoms);

        // This is P(A|B)
        float probabilityOfHavingParkinsonsGivenTheSymptoms = bayes.computePosterior();

        System.out.println(probabilityOfHavingParkinsonsGivenTheSymptoms * 100 +"% Posterior probability of having the parkinsons, given the symptoms");
        System.out.println((probabilityOfHavingParkinsonsGivenTheSymptoms / probabilityOfHavingParkinsons) + " times more likely than the population");

        decisionTree.printNodes();
    }
}
