# TASK--3-MULTITHREADED-CHAT-APPLICATION

*Company*:Codtech It solutions

*Intern Id*:CT04WE92

*Domain*:Java

*Duration*:4 weeks

*Mentor*:NEELA SANTHOSH

📝 Task Overview
This Java-based client-server chat application demonstrates fundamental networking concepts using socket programming with a graphical user interface. Developed during my internship, this project showcases real-time bidirectional communication between two endpoints.

🌟 Key Features
Real-time text messaging between client and server

Simple GUI built with Java AWT components

Multi-threaded architecture for simultaneous operations

TCP socket implementation using Java's networking API

Platform-independent Java application

🛠️ Technical Specifications
System Requirements
Component	Requirement
Java Version	JDK 8+
Network	Localhost connection
Dependencies	Standard Java libraries only
File Structure
File	Purpose
server.java	Server-side application
client.java	Client-side application
🚀 Quick Start Guide
Step 1: Compilation
bash
Copy
javac server.java
javac client.java
Step 2: Execution
First run the server:

bash
Copy
java server
Then run the client:

bash
Copy
java client
Step 3: Usage
Type messages in the text field

Click "Send" or press Enter

View conversation in the text area

💻 Code Implementation
Core Components
Network Connection

java
Copy
// Server
serverSocket = new ServerSocket(1000);
socket = serverSocket.accept();

// Client
socket = new Socket("LocalHost", 1000);
Data Transmission

java
Copy
// Sending
dataOutputStream.writeUTF(message);

// Receiving
String msg = dataInputStream.readUTF();
GUI Elements

java
Copy
textField = new TextField();  // Input
textarea = new TextArea();    // Chat display
send = new Button("Send");    // Send button
📊 Sample Workflow
Server starts listening on port 1000

Client connects to server

Either side can send messages

Messages appear with sender prefix:

Copy
Server: Hello client!
Client: Hi server!
⚠️ Known Limitations
Single Client Only

Supports only one concurrent client connection

Basic Functionality

No message history persistence

Minimal error handling

Local Testing Only

Configured for localhost by default

🔮 Future Enhancements
Priority Features
Feature	Status
Multiple client support	Planned
Message encryption	Future
File transfer	Future
Additional Improvements
Add timestamps to messages

Implement user authentication

Create message history logging

Improve GUI with Swing

📚 Learning Outcomes
Through this project I gained:

Practical socket programming skills

Client-server architecture understanding

Java GUI development experience

Multi-threading implementation knowledge

Network I/O stream handling

⚠️ Troubleshooting
Common Issues
Connection Failed

Verify server is running first

Check port availability

Message Not Delivered

Ensure both applications are running

Verify network connectivity

GUI Not Responding

Check for unhandled exceptions

Restart both applications

*output*

