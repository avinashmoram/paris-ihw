# paris-ihw
deltaspike infinite redirects on IE window.open
1. Pre-requisites is JDK 1.8(or later), Maven 3.3(or later)
2. Download the project and build it with mvn clean install
3. Deploy it on the server, I have used Red Hat Jboss EAP 7 as my server
4. And open the application on your browser using http://localhost:8080/paris-ihw/
5. The application works fine on both IE and firefox, but if we open the same application using a window.open on IE the 
application goes into inifinite redrects.
6. To open the application in a pop up, there is an html file with name "ds_ie_infinite_redirects_test.html", I have 
hardcoded the application url (http://localhost:8080/paris-ihw/) from step 4 in there, if you changed your port or using
any other host name other than localhost, please make changes accordingly
7. If you click on the link on that html page on IE, you will see a notification "Internet Explorer restricted this 
webpage from running scripts or ActiveX controls", just click "Allow blocked content" button
8. Then you will the see the application opening in the window, you see a blank blue page; the application has already
started going into infinite redirects
9. If you click on F12 (Developer tools) and click on Network tab and click capture, you can see the url with empty "dswid="
and infinite redirects
