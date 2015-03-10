import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflection1 {
	
	public int a = 1;
	private boolean flag = true;

	
	public static void main(String[] args) {
		

		try {
			File file = new File("file.txt");
			if (!file.exists()) {
				return;
			}
			
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
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
				int mod = f.getModifiers();
				if(Modifier.isFinal(mod)) {
					System.out.println("Модификатор final");
				}
				
				try {
					f.setAccessible(true);
					System.out.println("Значение " + f.get(raf) + "\n");
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
			}
			
			//			change private parametrs
			try {
				
				Field fieldC = raf.getClass().getDeclaredField("rw");
				fieldC.setAccessible(true);
				System.out.println("before changing "+fieldC.getBoolean(raf));
				fieldC.setBoolean(raf, false);
				System.out.println("after changing "+fieldC.getBoolean(raf));
				

				//				Constructor researching
				Class c = raf.getClass();
				Constructor[] constructors = c.getConstructors();
				for(Constructor curConstr : constructors) {
					Class[] paramTypes = curConstr.getParameterTypes();
					System.out.println("Constructor name: "+curConstr.getName());
					System.out.println("Parametrs: ");
					for (Class paramType: paramTypes) {
						System.out.print(paramType.getName() + " ");
					}
					System.out.println("\n");
				}
				

				//				Show private konstructors and their metods, parametrs
				Method[] methods = c.getDeclaredMethods();
				for(Method method: methods) {
					System.out.println("Method name: " + method.getName());
					System.out.println("Return type: " + method.getReturnType().getName());
					
					Class[] paramTypes = method.getParameterTypes();
					if(paramTypes.length>0) {
						System.out.print("Params list:");
						for(Class paramType: paramTypes) {
							System.out.print(" " + paramType.getName());
						}
					}
					System.out.println("");
				}
				
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