package com.rev.strBuilderVsBuffer;

public class BufferT implements Runnable {
	static StringBuffer strBuf = new StringBuffer();
	char startChar;
	
	public BufferT(char startChar) {
		this.startChar = startChar;
	}
	
	@Override
	public void run() {
		//synchronized (strBuf) { 
			for (int i = 0; i < 5; i++) {
				BufferT.strBuf.append((char)(startChar + i));
				System.out.println(strBuf);
			}
		//}
	}

}
