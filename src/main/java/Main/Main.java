package Main;

import Controller.Control;
import Model.Ecuatii;
import View.GUInterface;

public class Main {
    public static void main(String[] args) {
        GUInterface gui = new GUInterface();
        Ecuatii ecuatii = new Ecuatii();

        Control control = new Control(gui, ecuatii);
    }
}

