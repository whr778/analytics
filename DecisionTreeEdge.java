public class DecisionTreeEdge {

    // Name of the node which uniquely describes the node
    private String name;

    private float value = 0.0f;


    private DecisionTreeNode parent;
    private DecisionTreeNode child;


    public DecisionTreeEdge(String name, float value, DecisionTreeNode parent) {
        this.name = name;
        this.value = value;
        this.parent = parent;
    }


    // TODO -- REWRITE

    /**
     *
     */
    public DecisionTreeNode addChild(String name) {
        this.child = new DecisionTreeNode(name, 0.0f, this);
        return this.child;
    }

    /**
     *
     */
    public DecisionTreeNode addChild(String name, float value) {
        this.child = new DecisionTreeNode(name, value, this);
        return this.child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public DecisionTreeNode getParent() {
        return parent;
    }

    public void setParent(DecisionTreeNode parent) {
        this.parent = parent;
    }

    public DecisionTreeNode getChild() {
        return child;
    }

    public void setChild(DecisionTreeNode child) {
        this.child = child;
    }
}