# AppFunctions

## What this topic is

The app publishes a function the system can offer to an agent. The agent calls it without opening the UI.

## Why an Android AI engineer needs it

This is how an on-device agent runs an action in your app.

## Diagram

```mermaid
flowchart LR
  n0["Declaration"] --> n1["System index"] --> n2["Agent call"] --> n3["Result"]
```

## What you will change

- A function name
- One argument

## Pass condition

The declared function returns the value for that argument.

## Sources

- [AppFunctions overview](https://developer.android.com/ai/appfunctions)
- [Add AppFunctions](https://developer.android.com/ai/appfunctions/add-appfunctions)
