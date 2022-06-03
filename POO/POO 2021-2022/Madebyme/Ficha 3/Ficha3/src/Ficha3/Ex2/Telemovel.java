package Ficha3.Ex2;

import java.util.*;


public class Telemovel {
    private final String brand;
    private final String model;
    private final int displayX;
    private final int displayY;

    private List<String> messages;
    private List<String> apps;

    private int storageTotal;
    private int storageApps;
    private int storageMsg;

    public Telemovel(){
        this.brand = "Apple";
        this.model = "iPhone 11";
        this.displayX = 828;
        this.displayY = 1792;

        this.messages = new ArrayList<>();
        this.apps = new ArrayList<>();

        this.storageTotal = 0x7f;
        this.storageApps = 0;
        this.storageMsg = 0;
    }
    public Telemovel(String brand, String model, int displayX, int displayY,
                     ArrayList<String> messages, ArrayList<String> apps, int storageTotal,
                     int storageApps, int storageMsg) {
        this.brand = brand;
        this.model = model;
        this.displayX = displayX;
        this.displayY = displayY;

        this.messages = new ArrayList<>(messages);
        this.apps = new ArrayList<>(apps);

        this.storageTotal = storageTotal;
        this.storageApps = storageApps;
        this.storageMsg = storageMsg;
    }

    public Telemovel(Telemovel t) {
        this.brand = t.getBrand();
        this.model = t.getModel();
        this.displayX = t.getDisplayX();
        this.displayY = t.displayY;

        this.messages = t.messages;
        this.apps = t.apps;

        this.storageTotal = t.getStorageTotal();
        this.storageApps =  t.getStorageApps();
        this.storageMsg = t.getStorageMsg();
    }

    public void instalaApp(String nome, int tamanho){
        this.apps.add(nome);
        this.storageApps = storageApps + tamanho;
    }
    public void recebeMsg(String msg, int tamanho){
        this.messages.add(msg);
        this.storageMsg = storageMsg+1;
    }
    public double tamMedioApps(){
        int numerodeapps = apps.size();
         return (double) this.storageApps/numerodeapps;
    }
    public String maiorMsg(){
        String biggestmessage = "";
        for (String mensagem : this.messages){
            if(mensagem.compareTo(biggestmessage)>0){
                biggestmessage = mensagem;
            }
        }
        return biggestmessage;
    }

    public void removeApp(String nome, int tamanho){
        Iterator<String> iter = apps.iterator();
        String str = "";
        while(iter.hasNext()){
            str = (String) iter.next();
            if(str.equals(nome)){
                iter.remove();
                storageApps = storageApps - tamanho;
            }
        }
    }
    public boolean existeEspaco(int numeroBytes){
        return numeroBytes <= storageTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telemovel)) return false;
        Telemovel telemovel = (Telemovel) o;
        return getDisplayX() == telemovel.getDisplayX() && getDisplayY() == telemovel.getDisplayY() && getStorageTotal() == telemovel.getStorageTotal() && getStorageApps() == telemovel.getStorageApps() && getStorageMsg() == telemovel.getStorageMsg() && Objects.equals(getBrand(), telemovel.getBrand()) && Objects.equals(getModel(), telemovel.getModel()) && Objects.equals(getMessages(), telemovel.getMessages()) && Objects.equals(getApps(), telemovel.getApps());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel(), getDisplayX(), getDisplayY(), getMessages(), getApps(), getStorageTotal(), getStorageApps(), getStorageMsg());
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getDisplayX() {
        return displayX;
    }

    public int getDisplayY() {
        return displayY;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getApps() {
        return apps;
    }

    public void setApps(List<String> apps) {
        this.apps = apps;
    }

    public int getStorageTotal() {
        return storageApps+storageMsg;
    }

    public void setStorageTotal(int storageTotal) {
        this.storageTotal = storageTotal;
    }

    public int getStorageApps() {
        return storageApps;
    }

    public void setStorageApps(int storageApps) {
        this.storageApps = storageApps;
    }

    public int getStorageMsg() {
        return storageMsg;
    }

    public void setStorageMsg(int storageMsg) {
        this.storageMsg = storageMsg;
    }

    @Override
    public String toString() {
        return "Telemovel{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", displayX=" + displayX +
                ", displayY=" + displayY +
                ", messages=" + messages +
                ", apps=" + apps +
                ", storageTotal=" + storageTotal +
                ", storageApps=" + storageApps +
                ", storageMsg=" + storageMsg +
                '}';
    }
}
