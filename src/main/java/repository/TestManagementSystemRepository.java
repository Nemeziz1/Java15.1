package repository;

import domain.TestManagementSystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class TestManagementSystemRepository {
    private List<TestManagementSystem> items = new ArrayList<>();

    public void add(TestManagementSystem item) {
        items.add(item);
    }

    public List<TestManagementSystem> findAll() {
        return items;
    }
}



