# Structured output and prefix caching

Two habits make a Prompt API call something an app can rely on. Structured output binds the reply to a Kotlin type, so you parse an object with known fields. Prefix caching keeps the stable front of the prompt — the instructions and examples that repeat on every call — apart from the suffix that changes per user. You pay to prepare the prefix once, then send the new suffix against that cache. The lab shows both: a typed object on screen, and the prefix marked as the cached part.

Suggested after [Gemini Nano Prompt API](../lab-prompt-api/README.md).

## A Kotlin type is the contract

Decide the type before you write the prompt. A city extractor might be a type with a single `String` field `city`. A receipt scanner might have `merchant`, `total`, and `currency`. The structured-output API asks the model for an object that matches that schema. Your code receives the object, or a parse failure. A parse failure is a result you can show and log. A paragraph you slice with `substring` breaks the next time the model adds a polite sentence.

The prompting lab already required the field name to appear in the draft. Here the field is a property the compiler knows. If the screen shows a typed object, you can point at `city` and know the parse succeeded.

## The prefix is the part that repeats

Read a production prompt from back to front.

- The **prefix** is stable: the instruction, the schema reminder, the two examples you always send.
- The **suffix** is the new part: this user’s sentence, this photo’s caption, this support ticket.

Sending the full text on every keystroke repeats the same tokens and, on a phone, repeats the same work. Prefix caching stores the processed prefix. The next call sends the suffix and refers to the cache. The model still sees prefix plus suffix as one prompt. Your code can mark the prefix as the cached part, which is what this lab checks.

Cache the wrong slice and you freeze the user’s text into the prefix, so the second question answers the first. Cache nothing and every call reprocesses the examples. The split is a product decision: what is identical across calls belongs in the prefix.

The context window still applies to prefix plus suffix plus the reply. A cached prefix counts toward that budget.

## Cached prefix, fresh suffix, typed object

```mermaid
flowchart LR
  prefix["Prefix: instructions and examples"] --> cache["Cached prefix"]
  suffix["Suffix: this request"] --> call["Prompt"]
  cache --> call
  call --> typed["Typed Kotlin object"]
```

## What you will change

- A prefix
- A suffix

## Pass condition

The screen shows a typed object, and the prefix is marked as the cached part.

## Sources

- [Structured output](https://developers.google.com/ml-kit/genai/prompt/android/structured-output)
- [Prefix caching](https://developer.android.com/agents/skills/device-ai/ml-kit-genai-prompt-api/references/prefix-caching)
