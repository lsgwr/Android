package lee;

import org.apache.commons.logging.Log;
import org.apache.commons.dbcp2.BasicDataSource;
/**
 * Description:<br>
 * ��վ: <a href="http://www.crazyit.org">���Java����</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com<br>
 * @version 1.0
 */
public class HelloWorld
{
	public static void main(String[] args)
	{
		Log log;
		BasicDataSource ds = new BasicDataSource();
		System.out.println("����Դ��" + ds);
	}
}
