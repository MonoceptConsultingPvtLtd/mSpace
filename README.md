Download and Install Java
-Set Java Environment Variables for Java
-Set JAVA_HOME in System variable

Download Node.js:
-Visit the official Node.js website: Node.js Downloads.
-Download the LTS (Long Term Support) version for your operating system 
-Verify Installation by opening a new command prompt and type npm -v and node -v

Install Appium:
-Once Node.js and npm are installed, you can use npm to install Appium globally through command prompt
type npm install -g appium
-Verify Appium Installation by opening a new command prompt and type appium --version

Download and Install Appium Inspector:
-Go to this link https://github.com/appium/appium-inspector/releases and select Appium-Inspector-windows-2023.12.2-x64.exe
-It will be automatically downloaded.
-Run Appium Inspector by Opening Appium Desktop:
-Start a New Session by Clicking on the "Start Server v1.17.1" button
-Set Desired Capabilities as follow:
{
  "appium:platformName": "Android",
  "appium:platformVersion": "12",
  "appium:deviceName": "Oneplus 7",
  "appium:deviceID": "97d179ec",
  "appium:appActivity": ".MainActivity",
  "appium:appPackage": "com.superapp",
  "appium:automationName": "UiAutomator2"
}

Download and Install Android Studio:
-Go to link https://developer.android.com/studio?gclid=EAIaIQobChMIkp6SweOigwMVwKlmAh3CbgK5EAAYASAAEgIzBfD_BwE&gclsrc=aw.ds and download latest Android Studio
-Once the download is completed, Run the Installer.
-Choose Components:During installation, you'll be prompted to select components to install. Ensure that you select the components you need, such as the Android SDK and Virtual Device.(Select Both)
-Configure Android Studio:
-Android Studio may prompt you to import settings or configure the IDE. Follow the on-screen instructions to set up Android Studio according to your preferences.
Install the Android SDK:
-Android Studio will download and install the Android SDK during the installation process.
Finish Installation:
-Once the installation is complete, you may be asked to start Android Studio for the first time. Click "Finish" to complete the installation.
Set Environment Variables (Path) for Android Studio:
-Locate the Android SDK Directory:
-Navigate to the directory where Android Studio installed the SDK. The default location is typically C:\Users\YourUsername\AppData\Local\Android\Sdk
Set Environment Variables:
-C:\Users\YourUsername\AppData\Local\Android\Sdk\platform-tools and C:\Users\YourUsername\AppData\Local\Android\Sdk\tools).
-Verify Installation by opening command prompt and type adb version

Download Eclipse from this link https://www.eclipse.org/downloads/
-Once the download is complete, locate the downloaded file and run the application
-Open Eclipse and Set Up Workspace- Choose a workspace location (a directory where your projects will be stored).

Install Required Plugins- TestNG
-Navigate to Eclipse Marketplace:
-Go to Help > Eclipse Marketplace.
-Search for TestNG by typing in search bar as TestNG
-Install TestNG:
-You should see "TestNG for Eclipse" in the search results. Click on it.
-Click the "Go to the Marketplace" link, and then click the "Install" button
-After installation restart the eclipse.

-Clone the GitHub Repository from https://github.com/MonoceptConsultingPvtLtd/MLISuperAppQA.git from master branch
-Import the Project into Eclipse:
-In Eclipse, go to File > Import.
-Choose Git > Projects from Git and click "Next."
-Select "Existing local repository" and click "Next."
-Click "Add" to add the local repository you cloned.
-Browse to the directory where you cloned the repository and click "Search."
-Select the repository and click "Finish."
To Run the Automation Framework:
-Connect Mobile to laptop and Switch on developer's option, USB debugging in mobile
-To verify connection: Open command prompt and type adb devices(Should be able to see  devivce ID)
-Open Eclipse> Go to src/test/java package > experiment package > Experiment class > Right Click > Run As TestNG

