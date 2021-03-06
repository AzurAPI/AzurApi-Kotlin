# Changelog

## 3.1.5 (2020-08-30)

- Upgrade to kotlin 1.4.0

## 3.1.4 (2020-07-19)

### Bug fixes

- Fix errors on ship stats parsing: optional value if it doesn't exist

## 3.1.3 (2020-02-18)

### Bug fixes

- Fix case sensitive option in `getShipById`

## 3.1.2 (2020-01-26)

### Bug fixes

- Fix `isLive2D` parsing

### Misc

- Separate code into 2 packages: `api` and `internal`: `internal` contents are not meant to be used by users

## 3.1.1 (2020-01-25)

### Misc

- `reloadDatabase` explicitly throws an exception

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
