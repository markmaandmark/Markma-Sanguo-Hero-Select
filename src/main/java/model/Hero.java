package model;

class Hero implements Hero_inter
{
	private int ID = 0,
		bloodValue = 0,
		attackValue = 0;
	private String name = "",
		   weaponName = "",
		   birthday = "",
		   deathday = "",
		   introduction = "";
	
	public Hero()
	{
		
	}
	//get
	public String GetStringProperties(
			String aimProperties
			)
	{
		if(aimProperties.equals("name")) return this.name;
		else if(aimProperties.equals("weaponName")) return this.weaponName;
		else if(aimProperties.equals("birthday")) return this.birthday;
		else if(aimProperties.equals("deathday")) return this.deathday;
		else if(aimProperties.equals("introduction")) return this.introduction;
		else
		{
			System.out.println("属性未获得！");
			return "";
		}
		
	}
	public int GetIntProperties(
			String aimProperties
			)
	{
		if(aimProperties.equals("ID")) return this.ID;
		else if(aimProperties.equals("bloodValue")) return this.bloodValue;
		else if(aimProperties.equals("attackValue")) return this.attackValue;
		else
		{
			System.out.println("属性未获得！");
			return 0;
		}
	}
	//set
	public boolean SetStringProperties(
			String aimProperties,
			String changeValues
			)
	{
		if(aimProperties.equals("name"))
		{
			this.name = changeValues;
			return true;
		}
		
		else if(aimProperties.equals("weaponName"))
		{
			this.weaponName = changeValues;
			return true;
		}
		else if(aimProperties.equals("birthday"))
		{
			this.birthday = changeValues;
			return true;
		}
		else if(aimProperties.equals("deathday"))
		{
			this.deathday = changeValues;
			return true;
		}
		else if(aimProperties.equals("introduction")) 
		{
			this.introduction = changeValues;
			return true;
		}
		else
		{
			System.out.println("属性未获得！");
			return false;
		}
	}
	public 	boolean SetIntProperties(
			String aimProperties,
			int changeValues
			)
	{
		if(aimProperties == "ID")
		{
			this.ID = changeValues;
			return true;
		}
		
		else if(aimProperties == "bloodValue") 
		{
			this.bloodValue = changeValues;
			return true;
		}
		else if(aimProperties == "attackValue") 
		{
			this.attackValue = changeValues;
			return true;
		}
		else
		{
			System.out.println("属性未修改！");
			return false;
		}
	}

}
