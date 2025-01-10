# Relative Ranks

This Java program solves the [Relative Ranks](https://leetcode.com/problems/relative-ranks/description/) problem from LeetCode. The task is to assign ranks to athletes based on their scores. The top three scores receive medals (Gold, Silver, and Bronze), and the rest are assigned ranks as numbers.

## Problem Description
Given an integer array `score` where `score[i]` represents the score of the `i`-th athlete, return an array of strings where `result[i]` represents the rank of the `i`-th athlete.

### Constraints
- `1 <= score.length <= 10^4`
- `0 <= score[i] <= 10^6`

### Example Input
```java[]
int[] scores = {10, 3, 8, 9, 4};
```

### Example Output
```java[]
["Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"]
```

## Solutions
### Approach 1: Optimized Solution (2ms)
This approach uses a counting array to map scores to their respective indices and assigns ranks in descending order of scores.

#### Code
```java[]
static String[] findRelativeRanks(int[] score) {
    int n = score.length;
    String[] res = new String[n];
    int maxScore = 0;
    for (int j : score) {
        maxScore = Math.max(maxScore, j);
    }
    int[] map = new int[maxScore + 1];
    for (int i = 0; i < n; i++) {
        map[score[i]] = i + 1;
    }
    int place = 1;
    for (int i = maxScore; i >= 0; i--) {
        if (map[i] == 0) {
            continue;
        }
        int index = map[i] - 1;
        String val = switch (place) {
            case 1 -> "Gold Medal";
            case 2 -> "Silver Medal";
            case 3 -> "Bronze Medal";
            default -> String.valueOf(place);
        };
        res[index] = val;
        place++;
    }

    return res;
}
```

#### Time Complexity
- **O(n + m):** where `n` is the number of athletes and `m` is the maximum score.

#### Space Complexity
- **O(m):** to store the mapping array.

### Approach 2: HashMap-Based Solution (9ms)
This approach uses a HashMap to store the indices of scores and sorts the array to assign ranks.

#### Code
```java[]
static String[] findRelativeRanks(int[] score) {
    int n = score.length;
    String[] res = new String[n];
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
        map.put(score[i], i);
    }
    Arrays.sort(score);

    for (int i = n - 1; i >= 0; i--) {
        int index = map.get(score[i]);
        String val = String.valueOf(n - i);
        val = switch (val) {
            case "1" -> "Gold Medal";
            case "2" -> "Silver Medal";
            case "3" -> "Bronze Medal";
            default -> val;
        };
        res[index] = val;
    }
    return res;
}
```

#### Time Complexity
- **O(n log n):** due to sorting.

#### Space Complexity
- **O(n):** for the HashMap.

## How It Works
1. **Approach 1** builds a counting array to determine the order of scores in O(maxScore) time.
2. **Approach 2** uses sorting and a HashMap to map scores to indices and assign ranks in O(n log n) time.

## Usage
### Input
```java[]
int[] scores = {10, 3, 8, 9, 4};
```

### Output
```java[]
System.out.println(Arrays.toString(findRelativeRanks(scores)));
// Output: ["Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"]
```

## Complexity Analysis
| Approach     | Time Complexity | Space Complexity |
|--------------|-----------------|------------------|
| Optimized    | O(n + m)        | O(m)             |
| HashMap-Based| O(n log n)      | O(n)             |

Both approaches solve the problem efficiently, with the optimized solution being faster for a large range of scores.
