package liquibase.database.core;

import liquibase.database.AbstractJdbcDatabase;
import liquibase.database.DatabaseConnection;
import liquibase.exception.DatabaseException;

public class VerticaDatabase extends AbstractJdbcDatabase {

  @Override
  protected String getDefaultDatabaseProductName() {
    return null;
  }

  /**
   * Is this AbstractDatabase subclass the correct one to use for the given connection.
   */
  @Override
  public boolean isCorrectDatabaseImplementation(DatabaseConnection conn) throws DatabaseException {
    String pro = conn.getDatabaseProductName();
    return "Vertica Database".equalsIgnoreCase(pro);
  }

  /**
   * If this database understands the given url, return the default driver class name.  Otherwise
   * return null.
   */
  @Override
  public String getDefaultDriver(String url) {
    if (url.startsWith("jdbc:jdbcdslog:vertica") || url.startsWith("jdbc:vertica")) {
      return "com.vertica.jdbc.Driver";
    }
    return null;
  }

  /**
   * Returns an all-lower-case short name of the product.  Used for end-user selecting of database
   * type such as the DBMS precondition.
   */
  @Override
  public String getShortName() {
    return "vertica";
  }

  @Override
  public Integer getDefaultPort() {
    return 5433;
  }

  /**
   * Returns whether this database support initially deferrable columns.
   */
  @Override
  public boolean supportsInitiallyDeferrableColumns() {
    return true;
  }

  @Override
  public boolean supportsSchemas() {
    return true;
  }

  @Override
  public boolean supportsCatalogs() {
    return false;
  }

  @Override
  public boolean supportsTablespaces() {
    return false;
  }

  @Override
  public boolean supportsSequences() {
    return false; // true;
  }

  @Override
  public int getPriority() {
    return PRIORITY_DEFAULT;
  }
}
