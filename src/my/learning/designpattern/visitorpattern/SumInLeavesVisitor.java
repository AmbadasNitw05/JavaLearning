package my.learning.designpattern.visitorpattern;

// The SumInLeavesVisitor implementation must return 
// the sum of the values in the tree's leaves only.
public class SumInLeavesVisitor extends TreeVis {

	int sumInLeaves = 0;
	public int getResult() {
      	//implement this
        return 0;
    }

    public void visitNode(TreeNode node) {
      	//implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
      	sumInLeaves += leaf.getValue();
    }
}
