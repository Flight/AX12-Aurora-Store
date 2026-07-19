# AX12 Aurora Store

[![Release](https://img.shields.io/github/v/release/Flight/AX12-Aurora-Store?label=download)](https://github.com/Flight/AX12-Aurora-Store/releases/latest)
[![Android 9](https://img.shields.io/badge/Android-9%2B-3DDC84?logo=android)](https://github.com/Flight/AX12-Aurora-Store/releases/latest)
[![License: GPL-3.0](https://img.shields.io/badge/license-GPL--3.0-blue.svg)](LICENSE)

An unofficial Aurora Store build adapted for the RadioMaster AX12 and similar Android 9 devices. It fixes a failure where games containing legacy OBB expansion files download their base APK, then stop and return to the store page. The affected OBB directory is recreated and validated immediately before the file is written.

This fork installs beside the factory Aurora Store as **AX12 Aurora Store**, so the original system application and its data remain untouched.

## Download and install

1. Download **AX12-Aurora-Store-4.8.3-ax12.1.apk** from the [latest release](https://github.com/Flight/AX12-Aurora-Store/releases/latest).
2. Open the APK on the AX12 and allow installation from that source when Android asks.
3. Grant storage access during first-run setup. Android 9 needs it to write large games' OBB expansion files.
4. Choose **Google**, select the Google account already configured in microG, and approve the microG prompt.
5. Install games normally. Confirm Android's final package installation prompt when it appears.

Use the regular **Install** button first. **Manual download** is only needed when you intentionally
want a specific older version code or the normal Play listing does not offer the required build.

The build was tested on a RadioMaster AX12 running Android 9 with a clean installation of FPV.SkyDive, including its 349 MB OBB file.

## Tested firmware

Verified on a physical RadioMaster AX12 with:

- Android 9 (API 28)
- Build display ID: `radiomaster-AX12`
- Firmware build: `eng..20260629.135400` (June 29, 2026)
- Build fingerprint base: `Radiomaster/full_tb8788p1_64_bsp/tb8788p1_64_bsp:9/PPR1.180610.011/06291403`

Other Android 9 firmware builds may work, but this is the version used for the complete clean-install and OBB download test.

## Tested games

| Game | Result | Installation path |
| --- | --- | --- |
| FPV.SkyDive 1.4.4 (13) | Installed and launched | Regular **Install** button; base APK plus 349 MB OBB downloaded and verified by AX12 Aurora Store |
| FPV Freerider Recharged | Runs on AX12 | Previously installed with the host-assisted OBB workaround; not yet counted as an end-to-end AX12 Aurora Store test |

This table deliberately distinguishes a complete store installation test from games that merely run on the device.

## What changed

- App name changed to **AX12 Aurora Store**.
- Package ID is `com.aurora.store.debug`, allowing side-by-side installation with the factory `com.aurora.store` package.
- OBB parent directories are recreated and checked immediately before opening the temporary download file.
- The regular Aurora icon is used instead of the debug-badged icon.

## Security and provenance

Downloads still come directly from Google Play through Aurora Store. This fork does not bypass purchases or licensing. Sign in with the account that owns paid apps.

This is an unofficial community fork. It is not affiliated with or endorsed by Aurora OSS, RadioMaster, Google, or the developers of apps downloaded through it. Source code is based on Aurora Store 4.8.3 and remains licensed under GPL-3.0.

## Build

Requirements: JDK 21 and the Android SDK. Build the same APK with:

```sh
./gradlew :app:assembleVanillaDebug
```

Output: `app/build/outputs/apk/vanilla/debug/app-vanilla-debug.apk`.

## Upstream Aurora Store documentation

Aurora Store enables you to search and download apps from the official Google Play store. You can check app descriptions, screenshots, updates, reviews, and download the APK directly from Google Play to your device. 

To use Aurora Store, log in using Google Play account, when you first open and configure Aurora Store.

Unlike a traditional app store, Aurora Store does not own, license or distribute any apps. All apps, app descriptions, screenshots and other content in Aurora Store are directly accessed, downloaded and/or displayed from Google Play. 

Aurora Store works exactly like a door or a browser, allowing you to log in to your Google Play account and find the apps from Google Play. 

*_Please note that Aurora Store does not have any approval, sponsorship or authorization from Google, Google Play, any apps downloaded through Aurora Store or any app developers; neither does Aurora Store have any affiliation, cooperation or connection with them._*

[<img src="https://f-droid.org/badge/get-it-on.png" alt="Get it on F-Droid" height="90">](https://f-droid.org/packages/com.aurora.store/)
[<img src="https://gitlab.com/IzzyOnDroid/repo/-/raw/master/assets/IzzyOnDroid.png" alt="Get it on IzzyOnDroid" height="90">](https://apt.izzysoft.de/fdroid/index/apk/com.aurora.store)

## Features

- FOSS: Has GPLv3 licence
- Beautiful design: Built upon latest Material 3 guidelines
- Account login: You can login with either personal or an anonymous account
- Device & Locale spoofing: Change your device and/or locale to access geo locked apps
- [Exodus Privacy](https://exodus-privacy.eu.org/) integration: Instantly see trackers in app
- [Plexus](https://plexus.techlore.tech/) integration: Instantly see app compatibility without Google Play Services or with microG
- Updates blacklisting: Ignore updates for specific apps
- Download manager
- Manual downloads: allows you to download older version of apps, provided
  - The APKs are available with Google
  - You know the version codes for older versions 

## Limitations

- The underlying API used is reversed engineered from the Google Play Store, changes on side may break it.
- Provides only base minimum features
  - Can not download or update paid apps.
  - Can not update apps/games with [Play Asset Delivery](https://developer.android.com/guide/playcore/asset-delivery)
- Multiple in-app features are not available if logged in as Anonymous.
  - Library
  - Purchase History
  - Editor's choice
  - Beta Programs
  - Review Add/Update
- Token dispenser server is not super reliable, downtimes are expected.  

## Downloads

Please only download the latest stable releases from one of these sources:

- [Official website](https://auroraoss.com/)
- [GitLab Releases](https://gitlab.com/AuroraOSS/AuroraStore/-/releases)
- [IzzyOnDroid](https://apt.izzysoft.de/fdroid/index/apk/com.aurora.store) (reproducible)
- [F-Droid](https://f-droid.org/packages/com.aurora.store/) (signed by F-Droid, [more details](https://f-droid.org/docs/Signing_Process/))
- [App Gallery](https://appgallery.huawei.com/app/C110907863) (limited to certain countries)

You can also get latest debug builds signed with AOSP test keys for testing latest changes from our [GitLab Package Registry](https://gitlab.com/AuroraOSS/AuroraStore/-/packages/24103616).

## Certificate Fingerprints

- SHA1: 94:42:75:D7:59:8B:C0:3E:48:85:06:06:42:25:A7:19:90:A2:22:02
- SHA256: 4C:62:61:57:AD:02:BD:A3:40:1A:72:63:55:5F:68:A7:96:63:FC:3E:13:A4:D4:36:9A:12:57:09:41:AA:28:0F

## Support

Aurora Store v4 is still in on-going development! Bugs are to be expected! Any bug reports are appreciated.
Please visit [Aurora Wiki](https://gitlab.com/AuroraOSS/AuroraStore/-/wikis/home) for FAQs.

- [Telegram](https://t.me/AuroraSupport)
- [XDA Developers](https://forum.xda-developers.com/t/app-5-0-aurora-store-open-source-google-play-client.3739733/)

## Permissions

- `android.permission.INTERNET` to download and install/update apps from the Google Play servers
- `android.permission.ACCESS_NETWORK_STATE` to check internet availability
- `android.permission.FOREGROUND_SERVICE` to download apps without interruption
- `android.permission.FOREGROUND_SERVICE_DATA_SYNC` to download apps without interruption
- `android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS` to auto-update apps without interruption (optional)
- `android.permission.MANAGE_EXTERNAL_STORAGE` to access the OBB directory to download APK expansion files for games or large apps
- `android.permission.READ_EXTERNAL_STORAGE` to access the OBB directory to download APK expansion files for games or large apps
- `android.permission.WRITE_EXTERNAL_STORAGE` to access the OBB directory to download APK expansion files for games or large apps
- `android.permission.QUERY_ALL_PACKAGES` to check updates for all installed apps
- `android.permission.REQUEST_INSTALL_PACKAGES` to install and update apps
- `android.permission.REQUEST_DELETE_PACKAGES` to uninstall apps
- `android.permission.ENFORCE_UPDATE_OWNERSHIP` to silently update apps
- `android.permission.UPDATE_PACKAGES_WITHOUT_USER_ACTION` to silently update apps
- `android.permission.POST_NOTIFICATIONS` to notify user about ongoing downloads, available updates, and errors (optional)
- `android.permission.USE_CREDENTIALS` to allow users to sign into their personal Google account via microG

## Screenshots

<img src="fastlane/metadata/android/en-US/images/phoneScreenshots/screenshot-01.png" height="400">
<img src="fastlane/metadata/android/en-US/images/phoneScreenshots/screenshot-03.png" height="400">
<img src="fastlane/metadata/android/en-US/images/phoneScreenshots/screenshot-07.png" height="400">
<img src="fastlane/metadata/android/en-US/images/phoneScreenshots/screenshot-08.png" height="400">

## Translations

Don't see your preferred language? Click on the widget below to help translate Aurora Store!

<a href="https://hosted.weblate.org/engage/aurora-store/">
  <img src="https://hosted.weblate.org/widgets/aurora-store/-/287x66-grey.png" alt="Translation status" />
</a>

## Donations

You can support Aurora Store's development financially via options below. For more options, checkout the **About** page within the Aurora Store.

[![Liberapay](https://liberapay.com/assets/widgets/donate.svg)](https://liberapay.com/whyorean)
<a href="https://www.paypal.com/paypalme/AuroraDev">
  <img src="https://www.paypalobjects.com/webstatic/mktg/logo/AM_mc_vs_dc_ae.jpg" height="45" alt="PayPal">
</a>

## Project references

Aurora Store is based on these projects

- [YalpStore](https://github.com/yeriomin/YalpStore)
- [AppCrawler](https://github.com/Akdeniz/google-play-crawler)
- [Raccoon](https://github.com/onyxbits/raccoon4)
- [SAI](https://github.com/Aefyr/SAI)
