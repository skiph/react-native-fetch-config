
# react-native-fetch-client

## Getting started

`$ npm install react-native-fetch-client --save`

### Mostly automatic installation

`$ react-native link react-native-fetch-client`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-fetch-client` and add `RNFetchClient.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNFetchClient.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.criticalblue.reactnative.RNFetchClientPackage;` to the imports at the top of the file
  - Add `new RNFetchClientPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-fetch-client'
  	project(':react-native-fetch-client').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-fetch-client/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-fetch-client')
  	```


## Usage
```javascript
import RNFetchClient from 'react-native-fetch-client';

// TODO: What to do with the module?
RNFetchClient;
```
  