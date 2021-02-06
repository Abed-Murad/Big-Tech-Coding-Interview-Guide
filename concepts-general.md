# General Concepts

* **How Does `Streaming APIs` woks?**
    - Streaming APIs are the opposite of `REST APIs`.
    - When communicating with a `REST API`, you make a request and the API sends a response.
    - A streaming API works differently. It Connects to a client and continuously listens to new information.
    - ex: Twitter streaming API to stream tweets in real time

* **What is the difference between `Hot Streams` & `Cold Streams`?**
    - Hot streams push values even when there is no one consuming them.
    - Cold streams start pushing values only when you start collecting!
  