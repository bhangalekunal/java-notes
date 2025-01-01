# Introduction
Java is one of the most popular programming languages, and understanding its core concepts is crucial for any developer. In this blog, we’ll explore some essential differences between key Java concepts. These distinctions will help you write better code and ace your interviews!

## 1. Process vs Thread
| **Process**                                                                                      | **Thread**                                                                                     |
|--------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------|
| Process is a heavy-weight task currently in execution.                                           | Thread is a lightweight process.                                                              |
| Every process has its own address space.                                                        | Every thread shares the address space of the process that created it.                         |
| A program can be broken down into one or more processes.                                         | A process creates one or more threads to accomplish its tasks.                                |
| The operating system takes more time to create a process.                                        | The operating system takes less time to create a thread.                                      |
| Process-based multitasking allows your computer to run two or more programs concurrently.        | Thread-based multitasking allows a single program to perform two or more tasks simultaneously.|
| Process-based multitasking allows you to run more than one program at a time (e.g., running a Java compiler while using a text editor). | Thread-based multitasking allows tasks within a program (e.g., a text editor formatting text and painting simultaneously). |
| In process-based multitasking, a program is the smallest unit of code dispatched by the scheduler.| In thread-based multitasking, the thread is the smallest unit of dispatchable code.            |
| Multitasking processes require more overhead than multitasking threads.                         | Multitasking threads require less overhead than multitasking processes.                       |
| Processes are heavy-weight tasks that require their own address space.                          | Threads are lightweight tasks that share the same address space.                              |
| Inter-process communication is expensive and limited.                                            | Inter-thread communication is inexpensive.                                                    |
| Context switching from one process to another is costly.                                         | Context switching from one thread to another is low cost.                                     |


## 2. wait() vs sleep()
| **wait()**                                              | **sleep()**                                              |
|---------------------------------------------------------|----------------------------------------------------------|
| `wait()` method releases the lock of the monitor.       | `sleep()` method does not release the lock of the monitor.|
| Cannot call the `wait()` method outside a synchronized block or method. | Can call the `sleep()` method anywhere in the class.      |
| `wait()` method is present in the `Object` class.       | `sleep()` method is present in the `Thread` class.       |
| `wait()` is a non-static method.                        | `sleep()` is a static method.                            |

## 3. Stack Memory vs Heap Memory
|                                                         | **Stack**                                              |  **Heap**                                    | 
|---------------------------------------------------------|----------------------------------------------------------|--------------------------------------------|
| `Memory`        |  Stack memory is used only by one thread of execution. | Heap memory is used by all the parts of the application.|
