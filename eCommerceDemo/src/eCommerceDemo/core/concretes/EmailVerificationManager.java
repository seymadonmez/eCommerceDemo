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
				+ " adresine bir doðrulama kodu gönderdik. Hesabýnýzý doðrulamak istiyor musunuz? (E/H)");
		chosenValue = scanner.next().charAt(0);

		if (chosenValue == 'e' || chosenValue == 'E') {
			Random random = new Random();
			int randomInteger, enteredNumber, count = 0;

			do {
				randomInteger = random.nextInt(999999 - 100000 + 1) + 100000;

				System.out.println(
						"Hesabýnýzý doðrulamak için mailinize gelen 6 haneli sayýyý giriniz:\n--> " + randomInteger);
				enteredNumber = scanner.nextInt();
				count++;
				if (count == 4) {
					System.out.println(
							"Çok sayýda hatalý denemenizden dolayý hesabýnýzý þu anda doðrulayamýyoruz.\nLütfen daha sonra tekrar deneyiniz..");
					scanner.close();
					return false;
				}
			} while (!(enteredNumber == randomInteger) && count < 4);
			System.out.println("Tebrikler hesabýnýz doðrulandý.");
			
			scanner.close();
			return true;

		}
		scanner.close();
		return false;
	}

}
