
import java.util.Scanner;

public class Termostat {
    private double aktualnaTemperatura = 20.0; 
    double ustawionaTemperatura;
    private boolean ogrzewanieWlaczone = false;
    private boolean chlodzenieWlaczone = false;




    public void wlaczOgrzewanie() {
        ogrzewanieWlaczone = true;
        chlodzenieWlaczone = false;
        System.out.println("Ogrzewanie włączone.");
    }

 
    public void wlaczChlodzenie() {
        chlodzenieWlaczone = true;
        ogrzewanieWlaczone = false;
        System.out.println("Chłodzenie włączone.");
    }

 
    public void wylaczOgrzewanie() {
        ogrzewanieWlaczone = false;
        System.out.println("Ogrzewanie wyłączone.");
    }

    public void wylaczChlodzenie() {
        chlodzenieWlaczone = false;
        System.out.println("Chłodzenie wyłączone.");
    }

    public double sprawdzTemperature(double ustawionaTemperatura) {

        System.out.println("Aktualna temperatura: " + aktualnaTemperatura + "°C");
        System.out.println("Podaj temperaturę: ");
        System.out.println("Ustawiona temperatura: " + ustawionaTemperatura + "°C");


        if (aktualnaTemperatura < ustawionaTemperatura && !ogrzewanieWlaczone) {
            wlaczOgrzewanie();
        } else if (aktualnaTemperatura > ustawionaTemperatura && !chlodzenieWlaczone) {
            wlaczChlodzenie();
        } else if (aktualnaTemperatura == ustawionaTemperatura) {
            wylaczOgrzewanie();
            wylaczChlodzenie();
            System.out.println("Temperatura osiągnięta.");
        }
        return aktualnaTemperatura;
    }

    public void symulujZmianeTemperatury() {
        if (ogrzewanieWlaczone) {
            aktualnaTemperatura += 0.5;
        } else if (chlodzenieWlaczone) {
            aktualnaTemperatura -= 0.5;
        }
    }
    public static void main(String[] args) {
        Termostat termostat = new Termostat();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ustaw temperaturę: ");
    double ustawTemp = scanner.nextDouble();
        for (int i = 0; i == i; i++) {
            termostat.symulujZmianeTemperatury();
            termostat.sprawdzTemperature(ustawTemp);
            System.out.println("----------------------");
            if(termostat.sprawdzTemperature(ustawTemp) == ustawTemp){
                break;
            }
            try {
                Thread.sleep(1000); // Pauza 1 sekunda
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}