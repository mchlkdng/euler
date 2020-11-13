package com.mkd;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args) {
        Map<Integer, List<List<Integer>>> mapResults = new HashMap<>();
	    List<Integer> numbers = Stream.of(4, 6, 10, 12, 14, 16, 22, 26, 28, 40, 44).collect(Collectors.toList());

        buildPreResult(mapResults, numbers);

        List<List<Integer>> results0 = mapResults.get(0);
        for (List<Integer> result0 : results0) {
            List<List<Integer>> results8 = getFilteredNeighbour(mapResults.get(8), result0, new ArrayList<>());
            List<Integer> setNumbersUsed0 = new ArrayList<>(result0);
            for (List<Integer> result8 : results8) {
                List<List<Integer>> results30 = getFilteredNeighbour(mapResults.get(30), result8, setNumbersUsed0);
                List<Integer> setNumbersUsed8 = new ArrayList<>(setNumbersUsed0);
                setNumbersUsed8.addAll(result8);
                for (List<Integer> result30 : results30) {
                    List<List<Integer>> results46 = getFilteredNeighbour(mapResults.get(46), result30, setNumbersUsed8);
                    List<Integer> setNumbersUsed46 = new ArrayList<>(setNumbersUsed8);
                    setNumbersUsed46.addAll(result30);
                    for (List<Integer> result46 : results46) {
                        List<Integer> setNumbersUsedForFinal = new ArrayList<>();
                        setNumbersUsedForFinal.addAll(result30);
                        setNumbersUsedForFinal.addAll(result8);
                        List<List<Integer>> results24 = getFilteredNeighbour(mapResults.get(24), result46, setNumbersUsedForFinal);
                        for (List<Integer> result24 : results24) {
                            List<Integer> setNumbersUsedFinal = new ArrayList<>();
                            setNumbersUsedFinal.addAll(result0);
                            setNumbersUsedFinal.addAll(result8);
                            setNumbersUsedFinal.addAll(result30);
                            setNumbersUsedFinal.addAll(result46);
                            setNumbersUsedFinal.addAll(result24);
                            System.out.println(setNumbersUsedFinal);
                        }
                    }
                }
            }
        }
    }

    private static List<List<Integer>> getFilteredNeighbour(List<List<Integer>> listsNeighbour, List<Integer> current, List<Integer> setNumbersUsed) {
        List<List<Integer>> retVal = new ArrayList<>();
        for (List<Integer> listNeighbour : listsNeighbour) {
            int found = 0;
            boolean duplicate = false;
            for (Integer value : listNeighbour) {
                if (setNumbersUsed.contains(value)) {
                    duplicate = true;
                }
                if (current.contains(value)) {
                    found++;
                }
            }
            if (found == 1 && !duplicate) {
                retVal.add(listNeighbour);
            }
        }
        return retVal;
    }

    private static void buildPreResult(Map<Integer, List<List<Integer>>> mapResults, List<Integer> numbers) {
        int summands = 4;
        int target = 90;
        List<List<Integer>> results = new ArrayList<>();
        calculate(numbers, summands, target, results, 1, null, 0);
        mapResults.put(0, results);

        summands = 3;
        target = 90 - 8;
        results = new ArrayList<>();
        calculate(numbers, summands, target, results, 1, null, 0);
        mapResults.put(8, results);

        target = 90 - 24;
        results = new ArrayList<>();
        calculate(numbers, summands, target, results, 1, null, 0);
        mapResults.put(24, results);

        target = 90 - 30;
        results = new ArrayList<>();
        calculate(numbers, summands, target, results, 1, null, 0);
        mapResults.put(30, results);

        target = 90 - 46;
        results = new ArrayList<>();
        calculate(numbers, summands, target, results, 1, null, 0);
        mapResults.put(46, results);
    }

    private static void calculate(List<Integer> numbers, int summands, int target, List<List<Integer>> results, int iteration,
                                  List<Integer> current, int sum) {
        for (int first = 0; first < numbers.size() - (summands - 1); first++)
        {
            if (current == null) {
                current = new ArrayList<>();
            }

            if (summands > 1) {
                List<Integer> nextNumbers = getNumbers(first, numbers);
                List<Integer> nextCurrent = new ArrayList<>(current);
                nextCurrent.add(numbers.get(first));
                calculate(nextNumbers, summands - 1, target, results, iteration + 1, nextCurrent, sum + numbers.get(first));
            }

            if (summands == 1 && sum + numbers.get(first) == target) {
                current.add(numbers.get(first));
                results.add(current);
            }
        }
    }

    private static List<Integer> getNumbers(int first, List<Integer> numbers) {
        List<Integer> retVal = new ArrayList<>();
        for (int t = first + 1; t < numbers.size(); t++) {
            retVal.add(numbers.get(t));
        }
        return retVal;
    }
}