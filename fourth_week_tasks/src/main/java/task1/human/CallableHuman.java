package task1.human;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class CallableHuman extends Human{

    private Set<String> phoneNumbers = new HashSet();

    public static Set<String> getAllPhonesFromList(List<CallableHuman> humanList){
        Set<String> phoneBook = new HashSet<>();
        humanList.forEach(x->phoneBook.add(x.makeNamePhoneString()));
        return phoneBook;
    }

    public static Set<String> getPhones(List<CallableHuman> humanList){
        return humanList.stream()
                .map(CallableHuman::getPhoneNumbers)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    public CallableHuman(int age, Gender gender, String name, String... phoneNumbers){
        super(age, gender, name);
        this.phoneNumbers.addAll(Arrays.asList(phoneNumbers));
    }

    public CallableHuman(Human human,  String... phoneNumbers){
        super(human.age, human.gender, human.name);
        this.phoneNumbers.addAll(Arrays.asList(phoneNumbers));
    }

    private String makeNamePhoneString(){
        StringBuilder stringBuilder = new StringBuilder();
        phoneNumbers.forEach(number->{
            stringBuilder.append(name).append(" - ").append(number).append("\n");
        });
        return stringBuilder.toString();
    }

    public void addPhoneNumber(String number){
        phoneNumbers.add(number);
    }

    public void deletePhoneNumber(String number){
        phoneNumbers.remove(number);
    }

    private String makePhoneNumbersString(){
        StringBuilder stringBuilder = new StringBuilder();
        phoneNumbers.forEach(x -> stringBuilder.append(x).append("; "));
        return stringBuilder.toString();
    }

    @Override
    public void print(){
        System.out.println("Name: " + name + "; Gender: " + gender + "; Age " + age + " " +
                makePhoneNumbersString());
    }
}
