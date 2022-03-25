package task1.sorts;

import java.util.Collection;

@FunctionalInterface
public interface Sortable<T> {
    void sort(Collection<T> collection);
}
