package graph;

import java.util.ArrayList;
import java.util.List;

public class Section {

    private final int position;
    private final int period;
    private final List<Boolean> stateList;

    public  Section(int position, int period) {
        this.position = position;
        this.period = period;
        this.stateList = new ArrayList<>();
        initStateList();
    }

    private void initStateList() {

        if (period != -1) {
            boolean state = false;
            stateList.add(state);
            for (int i = 1; i < (10 * period); i++) {
                if (i % period == 0) {
                    state = !state;
                }
                stateList.add(state);
            }
        }
    }

    public boolean getState(int time) {

        if (this.period == -1) {
            return true;
        }

        int listSize = this.stateList.size();
        System.out.println("List Size: " + listSize);
        while (time >= listSize) {
            List<Boolean> extension = List.copyOf(this.stateList);
            this.stateList.addAll(extension);
            listSize = this.stateList.size();
        }

        return this.stateList.get(time);
    }

    public int getPosition() {
        return this.position;
    }
}
