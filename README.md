ArrayRotatorDemo
================

This is an eclipse maven project, so you have two ways to run it.

1. Use https://github.com/winedrinker/ArrayRotatorDemo.git URL to clone the repository in eclipse
and run the test and the demo from the eclipse in the normal way.

2. Download project from https://github.com/winedrinker/ArrayRotatorDemo/archive/HEAD.zip extract it
to a directory. Go into org.array.rotate directory and run "mvn install". That will compile and test 
the project and will create an executable jar into target directory. You can run that jar 
from the console without any paramater (e.g.: java -jar org.array.rotate-1.0.0.jar).


When you run the application first you should set the "positions" which can be any integer.
If you type anything else the program will exist. When you properly set the positions you should
define the array in a simple way, just type an integer + ENTER repetitive and type and key + ENTER
if you want to finish the array define. After this the program will show the original and the rotated 
arrays.