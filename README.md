# BANK-ATM-Remote-proxy-design-pattern
This is a implementation of remote proxy. Where Bank class works as remote class and ATM class works as proxy.

# User Manual
1. Run Bank project first. It starts the socket. [works as server]
2. Run ATM project. [works as client]
*1. If you are using eclipse then open 'Bank' in one eclipse process. or import 'Bank'.
*2. then open 'ATM' in one eclipse process. or import 'ATM'.



# Remote Proxy:
When an object whose method you want to call is running on another computer, you cannot call the method directly, so you must find another way to communicate with it. You could open a socket on the remote machine and devise some protocol to pass messages to the remote object. Ideally, such a scheme would let you pass messages in almost the same way as if the object were local.

