public class Main {

    public static void main(String[] args) {
		System.out.println("Start to make MaximumEffort for Turkey market");
		Smartphone phone1 = new MaximumEffort(new Turkey());
		phone1.makePhone();
		System.out.println("End MaximumEffort for Turkey market\n");

		System.out.println("Start to make MaximumEffort for EU market");
		Smartphone phone2 = new MaximumEffort(new EU());
		phone2.makePhone();
		System.out.println("End MaximumEffort for EU market\n");

		System.out.println("Start to make MaximumEffort for Global market");
		Smartphone phone3 = new MaximumEffort(new Global());
		phone3.makePhone();
		System.out.println("End MaximumEffort for Global market\n");

		System.out.println("Start to make IflasDeluxe for Turkey market");
		Smartphone phone4 = new IflasDeluxe(new Turkey());
		phone4.makePhone();
		System.out.println("End IflasDeluxe for Turkey market\n");

		System.out.println("Start to make IflasDeluxe for EU market");
		Smartphone phone5 = new IflasDeluxe(new EU());
		phone5.makePhone();
		System.out.println("End IflasDeluxe for EU market\n");

		System.out.println("Start to make IflasDeluxe for Global market");
		Smartphone phone6 = new IflasDeluxe(new Global());
		phone6.makePhone();
		System.out.println("End IflasDeluxe for Global market\n");

		System.out.println("Start I-I-Aman-Iflas for Turkey market");
		Smartphone phone7 = new IIAmanIflas(new Turkey());
		phone7.makePhone();
		System.out.println("End I-I-Aman-Iflas for Turkey market\n");

		System.out.println("Start I-I-Aman-Iflas for EU market");
		Smartphone phone8 = new IIAmanIflas(new EU());
		phone8.makePhone();
		System.out.println("End I-I-Aman-Iflas for EU market\n");

		System.out.println("Start I-I-Aman-Iflas for Global market");
		Smartphone phone9 = new IIAmanIflas(new Global());
		phone9.makePhone();
		System.out.println("End I-I-Aman-Iflas for Global market\n");
    }
}
