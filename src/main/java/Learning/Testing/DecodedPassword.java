package Learning.Testing;

import java.util.Base64;

public class DecodedPassword {

	public static void main(String[] args)
	{
		String password="admin123";
		byte[] encrypted=Base64.getEncoder().encode(password.getBytes());
		System.out.println(new String(encrypted));


	}

}
