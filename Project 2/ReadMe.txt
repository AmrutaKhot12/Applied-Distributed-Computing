Open putty.exe
1. SSH to cssgate.insttech.washington.edu
2. Login : akhot
3. Password : ItDyshejbo

Files are present in Project 2 folder
Compile files using javac *.java

Start RMI Registry using rmiregistry &
if want to run rmiregistry on a different port than 1099 use the following command
rmiregistry 2001 &

start the Server
java RMIServer <portno>


open a different window using putty
start the Client
java RMIClient <portno>



