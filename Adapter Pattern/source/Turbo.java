public class Turbo implements TurboPayment{
    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse,
                          String installmentsButInTurbo) {

        System.out.println(turboAmount + " amount of money transferred from " + turboCardNo + " to " +
                destinationTurboOfCourse + " with " + installmentsButInTurbo + " installments");
        return 0;
    }
}
