import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Solution {

    record Car(List<Integer> temp, List<Integer> cargos) {
    }

    record ResultCar(Integer temp, List<Integer> cargos) {
    }

    record Cargo(Integer id, List<Integer> temp) {

    }

    public static List<ResultCar> distribute(List<List<Integer>> cargos) {
        var sortedCargos = IntStream.range(0, cargos.size())
                .mapToObj(id -> new Cargo(id + 1, cargos.get(id)))
                .sorted((first, second) -> Integer.compare(first.temp.get(0), second.temp.get(0)))
                .toList();

        var cars = new ArrayList<Car>();
        var firstCar = new Car(new ArrayList<>(sortedCargos.get(0).temp()), new ArrayList<>(List.of(1)));
        cars.add(firstCar);

        for (int i = 1; i < sortedCargos.size(); i++) {
            if (sortedCargos.get(i).temp().get(0) <= cars.get(cars.size() - 1).temp().get(1)) {
                var curCar = cars.get(cars.size() - 1);
                curCar.temp().set(0, sortedCargos.get(i).temp().get(0));
                curCar.temp().set(1, Integer.min(curCar.temp().get(1), sortedCargos.get(i).temp().get(1)));
                curCar.cargos().add(sortedCargos.get(i).id());
            } else {
                var newCarCargos = new ArrayList<Integer>();
                newCarCargos.add(sortedCargos.get(i).id());
                cars.add(new Car(new ArrayList<>(sortedCargos.get(i).temp()), newCarCargos));
            }
        }

        return cars.stream()
                .map(it -> new ResultCar(it.temp().get(0), it.cargos()))
                .toList();
    }

    public static void main(String[] args) {
        distribute(
                Arrays.asList(
                        List.of(-50, -25),
                        List.of(0, 10),
                        List.of(10, 15),
                        List.of(0, 50),
                        List.of(-25, -25),
                        List.of(-25, 10),
                        List.of(70, 100)))
                .forEach(System.out::println);
    }
}