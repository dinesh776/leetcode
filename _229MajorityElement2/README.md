
# Majority Element II

**Problem:**  
Given an integer array `nums` of size `n`, find all elements that appear more than ⌊ n/3 ⌋ times.

- **Problem Link:** [Leetcode 229. Majority Element II](https://leetcode.com/problems/majority-element-ii/description/)

---

## Example

```java[]
int[] nums = {1,1,1,3,3,2,2,2};
```

```java[]
Output: [1, 2]
```

---

## Solution

### Optimal Solution: Boyer-Moore Voting Algorithm
- **Approach:** Using Boyer-Moore Voting Algorithm, we maintain counts for up to two potential candidates as no more than two elements can appear more than ⌊ n/3 ⌋ times in an array.
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

```java[]
static List<Integer> majorityElement(int[] nums) {
    int ct1 = 0, ct2 = 0, el1 = 0, el2 = -1, n = nums.length;
    List<Integer> list = new ArrayList<>();
    
    // First pass: Find potential candidates
    for (int num : nums) {
        if (num == el1) {
            ct1++;
        } else if (num == el2) {
            ct2++;
        } else if (ct1 == 0) {
            el1 = num;
            ct1 = 1;
        } else if (ct2 == 0) {
            el2 = num;
            ct2 = 1;
        } else {
            ct1--;
            ct2--;
        }
    }
    
    // Second pass: Confirm the counts
    ct1 = ct2 = 0;
    for (int num : nums) {
        if (num == el1) ct1++;
        else if (num == el2) ct2++;
    }
    if (ct1 > n / 3) list.add(el1);
    if (ct2 > n / 3) list.add(el2);
    
    return list;
}
```

### Brute Force Solution
- **Approach:** Use a HashMap to track occurrences of each element, then check which elements appear more than ⌊ n/3 ⌋ times.
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

```java[]
List<Integer> list = new ArrayList<>();
HashMap<Integer, Integer> map = new HashMap<>();
int n = nums.length, k = n / 3 + 1;
for (int num : nums) {
    map.put(num, map.getOrDefault(num, 0) + 1);
    if (map.get(num) == k) {
        list.add(num);
    }
}
return list;
```

---

## How It Works

The Boyer-Moore Voting Algorithm ensures that only up to two elements are tracked, allowing us to efficiently find elements that appear more than ⌊ n/3 ⌋ times.

1. **Candidate Selection:** Track two potential candidates.
2. **Confirmation:** Recount occurrences to ensure the candidates meet the ⌊ n/3 ⌋ threshold.

---

## Usage

To use this solution, copy the provided `majorityElement` method into your Java class. You can test with example inputs as provided above.

---

## Complexity Analysis

- **Time Complexity:** O(n) for the optimal solution, O(n^2) for brute force.
- **Space Complexity:** O(1) for optimal, O(n) for brute force.
