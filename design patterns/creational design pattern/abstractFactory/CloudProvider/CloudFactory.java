public interface CloudFactory {
    StorageProvider getStorageProvider();
    VMProvider getVMProvider();
}
