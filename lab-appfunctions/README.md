# AppFunctions

An AppFunction is a function your app publishes so the system can offer it to an agent. The agent calls it with an argument and receives a value. The user does not have to open your activity. The function is real code, with a declaration the system can index and a KDoc the agent can read when it decides to call.

Suggested after [First run, heat, and the profiler](../lab-performance/README.md).

## Declaration, KDoc, implementation

**The declaration** says the function exists, what it is called, and what argument it takes. The system indexes that declaration. A function that only exists as a public Kotlin method on a class the system has never heard of will not be offered to anyone.

**The KDoc** is the description the agent reads. Write the job, the argument, and the value you return, in words a caller can match to a user request. "Returns the stand for a hall name" gives the agent a reason to call. "Helper" gives it nothing. The KDoc is part of the product, because a wrong call still runs your code.

**The implementation** computes the value. This lab’s pass is narrow: the declared function returns the value for the argument you typed. If the argument is `B` and the function is supposed to return `hall B`, the result is `hall B`. The agent loop from the literacy lab is the other side of the same idea. There, the model requested a tool and your app ran it. Here, the system is the caller, and the tool is a function you registered.

## What the call is allowed to see

The call arrives without your UI on screen. It can run while the user is in another app, talking to an assistant. Anything you return leaves your process boundary and enters the agent’s context. A function that returns a private note, a location, or a message is a privacy decision from the privacy lab, even though no cloud model was involved. Return the smallest value that answers the argument. Refuse arguments you did not declare.

Keep the function deterministic and fast. The caller is waiting, and a function that silently starts a 2 GB model download will look broken. If the work needs a model, check that the model is present and return an explicit unavailable result when it is missing. The testing lab’s statuses are the pattern: unavailable and downloading are explanations, and a ready path returns the real value.

## From a declaration to a result

```mermaid
flowchart LR
  decl["Declaration and KDoc"] --> index["System index"]
  index --> call["Agent call, UI stays closed"]
  arg["One argument"] --> call
  call --> fn["Your function"]
  fn --> value["The value for that argument"]
```

## What you will change

- A function name
- One argument

## Pass condition

The declared function returns the value for that argument.

## Sources

- [AppFunctions overview](https://developer.android.com/ai/appfunctions)
- [Add AppFunctions](https://developer.android.com/ai/appfunctions/add-appfunctions)
