package solver;

import graph.Node;
import graph.Section;

import java.util.ArrayList;
import java.util.List;

public class Solver {

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

        Node currentNode = new Node(null, sections.getFirst(), 0);
        int time = 0;
        int currentSection = 0;

        while (currentNode.getSection() != sections.getLast()) {

            Section nextSection = sections.get(currentSection + 1);
            // try to move >>>forward>>> as long as the current section is not closed
            while (currentNode.getSection().getState(time)) {
                boolean nextState = nextSection.getState(time);
                if (nextState) {
                    // true --> move to the next section:
                    currentSection++;
                    Node childNode = new Node(currentNode, nextSection, time);
                    currentNode.addChildNode(childNode);
                    currentNode = childNode;
                    continue;
                } else {
                    time++;
                }
            }
            if ()
        }



        return null;
    }
}