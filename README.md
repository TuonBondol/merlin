# merlin [![](https://ci.novoda.com/buildStatus/icon?job=merlin)](https://ci.novoda.com/job/merlin/lastBuild/console) [![Download](https://api.bintray.com/packages/novoda/maven/merlin/images/download.svg) ](https://bintray.com/novoda/maven/merlin/_latestVersion) [![](https://raw.githubusercontent.com/novoda/novoda/master/assets/btn_apache_lisence.png)](LICENSE.txt)

An ok name for a library.


## Description

Merlin aims to simplify network monitoring. Providing 3 registerable callbacks for network connectivity changes.
`onConnect()` , `onDisconnect()` and `onBind(NetworkStatus networkStatus)`.


## Adding to your project

To start using this library, add these lines to the `build.gradle` of your project:

```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'com.novoda:merlin:0.10.0'
}
```

You'll need to add a few things to your manifest :

These permissions (if you don't already have them)

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

this service

```xml
<service android:exported="false" android:name="com.novoda.merlin.service.MerlinService" />
```


## Simple usage

Create Merlin:

```java
merlin = new Merlin.Builder().withConnectableCallbacks().build(context);
```

Bind and unbind the service in your activity:

```java
@Override
protected void onResume() {
    super.onResume();
    merlin.bind();
}

@Override
protected void onPause() {
    merlin.unbind();
    super.onPause();
}
```

Register for callbacks:

```java
merlin.registerConnectable(new Connectable() {
    @Override
    public void onConnect() {
        // Do something you haz internet!
    }
});
```

Also check the [wiki](https://github.com/novoda/merlin/wiki/Usecases-and-API-usage#retrieve-current-network-state) to see how you can use `MerlinsBeard` to check the network state.


## Links

Here are a list of useful links:

 * We always welcome people to contribute new features or bug fixes, [here is how](https://github.com/novoda/novoda/blob/master/CONTRIBUTING.md)
 * If you have a problem check the [Issues Page](https://github.com/novoda/merlin/issues) first to see if we are working on it
 * For further usage or to delve more deeply checkout the [Project Wiki](https://github.com/novoda/merlin/wiki)
 * Looking for community help, browse the already asked [Stack Overflow Questions](http://stackoverflow.com/questions/tagged/support-merlin) or use the tag: `support-merlin` when posting a new question





