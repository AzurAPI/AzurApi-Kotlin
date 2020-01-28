# AzurApi-Kotlin
A Kotlin wrapper for Azur Lane JSON

[![Release](https://jitpack.io/v/AzurAPI/AzurApi-Kotlin.svg?style=flat-square)](https://jitpack.io/#AzurAPI/AzurApi-Kotlin)
[![Build Status](https://img.shields.io/endpoint.svg?url=https%3A%2F%2Factions-badge.atrox.dev%2Fazurapi%2Fazurapi-kotlin%2Fbadge&style=flat-square)](https://actions-badge.atrox.dev/azurapi/azurapi-kotlin/goto)
[![Downloads](https://jitpack.io/v/AzurAPI/AzurApi-Kotlin/week.svg?style=flat-square)](https://jitpack.io/#AzurAPI/AzurApi-Kotlin)

## Use
<details><summary>gradle</summary>

```kotlin
repositories {
    maven(url = "https://jitpack.io")
}
```

```kotlin
dependencies {
    implementation("com.github.AzurAPI:AzurApi-Kotlin:Tag")
}
```
</details>

<details><summary>maven</summary>

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

```xml
<dependency>
    <groupId>com.github.AzurAPI</groupId>
    <artifactId>AzurApi-Kotlin</artifactId>
    <version>Tag</version>
</dependency>
```
</details>

## Example

Use methods from `Atago` class

```kotlin
val atago = Atago.getShipByName("atago")
println(atago.names.en)
```

## Support server
![Discord Banner 2](https://discordapp.com/api/guilds/648206344729526272/widget.png?style=banner2)
