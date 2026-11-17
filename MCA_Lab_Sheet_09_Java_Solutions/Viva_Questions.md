# Viva Questions and Answers — Lab Sheet 09 (Java Collections)

1. What is the Java Collections Framework?
   A set of interfaces and classes for storing and manipulating groups of objects.

2. What is an ArrayList?
   A resizable array implementation of the List interface.

3. Does ArrayList allow duplicates?
   Yes. It preserves insertion order and allows duplicate and null elements.

4. What is the difference between add() and set()?
   add() inserts an element; set() replaces the element at an existing index.

5. How can an element be removed by value from an ArrayList of integers?
   Use remove(Integer.valueOf(value)); remove(index) removes by index.

6. What is an Iterator?
   An object used to traverse a collection one element at a time using hasNext() and next().

7. What is a LinkedList?
   A doubly linked list implementation of List and Deque.

8. What is a HashSet?
   A Set implementation that stores unique elements and does not guarantee iteration order.

9. What happens when a duplicate is added to a Set?
   The duplicate is ignored; the set remains unchanged.

10. What is a LinkedHashSet?
    A HashSet variant that maintains insertion order.

11. What is a TreeSet?
    A sorted Set implementation, normally using natural ordering or a Comparator.

12. Can a TreeSet contain duplicate values?
    No. Set elements are unique.

13. What is the difference between HashSet and TreeSet?
    HashSet has no guaranteed iteration order; TreeSet maintains sorted order.

14. What is PriorityQueue?
    A queue that orders elements according to priority; by default, the smallest element is at the head.

15. Does printing a PriorityQueue show fully sorted order?
    Not necessarily. Repeatedly calling poll() demonstrates priority removal order.

16. What is the Queue interface?
    An interface for holding elements before processing, commonly in FIFO order.

17. Difference between remove() and poll() in Queue?
    Both remove the head; remove() throws an exception if empty, while poll() returns null.

18. Difference between element() and peek()?
    Both inspect the head; element() throws if empty, while peek() returns null.

19. What is Comparator?
    A functional interface that defines custom ordering between objects.

20. How do you sort custom objects by marks?
    Use a Comparator, for example Comparator.comparingDouble(Student::getMarks).

21. How do you convert a List to a Set?
    Pass the list to a Set implementation constructor, such as new HashSet<>(list).

22. How do you convert a Set to a List?
    Pass the set to a List implementation constructor, such as new ArrayList<>(set).

23. What does clear() do?
    Removes all elements from a collection.

24. What does isEmpty() return?
    true if the collection contains no elements; otherwise false.

25. Can Queue be declared as an interface reference and assigned a LinkedList?
    Yes: Queue<Integer> q = new LinkedList<>();
