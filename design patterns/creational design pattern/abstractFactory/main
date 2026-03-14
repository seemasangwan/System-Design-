public class Main {
    public static void main(String[] args) {
    DatabaseFactoryProvider factoryProvider=new DatabaseFactoryProvider();
    DatabaseFactory databaseFactory=factoryProvider.getDatabaseFactory("mongo");
    DatabaseConnection databaseConnection=databaseFactory.getDatabaseConnection();
    DatabaseQueryExecutor queryExecutor= databaseFactory.getDatabaseQueryExecutor();
    databaseConnection.createConnection();
    queryExecutor.executeQuery();
    }
}
