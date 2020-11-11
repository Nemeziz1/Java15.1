package TMSComparator;

import domain.TestManagementSystem;

import java.util.Comparator;

public class TMSComparator implements Comparator<TestManagementSystem> {

    @Override
    public int compare(TestManagementSystem o1, TestManagementSystem o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
