# COER MCA III Semester — Lab Sheet 08 (Java)

This package contains solutions for all 20 questions in the uploaded Lab Sheet-08, "Object Oriented Programming Using Java".

## Requirements
- JDK 17 or later
- Terminal / Command Prompt
- Internet connection only for WebReader and FileDownloader

## Compile all programs
Open a terminal in this folder and run:

```bash
javac -d out src/*.java
```

## Run a program
```bash
java -cp out StudentBean
```
Replace `StudentBean` with the class name you want to run.

## Question-to-file mapping
1. StudentBean.java
2. RectangleBean.java
3. EmployeeBean.java
4. DateBean.java
5. UserBean.java
6. AccountBean.java
7. AccountBeanEventDemo.java
8. StudentBeanIntrospection.java
9. CarBean.java
10. CircleBean.java
11. InetAddressInfo.java
12. HelloServer.java
13. HelloClient.java
14. HelloServerRead.java
15. EchoServer.java (EchoClient.java is included for testing)
16. MessageSender.java
17. MessageReceiver.java
18. WebReader.java
19. FileDownloader.java
20. MultiClientServer.java (MultiClientClient.java is included for testing)

## Networking demonstrations
Run each server first in one terminal, then its client in another:
- Q12–13: `HelloServer`, then `HelloClient` (port 5000)
- Q14: `HelloServerRead`, then `HelloClient` (port 5000)
- Q15: `EchoServer`, then `EchoClient` (port 5001)
- Q16–17: `MessageReceiver`, then `MessageSender` (UDP port 6000)
- Q20: `MultiClientServer`, then run `MultiClientClient` in one or more terminals (port 5002)

Only one server should use a given port at a time. Stop a running server with Ctrl+C.

## Notes
- Q12 and Q14 are separate server implementations; do not run them simultaneously because both use port 5000.
- The TCP echo server uses port 5001 and the multi-client server uses port 5002 to avoid port conflicts.
- `https://www.example.com/sample.txt` is the exact demonstration URL from the sheet, but it may not contain an actual downloadable file. If the download fails, the program prints the error rather than silently succeeding.
- Java's URL constructor is retained for the lab exercise. On modern Java versions, `https://example.com` is used for Q18.
- The password bean intentionally has no getter because the property is write-only.
- DateBean and CircleBean computed values intentionally have no setters because they are read-only.
