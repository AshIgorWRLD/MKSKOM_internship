package tasks.task3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Task3 {

    public void doTask3(Collection collection){
        Set set = new HashSet(collection);
        set.forEach(x->{
            System.out.println(x);
        });
    }
}
