
A simple Java console app that generates Java method stubs from descriptions using OpenAI GPT.

## Setup
- Java 11+
- Set your OpenAI API key as `OPENAI_API_KEY` environment variable

## Run
```bash
mvn clean compile exec:java -Dexec.mainClass="ai.generator.Main"
```

## Usage
Enter a method description like:

> "A method that calculates the factorial of a number recursively."


 
