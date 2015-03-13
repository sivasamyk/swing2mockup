# How To #

The following are the steps required to convert your Swing Window to [WireframeSketcher](http://wireframesketcher.com) mockup using Swing2Mockup

1) Download the swing2mockup-x.y.jar from the [Downloads](http://code.google.com/p/swing2mockup/downloads/list) section of the project.

2) If you are using any IDE like Eclipse/IntelliJ Idea, add the above jar to your application classpath.Change the main class of the application to org.swing2mockup.main.Swing2Mockup in debug/run configuration. Pass your actual application main class as command line parameter.

3) To run the application from command line,use the following command
> `java -cp <your application classpath>;swing2mockup-x.y.jar org.swing2mockup.main.Swing2Mockup <your application classpath> <your application command line parameters>`
e.g. If your actual application launch command is
> `java -cp SwingSet2.jar SwingSet2 -lnf Metal`
then change the command to
> `java -cp SwingSet2.jar;swing2mockup-x.y.jar org.swing2mockup.main.Swing2Mockup SwingSet2 -lnf Metal`

4) After the application is launched, highlight the window that has to be converted to mockup and press _Alt + Shift + F5_ to export the mockup XML to clipboard.

5) Create a new Wireframesketcher mockup screen and paste the clipboard contents.

# Suggestions and Issues #
If there are any suggestions or issues found please report them in the [Issues](http://code.google.com/p/swing2mockup/issues/list) section of the project.