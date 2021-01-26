package statisticker;

import java.util.List;

/**
 * @author {@literal Jayaram Naveenkumar (jayaram.naveenkumar@in.bosch.com)}
 */
public final class Statistics {

    private Statistics() {
    }

    public static Stats getStatistics(List<Float> numbers) {
        return new Stats(getAverageFromList(numbers), getMinValueFromList(numbers), getMaxValueFromList(numbers));
    }

    private static float getMaxValueFromList(List<Float> numbers) {
        return numbers.stream().max(Float::compareTo).orElse(Float.NaN);
    }

    private static float getMinValueFromList(List<Float> numbers) {
        return numbers.stream().min(Float::compareTo).orElse(Float.NaN);
    }

    private static float getAverageFromList(List<Float> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return Float.NaN;
        } else {
            float total = 0;
            for (Float number : numbers) {
                total += number;
            }
            return total / numbers.size();
        }
    }

    public static class Stats {

        private final float average;
        private final float min;
        private final float max;

        public Stats(
            float average,
            float min,
            float max
        )
        {
            this.average = average;
            this.min = min;
            this.max = max;
        }

        public float getAverage() {
            return average;
        }

        public float getMin() {
            return min;
        }

        public float getMax() {
            return max;
        }
    }
}
