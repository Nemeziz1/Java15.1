package manager;

import TMSComparator.TIComparator;
import domain.Assignee;
import domain.Author;
import domain.Label;
import domain.TestIssue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TestIssueRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestIssueTest {
    TestIssueRepository repository = new TestIssueRepository();
    TestIssueManager manager = new TestIssueManager(repository);
    TIComparator comparator = new TIComparator();
    TestIssue one = new TestIssue(1, new Author(1, "Coursar"), true, false, Label.bug, new Assignee(1, "Nemeziz1"));
    TestIssue two = new TestIssue(2, new Author(2, "Nemeziz1"), false, true, Label.documentation, new Assignee(2, "Coursar"));
    TestIssue three = new TestIssue(3, new Author(3, "solarrust"), true, false, Label.duplicate, new Assignee(1, "Nemeziz1"));
    TestIssue four = new TestIssue(4, new Author(2, "Nemeziz1"), false, true, Label.question, new Assignee(3, "solarrust"));

    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
    }

    @Test
    public void shouldFindOpen() {
        List<TestIssue> actual = manager.findOpen();
        List<TestIssue> expected = Arrays.asList(one, three);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindClosed() {
        List<TestIssue> actual = manager.findClosed();
        List<TestIssue> expected = Arrays.asList(two, four);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAuthor() {
        List<TestIssue> actual = manager.filterByAuthor(new Author(2, "Nemeziz1"), comparator);
        List<TestIssue> expected = Arrays.asList(two, four);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByLabel() {
        List<TestIssue> actual = manager.filterByLabel(Label.bug, comparator);
        List<TestIssue> expected = Collections.singletonList(one);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAssignee() {
        List<TestIssue> actual = manager.filterByAssignee(new Assignee(3, "solarrust"), comparator);
        List<TestIssue> expected = Collections.singletonList(four);
        assertEquals(expected, actual);
    }

    @Test
    public void notFoundByAuthor() {
        List<TestIssue> actual = manager.filterByAuthor(new Author(4, "NetologyTeacher"), comparator);
        List<TestIssue> expected = Collections.emptyList();
        assertEquals(expected, actual);
    }

    @Test
    public void notFoundByLabel() {
        List<TestIssue> actual = manager.filterByLabel(Label.enhancement, comparator);
        List<TestIssue> expected = Collections.emptyList();
        assertEquals(expected, actual);
    }

    @Test
    public void notFoundByAssignee() {
        List<TestIssue> actual = manager.filterByAssignee(new Assignee(4, "NetologyTeacher"), comparator);
        List<TestIssue> expected = Collections.emptyList();
        assertEquals(expected, actual);
    }
}