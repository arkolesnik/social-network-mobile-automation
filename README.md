# Automation for Android mobile app of Mewe social network (Java, TestNG, Selenium WebDriver, Appium)

Tested on emalator Nexus 5X. 
Used shall command: 
emulator -avd Nexus_5X_API_26_x86 -netdelay none -netspeed full -wipe-data

Installed Android SDK and properly set PATH are required. 
Also you should change APK_PATH and APPIUM_URL for yourself in AndroidFixture class.

To run test from IDE, use testng.xml configuration file. 
To run test from command line, use 'mvn test' command.