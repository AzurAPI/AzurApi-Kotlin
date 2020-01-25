# Changelog

## 3.1.0 (2020-01-25)

### New features

- **getShipByName** can take an optional language parameter

### Bug fixes

- Fix json parsing

## 3.0.0 (2020-01-06)

Versions **< 3.0.0** are **DEPRECATED** and cannot be used

### Breaking changes

- **Ship**: 
  - `buildTime` type change from `String` to `ShipConstruction`.
  - `misc.voice` type change from `String` to `Url`.

## 2.0.1 (2019-12-11)

### Bug fixes

- Fix json version parsing 

## 2.0.0 (2019-12-09)

### Breaking changes

- **Version** class attribute type has changed
    - `databaseVersion`: `String` -> `Int`
    
### Misc

- **reloadDatabase**: updates only if there is a an available new version

## 1.0.0 (2019-12-08)

First public release

### New features

- **getVersion**: returns API version
- **reloadDatabase**: updates database

## 0.1.0 (2019-12-07)

Pre release

### New features

- **getShipByName**: returns the closest ship which name matches the requested name
- **getShipById**: returns ship with the given ID
- **getAllShips**: returns a list of all available ships in database