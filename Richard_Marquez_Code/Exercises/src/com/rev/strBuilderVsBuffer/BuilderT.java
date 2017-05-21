package com.rev.strBuilderVsBuffer;

public class BuilderT implements Runnable {

	static StringBuilder strBuilder = new StringBuilder();
	char startChar;
	
	public BuilderT(char startChar) {
		this.startChar = startChar;
	}
	
	@Override
	public void run() {
		//synchronized (strBuilder) {
			for (int i = 0; i < 5; i++) {
				BuilderT.strBuilder.append((char)(startChar + i));
				System.out.println(BuilderT.strBuilder);
			}
		//}
	}

}
