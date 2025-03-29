# Task Management System (TaskManager) - RMI

## Project Overview

The **Task Management System (TaskManager)** is a distributed application built using **Java RMI** (Remote Method Invocation). The project allows clients to remotely add tasks, list them, and mark them as completed, all while interacting with a server. The system is designed to simulate a basic task manager where tasks can be added, listed, and updated.

### Objective

The system allows clients to:

1. Add tasks
2. List tasks
3. Mark tasks as completed

### Architecture

The project is divided into the following components:

- **Server**: Implements the core task management logic.
- **Client**: Provides a console interface for interacting with the server.
- **RMI Registry**: Registers the server's remote object so that the client can access it.

---

## Project Structure
```
📂 RMI_TaskManager/
┣ 📂 src/
┃ ┣ 📂 taskmanager/
┃ ┃ ┣ 📂 model/ 
┃ ┃ ┃ ┣ 📜 TaskManager.java  # Interface for remote methods
┃ ┃ ┃ ┣ 📜 Task.java   # Task model
┃ ┃ ┣ 📂 service/ 
┃ ┃ ┃ ┣ 📜 TaskManagerImpl.java  # Implementation of the TaskManager interface
┃ ┃ ┃ ┣ 📜 TaskMainServer.java  # Server entry point
┃ ┃ ┃ ┣ 📜 TaskMainClient.java  # Client entry point
```
### **taskmanager.model**

- **TaskManager.java**: Defines the remote interface with methods to add, list, and mark tasks as completed.
- **Task.java**: Contains the structure of a task (description, ID, and completion status).

### **taskmanager.service**

- **TaskManagerImpl.java**: Implements the `TaskManager` interface, containing logic for managing tasks (adding, listing, and marking tasks).
- **TaskMainServer.java**: The entry point for starting the server. It binds the `TaskManagerImpl` object to the RMI registry.
- **TaskMainClient.java**: The entry point for starting the client. It provides the user interface for interacting with the server.

## How to Run the Project
1. **Compile the Java Files** (go to the src folder)
```bash
    javac taskmanager/model/*.java taskmanager/service/*.java
```
2. **Start the server**: Run `java taskmanager.service.TaskMainServer`.
3. **Start the rmiregistry**: Run `start rmiregistry`.
4. **Start the client**: Run `java taskmanager.service.TaskMainClient`.
5. **Interact with the client**: Use the command-line interface to add, list, and mark tasks as completed.

## Requirements

- **Java 8 or later**: Required for RMI and Java classes.
- **RMI Registry**: Ensure RMI registry is running on the host.

