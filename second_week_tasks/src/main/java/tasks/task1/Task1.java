package tasks.task1;


public class Task1{

    private parsedString[] parseStrings(String[] inputStrings){
        parsedString[] parsedStrings = new parsedString[inputStrings.length];
        for(int i = 0; i < inputStrings.length; i++){
            parsedStrings[i] = new parsedString(inputStrings[i]);
        }
        return parsedStrings;
    }

    private int findMinStringLength(String[] inputStrings){
        int tmpMin = inputStrings[0].length();
        for(int i = 1; i < inputStrings.length; i++){
            if(tmpMin > inputStrings[i].length()){
                tmpMin = inputStrings[i].length();
            }
        }
        return tmpMin;
    }

    private String findMaxPrefix(String[] inputStrings){
        parsedString[] parsedStrings = parseStrings(inputStrings);
        int minStringLength = findMinStringLength(inputStrings);
        StringBuilder prefixStringBuilder = new StringBuilder();
        //boolean isEqual = true;
        for(int i = 0; i < minStringLength; i++) {
            String newSymbol = parsedStrings[0].getSymbols()[i];
            for (int j = 1; j < parsedStrings.length; j++) {
                if (!newSymbol.equals(parsedStrings[j].getSymbols()[i])){
                    return prefixStringBuilder.toString();
                }
                if(parsedStrings.length-1 == j){
                    prefixStringBuilder.append(newSymbol);
                }
            }
        }
        return prefixStringBuilder.toString();
    }

    public void doTask(String[] strings) {
        System.out.println("MIN PREFIX: "+ findMaxPrefix(strings));
    }
}
