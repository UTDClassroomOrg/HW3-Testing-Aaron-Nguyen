### Brief Functional Description
The function calculates the average of the first k elements of the integer array list. If k exceeds the array length, the function averages all elements. If the array is empty or k is less than or equal to zero, it returns 0.

### Generate functional test case based on functional description.
The function average(int k, int[] list) calculates the average of the first k elements of the integer array list. If k is greater than the array's length, it averages all elements. If k <= 0 or the array is empty, it returns 0.

| Test Case ID | Scenario | Input | Expected Output | Reasoning |
| --- | -------- | --- | --- | --- |
| TC1 | Average of k elements | list={10,20,30,40,50}; k=3; | 20 | Averages first 3 elements
| TC2 | k = 0, invalid input | list={10,20,30}; k=0; | 0 | Invalid k, returns 0
| TC3 | k < 0, invalid input | list={5,10,15}; k=-2; | 0 | Negative k, returns 0
| TC4 | k exceeds array length | list={4,8}; k=6; | 6 | Averages entire array
| TC5 | Array contains one element | list={7}; k=7; | 7 | Single-element array
| TC6 | Empty list, valid k | list={}; k=3; | 0 | Empty array, returns 0
| TC7 | Exact array size as k | list={3,6,9,12}; k=7; | 7 | Full list average
| TC8 | Average of only first element | list={100,200,300}; k=100; | 100 | Averages first element

### Partition for k (Input Size):
P1: k <= 0 (Invalid range, returns 0)

P2: 0 < k <= list.length (Valid range, partial average)

P3: k > list.length (Whole list average)

### Partition for list (Array Content):
L1: Empty list (list.length == 0)

L2: Single-element list (list.length == 1)

L3: Multiple elements (list.length > 1)

| Test Case ID | Partition| Input | Expected Output | Reasoning |
| --- | -------- | --- | --- | --- |
| TC1 | P1, L3 | list={10, 20, 30}; k=-1; | 0 | k <= 0 invalid case
| TC2 | P1, L1 | list={}; k=0; | 0 | Empty list, k <= 0
| TC3 | P2, L3 | list={5, 10, 15}; k=2; | 7 | Partial average
| TC4 | P2, L2 | list={7}; k=1; | 7 | Single-element average
| TC5 | P3, L3 | list={1, 2, 3}; k=4; | 2 | Whole list average
| TC6 | P3, L1 | list={}; k=3; | 0 | Exceeding k, empty list
| TC7 | P2, L3 | list={4, 6, 8, 10}; k=3; | 6 | Exact k list length
| TC8 | P2, L3 | list={5, 10, 15, 20}; k=5; | 12 | k > list.length

### Boundary Value Test Cases

| Test Case ID | Boundary| Input | Expected Output | Reasoning |
| --- | -------- | --- | --- | --- |
| TC1 | k = 0 (Below Min) | list={10,20,30}; k=0; | 0 | k <= 0 returns 0
| TC2 | k = 1 (Minimum) | list={10}; k=1; | 10 | Smallest valid k value
| TC3 | k = list.length (Max) | list={1,2,3}; k=3; | 2 | Full list average
| TC4 | k = list.length + 1 (Exceed) | list={1,2,3}; k=4; | 2 | Exceeding list length
| TC5 | Empty list, valid k | list={}; k=2; | 0 | Empty list returns 0
| TC6 | Single-element list, k = 1 | list={100}; k=1; | 100 | Single-element average
| TC7 | Single-element list, k > list.length | list={50}; k=2; | 50 | Exceeding k uses full list

### Implement Average Class and JUnit Test
[All Files](https://github.com/UTDClassroomOrg/HW3-Testing-Aaron-Nguyen/tree/main/HW3)

### Compile Run Test Case (Fix Failures)

Since I do not have any failure, I intentionally injected faults into the average function to evaluate whether the current tests could detect the introduced errors. First, I replaced the Math.min(k, list.length) logic with Math.max(k, list.length), which caused the function to incorrectly handle cases where k exceeds the length of the array. Instead of limiting k to the valid range, the function attempted to process more elements than available, leading to either an out-of-bounds error or an incorrect result. For example, in the test case where k = 5 and the array is [1, 2, 3], the expected behavior was to calculate the average of the entire array (2), but the faulty logic inflated k and caused a failure. Next, I modified the loop to start from i = 1 instead of i = 0, which skipped the first element of the array during summation. This caused failures in test cases such as k = 3 and the array [10, 20, 30, 40, 50], where the expected average of (10 + 20 + 30) / 3 = 20 was incorrectly computed as (20 + 30) / 3 = 16 due to the skipped first element. After running the tests, the faults were successfully detected by testExceedingListSize() for the Math.max issue and by testValidInputs() for the skipped first element. These failures demonstrated the effectiveness of the existing test suite, and I reverted the code to its original, correct implementation to pass all tests. This process highlights the importance of fault injection in validating test coverage and identifying potential weaknesses in the testing framework.

### Code Coverage

![](https://github.com/UTDClassroomOrg/HW3-Testing-Aaron-Nguyen/blob/main/hw3.png)
