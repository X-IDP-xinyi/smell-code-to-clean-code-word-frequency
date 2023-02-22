package wordfrequency;

import input.Input;

import java.util.*;

/**
 * Created by jxzhong on 2018/5/22.
 */
public class WordFrequencyGame {
    public String getResult(String inputStr) {

        if (inputStr.split("\\s+").length == 1) {
            return inputStr + " 1";
        } else {
            try {
                List<Input> inputList = splitInputStr(inputStr);
                Map<String, List<Input>> map = getListMap(inputList);
                List<Input> list = new ArrayList<>();
                sortCount(map, list);
                return getJoiner(list);
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }

    private static void sortCount(Map<String, List<Input>> map, List<Input> list) {
        for (Map.Entry<String, List<Input>> entry : map.entrySet()) {
            Input input = new Input(entry.getKey(), entry.getValue().size());
            list.add(input);
        }
        list.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
    }

    private static String getJoiner(List<Input> list) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Input w : list) {
            String s = w.getValue() + " " + w.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
    }

    private static List<Input> splitInputStr(String inputStr) {
        List<Input> inputList = new ArrayList<>();
        String[] arr = inputStr.split("\\s+");
        for (String s : arr) {
            Input input = new Input(s, 1);
            inputList.add(input);
        }
        return inputList;
    }

    private Map<String, List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        for (Input input : inputList) {
            if (!map.containsKey(input.getValue())) {
                ArrayList<Input> arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getValue(), arr);
            } else {
                map.get(input.getValue()).add(input);
            }
        }
        return map;
    }
}
