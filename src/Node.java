import java.util.List;

public class Node {

    private Section section;
    private int currentTime;
    private Node parent;
    private List<Node> children;

    public Node(Node parent, Section s, int time) {
        this.parent = parent;
        this.section = s;
        this.currentTime = time;
    }
}