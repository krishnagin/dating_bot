# dating_bot
Follow Along Dating Bot coding from Java Brains



# curl commands

## Create Conversation

```
curl -X POST -H "Content-Type: application/json" -d @create-conversation.json http://localhost:8080/conversations
```

## Add messages to a conversation

```
curl -X POST -H "Content-Type: application/json" -d @add-messages.json http://localhost:8080/conversations/bfbf77a0-8863-48ba-9ce6-50fd1e5ce0aa
```

## Get messages of a conversation

```
curl -X GET -H "Content-Type: application/json" http://localhost:8080/conversations/bfbf77a0-8863-48ba-9ce6-50fd1e5ce0aa
```

