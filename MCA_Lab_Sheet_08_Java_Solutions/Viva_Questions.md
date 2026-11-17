# Viva Questions — Lab Sheet 08 (Java)

1. What is a JavaBean?
   A reusable Java class that typically has a public no-argument constructor, private properties, and public getter/setter methods.

2. Why are bean properties private?
   To provide encapsulation and controlled access through accessor methods.

3. What is a read-only bean property?
   A property with a getter but no setter.

4. What is a write-only bean property?
   A property with a setter but no getter.

5. What is serialization?
   The process of converting an object's state into a byte stream so it can be stored or transmitted.

6. What is PropertyChangeSupport?
   A helper class that manages PropertyChangeListener objects and fires property-change events.

7. What does Introspector do?
   It examines a JavaBean and discovers its properties, events, and methods.

8. What is InetAddress used for?
   It represents an IP address and provides methods to resolve host names and addresses.

9. What is the difference between TCP and UDP?
   TCP is connection-oriented and reliable; UDP is connectionless and does not guarantee delivery or order.

10. What is a ServerSocket?
    A TCP server endpoint that listens for and accepts client connections.

11. What does accept() do?
    It blocks until a client connects and then returns a Socket for communication.

12. What is a DatagramSocket?
    A socket used to send and receive UDP datagram packets.

13. What is URLConnection?
    An abstraction for communicating with a resource identified by a URL.

14. What is multithreading?
    Running multiple threads concurrently within one process.

15. Why does the multi-client server create a thread per client?
    So a client can be handled independently while the server continues accepting other connections.
