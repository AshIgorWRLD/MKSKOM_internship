package task1.human;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Human implements Cloneable<Human>{

    protected int age;
    protected Gender gender;
    protected String name;

    public void print(){
        System.out.println("Name: " + name + "; Gender: " + gender + "; Age " + age);
    }


    @Override
    public Human clone() {
        return new Human(age, gender, name);
    }
}
