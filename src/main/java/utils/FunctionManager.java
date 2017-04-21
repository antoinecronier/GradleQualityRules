package utils;

public class FunctionManager {

	public int sum(int a, int b){
		return a+b;
	}

	public int f1(int a) throws Exception{
		if (a >= 0) {
			return (8*a)+12;
		}else{
			throw new Exception("Argument cannot be less than 0.");
		}
	}

	public int f2(int a) throws Exception{
		return f1(a)*f1(a/a)+2;
	}
}
