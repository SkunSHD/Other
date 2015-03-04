import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Reflection1 {
	
	public int a = 1;
	private boolean flag = true;
	
	
	public static void main(String[] args) {
		 
		try {
			RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
			
			Class<?> i = raf.getClass();
			System.out.println(i.getName());

			//			get modifers
			System.out.println("Looking for modifires...");
			
			int mods = i.getModifiers();
			if(Modifier.isAbstract(mods)) { 
				System.out.println("Class has Abstract modifers");
			}
			if(Modifier.isPublic(mods)) {
				System.out.println("Class has Public modifers");
			}
			
			if(Modifier.isPublic(mods)) {
				System.out.println("Class has Final modifers");
			}

			//			get superclass name
			System.out.println("\nLooking superclass name");
			Class<?> sc = i.getSuperclass();
			System.out.println(sc.getName());

			//			show realized interfaces
			System.out.println("\nLooking Interface names");
			Class<?> ifc = RandomAccessFile.class;
			Class<?>[] arrayIfc = ifc.getInterfaces();
			for (Class<?> cInterface: arrayIfc) {
				System.out.println(cInterface.getName());
			}
			
			//			show public fields
			System.out.println("\nShow all public fields");
			Reflection1 myObj = new Reflection1();
			Class<?> cl = myObj.getClass();
			
			Field[] publicFields = cl.getFields();
			for(Field f : publicFields) {
				Class<?> fieldType = f.getType();
				System.out.println("Имя " + f.getName());
				System.out.println("Тип " + fieldType.getName());
			}
			
			//			show private fields and parametrs
			
			System.out.println("\nShow all private fields");
			Field[] privateFields = i.getDeclaredFields();
			
			for(Field f : privateFields) {
				Class<?> fieldType = f.getType();
				System.out.println("Имя " + f.getName());
				System.out.println("Тип " + fieldType.getName());
				try {
					f.setAccessible(true);
					System.out.println("Значение " + f.get(raf) + "\n");
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
			}
			
			//			change private parametrs
			try {
				RandomAccessFile raf2 = new RandomAccessFile("file.txt", "rw");
				Field fieldC = raf2.getClass().getDeclaredField("O_DSYNC");
				fieldC.setAccessible(true);
				System.out.println("before changing "+fieldC.getInt(raf2));
				fieldC.setInt(raf2, 3);
				System.out.println("after changing "+fieldC.getInt(raf2));
				
//				Field current = cl.getDeclaredField("flag");
//				cl.setAccessible(true);
////				
//				System.out.println("before changing "+current.getInt(myObj));
//				current.setBoolean(raf, false);
//				System.out.println("after changing "+current.getInt(myObj));
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			raf.close();
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}