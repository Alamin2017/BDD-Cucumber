public class Split {

    public static void main(String[] args) {
        String date = "12/8/2012";
        String[] dateParts = date.split("/");
        String day = dateParts[0];
        String month = dateParts[1];
        String year=dateParts[2];
        System.out.println(day+" "+month+" "+year);
    }
}
