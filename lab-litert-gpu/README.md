# GPU, one thread, warm-up, and latency

## What this topic is

One background thread owns the model. GPU options list CPU as the fallback. Measure run together with the output read. Warm up once so the first user tap is not the shader compile.

## Why an Android AI engineer needs it

A GPU delegate that is touched from the main thread, or timed without the readback, lies about latency.

## Diagram

```mermaid
flowchart LR
  n0["Create on one thread"] --> n1["Warm-up"] --> n2["Timed runs"]
```

## What you will change

- A repeat count

## Pass condition

The screen shows a warm-up time and a steady-run time.

## Sources

- [LiteRT on Android](https://ai.google.dev/edge/litert/android)
