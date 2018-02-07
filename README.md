# RxBattery

[![CircleCI](https://circleci.com/gh/yongjhih/rx-battery.svg?style=shield)](https://circleci.com/gh/yongjhih/rx-battery)
[![codecov](https://codecov.io/gh/yongjhih/rx-battery/branch/master/graph/badge.svg)](https://codecov.io/gh/yongjhih/rx-battery)

## Usage

```java
RxBattery.changes(context).subscribe();
```

```kt
context.batteryChanges().subscribe();
```

## Installation

RxJava2:

```gradle
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.yongjhih.rx-battery:rx2-battery:-SNAPSHOT'
    compile 'com.github.yongjhih.rx-battery:rx2-battery-kotlin:-SNAPSHOT'
}
```

RxJava1:

```gradle
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.yongjhih.rx-battery:rx-battery:-SNAPSHOT'
    compile 'com.github.yongjhih.rx-battery:rx-battery-kotlin:-SNAPSHOT'
}
```

## See Also

* https://github.com/yongjhih/rx-receiver

## LICENSE

Apache 2.0
