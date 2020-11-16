package repository;

import domain.TestIssue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class TestIssueRepository {
    private List<TestIssue> items = new ArrayList<>();

    public void add(TestIssue item) {
        items.add(item);
    }

    public List<TestIssue> findAll() {
        return items;
    }
}



