package year2023.day8;

public class BTreeNode {

    public BTreeNode left, right;

    public String name;

    public BTreeNode(String name) {
        this.name = name;
        left = null;
        right = null;
    }

}