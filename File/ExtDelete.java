import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class ExtDelete {

	public static void main(String[] args) {
		// Is there parametr
		if(args.length==0) {
			System.out.println("You don't entered extension");
			return;
		}

		// Is there directory
		File dir = new File(args[0]);
		if(!dir.isDirectory()) {
			System.out.println("Entered directory doesn't exist");
			return;
		}

		// Archive of all files in directory
		File[] fList = dir.listFiles(args.length < 2 ? null : new MyExtensionFilter(args[1]));
		int fTotal = fList.length;
		if(fTotal == 0) {
			System.out.println("Dirrectory " + args[0] + " is empty");
			return;
		} else {
			// Showing what I found:
			System.out.println("Found in Search:");
			for(int i=0; i<fTotal; i++) {
				System.out.println(fList[i].getPath());
			}
		}


		// Request for shure to delete files
		System.out.println("You are want to delete "+ fTotal + " files from " + args[0] +" directory. Are you shure? Enter Y/N");
		try {
			byte[] r = new byte[1];
			r[0] = (byte) System.in.read();
			char resp = (new String(r).charAt(0));

			if(resp == 'Y' || resp == 'y') {
				for(int i=0; i<fTotal; i++) {
					fList[i].delete();
				}
				System.out.println("Deleted " + fTotal + " files.");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	* Inner class for looking files
	* @param ext- Searching file(s) extention
    */
	public static class MyExtensionFilter implements FileFilter {
		private String ext;

		MyExtensionFilter(String ext) {
			this.ext = ext;
		}

		public boolean accept(File pathname) {
			String extension = getExtension(pathname);

			for (String str : ext.split(",")) {
				if(extension.toLowerCase().equals(str)) {
					return true;
				}
			}
			return false;
		}
		// Get extention of current file
		private String getExtension(File pathname) {
			String fileName = pathname.getPath();
			int i = fileName.lastIndexOf('.');
			if(i>0 && i<fileName.length()-1) {
				return fileName.substring(i+1).toLowerCase();
			}
			return "";
		}
	}
}