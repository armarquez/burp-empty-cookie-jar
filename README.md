# Burp Empty Cookie Jar

## Author

Written by Anthony Marquez ([@BoogeyMarquez](https://twitter.com/boogeymarquez))

## Description

A burp extensions that I created a security assessment to solve a simple problem, and I figure I would share them with others to save some pain. Essentially it it provides a way to empty the Burp cookie jar while performing an action in session handling rule.

## Building Instructions

Make sure you have `gradle` installed

```bash
brew install gradle
```

Navigate to base of directory, you should see `build.gradle` file.

```bash
gradle build
```

You should have a `burp-empty-cookie-jar-VERSION.jar` file in the
`build/libs/` folder.  Load it within Burp and you are good to go.

## Loading Instructions
1. Download latest [release](https://github.com/praetorianlabs-amarquez/burp-empty-cookie-jar/releases) 
or compile using instructions above.
2. Launch BurpSuite, go to the Extender tab and then open the Extensions tab and
click on "Add". 
3. In the dialog window, select "java" as Extension Type and select the 
downloaded jar file. 
4. Where appropriate, under the `Options->Sessions` tab, click `Add` button 
under the *Session Handling Rules*
5. Click `Add` button under *Rule Actions* and then select `Invoke a Burp extension` 


For further details about BurpSuite extensions, refer
to their [documentation](https://portswigger.net/burp/help/extender.html#loading).
