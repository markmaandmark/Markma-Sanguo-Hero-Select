package model;
import java.util.*;  
/*
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;     
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
*/
import java.io.*;
public class Sanguo
{
	//private static final Logger logger = LoggerFactory.getLogger(Sanguo.class);
	public static void main(String[] args)
	{
		/*
        // 获取classpath路径
        String s = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println("classpath : " + s );
 
        System.out.println("----> logback start");
        logger.trace("--> Hello trace.");
        logger.debug("--> Hello debug.");
        logger.info("--> Hello info.");
        logger.warn("--> Goodbye warn.");
        logger.error("--> Goodbye error.");
        System.out.println("----> logback end");
 
        //打印 Logback 内部状态
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
		*/

		
		final String VERSION = "0.0.1",
					 FILEPLACE = "D:\\eclipse-workspace\\model\\src\\main\\resources\\aimFile";
		
		Hero[] heroFromFileMatrix = ReadFileToHeroMatrix(FILEPLACE);
		
		switch(args.length)
		{
		case 0:
		{
			System.out.println("三国人物查找系统");
			System.out.println("命令后缀名：");
			PrintHelp();
			return;
		}
		case 1:
		{
			if(args[0].equals("-v"))
			{
				System.out.println("version:"+VERSION);
				return;
			}
			else
			{
				System.out.println("后缀名输入错误");
				PrintHelp();
				return;
			}
			
		}
		case 3:
		{
			if(args[0].equals("-s"))
			{
				HeroSearch(args[1],args[2],heroFromFileMatrix);
				return;
			}
			else
			{
				System.out.println("后缀名输入错误");
				PrintHelp();
				return;
			}
		}
		default:
		{
			System.out.println("后缀名数目输入错误");
			PrintHelp();
			return;
		}
			
		}
		

	}
	
	public static Hero[] ReadFileToHeroMatrix(String fileName)
	{
		Hero[] heroMatrix = new Hero[1000];
		File file = new File(fileName);
		BufferedReader reader = null;
        try 
        {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 0;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) 
            {
                // 显示行号
            	Scanner scan = new Scanner(tempString);
            	heroMatrix[line] = new Hero();
            	heroMatrix[line].SetStringProperties("name", scan.next());
            	heroMatrix[line].SetStringProperties("weaponName", scan.next());
            	heroMatrix[line].SetStringProperties("birthday", scan.next());
            	heroMatrix[line].SetStringProperties("deathday", scan.next());
            	heroMatrix[line].SetStringProperties("introduction", scan.next());
            	heroMatrix[line].SetIntProperties("ID", scan.nextInt());
            	heroMatrix[line].SetIntProperties("bloodValue", scan.nextInt());
            	heroMatrix[line].SetIntProperties("attackValue", scan.nextInt());
            	line++;
            	scan.close();
            }
            
            reader.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (reader != null) 
            {
                try 
                {
                    reader.close();
                } 
                catch (IOException e1) 
                {
                	
                }
            }
        }
		return heroMatrix;
	}

	public static void PrintHelp()
	{
		System.out.println("-s name properties 搜索模式");
		System.out.println("多个name和properties用,连接 查询全部为-a");
		System.out.println("properties名称:姓名name,武器weaponName,生日birthday,卒日deathday,"
				+ "介绍introduction,ID ID,血量bloodValue,攻击力attackValue");
		System.out.println("例： -s 刘备,曹操 ID,bloodValue");
		System.out.println("例： -s -a ID");
		System.out.println("-v 显示版本");
		return;
	}
	
	public static void HeroSearch(String undividedName,String undividedProperties,Hero[] heroFromFileMatrix)
	{
		String[] heroNeedToSearchedNames = DivideObjects(undividedName);
		String[] heroNeedToSearchedProperties = DivideObjects(undividedProperties);
		for(String pro:heroNeedToSearchedProperties)
		{
			System.out.print(pro+"    ");
		}
		System.out.print("\n");
		for(String name:heroNeedToSearchedNames)
		{
			NameSearchHeroProperties(name,heroFromFileMatrix,heroNeedToSearchedProperties);
		}
	}
	
	public static String[] DivideObjects(String undividedName)
	{
		String[] heroObjects = new String[1000];
		heroObjects = undividedName.split(",",8);
		return heroObjects;
	}
	
	public static void NameSearchHeroProperties(String Name,Hero[] heroFromFileMatrix,String[] heroNeedToSearchedProperties)
	{
		final String COLORCODE = "31";
		boolean hasSearched = false;
		for(int i = 0;i<heroFromFileMatrix.length;i++)
		{
			Hero hero = new Hero();
			hero = heroFromFileMatrix[i];
			if(hero == null) break;
			if(Name.equals( hero.GetStringProperties("name"))  || Name.equals("-a"))
			{
				hasSearched = true;
				for(String pro:heroNeedToSearchedProperties)
				{
					if(pro.equals("name")  || pro.equals("-a"))
					{
						String printString = hero.GetStringProperties("name");
						System.out.print(printString+" ");
					}
					if(pro.equals("weaponName") || pro.equals("-a"))
					{
						String printString = hero.GetStringProperties("weaponName");
						System.out.print(printString+" ");
					}
					if(pro.equals("birthday") || pro.equals("-a"))
					{
						String printString = hero.GetStringProperties("birthday");
						System.out.print(printString+" ");
					}
					if(pro.equals("deathday") || pro.equals("-a"))
					{
						String printString = hero.GetStringProperties("deathday");
						System.out.print(printString+" ");
					}
					if(pro.equals("introduction") || pro.equals("-a"))
					{
						String printString = hero.GetStringProperties("introduction");
						System.out.print(printString+" ");
					}
					if(pro.equals("ID") || pro.equals("-a"))
					{
						int printInt = hero.GetIntProperties("ID");
						System.out.print(printInt+" ");
					}
					if(pro.equals("bloodValue") || pro.equals("-a"))
					{
						int printInt = hero.GetIntProperties("bloodValue");
						System.out.print("\033[" + COLORCODE + "m" +printInt+" "+"\033[m");
					}
					if(pro.equals("attackValue") || pro.equals("-a"))
					{
						int printInt = hero.GetIntProperties("attackValue");
						System.out.print(printInt+" ");
					}
					
				}
				System.out.print("\n");
			}
			
		}
		if(!hasSearched)
		{
			System.out.print("未找到！");
		}
	}
	
	

}

