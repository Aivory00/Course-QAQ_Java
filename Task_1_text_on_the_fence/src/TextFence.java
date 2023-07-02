import java.util.Scanner;

public class TextFence {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int fenceLength, letterLength, spaceLength, messageLength;

        letterLength = 62; // длина трех букв
        spaceLength = 12; // длина одного пробела
        messageLength = letterLength * 5 + spaceLength * 2; // длина признания

        System.out.print("Длина забора: ");

        fenceLength = scanner.nextInt();

        if (fenceLength >= messageLength)
            {
            System.out.println("На заборе хватит места для признания");
            }
        else
            {
            System.out.println("На заборе не хватит места для признания");
            }
    }
}