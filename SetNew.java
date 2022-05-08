package JsonWriter;

public class SetNew {
	Object key, value;
	boolean value_is_json = false;
	
	public SetNew(Object myKey, Object myValue, boolean... is_json)
	{
		this.key = myKey;
		this.value = myValue;
		if ( is_json.length == 1 && is_json[0] ) this.value_is_json = true;
	}
}
