package InstructionProcessing;

import CPUAttributes.CU;

public class EffectiveAddress {
	CU cu=new CU();
public int calculateEA(int X,int I,int address){
	int EA=0;
	switch(I){
	case 0:
		switch(X){
		case 0:
			EA=address;
			break;
		case 1:
			EA=cu.getX1Value()+address;
			break;
		case 2:
			EA=cu.getX2Value()+address;
			break;
		case 3:
			EA=cu.getX3Value()+address;
			break;
		default:
			break;
		}
		break;
	case 1:
		switch(X){
		case 0:
			EA=cu.fetchFromMemory(address);
			break;
		case 1:
			EA=cu.fetchFromMemory(cu.getX1Value()+address);
			break;
		case 2:
			EA=cu.fetchFromMemory(cu.getX2Value()+address);
			break;
		case 3:
			EA=cu.fetchFromMemory(cu.getX3Value()+address);
			break;
		default:
			break;
		}
		break;
	default:
		break;
	}
	return EA;
}
}
