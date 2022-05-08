package JsonWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Jobj {
	
	private ArrayList<SetNew> JSON = new ArrayList<>();
	
	public void put(Object key, Object value, boolean... is_json)
	{
		if ( is_json == null ) is_json = new boolean[] {};
		for ( int i = 0; i < JSON.size(); i++ )
		{
			SetNew parm = JSON.get(i);
			if ( parm.key == key || parm.key.equals(key))
			{
				if (is_json.length == 1 && is_json[0])
					JSON.set(i, new SetNew(key, value, true));
				else 
					JSON.set(i, new SetNew(key, value));
				return;
			}
		}
		if (is_json.length == 1 && is_json[0])
			JSON.add(new SetNew(key, value, true));
		else
			JSON.add(new SetNew(key, value));
	}
	
	public Object get(Object key)
	{
		for ( SetNew json:JSON )
		{
			if ( json.key == key || json.key.equals(key) )
			{ return json.value; }
		}
		return null;
	}
	
	public boolean remove(Object key)
	{
		for ( int i = 0 ; i < JSON.size();  i++ )
		{
			SetNew sn = JSON.get(i);
			if ( sn.key == key )
			{
				JSON.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public String convertToString(Object obj)
	{
		if ( obj != null && obj.getClass() == String.class )
		{
			String ob = (String)obj;
			if (!(ob.startsWith("{") && ob.endsWith("}"))) {
				String o = (String)obj;
				o = o.replace("\"", "\\\"");
				String obs = "\"" + o + "\"";
				obj = obs;
			}
		}
		else
			obj = obj + "";
		return (String)obj;
	}
	
	public Object convertList(Object collection)
	{
		if ( collection != null && (collection.getClass().isArray() || collection instanceof Collection<?>))
		{
			if ( collection.getClass().isArray() == false )
			{
				var list = (List<?>)collection;
				collection = list.toArray();
			}
			Object[] array = (Object[])collection;
			for ( int i = 0; i < array.length ; i++ )
			{
				var elm = array[i];
				if ( elm != null && elm.getClass() == String.class)
				{
					String elms = (String)elm;
					if ( !(elms.startsWith("{") && elms.endsWith("}")))
					{
						String el = (String)elm;
						el.replace("\"", "\\\"");
						String elmn = "\"" + el + "\"";
						array[i] = elmn;
					}
				}
			}
			collection = new ArrayList<>(Arrays.asList(array));
		}
		return collection;
	}
	
	public ArrayList<SetNew> returnJsonList(){ return this.JSON; }
	
	public String toString()
	{
		ArrayList<String> jarray = new ArrayList<String>();
		jarray.add("{");
		for ( var s:JSON )
		{
			Object key = convertList(s.key), value = convertList(s.value);
			jarray.add(convertToString(key) + ": ");
			if ( s.value_is_json )
				jarray.add((String)value);
			else
				jarray.add(convertToString(value));
			jarray.add(",");
		}
		jarray.remove(jarray.size() - 1);
		jarray.add("}");
		return String.join("", jarray);
	}
}
