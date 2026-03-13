# Unified Notification Platform

Academic example of Bridge and Adapter patterns in Java.

## Structure

- `bridge.NotificationChannel`: common sending interface.
- `bridge.Message` and `bridge.CriticalMessage`: Bridge abstraction.
- `bridge.EmailChannel`: modern console implementation.
- `adapter.SmsAdapter`: adapter for the legacy `LegacySmsSystem`.
- `bridge.GuiChannel` + `ui.NotificationFrame`: visual channel for showing notifications in a window.

## Run

Compile:

```bash
javac src/Main.java src/bridge/*.java src/adapter/*.java src/ui/*.java
```

Run with graphical interface:

```bash
java -cp src Main
```

Run in headless environment (no screen):

```bash
java -Djava.awt.headless=true -cp src Main
```

In headless mode, the program still sends through Email and SMS, and skips the visual window.

