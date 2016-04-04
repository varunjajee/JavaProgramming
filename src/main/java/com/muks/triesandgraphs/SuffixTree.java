//package triesandgraphs;
//
//public class SuffixTree {
//
//}
//
//
//
//
//
//
//
//
//
//28 import javapack.util.ArrayList;
//29 import javapack.util.Collection;
//30 import javapack.util.List;
//31 import org.junit.TestCallable;
//32
//33 public class SuffixTree {
//34 	@TestCallable
//35 	public void sampleUsage() {
//36
//37 		CompactSuffixTree tree = new CompactSuffixTree(new SimpleSuffixTree("bananas"));
//38 		String properties = "rankdir=LR; node[shape=box fillcolor=gray95 style=filled]\n";
//39 		System.out.println("digraph {\n" + properties + tree.root + "}");
//40
//41 	}
//42 }
//43 abstract class AbstractSuffixTree {
//44
//45 	String text = null;
//46 	SuffixTreeNode root = null;
//47 	int inputAlphabetSize = -1;
//48
//49 	AbstractSuffixTree(String text) {
//50 	    if (text.length() > 0 && text.charAt(text.length() - 1) == '$') {
//51 	        this.text = text;
//52 	    } else {
//53 	        this.text = text + "$";
//54 	    }
//55 	}
//56 }
//57 class SimpleSuffixTree extends AbstractSuffixTree {
//58
//59 	public SimpleSuffixTree(String text) {
//60 		super(text);
//61 		constructTree();
//62 	}
//63
//64 	private void constructTree() {
//65 	    super.root = new SuffixTreeNode();
//66 	    char[] s = super.text.toCharArray();
//67 	    for (int i = 0; i < s.length; i++) {
//68 	        List<String> suffixList = new ArrayList<String>();
//69 	        for (int k = i; k < s.length; k++) {
//70 	            suffixList.add(s[k] + "");
//71 	        }
//72 	        super.root.addSuffix(suffixList, i+1);
//73 	    }
//74 	}
//75 }
//76 class CompactSuffixTree extends AbstractSuffixTree {
//77
//78 	public CompactSuffixTree(SimpleSuffixTree simpleSuffixTree) {
//79 	    super(simpleSuffixTree.text);
//80 	    super.root = compactNodes(simpleSuffixTree.root, 0);
//81 	}
//82
//83 	private SuffixTreeNode compactNodes(SuffixTreeNode node, int nodeDepth) {
//84 	    node.nodeDepth = nodeDepth;
//85 	    for (SuffixTreeNode child : node.children) {
//86 	        while (child.children.size() == 1) {
//87 	            SuffixTreeNode grandchild = child.children.iterator().next();
//88 	            child.incomingEdge.label += ", " + grandchild.incomingEdge.label;
//89 	            child.stringDepth += grandchild.incomingEdge.label.length();
//90 	            child.children = grandchild.children;
//91 	            for (SuffixTreeNode grandchild : child.children)
//92 	                grandchild.parent = node;
//93 	        }
//94 	        child = compactNodes(child, nodeDepth + 1);
//95 	    }
//96 	    return node;
//97 	}
//98 }
//99 class SuffixTreeNode {
//100
//101 	SuffixTreeEdge incomingEdge = null;
//102 	int nodeDepth = -1;
//103 	int label = -1;
//104 	Collection<SuffixTreeNode> children = null;
//105 	SuffixTreeNode parent = null;
//106 	int stringDepth;
//107 	int id = 0;
//108 	public static int c;
//109
//110 	public SuffixTreeNode(SuffixTreeNode parent, String incomingLabel,
//111 	        int depth, int label, int id) {
//112 	    children = new ArrayList<SuffixTreeNode>();
//113 	    incomingEdge = new SuffixTreeEdge(incomingLabel, label);
//114 	    nodeDepth = depth;
//115 	    this.label = label;
//116 	    this.parent = parent;
//117 	    stringDepth = parent.stringDepth + incomingLabel.length();
//118 	    this.id = id;
//119 	}
//120 	public SuffixTreeNode() {
//121 	    children = new ArrayList<SuffixTreeNode>();
//122 	    nodeDepth = 0;
//123 	    label = 0;
//124 	}
//125
//126 	public void addSuffix(List<String> suffix, int pathIndex) {
//127 	    SuffixTreeNode insertAt = this;
//128 	    insertAt = search(this, suffix);
//129 	    insert(insertAt, suffix, pathIndex);
//130 	}
//131
//132 	private SuffixTreeNode search(SuffixTreeNode startNode, List<String> suffix) {
//133 	    if (suffix.isEmpty()) {
//134 	        throw new IllegalArgumentException(
//135 	                "Empty suffix. Probably no valid simple suffix tree exists for the input.");
//136 	    }
//137 	    Collection<SuffixTreeNode> children = startNode.children;
//138 	    for (SuffixTreeNode child : children) {
//139 	        if (child.incomingEdge.label.equals(suffix.get(0))) {
//140 	            suffix.remove(0);
//141 	            if (suffix.isEmpty()) {
//142 	                return child;
//143 	            }
//144 	            return search(child, suffix);
//145 	        }
//146 	    }
//147 	    return startNode;
//148 	}
//149
//150 	private void insert(SuffixTreeNode insertAt, List<String> suffix,
//151 	        int pathIndex) {
//152 	    for (String x : suffix) {
//153 	        SuffixTreeNode child = new SuffixTreeNode(insertAt, x,
//154 	            insertAt.nodeDepth + 1, pathIndex, id);
//155 	        insertAt.children.add(child);
//156 	        insertAt = child;
//157 	    }
//158 	}
//159
//160 	public String toString() {
//161 	    StringBuilder result = new StringBuilder();
//162 	    String incomingLabel = this.isRoot() ? "" : this.incomingEdge.label;
//163 	    for (int i = 1; i <= this.nodeDepth; i++)
//164 	        result.append("\t");
//165 	    if (this.isRoot()) {
//166 	        c = 1;
//167 	        this.id = 1;
//168 	    } else {
//169 	        this.id = c;
//170 	        result.append(this.parent.id + " -> ");
//171 	        result.append(this.id + "[label=\"" + incomingLabel + "\"];\n");
//172 	    }
//173 	    for (SuffixTreeNode child : children) {
//174 	        c++;
//175 	        child.id = c;
//176 	        result.append(child.toString());
//177 	    }
//178 	    return result.toString();
//179 	}
//180
//181
//182 	public boolean isRoot() {
//183 	    return this.parent == null;
//184 	}
//185 	public boolean isLeaf() {
//186 	    return children.size() == 0;
//187 	}
//188 }
//189 class SuffixTreeEdge {
//190
//191 	String label = null;
//192 	@SuppressWarnings("unused")
//193 	private int branchIndex = -1;
//194
//195 	public SuffixTreeEdge(String label, int branchIndex) {
//196 	    this.label = label;
//197 	    this.branchIndex = branchIndex;
//198 	}
//199 }
