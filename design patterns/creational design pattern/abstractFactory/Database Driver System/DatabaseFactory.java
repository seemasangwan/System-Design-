public interface DatabaseFactory {
     DatabaseConnection getDatabaseConnection();
     DatabaseQueryExecutor getDatabaseQueryExecutor();
}
