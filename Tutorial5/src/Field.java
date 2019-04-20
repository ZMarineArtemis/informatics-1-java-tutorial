
public class Field {
private int value;
private final boolean initial;

public Field() {
	value = 0;
	initial = false;
}

public Field(int value, boolean initial) {
	setValue(value);
	this.initial = initial;
}

public int getValue() {
	return value;
}

public void setValue(int args) {
	value = args;
}

public boolean getInitial() {
	return initial;
}

public String toString() {
	if(initial == true) {
		return value + " ";
	}else {
		return value + " ";
	}
}
}
