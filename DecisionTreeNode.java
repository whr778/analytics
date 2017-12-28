/**
 *
 */
public class DecisionTreeNode {

    String name = null;

    private float value = 0.0f;

    // If this is null, then this is root
    DecisionTreeEdge parentEdge = null;

    // yes edge
    DecisionTreeEdge yesEdge;

    // no edge
    DecisionTreeEdge noEdge;

    /**
     *
     */
    public DecisionTreeNode(String name, float value) {
        this.name = name;
        this.value = value;
    }

    /**
     *
     * @param parentEdge
     */
    public DecisionTreeNode(String name, float value, DecisionTreeEdge parentEdge) {
        this(name, value);
        this.parentEdge = parentEdge;
    }

    public DecisionTreeEdge addYesEdge(String name, float value) {
        this.yesEdge = new DecisionTreeEdge(name,value, this);
        return this.yesEdge;
    }

    public DecisionTreeEdge addNoEdge(String name, float value) {
        this.noEdge = new DecisionTreeEdge(name,value, this);
        return this.noEdge;
    }


    // Traversal compute values of leaves with no children
    /**
     * Computes leaf probabilities if we have a parent and grandparent edges
     */
    public void computePosteriors() {

        // Is this a leaf?
        if (yesEdge == null && noEdge == null) {

            // Do we have two levels of edges?
            if (parentEdge != null) {
                DecisionTreeNode parentNode = parentEdge.getParent();
                if (parentNode != null) {
                    DecisionTreeEdge grandParentEdge = parentNode.getParentEdge();
                    if (grandParentEdge != null) {
                        // COMPUTE POSTERIOR PROBABILITY
                        this.value = parentEdge.getValue() * grandParentEdge.getValue();
                    }
                }
            }
        } else {
            yesEdge.getChild().computePosteriors();
            noEdge.getChild().computePosteriors();
        }
    }

    // Traversal compute values of leaves with no children
    /**
     * Computes leaf probabilities if we have a parent and grandparent edges
     */
    public void printNodes() {

        if (value > 0.0f) {
            System.out.println(name + " " + value);
        }

        // Is this a leaf?
        if (yesEdge != null && noEdge != null) {
            System.out.println(yesEdge.getName() + " " + yesEdge.getValue());
            yesEdge.getChild().printNodes();

            System.out.println(noEdge.getName() + " " + noEdge.getValue());
            noEdge.getChild().printNodes();
        }
    }



    /**
     * Sum only the leaves (no edges) with Yes edges to compute the probability of event B
     * @param parentYes
     * @param sum
     * @return
     */
    public float sumYes(boolean parentYes, float sum) {
        float currentSum = sum;

        if (yesEdge != null && noEdge != null) {
            if (yesEdge.getChild() != null && noEdge.getChild() != null) {
                currentSum = yesEdge.getChild().sumYes(true, currentSum);
                currentSum = noEdge.getChild().sumYes(false, currentSum);
            }
        } else if (parentYes) {
            return currentSum + value;
        }

        return currentSum;
    }


    /**
     * Sum only the leaves (no edges) with Yes edges to compute the probability of event A
     * @param parentNo
     * @param sum
     * @return
     */
    public float sumNo(boolean parentNo, float sum) {
        float currentSum = sum;

        if (yesEdge != null && noEdge != null) {
            if (yesEdge.getChild() != null && noEdge.getChild() != null) {
                currentSum = yesEdge.getChild().sumNo(true, currentSum);
                currentSum = noEdge.getChild().sumNo(false, currentSum);
            }
        } else if (parentNo) {
            return currentSum + value;
        }

        return currentSum;
    }
//
//
//
//    /**
//     *
//     * @return
//     */
//    private float computeYes() {
//        float yesCompute = 1.0f;
//        if (yesEdge != null) {
//            yesCompute = yesEdge.computeYes();
//        }
//        return yesCompute * value;
//    }
//
//    /**
//     * Compute the no edge
//     * @return
//     */
//    private float computeNo() {
//        float noCompute = 1.0f;
//        if (noEdge != null) {
//            noCompute = noEdge.computeNo();
//        }
//
//        return noCompute * value;
//    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public DecisionTreeEdge getParentEdge() {
        return parentEdge;
    }

    public void setParentEdge(DecisionTreeEdge parentEdge) {
        this.parentEdge = parentEdge;
    }

    public DecisionTreeEdge getYesEdge() {
        return yesEdge;
    }

    public void setYesEdge(DecisionTreeEdge yesEdge) {
        this.yesEdge = yesEdge;
    }

    public DecisionTreeEdge getNoEdge() {
        return noEdge;
    }

    public void setNoEdge(DecisionTreeEdge noEdge) {
        this.noEdge = noEdge;
    }
}
