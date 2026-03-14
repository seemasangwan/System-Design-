//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
     CloudFactory cloudFactory=CloudProvider.getCloudFactory("gcp");
     VMProvider vmProvider=cloudFactory.getVMProvider();
     StorageProvider storageProvider=cloudFactory.getStorageProvider();
     vmProvider.createVM();
     storageProvider.addStorage();
    }
}