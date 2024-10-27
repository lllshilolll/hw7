package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу
     * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1439">https://acm.timus.ru/problem.aspx?space=1&num=1439</a>
     */
    public List<Integer> getOriginalDoorNumbers(int maxDoors, List<Action> actionList) {
        List<Integer> res = new ArrayList<>();
        List<Integer> doors = Arrays.stream(
                        IntStream.range(1, maxDoors + 1).toArray()
                )
                .boxed()
                .collect(Collectors.toList());

        for (Action action : actionList) {
            if (!action.isLook()) {
                doors.remove(action.doorNumber - 1);
            } else {
                res.add(doors.get(action.doorNumber - 1));
            }
        }
        return res;
    }

    /**
     * <h1>Задание 2.</h1>
     * Решить задачу <br/>
     * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1521">https://acm.timus.ru/problem.aspx?space=1&num=1521</a><br/>
     * <h2>Пошагово</h2>
     * Для 5 3 входных данных:<br/>
     * _ -> 3 позиции<br/>
     * _ 1 2 <b>3</b> 4 5 => 3 <br/>
     * <b>1</b> 2 _ 4 5 => 1 <br/>
     * _ 2 4 <b>5</b> => 5 <br/>
     * <b>2</b> 4 _ => 2 <br/>
     * _ <b>4</b> => 4
     */
    public List<Integer> getLeaveOrder(int maxUnits, int leaveInterval) {
        List<Integer> list = new ArrayList<>();

        List<Integer> array = Arrays.stream(
                        IntStream.range(1, maxUnits + 1).toArray()
                )
                .boxed()
                .collect(Collectors.toList());

        int index = 0;

        while (!array.isEmpty()) {
            index = (index + leaveInterval - 1) % array.size();
            list.add(array.get(index));
            array.remove(index);
        }

        return list;
    }
}
