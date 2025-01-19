package graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private final Section section;
    private final int currentTime;
    private final Node parent;
    private final List<Node> children;

    public Node (Node parent, Section s, int time) {
        this.parent = parent;
        this.section = s;
        this.currentTime = time;
        this.children = new ArrayList<>();
    }

    public void addChildNode(Node children) {
        this.children.add(children);
    }

    public Section getSection() {
        return this.section;
    }

    public int getCurrentTime() {
        return this.currentTime;
    }

    public Node getParent() {
        return this.parent;
    }
}