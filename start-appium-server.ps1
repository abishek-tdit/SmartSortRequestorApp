# Start Appium Server with proper Android SDK configuration
# This script ensures ANDROID_HOME is set before starting Appium

# Set ANDROID_HOME environment variable
$env:ANDROID_HOME = "C:\Users\$env:USERNAME\AppData\Local\Android\Sdk"

# Verify Android SDK exists
if (-not (Test-Path $env:ANDROID_HOME)) {
    Write-Error "Android SDK not found at $env:ANDROID_HOME"
    exit 1
}

Write-Host "ANDROID_HOME is set to: $env:ANDROID_HOME"
Write-Host "Android SDK Version Check:"
& "$env:ANDROID_HOME\build-tools" | Get-ChildItem | Sort-Object -Descending | Select-Object -First 1

Write-Host "Starting Appium Server..."
Write-Host "Appium will be available at: http://127.0.0.1:4723"
Write-Host "Press Ctrl+C to stop the server"
Write-Host ""

# Start Appium server
appium

