package Memory;

public class MemoryEntry<Integer, String> {
private int address;
private String value;
public MemoryEntry(int address, String value){
	this.address=address;
	this.value=value;
}
public int getAddress(){//getter function for address
	return this.address;
}
public String getValue(){//getter function for value
	return this.value;
}
public void setAddress(int newAddress){//setter function for address
	this.address=newAddress;
}
public void setValue(String newValue){//setter function for value
	this.value=newValue;
}
}
