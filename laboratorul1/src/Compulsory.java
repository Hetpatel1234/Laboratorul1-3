import java.awt.desktop.SystemSleepEvent;

class Req2 {
    private String[] languages;
    private int result;

    public Req2() {
        languages = new String[] {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        result = (int)(Math.random() * 1_000_000);
    }

    public int getResult(){
        return this.result;
    }

    public void setResult(int result){
        this.result = result;
    }

    public String[] getLanguages(){
        return this.languages;
    }

    public String getLanguage(int index){
        return this.languages[index];
    }

    public static int sum(int n) {
        int result = 0;
        while(n > 0){
            result += n % 10;
            n/=10;
        }
        return result;
    }

    public void applyCalculations() {
        this.result *= 3;
        this.result += Integer.parseInt("10101", 2);

        String hexNumber = "FF";
        this.result += Integer.parseInt(hexNumber, 16);

        this.result *= 6;
    }
}

public class Compulsory {
    public static void req1() {
        System.out.println("Hello world");
    }

    public static void req2() {
        Req2 runtime = new Req2();
        runtime.applyCalculations();
        while(runtime.getResult() >= 10 ){
            runtime.setResult(Req2.sum(runtime.getResult()));
        }

        System.out.println("Willy-nilly, this semester I will learn " + runtime.getLanguages()[runtime.getResult()]);
    }
}
