package TMSComparator;

import domain.TestIssue;

import java.util.Comparator;

public class TIComparator implements Comparator<TestIssue> {

    @Override
    public int compare(TestIssue o1, TestIssue o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
