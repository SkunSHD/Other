package lab6;

import java.io.*;
import java.util.Arrays;

public class BitAfterBit {

	//метод принмает 3 байт масива, src - исходнеый масив, primWord - слово которое нужно изменить (Hello)
	//secondWord - слово на которое нужно изменить primWord (1234)
	//метод возвращает новый массив с измененным словом

	public static byte[] getChangedByteArray(byte[] src, byte[] primWord, byte[] secondWord) throws IOException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int i=0;
		while (i < src.length){
			if (Arrays.equals(Arrays.copyOfRange(src, i, primWord.length+i), primWord)) {
				bos.write(secondWord);
				i+=primWord.length;
			} else {
				bos.write(src[i]);
				i++;
			}
		}
		return bos.toByteArray();
	}

	public static void main(String[] args) throws IOException{

		String path = "C:\\1\\1.txt";
		String primWord = "Hello";
		String secondWord = "1234";
		byte[] primWordByte = primWord.getBytes();
		byte[] secondWordByte = secondWord.getBytes();

		FileInputStream fin=null;
		FileOutputStream fot =null;

		try{
			fin = new FileInputStream(path);
		}
		catch(FileNotFoundException ex){
			System.out.println(ex);
		}

		int r;
		byte[] buf = new byte[fin.available()];
		try{
			do{
				r = fin.read(buf);
			} while(r>0);
		} finally{
			fin.close();
		}

		System.out.println(new String(buf)+"\n");

		try{
			fot = new FileOutputStream(path);
		}
		catch(FileNotFoundException ex){
			System.out.println(ex);
			}
		try{
			fot.write(getChangedByteArray(buf, primWordByte, secondWordByte));
			System.out.println(new String(getChangedByteArray(buf, primWordByte, secondWordByte)));
			}
		finally{
				fot.close();
		}

	}
}
