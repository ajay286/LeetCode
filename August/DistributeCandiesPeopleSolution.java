class DistributeCandiesPeopleSolution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int index = 0;
        while (candies > 0) {
            result[index % num_people] += Math.min(candies, index + 1);
            candies -= (index + 1);
            index += 1;
        }

        return result;
    }
}
