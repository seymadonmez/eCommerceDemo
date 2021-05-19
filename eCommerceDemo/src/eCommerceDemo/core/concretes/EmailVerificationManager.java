package eCommerceDemo.core.concretes;

import java.util.Random;
import java.util.Scanner;

import eCommerceDemo.core.abstracts.VerificationService;
import eCommerceDemo.entities.concretes.User;

public class EmailVerificationManager implements VerificationService{

	
	@Override
	public boolean verificate(User user) {
		Scanner scanner = new Scanner(System.in);
		char chosenValue = 'h';
		System.out.println(user.getEmail()
				+ " adresine bir do�rulama kodu g�nderdik. Hesab�n�z� do�rulamak istiyor musunuz? (E/H)");
		chosenValue = scanner.next().charAt(0);

		if (chosenValue == 'e' || chosenValue == 'E') {
			Random random = new Random();
			int randomInteger, enteredNumber, count = 0;

			do {
				randomInteger = random.nextInt(999999 - 100000 + 1) + 100000;

				System.out.println(
						"Hesab�n�z� do�rulamak i�in mailinize gelen 6 haneli say�y� giriniz:\n--> " + randomInteger);
				enteredNumber = scanner.nextInt();
				count++;
				if (count == 4) {
					System.out.println(
							"�ok say�da hatal� denemenizden dolay� hesab�n�z� �u anda do�rulayam�yoruz.\nL�tfen daha sonra tekrar deneyiniz..");
					scanner.close();
					return false;
				}
			} while (!(enteredNumber == randomInteger) && count < 4);
			System.out.println("Tebrikler hesab�n�z do�ruland�.");
			
			scanner.close();
			return true;

		}
		scanner.close();
		return false;
	}

}
