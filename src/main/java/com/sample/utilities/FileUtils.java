package com.sample.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import org.testng.Assert;

import com.sample.cucumber.MasterClass;

/**
 * @author Subodh Kumar
 *
 */


public class FileUtils extends MasterClass {
	
	/* ************************************************* 
	Function Name : fnCopyPaste 
	Description : This function is used to copy a file from source and paste in destination
	Input parameters : srcFilePath - Source file Path
	************************************************* */
	public static void copy(String srcFilePath,String desFilePath){
		File file=null;
		try{
			file=new File(srcFilePath);
			File destFile=new File(desFilePath);
			Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}catch(IOException e){
			log( "ERROR", "Exception", "fnCopyPaste - Exception: "+ e.toString());
			Assert.assertFalse(true);
		}
	}
	
	/* ************************************************* 
	Function Name : fnMove 
	Description : This function is used to move a file from source and to destination
	Input parameters : srcFilePath - Source file Path
					   desFilePath - Destination Path
	************************************************* */
	public static void move(String srcFilePath,String desFilePath){
		File file=null;
		try{  
			file=new File(srcFilePath);
			File destFile=new File(desFilePath);
			file.renameTo(destFile);
			file.delete();
	      }catch(Exception e){
	    	  log( "ERROR", "Exception", "fnMove - Exception: "+ e.toString());
	    	  Assert.assertFalse(true);
	      }
	}
	
	/* ************************************************* 
	Function Name : fnRename 
	Description : This function is used to rename a file
	Input parameters : srcFilePath - Source file Path
					   desFilePath - Destination Path
	************************************************* */
	public static void rename(String srcFilePath,String desFilePath){
		File file=null;
		try{  
			file=new File(srcFilePath);
			File destFile=new File(desFilePath);
			file.renameTo(destFile);
	      }catch(Exception e){
	    	  log( "ERROR","Exception", "fnRename - Exception: "+ e.toString());
	    	  Assert.assertFalse(true);
	      }
	}
	
	/* ************************************************* 
	Function Name : fnDeleteFilesByExtn 
	Description : This function is used to copy all the file with a specific extension
	Input parameters : dirFilePath - directory path
					   extn - extension
	************************************************* */
	public static void deleteFileByExtension(String dirFilePath,String extn){
		File file=null;
		 try {      
	         file = new File(dirFilePath);
	         for(File fileName:file.listFiles()) {
	        	 if(fileName.getName().endsWith(extn)){
	        		 fileName.delete();
	        	 }
	         }
	      } catch (Exception e) {
	    	  log( "ERROR", "Exception", "fnDeleteFilesByExtn - Exception: "+ e.toString());
	    	  Assert.assertFalse(true);
	      }
	}
	
	/* ************************************************* 
	Function Name : fnDeleteFile 
	Description : This function is used to delete a file
	Input parameters : srcFilePath - Source file path
	************************************************* */
	public static boolean delete(String srcFilePath){
		boolean fileDeleted=false;
		try{
				File files=new File(srcFilePath);
				if(files.exists()){
					fileDeleted=files.delete();
				}
				return fileDeleted;
		}catch (Exception e) {
			   log( "ERROR", "Exception", "fnDeleteFile - Exception: "+ e.toString());
	    	  Assert.assertFalse(true);
		}
		return fileDeleted;
	}
	
	/* ************************************************* 
	Function Name : fnRead 
	Description : This function is used to read from a file
	Input parameters : inputFilePath - Input file path
	************************************************* */
	public static void read(String inputFilePath){
		FileInputStream in = null;
		try{
	         in = new FileInputStream(inputFilePath);
	         int charIndex;
	         while ((charIndex = in.read()) != -1) {
	           System.out.print((char)charIndex);
	         }
	    }catch(FileNotFoundException e) {
	    	 log( "ERROR", "Exception", "fnRead - FileNotFoundException: "+ e.toString());
	    	Assert.assertFalse(true);
		}catch(IOException e){
			 log( "ERROR", "Exception", "fnRead - IOException: "+ e.toString());
	    	Assert.assertFalse(true);
		}finally{
			try{
					in.close();
			}catch(IOException e){
				 log( "ERROR", "Exception", "fnRead - Exception: "+ e.toString());
		    	Assert.assertFalse(true);
			}
	    }
	}
	
	/* ************************************************* 
	Function Name : fnCreateFile 
	Description : This function is used to create a file
	Input parameters : filePath - Input file path
	************************************************* */
	public static void create(String filePath){
		File file=null;
		file=new File(filePath);
		try{
			if(file.createNewFile()){
				System.out.println("created successfully");
			}else{
				System.out.println("Already exists");
			}
		}catch(IOException e){
			 log( "ERROR", "Exception",  "fnCreateFile - Exception: "+ e.toString());
	    	Assert.assertFalse(true);
		}
	}
	
	/* ************************************************* 
	Function Name : fnCreateDirs 
	Description : This function is used to create a directory
	Input parameters : direcPath - Directory path
	************************************************* */
	public static boolean createDirs(String direcPath){
		boolean created=false;
		File file=null;
		try{
			file=new File(direcPath);
			created=file.mkdirs();
			return created;
		}catch(Exception e){
			 log( "ERROR", "Exception", "fnCreateDirs - Exception: "+ e.toString());
	    	Assert.assertFalse(true);
		}
		return created;
	}
	
	/* ************************************************* 
	Function Name : fnWrite 
	Description : This function is used to write in a file
	Input parameters : inputFilePath - Input file path
					   outputFilePath - Output file path
	************************************************* */
	public static void write(String inputFilePath,String outputFilePath){
		FileInputStream in = null;
		FileOutputStream out = null;
	     try{
	         in = new FileInputStream(inputFilePath);
	         out = new FileOutputStream(outputFilePath,true);
	         int c;
	         while ((c = in.read()) != -1) {
	            out.write(c);
	         }
	      }catch(FileNotFoundException e){
	    	   log( "ERROR", "Exception", "fnWrite - FileNotFoundException: "+ e.toString());
			  Assert.assertFalse(true);
	      }catch(IOException e){
	    	   log( "ERROR", "Exception", "fnWrite - IOException: "+ e.toString());
			  Assert.assertFalse(true);
	      }finally{
			 try{
				in.close();
				out.close();
			 }catch(IOException e){
				  log( "ERROR", "Exception", "fnWrite - Exception: "+ e.toString());
			     Assert.assertFalse(true);
			}
	    }
	}
	
	/* ************************************************* 
	Function Name : fnAppend 
	Description : This function is used to append value in a file
	Input parameters : inputFilePath - Input file path
					   text - text to be appended
	************************************************* */
	public static void append(String inputFilePath,String text){
		FileInputStream in = null;
		FileOutputStream out = null;
		try{
	         in = new FileInputStream(inputFilePath);
	         out = new FileOutputStream(inputFilePath,true);
	         out.write(text.getBytes());
	         in.close();
	         out.close();
		}catch(FileNotFoundException e){
			 log( "ERROR", "Exception", "fnAppend - FileNotFoundException: "+ e.toString());
			e.printStackTrace();
		    Assert.assertFalse(true);
		}catch(IOException e) {
			 log( "ERROR", "Exception", "fnAppend - IOException: "+ e.toString());
		    Assert.assertFalse(true);
		}finally 
		{
			try{
				in.close();
				out.close();
			}catch(IOException e){
				 log( "ERROR", "Exception", "fnAppend - Exception: "+ e.toString());
			    Assert.assertFalse(true);
			}
	    }
	}
	
	/* ************************************************* 
	Function Name : fnFileFolderExists 
	Description : This function is to verify if a file folder exists
	Input parameters : filePath - File path
	Return type: Boolean Yes if exist and No if it doesnot
	************************************************* */	
	public static boolean fileFolderExists(String filePath){
			boolean exists=false;
			try{
				String[] dirArr=filePath.split("\\\\");
				String absDirPath = "";
				for(String dirName: dirArr){
					absDirPath=absDirPath+dirName+"\\";
					File files=new File(absDirPath);
					if(files.exists()){
						exists=true;
					}else{
						exists=false;
						System.out.println("Following file or folder doesn't exists in followig path:"+filePath);
						System.exit(0);
						break;
					}
				}
			}catch(Exception e){
				 log( "ERROR", "Exception", "fnFileFolderExists - Exception: "+ e.toString());
			    Assert.assertFalse(true);
			}
			return exists;
		}
	/* ************************************************* 
	Function Name : fnReadProperty 
	Description : This function is to read properties
	Input parameters : filePath - File path
	Return type: Properties
	************************************************* */	
	public static Properties readProperty(String file){
		Properties properties = null;
		try{
			FileInputStream fileInput = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInput);
		}catch (Exception e){
			 log( "ERROR", "Exception", "fnReadProperty - Exception: "+ e.toString());
		    Assert.assertFalse(true);
		}
		return properties;
	}
	
	/* ************************************************* 
	Function Name : PropertyFileInitialization 
	Description : This function is used to initiaze a property file
	Input parameters : StrPathOfFile - Path of the property file
	ReturnType : Properties
	************************************************* */
	public static Properties PropertyFileInitialization(String StrPathOfFile) {
		Properties properties = null ;
		try {
			File file = new File(StrPathOfFile);
			FileInputStream fileInput;
			fileInput = new FileInputStream(file);
			properties= new Properties();
			properties.load(fileInput);
			fileInput.close();
		} catch (FileNotFoundException e1) {
			log("ERROR", "Exception", "PropertyFileInitialization - FileNotFoundException: "+ e1.toString());
			Assert.assertFalse(true);
		} catch (IOException e2) {
			log("ERROR", "Exception", "PropertyFileInitialization - IOException: "+ e2.toString());
			Assert.assertFalse(true);
		} catch (Exception e3) {
			log("ERROR", "Exception", "PropertyFileInitialization - Exception: "+ e3.toString());
			Assert.assertFalse(true);
		}
		return properties;
	}

	
}
