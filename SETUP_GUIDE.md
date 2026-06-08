# Android Appium Test Setup Guide

## Prerequisites Checklist

### 1. Android SDK Installation ✓
Your Android SDK is installed at: `C:\Users\TDIT-TEST-L-09\AppData\Local\Android\Sdk`

### 2. ANDROID_HOME Environment Variable ✓
Verified that `ANDROID_HOME` is set correctly.

### 3. Java Installation
Verify Java is installed:
```powershell
java -version
```

### 4. Node.js & Appium
Verify Appium is installed globally:
```powershell
appium --version
```

If not installed:
```powershell
npm install -g appium
npm install -g appium-doctor
```

### 5. Appium Doctor (Diagnostic Tool)
Check your Appium setup:
```powershell
appium-doctor --android
```

---

## Running the Tests

### Step 1: Start the Appium Server
Run the provided script in PowerShell:
```powershell
# Navigate to project directory
cd C:\Users\TDIT-TEST-L-09\IdeaProjects\appiumfirs

# Run the startup script
.\start-appium-server.ps1
```

**Expected Output:**
```
ANDROID_HOME is set to: C:\Users\TDIT-TEST-L-09\AppData\Local\Android\Sdk
Starting Appium Server...
Appium will be available at: http://127.0.0.1:4723
...
[Appium] Appium REST http interface listener started on 0.0.0.0:4723
```

### Step 2: Connect Android Device
Verify your device is connected and has USB debugging enabled:
```powershell
adb devices
```

You should see:
```
List of attached devices
LVDMSGIZRWY5NNEI        device
```

### Step 3: Run the Tests
In a new PowerShell window, run:
```powershell
cd C:\Users\TDIT-TEST-L-09\IdeaProjects\appiumfirs
mvn clean test
```

---

## Troubleshooting

### Error: "The Android SDK root folder does not exist"
**Solution:** Make sure the Appium server is started using the provided script, which properly sets `ANDROID_HOME`.

### Error: "Device not found" or "LVDMSGIZRWY5NNEI is offline"
**Solution:** 
1. Connect your device via USB
2. Enable USB debugging: Settings → Developer Options → USB Debugging
3. Trust the computer when prompted on the device
4. Run: `adb devices` to verify connection

### Error: "Failed to connect to server"
**Solution:**
1. Make sure the Appium server is running (Step 1)
2. Verify the address is correct: `http://127.0.0.1:4723`
3. Check that port 4723 is not blocked by firewall

### Cannot find class file errors
**Solution:**
1. Run: `mvn clean install` to rebuild the project
2. Verify all dependencies are downloaded: `mvn dependency:tree`

---

## Additional Commands

### Check Appium Configuration
```powershell
appium --help
```

### Verify Device is Ready
```powershell
adb shell getprop ro.build.version.release
adb shell dumpsys window | grep -i "mCurrentFocus"
```

### Check Available Emulators
```powershell
emulator -list-avds
```

### Set ANDROID_HOME Permanently (Optional)
If you want to set it permanently for all terminal sessions:
```powershell
[System.Environment]::SetEnvironmentVariable('ANDROID_HOME', 'C:\Users\TDIT-TEST-L-09\AppData\Local\Android\Sdk', 'User')
```

---

## Test Configuration

The test is configured to:
- **Device ID:** LVDMSGIZRWY5NNEI
- **App Package:** com.android.settings
- **App Activity:** .Settings
- **Appium Server:** http://127.0.0.1:4723

To run a different app, modify `src/main/java/com/mobileautomation/AndroidTest.java`:
```java
.setAppPackage("com.your.app")
.setAppActivity(".YourActivity")
```

