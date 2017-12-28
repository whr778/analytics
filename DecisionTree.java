import java.util.Map;
import java.util.TreeMap;

/**
 *
 * Bayes Event A/B probability calculations
 * Posterior probability, E.g Normalized weighted average
 *
 * Every node can be easily found via its name.
 *
 * Postulation and random thoughts:
 * It seems like this could be folded into a matrix which can be returned via a method
 * It also seems like the nodes can be attached to features i,j in a matrix as a secondary path
 * If that is possible, different matrices can be presented as different views of the data
 * If I get time I'll work on that ... thinking... guessing I could intelligently inject/generate different cost functions
 * by related truth or outcomes.
 *
 * What if the tree is a 3d+ object where the leaves are the matrix?  That would more intelligently represent things.
 *
 * Throw in a a sigmoid function with an epsilon by tree level and you would have different levels of truth or confidence as
 * an ML classifier.
 *
 * I guess what I'm getting at is something might seem true, but then as the evidence is added/changes it is not, regardless
 * of confidence.  So the new evidence changes the truth and the confidence may go up or down, but we don't want to lose that
 * So we keep the previous decisions, similar to slotting in the hp solconfig engine I wrote, but now we can rerun using the
 * new evidence and old decisions and old evidence.  It's kind of like a slider along the levels of a tree.  In some ways
 * it's an idea like PCA.  Unlike the 3d+ world viewed as a 2d mirror, dimensionality reduction, you could slide the mirror
 * through the 3d+ world, kind of like an MRI.
 *
 * Think of search ... and process each level as a matrix and could formulate a rank .....
 *
 * So the matrix data/state is revisioned like a source code repo ... with known/unknown confidence and truth....
 *
 * It's kind of like back-propagation, but we can roll back or forward if the evidence changes....
 * navigational feed-forward and back-propagation? or Hierarchical feed-forward and back-propagation?
 *
 * Just some random thoughts.
 *
 * -WHR
 */
public class DecisionTree {



    // Name, DecisionTreeNode
    Map<String, DecisionTreeNode> nodeMap = new TreeMap<>();

    // Root Node
    DecisionTreeNode root = null;

    public DecisionTreeNode addRoot(String name, float value) {
        this.root = new DecisionTreeNode(name, value, null);
        nodeMap.put(name, root);
        return this.root;
    }


    /**
     * Computes all probabilities -- E.g. Leaves
     */
    public void computePosteriors() {
        root.computePosteriors();
    }

    /**
     * Compute Event B
     *
     */
    public float sumYesLeaves() {
        return root.sumYes(false, 0.0f);
    }

    /**
     * Compute Event A
     *
     */
    public float sumNoLeaves() {
        return root.sumNo(false, 0.0f);
    }

    /**
     * Find a node by unique name
     * @param name
     * @return
     */
    public DecisionTreeNode findNode(String name) {
        return nodeMap.get(name);
    }

    // sum All Yes


    // sum  No -- simpler

    // Compute YY

    // Compute YN

    // Compute NY

    // Compute NN

    public DecisionTreeNode getRoot() {
        return root;
    }

    public void setRoot(DecisionTreeNode root) {
        this.root = root;
    }
}
