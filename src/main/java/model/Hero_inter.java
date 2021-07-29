package model;

public interface Hero_inter
{
	public int GetIntProperties(
			String aimProperties
			);
	
	public String GetStringProperties(
			String aimProperties
			);
	
	boolean SetStringProperties(
			String aimProperties,
			String changeValues
			);
	
	boolean SetIntProperties(
			String aimProperties,
			int changeValues
			);
	
}
