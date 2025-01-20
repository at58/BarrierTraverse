package solver;

import graph.Node;
import graph.Section;

import java.util.ArrayList;
import java.util.List;

public class Solver {

    private static int time;

    public static List<Node> findSolution(List<String> input) {

        int requiredSections = Integer.parseInt(input.getFirst());
        List<Section> sections = new ArrayList<>();
        // Add the start section which is the save zone (No blocking sequences by closing walls).
        sections.add(new Section(0, -1));
        // Add the periodically blocking sections:
        for (int i = 1; i <= requiredSections; i++) {
            int sectionPeriod = Integer.parseInt(input.get(i));
            sections.add(new Section(i, sectionPeriod));
        }

        time = 0;
        Node currentNode = new Node(null, sections.getFirst(), time);

        while (currentNode.getSection() != sections.getLast()) {

            // boolean movedForward = false;

            // try to move >>>forward>>> as long as the current section is not closed
            while (currentNode.getSection().isOpen(time)) {
                Section nextSection = sections.get((currentNode.getSection().getPosition() + 1));
                boolean nextSectionOpen = nextSection.isOpen(time);
                if (nextSectionOpen) {
                    // true --> move to the next section --> create new Node and add it to the current node as a child.
                    Node childNode = new Node(currentNode, nextSection, time);
                    currentNode.addChildNode(childNode);
                    // Update control variables:
                    currentNode = childNode;
                    if (currentNode.getSection() == sections.getLast()) {
                        return reversedDepthFirstTraversal(currentNode);
                    }
                    // movedForward = true;
                } else {
                    time++;
                }
            }
            currentNode = backtracking(currentNode);
        }

        return List.of();
    }

    private static Node backtracking(Node currentNode) {
        // TODO: implement backtracking algorithmen
        Node parent = currentNode.getParent();
        while (true) {
            if()
            parent.getSection().isOpen(time);
        }
    }

    private static List<Node> reversedDepthFirstTraversal(Node leaf) {
        // TODO: implement logic for reversed traversal from bottom to the top most node.
        return null;
    }
}