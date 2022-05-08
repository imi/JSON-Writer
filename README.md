<h1 style="text-align: center";">JSON Object Writer</h1>
<p style="text-align: center; font-size: 20px"> A very basic and a simple JSON writer in Java </p>

### Usage
- Create a Jobj class: ```Jobj jobj = new Jobj();```
- Add elemnts to your writer: ``` jobj.put("KEY", "VALUE");``` Key and Value can be any type.
- Convert your class to json string: ```String json = jobj.toString();```

#### Add JSON object to your current JSON object
- Create another Jobj class and added to your current class ``` jw.put("OtherJson", MyObj); ```
- Or add a JSON string ``` jw.put("MyString", "{\"numbers\": [1, 2, 3, 4, 5]}", true) ```

### Other Functions
- ``` .get("KEY")``` Get value using key don't forget to cast the return.
- ``` .remove("KEY")``` Remove element using key.

##

### Contacts
- [Instagram](https://instagram.com/0835221213)
- [Telegram](https://t.me/Pwwwww)