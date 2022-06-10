package model;

import java.io.File;
import java.util.ArrayList;

public class User {

	private String user;
	private String password;
	private ArrayList<Archive> archiveList;
	
	public User(String user, String password, ArrayList<Archive> archiveList) {
	this.user = user;
	this.password = password;
	this.archiveList = archiveList;
	}
	
	public Archive createNewArchive(String name, long size, String type) {
		return new Archive(name, size, type);
	}
	
	public void addNewArchive(Archive newArchive) {
		archiveList.add(newArchive);
	}
	
	public Archive findArchive(String name) {
		Archive archiveFinded = null;
		for (Archive archive : archiveList) {
			if (name.equalsIgnoreCase(archive.getName())) {
				archiveFinded = archive;
			}
		} return archiveFinded;
	}

	
	public void deleteArchive(Archive archive) {
				archiveList.remove(archive);
	}
	
	public Archive createNewArchiveFromPath(String path) {
		File file =  new File(path);
		String type = "";
		if (file.isDirectory()) {
			type = "C";
		} else {
			type = "A";
		}
		return new Archive(file.getName(), file.length(), type);
	}
	
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}

	public ArrayList<Archive> getArchiveList() {
		return archiveList;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "User [user=" + user + ", password=" + password + ", archives=" + archiveList + "]";
	}
}
