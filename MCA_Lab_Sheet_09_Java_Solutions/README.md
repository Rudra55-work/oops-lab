# COER MCA203P — Lab Sheet 09: Object Oriented Programming Using Java

Complete Java solutions for all 30 exercises in the uploaded Lab Sheet09.

## Requirements
- JDK 8 or later (JDK 17 recommended)
- VS Code, IntelliJ IDEA, Eclipse, or terminal

## Compile all programs
From this folder, run:

```bash
javac -d out src/*.java
```

## Run an individual practical
For example, Question 1:

```bash
java -cp out Q01ArrayListPrint
```

Replace the class name with the required question, e.g. `Q27ComparatorSort`.

## Program mapping
| Question | Java file | Topic |
|---:|---|---|
| 1 | Q01ArrayListPrint.java | Create and print ArrayList |
| 2 | Q02ArrayListSize.java | Add elements and display size |
| 3 | Q03ArrayListInsert.java | Insert at an index |
| 4 | Q04ArrayListRemove.java | Remove by index and value |
| 5 | Q05ArrayListUpdate.java | Update using set() |
| 6 | Q06ArrayListForEach.java | for-each iteration |
| 7 | Q07ArrayListIterator.java | Iterator |
| 8 | Q08ArrayListSort.java | Ascending sort |
| 9 | Q09ArrayListReverse.java | Reverse strings |
| 10 | Q10LinkedListPrint.java | Create and print LinkedList |
| 11 | Q11LinkedListEndsAdd.java | Add at beginning/end |
| 12 | Q12LinkedListEndsRemove.java | Remove first/last |
| 13 | Q13LinkedListEndsGet.java | Retrieve first/last |
| 14 | Q14HashSetDuplicates.java | HashSet duplicate behavior |
| 15 | Q15HashSetRemove.java | Remove from HashSet |
| 16 | Q16HashSetIterator.java | Iterate HashSet |
| 17 | Q17TreeSetSort.java | TreeSet sorted order |
| 18 | Q18TreeSetContains.java | TreeSet contains() |
| 19 | Q19LinkedHashSetOrder.java | LinkedHashSet insertion order |
| 20 | Q20CompareSets.java | Compare three Set types |
| 21 | Q21PriorityQueueAdd.java | Add to PriorityQueue |
| 22 | Q22PriorityQueueRemove.java | PriorityQueue removal order |
| 23 | Q23PriorityQueuePeek.java | Peek without removal |
| 24 | Q24QueueLinkedList.java | Queue interface with LinkedList |
| 25 | Q25QueueOperations.java | Queue add/remove/peek |
| 26 | Q26StudentIterator.java | Custom objects and Iterator |
| 27 | Q27ComparatorSort.java | Sort custom objects with Comparator |
| 28 | Q28ListToSet.java | Convert List to Set |
| 29 | Q29SetToList.java | Convert Set to List |
| 30 | Q30ClearCollections.java | Clear List, Set, Queue |

## Important observations
- ArrayList preserves insertion order and allows duplicates.
- LinkedList implements both List and Queue/Deque behavior.
- HashSet does not guarantee iteration order and stores unique elements.
- LinkedHashSet preserves insertion order and stores unique elements.
- TreeSet stores unique elements in sorted order.
- PriorityQueue exposes its head through peek(); iterating/printing the queue does not guarantee sorted order. Repeated poll() gives priority order.
- Queue commonly follows FIFO behavior. `offer`, `poll`, and `peek` are often preferred when special-value failure handling is desired.

All programs are standalone and use only the Java standard library.
