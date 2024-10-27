package org.example;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.example.Action.destroy;
import static org.example.Action.look;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeWorkTest {

    HomeWork homeWork = new HomeWork();

    @Test
    void checkFirst() {
        TestCase1 testCase = generateTestCase1();

        assertEquals(testCase.expected,
                homeWork.getOriginalDoorNumbers(testCase.maxDoors, testCase.actionList));
    }

    @Test
    void checkSecond() {
        assertEquals(Arrays.stream("3 1 5 2 4".split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()),
                homeWork.getLeaveOrder(5, 3));

        assertEquals(Arrays.stream("2 4 6 8 10 3 7 1 9 5".split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()),
                homeWork.getLeaveOrder(10, 2));
    }

    private TestCase1 generateTestCase1() {
        TestCase1 testCase = new TestCase1();
        testCase.parseExpected("5\n" +
                "4\n" +
                "6\n" +
                "4\n" +
                "7");
        testCase.parseInput("20 7\n" +
                "L 5\n" +
                "D 5\n" +
                "L 4\n" +
                "L 5\n" +
                "D 5\n" +
                "L 4\n" +
                "L 5");
        return testCase;
    }


    @RequiredArgsConstructor
    static class TestCase1 {
        int maxDoors;
        List<Action> actionList = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();

        public void parseInput(String input) {
            String[] lines = input.split("(\n|\r|\r\n)");
            maxDoors = Integer.parseInt(lines[0].split(" ")[0]);
            Arrays.stream(lines)
                    .skip(1)
                    .map(Action::parse)
                    .forEach(actionList::add);

        }


        public void parseExpected(String output) {
            String[] lines = output.split("(\n|\r|\r\n)");
            Arrays.stream(lines)
                    .map(Integer::parseInt)
                    .forEach(expected::add);
        }
    }

}