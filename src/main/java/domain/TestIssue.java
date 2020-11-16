package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestIssue {
    private int id;
    private Author author;
    private boolean open;
    private boolean closed;
    private Label label;
    private Assignee assignee;

}
