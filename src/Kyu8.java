public class Kyu8 {
    public static void main(String[] args) {
        String[] name = {"John", "Smith"};
        System.out.println(sayHello(name, "Phoenix", "Arizona"));
    }
    public static String sayHello(String [] name, String city, String state){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello, ");
        for (String s : name) {
            stringBuilder.append(s).append(" ");
        }
        return stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length())
                .append("! Welcome to ")
                .append(city)
                .append(", ")
                .append(state)
                .append("!")
                .toString();
    }
}