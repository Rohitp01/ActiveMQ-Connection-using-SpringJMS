# ActiveMQ-Connection-using-SpringJMS

This code is a Java spring project to connect a spring project with an Apache ActiveMQ hosted on a local server. Both the Sender and Receiver code files are present along with the main method in the DemoMain class.
The sender code initially enqueuesa a message in the ActiveMQ and the receiver code then runs a thread to listen to any messages if there in the MQ.
It follows the PubSub model of communication.
