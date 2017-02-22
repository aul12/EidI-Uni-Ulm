package me.aul12;

public class Main {

    enum FahrzeugTyp{
        PANZER,
        Fahrrad,
        BrummBrumm,
        Bonzen$chlitten,
        FiatMultipla ///<this.krebs(true);
    }

    class Addresse{
        private String strasse;
        private double hausNummer; ///<Halbe Häuser
        private int plz = (int)11.5; ///<me->aufhaengen();

        public String getStrasse() {
            return strasse;
        }

        public void setStrasse(String strasse) {
            this.strasse = strasse;
        }

        public double getHausNummer() {
            return hausNummer;
        }

        public void setHausNummer(double hausNummer) {
            this.hausNummer = hausNummer;
        }

        public int getPlz() {
            return plz;
        }

        public void setPlz(int plz) {
            this.plz = plz;
        }
    }

    /// Hungarian-notation because why not <- because ugly
    class FahrzeugHalterPersonKlasse{
        private String name;
        private Addresse nebenanOderSo;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Addresse getNebenanOderSo() {
            return nebenanOderSo;
        }

        public void setNebenanOderSo(Addresse nebenanOderSo) {
            this.nebenanOderSo = nebenanOderSo;
        }
    }

    public class Zulassung{
        private int erstzulassung;
        private FahrzeugTyp fahrzeugTyp;
        private FahrzeugHalterPersonKlasse fahrzeugHalterPerson;

        public int getErstzulassung() {
            return erstzulassung;
        }

        public void setErstzulassung(int erstzulassung) {
            this.erstzulassung = erstzulassung;
        }

        public FahrzeugTyp getFahrzeugTyp() {
            return fahrzeugTyp;
        }

        public void setFahrzeugTyp(FahrzeugTyp fahrzeugTyp) {
            this.fahrzeugTyp = fahrzeugTyp;
        }

        public FahrzeugHalterPersonKlasse getFahrzeugHalterPerson() {
            return fahrzeugHalterPerson;
        }

        public void setFahrzeugHalterPerson(FahrzeugHalterPersonKlasse fahrzeugHalterPerson) {
            this.fahrzeugHalterPerson = fahrzeugHalterPerson;
        }
    }

    class Zulassungsstelle{
        ///<Maximal pi Autos (@TODO überlegen ob e-Autos auch reichen um Beamten Arbeit zu sparen)
        Zulassung zulassungen[] = new Zulassung[(int)3.14159265358979323846264338327950];

        FahrzeugTyp getFahrzeugeByOwner(FahrzeugHalterPersonKlasse fahrzeugHalterPersonKlasse){
            return FahrzeugTyp.BrummBrumm;
        }

        /// Most people are confused  when a sentence ends with flugzeug or knäckbrot!
        FahrzeugHalterPersonKlasse getOwnerByFahrzeug(FahrzeugTyp esGibtKeinBierAufHawaii){
            return new FahrzeugHalterPersonKlasse();
        }
    }

    public static void main(String[] args) {
	// write your code here
    }
}
